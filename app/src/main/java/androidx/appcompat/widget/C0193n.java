package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: androidx.appcompat.widget.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0193n extends PopupWindow {
    public C0193n(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, i4);
        U u = U.u(context, attributeSet, Y1.a.f2128w, i2, i4);
        if (u.r(2)) {
            setOverlapAnchor(u.a(2, false));
        }
        setBackgroundDrawable(u.f(0));
        u.v();
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i2, int i4) {
        super.showAsDropDown(view, i2, i4);
    }

    @Override // android.widget.PopupWindow
    public final void update(View view, int i2, int i4, int i5, int i6) {
        super.update(view, i2, i4, i5, i6);
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i2, int i4, int i5) {
        super.showAsDropDown(view, i2, i4, i5);
    }
}
