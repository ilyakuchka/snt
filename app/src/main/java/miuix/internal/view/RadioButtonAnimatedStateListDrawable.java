package miuix.internal.view;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.android.mmt.R;
import miuix.internal.view.a;

/* loaded from: classes.dex */
public class RadioButtonAnimatedStateListDrawable extends CheckBoxAnimatedStateListDrawable {

    /* renamed from: q, reason: collision with root package name */
    private int f7110q;

    protected static class a extends a.C0122a {
        protected a() {
        }

        @Override // miuix.internal.view.a.C0122a
        protected final Drawable a(Resources resources, Resources.Theme theme, a.C0122a c0122a) {
            return new RadioButtonAnimatedStateListDrawable(resources, theme, c0122a);
        }
    }

    public RadioButtonAnimatedStateListDrawable() {
        this.f7110q = 19;
    }

    @Override // miuix.internal.view.CheckBoxAnimatedStateListDrawable, miuix.internal.view.a
    protected final a.C0122a a() {
        return new a();
    }

    @Override // miuix.internal.view.CheckBoxAnimatedStateListDrawable
    protected final int b() {
        return R.style.CheckWidgetDrawable_RadioButton;
    }

    @Override // miuix.internal.view.CheckBoxAnimatedStateListDrawable
    protected final void g(int i2, int i4, int i5, int i6) {
        int i7 = this.f7110q;
        super.g(i2 + i7, i4 + i7, i5 - i7, i6 - i7);
    }

    @Override // miuix.internal.view.CheckBoxAnimatedStateListDrawable
    protected final void h(Rect rect) {
        int i2 = this.f7110q;
        rect.inset(i2, i2);
        super.h(rect);
    }

    public RadioButtonAnimatedStateListDrawable(Resources resources, Resources.Theme theme, a.C0122a c0122a) {
        super(resources, theme, c0122a);
        this.f7110q = 19;
        if (resources != null) {
            this.f7110q = resources.getDimensionPixelSize(R.dimen.miuix_appcompat_radio_button_drawable_padding);
        }
    }
}
