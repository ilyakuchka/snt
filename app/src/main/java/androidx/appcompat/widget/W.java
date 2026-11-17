package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.l;
import com.android.mmt.R;
import t.C0384b;

/* loaded from: classes.dex */
public final class W implements B {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f2953a;

    /* renamed from: b, reason: collision with root package name */
    private int f2954b;

    /* renamed from: c, reason: collision with root package name */
    private View f2955c;
    private Drawable d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f2956e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f2957f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    CharSequence f2958h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f2959i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f2960j;

    /* renamed from: k, reason: collision with root package name */
    Window.Callback f2961k;

    /* renamed from: l, reason: collision with root package name */
    boolean f2962l;

    /* renamed from: m, reason: collision with root package name */
    private C0182c f2963m;

    /* renamed from: n, reason: collision with root package name */
    private int f2964n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f2965o;

    final class a extends C0384b {

        /* renamed from: A, reason: collision with root package name */
        final /* synthetic */ int f2966A;

        /* renamed from: z, reason: collision with root package name */
        private boolean f2968z = false;

        a(int i2) {
            this.f2966A = i2;
        }

        @Override // androidx.core.view.u
        public final void a() {
            if (this.f2968z) {
                return;
            }
            W.this.f2953a.setVisibility(this.f2966A);
        }

        @Override // t.C0384b, androidx.core.view.u
        public final void b(View view) {
            this.f2968z = true;
        }

        @Override // t.C0384b, androidx.core.view.u
        public final void c() {
            W.this.f2953a.setVisibility(0);
        }
    }

