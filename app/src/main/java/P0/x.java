package P0;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class x implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ z f963i;

    x(z zVar) {
        this.f963i = zVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f963i.b();
    }
}
