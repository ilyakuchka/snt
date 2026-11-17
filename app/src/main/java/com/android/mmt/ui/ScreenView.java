package com.android.mmt.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.android.mmt.R;
import java.util.Objects;

/* loaded from: classes.dex */
public class ScreenView extends ViewGroup {

    /* renamed from: U, reason: collision with root package name */
    private static final LinearLayout.LayoutParams f5340U = new LinearLayout.LayoutParams(-1, -1, 1.0f);

    /* renamed from: V, reason: collision with root package name */
    private static final float f5341V = (float) (0.016d / Math.log(0.75d));

    /* renamed from: A, reason: collision with root package name */
    private int f5342A;

    /* renamed from: B, reason: collision with root package name */
    private ScaleGestureDetector f5343B;

    /* renamed from: C, reason: collision with root package name */
    protected float f5344C;

    /* renamed from: D, reason: collision with root package name */
    protected float f5345D;

    /* renamed from: E, reason: collision with root package name */
    private int f5346E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f5347F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f5348G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f5349H;

    /* renamed from: I, reason: collision with root package name */
    private int f5350I;

    /* renamed from: J, reason: collision with root package name */
    private int f5351J;

    /* renamed from: K, reason: collision with root package name */
    private int f5352K;
    private float L;
    private float M;

    /* renamed from: N, reason: collision with root package name */
    private float f5353N;

    /* renamed from: O, reason: collision with root package name */
    private int f5354O;
    private e P;

    /* renamed from: Q, reason: collision with root package name */
    private int f5355Q;

    /* renamed from: R, reason: collision with root package name */
    private float f5356R;

    /* renamed from: S, reason: collision with root package name */
    private g f5357S;

    /* renamed from: T, reason: collision with root package name */
    private a f5358T;

    /* renamed from: i, reason: collision with root package name */
    private final float f5359i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5360j;

    /* renamed from: k, reason: collision with root package name */
    private int f5361k;

    /* renamed from: l, reason: collision with root package name */
    private int f5362l;

    /* renamed from: m, reason: collision with root package name */
    private f f5363m;

    /* renamed from: n, reason: collision with root package name */
    private int f5364n;

    /* renamed from: o, reason: collision with root package name */
    protected int f5365o;
    protected int p;

    /* renamed from: q, reason: collision with root package name */
    private int f5366q;

    /* renamed from: r, reason: collision with root package name */
    private int f5367r;

    /* renamed from: s, reason: collision with root package name */
    private int f5368s;

    /* renamed from: t, reason: collision with root package name */
    protected int f5369t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    private int f5370v;

    /* renamed from: w, reason: collision with root package name */
    private int f5371w;

    /* renamed from: x, reason: collision with root package name */
    private float f5372x;

    /* renamed from: y, reason: collision with root package name */
    private Scroller f5373y;

    /* renamed from: z, reason: collision with root package name */
    private float f5374z;

    private class a {

        /* renamed from: a, reason: collision with root package name */
        private VelocityTracker f5375a;

        /* renamed from: b, reason: collision with root package name */
        private int f5376b = -1;

        /* renamed from: c, reason: collision with root package name */
        private float f5377c = -1.0f;
        private float d = -1.0f;

        /* renamed from: e, reason: collision with root package name */
        private float f5378e = -1.0f;

        a() {
        }

        public final void a(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            if (action == 1 || action == 3) {
                return;
            }
            if (this.f5375a == null) {
                this.f5375a = VelocityTracker.obtain();
            }
            this.f5375a.addMovement(motionEvent);
            float x2 = motionEvent.getX();
            int i2 = this.f5376b;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                if (iFindPointerIndex != -1) {
                    x2 = motionEvent.getX(iFindPointerIndex);
                } else {
                    this.f5376b = -1;
                }
            }
            float f4 = this.f5377c;
            if (f4 < 0.0f) {
                this.f5377c = x2;
                return;
            }
            float f5 = this.f5378e;
            if (f5 < 0.0f) {
                this.f5378e = x2;
                return;
            }
            float f6 = this.d;
            if (f6 < 0.0f) {
                if (((f5 > f4 && x2 < f5) || (f5 < f4 && x2 > f5)) && Math.abs(x2 - f4) > 3.0f) {
                    this.d = this.f5378e;
                }
            } else if (f6 != f5 && (((f5 > f6 && x2 < f5) || (f5 < f6 && x2 > f5)) && Math.abs(x2 - f6) > 3.0f)) {
                this.f5377c = this.d;
                this.d = this.f5378e;
            }
            this.f5378e = x2;
        }

