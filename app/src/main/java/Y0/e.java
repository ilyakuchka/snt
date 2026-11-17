package Y0;

import W0.d;
import Y0.h;
import c1.n;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
final class e implements h, d.a<Object> {

    /* renamed from: i, reason: collision with root package name */
    private final List<V0.f> f1914i;

    /* renamed from: j, reason: collision with root package name */
    private final i<?> f1915j;

    /* renamed from: k, reason: collision with root package name */
    private final h.a f1916k;

    /* renamed from: l, reason: collision with root package name */
    private int f1917l;

    /* renamed from: m, reason: collision with root package name */
    private V0.f f1918m;

    /* renamed from: n, reason: collision with root package name */
    private List<c1.n<File, ?>> f1919n;

    /* renamed from: o, reason: collision with root package name */
    private int f1920o;
    private volatile n.a<?> p;

    /* renamed from: q, reason: collision with root package name */
    private File f1921q;

    e(i<?> iVar, h.a aVar) {
        List<V0.f> listC = iVar.c();
        this.f1917l = -1;
        this.f1914i = listC;
        this.f1915j = iVar;
        this.f1916k = aVar;
    }

    @Override // Y0.h
    public final boolean a() {
        while (true) {
            List<c1.n<File, ?>> list = this.f1919n;
            if (list != null) {
                if (this.f1920o < list.size()) {
                    this.p = null;
                    boolean z4 = false;
                    while (!z4) {
                        if (!(this.f1920o < this.f1919n.size())) {
                            break;
                        }
                        List<c1.n<File, ?>> list2 = this.f1919n;
                        int i2 = this.f1920o;
                        this.f1920o = i2 + 1;
                        this.p = list2.get(i2).a(this.f1921q, this.f1915j.s(), this.f1915j.f(), this.f1915j.k());
                        if (this.p != null && this.f1915j.t(this.p.f4421c.a())) {
                            this.p.f4421c.c(this.f1915j.l(), this);
                            z4 = true;
                        }
                    }
                    return z4;
                }
            }
            int i4 = this.f1917l + 1;
            this.f1917l = i4;
            if (i4 >= this.f1914i.size()) {
                return false;
            }
            V0.f fVar = this.f1914i.get(this.f1917l);
            File fileB = this.f1915j.d().b(new f(fVar, this.f1915j.o()));
            this.f1921q = fileB;
            if (fileB != null) {
                this.f1918m = fVar;
                this.f1919n = this.f1915j.j(fileB);
                this.f1920o = 0;
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
        this.f1916k.e(this.f1918m, exc, this.p.f4421c, V0.a.f1749k);
    }

    @Override // W0.d.a
    public final void f(Object obj) {
        this.f1916k.g(this.f1918m, obj, this.p.f4421c, V0.a.f1749k, this.f1918m);
    }

    e(List<V0.f> list, i<?> iVar, h.a aVar) {
        this.f1917l = -1;
        this.f1914i = list;
        this.f1915j = iVar;
        this.f1916k = aVar;
    }
}
