package miuix.appcompat.internal.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.android.mmt.R;
import z3.C0432b;

/* loaded from: classes.dex */
public class ActionBarMovableLayout extends ActionBarOverlayLayout {
    private ScrollingTabContainerView M;

    /* renamed from: N, reason: collision with root package name */
    private OverScroller f6763N;

    /* renamed from: O, reason: collision with root package name */
    private int f6764O;
    private boolean P;

    /* renamed from: Q, reason: collision with root package name */
    private float f6765Q;

    /* renamed from: R, reason: collision with root package name */
    private float f6766R;

    /* renamed from: S, reason: collision with root package name */
    private int f6767S;

    /* renamed from: T, reason: collision with root package name */
    private final int f6768T;

    /* renamed from: U, reason: collision with root package name */
    private final int f6769U;

    /* renamed from: V, reason: collision with root package name */
    private final int f6770V;

    /* renamed from: W, reason: collision with root package name */
    private int f6771W;

    /* renamed from: a0, reason: collision with root package name */
    private int f6772a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f6773b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f6774c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f6775d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f6776e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f6777f0;

    /* renamed from: g0, reason: collision with root package name */
    private VelocityTracker f6778g0;

    public ActionBarMovableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6771W = -1;
        this.f6773b0 = -1;
        this.f6774c0 = 8;
        this.f6776e0 = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2099T, R.attr.actionBarMovableLayoutStyle, 0);
        int i2 = C0432b.f8169a;
        this.f6772a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6771W = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        this.f6773b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6768T = viewConfiguration.getScaledTouchSlop();
        this.f6763N = new OverScroller(context);
        this.f6769U = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6770V = viewConfiguration.getScaledMaximumFlingVelocity();
        setOverScrollMode(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean F(View view, int i2, int i4) {
        if (view == null) {
            return false;
        }
        int y2 = (int) view.getY();
        int x2 = (int) view.getX();
        int y4 = (int) (view.getY() + view.getHeight());
        int x4 = (int) (view.getX() + view.getWidth());
        if (view == this.M) {
            int top = this.f6791j.getTop();
            y2 += top;
            y4 += top;
        }
        return i4 >= y2 && i4 < y4 && i2 >= x2 && i2 < x4;
    }

    private void G() {
        if (this.f6778g0 == null) {
            this.f6778g0 = VelocityTracker.obtain();
        }
    }

    private void H(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f6764O) {
            int i2 = action == 0 ? 1 : 0;
            this.f6765Q = (int) motionEvent.getY(i2);
            this.f6764O = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f6778g0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    protected final void D(float f4) {
        float height = (((-this.f6772a0) + f4) - this.f6771W) - 0;
        E();
        ScrollingTabContainerView scrollingTabContainerView = this.M;
        if (scrollingTabContainerView != null && scrollingTabContainerView.getVisibility() == 0) {
            height -= this.M.getHeight();
        }
        this.f6792k.setTranslationY(height);
        E();
        ScrollingTabContainerView scrollingTabContainerView2 = this.M;
        if (scrollingTabContainerView2 != null) {
            scrollingTabContainerView2.setTranslationY(height);
        }
    }

    final void E() {
        this.M = (ScrollingTabContainerView) this.f6791j.h();
    }

    protected final boolean I(MotionEvent motionEvent) {
        int i2 = this.f6764O;
        boolean z4 = false;
        if (i2 == -1) {
            return false;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i2);
        if (iFindPointerIndex == -1) {
            Log.w("ActionBarMovableLayout", "invalid pointer index");
            return false;
        }
        float x2 = motionEvent.getX(iFindPointerIndex);
        float y2 = motionEvent.getY(iFindPointerIndex);
        int i4 = (int) (y2 - this.f6765Q);
        int iAbs = Math.abs(i4);
        int iAbs2 = (int) Math.abs(x2 - this.f6766R);
        int i5 = (int) x2;
        int i6 = (int) y2;
        if ((F(this.f6792k, i5, i6) || F(this.M, i5, i6)) && iAbs > this.f6768T && iAbs > iAbs2) {
            if (this.f6767S == 0) {
                if (i4 >= 0) {
                }
            } else if (i4 > 0) {
                int i7 = C0432b.f8169a;
            }
            z4 = true;
        }
        if (z4) {
            this.f6765Q = y2;
            this.f6766R = x2;
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
        return z4;
    }

    protected final void J() {
        if (this.f6776e0) {
            int i2 = this.f6771W;
            int i4 = this.f6767S;
            this.f6763N.startScroll(0, i4, 0, i4 > i2 / 2 ? i2 - i4 : -i4, 800);
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (!this.f6763N.computeScrollOffset()) {
            if (this.f6777f0) {
                J();
                this.f6777f0 = false;
                return;
            }
            return;
        }
        int i2 = this.f6767S;
        int currY = this.f6763N.getCurrY();
        if (i2 != currY) {
            int i4 = this.f6771W;
            int i5 = C0432b.f8169a;
            overScrollBy(0, currY - i2, 0, this.f6767S, 0, i4, 0, this.f6772a0, true);
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.View
    protected final int computeVerticalScrollExtent() {
        return 0;
    }

    @Override // android.view.View
    protected final int computeVerticalScrollRange() {
        return this.f6771W;
    }

    @Override // android.view.ViewGroup
    protected final void measureChildWithMargins(View view, int i2, int i4, int i5, int i6) {
        if (view != this.f6792k) {
            super.measureChildWithMargins(view, i2, i4, i5, i6);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f6790i.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width);
        int measuredHeight = ((this.f6790i.getMeasuredHeight() + ((getPaddingBottom() + getPaddingTop()) + marginLayoutParams.bottomMargin)) + marginLayoutParams2.topMargin) - this.f6771W;
        int i7 = C0432b.f8169a;
        view.measure(childMeasureSpec, ViewGroup.getChildMeasureSpec(i5, (measuredHeight - this.f6772a0) + 0, marginLayoutParams.height));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View viewI = i();
        if (viewI != null && viewI.getVisibility() == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.P) {
            return true;
        }
        int i2 = action & 255;
        if (i2 == 0) {
            this.f6765Q = motionEvent.getY();
            this.f6766R = motionEvent.getX();
            this.f6764O = motionEvent.getPointerId(0);
            VelocityTracker velocityTracker = this.f6778g0;
            if (velocityTracker == null) {
                this.f6778g0 = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            this.f6778g0.addMovement(motionEvent);
            this.f6763N.forceFinished(true);
        } else if (i2 == 1) {
            this.P = false;
            this.f6764O = -1;
            VelocityTracker velocityTracker2 = this.f6778g0;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f6778g0 = null;
            }
        } else if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 6) {
                    H(motionEvent);
                }
            }
        } else if (I(motionEvent)) {
            this.P = true;
            G();
            this.f6778g0.addMovement(motionEvent);
        }
        return this.P;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    @Override // miuix.appcompat.internal.app.widget.ActionBarOverlayLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        boolean z5;
        boolean z6;
        int visibility;
        super.onLayout(z4, i2, i4, i5, i6);
        if (this.f6775d0) {
            E();
            ScrollingTabContainerView scrollingTabContainerView = this.M;
            if (scrollingTabContainerView == null || (visibility = scrollingTabContainerView.getVisibility()) == this.f6774c0) {
                z6 = false;
            } else {
                this.f6774c0 = visibility;
                z6 = true;
            }
            z5 = z6;
        }
        if (!this.f6775d0) {
            if (this.f6773b0 < 0) {
                this.f6773b0 = this.f6771W;
            }
            this.f6767S = this.f6773b0;
            this.f6775d0 = true;
        }
        if (z5) {
            D(this.f6767S);
        }
    }

    @Override // android.view.View
    protected final void onOverScrolled(int i2, int i4, boolean z4, boolean z5) {
        D(i4);
        this.f6767S = i4;
        if (i4 == 0 && z5) {
            VelocityTracker velocityTracker = this.f6778g0;
            velocityTracker.computeCurrentVelocity(1000, this.f6770V);
            Math.abs((int) velocityTracker.getYVelocity(this.f6764O));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        G();
        this.f6778g0.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f6765Q = motionEvent.getY();
            this.f6764O = motionEvent.getPointerId(0);
        } else if (action == 1) {
            if (this.P) {
                this.P = false;
                this.f6764O = -1;
                VelocityTracker velocityTracker = this.f6778g0;
                velocityTracker.computeCurrentVelocity(1000, this.f6770V);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f6764O);
                if (Math.abs(yVelocity) > this.f6769U) {
                    int i2 = C0432b.f8169a;
                    this.f6763N.fling(0, this.f6767S, 0, yVelocity, 0, 0, 0, this.f6771W, 0, this.f6772a0);
                    this.f6777f0 = true;
                    postInvalidate();
                } else {
                    if (this.f6763N.springBack(0, this.f6767S, 0, 0, 0, this.f6771W)) {
                        invalidate();
                    } else {
                        J();
                    }
                }
            }
        } else if (action != 2) {
            if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.f6765Q = (int) motionEvent.getY(actionIndex);
                    this.f6764O = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    H(motionEvent);
                    this.f6765Q = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f6764O));
                }
            }
        } else if (this.P) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f6764O);
            if (iFindPointerIndex == -1) {
                return false;
            }
            float y2 = motionEvent.getY(iFindPointerIndex);
            int i4 = (int) (y2 - this.f6765Q);
            int i5 = this.f6771W;
            int i6 = C0432b.f8169a;
            boolean zOverScrollBy = overScrollBy(0, i4, 0, this.f6767S, 0, i5, 0, this.f6772a0, true);
            this.f6765Q = y2;
            if (zOverScrollBy) {
                if (this.f6767S == 0) {
                    this.P = false;
                    this.f6764O = -1;
                    motionEvent.setAction(0);
                    dispatchTouchEvent(motionEvent);
                }
                this.f6778g0.clear();
            }
        } else if (I(motionEvent)) {
            this.P = true;
            G();
            this.f6778g0.addMovement(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    protected final boolean overScrollBy(int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z4) {
        int overScrollMode = getOverScrollMode();
        boolean z5 = true;
        int i11 = i6 + i4;
        if (!(overScrollMode == 0 || (overScrollMode == 1 && (computeVerticalScrollRange() > computeVerticalScrollExtent())))) {
            i10 = 0;
        }
        int i12 = i10 + i8;
        if (i11 > i12) {
            i11 = i12;
        } else if (i11 < 0) {
            i11 = 0;
        } else {
            z5 = false;
        }
        onOverScrolled(0, i11, false, z5);
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
    }
}
