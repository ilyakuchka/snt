package com.android.mmt.audio;

import Y1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class RecordingProgressView extends View {

    /* renamed from: i, reason: collision with root package name */
    private int f4487i;

    /* renamed from: j, reason: collision with root package name */
    private int f4488j;

    /* renamed from: k, reason: collision with root package name */
    private int f4489k;

    /* renamed from: l, reason: collision with root package name */
    private int f4490l;

    /* renamed from: m, reason: collision with root package name */
    private LinkedList<Integer> f4491m;

    /* renamed from: n, reason: collision with root package name */
    private int f4492n;

    /* renamed from: o, reason: collision with root package name */
    private int f4493o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    Paint f4494q;

    public RecordingProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4491m = new LinkedList<>();
        this.f4494q = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f2092J);
        this.f4487i = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 25);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 4);
        this.f4488j = dimensionPixelSize;
        this.f4489k = dimensionPixelSize / 2;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 80);
        this.f4490l = typedArrayObtainStyledAttributes.getInt(3, 22);
        this.f4493o = typedArrayObtainStyledAttributes.getColor(0, -7829368);
        this.p = typedArrayObtainStyledAttributes.getColor(1, -16776961);
        typedArrayObtainStyledAttributes.recycle();
        this.f4494q.setAntiAlias(true);
        this.f4494q.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4494q.setColor(this.f4493o);
        int i2 = 0;
        this.f4492n = 0;
        int height = (getHeight() / 2) - this.f4489k;
        for (int i4 = 0; i4 < this.f4490l - this.f4491m.size(); i4++) {
            int i5 = this.f4492n;
            canvas.drawCircle(i5 + r4, height + r4, this.f4489k, this.f4494q);
            this.f4492n = this.f4487i + this.f4488j + this.f4492n;
        }
        this.f4494q.setColor(isEnabled() ? this.p : this.f4493o);
        Iterator<Integer> it = this.f4491m.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (this.f4491m.size() - i2 > this.f4490l) {
                i2++;
            } else {
                int iIntValue = next.intValue();
                int height2 = (getHeight() - iIntValue) / 2;
                int i6 = this.f4492n;
                float f4 = height2;
                canvas.drawCircle(i6 + r5, f4, this.f4489k, this.f4494q);
                float f5 = height2 + iIntValue;
                canvas.drawRect(this.f4492n, f4, r4 + this.f4488j, f5, this.f4494q);
                int i7 = this.f4492n;
                canvas.drawCircle(i7 + r4, f5, this.f4489k, this.f4494q);
                this.f4492n = this.f4487i + this.f4488j + this.f4492n;
            }
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        setMeasuredDimension((this.f4487i + this.f4488j) * this.f4490l, View.getDefaultSize(getSuggestedMinimumHeight(), i4));
    }
}
