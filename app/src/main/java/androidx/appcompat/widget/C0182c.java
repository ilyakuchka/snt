package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: androidx.appcompat.widget.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0182c extends androidx.appcompat.view.menu.a {

    /* renamed from: A, reason: collision with root package name */
    RunnableC0059c f2983A;

    /* renamed from: B, reason: collision with root package name */
    private b f2984B;

    /* renamed from: C, reason: collision with root package name */
    final f f2985C;

    /* renamed from: q, reason: collision with root package name */
    d f2986q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2987r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f2988s;

    /* renamed from: t, reason: collision with root package name */
    private int f2989t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    private int f2990v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f2991w;

    /* renamed from: x, reason: collision with root package name */
    private final SparseBooleanArray f2992x;

    /* renamed from: y, reason: collision with root package name */
    e f2993y;

    /* renamed from: z, reason: collision with root package name */
    a f2994z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$a */
    class a extends androidx.appcompat.view.menu.k {
        public a(Context context, androidx.appcompat.view.menu.p pVar, View view) {
            super(context, pVar, view, false, R.attr.actionOverflowMenuStyle, 0);
            if (!((androidx.appcompat.view.menu.h) pVar.getItem()).k()) {
                View view2 = C0182c.this.f2986q;
                e(view2 == null ? (View) ((androidx.appcompat.view.menu.a) C0182c.this).p : view2);
            }
            i(C0182c.this.f2985C);
        }

        @Override // androidx.appcompat.view.menu.k
        protected final void d() {
            C0182c.this.f2994z = null;
            super.d();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$b */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public final m.b a() {
            a aVar = C0182c.this.f2994z;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    class RunnableC0059c implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private e f2997i;

        public RunnableC0059c(e eVar) {
            this.f2997i = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((androidx.appcompat.view.menu.a) C0182c.this).f2486k != null) {
                ((androidx.appcompat.view.menu.a) C0182c.this).f2486k.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) C0182c.this).p;
            if (view != null && view.getWindowToken() != null && this.f2997i.l()) {
                C0182c.this.f2993y = this.f2997i;
            }
            C0182c.this.f2983A = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$d */
    private class d extends AppCompatImageView implements ActionMenuView.a {

        /* renamed from: androidx.appcompat.widget.c$d$a */
        final class a extends F {
            a(View view) {
                super(view);
            }

            @Override // androidx.appcompat.widget.F
            public final m.b b() {
                e eVar = C0182c.this.f2993y;
                if (eVar == null) {
                    return null;
                }
                return eVar.b();
            }

            @Override // androidx.appcompat.widget.F
            public final boolean c() {
                C0182c.this.A();
                return true;
            }

            @Override // androidx.appcompat.widget.F
            public final boolean d() {
                C0182c c0182c = C0182c.this;
                if (c0182c.f2983A != null) {
                    return false;
                }
                c0182c.u();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setTooltipText(getContentDescription());
            setOnTouchListener(new a(this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean c() {
            return false;
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0182c.this.A();
            return true;
        }

        @Override // android.widget.ImageView
        protected final boolean setFrame(int i2, int i4, int i5, int i6) {
            boolean frame = super.setFrame(i2, i4, i5, i6);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$e */
    private class e extends androidx.appcompat.view.menu.k {
        public e(Context context, androidx.appcompat.view.menu.f fVar, View view) {
            super(context, fVar, view, true, R.attr.actionOverflowMenuStyle, 0);
            g();
            i(C0182c.this.f2985C);
        }

        @Override // androidx.appcompat.view.menu.k
        protected final void d() {
            if (((androidx.appcompat.view.menu.a) C0182c.this).f2486k != null) {
                ((androidx.appcompat.view.menu.a) C0182c.this).f2486k.e(true);
            }
            C0182c.this.f2993y = null;
            super.d();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$f */
    private class f implements l.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z4) {
            if (fVar instanceof androidx.appcompat.view.menu.p) {
                fVar.q().e(false);
            }
            l.a aVarI = C0182c.this.i();
            if (aVarI != null) {
                aVarI.a(fVar, z4);
            }
        }

        @Override // androidx.appcompat.view.menu.l.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            if (fVar == ((androidx.appcompat.view.menu.a) C0182c.this).f2486k) {
                return false;
            }
            C0182c c0182c = C0182c.this;
            Objects.requireNonNull(((androidx.appcompat.view.menu.p) fVar).getItem());
            Objects.requireNonNull(c0182c);
            l.a aVarI = C0182c.this.i();
            if (aVarI != null) {
                return aVarI.b(fVar);
            }
            return false;
        }
    }

    public C0182c(Context context) {
        super(context);
        this.f2992x = new SparseBooleanArray();
        this.f2985C = new f();
    }

    public final boolean A() {
        androidx.appcompat.view.menu.f fVar;
        if (!this.f2987r || v() || (fVar = this.f2486k) == null || this.p == null || this.f2983A != null || fVar.p().isEmpty()) {
            return false;
        }
        RunnableC0059c runnableC0059c = new RunnableC0059c(new e(this.f2485j, this.f2486k, this.f2986q));
        this.f2983A = runnableC0059c;
        ((View) this.p).post(runnableC0059c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.l
    public final void a(androidx.appcompat.view.menu.f fVar, boolean z4) {
        t();
        super.a(fVar, z4);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.l
    public final void c(Context context, androidx.appcompat.view.menu.f fVar) {
        super.c(context, fVar);
        Resources resources = context.getResources();
        l.a aVarB = l.a.b(context);
        if (!this.f2988s) {
            this.f2987r = true;
        }
        this.f2989t = aVarB.c();
        this.f2990v = aVarB.d();
        int measuredWidth = this.f2989t;
        if (this.f2987r) {
            if (this.f2986q == null) {
                this.f2986q = new d(this.f2484i);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f2986q.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f2986q.getMeasuredWidth();
        } else {
            this.f2986q = null;
        }
        this.u = measuredWidth;
        float f4 = resources.getDisplayMetrics().density;
    }

    @Override // androidx.appcompat.view.menu.a
    public final void f(androidx.appcompat.view.menu.h hVar, m.a aVar) {
        aVar.b(hVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.e((ActionMenuView) this.p);
        if (this.f2984B == null) {
            this.f2984B = new b();
        }
        actionMenuItemView.f(this.f2984B);
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean flagActionItems() {
        ArrayList<androidx.appcompat.view.menu.h> arrayListR;
        int size;
        boolean z4;
        boolean z5;
        androidx.appcompat.view.menu.f fVar = this.f2486k;
        View view = null;
        boolean z6 = false;
        if (fVar != null) {
            arrayListR = fVar.r();
            size = arrayListR.size();
        } else {
            arrayListR = null;
            size = 0;
        }
        int i2 = this.f2990v;
        int i4 = this.u;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.p;
        int i5 = 0;
        boolean z7 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            z4 = true;
            if (i5 >= size) {
                break;
            }
            androidx.appcompat.view.menu.h hVar = arrayListR.get(i5);
            if (hVar.n()) {
                i6++;
            } else if (hVar.m()) {
                i7++;
            } else {
                z7 = true;
            }
            if (this.f2991w && hVar.isActionViewExpanded()) {
                i2 = 0;
            }
            i5++;
        }
        if (this.f2987r && (z7 || i7 + i6 > i2)) {
            i2--;
        }
        int i8 = i2 - i6;
        SparseBooleanArray sparseBooleanArray = this.f2992x;
        sparseBooleanArray.clear();
        int i9 = 0;
        int i10 = 0;
        while (i9 < size) {
            androidx.appcompat.view.menu.h hVar2 = arrayListR.get(i9);
            if (hVar2.n()) {
                View viewJ = j(hVar2, view, viewGroup);
                viewJ.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewJ.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i10 == 0) {
                    i10 = measuredWidth;
                }
                int groupId = hVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, z4);
                }
                hVar2.s(z4);
                z5 = z6;
            } else if (hVar2.m()) {
                int groupId2 = hVar2.getGroupId();
                boolean z8 = sparseBooleanArray.get(groupId2);
                boolean z9 = ((i8 > 0 || z8) && i4 > 0) ? z4 : z6;
                if (z9) {
                    View viewJ2 = j(hVar2, view, viewGroup);
                    viewJ2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewJ2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i10 == 0) {
                        i10 = measuredWidth2;
                    }
                    z9 &= i4 + i10 > 0 ? z4 : false;
                }
                boolean z10 = z9;
                if (z10 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, z4);
                } else if (z8) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i11 = 0; i11 < i9; i11++) {
                        androidx.appcompat.view.menu.h hVar3 = arrayListR.get(i11);
                        if (hVar3.getGroupId() == groupId2) {
                            if (hVar3.k()) {
                                i8++;
                            }
                            hVar3.s(false);
                        }
                    }
                }
                if (z10) {
                    i8--;
                }
                hVar2.s(z10);
                z5 = false;
            } else {
                z5 = z6;
                hVar2.s(z5);
            }
            i9++;
            z6 = z5;
            view = null;
            z4 = true;
        }
        return z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.l
    public final boolean g(androidx.appcompat.view.menu.p pVar) {
        boolean z4 = false;
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.p pVar2 = pVar;
        while (pVar2.Q() != this.f2486k) {
            pVar2 = (androidx.appcompat.view.menu.p) pVar2.Q();
        }
        MenuItem item = pVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.p;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i2);
                if ((childAt instanceof m.a) && ((m.a) childAt).getItemData() == item) {
                    view = childAt;
                    break;
                }
                i2++;
            }
        }
        if (view == null) {
            return false;
        }
        Objects.requireNonNull(pVar.getItem());
        int size = pVar.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            MenuItem item2 = pVar.getItem(i4);
            if (item2.isVisible() && item2.getIcon() != null) {
                z4 = true;
                break;
            }
            i4++;
        }
        a aVar = new a(this.f2485j, pVar, view);
        this.f2994z = aVar;
        aVar.f(z4);
        this.f2994z.j();
        super.g(pVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public final boolean h(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f2986q) {
            return false;
        }
        viewGroup.removeViewAt(i2);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public final View j(androidx.appcompat.view.menu.h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.i()) {
            actionView = super.j(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public final androidx.appcompat.view.menu.m k(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.m mVar = this.p;
        androidx.appcompat.view.menu.m mVarK = super.k(viewGroup);
        if (mVar != mVarK) {
            ((ActionMenuView) mVarK).D(this);
        }
        return mVarK;
    }

    @Override // androidx.appcompat.view.menu.a
    public final boolean l(androidx.appcompat.view.menu.h hVar) {
        return hVar.k();
    }

    public final boolean t() {
        boolean z4;
        boolean zU = u();
        a aVar = this.f2994z;
        if (aVar != null) {
            aVar.a();
            z4 = true;
        } else {
            z4 = false;
        }
        return z4 | zU;
    }

    public final boolean u() {
        Object obj;
        RunnableC0059c runnableC0059c = this.f2983A;
        if (runnableC0059c != null && (obj = this.p) != null) {
            ((View) obj).removeCallbacks(runnableC0059c);
            this.f2983A = null;
            return true;
        }
        e eVar = this.f2993y;
        if (eVar == null) {
            return false;
        }
        eVar.a();
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.l
    public final void updateMenuView(boolean z4) {
        super.updateMenuView(z4);
        ((View) this.p).requestLayout();
        androidx.appcompat.view.menu.f fVar = this.f2486k;
        boolean z5 = false;
        if (fVar != null) {
            ArrayList<androidx.appcompat.view.menu.h> arrayListL = fVar.l();
            int size = arrayListL.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayListL.get(i2).b();
            }
        }
        androidx.appcompat.view.menu.f fVar2 = this.f2486k;
        ArrayList<androidx.appcompat.view.menu.h> arrayListP = fVar2 != null ? fVar2.p() : null;
        if (this.f2987r && arrayListP != null) {
            int size2 = arrayListP.size();
            if (size2 == 1) {
                z5 = !arrayListP.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z5 = true;
            }
        }
        if (z5) {
            if (this.f2986q == null) {
                this.f2986q = new d(this.f2484i);
            }
            ViewGroup viewGroup = (ViewGroup) this.f2986q.getParent();
            if (viewGroup != this.p) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2986q);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.p;
                d dVar = this.f2986q;
                ActionMenuView.c cVarGenerateDefaultLayoutParams = actionMenuView.generateDefaultLayoutParams();
                cVarGenerateDefaultLayoutParams.f2696a = true;
                actionMenuView.addView(dVar, cVarGenerateDefaultLayoutParams);
            }
        } else {
            d dVar2 = this.f2986q;
            if (dVar2 != null) {
                Object parent = dVar2.getParent();
                Object obj = this.p;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f2986q);
                }
            }
        }
        ((ActionMenuView) this.p).B(this.f2987r);
    }

    public final boolean v() {
        e eVar = this.f2993y;
        return eVar != null && eVar.c();
    }

    public final void w() {
        this.f2990v = l.a.b(this.f2485j).d();
        androidx.appcompat.view.menu.f fVar = this.f2486k;
        if (fVar != null) {
            fVar.x(true);
        }
    }

    public final void x() {
        this.f2991w = true;
    }

    public final void y(ActionMenuView actionMenuView) {
        this.p = actionMenuView;
        actionMenuView.b(this.f2486k);
    }

    public final void z() {
        this.f2987r = true;
        this.f2988s = true;
    }
}
