package Q3;

import L3.A;
import L3.l;
import L3.m;
import L3.s;
import L3.t;
import X3.g;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final X3.g f1207a;

    /* renamed from: b, reason: collision with root package name */
    private static final X3.g f1208b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1209c = 0;

    static {
        g.a aVar = X3.g.f1847l;
        f1207a = aVar.b("\"\\");
        f1208b = aVar.b("\t ,=");
    }

    public static final boolean a(A a2) {
        if (f3.c.a(a2.o0().g(), "HEAD")) {
            return false;
        }
        int iE0 = a2.e0();
        return (((iE0 >= 100 && iE0 < 200) || iE0 == 204 || iE0 == 304) && M3.c.l(a2) == -1 && !i3.f.q("chunked", A.h0(a2, "Transfer-Encoding"))) ? false : true;
    }

    public static final void b(m mVar, t tVar, s sVar) {
        f3.c.d(mVar, "<this>");
        f3.c.d(tVar, "url");
        f3.c.d(sVar, "headers");
        if (mVar == m.f466b) {
            return;
        }
        List<l> listB = l.f454j.b(tVar, sVar);
        if (listB.isEmpty()) {
            return;
        }
        mVar.a(tVar, listB);
    }
}
