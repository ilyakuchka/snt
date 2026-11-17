package com.android.mmt.transaction;

import android.text.TextUtils;
import android.widget.Toast;
import com.android.mmt.R;
import com.android.mmt.util.C0287t;

/* loaded from: classes.dex */
final class j implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f4635i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ SmsReceiverService f4636j;

    j(SmsReceiverService smsReceiverService, int i2) {
        this.f4636j = smsReceiverService;
        this.f4635i = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        String strC;
        SmsReceiverService smsReceiverService = this.f4636j;
        if (C0287t.y()) {
            int i2 = this.f4635i;
            if (i2 == 0) {
                strC = smsReceiverService.getString(R.string.sim_card1);
            } else if (i2 == 1) {
                strC = smsReceiverService.getString(R.string.sim_card2);
            }
        } else {
            strC = "";
        }
        if (!TextUtils.isEmpty(strC)) {
            strC = D2.e.c(strC, " ");
        }
        StringBuilder sbD = D2.e.d(strC);
        sbD.append(smsReceiverService.getString(R.string.message_queued));
        Toast.makeText(smsReceiverService, sbD.toString(), 0).show();
    }
}
