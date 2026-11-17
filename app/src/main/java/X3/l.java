package X3;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class l implements y {

    /* renamed from: i, reason: collision with root package name */
    private final f f1860i;

    /* renamed from: j, reason: collision with root package name */
    private final Inflater f1861j;

    /* renamed from: k, reason: collision with root package name */
    private int f1862k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1863l;

    public l(f fVar, Inflater inflater) {
        this.f1860i = fVar;
        this.f1861j = inflater;
    }

    @Override // X3.y
    public final long U(d dVar, long j2) throws DataFormatException, IOException {
        long j4;
        f3.c.d(dVar, "sink");
        while (!this.f1863l) {
            try {
                t tVarP0 = dVar.p0(1);
                int iMin = (int) Math.min(8192L, 8192 - tVarP0.f1881c);
                if (this.f1861j.needsInput() && !this.f1860i.V()) {
                    t tVar = this.f1860i.b().f1845i;
                    f3.c.b(tVar);
                    int i2 = tVar.f1881c;
                    int i4 = tVar.f1880b;
                    int i5 = i2 - i4;
                    this.f1862k = i5;
                    this.f1861j.setInput(tVar.f1879a, i4, i5);
                }
                int iInflate = this.f1861j.inflate(tVarP0.f1879a, tVarP0.f1881c, iMin);
                int i6 = this.f1862k;
                if (i6 != 0) {
                    int remaining = i6 - this.f1861j.getRemaining();
                    this.f1862k -= remaining;
                    this.f1860i.a(remaining);
                }
                if (iInflate > 0) {
                    tVarP0.f1881c += iInflate;
                    j4 = iInflate;
                    dVar.m0(dVar.n0() + j4);
                } else {
                    if (tVarP0.f1880b == tVarP0.f1881c) {
                        dVar.f1845i = tVarP0.a();
                        u.b(tVarP0);
                    }
                    j4 = 0;
                }
                if (j4 > 0) {
                    return j4;
                }
                if (this.f1861j.finished() || this.f1861j.needsDictionary()) {
                    return -1L;
                }
                if (this.f1860i.V()) {
                    throw new EOFException("source exhausted prematurely");
                }
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // X3.y
    public final z c() {
        return this.f1860i.c();
    }

    @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f1863l) {
            return;
        }
        this.f1861j.end();
        this.f1863l = true;
        this.f1860i.close();
    }
}
