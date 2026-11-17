package s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import s.d;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public List<e> f7804a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7805b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f7806c;
    List<e> d;

    /* renamed from: e, reason: collision with root package name */
    List<e> f7807e;

    /* renamed from: f, reason: collision with root package name */
    HashSet<e> f7808f;
    HashSet<e> g;

    /* renamed from: h, reason: collision with root package name */
    List<e> f7809h;

    /* renamed from: i, reason: collision with root package name */
    List<e> f7810i;

    g(List<e> list) {
        this.f7805b = false;
        this.f7806c = new int[]{-1, -1};
        this.d = new ArrayList();
        this.f7807e = new ArrayList();
        this.f7808f = new HashSet<>();
        this.g = new HashSet<>();
        this.f7809h = new ArrayList();
        this.f7810i = new ArrayList();
        this.f7804a = list;
    }

    private void c(ArrayList<e> arrayList, e eVar) {
        e eVar2;
        if (eVar.f7764c0) {
            return;
        }
        arrayList.add(eVar);
        eVar.f7764c0 = true;
        if (eVar.A()) {
            return;
        }
        if (eVar instanceof i) {
            i iVar = (i) eVar;
            int i2 = iVar.f7817j0;
            for (int i4 = 0; i4 < i2; i4++) {
                c(arrayList, iVar.f7816i0[i4]);
            }
        }
        int length = eVar.f7736A.length;
        for (int i5 = 0; i5 < length; i5++) {
            d dVar = eVar.f7736A[i5].d;
            if (dVar != null && (eVar2 = dVar.f7722b) != eVar.f7739D) {
                c(arrayList, eVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(e eVar) {
        int iV;
        if (!eVar.f7760a0 || eVar.A()) {
            return;
        }
        d dVar = eVar.u.d;
        boolean z4 = dVar != null;
        if (!z4) {
            dVar = eVar.f7782s.d;
        }
        if (dVar != null) {
            e eVar2 = dVar.f7722b;
            if (!eVar2.f7762b0) {
                d(eVar2);
            }
            d.a aVar = dVar.f7723c;
            if (aVar == d.a.RIGHT) {
                e eVar3 = dVar.f7722b;
                iV = eVar3.v() + eVar3.f7744I;
            } else {
                iV = aVar == d.a.LEFT ? dVar.f7722b.f7744I : 0;
            }
        }
        int iC = z4 ? iV - eVar.u.c() : iV + eVar.v() + eVar.f7782s.c();
        eVar.P(iC - eVar.v(), iC);
        d dVar2 = eVar.f7785w.d;
        if (dVar2 != null) {
            e eVar4 = dVar2.f7722b;
            if (!eVar4.f7762b0) {
                d(eVar4);
            }
            e eVar5 = dVar2.f7722b;
            int i2 = (eVar5.f7745J + eVar5.f7749Q) - eVar.f7749Q;
            eVar.b0(i2, eVar.f7741F + i2);
            eVar.f7762b0 = true;
            return;
        }
        d dVar3 = eVar.f7784v.d;
        boolean z5 = dVar3 != null;
        if (!z5) {
            dVar3 = eVar.f7783t.d;
        }
        if (dVar3 != null) {
            e eVar6 = dVar3.f7722b;
            if (!eVar6.f7762b0) {
                d(eVar6);
            }
            d.a aVar2 = dVar3.f7723c;
            if (aVar2 == d.a.BOTTOM) {
                e eVar7 = dVar3.f7722b;
                iC = eVar7.f7745J + eVar7.n();
            } else if (aVar2 == d.a.TOP) {
                iC = dVar3.f7722b.f7745J;
            }
        }
        int iC2 = z5 ? iC - eVar.f7784v.c() : iC + eVar.n() + eVar.f7783t.c();
        eVar.b0(iC2 - eVar.n(), iC2);
        eVar.f7762b0 = true;
    }

    final void a(e eVar, int i2) {
        if (i2 == 0) {
            this.f7808f.add(eVar);
        } else if (i2 == 1) {
            this.g.add(eVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<s.e>] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList, java.util.List<s.e>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList, java.util.List<s.e>] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList, java.util.List<s.e>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList, java.util.List<s.e>] */
    final List<e> b() {
        if (!this.f7809h.isEmpty()) {
            return this.f7809h;
        }
        int size = this.f7804a.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.f7804a.get(i2);
            if (!eVar.f7760a0) {
                c(this.f7809h, eVar);
            }
        }
        this.f7810i.clear();
        this.f7810i.addAll(this.f7804a);
        this.f7810i.removeAll(this.f7809h);
        return this.f7809h;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<s.e>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList, java.util.List<s.e>] */
    final void e() {
        int size = this.f7810i.size();
        for (int i2 = 0; i2 < size; i2++) {
            d((e) this.f7810i.get(i2));
        }
    }

    g(List<e> list, boolean z4) {
        this.f7805b = false;
        this.f7806c = new int[]{-1, -1};
        this.d = new ArrayList();
        this.f7807e = new ArrayList();
        this.f7808f = new HashSet<>();
        this.g = new HashSet<>();
        this.f7809h = new ArrayList();
        this.f7810i = new ArrayList();
        this.f7804a = list;
        this.f7805b = true;
    }
}
