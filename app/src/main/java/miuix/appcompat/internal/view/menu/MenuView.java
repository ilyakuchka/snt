package miuix.appcompat.internal.view.menu;

import android.graphics.drawable.Drawable;
import miuix.appcompat.internal.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i2);

        boolean prefersCondensedTitle();

        void setCheckable(boolean z4);

        void setChecked(boolean z4);

        void setEnabled(boolean z4);

        void setIcon(Drawable drawable);

        void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker);

        void setShortcut(boolean z4, char c2);

        void setTitle(CharSequence charSequence);

        boolean showsIcon();
    }

    boolean filterLeftoverView(int i2);

    int getWindowAnimations();

    boolean hasBackgroundView();

    void initialize(MenuBuilder menuBuilder);
}
