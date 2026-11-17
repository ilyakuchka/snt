package miuix.appcompat.internal.view.menu.action;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.android.mmt.R;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.appcompat.internal.view.menu.MenuItemImpl;
import miuix.appcompat.internal.view.menu.MenuView;
import u3.C0393b;

/* loaded from: classes.dex */
public class ActionMenuItemView extends LinearLayout implements MenuView.ItemView {

    /* renamed from: i, reason: collision with root package name */
    private MenuItemImpl f7018i;

    /* renamed from: j, reason: collision with root package name */
    private MenuBuilder.ItemInvoker f7019j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7020k;

    /* renamed from: l, reason: collision with root package name */
    private C0393b f7021l;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f7021l = new C0393b(this);
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final MenuItemImpl getItemData() {
        return this.f7018i;
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final void initialize(MenuItemImpl menuItemImpl, int i2) {
        this.f7018i = menuItemImpl;
        setSelected(false);
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setClickable(true);
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        this.f7021l.a(getContext().getResources().getConfiguration());
        setPaddingRelative(getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_action_button_bg_top_padding), getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_action_button_bg_bottom_padding));
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        MenuBuilder.ItemInvoker itemInvoker = this.f7019j;
        if (itemInvoker == null || !itemInvoker.invokeItem(this.f7018i)) {
            return false;
        }
        playSoundEffect(0);
        return true;
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final boolean prefersCondensedTitle() {
        return false;
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final void setCheckable(boolean z4) {
        this.f7020k = z4;
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final void setChecked(boolean z4) {
        if (this.f7020k) {
            setSelected(z4);
        }
    }

    @Override // android.view.View, miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final void setEnabled(boolean z4) {
        super.setEnabled(z4);
        this.f7021l.b(z4);
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final void setIcon(Drawable drawable) {
        this.f7021l.c(drawable);
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f7019j = itemInvoker;
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final void setShortcut(boolean z4, char c2) {
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final void setTitle(CharSequence charSequence) {
        this.f7021l.d(charSequence);
    }

    @Override // miuix.appcompat.internal.view.menu.MenuView.ItemView
    public final boolean showsIcon() {
        return true;
    }
}
