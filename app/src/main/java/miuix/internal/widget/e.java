package miuix.internal.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mmt.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class e extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private LayoutInflater f7166a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<MenuItem> f7167b;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        ImageView f7168a;

        /* renamed from: b, reason: collision with root package name */
        TextView f7169b;

        private b() {
        }

        b(a aVar) {
        }
    }

    protected e(Context context, Menu menu) {
        this.f7166a = LayoutInflater.from(context);
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        this.f7167b = arrayList;
        if (menu != null) {
            b(menu, arrayList);
        }
    }

    private void b(Menu menu, ArrayList<MenuItem> arrayList) {
        arrayList.clear();
        if (menu != null) {
            int size = menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = menu.getItem(i2);
                if (c(item)) {
                    arrayList.add(item);
                }
            }
        }
    }

    protected boolean c(MenuItem menuItem) {
        throw null;
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final MenuItem getItem(int i2) {
        return this.f7167b.get(i2);
    }

    public final void e(Menu menu) {
        b(menu, this.f7167b);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f7167b.size();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f7166a.inflate(R.layout.miuix_appcompat_popup_menu_item, viewGroup, false);
            b bVar = new b(null);
            bVar.f7168a = (ImageView) view.findViewById(android.R.id.icon);
            bVar.f7169b = (TextView) view.findViewById(android.R.id.text1);
            view.setTag(R.id.tag_popup_menu_item, bVar);
        }
        z3.d.b(view, i2, getCount());
        Object tag = view.getTag(R.id.tag_popup_menu_item);
        if (tag != null) {
            b bVar2 = (b) tag;
            MenuItem item = getItem(i2);
            if (item.getIcon() != null) {
                bVar2.f7168a.setImageDrawable(item.getIcon());
                bVar2.f7168a.setVisibility(0);
            } else {
                bVar2.f7168a.setVisibility(8);
            }
            bVar2.f7169b.setText(item.getTitle());
        }
        return view;
    }
}
