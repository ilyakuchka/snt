package com.android.mmt.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.android.mmt.ui.C0230a;
import t.C0384b;

/* loaded from: classes.dex */
public final class L0 extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    private boolean f4889i;

    /* renamed from: j, reason: collision with root package name */
    private int f4890j;

    /* renamed from: k, reason: collision with root package name */
    private int f4891k;

    /* renamed from: l, reason: collision with root package name */
    private int f4892l;

    /* renamed from: m, reason: collision with root package name */
    private int f4893m;

    /* renamed from: n, reason: collision with root package name */
    private int f4894n;

    /* renamed from: o, reason: collision with root package name */
    private int f4895o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private int f4896q;

    /* renamed from: r, reason: collision with root package name */
    private int f4897r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f4898s;

    /* renamed from: t, reason: collision with root package name */
    private a f4899t;
    private int u;

    public interface a {
    }

    public L0(Context context, int i2, int i4, int i5, int i6, int i7) {
        super(context);
        this.f4891k = Math.max(1, i2);
        this.f4892l = Math.max(1, i4);
        this.f4893m = Math.max(1, i6);
        int iMax = Math.max(1, i5);
        int i8 = this.f4892l;
        this.f4894n = ((iMax * i8) - (i7 * 2)) / i8;
        this.u = i7;
        setDrawingCacheEnabled(true);
        setWillNotDraw(false);
    }

    protected final void a() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            int i4 = this.f4892l;
            int i5 = i2 / i4;
            int i6 = i2 % i4;
            int i7 = this.f4893m;
            int i8 = this.f4890j;
            int paddingTop = getPaddingTop() + ((i7 + i8) * i5) + i8;
            View childAt = getChildAt(i2);
            int i9 = this.f4894n;
            int i10 = this.u;
            C0384b.l(childAt, (i9 * i6) + i10, paddingTop, ((i6 + 1) * i9) + i10, paddingTop + this.f4893m, getLayoutDirection() == 1, getWidth());
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    final int b(int i2, int i4) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i4, View.MeasureSpec.getSize(i2));
        }
        if (mode == 0) {
            return i4;
        }
        if (mode != 1073741824) {
            return 0;
        }
        return View.MeasureSpec.getSize(i2);
    }

    public final void c(a aVar) {
        this.f4899t = aVar;
    }

    public final void d() {
        this.f4889i = true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        a aVar;
        if (this.f4898s || (aVar = this.f4899t) == null) {
            return;
        }
        this.f4898s = true;
        ((C0230a.i) aVar).a(this);
        measureChildren(View.MeasureSpec.makeMeasureSpec(this.f4894n, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f4893m, 1073741824));
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        if (this.f4898s || this.f4899t == null) {
            if (this.f4889i) {
                this.f4890j = (((getMeasuredHeight() - (this.f4893m * this.f4891k)) - getPaddingTop()) - getPaddingBottom()) / (this.f4891k + 1);
            }
            a();
        } else {
            this.f4895o = i2;
            this.p = i4;
            this.f4896q = i5;
            this.f4897r = i6;
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i4) {
        setMeasuredDimension(b(i2, this.f4894n * this.f4892l), b(i4, this.f4893m * this.f4891k));
        measureChildren(View.MeasureSpec.makeMeasureSpec(this.f4894n, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f4893m, 1073741824));
    }
}
