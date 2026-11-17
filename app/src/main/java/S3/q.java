package S3;

import miuix.appcompat.internal.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private int f1517a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f1518b = new int[10];

    public final int a(int i2) {
        return this.f1518b[i2];
    }

    public final int b() {
        if ((this.f1517a & 2) != 0) {
            return this.f1518b[1];
        }
        return -1;
    }

    public final int c() {
        return (this.f1517a & 128) != 0 ? this.f1518b[7] : MenuBuilder.USER_MASK;
    }

    public final int d() {
        if ((this.f1517a & 16) != 0) {
            return this.f1518b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int e(int i2) {
        return (this.f1517a & 32) != 0 ? this.f1518b[5] : i2;
    }

    public final boolean f(int i2) {
        return (this.f1517a & (1 << i2)) != 0;
    }

    public final void g(q qVar) {
        f3.c.d(qVar, "other");
        int i2 = 0;
        while (i2 < 10) {
            int i4 = i2 + 1;
            if (((1 << i2) & qVar.f1517a) != 0) {
                h(i2, qVar.f1518b[i2]);
            }
            i2 = i4;
        }
    }

    public final q h(int i2, int i4) {
        if (i2 >= 0) {
            int[] iArr = this.f1518b;
            if (i2 < iArr.length) {
                this.f1517a = (1 << i2) | this.f1517a;
                iArr[i2] = i4;
            }
        }
        return this;
    }

    public final int i() {
        return Integer.bitCount(this.f1517a);
    }
}
