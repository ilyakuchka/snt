package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.B;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.t;
import androidx.core.view.u;
import androidx.core.view.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import l.b;
import t.C0384b;

/* loaded from: classes.dex */
public final class s extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {

    /* renamed from: a, reason: collision with root package name */
    Context f2428a;

    /* renamed from: b, reason: collision with root package name */
    private Context f2429b;

    /* renamed from: c, reason: collision with root package name */
    ActionBarOverlayLayout f2430c;
    ActionBarContainer d;

    /* renamed from: e, reason: collision with root package name */
    B f2431e;

    /* renamed from: f, reason: collision with root package name */
    ActionBarContextView f2432f;
    View g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2433h;

    /* renamed from: i, reason: collision with root package name */
    d f2434i;

    /* renamed from: j, reason: collision with root package name */
    d f2435j;

    /* renamed from: k, reason: collision with root package name */
    b.a f2436k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2437l;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<a.b> f2438m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2439n;

    /* renamed from: o, reason: collision with root package name */
    private int f2440o;
    boolean p;

    /* renamed from: q, reason: collision with root package name */
    boolean f2441q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f2442r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f2443s;

    /* renamed from: t, reason: collision with root package name */
    l.h f2444t;
    private boolean u;

    /* renamed from: v, reason: collision with root package name */
    boolean f2445v;

    /* renamed from: w, reason: collision with root package name */
    final u f2446w;

    /* renamed from: x, reason: collision with root package name */
    final u f2447x;

    /* renamed from: y, reason: collision with root package name */
    final v f2448y;

    /* renamed from: z, reason: collision with root package name */
    private static final AccelerateInterpolator f2427z = new AccelerateInterpolator();

    /* renamed from: A, reason: collision with root package name */
    private static final DecelerateInterpolator f2426A = new DecelerateInterpolator();

    final class a extends C0384b {
        a() {
        }

        @Override // androidx.core.view.u
        public final void a() {
            View view;
            s sVar = s.this;
            if (sVar.p && (view = sVar.g) != null) {
                view.setTranslationY(0.0f);
                s.this.d.setTranslationY(0.0f);
            }
            s.this.d.setVisibility(8);
            s.this.d.a(false);
            s sVar2 = s.this;
            sVar2.f2444t = null;
            b.a aVar = sVar2.f2436k;
            if (aVar != null) {
                aVar.c(sVar2.f2435j);
                sVar2.f2435j = null;
                sVar2.f2436k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = s.this.f2430c;
            if (actionBarOverlayLayout != null) {
                int i2 = androidx.core.view.o.d;
                actionBarOverlayLayout.requestApplyInsets();
            }
        }
    }

    final class b extends C0384b {
        b() {
        }

        @Override // androidx.core.view.u
        public final void a() {
            s sVar = s.this;
            sVar.f2444t = null;
            sVar.d.requestLayout();
        }
    }

    final class c implements v {
        c() {
        }

        @Override // androidx.core.view.v
        public final void a() {
            ((View) s.this.d.getParent()).invalidate();
        }
    }

    public class d extends l.b implements f.a {

        /* renamed from: k, reason: collision with root package name */
        private final Context f2452k;

        /* renamed from: l, reason: collision with root package name */
        private final androidx.appcompat.view.menu.f f2453l;

        /* renamed from: m, reason: collision with root package name */
        private b.a f2454m;

        /* renamed from: n, reason: collision with root package name */
        private WeakReference<View> f2455n;

        public d(Context context, b.a aVar) {
            this.f2452k = context;
            this.f2454m = aVar;
            androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
            fVar.F();
            this.f2453l = fVar;
            fVar.E(this);
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            b.a aVar = this.f2454m;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f fVar) {
            if (this.f2454m == null) {
                return;
            }
            k();
            s.this.f2432f.r();
        }

        @Override // l.b
        public final void c() {
            s sVar = s.this;
            if (sVar.f2434i != this) {
                return;
            }
            if (!sVar.f2441q) {
                this.f2454m.c(this);
            } else {
                sVar.f2435j = this;
                sVar.f2436k = this.f2454m;
            }
            this.f2454m = null;
            s.this.o(false);
            s.this.f2432f.f();
            s.this.f2431e.o().sendAccessibilityEvent(32);
            s sVar2 = s.this;
            sVar2.f2430c.z(sVar2.f2445v);
            s.this.f2434i = null;
        }

