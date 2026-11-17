package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.G;
import java.util.Objects;

/* loaded from: classes.dex */
public class ActionMenuView extends G implements f.b, androidx.appcompat.view.menu.m {

    /* renamed from: A, reason: collision with root package name */
    private boolean f2684A;

    /* renamed from: B, reason: collision with root package name */
    private C0182c f2685B;

    /* renamed from: C, reason: collision with root package name */
    private l.a f2686C;

    /* renamed from: D, reason: collision with root package name */
    f.a f2687D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f2688E;

    /* renamed from: F, reason: collision with root package name */
    private int f2689F;

    /* renamed from: G, reason: collision with root package name */
    private int f2690G;

    /* renamed from: H, reason: collision with root package name */
    private int f2691H;

    /* renamed from: I, reason: collision with root package name */
    e f2692I;

    /* renamed from: x, reason: collision with root package name */
    private androidx.appcompat.view.menu.f f2693x;

    /* renamed from: y, reason: collision with root package name */
    private Context f2694y;

    /* renamed from: z, reason: collision with root package name */
    private int f2695z;

    public interface a {
        boolean a();

        boolean c();
    }

    private static class b implements l.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z4) {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            return false;
        }
    }

    public static class c extends G.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f2696a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f2697b;

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f2698c;

        @ViewDebug.ExportedProperty
        public boolean d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f2699e;

        /* renamed from: f, reason: collision with root package name */
        boolean f2700f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f2696a = cVar.f2696a;
        }

        public c() {
            super(-2);
            this.f2696a = false;
        }
    }

    private class d implements f.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.f2692I;
            if (eVar == null) {
                return false;
            }
            Objects.requireNonNull(Toolbar.this);
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f fVar) {
            f.a aVar = ActionMenuView.this.f2687D;
            if (aVar != null) {
                aVar.b(fVar);
            }
        }
    }

    public interface e {
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n();
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f2690G = (int) (56.0f * f4);
        this.f2691H = (int) (f4 * 4.0f);
        this.f2694y = context;
        this.f2695z = 0;
    }

    static int x(View view, int i2, int i4, int i5, int i6) {
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5) - i6, View.MeasureSpec.getMode(i5));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z4 = false;
        boolean z5 = actionMenuItemView != null && actionMenuItemView.d();
        int i7 = 2;
        if (i4 <= 0 || (z5 && i4 < 2)) {
            i7 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i4 * i2, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i8 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i8++;
            }
            if (!z5 || i8 >= 2) {
                i7 = i8;
            }
        }
        if (!cVar.f2696a && z5) {
            z4 = true;
        }
        cVar.d = z4;
        cVar.f2697b = i7;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i7, 1073741824), iMakeMeasureSpec);
        return i7;
    }

    public final void A() {
        this.f2686C = null;
        this.f2687D = null;
    }

    public final void B(boolean z4) {
        this.f2684A = z4;
    }

    public final void C(int i2) {
        if (this.f2695z != i2) {
            this.f2695z = i2;
            if (i2 == 0) {
                this.f2694y = getContext();
            } else {
                this.f2694y = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public final void D(C0182c c0182c) {
        this.f2685B = c0182c;
        c0182c.y(this);
    }

    public final boolean E() {
        C0182c c0182c = this.f2685B;
        return c0182c != null && c0182c.A();
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean a(androidx.appcompat.view.menu.h hVar) {
        return this.f2693x.z(hVar, null, 0);
    }

    @Override // androidx.appcompat.view.menu.m
    public final void b(androidx.appcompat.view.menu.f fVar) {
        this.f2693x = fVar;
    }

    @Override // androidx.appcompat.widget.G, android.view.ViewGroup
    protected final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.G
    /* renamed from: h */
    public final G.a generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public final void o() {
        C0182c c0182c = this.f2685B;
        if (c0182c != null) {
            c0182c.t();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0182c c0182c = this.f2685B;
        if (c0182c != null) {
            c0182c.updateMenuView(false);
            if (this.f2685B.v()) {
                this.f2685B.u();
                this.f2685B.A();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0182c c0182c = this.f2685B;
        if (c0182c != null) {
            c0182c.t();
        }
    }

    @Override // androidx.appcompat.widget.G, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int width;
        int paddingLeft;
        if (!this.f2688E) {
            super.onLayout(z4, i2, i4, i5, i6);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i6 - i4) / 2;
        int iK = k();
        int i8 = i5 - i2;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zB = Y.b(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2696a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (s(i11)) {
                        measuredWidth += iK;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    s(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int iMax = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f2696a) {
                    int i17 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f2696a) {
                int i20 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax + i20;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    @Override // androidx.appcompat.widget.G, android.view.View
    protected final void onMeasure(int i2, int i4) {
        int i5;
        boolean z4;
        int i6;
        int i7;
        boolean z5;
        int i8;
        ?? r32;
        androidx.appcompat.view.menu.f fVar;
        boolean z6 = this.f2688E;
        boolean z7 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.f2688E = z7;
        if (z6 != z7) {
            this.f2689F = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.f2688E && (fVar = this.f2693x) != null && size != this.f2689F) {
            this.f2689F = size;
            fVar.x(true);
        }
        int childCount = getChildCount();
        if (!this.f2688E || childCount <= 0) {
            for (int i9 = 0; i9 < childCount; i9++) {
                c cVar = (c) getChildAt(i9).getLayoutParams();
                ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
            }
            super.onMeasure(i2, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i2);
        int size3 = View.MeasureSpec.getSize(i4);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, paddingBottom, -2);
        int i10 = size2 - paddingRight;
        int i11 = this.f2690G;
        int i12 = i10 / i11;
        int i13 = i10 % i11;
        if (i12 == 0) {
            setMeasuredDimension(i10, 0);
            return;
        }
        int i14 = (i13 / i12) + i11;
        int childCount2 = getChildCount();
        int i15 = 0;
        int iMax = 0;
        int iMax2 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z8 = false;
        long j2 = 0;
        while (i17 < childCount2) {
            View childAt = getChildAt(i17);
            int i18 = size3;
            int i19 = i10;
            if (childAt.getVisibility() != 8) {
                boolean z9 = childAt instanceof ActionMenuItemView;
                int i20 = i15 + 1;
                if (z9) {
                    int i21 = this.f2691H;
                    i8 = i20;
                    r32 = 0;
                    childAt.setPadding(i21, 0, i21, 0);
                } else {
                    i8 = i20;
                    r32 = 0;
                }
                c cVar2 = (c) childAt.getLayoutParams();
                cVar2.f2700f = r32;
                cVar2.f2698c = r32;
                cVar2.f2697b = r32;
                cVar2.d = r32;
                ((LinearLayout.LayoutParams) cVar2).leftMargin = r32;
                ((LinearLayout.LayoutParams) cVar2).rightMargin = r32;
                cVar2.f2699e = z9 && ((ActionMenuItemView) childAt).d();
                int iX = x(childAt, i14, cVar2.f2696a ? 1 : i12, childMeasureSpec, paddingBottom);
                iMax2 = Math.max(iMax2, iX);
                if (cVar2.d) {
                    i16++;
                }
                if (cVar2.f2696a) {
                    z8 = true;
                }
                i12 -= iX;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iX == 1) {
                    j2 |= 1 << i17;
                }
                i15 = i8;
            }
            i17++;
            size3 = i18;
            i10 = i19;
        }
        int i22 = i10;
        int i23 = size3;
        boolean z10 = z8 && i15 == 2;
        boolean z11 = false;
        while (i16 > 0 && i12 > 0) {
            int i24 = Integer.MAX_VALUE;
            int i25 = 0;
            int i26 = 0;
            long j4 = 0;
            while (i25 < childCount2) {
                int i27 = iMax;
                c cVar3 = (c) getChildAt(i25).getLayoutParams();
                boolean z12 = z11;
                if (cVar3.d) {
                    int i28 = cVar3.f2697b;
                    if (i28 < i24) {
                        j4 = 1 << i25;
                        i24 = i28;
                        i26 = 1;
                    } else if (i28 == i24) {
                        i26++;
                        j4 |= 1 << i25;
                    }
                }
                i25++;
                z11 = z12;
                iMax = i27;
            }
            i5 = iMax;
            z4 = z11;
            j2 |= j4;
            if (i26 > i12) {
                break;
            }
            int i29 = i24 + 1;
            int i30 = 0;
            while (i30 < childCount2) {
                View childAt2 = getChildAt(i30);
                c cVar4 = (c) childAt2.getLayoutParams();
                int i31 = i16;
                long j5 = 1 << i30;
                if ((j4 & j5) == 0) {
                    if (cVar4.f2697b == i29) {
                        j2 |= j5;
                    }
                    z5 = z10;
                } else {
                    if (z10 && cVar4.f2699e && i12 == 1) {
                        int i32 = this.f2691H;
                        z5 = z10;
                        childAt2.setPadding(i32 + i14, 0, i32, 0);
                    } else {
                        z5 = z10;
                    }
                    cVar4.f2697b++;
                    cVar4.f2700f = true;
                    i12--;
                }
                i30++;
                i16 = i31;
                z10 = z5;
            }
            iMax = i5;
            z11 = true;
        }
        i5 = iMax;
        z4 = z11;
        boolean z13 = !z8 && i15 == 1;
        if (i12 > 0 && j2 != 0 && (i12 < i15 - 1 || z13 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j2);
            if (!z13) {
                if ((j2 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f2699e) {
                    fBitCount -= 0.5f;
                }
                int i33 = childCount2 - 1;
                if ((j2 & (1 << i33)) != 0 && !((c) getChildAt(i33).getLayoutParams()).f2699e) {
                    fBitCount -= 0.5f;
                }
            }
            int i34 = fBitCount > 0.0f ? (int) ((i12 * i14) / fBitCount) : 0;
            for (int i35 = 0; i35 < childCount2; i35++) {
                if ((j2 & (1 << i35)) != 0) {
                    View childAt3 = getChildAt(i35);
                    c cVar5 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar5.f2698c = i34;
                        cVar5.f2700f = true;
                        if (i35 == 0 && !cVar5.f2699e) {
                            ((LinearLayout.LayoutParams) cVar5).leftMargin = (-i34) / 2;
                        }
                        z4 = true;
                    } else if (cVar5.f2696a) {
                        cVar5.f2698c = i34;
                        cVar5.f2700f = true;
                        ((LinearLayout.LayoutParams) cVar5).rightMargin = (-i34) / 2;
                        z4 = true;
                    } else {
                        if (i35 != 0) {
                            ((LinearLayout.LayoutParams) cVar5).leftMargin = i34 / 2;
                        }
                        if (i35 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) cVar5).rightMargin = i34 / 2;
                        }
                    }
                }
            }
        }
        if (z4) {
            for (int i36 = 0; i36 < childCount2; i36++) {
                View childAt4 = getChildAt(i36);
                c cVar6 = (c) childAt4.getLayoutParams();
                if (cVar6.f2700f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar6.f2697b * i14) + cVar6.f2698c, 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode != 1073741824) {
            i7 = i22;
            i6 = i5;
        } else {
            i6 = i23;
            i7 = i22;
        }
        setMeasuredDimension(i7, i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.G, android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final c generateDefaultLayoutParams() {
        c cVar = new c();
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.G
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public final Menu r() {
        if (this.f2693x == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
            this.f2693x = fVar;
            fVar.E(new d());
            C0182c c0182c = new C0182c(context);
            this.f2685B = c0182c;
            c0182c.z();
            C0182c c0182c2 = this.f2685B;
            l.a bVar = this.f2686C;
            if (bVar == null) {
                bVar = new b();
            }
            c0182c2.d(bVar);
            this.f2693x.c(this.f2685B, this.f2694y);
            this.f2685B.y(this);
        }
        return this.f2693x;
    }

    protected final boolean s(int i2) {
        boolean zA = false;
        if (i2 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i2 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            zA = false | ((a) childAt).a();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).c();
    }

    public final boolean t() {
        C0182c c0182c = this.f2685B;
        return c0182c != null && c0182c.u();
    }

    public final boolean u() {
        C0182c c0182c = this.f2685B;
        if (c0182c != null) {
            if (c0182c.f2983A != null || c0182c.v()) {
                return true;
            }
        }
        return false;
    }

    public final boolean v() {
        C0182c c0182c = this.f2685B;
        return c0182c != null && c0182c.v();
    }

    public final boolean w() {
        return this.f2684A;
    }

    public final androidx.appcompat.view.menu.f y() {
        return this.f2693x;
    }

    public final void z() {
        this.f2685B.x();
    }

    @Override // androidx.appcompat.widget.G, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }
}
