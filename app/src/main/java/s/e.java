package s;

import java.util.ArrayList;
import r.C0369b;
import r.C0370c;
import r.C0372e;
import r.C0375h;
import s.d;

/* loaded from: classes.dex */
public class e {

    /* renamed from: A, reason: collision with root package name */
    protected d[] f7736A;

    /* renamed from: B, reason: collision with root package name */
    protected ArrayList<d> f7737B;

    /* renamed from: C, reason: collision with root package name */
    protected int[] f7738C;

    /* renamed from: D, reason: collision with root package name */
    e f7739D;

    /* renamed from: E, reason: collision with root package name */
    int f7740E;

    /* renamed from: F, reason: collision with root package name */
    int f7741F;

    /* renamed from: G, reason: collision with root package name */
    protected float f7742G;

    /* renamed from: H, reason: collision with root package name */
    protected int f7743H;

    /* renamed from: I, reason: collision with root package name */
    protected int f7744I;

    /* renamed from: J, reason: collision with root package name */
    protected int f7745J;

    /* renamed from: K, reason: collision with root package name */
    int f7746K;
    int L;
    private int M;

    /* renamed from: N, reason: collision with root package name */
    private int f7747N;

    /* renamed from: O, reason: collision with root package name */
    protected int f7748O;
    protected int P;

    /* renamed from: Q, reason: collision with root package name */
    int f7749Q;

    /* renamed from: R, reason: collision with root package name */
    protected int f7750R;

    /* renamed from: S, reason: collision with root package name */
    protected int f7751S;

    /* renamed from: T, reason: collision with root package name */
    private int f7752T;

    /* renamed from: U, reason: collision with root package name */
    private int f7753U;

    /* renamed from: V, reason: collision with root package name */
    float f7754V;

    /* renamed from: W, reason: collision with root package name */
    float f7755W;

    /* renamed from: X, reason: collision with root package name */
    private Object f7756X;

    /* renamed from: Y, reason: collision with root package name */
    private int f7757Y;

    /* renamed from: Z, reason: collision with root package name */
    private String f7758Z;

    /* renamed from: a0, reason: collision with root package name */
    boolean f7760a0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f7762b0;

    /* renamed from: c, reason: collision with root package name */
    l f7763c;

    /* renamed from: c0, reason: collision with root package name */
    boolean f7764c0;
    l d;

    /* renamed from: d0, reason: collision with root package name */
    int f7765d0;

    /* renamed from: e0, reason: collision with root package name */
    int f7767e0;

    /* renamed from: f0, reason: collision with root package name */
    float[] f7769f0;

    /* renamed from: g0, reason: collision with root package name */
    protected e[] f7770g0;

    /* renamed from: h0, reason: collision with root package name */
    protected e[] f7772h0;

    /* renamed from: z, reason: collision with root package name */
    d f7788z;

    /* renamed from: a, reason: collision with root package name */
    public int f7759a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f7761b = -1;

    /* renamed from: e, reason: collision with root package name */
    int f7766e = 0;

    /* renamed from: f, reason: collision with root package name */
    int f7768f = 0;
    int[] g = new int[2];

    /* renamed from: h, reason: collision with root package name */
    int f7771h = 0;

    /* renamed from: i, reason: collision with root package name */
    int f7773i = 0;

    /* renamed from: j, reason: collision with root package name */
    float f7774j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    int f7775k = 0;

    /* renamed from: l, reason: collision with root package name */
    int f7776l = 0;

    /* renamed from: m, reason: collision with root package name */
    float f7777m = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    int f7778n = -1;

    /* renamed from: o, reason: collision with root package name */
    float f7779o = 1.0f;
    g p = null;

    /* renamed from: q, reason: collision with root package name */
    private int[] f7780q = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: r, reason: collision with root package name */
    private float f7781r = 0.0f;

    /* renamed from: s, reason: collision with root package name */
    d f7782s = new d(this, d.a.LEFT);

    /* renamed from: t, reason: collision with root package name */
    d f7783t = new d(this, d.a.TOP);
    d u = new d(this, d.a.RIGHT);

    /* renamed from: v, reason: collision with root package name */
    d f7784v = new d(this, d.a.BOTTOM);

    /* renamed from: w, reason: collision with root package name */
    d f7785w = new d(this, d.a.BASELINE);

    /* renamed from: x, reason: collision with root package name */
    d f7786x = new d(this, d.a.CENTER_X);

    /* renamed from: y, reason: collision with root package name */
    d f7787y = new d(this, d.a.CENTER_Y);

