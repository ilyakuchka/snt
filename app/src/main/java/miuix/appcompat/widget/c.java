package miuix.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import java.util.Objects;
import miuix.appcompat.widget.Spinner;
import miuix.view.HapticCompat;

/* loaded from: classes.dex */
final class c implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Spinner.f f7103i;

    c(Spinner.f fVar) {
        this.f7103i = fVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Spinner.this.setSelection(i2);
        Spinner spinner = Spinner.this;
        int i4 = Spinner.f7078t;
        Objects.requireNonNull(spinner);
        HapticCompat.performHapticFeedback(spinner, miuix.view.c.f7458h);
        if (Spinner.this.getOnItemClickListener() != null) {
            Spinner.f fVar = this.f7103i;
            Spinner.this.performItemClick(view, i2, fVar.f7096j.getItemId(i2));
        }
        this.f7103i.dismiss();
    }
}
