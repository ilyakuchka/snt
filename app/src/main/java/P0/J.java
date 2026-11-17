package P0;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class J implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ v f900i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ K f901j;

    J(K k2, v vVar) {
        this.f901j = k2;
        this.f900i = vVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        H0.a item = this.f900i.getItem(i2);
        if (item != null) {
            K.a(this.f901j, item.f256a);
        }
    }
}