        @Override // l.b
        public final View d() {
            WeakReference<View> weakReference = this.f2455n;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // l.b
        public final Menu e() {
            return this.f2453l;
        }

        @Override // l.b
        public final MenuInflater f() {
            return new l.g(this.f2452k);
        }

        @Override // l.b
        public final CharSequence g() {
            return s.this.f2432f.g();
        }

        @Override // l.b
        public final CharSequence i() {
            return s.this.f2432f.h();
        }

        @Override // l.b
        public final void k() {
            if (s.this.f2434i != this) {
                return;
            }
            this.f2453l.P();
            try {
                this.f2454m.d(this, this.f2453l);
            } finally {
                this.f2453l.O();
            }
        }

        @Override // l.b
        public final boolean l() {
            return s.this.f2432f.k();
        }

        @Override // l.b
        public final void m(View view) {
            s.this.f2432f.m(view);
            this.f2455n = new WeakReference<>(view);
        }

        @Override // l.b
        public final void n(int i2) throws Resources.NotFoundException {
            s.this.f2432f.n(s.this.f2428a.getResources().getString(i2));
        }

        @Override // l.b
        public final void o(CharSequence charSequence) {
            s.this.f2432f.n(charSequence);
        }

        @Override // l.b
        public final void q(int i2) throws Resources.NotFoundException {
            s.this.f2432f.o(s.this.f2428a.getResources().getString(i2));
        }

        @Override // l.b
        public final void r(CharSequence charSequence) {
            s.this.f2432f.o(charSequence);
        }

        @Override // l.b
        public final void s(boolean z4) {
            super.s(z4);
            s.this.f2432f.p(z4);
        }

        public final boolean t() {
            this.f2453l.P();
            try {
                return this.f2454m.a(this, this.f2453l);
            } finally {
                this.f2453l.O();
            }
        }
    }

    public s(Activity activity, boolean z4) {
        new ArrayList();
        this.f2438m = new ArrayList<>();
        this.f2440o = 0;
        this.p = true;
        this.f2443s = true;
        this.f2446w = new a();
        this.f2447x = new b();
        this.f2448y = new c();
        View decorView = activity.getWindow().getDecorView();
        s(decorView);
        if (z4) {
            return;
        }
        this.g = decorView.findViewById(R.id.content);
    }

