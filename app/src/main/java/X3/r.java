package X3;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class r implements e {

    /* renamed from: i, reason: collision with root package name */
    public final w f1873i;

    /* renamed from: j, reason: collision with root package name */
    public final d f1874j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1875k;

    public r(w wVar) {
        f3.c.d(wVar, "sink");
        this.f1873i = wVar;
        this.f1874j = new d();
    }

    @Override // X3.e
    public final e D(g gVar) throws IOException {
        f3.c.d(gVar, "byteString");
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f1874j.q0(gVar);
        f();
        return this;
    }

    @Override // X3.e
    public final e F(int i2) throws IOException {
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f1874j.w0(i2);
        f();
        return this;
    }

    @Override // X3.e
    public final e S(String str) throws IOException {
        f3.c.d(str, "string");
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f1874j.y0(str);
        f();
        return this;
    }

    @Override // X3.e
    public final e X(int i2) throws IOException {
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f1874j.u0(i2);
        f();
        return this;
    }

    @Override // X3.e
    public final d b() {
        return this.f1874j;
    }

    @Override // X3.w
    public final z c() {
        return this.f1873i.c();
    }

    @Override // X3.w, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        if (this.f1875k) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f1874j.n0() > 0) {
                w wVar = this.f1873i;
                d dVar = this.f1874j;
                wVar.w(dVar, dVar.n0());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f1873i.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f1875k = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // X3.e
    public final e d(byte[] bArr) throws IOException {
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f1874j.r0(bArr);
        f();
        return this;
    }

    public final e f() throws IOException {
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        long jI = this.f1874j.I();
        if (jI > 0) {
            this.f1873i.w(this.f1874j, jI);
        }
        return this;
    }

    @Override // X3.e, X3.w, java.io.Flushable
    public final void flush() throws IOException {
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f1874j.n0() > 0) {
            w wVar = this.f1873i;
            d dVar = this.f1874j;
            wVar.w(dVar, dVar.n0());
        }
        this.f1873i.flush();
    }

    @Override // X3.e
    public final e g(byte[] bArr, int i2, int i4) throws IOException {
        f3.c.d(bArr, "source");
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f1874j.s0(bArr, i2, i4);
        f();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f1875k;
    }

    @Override // X3.e
    public final e m(long j2) throws IOException {
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f1874j.m(j2);
        f();
        return this;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("buffer(");
        sbD.append(this.f1873i);
        sbD.append(')');
        return sbD.toString();
    }

    @Override // X3.w
    public final void w(d dVar, long j2) throws IOException {
        f3.c.d(dVar, "source");
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f1874j.w(dVar, j2);
        f();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) throws IOException {
        f3.c.d(byteBuffer, "source");
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f1874j.write(byteBuffer);
        f();
        return iWrite;
    }

    @Override // X3.e
    public final e x(int i2) throws IOException {
        if (!(!this.f1875k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f1874j.x0(i2);
        f();
        return this;
    }
}