    public W(Toolbar toolbar) {
        Drawable drawable;
        this.f2964n = 0;
        this.f2953a = toolbar;
        this.f2958h = toolbar.u();
        this.f2959i = toolbar.t();
        this.g = this.f2958h != null;
        this.f2957f = toolbar.s();
        U u = U.u(toolbar.getContext(), null, Y1.a.f2114f, R.attr.actionBarStyle, 0);
        this.f2965o = u.f(39);
        CharSequence charSequenceO = u.o(53);
        if (!TextUtils.isEmpty(charSequenceO)) {
            this.g = true;
            this.f2958h = charSequenceO;
            if ((this.f2954b & 8) != 0) {
                this.f2953a.R(charSequenceO);
            }
        }
        CharSequence charSequenceO2 = u.o(50);
        if (!TextUtils.isEmpty(charSequenceO2)) {
            this.f2959i = charSequenceO2;
            if ((this.f2954b & 8) != 0) {
                this.f2953a.P(charSequenceO2);
            }
        }
        Drawable drawableF = u.f(44);
        if (drawableF != null) {
            this.f2956e = drawableF;
            z();
        }
        Drawable drawableF2 = u.f(41);
        if (drawableF2 != null) {
            this.d = drawableF2;
            z();
        }
        if (this.f2957f == null && (drawable = this.f2965o) != null) {
            this.f2957f = drawable;
            y();
        }
        w(u.j(31, 0));
        int iM = u.m(29, 0);
        if (iM != 0) {
            View viewInflate = LayoutInflater.from(this.f2953a.getContext()).inflate(iM, (ViewGroup) this.f2953a, false);
            View view = this.f2955c;
            if (view != null && (this.f2954b & 16) != 0) {
                this.f2953a.removeView(view);
            }
            this.f2955c = viewInflate;
            if (viewInflate != null && (this.f2954b & 16) != 0) {
                this.f2953a.addView(viewInflate);
            }
            w(this.f2954b | 16);
        }
        int iL = u.l(37, 0);
        if (iL > 0) {
            ViewGroup.LayoutParams layoutParams = this.f2953a.getLayoutParams();
            layoutParams.height = iL;
            this.f2953a.setLayoutParams(layoutParams);
        }
        int iD = u.d(27, -1);
        int iD2 = u.d(23, -1);
        if (iD >= 0 || iD2 >= 0) {
            this.f2953a.I(Math.max(iD, 0), Math.max(iD2, 0));
        }
        int iM2 = u.m(55, 0);
        if (iM2 != 0) {
            Toolbar toolbar2 = this.f2953a;
            toolbar2.S(toolbar2.getContext(), iM2);
        }
        int iM3 = u.m(51, 0);
        if (iM3 != 0) {
            Toolbar toolbar3 = this.f2953a;
            toolbar3.Q(toolbar3.getContext(), iM3);
        }
        int iM4 = u.m(46, 0);
        if (iM4 != 0) {
            this.f2953a.O(iM4);
        }
        u.v();
        if (R.string.abc_action_bar_up_description != this.f2964n) {
            this.f2964n = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(this.f2953a.r())) {
                int i2 = this.f2964n;
                this.f2960j = i2 != 0 ? this.f2953a.getContext().getString(i2) : null;
                x();
            }
        }
        this.f2960j = this.f2953a.r();
        this.f2953a.N(new V(this));
    }

    private void x() {
        if ((this.f2954b & 4) != 0) {
            if (!TextUtils.isEmpty(this.f2960j)) {
                this.f2953a.L(this.f2960j);
                return;
            }
            Toolbar toolbar = this.f2953a;
            int i2 = this.f2964n;
            toolbar.L(i2 != 0 ? toolbar.getContext().getText(i2) : null);
        }
    }

    private void y() {
        if ((this.f2954b & 4) == 0) {
            this.f2953a.M(null);
            return;
        }
        Toolbar toolbar = this.f2953a;
        Drawable drawable = this.f2957f;
        if (drawable == null) {
            drawable = this.f2965o;
        }
        toolbar.M(drawable);
    }

    private void z() {
        Drawable drawable;
        int i2 = this.f2954b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f2956e) == null) {
            drawable = this.d;
        }
        this.f2953a.J(drawable);
    }

    @Override // androidx.appcompat.widget.B
    public final void a(Menu menu, l.a aVar) {
        if (this.f2963m == null) {
            this.f2963m = new C0182c(this.f2953a.getContext());
        }
        this.f2963m.d(aVar);
        this.f2953a.K((androidx.appcompat.view.menu.f) menu, this.f2963m);
    }

    @Override // androidx.appcompat.widget.B
    public final boolean b() {
        return this.f2953a.A();
    }

    @Override // androidx.appcompat.widget.B
    public final void c(CharSequence charSequence) {
        if (this.g) {
            return;
        }
        this.f2958h = charSequence;
        if ((this.f2954b & 8) != 0) {
            this.f2953a.R(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.B
    public final void collapseActionView() {
        this.f2953a.e();
    }

    @Override // androidx.appcompat.widget.B
    public final boolean d() {
        return this.f2953a.B();
    }

    @Override // androidx.appcompat.widget.B
    public final void e(Window.Callback callback) {
        this.f2961k = callback;
    }

    @Override // androidx.appcompat.widget.B
    public final boolean f() {
        return this.f2953a.y();
    }

    @Override // androidx.appcompat.widget.B
    public final boolean g() {
        return this.f2953a.U();
    }

    @Override // androidx.appcompat.widget.B
    public final void h() {
        this.f2962l = true;
    }

    @Override // androidx.appcompat.widget.B
    public final boolean i() {
        return this.f2953a.d();
    }

    @Override // androidx.appcompat.widget.B
    public final void j() {
        this.f2953a.f();
    }

    @Override // androidx.appcompat.widget.B
    public final void k() {
    }

    @Override // androidx.appcompat.widget.B
    public final int l() {
        return this.f2954b;
    }

    @Override // androidx.appcompat.widget.B
    public final void m(int i2) {
        this.f2953a.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.B
    public final void n() {
    }

    @Override // androidx.appcompat.widget.B
    public final ViewGroup o() {
        return this.f2953a;
    }

    @Override // androidx.appcompat.widget.B
    public final Context p() {
        return this.f2953a.getContext();
    }

    @Override // androidx.appcompat.widget.B
    public final void q() {
    }

    @Override // androidx.appcompat.widget.B
    public final androidx.core.view.t r(int i2, long j2) {
        androidx.core.view.t tVarA = androidx.core.view.o.a(this.f2953a);
        tVarA.a(i2 == 0 ? 1.0f : 0.0f);
        tVarA.d(j2);
        tVarA.f(new a(i2));
        return tVarA;
    }

    @Override // androidx.appcompat.widget.B
    public final void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.B
    public final boolean t() {
        return this.f2953a.x();
    }

    @Override // androidx.appcompat.widget.B
    public final void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.B
    public final void v(boolean z4) {
        this.f2953a.H(z4);
    }

    @Override // androidx.appcompat.widget.B
    public final void w(int i2) {
        View view;
        int i4 = this.f2954b ^ i2;
        this.f2954b = i2;
        if (i4 != 0) {
            if ((i4 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    x();
                }
                y();
            }
            if ((i4 & 3) != 0) {
                z();
            }
            if ((i4 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f2953a.R(this.f2958h);
                    this.f2953a.P(this.f2959i);
                } else {
                    this.f2953a.R(null);
                    this.f2953a.P(null);
                }
            }
            if ((i4 & 16) == 0 || (view = this.f2955c) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.f2953a.addView(view);
            } else {
                this.f2953a.removeView(view);
            }
        }
    }
}
