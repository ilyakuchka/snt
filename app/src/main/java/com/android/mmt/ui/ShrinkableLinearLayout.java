package com.android.mmt.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ShrinkableLinearLayout extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    private int f5427i;

    public ShrinkableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5427i = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.M);
        this.f5427i = typedArrayObtainStyledAttributes.getInt(0, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        if (getOrientation() == 1) {
            if (this.f5427i != -1 && getOrientation() != 0 && View.MeasureSpec.getMode(i4) != 0) {
                View childAt = getChildAt(this.f5427i);
                childAt.getLayoutParams().height = -2;
                super.onMeasure(i2, 0);
                int measuredHeight = childAt.getMeasuredHeight();
                int measuredHeight2 = getMeasuredHeight();
                int size = View.MeasureSpec.getSize(i4);
                if (size < measuredHeight2) {
                    int i5 = measuredHeight - (measuredHeight2 - size);
                    childAt.getLayoutParams().height = i5 >= 0 ? i5 : 0;
                }
            }
            super.onMeasure(i2, i4);
            return;
        }
        if (this.f5427i != -1 && getOrientation() != 1 && View.MeasureSpec.getMode(i2) != 0) {
            View childAt2 = getChildAt(this.f5427i);
            childAt2.getLayoutParams().width = -2;
            super.onMeasure(0, i4);
            int measuredWidth = childAt2.getMeasuredWidth();
            int measuredWidth2 = getMeasuredWidth();
            int size2 = View.MeasureSpec.getSize(i2);
            if (size2 < measuredWidth2) {
                int i6 = measuredWidth - (measuredWidth2 - size2);
                childAt2.getLayoutParams().width = i6 >= 0 ? i6 : 0;
            }
        }
        super.onMeasure(i2, i4);
    }
}
