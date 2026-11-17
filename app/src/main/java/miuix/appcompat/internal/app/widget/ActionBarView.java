package miuix.appcompat.internal.app.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import com.android.mmt.R;
import java.lang.ref.WeakReference;
import java.util.Objects;
import miuix.appcompat.internal.app.widget.c;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.appcompat.internal.view.menu.MenuItemImpl;
import miuix.appcompat.internal.view.menu.MenuPresenter;
import miuix.appcompat.internal.view.menu.MenuView;
import miuix.appcompat.internal.view.menu.SubMenuBuilder;
import r3.C0378b;
import t3.C0386a;
import u3.MenuItemC0392a;
import z3.C0431a;
import z3.C0432b;

/* loaded from: classes.dex */
public class ActionBarView extends miuix.appcompat.internal.app.widget.c {

    /* renamed from: A, reason: collision with root package name */
    private final int f6814A;

    /* renamed from: A0, reason: collision with root package name */
    private int f6815A0;

    /* renamed from: B, reason: collision with root package name */
    private HomeView f6816B;

    /* renamed from: B0, reason: collision with root package name */
    private int f6817B0;

    /* renamed from: C, reason: collision with root package name */
    private HomeView f6818C;

    /* renamed from: C0, reason: collision with root package name */
    private c.a f6819C0;

    /* renamed from: D, reason: collision with root package name */
    private FrameLayout f6820D;

    /* renamed from: D0, reason: collision with root package name */
    private c.a f6821D0;

    /* renamed from: E, reason: collision with root package name */
    private FrameLayout f6822E;

    /* renamed from: E0, reason: collision with root package name */
    private boolean f6823E0;

    /* renamed from: F, reason: collision with root package name */
    private FrameLayout f6824F;

    /* renamed from: F0, reason: collision with root package name */
    private boolean f6825F0;

    /* renamed from: G, reason: collision with root package name */
    private NestedScrollView f6826G;

    /* renamed from: G0, reason: collision with root package name */
    private Scroller f6827G0;

    /* renamed from: H, reason: collision with root package name */
    private NestedScrollView f6828H;

    /* renamed from: H0, reason: collision with root package name */
    private boolean f6829H0;

    /* renamed from: I, reason: collision with root package name */
    private C0378b f6830I;

    /* renamed from: I0, reason: collision with root package name */
    private boolean f6831I0;

    /* renamed from: J, reason: collision with root package name */
    private r3.c f6832J;

    /* renamed from: J0, reason: collision with root package name */
    private boolean f6833J0;

    /* renamed from: K, reason: collision with root package name */
    private AppCompatImageView f6834K;

    /* renamed from: K0, reason: collision with root package name */
    private ValueAnimator f6835K0;
    private ScrollingTabContainerView L;

    /* renamed from: L0, reason: collision with root package name */
    private k f6836L0;
    private ScrollingTabContainerView M;

    /* renamed from: M0, reason: collision with root package name */
    private Runnable f6837M0;

    /* renamed from: N, reason: collision with root package name */
    private ScrollingTabContainerView f6838N;

    /* renamed from: O, reason: collision with root package name */
    private ScrollingTabContainerView f6839O;
    private View P;

    /* renamed from: Q, reason: collision with root package name */
    private ProgressBar f6840Q;

    /* renamed from: R, reason: collision with root package name */
    private View f6841R;

    /* renamed from: S, reason: collision with root package name */
    private View f6842S;

    /* renamed from: T, reason: collision with root package name */
    private int f6843T;

    /* renamed from: U, reason: collision with root package name */
    private int f6844U;

    /* renamed from: V, reason: collision with root package name */
    private int f6845V;

    /* renamed from: W, reason: collision with root package name */
    private int f6846W;

    /* renamed from: a0, reason: collision with root package name */
    private int f6847a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f6848b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f6849c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f6850d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f6851e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f6852f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f6853g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f6854h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f6855i0;

    /* renamed from: j0, reason: collision with root package name */
    private MenuBuilder f6856j0;

    /* renamed from: k0, reason: collision with root package name */
    private MenuItemC0392a f6857k0;

    /* renamed from: l0, reason: collision with root package name */
    private MenuItemC0392a f6858l0;

    /* renamed from: m0, reason: collision with root package name */
    private i f6859m0;

    /* renamed from: n0, reason: collision with root package name */
    View f6860n0;

    /* renamed from: o0, reason: collision with root package name */
    Window.Callback f6861o0;
    private boolean p0;
    protected Animator.AnimatorListener q0;

    /* renamed from: r0, reason: collision with root package name */
    protected Animator.AnimatorListener f6862r0;

    /* renamed from: s, reason: collision with root package name */
    private int f6863s;

    /* renamed from: s0, reason: collision with root package name */
    private final View.OnClickListener f6864s0;

    /* renamed from: t, reason: collision with root package name */
    private int f6865t;

    /* renamed from: t0, reason: collision with root package name */
    private final View.OnClickListener f6866t0;
    private CharSequence u;

    /* renamed from: u0, reason: collision with root package name */
    private final View.OnClickListener f6867u0;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f6868v;

    /* renamed from: v0, reason: collision with root package name */
    private final TextWatcher f6869v0;

    /* renamed from: w, reason: collision with root package name */
    private int f6870w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f6871w0;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f6872x;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f6873x0;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f6874y;

    /* renamed from: y0, reason: collision with root package name */
    private int f6875y0;

    /* renamed from: z, reason: collision with root package name */
    private Context f6876z;

    /* renamed from: z0, reason: collision with root package name */
    int f6877z0;

    private static class HomeView extends FrameLayout {

        /* renamed from: i, reason: collision with root package name */
        private ImageView f6878i;

        /* renamed from: j, reason: collision with root package name */
        private ImageView f6879j;

        /* renamed from: k, reason: collision with root package name */
        private int f6880k;

        /* renamed from: l, reason: collision with root package name */
        private int f6881l;

        /* renamed from: m, reason: collision with root package name */
        private Drawable f6882m;

        public HomeView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final void a(Drawable drawable) {
            this.f6879j.setImageDrawable(drawable);
        }

        public final void b(boolean z4) {
            this.f6878i.setVisibility(z4 ? 0 : 8);
        }

        @Override // android.view.View
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            CharSequence contentDescription = getContentDescription();
            if (TextUtils.isEmpty(contentDescription)) {
                return true;
            }
            accessibilityEvent.getText().add(contentDescription);
            return true;
        }

