package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import q.C0365a;

/* loaded from: classes.dex */
final class z {

    /* renamed from: a, reason: collision with root package name */
    final C0365a<RecyclerView.x, a> f4272a = new C0365a<>();

    /* renamed from: b, reason: collision with root package name */
    final q.e<RecyclerView.x> f4273b = new q.e<>();

    static class a {
        static E.b<a> d = new E.c(20);

        /* renamed from: a, reason: collision with root package name */
        int f4274a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.i.c f4275b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.i.c f4276c;

        private a() {
        }

        static a a() {
            a aVarB = d.b();
            return aVarB == null ? new a() : aVarB;
        }

        static void b(a aVar) {
            aVar.f4274a = 0;
            aVar.f4275b = null;
            aVar.f4276c = null;
            d.a(aVar);
        }
    }

    z() {
    }

    private RecyclerView.i.c d(RecyclerView.x xVar, int i2) {
        a aVarL;
        RecyclerView.i.c cVar;
        int iE = this.f4272a.e(xVar);
        if (iE >= 0 && (aVarL = this.f4272a.l(iE)) != null) {
            int i4 = aVarL.f4274a;
            if ((i4 & i2) != 0) {
                int i5 = (~i2) & i4;
                aVarL.f4274a = i5;
                if (i2 == 4) {
                    cVar = aVarL.f4275b;
                } else {
                    if (i2 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVarL.f4276c;
                }
                if ((i5 & 12) == 0) {
                    this.f4272a.j(iE);
                    a.b(aVarL);
                }
                return cVar;
            }
        }
        return null;
    }

    final void a(RecyclerView.x xVar) {
        a orDefault = this.f4272a.getOrDefault(xVar, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f4272a.put(xVar, orDefault);
        }
        orDefault.f4274a |= 1;
    }

    final void b(RecyclerView.x xVar, RecyclerView.i.c cVar) {
        a orDefault = this.f4272a.getOrDefault(xVar, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f4272a.put(xVar, orDefault);
        }
        orDefault.f4276c = cVar;
        orDefault.f4274a |= 8;
    }

    final void c(RecyclerView.x xVar, RecyclerView.i.c cVar) {
        a orDefault = this.f4272a.getOrDefault(xVar, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f4272a.put(xVar, orDefault);
        }
        orDefault.f4275b = cVar;
        orDefault.f4274a |= 4;
    }

    final RecyclerView.i.c e(RecyclerView.x xVar) {
        return d(xVar, 8);
    }

    final RecyclerView.i.c f(RecyclerView.x xVar) {
        return d(xVar, 4);
    }

    final void g(RecyclerView.x xVar) {
        a orDefault = this.f4272a.getOrDefault(xVar, null);
        if (orDefault == null) {
            return;
        }
        orDefault.f4274a &= -2;
    }

    final void h(RecyclerView.x xVar) {
        int iH = this.f4273b.h() - 1;
        while (true) {
            if (iH < 0) {
                break;
            }
            if (xVar == this.f4273b.i(iH)) {
                this.f4273b.g(iH);
                break;
            }
            iH--;
        }
        a aVarRemove = this.f4272a.remove(xVar);
        if (aVarRemove != null) {
            a.b(aVarRemove);
        }
    }
}
