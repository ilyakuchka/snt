package com.android.mmt.transaction;

import P0.r;
import a.C0178a;
import android.app.IntentService;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.MmsApp;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.O;
import miuix.appcompat.internal.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public class MessageStatusService extends IntentService {

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f4507j = {"_id"};

    /* renamed from: k, reason: collision with root package name */
    private static final Uri f4508k = Uri.parse("content://sms/status");

    /* renamed from: i, reason: collision with root package name */
    private int f4509i;

    public MessageStatusService() {
        super(MessageStatusService.class.getName());
        this.f4509i = 0;
        setIntentRedelivery(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onHandleIntent(Intent intent) {
        boolean z4;
        Cursor cursorE;
        Uri data = intent.getData();
        byte[] byteArrayExtra = intent.getByteArrayExtra("pdu");
        String stringExtra = intent.getStringExtra("format");
        int iT = C0287t.t(intent);
        W2.a.a("MessageStatusService", "sms delivered, uri: " + data);
        this.f4509i = 0;
        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu(byteArrayExtra, stringExtra);
        if (smsMessageCreateFromPdu == null) {
            smsMessageCreateFromPdu = null;
        } else {
            this.f4509i = smsMessageCreateFromPdu.getStatus() & MenuBuilder.USER_MASK;
            String strH = C0178a.h(smsMessageCreateFromPdu);
            int i2 = this.f4509i;
            if (TextUtils.isEmpty(strH)) {
                Log.v("MessageStatusService", "checkSpecialFailedStatus dest is empty");
            } else {
                String strI = C0178a.i(this, (int) C0287t.m(iT));
                if (TextUtils.isEmpty(strI)) {
                    Log.v("MessageStatusService", "checkSpecialFailedStatus plmn is empty for slotId " + iT);
                } else {
                    if (i2 == 67 && "46009".equalsIgnoreCase(strI) && ("10010".equals(strH) || "+8610010".equals(strH))) {
                        Log.v("MessageStatusService", "checkSpecialFailedStatus is right");
                        z4 = true;
                    }
                    if (z4) {
                        this.f4509i = 0;
                    }
                    cursorE = O.e(this, getContentResolver(), data, f4507j, null, null, null);
                    if (cursorE == null) {
                        try {
                            if (cursorE.moveToFirst()) {
                                Uri uriWithAppendedId = ContentUris.withAppendedId(f4508k, cursorE.getInt(0));
                                int i4 = this.f4509i;
                                boolean zIsStatusReportMessage = smsMessageCreateFromPdu.isStatusReportMessage();
                                ContentValues contentValues = new ContentValues();
                                if (Log.isLoggable("Mms", 3)) {
                                    Log.d("Mms", "[MessageStatusReceiver] " + ("updateMessageStatus: msgUrl=" + data + ", status=" + i4 + ", isStatusReport=" + zIsStatusReportMessage));
                                }
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                contentValues.put("status", Integer.valueOf(i4));
                                contentValues.put("date_sent", Long.valueOf(jCurrentTimeMillis));
                                if (i4 >= 64) {
                                    contentValues.put("type", (Integer) 5);
                                    contentValues.put("read", (Integer) 0);
                                    contentValues.put("error_code", (Integer) 0);
                                }
                                O.g(this, getContentResolver(), uriWithAppendedId, contentValues, null, null);
                            } else {
                                Log.e("Mms", "[MessageStatusReceiver] " + ("Can't find message for status update: " + data));
                            }
                        } finally {
                            cursorE.close();
                        }
                    }
                }
            }
            z4 = false;
            if (z4) {
            }
            cursorE = O.e(this, getContentResolver(), data, f4507j, null, null, null);
            if (cursorE == null) {
            }
        }
        if (smsMessageCreateFromPdu == null || !smsMessageCreateFromPdu.isStatusReportMessage()) {
            return;
        }
        int i5 = this.f4509i;
        if (i5 != 0) {
            if (i5 >= 64) {
                d.A(iT);
            }
        } else {
            Uri uri = d.f4609m;
            if ((r.g(androidx.preference.g.c(MmsApp.c())) & 16) == 16) {
                Q2.c.a(new e(data));
            }
        }
    }
}
