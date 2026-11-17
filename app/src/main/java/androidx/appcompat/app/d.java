package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
final class d implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f2317i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ AlertController f2318j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ AlertController.b f2319k;

    d(AlertController.b bVar, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.f2319k = bVar;
        this.f2317i = recycleListView;
        this.f2318j = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        boolean[] zArr = this.f2319k.p;
        if (zArr != null) {
            zArr[i2] = this.f2317i.isItemChecked(i2);
        }
        this.f2319k.f2310t.onClick(this.f2318j.f2270b, i2, this.f2317i.isItemChecked(i2));
    }
}
