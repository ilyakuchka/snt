package miuix.appcompat.internal.app.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.a;
import androidx.fragment.app.ActivityC0219o;
import androidx.fragment.app.E;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.Objects;
import miuix.appcompat.app.b;
import miuix.appcompat.internal.view.menu.action.PhoneActionMenuView;
import miuix.view.e;
import t3.C0386a;
import t3.C0387b;
import t3.C0388c;
import t3.C0389d;

/* loaded from: classes.dex */
public final class d extends miuix.appcompat.app.b {

    /* renamed from: E, reason: collision with root package name */
    private static final a.d f6944E = new a();

    /* renamed from: A, reason: collision with root package name */
    private final C0387b.a f6945A;

    /* renamed from: B, reason: collision with root package name */
    private int f6946B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f6947C;

    /* renamed from: D, reason: collision with root package name */
    private int f6948D;

    /* renamed from: a, reason: collision with root package name */
    C0387b f6949a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f6950b;

    /* renamed from: c, reason: collision with root package name */
    private Context f6951c;
    private ActionBarOverlayLayout d;

    /* renamed from: e, reason: collision with root package name */
    private ActionBarContainer f6952e;

    /* renamed from: f, reason: collision with root package name */
    private ActionBarView f6953f;
    private ActionBarContextView g;

    /* renamed from: h, reason: collision with root package name */
    private ActionBarContainer f6954h;

    /* renamed from: i, reason: collision with root package name */
    private PhoneActionMenuView f6955i;

    /* renamed from: j, reason: collision with root package name */
    private View f6956j;

    /* renamed from: k, reason: collision with root package name */
    private View.OnClickListener f6957k;

    /* renamed from: l, reason: collision with root package name */
    private g f6958l;

    /* renamed from: m, reason: collision with root package name */
    private j f6959m;

    /* renamed from: n, reason: collision with root package name */
    private l f6960n;

    /* renamed from: o, reason: collision with root package name */
    private o f6961o;
    private p p;

    /* renamed from: q, reason: collision with root package name */
    private ViewGroup f6962q;

    /* renamed from: s, reason: collision with root package name */
    private C0119d f6964s;

    /* renamed from: t, reason: collision with root package name */
    private w f6965t;

    /* renamed from: v, reason: collision with root package name */
    private int f6966v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f6967w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f6968x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f6969y;

    /* renamed from: z, reason: collision with root package name */
    private SearchActionModeView f6970z;

    /* renamed from: r, reason: collision with root package name */
    private final ArrayList<C0119d> f6963r = new ArrayList<>();
    private int u = -1;

    final class a implements a.d {
        a() {
        }

        @Override // androidx.appcompat.app.a.d
        public final void a(a.c cVar, E e2) {
            C0119d c0119d = (C0119d) cVar;
            if (c0119d.f6973a != null) {
                c0119d.f6973a.a(cVar, e2);
            }
        }

        @Override // androidx.appcompat.app.a.d
        public final void b(a.c cVar, E e2) {
            C0119d c0119d = (C0119d) cVar;
            if (c0119d.f6973a != null) {
                c0119d.f6973a.b(cVar, e2);
            }
        }

        @Override // androidx.appcompat.app.a.d
        public final void c(a.c cVar, E e2) {
            C0119d c0119d = (C0119d) cVar;
            if (c0119d.f6973a != null) {
                c0119d.f6973a.c(cVar, e2);
            }
        }
    }

    final class b implements C0387b.a {
        b() {
        }

        @Override // t3.C0387b.a
        public final void a() {
            d.this.D(false);
            d.this.f6949a = null;
        }
    }

