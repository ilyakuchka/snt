package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.o;
import java.util.Objects;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: b, reason: collision with root package name */
    public static final w f3326b = i.f3334h;

    /* renamed from: a, reason: collision with root package name */
    private final j f3327a;

    private static class c extends b {
        c() {
        }

        c(w wVar) {
            super(wVar);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private final w f3330a;

        d() {
            this(new w());
        }

        protected final void a() {
        }

        d(w wVar) {
            this.f3330a = wVar;
        }
    }

    private static class e extends j {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets f3331c;
        private y.b d;

        /* renamed from: e, reason: collision with root package name */
        private w f3332e;

        /* renamed from: f, reason: collision with root package name */
        y.b f3333f;

        e(w wVar, WindowInsets windowInsets) {
            super(wVar);
            this.d = null;
            this.f3331c = windowInsets;
        }

        private y.b m(View view) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // androidx.core.view.w.j
        void d(View view) {
            y.b bVarM = m(view);
            if (bVarM == null) {
                bVarM = y.b.f8140e;
            }
            n(bVarM);
        }

        @Override // androidx.core.view.w.j
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f3333f, ((e) obj).f3333f);
            }
            return false;
        }

        @Override // androidx.core.view.w.j
        final y.b g() {
            if (this.d == null) {
                this.d = y.b.a(this.f3331c.getSystemWindowInsetLeft(), this.f3331c.getSystemWindowInsetTop(), this.f3331c.getSystemWindowInsetRight(), this.f3331c.getSystemWindowInsetBottom());
            }
            return this.d;
        }

        @Override // androidx.core.view.w.j
        w h(int i2, int i4, int i5, int i6) {
            a aVar = new a(w.o(this.f3331c, null));
            aVar.c(w.j(g(), i2, i4, i5, i6));
            aVar.b(w.j(f(), i2, i4, i5, i6));
            return aVar.a();
        }

        @Override // androidx.core.view.w.j
        boolean j() {
            return this.f3331c.isRound();
        }

        @Override // androidx.core.view.w.j
        public void k(y.b[] bVarArr) {
        }

        @Override // androidx.core.view.w.j
        void l(w wVar) {
            this.f3332e = wVar;
        }

        void n(y.b bVar) {
            this.f3333f = bVar;
        }
    }

    private static class f extends e {
        private y.b g;

        f(w wVar, WindowInsets windowInsets) {
            super(wVar, windowInsets);
            this.g = null;
        }

        @Override // androidx.core.view.w.j
        w b() {
            return w.o(this.f3331c.consumeStableInsets(), null);
        }

        @Override // androidx.core.view.w.j
        w c() {
            return w.o(this.f3331c.consumeSystemWindowInsets(), null);
        }

        @Override // androidx.core.view.w.j
        final y.b f() {
            if (this.g == null) {
                this.g = y.b.a(this.f3331c.getStableInsetLeft(), this.f3331c.getStableInsetTop(), this.f3331c.getStableInsetRight(), this.f3331c.getStableInsetBottom());
            }
            return this.g;
        }

        @Override // androidx.core.view.w.j
        boolean i() {
            return this.f3331c.isConsumed();
        }
    }

    private static class g extends f {
        g(w wVar, WindowInsets windowInsets) {
            super(wVar, windowInsets);
        }

        @Override // androidx.core.view.w.j
        w a() {
            return w.o(this.f3331c.consumeDisplayCutout(), null);
        }

        @Override // androidx.core.view.w.j
        androidx.core.view.d e() {
            return androidx.core.view.d.a(this.f3331c.getDisplayCutout());
        }

        @Override // androidx.core.view.w.e, androidx.core.view.w.j
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Objects.equals(this.f3331c, gVar.f3331c) && Objects.equals(this.f3333f, gVar.f3333f);
        }

        @Override // androidx.core.view.w.j
        public int hashCode() {
            return this.f3331c.hashCode();
        }
    }

    private static class h extends g {
        h(w wVar, WindowInsets windowInsets) {
            super(wVar, windowInsets);
        }

        @Override // androidx.core.view.w.e, androidx.core.view.w.j
        w h(int i2, int i4, int i5, int i6) {
            return w.o(this.f3331c.inset(i2, i4, i5, i6), null);
        }
    }

    private static class i extends h {

        /* renamed from: h, reason: collision with root package name */
        static final w f3334h = w.o(WindowInsets.CONSUMED, null);

        i(w wVar, WindowInsets windowInsets) {
            super(wVar, windowInsets);
        }

        @Override // androidx.core.view.w.e, androidx.core.view.w.j
        final void d(View view) {
        }
    }

    private static class j {

        /* renamed from: b, reason: collision with root package name */
        static final w f3335b = new a().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        final w f3336a;

        j(w wVar) {
            this.f3336a = wVar;
        }

        w a() {
            return this.f3336a;
        }

        w b() {
            return this.f3336a;
        }

        w c() {
            return this.f3336a;
        }

        void d(View view) {
        }

        androidx.core.view.d e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return j() == jVar.j() && i() == jVar.i() && Objects.equals(g(), jVar.g()) && Objects.equals(f(), jVar.f()) && Objects.equals(e(), jVar.e());
        }

        y.b f() {
            return y.b.f8140e;
        }

        y.b g() {
            return y.b.f8140e;
        }

        w h(int i2, int i4, int i5, int i6) {
            return f3335b;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(j()), Boolean.valueOf(i()), g(), f(), e());
        }

        boolean i() {
            return false;
        }

        boolean j() {
            return false;
        }

        public void k(y.b[] bVarArr) {
        }

        void l(w wVar) {
        }
    }

    private w(WindowInsets windowInsets) {
        this.f3327a = new i(this, windowInsets);
    }

    static y.b j(y.b bVar, int i2, int i4, int i5, int i6) {
        int iMax = Math.max(0, bVar.f8141a - i2);
        int iMax2 = Math.max(0, bVar.f8142b - i4);
        int iMax3 = Math.max(0, bVar.f8143c - i5);
        int iMax4 = Math.max(0, bVar.d - i6);
        return (iMax == i2 && iMax2 == i4 && iMax3 == i5 && iMax4 == i6) ? bVar : y.b.a(iMax, iMax2, iMax3, iMax4);
    }

    public static w o(WindowInsets windowInsets, View view) {
        Objects.requireNonNull(windowInsets);
        w wVar = new w(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            int i2 = o.d;
            wVar.m(o.e.a(view));
            wVar.d(view.getRootView());
        }
        return wVar;
    }

    @Deprecated
    public final w a() {
        return this.f3327a.a();
    }

    @Deprecated
    public final w b() {
        return this.f3327a.b();
    }

    @Deprecated
    public final w c() {
        return this.f3327a.c();
    }

    final void d(View view) {
        this.f3327a.d(view);
    }

    @Deprecated
    public final int e() {
        return this.f3327a.g().d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return Objects.equals(this.f3327a, ((w) obj).f3327a);
        }
        return false;
    }

    @Deprecated
    public final int f() {
        return this.f3327a.g().f8141a;
    }

    @Deprecated
    public final int g() {
        return this.f3327a.g().f8143c;
    }

    @Deprecated
    public final int h() {
        return this.f3327a.g().f8142b;
    }

    public final int hashCode() {
        j jVar = this.f3327a;
        if (jVar == null) {
            return 0;
        }
        return jVar.hashCode();
    }

    public final w i(int i2, int i4, int i5, int i6) {
        return this.f3327a.h(i2, i4, i5, i6);
    }

    public final boolean k() {
        return this.f3327a.i();
    }

    final void l() {
        this.f3327a.k(null);
    }

    final void m(w wVar) {
        this.f3327a.l(wVar);
    }

    public final WindowInsets n() {
        j jVar = this.f3327a;
        if (jVar instanceof e) {
            return ((e) jVar).f3331c;
        }
        return null;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final c f3328a;

        public a() {
            this.f3328a = new c();
        }

        public final w a() {
            return this.f3328a.b();
        }

        @Deprecated
        public final a b(y.b bVar) {
            this.f3328a.c(bVar);
            return this;
        }

        @Deprecated
        public final a c(y.b bVar) {
            this.f3328a.d(bVar);
            return this;
        }

        public a(w wVar) {
            this.f3328a = new c(wVar);
        }
    }

    private static class b extends d {

        /* renamed from: b, reason: collision with root package name */
        final WindowInsets.Builder f3329b;

        b() {
            this.f3329b = new WindowInsets.Builder();
        }

        w b() {
            a();
            w wVarO = w.o(this.f3329b.build(), null);
            wVarO.l();
            return wVarO;
        }

        void c(y.b bVar) {
            this.f3329b.setStableInsets(bVar.b());
        }

        void d(y.b bVar) {
            this.f3329b.setSystemWindowInsets(bVar.b());
        }

        b(w wVar) {
            WindowInsets.Builder builder;
            WindowInsets windowInsetsN = wVar.n();
            if (windowInsetsN != null) {
                builder = new WindowInsets.Builder(windowInsetsN);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f3329b = builder;
        }
    }

    public w() {
        this.f3327a = new j(this);
    }
}
