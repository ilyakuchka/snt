package com.android.mmt.transaction;

import android.widget.Toast;
import com.android.mmt.MmsApp;

/* loaded from: classes.dex */
final class g implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ CharSequence f4630i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ long f4631j;

    g(CharSequence charSequence, long j2) {
        this.f4630i = charSequence;
        this.f4631j = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(MmsApp.c(), this.f4630i, (int) this.f4631j).show();
    }
}
