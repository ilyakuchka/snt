package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0180a;
import androidx.appcompat.widget.C0182c;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0180a {

    /* renamed from: A, reason: collision with root package name */
    private boolean f2643A;

    /* renamed from: B, reason: collision with root package name */
    private int f2644B;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f2645q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f2646r;

    /* renamed from: s, reason: collision with root package name */
    private View f2647s;

    /* renamed from: t, reason: collision with root package name */
    private View f2648t;
    private View u;

    /* renamed from: v, reason: collision with root package name */
    private LinearLayout f2649v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f2650w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f2651x;

    /* renamed from: y, reason: collision with root package name */
    private int f2652y;

    /* renamed from: z, reason: collision with root package name */
    private int f2653z;

    final class a implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ l.b f2654i;

        a(l.b bVar) {
            this.f2654i = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f2654i.c();
        }
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        U u = U.u(context, attributeSet, Y1.a.f2116i, R.attr.actionModeStyle, 0);
        Drawable drawableF = u.f(6);
        int i2 = androidx.core.view.o.d;
        setBackground(drawableF);
        this.f2652y = u.m(12, 0);
        this.f2653z = u.m(11, 0);
        this.f2976m = u.l(10, 0);
        this.f2644B = u.m(8, R.layout.abc_action_mode_close_item_material);
        u.v();
    }

    private void j() {
        if (this.f2649v == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2649v = linearLayout;
            this.f2650w = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f2651x = (TextView) this.f2649v.findViewById(R.id.action_bar_subtitle);
            if (this.f2652y != 0) {
                this.f2650w.setTextAppearance(getContext(), this.f2652y);
            }
            if (this.f2653z != 0) {
                this.f2651x.setTextAppearance(getContext(), this.f2653z);
            }
        }
        this.f2650w.setText(this.f2645q);
        this.f2651x.setText(this.f2646r);
        boolean z4 = !TextUtils.isEmpty(this.f2645q);
        boolean z5 = !TextUtils.isEmpty(this.f2646r);
        int i2 = 0;
        this.f2651x.setVisibility(z5 ? 0 : 8);
        LinearLayout linearLayout2 = this.f2649v;
        if (!z4 && !z5) {
            i2 = 8;
        }
        linearLayout2.setVisibility(i2);
        if (this.f2649v.getParent() == null) {
            addView(this.f2649v);
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0180a
    public final void e(int i2) {
        this.f2976m = i2;
    }

    public final void f() {
        if (this.f2647s == null) {
            l();
        }
    }

    public final CharSequence g() {
        return this.f2646r;
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public final CharSequence h() {
        return this.f2645q;
    }

    public final void i(l.b bVar) {
        View view = this.f2647s;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f2644B, (ViewGroup) this, false);
            this.f2647s = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f2647s);
        }
        View viewFindViewById = this.f2647s.findViewById(R.id.action_mode_close_button);
        this.f2648t = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) bVar.e();
        C0182c c0182c = this.f2975l;
        if (c0182c != null) {
            c0182c.t();
        }
        C0182c c0182c2 = new C0182c(getContext());
        this.f2975l = c0182c2;
        c0182c2.z();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        fVar.c(this.f2975l, this.f2973j);
        ActionMenuView actionMenuView = (ActionMenuView) this.f2975l.k(this);
        this.f2974k = actionMenuView;
        int i2 = androidx.core.view.o.d;
        actionMenuView.setBackground(null);
        addView(this.f2974k, layoutParams);
    }

    public final boolean k() {
        return this.f2643A;
    }

    public final void l() {
        removeAllViews();
        this.u = null;
        this.f2974k = null;
        this.f2975l = null;
        View view = this.f2648t;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public final void m(View view) {
        LinearLayout linearLayout;
        View view2 = this.u;
        if (view2 != null) {
            removeView(view2);
        }
        this.u = view;
        if (view != null && (linearLayout = this.f2649v) != null) {
            removeView(linearLayout);
            this.f2649v = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public final void n(CharSequence charSequence) {
        this.f2646r = charSequence;
        j();
    }

    public final void o(CharSequence charSequence) {
        this.f2645q = charSequence;
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0182c c0182c = this.f2975l;
        if (c0182c != null) {
            c0182c.u();
            C0182c.a aVar = this.f2975l.f2994z;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f2645q);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        boolean zB = Y.b(this);
        int paddingRight = zB ? (i5 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2647s;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2647s.getLayoutParams();
            int i7 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i9 = zB ? paddingRight - i7 : paddingRight + i7;
            int iD = i9 + d(this.f2647s, i9, paddingTop, paddingTop2, zB);
            paddingRight = zB ? iD - i8 : iD + i8;
        }
        int iD2 = paddingRight;
        LinearLayout linearLayout = this.f2649v;
        if (linearLayout != null && this.u == null && linearLayout.getVisibility() != 8) {
            iD2 += d(this.f2649v, iD2, paddingTop, paddingTop2, zB);
        }
        int i10 = iD2;
        View view2 = this.u;
        if (view2 != null) {
            d(view2, i10, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i5 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f2974k;
        if (actionMenuView != null) {
            d(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i4) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.f2976m;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i4);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f2647s;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2647s.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f2974k;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f2974k, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f2649v;
        if (linearLayout != null && this.u == null) {
            if (this.f2643A) {
                this.f2649v.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f2649v.getMeasuredWidth();
                boolean z4 = measuredWidth <= paddingLeft;
                if (z4) {
                    paddingLeft -= measuredWidth;
                }
                this.f2649v.setVisibility(z4 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.u;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i5 = layoutParams.width;
            int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i5 >= 0) {
                paddingLeft = Math.min(i5, paddingLeft);
            }
            int i7 = layoutParams.height;
            int i8 = i7 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i7 >= 0) {
                iMin = Math.min(i7, iMin);
            }
            this.u.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(iMin, i8));
        }
        if (this.f2976m > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i9) {
                i9 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i9);
    }

    public final void p(boolean z4) {
        if (z4 != this.f2643A) {
            requestLayout();
        }
        this.f2643A = z4;
    }

    public final androidx.core.view.t q(int i2, long j2) {
        androidx.core.view.t tVar = this.f2977n;
        if (tVar != null) {
            tVar.b();
        }
        if (i2 != 0) {
            androidx.core.view.t tVarA = androidx.core.view.o.a(this);
            tVarA.a(0.0f);
            tVarA.d(j2);
            AbstractC0180a.C0058a c0058a = this.f2972i;
            AbstractC0180a.this.f2977n = tVarA;
            c0058a.f2980b = i2;
            tVarA.f(c0058a);
            return tVarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        androidx.core.view.t tVarA2 = androidx.core.view.o.a(this);
        tVarA2.a(1.0f);
        tVarA2.d(j2);
        AbstractC0180a.C0058a c0058a2 = this.f2972i;
        AbstractC0180a.this.f2977n = tVarA2;
        c0058a2.f2980b = i2;
        tVarA2.f(c0058a2);
        return tVarA2;
    }

    public final boolean r() {
        C0182c c0182c = this.f2975l;
        if (c0182c != null) {
            return c0182c.A();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
