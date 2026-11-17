package s;

import java.util.ArrayList;
import r.C0372e;
import r.C0375h;

/* loaded from: classes.dex */
public final class b extends i {

    /* renamed from: k0, reason: collision with root package name */
    private int f7704k0 = 0;

    /* renamed from: l0, reason: collision with root package name */
    private ArrayList<k> f7705l0 = new ArrayList<>(4);

    /* renamed from: m0, reason: collision with root package name */
    private boolean f7706m0 = true;

    @Override // s.e
    public final void E() {
        super.E();
        this.f7705l0.clear();
    }

    @Override // s.e
    public final void G() {
        k kVarD;
        float f4;
        k kVar;
        int i2 = this.f7704k0;
        float f5 = Float.MAX_VALUE;
        if (i2 != 0) {
            if (i2 == 1) {
                kVarD = this.u.d();
            } else if (i2 == 2) {
                kVarD = this.f7783t.d();
            } else if (i2 != 3) {
                return;
            } else {
                kVarD = this.f7784v.d();
            }
            f5 = 0.0f;
        } else {
            kVarD = this.f7782s.d();
        }
        int size = this.f7705l0.size();
        k kVar2 = null;
        for (int i4 = 0; i4 < size; i4++) {
            k kVar3 = this.f7705l0.get(i4);
            if (kVar3.f7829b != 1) {
                return;
            }
            int i5 = this.f7704k0;
            if (i5 == 0 || i5 == 2) {
                f4 = kVar3.g;
                if (f4 < f5) {
                    kVar = kVar3.f7821f;
                    kVar2 = kVar;
                    f5 = f4;
                }
            } else {
                f4 = kVar3.g;
                if (f4 > f5) {
                    kVar = kVar3.f7821f;
                    kVar2 = kVar;
                    f5 = f4;
                }
            }
        }
        kVarD.f7821f = kVar2;
        kVarD.g = f5;
        kVarD.b();
        int i6 = this.f7704k0;
        if (i6 == 0) {
            this.u.d().l(kVar2, f5);
            return;
        }
        if (i6 == 1) {
            this.f7782s.d().l(kVar2, f5);
        } else if (i6 == 2) {
            this.f7784v.d().l(kVar2, f5);
        } else {
            if (i6 != 3) {
                return;
            }
            this.f7783t.d().l(kVar2, f5);
        }
    }

    @Override // s.e
    public final void a(C0372e c0372e) {
        d[] dVarArr;
        boolean z4;
        int i2;
        d[] dVarArr2 = this.f7736A;
        dVarArr2[0] = this.f7782s;
        dVarArr2[2] = this.f7783t;
        dVarArr2[1] = this.u;
        dVarArr2[3] = this.f7784v;
        int i4 = 0;
        while (true) {
            dVarArr = this.f7736A;
            if (i4 >= dVarArr.length) {
                break;
            }
            dVarArr[i4].f7727i = c0372e.n(dVarArr[i4]);
            i4++;
        }
        int i5 = this.f7704k0;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        d dVar = dVarArr[i5];
        for (int i6 = 0; i6 < this.f7817j0; i6++) {
            e eVar = this.f7816i0[i6];
            if ((this.f7706m0 || eVar.b()) && ((((i2 = this.f7704k0) == 0 || i2 == 1) && eVar.f7738C[0] == 3) || ((i2 == 2 || i2 == 3) && eVar.f7738C[1] == 3))) {
                z4 = true;
                break;
            }
        }
        z4 = false;
        int i7 = this.f7704k0;
        if (i7 == 0 || i7 == 1 ? this.f7739D.f7738C[0] == 2 : this.f7739D.f7738C[1] == 2) {
            z4 = false;
        }
        for (int i8 = 0; i8 < this.f7817j0; i8++) {
            e eVar2 = this.f7816i0[i8];
            if (this.f7706m0 || eVar2.b()) {
                C0375h c0375hN = c0372e.n(eVar2.f7736A[this.f7704k0]);
                d[] dVarArr3 = eVar2.f7736A;
                int i9 = this.f7704k0;
                dVarArr3[i9].f7727i = c0375hN;
                if (i9 == 0 || i9 == 2) {
                    c0372e.h(dVar.f7727i, c0375hN, z4);
                } else {
                    c0372e.f(dVar.f7727i, c0375hN, z4);
                }
            }
        }
        int i10 = this.f7704k0;
        if (i10 == 0) {
            c0372e.d(this.u.f7727i, this.f7782s.f7727i, 0, 6);
            if (z4) {
                return;
            }
            c0372e.d(this.f7782s.f7727i, this.f7739D.u.f7727i, 0, 5);
            return;
        }
        if (i10 == 1) {
            c0372e.d(this.f7782s.f7727i, this.u.f7727i, 0, 6);
            if (z4) {
                return;
            }
            c0372e.d(this.f7782s.f7727i, this.f7739D.f7782s.f7727i, 0, 5);
            return;
        }
        if (i10 == 2) {
            c0372e.d(this.f7784v.f7727i, this.f7783t.f7727i, 0, 6);
            if (z4) {
                return;
            }
            c0372e.d(this.f7783t.f7727i, this.f7739D.f7784v.f7727i, 0, 5);
            return;
        }
        if (i10 == 3) {
            c0372e.d(this.f7783t.f7727i, this.f7784v.f7727i, 0, 6);
            if (z4) {
                return;
            }
            c0372e.d(this.f7783t.f7727i, this.f7739D.f7783t.f7727i, 0, 5);
        }
    }

    @Override // s.e
    public final boolean b() {
        return true;
    }

    @Override // s.e
    public final void c(int i2) {
        k kVarD;
        e eVar = this.f7739D;
        if (eVar != null && ((f) eVar).w0(2)) {
            int i4 = this.f7704k0;
            if (i4 == 0) {
                kVarD = this.f7782s.d();
            } else if (i4 == 1) {
                kVarD = this.u.d();
            } else if (i4 == 2) {
                kVarD = this.f7783t.d();
            } else if (i4 != 3) {
                return;
            } else {
                kVarD = this.f7784v.d();
            }
            kVarD.f7822h = 5;
            int i5 = this.f7704k0;
            if (i5 == 0 || i5 == 1) {
                this.f7783t.d().l(null, 0.0f);
                this.f7784v.d().l(null, 0.0f);
            } else {
                this.f7782s.d().l(null, 0.0f);
                this.u.d().l(null, 0.0f);
            }
            this.f7705l0.clear();
            for (int i6 = 0; i6 < this.f7817j0; i6++) {
                e eVar2 = this.f7816i0[i6];
                if (this.f7706m0 || eVar2.b()) {
                    int i7 = this.f7704k0;
                    k kVarD2 = i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 3 ? null : eVar2.f7784v.d() : eVar2.f7783t.d() : eVar2.u.d() : eVar2.f7782s.d();
                    if (kVarD2 != null) {
                        this.f7705l0.add(kVarD2);
                        kVarD2.a(kVarD);
                    }
                }
            }
        }
    }

    public final boolean p0() {
        return this.f7706m0;
    }

    public final void q0(boolean z4) {
        this.f7706m0 = z4;
    }

    public final void r0(int i2) {
        this.f7704k0 = i2;
    }
}
