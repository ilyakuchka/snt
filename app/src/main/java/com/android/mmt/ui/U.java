package com.android.mmt.ui;

import android.net.Uri;
import com.android.mmt.R;

/* loaded from: classes.dex */
final class U implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f5489i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ Uri f5490j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ boolean f5491k = true;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ P f5492l;

    U(P p, int i2, Uri uri) {
        this.f5492l = p;
        this.f5489i = i2;
        this.f5490j = uri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Uri uri;
        x0.j jVar;
        this.f5492l.f5252f0.v(this.f5489i, R.string.type_attachment);
        if (this.f5492l.isDestroyed() || (uri = this.f5490j) == null || !this.f5491k || (jVar = this.f5492l.f5241U) == null) {
            return;
        }
        jVar.J(uri, false);
        P p = this.f5492l;
        p.M.j(p.f5241U);
        this.f5492l.u0();
        this.f5492l.t0();
        this.f5492l.f5252f0.D();
    }
}
