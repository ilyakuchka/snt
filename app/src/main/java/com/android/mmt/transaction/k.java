package com.android.mmt.transaction;

import android.content.ContentValues;
import android.provider.Telephony;
import android.util.Log;
import com.android.mmt.util.O;
import java.util.Objects;

/* loaded from: classes.dex */
final class k implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ SmsReceiverService f4637i;

    k(SmsReceiverService smsReceiverService) {
        this.f4637i = smsReceiverService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SmsReceiverService smsReceiverService = this.f4637i;
        int i2 = SmsReceiverService.f4519q;
        Objects.requireNonNull(smsReceiverService);
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("type", (Integer) 5);
        contentValues.put("error_code", (Integer) 1);
        contentValues.put("read", (Integer) 0);
        int iG = O.g(smsReceiverService.getApplicationContext(), smsReceiverService.getContentResolver(), Telephony.Sms.Outbox.CONTENT_URI, contentValues, "type = 4", null);
        if (Log.isLoggable("Mms:transaction", 2)) {
            Log.v("SmsReceiverService", "moveOutboxMessagesToFailedBox messageCount: " + iG);
        }
        if (iG > 0) {
            d.z();
        }
    }
}
