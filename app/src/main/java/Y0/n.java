package Y0;

import Y0.j;
import Y0.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import t.C0384b;
import t1.a;

/* loaded from: classes.dex */
final class n<R> implements j.a<R>, a.d {

    /* renamed from: G, reason: collision with root package name */
    private static final c f2005G = new c();

    /* renamed from: A, reason: collision with root package name */
    private boolean f2006A;

    /* renamed from: B, reason: collision with root package name */
    s f2007B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f2008C;

    /* renamed from: D, reason: collision with root package name */
    r<?> f2009D;

    /* renamed from: E, reason: collision with root package name */
    private j<R> f2010E;

    /* renamed from: F, reason: collision with root package name */
    private volatile boolean f2011F;

    /* renamed from: i, reason: collision with root package name */
    final e f2012i;

    /* renamed from: j, reason: collision with root package name */
    private final t1.d f2013j;

    /* renamed from: k, reason: collision with root package name */
    private final r.a f2014k;

    /* renamed from: l, reason: collision with root package name */
    private final E.b<n<?>> f2015l;

    /* renamed from: m, reason: collision with root package name */
    private final c f2016m;

    /* renamed from: n, reason: collision with root package name */
    private final o f2017n;

    /* renamed from: o, reason: collision with root package name */
    private final b1.a f2018o;
    private final b1.a p;

    /* renamed from: q, reason: collision with root package name */
    private final b1.a f2019q;

    /* renamed from: r, reason: collision with root package name */
    private final b1.a f2020r;

    /* renamed from: s, reason: collision with root package name */
    private final AtomicInteger f2021s;

    /* renamed from: t, reason: collision with root package name */
    private V0.f f2022t;
    private boolean u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f2023v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f2024w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f2025x;

    /* renamed from: y, reason: collision with root package name */
    private x<?> f2026y;

    /* renamed from: z, reason: collision with root package name */
    V0.a f2027z;

    private class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private final o1.f f2028i;

