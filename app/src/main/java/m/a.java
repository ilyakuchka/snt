package m;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import w.C0405a;

/* loaded from: classes.dex */
public final class a implements A.b {

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f6548a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f6549b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f6550c;
    private char d;

    /* renamed from: f, reason: collision with root package name */
    private char f6552f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f6553h;

    /* renamed from: i, reason: collision with root package name */
    private Context f6554i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f6555j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f6556k;

    /* renamed from: e, reason: collision with root package name */
    private int f6551e = 4096;
    private int g = 4096;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f6557l = null;

    /* renamed from: m, reason: collision with root package name */
    private PorterDuff.Mode f6558m = null;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6559n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6560o = false;
    private int p = 16;

    public a(Context context, CharSequence charSequence) {
        this.f6554i = context;
        this.f6548a = charSequence;
    }

    private void c() {
        Drawable drawable = this.f6553h;
        if (drawable != null) {
            if (this.f6559n || this.f6560o) {
                this.f6553h = drawable;
                Drawable drawableMutate = drawable.mutate();
                this.f6553h = drawableMutate;
                if (this.f6559n) {
                    drawableMutate.setTintList(this.f6557l);
                }
                if (this.f6560o) {
                    this.f6553h.setTintMode(this.f6558m);
                }
            }
        }
    }

    @Override // A.b
    public final A.b a(androidx.core.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // A.b
    public final androidx.core.view.b b() {
        return null;
    }

    @Override // A.b, android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // A.b, android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // A.b, android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // A.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f6552f;
    }

    @Override // A.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f6555j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f6553h;
    }

    @Override // A.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f6557l;
    }

    @Override // A.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f6558m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f6550c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // A.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f6551e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f6548a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f6549b;
        return charSequence != null ? charSequence : this.f6548a;
    }

    @Override // A.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f6556k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // A.b, android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2) {
        this.f6552f = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        this.p = (z4 ? 1 : 0) | (this.p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        this.p = (z4 ? 2 : 0) | (this.p & (-3));
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final A.b setContentDescription(CharSequence charSequence) {
        this.f6555j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        this.p = (z4 ? 16 : 0) | (this.p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f6553h = drawable;
        c();
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f6557l = colorStateList;
        this.f6559n = true;
        c();
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f6558m = mode;
        this.f6560o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f6550c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2) {
        this.d = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c4) {
        this.d = c2;
        this.f6552f = Character.toLowerCase(c4);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final void setShowAsAction(int i2) {
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i2) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f6548a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f6549b = charSequence;
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final A.b setTooltipText(CharSequence charSequence) {
        this.f6556k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        this.p = (this.p & 8) | (z4 ? 0 : 8);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f6552f = Character.toLowerCase(c2);
        this.g = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f6555j = charSequence;
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2, int i2) {
        this.d = c2;
        this.f6551e = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i2) {
        this.f6548a = this.f6554i.getResources().getString(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f6556k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i2) {
        Context context = this.f6554i;
        int i4 = C0405a.f7979b;
        this.f6553h = context.getDrawable(i2);
        c();
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c4, int i2, int i4) {
        this.d = c2;
        this.f6551e = KeyEvent.normalizeMetaState(i2);
        this.f6552f = Character.toLowerCase(c4);
        this.g = KeyEvent.normalizeMetaState(i4);
        return this;
    }
}
