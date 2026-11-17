package com.android.mmt.transaction;

import com.android.mmt.util.C0287t;

/* loaded from: classes.dex */
final class p implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ TransactionService f4648i;

    p(TransactionService transactionService) {
        this.f4648i = transactionService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4648i.f4571w = false;
        Y1.a.k("requestRetryConnectForStarted end", new Object[0]);
        if (this.f4648i.f4560j < (C0287t.x() ? 10 : 18)) {
            TransactionService.F(this.f4648i);
        } else {
            long j2 = this.f4648i.f4570v.p;
            TransactionService transactionService = this.f4648i;
            TransactionService.I(transactionService, transactionService.f4570v);
            this.f4648i.f4559i = 0;
            this.f4648i.f4560j = 0;
            this.f4648i.f4570v = null;
            this.f4648i.O(false);
            TransactionService transactionService2 = this.f4648i;
            transactionService2.f4568s = TransactionService.K(transactionService2, j2);
            Y1.a.k("requestRetryConnectForStarted before sim id = " + j2 + " and after sim id = " + this.f4648i.f4568s, new Object[0]);
        }
        this.f4648i.N();
    }
}
