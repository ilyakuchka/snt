package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
public class n extends b implements Menu {
    private final A.a d;

    public n(Context context, A.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.d = aVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return c(this.d.add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i2, int i4, int i5, ComponentName componentName, Intent[] intentArr, Intent intent, int i6, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.d.addIntentOptions(i2, i4, i5, componentName, intentArr, intent, i6, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i7 = 0; i7 < length; i7++) {
                menuItemArr[i7] = c(menuItemArr2[i7]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public final void clear() {
        e();
        this.d.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.d.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i2) {
        return c(this.d.findItem(i2));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i2) {
        return c(this.d.getItem(i2));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.d.isShortcutKey(i2, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i2, int i4) {
        return this.d.performIdentifierAction(i2, i4);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i2, KeyEvent keyEvent, int i4) {
        return this.d.performShortcut(i2, keyEvent, i4);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i2) {
        f(i2);
        this.d.removeGroup(i2);
    }

    @Override // android.view.Menu
    public final void removeItem(int i2) {
        g(i2);
        this.d.removeItem(i2);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i2, boolean z4, boolean z5) {
        this.d.setGroupCheckable(i2, z4, z5);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i2, boolean z4) {
        this.d.setGroupEnabled(i2, z4);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i2, boolean z4) {
        this.d.setGroupVisible(i2, z4);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.d.setQwertyMode(z4);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.d.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2) {
        return c(this.d.add(i2));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2) {
        return d(this.d.addSubMenu(i2));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i4, int i5, CharSequence charSequence) {
        return c(this.d.add(i2, i4, i5, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i4, int i5, CharSequence charSequence) {
        return d(this.d.addSubMenu(i2, i4, i5, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i4, int i5, int i6) {
        return c(this.d.add(i2, i4, i5, i6));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i4, int i5, int i6) {
        return d(this.d.addSubMenu(i2, i4, i5, i6));
    }
}
