package miuix.pickerwidget.widget;

import android.view.View;

/* loaded from: classes.dex */
final class e implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ TimePicker f7292i;

    e(TimePicker timePicker) {
        this.f7292i = timePicker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        view.requestFocus();
        this.f7292i.f7278i = !r2.f7278i;
        this.f7292i.k();
        this.f7292i.g();
    }
}
