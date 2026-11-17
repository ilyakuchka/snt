package Q3;

import L3.A;
import L3.C;
import L3.u;
import L3.y;
import L3.z;
import X3.n;
import X3.r;
import java.net.ProtocolException;

/* loaded from: classes.dex */
public final class b implements u {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1203a;

    public b(boolean z4) {
        this.f1203a = z4;
    }

    @Override // L3.u
    public final A a(u.a aVar) throws Throwable {
        A.a aVarP;
        A aC;
        f fVar = (f) aVar;
        P3.c cVarF = fVar.f();
        f3.c.b(cVarF);
        y yVarH = fVar.h();
        z zVarA = yVarH.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVarF.t(yVarH);
        boolean z4 = true;
        if (!Y1.a.i(yVarH.g()) || zVarA == null) {
            cVarF.n();
            aVarP = null;
        } else {
            if (i3.f.q("100-continue", yVarH.d("Expect"))) {
                cVarF.f();
                aVarP = cVarF.p(true);
                cVarF.r();
                z4 = false;
            } else {
                aVarP = null;
            }
            if (aVarP == null) {
                X3.e eVarB = n.b(cVarF.c(yVarH));
                zVarA.c(eVarB);
                ((r) eVarB).close();
            } else {
                cVarF.n();
                if (!cVarF.h().r()) {
                    cVarF.m();
                }
            }
        }
        cVarF.e();
        if (aVarP == null) {
            aVarP = cVarF.p(false);
            f3.c.b(aVarP);
            if (z4) {
                cVarF.r();
                z4 = false;
            }
        }
        aVarP.q(yVarH);
        aVarP.h(cVarF.h().n());
        aVarP.r(jCurrentTimeMillis);
        aVarP.p(System.currentTimeMillis());
        A aC2 = aVarP.c();
        int iE0 = aC2.e0();
        if (iE0 == 100) {
            A.a aVarP2 = cVarF.p(false);
            f3.c.b(aVarP2);
            if (z4) {
                cVarF.r();
            }
            aVarP2.q(yVarH);
            aVarP2.h(cVarF.h().n());
            aVarP2.r(jCurrentTimeMillis);
            aVarP2.p(System.currentTimeMillis());
            aC2 = aVarP2.c();
            iE0 = aC2.e0();
        }
        cVarF.q(aC2);
        if (this.f1203a && iE0 == 101) {
            A.a aVar2 = new A.a(aC2);
            aVar2.b(M3.c.f598c);
            aC = aVar2.c();
        } else {
            A.a aVar3 = new A.a(aC2);
            aVar3.b(cVarF.o(aC2));
            aC = aVar3.c();
        }
        if (i3.f.q("close", aC.o0().d("Connection")) || i3.f.q("close", A.h0(aC, "Connection"))) {
            cVarF.m();
        }
        if (iE0 == 204 || iE0 == 205) {
            C cF = aC.f();
            if ((cF == null ? -1L : cF.H()) > 0) {
                StringBuilder sbC = C2.c.c("HTTP ", iE0, " had non-zero Content-Length: ");
                C cF2 = aC.f();
                sbC.append(cF2 != null ? Long.valueOf(cF2.H()) : null);
                throw new ProtocolException(sbC.toString());
            }
        }
        return aC;
    }
}
