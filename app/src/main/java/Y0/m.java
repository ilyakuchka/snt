package Y0;

import Y0.C0177c;
import Y0.j;
import Y0.r;
import a1.a;
import a1.i;
import android.os.SystemClock;
import android.util.Log;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import t1.a;

/* loaded from: classes.dex */
public final class m implements o, i.a, r.a {

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f1984h = Log.isLoggable("Engine", 2);

    /* renamed from: a, reason: collision with root package name */
    private final u f1985a;

    /* renamed from: b, reason: collision with root package name */
    private final q f1986b;

    /* renamed from: c, reason: collision with root package name */
    private final a1.i f1987c;
    private final b d;

    /* renamed from: e, reason: collision with root package name */
    private final A f1988e;

    /* renamed from: f, reason: collision with root package name */
    private final a f1989f;
    private final C0177c g;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        final j.d f1990a;

        /* renamed from: b, reason: collision with root package name */
        final E.b<j<?>> f1991b = t1.a.a(150, new C0049a());

        /* renamed from: c, reason: collision with root package name */
        private int f1992c;

        /* renamed from: Y0.m$a$a, reason: collision with other inner class name */
        final class C0049a implements a.b<j<?>> {
            C0049a() {
            }

            @Override // t1.a.b
            public final j<?> a() {
                a aVar = a.this;
                return new j<>(aVar.f1990a, aVar.f1991b);
            }
        }

        a(j.d dVar) {
            this.f1990a = dVar;
        }

