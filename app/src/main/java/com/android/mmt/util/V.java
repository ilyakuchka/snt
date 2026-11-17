package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import com.android.mmt.util.b0;

/* loaded from: classes.dex */
final class V implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f5925i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ b0.a f5926j;

    V(Context context, b0.a aVar) {
        this.f5925i = context;
        this.f5926j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0.c(this.f5925i, new Intent("android.intent.action.VIEW", this.f5926j.f5941a));
    }
}
