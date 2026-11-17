package miuix.appcompat.widget;

import android.content.DialogInterface;
import java.util.Objects;
import miuix.appcompat.widget.Spinner;

/* loaded from: classes.dex */
final class a implements DialogInterface.OnDismissListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Spinner.b f7102i;

    a(Spinner.b bVar) {
        this.f7102i = bVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Spinner spinner = Spinner.this;
        int i2 = Spinner.f7078t;
        Objects.requireNonNull(spinner);
    }
}
