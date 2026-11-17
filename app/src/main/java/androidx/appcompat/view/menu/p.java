package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.f;

/* loaded from: classes.dex */
public final class p extends f implements SubMenu {

    /* renamed from: A, reason: collision with root package name */
    private h f2632A;

    /* renamed from: z, reason: collision with root package name */
    private f f2633z;

    public p(Context context, f fVar, h hVar) {
        super(context);
        this.f2633z = fVar;
        this.f2632A = hVar;
    }

    @Override // androidx.appcompat.view.menu.f
    public final void E(f.a aVar) {
        this.f2633z.E(aVar);
    }

    public final Menu Q() {
        return this.f2633z;
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean f(h hVar) {
        return this.f2633z.f(hVar);
    }

    @Override // androidx.appcompat.view.menu.f
    final boolean g(f fVar, MenuItem menuItem) {
        return super.g(fVar, menuItem) || this.f2633z.g(fVar, menuItem);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f2632A;
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean h(h hVar) {
        return this.f2633z.h(hVar);
    }

    @Override // androidx.appcompat.view.menu.f
    public final String m() {
        h hVar = this.f2632A;
        int itemId = hVar != null ? hVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return "android:menu:actionviewstates:" + itemId;
    }

    @Override // androidx.appcompat.view.menu.f
    public final f q() {
        return this.f2633z.q();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean s() {
        return this.f2633z.s();
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setGroupDividerEnabled(boolean z4) {
        this.f2633z.setGroupDividerEnabled(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        I(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        L(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        M(view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f2632A.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.f2633z.setQwertyMode(z4);
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean t() {
        return this.f2633z.t();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean u() {
        return this.f2633z.u();
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i2) {
        H(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i2) {
        K(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i2) {
        this.f2632A.setIcon(i2);
        return this;
    }
}
