package Y0;

import W0.d;
import Y0.h;
import c1.n;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class y implements h, d.a<Object> {

    /* renamed from: i, reason: collision with root package name */
    private final h.a f2067i;

    /* renamed from: j, reason: collision with root package name */
    private final i<?> f2068j;

    /* renamed from: k, reason: collision with root package name */
    private int f2069k;

    /* renamed from: l, reason: collision with root package name */
    private int f2070l = -1;

    /* renamed from: m, reason: collision with root package name */
    private V0.f f2071m;

    /* renamed from: n, reason: collision with root package name */
    private List<c1.n<File, ?>> f2072n;

    /* renamed from: o, reason: collision with root package name */
    private int f2073o;
    private volatile n.a<?> p;

    /* renamed from: q, reason: collision with root package name */
    private File f2074q;

    /* renamed from: r, reason: collision with root package name */
    private z f2075r;

    y(i<?> iVar, h.a aVar) {
        this.f2068j = iVar;
        this.f2067i = aVar;
    }

    @Override // Y0.h
    public final boolean a() {
        ArrayList arrayList = (ArrayList) this.f2068j.c();
        if (arrayList.isEmpty()) {
            return false;
        }
        List<Class<?>> listM = this.f2068j.m();
        if (listM.isEmpty()) {
            if (File.class.equals(this.f2068j.q())) {
                return false;
            }
            StringBuilder sbD = D2.e.d("Failed to find any load path from ");
            sbD.append(this.f2068j.i());
            sbD.append(" to ");
            sbD.append(this.f2068j.q());
            throw new IllegalStateException(sbD.toString());
        }
        while (true) {
            List<c1.n<File, ?>> list = this.f2072n;
            if (list != null) {
                if (this.f2073o < list.size()) {
                    this.p = null;
                    boolean z4 = false;
                    while (!z4) {
                        if (!(this.f2073o < this.f2072n.size())) {
                            break;
                        }
                        List<c1.n<File, ?>> list2 = this.f2072n;
                        int i2 = this.f2073o;
                        this.f2073o = i2 + 1;
                        this.p = list2.get(i2).a(this.f2074q, this.f2068j.s(), this.f2068j.f(), this.f2068j.k());
                        if (this.p != null && this.f2068j.t(this.p.f4421c.a())) {
                            this.p.f4421c.c(this.f2068j.l(), this);
                            z4 = true;
                        }
                    }
                    return z4;
                }
            }
            int i4 = this.f2070l + 1;
            this.f2070l = i4;
            if (i4 >= listM.size()) {
                int i5 = this.f2069k + 1;
                this.f2069k = i5;
                if (i5 >= arrayList.size()) {
                    return false;
                }
                this.f2070l = 0;
            }
            V0.f fVar = (V0.f) arrayList.get(this.f2069k);
            Class<?> cls = listM.get(this.f2070l);
            this.f2075r = new z(this.f2068j.b(), fVar, this.f2068j.o(), this.f2068j.s(), this.f2068j.f(), this.f2068j.r(cls), cls, this.f2068j.k());
            File fileB = this.f2068j.d().b(this.f2075r);
            this.f2074q = fileB;
            if (fileB != null) {
                this.f2071m = fVar;
                this.f2072n = this.f2068j.j(fileB);
                this.f2073o = 0;
            }
        }
    }

    @Override // Y0.h
    public final void cancel() {
        n.a<?> aVar = this.p;
        if (aVar != null) {
            aVar.f4421c.cancel();
        }
    }

    @Override // W0.d.a
    public final void e(Exception exc) {
        this.f2067i.e(this.f2075r, exc, this.p.f4421c, V0.a.f1750l);
    }

    @Override // W0.d.a
    public final void f(Object obj) {
        this.f2067i.g(this.f2071m, obj, this.p.f4421c, V0.a.f1750l, this.f2075r);
    }
}
