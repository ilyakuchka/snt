package com.android.mmt.transaction;

import android.content.Context;
import com.android.mmt.transaction.d;
import com.android.mmt.util.d0;
import java.util.Objects;

/* loaded from: classes.dex */
final class h implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f4632i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ d.c f4633j;

    h(d.c cVar, Context context) {
        this.f4633j = cVar;
        this.f4632i = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Objects.requireNonNull(this.f4633j);
        d0.a();
        d0.b(this.f4632i);
    }
}