    public e() {
        d dVar = new d(this, d.a.CENTER);
        this.f7788z = dVar;
        this.f7736A = new d[]{this.f7782s, this.u, this.f7783t, this.f7784v, this.f7785w, dVar};
        ArrayList<d> arrayList = new ArrayList<>();
        this.f7737B = arrayList;
        this.f7738C = new int[]{1, 1};
        this.f7739D = null;
        this.f7740E = 0;
        this.f7741F = 0;
        this.f7742G = 0.0f;
        this.f7743H = -1;
        this.f7744I = 0;
        this.f7745J = 0;
        this.f7746K = 0;
        this.L = 0;
        this.M = 0;
        this.f7747N = 0;
        this.f7748O = 0;
        this.P = 0;
        this.f7749Q = 0;
        this.f7754V = 0.5f;
        this.f7755W = 0.5f;
        this.f7757Y = 0;
        this.f7758Z = null;
        this.f7760a0 = false;
        this.f7762b0 = false;
        this.f7764c0 = false;
        this.f7765d0 = 0;
        this.f7767e0 = 0;
        this.f7769f0 = new float[]{-1.0f, -1.0f};
        this.f7770g0 = new e[]{null, null};
        this.f7772h0 = new e[]{null, null};
        arrayList.add(this.f7782s);
        this.f7737B.add(this.f7783t);
        this.f7737B.add(this.u);
        this.f7737B.add(this.f7784v);
        this.f7737B.add(this.f7786x);
        this.f7737B.add(this.f7787y);
        this.f7737B.add(this.f7788z);
        this.f7737B.add(this.f7785w);
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(C0372e c0372e, boolean z4, C0375h c0375h, C0375h c0375h2, int i2, boolean z5, d dVar, d dVar2, int i4, int i5, int i6, int i7, float f4, boolean z6, boolean z7, int i8, int i9, int i10, float f5, boolean z8) {
        boolean z9;
        int iMin;
        C0375h c0375h3;
        int i11;
        int i12;
        int i13;
        C0375h c0375hN;
        C0375h c0375hN2;
        int i14;
        int i15;
        C0375h c0375h4;
        int i16;
        boolean z10;
        C0375h c0375h5;
        C0375h c0375h6;
        C0375h c0375h7;
        int i17;
        int i18;
        int i19;
        C0375h c0375h8;
        int i20;
        int i21;
        C0375h c0375h9;
        boolean z11;
        boolean z12;
        int i22;
        boolean z13;
        C0375h c0375h10;
        C0375h c0375h11;
        int i23;
        C0375h c0375h12;
        boolean z14;
        boolean z15;
        int i24;
        int i25;
        int i26;
        int i27;
        boolean z16;
        d.a aVar = d.a.BOTTOM;
        C0375h c0375hN3 = c0372e.n(dVar);
        C0375h c0375hN4 = c0372e.n(dVar2);
        C0375h c0375hN5 = c0372e.n(dVar.d);
        C0375h c0375hN6 = c0372e.n(dVar2.d);
        if (c0372e.f7667f && dVar.d().f7829b == 1 && dVar2.d().f7829b == 1) {
            dVar.d().f(c0372e);
            dVar2.d().f(c0372e);
            if (z7 || !z4) {
                return;
            }
            c0372e.g(c0375h2, c0375hN4, 0, 6);
            return;
        }
        boolean zH = dVar.h();
        boolean zH2 = dVar2.h();
        boolean zH3 = this.f7788z.h();
        int i28 = zH2 ? (zH ? 1 : 0) + 1 : zH ? 1 : 0;
        if (zH3) {
            i28++;
        }
        int i29 = z6 ? 3 : i8;
        if (i2 == 0) {
            throw null;
        }
        int i30 = i28;
        int i31 = i2 - 1;
        boolean z17 = (i31 == 0 || i31 == 1 || i31 != 2 || i29 == 4) ? false : true;
        if (this.f7757Y == 8) {
            iMin = 0;
            z9 = false;
        } else {
            z9 = z17;
            iMin = i5;
        }
        if (z8) {
            if (!zH && !zH2 && !zH3) {
                c0372e.e(c0375hN3, i4);
            } else if (zH && !zH2) {
                c0375h3 = c0375hN6;
                i11 = 6;
                c0372e.d(c0375hN3, c0375hN5, dVar.c(), 6);
            }
            c0375h3 = c0375hN6;
            i11 = 6;
        } else {
            c0375h3 = c0375hN6;
            i11 = 6;
        }
        if (z9) {
            int i32 = i9;
            i12 = i10;
            if (i32 == -2) {
                i32 = iMin;
            }
            if (i12 == -2) {
                i12 = iMin;
            }
            if (i32 > 0) {
                i13 = 6;
                c0372e.g(c0375hN4, c0375hN3, i32, 6);
                iMin = Math.max(iMin, i32);
            } else {
                i13 = 6;
            }
            if (i12 > 0) {
                c0372e.i(c0375hN4, c0375hN3, i12, i13);
                iMin = Math.min(iMin, i12);
            }
            if (i29 != 1) {
                if (i29 == 2) {
                    d.a aVar2 = dVar.f7723c;
                    d.a aVar3 = d.a.TOP;
                    if (aVar2 == aVar3 || aVar2 == aVar) {
                        c0375hN = c0372e.n(this.f7739D.g(aVar3));
                        c0375hN2 = c0372e.n(this.f7739D.g(aVar));
                    } else {
                        c0375hN = c0372e.n(this.f7739D.g(d.a.LEFT));
                        c0375hN2 = c0372e.n(this.f7739D.g(d.a.RIGHT));
                    }
                    C0369b c0369bO = c0372e.o();
                    i14 = i32;
                    i15 = i30;
                    c0375h4 = c0375hN5;
                    i16 = i29;
                    c0369bO.c(c0375hN4, c0375hN3, c0375hN2, c0375hN, f5);
                    c0372e.c(c0369bO);
                    z10 = false;
                }
                if (z10 && i15 != 2 && !z6) {
                    int iMax = Math.max(i14, iMin);
                    if (i12 > 0) {
                        iMax = Math.min(i12, iMax);
                    }
                    c0372e.d(c0375hN4, c0375hN3, iMax, 6);
                    z10 = false;
                }
            } else if (z4) {
                c0372e.d(c0375hN4, c0375hN3, iMin, 6);
            } else if (z7) {
                c0372e.d(c0375hN4, c0375hN3, iMin, 4);
            } else {
                c0372e.d(c0375hN4, c0375hN3, iMin, 1);
            }
            c0375h4 = c0375hN5;
            i14 = i32;
            i16 = i29;
            i15 = i30;
            z10 = z9;
            if (z10) {
                int iMax2 = Math.max(i14, iMin);
                if (i12 > 0) {
                }
                c0372e.d(c0375hN4, c0375hN3, iMax2, 6);
                z10 = false;
            }
        } else {
            if (z5) {
                c0372e.d(c0375hN4, c0375hN3, 0, 3);
                if (i6 > 0) {
                    c0372e.g(c0375hN4, c0375hN3, i6, i11);
                }
                if (i7 < Integer.MAX_VALUE) {
                    c0372e.i(c0375hN4, c0375hN3, i7, i11);
                }
            } else {
                c0372e.d(c0375hN4, c0375hN3, iMin, i11);
            }
            i14 = i9;
            i12 = i10;
            c0375h4 = c0375hN5;
            z10 = z9;
            i16 = i29;
            i15 = i30;
        }
        if (!z8) {
            c0375h5 = c0375h;
            c0375h6 = c0375hN3;
            c0375h7 = c0375h2;
            i17 = i15;
            i18 = 6;
            i19 = 0;
            c0375h8 = c0375hN4;
            i20 = 2;
        } else {
            if (!z7) {
                if (zH || zH2 || zH3) {
                    i21 = 0;
                    if (!zH || zH2) {
                        if (zH || !zH2) {
                            C0375h c0375h13 = c0375h3;
                            if (zH && zH2) {
                                if (z10) {
                                    if (z4 && i6 == 0) {
                                        c0372e.g(c0375hN4, c0375hN3, 0, 6);
                                    }
                                    if (i16 == 0) {
                                        if (i12 > 0 || i14 > 0) {
                                            i27 = 4;
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                            i27 = 6;
                                        }
                                        c0375h9 = c0375h4;
                                        c0372e.d(c0375hN3, c0375h9, dVar.c(), i27);
                                        c0372e.d(c0375hN4, c0375h13, -dVar2.c(), i27);
                                        z12 = i12 > 0 || i14 > 0;
                                        z13 = z16;
                                        i22 = 5;
                                        z11 = true;
                                    } else {
                                        c0375h9 = c0375h4;
                                        z11 = true;
                                        if (i16 == 1) {
                                            z12 = true;
                                            z13 = true;
                                            i22 = 6;
                                        } else if (i16 == 3) {
                                            int i33 = (z6 || this.f7778n == -1 || i12 > 0) ? 4 : 6;
                                            c0372e.d(c0375hN3, c0375h9, dVar.c(), i33);
                                            c0372e.d(c0375hN4, c0375h13, -dVar2.c(), i33);
                                            z12 = true;
                                            z13 = true;
                                            i22 = 5;
                                        } else {
                                            i22 = 5;
                                            z12 = false;
                                            z13 = false;
                                        }
                                    }
                                } else {
                                    c0375h9 = c0375h4;
                                    z11 = true;
                                    z12 = true;
                                    i22 = 5;
                                    z13 = false;
                                }
                                if (z12) {
                                    z15 = z11;
                                    c0375h10 = c0375h9;
                                    c0375h12 = c0375hN4;
                                    c0375h11 = c0375hN3;
                                    c0372e.b(c0375hN3, c0375h9, dVar.c(), f4, c0375h13, c0375hN4, dVar2.c(), i22);
                                    i23 = 0;
                                    boolean z18 = dVar.d.f7722b instanceof b;
                                    boolean z19 = dVar2.d.f7722b instanceof b;
                                    if (!z18 || z19) {
                                        if (!z18 && z19) {
                                            z14 = z4;
                                            i24 = 6;
                                        }
                                        i25 = 5;
                                        if (z13) {
                                            i24 = 6;
                                            i25 = 6;
                                        }
                                        if ((z10 && z15) || z13) {
                                            c0372e.g(c0375h11, c0375h10, dVar.c(), i24);
                                        }
                                        if ((z10 && z14) || z13) {
                                            c0372e.i(c0375h12, c0375h13, -dVar2.c(), i25);
                                        }
                                        if (z4) {
                                            i26 = 6;
                                            c0372e.g(c0375h11, c0375h, i23, 6);
                                        } else {
                                            i26 = 6;
                                        }
                                    } else {
                                        z14 = z15;
                                        i24 = 5;
                                        i25 = 6;
                                        z15 = z4;
                                        if (z13) {
                                        }
                                        if (z10) {
                                            c0372e.g(c0375h11, c0375h10, dVar.c(), i24);
                                            if (z10) {
                                            }
                                        } else {
                                            c0372e.g(c0375h11, c0375h10, dVar.c(), i24);
                                            if (z10) {
                                                c0372e.i(c0375h12, c0375h13, -dVar2.c(), i25);
                                                if (z4) {
                                                }
                                            } else {
                                                c0372e.i(c0375h12, c0375h13, -dVar2.c(), i25);
                                                if (z4) {
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    c0375h10 = c0375h9;
                                    c0375h11 = c0375hN3;
                                    i23 = 0;
                                    c0375h12 = c0375hN4;
                                }
                                z14 = z4;
                                z15 = z14;
                                i24 = 5;
                                i25 = 5;
                                if (z13) {
                                }
                                if (z10) {
                                }
                            }
                        } else {
                            c0372e.d(c0375hN4, c0375h3, -dVar2.c(), 6);
                            if (z4) {
                                c0372e.g(c0375hN3, c0375h, 0, 5);
                            }
                        }
                    } else if (z4) {
                        c0372e.g(c0375h2, c0375hN4, 0, 5);
                    }
                    i23 = i21;
                    i26 = 6;
                    c0375h12 = c0375hN4;
                } else if (z4) {
                    i21 = 0;
                    c0372e.g(c0375h2, c0375hN4, 0, 5);
                    i23 = i21;
                    i26 = 6;
                    c0375h12 = c0375hN4;
                } else {
                    c0375h12 = c0375hN4;
                    i26 = 6;
                    i23 = 0;
                }
                if (z4) {
                    c0372e.g(c0375h2, c0375h12, i23, i26);
                    return;
                }
                return;
            }
            c0375h5 = c0375h;
            c0375h6 = c0375hN3;
            c0375h7 = c0375h2;
            i17 = i15;
            i18 = 6;
            i19 = 0;
            i20 = 2;
            c0375h8 = c0375hN4;
        }
        if (i17 >= i20 || !z4) {
            return;
        }
        c0372e.g(c0375h6, c0375h5, i19, i18);
        c0372e.g(c0375h7, c0375h8, i19, i18);
    }

    private boolean z(int i2) {
        int i4 = i2 * 2;
        d[] dVarArr = this.f7736A;
        if (dVarArr[i4].d != null && dVarArr[i4].d.d != dVarArr[i4]) {
            int i5 = i4 + 1;
            if (dVarArr[i5].d != null && dVarArr[i5].d.d == dVarArr[i5]) {
                return true;
            }
        }
        return false;
    }

    public final boolean A() {
        return this.f7782s.d().f7829b == 1 && this.u.d().f7829b == 1 && this.f7783t.d().f7829b == 1 && this.f7784v.d().f7829b == 1;
    }

    public final boolean B() {
        return this.f7768f == 0 && this.f7742G == 0.0f && this.f7775k == 0 && this.f7776l == 0 && this.f7738C[1] == 3;
    }

    public final boolean C() {
        return this.f7766e == 0 && this.f7742G == 0.0f && this.f7771h == 0 && this.f7773i == 0 && this.f7738C[0] == 3;
    }

    public void D() {
        this.f7782s.i();
        this.f7783t.i();
        this.u.i();
        this.f7784v.i();
        this.f7785w.i();
        this.f7786x.i();
        this.f7787y.i();
        this.f7788z.i();
        this.f7739D = null;
        this.f7781r = 0.0f;
        this.f7740E = 0;
        this.f7741F = 0;
        this.f7742G = 0.0f;
        this.f7743H = -1;
        this.f7744I = 0;
        this.f7745J = 0;
        this.M = 0;
        this.f7747N = 0;
        this.f7748O = 0;
        this.P = 0;
        this.f7749Q = 0;
        this.f7750R = 0;
        this.f7751S = 0;
        this.f7752T = 0;
        this.f7753U = 0;
        this.f7754V = 0.5f;
        this.f7755W = 0.5f;
        int[] iArr = this.f7738C;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f7756X = null;
        this.f7757Y = 0;
        this.f7765d0 = 0;
        this.f7767e0 = 0;
        float[] fArr = this.f7769f0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f7759a = -1;
        this.f7761b = -1;
        int[] iArr2 = this.f7780q;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.f7766e = 0;
        this.f7768f = 0;
        this.f7774j = 1.0f;
        this.f7777m = 1.0f;
        this.f7773i = Integer.MAX_VALUE;
        this.f7776l = Integer.MAX_VALUE;
        this.f7771h = 0;
        this.f7775k = 0;
        this.f7778n = -1;
        this.f7779o = 1.0f;
        l lVar = this.f7763c;
        if (lVar != null) {
            lVar.f7829b = 0;
            lVar.f7828a.clear();
            lVar.f7827c = 0.0f;
        }
        l lVar2 = this.d;
        if (lVar2 != null) {
            lVar2.f7829b = 0;
            lVar2.f7828a.clear();
            lVar2.f7827c = 0.0f;
        }
        this.p = null;
        this.f7760a0 = false;
        this.f7762b0 = false;
        this.f7764c0 = false;
    }

    public void E() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.f7736A[i2].d().k();
        }
    }

    public void F(C0370c c0370c) {
        this.f7782s.j();
        this.f7783t.j();
        this.u.j();
        this.f7784v.j();
        this.f7785w.j();
        this.f7788z.j();
        this.f7786x.j();
        this.f7787y.j();
    }

    public void G() {
    }

    public final void H(int i2) {
        this.f7749Q = i2;
    }

    public final void I(Object obj) {
        this.f7756X = obj;
    }

    public final void J(String str) {
        this.f7758Z = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0084 A[PHI: r0
      0x0084: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:45:0x0084, B:35:0x007d, B:23:0x004f, B:25:0x0055, B:27:0x0061, B:29:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(String str) throws NumberFormatException {
        float fAbs;
        int i2 = 0;
        if (str == null || str.length() == 0) {
            this.f7742G = 0.0f;
            return;
        }
        int i4 = -1;
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i5 = 0;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (strSubstring.equalsIgnoreCase("W")) {
                i4 = 0;
            } else if (strSubstring.equalsIgnoreCase("H")) {
                i4 = 1;
            }
            i5 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
            String strSubstring2 = str.substring(i5);
            fAbs = strSubstring2.length() > 0 ? Float.parseFloat(strSubstring2) : i2;
        } else {
            String strSubstring3 = str.substring(i5, iIndexOf2);
            String strSubstring4 = str.substring(iIndexOf2 + 1);
            if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                float f4 = Float.parseFloat(strSubstring3);
                float f5 = Float.parseFloat(strSubstring4);
                if (f4 > 0.0f && f5 > 0.0f) {
                    fAbs = i4 == 1 ? Math.abs(f5 / f4) : Math.abs(f4 / f5);
                }
            }
        }
        i2 = (fAbs > i2 ? 1 : (fAbs == i2 ? 0 : -1));
        if (i2 > 0) {
            this.f7742G = fAbs;
            this.f7743H = i4;
        }
    }

    public final void L(int i2, int i4, int i5) {
        if (i5 == 0) {
            P(i2, i4);
        } else if (i5 == 1) {
            b0(i2, i4);
        }
        this.f7762b0 = true;
    }

    public final void M(int i2) {
        this.f7741F = i2;
        int i4 = this.f7751S;
        if (i2 < i4) {
            this.f7741F = i4;
        }
    }

    public final void N(float f4) {
        this.f7754V = f4;
    }

    public final void O(int i2) {
        this.f7765d0 = i2;
    }

    public final void P(int i2, int i4) {
        this.f7744I = i2;
        int i5 = i4 - i2;
        this.f7740E = i5;
        int i6 = this.f7750R;
        if (i5 < i6) {
            this.f7740E = i6;
        }
    }

    public final void Q(int i2) {
        this.f7738C[0] = i2;
        if (i2 == 2) {
            g0(this.f7752T);
        }
    }

    public final void R(int i2, int i4, int i5, float f4) {
        this.f7766e = i2;
        this.f7771h = i4;
        this.f7773i = i5;
        this.f7774j = f4;
        if (f4 >= 1.0f || i2 != 0) {
            return;
        }
        this.f7766e = 2;
    }

    public final void S(float f4) {
        this.f7769f0[0] = f4;
    }

    public final void T(int i2) {
        this.f7780q[1] = i2;
    }

    public final void U(int i2) {
        this.f7780q[0] = i2;
    }

    public final void V(int i2) {
        if (i2 < 0) {
            this.f7751S = 0;
        } else {
            this.f7751S = i2;
        }
    }

    public final void W(int i2) {
        if (i2 < 0) {
            this.f7750R = 0;
        } else {
            this.f7750R = i2;
        }
    }

    public void X(int i2, int i4) {
        this.f7748O = i2;
        this.P = i4;
    }

    public final void Y(int i2, int i4) {
        this.f7744I = i2;
        this.f7745J = i4;
    }

    public final void Z(float f4) {
        this.f7755W = f4;
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0322 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(C0372e c0372e) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        C0375h c0375h;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z8;
        char c2;
        C0375h c0375h2;
        C0375h c0375h3;
        C0375h c0375h4;
        C0375h c0375h5;
        C0372e c0372e2;
        boolean z9;
        C0375h c0375h6;
        e eVar;
        int i8;
        int i9;
        d dVar;
        d dVar2;
        boolean z10;
        d dVar3;
        d dVar4;
        boolean z11;
        C0375h c0375hN = c0372e.n(this.f7782s);
        C0375h c0375hN2 = c0372e.n(this.u);
        C0375h c0375hN3 = c0372e.n(this.f7783t);
        C0375h c0375hN4 = c0372e.n(this.f7784v);
        C0375h c0375hN5 = c0372e.n(this.f7785w);
        e eVar2 = this.f7739D;
        if (eVar2 != null) {
            int[] iArr = eVar2.f7738C;
            boolean z12 = iArr[0] == 2;
            boolean z13 = iArr[1] == 2;
            if (z(0)) {
                ((f) this.f7739D).r0(this, 0);
            } else {
                d dVar5 = this.f7782s;
                d dVar6 = dVar5.d;
                if ((dVar6 == null || dVar6.d != dVar5) && ((dVar2 = (dVar = this.u).d) == null || dVar2.d != dVar)) {
                    z10 = false;
                }
                if (z(1)) {
                    d dVar7 = this.f7783t;
                    d dVar8 = dVar7.d;
                    if ((dVar8 == null || dVar8.d != dVar7) && ((dVar4 = (dVar3 = this.f7784v).d) == null || dVar4.d != dVar3)) {
                        z11 = false;
                    }
                    if (z12 && this.f7757Y != 8 && this.f7782s.d == null && this.u.d == null) {
                        c0372e.g(c0372e.n(this.f7739D.u), c0375hN2, 0, 1);
                    }
                    if (z13 && this.f7757Y != 8 && this.f7783t.d == null && this.f7784v.d == null && this.f7785w == null) {
                        c0372e.g(c0372e.n(this.f7739D.f7784v), c0375hN4, 0, 1);
                    }
                    z6 = z13;
                    z4 = z12;
                    z5 = z10;
                    z7 = z11;
                } else {
                    ((f) this.f7739D).r0(this, 1);
                }
                z11 = true;
                if (z12) {
                    c0372e.g(c0372e.n(this.f7739D.u), c0375hN2, 0, 1);
                }
                if (z13) {
                    c0372e.g(c0372e.n(this.f7739D.f7784v), c0375hN4, 0, 1);
                }
                z6 = z13;
                z4 = z12;
                z5 = z10;
                z7 = z11;
            }
            z10 = true;
            if (z(1)) {
            }
            z11 = true;
            if (z12) {
            }
            if (z13) {
            }
            z6 = z13;
            z4 = z12;
            z5 = z10;
            z7 = z11;
        } else {
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
        }
        int i10 = this.f7740E;
        int i11 = this.f7750R;
        if (i10 >= i11) {
            i11 = i10;
        }
        int i12 = this.f7741F;
        int i13 = this.f7751S;
        if (i12 >= i13) {
            i13 = i12;
        }
        int[] iArr2 = this.f7738C;
        boolean z14 = iArr2[0] != 3;
        boolean z15 = iArr2[1] != 3;
        int i14 = this.f7743H;
        this.f7778n = i14;
        float f4 = this.f7742G;
        this.f7779o = f4;
        int i15 = this.f7766e;
        int i16 = this.f7768f;
        if (f4 > 0.0f) {
            c0375h = c0375hN4;
            if (this.f7757Y != 8) {
                if (iArr2[0] == 3 && i15 == 0) {
                    i15 = 3;
                }
                i2 = i11;
                if (iArr2[1] == 3 && i16 == 0) {
                    i16 = 3;
                }
                if (iArr2[0] != 3) {
                    i9 = 0;
                } else if (iArr2[1] == 3 && i15 == 3 && i16 == 3) {
                    if (i14 == -1) {
                        if (z14 && !z15) {
                            this.f7778n = 0;
                        } else if (!z14 && z15) {
                            this.f7778n = 1;
                            if (i14 == -1) {
                                this.f7779o = 1.0f / f4;
                            }
                        }
                    }
                    if (this.f7778n == 0 && (!this.f7783t.h() || !this.f7784v.h())) {
                        this.f7778n = 1;
                    } else if (this.f7778n == 1 && (!this.f7782s.h() || !this.u.h())) {
                        this.f7778n = 0;
                    }
                    if (this.f7778n == -1 && (!this.f7783t.h() || !this.f7784v.h() || !this.f7782s.h() || !this.u.h())) {
                        if (this.f7783t.h() && this.f7784v.h()) {
                            this.f7778n = 0;
                        } else if (this.f7782s.h() && this.u.h()) {
                            this.f7779o = 1.0f / this.f7779o;
                            this.f7778n = 1;
                        }
                    }
                    if (this.f7778n == -1) {
                        if (z4 && !z6) {
                            this.f7778n = 0;
                        } else if (!z4 && z6) {
                            this.f7779o = 1.0f / this.f7779o;
                            this.f7778n = 1;
                        }
                    }
                    if (this.f7778n == -1) {
                        int i17 = this.f7771h;
                        if (i17 > 0 && this.f7775k == 0) {
                            this.f7778n = 0;
                        } else if (i17 == 0 && this.f7775k > 0) {
                            this.f7779o = 1.0f / this.f7779o;
                            this.f7778n = 1;
                        }
                    }
                    if (this.f7778n == -1 && z4 && z6) {
                        this.f7779o = 1.0f / this.f7779o;
                        this.f7778n = 1;
                    }
                    i4 = i15;
                    i5 = i16;
                    i6 = i13;
                    i7 = i2;
                    z8 = true;
                    int[] iArr3 = this.g;
                    iArr3[0] = i4;
                    iArr3[1] = i5;
                    if (z8) {
                        int i18 = this.f7778n;
                        c2 = 65535;
                        boolean z16 = i18 == 0 || i18 == -1;
                        boolean z17 = this.f7738C[0] != 2 && (this instanceof f);
                        boolean z18 = !this.f7788z.h();
                        if (this.f7759a == 2) {
                            e eVar3 = this.f7739D;
                            C0375h c0375hN6 = eVar3 != null ? c0372e.n(eVar3.u) : null;
                            e eVar4 = this.f7739D;
                            c0375h3 = c0375hN5;
                            c0375h5 = c0375h;
                            c0375h2 = c0375hN3;
                            c0375h4 = c0375hN2;
                            d(c0372e, z4, eVar4 != null ? c0372e.n(eVar4.f7782s) : null, c0375hN6, this.f7738C[0], z17, this.f7782s, this.u, this.f7744I, i7, this.f7750R, this.f7780q[0], this.f7754V, z16, z5, i4, this.f7771h, this.f7773i, this.f7774j, z18);
                        } else {
                            c0375h2 = c0375hN3;
                            c0375h3 = c0375hN5;
                            c0375h4 = c0375hN2;
                            c0375h5 = c0375h;
                        }
                        if (this.f7761b != 2) {
                            return;
                        }
                        boolean z19 = this.f7738C[1] == 2 && (this instanceof f);
                        boolean z20 = z8 && ((i8 = this.f7778n) == 1 || i8 == -1);
                        if (this.f7749Q <= 0) {
                            c0372e2 = c0372e;
                        } else {
                            if (this.f7785w.d().f7829b != 1) {
                                c0372e2 = c0372e;
                                C0375h c0375h7 = c0375h3;
                                c0375h6 = c0375h2;
                                c0372e2.d(c0375h7, c0375h6, this.f7749Q, 6);
                                d dVar9 = this.f7785w.d;
                                if (dVar9 != null) {
                                    c0372e2.d(c0375h7, c0372e2.n(dVar9), 0, 6);
                                    z9 = false;
                                } else {
                                    z9 = z18;
                                }
                                e eVar5 = this.f7739D;
                                C0375h c0375hN7 = eVar5 == null ? c0372e2.n(eVar5.f7784v) : null;
                                e eVar6 = this.f7739D;
                                boolean z21 = z6;
                                C0375h c0375h8 = c0375h6;
                                d(c0372e, z21, eVar6 == null ? c0372e2.n(eVar6.f7783t) : null, c0375hN7, this.f7738C[1], z19, this.f7783t, this.f7784v, this.f7745J, i6, this.f7751S, this.f7780q[1], this.f7755W, z20, z7, i5, this.f7775k, this.f7776l, this.f7777m, z9);
                                if (z8) {
                                    eVar = this;
                                } else {
                                    eVar = this;
                                    if (eVar.f7778n == 1) {
                                        c0372e.j(c0375h5, c0375h8, c0375h4, c0375hN, eVar.f7779o);
                                    } else {
                                        c0372e.j(c0375h4, c0375hN, c0375h5, c0375h8, eVar.f7779o);
                                    }
                                }
                                if (eVar.f7788z.h()) {
                                    return;
                                }
                                e eVar7 = eVar.f7788z.d.f7722b;
                                float radians = (float) Math.toRadians(eVar.f7781r + 90.0f);
                                int iC = eVar.f7788z.c();
                                d.a aVar = d.a.LEFT;
                                C0375h c0375hN8 = c0372e.n(eVar.g(aVar));
                                d.a aVar2 = d.a.TOP;
                                C0375h c0375hN9 = c0372e.n(eVar.g(aVar2));
                                d.a aVar3 = d.a.RIGHT;
                                C0375h c0375hN10 = c0372e.n(eVar.g(aVar3));
                                d.a aVar4 = d.a.BOTTOM;
                                C0375h c0375hN11 = c0372e.n(eVar.g(aVar4));
                                C0375h c0375hN12 = c0372e.n(eVar7.g(aVar));
                                C0375h c0375hN13 = c0372e.n(eVar7.g(aVar2));
                                C0375h c0375hN14 = c0372e.n(eVar7.g(aVar3));
                                C0375h c0375hN15 = c0372e.n(eVar7.g(aVar4));
                                C0369b c0369bO = c0372e.o();
                                double d = radians;
                                double d2 = iC;
                                c0369bO.g(c0375hN9, c0375hN11, c0375hN13, c0375hN15, (float) (Math.sin(d) * d2));
                                c0372e.c(c0369bO);
                                C0369b c0369bO2 = c0372e.o();
                                c0369bO2.g(c0375hN8, c0375hN10, c0375hN12, c0375hN14, (float) (Math.cos(d) * d2));
                                c0372e.c(c0369bO2);
                                return;
                            }
                            c0372e2 = c0372e;
                            this.f7785w.d().f(c0372e2);
                        }
                        c0375h6 = c0375h2;
                        z9 = z18;
                        e eVar52 = this.f7739D;
                        if (eVar52 == null) {
                        }
                        e eVar62 = this.f7739D;
                        boolean z212 = z6;
                        C0375h c0375h82 = c0375h6;
                        d(c0372e, z212, eVar62 == null ? c0372e2.n(eVar62.f7783t) : null, c0375hN7, this.f7738C[1], z19, this.f7783t, this.f7784v, this.f7745J, i6, this.f7751S, this.f7780q[1], this.f7755W, z20, z7, i5, this.f7775k, this.f7776l, this.f7777m, z9);
                        if (z8) {
                        }
                        if (eVar.f7788z.h()) {
                        }
                    } else {
                        c2 = 65535;
                    }
                    if (this.f7738C[0] != 2) {
                    }
                    boolean z182 = !this.f7788z.h();
                    if (this.f7759a == 2) {
                    }
                    if (this.f7761b != 2) {
                    }
                } else {
                    i9 = 0;
                }
                if (iArr2[i9] == 3 && i15 == 3) {
                    this.f7778n = i9;
                    int i19 = (int) (f4 * i12);
                    if (iArr2[1] != 3) {
                        i7 = i19;
                        i5 = i16;
                        i4 = 4;
                        z8 = false;
                    } else {
                        i7 = i19;
                        i4 = i15;
                        i5 = i16;
                        z8 = true;
                    }
                    i6 = i13;
                    int[] iArr32 = this.g;
                    iArr32[0] = i4;
                    iArr32[1] = i5;
                    if (z8) {
                    }
                    if (this.f7738C[0] != 2) {
                    }
                    boolean z1822 = !this.f7788z.h();
                    if (this.f7759a == 2) {
                    }
                    if (this.f7761b != 2) {
                    }
                } else {
                    if (iArr2[1] == 3 && i16 == 3) {
                        this.f7778n = 1;
                        if (i14 == -1) {
                            this.f7779o = 1.0f / f4;
                        }
                        i13 = (int) (this.f7779o * i10);
                        if (iArr2[0] != 3) {
                            i16 = 4;
                        }
                    }
                    i4 = i15;
                    i5 = i16;
                    i6 = i13;
                    i7 = i2;
                    z8 = true;
                    int[] iArr322 = this.g;
                    iArr322[0] = i4;
                    iArr322[1] = i5;
                    if (z8) {
                    }
                    if (this.f7738C[0] != 2) {
                    }
                    boolean z18222 = !this.f7788z.h();
                    if (this.f7759a == 2) {
                    }
                    if (this.f7761b != 2) {
                    }
                }
            }
            i4 = i15;
            i5 = i16;
            i6 = i13;
            i7 = i2;
            z8 = false;
            int[] iArr3222 = this.g;
            iArr3222[0] = i4;
            iArr3222[1] = i5;
            if (z8) {
            }
            if (this.f7738C[0] != 2) {
            }
            boolean z182222 = !this.f7788z.h();
            if (this.f7759a == 2) {
            }
            if (this.f7761b != 2) {
            }
        } else {
            c0375h = c0375hN4;
        }
        i2 = i11;
        i4 = i15;
        i5 = i16;
        i6 = i13;
        i7 = i2;
        z8 = false;
        int[] iArr32222 = this.g;
        iArr32222[0] = i4;
        iArr32222[1] = i5;
        if (z8) {
        }
        if (this.f7738C[0] != 2) {
        }
        boolean z1822222 = !this.f7788z.h();
        if (this.f7759a == 2) {
        }
        if (this.f7761b != 2) {
        }
    }

    public final void a0(int i2) {
        this.f7767e0 = i2;
    }

    public boolean b() {
        return this.f7757Y != 8;
    }

    public final void b0(int i2, int i4) {
        this.f7745J = i2;
        int i5 = i4 - i2;
        this.f7741F = i5;
        int i6 = this.f7751S;
        if (i5 < i6) {
            this.f7741F = i6;
        }
    }

    public void c(int i2) {
        j.a(i2, this);
    }

    public final void c0(int i2) {
        this.f7738C[1] = i2;
        if (i2 == 2) {
            M(this.f7753U);
        }
    }

    public final void d0(int i2, int i4, int i5, float f4) {
        this.f7768f = i2;
        this.f7775k = i4;
        this.f7776l = i5;
        this.f7777m = f4;
        if (f4 >= 1.0f || i2 != 0) {
            return;
        }
        this.f7768f = 2;
    }

    public final void e(e eVar, float f4, int i2) {
        d.a aVar = d.a.CENTER;
        y(aVar, eVar, aVar, i2, 0);
        this.f7781r = f4;
    }

    public final void e0(float f4) {
        this.f7769f0[1] = f4;
    }

    public final void f(C0372e c0372e) {
        c0372e.n(this.f7782s);
        c0372e.n(this.f7783t);
        c0372e.n(this.u);
        c0372e.n(this.f7784v);
        if (this.f7749Q > 0) {
            c0372e.n(this.f7785w);
        }
    }

    public final void f0(int i2) {
        this.f7757Y = i2;
    }

    public d g(d.a aVar) {
        switch (aVar) {
            case NONE:
                return null;
            case LEFT:
                return this.f7782s;
            case TOP:
                return this.f7783t;
            case RIGHT:
                return this.u;
            case BOTTOM:
                return this.f7784v;
            case BASELINE:
                return this.f7785w;
            case CENTER:
                return this.f7788z;
            case CENTER_X:
                return this.f7786x;
            case CENTER_Y:
                return this.f7787y;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public final void g0(int i2) {
        this.f7740E = i2;
        int i4 = this.f7750R;
        if (i2 < i4) {
            this.f7740E = i4;
        }
    }

    public final int h() {
        return this.f7749Q;
    }

    public final void h0(int i2) {
        this.f7753U = i2;
    }

    public final int i() {
        return this.f7745J + this.f7741F;
    }

    public final void i0(int i2) {
        this.f7752T = i2;
    }

    public final Object j() {
        return this.f7756X;
    }

    public final void j0(int i2) {
        this.f7744I = i2;
    }

    public final String k() {
        return this.f7758Z;
    }

    public final void k0(int i2) {
        this.f7745J = i2;
    }

    public final int l() {
        return this.M + this.f7748O;
    }

    public void l0() {
        int i2 = this.f7744I;
        int i4 = this.f7745J;
        this.M = i2;
        this.f7747N = i4;
    }

    public final int m() {
        return this.f7747N + this.P;
    }

    public void m0(C0372e c0372e) {
        int i2;
        int i4;
        int iR = c0372e.r(this.f7782s);
        int iR2 = c0372e.r(this.f7783t);
        int iR3 = c0372e.r(this.u);
        int iR4 = c0372e.r(this.f7784v);
        int i5 = iR4 - iR2;
        if (iR3 - iR < 0 || i5 < 0 || iR == Integer.MIN_VALUE || iR == Integer.MAX_VALUE || iR2 == Integer.MIN_VALUE || iR2 == Integer.MAX_VALUE || iR3 == Integer.MIN_VALUE || iR3 == Integer.MAX_VALUE || iR4 == Integer.MIN_VALUE || iR4 == Integer.MAX_VALUE) {
            iR4 = 0;
            iR = 0;
            iR2 = 0;
            iR3 = 0;
        }
        int i6 = iR3 - iR;
        int i7 = iR4 - iR2;
        this.f7744I = iR;
        this.f7745J = iR2;
        if (this.f7757Y == 8) {
            this.f7740E = 0;
            this.f7741F = 0;
            return;
        }
        int[] iArr = this.f7738C;
        if (iArr[0] == 1 && i6 < (i4 = this.f7740E)) {
            i6 = i4;
        }
        if (iArr[1] == 1 && i7 < (i2 = this.f7741F)) {
            i7 = i2;
        }
        this.f7740E = i6;
        this.f7741F = i7;
        int i8 = this.f7751S;
        if (i7 < i8) {
            this.f7741F = i8;
        }
        int i9 = this.f7750R;
        if (i6 < i9) {
            this.f7740E = i9;
        }
        this.f7762b0 = true;
    }

    public final int n() {
        if (this.f7757Y == 8) {
            return 0;
        }
        return this.f7741F;
    }

    public final int o() {
        return this.f7738C[0];
    }

    public final int p(int i2) {
        if (i2 == 0) {
            return v();
        }
        if (i2 == 1) {
            return n();
        }
        return 0;
    }

    public final l q() {
        if (this.d == null) {
            this.d = new l();
        }
        return this.d;
    }

    public final l r() {
        if (this.f7763c == null) {
            this.f7763c = new l();
        }
        return this.f7763c;
    }

    public final int s() {
        return this.f7744I + this.f7740E;
    }

    public final int t() {
        return this.f7738C[1];
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("");
        sbD.append(this.f7758Z != null ? C2.c.b(D2.e.d("id: "), this.f7758Z, " ") : "");
        sbD.append("(");
        sbD.append(this.f7744I);
        sbD.append(", ");
        sbD.append(this.f7745J);
        sbD.append(") - (");
        sbD.append(this.f7740E);
        sbD.append(" x ");
        sbD.append(this.f7741F);
        sbD.append(") wrap: (");
        sbD.append(this.f7752T);
        sbD.append(" x ");
        sbD.append(this.f7753U);
        sbD.append(")");
        return sbD.toString();
    }

    public final int u() {
        return this.f7757Y;
    }

    public final int v() {
        if (this.f7757Y == 8) {
            return 0;
        }
        return this.f7740E;
    }

    public final int w() {
        return this.f7753U;
    }

    public final int x() {
        return this.f7752T;
    }

    public final void y(d.a aVar, e eVar, d.a aVar2, int i2, int i4) {
        g(aVar).a(eVar.g(aVar2), i2, i4, 2, 0, true);
    }
}
