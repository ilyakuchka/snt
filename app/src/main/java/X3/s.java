package X3;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class s implements f {

    /* renamed from: i, reason: collision with root package name */
    public final y f1876i;

    /* renamed from: j, reason: collision with root package name */
    public final d f1877j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1878k;

    public s(y yVar) {
        f3.c.d(yVar, "source");
        this.f1876i = yVar;
        this.f1877j = new d();
    }

    @Override // X3.f
    public final int E(p pVar) throws EOFException {
        f3.c.d(pVar, "options");
        if (!(!this.f1878k)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int iC = Y3.a.c(this.f1877j, pVar, true);
            if (iC != -2) {
                if (iC != -1) {
                    this.f1877j.a(pVar.g()[iC].h());
                    return iC;
                }
            } else if (this.f1876i.U(this.f1877j, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    public final int H() throws EOFException {
        Q(4L);
        int i2 = this.f1877j.readInt();
        return ((i2 & 255) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    @Override // X3.f
    public final String N() {
        return t(Long.MAX_VALUE);
    }

    @Override // X3.f
    public final byte[] P() throws IOException {
        this.f1877j.t0(this.f1876i);
        return this.f1877j.P();
    }

    @Override // X3.f
    public final void Q(long j2) throws EOFException {
        if (!z(j2)) {
            throw new EOFException();
        }
    }

    @Override // X3.y
    public final long U(d dVar, long j2) {
        f3.c.d(dVar, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(f3.c.h("byteCount < 0: ", Long.valueOf(j2)).toString());
        }
        if (!(!this.f1878k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f1877j.n0() == 0 && this.f1876i.U(this.f1877j, 8192L) == -1) {
            return -1L;
        }
        return this.f1877j.U(dVar, Math.min(j2, this.f1877j.n0()));
    }

    @Override // X3.f
    public final boolean V() {
        if (!this.f1878k) {
            return this.f1877j.V() && this.f1876i.U(this.f1877j, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // X3.f
    public final byte[] Z(long j2) throws EOFException {
        Q(j2);
        return this.f1877j.Z(j2);
    }

    @Override // X3.f
    public final void a(long j2) throws EOFException {
        if (!(!this.f1878k)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (this.f1877j.n0() == 0 && this.f1876i.U(this.f1877j, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j2, this.f1877j.n0());
            this.f1877j.a(jMin);
            j2 -= jMin;
        }
    }

    @Override // X3.f
    public final long a0() throws EOFException {
        byte bF0;
        Q(1L);
        int i2 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (!z(i4)) {
                break;
            }
            bF0 = this.f1877j.f0(i2);
            if ((bF0 < ((byte) 48) || bF0 > ((byte) 57)) && ((bF0 < ((byte) 97) || bF0 > ((byte) 102)) && (bF0 < ((byte) 65) || bF0 > ((byte) 70)))) {
                break;
            }
            i2 = i4;
        }
        if (i2 == 0) {
            i3.a.c(16);
            i3.a.c(16);
            String string = Integer.toString(bF0, 16);
            f3.c.c(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(f3.c.h("Expected leading [0-9a-fA-F] character but was 0x", string));
        }
        return this.f1877j.a0();
    }

    @Override // X3.f, X3.e
    public final d b() {
        return this.f1877j;
    }

    @Override // X3.y
    public final z c() {
        return this.f1876i.c();
    }

    @Override // X3.f
    public final String c0(Charset charset) throws IOException {
        this.f1877j.t0(this.f1876i);
        return this.f1877j.c0(charset);
    }

    @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f1878k) {
            return;
        }
        this.f1878k = true;
        this.f1876i.close();
        this.f1877j.f();
    }

    public final long f(byte b2, long j2, long j4) {
        if (!(!this.f1878k)) {
            throw new IllegalStateException("closed".toString());
        }
        long jMax = 0;
        if (!(0 <= j4)) {
            throw new IllegalArgumentException(("fromIndex=0 toIndex=" + j4).toString());
        }
        while (jMax < j4) {
            long jG0 = this.f1877j.g0(b2, jMax, j4);
            if (jG0 != -1) {
                return jG0;
            }
            long jN0 = this.f1877j.n0();
            if (jN0 >= j4 || this.f1876i.U(this.f1877j, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, jN0);
        }
        return -1L;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f1878k;
    }

    @Override // X3.f
    public final d o() {
        return this.f1877j;
    }

    @Override // X3.f
    public final g q(long j2) throws EOFException {
        Q(j2);
        return this.f1877j.q(j2);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        f3.c.d(byteBuffer, "sink");
        if (this.f1877j.n0() == 0 && this.f1876i.U(this.f1877j, 8192L) == -1) {
            return -1;
        }
        return this.f1877j.read(byteBuffer);
    }

    @Override // X3.f
    public final byte readByte() throws EOFException {
        Q(1L);
        return this.f1877j.readByte();
    }

    @Override // X3.f
    public final int readInt() throws EOFException {
        Q(4L);
        return this.f1877j.readInt();
    }

    @Override // X3.f
    public final short readShort() throws EOFException {
        Q(2L);
        return this.f1877j.readShort();
    }

    @Override // X3.f
    public final String t(long j2) throws EOFException {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(f3.c.h("limit < 0: ", Long.valueOf(j2)).toString());
        }
        long j4 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
        byte b2 = (byte) 10;
        long jF = f(b2, 0L, j4);
        if (jF != -1) {
            return Y3.a.b(this.f1877j, jF);
        }
        if (j4 < Long.MAX_VALUE && z(j4) && this.f1877j.f0(j4 - 1) == ((byte) 13) && z(1 + j4) && this.f1877j.f0(j4) == b2) {
            return Y3.a.b(this.f1877j, j4);
        }
        d dVar = new d();
        d dVar2 = this.f1877j;
        dVar2.e0(dVar, 0L, Math.min(32, dVar2.n0()));
        StringBuilder sbD = D2.e.d("\\n not found: limit=");
        sbD.append(Math.min(this.f1877j.n0(), j2));
        sbD.append(" content=");
        sbD.append(dVar.h0().i());
        sbD.append((char) 8230);
        throw new EOFException(sbD.toString());
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("buffer(");
        sbD.append(this.f1876i);
        sbD.append(')');
        return sbD.toString();
    }

    @Override // X3.f
    public final boolean z(long j2) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(f3.c.h("byteCount < 0: ", Long.valueOf(j2)).toString());
        }
        if (!(!this.f1878k)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f1877j.n0() < j2) {
            if (this.f1876i.U(this.f1877j, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }
}
