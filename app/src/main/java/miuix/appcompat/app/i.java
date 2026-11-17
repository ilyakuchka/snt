package miuix.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.android.mmt.R;
import java.lang.reflect.InvocationTargetException;
import miuix.appcompat.app.h;
import miuix.appcompat.internal.app.widget.ActionBarContainer;
import miuix.appcompat.internal.app.widget.ActionBarOverlayLayout;
import miuix.appcompat.internal.app.widget.ActionBarView;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.view.e;
import x3.C0418a;
import z3.C0431a;

/* loaded from: classes.dex */
final class i extends d {

    /* renamed from: A, reason: collision with root package name */
    private ViewGroup f6687A;

    /* renamed from: B, reason: collision with root package name */
    private LayoutInflater f6688B;

    /* renamed from: C, reason: collision with root package name */
    private e f6689C;

    /* renamed from: D, reason: collision with root package name */
    Window f6690D;

    /* renamed from: E, reason: collision with root package name */
    private b f6691E;

    /* renamed from: F, reason: collision with root package name */
    private final Runnable f6692F;

    /* renamed from: y, reason: collision with root package name */
    private ActionBarOverlayLayout f6693y;

    /* renamed from: z, reason: collision with root package name */
    private ActionBarContainer f6694z;

    final class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.Menu, miuix.appcompat.internal.view.menu.MenuBuilder] */
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            ?? E2 = i.this.e();
            if (!i.this.l() && ((h.a) i.this.f6689C).a(0, E2) && ((h.a) i.this.f6689C).b(0, null, E2)) {
                i.this.r(E2);
            } else {
                i.this.r(null);
            }
        }
    }

    class b extends l.i {
        public b(Window.Callback callback) {
            super(callback);
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
        }
    }

    i(h hVar, e eVar) {
        super(hVar);
        this.f6692F = new a();
        this.f6689C = eVar;
    }

    private void x() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBarOverlayLayout actionBarOverlayLayout;
        h hVar;
        if (this.f6672m) {
            return;
        }
        Window window = this.f6690D;
        if (window == null) {
            if (window == null && (hVar = this.f6668i) != null) {
                Window window2 = hVar.getWindow();
                if (this.f6690D != null) {
                    throw new IllegalStateException("AppCompat has already installed itself into the Window");
                }
                Window.Callback callback = window2.getCallback();
                if (callback instanceof b) {
                    throw new IllegalStateException("AppCompat has already installed itself into the Window");
                }
                b bVar = new b(callback);
                this.f6691E = bVar;
                window2.setCallback(bVar);
                this.f6690D = window2;
            }
            if (this.f6690D == null) {
                throw new IllegalStateException("We have not been given a Window");
            }
        }
        this.f6672m = true;
        Window window3 = this.f6668i.getWindow();
        this.f6688B = window3.getLayoutInflater();
        TypedArray typedArrayObtainStyledAttributes = this.f6668i.obtainStyledAttributes(Y1.a.f2109b0);
        if (typedArrayObtainStyledAttributes.getInt(21, 0) == 1) {
            this.f6668i.getWindow().setGravity(80);
        }
        if (!typedArrayObtainStyledAttributes.hasValue(10)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a miui theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(10, false)) {
            p(8);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(12, false)) {
            p(9);
        }
        s(typedArrayObtainStyledAttributes.getInt(27, 0));
        h hVar2 = this.f6668i;
        Context context = window3.getContext();
        int i2 = C0431a.c(context, R.attr.windowActionBar, false) ? C0431a.c(context, R.attr.windowActionBarMovable, false) ? R.layout.miuix_appcompat_screen_action_bar_movable : R.layout.miuix_appcompat_screen_action_bar : R.layout.miuix_appcompat_screen_simple;
        int iB = C0431a.b(context, R.attr.startingWindowOverlay);
        if (iB > 0 && "android".equals(this.f6668i.getApplicationContext().getApplicationInfo().packageName) && C0431a.c(context, R.attr.windowActionBar, true)) {
            i2 = iB;
        }
        if (!window3.isFloating() && (window3.getCallback() instanceof Dialog)) {
            C0418a.a(window3, C0431a.g(context, R.attr.windowTranslucentStatus, 0));
        }
        View viewInflate = View.inflate(hVar2, i2, null);
        View viewFindViewById = viewInflate.findViewById(R.id.action_bar_overlay_layout);
        if (viewFindViewById instanceof ActionBarOverlayLayout) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) viewFindViewById;
            this.f6693y = actionBarOverlayLayout2;
            ViewGroup viewGroup = (ViewGroup) actionBarOverlayLayout2.findViewById(android.R.id.content);
            ViewGroup viewGroup2 = (ViewGroup) window3.findViewById(android.R.id.content);
            if (viewGroup2 != null) {
                while (viewGroup2.getChildCount() > 0) {
                    View childAt = viewGroup2.getChildAt(0);
                    viewGroup2.removeViewAt(0);
                    viewGroup.addView(childAt);
                }
                viewGroup2.setId(-1);
                viewGroup.setId(android.R.id.content);
                if (viewGroup2 instanceof FrameLayout) {
                    ((FrameLayout) viewGroup2).setForeground(null);
                }
            }
        }
        window3.setContentView(viewInflate);
        ActionBarOverlayLayout actionBarOverlayLayout3 = this.f6693y;
        if (actionBarOverlayLayout3 != null) {
            this.f6687A = (ViewGroup) actionBarOverlayLayout3.findViewById(android.R.id.content);
        }
        ActionBarOverlayLayout actionBarOverlayLayout4 = this.f6693y;
        if (actionBarOverlayLayout4 != null) {
            actionBarOverlayLayout4.v(this.f6668i);
            this.f6693y.C(j());
        }
        if (this.f6674o && (actionBarOverlayLayout = this.f6693y) != null) {
            this.f6694z = (ActionBarContainer) actionBarOverlayLayout.findViewById(R.id.action_bar_container);
            this.f6693y.z(this.p);
            ActionBarView actionBarView = (ActionBarView) this.f6693y.findViewById(R.id.action_bar);
            this.f6669j = actionBarView;
            actionBarView.H0(this.f6668i);
            if (this.f6673n) {
                this.f6669j.e0();
            }
            this.f6678t = typedArrayObtainStyledAttributes.getResourceId(5, 0);
            if (l()) {
                this.f6669j.d0(this.f6678t, this);
            }
            if (this.f6669j.V() != null) {
                ActionBarView actionBarView2 = this.f6669j;
                actionBarView2.v0(actionBarView2.W() | 16);
            }
            boolean zEquals = "splitActionBarWhenNarrow".equals(k());
            boolean z4 = zEquals ? this.f6668i.getResources().getBoolean(R.bool.abc_split_action_bar_is_narrow) : typedArrayObtainStyledAttributes.getBoolean(26, false);
            if (z4) {
                d(z4, zEquals, this.f6693y);
            }
            this.f6668i.getWindow().getDecorView().post(this.f6692F);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(4, false)) {
            q(true);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void A(Bundle bundle) {
        ApplicationInfo applicationInfo;
        Bundle bundle2;
        Bundle bundle3;
        super/*androidx.fragment.app.o*/.onCreate(bundle);
        x();
        ActivityInfo activityInfo = null;
        try {
            applicationInfo = this.f6668i.getPackageManager().getApplicationInfo(this.f6668i.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        int i2 = (applicationInfo == null || (bundle3 = applicationInfo.metaData) == null) ? 0 : bundle3.getInt("miui.extra.window.padding.level", 0);
        try {
            activityInfo = this.f6668i.getPackageManager().getActivityInfo(this.f6668i.getComponentName(), 128);
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
        }
        if (activityInfo != null && (bundle2 = activityInfo.metaData) != null) {
            i2 = bundle2.getInt("miui.extra.window.padding.level", i2);
        }
        int iG = C0431a.g(this.f6668i, R.attr.windowExtraPaddingHorizontal, i2);
        boolean zC = C0431a.c(this.f6668i, R.attr.windowExtraPaddingHorizontalEnable, iG != 0);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f6693y;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.y(iG);
        }
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f6693y;
        if (actionBarOverlayLayout2 != null) {
            actionBarOverlayLayout2.x(zC);
        }
    }

    public final boolean B(int i2, Menu menu) {
        return i2 != 0 && ((h.a) this.f6689C).a(i2, menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [miuix.appcompat.app.h$a] */
    /* JADX WARN: Type inference failed for: r1v4, types: [miuix.appcompat.app.h$a] */
    /* JADX WARN: Type inference failed for: r4v0, types: [miuix.appcompat.app.d, miuix.appcompat.app.i] */
    /* JADX WARN: Type inference failed for: r5v2, types: [miuix.appcompat.internal.view.menu.MenuBuilder] */
    /* JADX WARN: Type inference failed for: r5v3, types: [miuix.appcompat.internal.view.menu.MenuBuilder] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.Menu, miuix.appcompat.internal.view.menu.MenuBuilder] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.view.Menu, miuix.appcompat.internal.view.menu.MenuBuilder] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public final View C(int i2) throws Resources.NotFoundException {
        if (i2 != 0) {
            return super/*android.app.Activity*/.onCreatePanelView(i2);
        }
        if (!l()) {
            ?? r5 = this.f6670k;
            boolean zB = true;
            r5 = r5;
            if (this.f6671l == null) {
                if (r5 == 0) {
                    ?? E2 = e();
                    r(E2);
                    E2.stopDispatchingItemsChanged();
                    zB = ((h.a) this.f6689C).a(0, E2);
                    r5 = E2;
                }
                if (zB) {
                    r5.stopDispatchingItemsChanged();
                    zB = ((h.a) this.f6689C).b(0, null, r5);
                }
            } else if (r5 == 0) {
                zB = false;
            }
            if (zB) {
                r5.startDispatchingItemsChanged();
            } else {
                r(null);
            }
        }
        return null;
    }

    public final void D() {
        super/*androidx.fragment.app.o*/.onPostResume();
    }

    public final boolean E(int i2, View view, Menu menu) {
        return i2 != 0 && ((h.a) this.f6689C).b(i2, view, menu);
    }

    public final void F(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray;
        super/*android.app.Activity*/.onRestoreInstanceState(bundle);
        if (this.f6694z == null || (sparseParcelableArray = bundle.getSparseParcelableArray("miuix:ActionBar")) == null) {
            return;
        }
        this.f6694z.restoreHierarchyState(sparseParcelableArray);
    }

    public final void G(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        if (this.f6694z != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f6694z.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("miuix:ActionBar", sparseArray);
        }
    }

    public final void H() {
        super/*androidx.fragment.app.o*/.onStop();
        f();
        miuix.appcompat.internal.app.widget.d dVar = (miuix.appcompat.internal.app.widget.d) g();
        if (dVar != null) {
            dVar.O(false);
        }
    }

    public final ActionMode I(ActionMode.Callback callback) {
        if (g() != null) {
            return ((miuix.appcompat.internal.app.widget.d) g()).P(callback);
        }
        return null;
    }

    public final void J(int i2) {
        if (!this.f6672m) {
            x();
        }
        ViewGroup viewGroup = this.f6687A;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f6688B.inflate(i2, this.f6687A);
        }
        this.f6691E.a().onContentChanged();
    }

    public final void K(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f6672m) {
            x();
        }
        ViewGroup viewGroup = this.f6687A;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f6687A.addView(view, layoutParams);
        }
        this.f6691E.a().onContentChanged();
    }

    public final void L() {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f6693y;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.x(false);
        }
    }

    public final ActionMode M(ActionMode.Callback callback) {
        if (callback instanceof e.a) {
            c(this.f6693y);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f6693y;
        if (actionBarOverlayLayout != null) {
            return actionBarOverlayLayout.startActionMode(callback);
        }
        return null;
    }

    @Override // miuix.appcompat.app.c
    public final miuix.appcompat.app.b a() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!this.f6672m) {
            x();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f6693y;
        if (actionBarOverlayLayout == null) {
            return null;
        }
        return new miuix.appcompat.internal.app.widget.d(this.f6668i, actionBarOverlayLayout);
    }

    @Override // miuix.appcompat.app.c
    public final void b() {
        ((a) this.f6692F).run();
    }

    @Override // miuix.appcompat.app.d
    public final Context i() {
        return this.f6668i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // miuix.appcompat.app.d
    protected final boolean m(MenuBuilder menuBuilder) {
        return this.f6668i.onCreateOptionsMenu(menuBuilder);
    }

    @Override // miuix.appcompat.app.d
    public final boolean n(int i2, MenuItem menuItem) {
        if (super/*androidx.fragment.app.o*/.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0 && menuItem.getItemId() == 16908332 && g() != null && (g().a() & 4) != 0) {
            if (!(this.f6668i.getParent() == null ? this.f6668i.onNavigateUp() : this.f6668i.getParent().onNavigateUpFromChild(this.f6668i))) {
                this.f6668i.finish();
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // miuix.appcompat.app.d
    protected final boolean o(MenuBuilder menuBuilder) {
        return this.f6668i.onPrepareOptionsMenu(menuBuilder);
    }

    @Override // miuix.appcompat.internal.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f6668i.onMenuItemSelected(0, menuItem);
    }

    public final void v(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f6672m) {
            x();
        }
        ViewGroup viewGroup = this.f6687A;
        if (viewGroup != null) {
            viewGroup.addView(view, layoutParams);
        }
        this.f6691E.a().onContentChanged();
    }

    public final int w() {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f6693y;
        if (actionBarOverlayLayout != null) {
            return actionBarOverlayLayout.n();
        }
        return 0;
    }

    final void y() {
        ActionMode actionMode = this.f6671l;
        if (actionMode != null) {
            actionMode.finish();
            return;
        }
        ActionBarView actionBarView = this.f6669j;
        if (actionBarView == null || !actionBarView.Z()) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        } else {
            this.f6669j.T();
        }
    }

    public final void z(Configuration configuration) {
        miuix.appcompat.internal.app.widget.d dVar;
        if (this.f6674o && this.f6672m && (dVar = (miuix.appcompat.internal.app.widget.d) g()) != null) {
            dVar.L();
        }
        super/*androidx.fragment.app.o*/.onConfigurationChanged(configuration);
    }
}
