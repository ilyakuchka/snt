package miuix.smooth;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: miuix.smooth.a$a, reason: collision with other inner class name */
    public static class C0127a {

        /* renamed from: a, reason: collision with root package name */
        public RectF f7437a;

        /* renamed from: b, reason: collision with root package name */
        public float f7438b;

        /* renamed from: c, reason: collision with root package name */
        public double f7439c;
        public double d;

        /* renamed from: e, reason: collision with root package name */
        public double f7440e;

        /* renamed from: f, reason: collision with root package name */
        public double f7441f;
        public float g;

        /* renamed from: h, reason: collision with root package name */
        public PointF[] f7442h = new PointF[4];

        /* renamed from: i, reason: collision with root package name */
        public PointF[] f7443i = new PointF[4];

        public final void a(float f4, RectF rectF, float f5, float f6, double d, int i2) {
            double dCos;
            this.f7438b = f4;
            float fWidth = rectF.width();
            float fHeight = rectF.height();
            float f7 = rectF.left;
            float f8 = rectF.top;
            float f9 = rectF.right;
            float f10 = rectF.bottom;
            this.f7439c = a.a(fWidth, this.f7438b, d);
            double dB = a.b(fHeight, this.f7438b, d);
            this.d = dB;
            double d2 = (this.f7439c * 3.141592653589793d) / 4.0d;
            this.f7440e = d2;
            double d4 = (dB * 3.141592653589793d) / 4.0d;
            this.f7441f = d4;
            this.g = (float) a.h((1.5707963267948966d - d4) - d2);
            double d5 = 0.46f;
            double d6 = this.f7439c * d5;
            double d7 = this.f7440e;
            double dCos2 = 0.0d;
            if (d7 == 0.0d) {
                dCos = 0.0d;
            } else {
                double d8 = d7 / 2.0d;
                dCos = (((Math.cos(d7) + 1.0d) * ((Math.tan(d8) + (d6 * 0.46000000834465027d)) * 2.0d)) / (Math.tan(d8) * 3.0d)) - 1.0d;
            }
            double dSin = (1.0d - Math.sin(this.f7440e)) * this.f7438b;
            double dCos3 = (1.0d - Math.cos(this.f7440e)) * this.f7438b;
            double dTan = (1.0d - Math.tan(this.f7440e / 2.0d)) * this.f7438b;
            float f11 = this.f7438b;
            double d9 = this.f7440e;
            double dTan2 = (Math.tan(d9 / 2.0d) * (f11 * 1.5d)) / (Math.cos(d9) + 1.0d);
            double d10 = dCos * dTan2;
            double d11 = this.d * d5;
            double d12 = this.f7441f;
            if (d12 != 0.0d) {
                double d13 = d12 / 2.0d;
                dCos2 = (((Math.cos(d12) + 1.0d) * ((Math.tan(d13) + (d11 * 0.46000000834465027d)) * 2.0d)) / (Math.tan(d13) * 3.0d)) - 1.0d;
            }
            double dCos4 = (1.0d - Math.cos(this.f7441f)) * this.f7438b;
            double dSin2 = (1.0d - Math.sin(this.f7441f)) * this.f7438b;
            double dTan3 = (1.0d - Math.tan(this.f7441f / 2.0d)) * this.f7438b;
            float f12 = this.f7438b;
            double d14 = this.f7441f;
            double dTan4 = (Math.tan(d14 / 2.0d) * (f12 * 1.5d)) / (Math.cos(d14) + 1.0d);
            double d15 = dCos2 * dTan4;
            if (i2 == 0) {
                float f13 = f7 + f5;
                float f14 = f8 + f6;
                float f15 = this.f7438b * 2.0f;
                this.f7437a = new RectF(f13, f14, f15 + f13, f15 + f14);
                double d16 = f13;
                double d17 = f14;
                this.f7442h[0] = new PointF((float) (dSin + d16), (float) (dCos3 + d17));
                this.f7442h[1] = new PointF((float) (dTan + d16), f14);
                double d18 = dTan + dTan2;
                this.f7442h[2] = new PointF((float) (d18 + d16), f14);
                this.f7442h[3] = new PointF((float) (d18 + d10 + d16), f14);
                double d19 = dTan3 + dTan4;
                this.f7443i[0] = new PointF(f13, (float) (d19 + d15 + d17));
                this.f7443i[1] = new PointF(f13, (float) (d19 + d17));
                this.f7443i[2] = new PointF(f13, (float) (dTan3 + d17));
                this.f7443i[3] = new PointF((float) (dCos4 + d16), (float) (dSin2 + d17));
                return;
            }
            if (i2 == 1) {
                float f16 = f8 + f6;
                float f17 = this.f7438b * 2.0f;
                float f18 = f9 - f5;
                this.f7437a = new RectF((f9 - f17) - f5, f16, f18, f17 + f16);
                double d20 = f9;
                double d21 = d20 - dTan;
                double d22 = d21 - dTan2;
                double d23 = f5;
                this.f7442h[0] = new PointF((float) ((d22 - d10) - d23), f16);
                this.f7442h[1] = new PointF((float) (d22 - d23), f16);
                this.f7442h[2] = new PointF((float) (d21 - d23), f16);
                double d24 = f16;
                this.f7442h[3] = new PointF((float) ((d20 - dSin) - d23), (float) (dCos3 + d24));
                this.f7443i[0] = new PointF((float) ((d20 - dCos4) - d23), (float) (dSin2 + d24));
                this.f7443i[1] = new PointF(f18, (float) (dTan3 + d24));
                double d25 = dTan3 + dTan4;
                this.f7443i[2] = new PointF(f18, (float) (d25 + d24));
                this.f7443i[3] = new PointF(f18, (float) (d25 + d15 + d24));
                return;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    float f19 = f7 + f5;
                    float f20 = this.f7438b * 2.0f;
                    float f21 = f10 - f6;
                    this.f7437a = new RectF(f19, (f10 - f20) - f6, f20 + f19, f21);
                    double d26 = dTan + dTan2;
                    double d27 = f19;
                    this.f7442h[0] = new PointF((float) (d10 + d26 + d27), f21);
                    this.f7442h[1] = new PointF((float) (d26 + d27), f21);
                    this.f7442h[2] = new PointF((float) (dTan + d27), f21);
                    float f22 = (float) (dSin + d27);
                    double d28 = f10;
                    double d29 = f6;
                    this.f7442h[3] = new PointF(f22, (float) ((d28 - dCos3) - d29));
                    this.f7443i[0] = new PointF((float) (dCos4 + d27), (float) ((d28 - dSin2) - d29));
                    double d30 = d28 - dTan3;
                    this.f7443i[1] = new PointF(f19, (float) (d30 - d29));
                    double d31 = d30 - dTan4;
                    this.f7443i[2] = new PointF(f19, (float) (d31 - d29));
                    this.f7443i[3] = new PointF(f19, (float) ((d31 - d15) - d29));
                    return;
                }
                return;
            }
            float f23 = this.f7438b * 2.0f;
            float f24 = f9 - f5;
            float f25 = f10 - f6;
            this.f7437a = new RectF((f9 - f23) - f5, (f10 - f23) - f6, f24, f25);
            double d32 = f9;
            double d33 = f5;
            double d34 = f10;
            double d35 = d34 - dCos3;
            double d36 = f6;
            this.f7442h[0] = new PointF((float) ((d32 - dSin) - d33), (float) (d35 - d36));
            double d37 = d32 - dTan;
            this.f7442h[1] = new PointF((float) (d37 - d33), f25);
            double d38 = d37 - dTan2;
            this.f7442h[2] = new PointF((float) (d38 - d33), f25);
            this.f7442h[3] = new PointF((float) ((d38 - d10) - d33), f25);
            double d39 = d34 - dTan3;
            double d40 = d39 - dTan4;
            this.f7443i[0] = new PointF(f24, (float) ((d40 - d15) - d36));
            this.f7443i[1] = new PointF(f24, (float) (d40 - d36));
            this.f7443i[2] = new PointF(f24, (float) (d39 - d36));
            this.f7443i[3] = new PointF((float) ((d32 - dCos4) - d33), (float) ((d34 - dSin2) - d36));
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public float f7444a;

        /* renamed from: b, reason: collision with root package name */
        public float f7445b;

        /* renamed from: c, reason: collision with root package name */
        public double f7446c;
        public C0127a d = null;

        /* renamed from: e, reason: collision with root package name */
        public C0127a f7447e = null;

        /* renamed from: f, reason: collision with root package name */
        public C0127a f7448f = null;
        public C0127a g = null;

        public b(float f4, float f5, double d) {
            this.f7444a = f4;
            this.f7445b = f5;
            this.f7446c = d;
        }
    }

    static double a(float f4, float f5, double d) {
        return g(f4, f5, f5, d, 0.46f) ? Math.max(Math.min(((f4 / (f5 * 2.0f)) - 1.0f) / 0.46f, 1.0f), 0.0f) : d;
    }

    static double b(float f4, float f5, double d) {
        return f(f4, f5, f5, d, 0.46f) ? Math.max(Math.min(((f4 / (f5 * 2.0f)) - 1.0f) / 0.46f, 1.0f), 0.0f) : d;
    }

    private static boolean f(float f4, float f5, float f6, double d, float f7) {
        return ((double) f4) <= ((d * ((double) f7)) + 1.0d) * ((double) (f5 + f6));
    }

    private static boolean g(float f4, float f5, float f6, double d, float f7) {
        return ((double) f4) <= ((d * ((double) f7)) + 1.0d) * ((double) (f5 + f6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double h(double d) {
        return (d * 180.0d) / 3.141592653589793d;
    }

    public final b d(RectF rectF, float[] fArr, float f4, float f5) {
        if (fArr == null) {
            return null;
        }
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        double d = 0.8f;
        b bVar = new b(fWidth, fHeight, d);
        float[] fArr2 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        for (int i2 = 0; i2 < Math.min(8, fArr.length); i2++) {
            if (!Float.isNaN(fArr[i2])) {
                fArr2[i2] = fArr[i2];
            }
        }
        float f6 = fArr2[0];
        float f7 = fArr2[1];
        float f8 = fArr2[2];
        float f9 = fArr2[3];
        float f10 = fArr2[4];
        float f11 = fArr2[5];
        float f12 = fArr2[6];
        float f13 = fArr2[7];
        if (f6 + f8 > fWidth) {
            f6 = (fArr2[0] * fWidth) / (fArr2[0] + fArr2[2]);
            f8 = (fArr2[2] * fWidth) / (fArr2[0] + fArr2[2]);
        }
        if (f9 + f11 > fHeight) {
            f9 = (fArr2[3] * fHeight) / (fArr2[3] + fArr2[5]);
            f11 = (fArr2[5] * fHeight) / (fArr2[3] + fArr2[5]);
        }
        float f14 = f9;
        float f15 = f11;
        if (f10 + f12 > fWidth) {
            f10 = (fArr2[4] * fWidth) / (fArr2[4] + fArr2[6]);
            f12 = (fWidth * fArr2[6]) / (fArr2[4] + fArr2[6]);
        }
        float f16 = f12;
        if (f13 + f7 > fHeight) {
            f13 = (fArr2[7] * fHeight) / (fArr2[7] + fArr2[1]);
            f7 = (fHeight * fArr2[1]) / (fArr2[7] + fArr2[1]);
        }
        float f17 = f13;
        if (bVar.d == null) {
            bVar.d = new C0127a();
        }
        if (bVar.f7447e == null) {
            bVar.f7447e = new C0127a();
        }
        if (bVar.f7448f == null) {
            bVar.f7448f = new C0127a();
        }
        if (bVar.g == null) {
            bVar.g = new C0127a();
        }
        bVar.d.a(Math.min(f6, f7), rectF, f4, f5, d, 0);
        bVar.f7447e.a(Math.min(f8, f14), rectF, f4, f5, d, 1);
        bVar.f7448f.a(Math.min(f10, f15), rectF, f4, f5, d, 2);
        bVar.g.a(Math.min(f16, f17), rectF, f4, f5, d, 3);
        return bVar;
    }

    public final Path e(Path path, b bVar) {
        Path path2 = path == null ? new Path() : path;
        path2.reset();
        if (bVar == null) {
            return path2;
        }
        C0127a c0127a = bVar.d;
        if (c0127a == null || bVar.f7447e == null || bVar.f7448f == null || bVar.g == null) {
            path2.addRect(new RectF(0.0f, 0.0f, bVar.f7444a, bVar.f7445b), Path.Direction.CCW);
            return path2;
        }
        if (c0127a.g != 0.0f) {
            path2.arcTo(c0127a.f7437a, (float) h(c0127a.f7441f + 3.141592653589793d), bVar.d.g);
        } else {
            PointF[] pointFArr = c0127a.f7442h;
            path2.moveTo(pointFArr[0].x, pointFArr[0].y);
        }
        C0127a c0127a2 = bVar.d;
        if (c0127a2.f7439c != 0.0d) {
            PointF[] pointFArr2 = c0127a2.f7442h;
            path2.cubicTo(pointFArr2[1].x, pointFArr2[1].y, pointFArr2[2].x, pointFArr2[2].y, pointFArr2[3].x, pointFArr2[3].y);
        }
        if (!g(bVar.f7444a, bVar.d.f7438b, bVar.f7447e.f7438b, bVar.f7446c, 0.46f)) {
            PointF[] pointFArr3 = bVar.f7447e.f7442h;
            path2.lineTo(pointFArr3[0].x, pointFArr3[0].y);
        }
        C0127a c0127a3 = bVar.f7447e;
        if (c0127a3.f7439c != 0.0d) {
            PointF[] pointFArr4 = c0127a3.f7442h;
            path2.cubicTo(pointFArr4[1].x, pointFArr4[1].y, pointFArr4[2].x, pointFArr4[2].y, pointFArr4[3].x, pointFArr4[3].y);
        }
        C0127a c0127a4 = bVar.f7447e;
        if (c0127a4.g != 0.0f) {
            path2.arcTo(c0127a4.f7437a, (float) h(c0127a4.f7440e + 4.71238898038469d), bVar.f7447e.g);
        }
        C0127a c0127a5 = bVar.f7447e;
        if (c0127a5.d != 0.0d) {
            PointF[] pointFArr5 = c0127a5.f7443i;
            path2.cubicTo(pointFArr5[1].x, pointFArr5[1].y, pointFArr5[2].x, pointFArr5[2].y, pointFArr5[3].x, pointFArr5[3].y);
        }
        if (!f(bVar.f7445b, bVar.f7447e.f7438b, bVar.f7448f.f7438b, bVar.f7446c, 0.46f)) {
            PointF[] pointFArr6 = bVar.f7448f.f7443i;
            path2.lineTo(pointFArr6[0].x, pointFArr6[0].y);
        }
        C0127a c0127a6 = bVar.f7448f;
        if (c0127a6.d != 0.0d) {
            PointF[] pointFArr7 = c0127a6.f7443i;
            path2.cubicTo(pointFArr7[1].x, pointFArr7[1].y, pointFArr7[2].x, pointFArr7[2].y, pointFArr7[3].x, pointFArr7[3].y);
        }
        C0127a c0127a7 = bVar.f7448f;
        if (c0127a7.g != 0.0f) {
            path2.arcTo(c0127a7.f7437a, (float) h(c0127a7.f7441f), bVar.f7448f.g);
        }
        C0127a c0127a8 = bVar.f7448f;
        if (c0127a8.f7439c != 0.0d) {
            PointF[] pointFArr8 = c0127a8.f7442h;
            path2.cubicTo(pointFArr8[1].x, pointFArr8[1].y, pointFArr8[2].x, pointFArr8[2].y, pointFArr8[3].x, pointFArr8[3].y);
        }
        if (!g(bVar.f7444a, bVar.f7448f.f7438b, bVar.g.f7438b, bVar.f7446c, 0.46f)) {
            PointF[] pointFArr9 = bVar.g.f7442h;
            path2.lineTo(pointFArr9[0].x, pointFArr9[0].y);
        }
        C0127a c0127a9 = bVar.g;
        if (c0127a9.f7439c != 0.0d) {
            PointF[] pointFArr10 = c0127a9.f7442h;
            path2.cubicTo(pointFArr10[1].x, pointFArr10[1].y, pointFArr10[2].x, pointFArr10[2].y, pointFArr10[3].x, pointFArr10[3].y);
        }
        C0127a c0127a10 = bVar.g;
        if (c0127a10.g != 0.0f) {
            path2.arcTo(c0127a10.f7437a, (float) h(c0127a10.f7440e + 1.5707963267948966d), bVar.g.g);
        }
        C0127a c0127a11 = bVar.g;
        if (c0127a11.d != 0.0d) {
            PointF[] pointFArr11 = c0127a11.f7443i;
            path2.cubicTo(pointFArr11[1].x, pointFArr11[1].y, pointFArr11[2].x, pointFArr11[2].y, pointFArr11[3].x, pointFArr11[3].y);
        }
        if (!f(bVar.f7445b, bVar.g.f7438b, bVar.d.f7438b, bVar.f7446c, 0.46f)) {
            PointF[] pointFArr12 = bVar.d.f7443i;
            path2.lineTo(pointFArr12[0].x, pointFArr12[0].y);
        }
        C0127a c0127a12 = bVar.d;
        if (c0127a12.d != 0.0d) {
            PointF[] pointFArr13 = c0127a12.f7443i;
            path2.cubicTo(pointFArr13[1].x, pointFArr13[1].y, pointFArr13[2].x, pointFArr13[2].y, pointFArr13[3].x, pointFArr13[3].y);
        }
        path2.close();
        return path2;
    }
}