        @Override // android.view.View
        protected final void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            int i2 = this.f6881l;
            if (i2 != 0) {
                this.f6881l = i2;
                this.f6878i.setImageDrawable(i2 != 0 ? getResources().getDrawable(i2) : null);
            }
        }

        @Override // android.view.View
        protected final void onFinishInflate() {
            super.onFinishInflate();
            this.f6878i = (ImageView) findViewById(R.id.up);
            this.f6879j = (ImageView) findViewById(R.id.home);
            ImageView imageView = this.f6878i;
            if (imageView != null) {
                this.f6882m = imageView.getDrawable();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
            int i7 = (i6 - i4) / 2;
            int i8 = 0;
            boolean z5 = getLayoutDirection() == 1;
            if (this.f6878i.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6878i.getLayoutParams();
                int measuredHeight = this.f6878i.getMeasuredHeight();
                int measuredWidth = this.f6878i.getMeasuredWidth();
                int i9 = i7 - (measuredHeight / 2);
                S2.d.k(this, this.f6878i, 0, i9, measuredWidth, i9 + measuredHeight);
                i8 = layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin;
                if (z5) {
                    i5 -= i8;
                } else {
                    i2 += i8;
                }
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f6879j.getLayoutParams();
            int measuredHeight2 = this.f6879j.getMeasuredHeight();
            int measuredWidth2 = this.f6879j.getMeasuredWidth();
            int iMax = Math.max(layoutParams2.getMarginStart(), ((i5 - i2) / 2) - (measuredWidth2 / 2)) + i8;
            int iMax2 = Math.max(layoutParams2.topMargin, i7 - (measuredHeight2 / 2));
            S2.d.k(this, this.f6879j, iMax, iMax2, iMax + measuredWidth2, iMax2 + measuredHeight2);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected final void onMeasure(int i2, int i4) {
            measureChildWithMargins(this.f6878i, i2, 0, i4, 0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6878i.getLayoutParams();
            this.f6880k = this.f6878i.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int i5 = this.f6878i.getVisibility() == 8 ? 0 : this.f6880k;
            int measuredHeight = layoutParams.bottomMargin + this.f6878i.getMeasuredHeight() + layoutParams.topMargin;
            measureChildWithMargins(this.f6879j, i2, i5, i4, 0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f6879j.getLayoutParams();
            int measuredWidth = this.f6879j.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin + i5;
            int iMax = Math.max(measuredHeight, this.f6879j.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i4);
            if (mode == Integer.MIN_VALUE) {
                measuredWidth = Math.min(measuredWidth, size);
            } else if (mode == 1073741824) {
                measuredWidth = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                iMax = Math.min(iMax, size2);
            } else if (mode2 == 1073741824) {
                iMax = size2;
            }
            setMeasuredDimension(measuredWidth, iMax);
        }
    }

    final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (ActionBarView.this.f6819C0 != null) {
                ActionBarView.this.f6819C0.d();
            }
        }
    }

    final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (ActionBarView.this.f6819C0 != null) {
                ActionBarView.this.f6819C0.c();
            }
        }
    }

    final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MenuItemImpl menuItemImpl = ActionBarView.this.f6859m0.f6894j;
            if (menuItemImpl != null) {
                menuItemImpl.collapseActionView();
            }
        }
    }

    final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActionBarView actionBarView = ActionBarView.this;
            actionBarView.f6861o0.onMenuItemSelected(0, actionBarView.f6857k0);
        }
    }

    final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActionBarView actionBarView = ActionBarView.this;
            actionBarView.f6861o0.onMenuItemSelected(0, actionBarView.f6858l0);
        }
    }

    final class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            ActionBarView.this.f6832J.i(charSequence);
        }
    }

    final class g implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ miuix.appcompat.app.d f6889i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ View f6890j;

        g(miuix.appcompat.app.d dVar, View view) {
            this.f6889i = dVar;
            this.f6890j = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f6889i.t(this.f6890j, ActionBarView.this);
        }
    }

    final class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActionBarView.this.f6827G0.computeScrollOffset()) {
                ActionBarView actionBarView = ActionBarView.this;
                int currY = actionBarView.f6827G0.getCurrY();
                ActionBarView actionBarView2 = ActionBarView.this;
                actionBarView.f6875y0 = (currY - actionBarView2.f6877z0) + actionBarView2.f6815A0;
                ActionBarView.this.requestLayout();
                if (!ActionBarView.this.f6827G0.isFinished()) {
                    ActionBarView.this.postOnAnimation(this);
                    return;
                }
                int currY2 = ActionBarView.this.f6827G0.getCurrY();
                ActionBarView actionBarView3 = ActionBarView.this;
                if (currY2 == actionBarView3.f6877z0) {
                    actionBarView3.i(0);
                    return;
                }
                int currY3 = actionBarView3.f6827G0.getCurrY();
                ActionBarView actionBarView4 = ActionBarView.this;
                if (currY3 == actionBarView4.f6824F.getMeasuredHeight() + actionBarView4.f6877z0) {
                    ActionBarView.this.i(1);
                }
            }
        }
    }

    private class i implements MenuPresenter {

        /* renamed from: i, reason: collision with root package name */
        MenuBuilder f6893i;

        /* renamed from: j, reason: collision with root package name */
        MenuItemImpl f6894j;

        i() {
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            KeyEvent.Callback callback = ActionBarView.this.f6860n0;
            if (callback instanceof CollapsibleActionView) {
                ((CollapsibleActionView) callback).onActionViewCollapsed();
            }
            ActionBarView actionBarView = ActionBarView.this;
            actionBarView.removeView(actionBarView.f6860n0);
            ActionBarView actionBarView2 = ActionBarView.this;
            actionBarView2.removeView(actionBarView2.f6818C);
            ActionBarView actionBarView3 = ActionBarView.this;
            actionBarView3.f6860n0 = null;
            if ((actionBarView3.f6865t & 2) != 0) {
                ActionBarView.this.f6816B.setVisibility(0);
            }
            if ((ActionBarView.this.f6865t & 8) != 0) {
                if (ActionBarView.this.f6830I == null) {
                    ActionBarView.this.f0();
                } else {
                    ActionBarView.this.G0(true);
                }
            }
            if (ActionBarView.this.L != null && ActionBarView.this.f6863s == 2) {
                ActionBarView.this.L.setVisibility(0);
            }
            if (ActionBarView.this.M != null && ActionBarView.this.f6863s == 2) {
                ActionBarView.this.M.setVisibility(0);
            }
            if (ActionBarView.this.f6838N != null && ActionBarView.this.f6863s == 2) {
                ActionBarView.this.f6838N.setVisibility(0);
            }
            if (ActionBarView.this.f6839O != null && ActionBarView.this.f6863s == 2) {
                ActionBarView.this.f6839O.setVisibility(0);
            }
            if (ActionBarView.this.P != null && (ActionBarView.this.f6865t & 16) != 0) {
                ActionBarView.this.P.setVisibility(0);
            }
            ActionBarView.this.f6818C.a(null);
            this.f6894j = null;
            ActionBarView.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            ActionBarView.this.f6860n0 = menuItemImpl.getActionView();
            ActionBarView.N(ActionBarView.this);
            ActionBarView.this.f6818C.a(ActionBarView.this.X().getConstantState().newDrawable(ActionBarView.this.getResources()));
            this.f6894j = menuItemImpl;
            ViewParent parent = ActionBarView.this.f6860n0.getParent();
            ActionBarView actionBarView = ActionBarView.this;
            if (parent != actionBarView) {
                actionBarView.addView(actionBarView.f6860n0);
            }
            ViewParent parent2 = ActionBarView.this.f6818C.getParent();
            ActionBarView actionBarView2 = ActionBarView.this;
            if (parent2 != actionBarView2) {
                actionBarView2.addView(actionBarView2.f6818C);
            }
            if (ActionBarView.this.f6816B != null) {
                ActionBarView.this.f6816B.setVisibility(8);
            }
            if (ActionBarView.this.f6830I != null) {
                ActionBarView.this.G0(false);
            }
            if (ActionBarView.this.L != null) {
                ActionBarView.this.L.setVisibility(8);
            }
            if (ActionBarView.this.M != null) {
                ActionBarView.this.M.setVisibility(8);
            }
            if (ActionBarView.this.f6838N != null) {
                ActionBarView.this.f6838N.setVisibility(8);
            }
            if (ActionBarView.this.f6839O != null) {
                ActionBarView.this.f6839O.setVisibility(8);
            }
            if (ActionBarView.this.P != null) {
                ActionBarView.this.P.setVisibility(8);
            }
            ActionBarView.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            KeyEvent.Callback callback = ActionBarView.this.f6860n0;
            if (callback instanceof CollapsibleActionView) {
                ((CollapsibleActionView) callback).onActionViewExpanded();
            }
            return true;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final boolean flagActionItems() {
            return false;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final int getId() {
            return 0;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.f6893i;
            if (menuBuilder2 != null && (menuItemImpl = this.f6894j) != null) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.f6893i = menuBuilder;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z4) {
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final void setCallback(MenuPresenter.Callback callback) {
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter
        public final void updateMenuView(boolean z4) {
            if (this.f6894j != null) {
                MenuBuilder menuBuilder = this.f6893i;
                boolean z5 = false;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        if (this.f6893i.getItem(i2) == this.f6894j) {
                            z5 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (z5) {
                    return;
                }
                collapseItemActionView(this.f6893i, this.f6894j);
            }
        }
    }

    static class j extends View.BaseSavedState {
        public static final Parcelable.ClassLoaderCreator<j> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        int f6896i;

        /* renamed from: j, reason: collision with root package name */
        boolean f6897j;

        /* renamed from: k, reason: collision with root package name */
        int f6898k;

        final class a implements Parcelable.ClassLoaderCreator<j> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new j(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new j[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final j createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new j(parcel, classLoader);
            }
        }

        j(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f6896i);
            parcel.writeInt(this.f6897j ? 1 : 0);
            parcel.writeInt(this.f6898k);
        }

        j(Parcel parcel) {
            super(parcel);
            this.f6896i = parcel.readInt();
            this.f6897j = parcel.readInt() != 0;
            this.f6898k = parcel.readInt();
        }

        j(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6896i = parcel.readInt();
            this.f6897j = parcel.readInt() != 0;
            this.f6898k = parcel.readInt();
        }
    }

    private static class k extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: i, reason: collision with root package name */
        private final WeakReference<ActionBarView> f6899i;

        /* renamed from: j, reason: collision with root package name */
        private int f6900j;

        k(ActionBarView actionBarView) {
            this.f6899i = new WeakReference<>(actionBarView);
        }

        final void a(int i2) {
            this.f6900j = i2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z4) {
            super.onAnimationEnd(animator, z4);
            ActionBarView actionBarView = this.f6899i.get();
            if (actionBarView == null) {
                return;
            }
            actionBarView.i(this.f6900j);
            actionBarView.k(actionBarView.f6829H0);
            if (actionBarView.f6833J0) {
                actionBarView.f6819C0.h(4);
            } else {
                actionBarView.f6819C0.h(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator, boolean z4) {
            super.onAnimationStart(animator, z4);
            ActionBarView actionBarView = this.f6899i.get();
            if (actionBarView == null) {
                return;
            }
            actionBarView.f6829H0 = actionBarView.c();
            actionBarView.k(true);
            actionBarView.i(2);
            actionBarView.f6819C0.h(4);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ActionBarView actionBarView = this.f6899i.get();
            if (actionBarView == null) {
                return;
            }
            actionBarView.f6875y0 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            actionBarView.requestLayout();
        }
    }

    public ActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6865t = -1;
        this.p0 = true;
        this.q0 = new a();
        this.f6862r0 = new b();
        this.f6864s0 = new c();
        this.f6866t0 = new d();
        this.f6867u0 = new e();
        this.f6869v0 = new f();
        this.f6871w0 = false;
        this.f6873x0 = false;
        this.f6819C0 = new c.a();
        this.f6821D0 = new c.a();
        this.f6823E0 = false;
        this.f6825F0 = false;
        this.f6831I0 = false;
        this.f6833J0 = false;
        this.f6835K0 = null;
        this.f6836L0 = new k(this);
        this.f6837M0 = new h();
        this.f6876z = context;
        this.f6827G0 = new Scroller(context);
        this.f6831I0 = false;
        this.f6833J0 = false;
        this.f6845V = context.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_title_horizontal_padding);
        this.f6846W = context.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_title_tab_horizontal_padding);
        this.f6847a0 = context.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_title_top_padding);
        this.f6848b0 = context.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_title_bottom_padding);
        this.f6849c0 = context.getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_subtitle_bottom_padding);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f6820D = frameLayout;
        frameLayout.setId(R.id.action_bar_collapse_container);
        this.f6820D.setForegroundGravity(17);
        this.f6820D.setVisibility(0);
        this.f6820D.setAlpha(this.p == 0 ? 1.0f : 0.0f);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.f6824F = frameLayout2;
        frameLayout2.setId(R.id.action_bar_movable_container);
        FrameLayout frameLayout3 = this.f6824F;
        int i2 = this.f6845V;
        frameLayout3.setPaddingRelative(i2, this.f6847a0, i2, this.f6848b0);
        this.f6824F.setVisibility(0);
        this.f6824F.setAlpha(this.p == 0 ? 0.0f : 1.0f);
        NestedScrollView nestedScrollView = new NestedScrollView(context, null);
        this.f6826G = nestedScrollView;
        nestedScrollView.setId(R.id.action_bar_collapse_tab_container);
        this.f6826G.setHorizontalScrollBarEnabled(false);
        this.f6826G.setVerticalScrollBarEnabled(false);
        this.f6826G.setVisibility(0);
        NestedScrollView nestedScrollView2 = new NestedScrollView(context, null);
        this.f6828H = nestedScrollView2;
        nestedScrollView2.setId(R.id.action_bar_movable_tab_container);
        this.f6828H.setHorizontalScrollBarEnabled(false);
        this.f6828H.setVerticalScrollBarEnabled(false);
        this.f6828H.setVisibility(0);
        this.f6819C0.b(this.f6820D);
        this.f6821D0.b(this.f6824F);
        this.f6819C0.b(this.f6826G);
        this.f6821D0.b(this.f6828H);
        setBackgroundResource(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2098S, android.R.attr.actionBarStyle, 0);
        this.f6863s = typedArrayObtainStyledAttributes.getInt(7, 0);
        this.u = typedArrayObtainStyledAttributes.getText(5);
        this.f6868v = typedArrayObtainStyledAttributes.getText(9);
        this.f6855i0 = typedArrayObtainStyledAttributes.getBoolean(54, false);
        this.f6874y = typedArrayObtainStyledAttributes.getDrawable(6);
        this.f6872x = typedArrayObtainStyledAttributes.getDrawable(0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f6814A = typedArrayObtainStyledAttributes.getResourceId(14, R.layout.miuix_appcompat_action_bar_home);
        this.f6850d0 = typedArrayObtainStyledAttributes.getResourceId(11, 0);
        this.f6851e0 = typedArrayObtainStyledAttributes.getResourceId(12, 0);
        this.f6843T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(13, 0);
        this.f6844U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(15, 0);
        v0(typedArrayObtainStyledAttributes.getInt(8, 0));
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(10, 0);
        if (resourceId != 0) {
            this.P = layoutInflaterFrom.inflate(resourceId, (ViewGroup) this, false);
            this.f6863s = 0;
        }
        this.f6936n = typedArrayObtainStyledAttributes.getLayoutDimension(4, 0);
        this.f6937o = typedArrayObtainStyledAttributes.getLayoutDimension(2, 0);
        typedArrayObtainStyledAttributes.recycle();
        CharSequence charSequence = this.u;
        this.f6857k0 = new MenuItemC0392a(context, android.R.id.home, charSequence);
        this.f6858l0 = new MenuItemC0392a(context, android.R.id.title, charSequence);
        post(new miuix.appcompat.internal.app.widget.f(this, 4));
    }

    private void F0(CharSequence charSequence) {
        this.u = charSequence;
        C0378b c0378b = this.f6830I;
        if (c0378b != null) {
            int i2 = 0;
            c0378b.r(0);
            this.f6830I.q(charSequence);
            this.f6832J.i(charSequence);
            G0((this.f6860n0 != null || (this.f6865t & 8) == 0 || (TextUtils.isEmpty(this.u) && TextUtils.isEmpty(this.f6868v))) ? false : true);
            if (!TextUtils.isEmpty(this.f6868v)) {
                this.f6830I.p(0);
                post(new miuix.appcompat.internal.app.widget.f(this, i2));
            }
        }
        MenuItemC0392a menuItemC0392a = this.f6857k0;
        if (menuItemC0392a != null) {
            menuItemC0392a.setTitle(charSequence);
        }
        MenuItemC0392a menuItemC0392a2 = this.f6858l0;
        if (menuItemC0392a2 != null) {
            menuItemC0392a2.setTitle(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(boolean z4) {
        C0378b c0378b = this.f6830I;
        if (c0378b != null) {
            c0378b.s(z4 ? 0 : 8);
        }
        r3.c cVar = this.f6832J;
        if (cVar != null) {
            cVar.k(z4 ? 0 : 8);
        }
        AppCompatImageView appCompatImageView = this.f6834K;
        if (appCompatImageView != null) {
            int i2 = this.f6865t;
            if ((i2 & 32) == 0) {
                if (z4) {
                    appCompatImageView.setVisibility((i2 & 2) != 0 ? 8 : (i2 & 4) != 0 ? 0 : 4);
                } else {
                    appCompatImageView.setVisibility(8);
                }
            }
        }
        int i4 = TextUtils.isEmpty(this.f6868v) ? this.f6848b0 : this.f6849c0;
        FrameLayout frameLayout = this.f6824F;
        frameLayout.setPaddingRelative(frameLayout.getPaddingStart(), this.f6824F.getPaddingTop(), this.f6824F.getPaddingEnd(), i4);
    }

    private void K0() {
        boolean z4 = k0() && TextUtils.isEmpty(this.u);
        int i2 = (z4 || !this.p0) ? 8 : 0;
        C0378b c0378b = this.f6830I;
        if (c0378b != null) {
            c0378b.r(i2);
        }
        int i4 = (z4 || !this.p0 || TextUtils.isEmpty(this.f6868v)) ? 8 : 0;
        C0378b c0378b2 = this.f6830I;
        if (c0378b2 != null) {
            c0378b2.p(i4);
        }
    }

    static void N(ActionBarView actionBarView) {
        if (actionBarView.f6818C == null) {
            HomeView homeView = (HomeView) LayoutInflater.from(actionBarView.f6876z).inflate(actionBarView.f6814A, (ViewGroup) actionBarView, false);
            actionBarView.f6818C = homeView;
            homeView.b(true);
            actionBarView.f6818C.setOnClickListener(actionBarView.f6864s0);
        }
    }

    private void S(ScrollingTabContainerView scrollingTabContainerView, ScrollingTabContainerView scrollingTabContainerView2, ScrollingTabContainerView scrollingTabContainerView3, ScrollingTabContainerView scrollingTabContainerView4) {
        this.L = scrollingTabContainerView;
        this.M = scrollingTabContainerView2;
        this.f6838N = scrollingTabContainerView3;
        this.f6839O = scrollingTabContainerView4;
        if (this.f6820D.getChildCount() == 0 || ((this.f6865t & 8) != 0 && TextUtils.isEmpty(this.u))) {
            this.f6820D.removeAllViews();
            ScrollingTabContainerView scrollingTabContainerView5 = this.L;
            if (scrollingTabContainerView5 != null) {
                scrollingTabContainerView5.setVisibility(0);
                this.f6820D.addView(this.L);
            }
            this.f6824F.removeAllViews();
            ScrollingTabContainerView scrollingTabContainerView6 = this.M;
            if (scrollingTabContainerView6 != null) {
                scrollingTabContainerView6.setVisibility(0);
                this.f6824F.addView(this.M);
            }
            this.f6826G.removeAllViews();
            this.f6828H.removeAllViews();
        } else if (this.f6820D.getChildCount() == 1) {
            C0386a c0386aB = C0386a.b(this.f6876z);
            View childAt = this.f6820D.getChildAt(0);
            if (c0386aB.h() || (childAt instanceof ScrollingTabContainerView)) {
                this.f6820D.removeAllViews();
                ScrollingTabContainerView scrollingTabContainerView7 = this.L;
                if (scrollingTabContainerView7 != null) {
                    this.f6820D.addView(scrollingTabContainerView7);
                }
                this.f6824F.removeAllViews();
                ScrollingTabContainerView scrollingTabContainerView8 = this.M;
                if (scrollingTabContainerView8 != null) {
                    this.f6824F.addView(scrollingTabContainerView8);
                }
            } else {
                this.f6826G.removeAllViews();
                ScrollingTabContainerView scrollingTabContainerView9 = this.f6838N;
                if (scrollingTabContainerView9 != null) {
                    this.f6826G.addView(scrollingTabContainerView9);
                }
                this.f6828H.removeAllViews();
                ScrollingTabContainerView scrollingTabContainerView10 = this.f6839O;
                if (scrollingTabContainerView10 != null) {
                    this.f6828H.addView(scrollingTabContainerView10);
                }
                if (this.f6826G.getParent() == null) {
                    addView(this.f6826G, new FrameLayout.LayoutParams(-1, -2));
                }
                if (this.f6828H.getParent() == null) {
                    addView(this.f6828H, new FrameLayout.LayoutParams(-1, -2));
                }
            }
        }
        u0(this, this.f6820D);
        u0(this, this.f6824F);
        ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        ViewGroup.LayoutParams layoutParams2 = this.M.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = -2;
            layoutParams2.height = -2;
        }
        ViewGroup.LayoutParams layoutParams3 = this.f6838N.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = -2;
            layoutParams3.height = -1;
        }
        ViewGroup.LayoutParams layoutParams4 = this.f6839O.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = -2;
            layoutParams4.height = -1;
        }
        K0();
    }

    private void U(MenuBuilder menuBuilder) {
        if (menuBuilder != null) {
            menuBuilder.addMenuPresenter(this.f6932j);
            menuBuilder.addMenuPresenter(this.f6859m0);
        } else {
            this.f6932j.initForMenu(this.f6876z, null);
            this.f6859m0.initForMenu(this.f6876z, null);
        }
        this.f6932j.updateMenuView(true);
        this.f6859m0.updateMenuView(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable X() {
        if ((this.f6870w & 1) != 1) {
            Context context = this.f6876z;
            if (context instanceof Activity) {
                try {
                    this.f6872x = context.getPackageManager().getActivityIcon(((Activity) this.f6876z).getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.e("ActionBarView", "Activity component name not found!", e2);
                }
            }
            if (this.f6872x == null) {
                this.f6872x = this.f6876z.getApplicationInfo().loadIcon(this.f6876z.getPackageManager());
            }
            this.f6870w |= 1;
        }
        return this.f6872x;
    }

    private boolean a0() {
        return !((this.f6865t & 8) == 0 || TextUtils.isEmpty(this.u)) || this.f6863s == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        int i2 = 2;
        if (this.f6834K == null) {
            Context context = getContext();
            AppCompatImageView appCompatImageView = new AppCompatImageView(context, null);
            appCompatImageView.setId(R.id.up);
            appCompatImageView.setVisibility(8);
            appCompatImageView.post(new O0.i(appCompatImageView, context, i2));
            this.f6834K = appCompatImageView;
            appCompatImageView.setOnClickListener(this.f6866t0);
        }
        addView(this.f6834K);
        int i4 = 1;
        if (this.f6830I == null) {
            C0378b c0378b = new C0378b(getContext());
            c0378b.j();
            this.f6830I = c0378b;
            r3.c cVar = new r3.c(getContext());
            cVar.c();
            this.f6832J = cVar;
            int i5 = this.f6865t;
            boolean z4 = (i5 & 4) != 0;
            boolean z5 = (i5 & 2) != 0;
            this.f6834K.setVisibility(z5 ? 8 : z4 ? 0 : 4);
            this.f6834K.setEnabled(z4 && !z5);
            this.f6830I.l(z4 && !z5);
            this.f6832J.e(z4 && !z5);
            this.f6830I.q(this.u);
            this.f6830I.n(this.f6868v);
            this.f6832J.i(this.u);
            this.f6832J.g(this.f6868v);
            post(new miuix.appcompat.internal.app.widget.f(this, i4));
            if (this.f6868v != null) {
                this.f6830I.p(0);
                this.f6832J.h(0);
            }
            K0();
        }
        View viewG = this.f6830I.g();
        View viewB = this.f6832J.b();
        if (this.f6863s == 2 && this.f6820D.getChildCount() == 1 && (this.f6820D.getChildAt(0) instanceof ScrollingTabContainerView)) {
            ScrollingTabContainerView scrollingTabContainerView = this.f6838N;
            if (scrollingTabContainerView != null) {
                u0(this.f6826G, scrollingTabContainerView);
            }
            ScrollingTabContainerView scrollingTabContainerView2 = this.f6839O;
            if (scrollingTabContainerView2 != null) {
                u0(this.f6828H, scrollingTabContainerView2);
            }
            this.f6820D.removeAllViews();
            this.f6824F.removeAllViews();
        }
        u0(this.f6820D, viewG);
        u0(this.f6824F, viewB);
        post(new miuix.appcompat.internal.app.widget.f(this, i2));
        if (this.f6860n0 != null || (TextUtils.isEmpty(this.u) && TextUtils.isEmpty(this.f6868v))) {
            G0(false);
        }
        u0(this, this.f6820D);
        u0(this, this.f6824F);
    }

    private boolean j0() {
        return this.f6820D.getChildCount() > 0 || !(this.P == null || this.f6822E == null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean l0() {
        boolean z4;
        HomeView homeView;
        if (this.f6855i0) {
            View view = this.P;
            if (view == null || view.getVisibility() != 0) {
                z4 = true;
                if (z4 && ((homeView = this.f6816B) == null || homeView.getVisibility() == 8)) {
                    return true;
                }
            } else {
                ViewGroup.LayoutParams layoutParams = this.P.getLayoutParams();
                a.C0055a c0055a = layoutParams instanceof a.C0055a ? (a.C0055a) layoutParams : null;
                if (c0055a != null) {
                    if (m0(c0055a.f2312a, getLayoutDirection() == 1) == 8388613) {
                    }
                    if (z4) {
                        return true;
                    }
                }
                z4 = false;
                if (z4) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (r4 != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return 8388613;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return 8388611;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r4 != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int m0(int i2, boolean z4) {
        int i4 = 8388615 & i2;
        if ((8388608 & i4) != 0) {
            return i4;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                return i4;
            }
        }
    }

    public static /* synthetic */ void n(ActionBarView actionBarView) {
        C0378b c0378b = actionBarView.f6830I;
        if (c0378b != null) {
            c0378b.o(c0378b.h());
        }
    }

    public static /* synthetic */ void o(ActionBarView actionBarView) {
        C0378b c0378b = actionBarView.f6830I;
        if (c0378b != null) {
            c0378b.m(actionBarView.f6867u0);
            if (actionBarView.f6868v != null) {
                C0378b c0378b2 = actionBarView.f6830I;
                c0378b2.o(c0378b2.h());
            }
        }
        r3.c cVar = actionBarView.f6832J;
        if (cVar != null) {
            cVar.f(actionBarView.f6867u0);
        }
    }

    public static /* synthetic */ void p(ActionBarView actionBarView) {
        int i2 = actionBarView.p;
        if (i2 == 0) {
            actionBarView.f6819C0.f(1.0f, 0);
            actionBarView.f6821D0.f(0.0f, 0);
        } else if (i2 == 1) {
            actionBarView.f6819C0.f(0.0f, 20);
            actionBarView.f6821D0.f(1.0f, 0);
        }
    }

    public static /* synthetic */ void q(ActionBarView actionBarView) {
        C0378b c0378b = actionBarView.f6830I;
        if (c0378b != null) {
            Rect rectF = c0378b.f();
            rectF.left -= C0431a.d(actionBarView.getContext(), R.attr.actionBarPaddingStart);
            actionBarView.setTouchDelegate(new TouchDelegate(rectF, actionBarView.f6830I.g()));
        }
    }

    public static /* synthetic */ void r(ActionBarView actionBarView) {
        C0378b c0378b = actionBarView.f6830I;
        if (c0378b != null) {
            c0378b.o(c0378b.h());
        }
    }

    private void u0(ViewGroup viewGroup, View view) {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
    }

    public final void A0(int i2) {
        ScrollingTabContainerView scrollingTabContainerView;
        ScrollingTabContainerView scrollingTabContainerView2;
        if (i2 != this.f6863s) {
            if (i2 == 1) {
                throw new UnsupportedOperationException("MIUIX Deleted");
            }
            if (i2 == 2 && (scrollingTabContainerView = this.L) != null && (scrollingTabContainerView2 = this.M) != null && this.f6853g0) {
                S(scrollingTabContainerView, scrollingTabContainerView2, this.f6838N, this.f6839O);
            }
            this.f6863s = i2;
            requestLayout();
        }
    }

    public final void B0(ActionBarContainer actionBarContainer) {
        this.f6933k = actionBarContainer;
    }

    public final void C0(boolean z4) {
        this.f6935m = z4;
    }

    public final void D0(CharSequence charSequence) {
        this.f6868v = charSequence;
        C0378b c0378b = this.f6830I;
        if (c0378b != null) {
            c0378b.n(charSequence);
            this.f6832J.g(charSequence);
            boolean z4 = false;
            this.f6830I.p(charSequence != null ? 0 : 8);
            this.f6832J.h(charSequence != null ? 0 : 8);
            if (this.f6860n0 == null && (this.f6865t & 8) != 0 && (!TextUtils.isEmpty(this.u) || !TextUtils.isEmpty(this.f6868v))) {
                z4 = true;
            }
            G0(z4);
            post(new miuix.appcompat.internal.app.widget.f(this, 3));
        }
    }

    public final void E0(CharSequence charSequence) {
        this.f6852f0 = true;
        F0(charSequence);
    }

    public final void H0(Window.Callback callback) {
        this.f6861o0 = callback;
    }

    public final void I0(CharSequence charSequence) {
        if (this.f6852f0) {
            return;
        }
        F0(charSequence);
    }

    public final boolean J0() {
        View view = this.f6841R;
        if (view == null) {
            return false;
        }
        view.setVisibility(0);
        return true;
    }

    public final void T() {
        i iVar = this.f6859m0;
        MenuItemImpl menuItemImpl = iVar == null ? null : iVar.f6894j;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public final View V() {
        return this.P;
    }

    public final int W() {
        return this.f6865t;
    }

    public final int Y() {
        return this.f6863s;
    }

    public final boolean Z() {
        i iVar = this.f6859m0;
        return (iVar == null || iVar.f6894j == null) ? false : true;
    }

    public final boolean b0() {
        View view = this.f6841R;
        if (view == null) {
            return false;
        }
        view.setVisibility(8);
        return true;
    }

    public final boolean c0() {
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        return bVar != null && bVar.k(false);
    }

    public final void d0(int i2, miuix.appcompat.app.d dVar) {
        if (i2 <= 0) {
            Log.w("ActionBarView", "Try to initialize invalid layout for immersion more button: " + i2);
            return;
        }
        int i4 = this.f6865t;
        if ((i4 & 16) != 0) {
            Log.d("ActionBarView", "Don't show immersion menu button for custom action bar");
            return;
        }
        if (i4 == 0) {
            Log.d("ActionBarView", "Don't show immersion menu button for null display option");
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) this, false);
        this.f6841R = viewInflate;
        addView(viewInflate);
        View viewFindViewById = this.f6841R.findViewById(R.id.more);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new g(dVar, viewFindViewById));
        }
    }

    @Override // miuix.appcompat.internal.app.widget.c
    protected final void e(int i2, int i4) {
        ValueAnimator valueAnimator = this.f6835K0;
        if (valueAnimator == null) {
            this.f6835K0 = new ValueAnimator();
        } else if (valueAnimator.isStarted()) {
            this.f6835K0.cancel();
        }
        if (i2 == 1) {
            this.f6875y0 = this.f6824F.getMeasuredHeight() + this.f6817B0;
        } else if (i2 == 0) {
            this.f6875y0 = 0;
        }
        this.f6835K0.removeAllListeners();
        this.f6835K0.removeAllUpdateListeners();
        this.f6836L0.a(i4);
        this.f6835K0.addListener(this.f6836L0);
        this.f6835K0.addUpdateListener(this.f6836L0);
        int measuredHeight = i4 == 1 ? this.f6824F.getMeasuredHeight() : 0;
        if (i4 == 1) {
            this.f6820D.setVisibility(4);
            this.f6826G.setVisibility(4);
        } else if (i4 == 0) {
            this.f6820D.setVisibility(0);
            this.f6826G.setVisibility(0);
        }
        this.f6835K0.setIntValues(this.f6875y0, measuredHeight);
        this.f6835K0.start();
    }

    public final void e0() {
        ProgressBar progressBar = new ProgressBar(this.f6876z, null, R.attr.actionBarIndeterminateProgressStyle);
        this.f6840Q = progressBar;
        progressBar.setId(R.id.progress_circular);
        this.f6840Q.setVisibility(8);
        this.f6840Q.setIndeterminate(true);
        addView(this.f6840Q);
    }

    @Override // miuix.appcompat.internal.app.widget.c
    protected final void f(int i2, int i4) {
        if (i2 == 2) {
            this.f6875y0 = 0;
            if (!this.f6827G0.isFinished()) {
                this.f6827G0.forceFinished(true);
            }
        }
        if (i4 != 0) {
            this.f6824F.setVisibility(0);
            this.f6828H.setVisibility(0);
        }
        if (i4 != 0) {
            this.f6875y0 = (getHeight() - this.f6877z0) + this.f6815A0;
        } else {
            this.f6824F.setVisibility(8);
            this.f6828H.setVisibility(8);
        }
    }

    public final boolean g0() {
        return this.f6854h0;
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a.C0055a(8388627);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a.C0055a(getContext(), attributeSet);
    }

    public final boolean h0() {
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        return bVar != null && bVar.m();
    }

    @Override // miuix.appcompat.internal.app.widget.c
    public final void i(int i2) {
        ActionBarContextView actionBarContextView;
        super.j(i2, false);
        if (!(getParent() instanceof ActionBarContainer) || (actionBarContextView = (ActionBarContextView) ((ActionBarContainer) getParent()).findViewById(R.id.action_context_bar)) == null) {
            return;
        }
        actionBarContextView.j(i2, false);
    }

    public final boolean i0() {
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        return bVar != null && bVar.n();
    }

    public final boolean k0() {
        return this.f6853g0 && C0386a.b(this.f6876z).h();
    }

    @Override // miuix.appcompat.internal.app.widget.c
    public final void l(boolean z4) throws Resources.NotFoundException {
        if (this.f6934l != z4) {
            miuix.appcompat.internal.view.menu.action.c cVar = this.f6931i;
            if (cVar != null) {
                ViewGroup viewGroup = (ViewGroup) cVar.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f6931i);
                }
                if (z4) {
                    ActionBarContainer actionBarContainer = this.f6933k;
                    if (actionBarContainer != null) {
                        actionBarContainer.addView(this.f6931i);
                    }
                    this.f6931i.getLayoutParams().width = -1;
                } else {
                    addView(this.f6931i);
                    this.f6931i.getLayoutParams().width = -2;
                }
                this.f6931i.requestLayout();
            }
            ActionBarContainer actionBarContainer2 = this.f6933k;
            if (actionBarContainer2 != null) {
                actionBarContainer2.setVisibility(z4 ? 0 : 8);
            }
            miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
            if (bVar != null) {
                if (z4) {
                    bVar.r(getContext().getResources().getDisplayMetrics().widthPixels);
                } else {
                    getResources().getBoolean(R.bool.abc_action_bar_expanded_action_views_exclusive);
                }
            }
            this.f6934l = z4;
        }
    }

    @Override // miuix.appcompat.internal.app.widget.c
    public final boolean m() {
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        return bVar != null && bVar.s();
    }

    public final void n0() {
        this.f6831I0 = false;
        this.f6833J0 = false;
        if (super.b() == 0) {
            this.f6819C0.e(1.0f);
            this.f6821D0.e(0.0f);
        } else if (super.b() == 1) {
            this.f6819C0.e(0.0f);
            this.f6821D0.e(1.0f);
        }
        View view = this.f6842S;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        AppCompatImageView appCompatImageView = this.f6834K;
        if (appCompatImageView != null) {
            appCompatImageView.setAlpha(1.0f);
        }
    }

    public final void o0(boolean z4) {
        this.f6831I0 = true;
        this.f6833J0 = z4;
        this.f6819C0.e(0.0f);
        this.f6821D0.e(0.0f);
        View view = this.f6842S;
        if (view != null) {
            view.setAlpha(0.0f);
        }
        AppCompatImageView appCompatImageView = this.f6834K;
        if (appCompatImageView != null) {
            appCompatImageView.setAlpha(0.0f);
        }
    }

    @Override // miuix.appcompat.internal.app.widget.c, android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        super.onConfigurationChanged(configuration);
        this.p0 = true;
        K0();
        if ((this.f6865t & 8) != 0) {
            this.f6830I.k(configuration);
            this.f6832J.d();
        }
        this.f6845V = getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_title_horizontal_padding);
        this.f6824F.setPaddingRelative(this.f6845V, getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_title_top_padding), this.f6845V, TextUtils.isEmpty(this.f6868v) ? this.f6848b0 : this.f6849c0);
        setPaddingRelative(C0431a.d(getContext(), R.attr.actionBarPaddingStart), getPaddingTop(), C0431a.d(getContext(), R.attr.actionBarPaddingEnd), getPaddingBottom());
        ScrollingTabContainerView scrollingTabContainerView = this.L;
        if (scrollingTabContainerView != null && this.f6853g0 && (layoutParams4 = scrollingTabContainerView.getLayoutParams()) != null) {
            layoutParams4.width = -2;
            layoutParams4.height = -1;
        }
        ScrollingTabContainerView scrollingTabContainerView2 = this.M;
        if (scrollingTabContainerView2 != null && this.f6853g0 && (layoutParams3 = scrollingTabContainerView2.getLayoutParams()) != null) {
            layoutParams3.width = -2;
            layoutParams3.height = -2;
        }
        ScrollingTabContainerView scrollingTabContainerView3 = this.f6838N;
        if (scrollingTabContainerView3 != null && this.f6853g0 && (layoutParams2 = scrollingTabContainerView3.getLayoutParams()) != null) {
            layoutParams2.width = -2;
            layoutParams2.height = -1;
        }
        ScrollingTabContainerView scrollingTabContainerView4 = this.f6839O;
        if (scrollingTabContainerView4 == null || !this.f6853g0 || (layoutParams = scrollingTabContainerView4.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = -2;
        layoutParams.height = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        if (bVar != null) {
            bVar.k(false);
            this.f6932j.l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c5 A[PHI: r18
      0x01c5: PHI (r18v2 int) = (r18v1 int), (r18v9 int), (r18v9 int) binds: [B:39:0x00bb, B:73:0x016b, B:81:0x018c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        int marginStart;
        int paddingEnd;
        miuix.appcompat.internal.view.menu.action.c cVar;
        View view;
        ProgressBar progressBar;
        View view2;
        View view3;
        int i9;
        NestedScrollView nestedScrollView;
        int i10;
        int i11;
        int i12;
        int marginStart2;
        int i13;
        int measuredWidth;
        int measuredHeight = this.f6820D.getMeasuredHeight();
        View view4 = this.P;
        if (view4 != null && view4.getParent() != null) {
            measuredHeight = this.P.getMeasuredHeight();
        }
        int i14 = measuredHeight;
        int measuredHeight2 = this.f6826G.getParent() == null ? 0 : this.f6826G.getMeasuredHeight();
        int measuredHeight3 = this.f6824F.getMeasuredHeight();
        int measuredHeight4 = this.f6828H.getParent() == null ? 0 : this.f6828H.getMeasuredHeight();
        int i15 = this.p;
        int i16 = (i6 - i4) - measuredHeight4;
        int i17 = i16 - (i15 == 2 ? this.f6875y0 : i15 == 1 ? measuredHeight3 + measuredHeight4 : 0);
        float f4 = ((measuredHeight3 + measuredHeight4) - r1) / measuredHeight3;
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        boolean z7 = getLayoutDirection() == 1;
        int paddingTop2 = (i14 - getPaddingTop()) - getPaddingBottom();
        if (paddingTop2 <= 0) {
            i9 = measuredHeight4;
        } else {
            HomeView homeView = this.f6860n0 != null ? this.f6818C : this.f6816B;
            if (homeView == null || homeView.getVisibility() == 8) {
                i7 = 8;
                z5 = z7;
                i8 = paddingTop;
            } else {
                i7 = 8;
                z5 = z7;
                i8 = paddingTop;
                paddingStart = g(homeView, paddingStart + 0, paddingTop, paddingTop2, false) + 0 + paddingStart;
            }
            if (this.f6860n0 != null) {
                z6 = z5;
                marginStart = paddingStart;
                paddingEnd = (i5 - i2) - getPaddingEnd();
                cVar = this.f6931i;
                if (cVar != null && cVar.getParent() == this) {
                    h(this.f6931i, paddingEnd);
                    paddingEnd -= this.f6931i.getMeasuredWidth();
                }
                view = this.f6842S;
                if (view != null) {
                    h(view, paddingEnd);
                    paddingEnd -= this.f6842S.getMeasuredWidth();
                }
                progressBar = this.f6840Q;
                if (progressBar != null && progressBar.getVisibility() != i7) {
                    h(this.f6840Q, paddingEnd - this.f6843T);
                    paddingEnd -= this.f6840Q.getMeasuredWidth() - (this.f6843T * 2);
                }
                view2 = this.f6841R;
                if (view2 != null && view2.getVisibility() != i7) {
                    h(this.f6841R, paddingEnd);
                    paddingEnd -= this.f6841R.getMeasuredWidth();
                }
                view3 = this.f6860n0;
                if (view3 == null && ((this.f6865t & 16) == 0 || (view3 = this.P) == null)) {
                    view3 = null;
                }
                if (view3 != null || view3.getVisibility() == i7) {
                    i9 = measuredHeight4;
                } else {
                    ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                    a.C0055a c0055a = layoutParams instanceof a.C0055a ? (a.C0055a) layoutParams : null;
                    int i18 = c0055a != null ? c0055a.f2312a : 8388627;
                    int measuredWidth2 = view3.getMeasuredWidth();
                    if (c0055a != null) {
                        marginStart = c0055a.getMarginStart() + marginStart;
                        paddingEnd -= c0055a.getMarginEnd();
                        i11 = ((ViewGroup.MarginLayoutParams) c0055a).topMargin;
                        i12 = ((ViewGroup.MarginLayoutParams) c0055a).bottomMargin;
                    } else {
                        i11 = 0;
                        i12 = 0;
                    }
                    int i19 = i18 & 8388615;
                    i9 = measuredHeight4;
                    if (i19 == 1) {
                        int width = (getWidth() - measuredWidth2) / 2;
                        if (width < marginStart) {
                            i19 = 8388611;
                        } else if (width + measuredWidth2 > paddingEnd) {
                            i19 = 8388613;
                        }
                        int paddingStart2 = getPaddingStart();
                        int iM0 = m0(i19, z6);
                        int width2 = iM0 == 1 ? iM0 != 8388611 ? iM0 != 8388613 ? paddingStart2 : paddingEnd - measuredWidth2 : marginStart : (getWidth() - measuredWidth2) / 2;
                        int i20 = i18 & 112;
                        if (i18 == -1) {
                            i20 = 16;
                        }
                        int height = i20 == 16 ? i20 != 48 ? i20 != 80 ? 0 : ((getHeight() - getPaddingBottom()) - view3.getMeasuredHeight()) - i12 : getPaddingTop() + i11 : (((getHeight() - getPaddingBottom()) - getPaddingTop()) - view3.getMeasuredHeight()) / 2;
                        int measuredWidth3 = view3.getMeasuredWidth();
                        view3.layout(!z6 ? (getWidth() - width2) - measuredWidth3 : width2, height, !z6 ? getWidth() - width2 : measuredWidth3 + width2, view3.getMeasuredHeight() + height);
                    } else {
                        if (i18 == -1) {
                        }
                        int paddingStart22 = getPaddingStart();
                        int iM02 = m0(i19, z6);
                        if (iM02 == 1) {
                        }
                        int i202 = i18 & 112;
                        if (i18 == -1) {
                        }
                        if (i202 == 16) {
                        }
                        int measuredWidth32 = view3.getMeasuredWidth();
                        view3.layout(!z6 ? (getWidth() - width2) - measuredWidth32 : width2, height, !z6 ? getWidth() - width2 : measuredWidth32 + width2, view3.getMeasuredHeight() + height);
                    }
                }
                nestedScrollView = this.f6826G;
                if (nestedScrollView != null && nestedScrollView.getChildCount() != 0) {
                    int i21 = this.f6845V;
                    int i22 = i2 + i21;
                    int i23 = i5 - i21;
                    int measuredWidth4 = this.f6838N.getMeasuredWidth();
                    S2.d.k(this, this.f6826G, i22, i14, i23, i14 + measuredHeight2);
                    float fMax = Math.max(0, ((i23 - i22) - measuredWidth4) / 2);
                    if (getLayoutDirection() != 1) {
                        fMax = -fMax;
                    }
                    this.f6838N.setTranslationX(fMax);
                    if (getLayoutDirection() != 1) {
                        i10 = 0;
                    } else {
                        int i24 = i5 - (this.f6845V * 2);
                        i10 = i24 - measuredWidth4;
                        measuredWidth4 = i24;
                    }
                    ScrollingTabContainerView scrollingTabContainerView = this.f6838N;
                    scrollingTabContainerView.layout(i10, 0, measuredWidth4, scrollingTabContainerView.getMeasuredHeight());
                }
            } else {
                boolean zJ0 = j0();
                if (zJ0) {
                    AppCompatImageView appCompatImageView = this.f6834K;
                    if (appCompatImageView != null) {
                        paddingStart += g(appCompatImageView, paddingStart, i8, paddingTop2, false);
                    }
                    if (l0()) {
                        FrameLayout frameLayout = this.f6820D;
                        if (frameLayout == null || frameLayout.getVisibility() == i7) {
                            marginStart2 = paddingStart;
                        } else {
                            FrameLayout frameLayout2 = this.f6820D;
                            int width3 = (getWidth() - frameLayout2.getMeasuredWidth()) / 2;
                            ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
                            marginStart2 = width3 - (layoutParams2 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams2).getMarginStart() + 0 : 0);
                        }
                        this.p0 = (this.f6830I == null || TextUtils.isEmpty(this.u) || ((super.c() || super.b() != 0) && !this.f6830I.e(this.u.toString()))) ? false : true;
                        K0();
                        int measuredWidth5 = this.f6820D.getMeasuredWidth() + marginStart2;
                        int measuredHeight5 = this.f6820D.getMeasuredHeight();
                        int i25 = ((paddingTop2 - measuredHeight5) / 2) + i8;
                        S2.d.k(this, this.f6820D, marginStart2, i25, measuredWidth5, i25 + measuredHeight5);
                    } else {
                        paddingStart += g(this.f6820D, paddingStart, i8, paddingTop2, true);
                    }
                }
                if (this.f6863s == 2) {
                    ScrollingTabContainerView scrollingTabContainerView2 = (this.f6820D.getChildCount() == 1 && (this.f6820D.getChildAt(0) instanceof ScrollingTabContainerView)) ? (ScrollingTabContainerView) this.f6820D.getChildAt(0) : null;
                    if (scrollingTabContainerView2 != null) {
                        int measuredWidth6 = scrollingTabContainerView2.getMeasuredWidth();
                        int measuredHeight6 = scrollingTabContainerView2.getMeasuredHeight();
                        int width4 = (getWidth() - measuredWidth6) / 2;
                        marginStart = (getWidth() + measuredWidth6) / 2;
                        if (zJ0) {
                            int i26 = this.f6844U;
                            width4 += i26;
                            marginStart -= i26;
                        }
                        z6 = z5;
                        int i27 = i8;
                        this.f6820D.layout(z6 ? getWidth() - marginStart : width4, i27, z6 ? getWidth() - width4 : marginStart, measuredHeight6 + i27);
                    }
                    paddingEnd = (i5 - i2) - getPaddingEnd();
                    cVar = this.f6931i;
                    if (cVar != null) {
                        h(this.f6931i, paddingEnd);
                        paddingEnd -= this.f6931i.getMeasuredWidth();
                    }
                    view = this.f6842S;
                    if (view != null) {
                    }
                    progressBar = this.f6840Q;
                    if (progressBar != null) {
                        h(this.f6840Q, paddingEnd - this.f6843T);
                        paddingEnd -= this.f6840Q.getMeasuredWidth() - (this.f6843T * 2);
                    }
                    view2 = this.f6841R;
                    if (view2 != null) {
                        h(this.f6841R, paddingEnd);
                        paddingEnd -= this.f6841R.getMeasuredWidth();
                    }
                    view3 = this.f6860n0;
                    if (view3 == null) {
                        view3 = null;
                    }
                    if (view3 != null) {
                        i9 = measuredHeight4;
                        nestedScrollView = this.f6826G;
                        if (nestedScrollView != null) {
                            int i212 = this.f6845V;
                            int i222 = i2 + i212;
                            int i232 = i5 - i212;
                            int measuredWidth42 = this.f6838N.getMeasuredWidth();
                            S2.d.k(this, this.f6826G, i222, i14, i232, i14 + measuredHeight2);
                            float fMax2 = Math.max(0, ((i232 - i222) - measuredWidth42) / 2);
                            if (getLayoutDirection() != 1) {
                            }
                            this.f6838N.setTranslationX(fMax2);
                            if (getLayoutDirection() != 1) {
                            }
                            ScrollingTabContainerView scrollingTabContainerView3 = this.f6838N;
                            scrollingTabContainerView3.layout(i10, 0, measuredWidth42, scrollingTabContainerView3.getMeasuredHeight());
                        }
                    }
                }
            }
        }
        if (a0()) {
            if (this.p == 2) {
                int i28 = f4 < 1.0f ? 0 : 4;
                FrameLayout frameLayout3 = this.f6824F;
                if (frameLayout3 != null && frameLayout3.getVisibility() != i28) {
                    this.f6824F.setVisibility(i28);
                }
                NestedScrollView nestedScrollView2 = this.f6828H;
                if (nestedScrollView2 != null && nestedScrollView2.getVisibility() != i28) {
                    this.f6828H.setVisibility(i28);
                }
            }
            int i29 = 1.0f - Math.min(1.0f, f4 * 3.0f) <= 0.0f ? this.f6815A0 : 0;
            FrameLayout frameLayout4 = this.f6824F;
            int measuredHeight7 = (frameLayout4 == null || frameLayout4.getVisibility() != 0) ? 0 : this.f6824F.getMeasuredHeight();
            NestedScrollView nestedScrollView3 = this.f6828H;
            int measuredHeight8 = (nestedScrollView3 == null || nestedScrollView3.getParent() == null || this.f6828H.getVisibility() != 0) ? 0 : this.f6828H.getMeasuredHeight();
            int i30 = (((i17 + measuredHeight7) + measuredHeight8) - i16) + i29;
            FrameLayout frameLayout5 = this.f6824F;
            if (frameLayout5 != null && frameLayout5.getVisibility() == 0 && this.p != 0) {
                this.f6824F.layout(i2, i16 - measuredHeight7, i5, i16);
                ScrollingTabContainerView scrollingTabContainerView4 = (this.f6824F.getChildCount() == 1 && (this.f6824F.getChildAt(0) instanceof ScrollingTabContainerView)) ? (ScrollingTabContainerView) this.f6824F.getChildAt(0) : null;
                if (scrollingTabContainerView4 != null) {
                    int measuredWidth7 = this.f6845V;
                    if (getLayoutDirection() == 1) {
                        measuredWidth7 = (i5 - this.f6845V) - scrollingTabContainerView4.getMeasuredWidth();
                    }
                    scrollingTabContainerView4.layout(measuredWidth7, this.f6847a0, scrollingTabContainerView4.getMeasuredWidth() + measuredWidth7, scrollingTabContainerView4.getMeasuredHeight() + this.f6847a0);
                }
                FrameLayout frameLayout6 = this.f6824F;
                Rect rect = new Rect();
                rect.set(i2, i30, i5, measuredHeight7 + measuredHeight8);
                frameLayout6.setClipBounds(rect);
            }
            NestedScrollView nestedScrollView4 = this.f6828H;
            if (nestedScrollView4 != null && nestedScrollView4.getChildCount() != 0 && this.p != 0) {
                NestedScrollView nestedScrollView5 = this.f6828H;
                int i31 = i16 + i9;
                S2.d.k(this, nestedScrollView5, this.f6846W + i2, i31 - nestedScrollView5.getMeasuredHeight(), i5 - this.f6846W, i31);
                ScrollingTabContainerView scrollingTabContainerView5 = (this.f6828H.getChildCount() == 1 && (this.f6828H.getChildAt(0) instanceof ScrollingTabContainerView)) ? (ScrollingTabContainerView) this.f6828H.getChildAt(0) : null;
                if (scrollingTabContainerView5 != null) {
                    int measuredWidth8 = scrollingTabContainerView5.getMeasuredWidth();
                    if (getLayoutDirection() == 1) {
                        measuredWidth = (i5 - (this.f6846W * 2)) - scrollingTabContainerView5.getMeasuredWidth();
                        measuredWidth8 = i5 - (this.f6846W * 2);
                    } else {
                        measuredWidth = 0;
                    }
                    scrollingTabContainerView5.layout(measuredWidth, 0, measuredWidth8, scrollingTabContainerView5.getMeasuredHeight());
                }
                NestedScrollView nestedScrollView6 = this.f6828H;
                Rect rect2 = new Rect();
                rect2.set(i2, i30 - (measuredHeight7 - measuredHeight8), i5, measuredHeight7 + measuredHeight8);
                nestedScrollView6.setClipBounds(rect2);
            }
        }
        float fMin = 1.0f - Math.min(1.0f, f4 * 3.0f);
        int i32 = this.p;
        if (i32 != 2) {
            if (i32 == 1) {
                this.f6819C0.a(0.0f, 20, this.f6862r0);
                this.f6821D0.a(this.f6831I0 ? 0.0f : 1.0f, 0, null);
                return;
            } else {
                if (i32 == 0) {
                    this.f6819C0.a(this.f6831I0 ? 0.0f : 1.0f, 0, this.q0);
                    this.f6821D0.a(0.0f, 0, null);
                    return;
                }
                return;
            }
        }
        if (fMin <= 0.0f) {
            i13 = 0;
            if (!this.f6871w0) {
                this.f6871w0 = true;
                this.f6873x0 = false;
                this.f6819C0.a(this.f6831I0 ? 0.0f : 1.0f, 0, this.q0);
            }
        } else if (this.f6873x0) {
            i13 = 0;
        } else {
            this.f6873x0 = true;
            i13 = 0;
            this.f6871w0 = false;
            this.f6819C0.a(0.0f, 20, this.f6862r0);
        }
        this.f6821D0.a(this.f6831I0 ? 0.0f : fMin, i13, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x035d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onMeasure(int i2, int i4) {
        int i5;
        int iMax;
        miuix.appcompat.internal.view.menu.action.c cVar;
        ProgressBar progressBar;
        View view;
        boolean zJ0;
        View view2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        NestedScrollView nestedScrollView;
        int i12;
        int i13;
        int i14;
        NestedScrollView nestedScrollView2;
        int measuredHeight;
        int i15;
        int i16;
        int i17;
        int i18;
        int iMax2;
        C0378b c0378b;
        C0378b c0378b2;
        miuix.appcompat.internal.view.menu.action.c cVar2;
        int childCount = getChildCount();
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (childAt.getVisibility() != 8 && (childAt != (cVar2 = this.f6931i) || cVar2.getChildCount() != 0)) {
                i19++;
            }
        }
        if (i19 == 0) {
            setMeasuredDimension(0, 0);
            this.f6854h0 = true;
            return;
        }
        this.f6854h0 = false;
        int size = View.MeasureSpec.getSize(i2);
        int i21 = this.f6936n;
        if (!TextUtils.isEmpty(this.u) && !TextUtils.isEmpty(this.f6868v) && (c0378b2 = this.f6830I) != null && c0378b2.e(this.u.toString())) {
            i21 = this.f6937o;
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int size2 = (i21 > 0 ? i21 : View.MeasureSpec.getSize(i4)) - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
        int iD = (size - paddingStart) - paddingEnd;
        int iMax3 = iD / 2;
        View view3 = this.f6842S;
        if (view3 != null) {
            iD = d(view3, iD, iMakeMeasureSpec2, 0);
            paddingEnd += this.f6842S.getMeasuredWidth();
        }
        HomeView homeView = this.f6860n0 != null ? this.f6818C : this.f6816B;
        if (homeView == null) {
            i5 = 0;
        } else {
            if (homeView.getVisibility() != 8) {
                int i22 = homeView.getLayoutParams().width;
                homeView.measure(i22 < 0 ? View.MeasureSpec.makeMeasureSpec(iD, Integer.MIN_VALUE) : View.MeasureSpec.makeMeasureSpec(i22, 1073741824), iMakeMeasureSpec);
                int measuredWidth = homeView.getMeasuredWidth();
                i5 = 0;
                int i23 = measuredWidth + 0;
                iD = Math.max(0, iD - i23);
                iMax = Math.max(0, iD - i23);
                paddingStart += i23;
                cVar = this.f6931i;
                if (cVar != null && cVar.getParent() == this) {
                    iD = d(this.f6931i, iD, iMakeMeasureSpec2, i5);
                    iMax3 = Math.max(i5, iMax3 - this.f6931i.getMeasuredWidth());
                    paddingEnd += this.f6931i.getMeasuredWidth();
                }
                progressBar = this.f6840Q;
                if (progressBar != null && progressBar.getVisibility() != 8) {
                    iD = d(this.f6840Q, iD, iMakeMeasureSpec2, this.f6843T * 2);
                    iMax3 = Math.max(0, (iMax3 - this.f6840Q.getMeasuredWidth()) - (this.f6843T * 2));
                    paddingEnd += this.f6840Q.getMeasuredWidth();
                }
                view = this.f6841R;
                if (view != null && view.getVisibility() != 8) {
                    iD = d(this.f6841R, iD, iMakeMeasureSpec2, 0);
                    iMax3 = Math.max(0, iMax3 - this.f6841R.getMeasuredWidth());
                    paddingEnd += this.f6841R.getMeasuredWidth();
                }
                int i24 = iMax3;
                zJ0 = j0();
                if (zJ0 && (c0378b = this.f6830I) != null) {
                    c0378b.t(l0());
                }
                view2 = this.f6860n0;
                if (view2 == null && ((this.f6865t & 16) == 0 || (view2 = this.P) == null)) {
                    view2 = null;
                }
                if (this.f6842S != null && view2 != null) {
                    view2.setVisibility(8);
                }
                if (view2 != null || view2.getVisibility() == 8) {
                    i6 = childCount;
                    i7 = size;
                    i8 = paddingBottom;
                } else {
                    ViewGroup.LayoutParams layoutParamsGenerateLayoutParams = generateLayoutParams(view2.getLayoutParams());
                    a.C0055a c0055a = layoutParamsGenerateLayoutParams instanceof a.C0055a ? (a.C0055a) layoutParamsGenerateLayoutParams : null;
                    if (c0055a != null) {
                        i8 = paddingBottom;
                        i17 = ((ViewGroup.MarginLayoutParams) c0055a).leftMargin + ((ViewGroup.MarginLayoutParams) c0055a).rightMargin;
                        i16 = ((ViewGroup.MarginLayoutParams) c0055a).bottomMargin + ((ViewGroup.MarginLayoutParams) c0055a).topMargin;
                    } else {
                        i8 = paddingBottom;
                        i16 = 0;
                        i17 = 0;
                    }
                    if (i21 <= 0) {
                        i6 = childCount;
                    } else {
                        i6 = childCount;
                        int i25 = layoutParamsGenerateLayoutParams.height != -2 ? 1073741824 : Integer.MIN_VALUE;
                        i18 = layoutParamsGenerateLayoutParams.height;
                        if (i18 >= 0) {
                            size2 = Math.min(i18, size2);
                        }
                        int iMax4 = Math.max(0, size2 - i16);
                        int i26 = layoutParamsGenerateLayoutParams.width;
                        int i27 = i26 == -2 ? 1073741824 : Integer.MIN_VALUE;
                        i7 = size;
                        iMax2 = Math.max(0, (i26 < 0 ? Math.min(i26, iD) : iD) - i17);
                        if (((c0055a == null ? c0055a.f2312a : 8388627) & 8388615) == 1 && layoutParamsGenerateLayoutParams.width == -1) {
                            iMax2 = Math.min(iMax, i24) * 2;
                        }
                        view2.measure(View.MeasureSpec.makeMeasureSpec(iMax2, i27), View.MeasureSpec.makeMeasureSpec(iMax4, i25));
                        iD -= view2.getMeasuredWidth() + i17;
                    }
                    i18 = layoutParamsGenerateLayoutParams.height;
                    if (i18 >= 0) {
                    }
                    int iMax42 = Math.max(0, size2 - i16);
                    int i262 = layoutParamsGenerateLayoutParams.width;
                    if (i262 == -2) {
                    }
                    i7 = size;
                    iMax2 = Math.max(0, (i262 < 0 ? Math.min(i262, iD) : iD) - i17);
                    if (((c0055a == null ? c0055a.f2312a : 8388627) & 8388615) == 1) {
                        iMax2 = Math.min(iMax, i24) * 2;
                    }
                    view2.measure(View.MeasureSpec.makeMeasureSpec(iMax2, i27), View.MeasureSpec.makeMeasureSpec(iMax42, i25));
                    iD -= view2.getMeasuredWidth() + i17;
                }
                if (this.f6860n0 == null || !zJ0) {
                    i9 = 1073741824;
                } else {
                    i9 = 1073741824;
                    int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i21, 1073741824);
                    if (this.f6834K != null) {
                        iD = d(this.f6834K, iD, View.MeasureSpec.makeMeasureSpec(i21, Integer.MIN_VALUE), 0);
                        paddingStart += this.f6834K.getMeasuredWidth();
                    }
                    if (l0()) {
                        this.f6820D.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, i7 - (Math.max(paddingStart, paddingEnd) * 2)), Integer.MIN_VALUE), iMakeMeasureSpec3);
                        this.f6820D.getMeasuredWidth();
                    } else {
                        d(this.f6820D, iD, iMakeMeasureSpec3, 0);
                    }
                }
                if (this.f6824F.getChildCount() == 0) {
                    i10 = i7;
                    i11 = 0;
                    this.f6824F.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, a0() ? 0 : i9));
                } else {
                    i10 = i7;
                    i11 = 0;
                }
                this.f6817B0 = i11;
                nestedScrollView = this.f6828H;
                if (nestedScrollView == null && nestedScrollView.getVisibility() == 0 && this.f6828H.getChildCount() != 0) {
                    this.f6828H.measure(View.MeasureSpec.makeMeasureSpec(i11, i11), View.MeasureSpec.makeMeasureSpec(i11, i11));
                    int measuredWidth2 = this.f6828H.getMeasuredWidth();
                    int measuredHeight2 = this.f6828H.getMeasuredHeight();
                    this.f6817B0 = measuredHeight2;
                    i14 = 0;
                    i13 = measuredWidth2;
                    i12 = measuredHeight2;
                } else {
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                }
                this.f6815A0 = i14;
                nestedScrollView2 = this.f6826G;
                if (nestedScrollView2 != null || nestedScrollView2.getParent() == null || this.f6826G.getChildCount() == 0) {
                    measuredHeight = 0;
                } else {
                    this.f6826G.measure(View.MeasureSpec.makeMeasureSpec(i14, i14), View.MeasureSpec.makeMeasureSpec(i14, i14));
                    this.f6826G.getMeasuredWidth();
                    measuredHeight = this.f6826G.getMeasuredHeight();
                    this.f6815A0 = measuredHeight;
                }
                if (this.f6860n0 == null || this.f6863s != 2) {
                    i15 = 0;
                } else {
                    ScrollingTabContainerView scrollingTabContainerView = this.f6838N;
                    if (scrollingTabContainerView != null && scrollingTabContainerView.getParent() != null) {
                        this.f6838N.measure(View.MeasureSpec.makeMeasureSpec(i10 - (this.f6845V * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                    }
                    ScrollingTabContainerView scrollingTabContainerView2 = this.f6839O;
                    if (scrollingTabContainerView2 != null && scrollingTabContainerView2.getParent() != null) {
                        i15 = 0;
                        this.f6839O.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, Math.min(i13, i10 - (this.f6846W * 2))), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                    }
                }
                if (i21 > 0) {
                    int i28 = i15;
                    int i29 = i6;
                    while (i15 < i29) {
                        int measuredHeight3 = getChildAt(i15).getMeasuredHeight() + i8;
                        if (measuredHeight3 > i28) {
                            i28 = measuredHeight3;
                        }
                        i15++;
                    }
                    setMeasuredDimension(i10, i28);
                    return;
                }
                int i30 = measuredHeight + i21;
                this.f6877z0 = i30;
                int measuredHeight4 = a0() ? this.f6824F.getMeasuredHeight() : i15;
                int i31 = this.p;
                if (i31 == 2) {
                    setMeasuredDimension(i10, Math.max(i21 + this.f6875y0, i30));
                    return;
                } else if (i31 == 1) {
                    setMeasuredDimension(i10, i21 + measuredHeight4 + i12);
                    return;
                } else {
                    setMeasuredDimension(i10, i30);
                    return;
                }
            }
            i5 = 0;
        }
        iMax = iMax3;
        cVar = this.f6931i;
        if (cVar != null) {
            iD = d(this.f6931i, iD, iMakeMeasureSpec2, i5);
            iMax3 = Math.max(i5, iMax3 - this.f6931i.getMeasuredWidth());
            paddingEnd += this.f6931i.getMeasuredWidth();
        }
        progressBar = this.f6840Q;
        if (progressBar != null) {
            iD = d(this.f6840Q, iD, iMakeMeasureSpec2, this.f6843T * 2);
            iMax3 = Math.max(0, (iMax3 - this.f6840Q.getMeasuredWidth()) - (this.f6843T * 2));
            paddingEnd += this.f6840Q.getMeasuredWidth();
        }
        view = this.f6841R;
        if (view != null) {
            iD = d(this.f6841R, iD, iMakeMeasureSpec2, 0);
            iMax3 = Math.max(0, iMax3 - this.f6841R.getMeasuredWidth());
            paddingEnd += this.f6841R.getMeasuredWidth();
        }
        int i242 = iMax3;
        zJ0 = j0();
        if (zJ0) {
            c0378b.t(l0());
        }
        view2 = this.f6860n0;
        if (view2 == null) {
            view2 = null;
        }
        if (this.f6842S != null) {
            view2.setVisibility(8);
        }
        if (view2 != null) {
            i6 = childCount;
            i7 = size;
            i8 = paddingBottom;
        }
        if (this.f6860n0 == null) {
            i9 = 1073741824;
        }
        if (this.f6824F.getChildCount() == 0) {
        }
        this.f6817B0 = i11;
        nestedScrollView = this.f6828H;
        if (nestedScrollView == null) {
            i12 = 0;
            i13 = 0;
            i14 = 0;
        }
        this.f6815A0 = i14;
        nestedScrollView2 = this.f6826G;
        if (nestedScrollView2 != null) {
            measuredHeight = 0;
        }
        if (this.f6860n0 == null) {
            i15 = 0;
        }
        if (i21 > 0) {
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuBuilder menuBuilder;
        MenuItem menuItemFindItem;
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.getSuperState());
        int i2 = jVar.f6896i;
        if (i2 != 0 && this.f6859m0 != null && (menuBuilder = this.f6856j0) != null && (menuItemFindItem = menuBuilder.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (jVar.f6897j) {
            post(new miuix.appcompat.internal.app.widget.a(this));
        }
        i(jVar.f6898k);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        j jVar = new j(super.onSaveInstanceState());
        i iVar = this.f6859m0;
        if (iVar == null || (menuItemImpl = iVar.f6894j) == null) {
            jVar.f6896i = 0;
        } else {
            jVar.f6896i = menuItemImpl.getItemId();
        }
        miuix.appcompat.internal.view.menu.action.b bVar = this.f6932j;
        jVar.f6897j = bVar != null && bVar.m();
        int i2 = this.p;
        if (i2 == 2) {
            jVar.f6898k = 0;
        } else {
            jVar.f6898k = i2;
        }
        return jVar;
    }

    public final void p0(int i2, int[] iArr, int[] iArr2) {
        if (i2 <= 0 || getHeight() <= this.f6877z0) {
            return;
        }
        int height = getHeight() - i2;
        int i4 = this.f6875y0;
        if (height >= this.f6877z0) {
            this.f6875y0 = i4 - i2;
            iArr[1] = iArr[1] + i2;
        } else {
            this.f6875y0 = 0;
            iArr[1] = ((getHeight() - this.f6877z0) - this.f6815A0) + iArr[1];
        }
        int i5 = this.f6875y0;
        if (i5 != i4) {
            iArr2[1] = i4 - i5;
            requestLayout();
        }
    }

    public final void q0(int i2, int[] iArr, int[] iArr2) {
        int measuredHeight = this.f6824F.getMeasuredHeight() + this.f6817B0;
        int i4 = (this.f6877z0 - this.f6815A0) + measuredHeight;
        int height = getHeight();
        if (i2 >= 0 || height >= i4) {
            return;
        }
        int i5 = this.f6875y0;
        if (height - i2 <= i4) {
            this.f6875y0 = i5 - i2;
            iArr[1] = iArr[1] + i2;
        } else {
            this.f6875y0 = measuredHeight;
            iArr[1] = iArr[1] + (-(i4 - height));
        }
        int i6 = this.f6875y0;
        if (i6 != i5) {
            iArr2[1] = i5 - i6;
            requestLayout();
        }
    }

    public final void r0(int i2) {
        if (i2 == 0) {
            this.f6823E0 = true;
        } else {
            this.f6825F0 = true;
        }
        if (!this.f6827G0.isFinished()) {
            this.f6827G0.forceFinished(true);
        }
        i(2);
    }

    public final boolean s0() {
        if (getContext().getResources().getConfiguration().orientation != 2) {
            return this.f6860n0 == null && j0() && super.c();
        }
        getContext();
        int i2 = C0432b.f8169a;
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t0() {
        boolean z4;
        int measuredHeight = this.f6824F.getMeasuredHeight();
        if (this.f6823E0) {
            this.f6823E0 = false;
            z4 = !this.f6825F0;
        } else {
            if (this.f6825F0) {
                this.f6825F0 = false;
            }
        }
        if (z4) {
            int i2 = this.f6875y0;
            if (i2 == 0) {
                i(0);
                return;
            }
            if (i2 == this.f6817B0 + measuredHeight) {
                i(1);
                return;
            }
            if (getHeight() > ((this.f6817B0 + measuredHeight) / 2) + this.f6877z0) {
                this.f6827G0.startScroll(0, getHeight(), 0, (this.f6877z0 + measuredHeight) - getHeight());
            } else {
                this.f6827G0.startScroll(0, getHeight(), 0, this.f6877z0 - getHeight());
            }
            postOnAnimation(this.f6837M0);
        }
    }

    public final void v0(int i2) {
        View view;
        int i4 = this.f6865t;
        int i5 = i4 != -1 ? i2 ^ i4 : -1;
        this.f6865t = i2;
        if ((i5 & 31) != 0) {
            boolean z4 = (i2 & 2) != 0;
            if (z4) {
                if (this.f6816B == null) {
                    HomeView homeView = (HomeView) LayoutInflater.from(this.f6876z).inflate(this.f6814A, (ViewGroup) this, false);
                    this.f6816B = homeView;
                    homeView.setOnClickListener(this.f6866t0);
                    this.f6816B.setClickable(true);
                    this.f6816B.setFocusable(true);
                    addView(this.f6816B);
                }
                this.f6816B.setVisibility(this.f6860n0 == null ? 0 : 8);
                if ((i5 & 4) != 0) {
                    boolean z5 = (i2 & 4) != 0;
                    this.f6816B.b(z5);
                    if (z5) {
                        y0(true);
                    }
                }
                if ((i5 & 1) != 0) {
                    if ((this.f6870w & 2) != 2) {
                        Context context = this.f6876z;
                        if (context instanceof Activity) {
                            try {
                                this.f6874y = context.getPackageManager().getActivityLogo(((Activity) this.f6876z).getComponentName());
                            } catch (PackageManager.NameNotFoundException e2) {
                                Log.e("ActionBarView", "Activity component name not found!", e2);
                            }
                        }
                        if (this.f6874y == null) {
                            this.f6874y = this.f6876z.getApplicationInfo().loadLogo(this.f6876z.getPackageManager());
                        }
                        this.f6870w |= 2;
                    }
                    Drawable drawableX = this.f6874y;
                    boolean z6 = (drawableX == null || (i2 & 1) == 0) ? false : true;
                    HomeView homeView2 = this.f6816B;
                    if (!z6) {
                        drawableX = X();
                    }
                    homeView2.a(drawableX);
                }
            } else {
                HomeView homeView3 = this.f6816B;
                if (homeView3 != null) {
                    removeView(homeView3);
                }
            }
            if ((i5 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    if (this.f6863s == 2) {
                        u0(this, this.f6826G);
                        u0(this, this.f6828H);
                        ScrollingTabContainerView scrollingTabContainerView = this.f6838N;
                        if (scrollingTabContainerView != null) {
                            u0(this.f6826G, scrollingTabContainerView);
                        }
                        ScrollingTabContainerView scrollingTabContainerView2 = this.f6839O;
                        if (scrollingTabContainerView2 != null) {
                            u0(this.f6828H, scrollingTabContainerView2);
                        }
                        this.f6820D.removeAllViews();
                        this.f6824F.removeAllViews();
                    }
                    f0();
                } else {
                    C0378b c0378b = this.f6830I;
                    if (c0378b != null) {
                        this.f6820D.removeView(c0378b.g());
                    }
                    r3.c cVar = this.f6832J;
                    if (cVar != null) {
                        this.f6824F.removeView(cVar.b());
                    }
                    removeView(this.f6834K);
                    this.f6830I = null;
                    this.f6832J = null;
                    this.f6834K = null;
                    if (this.f6863s == 2) {
                        removeView(this.f6826G);
                        removeView(this.f6828H);
                        this.f6826G.removeAllViews();
                        this.f6828H.removeAllViews();
                        ScrollingTabContainerView scrollingTabContainerView3 = this.L;
                        if (scrollingTabContainerView3 != null) {
                            u0(this.f6820D, scrollingTabContainerView3);
                        }
                        ScrollingTabContainerView scrollingTabContainerView4 = this.M;
                        if (scrollingTabContainerView4 != null) {
                            u0(this.f6824F, scrollingTabContainerView4);
                        }
                    }
                }
            }
            C0378b c0378b2 = this.f6830I;
            if (c0378b2 != null && (i5 & 6) != 0) {
                boolean z7 = (this.f6865t & 4) != 0;
                if (c0378b2.i() == 0 || (this.f6865t & 32) != 0) {
                    this.f6834K.setVisibility(!z4 ? z7 ? 0 : 4 : 8);
                }
                this.f6830I.l(!z4 && z7);
                this.f6832J.e(!z4 && z7);
            }
            if ((i5 & 16) != 0 && (view = this.P) != null) {
                if ((i2 & 16) != 0) {
                    u0(this, view);
                    FrameLayout frameLayout = (FrameLayout) this.P.findViewById(R.id.action_bar_expand_container);
                    TextView textView = frameLayout != null ? (TextView) frameLayout.findViewById(android.R.id.title) : null;
                    if (textView != null) {
                        if (this.f6820D.getChildCount() == 1 && (this.f6820D.getChildAt(0) instanceof ScrollingTabContainerView)) {
                            this.f6820D.removeAllViews();
                            this.f6826G.removeAllViews();
                            ScrollingTabContainerView scrollingTabContainerView5 = this.f6838N;
                            if (scrollingTabContainerView5 != null) {
                                this.f6826G.addView(scrollingTabContainerView5);
                            }
                            this.f6828H.removeAllViews();
                            ScrollingTabContainerView scrollingTabContainerView6 = this.f6839O;
                            if (scrollingTabContainerView6 != null) {
                                this.f6828H.addView(scrollingTabContainerView6);
                            }
                        }
                        this.f6824F.removeAllViews();
                        this.f6822E = frameLayout;
                        this.f6819C0.b(frameLayout);
                        this.f6832J.i(textView.getText());
                        this.f6832J.j();
                        this.f6832J.k(0);
                        this.f6832J.h(8);
                        this.f6824F.addView(this.f6832J.b());
                        textView.addTextChangedListener(this.f6869v0);
                    }
                } else {
                    removeView(view);
                }
            }
            requestLayout();
        } else {
            invalidate();
        }
        HomeView homeView4 = this.f6816B;
        if (homeView4 != null) {
            if (!homeView4.isEnabled()) {
                this.f6816B.setContentDescription(null);
            } else if ((i2 & 4) != 0) {
                this.f6816B.setContentDescription(this.f6876z.getResources().getText(R.string.abc_action_bar_up_description));
            } else {
                this.f6816B.setContentDescription(this.f6876z.getResources().getText(R.string.abc_action_bar_home_description));
            }
        }
    }

    public final void w0(ScrollingTabContainerView scrollingTabContainerView, ScrollingTabContainerView scrollingTabContainerView2, ScrollingTabContainerView scrollingTabContainerView3, ScrollingTabContainerView scrollingTabContainerView4) {
        boolean z4 = scrollingTabContainerView != null;
        this.f6853g0 = z4;
        if (z4 && this.f6863s == 2) {
            S(scrollingTabContainerView, scrollingTabContainerView2, scrollingTabContainerView3, scrollingTabContainerView4);
        }
    }

    public final void x0(View view) {
        View view2 = this.f6842S;
        if (view2 != null) {
            removeView(view2);
        }
        this.f6842S = view;
        addView(view);
    }

    public final void y0(boolean z4) {
        HomeView homeView = this.f6816B;
        if (homeView != null) {
            homeView.setEnabled(z4);
            this.f6816B.setFocusable(z4);
            if (!z4) {
                this.f6816B.setContentDescription(null);
            } else if ((this.f6865t & 4) != 0) {
                this.f6816B.setContentDescription(this.f6876z.getResources().getText(R.string.abc_action_bar_up_description));
            } else {
                this.f6816B.setContentDescription(this.f6876z.getResources().getText(R.string.abc_action_bar_home_description));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z0(Menu menu, MenuPresenter.Callback callback) throws Resources.NotFoundException {
        miuix.appcompat.internal.view.menu.action.c cVar;
        ViewGroup viewGroup;
        MenuBuilder menuBuilder = this.f6856j0;
        if (menu == menuBuilder) {
            return;
        }
        if (this.f6934l || menuBuilder != null) {
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.f6932j);
                this.f6856j0.removeMenuPresenter(this.f6859m0);
            }
            MenuBuilder menuBuilder2 = (MenuBuilder) menu;
            this.f6856j0 = menuBuilder2;
            miuix.appcompat.internal.view.menu.action.c cVar2 = this.f6931i;
            if (cVar2 != null && (viewGroup = (ViewGroup) cVar2.getParent()) != null) {
                viewGroup.removeView(this.f6931i);
            }
            if (this.f6932j == null) {
                Object parent = getParent();
                while (true) {
                    View view = (View) parent;
                    if (view instanceof ActionBarOverlayLayout) {
                        miuix.appcompat.internal.view.menu.action.b bVar = new miuix.appcompat.internal.view.menu.action.b(this.f6876z, (ActionBarOverlayLayout) view, R.layout.miuix_appcompat_action_menu_item_layout);
                        bVar.setCallback(callback);
                        bVar.setId(R.id.action_menu_presenter);
                        this.f6932j = bVar;
                        this.f6859m0 = new i();
                        break;
                    }
                    if (!(view.getParent() instanceof View)) {
                        throw new IllegalStateException("ActionBarOverlayLayout not found");
                    }
                    parent = view.getParent();
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
            if (this.f6934l) {
                Objects.requireNonNull(this.f6932j);
                this.f6932j.r(getContext().getResources().getDisplayMetrics().widthPixels);
                layoutParams.width = -1;
                layoutParams.height = -2;
                getContext();
                int i2 = C0432b.f8169a;
                layoutParams.gravity = 80;
                U(menuBuilder2);
                cVar = (miuix.appcompat.internal.view.menu.action.c) this.f6932j.getMenuView(this);
                if (this.f6933k != null) {
                    ViewGroup viewGroup2 = (ViewGroup) cVar.getParent();
                    if (viewGroup2 != null && viewGroup2 != this.f6933k) {
                        viewGroup2.removeView(cVar);
                    }
                    cVar.setVisibility(getVisibility());
                    this.f6933k.addView(cVar, layoutParams);
                    View viewFindViewById = cVar.findViewById(R.id.expanded_menu);
                    if (viewFindViewById != null) {
                        viewFindViewById.requestLayout();
                    }
                } else {
                    cVar.setLayoutParams(layoutParams);
                }
            } else {
                miuix.appcompat.internal.view.menu.action.b bVar2 = this.f6932j;
                getResources().getBoolean(R.bool.abc_action_bar_expanded_action_views_exclusive);
                Objects.requireNonNull(bVar2);
                U(menuBuilder2);
                cVar = (miuix.appcompat.internal.view.menu.action.c) this.f6932j.getMenuView(this);
                ViewGroup viewGroup3 = (ViewGroup) cVar.getParent();
                if (viewGroup3 != null && viewGroup3 != this) {
                    viewGroup3.removeView(cVar);
                }
                addView(cVar, layoutParams);
            }
            this.f6931i = cVar;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams == null ? generateDefaultLayoutParams() : layoutParams;
    }
}
