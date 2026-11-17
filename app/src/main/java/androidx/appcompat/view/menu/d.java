package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d implements l, AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    Context f2528i;

    /* renamed from: j, reason: collision with root package name */
    LayoutInflater f2529j;

    /* renamed from: k, reason: collision with root package name */
    f f2530k;

    /* renamed from: l, reason: collision with root package name */
    ExpandedMenuView f2531l;

    /* renamed from: m, reason: collision with root package name */
    private l.a f2532m;

    /* renamed from: n, reason: collision with root package name */
    a f2533n;

    /* JADX INFO: Access modifiers changed from: private */
    class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private int f2534a = -1;

        public a() {
            b();
        }

        final void b() {
            h hVarO = d.this.f2530k.o();
            if (hVarO != null) {
                ArrayList<h> arrayListP = d.this.f2530k.p();
                int size = arrayListP.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (arrayListP.get(i2) == hVarO) {
                        this.f2534a = i2;
                        return;
                    }
                }
            }
            this.f2534a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final h getItem(int i2) {
            ArrayList<h> arrayListP = d.this.f2530k.p();
            Objects.requireNonNull(d.this);
            int i4 = i2 + 0;
            int i5 = this.f2534a;
            if (i5 >= 0 && i4 >= i5) {
                i4++;
            }
            return arrayListP.get(i4);
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            int size = d.this.f2530k.p().size();
            Objects.requireNonNull(d.this);
            int i2 = size + 0;
            return this.f2534a < 0 ? i2 : i2 - 1;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = d.this.f2529j.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
            }
            ((m.a) view).b(getItem(i2));
            return view;
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public d(Context context) {
        this.f2528i = context;
        this.f2529j = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.l
    public final void a(f fVar, boolean z4) {
        l.a aVar = this.f2532m;
        if (aVar != null) {
            aVar.a(fVar, z4);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean b(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public final void c(Context context, f fVar) {
        if (this.f2528i != null) {
            this.f2528i = context;
            if (this.f2529j == null) {
                this.f2529j = LayoutInflater.from(context);
            }
        }
        this.f2530k = fVar;
        a aVar = this.f2533n;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public final void d(l.a aVar) {
        this.f2532m = aVar;
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean e(h hVar) {
        return false;
    }

    public final ListAdapter f() {
        if (this.f2533n == null) {
            this.f2533n = new a();
        }
        return this.f2533n;
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public final boolean g(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        new g(pVar).c();
        l.a aVar = this.f2532m;
        if (aVar == null) {
            return true;
        }
        aVar.b(pVar);
        return true;
    }

    public final m h(ViewGroup viewGroup) {
        if (this.f2531l == null) {
            this.f2531l = (ExpandedMenuView) this.f2529j.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f2533n == null) {
                this.f2533n = new a();
            }
            this.f2531l.setAdapter((ListAdapter) this.f2533n);
            this.f2531l.setOnItemClickListener(this);
        }
        return this.f2531l;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f2530k.z(this.f2533n.getItem(i2), this, 0);
    }

    @Override // androidx.appcompat.view.menu.l
    public final void updateMenuView(boolean z4) {
        a aVar = this.f2533n;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }
}
