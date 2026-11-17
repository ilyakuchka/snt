package miuix.appcompat.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.ActivityC0219o;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.x;
import com.android.mmt.R;
import java.lang.ref.WeakReference;
import java.util.Objects;
import miuix.appcompat.internal.app.widget.ActionBarOverlayLayout;
import miuix.appcompat.internal.app.widget.ActionBarView;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import t3.WindowCallbackC0390e;
import z3.C0431a;

/* loaded from: classes.dex */
public final class k extends d {

    /* renamed from: A, reason: collision with root package name */
    private int f6699A;

    /* renamed from: B, reason: collision with root package name */
    private ContextThemeWrapper f6700B;

    /* renamed from: C, reason: collision with root package name */
    private MenuBuilder f6701C;

    /* renamed from: D, reason: collision with root package name */
    private byte f6702D;

    /* renamed from: E, reason: collision with root package name */
    private int f6703E;

    /* renamed from: F, reason: collision with root package name */
    private Runnable f6704F;

    /* renamed from: G, reason: collision with root package name */
    private final Window.Callback f6705G;

    /* renamed from: y, reason: collision with root package name */
    private Fragment f6706y;

    /* renamed from: z, reason: collision with root package name */
    private View f6707z;

    final class a extends WindowCallbackC0390e {
        a() {
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(ActionMode actionMode) {
            ((l) k.this.f6706y).onActionModeFinished(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(ActionMode actionMode) {
            ((l) k.this.f6706y).onActionModeStarted(actionMode);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
            return k.this.n(i2, menuItem);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int i2, Menu menu) {
            h hVar = k.this.f6668i;
            if (hVar != null) {
                hVar.onPanelClosed(i2, menu);
            }
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            k kVar = k.this;
            if (kVar.g() != null) {
                return ((miuix.appcompat.internal.app.widget.d) kVar.g()).P(callback);
            }
            return null;
        }
    }

    private static class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<k> f6709i;

        b(k kVar) {
            this.f6709i = null;
            this.f6709i = new WeakReference<>(kVar);
        }

        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            boolean zA;
            WeakReference<k> weakReference = this.f6709i;
            k kVar = weakReference == null ? null : weakReference.get();
            if (kVar == null) {
                return;
            }
            boolean z4 = true;
            if ((kVar.f6702D & 1) == 1) {
                kVar.f6701C = null;
            }
            if (kVar.f6701C == null) {
                kVar.f6701C = kVar.e();
                zA = kVar.A(0, kVar.f6701C);
            } else {
                zA = true;
            }
            if (zA) {
                kVar.D(0, null, kVar.f6701C);
            } else {
                z4 = zA;
            }
            if (z4) {
                kVar.r(kVar.f6701C);
            } else {
                kVar.r(null);
                kVar.f6701C = null;
            }
            k.w(kVar);
        }
    }

    public k(Fragment fragment) {
        super((h) fragment.x());
        this.f6703E = 0;
        this.f6705G = new a();
        this.f6706y = fragment;
    }

    static /* synthetic */ byte w(k kVar) {
        byte b2 = (byte) (kVar.f6702D & (-18));
        kVar.f6702D = b2;
        return b2;
    }

    public final boolean A(int i2, Menu menu) {
        return ((l) this.f6706y).onCreatePanelMenu(0, menu);
    }

