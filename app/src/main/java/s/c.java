package s;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    protected e f7707a;

    /* renamed from: b, reason: collision with root package name */
    protected e f7708b;

    /* renamed from: c, reason: collision with root package name */
    protected e f7709c;
    protected e d;

    /* renamed from: e, reason: collision with root package name */
    protected e f7710e;

    /* renamed from: f, reason: collision with root package name */
    protected e f7711f;
    protected e g;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList<e> f7712h;

    /* renamed from: i, reason: collision with root package name */
    protected int f7713i;

    /* renamed from: j, reason: collision with root package name */
    protected int f7714j;

    /* renamed from: k, reason: collision with root package name */
    protected float f7715k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    private int f7716l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7717m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f7718n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f7719o;
    protected boolean p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7720q;

    public c(e eVar, int i2, boolean z4) {
        this.f7707a = eVar;
        this.f7716l = i2;
        this.f7717m = z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        boolean z4;
        e eVar;
        if (!this.f7720q) {
            int i2 = this.f7716l * 2;
            e eVar2 = this.f7707a;
            boolean z5 = false;
            e eVar3 = eVar2;
            boolean z6 = false;
            while (!z6) {
                this.f7713i++;
                e[] eVarArr = eVar2.f7772h0;
                int i4 = this.f7716l;
                e eVar4 = null;
                eVarArr[i4] = null;
                eVar2.f7770g0[i4] = null;
                if (eVar2.u() != 8) {
                    if (this.f7708b == null) {
                        this.f7708b = eVar2;
                    }
                    this.d = eVar2;
                    int[] iArr = eVar2.f7738C;
                    int i5 = this.f7716l;
                    if (iArr[i5] == 3) {
                        int[] iArr2 = eVar2.g;
                        if (iArr2[i5] == 0 || iArr2[i5] == 3 || iArr2[i5] == 2) {
                            this.f7714j++;
                            float[] fArr = eVar2.f7769f0;
                            float f4 = fArr[i5];
                            if (f4 > 0.0f) {
                                this.f7715k += fArr[i5];
                            }
                            if (eVar2.u() == 8 || eVar2.f7738C[i5] != 3) {
                                z4 = false;
                                if (z4) {
                                    if (f4 < 0.0f) {
                                        this.f7718n = true;
                                    } else {
                                        this.f7719o = true;
                                    }
                                    if (this.f7712h == null) {
                                        this.f7712h = new ArrayList<>();
                                    }
                                    this.f7712h.add(eVar2);
                                }
                                if (this.f7711f == null) {
                                    this.f7711f = eVar2;
                                }
                                eVar = this.g;
                                if (eVar != null) {
                                    eVar.f7770g0[this.f7716l] = eVar2;
                                }
                                this.g = eVar2;
                            } else {
                                int[] iArr3 = eVar2.g;
                                if (iArr3[i5] == 0 || iArr3[i5] == 3) {
                                    z4 = true;
                                }
                                if (z4) {
                                }
                                if (this.f7711f == null) {
                                }
                                eVar = this.g;
                                if (eVar != null) {
                                }
                                this.g = eVar2;
                            }
                        }
                    }
                }
                if (eVar3 != eVar2) {
                    eVar3.f7772h0[this.f7716l] = eVar2;
                }
                d dVar = eVar2.f7736A[i2 + 1].d;
                if (dVar != null) {
                    e eVar5 = dVar.f7722b;
                    d[] dVarArr = eVar5.f7736A;
                    if (dVarArr[i2].d != null && dVarArr[i2].d.f7722b == eVar2) {
                        eVar4 = eVar5;
                    }
                }
                if (eVar4 == null) {
                    z6 = true;
                    eVar4 = eVar2;
                }
                eVar3 = eVar2;
                eVar2 = eVar4;
            }
            this.f7709c = eVar2;
            if (this.f7716l == 0 && this.f7717m) {
                this.f7710e = eVar2;
            } else {
                this.f7710e = this.f7707a;
            }
            if (this.f7719o && this.f7718n) {
                z5 = true;
            }
            this.p = z5;
        }
        this.f7720q = true;
    }
}
