package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A, reason: collision with root package name */
    private int f2902A;

    /* renamed from: B, reason: collision with root package name */
    private N f2903B;

    /* renamed from: C, reason: collision with root package name */
    private int f2904C;

    /* renamed from: D, reason: collision with root package name */
    private int f2905D;

    /* renamed from: E, reason: collision with root package name */
    private int f2906E;

    /* renamed from: F, reason: collision with root package name */
    private CharSequence f2907F;

    /* renamed from: G, reason: collision with root package name */
    private CharSequence f2908G;

    /* renamed from: H, reason: collision with root package name */
    private ColorStateList f2909H;

    /* renamed from: I, reason: collision with root package name */
    private ColorStateList f2910I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f2911J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f2912K;
    private final ArrayList<View> L;
    private final ArrayList<View> M;

    /* renamed from: N, reason: collision with root package name */
    private final int[] f2913N;

    /* renamed from: O, reason: collision with root package name */
    private final ActionMenuView.e f2914O;
    private W P;

    /* renamed from: Q, reason: collision with root package name */
    private C0182c f2915Q;

    /* renamed from: R, reason: collision with root package name */
    private d f2916R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f2917S;

    /* renamed from: T, reason: collision with root package name */
    private final Runnable f2918T;

    /* renamed from: i, reason: collision with root package name */
    private ActionMenuView f2919i;

    /* renamed from: j, reason: collision with root package name */
    private AppCompatTextView f2920j;

    /* renamed from: k, reason: collision with root package name */
    private AppCompatTextView f2921k;

    /* renamed from: l, reason: collision with root package name */
    private C0190k f2922l;

    /* renamed from: m, reason: collision with root package name */
    private AppCompatImageView f2923m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f2924n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f2925o;
    C0190k p;

    /* renamed from: q, reason: collision with root package name */
    View f2926q;

    /* renamed from: r, reason: collision with root package name */
    private Context f2927r;

    /* renamed from: s, reason: collision with root package name */
    private int f2928s;

    /* renamed from: t, reason: collision with root package name */
    private int f2929t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    int f2930v;

    /* renamed from: w, reason: collision with root package name */
    private int f2931w;

    /* renamed from: x, reason: collision with root package name */
    private int f2932x;

    /* renamed from: y, reason: collision with root package name */
    private int f2933y;

    /* renamed from: z, reason: collision with root package name */
    private int f2934z;

    final class a implements ActionMenuView.e {
        a() {
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toolbar.this.U();
        }
    }

    final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Toolbar.this.e();
        }
    }

    private class d implements androidx.appcompat.view.menu.l {

        /* renamed from: i, reason: collision with root package name */
        androidx.appcompat.view.menu.f f2938i;

        /* renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.h f2939j;

        d() {
        }

        @Override // androidx.appcompat.view.menu.l
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z4) {
        }

        @Override // androidx.appcompat.view.menu.l
        public final boolean b(androidx.appcompat.view.menu.h hVar) {
            KeyEvent.Callback callback = Toolbar.this.f2926q;
            if (callback instanceof l.c) {
                ((l.c) callback).d();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f2926q);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.p);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f2926q = null;
            toolbar3.a();
            this.f2939j = null;
            Toolbar.this.requestLayout();
            hVar.p(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.l
        public final void c(Context context, androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.h hVar;
            androidx.appcompat.view.menu.f fVar2 = this.f2938i;
            if (fVar2 != null && (hVar = this.f2939j) != null) {
                fVar2.f(hVar);
            }
            this.f2938i = fVar;
        }

        @Override // androidx.appcompat.view.menu.l
        public final boolean e(androidx.appcompat.view.menu.h hVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.p.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.p);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.p);
            }
            Toolbar.this.f2926q = hVar.getActionView();
            this.f2939j = hVar;
            ViewParent parent2 = Toolbar.this.f2926q.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f2926q);
                }
                Objects.requireNonNull(Toolbar.this);
                e eVar = new e();
                Toolbar toolbar4 = Toolbar.this;
                eVar.f2312a = 8388611 | (toolbar4.f2930v & 112);
                eVar.f2941b = 2;
                toolbar4.f2926q.setLayoutParams(eVar);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f2926q);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            hVar.p(true);
            KeyEvent.Callback callback = Toolbar.this.f2926q;
            if (callback instanceof l.c) {
                ((l.c) callback).c();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.l
        public final boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.l
        public final boolean g(androidx.appcompat.view.menu.p pVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.l
        public final void updateMenuView(boolean z4) {
            if (this.f2939j != null) {
                androidx.appcompat.view.menu.f fVar = this.f2938i;
                boolean z5 = false;
                if (fVar != null) {
                    int size = fVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        if (this.f2938i.getItem(i2) == this.f2939j) {
                            z5 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (z5) {
                    return;
                }
                b(this.f2939j);
            }
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.f2906E = 8388627;
        this.L = new ArrayList<>();
        this.M = new ArrayList<>();
        this.f2913N = new int[2];
        this.f2914O = new a();
        this.f2918T = new b();
        Context context2 = getContext();
        int[] iArr = Y1.a.f2085C;
        U u = U.u(context2, attributeSet, iArr, R.attr.toolbarStyle, 0);
        androidx.core.view.o.i(this, context, iArr, attributeSet, u.q(), R.attr.toolbarStyle);
        this.f2929t = u.m(28, 0);
        this.u = u.m(19, 0);
        this.f2906E = u.k(0, this.f2906E);
        this.f2930v = u.k(2, 48);
        int iD = u.d(22, 0);
        iD = u.r(27) ? u.d(27, iD) : iD;
        this.f2902A = iD;
        this.f2934z = iD;
        this.f2933y = iD;
        this.f2932x = iD;
        int iD2 = u.d(25, -1);
        if (iD2 >= 0) {
            this.f2932x = iD2;
        }
        int iD3 = u.d(24, -1);
        if (iD3 >= 0) {
            this.f2933y = iD3;
        }
        int iD4 = u.d(26, -1);
        if (iD4 >= 0) {
            this.f2934z = iD4;
        }
        int iD5 = u.d(23, -1);
        if (iD5 >= 0) {
            this.f2902A = iD5;
        }
        this.f2931w = u.e(13, -1);
        int iD6 = u.d(9, Integer.MIN_VALUE);
        int iD7 = u.d(5, Integer.MIN_VALUE);
        int iE = u.e(7, 0);
        int iE2 = u.e(8, 0);
        h();
        this.f2903B.c(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.f2903B.e(iD6, iD7);
        }
        this.f2904C = u.d(10, Integer.MIN_VALUE);
        this.f2905D = u.d(6, Integer.MIN_VALUE);
        this.f2924n = u.f(4);
        this.f2925o = u.o(3);
        CharSequence charSequenceO = u.o(21);
        if (!TextUtils.isEmpty(charSequenceO)) {
            R(charSequenceO);
        }
        CharSequence charSequenceO2 = u.o(18);
        if (!TextUtils.isEmpty(charSequenceO2)) {
            P(charSequenceO2);
        }
        this.f2927r = getContext();
        O(u.m(17, 0));
        Drawable drawableF = u.f(16);
        if (drawableF != null) {
            M(drawableF);
        }
        CharSequence charSequenceO3 = u.o(15);
        if (!TextUtils.isEmpty(charSequenceO3)) {
            L(charSequenceO3);
        }
        Drawable drawableF2 = u.f(11);
        if (drawableF2 != null) {
            J(drawableF2);
        }
        CharSequence charSequenceO4 = u.o(12);
        if (!TextUtils.isEmpty(charSequenceO4)) {
            if (!TextUtils.isEmpty(charSequenceO4) && this.f2923m == null) {
                this.f2923m = new AppCompatImageView(getContext(), null);
            }
            AppCompatImageView appCompatImageView = this.f2923m;
            if (appCompatImageView != null) {
                appCompatImageView.setContentDescription(charSequenceO4);
            }
        }
        if (u.r(29)) {
            ColorStateList colorStateListC = u.c(29);
            this.f2909H = colorStateListC;
            AppCompatTextView appCompatTextView = this.f2920j;
            if (appCompatTextView != null) {
                appCompatTextView.setTextColor(colorStateListC);
            }
        }
        if (u.r(20)) {
            ColorStateList colorStateListC2 = u.c(20);
            this.f2910I = colorStateListC2;
            AppCompatTextView appCompatTextView2 = this.f2921k;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setTextColor(colorStateListC2);
            }
        }
        if (u.r(14)) {
            int iM = u.m(14, 0);
            l.g gVar = new l.g(getContext());
            i();
            if (this.f2919i.y() == null) {
                androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) this.f2919i.r();
                if (this.f2916R == null) {
                    this.f2916R = new d();
                }
                this.f2919i.z();
                fVar.c(this.f2916R, this.f2927r);
            }
            gVar.inflate(iM, this.f2919i.r());
        }
        u.v();
    }

    private int C(View view, int i2, int[] iArr, int i4) {
        e eVar = (e) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int iMax = Math.max(0, i5) + i2;
        iArr[0] = Math.max(0, -i5);
        int iN = n(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iN, iMax + measuredWidth, view.getMeasuredHeight() + iN);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin + iMax;
    }

    private int D(View view, int i2, int[] iArr, int i4) {
        e eVar = (e) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int iMax = i2 - Math.max(0, i5);
        iArr[1] = Math.max(0, -i5);
        int iN = n(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iN, iMax, view.getMeasuredHeight() + iN);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int E(View view, int i2, int i4, int i5, int i6, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i7 = marginLayoutParams.leftMargin - iArr[0];
        int i8 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i8) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i7);
        iArr[1] = Math.max(0, -i8);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + iMax + i4, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i5, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void F(View view, int i2, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private boolean T(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i2) {
        int i4 = androidx.core.view.o.d;
        boolean z4 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        list.clear();
        if (!z4) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f2941b == 0 && T(childAt) && m(eVar.f2312a) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f2941b == 0 && T(childAt2) && m(eVar2.f2312a) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e eVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        eVarGenerateDefaultLayoutParams.f2941b = 1;
        if (!z4 || this.f2926q == null) {
            addView(view, eVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.M.add(view);
        }
    }

    private void h() {
        if (this.f2903B == null) {
            this.f2903B = new N();
        }
    }

    private void i() {
        if (this.f2919i == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f2919i = actionMenuView;
            actionMenuView.C(this.f2928s);
            ActionMenuView actionMenuView2 = this.f2919i;
            actionMenuView2.f2692I = this.f2914O;
            actionMenuView2.A();
            e eVar = new e();
            eVar.f2312a = 8388613 | (this.f2930v & 112);
            this.f2919i.setLayoutParams(eVar);
            c(this.f2919i, false);
        }
    }

    private void j() {
        if (this.f2922l == null) {
            this.f2922l = new C0190k(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            e eVar = new e();
            eVar.f2312a = 8388611 | (this.f2930v & 112);
            this.f2922l.setLayoutParams(eVar);
        }
    }

    private int m(int i2) {
        int i4 = androidx.core.view.o.d;
        int layoutDirection = getLayoutDirection();
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, layoutDirection) & 7;
        return (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) ? absoluteGravity : layoutDirection == 1 ? 5 : 3;
    }

    private int n(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int i5 = eVar.f2312a & 112;
        if (i5 != 16 && i5 != 48 && i5 != 80) {
            i5 = this.f2906E & 112;
        }
        if (i5 == 48) {
            return getPaddingTop() - i4;
        }
        if (i5 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i4;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i6 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (iMax < i6) {
            iMax = i6;
        } else {
            int i7 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i8 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i7 < i8) {
                iMax = Math.max(0, iMax - (i8 - i7));
            }
        }
        return paddingTop + iMax;
    }

    private int q(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    private int v(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private boolean z(View view) {
        return view.getParent() == this || this.M.contains(view);
    }

    public final boolean A() {
        ActionMenuView actionMenuView = this.f2919i;
        return actionMenuView != null && actionMenuView.u();
    }

    public final boolean B() {
        ActionMenuView actionMenuView = this.f2919i;
        return actionMenuView != null && actionMenuView.v();
    }

    final void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f2941b != 2 && childAt != this.f2919i) {
                removeViewAt(childCount);
                this.M.add(childAt);
            }
        }
    }

    public final void H(boolean z4) {
        this.f2917S = z4;
        requestLayout();
    }

    public final void I(int i2, int i4) {
        h();
        this.f2903B.e(i2, i4);
    }

    public final void J(Drawable drawable) {
        if (drawable != null) {
            if (this.f2923m == null) {
                this.f2923m = new AppCompatImageView(getContext(), null);
            }
            if (!z(this.f2923m)) {
                c(this.f2923m, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.f2923m;
            if (appCompatImageView != null && z(appCompatImageView)) {
                removeView(this.f2923m);
                this.M.remove(this.f2923m);
            }
        }
        AppCompatImageView appCompatImageView2 = this.f2923m;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public final void K(androidx.appcompat.view.menu.f fVar, C0182c c0182c) {
        androidx.appcompat.view.menu.h hVar;
        if (fVar == null && this.f2919i == null) {
            return;
        }
        i();
        androidx.appcompat.view.menu.f fVarY = this.f2919i.y();
        if (fVarY == fVar) {
            return;
        }
        if (fVarY != null) {
            fVarY.B(this.f2915Q);
            fVarY.B(this.f2916R);
        }
        if (this.f2916R == null) {
            this.f2916R = new d();
        }
        c0182c.x();
        if (fVar != null) {
            fVar.c(c0182c, this.f2927r);
            fVar.c(this.f2916R, this.f2927r);
        } else {
            c0182c.c(this.f2927r, null);
            d dVar = this.f2916R;
            androidx.appcompat.view.menu.f fVar2 = dVar.f2938i;
            if (fVar2 != null && (hVar = dVar.f2939j) != null) {
                fVar2.f(hVar);
            }
            dVar.f2938i = null;
            c0182c.updateMenuView(true);
            this.f2916R.updateMenuView(true);
        }
        this.f2919i.C(this.f2928s);
        this.f2919i.D(c0182c);
        this.f2915Q = c0182c;
    }

    public final void L(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        C0190k c0190k = this.f2922l;
        if (c0190k != null) {
            c0190k.setContentDescription(charSequence);
        }
    }

    public final void M(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!z(this.f2922l)) {
                c(this.f2922l, true);
            }
        } else {
            C0190k c0190k = this.f2922l;
            if (c0190k != null && z(c0190k)) {
                removeView(this.f2922l);
                this.M.remove(this.f2922l);
            }
        }
        C0190k c0190k2 = this.f2922l;
        if (c0190k2 != null) {
            c0190k2.setImageDrawable(drawable);
        }
    }

    public final void N(View.OnClickListener onClickListener) {
        j();
        this.f2922l.setOnClickListener(onClickListener);
    }

    public final void O(int i2) {
        if (this.f2928s != i2) {
            this.f2928s = i2;
            if (i2 == 0) {
                this.f2927r = getContext();
            } else {
                this.f2927r = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public final void P(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f2921k;
            if (appCompatTextView != null && z(appCompatTextView)) {
                removeView(this.f2921k);
                this.M.remove(this.f2921k);
            }
        } else {
            if (this.f2921k == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.f2921k = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f2921k.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.u;
                if (i2 != 0) {
                    this.f2921k.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f2910I;
                if (colorStateList != null) {
                    this.f2921k.setTextColor(colorStateList);
                }
            }
            if (!z(this.f2921k)) {
                c(this.f2921k, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f2921k;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f2908G = charSequence;
    }

    public final void Q(Context context, int i2) {
        this.u = i2;
        AppCompatTextView appCompatTextView = this.f2921k;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(context, i2);
        }
    }

    public final void R(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f2920j;
            if (appCompatTextView != null && z(appCompatTextView)) {
                removeView(this.f2920j);
                this.M.remove(this.f2920j);
            }
        } else {
            if (this.f2920j == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.f2920j = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f2920j.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f2929t;
                if (i2 != 0) {
                    this.f2920j.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f2909H;
                if (colorStateList != null) {
                    this.f2920j.setTextColor(colorStateList);
                }
            }
            if (!z(this.f2920j)) {
                c(this.f2920j, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f2920j;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f2907F = charSequence;
    }

    public final void S(Context context, int i2) {
        this.f2929t = i2;
        AppCompatTextView appCompatTextView = this.f2920j;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(context, i2);
        }
    }

    public final boolean U() {
        ActionMenuView actionMenuView = this.f2919i;
        return actionMenuView != null && actionMenuView.E();
    }

    final void a() {
        for (int size = this.M.size() - 1; size >= 0; size--) {
            addView(this.M.get(size));
        }
        this.M.clear();
    }

    @Override // android.view.ViewGroup
    protected final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public final boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f2919i) != null && actionMenuView.w();
    }

    public final void e() {
        d dVar = this.f2916R;
        androidx.appcompat.view.menu.h hVar = dVar == null ? null : dVar.f2939j;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    public final void f() {
        ActionMenuView actionMenuView = this.f2919i;
        if (actionMenuView != null) {
            actionMenuView.o();
        }
    }

    final void g() {
        if (this.p == null) {
            C0190k c0190k = new C0190k(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.p = c0190k;
            c0190k.setImageDrawable(this.f2924n);
            this.p.setContentDescription(this.f2925o);
            e eVar = new e();
            eVar.f2312a = 8388611 | (this.f2930v & 112);
            eVar.f2941b = 2;
            this.p.setLayoutParams(eVar);
            this.p.setOnClickListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final e generateDefaultLayoutParams() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0055a ? new e((a.C0055a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public final int o() {
        androidx.appcompat.view.menu.f fVarY;
        ActionMenuView actionMenuView = this.f2919i;
        if ((actionMenuView == null || (fVarY = actionMenuView.y()) == null || !fVarY.hasVisibleItems()) ? false : true) {
            N n2 = this.f2903B;
            return Math.max(n2 != null ? n2.a() : 0, Math.max(this.f2905D, 0));
        }
        N n4 = this.f2903B;
        return n4 != null ? n4.a() : 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2918T);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2912K = false;
        }
        if (!this.f2912K) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f2912K = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2912K = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x02af A[LOOP:0: B:112:0x02ad->B:113:0x02af, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d1 A[LOOP:1: B:115:0x02cf->B:116:0x02d1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02f5 A[LOOP:2: B:118:0x02f3->B:119:0x02f5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0346 A[LOOP:3: B:127:0x0344->B:128:0x0346, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0235  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int iC;
        int iD;
        boolean zT;
        boolean zT2;
        int measuredHeight;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        int i11;
        int paddingTop;
        int i12;
        int i13;
        int i14;
        int i15;
        int size;
        int iC2;
        int i16;
        int size2;
        int i17;
        int size3;
        int i18;
        int i19;
        int size4;
        int i20;
        int i21 = androidx.core.view.o.d;
        boolean z6 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i22 = width - paddingRight;
        int[] iArr = this.f2913N;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = getMinimumHeight();
        int iMin = minimumHeight >= 0 ? Math.min(minimumHeight, i6 - i4) : 0;
        if (!T(this.f2922l)) {
            iC = paddingLeft;
        } else {
            if (z6) {
                iD = D(this.f2922l, i22, iArr, iMin);
                iC = paddingLeft;
                if (T(this.p)) {
                    if (z6) {
                        iD = D(this.p, iD, iArr, iMin);
                    } else {
                        iC = C(this.p, iC, iArr, iMin);
                    }
                }
                if (T(this.f2919i)) {
                    if (z6) {
                        iC = C(this.f2919i, iC, iArr, iMin);
                    } else {
                        iD = D(this.f2919i, iD, iArr, iMin);
                    }
                }
                int iO = getLayoutDirection() != 1 ? o() : p();
                int iP = getLayoutDirection() != 1 ? p() : o();
                iArr[0] = Math.max(0, iO - iC);
                iArr[1] = Math.max(0, iP - (i22 - iD));
                int iMax = Math.max(iC, iO);
                int iMin2 = Math.min(iD, i22 - iP);
                if (T(this.f2926q)) {
                    if (z6) {
                        iMin2 = D(this.f2926q, iMin2, iArr, iMin);
                    } else {
                        iMax = C(this.f2926q, iMax, iArr, iMin);
                    }
                }
                if (T(this.f2923m)) {
                    if (z6) {
                        iMin2 = D(this.f2923m, iMin2, iArr, iMin);
                    } else {
                        iMax = C(this.f2923m, iMax, iArr, iMin);
                    }
                }
                zT = T(this.f2920j);
                zT2 = T(this.f2921k);
                if (zT) {
                    measuredHeight = 0;
                } else {
                    e eVar = (e) this.f2920j.getLayoutParams();
                    measuredHeight = this.f2920j.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin + 0;
                }
                if (zT2) {
                    i7 = width;
                } else {
                    e eVar2 = (e) this.f2921k.getLayoutParams();
                    i7 = width;
                    measuredHeight += this.f2921k.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin;
                }
                if (!zT || zT2) {
                    AppCompatTextView appCompatTextView = !zT ? this.f2920j : this.f2921k;
                    AppCompatTextView appCompatTextView2 = !zT2 ? this.f2921k : this.f2920j;
                    e eVar3 = (e) appCompatTextView.getLayoutParams();
                    e eVar4 = (e) appCompatTextView2.getLayoutParams();
                    if ((zT || this.f2920j.getMeasuredWidth() <= 0) && (!zT2 || this.f2921k.getMeasuredWidth() <= 0)) {
                        i8 = paddingLeft;
                        z5 = false;
                    } else {
                        i8 = paddingLeft;
                        z5 = true;
                    }
                    i9 = this.f2906E & 112;
                    i10 = iMin;
                    if (i9 == 48) {
                        i11 = iMax;
                        paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin + this.f2934z;
                    } else if (i9 != 80) {
                        int iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                        i11 = iMax;
                        int i23 = ((ViewGroup.MarginLayoutParams) eVar3).topMargin + this.f2934z;
                        if (iMax2 < i23) {
                            iMax2 = i23;
                        } else {
                            int i24 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                            int i25 = ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin;
                            int i26 = this.f2902A;
                            if (i24 < i25 + i26) {
                                iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) eVar4).bottomMargin + i26) - i24));
                            }
                        }
                        paddingTop = paddingTop2 + iMax2;
                    } else {
                        i11 = iMax;
                        paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin) - this.f2902A) - measuredHeight;
                    }
                    if (z6) {
                        int i27 = (z5 ? this.f2932x : 0) - iArr[1];
                        iMin2 -= Math.max(0, i27);
                        iArr[1] = Math.max(0, -i27);
                        if (zT) {
                            e eVar5 = (e) this.f2920j.getLayoutParams();
                            int measuredWidth = iMin2 - this.f2920j.getMeasuredWidth();
                            int measuredHeight2 = this.f2920j.getMeasuredHeight() + paddingTop;
                            this.f2920j.layout(measuredWidth, paddingTop, iMin2, measuredHeight2);
                            i14 = measuredWidth - this.f2933y;
                            paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) eVar5).bottomMargin;
                        } else {
                            i14 = iMin2;
                        }
                        if (zT2) {
                            int i28 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f2921k.getLayoutParams())).topMargin;
                            this.f2921k.layout(iMin2 - this.f2921k.getMeasuredWidth(), i28, iMin2, this.f2921k.getMeasuredHeight() + i28);
                            i15 = iMin2 - this.f2933y;
                        } else {
                            i15 = iMin2;
                        }
                        if (z5) {
                            iMin2 = Math.min(i14, i15);
                        }
                        iMax = i11;
                    } else {
                        int i29 = (z5 ? this.f2932x : 0) - iArr[0];
                        int iMax3 = Math.max(0, i29) + i11;
                        iArr[0] = Math.max(0, -i29);
                        if (zT) {
                            e eVar6 = (e) this.f2920j.getLayoutParams();
                            int measuredWidth2 = this.f2920j.getMeasuredWidth() + iMax3;
                            int measuredHeight3 = this.f2920j.getMeasuredHeight() + paddingTop;
                            this.f2920j.layout(iMax3, paddingTop, measuredWidth2, measuredHeight3);
                            i12 = measuredWidth2 + this.f2933y;
                            paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) eVar6).bottomMargin;
                        } else {
                            i12 = iMax3;
                        }
                        if (zT2) {
                            int i30 = paddingTop + ((ViewGroup.MarginLayoutParams) ((e) this.f2921k.getLayoutParams())).topMargin;
                            int measuredWidth3 = this.f2921k.getMeasuredWidth() + iMax3;
                            this.f2921k.layout(iMax3, i30, measuredWidth3, this.f2921k.getMeasuredHeight() + i30);
                            i13 = measuredWidth3 + this.f2933y;
                        } else {
                            i13 = iMax3;
                        }
                        iMax = z5 ? Math.max(i12, i13) : iMax3;
                    }
                } else {
                    i8 = paddingLeft;
                    i10 = iMin;
                }
                b(this.L, 3);
                size = this.L.size();
                iC2 = iMax;
                for (i16 = 0; i16 < size; i16++) {
                    iC2 = C(this.L.get(i16), iC2, iArr, i10);
                }
                int i31 = i10;
                b(this.L, 5);
                size2 = this.L.size();
                for (i17 = 0; i17 < size2; i17++) {
                    iMin2 = D(this.L.get(i17), iMin2, iArr, i31);
                }
                b(this.L, 1);
                ArrayList<View> arrayList = this.L;
                int i32 = iArr[0];
                int i33 = iArr[1];
                size3 = arrayList.size();
                i18 = 0;
                int measuredWidth4 = 0;
                while (i18 < size3) {
                    View view = arrayList.get(i18);
                    e eVar7 = (e) view.getLayoutParams();
                    int i34 = ((ViewGroup.MarginLayoutParams) eVar7).leftMargin - i32;
                    int i35 = ((ViewGroup.MarginLayoutParams) eVar7).rightMargin - i33;
                    int iMax4 = Math.max(0, i34);
                    int iMax5 = Math.max(0, i35);
                    int iMax6 = Math.max(0, -i34);
                    int iMax7 = Math.max(0, -i35);
                    measuredWidth4 += view.getMeasuredWidth() + iMax4 + iMax5;
                    i18++;
                    i33 = iMax7;
                    i32 = iMax6;
                }
                i19 = ((((i7 - i8) - paddingRight) / 2) + i8) - (measuredWidth4 / 2);
                int i36 = measuredWidth4 + i19;
                if (i19 >= iC2) {
                    iC2 = i36 > iMin2 ? i19 - (i36 - iMin2) : i19;
                }
                size4 = this.L.size();
                for (i20 = 0; i20 < size4; i20++) {
                    iC2 = C(this.L.get(i20), iC2, iArr, i31);
                }
                this.L.clear();
            }
            iC = C(this.f2922l, paddingLeft, iArr, iMin);
        }
        iD = i22;
        if (T(this.p)) {
        }
        if (T(this.f2919i)) {
        }
        if (getLayoutDirection() != 1) {
        }
        if (getLayoutDirection() != 1) {
        }
        iArr[0] = Math.max(0, iO - iC);
        iArr[1] = Math.max(0, iP - (i22 - iD));
        int iMax8 = Math.max(iC, iO);
        int iMin22 = Math.min(iD, i22 - iP);
        if (T(this.f2926q)) {
        }
        if (T(this.f2923m)) {
        }
        zT = T(this.f2920j);
        zT2 = T(this.f2921k);
        if (zT) {
        }
        if (zT2) {
        }
        if (zT) {
            if (!zT) {
            }
            if (!zT2) {
            }
            e eVar32 = (e) appCompatTextView.getLayoutParams();
            e eVar42 = (e) appCompatTextView2.getLayoutParams();
            if (zT) {
                i8 = paddingLeft;
                z5 = false;
                i9 = this.f2906E & 112;
                i10 = iMin;
                if (i9 == 48) {
                }
                if (z6) {
                }
            } else {
                i8 = paddingLeft;
                z5 = false;
                i9 = this.f2906E & 112;
                i10 = iMin;
                if (i9 == 48) {
                }
                if (z6) {
                }
            }
        }
        b(this.L, 3);
        size = this.L.size();
        iC2 = iMax8;
        while (i16 < size) {
        }
        int i312 = i10;
        b(this.L, 5);
        size2 = this.L.size();
        while (i17 < size2) {
        }
        b(this.L, 1);
        ArrayList<View> arrayList2 = this.L;
        int i322 = iArr[0];
        int i332 = iArr[1];
        size3 = arrayList2.size();
        i18 = 0;
        int measuredWidth42 = 0;
        while (i18 < size3) {
        }
        i19 = ((((i7 - i8) - paddingRight) / 2) + i8) - (measuredWidth42 / 2);
        int i362 = measuredWidth42 + i19;
        if (i19 >= iC2) {
        }
        size4 = this.L.size();
        while (i20 < size4) {
        }
        this.L.clear();
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean z4;
        int[] iArr = this.f2913N;
        boolean zB = Y.b(this);
        int i5 = !zB ? 1 : 0;
        if (T(this.f2922l)) {
            F(this.f2922l, i2, 0, i4, this.f2931w);
            measuredWidth = this.f2922l.getMeasuredWidth() + q(this.f2922l);
            iMax = Math.max(0, this.f2922l.getMeasuredHeight() + v(this.f2922l));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2922l.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (T(this.p)) {
            F(this.p, i2, 0, i4, this.f2931w);
            measuredWidth = this.p.getMeasuredWidth() + q(this.p);
            iMax = Math.max(iMax, this.p.getMeasuredHeight() + v(this.p));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.p.getMeasuredState());
        }
        int iP = p();
        int iMax3 = Math.max(iP, measuredWidth) + 0;
        iArr[zB ? 1 : 0] = Math.max(0, iP - measuredWidth);
        if (T(this.f2919i)) {
            F(this.f2919i, i2, iMax3, i4, this.f2931w);
            measuredWidth2 = this.f2919i.getMeasuredWidth() + q(this.f2919i);
            iMax = Math.max(iMax, this.f2919i.getMeasuredHeight() + v(this.f2919i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2919i.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int iO = o();
        int iMax4 = iMax3 + Math.max(iO, measuredWidth2);
        iArr[i5] = Math.max(0, iO - measuredWidth2);
        if (T(this.f2926q)) {
            iMax4 += E(this.f2926q, i2, iMax4, i4, 0, iArr);
            iMax = Math.max(iMax, this.f2926q.getMeasuredHeight() + v(this.f2926q));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2926q.getMeasuredState());
        }
        if (T(this.f2923m)) {
            iMax4 += E(this.f2923m, i2, iMax4, i4, 0, iArr);
            iMax = Math.max(iMax, this.f2923m.getMeasuredHeight() + v(this.f2923m));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2923m.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (((e) childAt.getLayoutParams()).f2941b == 0 && T(childAt)) {
                iMax4 += E(childAt, i2, iMax4, i4, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + v(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i7 = this.f2934z + this.f2902A;
        int i8 = this.f2932x + this.f2933y;
        if (T(this.f2920j)) {
            E(this.f2920j, i2, iMax4 + i8, i4, i7, iArr);
            int measuredWidth3 = this.f2920j.getMeasuredWidth() + q(this.f2920j);
            measuredHeight = this.f2920j.getMeasuredHeight() + v(this.f2920j);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2920j.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (T(this.f2921k)) {
            iMax2 = Math.max(iMax2, E(this.f2921k, i2, iMax4 + i8, i4, measuredHeight + i7, iArr));
            measuredHeight += this.f2921k.getMeasuredHeight() + v(this.f2921k);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f2921k.getMeasuredState());
        }
        int iMax5 = Math.max(iMax, measuredHeight);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax5;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + iMax4 + iMax2, getSuggestedMinimumWidth()), i2, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16);
        if (!this.f2917S) {
            z4 = false;
            break;
        }
        int childCount2 = getChildCount();
        for (int i9 = 0; i9 < childCount2; i9++) {
            View childAt2 = getChildAt(i9);
            if (T(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                z4 = false;
                break;
            }
        }
        z4 = true;
        setMeasuredDimension(iResolveSizeAndState, z4 ? 0 : iResolveSizeAndState2);
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.a());
        ActionMenuView actionMenuView = this.f2919i;
        androidx.appcompat.view.menu.f fVarY = actionMenuView != null ? actionMenuView.y() : null;
        int i2 = fVar.f2942k;
        if (i2 != 0 && this.f2916R != null && fVarY != null && (menuItemFindItem = fVarY.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (fVar.f2943l) {
            removeCallbacks(this.f2918T);
            post(this.f2918T);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        h();
        this.f2903B.d(i2 == 1);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.h hVar;
        f fVar = new f(super.onSaveInstanceState());
        d dVar = this.f2916R;
        if (dVar != null && (hVar = dVar.f2939j) != null) {
            fVar.f2942k = hVar.getItemId();
        }
        ActionMenuView actionMenuView = this.f2919i;
        fVar.f2943l = actionMenuView != null && actionMenuView.v();
        return fVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2911J = false;
        }
        if (!this.f2911J) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2911J = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2911J = false;
        }
        return true;
    }

    public final int p() {
        if (s() != null) {
            N n2 = this.f2903B;
            return Math.max(n2 != null ? n2.b() : 0, Math.max(this.f2904C, 0));
        }
        N n4 = this.f2903B;
        return n4 != null ? n4.b() : 0;
    }

    public final CharSequence r() {
        C0190k c0190k = this.f2922l;
        if (c0190k != null) {
            return c0190k.getContentDescription();
        }
        return null;
    }

    public final Drawable s() {
        C0190k c0190k = this.f2922l;
        if (c0190k != null) {
            return c0190k.getDrawable();
        }
        return null;
    }

    public final CharSequence t() {
        return this.f2908G;
    }

    public final CharSequence u() {
        return this.f2907F;
    }

    public final B w() {
        if (this.P == null) {
            this.P = new W(this);
        }
        return this.P;
    }

    public final boolean x() {
        d dVar = this.f2916R;
        return (dVar == null || dVar.f2939j == null) ? false : true;
    }

    public final boolean y() {
        ActionMenuView actionMenuView = this.f2919i;
        return actionMenuView != null && actionMenuView.t();
    }

    public static class e extends a.C0055a {

        /* renamed from: b, reason: collision with root package name */
        int f2941b;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2941b = 0;
        }

        public e() {
            this.f2941b = 0;
            this.f2312a = 8388627;
        }

        public e(e eVar) {
            super((a.C0055a) eVar);
            this.f2941b = 0;
            this.f2941b = eVar.f2941b;
        }

        public e(a.C0055a c0055a) {
            super(c0055a);
            this.f2941b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2941b = 0;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2941b = 0;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public static class f extends I.a {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: k, reason: collision with root package name */
        int f2942k;

        /* renamed from: l, reason: collision with root package name */
        boolean f2943l;

        final class a implements Parcelable.ClassLoaderCreator<f> {
            a() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new f[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2942k = parcel.readInt();
            this.f2943l = parcel.readInt() != 0;
        }

        @Override // I.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2942k);
            parcel.writeInt(this.f2943l ? 1 : 0);
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
