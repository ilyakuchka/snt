package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.K;
import com.android.mmt.R;

/* loaded from: classes.dex */
final class o extends j implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: A, reason: collision with root package name */
    private int f2612A;

    /* renamed from: C, reason: collision with root package name */
    private boolean f2614C;

    /* renamed from: j, reason: collision with root package name */
    private final Context f2615j;

    /* renamed from: k, reason: collision with root package name */
    private final f f2616k;

    /* renamed from: l, reason: collision with root package name */
    private final e f2617l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f2618m;

    /* renamed from: n, reason: collision with root package name */
    private final int f2619n;

    /* renamed from: o, reason: collision with root package name */
    private final int f2620o;
    private final int p;

    /* renamed from: q, reason: collision with root package name */
    final K f2621q;

    /* renamed from: t, reason: collision with root package name */
    private PopupWindow.OnDismissListener f2624t;
    private View u;

    /* renamed from: v, reason: collision with root package name */
    View f2625v;

    /* renamed from: w, reason: collision with root package name */
    private l.a f2626w;

    /* renamed from: x, reason: collision with root package name */
    ViewTreeObserver f2627x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f2628y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f2629z;

    /* renamed from: r, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f2622r = new a();

    /* renamed from: s, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f2623s = new b();

    /* renamed from: B, reason: collision with root package name */
    private int f2613B = 0;

    final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (!o.this.isShowing() || o.this.f2621q.k()) {
                return;
            }
            View view = o.this.f2625v;
            if (view == null || !view.isShown()) {
                o.this.dismiss();
            } else {
                o.this.f2621q.f();
            }
        }
    }

    final class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = o.this.f2627x;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    o.this.f2627x = view.getViewTreeObserver();
                }
                o oVar = o.this;
                oVar.f2627x.removeGlobalOnLayoutListener(oVar.f2622r);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public o(Context context, f fVar, View view, int i2, int i4, boolean z4) {
        this.f2615j = context;
        this.f2616k = fVar;
        this.f2618m = z4;
        this.f2617l = new e(fVar, LayoutInflater.from(context), z4, R.layout.abc_popup_menu_item_layout);
        this.f2620o = i2;
        this.p = i4;
        Resources resources = context.getResources();
        this.f2619n = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.u = view;
        this.f2621q = new K(context, i2, i4);
        fVar.c(this, context);
    }

    @Override // androidx.appcompat.view.menu.l
    public final void a(f fVar, boolean z4) {
        if (fVar != this.f2616k) {
            return;
        }
        dismiss();
        l.a aVar = this.f2626w;
        if (aVar != null) {
            aVar.a(fVar, z4);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public final void d(l.a aVar) {
        this.f2626w = aVar;
    }

    @Override // m.b
    public final void dismiss() {
        if (isShowing()) {
            this.f2621q.dismiss();
        }
    }

    @Override // m.b
    public final void f() {
        View view;
        boolean z4 = true;
        if (!isShowing()) {
            if (this.f2628y || (view = this.u) == null) {
                z4 = false;
            } else {
                this.f2625v = view;
                this.f2621q.s(this);
                this.f2621q.t(this);
                this.f2621q.r();
                View view2 = this.f2625v;
                boolean z5 = this.f2627x == null;
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.f2627x = viewTreeObserver;
                if (z5) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f2622r);
                }
                view2.addOnAttachStateChangeListener(this.f2623s);
                this.f2621q.l(view2);
                this.f2621q.o(this.f2613B);
                if (!this.f2629z) {
                    this.f2612A = j.k(this.f2617l, this.f2615j, this.f2619n);
                    this.f2629z = true;
                }
                this.f2621q.n(this.f2612A);
                this.f2621q.q();
                this.f2621q.p(j());
                this.f2621q.f();
                ListView listViewH = this.f2621q.h();
                listViewH.setOnKeyListener(this);
                if (this.f2614C && this.f2616k.f2552m != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f2615j).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewH, false);
                    TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                    if (textView != null) {
                        textView.setText(this.f2616k.f2552m);
                    }
                    frameLayout.setEnabled(false);
                    listViewH.addHeaderView(frameLayout, null, false);
                }
                this.f2621q.setAdapter(this.f2617l);
                this.f2621q.f();
            }
        }
        if (!z4) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean g(p pVar) {
        if (pVar.hasVisibleItems()) {
            k kVar = new k(this.f2615j, pVar, this.f2625v, this.f2618m, this.f2620o, this.p);
            kVar.i(this.f2626w);
            kVar.f(j.t(pVar));
            kVar.h(this.f2624t);
            this.f2624t = null;
            this.f2616k.e(false);
            int horizontalOffset = this.f2621q.getHorizontalOffset();
            int verticalOffset = this.f2621q.getVerticalOffset();
            int i2 = this.f2613B;
            View view = this.u;
            int i4 = androidx.core.view.o.d;
            if ((Gravity.getAbsoluteGravity(i2, view.getLayoutDirection()) & 7) == 5) {
                horizontalOffset += this.u.getWidth();
            }
            if (kVar.m(horizontalOffset, verticalOffset)) {
                l.a aVar = this.f2626w;
                if (aVar == null) {
                    return true;
                }
                aVar.b(pVar);
                return true;
            }
        }
        return false;
    }

    @Override // m.b
    public final ListView h() {
        return this.f2621q.h();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void i(f fVar) {
    }

    @Override // m.b
    public final boolean isShowing() {
        return !this.f2628y && this.f2621q.isShowing();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void l(View view) {
        this.u = view;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void n(boolean z4) {
        this.f2617l.e(z4);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void o(int i2) {
        this.f2613B = i2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f2628y = true;
        this.f2616k.e(true);
        ViewTreeObserver viewTreeObserver = this.f2627x;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f2627x = this.f2625v.getViewTreeObserver();
            }
            this.f2627x.removeGlobalOnLayoutListener(this.f2622r);
            this.f2627x = null;
        }
        this.f2625v.removeOnAttachStateChangeListener(this.f2623s);
        PopupWindow.OnDismissListener onDismissListener = this.f2624t;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void p(int i2) {
        this.f2621q.setHorizontalOffset(i2);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.f2624t = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void r(boolean z4) {
        this.f2614C = z4;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void s(int i2) {
        this.f2621q.setVerticalOffset(i2);
    }

    @Override // androidx.appcompat.view.menu.l
    public final void updateMenuView(boolean z4) {
        this.f2629z = false;
        e eVar = this.f2617l;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }
}