    private void B(boolean z4) {
        View view;
        View view2;
        View view3;
        if (!(this.f2442r || !this.f2441q)) {
            if (this.f2443s) {
                this.f2443s = false;
                l.h hVar = this.f2444t;
                if (hVar != null) {
                    hVar.a();
                }
                if (this.f2440o != 0 || (!this.u && !z4)) {
                    ((a) this.f2446w).a();
                    return;
                }
                this.d.setAlpha(1.0f);
                this.d.a(true);
                l.h hVar2 = new l.h();
                float f4 = -this.d.getHeight();
                if (z4) {
                    this.d.getLocationInWindow(new int[]{0, 0});
                    f4 -= r6[1];
                }
                t tVarA = androidx.core.view.o.a(this.d);
                tVarA.k(f4);
                tVarA.i(this.f2448y);
                hVar2.c(tVarA);
                if (this.p && (view = this.g) != null) {
                    t tVarA2 = androidx.core.view.o.a(view);
                    tVarA2.k(f4);
                    hVar2.c(tVarA2);
                }
                hVar2.f(f2427z);
                hVar2.e();
                hVar2.g(this.f2446w);
                this.f2444t = hVar2;
                hVar2.h();
                return;
            }
            return;
        }
        if (this.f2443s) {
            return;
        }
        this.f2443s = true;
        l.h hVar3 = this.f2444t;
        if (hVar3 != null) {
            hVar3.a();
        }
        this.d.setVisibility(0);
        if (this.f2440o == 0 && (this.u || z4)) {
            this.d.setTranslationY(0.0f);
            float f5 = -this.d.getHeight();
            if (z4) {
                this.d.getLocationInWindow(new int[]{0, 0});
                f5 -= r6[1];
            }
            this.d.setTranslationY(f5);
            l.h hVar4 = new l.h();
            t tVarA3 = androidx.core.view.o.a(this.d);
            tVarA3.k(0.0f);
            tVarA3.i(this.f2448y);
            hVar4.c(tVarA3);
            if (this.p && (view3 = this.g) != null) {
                view3.setTranslationY(f5);
                t tVarA4 = androidx.core.view.o.a(this.g);
                tVarA4.k(0.0f);
                hVar4.c(tVarA4);
            }
            hVar4.f(f2426A);
            hVar4.e();
            hVar4.g(this.f2447x);
            this.f2444t = hVar4;
            hVar4.h();
        } else {
            this.d.setAlpha(1.0f);
            this.d.setTranslationY(0.0f);
            if (this.p && (view2 = this.g) != null) {
                view2.setTranslationY(0.0f);
            }
            ((b) this.f2447x).a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2430c;
        if (actionBarOverlayLayout != null) {
            int i2 = androidx.core.view.o.d;
            actionBarOverlayLayout.requestApplyInsets();
        }
    }

    private void s(View view) {
        B bW;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.android.mmt.R.id.decor_content_parent);
        this.f2430c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.x(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(com.android.mmt.R.id.action_bar);
        if (callbackFindViewById instanceof B) {
            bW = (B) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                StringBuilder sbD = D2.e.d("Can't make a decor toolbar out of ");
                sbD.append(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null");
                throw new IllegalStateException(sbD.toString());
            }
            bW = ((Toolbar) callbackFindViewById).w();
        }
        this.f2431e = bW;
        this.f2432f = (ActionBarContextView) view.findViewById(com.android.mmt.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.android.mmt.R.id.action_bar_container);
        this.d = actionBarContainer;
        B b2 = this.f2431e;
        if (b2 == null || this.f2432f == null || actionBarContainer == null) {
            throw new IllegalStateException(s.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f2428a = b2.p();
        if ((this.f2431e.l() & 4) != 0) {
            this.f2433h = true;
        }
        l.a aVarB = l.a.b(this.f2428a);
        aVarB.a();
        this.f2431e.n();
        x(aVarB.e());
        TypedArray typedArrayObtainStyledAttributes = this.f2428a.obtainStyledAttributes(null, Y1.a.f2114f, com.android.mmt.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(38, false)) {
            if (!this.f2430c.u()) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f2445v = true;
            this.f2430c.z(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(33, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.d;
            int i2 = androidx.core.view.o.d;
            actionBarContainer2.setElevation(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void x(boolean z4) {
        this.f2439n = z4;
        if (z4) {
            Objects.requireNonNull(this.d);
            this.f2431e.k();
        } else {
            this.f2431e.k();
            Objects.requireNonNull(this.d);
        }
        this.f2431e.q();
        B b2 = this.f2431e;
        boolean z5 = this.f2439n;
        b2.v(false);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2430c;
        boolean z6 = this.f2439n;
        actionBarOverlayLayout.y(false);
    }

    public final void A() {
        if (this.f2441q) {
            this.f2441q = false;
            B(true);
        }
    }

    @Override // androidx.appcompat.app.a
    public final int a() {
        return this.f2431e.l();
    }

    @Override // androidx.appcompat.app.a
    public final Context c() {
        if (this.f2429b == null) {
            TypedValue typedValue = new TypedValue();
            this.f2428a.getTheme().resolveAttribute(com.android.mmt.R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f2429b = new ContextThemeWrapper(this.f2428a, i2);
            } else {
                this.f2429b = this.f2428a;
            }
        }
        return this.f2429b;
    }

    @Override // androidx.appcompat.app.a
    public final void g(boolean z4) {
        int i2 = z4 ? 4 : 0;
        int iL = this.f2431e.l();
        this.f2433h = true;
        this.f2431e.w((i2 & 4) | ((-5) & iL));
    }

    @Override // androidx.appcompat.app.a
    public final void j(boolean z4) {
        this.f2431e.n();
    }

    public final void o(boolean z4) {
        t tVarQ;
        t tVarQ2;
        if (z4) {
            if (!this.f2442r) {
                this.f2442r = true;
                B(false);
            }
        } else if (this.f2442r) {
            this.f2442r = false;
            B(false);
        }
        ActionBarContainer actionBarContainer = this.d;
        int i2 = androidx.core.view.o.d;
        if (!actionBarContainer.isLaidOut()) {
            if (z4) {
                this.f2431e.m(4);
                this.f2432f.setVisibility(0);
                return;
            } else {
                this.f2431e.m(0);
                this.f2432f.setVisibility(8);
                return;
            }
        }
        if (z4) {
            tVarQ = this.f2431e.r(4, 100L);
            tVarQ2 = this.f2432f.q(0, 200L);
        } else {
            t tVarR = this.f2431e.r(0, 200L);
            tVarQ = this.f2432f.q(8, 100L);
            tVarQ2 = tVarR;
        }
        l.h hVar = new l.h();
        hVar.d(tVarQ, tVarQ2);
        hVar.h();
    }

    public final void p(boolean z4) {
        if (z4 == this.f2437l) {
            return;
        }
        this.f2437l = z4;
        int size = this.f2438m.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2438m.get(i2).a();
        }
    }

    public final void q(boolean z4) {
        this.p = z4;
    }

    public final void r() {
        if (this.f2441q) {
            return;
        }
        this.f2441q = true;
        B(true);
    }

    public final void t() {
        x(l.a.b(this.f2428a).e());
    }

    public final void u() {
        l.h hVar = this.f2444t;
        if (hVar != null) {
            hVar.a();
            this.f2444t = null;
        }
    }

    public final void v(int i2) {
        this.f2440o = i2;
    }

    public final void w(boolean z4) {
        if (this.f2433h) {
            return;
        }
        g(z4);
    }

    public final void y(boolean z4) {
        l.h hVar;
        this.u = z4;
        if (z4 || (hVar = this.f2444t) == null) {
            return;
        }
        hVar.a();
    }

    public final void z(CharSequence charSequence) {
        this.f2431e.c(charSequence);
    }

    public s(Dialog dialog) {
        new ArrayList();
        this.f2438m = new ArrayList<>();
        this.f2440o = 0;
        this.p = true;
        this.f2443s = true;
        this.f2446w = new a();
        this.f2447x = new b();
        this.f2448y = new c();
        s(dialog.getWindow().getDecorView());
    }
}
