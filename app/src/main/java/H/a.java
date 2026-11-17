package H;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.core.view.o;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: y, reason: collision with root package name */
    private static final int f230y = ViewConfiguration.getTapTimeout();

    /* renamed from: i, reason: collision with root package name */
    final C0009a f231i;

    /* renamed from: j, reason: collision with root package name */
    private final AccelerateInterpolator f232j;

    /* renamed from: k, reason: collision with root package name */
    final View f233k;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f234l;

    /* renamed from: m, reason: collision with root package name */
    private float[] f235m;

    /* renamed from: n, reason: collision with root package name */
    private float[] f236n;

    /* renamed from: o, reason: collision with root package name */
    private int f237o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private float[] f238q;

    /* renamed from: r, reason: collision with root package name */
    private float[] f239r;

    /* renamed from: s, reason: collision with root package name */
    private float[] f240s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f241t;
    boolean u;

    /* renamed from: v, reason: collision with root package name */
    boolean f242v;

    /* renamed from: w, reason: collision with root package name */
    boolean f243w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f244x;

    /* renamed from: H.a$a, reason: collision with other inner class name */
    private static class C0009a {

        /* renamed from: a, reason: collision with root package name */
        private int f245a;

        /* renamed from: b, reason: collision with root package name */
        private int f246b;

        /* renamed from: c, reason: collision with root package name */
        private float f247c;
        private float d;

        /* renamed from: j, reason: collision with root package name */
        private float f252j;

        /* renamed from: k, reason: collision with root package name */
        private int f253k;

        /* renamed from: e, reason: collision with root package name */
        private long f248e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f251i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f249f = 0;
        private int g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f250h = 0;

        C0009a() {
        }

        private float d(long j2) {
            if (j2 < this.f248e) {
                return 0.0f;
            }
            long j4 = this.f251i;
            if (j4 < 0 || j2 < j4) {
                return a.c((j2 - r0) / this.f245a, 0.0f, 1.0f) * 0.5f;
            }
            float f4 = this.f252j;
            return (f4 * a.c((j2 - j4) / this.f253k, 0.0f, 1.0f)) + (1.0f - f4);
        }

        public final void a() {
            if (this.f249f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fD = d(jCurrentAnimationTimeMillis);
            long j2 = jCurrentAnimationTimeMillis - this.f249f;
            this.f249f = jCurrentAnimationTimeMillis;
            float f4 = j2 * ((fD * 4.0f) + ((-4.0f) * fD * fD));
            this.g = (int) (this.f247c * f4);
            this.f250h = (int) (f4 * this.d);
        }

        public final int b() {
            return this.f250h;
        }

        public final int c() {
            float f4 = this.f247c;
            return (int) (f4 / Math.abs(f4));
        }

        public final int e() {
            float f4 = this.d;
            return (int) (f4 / Math.abs(f4));
        }

        public final boolean f() {
            return this.f251i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f251i + ((long) this.f253k);
        }

        public final void g() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            int i2 = (int) (jCurrentAnimationTimeMillis - this.f248e);
            int i4 = this.f246b;
            if (i2 > i4) {
                i2 = i4;
            } else if (i2 < 0) {
                i2 = 0;
            }
            this.f253k = i2;
            this.f252j = d(jCurrentAnimationTimeMillis);
            this.f251i = jCurrentAnimationTimeMillis;
        }

        public final void h() {
            this.f246b = 500;
        }

        public final void i() {
            this.f245a = 500;
        }

        public final void j(float f4, float f5) {
            this.f247c = f4;
            this.d = f5;
        }

        public final void k() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f248e = jCurrentAnimationTimeMillis;
            this.f251i = -1L;
            this.f249f = jCurrentAnimationTimeMillis;
            this.f252j = 0.5f;
            this.g = 0;
            this.f250h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            if (aVar.f243w) {
                if (aVar.u) {
                    aVar.u = false;
                    aVar.f231i.k();
                }
                C0009a c0009a = a.this.f231i;
                if (c0009a.f() || !a.this.g()) {
                    a.this.f243w = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f242v) {
                    aVar2.f242v = false;
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar2.f233k.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                c0009a.a();
                a.this.e(c0009a.b());
                View view = a.this.f233k;
                int i2 = o.d;
                view.postOnAnimation(this);
            }
        }
    }

    public a(View view) {
        C0009a c0009a = new C0009a();
        this.f231i = c0009a;
        this.f232j = new AccelerateInterpolator();
        this.f235m = new float[]{0.0f, 0.0f};
        this.f236n = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f238q = new float[]{0.0f, 0.0f};
        this.f239r = new float[]{0.0f, 0.0f};
        this.f240s = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f233k = view;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.f240s;
        float f5 = ((int) ((1575.0f * f4) + 0.5f)) / 1000.0f;
        fArr[0] = f5;
        fArr[1] = f5;
        float[] fArr2 = this.f239r;
        float f6 = ((int) ((f4 * 315.0f) + 0.5f)) / 1000.0f;
        fArr2[0] = f6;
        fArr2[1] = f6;
        this.f237o = 1;
        float[] fArr3 = this.f236n;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f235m;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.f238q;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.p = f230y;
        c0009a.i();
        c0009a.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float b(int i2, float f4, float f5, float f6) {
        float fC;
        float interpolation;
        float fC2 = c(this.f235m[i2] * f5, 0.0f, this.f236n[i2]);
        float fD = d(f5 - f4, fC2) - d(f4, fC2);
        if (fD < 0.0f) {
            interpolation = -this.f232j.getInterpolation(-fD);
        } else {
            if (fD <= 0.0f) {
                fC = 0.0f;
                if (fC != 0.0f) {
                    return 0.0f;
                }
                float f7 = this.f238q[i2];
                float f8 = this.f239r[i2];
                float f9 = this.f240s[i2];
                float f10 = f7 * f6;
                return fC > 0.0f ? c(fC * f10, f8, f9) : -c((-fC) * f10, f8, f9);
            }
            interpolation = this.f232j.getInterpolation(fD);
        }
        fC = c(interpolation, -1.0f, 1.0f);
        if (fC != 0.0f) {
        }
    }

    static float c(float f4, float f5, float f6) {
        return f4 > f6 ? f6 : f4 < f5 ? f5 : f4;
    }

    private float d(float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f237o;
        if (i2 == 0 || i2 == 1) {
            if (f4 < f5) {
                if (f4 >= 0.0f) {
                    return 1.0f - (f4 / f5);
                }
                if (this.f243w && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f4 < 0.0f) {
            return f4 / (-f5);
        }
        return 0.0f;
    }

    public abstract boolean a(int i2);

    public abstract void e(int i2);

    public final a f(boolean z4) {
        if (this.f244x && !z4) {
            if (this.u) {
                this.f243w = false;
            } else {
                this.f231i.g();
            }
        }
        this.f244x = z4;
        return this;
    }

    final boolean g() {
        C0009a c0009a = this.f231i;
        int iE = c0009a.e();
        c0009a.c();
        return iE != 0 && a(iE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0017  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i2;
        if (!this.f244x) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.u) {
                    this.f243w = false;
                } else {
                    this.f231i.g();
                }
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                }
            }
            return false;
        }
        this.f242v = true;
        this.f241t = false;
        this.f231i.j(b(0, motionEvent.getX(), view.getWidth(), this.f233k.getWidth()), b(1, motionEvent.getY(), view.getHeight(), this.f233k.getHeight()));
        if (!this.f243w && g()) {
            if (this.f234l == null) {
                this.f234l = new b();
            }
            this.f243w = true;
            this.u = true;
            if (this.f241t || (i2 = this.p) <= 0) {
                ((b) this.f234l).run();
            } else {
                View view2 = this.f233k;
                Runnable runnable = this.f234l;
                long j2 = i2;
                int i4 = o.d;
                view2.postOnAnimationDelayed(runnable, j2);
            }
            this.f241t = true;
        }
        return false;
    }
}