        final <R> j<R> a(com.bumptech.glide.e eVar, Object obj, p pVar, V0.f fVar, int i2, int i4, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, l lVar, Map<Class<?>, V0.l<?>> map, boolean z4, boolean z5, boolean z6, V0.h hVar, j.a<R> aVar) {
            j<R> jVar = (j) this.f1991b.b();
            Objects.requireNonNull(jVar, "Argument must not be null");
            int i5 = this.f1992c;
            this.f1992c = i5 + 1;
            jVar.n(eVar, obj, pVar, fVar, i2, i4, cls, cls2, fVar2, lVar, map, z4, z5, z6, hVar, aVar, i5);
            return jVar;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final b1.a f1994a;

        /* renamed from: b, reason: collision with root package name */
        final b1.a f1995b;

        /* renamed from: c, reason: collision with root package name */
        final b1.a f1996c;
        final b1.a d;

        /* renamed from: e, reason: collision with root package name */
        final o f1997e;

        /* renamed from: f, reason: collision with root package name */
        final r.a f1998f;
        final E.b<n<?>> g = t1.a.a(150, new a());

        final class a implements a.b<n<?>> {
            a() {
            }

            @Override // t1.a.b
            public final n<?> a() {
                b bVar = b.this;
                return new n<>(bVar.f1994a, bVar.f1995b, bVar.f1996c, bVar.d, bVar.f1997e, bVar.f1998f, bVar.g);
            }
        }

        b(b1.a aVar, b1.a aVar2, b1.a aVar3, b1.a aVar4, o oVar, r.a aVar5) {
            this.f1994a = aVar;
            this.f1995b = aVar2;
            this.f1996c = aVar3;
            this.d = aVar4;
            this.f1997e = oVar;
            this.f1998f = aVar5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements j.d {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0052a f2000a;

        /* renamed from: b, reason: collision with root package name */
        private volatile a1.a f2001b;

        c(a.InterfaceC0052a interfaceC0052a) {
            this.f2000a = interfaceC0052a;
        }

        public final a1.a a() {
            if (this.f2001b == null) {
                synchronized (this) {
                    if (this.f2001b == null) {
                        this.f2001b = ((a1.d) this.f2000a).a();
                    }
                    if (this.f2001b == null) {
                        this.f2001b = new a1.b();
                    }
                }
            }
            return this.f2001b;
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        private final n<?> f2002a;

        /* renamed from: b, reason: collision with root package name */
        private final o1.f f2003b;

        d(o1.f fVar, n<?> nVar) {
            this.f2003b = fVar;
            this.f2002a = nVar;
        }

        public final void a() {
            synchronized (m.this) {
                this.f2002a.k(this.f2003b);
            }
        }
    }

    public m(a1.i iVar, a.InterfaceC0052a interfaceC0052a, b1.a aVar, b1.a aVar2, b1.a aVar3, b1.a aVar4) {
        this.f1987c = iVar;
        c cVar = new c(interfaceC0052a);
        C0177c c0177c = new C0177c();
        this.g = c0177c;
        c0177c.d(this);
        this.f1986b = new q();
        this.f1985a = new u();
        this.d = new b(aVar, aVar2, aVar3, aVar4, this, this);
        this.f1989f = new a(cVar);
        this.f1988e = new A();
        ((a1.h) iVar).i(this);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap, java.util.Map<V0.f, Y0.c$a>] */
    private r<?> c(p pVar, boolean z4, long j2) {
        r<?> rVar;
        if (!z4) {
            return null;
        }
        C0177c c0177c = this.g;
        synchronized (c0177c) {
            C0177c.a aVar = (C0177c.a) c0177c.f1909b.get(pVar);
            if (aVar == null) {
                rVar = null;
            } else {
                rVar = aVar.get();
                if (rVar == null) {
                    c0177c.c(aVar);
                }
            }
        }
        if (rVar != null) {
            rVar.a();
        }
        if (rVar != null) {
            if (f1984h) {
                d("Loaded resource from active resources", j2, pVar);
            }
            return rVar;
        }
        x<?> xVarG = ((a1.h) this.f1987c).g(pVar);
        r<?> rVar2 = xVarG == null ? null : xVarG instanceof r ? (r) xVarG : new r<>(xVarG, true, true, pVar, this);
        if (rVar2 != null) {
            rVar2.a();
            this.g.a(pVar, rVar2);
        }
        if (rVar2 == null) {
            return null;
        }
        if (f1984h) {
            d("Loaded resource from cache", j2, pVar);
        }
        return rVar2;
    }

    private static void d(String str, long j2, V0.f fVar) {
        Log.v("Engine", str + " in " + s1.f.a(j2) + "ms, key: " + fVar);
    }

    private <R> d i(com.bumptech.glide.e eVar, Object obj, V0.f fVar, int i2, int i4, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, l lVar, Map<Class<?>, V0.l<?>> map, boolean z4, boolean z5, V0.h hVar, boolean z6, boolean z7, boolean z8, boolean z9, o1.f fVar3, Executor executor, p pVar, long j2) {
        n<?> nVarA = this.f1985a.a(pVar, z9);
        if (nVarA != null) {
            nVarA.a(fVar3, executor);
            if (f1984h) {
                d("Added to existing load", j2, pVar);
            }
            return new d(fVar3, nVarA);
        }
        n<?> nVarB = this.d.g.b();
        Objects.requireNonNull(nVarB, "Argument must not be null");
        nVarB.d(pVar, z6, z7, z8, z9);
        j<?> jVarA = this.f1989f.a(eVar, obj, pVar, fVar, i2, i4, cls, cls2, fVar2, lVar, map, z4, z5, z9, hVar, nVarB);
        this.f1985a.c(pVar, nVarB);
        nVarB.a(fVar3, executor);
        nVarB.m(jVarA);
        if (f1984h) {
            d("Started new load", j2, pVar);
        }
        return new d(fVar3, nVarB);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap, java.util.Map<V0.f, Y0.c$a>] */
    @Override // Y0.r.a
    public final void a(V0.f fVar, r<?> rVar) {
        C0177c c0177c = this.g;
        synchronized (c0177c) {
            C0177c.a aVar = (C0177c.a) c0177c.f1909b.remove(fVar);
            if (aVar != null) {
                aVar.f1913c = null;
                aVar.clear();
            }
        }
        if (rVar.f()) {
            ((a1.h) this.f1987c).f(fVar, rVar);
        } else {
            this.f1988e.a(rVar, false);
        }
    }

    public final <R> d b(com.bumptech.glide.e eVar, Object obj, V0.f fVar, int i2, int i4, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, l lVar, Map<Class<?>, V0.l<?>> map, boolean z4, boolean z5, V0.h hVar, boolean z6, boolean z7, boolean z8, boolean z9, o1.f fVar3, Executor executor) {
        long jElapsedRealtimeNanos;
        if (f1984h) {
            int i5 = s1.f.f7857b;
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        } else {
            jElapsedRealtimeNanos = 0;
        }
        long j2 = jElapsedRealtimeNanos;
        Objects.requireNonNull(this.f1986b);
        p pVar = new p(obj, fVar, i2, i4, map, cls, cls2, hVar);
        synchronized (this) {
            r<?> rVarC = c(pVar, z6, j2);
            if (rVarC == null) {
                return i(eVar, obj, fVar, i2, i4, cls, cls2, fVar2, lVar, map, z4, z5, hVar, z6, z7, z8, z9, fVar3, executor, pVar, j2);
            }
            ((o1.g) fVar3).q(rVarC, V0.a.f1751m);
            return null;
        }
    }

    public final synchronized void e(n<?> nVar, V0.f fVar) {
        this.f1985a.d(fVar, nVar);
    }

    public final synchronized void f(n<?> nVar, V0.f fVar, r<?> rVar) {
        if (rVar != null) {
            if (rVar.f()) {
                this.g.a(fVar, rVar);
            }
            this.f1985a.d(fVar, nVar);
        } else {
            this.f1985a.d(fVar, nVar);
        }
    }

    public final void g(x<?> xVar) {
        this.f1988e.a(xVar, true);
    }

    public final void h(x<?> xVar) {
        if (!(xVar instanceof r)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((r) xVar).g();
    }
}
