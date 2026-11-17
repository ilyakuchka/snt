package Y0;

import W0.d;
import c1.n;

/* loaded from: classes.dex */
final class B implements d.a<Object> {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ n.a f1897i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ C f1898j;

    B(C c2, n.a aVar) {
        this.f1898j = c2;
        this.f1897i = aVar;
    }

    @Override // W0.d.a
    public final void e(Exception exc) {
        if (this.f1898j.b(this.f1897i)) {
            this.f1898j.f(this.f1897i, exc);
        }
    }

    @Override // W0.d.a
    public final void f(Object obj) {
        if (this.f1898j.b(this.f1897i)) {
            this.f1898j.c(this.f1897i, obj);
        }
    }
}
