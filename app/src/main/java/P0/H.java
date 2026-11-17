package P0;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class H implements DialogInterface.OnCancelListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ K f898i;

    H(K k2) {
        this.f898i = k2;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f898i.b();
    }
}
