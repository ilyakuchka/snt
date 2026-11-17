package F0;

import D2.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f128a;

    public a(int i2) {
        this.f128a = -1;
        if (i2 != 10 && i2 != 11) {
            throw new IllegalArgumentException(e.b("Bad layout type detected: ", i2));
        }
        this.f128a = i2;
    }

    public final int a() {
        return this.f128a == 10 ? 320 : 480;
    }

    public final int b() {
        return this.f128a == 10 ? 240 : 320;
    }

    public final int c() {
        return this.f128a == 10 ? 80 : 160;
    }

    public final int d() {
        return this.f128a == 10 ? 480 : 320;
    }
}
