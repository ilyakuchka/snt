package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.U;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements f.b, m, AdapterView.OnItemClickListener {

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f2467j = {R.attr.background, R.attr.divider};

    /* renamed from: i, reason: collision with root package name */
    private f f2468i;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        U u = U.u(context, attributeSet, f2467j, R.attr.listViewStyle, 0);
        if (u.r(0)) {
            setBackgroundDrawable(u.f(0));
        }
        if (u.r(1)) {
            setDivider(u.f(1));
        }
        u.v();
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean a(h hVar) {
        return this.f2468i.z(hVar, null, 0);
    }

    @Override // androidx.appcompat.view.menu.m
    public final void b(f fVar) {
        this.f2468i = fVar;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        a((h) getAdapter().getItem(i2));
    }
}
