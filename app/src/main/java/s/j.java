package s;

import java.util.ArrayList;
import java.util.Objects;
import r.C0369b;
import r.C0372e;
import r.C0375h;
import s.d;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    static boolean[] f7818a = new boolean[3];

    static void a(int i2, e eVar) {
        Objects.requireNonNull(eVar);
        for (int i4 = 0; i4 < 6; i4++) {
            k kVarD = eVar.f7736A[i4].d();
            d dVar = kVarD.f7819c;
            d dVar2 = dVar.d;
            if (dVar2 != null) {
                if (dVar2.d == dVar) {
                    kVarD.f7822h = 4;
                    dVar2.d().f7822h = 4;
                }
                int iC = kVarD.f7819c.c();
                d.a aVar = kVarD.f7819c.f7723c;
                if (aVar == d.a.RIGHT || aVar == d.a.BOTTOM) {
                    iC = -iC;
                }
                kVarD.i(dVar2.d(), iC);
            }
        }
        k kVarD2 = eVar.f7782s.d();
        k kVarD3 = eVar.f7783t.d();
        k kVarD4 = eVar.u.d();
        k kVarD5 = eVar.f7784v.d();
        boolean z4 = (i2 & 8) == 8;
        boolean z5 = eVar.f7738C[0] == 3 && d(eVar, 0);
        if (kVarD2.f7822h != 4 && kVarD4.f7822h != 4) {
            if (eVar.f7738C[0] == 1 || (z5 && eVar.u() == 8)) {
                d dVar3 = eVar.f7782s.d;
                if (dVar3 == null && eVar.u.d == null) {
                    kVarD2.f7822h = 1;
                    kVarD4.f7822h = 1;
                    if (z4) {
                        kVarD4.h(kVarD2, 1, eVar.r());
                    } else {
                        kVarD4.i(kVarD2, eVar.v());
                    }
                } else if (dVar3 != null && eVar.u.d == null) {
                    kVarD2.f7822h = 1;
                    kVarD4.f7822h = 1;
                    if (z4) {
                        kVarD4.h(kVarD2, 1, eVar.r());
                    } else {
                        kVarD4.i(kVarD2, eVar.v());
                    }
                } else if (dVar3 == null && eVar.u.d != null) {
                    kVarD2.f7822h = 1;
                    kVarD4.f7822h = 1;
                    kVarD2.i(kVarD4, -eVar.v());
                    if (z4) {
                        kVarD2.h(kVarD4, -1, eVar.r());
                    } else {
                        kVarD2.i(kVarD4, -eVar.v());
                    }
                } else if (dVar3 != null && eVar.u.d != null) {
                    kVarD2.f7822h = 2;
                    kVarD4.f7822h = 2;
                    if (z4) {
                        eVar.r().a(kVarD2);
                        eVar.r().a(kVarD4);
                        kVarD2.o(kVarD4, -1, eVar.r());
                        kVarD4.o(kVarD2, 1, eVar.r());
                    } else {
                        kVarD2.n(kVarD4);
                        kVarD4.n(kVarD2);
                    }
                }
            } else if (z5) {
                int iV = eVar.v();
                kVarD2.f7822h = 1;
                kVarD4.f7822h = 1;
                d dVar4 = eVar.f7782s.d;
                if (dVar4 == null && eVar.u.d == null) {
                    if (z4) {
                        kVarD4.h(kVarD2, 1, eVar.r());
                    } else {
                        kVarD4.i(kVarD2, iV);
                    }
                } else if (dVar4 == null || eVar.u.d != null) {
                    if (dVar4 != null || eVar.u.d == null) {
                        if (dVar4 != null && eVar.u.d != null) {
                            if (z4) {
                                eVar.r().a(kVarD2);
                                eVar.r().a(kVarD4);
                            }
                            if (eVar.f7742G == 0.0f) {
                                kVarD2.f7822h = 3;
                                kVarD4.f7822h = 3;
                                kVarD2.n(kVarD4);
                                kVarD4.n(kVarD2);
                            } else {
                                kVarD2.f7822h = 2;
                                kVarD4.f7822h = 2;
                                kVarD2.n(kVarD4);
                                kVarD4.n(kVarD2);
                                eVar.g0(iV);
                            }
                        }
                    } else if (z4) {
                        kVarD2.h(kVarD4, -1, eVar.r());
                    } else {
                        kVarD2.i(kVarD4, -iV);
                    }
                } else if (z4) {
                    kVarD4.h(kVarD2, 1, eVar.r());
                } else {
                    kVarD4.i(kVarD2, iV);
                }
            }
        }
        boolean z6 = eVar.f7738C[1] == 3 && d(eVar, 1);
        if (kVarD3.f7822h == 4 || kVarD5.f7822h == 4) {
            return;
        }
        if (eVar.f7738C[1] != 1 && (!z6 || eVar.u() != 8)) {
            if (z6) {
                int iN = eVar.n();
                kVarD3.f7822h = 1;
                kVarD5.f7822h = 1;
                d dVar5 = eVar.f7783t.d;
                if (dVar5 == null && eVar.f7784v.d == null) {
                    if (z4) {
                        kVarD5.h(kVarD3, 1, eVar.q());
                        return;
                    } else {
                        kVarD5.i(kVarD3, iN);
                        return;
                    }
                }
                if (dVar5 != null && eVar.f7784v.d == null) {
                    if (z4) {
                        kVarD5.h(kVarD3, 1, eVar.q());
                        return;
                    } else {
                        kVarD5.i(kVarD3, iN);
                        return;
                    }
                }
                if (dVar5 == null && eVar.f7784v.d != null) {
                    if (z4) {
                        kVarD3.h(kVarD5, -1, eVar.q());
                        return;
                    } else {
                        kVarD3.i(kVarD5, -iN);
                        return;
                    }
                }
                if (dVar5 == null || eVar.f7784v.d == null) {
                    return;
                }
                if (z4) {
                    eVar.q().a(kVarD3);
                    eVar.r().a(kVarD5);
                }
                if (eVar.f7742G == 0.0f) {
                    kVarD3.f7822h = 3;
                    kVarD5.f7822h = 3;
                    kVarD3.n(kVarD5);
                    kVarD5.n(kVarD3);
                    return;
                }
                kVarD3.f7822h = 2;
                kVarD5.f7822h = 2;
                kVarD3.n(kVarD5);
                kVarD5.n(kVarD3);
                eVar.M(iN);
                if (eVar.f7749Q > 0) {
                    eVar.f7785w.d().g(kVarD3, eVar.f7749Q);
                    return;
                }
                return;
            }
            return;
        }
        d dVar6 = eVar.f7783t.d;
        if (dVar6 == null && eVar.f7784v.d == null) {
            kVarD3.f7822h = 1;
            kVarD5.f7822h = 1;
            if (z4) {
                kVarD5.h(kVarD3, 1, eVar.q());
            } else {
                kVarD5.i(kVarD3, eVar.n());
            }
            d dVar7 = eVar.f7785w;
            if (dVar7.d != null) {
                dVar7.d().f7822h = 1;
                kVarD3.g(eVar.f7785w.d(), -eVar.f7749Q);
                return;
            }
            return;
        }
        if (dVar6 != null && eVar.f7784v.d == null) {
            kVarD3.f7822h = 1;
            kVarD5.f7822h = 1;
            if (z4) {
                kVarD5.h(kVarD3, 1, eVar.q());
            } else {
                kVarD5.i(kVarD3, eVar.n());
            }
            if (eVar.f7749Q > 0) {
                eVar.f7785w.d().g(kVarD3, eVar.f7749Q);
                return;
            }
            return;
        }
        if (dVar6 == null && eVar.f7784v.d != null) {
            kVarD3.f7822h = 1;
            kVarD5.f7822h = 1;
            if (z4) {
                kVarD3.h(kVarD5, -1, eVar.q());
            } else {
                kVarD3.i(kVarD5, -eVar.n());
            }
            if (eVar.f7749Q > 0) {
                eVar.f7785w.d().g(kVarD3, eVar.f7749Q);
                return;
            }
            return;
        }
        if (dVar6 == null || eVar.f7784v.d == null) {
            return;
        }
        kVarD3.f7822h = 2;
        kVarD5.f7822h = 2;
        if (z4) {
            kVarD3.o(kVarD5, -1, eVar.q());
            kVarD5.o(kVarD3, 1, eVar.q());
            eVar.q().a(kVarD3);
            eVar.r().a(kVarD5);
        } else {
            kVarD3.n(kVarD5);
            kVarD5.n(kVarD3);
        }
        if (eVar.f7749Q > 0) {
            eVar.f7785w.d().g(kVarD3, eVar.f7749Q);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x01b2, code lost:
    
        if (r0.f7738C[r30] == 2) goto L200;
     */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0300 A[PHI: r8
      0x0300: PHI (r8v24 float) = (r8v20 float), (r8v18 float) binds: [B:194:0x0358, B:184:0x02fd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c A[PHI: r16 r17
      0x005c: PHI (r16v3 boolean) = (r16v1 boolean), (r16v9 boolean) binds: [B:28:0x005a, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x005c: PHI (r17v3 boolean) = (r17v1 boolean), (r17v9 boolean) binds: [B:28:0x005a, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e A[PHI: r16 r17
      0x005e: PHI (r16v7 boolean) = (r16v1 boolean), (r16v9 boolean) binds: [B:28:0x005a, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x005e: PHI (r17v7 boolean) = (r17v1 boolean), (r17v9 boolean) binds: [B:28:0x005a, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void b(f fVar, C0372e c0372e, int i2) {
        int i4;
        c[] cVarArr;
        int i5;
        int i6;
        c[] cVarArr2;
        int i7;
        int i8;
        boolean z4;
        boolean z5;
        boolean z6;
        c cVar;
        k kVar;
        float fC;
        boolean z7;
        e eVar;
        e eVar2;
        int i9 = 2;
        if (i2 == 0) {
            i4 = fVar.f7792m0;
            cVarArr = fVar.p0;
            i5 = 0;
        } else {
            i4 = fVar.f7793n0;
            cVarArr = fVar.f7794o0;
            i5 = 2;
        }
        f fVar2 = fVar;
        int i10 = 0;
        while (i10 < i4) {
            c cVar2 = cVarArr[i10];
            cVar2.a();
            if (fVar2.w0(4)) {
                e eVar3 = cVar2.f7707a;
                e eVar4 = cVar2.f7709c;
                e eVar5 = cVar2.f7708b;
                e eVar6 = cVar2.d;
                e eVar7 = cVar2.f7710e;
                float f4 = cVar2.f7715k;
                int i11 = fVar2.f7738C[i2];
                if (i2 == 0) {
                    int i12 = eVar7.f7765d0;
                    z4 = i12 == 0;
                    z5 = i12 == 1;
                    z6 = i12 == i9;
                } else {
                    int i13 = eVar7.f7767e0;
                    z4 = i13 == 0;
                    z5 = i13 == 1;
                    if (i13 == i9) {
                    }
                }
                i6 = i4;
                e eVar8 = eVar3;
                float fV = 0.0f;
                float fC2 = 0.0f;
                int i14 = 0;
                int i15 = 0;
                boolean z8 = false;
                while (!z8) {
                    cVarArr2 = cVarArr;
                    if (eVar8.u() != 8) {
                        i14++;
                        fV += i2 == 0 ? eVar8.v() : eVar8.n();
                        eVar2 = eVar8;
                        if (eVar2 != eVar5) {
                            fV += eVar2.f7736A[i5].c();
                        }
                        if (eVar2 != eVar6) {
                            fV += eVar2.f7736A[i5 + 1].c();
                        }
                        fC2 = fC2 + eVar2.f7736A[i5].c() + eVar2.f7736A[i5 + 1].c();
                    } else {
                        eVar2 = eVar8;
                    }
                    d dVar = eVar2.f7736A[i5];
                    int i16 = i14;
                    if (eVar2.u() != 8 && eVar2.f7738C[i2] == 3) {
                        i15++;
                        if (i2 != 0) {
                            if (eVar2.f7768f == 0 && eVar2.f7775k == 0 && eVar2.f7776l == 0) {
                            }
                            i7 = i10;
                            cVar = cVar2;
                            break;
                        }
                        if (eVar2.f7766e == 0 && eVar2.f7771h == 0 && eVar2.f7773i == 0) {
                            if (eVar2.f7742G != 0.0f) {
                            }
                        }
                        i7 = i10;
                        cVar = cVar2;
                        break;
                    }
                    d dVar2 = eVar2.f7736A[i5 + 1].d;
                    if (dVar2 != null) {
                        e eVar9 = dVar2.f7722b;
                        d[] dVarArr = eVar9.f7736A;
                        eVar8 = eVar9;
                        if (dVarArr[i5].d == null || dVarArr[i5].d.f7722b != eVar2) {
                            eVar8 = null;
                        }
                    }
                    if (eVar8 != null) {
                        cVarArr = cVarArr2;
                        i14 = i16;
                    } else {
                        eVar8 = eVar2;
                        cVarArr = cVarArr2;
                        i14 = i16;
                        z8 = true;
                    }
                }
                cVarArr2 = cVarArr;
                e eVar10 = eVar8;
                k kVarD = eVar3.f7736A[i5].d();
                i7 = i10;
                int i17 = i5 + 1;
                k kVarD2 = eVar4.f7736A[i17].d();
                k kVar2 = kVarD.d;
                cVar = cVar2;
                if (kVar2 == null || (kVar = kVarD2.d) == null || kVar2.f7829b != 1 || kVar.f7829b != 1 || (i15 > 0 && i15 != i14)) {
                    i8 = 2;
                } else {
                    if (z6 || z4 || z5) {
                        fC = eVar5 != null ? eVar5.f7736A[i5].c() : 0.0f;
                        if (eVar6 != null) {
                            fC += eVar6.f7736A[i17].c();
                        }
                    } else {
                        fC = 0.0f;
                    }
                    float fC3 = kVarD.d.g;
                    float f5 = kVarD2.d.g;
                    float f6 = (fC3 < f5 ? f5 - fC3 : fC3 - f5) - fV;
                    float f7 = -1.0f;
                    if (i15 <= 0 || i15 != i14) {
                        i8 = 2;
                        if (f6 < 0.0f) {
                            z6 = true;
                            z4 = false;
                            z5 = false;
                        }
                        if (z6) {
                            float f8 = f6 - fC;
                            if (i2 == 0) {
                                eVar = eVar3;
                                f7 = eVar.f7754V;
                            } else {
                                eVar = eVar3;
                                if (i2 == 1) {
                                    f7 = eVar.f7755W;
                                }
                            }
                            float fC4 = (f8 * f7) + fC3;
                            e eVar11 = eVar;
                            while (eVar11 != null) {
                                e eVar12 = eVar11.f7772h0[i2];
                                if (eVar12 != null || eVar11 == eVar4) {
                                    int iV = i2 == 0 ? eVar11.v() : eVar11.n();
                                    float fC5 = fC4 + eVar11.f7736A[i5].c();
                                    eVar11.f7736A[i5].d().l(kVarD.f7821f, fC5);
                                    float f9 = fC5 + iV;
                                    eVar11.f7736A[i17].d().l(kVarD.f7821f, f9);
                                    eVar11.f7736A[i5].d().f(c0372e);
                                    eVar11.f7736A[i17].d().f(c0372e);
                                    fC4 = f9 + eVar11.f7736A[i17].c();
                                }
                                eVar11 = eVar12;
                            }
                        } else {
                            if (z4 || z5) {
                                if (z4 || z5) {
                                    f6 -= fC;
                                }
                                float f10 = f6 / (i14 + 1);
                                if (z5) {
                                    f10 = f6 / (i14 > 1 ? i14 - 1 : 2.0f);
                                }
                                float fC6 = eVar3.u() != 8 ? fC3 + f10 : fC3;
                                z7 = true;
                                if (z5 && i14 > 1) {
                                    fC6 = eVar5.f7736A[i5].c() + fC3;
                                }
                                if (z4 && eVar5 != null) {
                                    fC6 += eVar5.f7736A[i5].c();
                                }
                                e eVar13 = eVar3;
                                while (eVar13 != null) {
                                    e eVar14 = eVar13.f7772h0[i2];
                                    if (eVar14 != null || eVar13 == eVar4) {
                                        float fV2 = i2 == 0 ? eVar13.v() : eVar13.n();
                                        if (eVar13 != eVar5) {
                                            fC6 += eVar13.f7736A[i5].c();
                                        }
                                        eVar13.f7736A[i5].d().l(kVarD.f7821f, fC6);
                                        eVar13.f7736A[i17].d().l(kVarD.f7821f, fC6 + fV2);
                                        eVar13.f7736A[i5].d().f(c0372e);
                                        eVar13.f7736A[i17].d().f(c0372e);
                                        fC6 += fV2 + eVar13.f7736A[i17].c();
                                        if (eVar14 != null) {
                                            if (eVar14.u() != 8) {
                                                fC6 += f10;
                                            }
                                        }
                                    }
                                    eVar13 = eVar14;
                                }
                            }
                            if (!z7) {
                                c(fVar, c0372e, i2, i5, cVar);
                            }
                            fVar2 = fVar;
                        }
                    } else {
                        e eVar15 = eVar10.f7739D;
                        if (eVar15 != null) {
                            i8 = 2;
                        } else {
                            i8 = 2;
                        }
                        float f11 = (f6 + fV) - fC2;
                        e eVar16 = eVar3;
                        while (eVar16 != null) {
                            e eVar17 = eVar16.f7772h0[i2];
                            if (eVar17 != null || eVar16 == eVar4) {
                                float f12 = f11 / i15;
                                if (f4 > 0.0f) {
                                    float[] fArr = eVar16.f7769f0;
                                    f12 = fArr[i2] == -1.0f ? 0.0f : (fArr[i2] * f11) / f4;
                                }
                                if (eVar16.u() == 8) {
                                    f12 = 0.0f;
                                }
                                float fC7 = fC3 + eVar16.f7736A[i5].c();
                                eVar16.f7736A[i5].d().l(kVarD.f7821f, fC7);
                                float f13 = fC7 + f12;
                                eVar16.f7736A[i17].d().l(kVarD.f7821f, f13);
                                eVar16.f7736A[i5].d().f(c0372e);
                                eVar16.f7736A[i17].d().f(c0372e);
                                fC3 = f13 + eVar16.f7736A[i17].c();
                            }
                            eVar16 = eVar17;
                        }
                    }
                    z7 = true;
                    if (!z7) {
                    }
                    fVar2 = fVar;
                }
                z7 = false;
                if (!z7) {
                }
                fVar2 = fVar;
            } else {
                i6 = i4;
                cVarArr2 = cVarArr;
                i7 = i10;
                i8 = i9;
                c(fVar2, c0372e, i2, i5, cVar2);
            }
            i10 = i7 + 1;
            i9 = i8;
            i4 = i6;
            cVarArr = cVarArr2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c A[PHI: r14 r15
      0x003c: PHI (r14v3 boolean) = (r14v1 boolean), (r14v28 boolean) binds: [B:23:0x003a, B:14:0x002b] A[DONT_GENERATE, DONT_INLINE]
      0x003c: PHI (r15v3 boolean) = (r15v1 boolean), (r15v36 boolean) binds: [B:23:0x003a, B:14:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e A[PHI: r14 r15
      0x003e: PHI (r14v26 boolean) = (r14v1 boolean), (r14v28 boolean) binds: [B:23:0x003a, B:14:0x002b] A[DONT_GENERATE, DONT_INLINE]
      0x003e: PHI (r15v34 boolean) = (r15v1 boolean), (r15v36 boolean) binds: [B:23:0x003a, B:14:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013f  */
    /* JADX WARN: Type inference failed for: r2v48, types: [s.e] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [s.e] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void c(f fVar, C0372e c0372e, int i2, int i4, c cVar) {
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        e eVar;
        int i6;
        C0375h c0375h;
        d dVar;
        C0375h c0375h2;
        e eVar2;
        d dVar2;
        C0375h c0375h3;
        C0375h c0375h4;
        e eVar3;
        int size;
        ArrayList<e> arrayList;
        int i7;
        boolean z7;
        int i8;
        boolean z8;
        e eVar4;
        boolean z9;
        int i9;
        e eVar5 = cVar.f7707a;
        e eVar6 = cVar.f7709c;
        e eVar7 = cVar.f7708b;
        e eVar8 = cVar.d;
        e eVar9 = cVar.f7710e;
        float f4 = cVar.f7715k;
        boolean z10 = fVar.f7738C[i2] == 2;
        if (i2 == 0) {
            int i10 = eVar9.f7765d0;
            z4 = i10 == 0;
            z5 = i10 == 1;
            z6 = i10 == 2;
        } else {
            int i11 = eVar9.f7767e0;
            z4 = i11 == 0;
            z5 = i11 == 1;
            if (i11 == 2) {
            }
        }
        ?? r7 = eVar5;
        boolean z11 = false;
        while (true) {
            if (z11) {
                break;
            }
            d dVar3 = r7.f7736A[i4];
            int i12 = (z10 || z6) ? 1 : 4;
            int iC = dVar3.c();
            float f5 = f4;
            d dVar4 = dVar3.d;
            if (dVar4 != null && r7 != eVar5) {
                iC = dVar4.c() + iC;
            }
            int i13 = iC;
            if (z6 && r7 != eVar5 && r7 != eVar7) {
                z7 = z11;
                z8 = z5;
                i8 = 6;
            } else if (z4 && z10) {
                z7 = z11;
                z8 = z5;
                i8 = 4;
            } else {
                z7 = z11;
                i8 = i12;
                z8 = z5;
            }
            d dVar5 = dVar3.d;
            if (dVar5 != null) {
                if (r7 == eVar7) {
                    z9 = z4;
                    eVar4 = eVar9;
                    c0372e.g(dVar3.f7727i, dVar5.f7727i, i13, 5);
                } else {
                    eVar4 = eVar9;
                    z9 = z4;
                    c0372e.g(dVar3.f7727i, dVar5.f7727i, i13, 6);
                }
                c0372e.d(dVar3.f7727i, dVar3.d.f7727i, i13, i8);
            } else {
                eVar4 = eVar9;
                z9 = z4;
            }
            if (z10) {
                if (r7.u() == 8 || r7.f7738C[i2] != 3) {
                    i9 = 0;
                } else {
                    d[] dVarArr = r7.f7736A;
                    i9 = 0;
                    c0372e.g(dVarArr[i4 + 1].f7727i, dVarArr[i4].f7727i, 0, 5);
                }
                c0372e.g(r7.f7736A[i4].f7727i, fVar.f7736A[i4].f7727i, i9, 6);
            }
            d dVar6 = r7.f7736A[i4 + 1].d;
            if (dVar6 != null) {
                ?? r2 = dVar6.f7722b;
                d[] dVarArr2 = r2.f7736A;
                if (dVarArr2[i4].d != null && dVarArr2[i4].d.f7722b == r7) {
                    c0375h = r2;
                }
            }
            if (c0375h != null) {
                r7 = c0375h;
                z11 = z7;
            } else {
                z11 = true;
            }
            z5 = z8;
            f4 = f5;
            z4 = z9;
            eVar9 = eVar4;
            r7 = r7;
        }
        e eVar10 = eVar9;
        float f6 = f4;
        boolean z12 = z4;
        boolean z13 = z5;
        if (eVar8 != null) {
            d[] dVarArr3 = eVar6.f7736A;
            int i14 = i4 + 1;
            if (dVarArr3[i14].d != null) {
                d dVar7 = eVar8.f7736A[i14];
                c0372e.i(dVar7.f7727i, dVarArr3[i14].d.f7727i, -dVar7.c(), 5);
            }
        }
        if (z10) {
            int i15 = i4 + 1;
            C0375h c0375h5 = fVar.f7736A[i15].f7727i;
            d[] dVarArr4 = eVar6.f7736A;
            c0372e.g(c0375h5, dVarArr4[i15].f7727i, dVarArr4[i15].c(), 6);
        }
        ArrayList<e> arrayList2 = cVar.f7712h;
        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
            float f7 = (!cVar.f7718n || cVar.p) ? f6 : cVar.f7714j;
            float f8 = 0.0f;
            float f9 = 0.0f;
            e eVar11 = null;
            int i16 = 0;
            while (i16 < size) {
                e eVar12 = arrayList2.get(i16);
                float f10 = eVar12.f7769f0[i2];
                if (f10 < f8) {
                    if (cVar.p) {
                        d[] dVarArr5 = eVar12.f7736A;
                        c0372e.d(dVarArr5[i4 + 1].f7727i, dVarArr5[i4].f7727i, 0, 4);
                        arrayList = arrayList2;
                        i7 = size;
                        i16++;
                        size = i7;
                        arrayList2 = arrayList;
                        f8 = 0.0f;
                    } else {
                        f10 = 1.0f;
                        f8 = 0.0f;
                    }
                }
                if (f10 == f8) {
                    d[] dVarArr6 = eVar12.f7736A;
                    c0372e.d(dVarArr6[i4 + 1].f7727i, dVarArr6[i4].f7727i, 0, 6);
                    arrayList = arrayList2;
                    i7 = size;
                    i16++;
                    size = i7;
                    arrayList2 = arrayList;
                    f8 = 0.0f;
                } else {
                    if (eVar11 != null) {
                        d[] dVarArr7 = eVar11.f7736A;
                        C0375h c0375h6 = dVarArr7[i4].f7727i;
                        int i17 = i4 + 1;
                        C0375h c0375h7 = dVarArr7[i17].f7727i;
                        d[] dVarArr8 = eVar12.f7736A;
                        arrayList = arrayList2;
                        C0375h c0375h8 = dVarArr8[i4].f7727i;
                        C0375h c0375h9 = dVarArr8[i17].f7727i;
                        i7 = size;
                        C0369b c0369bO = c0372e.o();
                        c0369bO.d(f9, f7, f10, c0375h6, c0375h7, c0375h8, c0375h9);
                        c0372e.c(c0369bO);
                    } else {
                        arrayList = arrayList2;
                        i7 = size;
                    }
                    f9 = f10;
                    eVar11 = eVar12;
                    i16++;
                    size = i7;
                    arrayList2 = arrayList;
                    f8 = 0.0f;
                }
            }
        }
        if (eVar7 != null && (eVar7 == eVar8 || z6)) {
            d[] dVarArr9 = eVar5.f7736A;
            d dVar8 = dVarArr9[i4];
            d[] dVarArr10 = eVar6.f7736A;
            int i18 = i4 + 1;
            d dVar9 = dVarArr10[i18];
            C0375h c0375h10 = dVarArr9[i4].d != null ? dVarArr9[i4].d.f7727i : null;
            C0375h c0375h11 = dVarArr10[i18].d != null ? dVarArr10[i18].d.f7727i : null;
            if (eVar7 == eVar8) {
                d[] dVarArr11 = eVar7.f7736A;
                dVar8 = dVarArr11[i4];
                dVar9 = dVarArr11[i18];
            }
            if (c0375h10 != null && c0375h11 != null) {
                c0372e.b(dVar8.f7727i, c0375h10, dVar8.c(), i2 == 0 ? eVar10.f7754V : eVar10.f7755W, c0375h11, dVar9.f7727i, dVar9.c(), 5);
            }
        } else if (!z12 || eVar7 == null) {
            int i19 = 8;
            if (z13 && eVar7 != null) {
                int i20 = cVar.f7714j;
                boolean z14 = i20 > 0 && cVar.f7713i == i20;
                e eVar13 = eVar7;
                e eVar14 = eVar13;
                while (eVar13 != null) {
                    e eVar15 = eVar13.f7772h0[i2];
                    while (eVar15 != null && eVar15.u() == i19) {
                        eVar15 = eVar15.f7772h0[i2];
                    }
                    if (eVar13 == eVar7 || eVar13 == eVar8 || eVar15 == null) {
                        eVar = eVar14;
                        i6 = i19;
                    } else {
                        e eVar16 = eVar15 == eVar8 ? null : eVar15;
                        d dVar10 = eVar13.f7736A[i4];
                        C0375h c0375h12 = dVar10.f7727i;
                        int i21 = i4 + 1;
                        C0375h c0375h13 = eVar14.f7736A[i21].f7727i;
                        int iC2 = dVar10.c();
                        int iC3 = eVar13.f7736A[i21].c();
                        if (eVar16 != null) {
                            dVar = eVar16.f7736A[i4];
                            c0375h2 = dVar.f7727i;
                            d dVar11 = dVar.d;
                            c0375h = dVar11 != null ? dVar11.f7727i : null;
                        } else {
                            d[] dVarArr12 = eVar13.f7736A;
                            d dVar12 = dVarArr12[i21].d;
                            C0375h c0375h14 = dVar12 != null ? dVar12.f7727i : null;
                            c0375h = dVarArr12[i21].f7727i;
                            dVar = dVar12;
                            c0375h2 = c0375h14;
                        }
                        int iC4 = dVar != null ? dVar.c() + iC3 : iC3;
                        int iC5 = eVar14.f7736A[i21].c() + iC2;
                        int i22 = z14 ? 6 : 4;
                        if (c0375h12 == null || c0375h13 == null || c0375h2 == null || c0375h == null) {
                            eVar2 = eVar16;
                            eVar = eVar14;
                            i6 = 8;
                        } else {
                            eVar2 = eVar16;
                            int i23 = iC4;
                            eVar = eVar14;
                            i6 = 8;
                            c0372e.b(c0375h12, c0375h13, iC5, 0.5f, c0375h2, c0375h, i23, i22);
                        }
                        eVar15 = eVar2;
                    }
                    if (eVar13.u() == i6) {
                        eVar13 = eVar;
                    }
                    i19 = i6;
                    eVar14 = eVar13;
                    eVar13 = eVar15;
                }
                d dVar13 = eVar7.f7736A[i4];
                d dVar14 = eVar5.f7736A[i4].d;
                int i24 = i4 + 1;
                d dVar15 = eVar8.f7736A[i24];
                d dVar16 = eVar6.f7736A[i24].d;
                if (dVar14 == null) {
                    i5 = 5;
                } else if (eVar7 != eVar8) {
                    i5 = 5;
                    c0372e.d(dVar13.f7727i, dVar14.f7727i, dVar13.c(), 5);
                } else {
                    i5 = 5;
                    if (dVar16 != null) {
                        c0372e.b(dVar13.f7727i, dVar14.f7727i, dVar13.c(), 0.5f, dVar15.f7727i, dVar16.f7727i, dVar15.c(), 5);
                    }
                }
                if (dVar16 != null && eVar7 != eVar8) {
                    c0372e.d(dVar15.f7727i, dVar16.f7727i, -dVar15.c(), i5);
                }
            }
        } else {
            int i25 = cVar.f7714j;
            boolean z15 = i25 > 0 && cVar.f7713i == i25;
            e eVar17 = eVar7;
            e eVar18 = eVar17;
            while (eVar17 != null) {
                e eVar19 = eVar17.f7772h0[i2];
                while (eVar19 != null && eVar19.u() == 8) {
                    eVar19 = eVar19.f7772h0[i2];
                }
                if (eVar19 != null || eVar17 == eVar8) {
                    d dVar17 = eVar17.f7736A[i4];
                    C0375h c0375h15 = dVar17.f7727i;
                    d dVar18 = dVar17.d;
                    C0375h c0375h16 = dVar18 != null ? dVar18.f7727i : null;
                    if (eVar18 != eVar17) {
                        c0375h16 = eVar18.f7736A[i4 + 1].f7727i;
                    } else if (eVar17 == eVar7 && eVar18 == eVar17) {
                        d[] dVarArr13 = eVar5.f7736A;
                        c0375h16 = dVarArr13[i4].d != null ? dVarArr13[i4].d.f7727i : null;
                    }
                    int iC6 = dVar17.c();
                    int i26 = i4 + 1;
                    int iC7 = eVar17.f7736A[i26].c();
                    if (eVar19 != null) {
                        dVar2 = eVar19.f7736A[i4];
                        C0375h c0375h17 = dVar2.f7727i;
                        c0375h4 = eVar17.f7736A[i26].f7727i;
                        c0375h3 = c0375h17;
                    } else {
                        dVar2 = eVar6.f7736A[i26].d;
                        c0375h3 = dVar2 != null ? dVar2.f7727i : null;
                        c0375h4 = eVar17.f7736A[i26].f7727i;
                    }
                    if (dVar2 != null) {
                        iC7 += dVar2.c();
                    }
                    if (eVar18 != null) {
                        iC6 += eVar18.f7736A[i26].c();
                    }
                    if (c0375h15 == null || c0375h16 == null || c0375h3 == null || c0375h4 == null) {
                        eVar3 = eVar19;
                    } else {
                        if (eVar17 == eVar7) {
                            iC6 = eVar7.f7736A[i4].c();
                        }
                        int i27 = iC6;
                        eVar3 = eVar19;
                        c0372e.b(c0375h15, c0375h16, i27, 0.5f, c0375h3, c0375h4, eVar17 == eVar8 ? eVar8.f7736A[i26].c() : iC7, z15 ? 6 : 4);
                    }
                }
                if (eVar17.u() != 8) {
                    eVar18 = eVar17;
                }
                eVar17 = eVar3;
            }
        }
        if ((z12 || z13) && eVar7 != null) {
            d[] dVarArr14 = eVar7.f7736A;
            d dVar19 = dVarArr14[i4];
            int i28 = i4 + 1;
            d dVar20 = eVar8.f7736A[i28];
            d dVar21 = dVar19.d;
            C0375h c0375h18 = dVar21 != null ? dVar21.f7727i : null;
            d dVar22 = dVar20.d;
            C0375h c0375h19 = dVar22 != null ? dVar22.f7727i : null;
            if (eVar6 != eVar8) {
                d dVar23 = eVar6.f7736A[i28].d;
                c0375h19 = dVar23 != null ? dVar23.f7727i : null;
            }
            if (eVar7 == eVar8) {
                dVar19 = dVarArr14[i4];
                dVar20 = dVarArr14[i28];
            }
            if (c0375h18 == null || c0375h19 == null) {
                return;
            }
            c0372e.b(dVar19.f7727i, c0375h18, dVar19.c(), 0.5f, c0375h19, dVar20.f7727i, eVar8.f7736A[i28].c(), 5);
        }
    }

    private static boolean d(e eVar, int i2) {
        int[] iArr = eVar.f7738C;
        if (iArr[i2] != 3) {
            return false;
        }
        if (eVar.f7742G != 0.0f) {
            int i4 = iArr[i2 != 0 ? (char) 0 : (char) 1];
            return false;
        }
        if (i2 == 0) {
            if (eVar.f7766e != 0 || eVar.f7771h != 0 || eVar.f7773i != 0) {
                return false;
            }
        } else if (eVar.f7768f != 0 || eVar.f7775k != 0 || eVar.f7776l != 0) {
            return false;
        }
        return true;
    }

    static void e(e eVar, int i2, int i4) {
        int i5 = i2 * 2;
        int i6 = i5 + 1;
        eVar.f7736A[i5].d().f7821f = eVar.f7739D.f7782s.d();
        eVar.f7736A[i5].d().g = i4;
        eVar.f7736A[i5].d().f7829b = 1;
        eVar.f7736A[i6].d().f7821f = eVar.f7736A[i5].d();
        eVar.f7736A[i6].d().g = eVar.p(i2);
        eVar.f7736A[i6].d().f7829b = 1;
    }
}
