package N;

import N.h;
import N.i;
import N.k;
import N.n;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class p<T> extends i<T> implements k.a {

    /* renamed from: x, reason: collision with root package name */
    final n<T> f719x;

    /* renamed from: y, reason: collision with root package name */
    h.a<T> f720y;

    final class a extends h.a<T> {
        a() {
        }

        @Override // N.h.a
        public final void a(int i2, h<T> hVar) {
            if (hVar.b()) {
                p.this.k();
                return;
            }
            if (p.this.r()) {
                return;
            }
            if (i2 != 0 && i2 != 3) {
                throw new IllegalArgumentException(D2.e.b("unexpected resultType", i2));
            }
            List<T> list = hVar.f653a;
            if (p.this.f661m.s() == 0) {
                p pVar = p.this;
                pVar.f661m.z(hVar.f654b, list, hVar.f655c, hVar.d, pVar.f660l.f681a, pVar);
            } else {
                p pVar2 = p.this;
                k<T> kVar = pVar2.f661m;
                int i4 = hVar.d;
                int i5 = pVar2.f662n;
                Objects.requireNonNull(pVar2.f660l);
                p pVar3 = p.this;
                kVar.D(i4, list, i5, pVar3.p, pVar3);
            }
            p pVar4 = p.this;
            if (pVar4.f659k != null) {
                boolean z4 = true;
                boolean z5 = pVar4.f661m.size() == 0;
                boolean z6 = !z5 && hVar.f654b == 0 && hVar.d == 0;
                int size = p.this.size();
                if (z5 || ((i2 != 0 || hVar.f655c != 0) && (i2 != 3 || hVar.d + p.this.f660l.f681a < size))) {
                    z4 = false;
                }
                p.this.i(z5, z6, z4);
            }
        }
    }

    final class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f722i;

        b(int i2) {
            this.f722i = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (p.this.r()) {
                return;
            }
            p pVar = p.this;
            int i2 = pVar.f660l.f681a;
            if (pVar.f719x.d()) {
                p.this.k();
                return;
            }
            int i4 = this.f722i * i2;
            int iMin = Math.min(i2, p.this.f661m.size() - i4);
            p pVar2 = p.this;
            pVar2.f719x.f(3, i4, iMin, pVar2.f657i, pVar2.f720y);
        }
    }

    p(n<T> nVar, Executor executor, Executor executor2, i.c<T> cVar, i.f fVar, int i2) {
        super(new k(), executor, executor2, cVar, fVar);
        this.f720y = new a();
        this.f719x = nVar;
        int i4 = this.f660l.f681a;
        this.f662n = i2;
        if (nVar.d()) {
            k();
            return;
        }
        int iMax = Math.max(this.f660l.d / i4, 2) * i4;
        int iMax2 = Math.max(0, ((i2 - (iMax / 2)) / i4) * i4);
        Executor executor3 = this.f657i;
        n.c cVar2 = new n.c(nVar, true, i4, this.f720y);
        nVar.g(new n.d(iMax2, iMax, i4), cVar2);
        cVar2.f706a.c(executor3);
    }

    @Override // N.k.a
    public final void d(int i2) {
        this.f658j.execute(new b(i2));
    }

    @Override // N.k.a
    public final void g(int i2, int i4) {
        v(i2, i4);
    }

    @Override // N.i
    protected final void n(i<T> iVar, i.e eVar) {
        k<T> kVar = iVar.f661m;
        if (kVar.isEmpty() || this.f661m.size() != kVar.size()) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        int i2 = this.f660l.f681a;
        int iO = this.f661m.o() / i2;
        int iS = this.f661m.s();
        int i4 = 0;
        while (i4 < iS) {
            int i5 = i4 + iO;
            int i6 = 0;
            while (i6 < this.f661m.s()) {
                int i7 = i5 + i6;
                if (!this.f661m.w(i2, i7) || kVar.w(i2, i7)) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 > 0) {
                eVar.a(i5 * i2, i2 * i6);
                i4 += i6 - 1;
            }
            i4++;
        }
    }

    @Override // N.i
    public final e<?, T> o() {
        return this.f719x;
    }

    @Override // N.i
    public final Object p() {
        return Integer.valueOf(this.f662n);
    }

    @Override // N.i
    final boolean q() {
        return false;
    }

    @Override // N.i
    protected final void u(int i2) {
        k<T> kVar = this.f661m;
        i.f fVar = this.f660l;
        kVar.g(i2, fVar.f682b, fVar.f681a, this);
    }
}
