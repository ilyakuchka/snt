package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.m;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    f f2536a;

    /* renamed from: b, reason: collision with root package name */
    private int f2537b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2538c;
    private final boolean d;

    /* renamed from: e, reason: collision with root package name */
    private final LayoutInflater f2539e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2540f;

    public e(f fVar, LayoutInflater layoutInflater, boolean z4, int i2) {
        this.d = z4;
        this.f2539e = layoutInflater;
        this.f2536a = fVar;
        this.f2540f = i2;
        b();
    }

    final void b() {
        h hVarO = this.f2536a.o();
        if (hVarO != null) {
            ArrayList<h> arrayListP = this.f2536a.p();
            int size = arrayListP.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayListP.get(i2) == hVarO) {
                    this.f2537b = i2;
                    return;
                }
            }
        }
        this.f2537b = -1;
    }

    public final f c() {
        return this.f2536a;
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final h getItem(int i2) {
        ArrayList<h> arrayListP = this.d ? this.f2536a.p() : this.f2536a.r();
        int i4 = this.f2537b;
        if (i4 >= 0 && i2 >= i4) {
            i2++;
        }
        return arrayListP.get(i2);
    }

    public final void e(boolean z4) {
        this.f2538c = z4;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f2537b < 0 ? (this.d ? this.f2536a.p() : this.f2536a.r()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        boolean z4 = false;
        if (view == null) {
            view = this.f2539e.inflate(this.f2540f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i4 = i2 - 1;
        int groupId2 = i4 >= 0 ? getItem(i4).getGroupId() : groupId;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f2536a.s() && groupId != groupId2) {
            z4 = true;
        }
        listMenuItemView.d(z4);
        m.a aVar = (m.a) view;
        if (this.f2538c) {
            listMenuItemView.c();
        }
        aVar.b(getItem(i2));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
