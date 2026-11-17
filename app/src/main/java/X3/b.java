package X3;

import java.io.IOException;

/* loaded from: classes.dex */
public final class b implements w {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0174a f1841i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ w f1842j;

    b(C0174a c0174a, w wVar) {
        this.f1841i = c0174a;
        this.f1842j = wVar;
    }

    @Override // X3.w
    public final z c() {
        return this.f1841i;
    }

    @Override // X3.w, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C0174a c0174a = this.f1841i;
        w wVar = this.f1842j;
        c0174a.r();
        try {
            wVar.close();
            if (c0174a.s()) {
                throw c0174a.t(null);
            }
        } catch (IOException e2) {
            if (!c0174a.s()) {
                throw e2;
            }
            throw c0174a.t(e2);
        } finally {
            c0174a.s();
        }
    }

    @Override // X3.w, java.io.Flushable
    public final void flush() throws IOException {
        C0174a c0174a = this.f1841i;
        w wVar = this.f1842j;
        c0174a.r();
        try {
            wVar.flush();
            if (c0174a.s()) {
                throw c0174a.t(null);
            }
        } catch (IOException e2) {
            if (!c0174a.s()) {
                throw e2;
            }
            throw c0174a.t(e2);
        } finally {
            c0174a.s();
        }
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("AsyncTimeout.sink(");
        sbD.append(this.f1842j);
        sbD.append(')');
        return sbD.toString();
    }

    @Override // X3.w
    public final void w(d dVar, long j2) throws IOException {
        f3.c.d(dVar, "source");
        n.d(dVar.n0(), 0L, j2);
        while (true) {
            long j4 = 0;
            if (j2 <= 0) {
                return;
            }
            t tVar = dVar.f1845i;
            f3.c.b(tVar);
            while (true) {
                if (j4 >= 65536) {
                    break;
                }
                j4 += tVar.f1881c - tVar.f1880b;
                if (j4 >= j2) {
                    j4 = j2;
                    break;
                } else {
                    tVar = tVar.f1883f;
                    f3.c.b(tVar);
                }
            }
            C0174a c0174a = this.f1841i;
            w wVar = this.f1842j;
            c0174a.r();
            try {
                wVar.w(dVar, j4);
                if (c0174a.s()) {
                    throw c0174a.t(null);
                }
                j2 -= j4;
            } catch (IOException e2) {
                if (!c0174a.s()) {
                    throw e2;
                }
                throw c0174a.t(e2);
            } finally {
                c0174a.s();
            }
        }
    }
}
