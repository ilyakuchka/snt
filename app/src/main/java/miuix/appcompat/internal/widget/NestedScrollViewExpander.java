package miuix.appcompat.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class NestedScrollViewExpander extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    private View f7075i;

    /* renamed from: j, reason: collision with root package name */
    private int f7076j;

    public NestedScrollViewExpander(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(View view) {
        this.f7075i = view;
    }

    final void b(int i2) {
        this.f7076j = i2;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i8 = (((((i5 - i2) - measuredWidth) / 2) + i2) + marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            int i9 = marginLayoutParams.topMargin + i4;
            childAt.layout(i8, i9, measuredWidth + i8, i9 + measuredHeight);
            i4 = i4 + marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        int mode = View.MeasureSpec.getMode(this.f7076j);
        if (mode == 0) {
            mode = Integer.MIN_VALUE;
        }
        int i5 = mode;
        int size = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        int measuredHeight = 0;
        int measuredHeight2 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && this.f7075i != childAt) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                measureChildWithMargins(childAt, i2, 0, i4, 0);
                measuredHeight2 += childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
        }
        int size2 = View.MeasureSpec.getSize(this.f7076j) - measuredHeight2;
        View view = this.f7075i;
        if (view != null && view.getVisibility() != 8) {
            if (size2 < this.f7075i.getMinimumHeight()) {
                size2 = this.f7075i.getMinimumHeight();
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f7075i.getLayoutParams();
            measureChildWithMargins(this.f7075i, i2, 0, View.MeasureSpec.makeMeasureSpec(size2, i5), 0);
            measuredHeight = this.f7075i.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
        }
        setMeasuredDimension(size, measuredHeight + measuredHeight2);
    }
}
