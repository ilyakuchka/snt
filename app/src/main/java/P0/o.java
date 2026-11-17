package P0;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class o implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Runnable f929i;

    o(Runnable runnable) {
        this.f929i = runnable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Runnable runnable = this.f929i;
        if (runnable != null) {
            runnable.run();
        }
        dialogInterface.dismiss();
    }
}
