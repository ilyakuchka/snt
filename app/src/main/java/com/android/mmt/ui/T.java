package com.android.mmt.ui;

/* loaded from: classes.dex */
final class T implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ x0.j f5455i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ P f5456j;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            T t2 = T.this;
            P p = t2.f5456j;
            x0.j jVar = t2.f5455i;
            p.f5241U = jVar;
            jVar.U(p.f5246Z);
            T.this.f5456j.u0();
            T.this.f5456j.t0();
            P p4 = T.this.f5456j;
            p4.M.j(p4.f5241U);
        }
    }

    T(P p, x0.j jVar) {
        this.f5456j = p;
        this.f5455i = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5455i.I(this.f5456j.f5246Z)) {
            this.f5456j.runOnUiThread(new a());
        }
    }
}