    public final View B(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        boolean z4;
        Context contextI = i();
        int[] iArr = Y1.a.f2109b0;
        TypedArray typedArrayObtainStyledAttributes = contextI.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(10)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a miui theme (or descendant) with this fragment.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(10, false)) {
            p(8);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(12, false)) {
            p(9);
        }
        s(typedArrayObtainStyledAttributes.getInt(27, 0));
        q(typedArrayObtainStyledAttributes.getBoolean(4, false));
        this.f6678t = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(i());
        if (this.f6674o) {
            Context contextI2 = i();
            if (!this.f6672m) {
                ActivityC0219o activityC0219oX = this.f6706y.x();
                if (activityC0219oX instanceof h) {
                    h hVar = (h) activityC0219oX;
                    int iL = hVar.L();
                    if (S2.d.j(iL) && this.f6703E != iL) {
                        this.f6703E = iL;
                        View view = this.f6707z;
                        if (view instanceof ActionBarOverlayLayout) {
                            ((ActionBarOverlayLayout) view).y(iL);
                        }
                    }
                    hVar.M();
                }
                this.f6672m = true;
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) layoutInflaterCloneInContext.inflate(R.layout.miuix_appcompat_screen_action_bar, viewGroup, false);
                actionBarOverlayLayout.v(this.f6705G);
                actionBarOverlayLayout.A();
                actionBarOverlayLayout.z(this.p);
                actionBarOverlayLayout.C(j());
                if (this.f6699A != 0) {
                    actionBarOverlayLayout.setBackground(C0431a.e(contextI2, android.R.attr.windowBackground));
                }
                ActionBarView actionBarView = (ActionBarView) actionBarOverlayLayout.findViewById(R.id.action_bar);
                this.f6669j = actionBarView;
                actionBarView.H0(this.f6705G);
                if (this.f6673n) {
                    this.f6669j.e0();
                }
                if (l()) {
                    this.f6669j.d0(this.f6678t, this);
                }
                boolean zEquals = "splitActionBarWhenNarrow".equals(k());
                if (zEquals) {
                    z4 = contextI2.getResources().getBoolean(R.bool.abc_split_action_bar_is_narrow);
                } else {
                    TypedArray typedArrayObtainStyledAttributes2 = contextI2.obtainStyledAttributes(iArr);
                    boolean z5 = typedArrayObtainStyledAttributes2.getBoolean(26, false);
                    typedArrayObtainStyledAttributes2.recycle();
                    z4 = z5;
                }
                if (z4) {
                    d(z4, zEquals, actionBarOverlayLayout);
                }
                this.f6702D = (byte) (this.f6702D | 1);
                b();
                this.f6707z = actionBarOverlayLayout;
            } else if (this.f6707z.getParent() != null && (this.f6707z.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) this.f6707z.getParent();
                if (viewGroup2.getChildCount() == 0) {
                    viewGroup2.endViewTransition(this.f6707z);
                }
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f6707z.findViewById(android.R.id.content);
            View viewO = ((l) this.f6706y).o(layoutInflaterCloneInContext);
            if (viewO != null && viewO.getParent() != viewGroup3) {
                if (viewO.getParent() != null) {
                    ((ViewGroup) viewO.getParent()).removeView(viewO);
                }
                viewGroup3.removeAllViews();
                viewGroup3.addView(viewO);
            }
        } else {
            this.f6707z = ((l) this.f6706y).o(layoutInflaterCloneInContext);
        }
        return this.f6707z;
    }

    final void C() {
        this.f6707z = null;
        this.f6672m = false;
        this.f6675q = null;
        this.f6669j = null;
        this.f6704F = null;
    }

    public final boolean D(int i2, View view, Menu menu) {
        ((l) this.f6706y).s();
        return true;
    }

    public final void E() {
        this.f6699A = R.style.MmsTheme_NoTitle;
    }

    @Override // miuix.appcompat.app.c
    public final miuix.appcompat.app.b a() {
        if (this.f6706y.W()) {
            return new miuix.appcompat.internal.app.widget.d(this.f6706y);
        }
        return null;
    }

    @Override // miuix.appcompat.app.c
    public final void b() {
        ActivityC0219o activityC0219oX = this.f6706y.x();
        if (activityC0219oX != null) {
            byte b2 = this.f6702D;
            if ((b2 & 16) == 0) {
                this.f6702D = (byte) (b2 | 16);
                View decorView = activityC0219oX.getWindow().getDecorView();
                if (this.f6704F == null) {
                    this.f6704F = new b(this);
                }
                decorView.post(this.f6704F);
            }
        }
    }

    @Override // miuix.appcompat.app.d
    public final Context i() {
        if (this.f6700B == null) {
            this.f6700B = this.f6668i;
            if (this.f6699A != 0) {
                this.f6700B = new ContextThemeWrapper(this.f6700B, this.f6699A);
            }
        }
        return this.f6700B;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // miuix.appcompat.app.d
    protected final boolean m(MenuBuilder menuBuilder) {
        x xVar = this.f6706y;
        if (xVar instanceof l) {
            return ((l) xVar).g(menuBuilder);
        }
        return false;
    }

    @Override // miuix.appcompat.app.d
    public final boolean n(int i2, MenuItem menuItem) {
        if (i2 == 0) {
            Objects.requireNonNull(this.f6706y);
            return false;
        }
        if (i2 == 6) {
            return this.f6706y.d0(menuItem);
        }
        return false;
    }

    @Override // miuix.appcompat.app.d
    protected final boolean o(MenuBuilder menuBuilder) {
        Fragment fragment = this.f6706y;
        if (!(fragment instanceof l)) {
            return false;
        }
        Objects.requireNonNull(fragment);
        return true;
    }

    @Override // miuix.appcompat.internal.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return n(0, menuItem);
    }

    public final View z() {
        return this.f6707z;
    }
}
