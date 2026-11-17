package L3;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class C implements Closeable {

    /* renamed from: i, reason: collision with root package name */
    public static final a f385i = new a();

    public static final class a {
        public final C a(byte[] bArr, v vVar) {
            f3.c.d(bArr, "<this>");
            X3.d dVar = new X3.d();
            dVar.r0(bArr);
            return new B(vVar, bArr.length, dVar);
        }
    }

    public abstract long H();

    public abstract v I();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        M3.c.e(e0());
    }

    public abstract X3.f e0();

    public final byte[] f() throws IOException {
        long jH = H();
        if (jH > 2147483647L) {
            throw new IOException(f3.c.h("Cannot buffer entire body for content length: ", Long.valueOf(jH)));
        }
        X3.f fVarE0 = e0();
        try {
            byte[] bArrP = fVarE0.P();
            S2.d.b(fVarE0, null);
            int length = bArrP.length;
            if (jH == -1 || jH == length) {
                return bArrP;
            }
            throw new IOException("Content-Length (" + jH + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }
}
