package X3;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
final class q implements w {

    /* renamed from: i, reason: collision with root package name */
    private final OutputStream f1871i;

    /* renamed from: j, reason: collision with root package name */
    private final z f1872j;

    public q(OutputStream outputStream, z zVar) {
        this.f1871i = outputStream;
        this.f1872j = zVar;
    }

    @Override // X3.w
    public final z c() {
        return this.f1872j;
    }

    @Override // X3.w, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f1871i.close();
    }

    @Override // X3.w, java.io.Flushable
    public final void flush() throws IOException {
        this.f1871i.flush();
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("sink(");
        sbD.append(this.f1871i);
        sbD.append(')');
        return sbD.toString();
    }

    @Override // X3.w
    public final void w(d dVar, long j2) throws IOException {
        f3.c.d(dVar, "source");
        n.d(dVar.n0(), 0L, j2);
        while (j2 > 0) {
            this.f1872j.f();
            t tVar = dVar.f1845i;
            f3.c.b(tVar);
            int iMin = (int) Math.min(j2, tVar.f1881c - tVar.f1880b);
            this.f1871i.write(tVar.f1879a, tVar.f1880b, iMin);
            tVar.f1880b += iMin;
            long j4 = iMin;
            j2 -= j4;
            dVar.m0(dVar.n0() - j4);
            if (tVar.f1880b == tVar.f1881c) {
                dVar.f1845i = tVar.a();
                u.b(tVar);
            }
        }
    }
}
