package com.android.mmt.transaction;

/* loaded from: classes.dex */
final class o implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ TransactionService f4647i;

    o(TransactionService transactionService) {
        this.f4647i = transactionService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4647i.f4571w = false;
        Y1.a.k("requestRetryConnectForFailed end", new Object[0]);
        if (this.f4647i.f4559i < 3) {
            TransactionService.q(this.f4647i);
        } else {
            TransactionService transactionService = this.f4647i;
            transactionService.U(transactionService.f4568s, false, false, true);
            this.f4647i.f4559i = 0;
            this.f4647i.f4560j = 0;
            this.f4647i.f4570v = null;
        }
        this.f4647i.N();
    }
}
