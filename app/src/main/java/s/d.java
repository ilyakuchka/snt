package s;

import r.C0375h;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    final e f7722b;

    /* renamed from: c, reason: collision with root package name */
    final a f7723c;
    d d;

    /* renamed from: i, reason: collision with root package name */
    C0375h f7727i;

    /* renamed from: a, reason: collision with root package name */
    private k f7721a = new k(this);

    /* renamed from: e, reason: collision with root package name */
    public int f7724e = 0;

    /* renamed from: f, reason: collision with root package name */
    int f7725f = -1;
    private int g = 1;

    /* renamed from: h, reason: collision with root package name */
    private int f7726h = 0;

    public enum a {
        /* JADX INFO: Fake field, exist only in values array */
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, a aVar) {
        this.f7722b = eVar;
        this.f7723c = aVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(d dVar, int i2, int i4, int i5, int i6, boolean z4) {
        boolean z5;
        if (dVar == null) {
            this.d = null;
            this.f7724e = 0;
            this.f7725f = -1;
            this.g = 1;
            this.f7726h = 2;
            return true;
        }
        if (!z4) {
            a aVar = a.CENTER_Y;
            a aVar2 = a.CENTER_X;
            a aVar3 = a.BASELINE;
            a aVar4 = dVar.f7723c;
            a aVar5 = this.f7723c;
            if (aVar4 == aVar5) {
                if (aVar5 == aVar3) {
                    if (dVar.f7722b.f7749Q > 0) {
                        if (!(this.f7722b.f7749Q > 0)) {
                        }
                    }
                    z5 = false;
                }
                z5 = true;
            } else {
                switch (aVar5) {
                    case NONE:
                    case BASELINE:
                    case CENTER_X:
                    case CENTER_Y:
                        z5 = false;
                        break;
                    case LEFT:
                    case RIGHT:
                        boolean z6 = aVar4 == a.LEFT || aVar4 == a.RIGHT;
                        if (!(dVar.f7722b instanceof h)) {
                            z5 = z6;
                            break;
                        } else if (z6 || aVar4 == aVar2) {
                            z5 = true;
                            break;
                        }
                        break;
                    case TOP:
                    case BOTTOM:
                        z5 = aVar4 == a.TOP || aVar4 == a.BOTTOM;
                        if (dVar.f7722b instanceof h) {
                            if (z5 || aVar4 == aVar) {
                            }
                        }
                        break;
                    case CENTER:
                        if (aVar4 == aVar3 || aVar4 == aVar2 || aVar4 == aVar) {
                        }
                        break;
                    default:
                        throw new AssertionError(this.f7723c.name());
                }
            }
            if (!z5) {
                return false;
            }
        }
        this.d = dVar;
        if (i2 > 0) {
            this.f7724e = i2;
        } else {
            this.f7724e = 0;
        }
        this.f7725f = i4;
        this.g = i5;
        this.f7726h = i6;
        return true;
    }

    public final int b() {
        return this.f7726h;
    }

    public final int c() {
        d dVar;
        if (this.f7722b.u() == 8) {
            return 0;
        }
        return (this.f7725f <= -1 || (dVar = this.d) == null || dVar.f7722b.u() != 8) ? this.f7724e : this.f7725f;
    }

    public final k d() {
        return this.f7721a;
    }

    public final C0375h e() {
        return this.f7727i;
    }

    public final int f() {
        return this.g;
    }

    public final d g() {
        return this.d;
    }

    public final boolean h() {
        return this.d != null;
    }

    public final void i() {
        this.d = null;
        this.f7724e = 0;
        this.f7725f = -1;
        this.g = 2;
        this.f7726h = 0;
        this.f7721a.k();
    }

    public final void j() {
        C0375h c0375h = this.f7727i;
        if (c0375h == null) {
            this.f7727i = new C0375h(1);
        } else {
            c0375h.d();
        }
    }

    public final String toString() {
        return this.f7722b.k() + ":" + this.f7723c.toString();
    }
}
