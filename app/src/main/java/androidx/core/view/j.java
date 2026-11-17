package androidx.core.view;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private int f3308a;

    /* renamed from: b, reason: collision with root package name */
    private int f3309b;

    public final int a() {
        return this.f3309b | this.f3308a;
    }

    public final void b(int i2) {
        this.f3308a = i2;
    }

    public final void c(int i2, int i4) {
        if (i4 == 1) {
            this.f3309b = i2;
        } else {
            this.f3308a = i2;
        }
    }

    public final void d(int i2) {
        if (i2 == 1) {
            this.f3309b = 0;
        } else {
            this.f3308a = 0;
        }
    }
}
