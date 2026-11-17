package r;

import java.util.Arrays;

/* renamed from: r.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0375h {
    public float d;

    /* renamed from: f, reason: collision with root package name */
    int f7682f;

    /* renamed from: a, reason: collision with root package name */
    public int f7678a = -1;

    /* renamed from: b, reason: collision with root package name */
    int f7679b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f7680c = 0;

    /* renamed from: e, reason: collision with root package name */
    float[] f7681e = new float[7];
    C0369b[] g = new C0369b[8];

    /* renamed from: h, reason: collision with root package name */
    int f7683h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f7684i = 0;

    public C0375h(int i2) {
        this.f7682f = i2;
    }

    static void b() {
    }

    public final void a(C0369b c0369b) {
        int i2 = 0;
        while (true) {
            int i4 = this.f7683h;
            if (i2 >= i4) {
                C0369b[] c0369bArr = this.g;
                if (i4 >= c0369bArr.length) {
                    this.g = (C0369b[]) Arrays.copyOf(c0369bArr, c0369bArr.length * 2);
                }
                C0369b[] c0369bArr2 = this.g;
                int i5 = this.f7683h;
                c0369bArr2[i5] = c0369b;
                this.f7683h = i5 + 1;
                return;
            }
            if (this.g[i2] == c0369b) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void c(C0369b c0369b) {
        int i2 = this.f7683h;
        for (int i4 = 0; i4 < i2; i4++) {
            if (this.g[i4] == c0369b) {
                for (int i5 = 0; i5 < (i2 - i4) - 1; i5++) {
                    C0369b[] c0369bArr = this.g;
                    int i6 = i4 + i5;
                    c0369bArr[i6] = c0369bArr[i6 + 1];
                }
                this.f7683h--;
                return;
            }
        }
    }

    public final void d() {
        this.f7682f = 5;
        this.f7680c = 0;
        this.f7678a = -1;
        this.f7679b = -1;
        this.d = 0.0f;
        this.f7683h = 0;
        this.f7684i = 0;
    }

    public final void e(C0369b c0369b) {
        int i2 = this.f7683h;
        for (int i4 = 0; i4 < i2; i4++) {
            C0369b[] c0369bArr = this.g;
            c0369bArr[i4].f7658c.m(c0369bArr[i4], c0369b);
        }
        this.f7683h = 0;
    }

    public final String toString() {
        return "null";
    }
}
