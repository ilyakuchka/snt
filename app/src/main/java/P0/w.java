package P0;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class w implements DialogInterface.OnCancelListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ z f962i;

    w(z zVar) {
        this.f962i = zVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f962i.b();
    }
}
