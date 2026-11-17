package Q3;

import L3.A;
import L3.C;
import L3.m;
import L3.s;
import L3.u;
import L3.v;
import L3.y;
import L3.z;
import X3.k;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a implements u {

    /* renamed from: a, reason: collision with root package name */
    private final m f1202a;

    public a(m mVar) {
        f3.c.d(mVar, "cookieJar");
        this.f1202a = mVar;
    }

    @Override // L3.u
    public final A a(u.a aVar) throws IOException {
        C cF;
        f fVar = (f) aVar;
        y yVarL = fVar.l();
        y.a aVar2 = new y.a(yVarL);
        z zVarA = yVarL.a();
        if (zVarA != null) {
            v vVarB = zVarA.b();
            if (vVarB != null) {
                aVar2.c("Content-Type", vVarB.toString());
            }
            long jA = zVarA.a();
            if (jA != -1) {
                aVar2.c("Content-Length", String.valueOf(jA));
                aVar2.f("Transfer-Encoding");
            } else {
                aVar2.c("Transfer-Encoding", "chunked");
                aVar2.f("Content-Length");
            }
        }
        boolean z4 = false;
        if (yVarL.d("Host") == null) {
            aVar2.c("Host", M3.c.x(yVarL.h(), false));
        }
        if (yVarL.d("Connection") == null) {
            aVar2.c("Connection", "Keep-Alive");
        }
        if (yVarL.d("Accept-Encoding") == null && yVarL.d("Range") == null) {
            aVar2.c("Accept-Encoding", "gzip");
            z4 = true;
        }
        this.f1202a.c(yVarL.h());
        if (yVarL.d("User-Agent") == null) {
            aVar2.c("User-Agent", "okhttp/4.10.0");
        }
        A aJ = fVar.j(aVar2.b());
        e.b(this.f1202a, yVarL.h(), aJ.i0());
        A.a aVar3 = new A.a(aJ);
        aVar3.q(yVarL);
        if (z4 && i3.f.q("gzip", A.h0(aJ, "Content-Encoding")) && e.a(aJ) && (cF = aJ.f()) != null) {
            k kVar = new k(cF.e0());
            s.a aVarI = aJ.i0().i();
            aVarI.e("Content-Encoding");
            aVarI.e("Content-Length");
            aVar3.j(aVarI.c());
            aVar3.b(new g(A.h0(aJ, "Content-Type"), -1L, new X3.s(kVar)));
        }
        return aVar3.c();
    }
}
