package s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import s.d;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0379a {
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList, java.util.List, java.util.List<s.g>] */
    public static void a(f fVar) {
        if ((fVar.t0() & 32) != 32) {
            g(fVar);
            return;
        }
        fVar.f7801x0 = true;
        fVar.f7795r0 = false;
        fVar.f7796s0 = false;
        fVar.f7797t0 = false;
        ArrayList<e> arrayList = fVar.f7838i0;
        ?? r32 = fVar.q0;
        int[] iArr = fVar.f7738C;
        boolean z4 = iArr[0] == 2;
        boolean z5 = iArr[1] == 2;
        boolean z6 = z4 || z5;
        r32.clear();
        for (e eVar : arrayList) {
            eVar.p = null;
            eVar.f7764c0 = false;
            eVar.E();
        }
        for (e eVar2 : arrayList) {
            if (eVar2.p == null) {
                g gVar = new g(new ArrayList(), true);
                r32.add(gVar);
                if (!h(eVar2, gVar, r32, z6)) {
                    g(fVar);
                    fVar.f7801x0 = false;
                    return;
                }
            }
        }
        int iMax = 0;
        int iMax2 = 0;
        for (g gVar2 : r32) {
            iMax = Math.max(iMax, b(gVar2, 0));
            iMax2 = Math.max(iMax2, b(gVar2, 1));
        }
        if (z4) {
            fVar.Q(1);
            fVar.g0(iMax);
            fVar.f7795r0 = true;
            fVar.f7796s0 = true;
            fVar.f7798u0 = iMax;
        }
        if (z5) {
            fVar.c0(1);
            fVar.M(iMax2);
            fVar.f7795r0 = true;
            fVar.f7797t0 = true;
            fVar.f7799v0 = iMax2;
        }
        f(r32, 0, fVar.v());
        f(r32, 1, fVar.n());
    }

    private static int b(g gVar, int i2) {
        int i4 = i2 * 2;
        Objects.requireNonNull(gVar);
        List<e> list = i2 == 0 ? gVar.d : i2 == 1 ? gVar.f7807e : null;
        int size = list.size();
        int iMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = list.get(i5);
            d[] dVarArr = eVar.f7736A;
            int i6 = i4 + 1;
            iMax = Math.max(iMax, c(eVar, i2, dVarArr[i6].d == null || !(dVarArr[i4].d == null || dVarArr[i6].d == null), 0));
        }
        gVar.f7806c[i2] = iMax;
        return iMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int c(e eVar, int i2, boolean z4, int i4) {
        int iN;
        int i5;
        int i6;
        int i7;
        int i8;
        int iV;
        int i9;
        int i10;
        int i11;
        int i12;
        d[] dVarArr;
        e eVar2;
        int i13;
        int iMax;
        int iMax2 = 0;
        if (!eVar.f7760a0) {
            return 0;
        }
        boolean z5 = eVar.f7785w.d != null && i2 == 1;
        if (z4) {
            i5 = eVar.f7749Q;
            iN = eVar.n() - eVar.f7749Q;
            i7 = i2 * 2;
            i6 = i7 + 1;
        } else {
            int iN2 = eVar.n();
            iN = eVar.f7749Q;
            i5 = iN2 - iN;
            i6 = i2 * 2;
            i7 = i6 + 1;
        }
        d[] dVarArr2 = eVar.f7736A;
        if (dVarArr2[i6].d == null || dVarArr2[i7].d != null) {
            i8 = 1;
        } else {
            i8 = -1;
            int i14 = i6;
            i6 = i7;
            i7 = i14;
        }
        int i15 = z5 ? i4 - i5 : i4;
        int iC = (dVarArr2[i7].c() * i8) + d(eVar, i2);
        int i16 = i15 + iC;
        int iV2 = (i2 == 0 ? eVar.v() : eVar.n()) * i8;
        Iterator<m> it = eVar.f7736A[i7].d().f7828a.iterator();
        while (it.hasNext()) {
            iMax2 = Math.max(iMax2, c(((k) it.next()).f7819c.f7722b, i2, z4, i16));
        }
        int iMax3 = 0;
        for (Iterator<m> it2 = eVar.f7736A[i6].d().f7828a.iterator(); it2.hasNext(); it2 = it2) {
            iMax3 = Math.max(iMax3, c(((k) it2.next()).f7819c.f7722b, i2, z4, iV2 + i16));
        }
        if (z5) {
            iMax2 -= i5;
            iV = iMax3 + iN;
        } else {
            iV = iMax3 + ((i2 == 0 ? eVar.v() : eVar.n()) * i8);
        }
        int i17 = 1;
        if (i2 == 1) {
            Iterator<m> it3 = eVar.f7785w.d().f7828a.iterator();
            int i18 = 0;
            while (it3.hasNext()) {
                Iterator<m> it4 = it3;
                k kVar = (k) it3.next();
                if (i8 == i17) {
                    iMax = Math.max(i18, c(kVar.f7819c.f7722b, i2, z4, i5 + i16));
                    i13 = i6;
                } else {
                    int i19 = i18;
                    i13 = i6;
                    iMax = Math.max(i19, c(kVar.f7819c.f7722b, i2, z4, (iN * i8) + i16));
                }
                it3 = it4;
                i6 = i13;
                i18 = iMax;
                i17 = 1;
            }
            int i20 = i18;
            i9 = i6;
            i10 = (eVar.f7785w.d().f7828a.size() <= 0 || z5) ? i20 : i8 == 1 ? i20 + i5 : i20 - iN;
        } else {
            i9 = i6;
            i10 = 0;
        }
        int iMax4 = Math.max(iMax2, Math.max(iV, i10)) + iC;
        int i21 = iV2 + i16;
        if (i8 == -1) {
            i21 = i16;
            i16 = i21;
        }
        if (z4) {
            j.e(eVar, i2, i16);
            eVar.L(i16, i21, i2);
        } else {
            eVar.p.a(eVar, i2);
            if (i2 != 0) {
                i11 = 1;
                if (i2 == 1) {
                    eVar.L = i16;
                }
                if (i2 != 0) {
                    i12 = eVar.f7738C[0];
                } else {
                    i12 = 0;
                    if (i2 == i11) {
                        i12 = eVar.f7738C[i11];
                    }
                }
                if (i12 == 3 && eVar.f7742G != 0.0f) {
                    eVar.p.a(eVar, i2);
                }
                dVarArr = eVar.f7736A;
                if (dVarArr[i7].d != null && dVarArr[i9].d != null && dVarArr[i7].d.f7722b == (eVar2 = eVar.f7739D) && dVarArr[i9].d.f7722b == eVar2) {
                    eVar.p.a(eVar, i2);
                }
                return iMax4;
            }
            eVar.f7746K = i16;
        }
        i11 = 1;
        if (i2 != 0) {
        }
        if (i12 == 3) {
            eVar.p.a(eVar, i2);
        }
        dVarArr = eVar.f7736A;
        if (dVarArr[i7].d != null) {
            eVar.p.a(eVar, i2);
        }
        return iMax4;
    }

    private static int d(e eVar, int i2) {
        d dVar;
        int i4 = i2 * 2;
        d[] dVarArr = eVar.f7736A;
        d dVar2 = dVarArr[i4];
        d dVar3 = dVarArr[i4 + 1];
        d dVar4 = dVar2.d;
        if (dVar4 == null) {
            return 0;
        }
        e eVar2 = dVar4.f7722b;
        e eVar3 = eVar.f7739D;
        if (eVar2 != eVar3 || (dVar = dVar3.d) == null || dVar.f7722b != eVar3) {
            return 0;
        }
        return (int) ((((eVar3.p(i2) - dVar2.c()) - dVar3.c()) - eVar.p(i2)) * (i2 == 0 ? eVar.f7754V : eVar.f7755W));
    }

    private static int e(e eVar) {
        int[] iArr = eVar.f7738C;
        if (iArr[0] == 3) {
            int iN = (int) (eVar.f7743H == 0 ? eVar.n() * eVar.f7742G : eVar.n() / eVar.f7742G);
            eVar.g0(iN);
            return iN;
        }
        if (iArr[1] != 3) {
            return -1;
        }
        int iV = (int) (eVar.f7743H == 1 ? eVar.v() * eVar.f7742G : eVar.v() / eVar.f7742G);
        eVar.M(iV);
        return iV;
    }

    public static void f(List<g> list, int i2, int i4) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = list.get(i5);
            Objects.requireNonNull(gVar);
            HashSet<e> hashSet = null;
            if (i2 == 0) {
                hashSet = gVar.f7808f;
            } else if (i2 == 1) {
                hashSet = gVar.g;
            }
            for (e eVar : hashSet) {
                if (eVar.f7760a0) {
                    int i6 = i2 * 2;
                    d[] dVarArr = eVar.f7736A;
                    d dVar = dVarArr[i6];
                    d dVar2 = dVarArr[i6 + 1];
                    if ((dVar.d == null || dVar2.d == null) ? false : true) {
                        j.e(eVar, i2, dVar.c() + d(eVar, i2));
                    } else {
                        if (eVar.f7742G != 0.0f) {
                            if ((i2 == 0 ? eVar.f7738C[0] : i2 == 1 ? eVar.f7738C[1] : 0) == 3) {
                                int iE = e(eVar);
                                int i7 = (int) eVar.f7736A[i6].d().g;
                                dVar2.d().f7821f = dVar.d();
                                dVar2.d().g = iE;
                                dVar2.d().f7829b = 1;
                                eVar.L(i7, i7 + iE, i2);
                            }
                        }
                        int i8 = i4 - (i2 == 0 ? eVar.f7746K : i2 == 1 ? eVar.L : 0);
                        int iP = i8 - eVar.p(i2);
                        eVar.L(iP, i8, i2);
                        j.e(eVar, i2, iP);
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<s.g>] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<s.g>] */
    private static void g(f fVar) {
        fVar.q0.clear();
        fVar.q0.add(0, new g(fVar.f7838i0));
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.util.ArrayList, java.util.List<s.e>] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.ArrayList, java.util.List<s.e>] */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.util.ArrayList, java.util.List<s.e>] */
    /* JADX WARN: Type inference failed for: r3v30, types: [java.util.ArrayList, java.util.List<s.e>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean h(e eVar, g gVar, List<g> list, boolean z4) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        if (eVar == null) {
            return true;
        }
        eVar.f7762b0 = false;
        f fVar = (f) eVar.f7739D;
        g gVar2 = eVar.p;
        if (gVar2 != null) {
            if (gVar2 != gVar) {
                gVar.f7804a.addAll(gVar2.f7804a);
                gVar.d.addAll(eVar.p.d);
                gVar.f7807e.addAll(eVar.p.f7807e);
                g gVar3 = eVar.p;
                if (!gVar3.f7805b) {
                    gVar.f7805b = false;
                }
                list.remove(gVar3);
                Iterator<e> it = eVar.p.f7804a.iterator();
                while (it.hasNext()) {
                    it.next().p = gVar;
                }
            }
            return true;
        }
        eVar.f7760a0 = true;
        gVar.f7804a.add(eVar);
        eVar.p = gVar;
        d dVar5 = eVar.f7782s.d;
        if (dVar5 == null && eVar.u.d == null && eVar.f7783t.d == null && eVar.f7784v.d == null && eVar.f7785w.d == null && eVar.f7788z.d == null) {
            gVar.f7805b = false;
            fVar.f7801x0 = false;
            eVar.f7760a0 = false;
            if (z4) {
                return false;
            }
        }
        d dVar6 = eVar.f7783t.d;
        if (dVar6 != null && (dVar4 = eVar.f7784v.d) != null) {
            int i2 = fVar.f7738C[1];
            if (z4) {
                gVar.f7805b = false;
                fVar.f7801x0 = false;
                eVar.f7760a0 = false;
                return false;
            }
            e eVar2 = dVar6.f7722b;
            e eVar3 = eVar.f7739D;
            if (eVar2 != eVar3 || dVar4.f7722b != eVar3) {
                gVar.f7805b = false;
                fVar.f7801x0 = false;
                eVar.f7760a0 = false;
            }
        }
        if (dVar5 != null && (dVar3 = eVar.u.d) != null) {
            int i4 = fVar.f7738C[0];
            if (z4) {
                gVar.f7805b = false;
                fVar.f7801x0 = false;
                eVar.f7760a0 = false;
                return false;
            }
            e eVar4 = dVar5.f7722b;
            e eVar5 = eVar.f7739D;
            if (eVar4 != eVar5 || dVar3.f7722b != eVar5) {
                gVar.f7805b = false;
                fVar.f7801x0 = false;
                eVar.f7760a0 = false;
            }
        }
        int[] iArr = eVar.f7738C;
        if (((iArr[0] == 3) ^ (iArr[1] == 3)) && eVar.f7742G != 0.0f) {
            e(eVar);
        } else if (iArr[0] == 3 || iArr[1] == 3) {
            gVar.f7805b = false;
            fVar.f7801x0 = false;
            eVar.f7760a0 = false;
            if (z4) {
                return false;
            }
        }
        d dVar7 = eVar.f7782s.d;
        if ((dVar7 != null || eVar.u.d != null) && ((dVar7 == null || dVar7.f7722b != eVar.f7739D || eVar.u.d != null) && ((dVar = eVar.u.d) == null || dVar.f7722b != eVar.f7739D || dVar7 != null))) {
            if (dVar7 != null) {
                e eVar6 = dVar7.f7722b;
                e eVar7 = eVar.f7739D;
                if (eVar6 == eVar7 && dVar != null && dVar.f7722b == eVar7) {
                    if (eVar.f7788z.d == null && !(eVar instanceof h) && !(eVar instanceof i)) {
                        gVar.d.add(eVar);
                    }
                }
            }
        }
        d dVar8 = eVar.f7783t.d;
        if ((dVar8 != null || eVar.f7784v.d != null) && ((dVar8 == null || dVar8.f7722b != eVar.f7739D || eVar.f7784v.d != null) && ((dVar2 = eVar.f7784v.d) == null || dVar2.f7722b != eVar.f7739D || dVar8 != null))) {
            if (dVar8 != null) {
                e eVar8 = dVar8.f7722b;
                e eVar9 = eVar.f7739D;
                if (eVar8 == eVar9 && dVar2 != null && dVar2.f7722b == eVar9) {
                    if (eVar.f7788z.d == null && eVar.f7785w.d == null && !(eVar instanceof h) && !(eVar instanceof i)) {
                        gVar.f7807e.add(eVar);
                    }
                }
            }
        }
        if (eVar instanceof i) {
            gVar.f7805b = false;
            fVar.f7801x0 = false;
            eVar.f7760a0 = false;
            if (z4) {
                return false;
            }
            i iVar = (i) eVar;
            for (int i5 = 0; i5 < iVar.f7817j0; i5++) {
                if (!h(iVar.f7816i0[i5], gVar, list, z4)) {
                    return false;
                }
            }
        }
        int length = eVar.f7736A.length;
        for (int i6 = 0; i6 < length; i6++) {
            d dVar9 = eVar.f7736A[i6];
            d dVar10 = dVar9.d;
            if (dVar10 != null && dVar10.f7722b != eVar.f7739D) {
                if (dVar9.f7723c == d.a.CENTER) {
                    gVar.f7805b = false;
                    fVar.f7801x0 = false;
                    eVar.f7760a0 = false;
                    if (z4) {
                        return false;
                    }
                } else {
                    k kVarD = dVar9.d();
                    d dVar11 = dVar9.d;
                    if (dVar11 != null && dVar11.d != dVar9) {
                        dVar11.d().a(kVarD);
                    }
                }
                if (!h(dVar9.d.f7722b, gVar, list, z4)) {
                    return false;
                }
            }
        }
        return true;
    }
}
