package com.android.mmt.transaction;

import android.telephony.PhoneStateListener;

/* loaded from: classes.dex */
final class m extends PhoneStateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TransactionService f4645a;

    m(TransactionService transactionService) {
        this.f4645a = transactionService;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i2, String str) {
        synchronized (this.f4645a.f4553C) {
            this.f4645a.b0();
        }
        TransactionService transactionService = this.f4645a;
        transactionService.Y(transactionService.f4555E);
    }
}
