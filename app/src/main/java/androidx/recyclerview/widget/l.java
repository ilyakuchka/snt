package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
final class l extends RecyclerView.k implements RecyclerView.n {

    /* renamed from: C, reason: collision with root package name */
    private static final int[] f4200C = {R.attr.state_pressed};

    /* renamed from: D, reason: collision with root package name */
    private static final int[] f4201D = new int[0];

    /* renamed from: A, reason: collision with root package name */
    int f4202A;

    /* renamed from: B, reason: collision with root package name */
    private final Runnable f4203B;

    /* renamed from: a, reason: collision with root package name */
    private final int f4204a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4205b;

    /* renamed from: c, reason: collision with root package name */
    final StateListDrawable f4206c;
    final Drawable d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4207e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4208f;
    private final StateListDrawable g;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f4209h;

    /* renamed from: i, reason: collision with root package name */
    private final int f4210i;

    /* renamed from: j, reason: collision with root package name */
    private final int f4211j;

    /* renamed from: k, reason: collision with root package name */
    int f4212k;

    /* renamed from: l, reason: collision with root package name */
    int f4213l;

    /* renamed from: m, reason: collision with root package name */
    float f4214m;

    /* renamed from: n, reason: collision with root package name */
    int f4215n;

    /* renamed from: o, reason: collision with root package name */
    int f4216o;
    float p;

    /* renamed from: s, reason: collision with root package name */
    private RecyclerView f4219s;

    /* renamed from: z, reason: collision with root package name */
    final ValueAnimator f4225z;

