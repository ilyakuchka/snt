package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
final class b extends ArrayAdapter<CharSequence> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f2313a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AlertController.b f2314b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(AlertController.b bVar, Context context, int i2, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i2, R.id.text1, charSequenceArr);
        this.f2314b = bVar;
        this.f2313a = recycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i2, view, viewGroup);
        boolean[] zArr = this.f2314b.p;
        if (zArr != null && zArr[i2]) {
            this.f2313a.setItemChecked(i2, true);
        }
        return view2;
    }
}
