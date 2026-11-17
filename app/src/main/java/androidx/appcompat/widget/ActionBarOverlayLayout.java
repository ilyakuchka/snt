package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.l;
import androidx.core.view.w;
import com.android.mmt.R;
import java.util.Objects;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements A, androidx.core.view.h, androidx.core.view.i {

    /* renamed from: J, reason: collision with root package name */
    static final int[] f2655J = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* renamed from: A, reason: collision with root package name */
    private androidx.core.view.w f2656A;

    /* renamed from: B, reason: collision with root package name */
    private androidx.core.view.w f2657B;

    /* renamed from: C, reason: collision with root package name */
    private d f2658C;

    /* renamed from: D, reason: collision with root package name */
    private OverScroller f2659D;

    /* renamed from: E, reason: collision with root package name */
    ViewPropertyAnimator f2660E;

    /* renamed from: F, reason: collision with root package name */
    final AnimatorListenerAdapter f2661F;

    /* renamed from: G, reason: collision with root package name */
    private final Runnable f2662G;

    /* renamed from: H, reason: collision with root package name */
    private final Runnable f2663H;

    /* renamed from: I, reason: collision with root package name */
    private final androidx.core.view.j f2664I;

    /* renamed from: i, reason: collision with root package name */
    private int f2665i;

    /* renamed from: j, reason: collision with root package name */
    private int f2666j;

    /* renamed from: k, reason: collision with root package name */
    private ContentFrameLayout f2667k;

    /* renamed from: l, reason: collision with root package name */
    ActionBarContainer f2668l;

    /* renamed from: m, reason: collision with root package name */
    private B f2669m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f2670n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2671o;
    private boolean p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2672q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2673r;

    /* renamed from: s, reason: collision with root package name */
    boolean f2674s;

    /* renamed from: t, reason: collision with root package name */
    private int f2675t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    private final Rect f2676v;

    /* renamed from: w, reason: collision with root package name */
    private final Rect f2677w;

    /* renamed from: x, reason: collision with root package name */
    private final Rect f2678x;

    /* renamed from: y, reason: collision with root package name */
    private androidx.core.view.w f2679y;

    /* renamed from: z, reason: collision with root package name */
    private androidx.core.view.w f2680z;

    final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2660E = null;
            actionBarOverlayLayout.f2674s = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2660E = null;
            actionBarOverlayLayout.f2674s = false;
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout.this.s();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2660E = actionBarOverlayLayout.f2668l.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f2661F);
        }
    }

    final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout.this.s();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2660E = actionBarOverlayLayout.f2668l.animate().translationY(-ActionBarOverlayLayout.this.f2668l.getHeight()).setListener(ActionBarOverlayLayout.this.f2661F);
        }
    }

    public interface d {
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e() {
            super(-1, -1);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2666j = 0;
        this.f2676v = new Rect();
        this.f2677w = new Rect();
        this.f2678x = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        androidx.core.view.w wVar = androidx.core.view.w.f3326b;
        this.f2679y = wVar;
        this.f2680z = wVar;
        this.f2656A = wVar;
        this.f2657B = wVar;
        this.f2661F = new a();
        this.f2662G = new b();
        this.f2663H = new c();
        t(context);
        this.f2664I = new androidx.core.view.j();
    }

    private boolean r(View view, Rect rect, boolean z4) {
        boolean z5;
        e eVar = (e) view.getLayoutParams();
        int i2 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        int i4 = rect.left;
        if (i2 != i4) {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i4;
            z5 = true;
        } else {
            z5 = false;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        int i6 = rect.top;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i6;
            z5 = true;
        }
        int i7 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        int i8 = rect.right;
        if (i7 != i8) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i8;
            z5 = true;
        }
        if (z4) {
            int i9 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i10 = rect.bottom;
            if (i9 != i10) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i10;
                return true;
            }
        }
        return z5;
    }

    private void t(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2655J);
        this.f2665i = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f2670n = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f2671o = context.getApplicationInfo().targetSdkVersion < 19;
        this.f2659D = new OverScroller(context);
    }

    @Override // androidx.appcompat.widget.A
    public final void a(Menu menu, l.a aVar) {
        v();
        this.f2669m.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.A
    public final boolean b() {
        v();
        return this.f2669m.b();
    }

    @Override // androidx.appcompat.widget.A
    public final void c(CharSequence charSequence) {
        v();
        this.f2669m.c(charSequence);
    }

    @Override // android.view.ViewGroup
    protected final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.A
    public final boolean d() {
        v();
        return this.f2669m.d();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f2670n == null || this.f2671o) {
            return;
        }
        if (this.f2668l.getVisibility() == 0) {
            translationY = (int) (this.f2668l.getTranslationY() + this.f2668l.getBottom() + 0.5f);
        } else {
            translationY = 0;
        }
        this.f2670n.setBounds(0, translationY, getWidth(), this.f2670n.getIntrinsicHeight() + translationY);
        this.f2670n.draw(canvas);
    }

    @Override // androidx.appcompat.widget.A
    public final void e(Window.Callback callback) {
        v();
        this.f2669m.e(callback);
    }

    @Override // androidx.appcompat.widget.A
    public final boolean f() {
        v();
        return this.f2669m.f();
    }

    @Override // android.view.View
    protected final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.A
    public final boolean g() {
        v();
        return this.f2669m.g();
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final int getNestedScrollAxes() {
        return this.f2664I.a();
    }

    @Override // androidx.appcompat.widget.A
    public final void h() {
        v();
        this.f2669m.h();
    }

    @Override // androidx.appcompat.widget.A
    public final boolean i() {
        v();
        return this.f2669m.i();
    }

    @Override // androidx.core.view.h
    public final void j(View view, View view2, int i2, int i4) {
        if (i4 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // androidx.core.view.h
    public final void k(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.h
    public final void l(View view, int i2, int i4, int[] iArr, int i5) {
        if (i5 == 0) {
            onNestedPreScroll(view, i2, i4, iArr);
        }
    }

    @Override // androidx.appcompat.widget.A
    public final void m(int i2) {
        v();
        if (i2 == 2) {
            this.f2669m.s();
            return;
        }
        if (i2 == 5) {
            this.f2669m.u();
        } else {
            if (i2 != 109) {
                return;
            }
            this.p = true;
            this.f2671o = getContext().getApplicationInfo().targetSdkVersion < 19;
        }
    }

    @Override // androidx.appcompat.widget.A
    public final void n() {
        v();
        this.f2669m.j();
    }

    @Override // androidx.core.view.i
    public final void o(View view, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        if (i7 == 0) {
            onNestedScroll(view, i2, i4, i5, i6);
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        v();
        androidx.core.view.w wVarO = androidx.core.view.w.o(windowInsets, this);
        boolean zR = r(this.f2668l, new Rect(wVarO.f(), wVarO.h(), wVarO.g(), wVarO.e()), false);
        androidx.core.view.o.b(this, wVarO, this.f2676v);
        Rect rect = this.f2676v;
        androidx.core.view.w wVarI = wVarO.i(rect.left, rect.top, rect.right, rect.bottom);
        this.f2679y = wVarI;
        boolean z4 = true;
        if (!this.f2680z.equals(wVarI)) {
            this.f2680z = this.f2679y;
            zR = true;
        }
        if (this.f2677w.equals(this.f2676v)) {
            z4 = zR;
        } else {
            this.f2677w.set(this.f2676v);
        }
        if (z4) {
            requestLayout();
        }
        return wVarO.a().c().b().n();
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        t(getContext());
        int i2 = androidx.core.view.o.d;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i9 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
            }
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        int measuredHeight;
        v();
        measureChildWithMargins(this.f2668l, i2, 0, i4, 0);
        e eVar = (e) this.f2668l.getLayoutParams();
        int iMax = Math.max(0, this.f2668l.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f2668l.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2668l.getMeasuredState());
        int i5 = androidx.core.view.o.d;
        boolean z4 = (getWindowSystemUiVisibility() & 256) != 0;
        if (z4) {
            measuredHeight = this.f2665i;
            if (this.f2672q) {
                Objects.requireNonNull(this.f2668l);
            }
        } else {
            measuredHeight = this.f2668l.getVisibility() != 8 ? this.f2668l.getMeasuredHeight() : 0;
        }
        this.f2678x.set(this.f2676v);
        androidx.core.view.w wVar = this.f2679y;
        this.f2656A = wVar;
        if (this.p || z4) {
            y.b bVarA = y.b.a(wVar.f(), this.f2656A.h() + measuredHeight, this.f2656A.g(), this.f2656A.e() + 0);
            w.a aVar = new w.a(this.f2656A);
            aVar.c(bVarA);
            this.f2656A = aVar.a();
        } else {
            Rect rect = this.f2678x;
            rect.top += measuredHeight;
            rect.bottom += 0;
            this.f2656A = wVar.i(0, measuredHeight, 0, 0);
        }
        r(this.f2667k, this.f2678x, true);
        if (!this.f2657B.equals(this.f2656A)) {
            androidx.core.view.w wVar2 = this.f2656A;
            this.f2657B = wVar2;
            androidx.core.view.o.c(this.f2667k, wVar2);
        }
        measureChildWithMargins(this.f2667k, i2, 0, i4, 0);
        e eVar2 = (e) this.f2667k.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f2667k.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f2667k.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2667k.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i2, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (!this.f2673r || !z4) {
            return false;
        }
        this.f2659D.fling(0, 0, 0, (int) f5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f2659D.getFinalY() > this.f2668l.getHeight()) {
            s();
            ((c) this.f2663H).run();
        } else {
            s();
            ((b) this.f2662G).run();
        }
        this.f2674s = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i2, int i4, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i2, int i4, int i5, int i6) {
        int i7 = this.f2675t + i4;
        this.f2675t = i7;
        w(i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f2664I.b(i2);
        ActionBarContainer actionBarContainer = this.f2668l;
        this.f2675t = actionBarContainer != null ? -((int) actionBarContainer.getTranslationY()) : 0;
        s();
        d dVar = this.f2658C;
        if (dVar != null) {
            ((androidx.appcompat.app.s) dVar).u();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f2668l.getVisibility() != 0) {
            return false;
        }
        return this.f2673r;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f2673r || this.f2674s) {
            return;
        }
        if (this.f2675t <= this.f2668l.getHeight()) {
            s();
            postDelayed(this.f2662G, 600L);
        } else {
            s();
            postDelayed(this.f2663H, 600L);
        }
    }

    @Override // android.view.View
    @Deprecated
    public final void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        v();
        int i4 = this.u ^ i2;
        this.u = i2;
        boolean z4 = (i2 & 4) == 0;
        boolean z5 = (i2 & 256) != 0;
        d dVar = this.f2658C;
        if (dVar != null) {
            ((androidx.appcompat.app.s) dVar).q(!z5);
            if (z4 || !z5) {
                ((androidx.appcompat.app.s) this.f2658C).A();
            } else {
                ((androidx.appcompat.app.s) this.f2658C).r();
            }
        }
        if ((i4 & 256) == 0 || this.f2658C == null) {
            return;
        }
        int i5 = androidx.core.view.o.d;
        requestApplyInsets();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f2666j = i2;
        d dVar = this.f2658C;
        if (dVar != null) {
            ((androidx.appcompat.app.s) dVar).v(i2);
        }
    }

    @Override // androidx.core.view.h
    public final void p(View view, int i2, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            onNestedScroll(view, i2, i4, i5, i6);
        }
    }

    @Override // androidx.core.view.h
    public final boolean q(View view, View view2, int i2, int i4) {
        return i4 == 0 && onStartNestedScroll(view, view2, i2);
    }

    final void s() {
        removeCallbacks(this.f2662G);
        removeCallbacks(this.f2663H);
        ViewPropertyAnimator viewPropertyAnimator = this.f2660E;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final boolean u() {
        return this.p;
    }

    final void v() {
        B bW;
        if (this.f2667k == null) {
            this.f2667k = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f2668l = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof B) {
                bW = (B) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    StringBuilder sbD = D2.e.d("Can't make a decor toolbar out of ");
                    sbD.append(callbackFindViewById.getClass().getSimpleName());
                    throw new IllegalStateException(sbD.toString());
                }
                bW = ((Toolbar) callbackFindViewById).w();
            }
            this.f2669m = bW;
        }
    }

    public final void w(int i2) {
        s();
        this.f2668l.setTranslationY(-Math.max(0, Math.min(i2, this.f2668l.getHeight())));
    }

    public final void x(d dVar) {
        this.f2658C = dVar;
        if (getWindowToken() != null) {
            ((androidx.appcompat.app.s) this.f2658C).v(this.f2666j);
            int i2 = this.u;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                int i4 = androidx.core.view.o.d;
                requestApplyInsets();
            }
        }
    }

    public final void y(boolean z4) {
        this.f2672q = z4;
    }

    public final void z(boolean z4) {
        if (z4 != this.f2673r) {
            this.f2673r = z4;
            if (z4) {
                return;
            }
            s();
            w(0);
        }
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }
}
