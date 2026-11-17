package miuix.pickerwidget.widget;

import android.view.MotionEvent;
import android.view.View;
import java.util.Objects;
import miuix.pickerwidget.widget.NumberPicker;

/* loaded from: classes.dex */
final class a implements View.OnTouchListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ NumberPicker f7288i;

    a(NumberPicker numberPicker) {
        this.f7288i = numberPicker;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            return false;
        }
        NumberPicker numberPicker = this.f7288i;
        NumberPicker.c cVar = NumberPicker.f7198E0;
        Objects.requireNonNull(numberPicker);
        return false;
    }
}
