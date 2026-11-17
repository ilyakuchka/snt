package v3;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;

/* renamed from: v3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0404a extends miuix.internal.widget.e {

    /* renamed from: c, reason: collision with root package name */
    private MenuItem f7962c;

    protected C0404a(Context context, Menu menu) {
        super(context, menu);
    }

    @Override // miuix.internal.widget.e
    protected final boolean c(MenuItem menuItem) {
        boolean zIsVisible = menuItem.isVisible();
        if (!zIsVisible || menuItem.getOrder() != 131072) {
            return zIsVisible;
        }
        if (this.f7962c != null) {
            throw new IllegalStateException("Only one menu item is allowed to have CATEGORY_SYSTEM order!");
        }
        this.f7962c = menuItem;
        return false;
    }

    final MenuItem f() {
        return this.f7962c;
    }
}
