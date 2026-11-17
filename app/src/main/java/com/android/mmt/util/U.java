package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import com.android.mmt.util.b0;

/* loaded from: classes.dex */
final class U implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f5923i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ b0.a f5924j;

    U(Context context, b0.a aVar) {
        this.f5923i = context;
        this.f5924j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0.c(this.f5923i, new Intent("android.intent.action.VIEW", this.f5924j.f5941a));
    }
}
