package androidx.appcompat.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* loaded from: classes.dex */
public final class K extends I implements J {

    /* renamed from: H, reason: collision with root package name */
    private J f2790H;

    public static class a extends D {

        /* renamed from: v, reason: collision with root package name */
        final int f2791v;

        /* renamed from: w, reason: collision with root package name */
        final int f2792w;

        /* renamed from: x, reason: collision with root package name */
        private J f2793x;

        /* renamed from: y, reason: collision with root package name */
        private androidx.appcompat.view.menu.h f2794y;

        public a(Context context, boolean z4) {
            super(context, z4);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f2791v = 21;
                this.f2792w = 22;
            } else {
                this.f2791v = 22;
                this.f2792w = 21;
            }
        }

        public final void e(J j2) {
            this.f2793x = j2;
        }

        @Override // androidx.appcompat.widget.D, android.view.View
        public final boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            androidx.appcompat.view.menu.e eVar;
            int iPointToPosition;
            int i2;
            if (this.f2793x != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    eVar = (androidx.appcompat.view.menu.e) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    eVar = (androidx.appcompat.view.menu.e) adapter;
                }
                androidx.appcompat.view.menu.h item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = iPointToPosition - headersCount) >= 0 && i2 < eVar.getCount()) {
                    item = eVar.getItem(i2);
                }
                androidx.appcompat.view.menu.h hVar = this.f2794y;
                if (hVar != item) {
                    androidx.appcompat.view.menu.f fVarC = eVar.c();
                    if (hVar != null) {
                        this.f2793x.g(fVarC, hVar);
                    }
                    this.f2794y = item;
                    if (item != null) {
                        this.f2793x.e(fVarC, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.f2791v) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i2 != this.f2792w) {
                return super.onKeyDown(i2, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.e) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.e) adapter).c().e(false);
            return true;
        }
    }

    public K(Context context, int i2, int i4) {
        super(context, null, i2, i4);
    }

    @Override // androidx.appcompat.widget.J
    public final void e(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        J j2 = this.f2790H;
        if (j2 != null) {
            j2.e(fVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.J
    public final void g(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        J j2 = this.f2790H;
        if (j2 != null) {
            j2.g(fVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.I
    final D i(Context context, boolean z4) {
        a aVar = new a(context, z4);
        aVar.e(this);
        return aVar;
    }

    public final void v() {
        this.f2768G.setEnterTransition(null);
    }

    public final void w() {
        this.f2768G.setExitTransition(null);
    }

    public final void x(J j2) {
        this.f2790H = j2;
    }

    public final void y() {
        this.f2768G.setTouchModal(false);
    }
}