        a(o1.f fVar) {
            this.f2028i = fVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (((o1.g) this.f2028i).h()) {
                synchronized (n.this) {
                    if (n.this.f2012i.g(this.f2028i)) {
                        n nVar = n.this;
                        o1.f fVar = this.f2028i;
                        Objects.requireNonNull(nVar);
                        try {
                            ((o1.g) fVar).o(nVar.f2007B);
                        } catch (Throwable th) {
                            throw new Y0.d(th);
                        }
                    }
                    n.this.b();
                }
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private final o1.f f2030i;

        b(o1.f fVar) {
            this.f2030i = fVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (((o1.g) this.f2030i).h()) {
                synchronized (n.this) {
                    if (n.this.f2012i.g(this.f2030i)) {
                        n.this.f2009D.a();
                        n nVar = n.this;
                        o1.f fVar = this.f2030i;
                        Objects.requireNonNull(nVar);
                        try {
                            ((o1.g) fVar).q(nVar.f2009D, nVar.f2027z);
                            n.this.k(this.f2030i);
                        } catch (Throwable th) {
                            throw new Y0.d(th);
                        }
                    }
                    n.this.b();
                }
            }
        }
    }

    static class c {
        c() {
        }
    }

    static final class d {

        /* renamed from: a, reason: collision with root package name */
        final o1.f f2032a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f2033b;

        d(o1.f fVar, Executor executor) {
            this.f2032a = fVar;
            this.f2033b = executor;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f2032a.equals(((d) obj).f2032a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f2032a.hashCode();
        }
    }

    n(b1.a aVar, b1.a aVar2, b1.a aVar3, b1.a aVar4, o oVar, r.a aVar5, E.b<n<?>> bVar) {
        c cVar = f2005G;
        this.f2012i = new e();
        this.f2013j = t1.d.a();
        this.f2021s = new AtomicInteger();
        this.f2018o = aVar;
        this.p = aVar2;
        this.f2019q = aVar3;
        this.f2020r = aVar4;
        this.f2017n = oVar;
        this.f2014k = aVar5;
        this.f2015l = bVar;
        this.f2016m = cVar;
    }

    private boolean e() {
        return this.f2008C || this.f2006A || this.f2011F;
    }

    private synchronized void j() {
        if (this.f2022t == null) {
            throw new IllegalArgumentException();
        }
        this.f2012i.clear();
        this.f2022t = null;
        this.f2009D = null;
        this.f2026y = null;
        this.f2008C = false;
        this.f2011F = false;
        this.f2006A = false;
        this.f2010E.r();
        this.f2010E = null;
        this.f2007B = null;
        this.f2027z = null;
        this.f2015l.a(this);
    }

    final synchronized void a(o1.f fVar, Executor executor) {
        this.f2013j.c();
        this.f2012i.d(fVar, executor);
        boolean z4 = true;
        if (this.f2006A) {
            c(1);
            executor.execute(new b(fVar));
        } else if (this.f2008C) {
            c(1);
            executor.execute(new a(fVar));
        } else {
            if (this.f2011F) {
                z4 = false;
            }
            C0384b.f(z4, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    final void b() {
        r<?> rVar;
        synchronized (this) {
            this.f2013j.c();
            C0384b.f(e(), "Not yet complete!");
            int iDecrementAndGet = this.f2021s.decrementAndGet();
            C0384b.f(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                rVar = this.f2009D;
                j();
            } else {
                rVar = null;
            }
        }
        if (rVar != null) {
            rVar.g();
        }
    }

    final synchronized void c(int i2) {
        r<?> rVar;
        C0384b.f(e(), "Not yet complete!");
        if (this.f2021s.getAndAdd(i2) == 0 && (rVar = this.f2009D) != null) {
            rVar.a();
        }
    }

    final synchronized n<R> d(V0.f fVar, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f2022t = fVar;
        this.u = z4;
        this.f2023v = z5;
        this.f2024w = z6;
        this.f2025x = z7;
        return this;
    }

    @Override // t1.a.d
    public final t1.d f() {
        return this.f2013j;
    }

    public final void g(s sVar) {
        synchronized (this) {
            this.f2007B = sVar;
        }
        synchronized (this) {
            this.f2013j.c();
            if (this.f2011F) {
                j();
                return;
            }
            if (this.f2012i.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.f2008C) {
                throw new IllegalStateException("Already failed once");
            }
            this.f2008C = true;
            V0.f fVar = this.f2022t;
            e eVarH = this.f2012i.h();
            c(eVarH.size() + 1);
            ((m) this.f2017n).f(this, fVar, null);
            Iterator<d> it = eVarH.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.f2033b.execute(new a(next.f2032a));
            }
            b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(x<R> xVar, V0.a aVar) {
        synchronized (this) {
            this.f2026y = xVar;
            this.f2027z = aVar;
        }
        synchronized (this) {
            this.f2013j.c();
            if (this.f2011F) {
                this.f2026y.d();
                j();
                return;
            }
            if (this.f2012i.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.f2006A) {
                throw new IllegalStateException("Already have resource");
            }
            c cVar = this.f2016m;
            x<?> xVar2 = this.f2026y;
            boolean z4 = this.u;
            V0.f fVar = this.f2022t;
            r.a aVar2 = this.f2014k;
            Objects.requireNonNull(cVar);
            this.f2009D = new r<>(xVar2, z4, true, fVar, aVar2);
            this.f2006A = true;
            e eVarH = this.f2012i.h();
            c(eVarH.size() + 1);
            ((m) this.f2017n).f(this, this.f2022t, this.f2009D);
            Iterator<d> it = eVarH.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.f2033b.execute(new b(next.f2032a));
            }
            b();
        }
    }

    final boolean i() {
        return this.f2025x;
    }

    final synchronized void k(o1.f fVar) {
        this.f2013j.c();
        this.f2012i.i(fVar);
        if (this.f2012i.isEmpty()) {
            boolean z4 = true;
            if (!e()) {
                this.f2011F = true;
                this.f2010E.h();
                ((m) this.f2017n).e(this, this.f2022t);
            }
            if (!this.f2006A && !this.f2008C) {
                z4 = false;
            }
            if (z4 && this.f2021s.get() == 0) {
                j();
            }
        }
    }

    public final void l(j<?> jVar) {
        (this.f2023v ? this.f2019q : this.f2024w ? this.f2020r : this.p).execute(jVar);
    }

    public final synchronized void m(j<R> jVar) {
        this.f2010E = jVar;
        (jVar.w() ? this.f2018o : this.f2023v ? this.f2019q : this.f2024w ? this.f2020r : this.p).execute(jVar);
    }

    static final class e implements Iterable<d> {

        /* renamed from: i, reason: collision with root package name */
        private final List<d> f2034i;

        e() {
            this.f2034i = new ArrayList(2);
        }

        final void clear() {
            this.f2034i.clear();
        }

        final void d(o1.f fVar, Executor executor) {
            this.f2034i.add(new d(fVar, executor));
        }

        final boolean g(o1.f fVar) {
            return this.f2034i.contains(new d(fVar, s1.e.a()));
        }

        final e h() {
            return new e(new ArrayList(this.f2034i));
        }

        final void i(o1.f fVar) {
            this.f2034i.remove(new d(fVar, s1.e.a()));
        }

        final boolean isEmpty() {
            return this.f2034i.isEmpty();
        }

        @Override // java.lang.Iterable
        public final Iterator<d> iterator() {
            return this.f2034i.iterator();
        }

        final int size() {
            return this.f2034i.size();
        }

        e(List<d> list) {
            this.f2034i = list;
        }
    }
}
