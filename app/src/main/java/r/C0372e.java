package r;

import java.util.Arrays;
import java.util.Objects;

/* renamed from: r.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0372e {

    /* renamed from: o, reason: collision with root package name */
    private static int f7662o = 1000;

    /* renamed from: b, reason: collision with root package name */
    private C0371d f7664b;

    /* renamed from: e, reason: collision with root package name */
    C0369b[] f7666e;

    /* renamed from: k, reason: collision with root package name */
    final C0370c f7671k;

    /* renamed from: n, reason: collision with root package name */
    private final C0369b f7674n;

    /* renamed from: a, reason: collision with root package name */
    int f7663a = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f7665c = 32;
    private int d = 32;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7667f = false;
    private boolean[] g = new boolean[32];

    /* renamed from: h, reason: collision with root package name */
    int f7668h = 1;

    /* renamed from: i, reason: collision with root package name */
    int f7669i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f7670j = 32;

    /* renamed from: l, reason: collision with root package name */
    private C0375h[] f7672l = new C0375h[f7662o];

    /* renamed from: m, reason: collision with root package name */
    private int f7673m = 0;

    /* renamed from: r.e$a */
    interface a {
    }

    public C0372e() {
        this.f7666e = null;
        this.f7666e = new C0369b[32];
        w();
        C0370c c0370c = new C0370c();
        this.f7671k = c0370c;
        this.f7664b = new C0371d(c0370c);
        this.f7674n = new C0369b(c0370c);
    }

    private C0375h a(int i2, String str) {
        C0375h c0375h = (C0375h) this.f7671k.f7660b.a();
        if (c0375h == null) {
            c0375h = new C0375h(i2);
            c0375h.f7682f = i2;
        } else {
            c0375h.d();
            c0375h.f7682f = i2;
        }
        int i4 = this.f7673m;
        int i5 = f7662o;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            f7662o = i6;
            this.f7672l = (C0375h[]) Arrays.copyOf(this.f7672l, i6);
        }
        C0375h[] c0375hArr = this.f7672l;
        int i7 = this.f7673m;
        this.f7673m = i7 + 1;
        c0375hArr[i7] = c0375h;
        return c0375h;
    }

    private final void k(C0369b c0369b) {
        C0369b[] c0369bArr = this.f7666e;
        int i2 = this.f7669i;
        if (c0369bArr[i2] != null) {
            this.f7671k.f7659a.b(c0369bArr[i2]);
        }
        C0369b[] c0369bArr2 = this.f7666e;
        int i4 = this.f7669i;
        c0369bArr2[i4] = c0369b;
        C0375h c0375h = c0369b.f7656a;
        c0375h.f7679b = i4;
        this.f7669i = i4 + 1;
        c0375h.e(c0369b);
    }

    private void s() {
        int i2 = this.f7665c * 2;
        this.f7665c = i2;
        this.f7666e = (C0369b[]) Arrays.copyOf(this.f7666e, i2);
        C0370c c0370c = this.f7671k;
        c0370c.f7661c = (C0375h[]) Arrays.copyOf(c0370c.f7661c, this.f7665c);
        int i4 = this.f7665c;
        this.g = new boolean[i4];
        this.d = i4;
        this.f7670j = i4;
    }

    private final int v(a aVar) {
        for (int i2 = 0; i2 < this.f7668h; i2++) {
            this.g[i2] = false;
        }
        boolean z4 = false;
        int i4 = 0;
        while (!z4) {
            i4++;
            if (i4 >= this.f7668h * 2) {
                return i4;
            }
            C0369b c0369b = (C0369b) aVar;
            C0375h c0375h = c0369b.f7656a;
            if (c0375h != null) {
                this.g[c0375h.f7678a] = true;
            }
            C0375h c0375hG = c0369b.f7658c.g(this.g, null);
            if (c0375hG != null) {
                boolean[] zArr = this.g;
                int i5 = c0375hG.f7678a;
                if (zArr[i5]) {
                    return i4;
                }
                zArr[i5] = true;
            }
            if (c0375hG != null) {
                float f4 = Float.MAX_VALUE;
                int i6 = -1;
                for (int i7 = 0; i7 < this.f7669i; i7++) {
                    C0369b c0369b2 = this.f7666e[i7];
                    if (c0369b2.f7656a.f7682f != 1 && !c0369b2.d && c0369b2.f7658c.d(c0375hG)) {
                        float f5 = c0369b2.f7658c.f(c0375hG);
                        if (f5 < 0.0f) {
                            float f6 = (-c0369b2.f7657b) / f5;
                            if (f6 < f4) {
                                i6 = i7;
                                f4 = f6;
                            }
                        }
                    }
                }
                if (i6 > -1) {
                    C0369b c0369b3 = this.f7666e[i6];
                    c0369b3.f7656a.f7679b = -1;
                    c0369b3.h(c0375hG);
                    C0375h c0375h2 = c0369b3.f7656a;
                    c0375h2.f7679b = i6;
                    c0375h2.e(c0369b3);
                }
            }
            z4 = true;
        }
        return i4;
    }

    private void w() {
        int i2 = 0;
        while (true) {
            C0369b[] c0369bArr = this.f7666e;
            if (i2 >= c0369bArr.length) {
                return;
            }
            C0369b c0369b = c0369bArr[i2];
            if (c0369b != null) {
                this.f7671k.f7659a.b(c0369b);
            }
            this.f7666e[i2] = null;
            i2++;
        }
    }

    private final void y(C0369b c0369b) {
        if (this.f7669i > 0) {
            c0369b.f7658c.n(c0369b, this.f7666e);
            if (c0369b.f7658c.f7648a == 0) {
                c0369b.d = true;
            }
        }
    }

    public final void b(C0375h c0375h, C0375h c0375h2, int i2, float f4, C0375h c0375h3, C0375h c0375h4, int i4, int i5) {
        C0369b c0369bO = o();
        if (c0375h2 == c0375h3) {
            c0369bO.f7658c.k(c0375h, 1.0f);
            c0369bO.f7658c.k(c0375h4, 1.0f);
            c0369bO.f7658c.k(c0375h2, -2.0f);
        } else if (f4 == 0.5f) {
            c0369bO.f7658c.k(c0375h, 1.0f);
            c0369bO.f7658c.k(c0375h2, -1.0f);
            c0369bO.f7658c.k(c0375h3, -1.0f);
            c0369bO.f7658c.k(c0375h4, 1.0f);
            if (i2 > 0 || i4 > 0) {
                c0369bO.f7657b = (-i2) + i4;
            }
        } else if (f4 <= 0.0f) {
            c0369bO.f7658c.k(c0375h, -1.0f);
            c0369bO.f7658c.k(c0375h2, 1.0f);
            c0369bO.f7657b = i2;
        } else if (f4 >= 1.0f) {
            c0369bO.f7658c.k(c0375h3, -1.0f);
            c0369bO.f7658c.k(c0375h4, 1.0f);
            c0369bO.f7657b = i4;
        } else {
            float f5 = 1.0f - f4;
            c0369bO.f7658c.k(c0375h, f5 * 1.0f);
            c0369bO.f7658c.k(c0375h2, f5 * (-1.0f));
            c0369bO.f7658c.k(c0375h3, (-1.0f) * f4);
            c0369bO.f7658c.k(c0375h4, 1.0f * f4);
            if (i2 > 0 || i4 > 0) {
                c0369bO.f7657b = (i4 * f4) + ((-i2) * f5);
            }
        }
        if (i5 != 6) {
            c0369bO.a(this, i5);
        }
        c(c0369bO);
    }

    public final void c(C0369b c0369b) {
        boolean z4;
        boolean z5;
        C0375h c0375hG;
        boolean z6 = true;
        if (this.f7669i + 1 >= this.f7670j || this.f7668h + 1 >= this.d) {
            s();
        }
        boolean z7 = false;
        if (!c0369b.d) {
            y(c0369b);
            if (c0369b.f7656a == null && c0369b.f7657b == 0.0f && c0369b.f7658c.f7648a == 0) {
                return;
            }
            float f4 = c0369b.f7657b;
            if (f4 < 0.0f) {
                c0369b.f7657b = f4 * (-1.0f);
                c0369b.f7658c.j();
            }
            C0375h c0375hB = c0369b.f7658c.b();
            if (c0375hB == null) {
                z4 = true;
            } else {
                c0369b.h(c0375hB);
                z4 = false;
            }
            if (c0369b.f7658c.f7648a == 0) {
                c0369b.d = true;
            }
            if (z4) {
                if (this.f7668h + 1 >= this.d) {
                    s();
                }
                C0375h c0375hA = a(3, null);
                int i2 = this.f7663a + 1;
                this.f7663a = i2;
                this.f7668h++;
                c0375hA.f7678a = i2;
                this.f7671k.f7661c[i2] = c0375hA;
                c0369b.f7656a = c0375hA;
                k(c0369b);
                C0369b c0369b2 = this.f7674n;
                Objects.requireNonNull(c0369b2);
                c0369b2.f7656a = null;
                c0369b2.f7658c.c();
                int i4 = 0;
                while (true) {
                    C0368a c0368a = c0369b.f7658c;
                    if (i4 >= c0368a.f7648a) {
                        break;
                    }
                    c0369b2.f7658c.a(c0368a.h(i4), c0369b.f7658c.i(i4), true);
                    i4++;
                }
                v(this.f7674n);
                if (c0375hA.f7679b == -1) {
                    if (c0369b.f7656a == c0375hA && (c0375hG = c0369b.f7658c.g(null, c0375hA)) != null) {
                        c0369b.h(c0375hG);
                    }
                    if (!c0369b.d) {
                        c0369b.f7656a.e(c0369b);
                    }
                    this.f7669i--;
                }
                z5 = true;
            } else {
                z5 = false;
            }
            C0375h c0375h = c0369b.f7656a;
            if (c0375h == null || (c0375h.f7682f != 1 && c0369b.f7657b < 0.0f)) {
                z6 = false;
            }
            if (!z6) {
                return;
            } else {
                z7 = z5;
            }
        }
        if (z7) {
            return;
        }
        k(c0369b);
    }

    public final C0369b d(C0375h c0375h, C0375h c0375h2, int i2, int i4) {
        C0369b c0369bO = o();
        boolean z4 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z4 = true;
            }
            c0369bO.f7657b = i2;
        }
        if (z4) {
            c0369bO.f7658c.k(c0375h, 1.0f);
            c0369bO.f7658c.k(c0375h2, -1.0f);
        } else {
            c0369bO.f7658c.k(c0375h, -1.0f);
            c0369bO.f7658c.k(c0375h2, 1.0f);
        }
        if (i4 != 6) {
            c0369bO.a(this, i4);
        }
        c(c0369bO);
        return c0369bO;
    }

    public final void e(C0375h c0375h, int i2) {
        int i4 = c0375h.f7679b;
        if (i4 == -1) {
            C0369b c0369bO = o();
            c0369bO.f7656a = c0375h;
            float f4 = i2;
            c0375h.d = f4;
            c0369bO.f7657b = f4;
            c0369bO.d = true;
            c(c0369bO);
            return;
        }
        C0369b c0369b = this.f7666e[i4];
        if (c0369b.d) {
            c0369b.f7657b = i2;
            return;
        }
        if (c0369b.f7658c.f7648a == 0) {
            c0369b.d = true;
            c0369b.f7657b = i2;
            return;
        }
        C0369b c0369bO2 = o();
        if (i2 < 0) {
            c0369bO2.f7657b = i2 * (-1);
            c0369bO2.f7658c.k(c0375h, 1.0f);
        } else {
            c0369bO2.f7657b = i2;
            c0369bO2.f7658c.k(c0375h, -1.0f);
        }
        c(c0369bO2);
    }

    public final void f(C0375h c0375h, C0375h c0375h2, boolean z4) {
        C0369b c0369bO = o();
        C0375h c0375hP = p();
        c0375hP.f7680c = 0;
        c0369bO.e(c0375h, c0375h2, c0375hP, 0);
        if (z4) {
            l(c0369bO, (int) (c0369bO.f7658c.f(c0375hP) * (-1.0f)), 1);
        }
        c(c0369bO);
    }

    public final void g(C0375h c0375h, C0375h c0375h2, int i2, int i4) {
        C0369b c0369bO = o();
        C0375h c0375hP = p();
        c0375hP.f7680c = 0;
        c0369bO.e(c0375h, c0375h2, c0375hP, i2);
        if (i4 != 6) {
            l(c0369bO, (int) (c0369bO.f7658c.f(c0375hP) * (-1.0f)), i4);
        }
        c(c0369bO);
    }

    public final void h(C0375h c0375h, C0375h c0375h2, boolean z4) {
        C0369b c0369bO = o();
        C0375h c0375hP = p();
        c0375hP.f7680c = 0;
        c0369bO.f(c0375h, c0375h2, c0375hP, 0);
        if (z4) {
            l(c0369bO, (int) (c0369bO.f7658c.f(c0375hP) * (-1.0f)), 1);
        }
        c(c0369bO);
    }

    public final void i(C0375h c0375h, C0375h c0375h2, int i2, int i4) {
        C0369b c0369bO = o();
        C0375h c0375hP = p();
        c0375hP.f7680c = 0;
        c0369bO.f(c0375h, c0375h2, c0375hP, i2);
        if (i4 != 6) {
            l(c0369bO, (int) (c0369bO.f7658c.f(c0375hP) * (-1.0f)), i4);
        }
        c(c0369bO);
    }

    public final void j(C0375h c0375h, C0375h c0375h2, C0375h c0375h3, C0375h c0375h4, float f4) {
        C0369b c0369bO = o();
        c0369bO.c(c0375h, c0375h2, c0375h3, c0375h4, f4);
        c(c0369bO);
    }

    final void l(C0369b c0369b, int i2, int i4) {
        c0369b.f7658c.k(m(i4, null), i2);
    }

    public final C0375h m(int i2, String str) {
        if (this.f7668h + 1 >= this.d) {
            s();
        }
        C0375h c0375hA = a(4, str);
        int i4 = this.f7663a + 1;
        this.f7663a = i4;
        this.f7668h++;
        c0375hA.f7678a = i4;
        c0375hA.f7680c = i2;
        this.f7671k.f7661c[i4] = c0375hA;
        this.f7664b.b(c0375hA);
        return c0375hA;
    }

    public final C0375h n(Object obj) {
        C0375h c0375hE = null;
        if (obj == null) {
            return null;
        }
        if (this.f7668h + 1 >= this.d) {
            s();
        }
        if (obj instanceof s.d) {
            s.d dVar = (s.d) obj;
            c0375hE = dVar.e();
            if (c0375hE == null) {
                dVar.j();
                c0375hE = dVar.e();
            }
            int i2 = c0375hE.f7678a;
            if (i2 == -1 || i2 > this.f7663a || this.f7671k.f7661c[i2] == null) {
                if (i2 != -1) {
                    c0375hE.d();
                }
                int i4 = this.f7663a + 1;
                this.f7663a = i4;
                this.f7668h++;
                c0375hE.f7678a = i4;
                c0375hE.f7682f = 1;
                this.f7671k.f7661c[i4] = c0375hE;
            }
        }
        return c0375hE;
    }

    public final C0369b o() {
        C0369b c0369b = (C0369b) this.f7671k.f7659a.a();
        if (c0369b == null) {
            c0369b = new C0369b(this.f7671k);
        } else {
            c0369b.f7656a = null;
            c0369b.f7658c.c();
            c0369b.f7657b = 0.0f;
            c0369b.d = false;
        }
        C0375h.b();
        return c0369b;
    }

    public final C0375h p() {
        if (this.f7668h + 1 >= this.d) {
            s();
        }
        C0375h c0375hA = a(3, null);
        int i2 = this.f7663a + 1;
        this.f7663a = i2;
        this.f7668h++;
        c0375hA.f7678a = i2;
        this.f7671k.f7661c[i2] = c0375hA;
        return c0375hA;
    }

    public final C0370c q() {
        return this.f7671k;
    }

    public final int r(Object obj) {
        C0375h c0375hE = ((s.d) obj).e();
        if (c0375hE != null) {
            return (int) (c0375hE.d + 0.5f);
        }
        return 0;
    }

    public final void t() throws Exception {
        boolean z4;
        if (!this.f7667f) {
            u(this.f7664b);
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f7669i) {
                z4 = true;
                break;
            } else {
                if (!this.f7666e[i2].d) {
                    z4 = false;
                    break;
                }
                i2++;
            }
        }
        if (!z4) {
            u(this.f7664b);
            return;
        }
        for (int i4 = 0; i4 < this.f7669i; i4++) {
            C0369b c0369b = this.f7666e[i4];
            c0369b.f7656a.d = c0369b.f7657b;
        }
    }

    final void u(a aVar) throws Exception {
        float f4;
        boolean z4;
        y((C0369b) aVar);
        int i2 = 0;
        while (true) {
            f4 = 0.0f;
            if (i2 >= this.f7669i) {
                z4 = false;
                break;
            }
            C0369b[] c0369bArr = this.f7666e;
            if (c0369bArr[i2].f7656a.f7682f != 1 && c0369bArr[i2].f7657b < 0.0f) {
                z4 = true;
                break;
            }
            i2++;
        }
        if (z4) {
            boolean z5 = false;
            int i4 = 0;
            while (!z5) {
                i4++;
                float f5 = Float.MAX_VALUE;
                int i5 = -1;
                int i6 = -1;
                int i7 = 0;
                int i8 = 0;
                while (i7 < this.f7669i) {
                    C0369b c0369b = this.f7666e[i7];
                    if (c0369b.f7656a.f7682f != 1 && !c0369b.d && c0369b.f7657b < f4) {
                        int i9 = 1;
                        while (i9 < this.f7668h) {
                            C0375h c0375h = this.f7671k.f7661c[i9];
                            float f6 = c0369b.f7658c.f(c0375h);
                            if (f6 > f4) {
                                for (int i10 = 0; i10 < 7; i10++) {
                                    float f7 = c0375h.f7681e[i10] / f6;
                                    if ((f7 < f5 && i10 == i8) || i10 > i8) {
                                        i8 = i10;
                                        f5 = f7;
                                        i5 = i7;
                                        i6 = i9;
                                    }
                                }
                            }
                            i9++;
                            f4 = 0.0f;
                        }
                    }
                    i7++;
                    f4 = 0.0f;
                }
                if (i5 != -1) {
                    C0369b c0369b2 = this.f7666e[i5];
                    c0369b2.f7656a.f7679b = -1;
                    c0369b2.h(this.f7671k.f7661c[i6]);
                    C0375h c0375h2 = c0369b2.f7656a;
                    c0375h2.f7679b = i5;
                    c0375h2.e(c0369b2);
                } else {
                    z5 = true;
                }
                if (i4 > this.f7668h / 2) {
                    z5 = true;
                }
                f4 = 0.0f;
            }
        }
        v(aVar);
        for (int i11 = 0; i11 < this.f7669i; i11++) {
            C0369b c0369b3 = this.f7666e[i11];
            c0369b3.f7656a.d = c0369b3.f7657b;
        }
    }

    public final void x() {
        C0370c c0370c;
        int i2 = 0;
        while (true) {
            c0370c = this.f7671k;
            C0375h[] c0375hArr = c0370c.f7661c;
            if (i2 >= c0375hArr.length) {
                break;
            }
            C0375h c0375h = c0375hArr[i2];
            if (c0375h != null) {
                c0375h.d();
            }
            i2++;
        }
        c0370c.f7660b.c(this.f7672l, this.f7673m);
        this.f7673m = 0;
        Arrays.fill(this.f7671k.f7661c, (Object) null);
        this.f7663a = 0;
        C0371d c0371d = this.f7664b;
        c0371d.f7658c.c();
        c0371d.f7656a = null;
        c0371d.f7657b = 0.0f;
        this.f7668h = 1;
        for (int i4 = 0; i4 < this.f7669i; i4++) {
            Objects.requireNonNull(this.f7666e[i4]);
        }
        w();
        this.f7669i = 0;
    }
}
