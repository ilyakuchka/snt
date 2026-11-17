package com.android.mmt.transaction;

import android.telephony.PhoneStateListener;

/* loaded from: classes.dex */
final class n extends PhoneStateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TransactionService f4646a;

    n(TransactionService transactionService) {
        this.f4646a = transactionService;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i2, String str) {
        synchronized (this.f4646a.f4553C) {
            this.f4646a.b0();
        }
        TransactionService transactionService = this.f4646a;
        transactionService.Y(transactionService.f4556F);
    }
}
