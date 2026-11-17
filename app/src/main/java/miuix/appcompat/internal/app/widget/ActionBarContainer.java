package miuix.appcompat.internal.app.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.mmt.R;
import java.util.Objects;
import miuix.appcompat.app.b;
import w3.C0411d;
import z3.C0431a;
import z3.C0432b;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout implements b.a {

    /* renamed from: i, reason: collision with root package name */
    private ScrollingTabContainerView f6710i;

    /* renamed from: j, reason: collision with root package name */
    private ActionBarView f6711j;

    /* renamed from: k, reason: collision with root package name */
    private ActionBarContextView f6712k;

    /* renamed from: l, reason: collision with root package name */
    private Animator f6713l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f6714m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable[] f6715n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f6716o;
    private boolean p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6717q;

    /* renamed from: r, reason: collision with root package name */
    private Rect f6718r;

    /* renamed from: s, reason: collision with root package name */
    private int f6719s;

    /* renamed from: t, reason: collision with root package name */
    private int f6720t;
    private AnimatorListenerAdapter u;

    final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ActionBarContainer.this.setVisibility(8);
            ActionBarContainer.this.f6713l = null;
        }
    }

    final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ActionBarContainer.this.f6713l = null;
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6720t = -1;
        new a();
        this.u = new b();
        setBackground(null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2098S);
        boolean z4 = true;
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f6714m = drawable;
        this.f6715n = new Drawable[]{drawable, typedArrayObtainStyledAttributes.getDrawable(18), typedArrayObtainStyledAttributes.getDrawable(19)};
        this.f6717q = typedArrayObtainStyledAttributes.getBoolean(30, false);
        if (getId() == R.id.split_action_bar) {
            this.p = true;
            this.f6716o = typedArrayObtainStyledAttributes.getDrawable(17);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.p) {
            setPadding(0, 0, 0, 0);
        }
        n();
        if (!this.p ? this.f6714m != null : this.f6716o != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
    }

    private void e(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (view == this.f6711j && this.f6717q) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        Rect rect = this.f6718r;
        marginLayoutParams.topMargin = rect != null ? rect.top : 0;
        view.setLayoutParams(marginLayoutParams);
    }

    private void n() {
        TypedValue typedValueH;
        if (this.p && (typedValueH = C0431a.h(getContext(), R.attr.actionBarSplitMaxPercentageHeight)) != null && typedValueH.type == 6) {
            float f4 = C0411d.b(getContext()).y;
            this.f6720t = View.MeasureSpec.makeMeasureSpec((int) typedValueH.getFraction(f4, f4), Integer.MIN_VALUE);
        }
    }

    @Override // miuix.appcompat.app.b.a
    public final void a(int i2) {
    }

    @Override // miuix.appcompat.app.b.a
    public final void b(int i2) {
    }

    @Override // miuix.appcompat.app.b.a
    public final void c(int i2, float f4, boolean z4, boolean z5) {
        miuix.appcompat.internal.view.menu.action.c cVar;
        if (!this.p || (cVar = (miuix.appcompat.internal.view.menu.action.c) getChildAt(1)) == null) {
            return;
        }
        cVar.g(f4, z4, z5);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f6714m;
        if (drawable != null && drawable.isStateful()) {
            this.f6714m.setState(getDrawableState());
        }
        Drawable drawable2 = this.f6716o;
        if (drawable2 == null || !drawable2.isStateful()) {
            return;
        }
        this.f6716o.setState(getDrawableState());
    }

    final int f() {
        if (!this.p) {
            return 0;
        }
        int iMax = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof miuix.appcompat.internal.view.menu.action.c) {
                miuix.appcompat.internal.view.menu.action.c cVar = (miuix.appcompat.internal.view.menu.action.c) getChildAt(i2);
                if (cVar.getVisibility() == 0 && cVar.getAlpha() != 0.0f && cVar.e() > 0) {
                    iMax = Math.max(iMax, cVar.e());
                }
            }
        }
        return iMax;
    }

    public final Rect g() {
        return this.f6718r;
    }

    public final View h() {
        return this.f6710i;
    }

    public final void i(View view, int i2, int i4, int[] iArr, int i5, int[] iArr2) {
        ActionBarContextView actionBarContextView = this.f6712k;
        if (actionBarContextView != null && actionBarContextView.getVisibility() == 0) {
            this.f6712k.J(i4, new int[]{0, 0}, new int[]{0, 0});
        }
        this.f6711j.p0(i4, iArr, iArr2);
    }

    public final void j(View view, int i2, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2) {
        ActionBarContextView actionBarContextView = this.f6712k;
        if (actionBarContextView != null && actionBarContextView.getVisibility() == 0) {
            this.f6712k.K(i6, new int[]{0, 0}, new int[]{0, 0});
        }
        this.f6711j.q0(i6, iArr, iArr2);
    }

    public final void k(View view, View view2, int i2, int i4) {
        ActionBarContextView actionBarContextView = this.f6712k;
        if (actionBarContextView != null && actionBarContextView.getVisibility() == 0) {
            this.f6712k.L(i4);
        }
        this.f6711j.r0(i4);
    }

    public final boolean l(View view, View view2, int i2, int i4) {
        ActionBarContextView actionBarContextView = this.f6712k;
        if (actionBarContextView != null && actionBarContextView.getVisibility() == 0) {
            this.f6712k.M();
        }
        return this.f6711j.s0();
    }

    public final void m(View view, int i2) {
        ActionBarContextView actionBarContextView = this.f6712k;
        if (actionBarContextView != null && actionBarContextView.getVisibility() == 0) {
            this.f6712k.N();
        }
        this.f6711j.t0();
    }

    public final void o(ActionBarContextView actionBarContextView) {
        this.f6712k = actionBarContextView;
        actionBarContextView.O(this.f6711j);
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.p) {
            getContext();
            int i2 = C0432b.f8169a;
        } else {
            Drawable drawable = this.f6714m;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f6711j = (ActionBarView) findViewById(R.id.action_bar);
        ActionBarContextView actionBarContextView = (ActionBarContextView) findViewById(R.id.action_context_bar);
        this.f6712k = actionBarContextView;
        if (actionBarContextView != null) {
            actionBarContextView.O(this.f6711j);
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        return !this.p;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        ActionBarView actionBarView;
        Drawable[] drawableArr;
        char c2;
        super.onLayout(z4, i2, i4, i5, i6);
        int measuredHeight = getMeasuredHeight();
        ScrollingTabContainerView scrollingTabContainerView = this.f6710i;
        boolean z5 = false;
        if (scrollingTabContainerView != null && scrollingTabContainerView.getVisibility() != 8) {
            int measuredHeight2 = this.f6710i.getMeasuredHeight();
            ActionBarView actionBarView2 = this.f6711j;
            if (actionBarView2 == null || actionBarView2.getVisibility() != 0 || this.f6711j.getMeasuredHeight() <= 0) {
                Rect rect = this.f6718r;
                measuredHeight2 += rect != null ? rect.top : 0;
                ScrollingTabContainerView scrollingTabContainerView2 = this.f6710i;
                int paddingLeft = scrollingTabContainerView2.getPaddingLeft();
                Rect rect2 = this.f6718r;
                scrollingTabContainerView2.setPadding(paddingLeft, rect2 != null ? rect2.top + this.f6719s : this.f6719s, this.f6710i.getPaddingRight(), this.f6710i.getPaddingBottom());
            } else {
                ScrollingTabContainerView scrollingTabContainerView3 = this.f6710i;
                scrollingTabContainerView3.setPadding(scrollingTabContainerView3.getPaddingLeft(), this.f6719s, this.f6710i.getPaddingRight(), this.f6710i.getPaddingBottom());
            }
            this.f6710i.layout(i2, measuredHeight - measuredHeight2, i5, measuredHeight);
        }
        boolean z6 = this.p;
        if (z6) {
            Drawable drawable = this.f6716o;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                z5 = true;
            }
        } else {
            if (!z6 && (actionBarView = this.f6711j) != null && this.f6714m != null && (drawableArr = this.f6715n) != null && drawableArr.length >= 3) {
                if (actionBarView.k0()) {
                    int iW = this.f6711j.W();
                    c2 = ((iW & 2) == 0 && (iW & 4) == 0 && (iW & 16) == 0) ? (char) 1 : (char) 2;
                } else {
                    c2 = 0;
                }
                Drawable[] drawableArr2 = this.f6715n;
                if (drawableArr2[c2] != null) {
                    this.f6714m = drawableArr2[c2];
                }
            }
            Drawable drawable2 = this.f6714m;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, i5 - i2, measuredHeight);
                z5 = true;
            }
        }
        if (z5) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i4) {
        int measuredHeight;
        Rect rect;
        if (this.p) {
            if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
                i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
            }
            int i5 = this.f6720t;
            if (i5 != -1) {
                i4 = i5;
            }
            super.onMeasure(i2, i4);
            int childCount = getChildCount();
            int iMax = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                iMax = Math.max(iMax, getChildAt(i6).getMeasuredHeight());
            }
            if (iMax == 0) {
                setMeasuredDimension(0, 0);
                return;
            }
            return;
        }
        ScrollingTabContainerView scrollingTabContainerView = this.f6710i;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setPadding(scrollingTabContainerView.getPaddingLeft(), this.f6719s, this.f6710i.getPaddingRight(), this.f6710i.getPaddingBottom());
        }
        e(this.f6711j);
        e(this.f6712k);
        super.onMeasure(i2, i4);
        ActionBarView actionBarView = this.f6711j;
        boolean z4 = (actionBarView == null || actionBarView.getVisibility() == 8 || this.f6711j.getMeasuredHeight() <= 0) ? false : true;
        if (z4) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6711j.getLayoutParams();
            measuredHeight = this.f6711j.g0() ? layoutParams.topMargin : layoutParams.bottomMargin + this.f6711j.getMeasuredHeight() + layoutParams.topMargin;
        } else {
            measuredHeight = 0;
        }
        ScrollingTabContainerView scrollingTabContainerView2 = this.f6710i;
        if (scrollingTabContainerView2 != null && scrollingTabContainerView2.getVisibility() != 8 && View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE) {
            setMeasuredDimension(getMeasuredWidth(), Math.min(this.f6710i.getMeasuredHeight() + measuredHeight, View.MeasureSpec.getSize(i4)) + ((z4 || (rect = this.f6718r) == null) ? 0 : rect.top));
        }
        int i7 = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 0 && childAt.getMeasuredHeight() > 0 && childAt.getMeasuredWidth() > 0) {
                i7++;
            }
        }
        if (i7 == 0) {
            setMeasuredDimension(0, 0);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return !this.p && super.onTouchEvent(motionEvent);
    }

    public final void p(Rect rect) {
        if (this.p) {
            return;
        }
        if (this.f6718r == null) {
            this.f6718r = new Rect();
        }
        if (Objects.equals(this.f6718r, rect)) {
            return;
        }
        this.f6718r.set(rect);
        e(this.f6711j);
        e(this.f6712k);
    }

    public final void q() {
        ScrollingTabContainerView scrollingTabContainerView = this.f6710i;
        if (scrollingTabContainerView != null) {
            removeView(scrollingTabContainerView);
        }
        ScrollingTabContainerView scrollingTabContainerView2 = this.f6710i;
        if (scrollingTabContainerView2 != null) {
            scrollingTabContainerView2.setBackground(null);
        }
        this.f6710i = null;
    }

    @Override // android.view.View
    public final void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z4 = i2 == 0;
        Drawable drawable = this.f6714m;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.f6716o;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected final boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f6714m && !this.p) || (drawable == this.f6716o && this.p) || super.verifyDrawable(drawable);
    }
}
