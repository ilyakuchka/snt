package miuix.pickerwidget.widget;

import android.view.View;

/* loaded from: classes.dex */
final class b implements View.OnFocusChangeListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ NumberPicker f7289i;

    b(NumberPicker numberPicker) {
        this.f7289i = numberPicker;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z4) {
        if (z4) {
            this.f7289i.f7239m.selectAll();
        } else {
            this.f7289i.f7239m.setSelection(0, 0);
            NumberPicker.o(this.f7289i, view);
        }
    }
}
