package N;

import N.h;
import N.i;
import N.k;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class d<K, V> extends i<V> implements k.a {

    /* renamed from: A, reason: collision with root package name */
    int f617A;

    /* renamed from: B, reason: collision with root package name */
    int f618B;

    /* renamed from: C, reason: collision with root package name */
    boolean f619C;

    /* renamed from: D, reason: collision with root package name */
    h.a<V> f620D;

    /* renamed from: x, reason: collision with root package name */
    final N.c<K, V> f621x;

    /* renamed from: y, reason: collision with root package name */
    int f622y;

    /* renamed from: z, reason: collision with root package name */
    int f623z;

    final class a extends h.a<V> {
        a() {
        }

        @Override // N.h.a
        public final void a(int i2, h<V> hVar) {
            if (hVar.b()) {
                d.this.k();
                return;
            }
            if (d.this.r()) {
                return;
            }
            List<V> list = hVar.f653a;
            if (i2 == 0) {
                d dVar = d.this;
                dVar.f661m.y(hVar.f654b, list, hVar.f655c, hVar.d, dVar);
                d dVar2 = d.this;
                if (dVar2.f662n == -1) {
                    dVar2.f662n = (list.size() / 2) + hVar.f654b + hVar.d;
                }
            } else {
                d dVar3 = d.this;
                int i4 = dVar3.f662n;
                dVar3.f661m.p();
                Objects.requireNonNull(d.this);
                if (i2 == 1) {
                    d dVar4 = d.this;
                    dVar4.f661m.h(list, dVar4);
                } else {
                    if (i2 != 2) {
                        throw new IllegalArgumentException(D2.e.b("unexpected resultType ", i2));
                    }
                    d dVar5 = d.this;
                    dVar5.f661m.B(list, dVar5);
                }
                Objects.requireNonNull(d.this);
            }
            d dVar6 = d.this;
            if (dVar6.f659k != null) {
                boolean z4 = dVar6.f661m.size() == 0;
                d.this.i(z4, !z4 && i2 == 2 && hVar.f653a.size() == 0, !z4 && i2 == 1 && hVar.f653a.size() == 0);
            }
        }
    }

    final class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f625i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Object f626j;

        b(int i2, Object obj) {
            this.f625i = i2;
            this.f626j = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (d.this.r()) {
                return;
            }
            if (d.this.f621x.d()) {
                d.this.k();
            } else {
                d dVar = d.this;
                dVar.f621x.g(this.f625i, dVar.f660l.f681a, dVar.f657i, dVar.f620D);
            }
        }
    }

    final class c implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f628i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Object f629j;

        c(int i2, Object obj) {
            this.f628i = i2;
            this.f629j = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (d.this.r()) {
                return;
            }
            if (d.this.f621x.d()) {
                d.this.k();
            } else {
                d dVar = d.this;
                dVar.f621x.f(this.f628i, dVar.f660l.f681a, dVar.f657i, dVar.f620D);
            }
        }
    }

    d(N.c<K, V> cVar, Executor executor, Executor executor2, i.c<V> cVar2, i.f fVar, K k2, int i2) {
        super(new k(), executor, executor2, cVar2, fVar);
        this.f622y = 0;
        this.f623z = 0;
        this.f617A = 0;
        this.f618B = 0;
        this.f619C = false;
        this.f620D = new a();
        this.f621x = cVar;
        this.f662n = i2;
        if (cVar.d()) {
            k();
        } else {
            i.f fVar2 = this.f660l;
            cVar.h(k2, fVar2.d, fVar2.f681a, this.f657i, this.f620D);
        }
        Objects.requireNonNull(this.f660l);
    }

    private void D() {
        if (this.f623z != 0) {
            return;
        }
        this.f623z = 1;
        this.f658j.execute(new c(((this.f661m.o() + this.f661m.u()) - 1) + this.f661m.t(), this.f661m.n()));
    }

    private void E() {
        if (this.f622y != 0) {
            return;
        }
        this.f622y = 1;
        this.f658j.execute(new b(this.f661m.o() + this.f661m.t(), this.f661m.l()));
    }

    public final void A(int i2) {
        w(0, i2);
        this.f619C = this.f661m.o() > 0 || this.f661m.v() > 0;
    }

    public final void B(int i2, int i4, int i5) {
        int i6 = (this.f618B - i4) - i5;
        this.f618B = i6;
        this.f623z = 0;
        if (i6 > 0) {
            D();
        }
        v(i2, i4);
        w(i2 + i4, i5);
    }

    public final void C(int i2, int i4, int i5) {
        int i6 = (this.f617A - i4) - i5;
        this.f617A = i6;
        this.f622y = 0;
        if (i6 > 0) {
            E();
        }
        v(i2, i4);
        w(0, i5);
        x(i5);
    }

    @Override // N.k.a
    public final void d(int i2) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }

    @Override // N.k.a
    public final void g(int i2, int i4) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }

    @Override // N.i
    final void n(i<V> iVar, i.e eVar) {
        k<V> kVar = iVar.f661m;
        int iQ = this.f661m.q() - kVar.q();
        int iR = this.f661m.r() - kVar.r();
        int iV = kVar.v();
        int iO = kVar.o();
        if (kVar.isEmpty() || iQ < 0 || iR < 0 || this.f661m.v() != Math.max(iV - iQ, 0) || this.f661m.o() != Math.max(iO - iR, 0) || this.f661m.u() != kVar.u() + iQ + iR) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        if (iQ != 0) {
            int iMin = Math.min(iV, iQ);
            int i2 = iQ - iMin;
            int iO2 = kVar.o() + kVar.u();
            if (iMin != 0) {
                eVar.a(iO2, iMin);
            }
            if (i2 != 0) {
                eVar.b(iO2 + iMin, i2);
            }
        }
        if (iR != 0) {
            int iMin2 = Math.min(iO, iR);
            int i4 = iR - iMin2;
            if (iMin2 != 0) {
                eVar.a(iO, iMin2);
            }
            if (i4 != 0) {
                eVar.b(0, i4);
            }
        }
    }

    @Override // N.i
    public final e<?, V> o() {
        return this.f621x;
    }

    @Override // N.i
    public final Object p() {
        return this.f621x.i(this.f662n);
    }

    @Override // N.i
    final boolean q() {
        return true;
    }

    @Override // N.i
    protected final void u(int i2) {
        int iO = this.f660l.f682b - (i2 - this.f661m.o());
        int iO2 = ((i2 + this.f660l.f682b) + 1) - (this.f661m.o() + this.f661m.u());
        int iMax = Math.max(iO, this.f617A);
        this.f617A = iMax;
        if (iMax > 0) {
            E();
        }
        int iMax2 = Math.max(iO2, this.f618B);
        this.f618B = iMax2;
        if (iMax2 > 0) {
            D();
        }
    }
}
