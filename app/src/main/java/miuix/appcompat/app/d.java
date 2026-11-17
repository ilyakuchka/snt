package miuix.appcompat.app;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.android.mmt.R;
import miuix.appcompat.internal.app.widget.ActionBarContainer;
import miuix.appcompat.internal.app.widget.ActionBarContextView;
import miuix.appcompat.internal.app.widget.ActionBarOverlayLayout;
import miuix.appcompat.internal.app.widget.ActionBarView;
import miuix.appcompat.internal.view.menu.ImmersionMenuPopupWindowImpl;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.appcompat.internal.view.menu.MenuPresenter;
import x3.C0418a;

/* loaded from: classes.dex */
public abstract class d implements c, MenuPresenter.Callback, MenuBuilder.Callback {

    /* renamed from: i, reason: collision with root package name */
    final h f6668i;

    /* renamed from: j, reason: collision with root package name */
    protected ActionBarView f6669j;

    /* renamed from: k, reason: collision with root package name */
    protected MenuBuilder f6670k;

    /* renamed from: l, reason: collision with root package name */
    protected ActionMode f6671l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f6672m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f6673n;

    /* renamed from: o, reason: collision with root package name */
    boolean f6674o;
    boolean p;

    /* renamed from: q, reason: collision with root package name */
    protected b f6675q;

    /* renamed from: r, reason: collision with root package name */
    private MenuInflater f6676r;

    /* renamed from: t, reason: collision with root package name */
    protected int f6678t;
    private ImmersionMenuPopupWindowImpl u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f6679v;

    /* renamed from: w, reason: collision with root package name */
    private MenuBuilder f6680w;

    /* renamed from: s, reason: collision with root package name */
    private int f6677s = 0;

    /* renamed from: x, reason: collision with root package name */
    private boolean f6681x = false;

    d(h hVar) {
        this.f6668i = hVar;
    }

    public final void c(ActionBarOverlayLayout actionBarOverlayLayout) {
        if (actionBarOverlayLayout != null) {
            ViewStub viewStub = (ViewStub) actionBarOverlayLayout.findViewById(R.id.content_mask_vs);
            actionBarOverlayLayout.w(viewStub != null ? viewStub.inflate() : actionBarOverlayLayout.findViewById(R.id.content_mask));
        }
    }

    public final void d(boolean z4, boolean z5, ActionBarOverlayLayout actionBarOverlayLayout) throws Resources.NotFoundException {
        if (this.f6681x) {
            return;
        }
        this.f6681x = true;
        ViewStub viewStub = (ViewStub) actionBarOverlayLayout.findViewById(R.id.split_action_bar_vs);
        ActionBarContainer actionBarContainer = viewStub != null ? (ActionBarContainer) viewStub.inflate() : (ActionBarContainer) actionBarOverlayLayout.findViewById(R.id.split_action_bar);
        if (actionBarContainer != null) {
            this.f6669j.B0(actionBarContainer);
            this.f6669j.l(z4);
            this.f6669j.C0(z5);
            actionBarOverlayLayout.B(actionBarContainer);
            c(actionBarOverlayLayout);
        }
        ActionBarContainer actionBarContainer2 = (ActionBarContainer) actionBarOverlayLayout.findViewById(R.id.action_bar_container);
        ViewStub viewStub2 = (ViewStub) actionBarOverlayLayout.findViewById(R.id.action_context_bar_vs);
        ActionBarContextView actionBarContextView = viewStub2 != null ? (ActionBarContextView) viewStub2.inflate() : (ActionBarContextView) actionBarOverlayLayout.findViewById(R.id.action_context_bar);
        if (actionBarContextView != null) {
            actionBarContainer2.o(actionBarContextView);
            actionBarOverlayLayout.t(actionBarContextView);
            if (actionBarContainer != null) {
                actionBarContextView.R(actionBarContainer);
                actionBarContextView.l(z4);
                actionBarContextView.S(z5);
            }
        }
    }

    protected final MenuBuilder e() {
        Context contextC = this.f6668i;
        b bVarG = g();
        if (bVarG != null) {
            contextC = bVarG.c();
        }
        MenuBuilder menuBuilder = new MenuBuilder(contextC);
        menuBuilder.setCallback(this);
        return menuBuilder;
    }

    public final void f() {
        ImmersionMenuPopupWindowImpl immersionMenuPopupWindowImpl = this.u;
        if (immersionMenuPopupWindowImpl != null) {
            immersionMenuPopupWindowImpl.dismiss(false);
        }
    }

