package com.android.mmt.transaction;

import android.widget.Toast;
import com.android.mmt.R;

/* loaded from: classes.dex */
final class i implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ SmsReceiverService f4634i;

    i(SmsReceiverService smsReceiverService) {
        this.f4634i = smsReceiverService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SmsReceiverService smsReceiverService = this.f4634i;
        Toast.makeText(smsReceiverService, smsReceiverService.getString(R.string.fdn_check_failure), 0).show();
    }
}
