package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements m.b, l, AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    private Rect f2600i;

    j() {
    }

    protected static int k(ListAdapter listAdapter, Context context, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i4 = 0;
        int i5 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = listAdapter.getItemViewType(i6);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i6, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i2) {
                return i2;
            }
            if (measuredWidth > i4) {
                i4 = measuredWidth;
            }
        }
        return i4;
    }

    protected static boolean t(f fVar) {
        int size = fVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = fVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean b(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public final void c(Context context, f fVar) {
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean e(h hVar) {
        return false;
    }

    public abstract void i(f fVar);

    public final Rect j() {
        return this.f2600i;
    }

    public abstract void l(View view);

    public final void m(Rect rect) {
        this.f2600i = rect;
    }

    public abstract void n(boolean z4);

    public abstract void o(int i2);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (e) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (e) listAdapter).f2536a.z((MenuItem) listAdapter.getItem(i2), this, (this instanceof c) ^ true ? 0 : 4);
    }

    public abstract void p(int i2);

    public abstract void q(PopupWindow.OnDismissListener onDismissListener);

    public abstract void r(boolean z4);

    public abstract void s(int i2);
}
