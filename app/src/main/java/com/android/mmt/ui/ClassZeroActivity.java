package com.android.mmt.ui;

import a.C0178a;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;
import java.util.ArrayList;
import java.util.Objects;
import miuix.appcompat.app.g;

/* loaded from: classes.dex */
public class ClassZeroActivity extends miuix.appcompat.app.h {

    /* renamed from: B, reason: collision with root package name */
    private static final String[] f4697B = {"_id", "address", "protocol", "sub_id", "thread_id"};

    /* renamed from: w, reason: collision with root package name */
    private d f4700w;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<d> f4699v = null;

    /* renamed from: x, reason: collision with root package name */
    private miuix.appcompat.app.g f4701x = null;

    /* renamed from: y, reason: collision with root package name */
    private Handler f4702y = new a();

    /* renamed from: z, reason: collision with root package name */
    private final DialogInterface.OnClickListener f4703z = new b();

    /* renamed from: A, reason: collision with root package name */
    private final DialogInterface.OnClickListener f4698A = new c();

    final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            if (ClassZeroActivity.this.f4700w != null) {
                ClassZeroActivity.this.f4700w.f4709c = false;
                ClassZeroActivity classZeroActivity = ClassZeroActivity.this;
                d dVar = classZeroActivity.f4700w;
                Objects.requireNonNull(classZeroActivity);
                Q2.c.a(new RunnableC0256n(classZeroActivity, dVar));
            } else {
                Log.d("Class0", "auto save message item is null");
            }
            ClassZeroActivity.this.f4701x.dismiss();
            ClassZeroActivity.Q(ClassZeroActivity.this);
        }
    }

    final class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            ClassZeroActivity.Q(ClassZeroActivity.this);
        }
    }

    final class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (ClassZeroActivity.this.f4700w != null) {
                ClassZeroActivity.this.f4700w.f4709c = true;
                ClassZeroActivity classZeroActivity = ClassZeroActivity.this;
                Q2.c.a(new RunnableC0256n(classZeroActivity, classZeroActivity.f4700w));
            }
            dialogInterface.dismiss();
            ClassZeroActivity.Q(ClassZeroActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        public SmsMessage f4707a;

        /* renamed from: b, reason: collision with root package name */
        public long f4708b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4709c;

        public d(SmsMessage smsMessage, long j2) {
            this.f4707a = smsMessage;
            this.f4708b = j2;
        }
    }

    static void Q(ClassZeroActivity classZeroActivity) {
        if (classZeroActivity.f4699v.isEmpty()) {
            classZeroActivity.finish();
            return;
        }
        classZeroActivity.f4699v.remove(0);
        if (classZeroActivity.f4699v.isEmpty()) {
            classZeroActivity.finish();
            return;
        }
        d dVar = classZeroActivity.f4699v.get(0);
        classZeroActivity.f4700w = dVar;
        classZeroActivity.U(dVar);
        classZeroActivity.f4702y.sendMessageDelayed(classZeroActivity.f4702y.obtainMessage(1), 300000L);
    }

    static long R(ClassZeroActivity classZeroActivity, d dVar) {
        long j2;
        long j4;
        Objects.requireNonNull(classZeroActivity);
        SmsMessage smsMessage = dVar.f4707a;
        ContentValues contentValuesV = classZeroActivity.V(smsMessage, dVar.f4709c);
        contentValuesV.put("body", classZeroActivity.T(smsMessage));
        ContentResolver contentResolver = classZeroActivity.getContentResolver();
        Cursor cursorE = com.android.mmt.util.O.e(classZeroActivity, contentResolver, Telephony.Sms.Inbox.CONTENT_URI, f4697B, "address =? AND protocol =? AND sub_id =?", new String[]{smsMessage.getOriginatingAddress(), Integer.toString(smsMessage.getProtocolIdentifier()), Long.toString(dVar.f4708b)}, null);
        if (cursorE != null) {
            try {
                if (cursorE.moveToFirst()) {
                    j2 = cursorE.getLong(0);
                    j4 = cursorE.getLong(4);
                } else {
                    j2 = -1;
                    j4 = -1;
                }
            } finally {
                cursorE.close();
            }
        } else {
            j2 = -1;
            j4 = -1;
        }
        if (j4 == -1) {
            return classZeroActivity.X(dVar);
        }
        com.android.mmt.util.O.g(classZeroActivity, contentResolver, ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, j2), contentValuesV, null, null);
        return j4;
    }

    private String T(SmsMessage smsMessage) {
        StringBuilder sb = new StringBuilder();
        if (smsMessage != null && !C0178a.m(smsMessage)) {
            sb.append(smsMessage.getDisplayMessageBody());
        }
        return sb.toString();
    }

    private void U(d dVar) {
        if (dVar == null) {
            Log.d("Class0", "displayZeroMessage item is null");
            return;
        }
        String strT = T(dVar.f4707a);
        g.a aVar = new g.a(this, R.style.MmsTheme_Dialog);
        aVar.k(strT);
        aVar.x(R.string.class_0_message_activity);
        aVar.t(R.string.save, this.f4698A);
        aVar.m(android.R.string.cancel, this.f4703z);
        miuix.appcompat.app.g gVarA = aVar.a();
        this.f4701x = gVarA;
        gVarA.setCancelable(false);
        this.f4701x.setCanceledOnTouchOutside(false);
        this.f4701x.show();
        Log.d("Class0", "displayZeroMessage displayed");
    }

    private ContentValues V(SmsMessage smsMessage, boolean z4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", smsMessage.getDisplayOriginatingAddress());
        contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("protocol", Integer.valueOf(smsMessage.getProtocolIdentifier()));
        contentValues.put("read", Integer.valueOf(z4 ? 1 : 0));
        contentValues.put("seen", Integer.valueOf(z4 ? 1 : 0));
        if (smsMessage.getPseudoSubject().length() > 0) {
            contentValues.put("subject", smsMessage.getPseudoSubject());
        }
        contentValues.put("reply_path_present", Integer.valueOf(smsMessage.isReplyPathPresent() ? 1 : 0));
        contentValues.put("service_center", smsMessage.getServiceCenterAddress());
        return contentValues;
    }

    private boolean W(Intent intent) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("pdu");
        String stringExtra = intent.getStringExtra("format");
        int i2 = C0287t.f6041f;
        long longExtra = intent.getLongExtra("sim_id", 0L);
        if (longExtra < 0) {
            Log.e("MSimUtils", "getSimIdFromIntent simId < DEFAULT_SIM_ID");
        }
        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu(byteArrayExtra, stringExtra);
        if (!TextUtils.isEmpty(T(smsMessageCreateFromPdu)) && longExtra >= 0) {
            this.f4699v.add(new d(smsMessageCreateFromPdu, longExtra));
            return true;
        }
        if (this.f4699v.isEmpty()) {
            finish();
        }
        Log.d("Class0", "queueMsgFromIntent queue nothing");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long X(d dVar) {
        SmsMessage smsMessage = dVar.f4707a;
        ContentValues contentValuesV = V(smsMessage, dVar.f4709c);
        contentValuesV.put("body", T(smsMessage));
        contentValuesV.put("sub_id", Long.valueOf(dVar.f4708b));
        long jH = C0287t.h(this, contentValuesV.getAsString("address"));
        contentValuesV.put("thread_id", Long.valueOf(jH));
        com.android.mmt.util.O.d(this, getContentResolver(), Telephony.Sms.Inbox.CONTENT_URI, contentValuesV);
        return jH;
    }

    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public final void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().addFlags(2621440);
        super.onCreate(bundle);
        if (this.f4699v == null) {
            this.f4699v = new ArrayList<>();
        }
        this.f4699v.clear();
        if (getIntent() != null) {
            W(getIntent());
            if (this.f4699v.size() == 1) {
                d dVar = this.f4699v.get(0);
                this.f4700w = dVar;
                U(dVar);
                this.f4702y.sendMessageDelayed(this.f4702y.obtainMessage(1), 300000L);
            }
        }
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    public final void onDestroy() {
        ArrayList<d> arrayList = this.f4699v;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f4702y.removeMessages(1);
        miuix.appcompat.app.g gVar = this.f4701x;
        if (gVar != null) {
            gVar.dismiss();
        }
        Log.d("Class0", "onDestroy");
        super.onDestroy();
    }

    @Override // androidx.fragment.app.ActivityC0219o, android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        W(intent);
    }
}
