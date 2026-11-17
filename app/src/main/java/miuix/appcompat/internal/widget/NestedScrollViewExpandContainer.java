package miuix.appcompat.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
public class NestedScrollViewExpandContainer extends NestedScrollView {
    public NestedScrollViewExpandContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    protected final void measureChild(View view, int i2, int i4) {
        ((NestedScrollViewExpander) view).b(i4);
        view.forceLayout();
        super.measureChild(view, i2, i4);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    protected final void measureChildWithMargins(View view, int i2, int i4, int i5, int i6) {
        ((NestedScrollViewExpander) view).b(i5);
        view.forceLayout();
        super.measureChildWithMargins(view, i2, i4, i5, i6);
    }
}
