package Q3;

import L3.A;
import L3.C;
import L3.D;
import L3.t;
import L3.u;
import L3.w;
import L3.y;
import P3.l;
import Z2.m;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class h implements u {

    /* renamed from: a, reason: collision with root package name */
    private final w f1220a;

    public h(w wVar) {
        f3.c.d(wVar, "client");
        this.f1220a = wVar;
    }

    private final y b(A a2, P3.c cVar) throws IOException {
        String strH0;
        t.a aVar;
        P3.f fVarH;
        D dV = (cVar == null || (fVarH = cVar.h()) == null) ? null : fVarH.v();
        int iE0 = a2.e0();
        String strG = a2.o0().g();
        if (iE0 != 307 && iE0 != 308) {
            if (iE0 == 401) {
                return this.f1220a.c().d(dV, a2);
            }
            if (iE0 == 421) {
                Objects.requireNonNull(a2.o0());
                if (cVar == null || !cVar.k()) {
                    return null;
                }
                cVar.h().t();
                return a2.o0();
            }
            if (iE0 == 503) {
                A aL0 = a2.l0();
                if ((aL0 == null || aL0.e0() != 503) && d(a2, Integer.MAX_VALUE) == 0) {
                    return a2.o0();
                }
                return null;
            }
            if (iE0 == 407) {
                f3.c.b(dV);
                if (dV.b().type() == Proxy.Type.HTTP) {
                    return this.f1220a.t().d(dV, a2);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iE0 == 408) {
                if (!this.f1220a.w()) {
                    return null;
                }
                Objects.requireNonNull(a2.o0());
                A aL02 = a2.l0();
                if ((aL02 == null || aL02.e0() != 408) && d(a2, 0) <= 0) {
                    return a2.o0();
                }
                return null;
            }
            switch (iE0) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f1220a.l() || (strH0 = A.h0(a2, "Location")) == null) {
            return null;
        }
        t tVarH = a2.o0().h();
        Objects.requireNonNull(tVarH);
        try {
            aVar = new t.a();
            aVar.g(tVarH, strH0);
        } catch (IllegalArgumentException unused) {
            aVar = null;
        }
        t tVarB = aVar == null ? null : aVar.b();
        if (tVarB == null) {
            return null;
        }
        if (!f3.c.a(tVarB.p(), a2.o0().h().p()) && !this.f1220a.m()) {
            return null;
        }
        y.a aVar2 = new y.a(a2.o0());
        if (Y1.a.i(strG)) {
            int iE02 = a2.e0();
            boolean z4 = f3.c.a(strG, "PROPFIND") || iE02 == 308 || iE02 == 307;
            if (!(!f3.c.a(strG, "PROPFIND")) || iE02 == 308 || iE02 == 307) {
                aVar2.e(strG, z4 ? a2.o0().a() : null);
            } else {
                aVar2.e("GET", null);
            }
            if (!z4) {
                aVar2.f("Transfer-Encoding");
                aVar2.f("Content-Length");
                aVar2.f("Content-Type");
            }
        }
        if (!M3.c.b(a2.o0().h(), tVarB)) {
            aVar2.f("Authorization");
        }
        aVar2.g(tVarB);
        return aVar2.b();
    }

    private final boolean c(IOException iOException, P3.e eVar, y yVar, boolean z4) {
        if (!this.f1220a.w()) {
            return false;
        }
        if (z4 && (iOException instanceof FileNotFoundException)) {
            return false;
        }
        return (!(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) : (iOException instanceof SocketTimeoutException) && !z4)) && eVar.v();
    }

    private final int d(A a2, int i2) throws NumberFormatException {
        String strH0 = A.h0(a2, "Retry-After");
        if (strH0 == null) {
            return i2;
        }
        if (!new i3.e("\\d+").a(strH0)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strH0);
        f3.c.c(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    @Override // L3.u
    public final A a(u.a aVar) throws IOException {
        P3.c cVarM;
        y yVarB;
        f fVar = (f) aVar;
        y yVarH = fVar.h();
        P3.e eVarD = fVar.d();
        List listK = m.f2185i;
        boolean z4 = true;
        A a2 = null;
        int i2 = 0;
        while (true) {
            eVarD.g(yVarH, z4);
            try {
                if (eVarD.q()) {
                    throw new IOException("Canceled");
                }
                try {
                    A aJ = fVar.j(yVarH);
                    if (a2 != null) {
                        A.a aVar2 = new A.a(aJ);
                        A.a aVar3 = new A.a(a2);
                        aVar3.b(null);
                        aVar2.n(aVar3.c());
                        aJ = aVar2.c();
                    }
                    a2 = aJ;
                    cVarM = eVarD.m();
                    yVarB = b(a2, cVarM);
                } catch (l e2) {
                    if (!c(e2.c(), eVarD, yVarH, false)) {
                        IOException iOExceptionB = e2.b();
                        M3.c.B(iOExceptionB, listK);
                        throw iOExceptionB;
                    }
                    listK = Z2.g.k(listK, e2.b());
                    eVarD.i(true);
                    z4 = false;
                } catch (IOException e4) {
                    if (!c(e4, eVarD, yVarH, !(e4 instanceof S3.a))) {
                        M3.c.B(e4, listK);
                        throw e4;
                    }
                    listK = Z2.g.k(listK, e4);
                    eVarD.i(true);
                    z4 = false;
                }
                if (yVarB == null) {
                    if (cVarM != null && cVarM.l()) {
                        eVarD.x();
                    }
                    eVarD.i(false);
                    return a2;
                }
                C cF = a2.f();
                if (cF != null) {
                    M3.c.e(cF);
                }
                i2++;
                if (i2 > 20) {
                    throw new ProtocolException(f3.c.h("Too many follow-up requests: ", Integer.valueOf(i2)));
                }
                eVarD.i(true);
                yVarH = yVarB;
                z4 = true;
            } catch (Throwable th) {
                eVarD.i(true);
                throw th;
            }
        }
    }
}
