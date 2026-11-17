package Q3;

import L3.A;
import L3.InterfaceC0154e;
import L3.u;
import L3.y;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class f implements u.a {

    /* renamed from: a, reason: collision with root package name */
    private final P3.e f1210a;

    /* renamed from: b, reason: collision with root package name */
    private final List<u> f1211b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1212c;
    private final P3.c d;

    /* renamed from: e, reason: collision with root package name */
    private final y f1213e;

    /* renamed from: f, reason: collision with root package name */
    private final int f1214f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1215h;

    /* renamed from: i, reason: collision with root package name */
    private int f1216i;

    /* JADX WARN: Multi-variable type inference failed */
    public f(P3.e eVar, List<? extends u> list, int i2, P3.c cVar, y yVar, int i4, int i5, int i6) {
        f3.c.d(eVar, "call");
        f3.c.d(list, "interceptors");
        f3.c.d(yVar, "request");
        this.f1210a = eVar;
        this.f1211b = list;
        this.f1212c = i2;
        this.d = cVar;
        this.f1213e = yVar;
        this.f1214f = i4;
        this.g = i5;
        this.f1215h = i6;
    }

    public static f c(f fVar, int i2, P3.c cVar, y yVar, int i4) {
        if ((i4 & 1) != 0) {
            i2 = fVar.f1212c;
        }
        int i5 = i2;
        if ((i4 & 2) != 0) {
            cVar = fVar.d;
        }
        P3.c cVar2 = cVar;
        if ((i4 & 4) != 0) {
            yVar = fVar.f1213e;
        }
        y yVar2 = yVar;
        int i6 = (i4 & 8) != 0 ? fVar.f1214f : 0;
        int i7 = (i4 & 16) != 0 ? fVar.g : 0;
        int i8 = (i4 & 32) != 0 ? fVar.f1215h : 0;
        Objects.requireNonNull(fVar);
        f3.c.d(yVar2, "request");
        return new f(fVar.f1210a, fVar.f1211b, i5, cVar2, yVar2, i6, i7, i8);
    }

    public final InterfaceC0154e a() {
        return this.f1210a;
    }

    public final L3.i b() {
        P3.c cVar = this.d;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    public final P3.e d() {
        return this.f1210a;
    }

    public final int e() {
        return this.f1214f;
    }

    public final P3.c f() {
        return this.d;
    }

    public final int g() {
        return this.g;
    }

    public final y h() {
        return this.f1213e;
    }

    public final int i() {
        return this.f1215h;
    }

    public final A j(y yVar) throws IOException {
        f3.c.d(yVar, "request");
        if (!(this.f1212c < this.f1211b.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f1216i++;
        P3.c cVar = this.d;
        if (cVar != null) {
            if (!cVar.j().e(yVar.h())) {
                StringBuilder sbD = D2.e.d("network interceptor ");
                sbD.append(this.f1211b.get(this.f1212c - 1));
                sbD.append(" must retain the same host and port");
                throw new IllegalStateException(sbD.toString().toString());
            }
            if (!(this.f1216i == 1)) {
                StringBuilder sbD2 = D2.e.d("network interceptor ");
                sbD2.append(this.f1211b.get(this.f1212c - 1));
                sbD2.append(" must call proceed() exactly once");
                throw new IllegalStateException(sbD2.toString().toString());
            }
        }
        f fVarC = c(this, this.f1212c + 1, null, yVar, 58);
        u uVar = this.f1211b.get(this.f1212c);
        A a2 = uVar.a(fVarC);
        if (a2 == null) {
            throw new NullPointerException("interceptor " + uVar + " returned null");
        }
        if (this.d != null) {
            if (!(this.f1212c + 1 >= this.f1211b.size() || fVarC.f1216i == 1)) {
                throw new IllegalStateException(("network interceptor " + uVar + " must call proceed() exactly once").toString());
            }
        }
        if (a2.f() != null) {
            return a2;
        }
        throw new IllegalStateException(("interceptor " + uVar + " returned a response with no body").toString());
    }

    public final int k() {
        return this.g;
    }

    public final y l() {
        return this.f1213e;
    }
}
