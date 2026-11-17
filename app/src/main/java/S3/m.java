package S3;

import S3.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class m implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    private static final Logger f1503o = Logger.getLogger(e.class.getName());

    /* renamed from: i, reason: collision with root package name */
    private final X3.e f1504i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f1505j;

    /* renamed from: k, reason: collision with root package name */
    private final X3.d f1506k;

    /* renamed from: l, reason: collision with root package name */
    private int f1507l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1508m;

    /* renamed from: n, reason: collision with root package name */
    private final d.b f1509n;

    public m(X3.e eVar, boolean z4) {
        this.f1504i = eVar;
        this.f1505j = z4;
        X3.d dVar = new X3.d();
        this.f1506k = dVar;
        this.f1507l = 16384;
        this.f1509n = new d.b(dVar);
    }

    private final void m0(int i2, long j2) throws IOException {
        while (j2 > 0) {
            long jMin = Math.min(this.f1507l, j2);
            j2 -= jMin;
            e0(i2, (int) jMin, 9, j2 == 0 ? 4 : 0);
            this.f1504i.w(this.f1506k, jMin);
        }
    }

    public final synchronized void H() throws IOException {
        if (this.f1508m) {
            throw new IOException("closed");
        }
        if (this.f1505j) {
            Logger logger = f1503o;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(M3.c.j(f3.c.h(">> CONNECTION ", e.f1398b.i()), new Object[0]));
            }
            this.f1504i.D(e.f1398b);
            this.f1504i.flush();
        }
    }

    public final synchronized void I(boolean z4, int i2, X3.d dVar, int i4) throws IOException {
        if (this.f1508m) {
            throw new IOException("closed");
        }
        e0(i2, i4, 0, z4 ? 1 : 0);
        if (i4 > 0) {
            X3.e eVar = this.f1504i;
            f3.c.b(dVar);
            eVar.w(dVar, i4);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.f1508m = true;
        this.f1504i.close();
    }

    public final void e0(int i2, int i4, int i5, int i6) throws IOException {
        Logger logger = f1503o;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.f1397a.b(false, i2, i4, i5, i6));
        }
        if (!(i4 <= this.f1507l)) {
            StringBuilder sbD = D2.e.d("FRAME_SIZE_ERROR length > ");
            sbD.append(this.f1507l);
            sbD.append(": ");
            sbD.append(i4);
            throw new IllegalArgumentException(sbD.toString().toString());
        }
        if (!((Integer.MIN_VALUE & i2) == 0)) {
            throw new IllegalArgumentException(f3.c.h("reserved bit set: ", Integer.valueOf(i2)).toString());
        }
        X3.e eVar = this.f1504i;
        byte[] bArr = M3.c.f596a;
        f3.c.d(eVar, "<this>");
        eVar.X((i4 >>> 16) & 255);
        eVar.X((i4 >>> 8) & 255);
        eVar.X(i4 & 255);
        this.f1504i.X(i5 & 255);
        this.f1504i.X(i6 & 255);
        this.f1504i.F(i2 & Integer.MAX_VALUE);
    }

    public final synchronized void f(q qVar) throws IOException {
        f3.c.d(qVar, "peerSettings");
        if (this.f1508m) {
            throw new IOException("closed");
        }
        this.f1507l = qVar.e(this.f1507l);
        if (qVar.b() != -1) {
            this.f1509n.d(qVar.b());
        }
        e0(0, 0, 4, 1);
        this.f1504i.flush();
    }

    public final synchronized void f0(int i2, b bVar, byte[] bArr) throws IOException {
        if (this.f1508m) {
            throw new IOException("closed");
        }
        if (!(bVar.d() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        e0(0, bArr.length + 8, 7, 0);
        this.f1504i.F(i2);
        this.f1504i.F(bVar.d());
        if (!(bArr.length == 0)) {
            this.f1504i.d(bArr);
        }
        this.f1504i.flush();
    }

    public final synchronized void flush() throws IOException {
        if (this.f1508m) {
            throw new IOException("closed");
        }
        this.f1504i.flush();
    }

    public final synchronized void g0(boolean z4, int i2, List<c> list) throws IOException {
        if (this.f1508m) {
            throw new IOException("closed");
        }
        this.f1509n.f(list);
        long jN0 = this.f1506k.n0();
        long jMin = Math.min(this.f1507l, jN0);
        int i4 = jN0 == jMin ? 4 : 0;
        if (z4) {
            i4 |= 1;
        }
        e0(i2, (int) jMin, 1, i4);
        this.f1504i.w(this.f1506k, jMin);
        if (jN0 > jMin) {
            m0(i2, jN0 - jMin);
        }
    }

    public final int h0() {
        return this.f1507l;
    }

    public final synchronized void i0(boolean z4, int i2, int i4) throws IOException {
        if (this.f1508m) {
            throw new IOException("closed");
        }
        e0(0, 8, 6, z4 ? 1 : 0);
        this.f1504i.F(i2);
        this.f1504i.F(i4);
        this.f1504i.flush();
    }

    public final synchronized void j0(int i2, b bVar) throws IOException {
        f3.c.d(bVar, "errorCode");
        if (this.f1508m) {
            throw new IOException("closed");
        }
        if (!(bVar.d() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        e0(i2, 4, 3, 0);
        this.f1504i.F(bVar.d());
        this.f1504i.flush();
    }

    public final synchronized void k0(q qVar) throws IOException {
        f3.c.d(qVar, "settings");
        if (this.f1508m) {
            throw new IOException("closed");
        }
        int i2 = 0;
        e0(0, qVar.i() * 6, 4, 0);
        while (i2 < 10) {
            int i4 = i2 + 1;
            if (qVar.f(i2)) {
                this.f1504i.x(i2 != 4 ? i2 != 7 ? i2 : 4 : 3);
                this.f1504i.F(qVar.a(i2));
            }
            i2 = i4;
        }
        this.f1504i.flush();
    }

    public final synchronized void l0(int i2, long j2) throws IOException {
        if (this.f1508m) {
            throw new IOException("closed");
        }
        if (!(j2 != 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(f3.c.h("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(j2)).toString());
        }
        e0(i2, 4, 8, 0);
        this.f1504i.F((int) j2);
        this.f1504i.flush();
    }
}
