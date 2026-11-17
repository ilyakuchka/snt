package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import com.android.mmt.util.b0;
import x0.C0414a;

/* loaded from: classes.dex */
final class Q implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0414a f5915i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ String f5916j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ b0.a f5917k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ Context f5918l;

    Q(C0414a c0414a, String str, b0.a aVar, Context context) {
        this.f5915i = c0414a;
        this.f5916j = str;
        this.f5917k = aVar;
        this.f5918l = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent intent = new Intent("android.intent.action.EDIT", this.f5915i.f0());
        intent.putExtra(this.f5916j, this.f5917k.f5943c);
        b0.c(this.f5918l, intent);
    }
}
