package miuix.pickerwidget.widget;

import java.util.Objects;
import miuix.pickerwidget.widget.NumberPicker;

/* loaded from: classes.dex */
final class c implements NumberPicker.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimePicker f7290a;

    c(TimePicker timePicker) {
        this.f7290a = timePicker;
    }

    @Override // miuix.pickerwidget.widget.NumberPicker.f
    public final void a(NumberPicker numberPicker, int i2, int i4) {
        Objects.requireNonNull(this.f7290a);
        if ((i2 == 11 && i4 == 12) || (i2 == 12 && i4 == 11)) {
            this.f7290a.f7278i = !r2.f7278i;
            this.f7290a.k();
        }
        this.f7290a.g();
    }
}
