package X3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class v extends g {

    /* renamed from: n, reason: collision with root package name */
    private final transient byte[][] f1887n;

    /* renamed from: o, reason: collision with root package name */
    private final transient int[] f1888o;

    public v(byte[][] bArr, int[] iArr) {
        super(g.f1848m.f());
        this.f1887n = bArr;
        this.f1888o = iArr;
    }

    private final g v() {
        return new g(u());
    }

    @Override // X3.g
    public final String d() {
        return v().d();
    }

    @Override // X3.g
    public final g e(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = this.f1887n.length;
        int i2 = 0;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.f1888o;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            messageDigest.update(this.f1887n[i2], i5, i6 - i4);
            i2++;
            i4 = i6;
        }
        byte[] bArrDigest = messageDigest.digest();
        f3.c.c(bArrDigest, "digestBytes");
        return new g(bArrDigest);
    }

    @Override // X3.g
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (gVar.h() != h() || !m(gVar, h())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // X3.g
    public final int h() {
        return this.f1888o[this.f1887n.length - 1];
    }

    @Override // X3.g
    public final int hashCode() {
        int iG = g();
        if (iG != 0) {
            return iG;
        }
        int length = this.f1887n.length;
        int i2 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i2 < length) {
            int[] iArr = this.f1888o;
            int i6 = iArr[length + i2];
            int i7 = iArr[i2];
            byte[] bArr = this.f1887n[i2];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr[i6];
                i6++;
            }
            i2++;
            i5 = i7;
        }
        n(i4);
        return i4;
    }

    @Override // X3.g
    public final String i() {
        return v().i();
    }

    @Override // X3.g
    public final byte[] j() {
        return u();
    }

    @Override // X3.g
    public final byte k(int i2) {
        n.d(this.f1888o[this.f1887n.length - 1], i2, 1L);
        int iJ = Y1.a.j(this, i2);
        int i4 = iJ == 0 ? 0 : this.f1888o[iJ - 1];
        int[] iArr = this.f1888o;
        byte[][] bArr = this.f1887n;
        return bArr[iJ][(i2 - i4) + iArr[bArr.length + iJ]];
    }

    @Override // X3.g
    public final boolean l(int i2, byte[] bArr, int i4, int i5) {
        f3.c.d(bArr, "other");
        if (i2 < 0 || i2 > h() - i5 || i4 < 0 || i4 > bArr.length - i5) {
            return false;
        }
        int i6 = i5 + i2;
        int iJ = Y1.a.j(this, i2);
        while (i2 < i6) {
            int i7 = iJ == 0 ? 0 : this.f1888o[iJ - 1];
            int[] iArr = this.f1888o;
            int i8 = iArr[iJ] - i7;
            int i9 = iArr[this.f1887n.length + iJ];
            int iMin = Math.min(i6, i8 + i7) - i2;
            if (!n.a(this.f1887n[iJ], (i2 - i7) + i9, bArr, i4, iMin)) {
                return false;
            }
            i4 += iMin;
            i2 += iMin;
            iJ++;
        }
        return true;
    }

    @Override // X3.g
    public final boolean m(g gVar, int i2) {
        f3.c.d(gVar, "other");
        if (h() - i2 < 0) {
            return false;
        }
        int i4 = i2 + 0;
        int iJ = Y1.a.j(this, 0);
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = iJ == 0 ? 0 : this.f1888o[iJ - 1];
            int[] iArr = this.f1888o;
            int i8 = iArr[iJ] - i7;
            int i9 = iArr[this.f1887n.length + iJ];
            int iMin = Math.min(i4, i8 + i7) - i5;
            if (!gVar.l(i6, this.f1887n[iJ], (i5 - i7) + i9, iMin)) {
                return false;
            }
            i6 += iMin;
            i5 += iMin;
            iJ++;
        }
        return true;
    }

    @Override // X3.g
    public final g p() {
        return v().p();
    }

    @Override // X3.g
    public final void r(d dVar, int i2) {
        f3.c.d(dVar, "buffer");
        int i4 = i2 + 0;
        int iJ = Y1.a.j(this, 0);
        int i5 = 0;
        while (i5 < i4) {
            int i6 = iJ == 0 ? 0 : this.f1888o[iJ - 1];
            int[] iArr = this.f1888o;
            int i7 = iArr[iJ] - i6;
            int i8 = iArr[this.f1887n.length + iJ];
            int iMin = Math.min(i4, i7 + i6) - i5;
            int i9 = (i5 - i6) + i8;
            t tVar = new t(this.f1887n[iJ], i9, i9 + iMin, true);
            t tVar2 = dVar.f1845i;
            if (tVar2 == null) {
                tVar.g = tVar;
                tVar.f1883f = tVar;
                dVar.f1845i = tVar;
            } else {
                t tVar3 = tVar2.g;
                f3.c.b(tVar3);
                tVar3.b(tVar);
            }
            i5 += iMin;
            iJ++;
        }
        dVar.m0(dVar.n0() + i2);
    }

    public final int[] s() {
        return this.f1888o;
    }

    public final byte[][] t() {
        return this.f1887n;
    }

    @Override // X3.g
    public final String toString() {
        return v().toString();
    }

    public final byte[] u() {
        byte[] bArr = new byte[h()];
        int length = this.f1887n.length;
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < length) {
            int[] iArr = this.f1888o;
            int i6 = iArr[length + i2];
            int i7 = iArr[i2];
            int i8 = i7 - i4;
            Z2.d.b(this.f1887n[i2], bArr, i5, i6, i6 + i8);
            i5 += i8;
            i2++;
            i4 = i7;
        }
        return bArr;
    }
}
