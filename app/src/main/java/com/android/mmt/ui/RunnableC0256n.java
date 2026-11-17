package com.android.mmt.ui;

import android.util.Log;
import com.android.mmt.ui.ClassZeroActivity;

/* renamed from: com.android.mmt.ui.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0256n implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ClassZeroActivity.d f5675i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ ClassZeroActivity f5676j;

    RunnableC0256n(ClassZeroActivity classZeroActivity, ClassZeroActivity.d dVar) {
        this.f5676j = classZeroActivity;
        this.f5675i = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (this.f5675i == null) {
            Log.w("Class0", "saveMessage item is null");
            return;
        }
        Log.d("Class0", "saveMessage");
        long jR = this.f5675i.f4707a.isReplace() ? ClassZeroActivity.R(this.f5676j, this.f5675i) : this.f5676j.X(this.f5675i);
        if (this.f5675i.f4709c) {
            return;
        }
        com.android.mmt.transaction.d.o(jR);
    }
}
