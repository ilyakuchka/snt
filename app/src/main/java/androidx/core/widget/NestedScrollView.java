package androidx.core.widget;

import D2.e;
import F.b;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.g;
import androidx.core.view.i;
import androidx.core.view.j;
import androidx.core.view.o;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements i {

    /* renamed from: I, reason: collision with root package name */
    private static final a f3337I = new a();

    /* renamed from: J, reason: collision with root package name */
    private static final int[] f3338J = {R.attr.fillViewport};

    /* renamed from: A, reason: collision with root package name */
    private final int[] f3339A;

    /* renamed from: B, reason: collision with root package name */
    private int f3340B;

    /* renamed from: C, reason: collision with root package name */
    private int f3341C;

    /* renamed from: D, reason: collision with root package name */
    private c f3342D;

    /* renamed from: E, reason: collision with root package name */
    private final j f3343E;

    /* renamed from: F, reason: collision with root package name */
    private final g f3344F;

    /* renamed from: G, reason: collision with root package name */
    private float f3345G;

    /* renamed from: H, reason: collision with root package name */
    private b f3346H;

    /* renamed from: i, reason: collision with root package name */
    private long f3347i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f3348j;

    /* renamed from: k, reason: collision with root package name */
    private OverScroller f3349k;

    /* renamed from: l, reason: collision with root package name */
    private EdgeEffect f3350l;

    /* renamed from: m, reason: collision with root package name */
    private EdgeEffect f3351m;

    /* renamed from: n, reason: collision with root package name */
    private int f3352n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3353o;
    private boolean p;

    /* renamed from: q, reason: collision with root package name */
    private View f3354q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f3355r;

    /* renamed from: s, reason: collision with root package name */
    private VelocityTracker f3356s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f3357t;
    private boolean u;

    /* renamed from: v, reason: collision with root package name */
    private int f3358v;

    /* renamed from: w, reason: collision with root package name */
    private int f3359w;

    /* renamed from: x, reason: collision with root package name */
    private int f3360x;

    /* renamed from: y, reason: collision with root package name */
    private int f3361y;

    /* renamed from: z, reason: collision with root package name */
    private final int[] f3362z;

    static class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.r() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setMaxScrollY(nestedScrollView.r());
        }

        @Override // androidx.core.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, F.b bVar) {
            int iR;
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.E(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (iR = nestedScrollView.r()) <= 0) {
                return;
            }
            bVar.U(true);
            if (nestedScrollView.getScrollY() > 0) {
                bVar.b(b.a.f117f);
                bVar.b(b.a.g);
            }
            if (nestedScrollView.getScrollY() < iR) {
                bVar.b(b.a.f116e);
                bVar.b(b.a.f118h);
            }
        }

        @Override // androidx.core.view.a
        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i2 != 4096) {
                if (i2 == 8192 || i2 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.D(iMax);
                    return true;
                }
                if (i2 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.r());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.D(iMin);
            return true;
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView);
    }

    static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        public int f3363i;

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
        }

        public final String toString() {
            StringBuilder sbD = e.d("HorizontalScrollView.SavedState{");
            sbD.append(Integer.toHexString(System.identityHashCode(this)));
            sbD.append(" scrollPosition=");
            sbD.append(this.f3363i);
            sbD.append("}");
            return sbD.toString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3363i);
        }

        c(Parcel parcel) {
            super(parcel);
            this.f3363i = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3348j = new Rect();
        this.f3353o = true;
        this.p = false;
        this.f3354q = null;
        this.f3355r = false;
        this.u = true;
        this.f3361y = -1;
        this.f3362z = new int[2];
        this.f3339A = new int[2];
        this.f3349k = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f3358v = viewConfiguration.getScaledTouchSlop();
        this.f3359w = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3360x = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3338J, 0, 0);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        if (z4 != this.f3357t) {
            this.f3357t = z4;
            requestLayout();
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f3343E = new j();
        this.f3344F = new g(this);
        setNestedScrollingEnabled(true);
        o.j(this, f3337I);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A(int i2, int i4, int i5) {
        boolean z4;
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = height + scrollY;
        boolean z5 = i2 == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = focusables.get(i7);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i4 < bottom && top < i5) {
                boolean z7 = i4 < top && bottom < i5;
                if (view == null) {
                    view = view2;
                    z6 = z7;
                } else {
                    boolean z8 = (z5 && top < view.getTop()) || (!z5 && bottom > view.getBottom());
                    if (z6) {
                        if (z7 && z8) {
                            view = view2;
                        }
                    } else if (z7) {
                        view = view2;
                        z6 = true;
                    } else if (z8) {
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i4 < scrollY || i5 > i6) {
            f(z5 ? i4 - scrollY : i5 - i6);
            z4 = true;
        } else {
            z4 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i2);
        }
        return z4;
    }

    private void B(View view) {
        view.getDrawingRect(this.f3348j);
        offsetDescendantRectToMyCoords(view, this.f3348j);
        int iD = d(this.f3348j);
        if (iD != 0) {
            scrollBy(0, iD);
        }
    }

    private void C(int i2, int i4, boolean z4) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f3347i > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f3349k.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i4 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            z(z4);
        } else {
            if (!this.f3349k.isFinished()) {
                a();
            }
            scrollBy(i2, i4);
        }
        this.f3347i = AnimationUtils.currentAnimationTimeMillis();
    }

    private void a() {
        this.f3349k.abortAnimation();
        F(1);
    }

    private static int c(int i2, int i4, int i5) {
        if (i4 >= i5 || i2 < 0) {
            return 0;
        }
        return i4 + i2 > i5 ? i5 - i4 : i2;
    }

    private void f(int i2) {
        if (i2 != 0) {
            if (this.u) {
                C(0, i2, false);
            } else {
                scrollBy(0, i2);
            }
        }
    }

    private void g() {
        this.f3355r = false;
        y();
        F(0);
        EdgeEffect edgeEffect = this.f3350l;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f3351m.onRelease();
        }
    }

    private void h() {
        if (getOverScrollMode() == 2) {
            this.f3350l = null;
            this.f3351m = null;
        } else if (this.f3350l == null) {
            Context context = getContext();
            this.f3350l = new EdgeEffect(context);
            this.f3351m = new EdgeEffect(context);
        }
    }

    private static boolean t(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && t((View) parent, view2);
    }

    private boolean u(View view, int i2, int i4) {
        view.getDrawingRect(this.f3348j);
        offsetDescendantRectToMyCoords(view, this.f3348j);
        return this.f3348j.bottom + i2 >= getScrollY() && this.f3348j.top - i2 <= getScrollY() + i4;
    }

    private void v(int i2, int i4, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f3344F.d(scrollY2, i2 - scrollY2, null, i4, iArr);
    }

    private void w(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3361y) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f3352n = (int) motionEvent.getY(i2);
            this.f3361y = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f3356s;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void y() {
        VelocityTracker velocityTracker = this.f3356s;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3356s = null;
        }
    }

    private void z(boolean z4) {
        if (z4) {
            E(2, 1);
        } else {
            F(1);
        }
        this.f3341C = getScrollY();
        int i2 = o.d;
        postInvalidateOnAnimation();
    }

    final void D(int i2) {
        C(0 - getScrollX(), i2 - getScrollY(), true);
    }

    public final boolean E(int i2, int i4) {
        return this.f3344F.l(i2, i4);
    }

    public final void F(int i2) {
        this.f3344F.m(i2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public final boolean b(int i2) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        int height = (int) (getHeight() * 0.5f);
        if (viewFindNextFocus == null || !u(viewFindNextFocus, height, getHeight())) {
            if (i2 == 33 && getScrollY() < height) {
                height = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                height = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), height);
            }
            if (height == 0) {
                return false;
            }
            if (i2 != 130) {
                height = -height;
            }
            f(height);
        } else {
            viewFindNextFocus.getDrawingRect(this.f3348j);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f3348j);
            f(d(this.f3348j));
            viewFindNextFocus.requestFocus(i2);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && (!u(viewFindFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f3349k.isFinished()) {
            return;
        }
        this.f3349k.computeScrollOffset();
        int currY = this.f3349k.getCurrY();
        int i2 = currY - this.f3341C;
        this.f3341C = currY;
        int[] iArr = this.f3339A;
        boolean z4 = false;
        iArr[1] = 0;
        e(0, i2, iArr, null, 1);
        int i4 = i2 - this.f3339A[1];
        int iR = r();
        if (i4 != 0) {
            int scrollY = getScrollY();
            x(i4, getScrollX(), scrollY, iR);
            int scrollY2 = getScrollY() - scrollY;
            int i5 = i4 - scrollY2;
            int[] iArr2 = this.f3339A;
            iArr2[1] = 0;
            this.f3344F.d(scrollY2, i5, this.f3362z, 1, iArr2);
            i4 = i5 - this.f3339A[1];
        }
        if (i4 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && iR > 0)) {
                z4 = true;
            }
            if (z4) {
                h();
                if (i4 < 0) {
                    if (this.f3350l.isFinished()) {
                        this.f3350l.onAbsorb((int) this.f3349k.getCurrVelocity());
                    }
                } else if (this.f3351m.isFinished()) {
                    this.f3351m.onAbsorb((int) this.f3349k.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f3349k.isFinished()) {
            F(1);
        } else {
            int i6 = o.d;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    protected final int d(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        int i5 = rect.bottom;
        if (i5 > i4 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i4) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
        }
        if (rect.top >= scrollY || i5 >= i4) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i4 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || i(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return this.f3344F.a(f4, f5, z4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f4, float f5) {
        return this.f3344F.b(f4, f5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i4, int[] iArr, int[] iArr2) {
        return e(i2, i4, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i4, int i5, int i6, int[] iArr) {
        return this.f3344F.e(i2, i4, i5, i6, iArr);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f3350l != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.f3350l.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = Math.min(0, scrollY);
                if (getClipToPadding()) {
                    width -= getPaddingRight() + getPaddingLeft();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (getClipToPadding()) {
                    height -= getPaddingBottom() + getPaddingTop();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.f3350l.setSize(width, height);
                if (this.f3350l.draw(canvas)) {
                    int i2 = o.d;
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f3351m.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(r(), scrollY) + height2;
            if (getClipToPadding()) {
                width2 -= getPaddingRight() + getPaddingLeft();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (getClipToPadding()) {
                height2 -= getPaddingBottom() + getPaddingTop();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f3351m.setSize(width2, height2);
            if (this.f3351m.draw(canvas)) {
                int i4 = o.d;
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave2);
        }
    }

    public final boolean e(int i2, int i4, int[] iArr, int[] iArr2, int i5) {
        return this.f3344F.c(i2, i4, iArr, iArr2, i5);
    }

    @Override // android.view.View
    protected final float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.ViewGroup
    public final int getNestedScrollAxes() {
        return this.f3343E.a();
    }

    @Override // android.view.View
    protected final float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return s(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(KeyEvent keyEvent) {
        boolean z4;
        this.f3348j.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            z4 = (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
        }
        if (!z4) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? b(33) : n(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? b(130) : n(130);
        }
        if (keyCode != 62) {
            return false;
        }
        int i2 = keyEvent.isShiftPressed() ? 33 : 130;
        boolean z5 = i2 == 130;
        int height = getHeight();
        if (z5) {
            this.f3348j.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt2 = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt2.getBottom() + ((FrameLayout.LayoutParams) childAt2.getLayoutParams()).bottomMargin;
                Rect rect = this.f3348j;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            this.f3348j.top = getScrollY() - height;
            Rect rect2 = this.f3348j;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f3348j;
        int i4 = rect3.top;
        int i5 = height + i4;
        rect3.bottom = i5;
        A(i2, i4, i5);
        return false;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f3344F.j();
    }

    @Override // androidx.core.view.h
    public final void j(View view, View view2, int i2, int i4) {
        this.f3343E.c(i2, i4);
        E(2, i4);
    }

    @Override // androidx.core.view.h
    public final void k(View view, int i2) {
        this.f3343E.d(i2);
        F(i2);
    }

    @Override // androidx.core.view.h
    public final void l(View view, int i2, int i4, int[] iArr, int i5) {
        e(i2, i4, iArr, null, i5);
    }

    public final void m(int i2) {
        if (getChildCount() > 0) {
            this.f3349k.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            z(true);
        }
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i2, int i4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i2, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final boolean n(int i2) {
        int childCount;
        boolean z4 = i2 == 130;
        int height = getHeight();
        Rect rect = this.f3348j;
        rect.top = 0;
        rect.bottom = height;
        if (z4 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f3348j.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            Rect rect2 = this.f3348j;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f3348j;
        return A(i2, rect3.top, rect3.bottom);
    }

    @Override // androidx.core.view.i
    public final void o(View view, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        v(i6, i7, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p = false;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f3355r) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                if (this.f3345G == 0.0f) {
                    TypedValue typedValue = new TypedValue();
                    Context context = getContext();
                    if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
                    }
                    this.f3345G = typedValue.getDimension(context.getResources().getDisplayMetrics());
                }
                int i2 = (int) (axisValue * this.f3345G);
                int iR = r();
                int scrollY = getScrollY();
                int i4 = scrollY - i2;
                if (i4 < 0) {
                    iR = 0;
                } else if (i4 <= iR) {
                    iR = i4;
                }
                if (iR != scrollY) {
                    super.scrollTo(getScrollX(), iR);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f3355r) {
            return true;
        }
        int i2 = action & 255;
        if (i2 == 0) {
            int y2 = (int) motionEvent.getY();
            int x2 = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                boolean z4 = y2 >= childAt.getTop() - scrollY && y2 < childAt.getBottom() - scrollY && x2 >= childAt.getLeft() && x2 < childAt.getRight();
                if (z4) {
                    this.f3352n = y2;
                    this.f3361y = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker = this.f3356s;
                    if (velocityTracker == null) {
                        this.f3356s = VelocityTracker.obtain();
                    } else {
                        velocityTracker.clear();
                    }
                    this.f3356s.addMovement(motionEvent);
                    this.f3349k.computeScrollOffset();
                    this.f3355r = !this.f3349k.isFinished();
                    E(2, 0);
                } else {
                    this.f3355r = false;
                    y();
                }
            }
        } else if (i2 == 1) {
            this.f3355r = false;
            this.f3361y = -1;
            y();
            if (this.f3349k.springBack(getScrollX(), getScrollY(), 0, 0, 0, r())) {
                int i4 = o.d;
                postInvalidateOnAnimation();
            }
            F(0);
        } else if (i2 == 2) {
            int i5 = this.f3361y;
            if (i5 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i5);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i5 + " in onInterceptTouchEvent");
                } else {
                    int y4 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y4 - this.f3352n) > this.f3358v && (2 & getNestedScrollAxes()) == 0) {
                        this.f3355r = true;
                        this.f3352n = y4;
                        if (this.f3356s == null) {
                            this.f3356s = VelocityTracker.obtain();
                        }
                        this.f3356s.addMovement(motionEvent);
                        this.f3340B = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i2 != 3) {
            if (i2 == 6) {
                w(motionEvent);
            }
        }
        return this.f3355r;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        int measuredHeight = 0;
        this.f3353o = false;
        View view = this.f3354q;
        if (view != null && t(view, this)) {
            B(this.f3354q);
        }
        this.f3354q = null;
        if (!this.p) {
            if (this.f3342D != null) {
                scrollTo(getScrollX(), this.f3342D.f3363i);
                this.f3342D = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iC = c(scrollY, paddingTop, measuredHeight);
            if (iC != scrollY) {
                scrollTo(getScrollX(), iC);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.p = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        if (this.f3357t && View.MeasureSpec.getMode(i4) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (z4) {
            return false;
        }
        dispatchNestedFling(0.0f, f5, true);
        m((int) f5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return dispatchNestedPreFling(f4, f5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i2, int i4, int[] iArr) {
        e(i2, i4, iArr, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i2, int i4, int i5, int i6) {
        v(i6, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f3343E.c(i2, 0);
        E(2, 0);
    }

    @Override // android.view.View
    protected final void onOverScrolled(int i2, int i4, boolean z4, boolean z5) {
        super.scrollTo(i2, i4);
    }

    @Override // android.view.ViewGroup
    protected final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i2) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        if (viewFindNextFocus == null || (!u(viewFindNextFocus, 0, getHeight()))) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i2, rect);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f3342D = cVar;
        requestLayout();
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f3363i = getScrollY();
        return cVar;
    }

    @Override // android.view.View
    protected final void onScrollChanged(int i2, int i4, int i5, int i6) {
        super.onScrollChanged(i2, i4, i5, i6);
        b bVar = this.f3346H;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !u(viewFindFocus, 0, i6)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f3348j);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f3348j);
        f(d(this.f3348j));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        this.f3343E.d(0);
        F(0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (this.f3356s == null) {
            this.f3356s = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3340B = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f3340B);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f3356s;
                velocityTracker.computeCurrentVelocity(1000, this.f3360x);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f3361y);
                if (Math.abs(yVelocity) >= this.f3359w) {
                    int i2 = -yVelocity;
                    float f4 = i2;
                    if (!dispatchNestedPreFling(0.0f, f4)) {
                        dispatchNestedFling(0.0f, f4, true);
                        m(i2);
                    }
                } else if (this.f3349k.springBack(getScrollX(), getScrollY(), 0, 0, 0, r())) {
                    int i4 = o.d;
                    postInvalidateOnAnimation();
                }
                this.f3361y = -1;
                g();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3361y);
                if (iFindPointerIndex == -1) {
                    StringBuilder sbD = e.d("Invalid pointerId=");
                    sbD.append(this.f3361y);
                    sbD.append(" in onTouchEvent");
                    Log.e("NestedScrollView", sbD.toString());
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    int i5 = this.f3352n - y2;
                    if (!this.f3355r && Math.abs(i5) > this.f3358v) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f3355r = true;
                        i5 = i5 > 0 ? i5 - this.f3358v : i5 + this.f3358v;
                    }
                    int i6 = i5;
                    if (this.f3355r) {
                        if (e(0, i6, this.f3339A, this.f3362z, 0)) {
                            i6 -= this.f3339A[1];
                            this.f3340B += this.f3362z[1];
                        }
                        this.f3352n = y2 - this.f3362z[1];
                        int scrollY = getScrollY();
                        int iR = r();
                        int overScrollMode = getOverScrollMode();
                        boolean z4 = overScrollMode == 0 || (overScrollMode == 1 && iR > 0);
                        if (x(i6, 0, getScrollY(), iR) && !s(0)) {
                            this.f3356s.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.f3339A;
                        iArr[1] = 0;
                        this.f3344F.d(scrollY2, i6 - scrollY2, this.f3362z, 0, iArr);
                        int i7 = this.f3352n;
                        int[] iArr2 = this.f3362z;
                        this.f3352n = i7 - iArr2[1];
                        this.f3340B += iArr2[1];
                        if (z4) {
                            int i8 = i6 - this.f3339A[1];
                            h();
                            int i9 = scrollY + i8;
                            if (i9 < 0) {
                                this.f3350l.onPull(i8 / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.f3351m.isFinished()) {
                                    this.f3351m.onRelease();
                                }
                            } else if (i9 > iR) {
                                this.f3351m.onPull(i8 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                if (!this.f3350l.isFinished()) {
                                    this.f3350l.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f3350l;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f3351m.isFinished())) {
                                int i10 = o.d;
                                postInvalidateOnAnimation();
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f3355r && getChildCount() > 0 && this.f3349k.springBack(getScrollX(), getScrollY(), 0, 0, 0, r())) {
                    int i11 = o.d;
                    postInvalidateOnAnimation();
                }
                this.f3361y = -1;
                g();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f3352n = (int) motionEvent.getY(actionIndex);
                this.f3361y = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                w(motionEvent);
                this.f3352n = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f3361y));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z5 = !this.f3349k.isFinished();
            this.f3355r = z5;
            if (z5 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f3349k.isFinished()) {
                a();
            }
            this.f3352n = (int) motionEvent.getY();
            this.f3361y = motionEvent.getPointerId(0);
            E(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f3356s;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    @Override // androidx.core.view.h
    public final void p(View view, int i2, int i4, int i5, int i6, int i7) {
        v(i6, i7, null);
    }

    @Override // androidx.core.view.h
    public final boolean q(View view, View view2, int i2, int i4) {
        return (i2 & 2) != 0;
    }

    final int r() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.f3353o) {
            this.f3354q = view2;
        } else {
            B(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iD = d(rect);
        boolean z5 = iD != 0;
        if (z5) {
            if (z4) {
                scrollBy(0, iD);
            } else {
                C(0, iD, false);
            }
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        if (z4) {
            y();
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f3353o = true;
        super.requestLayout();
    }

    public final boolean s(int i2) {
        return this.f3344F.i(i2);
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i4) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iC = c(i2, width, width2);
            int iC2 = c(i4, height, height2);
            if (iC == getScrollX() && iC2 == getScrollY()) {
                return;
            }
            super.scrollTo(iC, iC2);
        }
    }

    @Override // android.view.View
    public final void setNestedScrollingEnabled(boolean z4) {
        this.f3344F.k(z4);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return E(i2, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        F(0);
    }

    final boolean x(int i2, int i4, int i5, int i6) {
        boolean z4;
        boolean z5;
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i7 = i4 + 0;
        int i8 = i5 + i2;
        int i9 = i6 + 0;
        if (i7 <= 0 && i7 >= 0) {
            z4 = false;
        } else {
            i7 = 0;
            z4 = true;
        }
        if (i8 > i9) {
            i8 = i9;
        } else {
            if (i8 >= 0) {
                z5 = false;
                if (z5 && !s(1)) {
                    this.f3349k.springBack(i7, i8, 0, 0, 0, r());
                }
                onOverScrolled(i7, i8, z4, z5);
                return z4 || z5;
            }
            i8 = 0;
        }
        z5 = true;
        if (z5) {
            this.f3349k.springBack(i7, i8, 0, 0, 0, r());
        }
        onOverScrolled(i7, i8, z4, z5);
        if (z4) {
            return true;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
