package com.android.mmt.transaction;

import O0.t;
import P0.r;
import a.C0178a;
import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import c.C0227a;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import com.android.mmt.storage.bugle.BugleDatabase;
import com.android.mmt.ui.ClassZeroActivity;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.L;
import com.android.mmt.util.O;
import f0.C0303b;
import java.util.GregorianCalendar;
import java.util.Objects;
import t.C0384b;
import t0.C0385a;
import x0.C0414a;

/* loaded from: classes.dex */
public class SmsReceiverService extends Service {

    /* renamed from: o, reason: collision with root package name */
    private static final String[] f4518o = {"_id", "thread_id", "address", "body", "status", "sub_id"};
    private static final String[] p = {"_id", "address", "protocol", "sub_id", "thread_id"};

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f4519q = 0;

    /* renamed from: i, reason: collision with root package name */
    private f f4520i;

    /* renamed from: j, reason: collision with root package name */
    private Looper f4521j;

    /* renamed from: k, reason: collision with root package name */
    private boolean[] f4522k;

    /* renamed from: m, reason: collision with root package name */
    private int f4524m;

    /* renamed from: l, reason: collision with root package name */
    public Handler f4523l = new Handler();

    /* renamed from: n, reason: collision with root package name */
    private Runnable f4525n = new a();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.d("SmsReceiverService", "send queued message without toast");
            C0287t.K(SmsReceiverService.this, 0);
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(SmsReceiverService.this, R.string.toast_pending_hangup_msg, 0).show();
        }
    }

    final class c implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f4528i;

        c(int i2) {
            this.f4528i = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            O0.f.j().q(this.f4528i);
        }
    }

    final class d implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f4529i;

        d(int i2) {
            this.f4529i = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            O0.f.j().r(this.f4529i);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public Uri f4530a;

        /* renamed from: b, reason: collision with root package name */
        public long f4531b;

        /* renamed from: c, reason: collision with root package name */
        public long f4532c;

        public e(Uri uri, long j2) {
            this.f4530a = uri;
            this.f4531b = j2;
        }
    }

    private final class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) throws NumberFormatException {
            int i2 = message.arg1;
            Intent intent = (Intent) message.obj;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra("errorCode", 0);
                Log.i("SmsReceiverService", "handleMessage action: " + action + " error: " + intExtra);
                if ("com.android.mmt.transaction.MESSAGE_SENT".equals(intent.getAction())) {
                    SmsReceiverService.a(SmsReceiverService.this, intent, intExtra);
                } else if ("android.provider.Telephony.SMS_DELIVER".equals(action)) {
                    SmsReceiverService.b(SmsReceiverService.this, intent, intExtra);
                } else if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
                    SmsReceiverService smsReceiverService = SmsReceiverService.this;
                    int i4 = SmsReceiverService.f4519q;
                    Objects.requireNonNull(smsReceiverService);
                    Q2.c.a(new k(smsReceiverService));
                } else if ("android.intent.action.SERVICE_STATE".equals(action)) {
                    SmsReceiverService.c(SmsReceiverService.this, intent);
                } else if ("com.android.mmt.transaction.SEND_MESSAGE".equals(action)) {
                    SmsReceiverService.d(SmsReceiverService.this, intent);
                }
            }
            SmsReceiverService smsReceiverService2 = SmsReceiverService.this;
            synchronized (SmsReceiver.f4515a) {
                if (SmsReceiver.f4516b != null && smsReceiverService2.stopSelfResult(i2)) {
                    SmsReceiver.f4516b.release();
                }
            }
        }
    }

    static void a(SmsReceiverService smsReceiverService, Intent intent, int i2) {
        Objects.requireNonNull(smsReceiverService);
        Uri data = intent.getData();
        boolean z4 = false;
        boolean booleanExtra = intent.getBooleanExtra("SendNextMsg", false);
        int iT = C0287t.t(intent);
        if (C0287t.A(iT)) {
            smsReceiverService.f4522k[iT] = false;
        }
        Log.d("SmsReceiverService", "message sent, uri: " + data + ", result: " + smsReceiverService.f4524m);
        try {
            Log.v("SmsReceiverService", "handleSmsSent resultCode = " + String.valueOf(smsReceiverService.f4524m));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i4 = smsReceiverService.f4524m;
        if (i4 == -1) {
            if (Log.isLoggable("Mms:transaction", 2)) {
                Log.v("SmsReceiverService", "handleSmsSent move message to sent folder uri: " + data);
            }
            if (data != null) {
                ContentValues contentValues = new ContentValues(3);
                contentValues.put("type", (Integer) 2);
                contentValues.put("read", (Integer) 1);
                contentValues.put("error_code", Integer.valueOf(i2));
                if (1 == O.g(smsReceiverService, smsReceiverService.getContentResolver(), data, contentValues, "type!=5", null)) {
                    z4 = true;
                }
            }
            if (!z4) {
                Log.e("SmsReceiverService", "handleSmsSent: failed to move message " + data + " to sent folder");
            }
            if (booleanExtra && C0287t.A(iT)) {
                smsReceiverService.k(true, iT);
            }
            com.android.mmt.transaction.d.E();
            return;
        }
        if (i4 != 2 && i4 != 4) {
            if (i4 == 6) {
                smsReceiverService.f4523l.post(new i(smsReceiverService));
                return;
            }
            if (i4 == 133404 && i2 == 0) {
                if (Log.isLoggable("Mms:transaction", 2)) {
                    Log.v("SmsReceiverService", "HTC phone mResultCode == RESULT_ERROR_HTC_TEMP_FAILURE && error == 0");
                    return;
                }
                return;
            } else {
                smsReceiverService.h(data, i2, iT);
                if (booleanExtra && C0287t.A(iT)) {
                    smsReceiverService.k(true, iT);
                    return;
                }
                return;
            }
        }
        Log.v("SmsReceiverService", "handleSmsSent: no service, queuing message w/ uri: " + data + " slotId is " + iT);
        smsReceiverService.i(iT);
        C0227a.d(smsReceiverService, data, 6, i2);
        if (intent.getBooleanExtra("show_toast_when_offline", true)) {
            smsReceiverService.f4523l.post(new j(smsReceiverService, iT));
        }
        if (Settings.Secure.getInt(smsReceiverService.getContentResolver(), "sim_lock_enable", 0) != 0) {
            int simState = ((TelephonyManager) smsReceiverService.getSystemService("phone")).getSimState(iT);
            if (simState == 2 || simState == 3) {
                Intent intent2 = new Intent("android.miui.intent.action.SIM_LOCKED");
                intent2.setPackage("com.miui.securitycenter");
                intent2.putExtra("slot_id", iT);
                smsReceiverService.sendBroadcast(intent2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void b(SmsReceiverService smsReceiverService, Intent intent, int i2) throws NumberFormatException {
        int i4;
        SmsMessage smsMessage;
        int i5;
        Uri uri;
        int i6;
        boolean z4;
        Cursor cursorE;
        e eVar;
        long j2;
        String string;
        long j4;
        C0414a c0414aN;
        long j5;
        long j6;
        Objects.requireNonNull(smsReceiverService);
        SmsMessage[] messagesFromIntent = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        String stringExtra = intent.getStringExtra("format");
        int intExtra = intent.getIntExtra("blockType", 0);
        String stringExtra2 = intent.getStringExtra("msg_uri");
        int iT = C0287t.t(intent);
        Context applicationContext = smsReceiverService.getApplicationContext();
        StringBuilder sbD = D2.e.d("pref_key_sim_out_of_service");
        sbD.append(C0287t.m(iT));
        String string2 = sbD.toString();
        SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("pref_mx", 0).edit();
        editorEdit.putLong(string2, 0L);
        editorEdit.apply();
        SmsMessage smsMessage2 = messagesFromIntent[0];
        if (smsMessage2 == null || C0178a.m(smsMessage2)) {
            Log.e("SmsReceiverService", "handleSmsReceived: sms == null or sms.mWrappedSmsMessage == null");
            return;
        }
        e eVarL = null;
        if (TextUtils.isEmpty(stringExtra2)) {
            i4 = intExtra;
            smsMessage = smsMessage2;
            eVarL = null;
        } else {
            Uri uri2 = Uri.parse(stringExtra2);
            if (uri2 == null) {
                Log.v("SmsReceiverService", "updateMessage parse uri is null");
                i4 = intExtra;
                smsMessage = smsMessage2;
            } else {
                cursorE = O.e(smsReceiverService, smsReceiverService.getContentResolver(), uri2, new String[]{"thread_id", "address", "body", "_id", "sub_id", "date"}, null, null, null);
                if (cursorE != null) {
                    try {
                        if (cursorE.moveToFirst()) {
                            j2 = cursorE.getLong(0);
                            string = cursorE.getString(1);
                            cursorE.getString(2);
                            cursorE.getLong(3);
                            cursorE.getInt(4);
                            j4 = cursorE.getLong(5);
                        } else {
                            j2 = 0;
                            string = null;
                            j4 = 0;
                        }
                    } finally {
                    }
                } else {
                    j2 = 0;
                    string = null;
                    j4 = 0;
                }
                long j7 = j2;
                long j8 = j4;
                if (j7 <= 0) {
                    Log.v("SmsReceiverService", "updateMessage threadId <= 0");
                    i4 = intExtra;
                    smsMessage = smsMessage2;
                    eVarL = null;
                } else {
                    ContentValues contentValues = new ContentValues();
                    if (TextUtils.isEmpty(string)) {
                        contentValues.put("address", smsReceiverService.getString(R.string.unknown_sender));
                        c0414aN = null;
                    } else {
                        c0414aN = C0414a.N(string);
                    }
                    if (c0414aN != null) {
                        c0414aN.m0(true, true);
                        synchronized (c0414aN) {
                        }
                    }
                    if (contentValues.size() > 0) {
                        i4 = intExtra;
                        j5 = j8;
                        smsMessage = smsMessage2;
                        j6 = j7;
                        if (O.g(smsReceiverService, smsReceiverService.getContentResolver(), uri2, contentValues, null, null) <= 0) {
                            Log.v("SmsReceiverService", "update count is less than 0");
                            eVarL = null;
                        }
                    } else {
                        i4 = intExtra;
                        smsMessage = smsMessage2;
                        j5 = j8;
                        j6 = j7;
                        Log.v("SmsReceiverService", "nothing to do for update message");
                    }
                    L.e().b(smsReceiverService, j6);
                    eVarL = new e(uri2, j6);
                    eVarL.f4532c = j5;
                }
            }
        }
        if (eVarL == null) {
            SmsMessage smsMessage3 = messagesFromIntent[0];
            if (smsMessage3.getMessageClass() == SmsMessage.MessageClass.CLASS_0 || smsMessage3.getMessageClass() == SmsMessage.MessageClass.CLASS_2) {
                i6 = 3;
                z4 = false;
                int i7 = i6;
                if (z4) {
                    Log.w("SmsReceiverService", "duplicated sms ignored");
                } else {
                    SmsMessage smsMessage4 = messagesFromIntent[0];
                    if (smsMessage4.getDisplayMessageBody() != null) {
                        if (smsMessage4.getMessageClass() == SmsMessage.MessageClass.CLASS_0) {
                            Intent intentPutExtra = new Intent(smsReceiverService, (Class<?>) ClassZeroActivity.class).putExtra("pdu", smsMessage4.getPdu()).putExtra("format", stringExtra);
                            intentPutExtra.setFlags(402653184);
                            long jM = C0287t.m(iT);
                            if (jM < 0) {
                                Log.e("SmsReceiverService", "displayClassZeroMessage simId < 0 when slotId is " + iT);
                            }
                            intentPutExtra.putExtra("sim_id", jM);
                            if (intentPutExtra.resolveActivity(smsReceiverService.getPackageManager()) != null) {
                                smsReceiverService.startActivity(intentPutExtra);
                            }
                        } else if (smsMessage4.isReplace()) {
                            SmsMessage smsMessage5 = messagesFromIntent[0];
                            ContentResolver contentResolver = smsReceiverService.getContentResolver();
                            String originatingAddress = smsMessage5.getOriginatingAddress();
                            int protocolIdentifier = smsMessage5.getProtocolIdentifier();
                            long jM2 = C0287t.m(iT);
                            if (jM2 < 0) {
                                Log.e("SmsReceiverService", "replaceMessage simId < 0 when slotId is " + iT);
                            }
                            String[] strArr = new String[i7];
                            strArr[0] = originatingAddress;
                            strArr[1] = Integer.toString(protocolIdentifier);
                            strArr[2] = Long.toString(jM2);
                            cursorE = O.e(smsReceiverService, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, p, "address = ? AND protocol = ? AND sub_id = ?", strArr, null);
                            if (cursorE != null) {
                                try {
                                    if (cursorE.moveToFirst()) {
                                        Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, cursorE.getLong(0));
                                        long j9 = cursorE.getLong(4);
                                        ContentValues contentValuesF = smsReceiverService.f(smsMessage5);
                                        contentValuesF.put("error_code", Integer.valueOf(i2));
                                        contentValuesF.put("body", j(smsReceiverService.e(messagesFromIntent)));
                                        i5 = iT;
                                        Log.v("SmsReceiverService", "replaceMessage update count is " + O.g(smsReceiverService, contentResolver, uriWithAppendedId, contentValuesF, null, null));
                                        eVar = new e(uriWithAppendedId, j9);
                                        eVarL = eVar;
                                    } else {
                                        i5 = iT;
                                    }
                                } finally {
                                }
                            } else {
                                i5 = iT;
                            }
                            eVar = smsReceiverService.l(smsReceiverService, messagesFromIntent, i2, i5, i4);
                            eVarL = eVar;
                        } else {
                            i5 = iT;
                            eVarL = smsReceiverService.l(smsReceiverService, messagesFromIntent, i2, i5, i4);
                        }
                    }
                }
                eVarL = null;
                i5 = iT;
            } else {
                String originatingAddress2 = smsMessage3.getOriginatingAddress();
                if (!TextUtils.isEmpty(originatingAddress2)) {
                    long timestampMillis = smsMessage3.getTimestampMillis();
                    if (timestampMillis > 0) {
                        String strE = smsReceiverService.e(messagesFromIntent);
                        if (!TextUtils.isEmpty(strE)) {
                            i6 = 3;
                            cursorE = O.e(smsReceiverService, smsReceiverService.getContentResolver(), Telephony.Sms.Inbox.CONTENT_URI, new String[]{"_id", "address"}, "address=? AND date_sent=" + timestampMillis + " AND body=?", new String[]{originatingAddress2, strE}, null);
                            if (cursorE != null) {
                                try {
                                    if (cursorE.moveToFirst()) {
                                        long j10 = cursorE.getLong(0);
                                        cursorE.getString(1);
                                        Log.w("SmsReceiverService", "receive duplicated message from , msg id=" + j10);
                                        cursorE.close();
                                        z4 = true;
                                        int i72 = i6;
                                        if (z4) {
                                        }
                                        eVarL = null;
                                        i5 = iT;
                                    }
                                } finally {
                                }
                            }
                        }
                        z4 = false;
                        int i722 = i6;
                        if (z4) {
                        }
                        eVarL = null;
                        i5 = iT;
                    }
                }
            }
        } else {
            i5 = iT;
        }
        String originatingAddress3 = smsMessage.getOriginatingAddress();
        String strJ = j(smsReceiverService.e(messagesFromIntent));
        C0414a.O(originatingAddress3);
        if (eVarL == null || (uri = eVarL.f4530a) == null) {
            return;
        }
        int i8 = r.f937c;
        MmsApp.c();
        if (r.m(uri) != 0) {
            return;
        }
        Log.i("SmsReceiverService", "handleSmsReceived   will  notification");
        String lastPathSegment = eVarL.f4530a.getLastPathSegment();
        Long.parseLong(lastPathSegment);
        long j11 = Long.parseLong(lastPathSegment);
        long j12 = eVarL.f4531b;
        long j13 = eVarL.f4532c;
        if (j11 >= 0) {
            Log.d("NewMessageInjector", "onMessageReceive: 0 | true | " + j11);
            L0.a aVar = new L0.a();
            aVar.z(j12);
            aVar.s(j13);
            aVar.C(strJ);
            BugleDatabase.y().x().F(aVar, true, 1);
        }
        Log.i("SmsReceiverService", "handleSmsReceived: notify new message");
        if (BugleDatabase.y().x().u(eVarL.f4531b) != null) {
            return;
        }
        com.android.mmt.transaction.d.p(eVarL.f4531b);
        D0.b.f80a = true;
        Uri uri3 = eVarL.f4530a;
        ContentResolver contentResolver2 = smsReceiverService.getContentResolver();
        boolean z5 = false;
        contentResolver2.notifyChange(uri3, (ContentObserver) null, false);
        contentResolver2.notifyChange(Telephony.MmsSms.CONTENT_URI, (ContentObserver) null, false);
        contentResolver2.notifyChange(Telephony.MmsSms.CONTENT_CONVERSATIONS_URI, (ContentObserver) null, false);
        contentResolver2.notifyChange(C0385a.b.f7897c, (ContentObserver) null, false);
        contentResolver2.notifyChange(C0385a.b.f7895a, (ContentObserver) null, false);
        int i9 = C0385a.f7893a;
        if ((i4 & 127) < 1) {
            String strE2 = smsReceiverService.e(messagesFromIntent);
            int i10 = Settings.System.getInt(smsReceiverService.getContentResolver(), "voiceassist_report_method", 2);
            int i11 = Settings.System.getInt(smsReceiverService.getContentResolver(), "voiceassist_sms_report", 0);
            AudioManager audioManager = (AudioManager) smsReceiverService.getSystemService("audio");
            if (audioManager.getRingerMode() != 0 && audioManager.getRingerMode() != 1 && i10 != 2 && i11 == 1 && (i10 != 0 || audioManager.isWiredHeadsetOn() || audioManager.isBluetoothScoOn())) {
                z5 = true;
            }
            if (z5) {
                C0414a c0414aO = C0414a.O(originatingAddress3);
                c0414aO.m0(true, true);
                char c2 = '0';
                if (c0414aO.b0() != null && !c0414aO.b0().trim().equals("")) {
                    c2 = '1';
                }
                Intent intent2 = new Intent(smsReceiverService, (Class<?>) SmsReportService.class);
                Bundle bundle = new Bundle();
                bundle.putString("sms_address", originatingAddress3);
                bundle.putString("sms_body", strE2);
                bundle.putString("sms_name", c0414aO.U());
                bundle.putChar("sms_contact", c2);
                bundle.putInt("slot_id", i5);
                intent2.putExtras(bundle);
                smsReceiverService.startService(intent2);
            }
        }
    }

    static void c(SmsReceiverService smsReceiverService, Intent intent) {
        Objects.requireNonNull(smsReceiverService);
        if (C0178a.n(intent.getExtras()).getState() == 0) {
            Log.d("SmsReceiverService", "service is in service");
            smsReceiverService.m();
            smsReceiverService.f4523l.removeCallbacks(smsReceiverService.f4525n);
            smsReceiverService.f4523l.postDelayed(smsReceiverService.f4525n, 10000L);
        }
    }

    static void d(SmsReceiverService smsReceiverService, Intent intent) {
        Objects.requireNonNull(smsReceiverService);
        int iT = C0287t.t(intent);
        boolean booleanExtra = intent.getBooleanExtra("show_toast_when_offline", true);
        if (!C0287t.A(iT)) {
            Log.v("SmsReceiverService", "handleSendMessage slot id is not valid");
        } else {
            if (smsReceiverService.f4522k[iT]) {
                return;
            }
            smsReceiverService.k(booleanExtra, iT);
        }
    }

    private String e(SmsMessage[] smsMessageArr) {
        if (smsMessageArr.length == 1) {
            return smsMessageArr[0].getDisplayMessageBody();
        }
        StringBuilder sb = new StringBuilder();
        for (SmsMessage smsMessage : smsMessageArr) {
            if (!C0178a.m(smsMessage)) {
                sb.append(smsMessage.getDisplayMessageBody());
            }
        }
        return sb.toString();
    }

    private ContentValues f(SmsMessage smsMessage) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", smsMessage.getDisplayOriginatingAddress());
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2011, 8, 18);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        long jCurrentTimeMillis = System.currentTimeMillis();
        gregorianCalendar2.setTimeInMillis(jCurrentTimeMillis);
        if (gregorianCalendar2.before(gregorianCalendar)) {
            jCurrentTimeMillis = smsMessage.getTimestampMillis();
        }
        contentValues.put("date", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("date_sent", Long.valueOf(smsMessage.getTimestampMillis()));
        contentValues.put("protocol", Integer.valueOf(smsMessage.getProtocolIdentifier()));
        contentValues.put("read", (Integer) 0);
        contentValues.put("seen", (Integer) 0);
        if (smsMessage.getPseudoSubject().length() > 0) {
            contentValues.put("subject", smsMessage.getPseudoSubject());
        }
        contentValues.put("reply_path_present", Integer.valueOf(smsMessage.isReplyPathPresent() ? 1 : 0));
        contentValues.put("service_center", smsMessage.getServiceCenterAddress());
        return contentValues;
    }

    private String g(boolean z4, int i2) {
        String str;
        long jM = C0287t.m(i2);
        String str2 = "address is not null AND address!=''";
        if (jM >= 0) {
            if (!C0287t.x() || !C0287t.y()) {
                return "address is not null AND address!=''";
            }
            if (i2 == 1) {
                return "address is not null AND address!='' AND sub_id=" + jM;
            }
            return "address is not null AND address!='' AND sub_id!=" + C0287t.m(1);
        }
        if (C0287t.D(i2)) {
            C0287t.I(this, i2);
            Log.v("SmsReceiverService", "sim info is not ready, retry");
        } else {
            int i4 = C0287t.f6041f;
            if (C0287t.x()) {
                if (i2 == 0) {
                    if (C0287t.D(1)) {
                        str = "address is not null AND address!='' AND sub_id!=" + C0287t.m(1);
                        str2 = str;
                    }
                } else if (i2 == 1 && C0287t.D(0)) {
                    str = "address is not null AND address!='' AND sub_id!=" + C0287t.m(0);
                    str2 = str;
                }
                Log.v("SmsReceiverService", "sim is not inserted, and not register");
                return str2;
            }
            i(i2);
            if (z4) {
                this.f4523l.post(new j(this, i2));
            }
            Log.v("SmsReceiverService", "sim is not inserted, but register");
        }
        return null;
    }

    private void h(Uri uri, int i2, int i4) {
        Log.v("SmsReceiverService", "messageFailedToSend msg failed uri: " + uri + " error: " + i2);
        C0227a.d(this, uri, 5, i2);
        com.android.mmt.transaction.d.A(i4);
        D0.b.b(0, Long.valueOf(uri.getLastPathSegment()).longValue());
    }

    private void i(int i2) {
        if (C0287t.x()) {
            int i4 = C0287t.f6041f;
            this.f4523l.post(new d(i2));
            Log.v("SmsReceiverService", "register for service state");
        } else {
            Context applicationContext = getApplicationContext();
            m();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SERVICE_STATE");
            Log.v("SmsReceiverService", "register for service state");
            C0384b.t(applicationContext, SmsReceiver.a(), intentFilter);
        }
    }

    public static String j(String str) {
        return str.replace('\f', '\n');
    }

    private synchronized void k(boolean z4, int i2) {
        Uri uri = Uri.parse("content://sms/queued");
        ContentResolver contentResolver = getContentResolver();
        String strG = g(z4, i2);
        if (strG == null) {
            Log.v("SmsReceiverService", "queued message with invalid selection");
            return;
        }
        long jM = C0287t.m(i2);
        Cursor cursorE = O.e(this, contentResolver, uri, f4518o, strG, null, "status DESC, date ASC");
        if (cursorE != null) {
            try {
                if (cursorE.moveToFirst()) {
                    String string = cursorE.getString(cursorE.getColumnIndexOrThrow("body"));
                    String string2 = cursorE.getString(cursorE.getColumnIndexOrThrow("address"));
                    long j2 = cursorE.getLong(cursorE.getColumnIndexOrThrow("thread_id"));
                    int i4 = cursorE.getInt(cursorE.getColumnIndexOrThrow("status"));
                    long j4 = cursorE.getInt(cursorE.getColumnIndexOrThrow("_id"));
                    long j5 = cursorE.getLong(cursorE.getColumnIndexOrThrow("sub_id"));
                    Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, j4);
                    if (jM < 0) {
                        this.f4522k[i2] = false;
                        h(uriWithAppendedId, 1, i2);
                        Log.e("SmsReceiverService", "mark failed to send for not find simId with slotId = " + i2);
                        return;
                    }
                    n(j4, j5, jM);
                    if (!C0287t.B(i2)) {
                        Log.w("SmsReceiverService", "Sms is unable to send: " + uriWithAppendedId + ", " + i2 + " pending it");
                        C0287t.I(this, i2 == 0 ? 1 : 0);
                        this.f4523l.post(new b());
                        int i5 = i2 == 0 ? 1 : 0;
                        int i6 = C0287t.f6041f;
                        this.f4523l.post(new c(i5));
                        return;
                    }
                    Log.w("SmsReceiverService", "start to send msg as normal sms: " + uriWithAppendedId);
                    try {
                        new t(this, string2, string, j2, i4 == 32, uriWithAppendedId, i2, z4).a();
                        this.f4522k[i2] = true;
                    } catch (C0303b e2) {
                        Log.e("SmsReceiverService", "sendFirstQueuedMessage: failed to send message " + uriWithAppendedId + ", caught ", e2);
                        this.f4522k[i2] = false;
                        h(uriWithAppendedId, 1, i2);
                    }
                }
                cursorE.close();
            } finally {
                cursorE.close();
            }
        }
    }

    private e l(Context context, SmsMessage[] smsMessageArr, int i2, int i4, int i5) {
        String string;
        ContentValues contentValuesF = f(smsMessageArr[0]);
        contentValuesF.put("error_code", Integer.valueOf(i2));
        contentValuesF.put("body", j(e(smsMessageArr)));
        Long asLong = contentValuesF.getAsLong("thread_id");
        String asString = contentValuesF.getAsString("address");
        if (TextUtils.isEmpty(asString)) {
            string = getString(R.string.unknown_sender);
            contentValuesF.put("address", string);
        } else {
            string = C0414a.N(asString).W();
        }
        long jM = C0287t.m(i4);
        if (jM < 0) {
            Log.e("SmsReceiverService", "storeMessage simId < 0 when slotId is " + i4);
        }
        contentValuesF.put("sub_id", Long.valueOf(jM));
        if ((asLong == null || asLong.longValue() == 0) && string != null) {
            asLong = Long.valueOf(C0287t.h(context, string));
            contentValuesF.put("thread_id", asLong);
        }
        int i6 = C0385a.f7893a;
        int i7 = i5 & 127;
        boolean z4 = (i5 & 128) == 128;
        if (i7 == 8) {
            contentValuesF.put("url_risky_type", (Integer) 3);
        } else if (z4) {
            contentValuesF.put("url_risky_type", (Integer) 1);
        }
        contentValuesF.put("read", (Integer) 0);
        int i8 = r.f937c;
        Uri uriD = O.d(context, context.getContentResolver(), Telephony.Sms.Inbox.CONTENT_URI, contentValuesF);
        L.e().b(context, asLong.longValue());
        e eVar = new e(uriD, asLong.longValue());
        eVar.f4532c = contentValuesF.getAsLong("date").longValue();
        return eVar;
    }

    private void m() {
        Log.v("SmsReceiverService", "un register for service state");
        try {
            getApplicationContext().unregisterReceiver(SmsReceiver.a());
        } catch (IllegalArgumentException unused) {
            Log.e("SmsReceiverService", "allow un-matched register-unregister calls");
        }
    }

    private void n(long j2, long j4, long j5) {
        if (!C0287t.x() || j4 == j5) {
            return;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("sub_id", Long.valueOf(j5));
        O.g(this, getContentResolver(), Telephony.Sms.CONTENT_URI, contentValues, "_id=" + j2, null);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        startForeground(114, new v.g(getBaseContext(), O0.d.g().f(2, -1)).b());
        HandlerThread handlerThread = new HandlerThread("SmsReceiverService", 10);
        handlerThread.start();
        this.f4521j = handlerThread.getLooper();
        this.f4520i = new f(this.f4521j);
        int iG = C0287t.g();
        this.f4522k = new boolean[iG];
        for (int i2 = 0; i2 < iG; i2++) {
            this.f4522k[i2] = false;
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f4521j.quit();
        stopForeground(true);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i4) {
        String str;
        int intExtra = intent != null ? intent.getIntExtra("result", 0) : 0;
        this.f4524m = intExtra;
        if (intExtra != 0) {
            StringBuilder sbC = C2.c.c("onStart: #", i4, " mResultCode: ");
            sbC.append(this.f4524m);
            sbC.append(" = ");
            switch (this.f4524m) {
                case -1:
                    str = "Activity.RESULT_OK";
                    break;
                case 0:
                default:
                    str = "Unknown error code";
                    break;
                case 1:
                    str = "SmsManager.RESULT_ERROR_GENERIC_FAILURE";
                    break;
                case 2:
                    str = "SmsManager.RESULT_ERROR_RADIO_OFF";
                    break;
                case 3:
                    str = "SmsManager.RESULT_ERROR_NULL_PDU";
                    break;
                case 4:
                    str = "SmsManager.RESULT_ERROR_NO_SERVICE";
                    break;
                case 5:
                    str = "SmsManager.RESULT_ERROR_LIMIT_EXCEEDED";
                    break;
                case 6:
                    str = "SmsManager.RESULT_ERROR_FDN_CHECK_FAILURE";
                    break;
            }
            sbC.append(str);
            Log.v("SmsReceiverService", sbC.toString());
        }
        Message messageObtainMessage = this.f4520i.obtainMessage();
        messageObtainMessage.arg1 = i4;
        messageObtainMessage.obj = intent;
        this.f4520i.sendMessage(messageObtainMessage);
        return 2;
    }
}
