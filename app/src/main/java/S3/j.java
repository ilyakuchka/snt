package S3;

import L3.A;
import L3.s;
import L3.t;
import L3.w;
import L3.x;
import S3.l;
import X3.y;
import X3.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j implements Q3.d {
    private static final List<String> g = M3.c.m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: h, reason: collision with root package name */
    private static final List<String> f1462h = M3.c.m("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    private final P3.f f1463a;

    /* renamed from: b, reason: collision with root package name */
    private final Q3.f f1464b;

    /* renamed from: c, reason: collision with root package name */
    private final f f1465c;
    private volatile l d;

    /* renamed from: e, reason: collision with root package name */
    private final x f1466e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f1467f;

    public j(w wVar, P3.f fVar, Q3.f fVar2, f fVar3) {
        f3.c.d(wVar, "client");
        f3.c.d(fVar, "connection");
        this.f1463a = fVar;
        this.f1464b = fVar2;
        this.f1465c = fVar3;
        List<x> listS = wVar.s();
        x xVar = x.f549o;
        this.f1466e = listS.contains(xVar) ? xVar : x.f548n;
    }

    @Override // Q3.d
    public final y a(A a2) {
        l lVar = this.d;
        f3.c.b(lVar);
        return lVar.p();
    }

    @Override // Q3.d
    public final X3.w b(L3.y yVar, long j2) {
        l lVar = this.d;
        f3.c.b(lVar);
        return lVar.n();
    }

    @Override // Q3.d
    public final void c() throws IOException {
        l lVar = this.d;
        f3.c.b(lVar);
        ((l.a) lVar.n()).close();
    }

    @Override // Q3.d
    public final void cancel() {
        this.f1467f = true;
        l lVar = this.d;
        if (lVar == null) {
            return;
        }
        lVar.f(b.CANCEL);
    }

    @Override // Q3.d
    public final void d() throws IOException {
        this.f1465c.flush();
    }

    @Override // Q3.d
    public final void e(L3.y yVar) throws IOException {
        if (this.d != null) {
            return;
        }
        int i2 = 0;
        boolean z4 = yVar.a() != null;
        s sVarE = yVar.e();
        ArrayList arrayList = new ArrayList(sVarE.size() + 4);
        arrayList.add(new c(c.f1375f, yVar.g()));
        X3.g gVar = c.g;
        t tVarH = yVar.h();
        f3.c.d(tVarH, "url");
        String strC = tVarH.c();
        String strE = tVarH.e();
        if (strE != null) {
            strC = strC + '?' + ((Object) strE);
        }
        arrayList.add(new c(gVar, strC));
        String strD = yVar.d("Host");
        if (strD != null) {
            arrayList.add(new c(c.f1377i, strD));
        }
        arrayList.add(new c(c.f1376h, yVar.h().p()));
        int size = sVarE.size();
        while (i2 < size) {
            int i4 = i2 + 1;
            String strG = sVarE.g(i2);
            Locale locale = Locale.US;
            f3.c.c(locale, "US");
            String lowerCase = strG.toLowerCase(locale);
            f3.c.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!g.contains(lowerCase) || (f3.c.a(lowerCase, "te") && f3.c.a(sVarE.k(i2), "trailers"))) {
                arrayList.add(new c(lowerCase, sVarE.k(i2)));
            }
            i2 = i4;
        }
        this.d = this.f1465c.G0(arrayList, z4);
        if (this.f1467f) {
            l lVar = this.d;
            f3.c.b(lVar);
            lVar.f(b.CANCEL);
            throw new IOException("Canceled");
        }
        l lVar2 = this.d;
        f3.c.b(lVar2);
        z zVarV = lVar2.v();
        long jG = this.f1464b.g();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zVarV.g(jG);
        l lVar3 = this.d;
        f3.c.b(lVar3);
        lVar3.E().g(this.f1464b.i());
    }

    @Override // Q3.d
    public final long f(A a2) {
        if (Q3.e.a(a2)) {
            return M3.c.l(a2);
        }
        return 0L;
    }

    @Override // Q3.d
    public final A.a g(boolean z4) throws IOException, NumberFormatException {
        l lVar = this.d;
        f3.c.b(lVar);
        s sVarC = lVar.C();
        x xVar = this.f1466e;
        f3.c.d(xVar, "protocol");
        s.a aVar = new s.a();
        int size = sVarC.size();
        int i2 = 0;
        Q3.i iVarA = null;
        while (i2 < size) {
            int i4 = i2 + 1;
            String strG = sVarC.g(i2);
            String strK = sVarC.k(i2);
            if (f3.c.a(strG, ":status")) {
                iVarA = Q3.i.d.a(f3.c.h("HTTP/1.1 ", strK));
            } else if (!f1462h.contains(strG)) {
                aVar.b(strG, strK);
            }
            i2 = i4;
        }
        if (iVarA == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        A.a aVar2 = new A.a();
        aVar2.o(xVar);
        aVar2.f(iVarA.f1222b);
        aVar2.l(iVarA.f1223c);
        aVar2.j(aVar.c());
        if (z4 && aVar2.g() == 100) {
            return null;
        }
        return aVar2;
    }

    @Override // Q3.d
    public final P3.f h() {
        return this.f1463a;
    }
}
