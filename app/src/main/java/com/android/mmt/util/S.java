package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import com.android.mmt.util.b0;

/* loaded from: classes.dex */
final class S implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f5919i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ b0.a f5920j;

    S(Context context, b0.a aVar) {
        this.f5919i = context;
        this.f5920j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0.c(this.f5919i, new Intent("android.intent.action.CALL", this.f5920j.f5941a));
    }
}
