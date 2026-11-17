package s;

import r.C0372e;
import r.C0375h;
import s.d;

/* loaded from: classes.dex */
public final class k extends m {

    /* renamed from: c, reason: collision with root package name */
    d f7819c;
    k d;

    /* renamed from: e, reason: collision with root package name */
    float f7820e;

    /* renamed from: f, reason: collision with root package name */
    k f7821f;
    float g;

    /* renamed from: i, reason: collision with root package name */
    private k f7823i;

    /* renamed from: h, reason: collision with root package name */
    int f7822h = 0;

    /* renamed from: j, reason: collision with root package name */
    private l f7824j = null;

    /* renamed from: k, reason: collision with root package name */
    private int f7825k = 1;

    /* renamed from: l, reason: collision with root package name */
    private l f7826l = null;

    public k(d dVar) {
        this.f7819c = dVar;
    }

    @Override // s.m
    public final void e() {
        int i2;
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        float fV;
        float f4;
        k kVar7;
        boolean z4 = true;
        if (this.f7829b == 1 || (i2 = this.f7822h) == 4) {
            return;
        }
        l lVar = this.f7824j;
        if (lVar != null) {
            if (lVar.f7829b != 1) {
                return;
            } else {
                this.f7820e = this.f7825k * lVar.f7827c;
            }
        }
        l lVar2 = this.f7826l;
        if (lVar2 == null || lVar2.f7829b == 1) {
            if (i2 == 1 && ((kVar7 = this.d) == null || kVar7.f7829b == 1)) {
                if (kVar7 == null) {
                    this.f7821f = this;
                    this.g = this.f7820e;
                } else {
                    this.f7821f = kVar7.f7821f;
                    this.g = kVar7.g + this.f7820e;
                }
                b();
                return;
            }
            if (i2 != 2 || (kVar4 = this.d) == null || kVar4.f7829b != 1 || (kVar5 = this.f7823i) == null || (kVar6 = kVar5.d) == null || kVar6.f7829b != 1) {
                if (i2 != 3 || (kVar = this.d) == null || kVar.f7829b != 1 || (kVar2 = this.f7823i) == null || (kVar3 = kVar2.d) == null || kVar3.f7829b != 1) {
                    if (i2 == 5) {
                        this.f7819c.f7722b.G();
                        return;
                    }
                    return;
                } else {
                    this.f7821f = kVar.f7821f;
                    kVar2.f7821f = kVar3.f7821f;
                    this.g = kVar.g + this.f7820e;
                    kVar2.g = kVar3.g + kVar2.f7820e;
                    b();
                    this.f7823i.b();
                    return;
                }
            }
            this.f7821f = kVar4.f7821f;
            kVar5.f7821f = kVar6.f7821f;
            d.a aVar = this.f7819c.f7723c;
            d.a aVar2 = d.a.RIGHT;
            int i4 = 0;
            if (aVar != aVar2 && aVar != d.a.BOTTOM) {
                z4 = false;
            }
            float f5 = z4 ? kVar4.g - kVar6.g : kVar6.g - kVar4.g;
            if (aVar == d.a.LEFT || aVar == aVar2) {
                fV = f5 - r0.f7722b.v();
                f4 = this.f7819c.f7722b.f7754V;
            } else {
                fV = f5 - r0.f7722b.n();
                f4 = this.f7819c.f7722b.f7755W;
            }
            int iC = this.f7819c.c();
            int iC2 = this.f7823i.f7819c.c();
            d dVar = this.f7819c.d;
            k kVar8 = this.f7823i;
            if (dVar == kVar8.f7819c.d) {
                f4 = 0.5f;
                iC2 = 0;
            } else {
                i4 = iC;
            }
            float f6 = i4;
            float f7 = iC2;
            float f8 = (fV - f6) - f7;
            if (z4) {
                kVar8.g = (f8 * f4) + kVar8.d.g + f7;
                this.g = (this.d.g - f6) - ((1.0f - f4) * f8);
            } else {
                this.g = (f8 * f4) + this.d.g + f6;
                kVar8.g = (kVar8.d.g - f7) - ((1.0f - f4) * f8);
            }
            b();
            this.f7823i.b();
        }
    }

    final void f(C0372e c0372e) {
        C0375h c0375h = this.f7819c.f7727i;
        k kVar = this.f7821f;
        if (kVar == null) {
            c0372e.e(c0375h, (int) (this.g + 0.5f));
        } else {
            c0372e.d(c0375h, c0372e.n(kVar.f7819c), (int) (this.g + 0.5f), 6);
        }
    }

    public final void g(k kVar, int i2) {
        this.f7822h = 1;
        this.d = kVar;
        this.f7820e = i2;
        kVar.a(this);
    }

    public final void h(k kVar, int i2, l lVar) {
        this.d = kVar;
        kVar.a(this);
        this.f7824j = lVar;
        this.f7825k = i2;
        lVar.a(this);
    }

    public final void i(k kVar, int i2) {
        this.d = kVar;
        this.f7820e = i2;
        kVar.a(this);
    }

    public final float j() {
        return this.g;
    }

    public final void k() {
        this.f7829b = 0;
        this.f7828a.clear();
        this.d = null;
        this.f7820e = 0.0f;
        this.f7824j = null;
        this.f7825k = 1;
        this.f7826l = null;
        this.f7821f = null;
        this.g = 0.0f;
        this.f7823i = null;
        this.f7822h = 0;
    }

    public final void l(k kVar, float f4) {
        int i2 = this.f7829b;
        if (i2 == 0 || !(this.f7821f == kVar || this.g == f4)) {
            this.f7821f = kVar;
            this.g = f4;
            if (i2 == 1) {
                c();
            }
            b();
        }
    }

    final String m(int i2) {
        return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public final void n(k kVar) {
        this.f7823i = kVar;
    }

    public final void o(k kVar, int i2, l lVar) {
        this.f7823i = kVar;
        this.f7826l = lVar;
    }

    public final String toString() {
        if (this.f7829b != 1) {
            StringBuilder sbD = D2.e.d("{ ");
            sbD.append(this.f7819c);
            sbD.append(" UNRESOLVED} type: ");
            sbD.append(m(this.f7822h));
            return sbD.toString();
        }
        if (this.f7821f == this) {
            StringBuilder sbD2 = D2.e.d("[");
            sbD2.append(this.f7819c);
            sbD2.append(", RESOLVED: ");
            sbD2.append(this.g);
            sbD2.append("]  type: ");
            sbD2.append(m(this.f7822h));
            return sbD2.toString();
        }
        StringBuilder sbD3 = D2.e.d("[");
        sbD3.append(this.f7819c);
        sbD3.append(", RESOLVED: ");
        sbD3.append(this.f7821f);
        sbD3.append(":");
        sbD3.append(this.g);
        sbD3.append("] type: ");
        sbD3.append(m(this.f7822h));
        return sbD3.toString();
    }
}