        public final int b(float f4) {
            if (f4 <= 300.0f) {
                return 4;
            }
            float f5 = this.d;
            if (f5 < 0.0f) {
                return this.f5378e > this.f5377c ? 1 : 2;
            }
            float f6 = this.f5378e;
            return f6 < f5 ? ScreenView.this.getScrollX() < ScreenView.this.g().getLeft() ? 3 : 2 : (f6 <= f5 || ScreenView.this.getScrollX() > ScreenView.this.g().getLeft()) ? 3 : 1;
        }

        public final float c(int i2, int i4) {
            this.f5375a.computeCurrentVelocity(1000, i2);
            return this.f5375a.getXVelocity(i4);
        }

        public final void d(int i2) {
            VelocityTracker velocityTracker = this.f5375a;
            if (velocityTracker == null) {
                this.f5375a = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            float f4 = -1;
            this.f5377c = f4;
            this.d = f4;
            this.f5378e = f4;
            this.f5376b = i2;
        }

        public final void e() {
            VelocityTracker velocityTracker = this.f5375a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f5375a = null;
            }
            this.f5376b = -1;
            float f4 = -1;
            this.f5377c = f4;
            this.d = f4;
            this.f5378e = f4;
        }
    }

    private interface b {
    }

    private class d implements ScaleGestureDetector.OnScaleGestureListener {
        d() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (ScreenView.this.f5346E == 0 && (scaleGestureDetector.getTimeDelta() > 200.0f || scaleFactor < 0.95f || scaleFactor > 1.0526316f)) {
                ScreenView.this.t(null, 4);
            }
            if (scaleFactor < 0.8f) {
                Objects.requireNonNull(ScreenView.this);
                return true;
            }
            if (scaleFactor <= 1.2f) {
                return false;
            }
            Objects.requireNonNull(ScreenView.this);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return ScreenView.this.f5346E == 0;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            ScreenView.this.f();
        }
    }

    private class e implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        private float f5382a;

        public e() {
            this.f5382a = ScreenView.this.f5356R;
        }

        public final void a() {
            this.f5382a = 0.0f;
        }

        public final void b(int i2) {
            this.f5382a = i2 > 0 ? ScreenView.this.f5356R / i2 : ScreenView.this.f5356R;
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            float f6 = this.f5382a;
            return ((((f6 + 1.0f) * f5) + f6) * f5 * f5) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class f extends LinearLayout implements b {
        public f(Context context) {
            super(context);
        }
    }

    public interface g {
        void a();

        void b();
    }

    public ScreenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f5359i = Resources.getSystem().getDisplayMetrics().density * 1280.0f;
        this.f5360j = true;
        this.f5362l = R.drawable.screen_view_seek_point_selector;
        this.f5365o = 1;
        this.f5366q = 0;
        this.u = -1;
        this.f5372x = 0.33333334f;
        this.f5374z = 0.5f;
        this.f5342A = 0;
        this.f5346E = 0;
        this.f5349H = true;
        this.f5352K = -1;
        this.f5353N = 0.5f;
        this.f5354O = 300;
        this.f5355Q = 0;
        this.f5356R = 1.3f;
        this.f5358T = new a();
        setAlwaysDrawnWithCacheEnabled(true);
        setClipToPadding(true);
        this.P = new e();
        this.f5373y = new Scroller(getContext(), this.P);
        q(0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f5350I = viewConfiguration.getScaledTouchSlop();
        this.f5351J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f5343B = new ScaleGestureDetector(getContext(), new d());
    }

    private void j(MotionEvent motionEvent) {
        this.f5358T.a(motionEvent);
        int i2 = this.f5346E;
        if (i2 == 0 || 4 == i2) {
            this.f5343B.onTouchEvent(motionEvent);
        }
    }

    private void k() {
        int i2 = this.p;
        float f4 = this.f5372x;
        int i4 = this.f5364n;
        this.f5371w = ((int) ((-i2) * f4)) - i4;
        this.f5370v = ((int) (((this.f5342A + f4) * i2) - this.f5366q)) + i4;
    }

    private boolean n(MotionEvent motionEvent) {
        float fAbs = Math.abs(motionEvent.getX(0) - this.f5344C);
        if (fAbs > Math.abs(motionEvent.getY(0) - this.f5345D) * this.f5353N) {
            return fAbs > ((float) (motionEvent.getPointerCount() * this.f5350I));
        }
        return false;
    }

    private void o(View view, float f4) {
        if (view.getCameraDistance() == f4) {
            return;
        }
        view.setCameraDistance(f4);
    }

    private void q(int i2) {
        int i4;
        int i5;
        int i6 = this.f5369t;
        if (this.f5363m != null) {
            int i7 = this.f5342A;
            this.f5363m.setContentDescription(getResources().getString(R.string.attachment_panel_show_part, Integer.valueOf(i2 + 1)));
            this.f5363m.sendAccessibilityEvent(16384);
            androidx.core.view.o.j(this.f5363m, new D0(this, i2));
            for (int i8 = 0; i8 < this.f5365o && (i5 = i6 + i8) < i7; i8++) {
                this.f5363m.getChildAt(i5).setSelected(false);
            }
            for (int i9 = 0; i9 < this.f5365o && (i4 = i2 + i9) < i7; i9++) {
                this.f5363m.getChildAt(i4).setSelected(true);
            }
        }
        this.f5369t = i2;
        this.u = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(MotionEvent motionEvent, int i2) {
        this.f5346E = i2;
        getParent().requestDisallowInterceptTouchEvent(this.f5346E != 0);
        if (this.f5346E == 0) {
            this.f5352K = -1;
            this.f5349H = false;
            this.f5358T.e();
            return;
        }
        if (motionEvent != null) {
            int pointerId = motionEvent.getPointerId(0);
            this.f5352K = pointerId;
            this.f5344C = motionEvent.getX(motionEvent.findPointerIndex(pointerId));
        }
        if (this.f5349H) {
            this.f5349H = false;
            View childAt = getChildAt(this.f5369t);
            if (childAt != null) {
                childAt.cancelLongPress();
            }
        }
        if (this.f5346E == 1) {
            this.M = getScrollX();
            this.L = System.nanoTime() / 1.0E9f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v(int i2, boolean z4) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (getWidth() > 0) {
            int i10 = this.f5342A;
            int width = getWidth();
            int height = getHeight();
            for (int i11 = 0; i11 < this.f5361k; i11++) {
                View childAt = getChildAt(i11 + i10);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = layoutParams.gravity;
                if (i12 != -1) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(i12, getLayoutDirection()) & 7;
                    int i13 = i12 & 112;
                    if (absoluteGravity == 1) {
                        i6 = ((width - measuredWidth) / 2) + layoutParams.leftMargin;
                        i7 = layoutParams.rightMargin;
                    } else if (absoluteGravity == 3 || absoluteGravity != 5) {
                        i5 = layoutParams.leftMargin;
                        if (i13 != 16) {
                            i8 = ((height - measuredHeight) / 2) + layoutParams.topMargin;
                            i9 = layoutParams.bottomMargin;
                        } else if (i13 == 48 || i13 != 80) {
                            i4 = layoutParams.topMargin;
                        } else {
                            i8 = height - measuredHeight;
                            i9 = layoutParams.bottomMargin;
                        }
                        i4 = i8 - i9;
                    } else {
                        i6 = width - measuredWidth;
                        i7 = layoutParams.rightMargin;
                    }
                    i5 = i6 - i7;
                    if (i13 != 16) {
                    }
                    i4 = i8 - i9;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (z4 || childAt.getHeight() <= 0 || childAt.getWidth() <= 0) {
                    childAt.layout(i5, i4, measuredWidth + i5, measuredHeight + i4);
                } else {
                    childAt.setTranslationX(i2);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        int iMin = this.f5342A;
        if (i2 >= 0) {
            iMin = Math.min(i2, iMin);
        }
        f fVar = this.f5363m;
        if (fVar != null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(this.f5362l);
            fVar.addView(imageView, iMin, f5340U);
        }
        this.f5342A++;
        k();
        super.addView(view, iMin, layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f5373y.computeScrollOffset()) {
            this.M = this.f5373y.getCurrX();
            setScrollX(this.f5373y.getCurrX());
            this.L = System.nanoTime() / 1.0E9f;
            setScrollY(this.f5373y.getCurrY());
            postInvalidateOnAnimation();
        } else {
            int i2 = this.u;
            if (i2 != -1) {
                q(Math.max(0, Math.min(i2, this.f5342A - 1)));
                this.u = -1;
                g gVar = this.f5357S;
                if (gVar != null) {
                    gVar.b();
                    this.f5357S = null;
                }
            } else if (this.f5346E == 1) {
                float fExp = (float) Math.exp((r0 - this.L) / f5341V);
                float scrollX = this.M - getScrollX();
                setScrollX((int) ((fExp * scrollX) + getScrollX()));
                this.L = System.nanoTime() / 1.0E9f;
                if (scrollX > 1.0f || scrollX < -1.0f) {
                    postInvalidate();
                }
            }
        }
        v(getScrollX(), false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchUnhandledMove(View view, int i2) {
        int i4;
        if (i2 == 17) {
            int i5 = this.f5369t;
            if (i5 > 0) {
                u(i5 - 1, 0, false);
                return true;
            }
        } else if (i2 == 66 && (i4 = this.f5369t) < this.f5342A - 1) {
            u(i4 + 1, 0, false);
            return true;
        }
        return super.dispatchUnhandledMove(view, i2);
    }

    @Override // android.view.ViewGroup
    protected final boolean drawChild(Canvas canvas, View view, long j2) {
        if (!(view instanceof b)) {
            float measuredWidth = view.getMeasuredWidth();
            float measuredHeight = view.getMeasuredHeight();
            float f4 = measuredWidth / 2.0f;
            float f5 = measuredHeight / 2.0f;
            float scrollX = (((getScrollX() + (getMeasuredWidth() / 2.0f)) - view.getLeft()) - f4) / measuredWidth;
            switch (this.f5355Q) {
                case 0:
                    m(view);
                    break;
                case 1:
                    m(view);
                    break;
                case 2:
                    if (scrollX != 0.0f && Math.abs(scrollX) <= 1.0f) {
                        view.setAlpha(((1.0f - Math.abs(scrollX)) * 0.7f) + 0.3f);
                        view.setTranslationX(0.0f);
                        view.setTranslationY(0.0f);
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                        view.setPivotX(0.0f);
                        view.setPivotY(0.0f);
                        view.setRotation(0.0f);
                        view.setRotationX(0.0f);
                        view.setRotationY(0.0f);
                        o(view, this.f5359i);
                        break;
                    } else {
                        m(view);
                        break;
                    }
                case 3:
                    if (scrollX != 0.0f && Math.abs(scrollX) <= 1.0f) {
                        view.setAlpha(1.0f);
                        view.setTranslationX(0.0f);
                        view.setTranslationY(0.0f);
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                        view.setPivotX(f4);
                        view.setPivotY(measuredHeight);
                        view.setRotation((-scrollX) * 30.0f);
                        view.setRotationX(0.0f);
                        view.setRotationY(0.0f);
                        o(view, this.f5359i);
                        break;
                    } else {
                        m(view);
                        break;
                    }
                    break;
                case 4:
                    if (scrollX != 0.0f && Math.abs(scrollX) <= 1.0f) {
                        view.setAlpha(1.0f);
                        view.setTranslationX(0.0f);
                        view.setTranslationY(0.0f);
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                        if (scrollX < 0.0f) {
                            measuredWidth = 0.0f;
                        }
                        view.setPivotX(measuredWidth);
                        view.setPivotY(f5);
                        view.setRotation(0.0f);
                        view.setRotationX(0.0f);
                        view.setRotationY(scrollX * (-90.0f));
                        o(view, 5000.0f);
                        break;
                    } else {
                        m(view);
                        break;
                    }
                case 5:
                    if (scrollX != 0.0f && Math.abs(scrollX) <= 1.0f) {
                        view.setAlpha(1.0f - Math.abs(scrollX));
                        view.setTranslationY(0.0f);
                        view.setTranslationX((measuredWidth * scrollX) - ((Math.abs(scrollX) * measuredWidth) * 0.3f));
                        float f6 = (0.3f * scrollX) + 1.0f;
                        view.setScaleX(f6);
                        view.setScaleY(f6);
                        view.setPivotX(0.0f);
                        view.setPivotY(f5);
                        view.setRotation(0.0f);
                        view.setRotationX(0.0f);
                        view.setRotationY((-scrollX) * 45.0f);
                        o(view, 5000.0f);
                        break;
                    } else {
                        m(view);
                        break;
                    }
                    break;
                case 7:
                    if (scrollX > 0.0f) {
                        float f7 = 1.0f - scrollX;
                        view.setAlpha(f7);
                        float f8 = (f7 * 0.4f) + 0.6f;
                        float f9 = 1.0f - f8;
                        view.setTranslationX(measuredWidth * f9 * 3.0f);
                        view.setTranslationY(measuredHeight * f9 * 0.5f);
                        view.setScaleX(f8);
                        view.setScaleY(f8);
                        view.setPivotX(0.0f);
                        view.setPivotY(0.0f);
                        view.setRotation(0.0f);
                        view.setRotationX(0.0f);
                        view.setRotationY(0.0f);
                        o(view, this.f5359i);
                        break;
                    } else {
                        m(view);
                        break;
                    }
                case 8:
                    if (scrollX != 0.0f && Math.abs(scrollX) <= 1.0f) {
                        view.setAlpha(1.0f - Math.abs(scrollX));
                        view.setTranslationX(measuredWidth * scrollX);
                        view.setTranslationY(0.0f);
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                        view.setPivotX(f4);
                        view.setPivotY(f5);
                        view.setRotation(0.0f);
                        view.setRotationX(0.0f);
                        view.setRotationY((-scrollX) * 90.0f);
                        o(view, 5000.0f);
                        break;
                    } else {
                        m(view);
                        break;
                    }
                    break;
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    protected void e(View view, FrameLayout.LayoutParams layoutParams) {
        this.f5361k++;
        super.addView(view, -1, layoutParams);
    }

    protected final void f() {
        this.f5348G = true;
        t(null, 0);
    }

    public final View g() {
        int i2 = this.f5369t;
        if (i2 < 0 || i2 >= this.f5342A) {
            return null;
        }
        return getChildAt(i2);
    }

    public final int h() {
        int i2 = this.u;
        return i2 != -1 ? i2 : this.f5369t;
    }

    public final int i() {
        return this.f5342A;
    }

    public final void l() {
        int i2 = this.f5342A;
        if (i2 > 0) {
            int iMin = Math.min(i2, i2 + 0);
            f fVar = this.f5363m;
            if (fVar != null) {
                fVar.removeViewsInLayout(0, iMin);
            }
            this.f5342A = 0;
            super.removeViewsInLayout(0, iMin);
        }
        requestLayout();
        invalidate();
    }

    protected final void m(View view) {
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        o(view, this.f5359i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        computeScroll();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i2;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            motionEvent.setAction(3);
            this.f5343B.onTouchEvent(motionEvent);
            motionEvent.setAction(0);
            this.f5348G = false;
            this.f5347F = false;
            this.f5344C = motionEvent.getX();
            this.f5345D = motionEvent.getY();
            if (this.f5373y.isFinished()) {
                this.f5349H = true;
            } else {
                this.f5373y.abortAnimation();
                t(motionEvent, 1);
            }
        } else if (action == 1) {
            t(motionEvent, 0);
        } else if (action == 2) {
            j(motionEvent);
            if (this.f5346E == 0 && n(motionEvent)) {
                t(motionEvent, 1);
            }
        } else if (action == 3) {
        }
        if (2 != (motionEvent.getAction() & 255)) {
            j(motionEvent);
        }
        return this.f5348G || !((i2 = this.f5346E) == 0 || i2 == 3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        v(getScrollX(), true);
        int i7 = this.f5342A;
        int measuredWidth = 0;
        for (int i8 = 0; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                childAt.layout(measuredWidth, getPaddingTop(), childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + getPaddingTop());
                measuredWidth = childAt.getMeasuredWidth() + measuredWidth;
            }
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        this.f5367r = i2;
        this.f5368s = i4;
        int i5 = this.f5342A;
        int iMax = 0;
        int iMax2 = 0;
        for (int i6 = 0; i6 < this.f5361k; i6++) {
            View childAt = getChildAt(i6 + i5);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft(), layoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop(), layoutParams.height));
            iMax = Math.max(iMax, childAt.getMeasuredWidth());
            iMax2 = Math.max(iMax2, childAt.getMeasuredHeight());
        }
        int iMax3 = 0;
        int iMax4 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            View childAt2 = getChildAt(i7);
            ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
            childAt2.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft(), layoutParams2.width), ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop(), layoutParams2.height));
            iMax3 = Math.max(iMax3, childAt2.getMeasuredWidth());
            iMax4 = Math.max(iMax4, childAt2.getMeasuredHeight());
        }
        setMeasuredDimension(View.resolveSize(getPaddingRight() + getPaddingLeft() + Math.max(iMax3, iMax), i2), View.resolveSize(getPaddingBottom() + getPaddingTop() + Math.max(iMax4, iMax2), i4));
        if (i5 > 0) {
            this.p = iMax3;
            this.f5366q = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
            this.f5364n = 0;
            this.f5364n = getPaddingLeft() + 0;
            int i8 = this.p;
            if (i8 > 0) {
                this.f5365o = Math.max(1, (this.f5366q + ((int) (i8 * this.f5374z))) / i8);
            }
            this.f5372x = this.f5372x;
            k();
        }
        if (!this.f5360j || this.f5365o <= 0) {
            return;
        }
        this.f5360j = false;
        setHorizontalScrollBarEnabled(false);
        p(this.f5369t);
        setHorizontalScrollBarEnabled(true);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        int i2 = cVar.f5380i;
        if (i2 != -1) {
            p(i2);
        }
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f5380i = this.f5369t;
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i4;
        if (this.f5348G) {
            return true;
        }
        if (this.f5347F) {
            j(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            if (this.f5346E == 1) {
                int i5 = this.f5352K;
                if (this.p > 0 && g() != null) {
                    int iC = (int) this.f5358T.c(this.f5351J, i5);
                    int iB = this.f5358T.b(Math.abs(iC));
                    if (iB == 1 && (i4 = this.f5369t) > 0) {
                        u(i4 - this.f5365o, iC, true);
                    } else if (iB == 2 && (i2 = this.f5369t) < this.f5342A - 1) {
                        u(i2 + this.f5365o, iC, true);
                    } else if (iB == 3) {
                        u(this.f5369t, iC, true);
                    } else {
                        u((getScrollX() + (this.p >> 1)) / this.p, 0, true);
                    }
                }
            }
            t(motionEvent, 0);
        } else if (action == 2) {
            if (this.f5346E == 0 && n(motionEvent)) {
                t(motionEvent, 1);
            }
            if (this.f5346E == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f5352K);
                if (iFindPointerIndex == -1) {
                    t(motionEvent, 1);
                    iFindPointerIndex = motionEvent.findPointerIndex(this.f5352K);
                }
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f4 = this.f5344C - x2;
                this.f5344C = x2;
                if (f4 != 0.0f) {
                    scrollTo(Math.round(this.M + f4), 0);
                } else {
                    awakenScrollBars();
                }
            }
        } else if (action != 3) {
            if (action == 6) {
                int action2 = (motionEvent.getAction() & 65280) >> 8;
                if (motionEvent.getPointerId(action2) == this.f5352K) {
                    int i6 = action2 == 0 ? 1 : 0;
                    this.f5344C = motionEvent.getX(i6);
                    int pointerId = motionEvent.getPointerId(i6);
                    this.f5352K = pointerId;
                    this.f5358T.d(pointerId);
                }
            }
        }
        this.f5347F = true;
        return true;
    }

    public final void p(int i2) {
        q(Math.max(0, Math.min(i2, this.f5342A - this.f5365o)));
        if (this.f5360j) {
            return;
        }
        if (!this.f5373y.isFinished()) {
            this.f5373y.abortAnimation();
        }
        int i4 = this.f5369t;
        measure(this.f5367r, this.f5368s);
        scrollTo((this.p * i4) - this.f5364n, 0);
        invalidate();
    }

    public final void r() {
        if (9 != this.f5355Q) {
            this.f5355Q = 9;
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        this.f5361k = 0;
        this.f5342A = 0;
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= this.f5342A) {
            return super.requestChildRectangleOnScreen(view, rect, z4);
        }
        if (iIndexOfChild == this.f5369t && this.f5373y.isFinished()) {
            return false;
        }
        u(iIndexOfChild, 0, false);
        return true;
    }

    public final void s(FrameLayout.LayoutParams layoutParams) {
        f fVar = this.f5363m;
        if (fVar != null) {
            fVar.setLayoutParams(layoutParams);
            return;
        }
        f fVar2 = new f(getContext());
        this.f5363m = fVar2;
        fVar2.setGravity(16);
        this.f5363m.setAnimationCacheEnabled(false);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            f fVar3 = this.f5363m;
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(this.f5362l);
            fVar3.addView(imageView, f5340U);
        }
        e(this.f5363m, layoutParams);
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i4) {
        this.M = Math.max(this.f5371w, Math.min(i2, this.f5370v));
        this.L = System.nanoTime() / 1.0E9f;
        super.scrollTo((int) this.M, i4);
    }

    @Override // android.view.View
    public final void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        int i2 = this.f5342A;
        for (int i4 = 0; i4 < i2; i4++) {
            getChildAt(i4).setOnLongClickListener(onLongClickListener);
        }
    }

    protected final void u(int i2, int i4, boolean z4) {
        if (this.f5366q <= 0) {
            return;
        }
        int iMax = Math.max(0, Math.min(i2, this.f5342A - this.f5365o));
        this.u = iMax;
        int iMax2 = Math.max(1, Math.abs(iMax - this.f5369t));
        if (!this.f5373y.isFinished()) {
            g gVar = this.f5357S;
            if (gVar != null) {
                gVar.a();
            }
            this.f5373y.abortAnimation();
        }
        this.f5357S = null;
        int iAbs = Math.abs(i4);
        if (z4) {
            this.P.b(iMax2);
        } else {
            this.P.a();
        }
        int scrollX = ((this.u * this.p) - this.f5364n) - getScrollX();
        if (scrollX == 0) {
            return;
        }
        int iAbs2 = Math.abs(scrollX);
        int i5 = this.f5354O;
        int i6 = (iAbs2 * i5) / this.f5366q;
        if (iAbs > 0) {
            i6 += (int) ((i6 / (iAbs / 2500.0f)) * 0.4f);
        }
        int iMax3 = Math.max(i5, i6);
        this.f5373y.startScroll(getScrollX(), 0, scrollX, 0, iMax2 <= 1 ? Math.min(iMax3, this.f5354O * 2) : iMax3);
        invalidate();
    }

    static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        int f5380i;

        final class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final c[] newArray(int i2) {
                return new c[i2];
            }
        }

        c(Parcelable parcelable) {
            super(parcelable);
            this.f5380i = -1;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f5380i);
        }

        c(Parcel parcel) {
            super(parcel);
            this.f5380i = -1;
            this.f5380i = parcel.readInt();
        }
    }
}
