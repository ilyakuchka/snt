package Y0;

import java.util.Objects;

/* loaded from: classes.dex */
final class r<Z> implements x<Z> {

    /* renamed from: i, reason: collision with root package name */
    private final boolean f2042i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f2043j;

    /* renamed from: k, reason: collision with root package name */
    private final x<Z> f2044k;

    /* renamed from: l, reason: collision with root package name */
    private final a f2045l;

    /* renamed from: m, reason: collision with root package name */
    private final V0.f f2046m;

    /* renamed from: n, reason: collision with root package name */
    private int f2047n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2048o;

    interface a {
        void a(V0.f fVar, r<?> rVar);
    }

    r(x<Z> xVar, boolean z4, boolean z5, V0.f fVar, a aVar) {
        Objects.requireNonNull(xVar, "Argument must not be null");
        this.f2044k = xVar;
        this.f2042i = z4;
        this.f2043j = z5;
        this.f2046m = fVar;
        Objects.requireNonNull(aVar, "Argument must not be null");
        this.f2045l = aVar;
    }

    final synchronized void a() {
        if (this.f2048o) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f2047n++;
    }

    @Override // Y0.x
    public final int b() {
        return this.f2044k.b();
    }

    @Override // Y0.x
    public final Class<Z> c() {
        return this.f2044k.c();
    }

    @Override // Y0.x
    public final synchronized void d() {
        if (this.f2047n > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f2048o) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f2048o = true;
        if (this.f2043j) {
            this.f2044k.d();
        }
    }

    final x<Z> e() {
        return this.f2044k;
    }

    final boolean f() {
        return this.f2042i;
    }

    final void g() {
        boolean z4;
        synchronized (this) {
            int i2 = this.f2047n;
            if (i2 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z4 = true;
            int i4 = i2 - 1;
            this.f2047n = i4;
            if (i4 != 0) {
                z4 = false;
            }
        }
        if (z4) {
            this.f2045l.a(this.f2046m, this);
        }
    }

    @Override // Y0.x
    public final Z get() {
        return this.f2044k.get();
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f2042i + ", listener=" + this.f2045l + ", key=" + this.f2046m + ", acquired=" + this.f2047n + ", isRecycled=" + this.f2048o + ", resource=" + this.f2044k + '}';
    }
}
