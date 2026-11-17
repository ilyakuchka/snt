package com.android.mmt.transaction;

import android.net.Uri;
import com.android.mmt.MmsApp;
import com.android.mmt.transaction.d;

/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Uri f4625i;

    e(Uri uri) {
        this.f4625i = uri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.b bVarJ = d.j(MmsApp.c(), this.f4625i);
        if (bVarJ != null) {
            d.k(MmsApp.c(), bVarJ.f4611a, 3000L, bVarJ.f4612b);
        }
    }
}
