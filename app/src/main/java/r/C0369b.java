package r;

import r.C0372e;

/* renamed from: r.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0369b implements C0372e.a {

    /* renamed from: c, reason: collision with root package name */
    public final C0368a f7658c;

    /* renamed from: a, reason: collision with root package name */
    C0375h f7656a = null;

    /* renamed from: b, reason: collision with root package name */
    float f7657b = 0.0f;
    boolean d = false;

    public C0369b(C0370c c0370c) {
        this.f7658c = new C0368a(this, c0370c);
    }

    public final C0369b a(C0372e c0372e, int i2) {
        this.f7658c.k(c0372e.m(i2, "ep"), 1.0f);
        this.f7658c.k(c0372e.m(i2, "em"), -1.0f);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(C0375h c0375h) {
        float f4;
        int i2 = c0375h.f7680c;
        if (i2 != 1) {
            f4 = i2 == 2 ? 1000.0f : i2 == 3 ? 1000000.0f : i2 == 4 ? 1.0E9f : i2 == 5 ? 1.0E12f : 1.0f;
        }
        this.f7658c.k(c0375h, f4);
    }

    public final C0369b c(C0375h c0375h, C0375h c0375h2, C0375h c0375h3, C0375h c0375h4, float f4) {
        this.f7658c.k(c0375h, -1.0f);
        this.f7658c.k(c0375h2, 1.0f);
        this.f7658c.k(c0375h3, f4);
        this.f7658c.k(c0375h4, -f4);
        return this;
    }

    public final C0369b d(float f4, float f5, float f6, C0375h c0375h, C0375h c0375h2, C0375h c0375h3, C0375h c0375h4) {
        this.f7657b = 0.0f;
        if (f5 == 0.0f || f4 == f6) {
            this.f7658c.k(c0375h, 1.0f);
            this.f7658c.k(c0375h2, -1.0f);
            this.f7658c.k(c0375h4, 1.0f);
            this.f7658c.k(c0375h3, -1.0f);
        } else if (f4 == 0.0f) {
            this.f7658c.k(c0375h, 1.0f);
            this.f7658c.k(c0375h2, -1.0f);
        } else if (f6 == 0.0f) {
            this.f7658c.k(c0375h3, 1.0f);
            this.f7658c.k(c0375h4, -1.0f);
        } else {
            float f7 = (f4 / f5) / (f6 / f5);
            this.f7658c.k(c0375h, 1.0f);
            this.f7658c.k(c0375h2, -1.0f);
            this.f7658c.k(c0375h4, f7);
            this.f7658c.k(c0375h3, -f7);
        }
        return this;
    }

    public final C0369b e(C0375h c0375h, C0375h c0375h2, C0375h c0375h3, int i2) {
        boolean z4 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z4 = true;
            }
            this.f7657b = i2;
        }
        if (z4) {
            this.f7658c.k(c0375h, 1.0f);
            this.f7658c.k(c0375h2, -1.0f);
            this.f7658c.k(c0375h3, -1.0f);
        } else {
            this.f7658c.k(c0375h, -1.0f);
            this.f7658c.k(c0375h2, 1.0f);
            this.f7658c.k(c0375h3, 1.0f);
        }
        return this;
    }

    public final C0369b f(C0375h c0375h, C0375h c0375h2, C0375h c0375h3, int i2) {
        boolean z4 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z4 = true;
            }
            this.f7657b = i2;
        }
        if (z4) {
            this.f7658c.k(c0375h, 1.0f);
            this.f7658c.k(c0375h2, -1.0f);
            this.f7658c.k(c0375h3, 1.0f);
        } else {
            this.f7658c.k(c0375h, -1.0f);
            this.f7658c.k(c0375h2, 1.0f);
            this.f7658c.k(c0375h3, -1.0f);
        }
        return this;
    }

    public final C0369b g(C0375h c0375h, C0375h c0375h2, C0375h c0375h3, C0375h c0375h4, float f4) {
        this.f7658c.k(c0375h3, 0.5f);
        this.f7658c.k(c0375h4, 0.5f);
        this.f7658c.k(c0375h, -0.5f);
        this.f7658c.k(c0375h2, -0.5f);
        this.f7657b = -f4;
        return this;
    }

    final void h(C0375h c0375h) {
        C0375h c0375h2 = this.f7656a;
        if (c0375h2 != null) {
            this.f7658c.k(c0375h2, -1.0f);
            this.f7656a = null;
        }
        float fL = this.f7658c.l(c0375h, true) * (-1.0f);
        this.f7656a = c0375h;
        if (fL == 1.0f) {
            return;
        }
        this.f7657b /= fL;
        this.f7658c.e(fL);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toString() {
        String string;
        boolean z4;
        if (this.f7656a == null) {
            string = "0";
        } else {
            StringBuilder sbD = D2.e.d("");
            sbD.append(this.f7656a);
            string = sbD.toString();
        }
        String strC = D2.e.c(string, " = ");
        if (this.f7657b != 0.0f) {
            StringBuilder sbD2 = D2.e.d(strC);
            sbD2.append(this.f7657b);
            strC = sbD2.toString();
            z4 = true;
        } else {
            z4 = false;
        }
        int i2 = this.f7658c.f7648a;
        for (int i4 = 0; i4 < i2; i4++) {
            if (this.f7658c.h(i4) != null) {
                float fI = this.f7658c.i(i4);
                if (fI != 0.0f) {
                    if (!z4) {
                        if (fI < 0.0f) {
                            strC = D2.e.c(strC, "- ");
                            fI *= -1.0f;
                        }
                        strC = fI == 1.0f ? D2.e.c(strC, "null") : strC + fI + " null";
                        z4 = true;
                    } else if (fI > 0.0f) {
                        strC = D2.e.c(strC, " + ");
                        if (fI == 1.0f) {
                        }
                        z4 = true;
                    } else {
                        strC = D2.e.c(strC, " - ");
                        fI *= -1.0f;
                        if (fI == 1.0f) {
                        }
                        z4 = true;
                    }
                }
            }
        }
        return !z4 ? D2.e.c(strC, "0.0") : strC;
    }
}
