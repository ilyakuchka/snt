package P3;

import L3.C0150a;
import L3.D;
import L3.p;
import L3.t;
import L3.w;
import P3.m;
import S3.r;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final j f993a;

    /* renamed from: b, reason: collision with root package name */
    private final C0150a f994b;

    /* renamed from: c, reason: collision with root package name */
    private final e f995c;
    private final p d;

    /* renamed from: e, reason: collision with root package name */
    private m.a f996e;

    /* renamed from: f, reason: collision with root package name */
    private m f997f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f998h;

    /* renamed from: i, reason: collision with root package name */
    private int f999i;

    /* renamed from: j, reason: collision with root package name */
    private D f1000j;

    public d(j jVar, C0150a c0150a, e eVar, p pVar) {
        f3.c.d(jVar, "connectionPool");
        f3.c.d(eVar, "call");
        f3.c.d(pVar, "eventListener");
        this.f993a = jVar;
        this.f994b = c0150a;
        this.f995c = eVar;
        this.d = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final f b(int i2, int i4, int i5, boolean z4, boolean z5) throws IOException {
        List<D> listA;
        boolean z6;
        Socket socketU;
        while (!this.f995c.q()) {
            f fVarK = this.f995c.k();
            if (fVarK != null) {
                synchronized (fVarK) {
                    socketU = (fVarK.l() || !e(fVarK.v().a().l())) ? this.f995c.u() : null;
                }
                if (this.f995c.k() != null) {
                    if (!(socketU == null)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    z6 = z5;
                } else {
                    if (socketU != null) {
                        M3.c.f(socketU);
                    }
                    p pVar = this.d;
                    e eVar = this.f995c;
                    Objects.requireNonNull(pVar);
                    f3.c.d(eVar, "call");
                    this.g = 0;
                    this.f998h = 0;
                    this.f999i = 0;
                    if (this.f993a.a(this.f994b, this.f995c, null, false)) {
                        D dC = this.f1000j;
                        try {
                            if (dC != null) {
                                this.f1000j = null;
                            } else {
                                m.a aVar = this.f996e;
                                if (aVar == null || !aVar.b()) {
                                    m mVar = this.f997f;
                                    if (mVar == null) {
                                        mVar = new m(this.f994b, this.f995c.j().n(), this.f995c, this.d);
                                        this.f997f = mVar;
                                    }
                                    m.a aVarC = mVar.c();
                                    this.f996e = aVarC;
                                    listA = aVarC.a();
                                    if (this.f995c.q()) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.f993a.a(this.f994b, this.f995c, listA, false)) {
                                        fVarK = this.f995c.k();
                                        f3.c.b(fVarK);
                                        this.d.a(this.f995c, fVarK);
                                    } else {
                                        dC = aVarC.c();
                                        f fVar = new f(this.f993a, dC);
                                        this.f995c.w(fVar);
                                        fVar.e(i2, i4, i5, z4, this.f995c, this.d);
                                        this.f995c.w(null);
                                        this.f995c.j().n().a(fVar.v());
                                        if (this.f993a.a(this.f994b, this.f995c, listA, true)) {
                                            synchronized (fVar) {
                                                this.f993a.e(fVar);
                                                this.f995c.c(fVar);
                                            }
                                            this.d.a(this.f995c, fVar);
                                            z6 = z5;
                                            fVarK = fVar;
                                        } else {
                                            f fVarK2 = this.f995c.k();
                                            f3.c.b(fVarK2);
                                            this.f1000j = dC;
                                            M3.c.f(fVar.y());
                                            this.d.a(this.f995c, fVarK2);
                                            fVarK = fVarK2;
                                        }
                                    }
                                } else {
                                    m.a aVar2 = this.f996e;
                                    f3.c.b(aVar2);
                                    dC = aVar2.c();
                                }
                            }
                            fVar.e(i2, i4, i5, z4, this.f995c, this.d);
                            this.f995c.w(null);
                            this.f995c.j().n().a(fVar.v());
                            if (this.f993a.a(this.f994b, this.f995c, listA, true)) {
                            }
                        } catch (Throwable th) {
                            this.f995c.w(null);
                            throw th;
                        }
                        listA = null;
                        f fVar2 = new f(this.f993a, dC);
                        this.f995c.w(fVar2);
                    } else {
                        fVarK = this.f995c.k();
                        f3.c.b(fVarK);
                        this.d.a(this.f995c, fVarK);
                    }
                    z6 = z5;
                }
            } else {
                this.g = 0;
                this.f998h = 0;
                this.f999i = 0;
                if (this.f993a.a(this.f994b, this.f995c, null, false)) {
                }
                z6 = z5;
            }
            if (fVarK.q(z6)) {
                return fVarK;
            }
            fVarK.u();
            if (this.f1000j == null) {
                m.a aVar3 = this.f996e;
                if (aVar3 == null ? true : aVar3.b()) {
                    continue;
                } else {
                    m mVar2 = this.f997f;
                    if (!(mVar2 != null ? mVar2.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final Q3.d a(w wVar, Q3.f fVar) {
        f3.c.d(wVar, "client");
        try {
            return b(fVar.e(), fVar.g(), fVar.i(), wVar.w(), !f3.c.a(fVar.h().g(), "GET")).s(wVar, fVar);
        } catch (l e2) {
            this.f(e2.c());
            throw e2;
        } catch (IOException e4) {
            this.f(e4);
            throw new l(e4);
        }
    }

    public final C0150a c() {
        return this.f994b;
    }

    public final boolean d() {
        m mVar;
        f fVarK;
        int i2 = this.g;
        boolean z4 = false;
        if (i2 == 0 && this.f998h == 0 && this.f999i == 0) {
            return false;
        }
        if (this.f1000j != null) {
            return true;
        }
        D dV = null;
        if (i2 <= 1 && this.f998h <= 1 && this.f999i <= 0 && (fVarK = this.f995c.k()) != null) {
            synchronized (fVarK) {
                if (fVarK.m() == 0 && M3.c.b(fVarK.v().a().l(), this.f994b.l())) {
                    dV = fVarK.v();
                }
            }
        }
        if (dV != null) {
            this.f1000j = dV;
            return true;
        }
        m.a aVar = this.f996e;
        if (aVar != null && aVar.b()) {
            z4 = true;
        }
        if (z4 || (mVar = this.f997f) == null) {
            return true;
        }
        return mVar.a();
    }

    public final boolean e(t tVar) {
        f3.c.d(tVar, "url");
        t tVarL = this.f994b.l();
        return tVar.j() == tVarL.j() && f3.c.a(tVar.g(), tVarL.g());
    }

    public final void f(IOException iOException) {
        f3.c.d(iOException, "e");
        this.f1000j = null;
        if ((iOException instanceof r) && ((r) iOException).f1519i == S3.b.REFUSED_STREAM) {
            this.g++;
        } else if (iOException instanceof S3.a) {
            this.f998h++;
        } else {
            this.f999i++;
        }
    }
}
