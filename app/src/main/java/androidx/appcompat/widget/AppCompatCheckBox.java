package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.android.mmt.R;
import i.C0333a;
import java.util.Objects;

/* loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox {

    /* renamed from: i, reason: collision with root package name */
    private final C0186g f2705i;

    /* renamed from: j, reason: collision with root package name */
    private final C0184e f2706j;

    /* renamed from: k, reason: collision with root package name */
    private final C0202x f2707k;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0184e c0184e = this.f2706j;
        if (c0184e != null) {
            c0184e.a();
        }
        C0202x c0202x = this.f2707k;
        if (c0202x != null) {
            c0202x.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public final int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0186g c0186g = this.f2705i;
        if (c0186g != null) {
            Objects.requireNonNull(c0186g);
        }
        return compoundPaddingLeft;
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0184e c0184e = this.f2706j;
        if (c0184e != null) {
            c0184e.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0184e c0184e = this.f2706j;
        if (c0184e != null) {
            c0184e.f(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0186g c0186g = this.f2705i;
        if (c0186g != null) {
            c0186g.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Q.a(context);
        O.a(this, getContext());
        C0186g c0186g = new C0186g(this);
        this.f2705i = c0186g;
        c0186g.b(attributeSet, i2);
        C0184e c0184e = new C0184e(this);
        this.f2706j = c0184e;
        c0184e.d(attributeSet, i2);
        C0202x c0202x = new C0202x(this);
        this.f2707k = c0202x;
        c0202x.f(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public final void setButtonDrawable(int i2) {
        setButtonDrawable(C0333a.a(getContext(), i2));
    }
}
