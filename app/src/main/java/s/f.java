package s;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import r.C0372e;
import s.d;

/* loaded from: classes.dex */
public final class f extends o {

    /* renamed from: l0, reason: collision with root package name */
    private n f7791l0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f7789j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    protected C0372e f7790k0 = new C0372e();

    /* renamed from: m0, reason: collision with root package name */
    int f7792m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    int f7793n0 = 0;

    /* renamed from: o0, reason: collision with root package name */
    c[] f7794o0 = new c[4];
    c[] p0 = new c[4];
    public List<g> q0 = new ArrayList();

    /* renamed from: r0, reason: collision with root package name */
    public boolean f7795r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f7796s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f7797t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    public int f7798u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    public int f7799v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    private int f7800w0 = 7;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f7801x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f7802y0 = false;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f7803z0 = false;

    private void A0() {
        this.f7792m0 = 0;
        this.f7793n0 = 0;
    }

    public final void B0(int i2) {
        this.f7800w0 = i2;
    }

    public final void C0(boolean z4) {
        this.f7789j0 = z4;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<s.g>] */
    @Override // s.o, s.e
    public final void D() {
        this.f7790k0.x();
        this.q0.clear();
        this.f7801x0 = false;
        super.D();
    }

    public final void D0() {
        k kVarD = g(d.a.LEFT).d();
        k kVarD2 = g(d.a.TOP).d();
        kVarD.l(null, 0.0f);
        kVarD2.l(null, 0.0f);
    }

