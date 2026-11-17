package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.C0199u;

/* renamed from: androidx.appcompat.widget.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0200v implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0199u.d f3071i;

    C0200v(C0199u.d dVar) {
        this.f3071i = dVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        C0199u.this.setSelection(i2);
        if (C0199u.this.getOnItemClickListener() != null) {
            C0199u.d dVar = this.f3071i;
            C0199u.this.performItemClick(view, i2, dVar.f3064I.getItemId(i2));
        }
        this.f3071i.dismiss();
    }
}
