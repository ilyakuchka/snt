package Y0;

import java.util.Objects;
import t1.a;

/* loaded from: classes.dex */
final class w<Z> implements x<Z>, a.d {

    /* renamed from: m, reason: collision with root package name */
    private static final E.b<w<?>> f2062m = t1.a.a(20, new a());

    /* renamed from: i, reason: collision with root package name */
    private final t1.d f2063i = t1.d.a();

    /* renamed from: j, reason: collision with root package name */
    private x<Z> f2064j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2065k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2066l;

    final class a implements a.b<w<?>> {
        a() {
        }

        @Override // t1.a.b
        public final w<?> a() {
            return new w<>();
        }
    }

    w() {
    }

    static <Z> w<Z> a(x<Z> xVar) {
        w<Z> wVar = (w) f2062m.b();
        Objects.requireNonNull(wVar, "Argument must not be null");
        ((w) wVar).f2066l = false;
        ((w) wVar).f2065k = true;
        ((w) wVar).f2064j = xVar;
        return wVar;
    }

    @Override // Y0.x
    public final int b() {
        return this.f2064j.b();
    }

    @Override // Y0.x
    public final Class<Z> c() {
        return this.f2064j.c();
    }

    @Override // Y0.x
    public final synchronized void d() {
        this.f2063i.c();
        this.f2066l = true;
        if (!this.f2065k) {
            this.f2064j.d();
            this.f2064j = null;
            f2062m.a(this);
        }
    }

    final synchronized void e() {
        this.f2063i.c();
        if (!this.f2065k) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f2065k = false;
        if (this.f2066l) {
            d();
        }
    }

    @Override // t1.a.d
    public final t1.d f() {
        return this.f2063i;
    }

    @Override // Y0.x
    public final Z get() {
        return this.f2064j.get();
    }
}
