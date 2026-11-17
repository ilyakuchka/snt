package s;

import r.C0369b;
import r.C0372e;
import r.C0375h;
import s.d;

/* loaded from: classes.dex */
public final class h extends e {

    /* renamed from: i0, reason: collision with root package name */
    protected float f7811i0 = -1.0f;

    /* renamed from: j0, reason: collision with root package name */
    protected int f7812j0 = -1;

    /* renamed from: k0, reason: collision with root package name */
    protected int f7813k0 = -1;

    /* renamed from: l0, reason: collision with root package name */
    private d f7814l0 = this.f7783t;

    /* renamed from: m0, reason: collision with root package name */
    private int f7815m0 = 0;

    public h() {
        this.f7737B.clear();
        this.f7737B.add(this.f7814l0);
        int length = this.f7736A.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f7736A[i2] = this.f7814l0;
        }
    }

    @Override // s.e
    public final void a(C0372e c0372e) {
        f fVar = (f) this.f7739D;
        if (fVar == null) {
            return;
        }
        d dVarG = fVar.g(d.a.LEFT);
        d dVarG2 = fVar.g(d.a.RIGHT);
        e eVar = this.f7739D;
        boolean z4 = eVar != null && eVar.f7738C[0] == 2;
        if (this.f7815m0 == 0) {
            dVarG = fVar.g(d.a.TOP);
            dVarG2 = fVar.g(d.a.BOTTOM);
            e eVar2 = this.f7739D;
            z4 = eVar2 != null && eVar2.f7738C[1] == 2;
        }
        if (this.f7812j0 != -1) {
            C0375h c0375hN = c0372e.n(this.f7814l0);
            c0372e.d(c0375hN, c0372e.n(dVarG), this.f7812j0, 6);
            if (z4) {
                c0372e.g(c0372e.n(dVarG2), c0375hN, 0, 5);
                return;
            }
            return;
        }
        if (this.f7813k0 != -1) {
            C0375h c0375hN2 = c0372e.n(this.f7814l0);
            C0375h c0375hN3 = c0372e.n(dVarG2);
            c0372e.d(c0375hN2, c0375hN3, -this.f7813k0, 6);
            if (z4) {
                c0372e.g(c0375hN2, c0372e.n(dVarG), 0, 5);
                c0372e.g(c0375hN3, c0375hN2, 0, 5);
                return;
            }
            return;
        }
        if (this.f7811i0 != -1.0f) {
            C0375h c0375hN4 = c0372e.n(this.f7814l0);
            C0375h c0375hN5 = c0372e.n(dVarG);
            C0375h c0375hN6 = c0372e.n(dVarG2);
            float f4 = this.f7811i0;
            C0369b c0369bO = c0372e.o();
            c0369bO.f7658c.k(c0375hN4, -1.0f);
            c0369bO.f7658c.k(c0375hN5, 1.0f - f4);
            c0369bO.f7658c.k(c0375hN6, f4);
            c0372e.c(c0369bO);
        }
    }

    @Override // s.e
    public final boolean b() {
        return true;
    }

    @Override // s.e
    public final void c(int i2) {
        e eVar = this.f7739D;
        if (eVar == null) {
            return;
        }
        if (this.f7815m0 == 1) {
            this.f7783t.d().g(eVar.f7783t.d(), 0);
            this.f7784v.d().g(eVar.f7783t.d(), 0);
            if (this.f7812j0 != -1) {
                this.f7782s.d().g(eVar.f7782s.d(), this.f7812j0);
                this.u.d().g(eVar.f7782s.d(), this.f7812j0);
                return;
            }
            if (this.f7813k0 != -1) {
                this.f7782s.d().g(eVar.u.d(), -this.f7813k0);
                this.u.d().g(eVar.u.d(), -this.f7813k0);
                return;
            }
            float f4 = this.f7811i0;
            if (f4 == -1.0f || eVar.f7738C[0] != 1) {
                return;
            }
            int i4 = (int) (eVar.f7740E * f4);
            this.f7782s.d().g(eVar.f7782s.d(), i4);
            this.u.d().g(eVar.f7782s.d(), i4);
            return;
        }
        this.f7782s.d().g(eVar.f7782s.d(), 0);
        this.u.d().g(eVar.f7782s.d(), 0);
        if (this.f7812j0 != -1) {
            this.f7783t.d().g(eVar.f7783t.d(), this.f7812j0);
            this.f7784v.d().g(eVar.f7783t.d(), this.f7812j0);
            return;
        }
        if (this.f7813k0 != -1) {
            this.f7783t.d().g(eVar.f7784v.d(), -this.f7813k0);
            this.f7784v.d().g(eVar.f7784v.d(), -this.f7813k0);
            return;
        }
        float f5 = this.f7811i0;
        if (f5 == -1.0f || eVar.f7738C[1] != 1) {
            return;
        }
        int i5 = (int) (eVar.f7741F * f5);
        this.f7783t.d().g(eVar.f7783t.d(), i5);
        this.f7784v.d().g(eVar.f7783t.d(), i5);
    }

    @Override // s.e
    public final d g(d.a aVar) {
        switch (aVar) {
            case NONE:
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
                return null;
            case LEFT:
            case RIGHT:
                if (this.f7815m0 == 1) {
                    return this.f7814l0;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.f7815m0 == 0) {
                    return this.f7814l0;
                }
                break;
        }
        throw new AssertionError(aVar.name());
    }

    @Override // s.e
    public final void m0(C0372e c0372e) {
        if (this.f7739D == null) {
            return;
        }
        int iR = c0372e.r(this.f7814l0);
        if (this.f7815m0 == 1) {
            this.f7744I = iR;
            this.f7745J = 0;
            M(this.f7739D.n());
            g0(0);
            return;
        }
        this.f7744I = 0;
        this.f7745J = iR;
        g0(this.f7739D.v());
        M(0);
    }

    public final void n0(int i2) {
        if (i2 > -1) {
            this.f7811i0 = -1.0f;
            this.f7812j0 = i2;
            this.f7813k0 = -1;
        }
    }

    public final void o0(int i2) {
        if (i2 > -1) {
            this.f7811i0 = -1.0f;
            this.f7812j0 = -1;
            this.f7813k0 = i2;
        }
    }

    public final void p0(float f4) {
        if (f4 > -1.0f) {
            this.f7811i0 = f4;
            this.f7812j0 = -1;
            this.f7813k0 = -1;
        }
    }

    public final void q0(int i2) {
        if (this.f7815m0 == i2) {
            return;
        }
        this.f7815m0 = i2;
        this.f7737B.clear();
        if (this.f7815m0 == 1) {
            this.f7814l0 = this.f7782s;
        } else {
            this.f7814l0 = this.f7783t;
        }
        this.f7737B.add(this.f7814l0);
        int length = this.f7736A.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f7736A[i4] = this.f7814l0;
        }
    }
}
