package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import n.C0352a;
import o.C0357a;
import o.C0358b;

/* loaded from: classes.dex */
public final class l extends g {

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference<k> f3696c;

    /* renamed from: a, reason: collision with root package name */
    private C0357a<j, a> f3694a = new C0357a<>();
    private int d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3697e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3698f = false;
    private ArrayList<g.c> g = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private g.c f3695b = g.c.INITIALIZED;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f3699h = true;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        g.c f3700a;

        /* renamed from: b, reason: collision with root package name */
        i f3701b;

        a(j jVar, g.c cVar) {
            this.f3701b = n.d(jVar);
            this.f3700a = cVar;
        }

        final void a(k kVar, g.b bVar) {
            g.c cVarD = bVar.d();
            this.f3700a = l.h(this.f3700a, cVarD);
            this.f3701b.g(kVar, bVar);
            this.f3700a = cVarD;
        }
    }

    public l(k kVar) {
        this.f3696c = new WeakReference<>(kVar);
    }

    private g.c d(j jVar) {
        Map.Entry<j, a> entryP = this.f3694a.p(jVar);
        g.c cVar = null;
        g.c cVar2 = entryP != null ? entryP.getValue().f3700a : null;
        if (!this.g.isEmpty()) {
            cVar = this.g.get(r0.size() - 1);
        }
        return h(h(this.f3695b, cVar2), cVar);
    }

    @SuppressLint({"RestrictedApi"})
    private void e(String str) {
        if (this.f3699h && !C0352a.k().m()) {
            throw new IllegalStateException(C2.c.a("Method ", str, " must be called on the main thread"));
        }
    }

    static g.c h(g.c cVar, g.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    private void i(g.c cVar) {
        if (this.f3695b == cVar) {
            return;
        }
        this.f3695b = cVar;
        if (this.f3697e || this.d != 0) {
            this.f3698f = true;
            return;
        }
        this.f3697e = true;
        m();
        this.f3697e = false;
    }

    private void j() {
        this.g.remove(r1.size() - 1);
    }

    private void k(g.c cVar) {
        this.g.add(cVar);
    }

    private void m() {
        k kVar = this.f3696c.get();
        if (kVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean z4 = true;
            if (this.f3694a.size() != 0) {
                g.c cVar = this.f3694a.g().getValue().f3700a;
                g.c cVar2 = this.f3694a.k().getValue().f3700a;
                if (cVar != cVar2 || this.f3695b != cVar2) {
                    z4 = false;
                }
            }
            if (z4) {
                this.f3698f = false;
                return;
            }
            this.f3698f = false;
            if (this.f3695b.compareTo(this.f3694a.g().getValue().f3700a) < 0) {
                Iterator<Map.Entry<j, a>> itD = this.f3694a.d();
                while (itD.hasNext() && !this.f3698f) {
                    Map.Entry<j, a> next = itD.next();
                    a value = next.getValue();
                    while (value.f3700a.compareTo(this.f3695b) > 0 && !this.f3698f && this.f3694a.contains(next.getKey())) {
                        int iOrdinal = value.f3700a.ordinal();
                        g.b bVar = iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? null : g.b.ON_PAUSE : g.b.ON_STOP : g.b.ON_DESTROY;
                        if (bVar == null) {
                            StringBuilder sbD = D2.e.d("no event down from ");
                            sbD.append(value.f3700a);
                            throw new IllegalStateException(sbD.toString());
                        }
                        k(bVar.d());
                        value.a(kVar, bVar);
                        j();
                    }
                }
            }
            Map.Entry<j, a> entryK = this.f3694a.k();
            if (!this.f3698f && entryK != null && this.f3695b.compareTo(entryK.getValue().f3700a) > 0) {
                C0358b<j, a>.d dVarI = this.f3694a.i();
                while (dVarI.hasNext() && !this.f3698f) {
                    Map.Entry next2 = dVarI.next();
                    a aVar = (a) next2.getValue();
                    while (aVar.f3700a.compareTo(this.f3695b) < 0 && !this.f3698f && this.f3694a.contains((j) next2.getKey())) {
                        k(aVar.f3700a);
                        g.b bVarE = g.b.e(aVar.f3700a);
                        if (bVarE == null) {
                            StringBuilder sbD2 = D2.e.d("no event up from ");
                            sbD2.append(aVar.f3700a);
                            throw new IllegalStateException(sbD2.toString());
                        }
                        aVar.a(kVar, bVarE);
                        j();
                    }
                }
            }
        }
    }

    @Override // androidx.lifecycle.g
    public final void a(j jVar) {
        k kVar;
        e("addObserver");
        g.c cVar = this.f3695b;
        g.c cVar2 = g.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = g.c.INITIALIZED;
        }
        a aVar = new a(jVar, cVar2);
        if (this.f3694a.n(jVar, aVar) == null && (kVar = this.f3696c.get()) != null) {
            boolean z4 = this.d != 0 || this.f3697e;
            g.c cVarD = d(jVar);
            this.d++;
            while (aVar.f3700a.compareTo(cVarD) < 0 && this.f3694a.contains(jVar)) {
                k(aVar.f3700a);
                g.b bVarE = g.b.e(aVar.f3700a);
                if (bVarE == null) {
                    StringBuilder sbD = D2.e.d("no event up from ");
                    sbD.append(aVar.f3700a);
                    throw new IllegalStateException(sbD.toString());
                }
                aVar.a(kVar, bVarE);
                j();
                cVarD = d(jVar);
            }
            if (!z4) {
                m();
            }
            this.d--;
        }
    }

    @Override // androidx.lifecycle.g
    public final g.c b() {
        return this.f3695b;
    }

    @Override // androidx.lifecycle.g
    public final void c(j jVar) {
        e("removeObserver");
        this.f3694a.o(jVar);
    }

    public final void f(g.b bVar) {
        e("handleLifecycleEvent");
        i(bVar.d());
    }

    @Deprecated
    public final void g() {
        e("markState");
        l();
    }

    public final void l() {
        g.c cVar = g.c.CREATED;
        e("setCurrentState");
        i(cVar);
    }
}
