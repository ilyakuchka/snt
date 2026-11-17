package X3;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class k implements y {

    /* renamed from: i, reason: collision with root package name */
    private byte f1855i;

    /* renamed from: j, reason: collision with root package name */
    private final s f1856j;

    /* renamed from: k, reason: collision with root package name */
    private final Inflater f1857k;

    /* renamed from: l, reason: collision with root package name */
    private final l f1858l;

    /* renamed from: m, reason: collision with root package name */
    private final CRC32 f1859m;

    public k(y yVar) {
        f3.c.d(yVar, "source");
        s sVar = new s(yVar);
        this.f1856j = sVar;
        Inflater inflater = new Inflater(true);
        this.f1857k = inflater;
        this.f1858l = new l(sVar, inflater);
        this.f1859m = new CRC32();
    }

    private final void H(d dVar, long j2, long j4) {
        t tVar = dVar.f1845i;
        f3.c.b(tVar);
        while (true) {
            int i2 = tVar.f1881c;
            int i4 = tVar.f1880b;
            if (j2 < i2 - i4) {
                break;
            }
            j2 -= i2 - i4;
            tVar = tVar.f1883f;
            f3.c.b(tVar);
        }
        while (j4 > 0) {
            int iMin = (int) Math.min(tVar.f1881c - r6, j4);
            this.f1859m.update(tVar.f1879a, (int) (tVar.f1880b + j2), iMin);
            j4 -= iMin;
            tVar = tVar.f1883f;
            f3.c.b(tVar);
            j2 = 0;
        }
    }

    private final void f(String str, int i2, int i4) throws IOException {
        if (i4 == i2) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i4), Integer.valueOf(i2)}, 3));
        f3.c.c(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    @Override // X3.y
    public final long U(d dVar, long j2) throws DataFormatException, IOException {
        long j4;
        f3.c.d(dVar, "sink");
        if (this.f1855i == 0) {
            this.f1856j.Q(10L);
            byte bF0 = this.f1856j.f1877j.f0(3L);
            boolean z4 = ((bF0 >> 1) & 1) == 1;
            if (z4) {
                H(this.f1856j.f1877j, 0L, 10L);
            }
            s sVar = this.f1856j;
            sVar.Q(2L);
            f("ID1ID2", 8075, sVar.f1877j.readShort());
            this.f1856j.a(8L);
            if (((bF0 >> 2) & 1) == 1) {
                this.f1856j.Q(2L);
                if (z4) {
                    H(this.f1856j.f1877j, 0L, 2L);
                }
                long jI0 = this.f1856j.f1877j.i0();
                this.f1856j.Q(jI0);
                if (z4) {
                    j4 = jI0;
                    H(this.f1856j.f1877j, 0L, jI0);
                } else {
                    j4 = jI0;
                }
                this.f1856j.a(j4);
            }
            if (((bF0 >> 3) & 1) == 1) {
                long jF = this.f1856j.f((byte) 0, 0L, Long.MAX_VALUE);
                if (jF == -1) {
                    throw new EOFException();
                }
                if (z4) {
                    H(this.f1856j.f1877j, 0L, jF + 1);
                }
                this.f1856j.a(jF + 1);
            }
            if (((bF0 >> 4) & 1) == 1) {
                long jF2 = this.f1856j.f((byte) 0, 0L, Long.MAX_VALUE);
                if (jF2 == -1) {
                    throw new EOFException();
                }
                if (z4) {
                    H(this.f1856j.f1877j, 0L, jF2 + 1);
                }
                this.f1856j.a(jF2 + 1);
            }
            if (z4) {
                s sVar2 = this.f1856j;
                sVar2.Q(2L);
                f("FHCRC", sVar2.f1877j.i0(), (short) this.f1859m.getValue());
                this.f1859m.reset();
            }
            this.f1855i = (byte) 1;
        }
        if (this.f1855i == 1) {
            long jN0 = dVar.n0();
            long jU = this.f1858l.U(dVar, 8192L);
            if (jU != -1) {
                H(dVar, jN0, jU);
                return jU;
            }
            this.f1855i = (byte) 2;
        }
        if (this.f1855i == 2) {
            f("CRC", this.f1856j.H(), (int) this.f1859m.getValue());
            f("ISIZE", this.f1856j.H(), (int) this.f1857k.getBytesWritten());
            this.f1855i = (byte) 3;
            if (!this.f1856j.V()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // X3.y
    public final z c() {
        return this.f1856j.c();
    }

    @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f1858l.close();
    }
}
