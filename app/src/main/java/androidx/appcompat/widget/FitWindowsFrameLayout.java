package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private E f2746i;

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected final boolean fitSystemWindows(Rect rect) {
        E e2 = this.f2746i;
        if (e2 != null) {
            e2.a();
        }
        return super.fitSystemWindows(rect);
    }
}
