package r;

import java.util.Arrays;

/* renamed from: r.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0368a {

    /* renamed from: b, reason: collision with root package name */
    private final C0369b f7649b;

    /* renamed from: c, reason: collision with root package name */
    private final C0370c f7650c;

    /* renamed from: a, reason: collision with root package name */
    int f7648a = 0;
    private int d = 8;

    /* renamed from: e, reason: collision with root package name */
    private int[] f7651e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    private int[] f7652f = new int[8];
    private float[] g = new float[8];

    /* renamed from: h, reason: collision with root package name */
    private int f7653h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f7654i = -1;

    /* renamed from: j, reason: collision with root package name */
    private boolean f7655j = false;

    C0368a(C0369b c0369b, C0370c c0370c) {
        this.f7649b = c0369b;
        this.f7650c = c0370c;
    }

    final void a(C0375h c0375h, float f4, boolean z4) {
        if (f4 == 0.0f) {
            return;
        }
        int i2 = this.f7653h;
        if (i2 == -1) {
            this.f7653h = 0;
            this.g[0] = f4;
            this.f7651e[0] = c0375h.f7678a;
            this.f7652f[0] = -1;
            c0375h.f7684i++;
            c0375h.a(this.f7649b);
            this.f7648a++;
            if (this.f7655j) {
                return;
            }
            int i4 = this.f7654i + 1;
            this.f7654i = i4;
            int[] iArr = this.f7651e;
            if (i4 >= iArr.length) {
                this.f7655j = true;
                this.f7654i = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i2 != -1 && i6 < this.f7648a; i6++) {
            int[] iArr2 = this.f7651e;
            int i7 = iArr2[i2];
            int i8 = c0375h.f7678a;
            if (i7 == i8) {
                float[] fArr = this.g;
                fArr[i2] = fArr[i2] + f4;
                if (fArr[i2] == 0.0f) {
                    if (i2 == this.f7653h) {
                        this.f7653h = this.f7652f[i2];
                    } else {
                        int[] iArr3 = this.f7652f;
                        iArr3[i5] = iArr3[i2];
                    }
                    if (z4) {
                        c0375h.c(this.f7649b);
                    }
                    if (this.f7655j) {
                        this.f7654i = i2;
                    }
                    c0375h.f7684i--;
                    this.f7648a--;
                    return;
                }
                return;
            }
            if (iArr2[i2] < i8) {
                i5 = i2;
            }
            i2 = this.f7652f[i2];
        }
        int length = this.f7654i;
        int i9 = length + 1;
        if (this.f7655j) {
            int[] iArr4 = this.f7651e;
            if (iArr4[length] != -1) {
                length = iArr4.length;
            }
        } else {
            length = i9;
        }
        int[] iArr5 = this.f7651e;
        if (length >= iArr5.length && this.f7648a < iArr5.length) {
            int i10 = 0;
            while (true) {
                int[] iArr6 = this.f7651e;
                if (i10 >= iArr6.length) {
                    break;
                }
                if (iArr6[i10] == -1) {
                    length = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr7 = this.f7651e;
        if (length >= iArr7.length) {
            length = iArr7.length;
            int i11 = this.d * 2;
            this.d = i11;
            this.f7655j = false;
            this.f7654i = length - 1;
            this.g = Arrays.copyOf(this.g, i11);
            this.f7651e = Arrays.copyOf(this.f7651e, this.d);
            this.f7652f = Arrays.copyOf(this.f7652f, this.d);
        }
        this.f7651e[length] = c0375h.f7678a;
        this.g[length] = f4;
        if (i5 != -1) {
            int[] iArr8 = this.f7652f;
            iArr8[length] = iArr8[i5];
            iArr8[i5] = length;
        } else {
            this.f7652f[length] = this.f7653h;
            this.f7653h = length;
        }
        c0375h.f7684i++;
        c0375h.a(this.f7649b);
        this.f7648a++;
        if (!this.f7655j) {
            this.f7654i++;
        }
        int i12 = this.f7654i;
        int[] iArr9 = this.f7651e;
        if (i12 >= iArr9.length) {
            this.f7655j = true;
            this.f7654i = iArr9.length - 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final C0375h b() {
        int i2 = this.f7653h;
        C0375h c0375h = null;
        C0375h c0375h2 = null;
        boolean z4 = false;
        boolean z5 = false;
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i4 = 0; i2 != -1 && i4 < this.f7648a; i4++) {
            float[] fArr = this.g;
            float f6 = fArr[i2];
            C0375h c0375h3 = this.f7650c.f7661c[this.f7651e[i2]];
            if (f6 < 0.0f) {
                if (f6 > -0.001f) {
                    fArr[i2] = 0.0f;
                    c0375h3.c(this.f7649b);
                    f6 = 0.0f;
                }
            } else if (f6 < 0.001f) {
                fArr[i2] = 0.0f;
                c0375h3.c(this.f7649b);
                f6 = 0.0f;
            }
            if (f6 != 0.0f) {
                boolean z6 = true;
                if (c0375h3.f7682f == 1) {
                    if (c0375h2 == null) {
                        if (c0375h3.f7684i > 1) {
                            z6 = false;
                        }
                        z4 = z6;
                        f4 = f6;
                        c0375h2 = c0375h3;
                    } else {
                        if (f4 > f6) {
                            if (c0375h3.f7684i > 1) {
                            }
                        } else if (!z4) {
                            if (c0375h3.f7684i <= 1) {
                            }
                        }
                        z4 = z6;
                        f4 = f6;
                        c0375h2 = c0375h3;
                    }
                } else if (c0375h2 == null && f6 < 0.0f) {
                    if (c0375h == null) {
                        if (c0375h3.f7684i > 1) {
                            z6 = false;
                        }
                        z5 = z6;
                        f5 = f6;
                        c0375h = c0375h3;
                    } else {
                        if (f5 > f6) {
                            if (c0375h3.f7684i > 1) {
                            }
                        } else if (!z5) {
                            if (c0375h3.f7684i <= 1) {
                            }
                        }
                        z5 = z6;
                        f5 = f6;
                        c0375h = c0375h3;
                    }
                }
            }
            i2 = this.f7652f[i2];
        }
        return c0375h2 != null ? c0375h2 : c0375h;
    }

    public final void c() {
        int i2 = this.f7653h;
        for (int i4 = 0; i2 != -1 && i4 < this.f7648a; i4++) {
            C0375h c0375h = this.f7650c.f7661c[this.f7651e[i2]];
            if (c0375h != null) {
                c0375h.c(this.f7649b);
            }
            i2 = this.f7652f[i2];
        }
        this.f7653h = -1;
        this.f7654i = -1;
        this.f7655j = false;
        this.f7648a = 0;
    }

    final boolean d(C0375h c0375h) {
        int i2 = this.f7653h;
        if (i2 == -1) {
            return false;
        }
        for (int i4 = 0; i2 != -1 && i4 < this.f7648a; i4++) {
            if (this.f7651e[i2] == c0375h.f7678a) {
                return true;
            }
            i2 = this.f7652f[i2];
        }
        return false;
    }

    final void e(float f4) {
        int i2 = this.f7653h;
        for (int i4 = 0; i2 != -1 && i4 < this.f7648a; i4++) {
            float[] fArr = this.g;
            fArr[i2] = fArr[i2] / f4;
            i2 = this.f7652f[i2];
        }
    }

    public final float f(C0375h c0375h) {
        int i2 = this.f7653h;
        for (int i4 = 0; i2 != -1 && i4 < this.f7648a; i4++) {
            if (this.f7651e[i2] == c0375h.f7678a) {
                return this.g[i2];
            }
            i2 = this.f7652f[i2];
        }
        return 0.0f;
    }

    final C0375h g(boolean[] zArr, C0375h c0375h) {
        int i2;
        int i4 = this.f7653h;
        C0375h c0375h2 = null;
        float f4 = 0.0f;
        for (int i5 = 0; i4 != -1 && i5 < this.f7648a; i5++) {
            float[] fArr = this.g;
            if (fArr[i4] < 0.0f) {
                C0375h c0375h3 = this.f7650c.f7661c[this.f7651e[i4]];
                if ((zArr == null || !zArr[c0375h3.f7678a]) && c0375h3 != c0375h && ((i2 = c0375h3.f7682f) == 3 || i2 == 4)) {
                    float f5 = fArr[i4];
                    if (f5 < f4) {
                        f4 = f5;
                        c0375h2 = c0375h3;
                    }
                }
            }
            i4 = this.f7652f[i4];
        }
        return c0375h2;
    }

    final C0375h h(int i2) {
        int i4 = this.f7653h;
        for (int i5 = 0; i4 != -1 && i5 < this.f7648a; i5++) {
            if (i5 == i2) {
                return this.f7650c.f7661c[this.f7651e[i4]];
            }
            i4 = this.f7652f[i4];
        }
        return null;
    }

    final float i(int i2) {
        int i4 = this.f7653h;
        for (int i5 = 0; i4 != -1 && i5 < this.f7648a; i5++) {
            if (i5 == i2) {
                return this.g[i4];
            }
            i4 = this.f7652f[i4];
        }
        return 0.0f;
    }

    final void j() {
        int i2 = this.f7653h;
        for (int i4 = 0; i2 != -1 && i4 < this.f7648a; i4++) {
            float[] fArr = this.g;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f7652f[i2];
        }
    }

    public final void k(C0375h c0375h, float f4) {
        if (f4 == 0.0f) {
            l(c0375h, true);
            return;
        }
        int i2 = this.f7653h;
        if (i2 == -1) {
            this.f7653h = 0;
            this.g[0] = f4;
            this.f7651e[0] = c0375h.f7678a;
            this.f7652f[0] = -1;
            c0375h.f7684i++;
            c0375h.a(this.f7649b);
            this.f7648a++;
            if (this.f7655j) {
                return;
            }
            int i4 = this.f7654i + 1;
            this.f7654i = i4;
            int[] iArr = this.f7651e;
            if (i4 >= iArr.length) {
                this.f7655j = true;
                this.f7654i = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i2 != -1 && i6 < this.f7648a; i6++) {
            int[] iArr2 = this.f7651e;
            int i7 = iArr2[i2];
            int i8 = c0375h.f7678a;
            if (i7 == i8) {
                this.g[i2] = f4;
                return;
            }
            if (iArr2[i2] < i8) {
                i5 = i2;
            }
            i2 = this.f7652f[i2];
        }
        int length = this.f7654i;
        int i9 = length + 1;
        if (this.f7655j) {
            int[] iArr3 = this.f7651e;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i9;
        }
        int[] iArr4 = this.f7651e;
        if (length >= iArr4.length && this.f7648a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f7651e;
                if (i10 >= iArr5.length) {
                    break;
                }
                if (iArr5[i10] == -1) {
                    length = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr6 = this.f7651e;
        if (length >= iArr6.length) {
            length = iArr6.length;
            int i11 = this.d * 2;
            this.d = i11;
            this.f7655j = false;
            this.f7654i = length - 1;
            this.g = Arrays.copyOf(this.g, i11);
            this.f7651e = Arrays.copyOf(this.f7651e, this.d);
            this.f7652f = Arrays.copyOf(this.f7652f, this.d);
        }
        this.f7651e[length] = c0375h.f7678a;
        this.g[length] = f4;
        if (i5 != -1) {
            int[] iArr7 = this.f7652f;
            iArr7[length] = iArr7[i5];
            iArr7[i5] = length;
        } else {
            this.f7652f[length] = this.f7653h;
            this.f7653h = length;
        }
        c0375h.f7684i++;
        c0375h.a(this.f7649b);
        int i12 = this.f7648a + 1;
        this.f7648a = i12;
        if (!this.f7655j) {
            this.f7654i++;
        }
        int[] iArr8 = this.f7651e;
        if (i12 >= iArr8.length) {
            this.f7655j = true;
        }
        if (this.f7654i >= iArr8.length) {
            this.f7655j = true;
            this.f7654i = iArr8.length - 1;
        }
    }

    public final float l(C0375h c0375h, boolean z4) {
        int i2 = this.f7653h;
        if (i2 == -1) {
            return 0.0f;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.f7648a) {
            if (this.f7651e[i2] == c0375h.f7678a) {
                if (i2 == this.f7653h) {
                    this.f7653h = this.f7652f[i2];
                } else {
                    int[] iArr = this.f7652f;
                    iArr[i5] = iArr[i2];
                }
                if (z4) {
                    c0375h.c(this.f7649b);
                }
                c0375h.f7684i--;
                this.f7648a--;
                this.f7651e[i2] = -1;
                if (this.f7655j) {
                    this.f7654i = i2;
                }
                return this.g[i2];
            }
            i4++;
            i5 = i2;
            i2 = this.f7652f[i2];
        }
        return 0.0f;
    }

    final void m(C0369b c0369b, C0369b c0369b2) {
        int i2 = this.f7653h;
        while (true) {
            for (int i4 = 0; i2 != -1 && i4 < this.f7648a; i4++) {
                int i5 = this.f7651e[i2];
                C0375h c0375h = c0369b2.f7656a;
                if (i5 == c0375h.f7678a) {
                    float f4 = this.g[i2];
                    l(c0375h, false);
                    C0368a c0368a = c0369b2.f7658c;
                    int i6 = c0368a.f7653h;
                    for (int i7 = 0; i6 != -1 && i7 < c0368a.f7648a; i7++) {
                        a(this.f7650c.f7661c[c0368a.f7651e[i6]], c0368a.g[i6] * f4, false);
                        i6 = c0368a.f7652f[i6];
                    }
                    c0369b.f7657b = (c0369b2.f7657b * f4) + c0369b.f7657b;
                    i2 = this.f7653h;
                } else {
                    i2 = this.f7652f[i2];
                }
            }
            return;
        }
    }

    final void n(C0369b c0369b, C0369b[] c0369bArr) {
        int i2 = this.f7653h;
        while (true) {
            for (int i4 = 0; i2 != -1 && i4 < this.f7648a; i4++) {
                C0375h c0375h = this.f7650c.f7661c[this.f7651e[i2]];
                if (c0375h.f7679b != -1) {
                    float f4 = this.g[i2];
                    l(c0375h, true);
                    C0369b c0369b2 = c0369bArr[c0375h.f7679b];
                    if (!c0369b2.d) {
                        C0368a c0368a = c0369b2.f7658c;
                        int i5 = c0368a.f7653h;
                        for (int i6 = 0; i5 != -1 && i6 < c0368a.f7648a; i6++) {
                            a(this.f7650c.f7661c[c0368a.f7651e[i5]], c0368a.g[i5] * f4, true);
                            i5 = c0368a.f7652f[i5];
                        }
                    }
                    c0369b.f7657b = (c0369b2.f7657b * f4) + c0369b.f7657b;
                    c0369b2.f7656a.c(c0369b);
                    i2 = this.f7653h;
                } else {
                    i2 = this.f7652f[i2];
                }
            }
            return;
        }
    }

    public final String toString() {
        int i2 = this.f7653h;
        String string = "";
        for (int i4 = 0; i2 != -1 && i4 < this.f7648a; i4++) {
            StringBuilder sbD = D2.e.d(D2.e.c(string, " -> "));
            sbD.append(this.g[i2]);
            sbD.append(" : ");
            StringBuilder sbD2 = D2.e.d(sbD.toString());
            sbD2.append(this.f7650c.f7661c[this.f7651e[i2]]);
            string = sbD2.toString();
            i2 = this.f7652f[i2];
        }
        return string;
    }
}