    public final b g() {
        if (!this.f6674o && !this.p) {
            this.f6675q = null;
        } else if (this.f6675q == null) {
            this.f6675q = a();
        }
        return this.f6675q;
    }

    public final MenuInflater h() {
        if (this.f6676r == null) {
            b bVarG = g();
            if (bVarG != null) {
                this.f6676r = new MenuInflater(bVarG.c());
            } else {
                this.f6676r = new MenuInflater(this.f6668i);
            }
        }
        return this.f6676r;
    }

    public abstract Context i();

    public final int j() {
        return this.f6677s;
    }

    protected final String k() {
        try {
            Bundle bundle = this.f6668i.getPackageManager().getActivityInfo(this.f6668i.getComponentName(), 128).metaData;
            if (bundle != null) {
                return bundle.getString("android.support.UI_OPTIONS");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            StringBuilder sbD = D2.e.d("getUiOptionsFromMetadata: Activity '");
            sbD.append(this.f6668i.getClass().getSimpleName());
            sbD.append("' not in manifest");
            Log.e("ActionBarDelegate", sbD.toString());
            return null;
        }
    }

    public final boolean l() {
        return this.f6679v;
    }

    protected abstract boolean m(MenuBuilder menuBuilder);

    public abstract /* synthetic */ boolean n(int i2, MenuItem menuItem);

    protected abstract boolean o(MenuBuilder menuBuilder);

    @Override // miuix.appcompat.internal.view.menu.MenuPresenter.Callback
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z4) {
        this.f6668i.closeOptionsMenu();
    }

    @Override // miuix.appcompat.internal.view.menu.MenuBuilder.Callback
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        ActionBarView actionBarView = this.f6669j;
        if (actionBarView == null || !actionBarView.i0()) {
            menuBuilder.close();
        } else if (this.f6669j.h0()) {
            this.f6669j.c0();
        } else if (this.f6669j.getVisibility() == 0) {
            this.f6669j.m();
        }
    }

    @Override // miuix.appcompat.internal.view.menu.MenuPresenter.Callback
    public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        return false;
    }

    public final boolean p(int i2) {
        if (i2 != 2) {
            if (i2 != 5) {
                if (i2 == 8) {
                    this.f6674o = true;
                    return true;
                }
                if (i2 != 9) {
                    return this.f6668i.requestWindowFeature(i2);
                }
                this.p = true;
                return true;
            }
            this.f6673n = true;
        }
        return true;
    }

    public final void q(boolean z4) {
        this.f6679v = z4;
        if (this.f6672m && this.f6674o) {
            if (!z4) {
                this.f6669j.b0();
            } else if (!this.f6669j.J0()) {
                this.f6669j.d0(this.f6678t, this);
            }
            b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void r(MenuBuilder menuBuilder) throws Resources.NotFoundException {
        if (menuBuilder == this.f6670k) {
            return;
        }
        this.f6670k = menuBuilder;
        ActionBarView actionBarView = this.f6669j;
        if (actionBarView != null) {
            actionBarView.z0(menuBuilder, this);
        }
    }

    public final void s(int i2) throws Resources.NotFoundException {
        int integer = this.f6668i.getResources().getInteger(R.integer.window_translucent_status);
        if (integer >= 0 && integer <= 2) {
            i2 = integer;
        }
        if (this.f6677s == i2 || !C0418a.a(this.f6668i.getWindow(), i2)) {
            return;
        }
        this.f6677s = i2;
    }

    public final void t(View view, ViewGroup viewGroup) {
        if (!this.f6679v) {
            Log.w("ActionBarDelegate", "Try to show immersion menu when immersion menu disabled");
            return;
        }
        if (view == null) {
            throw new IllegalArgumentException("You must specify a valid anchor view");
        }
        if (this.f6680w == null) {
            MenuBuilder menuBuilderE = e();
            this.f6680w = menuBuilderE;
            m(menuBuilderE);
        }
        if (o(this.f6680w) && this.f6680w.hasVisibleItems()) {
            ImmersionMenuPopupWindowImpl immersionMenuPopupWindowImpl = this.u;
            if (immersionMenuPopupWindowImpl == null) {
                this.u = new ImmersionMenuPopupWindowImpl(this, this.f6680w);
            } else {
                immersionMenuPopupWindowImpl.update(this.f6680w);
            }
            if (this.u.isShowing()) {
                return;
            }
            this.u.show(view, viewGroup);
        }
    }
}