    /* renamed from: q, reason: collision with root package name */
    private int f4217q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f4218r = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f4220t = false;
    private boolean u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f4221v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f4222w = 0;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f4223x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    private final int[] f4224y = new int[2];

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l lVar = l.this;
            int i2 = lVar.f4202A;
            if (i2 == 1) {
                lVar.f4225z.cancel();
            } else if (i2 != 2) {
                return;
            }
            lVar.f4202A = 3;
            ValueAnimator valueAnimator = lVar.f4225z;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            lVar.f4225z.setDuration(500);
            lVar.f4225z.start();
        }
    }

    final class b extends RecyclerView.o {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public final void b(RecyclerView recyclerView) {
            l.this.m(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class c extends AnimatorListenerAdapter {

        /* renamed from: i, reason: collision with root package name */
        private boolean f4228i = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f4228i = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.f4228i) {
                this.f4228i = false;
                return;
            }
            if (((Float) l.this.f4225z.getAnimatedValue()).floatValue() == 0.0f) {
                l lVar = l.this;
                lVar.f4202A = 0;
                lVar.k(0);
            } else {
                l lVar2 = l.this;
                lVar2.f4202A = 2;
                lVar2.i();
            }
        }
    }

    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            l.this.f4206c.setAlpha(iFloatValue);
            l.this.d.setAlpha(iFloatValue);
            l.this.i();
        }
    }

    l(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i4, int i5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4225z = valueAnimatorOfFloat;
        this.f4202A = 0;
        this.f4203B = new a();
        b bVar = new b();
        this.f4206c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.f4209h = drawable2;
        this.f4207e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f4208f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f4210i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f4211j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f4204a = i4;
        this.f4205b = i5;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        RecyclerView recyclerView2 = this.f4219s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            RecyclerView.l lVar = recyclerView2.u;
            if (lVar != null) {
                lVar.g("Cannot remove item decoration during a scroll  or layout");
            }
            recyclerView2.f3968w.remove(this);
            if (recyclerView2.f3968w.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.X();
            recyclerView2.requestLayout();
            this.f4219s.h0(this);
            this.f4219s.i0(bVar);
            f();
        }
        this.f4219s = recyclerView;
        if (recyclerView != null) {
            recyclerView.g(this);
            this.f4219s.h(this);
            this.f4219s.i(bVar);
        }
    }

    private void f() {
        this.f4219s.removeCallbacks(this.f4203B);
    }

    private int j(float f4, float f5, int[] iArr, int i2, int i4, int i5) {
        int i6 = iArr[1] - iArr[0];
        if (i6 == 0) {
            return 0;
        }
        int i7 = i2 - i5;
        int i8 = (int) (((f5 - f4) / i6) * i7);
        int i9 = i4 + i8;
        if (i9 >= i7 || i9 < 0) {
            return 0;
        }
        return i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public final boolean a(MotionEvent motionEvent) {
        int i2 = this.f4221v;
        if (i2 == 1) {
            boolean zH = h(motionEvent.getX(), motionEvent.getY());
            boolean zG = g(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (zH || zG)) {
                if (zG) {
                    this.f4222w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (zH) {
                    this.f4222w = 2;
                    this.f4214m = (int) motionEvent.getY();
                }
                k(2);
                return true;
            }
        } else if (i2 == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public final void b() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public final void c(MotionEvent motionEvent) {
        if (this.f4221v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zH = h(motionEvent.getX(), motionEvent.getY());
            boolean zG = g(motionEvent.getX(), motionEvent.getY());
            if (zH || zG) {
                if (zG) {
                    this.f4222w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (zH) {
                    this.f4222w = 2;
                    this.f4214m = (int) motionEvent.getY();
                }
                k(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f4221v == 2) {
            this.f4214m = 0.0f;
            this.p = 0.0f;
            k(1);
            this.f4222w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f4221v == 2) {
            l();
            if (this.f4222w == 1) {
                float x2 = motionEvent.getX();
                int[] iArr = this.f4224y;
                int i2 = this.f4205b;
                iArr[0] = i2;
                iArr[1] = this.f4217q - i2;
                float fMax = Math.max(iArr[0], Math.min(iArr[1], x2));
                if (Math.abs(this.f4216o - fMax) >= 2.0f) {
                    int iJ = j(this.p, fMax, iArr, this.f4219s.computeHorizontalScrollRange(), this.f4219s.computeHorizontalScrollOffset(), this.f4217q);
                    if (iJ != 0) {
                        this.f4219s.scrollBy(iJ, 0);
                    }
                    this.p = fMax;
                }
            }
            if (this.f4222w == 2) {
                float y2 = motionEvent.getY();
                int[] iArr2 = this.f4223x;
                int i4 = this.f4205b;
                iArr2[0] = i4;
                iArr2[1] = this.f4218r - i4;
                float fMax2 = Math.max(iArr2[0], Math.min(iArr2[1], y2));
                if (Math.abs(this.f4213l - fMax2) < 2.0f) {
                    return;
                }
                int iJ2 = j(this.f4214m, fMax2, iArr2, this.f4219s.computeVerticalScrollRange(), this.f4219s.computeVerticalScrollOffset(), this.f4218r);
                if (iJ2 != 0) {
                    this.f4219s.scrollBy(0, iJ2);
                }
                this.f4214m = fMax2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public final void e(Canvas canvas, RecyclerView recyclerView) {
        if (this.f4217q != this.f4219s.getWidth() || this.f4218r != this.f4219s.getHeight()) {
            this.f4217q = this.f4219s.getWidth();
            this.f4218r = this.f4219s.getHeight();
            k(0);
            return;
        }
        if (this.f4202A != 0) {
            if (this.f4220t) {
                int i2 = this.f4217q;
                int i4 = this.f4207e;
                int i5 = i2 - i4;
                int i6 = this.f4213l;
                int i7 = this.f4212k;
                int i8 = i6 - (i7 / 2);
                this.f4206c.setBounds(0, 0, i4, i7);
                this.d.setBounds(0, 0, this.f4208f, this.f4218r);
                RecyclerView recyclerView2 = this.f4219s;
                int i9 = androidx.core.view.o.d;
                if (recyclerView2.getLayoutDirection() == 1) {
                    this.d.draw(canvas);
                    canvas.translate(this.f4207e, i8);
                    canvas.scale(-1.0f, 1.0f);
                    this.f4206c.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    canvas.translate(-this.f4207e, -i8);
                } else {
                    canvas.translate(i5, 0.0f);
                    this.d.draw(canvas);
                    canvas.translate(0.0f, i8);
                    this.f4206c.draw(canvas);
                    canvas.translate(-i5, -i8);
                }
            }
            if (this.u) {
                int i10 = this.f4218r;
                int i11 = this.f4210i;
                int i12 = this.f4216o;
                int i13 = this.f4215n;
                this.g.setBounds(0, 0, i13, i11);
                this.f4209h.setBounds(0, 0, this.f4217q, this.f4211j);
                canvas.translate(0.0f, i10 - i11);
                this.f4209h.draw(canvas);
                canvas.translate(i12 - (i13 / 2), 0.0f);
                this.g.draw(canvas);
                canvas.translate(-r3, -r8);
            }
        }
    }

    final boolean g(float f4, float f5) {
        if (f5 >= this.f4218r - this.f4210i) {
            int i2 = this.f4216o;
            int i4 = this.f4215n;
            if (f4 >= i2 - (i4 / 2) && f4 <= (i4 / 2) + i2) {
                return true;
            }
        }
        return false;
    }

    final boolean h(float f4, float f5) {
        RecyclerView recyclerView = this.f4219s;
        int i2 = androidx.core.view.o.d;
        if (recyclerView.getLayoutDirection() == 1) {
            if (f4 > this.f4207e / 2) {
                return false;
            }
        } else if (f4 < this.f4217q - this.f4207e) {
            return false;
        }
        int i4 = this.f4213l;
        int i5 = this.f4212k;
        return f5 >= ((float) (i4 - (i5 / 2))) && f5 <= ((float) ((i5 / 2) + i4));
    }

    final void i() {
        this.f4219s.invalidate();
    }

    final void k(int i2) {
        if (i2 == 2 && this.f4221v != 2) {
            this.f4206c.setState(f4200C);
            f();
        }
        if (i2 == 0) {
            i();
        } else {
            l();
        }
        if (this.f4221v == 2 && i2 != 2) {
            this.f4206c.setState(f4201D);
            f();
            this.f4219s.postDelayed(this.f4203B, 1200);
        } else if (i2 == 1) {
            f();
            this.f4219s.postDelayed(this.f4203B, 1500);
        }
        this.f4221v = i2;
    }

    public final void l() {
        int i2 = this.f4202A;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                this.f4225z.cancel();
            }
        }
        this.f4202A = 1;
        ValueAnimator valueAnimator = this.f4225z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f4225z.setDuration(500L);
        this.f4225z.setStartDelay(0L);
        this.f4225z.start();
    }

    final void m(int i2, int i4) {
        int iComputeVerticalScrollRange = this.f4219s.computeVerticalScrollRange();
        int i5 = this.f4218r;
        this.f4220t = iComputeVerticalScrollRange - i5 > 0 && i5 >= this.f4204a;
        int iComputeHorizontalScrollRange = this.f4219s.computeHorizontalScrollRange();
        int i6 = this.f4217q;
        boolean z4 = iComputeHorizontalScrollRange - i6 > 0 && i6 >= this.f4204a;
        this.u = z4;
        boolean z5 = this.f4220t;
        if (!z5 && !z4) {
            if (this.f4221v != 0) {
                k(0);
                return;
            }
            return;
        }
        if (z5) {
            float f4 = i5;
            this.f4213l = (int) ((((f4 / 2.0f) + i4) * f4) / iComputeVerticalScrollRange);
            this.f4212k = Math.min(i5, (i5 * i5) / iComputeVerticalScrollRange);
        }
        if (this.u) {
            float f5 = i6;
            this.f4216o = (int) ((((f5 / 2.0f) + i2) * f5) / iComputeHorizontalScrollRange);
            this.f4215n = Math.min(i6, (i6 * i6) / iComputeHorizontalScrollRange);
        }
        int i7 = this.f4221v;
        if (i7 == 0 || i7 == 1) {
            k(1);
        }
    }
}
