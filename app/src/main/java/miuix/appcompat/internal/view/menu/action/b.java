package miuix.appcompat.internal.view.menu.action;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.Objects;
import miuix.appcompat.internal.app.widget.ActionBarOverlayLayout;
import miuix.appcompat.internal.view.menu.BaseMenuPresenter;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import miuix.appcompat.internal.view.menu.MenuDialogHelper;
import miuix.appcompat.internal.view.menu.MenuItemImpl;
import miuix.appcompat.internal.view.menu.MenuPopupHelper;
import miuix.appcompat.internal.view.menu.MenuPresenter;
import miuix.appcompat.internal.view.menu.MenuView;
import miuix.appcompat.internal.view.menu.SubMenuBuilder;
import miuix.appcompat.internal.view.menu.action.c;
import t3.C0386a;

/* loaded from: classes.dex */
public final class b extends BaseMenuPresenter {

    /* renamed from: i, reason: collision with root package name */
    private View f7035i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f7036j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7037k;

    /* renamed from: l, reason: collision with root package name */
    private int f7038l;

    /* renamed from: m, reason: collision with root package name */
    private int f7039m;

    /* renamed from: n, reason: collision with root package name */
    private int f7040n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7041o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private c f7042q;

    /* renamed from: r, reason: collision with root package name */
    private MenuItemImpl f7043r;

    /* renamed from: s, reason: collision with root package name */
    private a f7044s;

    /* renamed from: t, reason: collision with root package name */
    private RunnableC0121b f7045t;
    private ActionBarOverlayLayout u;

    /* renamed from: v, reason: collision with root package name */
    final e f7046v;

    /* renamed from: w, reason: collision with root package name */
    int f7047w;

    private class a extends MenuDialogHelper {
        public a(SubMenuBuilder subMenuBuilder) {
            super(subMenuBuilder);
            b.this.setCallback(b.this.f7046v);
        }

