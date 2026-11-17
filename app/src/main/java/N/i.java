package N;

import N.n;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class i<T> extends AbstractList<T> {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f656w = 0;

    /* renamed from: i, reason: collision with root package name */
    final Executor f657i;

    /* renamed from: j, reason: collision with root package name */
    final Executor f658j;

    /* renamed from: k, reason: collision with root package name */
    final c<T> f659k;

    /* renamed from: l, reason: collision with root package name */
    final f f660l;

    /* renamed from: m, reason: collision with root package name */
    final k<T> f661m;
    final int p;

    /* renamed from: n, reason: collision with root package name */
    int f662n = 0;

    /* renamed from: o, reason: collision with root package name */
    T f663o = null;

    /* renamed from: q, reason: collision with root package name */
    boolean f664q = false;

    /* renamed from: r, reason: collision with root package name */
    boolean f665r = false;

    /* renamed from: s, reason: collision with root package name */
    private int f666s = Integer.MAX_VALUE;

    /* renamed from: t, reason: collision with root package name */
    private int f667t = Integer.MIN_VALUE;
    private final AtomicBoolean u = new AtomicBoolean(false);

    /* renamed from: v, reason: collision with root package name */
    private final ArrayList<WeakReference<e>> f668v = new ArrayList<>();

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f669i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f670j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f671k;

        a(boolean z4, boolean z5, boolean z6) {
            this.f669i = z4;
            this.f670j = z5;
            this.f671k = z6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f669i) {
                Objects.requireNonNull(i.this.f659k);
            }
            if (this.f670j) {
                i.this.f664q = true;
            }
            if (this.f671k) {
                i.this.f665r = true;
            }
            i.this.z(false);
        }
    }

    final class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f673i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f674j;

        b(boolean z4, boolean z5) {
            this.f673i = z4;
            this.f674j = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.this.l(this.f673i, this.f674j);
        }
    }

    public static abstract class c<T> {
        public abstract void a(T t2);
    }

    public static final class d<Key, Value> {

        /* renamed from: a, reason: collision with root package name */
        private final N.e<Key, Value> f676a;

        /* renamed from: b, reason: collision with root package name */
        private final f f677b;

        /* renamed from: c, reason: collision with root package name */
        private Executor f678c;
        private Executor d;

        /* renamed from: e, reason: collision with root package name */
        private c f679e;

        /* renamed from: f, reason: collision with root package name */
        private Key f680f;

        public d(N.e<Key, Value> eVar, f fVar) {
            if (eVar == null) {
                throw new IllegalArgumentException("DataSource may not be null");
            }
            if (fVar == null) {
                throw new IllegalArgumentException("Config may not be null");
            }
            this.f676a = eVar;
            this.f677b = fVar;
        }

        public final i<Value> a() {
            int iIntValue;
            Executor executor = this.f678c;
            if (executor == null) {
                throw new IllegalArgumentException("MainThreadExecutor required");
            }
            Executor executor2 = this.d;
            if (executor2 == null) {
                throw new IllegalArgumentException("BackgroundThreadExecutor required");
            }
            N.e<Key, Value> eVar = this.f676a;
            c cVar = this.f679e;
            f fVar = this.f677b;
            Key key = this.f680f;
            int i2 = i.f656w;
            if (!eVar.c() && fVar.f683c) {
                return new p((n) eVar, executor, executor2, cVar, fVar, key != null ? ((Integer) key).intValue() : 0);
            }
            if (eVar.c()) {
                iIntValue = -1;
            } else {
                n.a aVar = new n.a((n) eVar);
                iIntValue = key != null ? ((Integer) key).intValue() : -1;
                eVar = aVar;
            }
            return new N.d((N.c) eVar, executor, executor2, cVar, fVar, key, iIntValue);
        }

        public final d<Key, Value> b(c cVar) {
            this.f679e = cVar;
            return this;
        }

        public final d<Key, Value> c(Executor executor) {
            this.d = executor;
            return this;
        }

        public final d<Key, Value> d(Key key) {
            this.f680f = key;
            return this;
        }

        public final d<Key, Value> e(Executor executor) {
            this.f678c = executor;
            return this;
        }
    }

    public static abstract class e {
        public abstract void a(int i2, int i4);

        public abstract void b(int i2, int i4);
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f681a;

        /* renamed from: b, reason: collision with root package name */
        public final int f682b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f683c;
        public final int d;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private int f684a = -1;

            /* renamed from: b, reason: collision with root package name */
            private int f685b = -1;

            /* renamed from: c, reason: collision with root package name */
            private int f686c = -1;
            private boolean d = true;

            public final f a() {
                if (this.f685b < 0) {
                    this.f685b = this.f684a;
                }
                if (this.f686c < 0) {
                    this.f686c = this.f684a * 3;
                }
                boolean z4 = this.d;
                if (z4 || this.f685b != 0) {
                    return new f(this.f684a, this.f685b, z4, this.f686c);
                }
                throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
            }

            public final a b() {
                this.d = false;
                return this;
            }

            public final a c() {
                this.f684a = 10;
                return this;
            }

            public final a d() {
                this.f685b = 20;
                return this;
            }
        }

        f(int i2, int i4, boolean z4, int i5) {
            this.f681a = i2;
            this.f682b = i4;
            this.f683c = z4;
            this.d = i5;
        }
    }

    i(k<T> kVar, Executor executor, Executor executor2, c<T> cVar, f fVar) {
        this.f661m = kVar;
        this.f657i = executor;
        this.f658j = executor2;
        this.f659k = cVar;
        this.f660l = fVar;
        this.p = (fVar.f682b * 2) + fVar.f681a;
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int i2) {
        T t2 = this.f661m.get(i2);
        if (t2 != null) {
            this.f663o = t2;
        }
        return t2;
    }

    public final void h(List<T> list, e eVar) {
        if (list != null && list != this) {
            if (!list.isEmpty()) {
                n((i) list, eVar);
            } else if (!this.f661m.isEmpty()) {
                eVar.b(0, this.f661m.size());
            }
        }
        int size = this.f668v.size();
        while (true) {
            size--;
            if (size < 0) {
                this.f668v.add(new WeakReference<>(eVar));
                return;
            } else if (this.f668v.get(size).get() == null) {
                this.f668v.remove(size);
            }
        }
    }

    final void i(boolean z4, boolean z5, boolean z6) {
        if (this.f659k == null) {
            throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
        }
        if (this.f666s == Integer.MAX_VALUE) {
            this.f666s = this.f661m.size();
        }
        if (this.f667t == Integer.MIN_VALUE) {
            this.f667t = 0;
        }
        if (z4 || z5 || z6) {
            this.f657i.execute(new a(z4, z5, z6));
        }
    }

    public final void k() {
        this.u.set(true);
    }

    final void l(boolean z4, boolean z5) {
        if (z4) {
            c<T> cVar = this.f659k;
            this.f661m.l();
            Objects.requireNonNull(cVar);
        }
        if (z5) {
            this.f659k.a(this.f661m.n());
        }
    }

    abstract void n(i<T> iVar, e eVar);

    public abstract N.e<?, T> o();

    public abstract Object p();

    abstract boolean q();

    public boolean r() {
        return this.u.get();
    }

    public boolean s() {
        return r();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f661m.size();
    }

    public final void t(int i2) {
        if (i2 < 0 || i2 >= size()) {
            StringBuilder sbC = C2.c.c("Index: ", i2, ", Size: ");
            sbC.append(size());
            throw new IndexOutOfBoundsException(sbC.toString());
        }
        this.f662n = this.f661m.t() + i2;
        u(i2);
        this.f666s = Math.min(this.f666s, i2);
        this.f667t = Math.max(this.f667t, i2);
        z(true);
    }

    abstract void u(int i2);

    final void v(int i2, int i4) {
        if (i4 != 0) {
            for (int size = this.f668v.size() - 1; size >= 0; size--) {
                e eVar = this.f668v.get(size).get();
                if (eVar != null) {
                    eVar.a(i2, i4);
                }
            }
        }
    }

    final void w(int i2, int i4) {
        if (i4 != 0) {
            for (int size = this.f668v.size() - 1; size >= 0; size--) {
                e eVar = this.f668v.get(size).get();
                if (eVar != null) {
                    eVar.b(i2, i4);
                }
            }
        }
    }

    final void x(int i2) {
        this.f662n += i2;
        this.f666s += i2;
        this.f667t += i2;
    }

    public final void y(e eVar) {
        for (int size = this.f668v.size() - 1; size >= 0; size--) {
            e eVar2 = this.f668v.get(size).get();
            if (eVar2 == null || eVar2 == eVar) {
                this.f668v.remove(size);
            }
        }
    }

    final void z(boolean z4) {
        boolean z5 = this.f664q && this.f666s <= this.f660l.f682b;
        boolean z6 = this.f665r && this.f667t >= (size() - 1) - this.f660l.f682b;
        if (z5 || z6) {
            if (z5) {
                this.f664q = false;
            }
            if (z6) {
                this.f665r = false;
            }
            if (z4) {
                this.f657i.execute(new b(z5, z6));
            } else {
                l(z5, z6);
            }
        }
    }
}
