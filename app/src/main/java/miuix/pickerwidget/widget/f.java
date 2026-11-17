package miuix.pickerwidget.widget;

import miuix.pickerwidget.widget.NumberPicker;

/* loaded from: classes.dex */
final class f implements NumberPicker.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimePicker f7293a;

    f(TimePicker timePicker) {
        this.f7293a = timePicker;
    }

    @Override // miuix.pickerwidget.widget.NumberPicker.f
    public final void a(NumberPicker numberPicker, int i2, int i4) {
        numberPicker.requestFocus();
        this.f7293a.f7278i = !r1.f7278i;
        this.f7293a.k();
        this.f7293a.g();
    }
}