    final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (d.this.f6955i == null || !d.this.f6955i.k()) {
                return;
            }
            d.this.f6955i.f().k(true);
        }
    }

    /* renamed from: miuix.appcompat.internal.app.widget.d$d, reason: collision with other inner class name */
    public class C0119d extends a.c {

        /* renamed from: a, reason: collision with root package name */
        private a.d f6973a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f6974b;

        /* renamed from: c, reason: collision with root package name */
        private int f6975c = -1;
        public boolean d = true;

        public C0119d() {
        }

        @Override // androidx.appcompat.app.a.c
        public final void a() {
        }

        @Override // androidx.appcompat.app.a.c
        public final void b() {
        }

        @Override // androidx.appcompat.app.a.c
        public final void c() {
        }

        @Override // androidx.appcompat.app.a.c
        public final int d() {
            return this.f6975c;
        }

        @Override // androidx.appcompat.app.a.c
        public final CharSequence e() {
            return this.f6974b;
        }

        @Override // androidx.appcompat.app.a.c
        public final void f() {
            d.this.f(this);
        }

        @Override // androidx.appcompat.app.a.c
        public final a.c g(CharSequence charSequence) {
            this.f6974b = charSequence;
            if (this.f6975c >= 0) {
                d.this.f6959m.o(this.f6975c);
                d.this.f6960n.o(this.f6975c);
                d.this.f6961o.o(this.f6975c);
                d.this.f6961o.o(this.f6975c);
            }
            return this;
        }

        public final a.c i(a.d dVar) {
            this.f6973a = dVar;
            return this;
        }

        public final void j(int i2) {
            this.f6975c = i2;
        }
    }

    public d(miuix.appcompat.app.h hVar, ViewGroup viewGroup) {
        new ArrayList();
        this.f6969y = true;
        this.f6945A = new b();
        this.f6950b = hVar;
        this.f6965t = hVar.u();
        I(viewGroup);
        n(hVar.getTitle());
    }

    private void E() {
        this.f6952e.setTranslationY(-r0.getHeight());
        this.f6952e.setAlpha(0.0f);
        this.f6952e.setVisibility(8);
        ActionBarContainer actionBarContainer = this.f6954h;
        if (actionBarContainer != null) {
            int height = actionBarContainer.getHeight();
            if (this.f6954h.getChildCount() == 1) {
                View childAt = this.f6954h.getChildAt(0);
                if (childAt instanceof PhoneActionMenuView) {
                    PhoneActionMenuView phoneActionMenuView = (PhoneActionMenuView) childAt;
                    if (!phoneActionMenuView.k()) {
                        height = phoneActionMenuView.e();
                    }
                }
            }
            actionBarContainer.setTranslationY(height);
            this.f6954h.setAlpha(0.0f);
            this.f6954h.setVisibility(8);
            Q(false);
        }
    }

    private void F() {
        this.f6952e.setVisibility(this.f6949a instanceof miuix.view.e ? 8 : 0);
        this.f6952e.setTranslationY(0.0f);
        this.f6952e.setAlpha(1.0f);
        ActionBarContainer actionBarContainer = this.f6954h;
        if (actionBarContainer != null) {
            actionBarContainer.setVisibility(0);
            this.f6954h.setTranslationY(0.0f);
            this.f6954h.setAlpha(1.0f);
            Q(true);
        }
    }

    private void G() {
        if (this.f6959m != null) {
            return;
        }
        j jVar = new j(this.f6950b);
        l lVar = new l(this.f6950b);
        o oVar = new o(this.f6950b);
        p pVar = new p(this.f6950b);
        jVar.setVisibility(0);
        lVar.setVisibility(0);
        oVar.setVisibility(0);
        pVar.setVisibility(0);
        this.f6953f.w0(jVar, lVar, oVar, pVar);
        jVar.setHorizontalFadingEdgeEnabled(true);
        this.f6959m = jVar;
        this.f6960n = lVar;
        this.f6961o = oVar;
        this.p = pVar;
    }

    private void M() {
        this.f6952e.q();
        this.f6953f.w0(this.f6959m, this.f6960n, this.f6961o, this.p);
        boolean z4 = this.f6953f.Y() == 2;
        j jVar = this.f6959m;
        if (jVar != null) {
            if (z4) {
                jVar.setVisibility(0);
            } else {
                jVar.setVisibility(8);
            }
            this.f6959m.setHorizontalFadingEdgeEnabled(true);
        }
        l lVar = this.f6960n;
        if (lVar != null) {
            if (z4) {
                lVar.setVisibility(0);
            } else {
                lVar.setVisibility(8);
            }
            this.f6960n.setHorizontalFadingEdgeEnabled(true);
        }
        o oVar = this.f6961o;
        if (oVar != null) {
            if (z4) {
                oVar.setVisibility(0);
            } else {
                oVar.setVisibility(8);
            }
            this.f6961o.setHorizontalFadingEdgeEnabled(true);
        }
        p pVar = this.p;
        if (pVar != null) {
            if (z4) {
                pVar.setVisibility(0);
            } else {
                pVar.setVisibility(8);
            }
            this.p.setHorizontalFadingEdgeEnabled(true);
        }
        Objects.requireNonNull(this.f6953f);
    }

    private void Q(boolean z4) {
        if (this.f6954h.getChildCount() == 2 && (this.f6954h.getChildAt(1) instanceof PhoneActionMenuView)) {
            PhoneActionMenuView phoneActionMenuView = (PhoneActionMenuView) this.f6954h.getChildAt(1);
            this.f6955i = phoneActionMenuView;
            if (!phoneActionMenuView.k() || this.f6956j == null) {
                return;
            }
            if (z4) {
                this.d.m(this.f6957k).b().start();
            } else {
                this.d.m(null).a().start();
            }
        }
    }

    private void R() {
        if (this.f6968x || !this.f6967w) {
            if (this.f6969y) {
                return;
            }
            this.f6969y = true;
            F();
            return;
        }
        if (this.f6969y) {
            this.f6969y = false;
            E();
        }
    }

    public final void C(b.a aVar) {
        this.f6958l.f(aVar);
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [android.view.ViewGroup, miuix.appcompat.internal.app.widget.i] */
    final void D(boolean z4) {
        if (z4) {
            if (!this.f6968x) {
                this.f6968x = true;
                R();
                this.f6946B = this.f6953f.b();
                this.f6947C = this.f6953f.c();
                ViewGroup viewGroup = this.f6962q;
                if (viewGroup instanceof SearchActionModeView) {
                    this.f6953f.j(0, true);
                    w(false);
                } else {
                    ((ActionBarContextView) viewGroup).j(this.f6946B, false);
                    ((ActionBarContextView) this.f6962q).k(this.f6947C);
                }
                this.f6948D = this.f6953f.getImportantForAccessibility();
                this.f6953f.setImportantForAccessibility(4);
                this.f6953f.o0(this.f6962q instanceof SearchActionModeView);
            }
        } else if (this.f6968x) {
            this.f6968x = false;
            this.f6953f.n0();
            R();
            w(true);
            ViewGroup viewGroup2 = this.f6962q;
            if (viewGroup2 instanceof SearchActionModeView) {
                this.f6953f.j(this.f6946B, true);
                w(this.f6947C);
            } else {
                this.f6946B = ((ActionBarContextView) viewGroup2).b();
                this.f6947C = ((ActionBarContextView) this.f6962q).c();
                u(this.f6946B);
                w(this.f6947C);
            }
            this.f6953f.setImportantForAccessibility(this.f6948D);
        }
        this.f6962q.animateToVisibility(z4);
        if (this.f6959m == null || this.f6953f.k0() || !this.f6953f.g0()) {
            return;
        }
        boolean z5 = !z4;
        this.f6959m.setEnabled(z5);
        this.f6960n.setEnabled(z5);
        this.f6961o.setEnabled(z5);
        this.p.setEnabled(z5);
    }

    final ActionBarOverlayLayout H() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void I(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) viewGroup;
        this.d = actionBarOverlayLayout;
        actionBarOverlayLayout.s(this);
        this.f6953f = (ActionBarView) viewGroup.findViewById(R.id.action_bar);
        this.g = (ActionBarContextView) viewGroup.findViewById(R.id.action_context_bar);
        this.f6952e = (ActionBarContainer) viewGroup.findViewById(R.id.action_bar_container);
        this.f6954h = (ActionBarContainer) viewGroup.findViewById(R.id.split_action_bar);
        View viewFindViewById = viewGroup.findViewById(R.id.content_mask);
        this.f6956j = viewFindViewById;
        if (viewFindViewById != null) {
            this.f6957k = new c();
        }
        ActionBarView actionBarView = this.f6953f;
        if (actionBarView == null && this.g == null && this.f6952e == null) {
            throw new IllegalStateException(d.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f6966v = actionBarView.f6934l ? 1 : 0;
        boolean z4 = true;
        Object[] objArr = (actionBarView.W() & 4) != 0;
        C0386a c0386aB = C0386a.b(this.f6950b);
        if (!c0386aB.a() && objArr == false) {
            z4 = false;
        }
        this.f6953f.y0(z4);
        c0386aB.g();
        M();
    }

    final void J(a.c cVar) {
        boolean z4 = this.f6963r.size() == 0;
        G();
        this.f6959m.d(cVar, z4);
        this.f6960n.d(cVar, z4);
        this.f6961o.d(cVar, z4);
        this.p.d(cVar, z4);
        int size = this.f6963r.size();
        C0119d c0119d = (C0119d) cVar;
        c0119d.j(size);
        this.f6963r.add(size, c0119d);
        int size2 = this.f6963r.size();
        while (true) {
            size++;
            if (size >= size2) {
                break;
            } else {
                this.f6963r.get(size).j(size);
            }
        }
        if (z4) {
            f(cVar);
        }
    }

    final void K() {
        if (this.f6964s != null) {
            f(null);
        }
        this.f6963r.clear();
        j jVar = this.f6959m;
        if (jVar != null) {
            jVar.k();
        }
        l lVar = this.f6960n;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f6961o;
        if (oVar != null) {
            oVar.k();
        }
        p pVar = this.p;
        if (pVar != null) {
            pVar.k();
        }
        this.u = -1;
    }

    public final void L() {
        C0386a.b(this.f6950b).g();
        M();
    }

    public final void N(int i2) {
        if (this.f6953f.Y() != 2) {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
        f(this.f6963r.get(i2));
    }

    public final void O(boolean z4) {
        if (this.f6969y) {
            F();
        } else {
            E();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [miuix.appcompat.internal.app.widget.SearchActionModeView] */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.view.ViewGroup, miuix.appcompat.internal.app.widget.i] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.ViewGroup, miuix.appcompat.internal.app.widget.i] */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.view.ViewGroup, miuix.appcompat.internal.app.widget.i] */
    public final ActionMode P(ActionMode.Callback callback) {
        ActionBarContextView actionBarContextView;
        C0387b c0387b = this.f6949a;
        if (c0387b != null) {
            c0387b.finish();
        }
        boolean z4 = callback instanceof e.a;
        C0387b c0389d = z4 ? new C0389d(this.f6950b, callback) : new C0388c(this.f6950b, callback);
        ?? r6 = this.f6962q;
        if (((r6 instanceof SearchActionModeView) && (c0389d instanceof C0389d)) || ((r6 instanceof ActionBarContextView) && (c0389d instanceof C0388c))) {
            r6.closeMode();
            this.f6962q.killMode();
        }
        if (z4) {
            if (this.f6970z == null) {
                SearchActionModeView searchActionModeView = (SearchActionModeView) LayoutInflater.from(c()).inflate(R.layout.miuix_appcompat_search_action_mode_view, (ViewGroup) this.d, false);
                searchActionModeView.setOnBackClickListener(new e(this));
                this.f6970z = searchActionModeView;
            }
            Rect rectG = this.f6952e.g();
            if (rectG != null) {
                this.f6970z.setStatusBarPaddingTop(rectG.top);
            }
            if (this.d != this.f6970z.getParent()) {
                this.d.addView(this.f6970z);
            }
            actionBarContextView = this.f6970z;
        } else {
            ActionBarContextView actionBarContextView2 = this.g;
            actionBarContextView = actionBarContextView2;
            if (actionBarContextView2 == null) {
                throw new IllegalStateException("not set windowSplitActionBar true in activity style!");
            }
        }
        this.f6962q = actionBarContextView;
        if (actionBarContextView == null) {
            throw new IllegalStateException("not set windowSplitActionBar true in activity style!");
        }
        c0389d.k(actionBarContextView);
        c0389d.j(this.f6945A);
        if (!c0389d.i()) {
            return null;
        }
        c0389d.invalidate();
        this.f6962q.initForMode(c0389d);
        D(true);
        ActionBarContainer actionBarContainer = this.f6954h;
        if (actionBarContainer != null && this.f6966v == 1 && actionBarContainer.getVisibility() != 0) {
            this.f6954h.setVisibility(0);
        }
        ViewGroup viewGroup = this.f6962q;
        if (viewGroup instanceof ActionBarContextView) {
            ((ActionBarContextView) viewGroup).sendAccessibilityEvent(32);
        }
        this.f6949a = c0389d;
        return c0389d;
    }

    @Override // androidx.appcompat.app.a
    public final int a() {
        return this.f6953f.W();
    }

    @Override // androidx.appcompat.app.a
    public final a.c b(int i2) {
        return this.f6963r.get(i2);
    }

    @Override // androidx.appcompat.app.a
    public final Context c() {
        if (this.f6951c == null) {
            TypedValue typedValue = new TypedValue();
            this.f6950b.getTheme().resolveAttribute(android.R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f6951c = new ContextThemeWrapper(this.f6950b, i2);
            } else {
                this.f6951c = this.f6950b;
            }
        }
        return this.f6951c;
    }

    @Override // androidx.appcompat.app.a
    public final void d() {
        if (this.f6967w) {
            return;
        }
        this.f6967w = true;
        R();
    }

    @Override // androidx.appcompat.app.a
    public final boolean e() {
        return this.f6969y;
    }

    @Override // androidx.appcompat.app.a
    public final void f(a.c cVar) {
        if (this.f6953f.Y() != 2) {
            this.u = cVar != null ? cVar.d() : -1;
            return;
        }
        E eF = this.f6965t.f();
        eF.j();
        C0119d c0119d = this.f6964s;
        if (c0119d != cVar) {
            this.f6959m.n(cVar != null ? cVar.d() : -1);
            this.f6960n.n(cVar != null ? cVar.d() : -1);
            this.f6961o.n(cVar != null ? cVar.d() : -1);
            this.p.n(cVar != null ? cVar.d() : -1);
            C0119d c0119d2 = this.f6964s;
            if (c0119d2 != null) {
                ((a) f6944E).c(c0119d2, eF);
            }
            C0119d c0119d3 = (C0119d) cVar;
            this.f6964s = c0119d3;
            if (c0119d3 != null) {
                c0119d3.d = true;
                ((a) f6944E).b(c0119d3, eF);
            }
        } else if (c0119d != null) {
            ((a) f6944E).a(c0119d, eF);
            this.f6959m.e(cVar.d());
            this.f6960n.e(cVar.d());
            this.f6961o.e(cVar.d());
            this.p.e(cVar.d());
        }
        if (eF.m()) {
            return;
        }
        eF.g();
    }

    @Override // androidx.appcompat.app.a
    public final void g(boolean z4) {
        this.f6953f.v0((this.f6953f.W() & (-5)) | 4);
    }

    @Override // androidx.appcompat.app.a
    public final void h(int i2) {
        this.f6953f.v0(i2);
    }

    @Override // androidx.appcompat.app.a
    public final void i() {
        this.f6953f.v0((this.f6953f.W() & (-9)) | 8);
    }

    @Override // androidx.appcompat.app.a
    public final void j(boolean z4) {
        this.f6953f.y0(true);
    }

    @Override // androidx.appcompat.app.a
    public final void k(int i2) {
        C0119d c0119d;
        if (this.f6953f.Y() == 2) {
            this.u = (this.f6953f.Y() == 2 && (c0119d = this.f6964s) != null) ? c0119d.d() : -1;
            f(null);
            this.f6959m.setVisibility(8);
            this.f6960n.setVisibility(8);
            this.f6961o.setVisibility(8);
            this.p.setVisibility(8);
        }
        this.f6953f.A0(i2);
        if (i2 == 2) {
            G();
            this.f6959m.setVisibility(0);
            this.f6960n.setVisibility(0);
            this.f6961o.setVisibility(0);
            this.p.setVisibility(0);
            int i4 = this.u;
            if (i4 != -1) {
                N(i4);
                this.u = -1;
            }
        }
        Objects.requireNonNull(this.f6953f);
    }

    @Override // androidx.appcompat.app.a
    public final void l(CharSequence charSequence) {
        this.f6953f.D0(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public final void m(int i2) {
        n(this.f6950b.getString(i2));
    }

    @Override // androidx.appcompat.app.a
    public final void n(CharSequence charSequence) {
        this.f6953f.E0(charSequence);
    }

    @Override // miuix.appcompat.app.b
    public final int o(String str, a.c cVar, Class cls, Bundle bundle) {
        return this.f6958l.e(str, cVar, cls, bundle);
    }

    @Override // miuix.appcompat.app.b
    public final Fragment p(int i2) {
        return this.f6958l.g(i2);
    }

    @Override // miuix.appcompat.app.b
    public final int q() {
        return this.f6958l.h();
    }

    @Override // miuix.appcompat.app.b
    public final boolean r() {
        return this.f6958l != null;
    }

    @Override // miuix.appcompat.app.b
    public final void s() {
        this.f6958l.i();
    }

    @Override // miuix.appcompat.app.b
    public final void t(View view) {
        this.f6953f.x0(view);
    }

    @Override // miuix.appcompat.app.b
    public final void u(int i2) {
        this.f6953f.i(i2);
    }

    @Override // miuix.appcompat.app.b
    public final void v(ActivityC0219o activityC0219o) {
        if (r()) {
            return;
        }
        if (r()) {
            throw new IllegalStateException("Cannot add tab directly in fragment view pager mode!\n Please using addFragmentTab().");
        }
        K();
        k(2);
        w wVar = this.f6965t;
        Objects.requireNonNull(activityC0219o);
        this.f6958l = new g(this, wVar);
        C(this.f6959m);
        C(this.f6960n);
        C(this.f6961o);
        C(this.p);
        ActionBarContainer actionBarContainer = this.f6954h;
        if (actionBarContainer != null) {
            C(actionBarContainer);
        }
    }

    @Override // miuix.appcompat.app.b
    public final void w(boolean z4) {
        this.f6953f.k(z4);
    }

    @Override // miuix.appcompat.app.b
    public final void x(boolean z4) {
        M();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Fragment fragment) {
        new ArrayList();
        this.f6969y = true;
        this.f6945A = new b();
        this.f6950b = ((miuix.appcompat.app.l) fragment).i();
        this.f6965t = fragment.A();
        I((ViewGroup) fragment.T());
        ActivityC0219o activityC0219oX = fragment.x();
        n(activityC0219oX != null ? activityC0219oX.getTitle() : null);
    }
}
