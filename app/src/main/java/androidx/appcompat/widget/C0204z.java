package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* renamed from: androidx.appcompat.widget.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0204z extends ToggleButton {

    /* renamed from: i, reason: collision with root package name */
    private final C0184e f3101i;

    /* renamed from: j, reason: collision with root package name */
    private final C0202x f3102j;

    public C0204z(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        O.a(this, getContext());
        C0184e c0184e = new C0184e(this);
        this.f3101i = c0184e;
        c0184e.d(attributeSet, R.attr.buttonStyleToggle);
        C0202x c0202x = new C0202x(this);
        this.f3102j = c0202x;
        c0202x.f(attributeSet, R.attr.buttonStyleToggle);
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        C0184e c0184e = this.f3101i;
        if (c0184e != null) {
            c0184e.a();
        }
        C0202x c0202x = this.f3102j;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.ToggleButton, android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0184e c0184e = this.f3101i;
        if (c0184e != null) {
            c0184e.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0184e c0184e = this.f3101i;
        if (c0184e != null) {
            c0184e.f(i2);
        }
    }
}
