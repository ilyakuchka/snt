package N;

import N.e;
import N.h;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class n<T> extends N.e<Integer, T> {

    static class a<Value> extends N.c<Integer, Value> {

        /* renamed from: c, reason: collision with root package name */
        final n<Value> f705c;

        a(n<Value> nVar) {
            this.f705c = nVar;
        }

        @Override // N.e
        public final void a(e.b bVar) {
            this.f705c.a(bVar);
        }

        @Override // N.e
        public final boolean d() {
            return this.f705c.d();
        }

        @Override // N.e
        public final void e(e.b bVar) {
            this.f705c.e(bVar);
        }

        @Override // N.c
        final void f(int i2, int i4, Executor executor, h.a aVar) {
            this.f705c.f(1, i2 + 1, i4, executor, aVar);
        }

        @Override // N.c
        final void g(int i2, int i4, Executor executor, h.a aVar) {
            int i5 = i2 - 1;
            if (i5 < 0) {
                this.f705c.f(2, i5, 0, executor, aVar);
                return;
            }
            int iMin = Math.min(i4, i5 + 1);
            this.f705c.f(2, (i5 - iMin) + 1, iMin, executor, aVar);
        }

        @Override // N.c
        final void h(Object obj, int i2, int i4, Executor executor, h.a aVar) {
            Integer numValueOf;
            Integer num = (Integer) obj;
            if (num == null) {
                numValueOf = 0;
            } else {
                i2 = Math.max(i2 / i4, 2) * i4;
                numValueOf = Integer.valueOf(Math.max(0, ((num.intValue() - (i2 / 2)) / i4) * i4));
            }
            n<Value> nVar = this.f705c;
            int iIntValue = numValueOf.intValue();
            Objects.requireNonNull(nVar);
            c cVar = new c(nVar, false, i4, aVar);
            nVar.g(new d(iIntValue, i2, i4), cVar);
            cVar.f706a.c(executor);
        }

        @Override // N.c
        final Object i(int i2) {
            return Integer.valueOf(i2);
        }
    }

    public static abstract class b<T> {
        public abstract void a(List<T> list, int i2, int i4);
    }

    static class c<T> extends b<T> {

        /* renamed from: a, reason: collision with root package name */
        final e.c<T> f706a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f707b;

        /* renamed from: c, reason: collision with root package name */
        private final int f708c;

        c(n nVar, boolean z4, int i2, h.a<T> aVar) {
            this.f706a = new e.c<>(nVar, 0, null, aVar);
            this.f707b = z4;
            this.f708c = i2;
            if (i2 < 1) {
                throw new IllegalArgumentException("Page size must be non-negative");
            }
        }

        @Override // N.n.b
        public final void a(List<T> list, int i2, int i4) {
            if (this.f706a.a()) {
                return;
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Position must be non-negative");
            }
            if (list.size() + i2 > i4) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            }
            if (list.size() == 0 && i4 > 0) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            }
            if (list.size() + i2 == i4 || list.size() % this.f708c == 0) {
                if (!this.f707b) {
                    this.f706a.b(new h<>(list, i2));
                    return;
                } else {
                    this.f706a.b(new h<>(list, i2, (i4 - i2) - list.size(), 0));
                    return;
                }
            }
            StringBuilder sbD = D2.e.d("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize ");
            sbD.append(list.size());
            sbD.append(", position ");
            sbD.append(i2);
            sbD.append(", totalCount ");
            sbD.append(i4);
            sbD.append(", pageSize ");
            sbD.append(this.f708c);
            throw new IllegalArgumentException(sbD.toString());
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f709a;

        /* renamed from: b, reason: collision with root package name */
        public final int f710b;

        /* renamed from: c, reason: collision with root package name */
        public final int f711c;

        public d(int i2, int i4, int i5) {
            this.f709a = i2;
            this.f710b = i4;
            this.f711c = i5;
        }
    }

    public static abstract class e<T> {
        public abstract void a(List<T> list);
    }

    static class f<T> extends e<T> {

        /* renamed from: a, reason: collision with root package name */
        private e.c<T> f712a;

        /* renamed from: b, reason: collision with root package name */
        private final int f713b;

        f(n nVar, int i2, int i4, Executor executor, h.a<T> aVar) {
            this.f712a = new e.c<>(nVar, i2, executor, aVar);
            this.f713b = i4;
        }

        @Override // N.n.e
        public final void a(List<T> list) {
            if (this.f712a.a()) {
                return;
            }
            this.f712a.b(new h<>(list, 0, 0, this.f713b));
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final int f714a;

        /* renamed from: b, reason: collision with root package name */
        public final int f715b;

        public g(int i2, int i4) {
            this.f714a = i2;
            this.f715b = i4;
        }
    }

    @Override // N.e
    final boolean c() {
        return false;
    }

    final void f(int i2, int i4, int i5, Executor executor, h.a<T> aVar) {
        f fVar = new f(this, i2, i4, executor, aVar);
        if (i5 == 0) {
            fVar.a(Collections.emptyList());
        } else {
            h(new g(i4, i5), fVar);
        }
    }

    public abstract void g(d dVar, b<T> bVar);

    public abstract void h(g gVar, e<T> eVar);
}
