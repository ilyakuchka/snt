package miuix.appcompat.internal.view.menu;

import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import miuix.internal.widget.d;

/* loaded from: classes.dex */
public class ImmersionMenuPopupWindowImpl extends d implements ImmersionMenuPopupWindow {
    private miuix.appcompat.app.d mActionBarDelegate;
    private ImmersionMenuAdapter mAdapter;
    private View mLastAnchor;
    private ViewGroup mLastParent;

    public ImmersionMenuPopupWindowImpl(miuix.appcompat.app.d dVar, Menu menu) {
        super(dVar.i());
        Context contextI = dVar.i();
        this.mActionBarDelegate = dVar;
        ImmersionMenuAdapter immersionMenuAdapter = new ImmersionMenuAdapter(contextI, menu);
        this.mAdapter = immersionMenuAdapter;
        setAdapter(immersionMenuAdapter);
        setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: miuix.appcompat.internal.view.menu.ImmersionMenuPopupWindowImpl.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                MenuItem item = ImmersionMenuPopupWindowImpl.this.mAdapter.getItem(i2);
                if (item.hasSubMenu()) {
                    final SubMenu subMenu = item.getSubMenu();
                    ImmersionMenuPopupWindowImpl.this.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: miuix.appcompat.internal.view.menu.ImmersionMenuPopupWindowImpl.1.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            ImmersionMenuPopupWindowImpl.this.setOnDismissListener(null);
                            ImmersionMenuPopupWindowImpl.this.update(subMenu);
                            ImmersionMenuPopupWindowImpl immersionMenuPopupWindowImpl = ImmersionMenuPopupWindowImpl.this;
                            immersionMenuPopupWindowImpl.fastShow(immersionMenuPopupWindowImpl.mLastAnchor, ImmersionMenuPopupWindowImpl.this.mLastParent);
                        }
                    });
                } else {
                    ImmersionMenuPopupWindowImpl.this.mActionBarDelegate.n(0, item);
                }
                ImmersionMenuPopupWindowImpl.this.dismiss(true);
            }
        });
    }

    private void adjustOffset(View view, ViewGroup viewGroup) {
        if (viewGroup == null) {
            Log.w("ImmersionMenu", "ImmersionMenuPopupWindow offset can't be adjusted without parent");
            return;
        }
        int[] iArr = new int[2];
        viewGroup.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        setVerticalOffset(-(view.getHeight() + ((iArr2[1] - iArr[1]) - getOffsetFromStatusBar())));
        setHorizontalOffset(viewGroup.getLayoutDirection() == 1 ? getMinMarginScreen() : (viewGroup.getWidth() - (view.getWidth() + (iArr2[0] - iArr[0]))) - getMinMarginScreen());
    }

    @Override // miuix.appcompat.internal.view.menu.ImmersionMenuPopupWindow
    public void dismiss(boolean z4) {
        dismiss();
    }

    @Override // miuix.internal.widget.d, miuix.appcompat.internal.view.menu.ImmersionMenuPopupWindow
    public void show(View view, ViewGroup viewGroup) {
        this.mLastAnchor = view;
        this.mLastParent = viewGroup;
        adjustOffset(view, viewGroup);
        super.show(view, viewGroup);
    }

    @Override // miuix.appcompat.internal.view.menu.ImmersionMenuPopupWindow
    public void update(Menu menu) {
        this.mAdapter.update(menu);
    }
}
