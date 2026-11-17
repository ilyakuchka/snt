package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.m;
import androidx.core.view.b;
import com.android.mmt.R;
import i.C0333a;

/* loaded from: classes.dex */
public final class h implements A.b {

    /* renamed from: A, reason: collision with root package name */
    private androidx.core.view.b f2565A;

    /* renamed from: B, reason: collision with root package name */
    private MenuItem.OnActionExpandListener f2566B;

    /* renamed from: D, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f2568D;

    /* renamed from: a, reason: collision with root package name */
    private final int f2569a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2570b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2571c;
    private final int d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f2572e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f2573f;
    private Intent g;

    /* renamed from: h, reason: collision with root package name */
    private char f2574h;

    /* renamed from: j, reason: collision with root package name */
    private char f2576j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f2578l;

    /* renamed from: n, reason: collision with root package name */
    f f2580n;

    /* renamed from: o, reason: collision with root package name */
    private p f2581o;
    private MenuItem.OnMenuItemClickListener p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f2582q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f2583r;

    /* renamed from: y, reason: collision with root package name */
    private int f2589y;

    /* renamed from: z, reason: collision with root package name */
    private View f2590z;

    /* renamed from: i, reason: collision with root package name */
    private int f2575i = 4096;

    /* renamed from: k, reason: collision with root package name */
    private int f2577k = 4096;

    /* renamed from: m, reason: collision with root package name */
    private int f2579m = 0;

    /* renamed from: s, reason: collision with root package name */
    private ColorStateList f2584s = null;

    /* renamed from: t, reason: collision with root package name */
    private PorterDuff.Mode f2585t = null;
    private boolean u = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f2586v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f2587w = false;

    /* renamed from: x, reason: collision with root package name */
    private int f2588x = 16;

    /* renamed from: C, reason: collision with root package name */
    private boolean f2567C = false;

    final class a implements b.a {
        a() {
        }
    }

    h(f fVar, int i2, int i4, int i5, int i6, CharSequence charSequence, int i7) {
        this.f2580n = fVar;
        this.f2569a = i4;
        this.f2570b = i2;
        this.f2571c = i5;
        this.d = i6;
        this.f2572e = charSequence;
        this.f2589y = i7;
    }

    private static void c(StringBuilder sb, int i2, int i4, String str) {
        if ((i2 & i4) == i4) {
            sb.append(str);
        }
    }

    private Drawable d(Drawable drawable) {
        if (drawable != null && this.f2587w && (this.u || this.f2586v)) {
            drawable = drawable.mutate();
            if (this.u) {
                drawable.setTintList(this.f2584s);
            }
            if (this.f2586v) {
                drawable.setTintMode(this.f2585t);
            }
            this.f2587w = false;
        }
        return drawable;
    }

    @Override // A.b
    public final A.b a(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.f2565A;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.f2590z = null;
        this.f2565A = bVar;
        this.f2580n.x(true);
        androidx.core.view.b bVar3 = this.f2565A;
        if (bVar3 != null) {
            bVar3.i(new a());
        }
        return this;
    }

    @Override // A.b
    public final androidx.core.view.b b() {
        return this.f2565A;
    }

