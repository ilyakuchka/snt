package P0;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class I implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ K f899i;

    I(K k2) {
        this.f899i = k2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f899i.b();
    }
}
