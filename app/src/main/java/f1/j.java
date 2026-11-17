package f1;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f6189a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final j f6190b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final j f6191c;
    public static final j d;

    /* renamed from: e, reason: collision with root package name */
    public static final j f6192e;

    /* renamed from: f, reason: collision with root package name */
    public static final V0.g<j> f6193f;
    static final boolean g;

    private static class a extends j {
        a() {
        }

        @Override // f1.j
        public final int a(int i2, int i4, int i5, int i6) {
            return (b(i2, i4, i5, i6) == 1.0f || j.g) ? 2 : 1;
        }

        @Override // f1.j
        public final float b(int i2, int i4, int i5, int i6) {
            return Math.min(1.0f, j.f6189a.b(i2, i4, i5, i6));
        }
    }

    private static class b extends j {
        b() {
        }

        @Override // f1.j
        public final int a(int i2, int i4, int i5, int i6) {
            return 2;
        }

        @Override // f1.j
        public final float b(int i2, int i4, int i5, int i6) {
            return Math.max(i5 / i2, i6 / i4);
        }
    }

    private static class c extends j {
        c() {
        }

        @Override // f1.j
        public final int a(int i2, int i4, int i5, int i6) {
            return j.g ? 2 : 1;
        }

        @Override // f1.j
        public final float b(int i2, int i4, int i5, int i6) {
            if (j.g) {
                return Math.min(i5 / i2, i6 / i4);
            }
            if (Math.max(i4 / i6, i2 / i5) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r0);
        }
    }

    private static class d extends j {
        d() {
        }

        @Override // f1.j
        public final int a(int i2, int i4, int i5, int i6) {
            return 2;
        }

        @Override // f1.j
        public final float b(int i2, int i4, int i5, int i6) {
            return 1.0f;
        }
    }

    static {
        b bVar = new b();
        f6191c = bVar;
        d = new d();
        f6192e = bVar;
        f6193f = V0.g.d("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", bVar);
        g = true;
    }

    public abstract int a(int i2, int i4, int i5, int i6);

    public abstract float b(int i2, int i4, int i5, int i6);
}