    @Override // A.b, android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f2589y & 8) == 0) {
            return false;
        }
        if (this.f2590z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f2566B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f2580n.f(this);
        }
        return false;
    }

    public final int e() {
        return this.d;
    }

    @Override // A.b, android.view.MenuItem
    public final boolean expandActionView() {
        if (!i()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f2566B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f2580n.h(this);
        }
        return false;
    }

    final char f() {
        return this.f2580n.t() ? this.f2576j : this.f2574h;
    }

    final String g() {
        char cF = f();
        if (cF == 0) {
            return "";
        }
        Resources resources = this.f2580n.n().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f2580n.n()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int i2 = this.f2580n.t() ? this.f2577k : this.f2575i;
        c(sb, i2, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        c(sb, i2, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        c(sb, i2, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        c(sb, i2, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        c(sb, i2, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        c(sb, i2, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (cF == '\b') {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (cF == '\n') {
            sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (cF != ' ') {
            sb.append(cF);
        } else {
            sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // A.b, android.view.MenuItem
    public final View getActionView() {
        View view = this.f2590z;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.f2565A;
        if (bVar == null) {
            return null;
        }
        View viewD = bVar.d(this);
        this.f2590z = viewD;
        return viewD;
    }

    @Override // A.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f2577k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f2576j;
    }

    @Override // A.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f2582q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f2570b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f2578l;
        if (drawable != null) {
            return d(drawable);
        }
        if (this.f2579m == 0) {
            return null;
        }
        Drawable drawableA = C0333a.a(this.f2580n.n(), this.f2579m);
        this.f2579m = 0;
        this.f2578l = drawableA;
        return d(drawableA);
    }

    @Override // A.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f2584s;
    }

    @Override // A.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f2585t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.f2569a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f2568D;
    }

    @Override // A.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f2575i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f2574h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f2571c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f2581o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.f2572e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2573f;
        return charSequence != null ? charSequence : this.f2572e;
    }

    @Override // A.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f2583r;
    }

    final CharSequence h(m.a aVar) {
        return (aVar == null || !aVar.prefersCondensedTitle()) ? this.f2572e : getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f2581o != null;
    }

    public final boolean i() {
        androidx.core.view.b bVar;
        if ((this.f2589y & 8) == 0) {
            return false;
        }
        if (this.f2590z == null && (bVar = this.f2565A) != null) {
            this.f2590z = bVar.d(this);
        }
        return this.f2590z != null;
    }

    @Override // A.b, android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f2567C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f2588x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f2588x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f2588x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        androidx.core.view.b bVar = this.f2565A;
        return (bVar == null || !bVar.g()) ? (this.f2588x & 8) == 0 : (this.f2588x & 8) == 0 && this.f2565A.b();
    }

    public final boolean j() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.p;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        f fVar = this.f2580n;
        if (fVar.g(fVar, this)) {
            return true;
        }
        if (this.g != null) {
            try {
                this.f2580n.n().startActivity(this.g);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        androidx.core.view.b bVar = this.f2565A;
        return bVar != null && bVar.e();
    }

    public final boolean k() {
        return (this.f2588x & 32) == 32;
    }

    public final boolean l() {
        return (this.f2588x & 4) != 0;
    }

    public final boolean m() {
        return (this.f2589y & 1) == 1;
    }

    public final boolean n() {
        return (this.f2589y & 2) == 2;
    }

    public final A.b o(View view) {
        int i2;
        this.f2590z = view;
        this.f2565A = null;
        if (view != null && view.getId() == -1 && (i2 = this.f2569a) > 0) {
            view.setId(i2);
        }
        this.f2580n.v();
        return this;
    }

    public final void p(boolean z4) {
        this.f2567C = z4;
        this.f2580n.x(false);
    }

    final void q(boolean z4) {
        int i2 = this.f2588x;
        int i4 = (z4 ? 2 : 0) | (i2 & (-3));
        this.f2588x = i4;
        if (i2 != i4) {
            this.f2580n.x(false);
        }
    }

    public final void r(boolean z4) {
        this.f2588x = (z4 ? 4 : 0) | (this.f2588x & (-5));
    }

    public final void s(boolean z4) {
        if (z4) {
            this.f2588x |= 32;
        } else {
            this.f2588x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // A.b, android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        o(view);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2) {
        if (this.f2576j == c2) {
            return this;
        }
        this.f2576j = Character.toLowerCase(c2);
        this.f2580n.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        int i2 = this.f2588x;
        int i4 = (z4 ? 1 : 0) | (i2 & (-2));
        this.f2588x = i4;
        if (i2 != i4) {
            this.f2580n.x(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        if ((this.f2588x & 4) != 0) {
            this.f2580n.G(this);
        } else {
            q(z4);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        if (z4) {
            this.f2588x |= 16;
        } else {
            this.f2588x &= -17;
        }
        this.f2580n.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f2579m = 0;
        this.f2578l = drawable;
        this.f2587w = true;
        this.f2580n.x(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2584s = colorStateList;
        this.u = true;
        this.f2587w = true;
        this.f2580n.x(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2585t = mode;
        this.f2586v = true;
        this.f2587w = true;
        this.f2580n.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2) {
        if (this.f2574h == c2) {
            return this;
        }
        this.f2574h = c2;
        this.f2580n.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f2566B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c4) {
        this.f2574h = c2;
        this.f2576j = Character.toLowerCase(c4);
        this.f2580n.x(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final void setShowAsAction(int i2) {
        int i4 = i2 & 3;
        if (i4 != 0 && i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f2589y = i2;
        this.f2580n.v();
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f2572e = charSequence;
        this.f2580n.x(false);
        p pVar = this.f2581o;
        if (pVar != null) {
            pVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2573f = charSequence;
        this.f2580n.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        int i2 = this.f2588x;
        int i4 = (z4 ? 0 : 8) | (i2 & (-9));
        this.f2588x = i4;
        if (i2 != i4) {
            this.f2580n.w();
        }
        return this;
    }

    public final void t(p pVar) {
        this.f2581o = pVar;
        pVar.setHeaderTitle(this.f2572e);
    }

    public final String toString() {
        CharSequence charSequence = this.f2572e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    final boolean u(boolean z4) {
        int i2 = this.f2588x;
        int i4 = (z4 ? 0 : 8) | (i2 & (-9));
        this.f2588x = i4;
        return i2 != i4;
    }

    public final boolean v() {
        return (this.f2589y & 4) == 4;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setActionView(int i2) {
        Context contextN = this.f2580n.n();
        o(LayoutInflater.from(contextN).inflate(i2, (ViewGroup) new LinearLayout(contextN), false));
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final A.b setContentDescription(CharSequence charSequence) {
        this.f2582q = charSequence;
        this.f2580n.x(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final A.b setTooltipText(CharSequence charSequence) {
        this.f2583r = charSequence;
        this.f2580n.x(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f2576j == c2 && this.f2577k == i2) {
            return this;
        }
        this.f2576j = Character.toLowerCase(c2);
        this.f2577k = KeyEvent.normalizeMetaState(i2);
        this.f2580n.x(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f2574h == c2 && this.f2575i == i2) {
            return this;
        }
        this.f2574h = c2;
        this.f2575i = KeyEvent.normalizeMetaState(i2);
        this.f2580n.x(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c4, int i2, int i4) {
        this.f2574h = c2;
        this.f2575i = KeyEvent.normalizeMetaState(i2);
        this.f2576j = Character.toLowerCase(c4);
        this.f2577k = KeyEvent.normalizeMetaState(i4);
        this.f2580n.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i2) {
        this.f2578l = null;
        this.f2579m = i2;
        this.f2587w = true;
        this.f2580n.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i2) {
        setTitle(this.f2580n.n().getString(i2));
        return this;
    }
}
