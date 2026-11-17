package com.android.mmt.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import t.C0384b;

/* loaded from: classes.dex */
public class RowLayout extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    private int f5327i;

    /* renamed from: j, reason: collision with root package name */
    private int f5328j;

    /* renamed from: k, reason: collision with root package name */
    protected ArrayList<b> f5329k;

    public static class a extends ViewGroup.MarginLayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a() {
            super(-2, -2);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f5330a;

        /* renamed from: b, reason: collision with root package name */
        int f5331b;

        /* renamed from: c, reason: collision with root package name */
        int f5332c;
    }

    public RowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5327i = 0;
        this.f5328j = 0;
        this.f5329k = new ArrayList<>();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, Y1.a.L);
        this.f5327i = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        requestLayout();
        this.f5328j = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        requestLayout();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        boolean z5 = getLayoutDirection() == 1;
        int paddingTop = getPaddingTop() + i4;
        int i7 = 0;
        int i8 = 0;
        while (i8 < this.f5329k.size()) {
            int paddingLeft = getPaddingLeft() + i2;
            int i9 = i7;
            for (int i10 = 0; i10 < this.f5329k.get(i8).f5332c; i10++) {
                View childAt = getChildAt(i9);
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                C0384b.l(childAt, paddingLeft, paddingTop, measuredWidth, childAt.getMeasuredHeight() + paddingTop, z5, i5);
                paddingLeft = measuredWidth + this.f5328j;
                i9++;
            }
            paddingTop += this.f5329k.get(i8).f5330a + this.f5327i;
            i8++;
            i7 = i9;
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        int childCount = getChildCount();
        this.f5329k.clear();
        b bVar = new b();
        int i5 = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            measureChildWithMargins(childAt, i2, 0, i4, i5);
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            int i7 = bVar.f5331b + measuredWidth;
            if (bVar.f5332c > 0) {
                i7 += this.f5328j;
            }
            if (mode != 0 && i7 > size) {
                if (mode2 != 0 && i5 >= size2) {
                    break;
                }
                if (this.f5329k.size() > 0) {
                    i5 += this.f5327i;
                }
                i5 += bVar.f5330a;
                this.f5329k.add(bVar);
                bVar = new b();
            }
            int i8 = bVar.f5332c;
            if (i8 > 0) {
                bVar.f5331b += this.f5328j;
            }
            int i9 = bVar.f5331b + measuredWidth;
            bVar.f5331b = i9;
            bVar.f5332c = i8 + 1;
            iMax = Math.max(iMax, i9);
            bVar.f5330a = Math.max(bVar.f5330a, measuredHeight);
        }
        if (bVar.f5332c > 0) {
            if (this.f5329k.size() > 0) {
                i5 += this.f5327i;
            }
            i5 += bVar.f5330a;
            this.f5329k.add(bVar);
        }
        setMeasuredDimension(View.resolveSize(getPaddingRight() + getPaddingLeft() + iMax, i2), View.resolveSize(getPaddingBottom() + getPaddingTop() + i5, i4));
    }
}
