package miuix.appcompat.internal.app.widget;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Y;
import java.util.Objects;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.appcompat.internal.view.menu.MenuDialogHelper;
import miuix.appcompat.internal.view.menu.MenuPresenter;
import miuix.core.util.SystemProperties;
import miuix.view.e;
import t3.C0389d;
import z3.C0431a;
import z3.C0432b;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends FrameLayout implements androidx.core.view.i {

    /* renamed from: A, reason: collision with root package name */
    private Rect f6779A;

    /* renamed from: B, reason: collision with root package name */
    private Rect f6780B;

    /* renamed from: C, reason: collision with root package name */
    private Rect f6781C;

    /* renamed from: D, reason: collision with root package name */
    private Rect f6782D;

    /* renamed from: E, reason: collision with root package name */
    private v3.b f6783E;

    /* renamed from: F, reason: collision with root package name */
    private MenuDialogHelper f6784F;

    /* renamed from: G, reason: collision with root package name */
    private c f6785G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f6786H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f6787I;

    /* renamed from: J, reason: collision with root package name */
    private int f6788J;

    /* renamed from: K, reason: collision with root package name */
    private int f6789K;
    private int[] L;

    /* renamed from: i, reason: collision with root package name */
    protected ActionBarView f6790i;

    /* renamed from: j, reason: collision with root package name */
    protected ActionBarContainer f6791j;

    /* renamed from: k, reason: collision with root package name */
    protected View f6792k;

    /* renamed from: l, reason: collision with root package name */
    private miuix.appcompat.app.b f6793l;

    /* renamed from: m, reason: collision with root package name */
    private ActionBarContainer f6794m;

    /* renamed from: n, reason: collision with root package name */
    private ActionBarContextView f6795n;

    /* renamed from: o, reason: collision with root package name */
    private View f6796o;
    private ActionMode p;

    /* renamed from: q, reason: collision with root package name */
    private Window.Callback f6797q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6798r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6799s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f6800t;
    private boolean u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f6801v;

    /* renamed from: w, reason: collision with root package name */
    private int f6802w;

    /* renamed from: x, reason: collision with root package name */
    private Rect f6803x;

    /* renamed from: y, reason: collision with root package name */
    private Rect f6804y;

    /* renamed from: z, reason: collision with root package name */
    private Rect f6805z;

    private class a implements ActionMode.Callback {

        /* renamed from: a, reason: collision with root package name */
        private ActionMode.Callback f6806a;

        public a(ActionMode.Callback callback) {
            this.f6806a = callback;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f6806a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f6806a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.f6806a.onDestroyActionMode(actionMode);
            if (ActionBarOverlayLayout.this.h() != null) {
                ActionBarOverlayLayout.this.h().onActionModeFinished(actionMode);
            }
            ActionBarOverlayLayout.this.p = null;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f6806a.onPrepareActionMode(actionMode, menu);
        }
    }

    public class b implements Animator.AnimatorListener {

        /* renamed from: i, reason: collision with root package name */
        private ObjectAnimator f6808i;

        /* renamed from: j, reason: collision with root package name */
        private ObjectAnimator f6809j;

        /* renamed from: k, reason: collision with root package name */
        private View.OnClickListener f6810k;

        b(View.OnClickListener onClickListener) {
            this.f6810k = onClickListener;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(ActionBarOverlayLayout.this.f6796o, "alpha", 0.0f, 1.0f);
            this.f6808i = objectAnimatorOfFloat;
            objectAnimatorOfFloat.addListener(this);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(ActionBarOverlayLayout.this.f6796o, "alpha", 1.0f, 0.0f);
            this.f6809j = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.addListener(this);
            int i2 = C0432b.f8169a;
        }

        public final Animator a() {
            return this.f6809j;
        }

        public final Animator b() {
            return this.f6808i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            if (ActionBarOverlayLayout.this.f6796o == null || ActionBarOverlayLayout.this.f6794m == null || animator != this.f6809j) {
                return;
            }
            ActionBarOverlayLayout.this.f6794m.bringToFront();
            ActionBarOverlayLayout.this.f6796o.setOnClickListener(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (ActionBarOverlayLayout.this.f6796o == null || ActionBarOverlayLayout.this.f6794m == null || ActionBarOverlayLayout.this.f6796o.getAlpha() != 0.0f) {
                return;
            }
            ActionBarOverlayLayout.this.f6794m.bringToFront();
            ActionBarOverlayLayout.this.f6796o.setOnClickListener(null);
            ActionBarOverlayLayout.this.f6796o.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            if (ActionBarOverlayLayout.this.f6796o == null || ActionBarOverlayLayout.this.f6794m == null || animator != this.f6808i) {
                return;
            }
            ActionBarOverlayLayout.this.f6796o.setVisibility(0);
            ActionBarOverlayLayout.this.f6796o.bringToFront();
            ActionBarOverlayLayout.this.f6794m.bringToFront();
            ActionBarOverlayLayout.this.f6796o.setOnClickListener(this.f6810k);
        }
    }

    private class c implements MenuBuilder.Callback, MenuPresenter.Callback {

        /* renamed from: i, reason: collision with root package name */
        private MenuDialogHelper f6812i;

        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // miuix.appcompat.internal.view.menu.MenuPresenter.Callback
        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z4) {
            if (menuBuilder.getRootMenu() != menuBuilder && ActionBarOverlayLayout.this.f6797q != null) {
                ActionBarOverlayLayout.this.f6797q.onPanelClosed(6, menuBuilder.getRootMenu());
            }
            if (z4) {
                if (ActionBarOverlayLayout.this.f6797q != null) {
                    ActionBarOverlayLayout.this.f6797q.onPanelClosed(6, menuBuilder);
                }
                ActionBarOverlayLayout.e(ActionBarOverlayLayout.this);
                MenuDialogHelper menuDialogHelper = this.f6812i;
                if (menuDialogHelper != null) {
                    menuDialogHelper.dismiss();
                    this.f6812i = null;
                }
            }
        }

        @Override // miuix.appcompat.internal.view.menu.MenuBuilder.Callback
        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (ActionBarOverlayLayout.this.f6797q != null) {
                return ActionBarOverlayLayout.this.f6797q.onMenuItemSelected(6, menuItem);
            }
            return false;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuBuilder.Callback
        public final void onMenuModeChange(MenuBuilder menuBuilder) {
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter.Callback
        public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            menuBuilder.setCallback(this);
            MenuDialogHelper menuDialogHelper = new MenuDialogHelper(menuBuilder);
            this.f6812i = menuDialogHelper;
            menuDialogHelper.show(null);
            return true;
        }
    }

    private class d extends a implements e.a {
        public d(ActionBarOverlayLayout actionBarOverlayLayout, ActionMode.Callback callback) {
            super(callback);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6799s = true;
        this.f6803x = new Rect();
        this.f6804y = new Rect();
        this.f6805z = new Rect();
        this.f6779A = new Rect();
        this.f6780B = new Rect();
        this.f6781C = new Rect();
        this.f6782D = new Rect();
        this.f6785G = new c();
        this.L = new int[2];
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2109b0, 0, 0);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.u = z4;
        if (z4) {
            this.f6801v = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(14, 0);
        y(i2);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(15, i2 == 1 || i2 == 2 || i2 == 3);
        if (this.f6787I != z5) {
            this.f6787I = z5;
            requestLayout();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    static void e(ActionBarOverlayLayout actionBarOverlayLayout) {
        MenuDialogHelper menuDialogHelper = actionBarOverlayLayout.f6784F;
        if (menuDialogHelper != null) {
            menuDialogHelper.dismiss();
            actionBarOverlayLayout.f6783E = null;
        }
    }

    private boolean g(View view, Rect rect, boolean z4, boolean z5) {
        boolean z6;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        int i2 = layoutParams.leftMargin;
        int i4 = rect.left;
        if (i2 != i4) {
            layoutParams.leftMargin = i4;
            z6 = true;
        } else {
            z6 = false;
        }
        if (z4) {
            int i5 = layoutParams.topMargin;
            int i6 = rect.top;
            if (i5 != i6) {
                layoutParams.topMargin = i6;
                z6 = true;
            }
        }
        int i7 = layoutParams.rightMargin;
        int i8 = rect.right;
        if (i7 != i8) {
            layoutParams.rightMargin = i8;
            z6 = true;
        }
        if (z5) {
            int i9 = layoutParams.bottomMargin;
            int i10 = rect.bottom;
            if (i9 != i10) {
                layoutParams.bottomMargin = i10;
                return true;
            }
        }
        return z6;
    }

    public final void A() {
        this.f6799s = false;
    }

    public final void B(ActionBarContainer actionBarContainer) {
        this.f6794m = actionBarContainer;
    }

    public final void C(int i2) {
        if (this.f6802w != i2) {
            this.f6802w = i2;
            requestFitSystemWindows();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        if (this.u && (drawable = this.f6801v) != null) {
            drawable.setBounds(0, 0, getRight() - getLeft(), this.f6803x.top);
            this.f6801v.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        boolean z4 = false;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            if (this.p != null) {
                ActionBarContextView actionBarContextView = this.f6795n;
                if (actionBarContextView != null) {
                    miuix.appcompat.internal.view.menu.action.b bVar = actionBarContextView.f6932j;
                    if (bVar != null && bVar.k(false)) {
                        z4 = true;
                    }
                    if (z4) {
                        return true;
                    }
                }
                this.p.finish();
                this.p = null;
                return true;
            }
            ActionBarView actionBarView = this.f6790i;
            if (actionBarView != null) {
                miuix.appcompat.internal.view.menu.action.b bVar2 = actionBarView.f6932j;
                if (bVar2 != null && bVar2.k(false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void f(int i2) {
        Rect rect = new Rect();
        Rect rect2 = this.f6805z;
        rect.top = rect2.top;
        rect.bottom = i2;
        rect.right = rect2.right;
        rect.left = rect2.left;
        g(this.f6792k, rect, true, true);
        this.f6792k.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean fitSystemWindows(Rect rect) {
        boolean z4;
        boolean zG;
        boolean z5;
        boolean z6;
        int dimensionPixelSize;
        Window window;
        this.f6779A.set(rect);
        Context context = ((ViewGroup) getRootView()).getChildAt(0).getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        boolean z7 = true;
        boolean z8 = (activity == null || (window = activity.getWindow()) == null || window.getAttributes().layoutInDisplayCutoutMode != 1) ? false : true;
        if (!z8) {
            z8 = C0431a.g(getContext(), R.attr.windowLayoutInDisplayCutoutMode, 0) == 1;
        }
        if (z8) {
            Rect rect2 = this.f6779A;
            rect2.left = 0;
            rect2.right = 0;
        }
        if (this.f6799s) {
            z4 = false;
        } else {
            if ((getWindowSystemUiVisibility() & 512) != 0) {
                int i2 = this.f6779A.bottom;
                Context context2 = getContext();
                if (Settings.Global.getInt(context2.getContentResolver(), "hide_gesture_line", 0) == 0) {
                    if (Settings.Global.getInt(context2.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                        if (Settings.Global.getInt(context2.getContentResolver(), "use_gesture_version_three", 0) != 0) {
                            z5 = true;
                        }
                        if (z5) {
                        }
                    }
                } else {
                    z5 = false;
                    if (z5) {
                        String str = SystemProperties.get("qemu.hw.mainkeys");
                        if (!"1".equals(str)) {
                            if ("0".equals(str)) {
                                z6 = true;
                            } else {
                                Resources resources = context2.getResources();
                                int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
                                z6 = identifier > 0 ? resources.getBoolean(identifier) : false;
                            }
                            if (z6) {
                                Resources resources2 = context2.getResources();
                                int identifier2 = resources2.getIdentifier("navigation_bar_height", "dimen", "android");
                                dimensionPixelSize = identifier2 > 0 ? resources2.getDimensionPixelSize(identifier2) : 0;
                                Log.i("MiuixUtils", "getNavigationBarHeightFromProp = " + dimensionPixelSize);
                            } else {
                                dimensionPixelSize = 0;
                            }
                            if (dimensionPixelSize < 0) {
                                dimensionPixelSize = 0;
                            }
                            Log.i("MiuixUtils", "getNavigationBarHeight = " + dimensionPixelSize);
                            if (i2 != dimensionPixelSize) {
                            }
                        }
                    } else {
                        if (!(Settings.Global.getInt(context2.getContentResolver(), "force_fsg_nav_bar", 0) != 0)) {
                        }
                    }
                }
            }
            this.f6779A.bottom = 0;
            z4 = true;
        }
        boolean z9 = this.f6799s;
        if (!z9 && !z4) {
            this.f6779A.bottom = 0;
        }
        Rect rect3 = this.f6779A;
        Rect rect4 = this.f6803x;
        boolean zR = r();
        rect4.set(rect3);
        if ((!z9 || zR) && !this.u) {
            rect4.top = 0;
        }
        if (this.f6791j != null) {
            if (r()) {
                this.f6791j.p(rect);
                ActionMode actionMode = this.p;
                if (actionMode instanceof C0389d) {
                    ((C0389d) actionMode).l(rect);
                }
            }
            zG = g(this.f6791j, this.f6779A, this.f6799s && !r(), false);
        } else {
            zG = false;
        }
        if (this.f6794m != null) {
            this.f6782D.set(this.f6779A);
            Rect rect5 = new Rect();
            rect5.set(this.f6803x);
            zG |= g(this.f6794m, rect5, false, true);
        }
        if (this.f6804y.equals(this.f6803x)) {
            z7 = zG;
        } else {
            this.f6804y.set(this.f6803x);
        }
        if (z7) {
            requestLayout();
        }
        return this.f6799s;
    }

    public final Window.Callback h() {
        return this.f6797q;
    }

    public final View i() {
        return this.f6796o;
    }

    @Override // androidx.core.view.h
    public final void j(View view, View view2, int i2, int i4) {
        ActionBarContainer actionBarContainer = this.f6791j;
        if (actionBarContainer != null) {
            actionBarContainer.k(view, view2, i2, i4);
        }
    }

    @Override // androidx.core.view.h
    public final void k(View view, int i2) {
        ActionBarContainer actionBarContainer = this.f6791j;
        if (actionBarContainer != null) {
            actionBarContainer.m(view, i2);
        }
    }

    @Override // androidx.core.view.h
    public final void l(View view, int i2, int i4, int[] iArr, int i5) {
        int[] iArr2 = this.L;
        iArr2[1] = 0;
        ActionBarContainer actionBarContainer = this.f6791j;
        if (actionBarContainer != null) {
            actionBarContainer.i(view, i2, i4, iArr, i5, iArr2);
        }
        this.f6792k.offsetTopAndBottom(-this.L[1]);
    }

    public final b m(View.OnClickListener onClickListener) {
        return new b(onClickListener);
    }

    public final int n() {
        return this.f6788J;
    }

    @Override // androidx.core.view.i
    public final void o(View view, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        int[] iArr2 = this.L;
        iArr2[1] = 0;
        ActionBarContainer actionBarContainer = this.f6791j;
        if (actionBarContainer != null) {
            actionBarContainer.j(view, i2, i4, i5, i6, i7, iArr, iArr2);
        }
        this.f6792k.offsetTopAndBottom(-this.L[1]);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        return (windowInsetsOnApplyWindowInsets.isConsumed() || !this.f6799s) ? windowInsetsOnApplyWindowInsets : windowInsets.consumeDisplayCutout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestFitSystemWindows();
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f6789K = S2.d.g(getContext(), this.f6788J);
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        if (this.f6792k == null) {
            this.f6792k = findViewById(R.id.content);
            ActionBarContainer actionBarContainer = (ActionBarContainer) findViewById(com.android.mmt.R.id.action_bar_container);
            this.f6791j = actionBarContainer;
            if (actionBarContainer != null) {
                this.f6790i = (ActionBarView) actionBarContainer.findViewById(com.android.mmt.R.id.action_bar);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        super.onLayout(z4, i2, i4, i5, i6);
        if (!this.f6787I || this.f6789K <= 0) {
            return;
        }
        View view = this.f6792k;
        int left = view.getLeft() + this.f6789K;
        int top = view.getTop();
        int right = view.getRight() + this.f6789K;
        int bottom = view.getBottom();
        if (Y.b(this)) {
            left = view.getLeft() - this.f6789K;
            right = view.getRight() - this.f6789K;
        }
        view.layout(left, top, right, bottom);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        ActionBarContainer actionBarContainer;
        View view = this.f6792k;
        View view2 = this.f6796o;
        int iMax = 0;
        int iMax2 = 0;
        int iCombineMeasuredStates = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt != view && childAt != view2 && childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i2, 0, i4, 0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                iMax = Math.max(iMax, childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
                iMax2 = Math.max(iMax2, childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        ActionBarContainer actionBarContainer2 = this.f6791j;
        int measuredHeight = (actionBarContainer2 == null || actionBarContainer2.getVisibility() == 8) ? 0 : this.f6791j.getMeasuredHeight();
        ActionBarView actionBarView = this.f6790i;
        int iF = (actionBarView == null || !actionBarView.f6934l || (actionBarContainer = this.f6794m) == null) ? 0 : actionBarContainer.f();
        this.f6781C.set(this.f6779A);
        this.f6805z.set(this.f6803x);
        if (r() && measuredHeight > 0) {
            this.f6805z.top = 0;
        }
        if (this.f6798r) {
            if (!r()) {
                this.f6781C.top += measuredHeight;
            } else if (measuredHeight > 0) {
                this.f6781C.top = measuredHeight;
            }
            this.f6781C.bottom += iF;
        } else {
            Rect rect = this.f6805z;
            rect.top += measuredHeight;
            rect.bottom += iF;
        }
        if ((getWindowSystemUiVisibility() & 512) != 0) {
            if (getResources().getConfiguration().orientation == 1) {
                this.f6805z.bottom = 0;
            } else {
                Rect rect2 = this.f6805z;
                rect2.right = 0;
                rect2.left = 0;
                getContext();
                int i6 = C0432b.f8169a;
                if (!(Settings.Global.getInt(getContext().getContentResolver(), "hide_gesture_line", 0) != 0)) {
                    this.f6805z.bottom = 0;
                }
            }
        }
        if (!this.f6786H) {
            g(view, this.f6805z, true, true);
        }
        if (!this.f6798r) {
            view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), 0);
        }
        if (!this.f6780B.equals(this.f6781C) || this.f6800t) {
            this.f6780B.set(this.f6781C);
            super.fitSystemWindows(this.f6781C);
            this.f6800t = false;
        }
        if (r() && this.u) {
            Drawable drawable = this.f6801v;
            if (drawable != null) {
                drawable.setBounds(0, 0, getRight() - getLeft(), this.f6803x.top);
            } else {
                ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
                if (viewGroup != null && viewGroup.getChildCount() == 1) {
                    View childAt2 = viewGroup.getChildAt(0);
                    childAt2.setPadding(childAt2.getPaddingLeft(), 0, childAt2.getPaddingRight(), childAt2.getPaddingBottom());
                }
            }
        }
        measureChildWithMargins(view, (!this.f6787I || this.f6789K <= 0) ? i2 : View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) - (this.f6789K * 2), View.MeasureSpec.getMode(i2)), 0, i4, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
        int iMax3 = Math.max(iMax, view.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int iMax4 = Math.max(iMax2, view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
        if (view2 != null && view2.getVisibility() == 0) {
            g(view2, this.f6782D, false, true);
            measureChildWithMargins(view2, i2, 0, i4, 0);
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i2, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16));
    }

    @Override // androidx.core.view.h
    public final void p(View view, int i2, int i4, int i5, int i6, int i7) {
    }

    @Override // androidx.core.view.h
    public final boolean q(View view, View view2, int i2, int i4) {
        ActionBarContainer actionBarContainer;
        miuix.appcompat.app.b bVar = this.f6793l;
        return bVar != null && bVar.e() && (actionBarContainer = this.f6791j) != null && actionBarContainer.l(view, view2, i2, i4);
    }

    public final boolean r() {
        int windowSystemUiVisibility = getWindowSystemUiVisibility();
        return (((windowSystemUiVisibility & 256) != 0) && ((windowSystemUiVisibility & 1024) != 0)) || (this.f6802w != 0);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestFitSystemWindows() {
        super.requestFitSystemWindows();
        this.f6800t = true;
    }

    public final void s(miuix.appcompat.app.b bVar) {
        this.f6793l = bVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean showContextMenuForChild(View view, float f4, float f5) {
        boolean zShowContextMenuForChild;
        v3.b bVar = this.f6783E;
        if (bVar == null) {
            v3.b bVar2 = new v3.b(getContext());
            this.f6783E = bVar2;
            bVar2.setCallback(this.f6785G);
        } else {
            bVar.clear();
        }
        v3.c cVarA = this.f6783E.a(view, view.getWindowToken(), f4, f5);
        if (cVarA != null) {
            cVarA.b(this.f6785G);
            zShowContextMenuForChild = true;
        } else {
            zShowContextMenuForChild = super.showContextMenuForChild(view);
        }
        if (zShowContextMenuForChild) {
            return true;
        }
        return getParent() != null && getParent().showContextMenuForChild(view, f4, f5);
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback callback) {
        Window.Callback callback2;
        ActionMode actionMode = this.p;
        if (actionMode != null) {
            actionMode.finish();
        }
        ActionMode actionModeOnWindowStartingActionMode = null;
        this.p = null;
        Window.Callback callback3 = this.f6797q;
        if (callback3 != null) {
            actionModeOnWindowStartingActionMode = callback3.onWindowStartingActionMode(callback instanceof e.a ? new d(this, callback) : new a(callback));
        }
        if (actionModeOnWindowStartingActionMode != null) {
            this.p = actionModeOnWindowStartingActionMode;
        }
        ActionMode actionMode2 = this.p;
        if (actionMode2 != null && (callback2 = this.f6797q) != null) {
            callback2.onActionModeStarted(actionMode2);
        }
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        if (!(view instanceof ActionBarOverlayLayout)) {
            return startActionMode(callback);
        }
        ActionMode actionMode = this.p;
        if (actionMode != null) {
            actionMode.finish();
        }
        ActionMode actionModeStartActionMode = view.startActionMode(callback instanceof e.a ? new d(this, callback) : new a(callback));
        this.p = actionModeStartActionMode;
        return actionModeStartActionMode;
    }

    public final void t(ActionBarContextView actionBarContextView) {
        this.f6795n = actionBarContextView;
        actionBarContextView.O(this.f6790i);
    }

    public final void u(boolean z4) {
        this.f6786H = z4;
    }

    public final void v(Window.Callback callback) {
        this.f6797q = callback;
    }

    public final void w(View view) {
        this.f6796o = view;
        int i2 = C0432b.f8169a;
    }

    public final void x(boolean z4) {
        if (this.f6787I != z4) {
            this.f6787I = z4;
            requestLayout();
        }
    }

    public final void y(int i2) {
        if (!S2.d.j(i2) || this.f6788J == i2) {
            return;
        }
        this.f6788J = i2;
        this.f6789K = S2.d.g(getContext(), i2);
        requestLayout();
    }

    public final void z(boolean z4) {
        this.f6798r = z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean showContextMenuForChild(View view) {
        MenuDialogHelper menuDialogHelper;
        v3.b bVar = this.f6783E;
        if (bVar == null) {
            v3.b bVar2 = new v3.b(getContext());
            this.f6783E = bVar2;
            bVar2.setCallback(this.f6785G);
        } else {
            bVar.clear();
        }
        v3.b bVar3 = this.f6783E;
        IBinder windowToken = view.getWindowToken();
        Objects.requireNonNull(bVar3);
        view.createContextMenu(bVar3);
        if (bVar3.getVisibleItems().size() > 0) {
            EventLog.writeEvent(50001, 1);
            menuDialogHelper = new MenuDialogHelper(bVar3);
            menuDialogHelper.show(windowToken);
        } else {
            menuDialogHelper = null;
        }
        this.f6784F = menuDialogHelper;
        if (menuDialogHelper != null) {
            menuDialogHelper.setPresenterCallback(this.f6785G);
            return true;
        }
        return super.showContextMenuForChild(view);
    }
}
