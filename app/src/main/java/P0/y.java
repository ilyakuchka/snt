package P0;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class y implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ v f964i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ z f965j;

    y(z zVar, v vVar) {
        this.f965j = zVar;
        this.f964i = vVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        H0.a item = this.f964i.getItem(i2);
        if (item != null) {
            z.a(this.f965j, item.f256a);
        }
    }
}
