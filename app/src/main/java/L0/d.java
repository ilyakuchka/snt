package L0;

import N.e;
import androidx.lifecycle.LiveData;
import com.android.mmt.storage.bugle.BugleDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class d {
    public void A() {
    }

    public abstract List<Long> B(Set<Long> set);

    public abstract List<Long> C(Set<Long> set);

    public abstract long D(long j2);

    public void E(a... aVarArr) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z4 = false;
        for (a aVar : aVarArr) {
            aVar.H(jCurrentTimeMillis);
            if (aVar.k() > 0) {
                z4 = true;
            }
        }
        g(aVarArr);
        if (z4) {
            I();
        }
    }

    public final a F(a aVar, boolean z4, int i2) {
        boolean z5;
        long jF = aVar.f();
        a aVarT = BugleDatabase.y().x().t(jF);
        if (aVarT == null) {
            aVarT = new a();
            aVarT.z(jF);
            z5 = true;
        } else {
            z5 = false;
        }
        if (aVarT.b() < aVar.b()) {
            aVarT.s(aVar.b());
            aVarT.C(aVar.i());
            aVarT.D(aVar.j());
        }
        if (!aVarT.o()) {
            aVarT.v(aVar.d());
        }
        if (!aVarT.p()) {
            aVarT.x(aVar.e());
        }
        if (!aVarT.q()) {
            aVarT.u(aVar.c());
        }
        if (z4) {
            if (i2 == 1) {
                aVarT.B(0);
                aVarT.G(aVar.m() + 1);
            }
            if (i2 == 3) {
                aVarT.y(true);
            } else {
                aVarT.A(aVar.g() + 1);
            }
        }
        if (z5) {
            long[] jArrP = BugleDatabase.y().x().p(aVarT);
            if (jArrP != null && jArrP.length > 0) {
                aVarT.z(jArrP[0]);
            }
        } else {
            BugleDatabase.y().x().E(aVarT);
        }
        return aVarT;
    }

    public abstract void G(List<Long> list);

    public void H(a... aVarArr) {
        boolean z4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a aVar : aVarArr) {
            aVar.H(jCurrentTimeMillis);
            if (aVar.k() > 0) {
                a aVarT = t(-103L);
                if (aVarT == null) {
                    aVarT = new a();
                    aVarT.z(-103L);
                    z4 = true;
                } else if (aVarT.b() <= aVar.b()) {
                    z4 = false;
                }
                aVarT.C(aVar.i());
                aVarT.D(aVar.j());
                aVarT.s(aVar.b());
                aVarT.H(aVar.n());
                aVarT.A(aVar.g());
                if (aVarT.f() > 0) {
                    aVarT.u(aVar.c());
                    aVarT.G(aVar.m());
                    aVarT.v(aVar.d());
                    aVarT.x(aVar.e());
                    aVarT.B(aVar.h());
                    aVarT.F(aVar.l());
                    aVarT.E(aVar.k());
                }
                if (z4) {
                    e(aVarT);
                } else {
                    g(aVarT);
                }
            }
            a aVarT2 = t(aVar.f());
            if (aVarT2 == null) {
                arrayList.add(aVar);
            } else {
                a aVarA = c.a(aVar, aVarT2);
                if (aVarA != null) {
                    arrayList2.add(aVarA);
                }
            }
        }
        if (arrayList.size() > 0) {
            e((a[]) arrayList.toArray(new a[0]));
        }
        if (arrayList2.size() > 0) {
            g((a[]) arrayList2.toArray(new a[0]));
        }
    }

    public void I() {
        a aVarY = y();
        a aVarT = t(-103L);
        if (aVarY == null) {
            if (aVarT != null) {
                i(aVarT);
                return;
            }
            return;
        }
        aVarY.z(-103L);
        aVarY.E(0);
        if (aVarT != null) {
            aVarY.z(aVarT.f());
        } else {
            aVarY.z(0L);
            p(aVarY);
        }
    }

    abstract void a(long j2);

    abstract void b(List<Long> list);

    abstract e.a<Integer, a> c(List<Integer> list, int i2);

    abstract e.a<Integer, a> d(List<Integer> list, int i2);

    abstract long[] e(a... aVarArr);

    abstract void f(List<Long> list);

    abstract void g(a... aVarArr);

    public void h(long j2) {
        a aVarT = t(j2);
        boolean z4 = aVarT != null && aVarT.k() > 0;
        a(j2);
        if (z4) {
            I();
        }
    }

    public void i(a... aVarArr) {
        k(aVarArr);
    }

    public boolean j(long j2) {
        h(j2);
        return true;
    }

    public void k(a... aVarArr) {
        if (aVarArr.length == 0) {
            return;
        }
        for (a aVar : aVarArr) {
            h(aVar.f());
        }
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/List<Ljava/lang/Long;>;Z)Z */
    public void l(List list, boolean z4) {
        Iterator it = ((ArrayList) c.b(list)).iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            if (list2 != null && list2.size() > 0) {
                m(list2);
            }
        }
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/util/List<Ljava/lang/Long;>;Z)Z */
    public void m(List list) {
        if (list.size() > 0) {
            b(list);
        }
    }

    public final e.a<Integer, a> n(boolean z4, List<Integer> list) {
        return z4 ? d(list, 0) : c(list, 0);
    }

    public final e.a<Integer, a> o(boolean z4, List<Integer> list, int i2) {
        return z4 ? d(list, i2) : c(list, i2);
    }

    public long[] p(a... aVarArr) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z4 = false;
        for (a aVar : aVarArr) {
            aVar.H(jCurrentTimeMillis);
            if (aVar.k() > 0) {
                z4 = true;
            }
        }
        long[] jArrE = e(aVarArr);
        if (z4) {
            I();
        }
        return jArrE;
    }

    public abstract void q(List<Long> list, int i2);

    public abstract void r(List list);

    public void s(List<Long> list) {
        Iterator it = ((ArrayList) c.b(list)).iterator();
        while (it.hasNext()) {
            List<Long> list2 = (List) it.next();
            if (list2 != null && list2.size() > 0) {
                f(list2);
            }
        }
    }

    public abstract a t(long j2);

    public abstract a u(long j2);

    abstract List<Long> v(List<Integer> list);

    abstract List<Long> w(List<Long> list, List<Integer> list2);

    public abstract LiveData<Integer> x(List<Integer> list, int i2);

    abstract a y();

    public List<Long> z(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        if (!K0.b.a().e()) {
            arrayList.add(1);
            arrayList.add(2);
        }
        return ((ArrayList) list).size() == 0 ? v(arrayList) : w(list, arrayList);
    }
}
