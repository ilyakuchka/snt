package s;

/* loaded from: classes.dex */
public final class l extends m {

    /* renamed from: c, reason: collision with root package name */
    float f7827c = 0.0f;

    public final void f() {
        this.f7829b = 2;
    }

    public final void g(int i2) {
        int i4 = this.f7829b;
        if (i4 == 0 || this.f7827c != i2) {
            this.f7827c = i2;
            if (i4 == 1) {
                c();
            }
            b();
        }
    }
}
