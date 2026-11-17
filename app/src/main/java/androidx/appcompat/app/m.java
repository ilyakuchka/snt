package androidx.appcompat.app;

import androidx.core.view.t;
import t.C0384b;

/* loaded from: classes.dex */
final class m implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ j f2404i;

    final class a extends C0384b {
        a() {
        }

        @Override // androidx.core.view.u
        public final void a() {
            m.this.f2404i.f2373x.setAlpha(1.0f);
            m.this.f2404i.f2332A.f(null);
            m.this.f2404i.f2332A = null;
        }

        @Override // t.C0384b, androidx.core.view.u
        public final void c() {
            m.this.f2404i.f2373x.setVisibility(0);
        }
    }

    m(j jVar) {
        this.f2404i = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f2404i;
        jVar.f2374y.showAtLocation(jVar.f2373x, 55, 0, 0);
        this.f2404i.L();
        if (!this.f2404i.b0()) {
            this.f2404i.f2373x.setAlpha(1.0f);
            this.f2404i.f2373x.setVisibility(0);
            return;
        }
        this.f2404i.f2373x.setAlpha(0.0f);
        j jVar2 = this.f2404i;
        t tVarA = androidx.core.view.o.a(jVar2.f2373x);
        tVarA.a(1.0f);
        jVar2.f2332A = tVarA;
        this.f2404i.f2332A.f(new a());
    }
}