    @Override // s.e
    public final void c(int i2) {
        j.a(i2, this);
        int size = this.f7838i0.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f7838i0.get(i4).c(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fd  */
    /* JADX WARN: Type inference failed for: r0v14, types: [s.e] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.ArrayList, java.util.List<s.g>] */
    /* JADX WARN: Type inference failed for: r0v38, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v39, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v41, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList, java.util.List<s.g>] */
    /* JADX WARN: Type inference failed for: r0v74, types: [java.util.ArrayList, java.util.List<s.g>] */
    /* JADX WARN: Type inference failed for: r0v75, types: [java.util.ArrayList, java.util.List<s.g>] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.ArrayList, java.util.List<s.g>] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.util.ArrayList, java.util.List<s.g>] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v3, types: [s.e] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.util.ArrayList, java.util.List<s.g>] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.ArrayList, java.util.List<s.g>] */
    @Override // s.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o0() {
        char c2;
        int i2;
        int i4;
        char c4;
        boolean z4;
        int i5;
        int i6;
        boolean z5;
        int iMax;
        ?? r32;
        boolean z6;
        int iMax2;
        boolean z7;
        char c5;
        int i7 = this.f7744I;
        int i8 = this.f7745J;
        int i9 = 0;
        int iMax3 = Math.max(0, v());
        int iMax4 = Math.max(0, n());
        this.f7802y0 = false;
        this.f7803z0 = false;
        if (this.f7739D != null) {
            if (this.f7791l0 == null) {
                this.f7791l0 = new n(this);
            }
            this.f7791l0.b(this);
            this.f7744I = 0;
            this.f7745J = 0;
            e eVar = this.f7739D;
            if (eVar != null && (eVar instanceof f)) {
            }
            int size = this.f7737B.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f7737B.get(i10).i();
            }
            F(this.f7790k0.q());
        } else {
            this.f7744I = 0;
            this.f7745J = 0;
        }
        int i11 = 32;
        int i12 = 1;
        if (this.f7800w0 != 0) {
            if (!w0(8)) {
                y0();
            }
            if (!w0(32)) {
                if (!w0(8)) {
                    c(this.f7800w0);
                }
                D0();
            }
            this.f7790k0.f7667f = true;
        } else {
            this.f7790k0.f7667f = false;
        }
        int[] iArr = this.f7738C;
        int i13 = iArr[1];
        int i14 = iArr[0];
        A0();
        if (this.q0.size() == 0) {
            this.q0.clear();
            this.q0.add(0, new g(this.f7838i0));
        }
        int size2 = this.q0.size();
        ArrayList<e> arrayList = this.f7838i0;
        int[] iArr2 = this.f7738C;
        boolean z8 = iArr2[0] == 2 || iArr2[1] == 2;
        boolean z9 = false;
        int i15 = 0;
        while (i15 < size2 && !this.f7801x0) {
            if (((g) this.q0.get(i15)).f7805b) {
                i2 = i8;
                i4 = size2;
                c4 = 2;
            } else {
                if (w0(i11)) {
                    int[] iArr3 = this.f7738C;
                    if (iArr3[i9] == i12 && iArr3[i12] == i12) {
                        this.f7838i0 = (ArrayList) ((g) this.q0.get(i15)).b();
                    } else {
                        this.f7838i0 = (ArrayList) ((g) this.q0.get(i15)).f7804a;
                    }
                }
                A0();
                int size3 = this.f7838i0.size();
                for (int i16 = i9; i16 < size3; i16++) {
                    e eVar2 = this.f7838i0.get(i16);
                    if (eVar2 instanceof o) {
                        ((o) eVar2).o0();
                    }
                }
                boolean z10 = z9;
                int i17 = 0;
                boolean z11 = true;
                while (z11) {
                    boolean z12 = z10;
                    int i18 = i17 + 1;
                    try {
                        this.f7790k0.x();
                        A0();
                        f(this.f7790k0);
                        int i19 = 0;
                        while (i19 < size3) {
                            z4 = z11;
                            try {
                                this.f7838i0.get(i19).f(this.f7790k0);
                                i19++;
                                z11 = z4;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                PrintStream printStream = System.out;
                                StringBuilder sb = new StringBuilder();
                                i5 = size2;
                                sb.append("EXCEPTION : ");
                                sb.append(e);
                                printStream.println(sb.toString());
                                if (!z4) {
                                }
                                if (z8) {
                                    z5 = false;
                                }
                                iMax = Math.max(this.f7750R, v());
                                if (iMax > v()) {
                                }
                                iMax2 = Math.max(this.f7751S, n());
                                if (iMax2 > n()) {
                                }
                                if (!z7) {
                                }
                                z11 = z5;
                                i17 = i18;
                                z10 = z7;
                                size2 = i5;
                                i8 = i6;
                            }
                        }
                        s0(this.f7790k0);
                    } catch (Exception e4) {
                        e = e4;
                        z4 = z11;
                    }
                    try {
                        this.f7790k0.t();
                        i5 = size2;
                        z4 = true;
                    } catch (Exception e5) {
                        e = e5;
                        z4 = true;
                        e.printStackTrace();
                        PrintStream printStream2 = System.out;
                        StringBuilder sb2 = new StringBuilder();
                        i5 = size2;
                        sb2.append("EXCEPTION : ");
                        sb2.append(e);
                        printStream2.println(sb2.toString());
                        if (!z4) {
                        }
                        if (z8) {
                        }
                        iMax = Math.max(this.f7750R, v());
                        if (iMax > v()) {
                        }
                        iMax2 = Math.max(this.f7751S, n());
                        if (iMax2 > n()) {
                        }
                        if (!z7) {
                        }
                        z11 = z5;
                        i17 = i18;
                        z10 = z7;
                        size2 = i5;
                        i8 = i6;
                    }
                    if (!z4) {
                        i6 = i8;
                        m0(this.f7790k0);
                        int i20 = 0;
                        while (true) {
                            if (i20 >= size3) {
                                break;
                            }
                            e eVar3 = this.f7838i0.get(i20);
                            if (eVar3.f7738C[0] == 3 && eVar3.v() < eVar3.x()) {
                                j.f7818a[2] = true;
                                break;
                            } else {
                                if (eVar3.f7738C[1] == 3 && eVar3.n() < eVar3.w()) {
                                    j.f7818a[2] = true;
                                    break;
                                }
                                i20++;
                            }
                        }
                    } else {
                        C0372e c0372e = this.f7790k0;
                        boolean[] zArr = j.f7818a;
                        char c6 = 0;
                        zArr[2] = false;
                        m0(c0372e);
                        int size4 = this.f7838i0.size();
                        int i21 = 0;
                        while (i21 < size4) {
                            int i22 = size4;
                            e eVar4 = this.f7838i0.get(i21);
                            eVar4.m0(c0372e);
                            C0372e c0372e2 = c0372e;
                            int i23 = i8;
                            if (eVar4.f7738C[c6] != 3 || eVar4.v() >= eVar4.x()) {
                                c5 = 1;
                            } else {
                                c5 = 1;
                                zArr[2] = true;
                            }
                            if (eVar4.f7738C[c5] == 3 && eVar4.n() < eVar4.w()) {
                                zArr[2] = true;
                            }
                            i21++;
                            size4 = i22;
                            c0372e = c0372e2;
                            i8 = i23;
                            c6 = 0;
                        }
                        i6 = i8;
                    }
                    if (z8 && i18 < 8 && j.f7818a[2]) {
                        int iMax5 = 0;
                        int iMax6 = 0;
                        for (int i24 = 0; i24 < size3; i24++) {
                            e eVar5 = this.f7838i0.get(i24);
                            iMax5 = Math.max(iMax5, eVar5.v() + eVar5.f7744I);
                            iMax6 = Math.max(iMax6, eVar5.n() + eVar5.f7745J);
                        }
                        int iMax7 = Math.max(this.f7750R, iMax5);
                        int iMax8 = Math.max(this.f7751S, iMax6);
                        if (i14 != 2 || v() >= iMax7) {
                            z5 = false;
                        } else {
                            g0(iMax7);
                            this.f7738C[0] = 2;
                            z5 = true;
                            z12 = true;
                        }
                        if (i13 == 2 && n() < iMax8) {
                            M(iMax8);
                            this.f7738C[1] = 2;
                            z5 = true;
                            z12 = true;
                        }
                    } else {
                        z5 = false;
                    }
                    iMax = Math.max(this.f7750R, v());
                    if (iMax > v()) {
                        g0(iMax);
                        r32 = 1;
                        this.f7738C[0] = 1;
                        z5 = true;
                        z6 = true;
                    } else {
                        r32 = 1;
                        z6 = z12;
                    }
                    iMax2 = Math.max(this.f7751S, n());
                    if (iMax2 > n()) {
                        M(iMax2);
                        this.f7738C[r32] = r32;
                        z5 = r32;
                        z7 = z5;
                    } else {
                        z7 = z6;
                    }
                    if (!z7) {
                        if (this.f7738C[0] == 2 && iMax3 > 0 && v() > iMax3) {
                            this.f7802y0 = r32;
                            this.f7738C[0] = r32;
                            g0(iMax3);
                            z5 = r32;
                            z7 = z5;
                        }
                        if (this.f7738C[r32] == 2 && iMax4 > 0 && n() > iMax4) {
                            this.f7803z0 = r32;
                            this.f7738C[r32] = r32;
                            M(iMax4);
                            z11 = true;
                            z7 = true;
                        }
                        i17 = i18;
                        z10 = z7;
                        size2 = i5;
                        i8 = i6;
                    }
                    z11 = z5;
                    i17 = i18;
                    z10 = z7;
                    size2 = i5;
                    i8 = i6;
                }
                i2 = i8;
                i4 = size2;
                c4 = 2;
                ((g) this.q0.get(i15)).e();
                z9 = z10;
            }
            i15++;
            size2 = i4;
            i8 = i2;
            i9 = 0;
            i11 = 32;
            i12 = 1;
        }
        int i25 = i8;
        this.f7838i0 = arrayList;
        if (this.f7739D != null) {
            int iMax9 = Math.max(this.f7750R, v());
            int iMax10 = Math.max(this.f7751S, n());
            this.f7791l0.a(this);
            c2 = 0;
            g0(iMax9 + 0 + 0);
            M(iMax10 + 0 + 0);
        } else {
            c2 = 0;
            this.f7744I = i7;
            this.f7745J = i25;
        }
        if (z9) {
            int[] iArr4 = this.f7738C;
            iArr4[c2] = i14;
            iArr4[1] = i13;
        }
        F(this.f7790k0.q());
        f fVar = this;
        f fVar2 = this.f7739D;
        while (fVar2 != null) {
            ?? r33 = fVar2.f7739D;
            if (fVar2 instanceof f) {
                fVar = fVar2;
            }
            fVar2 = r33;
        }
        if (this == fVar) {
            l0();
        }
    }

