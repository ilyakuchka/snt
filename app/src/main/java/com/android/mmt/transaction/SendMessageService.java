package com.android.mmt.transaction;

import O0.s;
import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.O;
import java.util.ArrayList;
import java.util.Iterator;
import x0.C0416c;

/* loaded from: classes.dex */
public class SendMessageService extends IntentService {

    /* renamed from: i, reason: collision with root package name */
    private static Uri f4512i = Uri.parse("content://sms/sent");

    /* renamed from: j, reason: collision with root package name */
    private static Uri f4513j = Uri.parse("content://mms/sent");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f4514k = 0;

    public SendMessageService() {
        super("SendMessageService");
    }

    @Override // android.app.IntentService
    protected final void onHandleIntent(Intent intent) {
        int i2;
        ContentValues contentValues;
        CharSequence charSequence;
        String action = intent.getAction();
        if ("com.android.mmt.transaction.SEND_SMS_BACKGROUND".equals(action)) {
            String stringExtra = intent.getStringExtra("extra_address");
            String stringExtra2 = intent.getStringExtra("extra_text");
            intent.getBooleanExtra("extra_send_by_mx", false);
            int iT = C0287t.t(intent);
            C0416c.v(C0287t.h(this, stringExtra)).T();
            long jH = C0287t.h(this, stringExtra);
            try {
                new s(this, new String[]{stringExtra}, stringExtra2, jH, 0L, iT).a();
                return;
            } catch (Exception e2) {
                W2.a.c("SendMessageService", "Failed to send SMS message, threadId=" + jH, e2);
                return;
            }
        }
        if ("com.android.sms.transaction.RESEND_SMS_BACKGROUND".equals(action)) {
            ContentValues contentValues2 = new ContentValues();
            int iT2 = C0287t.t(intent);
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("extra_sms_msg_ids");
            StringBuilder sbD = D2.e.d("_id IN (");
            sbD.append(TextUtils.join(",", stringArrayListExtra));
            sbD.append(")");
            String string = sbD.toString();
            if (stringArrayListExtra.size() <= 0) {
                W2.a.f("SendMessageService", "smsWhere == NULL");
                return;
            }
            contentValues2.put("date", Long.valueOf(jCurrentTimeMillis));
            contentValues2.put("timed", (Integer) 0);
            contentValues2.put("type", (Integer) 6);
            W2.a.f("SendMessageService", "smsWhere == " + string);
            if (O.g(this, getContentResolver(), f4512i, contentValues2, string, null) > 0) {
                C0287t.I(this, iT2);
                return;
            }
            return;
        }
        if ("com.android.mmt.transaction.RESEND_MMS_BACKGROUND".equals(action)) {
            ContentValues contentValues3 = new ContentValues();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("extra_mms_msg_ids");
            StringBuilder sbD2 = D2.e.d("_id IN (");
            sbD2.append(TextUtils.join(",", stringArrayListExtra2));
            sbD2.append(")");
            String string2 = sbD2.toString();
            if (stringArrayListExtra2.size() <= 0) {
                W2.a.f("SendMessageService", "mmsWhere == NULL");
                return;
            }
            contentValues3.put("date_full", Long.valueOf(jCurrentTimeMillis2));
            contentValues3.put("timed", (Integer) 0);
            contentValues3.put("msg_box", (Integer) 4);
            if (O.g(this, getContentResolver(), f4513j, contentValues3, string2, null) > 0) {
                startService(new Intent(this, (Class<?>) TransactionService.class));
                return;
            }
            return;
        }
        if ("com.android.mmt.transaction.MARK_FAIL_BACKGROUND".equals(action)) {
            ContentValues contentValues4 = new ContentValues();
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            ArrayList<String> stringArrayListExtra3 = intent.getStringArrayListExtra("extra_mms_msg_ids");
            StringBuilder sbD3 = D2.e.d("_id IN (");
            sbD3.append(TextUtils.join(",", stringArrayListExtra3));
            sbD3.append(")");
            String string3 = sbD3.toString();
            StringBuilder sbD4 = D2.e.d("msg_id IN (");
            sbD4.append(TextUtils.join(",", stringArrayListExtra3));
            sbD4.append(")");
            String string4 = sbD4.toString();
            if (stringArrayListExtra3.size() > 0) {
                contentValues4.put("date_full", Long.valueOf(jCurrentTimeMillis3));
                contentValues4.put("timed", (Integer) 0);
                contentValues4.put("msg_box", (Integer) 4);
                charSequence = ",";
                O.g(this, getContentResolver(), f4513j, contentValues4, string3, null);
                contentValues4.clear();
                contentValues4.put("err_type", (Integer) 10);
                contentValues = contentValues4;
                O.g(this, getContentResolver(), Telephony.MmsSms.PendingMessages.CONTENT_URI, contentValues4, string4, null);
            } else {
                contentValues = contentValues4;
                charSequence = ",";
                W2.a.f("SendMessageService", "mark fail == NULL");
            }
            ArrayList<String> stringArrayListExtra4 = intent.getStringArrayListExtra("extra_sms_msg_ids");
            StringBuilder sbD5 = D2.e.d("_id IN (");
            sbD5.append(TextUtils.join(charSequence, stringArrayListExtra4));
            sbD5.append(")");
            String string5 = sbD5.toString();
            if (stringArrayListExtra4.size() > 0) {
                W2.a.f("SendMessageService", "mark sms fail");
                contentValues.clear();
                contentValues.put("date", Long.valueOf(jCurrentTimeMillis3));
                contentValues.put("timed", (Integer) 0);
                contentValues.put("type", (Integer) 5);
                O.g(this, getContentResolver(), f4512i, contentValues, string5, null);
                return;
            }
            return;
        }
        if ("com.android.mmt.transaction.ACTION_MARK_READ_BACKGROUND".equals(action)) {
            long longExtra = intent.getLongExtra("extra_thread_id", 0L);
            String stringExtra3 = intent.getStringExtra("extra_address");
            if (longExtra <= 0) {
                longExtra = C0287t.h(this, stringExtra3);
            }
            C0416c.v(longExtra).T();
            return;
        }
        if ("com.android.mmt.transaction.ACTION_DELETE_BACKGROUND".equals(action)) {
            O.c(this, getContentResolver(), Uri.parse(intent.getStringExtra("extra_uri")), null, null);
            return;
        }
        if ("com.android.mmt.transaction.ACTION_SEND_TIMED_MESSAGE".equals(action)) {
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Cursor cursorE = O.e(this, getContentResolver(), f4512i, new String[]{"_id", "sub_id"}, "timed > 0 AND date <= " + jCurrentTimeMillis4, null, null);
            if (cursorE != null) {
                StringBuilder sbD6 = D2.e.d("get timed sms: ");
                sbD6.append(cursorE.getCount());
                W2.a.d(sbD6.toString());
                while (cursorE.moveToNext()) {
                    try {
                        arrayList.add(Long.valueOf(cursorE.getLong(0)));
                        arrayList2.add(Long.valueOf(cursorE.getLong(1)));
                    } finally {
                    }
                }
            }
            ContentValues contentValues5 = new ContentValues(3);
            contentValues5.put("timed", (Integer) 0);
            contentValues5.put("type", (Integer) 6);
            Iterator it = arrayList.iterator();
            int i4 = 0;
            int iG = 0;
            while (it.hasNext()) {
                Long l2 = (Long) it.next();
                contentValues5.put("date", Long.valueOf(i4 + jCurrentTimeMillis4));
                iG += O.g(this, getContentResolver(), f4512i, contentValues5, "_id=" + l2, null);
                i4++;
            }
            int i5 = i4;
            if (iG > 0) {
                C0287t.I(this, C0287t.p(arrayList2));
            }
            arrayList2.clear();
            arrayList.clear();
            cursorE = O.e(this, getContentResolver(), f4513j, new String[]{"_id"}, "timed > 0 AND date*1000+date_ms_part <= " + jCurrentTimeMillis4, null, null);
            if (cursorE != null) {
                StringBuilder sbD7 = D2.e.d("get time mms: ");
                sbD7.append(cursorE.getCount());
                W2.a.d(sbD7.toString());
                while (cursorE.moveToNext()) {
                    try {
                        arrayList.add(Long.valueOf(cursorE.getLong(0)));
                    } finally {
                    }
                }
                i2 = 0;
            } else {
                i2 = 0;
            }
            contentValues5.clear();
            contentValues5.put("timed", (Integer) 0);
            contentValues5.put("msg_box", (Integer) 4);
            Iterator it2 = arrayList.iterator();
            int iG2 = i2;
            int i6 = i5;
            while (it2.hasNext()) {
                Long l3 = (Long) it2.next();
                contentValues5.put("date_full", Long.valueOf(i6 + jCurrentTimeMillis4));
                iG2 += O.g(this, getContentResolver(), f4513j, contentValues5, "_id=" + l3, null);
                i6++;
            }
            if (iG2 > 0) {
                startService(new Intent(this, (Class<?>) TransactionService.class));
            }
            if (iG > 0 || iG2 > 0) {
                TimedMessageReceiver.a(this);
            }
        }
    }
}