        @Override // miuix.appcompat.internal.view.menu.MenuDialogHelper, android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            b.this.f7044s = null;
            b.this.f7047w = 0;
        }
    }

    /* renamed from: miuix.appcompat.internal.view.menu.action.b$b, reason: collision with other inner class name */
    private class RunnableC0121b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private c f7049i;

        public RunnableC0121b(c cVar) {
            this.f7049i = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((BaseMenuPresenter) b.this).mMenu.changeMenuMode();
            View view = (View) ((BaseMenuPresenter) b.this).mMenuView;
            if (view != null && view.getWindowToken() != null && this.f7049i.tryShow()) {
                b.this.f7042q = this.f7049i;
            }
            b.this.f7045t = null;
        }
    }

    private interface c {
        boolean isShowing();

        boolean tryShow();
    }

    private class d extends MenuPopupHelper implements c {
        public d(Context context, MenuBuilder menuBuilder, View view) {
            super(context, menuBuilder, view, true);
            setCallback(b.this.f7046v);
            setMenuItemLayout(R.layout.miuix_appcompat_overflow_popup_menu_item_layout);
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPopupHelper
        public final void dismiss(boolean z4) {
            super.dismiss(z4);
            if (b.this.f7035i != null) {
                b.this.f7035i.setSelected(false);
            }
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPopupHelper, android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            super.onDismiss();
            ((BaseMenuPresenter) b.this).mMenu.close();
            b.this.f7042q = null;
        }
    }

    private class e implements MenuPresenter.Callback {
        e() {
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter.Callback
        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z4) {
            if (menuBuilder instanceof SubMenuBuilder) {
                BaseMenuPresenter.close(menuBuilder.getRootMenu(), false);
            }
        }

        @Override // miuix.appcompat.internal.view.menu.MenuPresenter.Callback
        public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            b.this.f7047w = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            return false;
        }
    }

    private static class f implements Parcelable {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        public int f7053i;

        final class a implements Parcelable.Creator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final f[] newArray(int i2) {
                return new f[i2];
            }
        }

        f() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f7053i);
        }

        f(Parcel parcel) {
            this.f7053i = parcel.readInt();
        }
    }

    public b(Context context, ActionBarOverlayLayout actionBarOverlayLayout, int i2) {
        super(context, R.layout.miuix_appcompat_action_menu_layout, i2);
        this.p = android.R.attr.actionOverflowButtonStyle;
        new SparseBooleanArray();
        this.f7046v = new e();
        this.f7040n = R.layout.miuix_appcompat_action_bar_expanded_menu_layout;
        this.f7039m = R.layout.miuix_appcompat_action_bar_list_menu_item_layout;
        this.u = actionBarOverlayLayout;
    }

    public static void a(b bVar) {
        MenuBuilder menuBuilder = bVar.mMenu;
        if (menuBuilder != null) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            if (bVar.f7043r == null) {
                bVar.f7043r = BaseMenuPresenter.createMenuItemImpl(bVar.mMenu, 0, R.id.more, 0, 0, bVar.mContext.getString(R.string.more), 0);
            }
            BaseMenuPresenter.dispatchMenuItemSelected(menuBuilder, rootMenu, bVar.f7043r);
        }
        if (bVar.f7035i.isSelected()) {
            bVar.k(true);
        } else {
            bVar.s();
        }
    }

    private c j() {
        return new d(this.mContext, this.mMenu, this.f7035i);
    }

    @Override // miuix.appcompat.internal.view.menu.BaseMenuPresenter
    public final void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        itemView.setItemInvoker((MenuBuilder.ItemInvoker) this.mMenuView);
    }

    @Override // miuix.appcompat.internal.view.menu.BaseMenuPresenter, miuix.appcompat.internal.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
        int size = visibleItems.size();
        int i2 = this.f7038l;
        if (i2 < size) {
            i2--;
        }
        int i4 = 0;
        while (true) {
            boolean z4 = true;
            if (i4 >= size || i2 <= 0) {
                break;
            }
            MenuItemImpl menuItemImpl = visibleItems.get(i4);
            if (!menuItemImpl.requestsActionButton() && !menuItemImpl.requiresActionButton()) {
                z4 = false;
            }
            menuItemImpl.setIsActionButton(z4);
            if (z4) {
                i2--;
            }
            i4++;
        }
        while (i4 < size) {
            visibleItems.get(i4).setIsActionButton(false);
            i4++;
        }
        return true;
    }

    @Override // miuix.appcompat.internal.view.menu.BaseMenuPresenter
    public final View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            if (!(view instanceof ActionMenuItemView)) {
                view = null;
            }
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        miuix.appcompat.internal.view.menu.action.c cVar = (miuix.appcompat.internal.view.menu.action.c) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!cVar.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(cVar.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // miuix.appcompat.internal.view.menu.BaseMenuPresenter, miuix.appcompat.internal.view.menu.MenuPresenter
    public final MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = super.getMenuView(viewGroup);
        ((miuix.appcompat.internal.view.menu.action.c) menuView).h(this);
        return menuView;
    }

    @Override // miuix.appcompat.internal.view.menu.BaseMenuPresenter, miuix.appcompat.internal.view.menu.MenuPresenter
    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        context.getResources();
        C0386a c0386aB = C0386a.b(context);
        if (!this.f7037k) {
            this.f7036j = true;
        }
        if (!this.f7041o) {
            c0386aB.c();
        }
        this.f7038l = c0386aB.d();
        if (!this.f7036j) {
            this.f7035i = null;
            return;
        }
        if (this.f7035i == null) {
            miuix.appcompat.internal.view.menu.action.d dVar = new miuix.appcompat.internal.view.menu.action.d(this.mSystemContext, this.p);
            dVar.a(new miuix.appcompat.internal.view.menu.action.a(this));
            this.f7035i = dVar;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.f7035i.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        }
        this.f7035i.getMeasuredWidth();
    }

    public final boolean k(boolean z4) {
        if (this.f7045t != null && this.mMenuView != null) {
            this.f7035i.setSelected(false);
            ((View) this.mMenuView).removeCallbacks(this.f7045t);
            this.f7045t = null;
            return true;
        }
        c cVar = this.f7042q;
        if (cVar == null) {
            return false;
        }
        boolean zIsShowing = cVar.isShowing();
        if (zIsShowing) {
            this.f7035i.setSelected(false);
        }
        ((d) this.f7042q).dismiss(z4);
        return zIsShowing;
    }

    public final boolean l() {
        a aVar = this.f7044s;
        if (aVar == null) {
            return false;
        }
        aVar.dismiss();
        return true;
    }

    public final boolean m() {
        c cVar = this.f7042q;
        return cVar != null && cVar.isShowing();
    }

    public final boolean n() {
        return this.f7036j;
    }

    public final void o(Configuration configuration) {
        this.f7038l = this.mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            BaseMenuPresenter.notifyItemsChanged(menuBuilder, true);
        }
        View view = this.f7035i;
        if (view instanceof miuix.appcompat.internal.view.menu.action.d) {
            ((miuix.appcompat.internal.view.menu.action.d) view).onConfigurationChanged(configuration);
        }
    }

    @Override // miuix.appcompat.internal.view.menu.BaseMenuPresenter, miuix.appcompat.internal.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z4) {
        k(true);
        super.onCloseMenu(menuBuilder, z4);
    }

    @Override // miuix.appcompat.internal.view.menu.MenuPresenter
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        int i2 = ((f) parcelable).f7053i;
        if (i2 <= 0 || (menuItemFindItem = this.mMenu.findItem(i2)) == null) {
            return;
        }
        onSubMenuSelected((SubMenuBuilder) menuItemFindItem.getSubMenu());
    }

    @Override // miuix.appcompat.internal.view.menu.MenuPresenter
    public final Parcelable onSaveInstanceState() {
        f fVar = new f();
        fVar.f7053i = this.f7047w;
        return fVar;
    }

    @Override // miuix.appcompat.internal.view.menu.BaseMenuPresenter, miuix.appcompat.internal.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        KeyEvent.Callback childAt;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        MenuItem item = subMenuBuilder2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            childAt = null;
        } else {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                childAt = viewGroup.getChildAt(i2);
                if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == item) {
                    break;
                }
            }
            childAt = null;
        }
        if (childAt == null && this.f7035i == null) {
            return false;
        }
        this.f7047w = subMenuBuilder.getItem().getItemId();
        a aVar = new a(subMenuBuilder);
        this.f7044s = aVar;
        aVar.show(null);
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public final void p() {
        this.p = R.attr.actionModeOverflowButtonStyle;
    }

    public final void q() {
        this.f7036j = true;
        this.f7037k = true;
    }

    public final void r(int i2) {
        this.f7041o = true;
    }

    public final boolean s() {
        if (!this.f7036j || m() || this.mMenu == null || this.mMenuView == null || this.f7045t != null) {
            return false;
        }
        RunnableC0121b runnableC0121b = new RunnableC0121b(j());
        this.f7045t = runnableC0121b;
        ((View) this.mMenuView).post(runnableC0121b);
        super.onSubMenuSelected(null);
        this.f7035i.setSelected(true);
        return true;
    }

    @Override // miuix.appcompat.internal.view.menu.BaseMenuPresenter
    public final boolean shouldIncludeItem(int i2, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    @Override // miuix.appcompat.internal.view.menu.BaseMenuPresenter, miuix.appcompat.internal.view.menu.MenuPresenter
    public final void updateMenuView(boolean z4) {
        super.updateMenuView(z4);
        if (this.mMenuView == null) {
            return;
        }
        MenuBuilder menuBuilder = this.mMenu;
        ArrayList<MenuItemImpl> nonActionItems = menuBuilder != null ? menuBuilder.getNonActionItems() : null;
        boolean z5 = false;
        if (this.f7036j && nonActionItems != null) {
            int size = nonActionItems.size();
            if (size == 1) {
                z5 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size > 0) {
                z5 = true;
            }
        }
        if (z5) {
            View view = this.f7035i;
            if (view == null) {
                miuix.appcompat.internal.view.menu.action.d dVar = new miuix.appcompat.internal.view.menu.action.d(this.mSystemContext, this.p);
                dVar.a(new miuix.appcompat.internal.view.menu.action.a(this));
                this.f7035i = dVar;
            } else {
                view.setTranslationY(0.0f);
            }
            ViewGroup viewGroup = (ViewGroup) this.f7035i.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f7035i);
                }
                miuix.appcompat.internal.view.menu.action.c cVar = (miuix.appcompat.internal.view.menu.action.c) this.mMenuView;
                View view2 = this.f7035i;
                Objects.requireNonNull(cVar);
                c.a aVar = new c.a();
                aVar.f7057a = true;
                cVar.addView(view2, aVar);
            }
        } else {
            View view3 = this.f7035i;
            if (view3 != null) {
                Object parent = view3.getParent();
                Object obj = this.mMenuView;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f7035i);
                }
            }
        }
        Objects.requireNonNull((miuix.appcompat.internal.view.menu.action.c) this.mMenuView);
    }
}
