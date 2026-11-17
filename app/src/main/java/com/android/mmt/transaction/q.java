package com.android.mmt.transaction;

import android.widget.Toast;
import com.android.mmt.R;

/* loaded from: classes.dex */
final class q implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f4649i = false;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ int f4650j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ TransactionService f4651k;

    q(TransactionService transactionService, int i2) {
        this.f4651k = transactionService;
        this.f4650j = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4649i) {
            Toast.makeText(this.f4651k, R.string.storage_unavailable, 1).show();
            return;
        }
        int i2 = this.f4650j;
        if (i2 == 1) {
            Toast.makeText(this.f4651k, R.string.download_later, 1).show();
        } else {
            if (i2 != 2) {
                return;
            }
            Toast.makeText(this.f4651k, R.string.message_queued, 1).show();
        }
    }
}
