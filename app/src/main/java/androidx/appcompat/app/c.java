package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
final class c implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ AlertController f2315i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ AlertController.b f2316j;

    c(AlertController.b bVar, AlertController alertController) {
        this.f2316j = bVar;
        this.f2315i = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f2316j.f2305n.onClick(this.f2315i.f2270b, i2);
        if (this.f2316j.f2308r) {
            return;
        }
        this.f2315i.f2270b.dismiss();
    }
}
