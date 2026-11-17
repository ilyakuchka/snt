package X3;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class m implements y {

    /* renamed from: i, reason: collision with root package name */
    private final InputStream f1864i;

    /* renamed from: j, reason: collision with root package name */
    private final z f1865j;

    public m(InputStream inputStream, z zVar) {
        this.f1864i = inputStream;
        this.f1865j = zVar;
    }

    @Override // X3.y
    public final long U(d dVar, long j2) throws IOException {
        f3.c.d(dVar, "sink");
        try {
            this.f1865j.f();
            t tVarP0 = dVar.p0(1);
            int i2 = this.f1864i.read(tVarP0.f1879a, tVarP0.f1881c, (int) Math.min(8192L, 8192 - tVarP0.f1881c));
            if (i2 != -1) {
                tVarP0.f1881c += i2;
                long j4 = i2;
                dVar.m0(dVar.n0() + j4);
                return j4;
            }
            if (tVarP0.f1880b != tVarP0.f1881c) {
                return -1L;
            }
            dVar.f1845i = tVarP0.a();
            u.b(tVarP0);
            return -1L;
        } catch (AssertionError e2) {
            if (n.e(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    @Override // X3.y
    public final z c() {
        return this.f1865j;
    }

    @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f1864i.close();
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("source(");
        sbD.append(this.f1864i);
        sbD.append(')');
        return sbD.toString();
    }
}
