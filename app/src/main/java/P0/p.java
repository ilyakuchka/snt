package P0;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class p implements DialogInterface.OnCancelListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Runnable f930i;

    p(Runnable runnable) {
        this.f930i = runnable;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Runnable runnable = this.f930i;
        if (runnable != null) {
            runnable.run();
        }
        dialogInterface.dismiss();
    }
}
