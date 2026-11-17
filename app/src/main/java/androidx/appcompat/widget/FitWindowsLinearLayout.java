package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    private E f2747i;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected final boolean fitSystemWindows(Rect rect) {
        E e2 = this.f2747i;
        if (e2 != null) {
            e2.a();
        }
        return super.fitSystemWindows(rect);
    }
}
