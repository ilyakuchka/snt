package miuix.appcompat.widget;

import android.widget.PopupWindow;
import java.util.Objects;
import miuix.appcompat.widget.Spinner;

/* loaded from: classes.dex */
final class d implements PopupWindow.OnDismissListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Spinner.f f7104i;

    d(Spinner.f fVar) {
        this.f7104i = fVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        Spinner spinner = Spinner.this;
        int i2 = Spinner.f7078t;
        Objects.requireNonNull(spinner);
    }
}
