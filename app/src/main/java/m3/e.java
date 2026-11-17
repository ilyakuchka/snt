package m3;

import m3.AbstractC0350b;

/* loaded from: classes.dex */
public final class e {
    private double d;

    /* renamed from: e, reason: collision with root package name */
    private double f6600e;

    /* renamed from: f, reason: collision with root package name */
    private double f6601f;
    private double g;

    /* renamed from: h, reason: collision with root package name */
    private double f6602h;

    /* renamed from: i, reason: collision with root package name */
    private double f6603i;

    /* renamed from: a, reason: collision with root package name */
    double f6597a = Math.sqrt(1500.0d);

    /* renamed from: b, reason: collision with root package name */
    double f6598b = 0.5d;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6599c = false;

    /* renamed from: j, reason: collision with root package name */
    private final AbstractC0350b.a f6604j = new AbstractC0350b.a();

    public e(float f4) {
        this.f6603i = f4;
    }

    public final float a() {
        return (float) this.f6603i;
    }

    public final boolean b(float f4, float f5) {
        return ((double) Math.abs(f5)) < this.f6600e && ((double) Math.abs(f4 - ((float) this.f6603i))) < this.d;
    }

    public final e c(float f4) {
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f6598b = f4;
        this.f6599c = false;
        return this;
    }

    public final e d(float f4) {
        this.f6603i = f4;
        return this;
    }

    public final e e(float f4) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f6597a = Math.sqrt(f4);
        this.f6599c = false;
        return this;
    }

    final void f(double d) {
        double dAbs = Math.abs(d);
        this.d = dAbs;
        this.f6600e = dAbs * 62.5d;
    }

    final AbstractC0350b.a g(double d, double d2, long j2) {
        double dCos;
        double dPow;
        if (!this.f6599c) {
            if (this.f6603i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the miuix.animation starts");
            }
            double d4 = this.f6598b;
            if (d4 > 1.0d) {
                double d5 = this.f6597a;
                this.f6601f = (Math.sqrt((d4 * d4) - 1.0d) * d5) + ((-d4) * d5);
                double d6 = this.f6598b;
                double d7 = this.f6597a;
                this.g = ((-d6) * d7) - (Math.sqrt((d6 * d6) - 1.0d) * d7);
            } else if (d4 >= 0.0d && d4 < 1.0d) {
                this.f6602h = Math.sqrt(1.0d - (d4 * d4)) * this.f6597a;
            }
            this.f6599c = true;
        }
        double d8 = j2 / 1000.0d;
        double d9 = d - this.f6603i;
        double d10 = this.f6598b;
        if (d10 > 1.0d) {
            double d11 = this.g;
            double d12 = this.f6601f;
            double d13 = d9 - (((d11 * d9) - d2) / (d11 - d12));
            double d14 = ((d9 * d11) - d2) / (d11 - d12);
            dPow = (Math.pow(2.718281828459045d, this.f6601f * d8) * d14) + (Math.pow(2.718281828459045d, d11 * d8) * d13);
            double d15 = this.g;
            double dPow2 = Math.pow(2.718281828459045d, d15 * d8) * d13 * d15;
            double d16 = this.f6601f;
            dCos = (Math.pow(2.718281828459045d, d16 * d8) * d14 * d16) + dPow2;
        } else if (d10 == 1.0d) {
            double d17 = this.f6597a;
            double d18 = (d17 * d9) + d2;
            double d19 = (d18 * d8) + d9;
            double dPow3 = Math.pow(2.718281828459045d, (-d17) * d8) * d19;
            double dPow4 = Math.pow(2.718281828459045d, (-this.f6597a) * d8) * d19;
            double d20 = this.f6597a;
            dCos = (Math.pow(2.718281828459045d, (-d20) * d8) * d18) + (dPow4 * (-d20));
            dPow = dPow3;
        } else {
            double d21 = 1.0d / this.f6602h;
            double d22 = this.f6597a;
            double d23 = ((d10 * d22 * d9) + d2) * d21;
            double dSin = ((Math.sin(this.f6602h * d8) * d23) + (Math.cos(this.f6602h * d8) * d9)) * Math.pow(2.718281828459045d, (-d10) * d22 * d8);
            double d24 = this.f6597a;
            double d25 = this.f6598b;
            double d26 = (-d24) * dSin * d25;
            double dPow5 = Math.pow(2.718281828459045d, (-d25) * d24 * d8);
            double d27 = this.f6602h;
            double dSin2 = Math.sin(d27 * d8) * (-d27) * d9;
            double d28 = this.f6602h;
            dCos = (((Math.cos(d28 * d8) * d23 * d28) + dSin2) * dPow5) + d26;
            dPow = dSin;
        }
        AbstractC0350b.a aVar = this.f6604j;
        aVar.f6591a = (float) (dPow + this.f6603i);
        aVar.f6592b = (float) dCos;
        return aVar;
    }
}
