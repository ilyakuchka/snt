package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
final class J implements androidx.savedstate.b, androidx.lifecycle.x {

    /* renamed from: i, reason: collision with root package name */
    private final androidx.lifecycle.w f3475i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.lifecycle.l f3476j = null;

    /* renamed from: k, reason: collision with root package name */
    private androidx.savedstate.a f3477k = null;

    J(androidx.lifecycle.w wVar) {
        this.f3475i = wVar;
    }

    @Override // androidx.lifecycle.k
    public final androidx.lifecycle.g a() {
        d();
        return this.f3476j;
    }

    final void b(g.b bVar) {
        this.f3476j.f(bVar);
    }

    final void d() {
        if (this.f3476j == null) {
            this.f3476j = new androidx.lifecycle.l(this);
            this.f3477k = androidx.savedstate.a.a(this);
        }
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry e() {
        d();
        return this.f3477k.b();
    }

    final boolean f() {
        return this.f3476j != null;
    }

    final void g(Bundle bundle) {
        this.f3477k.c(bundle);
    }

    final void h(Bundle bundle) {
        this.f3477k.d(bundle);
    }

    final void i() {
        this.f3476j.l();
    }

    @Override // androidx.lifecycle.x
    public final androidx.lifecycle.w q() {
        d();
        return this.f3475i;
    }
}