    final void r0(e eVar, int i2) {
        if (i2 == 0) {
            int i4 = this.f7792m0 + 1;
            c[] cVarArr = this.p0;
            if (i4 >= cVarArr.length) {
                this.p0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
            }
            c[] cVarArr2 = this.p0;
            int i5 = this.f7792m0;
            cVarArr2[i5] = new c(eVar, 0, this.f7789j0);
            this.f7792m0 = i5 + 1;
            return;
        }
        if (i2 == 1) {
            int i6 = this.f7793n0 + 1;
            c[] cVarArr3 = this.f7794o0;
            if (i6 >= cVarArr3.length) {
                this.f7794o0 = (c[]) Arrays.copyOf(cVarArr3, cVarArr3.length * 2);
            }
            c[] cVarArr4 = this.f7794o0;
            int i7 = this.f7793n0;
            cVarArr4[i7] = new c(eVar, 1, this.f7789j0);
            this.f7793n0 = i7 + 1;
        }
    }

    public final void s0(C0372e c0372e) {
        a(c0372e);
        int size = this.f7838i0.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.f7838i0.get(i2);
            if (eVar instanceof f) {
                int[] iArr = eVar.f7738C;
                int i4 = iArr[0];
                int i5 = iArr[1];
                if (i4 == 2) {
                    eVar.Q(1);
                }
                if (i5 == 2) {
                    eVar.c0(1);
                }
                eVar.a(c0372e);
                if (i4 == 2) {
                    eVar.Q(i4);
                }
                if (i5 == 2) {
                    eVar.c0(i5);
                }
            } else {
                if (this.f7738C[0] != 2 && eVar.f7738C[0] == 4) {
                    int i6 = eVar.f7782s.f7724e;
                    int iV = v() - eVar.u.f7724e;
                    d dVar = eVar.f7782s;
                    dVar.f7727i = c0372e.n(dVar);
                    d dVar2 = eVar.u;
                    dVar2.f7727i = c0372e.n(dVar2);
                    c0372e.e(eVar.f7782s.f7727i, i6);
                    c0372e.e(eVar.u.f7727i, iV);
                    eVar.f7759a = 2;
                    eVar.P(i6, iV);
                }
                if (this.f7738C[1] != 2 && eVar.f7738C[1] == 4) {
                    int i7 = eVar.f7783t.f7724e;
                    int iN = n() - eVar.f7784v.f7724e;
                    d dVar3 = eVar.f7783t;
                    dVar3.f7727i = c0372e.n(dVar3);
                    d dVar4 = eVar.f7784v;
                    dVar4.f7727i = c0372e.n(dVar4);
                    c0372e.e(eVar.f7783t.f7727i, i7);
                    c0372e.e(eVar.f7784v.f7727i, iN);
                    if (eVar.f7749Q > 0 || eVar.u() == 8) {
                        d dVar5 = eVar.f7785w;
                        dVar5.f7727i = c0372e.n(dVar5);
                        c0372e.e(eVar.f7785w.f7727i, eVar.f7749Q + i7);
                    }
                    eVar.f7761b = 2;
                    eVar.b0(i7, iN);
                }
                eVar.a(c0372e);
            }
        }
        if (this.f7792m0 > 0) {
            j.b(this, c0372e, 0);
        }
        if (this.f7793n0 > 0) {
            j.b(this, c0372e, 1);
        }
    }

    public final int t0() {
        return this.f7800w0;
    }

    public final boolean u0() {
        return this.f7803z0;
    }

    public final boolean v0() {
        return this.f7802y0;
    }

    public final boolean w0(int i2) {
        return (this.f7800w0 & i2) == i2;
    }

    public final void x0(int i2, int i4) {
        l lVar;
        l lVar2;
        if (this.f7738C[0] != 2 && (lVar2 = this.f7763c) != null) {
            lVar2.g(i2);
        }
        if (this.f7738C[1] == 2 || (lVar = this.d) == null) {
            return;
        }
        lVar.g(i4);
    }

    public final void y0() {
        int size = this.f7838i0.size();
        E();
        for (int i2 = 0; i2 < size; i2++) {
            this.f7838i0.get(i2).E();
        }
    }

    public final void z0() {
        y0();
        c(this.f7800w0);
    }
}
