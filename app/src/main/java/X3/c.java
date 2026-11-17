package X3;

import java.io.IOException;

/* loaded from: classes.dex */
public final class c implements y {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0174a f1843i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ y f1844j;

    c(C0174a c0174a, y yVar) {
        this.f1843i = c0174a;
        this.f1844j = yVar;
    }

    @Override // X3.y
    public final long U(d dVar, long j2) throws IOException {
        f3.c.d(dVar, "sink");
        C0174a c0174a = this.f1843i;
        y yVar = this.f1844j;
        c0174a.r();
        try {
            long jU = yVar.U(dVar, 8192L);
            if (c0174a.s()) {
                throw c0174a.t(null);
            }
            return jU;
        } catch (IOException e2) {
            if (c0174a.s()) {
                throw c0174a.t(e2);
            }
            throw e2;
        } finally {
            c0174a.s();
        }
    }

    @Override // X3.y
    public final z c() {
        return this.f1843i;
    }

    @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C0174a c0174a = this.f1843i;
        y yVar = this.f1844j;
        c0174a.r();
        try {
            yVar.close();
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
        StringBuilder sbD = D2.e.d("AsyncTimeout.source(");
        sbD.append(this.f1844j);
        sbD.append(')');
        return sbD.toString();
    }
}
