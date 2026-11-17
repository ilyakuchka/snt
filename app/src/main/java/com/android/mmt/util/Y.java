package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import com.android.mmt.util.b0;

/* loaded from: classes.dex */
final class Y implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f5932i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ b0.a f5933j;

    Y(Context context, b0.a aVar) {
        this.f5932i = context;
        this.f5933j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0.c(this.f5932i, new Intent("android.intent.action.VIEW", this.f5933j.f5945f.f0()));
    }
}
