package X3;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class d implements f, e, Cloneable, ByteChannel {

    /* renamed from: i, reason: collision with root package name */
    public t f1845i;

    /* renamed from: j, reason: collision with root package name */
    private long f1846j;

    public final d A0(int i2) {
        String str;
        if (i2 < 128) {
            u0(i2);
        } else if (i2 < 2048) {
            t tVarP0 = p0(2);
            byte[] bArr = tVarP0.f1879a;
            int i4 = tVarP0.f1881c;
            bArr[i4] = (byte) ((i2 >> 6) | 192);
            bArr[i4 + 1] = (byte) ((i2 & 63) | 128);
            tVarP0.f1881c = i4 + 2;
            this.f1846j += 2;
        } else {
            int i5 = 0;
            if (55296 <= i2 && i2 <= 57343) {
                u0(63);
            } else if (i2 < 65536) {
                t tVarP02 = p0(3);
                byte[] bArr2 = tVarP02.f1879a;
                int i6 = tVarP02.f1881c;
                bArr2[i6] = (byte) ((i2 >> 12) | 224);
                bArr2[i6 + 1] = (byte) (((i2 >> 6) & 63) | 128);
                bArr2[i6 + 2] = (byte) ((i2 & 63) | 128);
                tVarP02.f1881c = i6 + 3;
                this.f1846j += 3;
            } else {
                if (i2 > 1114111) {
                    if (i2 != 0) {
                        char[] cArr = {Y3.b.b()[(i2 >> 28) & 15], Y3.b.b()[(i2 >> 24) & 15], Y3.b.b()[(i2 >> 20) & 15], Y3.b.b()[(i2 >> 16) & 15], Y3.b.b()[(i2 >> 12) & 15], Y3.b.b()[(i2 >> 8) & 15], Y3.b.b()[(i2 >> 4) & 15], Y3.b.b()[i2 & 15]};
                        while (i5 < 8 && cArr[i5] == '0') {
                            i5++;
                        }
                        if (i5 < 0) {
                            throw new IndexOutOfBoundsException("startIndex: " + i5 + ", endIndex: 8, size: 8");
                        }
                        if (i5 > 8) {
                            throw new IllegalArgumentException("startIndex: " + i5 + " > endIndex: 8");
                        }
                        str = new String(cArr, i5, 8 - i5);
                    } else {
                        str = "0";
                    }
                    throw new IllegalArgumentException(f3.c.h("Unexpected code point: 0x", str));
                }
                t tVarP03 = p0(4);
                byte[] bArr3 = tVarP03.f1879a;
                int i7 = tVarP03.f1881c;
                bArr3[i7] = (byte) ((i2 >> 18) | 240);
                bArr3[i7 + 1] = (byte) (((i2 >> 12) & 63) | 128);
                bArr3[i7 + 2] = (byte) (((i2 >> 6) & 63) | 128);
                bArr3[i7 + 3] = (byte) ((i2 & 63) | 128);
                tVarP03.f1881c = i7 + 4;
                this.f1846j += 4;
            }
        }
        return this;
    }

    @Override // X3.e
    public final /* bridge */ /* synthetic */ e D(g gVar) {
        q0(gVar);
        return this;
    }

    @Override // X3.f
    public final int E(p pVar) throws EOFException {
        f3.c.d(pVar, "options");
        int iC = Y3.a.c(this, pVar, false);
        if (iC == -1) {
            return -1;
        }
        a(pVar.g()[iC].h());
        return iC;
    }

    @Override // X3.e
    public final /* bridge */ /* synthetic */ e F(int i2) {
        w0(i2);
        return this;
    }

    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final d clone() {
        d dVar = new d();
        if (this.f1846j != 0) {
            t tVar = this.f1845i;
            f3.c.b(tVar);
            t tVarC = tVar.c();
            dVar.f1845i = tVarC;
            tVarC.g = tVarC;
            tVarC.f1883f = tVarC;
            for (t tVar2 = tVar.f1883f; tVar2 != tVar; tVar2 = tVar2.f1883f) {
                t tVar3 = tVarC.g;
                f3.c.b(tVar3);
                f3.c.b(tVar2);
                tVar3.b(tVar2.c());
            }
            dVar.f1846j = this.f1846j;
        }
        return dVar;
    }

    public final long I() {
        long j2 = this.f1846j;
        if (j2 == 0) {
            return 0L;
        }
        t tVar = this.f1845i;
        f3.c.b(tVar);
        t tVar2 = tVar.g;
        f3.c.b(tVar2);
        if (tVar2.f1881c < 8192 && tVar2.f1882e) {
            j2 -= r2 - tVar2.f1880b;
        }
        return j2;
    }

    @Override // X3.f
    public final String N() throws EOFException {
        return t(Long.MAX_VALUE);
    }

    @Override // X3.f
    public final byte[] P() {
        return Z(this.f1846j);
    }

    @Override // X3.f
    public final void Q(long j2) throws EOFException {
        if (this.f1846j < j2) {
            throw new EOFException();
        }
    }

    @Override // X3.e
    public final /* bridge */ /* synthetic */ e S(String str) {
        y0(str);
        return this;
    }

    @Override // X3.y
    public final long U(d dVar, long j2) {
        f3.c.d(dVar, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(f3.c.h("byteCount < 0: ", Long.valueOf(j2)).toString());
        }
        long j4 = this.f1846j;
        if (j4 == 0) {
            return -1L;
        }
        if (j2 > j4) {
            j2 = j4;
        }
        dVar.w(this, j2);
        return j2;
    }

    @Override // X3.f
    public final boolean V() {
        return this.f1846j == 0;
    }

    @Override // X3.e
    public final /* bridge */ /* synthetic */ e X(int i2) {
        u0(i2);
        return this;
    }

    @Override // X3.f
    public final byte[] Z(long j2) throws EOFException {
        int iMin;
        int i2 = 0;
        if (!(j2 >= 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(f3.c.h("byteCount: ", Long.valueOf(j2)).toString());
        }
        if (this.f1846j < j2) {
            throw new EOFException();
        }
        int i4 = (int) j2;
        byte[] bArr = new byte[i4];
        while (i2 < i4) {
            int i5 = i4 - i2;
            n.d(i4, i2, i5);
            t tVar = this.f1845i;
            if (tVar == null) {
                iMin = -1;
            } else {
                iMin = Math.min(i5, tVar.f1881c - tVar.f1880b);
                byte[] bArr2 = tVar.f1879a;
                int i6 = tVar.f1880b;
                Z2.d.b(bArr2, bArr, i2, i6, i6 + iMin);
                int i7 = tVar.f1880b + iMin;
                tVar.f1880b = i7;
                this.f1846j -= iMin;
                if (i7 == tVar.f1881c) {
                    this.f1845i = tVar.a();
                    u.b(tVar);
                }
            }
            if (iMin == -1) {
                throw new EOFException();
            }
            i2 += iMin;
        }
        return bArr;
    }

    @Override // X3.f
    public final void a(long j2) throws EOFException {
        while (j2 > 0) {
            t tVar = this.f1845i;
            if (tVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j2, tVar.f1881c - tVar.f1880b);
            long j4 = iMin;
            this.f1846j -= j4;
            j2 -= j4;
            int i2 = tVar.f1880b + iMin;
            tVar.f1880b = i2;
            if (i2 == tVar.f1881c) {
                this.f1845i = tVar.a();
                u.b(tVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1 A[EDGE_INSN: B:44:0x00b1->B:38:0x00b1 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    @Override // X3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a0() throws EOFException {
        int i2;
        if (this.f1846j == 0) {
            throw new EOFException();
        }
        int i4 = 0;
        boolean z4 = false;
        long j2 = 0;
        do {
            t tVar = this.f1845i;
            f3.c.b(tVar);
            byte[] bArr = tVar.f1879a;
            int i5 = tVar.f1880b;
            int i6 = tVar.f1881c;
            while (i5 < i6) {
                byte b2 = bArr[i5];
                byte b4 = (byte) 48;
                if (b2 < b4 || b2 > ((byte) 57)) {
                    byte b5 = (byte) 97;
                    if ((b2 >= b5 && b2 <= ((byte) 102)) || (b2 >= (b5 = (byte) 65) && b2 <= ((byte) 70))) {
                        i2 = (b2 - b5) + 10;
                    } else {
                        if (i4 == 0) {
                            throw new NumberFormatException(f3.c.h("Expected leading [0-9a-fA-F] character but was 0x", new String(new char[]{Y3.b.b()[(b2 >> 4) & 15], Y3.b.b()[b2 & 15]})));
                        }
                        z4 = true;
                        if (i5 != i6) {
                            this.f1845i = tVar.a();
                            u.b(tVar);
                        } else {
                            tVar.f1880b = i5;
                        }
                        if (!z4) {
                            break;
                        }
                    }
                } else {
                    i2 = b2 - b4;
                }
                if (((-1152921504606846976L) & j2) != 0) {
                    d dVarM = new d().m(j2);
                    dVarM.u0(b2);
                    throw new NumberFormatException(f3.c.h("Number too large: ", dVarM.k0()));
                }
                j2 = (j2 << 4) | i2;
                i5++;
                i4++;
            }
            if (i5 != i6) {
            }
            if (!z4) {
            }
        } while (this.f1845i != null);
        this.f1846j -= i4;
        return j2;
    }

    @Override // X3.f, X3.e
    public final d b() {
        return this;
    }

    @Override // X3.y
    public final z c() {
        return z.d;
    }

    @Override // X3.f
    public final String c0(Charset charset) {
        return j0(this.f1846j, charset);
    }

    @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // X3.e
    public final /* bridge */ /* synthetic */ e d(byte[] bArr) {
        r0(bArr);
        return this;
    }

    public final d e0(d dVar, long j2, long j4) {
        f3.c.d(dVar, "out");
        n.d(this.f1846j, j2, j4);
        if (j4 != 0) {
            dVar.f1846j += j4;
            t tVar = this.f1845i;
            while (true) {
                f3.c.b(tVar);
                int i2 = tVar.f1881c;
                int i4 = tVar.f1880b;
                if (j2 < i2 - i4) {
                    break;
                }
                j2 -= i2 - i4;
                tVar = tVar.f1883f;
            }
            while (j4 > 0) {
                f3.c.b(tVar);
                t tVarC = tVar.c();
                int i5 = tVarC.f1880b + ((int) j2);
                tVarC.f1880b = i5;
                tVarC.f1881c = Math.min(i5 + ((int) j4), tVarC.f1881c);
                t tVar2 = dVar.f1845i;
                if (tVar2 == null) {
                    tVarC.g = tVarC;
                    tVarC.f1883f = tVarC;
                    dVar.f1845i = tVarC;
                } else {
                    f3.c.b(tVar2);
                    t tVar3 = tVar2.g;
                    f3.c.b(tVar3);
                    tVar3.b(tVarC);
                }
                j4 -= tVarC.f1881c - tVarC.f1880b;
                tVar = tVar.f1883f;
                j2 = 0;
            }
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            long j2 = this.f1846j;
            d dVar = (d) obj;
            if (j2 != dVar.f1846j) {
                return false;
            }
            if (j2 != 0) {
                t tVar = this.f1845i;
                f3.c.b(tVar);
                t tVar2 = dVar.f1845i;
                f3.c.b(tVar2);
                int i2 = tVar.f1880b;
                int i4 = tVar2.f1880b;
                long j4 = 0;
                while (j4 < this.f1846j) {
                    long jMin = Math.min(tVar.f1881c - i2, tVar2.f1881c - i4);
                    if (0 < jMin) {
                        long j5 = 0;
                        while (true) {
                            j5++;
                            int i5 = i2 + 1;
                            int i6 = i4 + 1;
                            if (tVar.f1879a[i2] != tVar2.f1879a[i4]) {
                                return false;
                            }
                            if (j5 >= jMin) {
                                i2 = i5;
                                i4 = i6;
                                break;
                            }
                            i2 = i5;
                            i4 = i6;
                        }
                    }
                    if (i2 == tVar.f1881c) {
                        tVar = tVar.f1883f;
                        f3.c.b(tVar);
                        i2 = tVar.f1880b;
                    }
                    if (i4 == tVar2.f1881c) {
                        tVar2 = tVar2.f1883f;
                        f3.c.b(tVar2);
                        i4 = tVar2.f1880b;
                    }
                    j4 += jMin;
                }
            }
        }
        return true;
    }

    public final void f() throws EOFException {
        a(this.f1846j);
    }

    public final byte f0(long j2) {
        n.d(this.f1846j, j2, 1L);
        t tVar = this.f1845i;
        if (tVar == null) {
            f3.c.b(null);
            throw null;
        }
        long j4 = this.f1846j;
        if (j4 - j2 < j2) {
            while (j4 > j2) {
                tVar = tVar.g;
                f3.c.b(tVar);
                j4 -= tVar.f1881c - tVar.f1880b;
            }
            return tVar.f1879a[(int) ((tVar.f1880b + j2) - j4)];
        }
        long j5 = 0;
        while (true) {
            int i2 = tVar.f1881c;
            int i4 = tVar.f1880b;
            long j6 = (i2 - i4) + j5;
            if (j6 > j2) {
                return tVar.f1879a[(int) ((i4 + j2) - j5)];
            }
            tVar = tVar.f1883f;
            f3.c.b(tVar);
            j5 = j6;
        }
    }

    @Override // X3.e, X3.w, java.io.Flushable
    public final void flush() {
    }

    @Override // X3.e
    public final /* bridge */ /* synthetic */ e g(byte[] bArr, int i2, int i4) {
        s0(bArr, i2, i4);
        return this;
    }

    public final long g0(byte b2, long j2, long j4) {
        t tVar;
        long j5 = 0;
        boolean z4 = false;
        if (0 <= j2 && j2 <= j4) {
            z4 = true;
        }
        if (!z4) {
            StringBuilder sbD = D2.e.d("size=");
            sbD.append(this.f1846j);
            sbD.append(" fromIndex=");
            sbD.append(j2);
            sbD.append(" toIndex=");
            sbD.append(j4);
            throw new IllegalArgumentException(sbD.toString().toString());
        }
        long j6 = this.f1846j;
        long j7 = j4 > j6 ? j6 : j4;
        if (j2 == j7 || (tVar = this.f1845i) == null) {
            return -1L;
        }
        if (j6 - j2 < j2) {
            while (j6 > j2) {
                tVar = tVar.g;
                f3.c.b(tVar);
                j6 -= tVar.f1881c - tVar.f1880b;
            }
            while (j6 < j7) {
                byte[] bArr = tVar.f1879a;
                int iMin = (int) Math.min(tVar.f1881c, (tVar.f1880b + j7) - j6);
                for (int i2 = (int) ((tVar.f1880b + j2) - j6); i2 < iMin; i2++) {
                    if (bArr[i2] == b2) {
                        return (i2 - tVar.f1880b) + j6;
                    }
                }
                j6 += tVar.f1881c - tVar.f1880b;
                tVar = tVar.f1883f;
                f3.c.b(tVar);
                j2 = j6;
            }
            return -1L;
        }
        while (true) {
            long j8 = (tVar.f1881c - tVar.f1880b) + j5;
            if (j8 > j2) {
                break;
            }
            tVar = tVar.f1883f;
            f3.c.b(tVar);
            j5 = j8;
        }
        while (j5 < j7) {
            byte[] bArr2 = tVar.f1879a;
            int iMin2 = (int) Math.min(tVar.f1881c, (tVar.f1880b + j7) - j5);
            for (int i4 = (int) ((tVar.f1880b + j2) - j5); i4 < iMin2; i4++) {
                if (bArr2[i4] == b2) {
                    return (i4 - tVar.f1880b) + j5;
                }
            }
            j5 += tVar.f1881c - tVar.f1880b;
            tVar = tVar.f1883f;
            f3.c.b(tVar);
            j2 = j5;
        }
        return -1L;
    }

    public final g h0() {
        return q(this.f1846j);
    }

    public final int hashCode() {
        t tVar = this.f1845i;
        if (tVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i4 = tVar.f1881c;
            for (int i5 = tVar.f1880b; i5 < i4; i5++) {
                i2 = (i2 * 31) + tVar.f1879a[i5];
            }
            tVar = tVar.f1883f;
            f3.c.b(tVar);
        } while (tVar != this.f1845i);
        return i2;
    }

    public final short i0() throws EOFException {
        int i2 = readShort() & 65535;
        return (short) (((i2 & 255) << 8) | ((65280 & i2) >>> 8));
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final String j0(long j2, Charset charset) throws EOFException {
        f3.c.d(charset, "charset");
        if (!(j2 >= 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(f3.c.h("byteCount: ", Long.valueOf(j2)).toString());
        }
        if (this.f1846j < j2) {
            throw new EOFException();
        }
        if (j2 == 0) {
            return "";
        }
        t tVar = this.f1845i;
        f3.c.b(tVar);
        int i2 = tVar.f1880b;
        if (i2 + j2 > tVar.f1881c) {
            return new String(Z(j2), charset);
        }
        int i4 = (int) j2;
        String str = new String(tVar.f1879a, i2, i4, charset);
        int i5 = tVar.f1880b + i4;
        tVar.f1880b = i5;
        this.f1846j -= j2;
        if (i5 == tVar.f1881c) {
            this.f1845i = tVar.a();
            u.b(tVar);
        }
        return str;
    }

    public final String k0() {
        return j0(this.f1846j, i3.c.f6339b);
    }

    public final String l0(long j2) throws EOFException {
        return j0(j2, i3.c.f6339b);
    }

    public final void m0(long j2) {
        this.f1846j = j2;
    }

    public final long n0() {
        return this.f1846j;
    }

    @Override // X3.f
    public final d o() {
        return this;
    }

    public final g o0(int i2) {
        if (i2 == 0) {
            return g.f1848m;
        }
        n.d(this.f1846j, 0L, i2);
        t tVar = this.f1845i;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2) {
            f3.c.b(tVar);
            int i7 = tVar.f1881c;
            int i8 = tVar.f1880b;
            if (i7 == i8) {
                throw new AssertionError("s.limit == s.pos");
            }
            i5 += i7 - i8;
            i6++;
            tVar = tVar.f1883f;
        }
        byte[][] bArr = new byte[i6][];
        int[] iArr = new int[i6 * 2];
        t tVar2 = this.f1845i;
        int i9 = 0;
        while (i4 < i2) {
            f3.c.b(tVar2);
            bArr[i9] = tVar2.f1879a;
            i4 += tVar2.f1881c - tVar2.f1880b;
            iArr[i9] = Math.min(i4, i2);
            iArr[i9 + i6] = tVar2.f1880b;
            tVar2.d = true;
            i9++;
            tVar2 = tVar2.f1883f;
        }
        return new v(bArr, iArr);
    }

    public final t p0(int i2) {
        if (!(i2 >= 1 && i2 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        t tVar = this.f1845i;
        if (tVar == null) {
            t tVarC = u.c();
            this.f1845i = tVarC;
            tVarC.g = tVarC;
            tVarC.f1883f = tVarC;
            return tVarC;
        }
        f3.c.b(tVar);
        t tVar2 = tVar.g;
        f3.c.b(tVar2);
        if (tVar2.f1881c + i2 <= 8192 && tVar2.f1882e) {
            return tVar2;
        }
        t tVarC2 = u.c();
        tVar2.b(tVarC2);
        return tVarC2;
    }

    @Override // X3.f
    public final g q(long j2) throws EOFException {
        if (!(j2 >= 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(f3.c.h("byteCount: ", Long.valueOf(j2)).toString());
        }
        if (this.f1846j < j2) {
            throw new EOFException();
        }
        if (j2 < 4096) {
            return new g(Z(j2));
        }
        g gVarO0 = o0((int) j2);
        a(j2);
        return gVarO0;
    }

    public final d q0(g gVar) {
        f3.c.d(gVar, "byteString");
        gVar.r(this, gVar.h());
        return this;
    }

    public final d r0(byte[] bArr) {
        f3.c.d(bArr, "source");
        s0(bArr, 0, bArr.length);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) throws IOException {
        f3.c.d(byteBuffer, "sink");
        t tVar = this.f1845i;
        if (tVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), tVar.f1881c - tVar.f1880b);
        byteBuffer.put(tVar.f1879a, tVar.f1880b, iMin);
        int i2 = tVar.f1880b + iMin;
        tVar.f1880b = i2;
        this.f1846j -= iMin;
        if (i2 == tVar.f1881c) {
            this.f1845i = tVar.a();
            u.b(tVar);
        }
        return iMin;
    }

    @Override // X3.f
    public final byte readByte() throws EOFException {
        if (this.f1846j == 0) {
            throw new EOFException();
        }
        t tVar = this.f1845i;
        f3.c.b(tVar);
        int i2 = tVar.f1880b;
        int i4 = tVar.f1881c;
        int i5 = i2 + 1;
        byte b2 = tVar.f1879a[i2];
        this.f1846j--;
        if (i5 == i4) {
            this.f1845i = tVar.a();
            u.b(tVar);
        } else {
            tVar.f1880b = i5;
        }
        return b2;
    }

    @Override // X3.f
    public final int readInt() throws EOFException {
        if (this.f1846j < 4) {
            throw new EOFException();
        }
        t tVar = this.f1845i;
        f3.c.b(tVar);
        int i2 = tVar.f1880b;
        int i4 = tVar.f1881c;
        if (i4 - i2 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = tVar.f1879a;
        int i5 = i2 + 1;
        int i6 = i5 + 1;
        int i7 = ((bArr[i2] & 255) << 24) | ((bArr[i5] & 255) << 16);
        int i8 = i6 + 1;
        int i9 = i7 | ((bArr[i6] & 255) << 8);
        int i10 = i8 + 1;
        int i11 = i9 | (bArr[i8] & 255);
        this.f1846j -= 4;
        if (i10 == i4) {
            this.f1845i = tVar.a();
            u.b(tVar);
        } else {
            tVar.f1880b = i10;
        }
        return i11;
    }

    @Override // X3.f
    public final short readShort() throws EOFException {
        if (this.f1846j < 2) {
            throw new EOFException();
        }
        t tVar = this.f1845i;
        f3.c.b(tVar);
        int i2 = tVar.f1880b;
        int i4 = tVar.f1881c;
        if (i4 - i2 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = tVar.f1879a;
        int i5 = i2 + 1;
        int i6 = i5 + 1;
        int i7 = ((bArr[i2] & 255) << 8) | (bArr[i5] & 255);
        this.f1846j -= 2;
        if (i6 == i4) {
            this.f1845i = tVar.a();
            u.b(tVar);
        } else {
            tVar.f1880b = i6;
        }
        return (short) i7;
    }

    public final d s0(byte[] bArr, int i2, int i4) {
        f3.c.d(bArr, "source");
        long j2 = i4;
        n.d(bArr.length, i2, j2);
        int i5 = i4 + i2;
        while (i2 < i5) {
            t tVarP0 = p0(1);
            int iMin = Math.min(i5 - i2, 8192 - tVarP0.f1881c);
            int i6 = i2 + iMin;
            Z2.d.b(bArr, tVarP0.f1879a, tVarP0.f1881c, i2, i6);
            tVarP0.f1881c += iMin;
            i2 = i6;
        }
        this.f1846j += j2;
        return this;
    }

    @Override // X3.f
    public final String t(long j2) throws EOFException {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(f3.c.h("limit < 0: ", Long.valueOf(j2)).toString());
        }
        long j4 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
        byte b2 = (byte) 10;
        long jG0 = g0(b2, 0L, j4);
        if (jG0 != -1) {
            return Y3.a.b(this, jG0);
        }
        if (j4 < this.f1846j && f0(j4 - 1) == ((byte) 13) && f0(j4) == b2) {
            return Y3.a.b(this, j4);
        }
        d dVar = new d();
        e0(dVar, 0L, Math.min(32, this.f1846j));
        StringBuilder sbD = D2.e.d("\\n not found: limit=");
        sbD.append(Math.min(this.f1846j, j2));
        sbD.append(" content=");
        sbD.append(dVar.h0().i());
        sbD.append((char) 8230);
        throw new EOFException(sbD.toString());
    }

    public final long t0(y yVar) throws IOException {
        f3.c.d(yVar, "source");
        long j2 = 0;
        while (true) {
            long jU = yVar.U(this, 8192L);
            if (jU == -1) {
                return j2;
            }
            j2 += jU;
        }
    }

    public final String toString() {
        long j2 = this.f1846j;
        if (j2 <= 2147483647L) {
            return o0((int) j2).toString();
        }
        throw new IllegalStateException(f3.c.h("size > Int.MAX_VALUE: ", Long.valueOf(j2)).toString());
    }

    public final d u0(int i2) {
        t tVarP0 = p0(1);
        byte[] bArr = tVarP0.f1879a;
        int i4 = tVarP0.f1881c;
        tVarP0.f1881c = i4 + 1;
        bArr[i4] = (byte) i2;
        this.f1846j++;
        return this;
    }

    @Override // X3.e
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final d m(long j2) {
        if (j2 == 0) {
            u0(48);
        } else {
            long j4 = (j2 >>> 1) | j2;
            long j5 = j4 | (j4 >>> 2);
            long j6 = j5 | (j5 >>> 4);
            long j7 = j6 | (j6 >>> 8);
            long j8 = j7 | (j7 >>> 16);
            long j9 = j8 | (j8 >>> 32);
            long j10 = j9 - ((j9 >>> 1) & 6148914691236517205L);
            long j11 = ((j10 >>> 2) & 3689348814741910323L) + (j10 & 3689348814741910323L);
            long j12 = ((j11 >>> 4) + j11) & 1085102592571150095L;
            long j13 = j12 + (j12 >>> 8);
            long j14 = j13 + (j13 >>> 16);
            int i2 = (int) ((((j14 & 63) + ((j14 >>> 32) & 63)) + 3) / 4);
            t tVarP0 = p0(i2);
            byte[] bArr = tVarP0.f1879a;
            int i4 = tVarP0.f1881c;
            for (int i5 = (i4 + i2) - 1; i5 >= i4; i5--) {
                bArr[i5] = Y3.a.a()[(int) (15 & j2)];
                j2 >>>= 4;
            }
            tVarP0.f1881c += i2;
            this.f1846j += i2;
        }
        return this;
    }

    @Override // X3.w
    public final void w(d dVar, long j2) {
        int i2;
        t tVar;
        t tVarC;
        f3.c.d(dVar, "source");
        if (!(dVar != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        n.d(dVar.f1846j, 0L, j2);
        while (j2 > 0) {
            t tVar2 = dVar.f1845i;
            f3.c.b(tVar2);
            int i4 = tVar2.f1881c;
            f3.c.b(dVar.f1845i);
            if (j2 < i4 - r3.f1880b) {
                t tVar3 = this.f1845i;
                if (tVar3 != null) {
                    f3.c.b(tVar3);
                    tVar = tVar3.g;
                } else {
                    tVar = null;
                }
                if (tVar != null && tVar.f1882e) {
                    if ((tVar.f1881c + j2) - (tVar.d ? 0 : tVar.f1880b) <= 8192) {
                        t tVar4 = dVar.f1845i;
                        f3.c.b(tVar4);
                        tVar4.d(tVar, (int) j2);
                        dVar.f1846j -= j2;
                        this.f1846j += j2;
                        return;
                    }
                }
                t tVar5 = dVar.f1845i;
                f3.c.b(tVar5);
                int i5 = (int) j2;
                if (!(i5 > 0 && i5 <= tVar5.f1881c - tVar5.f1880b)) {
                    throw new IllegalArgumentException("byteCount out of range".toString());
                }
                if (i5 >= 1024) {
                    tVarC = tVar5.c();
                } else {
                    tVarC = u.c();
                    byte[] bArr = tVar5.f1879a;
                    byte[] bArr2 = tVarC.f1879a;
                    int i6 = tVar5.f1880b;
                    Z2.d.b(bArr, bArr2, 0, i6, i6 + i5);
                }
                tVarC.f1881c = tVarC.f1880b + i5;
                tVar5.f1880b += i5;
                t tVar6 = tVar5.g;
                f3.c.b(tVar6);
                tVar6.b(tVarC);
                dVar.f1845i = tVarC;
            }
            t tVar7 = dVar.f1845i;
            f3.c.b(tVar7);
            long j4 = tVar7.f1881c - tVar7.f1880b;
            dVar.f1845i = tVar7.a();
            t tVar8 = this.f1845i;
            if (tVar8 == null) {
                this.f1845i = tVar7;
                tVar7.g = tVar7;
                tVar7.f1883f = tVar7;
            } else {
                f3.c.b(tVar8);
                t tVar9 = tVar8.g;
                f3.c.b(tVar9);
                tVar9.b(tVar7);
                t tVar10 = tVar7.g;
                if (!(tVar10 != tVar7)) {
                    throw new IllegalStateException("cannot compact".toString());
                }
                f3.c.b(tVar10);
                if (tVar10.f1882e) {
                    int i7 = tVar7.f1881c - tVar7.f1880b;
                    t tVar11 = tVar7.g;
                    f3.c.b(tVar11);
                    int i8 = 8192 - tVar11.f1881c;
                    t tVar12 = tVar7.g;
                    f3.c.b(tVar12);
                    if (tVar12.d) {
                        i2 = 0;
                    } else {
                        t tVar13 = tVar7.g;
                        f3.c.b(tVar13);
                        i2 = tVar13.f1880b;
                    }
                    if (i7 <= i8 + i2) {
                        t tVar14 = tVar7.g;
                        f3.c.b(tVar14);
                        tVar7.d(tVar14, i7);
                        tVar7.a();
                        u.b(tVar7);
                    }
                }
            }
            dVar.f1846j -= j4;
            this.f1846j += j4;
            j2 -= j4;
        }
    }

    public final d w0(int i2) {
        t tVarP0 = p0(4);
        byte[] bArr = tVarP0.f1879a;
        int i4 = tVarP0.f1881c;
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 24) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 16) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i2 >>> 8) & 255);
        bArr[i7] = (byte) (i2 & 255);
        tVarP0.f1881c = i7 + 1;
        this.f1846j += 4;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) throws IOException {
        f3.c.d(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            t tVarP0 = p0(1);
            int iMin = Math.min(i2, 8192 - tVarP0.f1881c);
            byteBuffer.get(tVarP0.f1879a, tVarP0.f1881c, iMin);
            i2 -= iMin;
            tVarP0.f1881c += iMin;
        }
        this.f1846j += iRemaining;
        return iRemaining;
    }

    @Override // X3.e
    public final /* bridge */ /* synthetic */ e x(int i2) {
        x0(i2);
        return this;
    }

    public final d x0(int i2) {
        t tVarP0 = p0(2);
        byte[] bArr = tVarP0.f1879a;
        int i4 = tVarP0.f1881c;
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 8) & 255);
        bArr[i5] = (byte) (i2 & 255);
        tVarP0.f1881c = i5 + 1;
        this.f1846j += 2;
        return this;
    }

    public final d y0(String str) {
        f3.c.d(str, "string");
        z0(str, 0, str.length());
        return this;
    }

    @Override // X3.f
    public final boolean z(long j2) {
        return this.f1846j >= Long.MAX_VALUE;
    }

    public final d z0(String str, int i2, int i4) {
        char cCharAt;
        f3.c.d(str, "string");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(f3.c.h("beginIndex < 0: ", Integer.valueOf(i2)).toString());
        }
        if (!(i4 >= i2)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i4 + " < " + i2).toString());
        }
        if (!(i4 <= str.length())) {
            StringBuilder sbC = C2.c.c("endIndex > string.length: ", i4, " > ");
            sbC.append(str.length());
            throw new IllegalArgumentException(sbC.toString().toString());
        }
        while (i2 < i4) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 128) {
                t tVarP0 = p0(1);
                byte[] bArr = tVarP0.f1879a;
                int i5 = tVarP0.f1881c - i2;
                int iMin = Math.min(i4, 8192 - i5);
                int i6 = i2 + 1;
                bArr[i2 + i5] = (byte) cCharAt2;
                while (true) {
                    i2 = i6;
                    if (i2 >= iMin || (cCharAt = str.charAt(i2)) >= 128) {
                        break;
                    }
                    i6 = i2 + 1;
                    bArr[i2 + i5] = (byte) cCharAt;
                }
                int i7 = tVarP0.f1881c;
                int i8 = (i5 + i2) - i7;
                tVarP0.f1881c = i7 + i8;
                this.f1846j += i8;
            } else {
                if (cCharAt2 < 2048) {
                    t tVarP02 = p0(2);
                    byte[] bArr2 = tVarP02.f1879a;
                    int i9 = tVarP02.f1881c;
                    bArr2[i9] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i9 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    tVarP02.f1881c = i9 + 2;
                    this.f1846j += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    t tVarP03 = p0(3);
                    byte[] bArr3 = tVarP03.f1879a;
                    int i10 = tVarP03.f1881c;
                    bArr3[i10] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i10 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i10 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    tVarP03.f1881c = i10 + 3;
                    this.f1846j += 3;
                } else {
                    int i11 = i2 + 1;
                    char cCharAt3 = i11 < i4 ? str.charAt(i11) : (char) 0;
                    if (cCharAt2 <= 56319) {
                        if (56320 <= cCharAt3 && cCharAt3 <= 57343) {
                            int i12 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            t tVarP04 = p0(4);
                            byte[] bArr4 = tVarP04.f1879a;
                            int i13 = tVarP04.f1881c;
                            bArr4[i13] = (byte) ((i12 >> 18) | 240);
                            bArr4[i13 + 1] = (byte) (((i12 >> 12) & 63) | 128);
                            bArr4[i13 + 2] = (byte) (((i12 >> 6) & 63) | 128);
                            bArr4[i13 + 3] = (byte) ((i12 & 63) | 128);
                            tVarP04.f1881c = i13 + 4;
                            this.f1846j += 4;
                            i2 += 2;
                        }
                    }
                    u0(63);
                    i2 = i11;
                }
                i2++;
            }
        }
        return this;
    }
}
