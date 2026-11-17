package P0;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mmt.R;
import java.util.List;

/* loaded from: classes.dex */
public final class v extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f957a;

    /* renamed from: b, reason: collision with root package name */
    private List<H0.a> f958b;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        TextView f959a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f960b;

        /* renamed from: c, reason: collision with root package name */
        TextView f961c;
        View d;

        private b() {
        }

        b(a aVar) {
        }
    }

    public v(Context context, List<H0.a> list) {
        this.f957a = context;
        this.f958b = list;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final H0.a getItem(int i2) {
        List<H0.a> list = this.f958b;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.f958b.get(i2);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<H0.a> list = this.f958b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View viewInflate;
        b bVar;
        if (view == null) {
            bVar = new b(null);
            viewInflate = LayoutInflater.from(this.f957a).inflate(R.layout.sim_card_info_item, (ViewGroup) null);
            bVar.f959a = (TextView) viewInflate.findViewById(R.id.tv_title);
            bVar.f960b = (ImageView) viewInflate.findViewById(R.id.iv_indicator);
            bVar.f961c = (TextView) viewInflate.findViewById(R.id.tv_sub_info);
            bVar.d = viewInflate.findViewById(R.id.v_bottom_divider);
            viewInflate.setTag(bVar);
        } else {
            viewInflate = view;
            bVar = (b) view.getTag();
        }
        bVar.d.setVisibility(i2 == getCount() + (-1) ? 0 : 8);
        H0.a item = getItem(i2);
        if (item != null) {
            bVar.f959a.setText(item.f258c);
            if (TextUtils.isEmpty(item.f257b)) {
                bVar.f961c.setVisibility(8);
            } else {
                bVar.f961c.setVisibility(0);
                bVar.f961c.setText(item.f257b);
            }
            if (item.f256a == 0) {
                bVar.f960b.setImageResource(R.drawable.sim1_indicator);
            } else {
                bVar.f960b.setImageResource(R.drawable.sim2_indicator);
            }
        }
        return viewInflate;
    }
}
