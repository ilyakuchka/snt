package N3;

import L3.A;
import L3.C;
import L3.InterfaceC0154e;
import L3.s;
import L3.u;
import L3.x;
import L3.y;
import M3.c;
import N3.b;
import P3.e;
import i3.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a implements u {

    /* renamed from: a, reason: collision with root package name */
    public static final C0024a f733a = new C0024a();

    /* renamed from: N3.a$a, reason: collision with other inner class name */
    public static final class C0024a {
        public static final s a(s sVar, s sVar2) {
            C0024a c0024a = a.f733a;
            s.a aVar = new s.a();
            int size = sVar.size();
            int i2 = 0;
            int i4 = 0;
            while (i4 < size) {
                int i5 = i4 + 1;
                String strG = sVar.g(i4);
                String strK = sVar.k(i4);
                if ((!f.q("Warning", strG) || !f.A(strK, "1", false)) && (c0024a.c(strG) || !c0024a.d(strG) || sVar2.d(strG) == null)) {
                    aVar.b(strG, strK);
                }
                i4 = i5;
            }
            int size2 = sVar2.size();
            while (i2 < size2) {
                int i6 = i2 + 1;
                String strG2 = sVar2.g(i2);
                if (!c0024a.c(strG2) && c0024a.d(strG2)) {
                    aVar.b(strG2, sVar2.k(i2));
                }
                i2 = i6;
            }
            return aVar.c();
        }

        public static final A b(A a2) {
            if ((a2 == null ? null : a2.f()) == null) {
                return a2;
            }
            A.a aVar = new A.a(a2);
            aVar.b(null);
            return aVar.c();
        }

        private final boolean c(String str) {
            return f.q("Content-Length", str) || f.q("Content-Encoding", str) || f.q("Content-Type", str);
        }

        private final boolean d(String str) {
            return (f.q("Connection", str) || f.q("Keep-Alive", str) || f.q("Proxy-Authenticate", str) || f.q("Proxy-Authorization", str) || f.q("TE", str) || f.q("Trailers", str) || f.q("Transfer-Encoding", str) || f.q("Upgrade", str)) ? false : true;
        }
    }

    @Override // L3.u
    public final A a(u.a aVar) throws IOException {
        Q3.f fVar = (Q3.f) aVar;
        InterfaceC0154e interfaceC0154eA = fVar.a();
        b bVarA = new b.C0025b(System.currentTimeMillis(), fVar.l()).a();
        y yVarB = bVarA.b();
        A a2 = bVarA.a();
        if (interfaceC0154eA instanceof e) {
        }
        if (yVarB == null && a2 == null) {
            A.a aVar2 = new A.a();
            aVar2.q(fVar.l());
            aVar2.o(x.f546l);
            aVar2.f(504);
            aVar2.l("Unsatisfiable Request (only-if-cached)");
            aVar2.b(c.f598c);
            aVar2.r(-1L);
            aVar2.p(System.currentTimeMillis());
            A aC = aVar2.c();
            f3.c.d(interfaceC0154eA, "call");
            return aC;
        }
        if (yVarB == null) {
            f3.c.b(a2);
            A.a aVar3 = new A.a(a2);
            aVar3.d(C0024a.b(a2));
            A aC2 = aVar3.c();
            f3.c.d(interfaceC0154eA, "call");
            return aC2;
        }
        if (a2 != null) {
            f3.c.d(interfaceC0154eA, "call");
        }
        A aJ = fVar.j(yVarB);
        if (a2 != null) {
            if (aJ.e0() == 304) {
                A.a aVar4 = new A.a(a2);
                aVar4.j(C0024a.a(a2.i0(), aJ.i0()));
                aVar4.r(aJ.p0());
                aVar4.p(aJ.n0());
                aVar4.d(C0024a.b(a2));
                aVar4.m(C0024a.b(aJ));
                aVar4.c();
                C cF = aJ.f();
                f3.c.b(cF);
                cF.close();
                f3.c.b(null);
                throw null;
            }
            C cF2 = a2.f();
            if (cF2 != null) {
                c.e(cF2);
            }
        }
        A.a aVar5 = new A.a(aJ);
        aVar5.d(C0024a.b(a2));
        aVar5.m(C0024a.b(aJ));
        return aVar5.c();
    }
}
