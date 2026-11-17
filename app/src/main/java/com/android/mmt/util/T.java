package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.android.mmt.util.b0;

/* loaded from: classes.dex */
final class T implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f5921i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ b0.a f5922j;

    T(Context context, b0.a aVar) {
        this.f5921i = context;
        this.f5922j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f5921i;
        StringBuilder sbD = D2.e.d("smsto:");
        sbD.append(this.f5922j.f5943c);
        b0.c(context, new Intent("android.intent.action.SENDTO", Uri.parse(sbD.toString())));
    }
}
