package androidx.appcompat.widget;

/* loaded from: classes.dex */
final class N {

    /* renamed from: a, reason: collision with root package name */
    private int f2803a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f2804b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f2805c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f2806e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f2807f = 0;
    private boolean g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2808h = false;

    N() {
    }

    public final int a() {
        return this.g ? this.f2803a : this.f2804b;
    }

    public final int b() {
        return this.g ? this.f2804b : this.f2803a;
    }

    public final void c(int i2, int i4) {
        this.f2808h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f2806e = i2;
            this.f2803a = i2;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f2807f = i4;
            this.f2804b = i4;
        }
    }

    public final void d(boolean z4) {
        if (z4 == this.g) {
            return;
        }
        this.g = z4;
        if (!this.f2808h) {
            this.f2803a = this.f2806e;
            this.f2804b = this.f2807f;
            return;
        }
        if (z4) {
            int i2 = this.d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f2806e;
            }
            this.f2803a = i2;
            int i4 = this.f2805c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f2807f;
            }
            this.f2804b = i4;
            return;
        }
        int i5 = this.f2805c;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f2806e;
        }
        this.f2803a = i5;
        int i6 = this.d;
        if (i6 == Integer.MIN_VALUE) {
            i6 = this.f2807f;
        }
        this.f2804b = i6;
    }

    public final void e(int i2, int i4) {
        this.f2805c = i2;
        this.d = i4;
        this.f2808h = true;
        if (this.g) {
            if (i4 != Integer.MIN_VALUE) {
                this.f2803a = i4;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f2804b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2803a = i2;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f2804b = i4;
        }
    }
}
