package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class G extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    private boolean f2748i;

    /* renamed from: j, reason: collision with root package name */
    private int f2749j;

    /* renamed from: k, reason: collision with root package name */
    private int f2750k;

    /* renamed from: l, reason: collision with root package name */
    private int f2751l;

    /* renamed from: m, reason: collision with root package name */
    private int f2752m;

    /* renamed from: n, reason: collision with root package name */
    private int f2753n;

    /* renamed from: o, reason: collision with root package name */
    private float f2754o;
    private boolean p;

    /* renamed from: q, reason: collision with root package name */
    private int[] f2755q;

    /* renamed from: r, reason: collision with root package name */
    private int[] f2756r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f2757s;

    /* renamed from: t, reason: collision with root package name */
    private int f2758t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    private int f2759v;

    /* renamed from: w, reason: collision with root package name */
    private int f2760w;

    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i2) {
            super(i2, -2);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public G(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    final void e(Canvas canvas, int i2) {
        this.f2757s.setBounds(getPaddingLeft() + this.f2760w, i2, (getWidth() - getPaddingRight()) - this.f2760w, this.u + i2);
        this.f2757s.draw(canvas);
    }

    final void f(Canvas canvas, int i2) {
        this.f2757s.setBounds(i2, getPaddingTop() + this.f2760w, this.f2758t + i2, (getHeight() - getPaddingBottom()) - this.f2760w);
        this.f2757s.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i2 = this.f2751l;
        if (i2 == 0) {
            return new a(-2);
        }
        if (i2 == 1) {
            return new a(-1);
        }
        return null;
    }

    @Override // android.view.View
    public final int getBaseline() {
        int i2;
        if (this.f2749j < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i4 = this.f2749j;
        if (childCount <= i4) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i4);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f2749j == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f2750k;
        if (this.f2751l == 1 && (i2 = this.f2752m & 112) != 48) {
            if (i2 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2753n) / 2;
            } else if (i2 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2753n;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public final Drawable j() {
        return this.f2757s;
    }

    public final int k() {
        return this.f2758t;
    }

    public final int l() {
        return this.f2752m;
    }

    protected final boolean m(int i2) {
        if (i2 == 0) {
            return (this.f2759v & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.f2759v & 4) != 0;
        }
        if ((this.f2759v & 2) == 0) {
            return false;
        }
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            if (getChildAt(i4).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public final void n() {
        this.f2748i = false;
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i2;
        if (this.f2757s == null) {
            return;
        }
        int i4 = 0;
        if (this.f2751l == 1) {
            int childCount = getChildCount();
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (childAt != null && childAt.getVisibility() != 8 && m(i4)) {
                    e(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin) - this.u);
                }
                i4++;
            }
            if (m(childCount)) {
                View childAt2 = getChildAt(childCount - 1);
                e(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.u : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((a) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int childCount2 = getChildCount();
        boolean zB = Y.b(this);
        while (i4 < childCount2) {
            View childAt3 = getChildAt(i4);
            if (childAt3 != null && childAt3.getVisibility() != 8 && m(i4)) {
                a aVar = (a) childAt3.getLayoutParams();
                f(canvas, zB ? childAt3.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f2758t);
            }
            i4++;
        }
        if (m(childCount2)) {
            View childAt4 = getChildAt(childCount2 - 1);
            if (childAt4 != null) {
                a aVar2 = (a) childAt4.getLayoutParams();
                if (zB) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i2 = this.f2758t;
                    right = left - i2;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i2 = this.f2758t;
                right = left - i2;
            }
            f(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a3  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int measuredHeight;
        int i14;
        int i15;
        int i16;
        int i17 = 8;
        int i18 = 5;
        if (this.f2751l == 1) {
            int paddingLeft = getPaddingLeft();
            int i19 = i5 - i2;
            int paddingRight = i19 - getPaddingRight();
            int paddingRight2 = (i19 - paddingLeft) - getPaddingRight();
            int childCount = getChildCount();
            int i20 = this.f2752m;
            int i21 = i20 & 112;
            int i22 = 8388615 & i20;
            int paddingTop = i21 != 16 ? i21 != 80 ? getPaddingTop() : ((getPaddingTop() + i6) - i4) - this.f2753n : getPaddingTop() + (((i6 - i4) - this.f2753n) / 2);
            int i23 = 0;
            while (i23 < childCount) {
                View childAt = getChildAt(i23);
                if (childAt == null) {
                    paddingTop += 0;
                } else if (childAt.getVisibility() != i17) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    a aVar = (a) childAt.getLayoutParams();
                    int i24 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i24 < 0) {
                        i24 = i22;
                    }
                    int i25 = androidx.core.view.o.d;
                    int absoluteGravity = Gravity.getAbsoluteGravity(i24, getLayoutDirection()) & 7;
                    if (absoluteGravity == 1) {
                        i14 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                        i15 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    } else if (absoluteGravity != i18) {
                        i16 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        if (m(i23)) {
                            paddingTop += this.u;
                        }
                        int i26 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                        int i27 = i26 + 0;
                        childAt.layout(i16, i27, measuredWidth + i16, measuredHeight2 + i27);
                        i23 += 0;
                        paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + 0 + i26;
                    } else {
                        i14 = paddingRight - measuredWidth;
                        i15 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                    i16 = i14 - i15;
                    if (m(i23)) {
                    }
                    int i262 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    int i272 = i262 + 0;
                    childAt.layout(i16, i272, measuredWidth + i16, measuredHeight2 + i272);
                    i23 += 0;
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + 0 + i262;
                }
                i23++;
                i17 = 8;
                i18 = 5;
            }
            return;
        }
        boolean zB = Y.b(this);
        int paddingTop2 = getPaddingTop();
        int i28 = i6 - i4;
        int paddingBottom = i28 - getPaddingBottom();
        int paddingBottom2 = (i28 - paddingTop2) - getPaddingBottom();
        int childCount2 = getChildCount();
        int i29 = this.f2752m;
        int i30 = 8388615 & i29;
        int i31 = i29 & 112;
        boolean z5 = this.f2748i;
        int[] iArr = this.f2755q;
        int[] iArr2 = this.f2756r;
        int i32 = androidx.core.view.o.d;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i30, getLayoutDirection());
        int paddingLeft2 = absoluteGravity2 != 1 ? absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i5) - i2) - this.f2753n : getPaddingLeft() + (((i5 - i2) - this.f2753n) / 2);
        if (zB) {
            i8 = childCount2 - 1;
            i7 = -1;
        } else {
            i7 = 1;
            i8 = 0;
        }
        int i33 = paddingLeft2;
        int i34 = 0;
        while (i34 < childCount2) {
            int i35 = (i7 * i34) + i8;
            View childAt2 = getChildAt(i35);
            if (childAt2 == null) {
                i33 += 0;
            } else {
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight3 = childAt2.getMeasuredHeight();
                    a aVar2 = (a) childAt2.getLayoutParams();
                    if (z5) {
                        i9 = i8;
                        i10 = childCount2;
                        int baseline = ((LinearLayout.LayoutParams) aVar2).height != -1 ? childAt2.getBaseline() : -1;
                        i11 = ((LinearLayout.LayoutParams) aVar2).gravity;
                        if (i11 < 0) {
                            i11 = i31;
                        }
                        i12 = i11 & 112;
                        i13 = i31;
                        if (i12 != 16) {
                            measuredHeight = ((((paddingBottom2 - measuredHeight3) / 2) + paddingTop2) + ((LinearLayout.LayoutParams) aVar2).topMargin) - ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                        } else if (i12 == 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) aVar2).topMargin + paddingTop2;
                            if (baseline != -1) {
                                measuredHeight = (iArr[1] - baseline) + measuredHeight;
                            }
                        } else if (i12 != 80) {
                            measuredHeight = paddingTop2;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                            }
                        }
                        if (m(i35)) {
                            i33 += this.f2758t;
                        }
                        int i36 = i33 + ((LinearLayout.LayoutParams) aVar2).leftMargin;
                        int i37 = i36 + 0;
                        childAt2.layout(i37, measuredHeight, measuredWidth2 + i37, measuredHeight3 + measuredHeight);
                        i34 += 0;
                        i33 = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + 0 + i36;
                    } else {
                        i9 = i8;
                        i10 = childCount2;
                    }
                    i11 = ((LinearLayout.LayoutParams) aVar2).gravity;
                    if (i11 < 0) {
                    }
                    i12 = i11 & 112;
                    i13 = i31;
                    if (i12 != 16) {
                    }
                    if (m(i35)) {
                    }
                    int i362 = i33 + ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    int i372 = i362 + 0;
                    childAt2.layout(i372, measuredHeight, measuredWidth2 + i372, measuredHeight3 + measuredHeight);
                    i34 += 0;
                    i33 = measuredWidth2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + 0 + i362;
                }
                i34++;
                i8 = i9;
                childCount2 = i10;
                i31 = i13;
            }
            i9 = i8;
            i10 = childCount2;
            i13 = i31;
            i34++;
            i8 = i9;
            childCount2 = i10;
            i31 = i13;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x06e7  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0877  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x087c  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:448:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i2, int i4) {
        char c2;
        int i5;
        int i6;
        float f4;
        int iCombineMeasuredStates;
        int i7;
        int i8;
        int i9;
        char c4;
        int i10;
        int i11;
        int i12;
        int i13;
        float f5;
        int i14;
        int baseline;
        int i15;
        int i16;
        int i17;
        int i18;
        float f6;
        int i19;
        int i20;
        int iMax;
        int i21;
        int i22;
        boolean z4;
        boolean z5;
        a aVar;
        boolean z6;
        int i23;
        boolean z7;
        int i24;
        int i25;
        int baseline2;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z8;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        a aVar2;
        boolean z9;
        boolean z10;
        int i37;
        boolean z11;
        int iMax2;
        int i38 = -2;
        int i39 = Integer.MIN_VALUE;
        int i40 = 8;
        float f7 = 0.0f;
        int i41 = 1073741824;
        boolean z12 = true;
        int i42 = 0;
        if (this.f2751l == 1) {
            this.f2753n = 0;
            int childCount = getChildCount();
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i4);
            int i43 = this.f2749j;
            boolean z13 = this.p;
            int i44 = 0;
            int i45 = 0;
            int iMax3 = 0;
            int iMax4 = 0;
            int iMax5 = 0;
            boolean z14 = false;
            boolean z15 = false;
            int i46 = 0;
            boolean z16 = true;
            float f8 = 0.0f;
            while (i44 < childCount) {
                View childAt = getChildAt(i44);
                if (childAt == null) {
                    this.f2753n += i42;
                } else if (childAt.getVisibility() == i40) {
                    i44 += 0;
                } else {
                    if (m(i44)) {
                        this.f2753n += this.u;
                    }
                    a aVar3 = (a) childAt.getLayoutParams();
                    float f9 = ((LinearLayout.LayoutParams) aVar3).weight;
                    f8 += f9;
                    if (mode2 == i41 && ((LinearLayout.LayoutParams) aVar3).height == 0 && f9 > f7) {
                        int i47 = this.f2753n;
                        this.f2753n = Math.max(i47, ((LinearLayout.LayoutParams) aVar3).topMargin + i47 + ((LinearLayout.LayoutParams) aVar3).bottomMargin);
                        i32 = i43;
                        i34 = mode2;
                        i35 = mode;
                        i36 = childCount;
                        aVar2 = aVar3;
                        z10 = true;
                        z9 = true;
                    } else {
                        if (((LinearLayout.LayoutParams) aVar3).height != 0 || f9 <= f7) {
                            i31 = i39;
                        } else {
                            ((LinearLayout.LayoutParams) aVar3).height = i38;
                            i31 = 0;
                        }
                        if (f8 == f7) {
                            i33 = this.f2753n;
                            i32 = i43;
                        } else {
                            i32 = i43;
                            i33 = 0;
                        }
                        i34 = mode2;
                        i35 = mode;
                        i36 = childCount;
                        aVar2 = aVar3;
                        z9 = true;
                        measureChildWithMargins(childAt, i2, 0, i4, i33);
                        if (i31 != i39) {
                            ((LinearLayout.LayoutParams) aVar2).height = i31;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i48 = this.f2753n;
                        this.f2753n = Math.max(i48, i48 + measuredHeight + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + 0);
                        if (z13) {
                            iMax3 = Math.max(measuredHeight, iMax3);
                        }
                        z10 = z14;
                    }
                    if (i32 >= 0 && i32 == i44 + 1) {
                        this.f2750k = this.f2753n;
                    }
                    if (i44 < i32 && ((LinearLayout.LayoutParams) aVar2).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    i37 = i35;
                    if (i37 == 1073741824 || ((LinearLayout.LayoutParams) aVar2).width != -1) {
                        z11 = false;
                    } else {
                        z11 = z9;
                        z15 = z11;
                    }
                    int i49 = ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                    int measuredWidth = childAt.getMeasuredWidth() + i49;
                    iMax2 = Math.max(i45, measuredWidth);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i46, childAt.getMeasuredState());
                    boolean z17 = (z16 && ((LinearLayout.LayoutParams) aVar2).width == -1) ? z9 : false;
                    if (((LinearLayout.LayoutParams) aVar2).weight > 0.0f) {
                        if (!z11) {
                            i49 = measuredWidth;
                        }
                        iMax5 = Math.max(iMax5, i49);
                    } else {
                        int i50 = iMax5;
                        if (!z11) {
                            i49 = measuredWidth;
                        }
                        iMax4 = Math.max(iMax4, i49);
                        iMax5 = i50;
                    }
                    i44 += 0;
                    z14 = z10;
                    z16 = z17;
                    i46 = iCombineMeasuredStates2;
                    i44++;
                    mode = i37;
                    i45 = iMax2;
                    i43 = i32;
                    z12 = z9;
                    mode2 = i34;
                    childCount = i36;
                    i42 = 0;
                    i38 = -2;
                    i39 = Integer.MIN_VALUE;
                    i40 = 8;
                    f7 = 0.0f;
                    i41 = 1073741824;
                }
                i32 = i43;
                i34 = mode2;
                i37 = mode;
                i36 = childCount;
                iMax2 = i45;
                z9 = true;
                i44++;
                mode = i37;
                i45 = iMax2;
                i43 = i32;
                z12 = z9;
                mode2 = i34;
                childCount = i36;
                i42 = 0;
                i38 = -2;
                i39 = Integer.MIN_VALUE;
                i40 = 8;
                f7 = 0.0f;
                i41 = 1073741824;
            }
            int i51 = mode2;
            int i52 = mode;
            int i53 = childCount;
            boolean z18 = z12;
            int iMax6 = i45;
            int i54 = iMax3;
            int iMax7 = iMax4;
            int i55 = iMax5;
            int iCombineMeasuredStates3 = i46;
            if (this.f2753n > 0 && m(i53)) {
                this.f2753n += this.u;
            }
            int i56 = i51;
            if (z13 && (i56 == Integer.MIN_VALUE || i56 == 0)) {
                int i57 = 0;
                this.f2753n = 0;
                int i58 = 0;
                while (i58 < i53) {
                    View childAt2 = getChildAt(i58);
                    if (childAt2 == null) {
                        this.f2753n += i57;
                    } else if (childAt2.getVisibility() == 8) {
                        i58 += 0;
                    } else {
                        a aVar4 = (a) childAt2.getLayoutParams();
                        int i59 = this.f2753n;
                        this.f2753n = Math.max(i59, i59 + i54 + ((LinearLayout.LayoutParams) aVar4).topMargin + ((LinearLayout.LayoutParams) aVar4).bottomMargin + 0);
                    }
                    i58++;
                    i57 = 0;
                }
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop() + this.f2753n;
            this.f2753n = paddingBottom;
            int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i4, 0);
            int i60 = (16777215 & iResolveSizeAndState) - this.f2753n;
            if (z14 || (i60 != 0 && f8 > 0.0f)) {
                float f10 = this.f2754o;
                if (f10 > 0.0f) {
                    f8 = f10;
                }
                this.f2753n = 0;
                int i61 = 0;
                while (i61 < i53) {
                    View childAt3 = getChildAt(i61);
                    if (childAt3.getVisibility() == 8) {
                        i27 = i56;
                    } else {
                        a aVar5 = (a) childAt3.getLayoutParams();
                        float f11 = ((LinearLayout.LayoutParams) aVar5).weight;
                        if (f11 > 0.0f) {
                            int i62 = (int) ((i60 * f11) / f8);
                            f8 -= f11;
                            int i63 = i60 - i62;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) aVar5).leftMargin + ((LinearLayout.LayoutParams) aVar5).rightMargin, ((LinearLayout.LayoutParams) aVar5).width);
                            if (((LinearLayout.LayoutParams) aVar5).height == 0) {
                                i30 = 1073741824;
                                if (i56 == 1073741824) {
                                    if (i62 <= 0) {
                                        i62 = 0;
                                    }
                                    childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i62, 1073741824));
                                }
                                iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, childAt3.getMeasuredState() & (-256));
                                i60 = i63;
                            } else {
                                i30 = 1073741824;
                            }
                            int measuredHeight2 = childAt3.getMeasuredHeight() + i62;
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i30));
                            iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, childAt3.getMeasuredState() & (-256));
                            i60 = i63;
                        }
                        int i64 = ((LinearLayout.LayoutParams) aVar5).leftMargin + ((LinearLayout.LayoutParams) aVar5).rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i64;
                        iMax6 = Math.max(iMax6, measuredWidth2);
                        i27 = i56;
                        if (i52 != 1073741824) {
                            i28 = i60;
                            i29 = -1;
                            z8 = ((LinearLayout.LayoutParams) aVar5).width == -1 ? z18 : false;
                            if (!z8) {
                                i64 = measuredWidth2;
                            }
                            iMax7 = Math.max(iMax7, i64);
                            boolean z19 = (z16 || ((LinearLayout.LayoutParams) aVar5).width != i29) ? false : z18;
                            int i65 = this.f2753n;
                            this.f2753n = Math.max(i65, childAt3.getMeasuredHeight() + i65 + ((LinearLayout.LayoutParams) aVar5).topMargin + ((LinearLayout.LayoutParams) aVar5).bottomMargin + 0);
                            z16 = z19;
                            i60 = i28;
                        } else {
                            i28 = i60;
                            i29 = -1;
                        }
                        if (!z8) {
                        }
                        iMax7 = Math.max(iMax7, i64);
                        if (z16) {
                            int i652 = this.f2753n;
                            this.f2753n = Math.max(i652, childAt3.getMeasuredHeight() + i652 + ((LinearLayout.LayoutParams) aVar5).topMargin + ((LinearLayout.LayoutParams) aVar5).bottomMargin + 0);
                            z16 = z19;
                            i60 = i28;
                        }
                    }
                    i61++;
                    i56 = i27;
                }
                this.f2753n = getPaddingBottom() + getPaddingTop() + this.f2753n;
            } else {
                iMax7 = Math.max(iMax7, i55);
                if (z13 && i56 != 1073741824) {
                    for (int i66 = 0; i66 < i53; i66++) {
                        View childAt4 = getChildAt(i66);
                        if (childAt4 != null && childAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) childAt4.getLayoutParams())).weight > 0.0f) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i54, 1073741824));
                        }
                    }
                }
            }
            int i67 = iMax6;
            if (z16 || i52 == 1073741824) {
                iMax7 = i67;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax7, getSuggestedMinimumWidth()), i2, iCombineMeasuredStates3), iResolveSizeAndState);
            if (z15) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                for (int i68 = 0; i68 < i53; i68++) {
                    View childAt5 = getChildAt(i68);
                    if (childAt5.getVisibility() != 8) {
                        a aVar6 = (a) childAt5.getLayoutParams();
                        if (((LinearLayout.LayoutParams) aVar6).width == -1) {
                            int i69 = ((LinearLayout.LayoutParams) aVar6).height;
                            ((LinearLayout.LayoutParams) aVar6).height = childAt5.getMeasuredHeight();
                            measureChildWithMargins(childAt5, iMakeMeasureSpec, 0, i4, 0);
                            ((LinearLayout.LayoutParams) aVar6).height = i69;
                        }
                    }
                }
                return;
            }
            return;
        }
        this.f2753n = 0;
        int childCount2 = getChildCount();
        int mode3 = View.MeasureSpec.getMode(i2);
        int mode4 = View.MeasureSpec.getMode(i4);
        if (this.f2755q == null || this.f2756r == null) {
            this.f2755q = new int[4];
            this.f2756r = new int[4];
        }
        int[] iArr = this.f2755q;
        int[] iArr2 = this.f2756r;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z20 = this.f2748i;
        boolean z21 = this.p;
        boolean z22 = mode3 == 1073741824;
        boolean z23 = true;
        int iMax8 = 0;
        float f12 = 0.0f;
        int i70 = 0;
        int i71 = 0;
        int iMax9 = 0;
        int i72 = 0;
        int iMax10 = 0;
        boolean z24 = false;
        boolean z25 = false;
        while (i71 < childCount2) {
            View childAt6 = getChildAt(i71);
            if (childAt6 == null) {
                this.f2753n += 0;
                i17 = iMax8;
                i18 = i70;
            } else {
                i17 = iMax8;
                i18 = i70;
                if (childAt6.getVisibility() == 8) {
                    i71 += 0;
                } else {
                    if (m(i71)) {
                        this.f2753n += this.f2758t;
                    }
                    a aVar7 = (a) childAt6.getLayoutParams();
                    float f13 = ((LinearLayout.LayoutParams) aVar7).weight;
                    float f14 = f12 + f13;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) aVar7).width == 0 && f13 > 0.0f) {
                        if (z22) {
                            i26 = i71;
                            this.f2753n = ((LinearLayout.LayoutParams) aVar7).leftMargin + ((LinearLayout.LayoutParams) aVar7).rightMargin + this.f2753n;
                        } else {
                            i26 = i71;
                            int i73 = this.f2753n;
                            this.f2753n = Math.max(i73, ((LinearLayout.LayoutParams) aVar7).leftMargin + i73 + ((LinearLayout.LayoutParams) aVar7).rightMargin);
                        }
                        if (z20) {
                            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt6.measure(iMakeMeasureSpec2, iMakeMeasureSpec2);
                            aVar = aVar7;
                            i20 = i17;
                            iMax = i18;
                            i22 = i26;
                            z4 = z21;
                            z5 = z20;
                        } else {
                            aVar = aVar7;
                            i20 = i17;
                            iMax = i18;
                            i22 = i26;
                            i23 = 1073741824;
                            z4 = z21;
                            z5 = z20;
                            z6 = true;
                            if (mode4 == i23 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                                z7 = true;
                                z25 = true;
                            } else {
                                z7 = false;
                            }
                            i24 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                            int measuredHeight3 = childAt6.getMeasuredHeight() + i24;
                            int iCombineMeasuredStates4 = View.combineMeasuredStates(i72, childAt6.getMeasuredState());
                            if (z5 || (baseline2 = childAt6.getBaseline()) == -1) {
                                i25 = i24;
                            } else {
                                int i74 = ((LinearLayout.LayoutParams) aVar).gravity;
                                if (i74 < 0) {
                                    i74 = this.f2752m;
                                }
                                int i75 = (((i74 & 112) >> 4) & (-2)) >> 1;
                                i25 = i24;
                                iArr[i75] = Math.max(iArr[i75], baseline2);
                                iArr2[i75] = Math.max(iArr2[i75], measuredHeight3 - baseline2);
                            }
                            int iMax11 = Math.max(iMax10, measuredHeight3);
                            boolean z26 = !z23 && ((LinearLayout.LayoutParams) aVar).height == -1;
                            if (((LinearLayout.LayoutParams) aVar).weight <= 0.0f) {
                                if (z7) {
                                    measuredHeight3 = i25;
                                }
                                iMax8 = Math.max(i20, measuredHeight3);
                            } else {
                                int i76 = i20;
                                if (z7) {
                                    measuredHeight3 = i25;
                                }
                                iMax = Math.max(iMax, measuredHeight3);
                                iMax8 = i76;
                            }
                            i71 = i22 + 0;
                            iMax10 = iMax11;
                            i72 = iCombineMeasuredStates4;
                            z24 = z6;
                            z23 = z26;
                            f12 = f14;
                            i70 = iMax;
                            i71++;
                            z21 = z4;
                            z20 = z5;
                        }
                    } else {
                        int i77 = i71;
                        if (((LinearLayout.LayoutParams) aVar7).width == 0) {
                            f6 = 0.0f;
                            if (f13 > 0.0f) {
                                ((LinearLayout.LayoutParams) aVar7).width = -2;
                                i19 = 0;
                            }
                            i20 = i17;
                            iMax = i18;
                            i21 = i19;
                            i22 = i77;
                            z4 = z21;
                            z5 = z20;
                            measureChildWithMargins(childAt6, i2, f14 != f6 ? this.f2753n : 0, i4, 0);
                            if (i21 == Integer.MIN_VALUE) {
                                aVar = aVar7;
                                ((LinearLayout.LayoutParams) aVar).width = i21;
                            } else {
                                aVar = aVar7;
                            }
                            int measuredWidth3 = childAt6.getMeasuredWidth();
                            if (z22) {
                                int i78 = this.f2753n;
                                this.f2753n = Math.max(i78, i78 + measuredWidth3 + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin + 0);
                            } else {
                                this.f2753n = ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth3 + ((LinearLayout.LayoutParams) aVar).rightMargin + 0 + this.f2753n;
                            }
                            if (z4) {
                                iMax9 = Math.max(measuredWidth3, iMax9);
                            }
                        } else {
                            f6 = 0.0f;
                        }
                        i19 = Integer.MIN_VALUE;
                        i20 = i17;
                        iMax = i18;
                        i21 = i19;
                        i22 = i77;
                        z4 = z21;
                        z5 = z20;
                        measureChildWithMargins(childAt6, i2, f14 != f6 ? this.f2753n : 0, i4, 0);
                        if (i21 == Integer.MIN_VALUE) {
                        }
                        int measuredWidth32 = childAt6.getMeasuredWidth();
                        if (z22) {
                        }
                        if (z4) {
                        }
                    }
                    z6 = z24;
                    i23 = 1073741824;
                    if (mode4 == i23) {
                        z7 = false;
                        i24 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        int measuredHeight32 = childAt6.getMeasuredHeight() + i24;
                        int iCombineMeasuredStates42 = View.combineMeasuredStates(i72, childAt6.getMeasuredState());
                        if (z5) {
                            i25 = i24;
                            int iMax112 = Math.max(iMax10, measuredHeight32);
                            if (z23) {
                                if (((LinearLayout.LayoutParams) aVar).weight <= 0.0f) {
                                }
                                i71 = i22 + 0;
                                iMax10 = iMax112;
                                i72 = iCombineMeasuredStates42;
                                z24 = z6;
                                z23 = z26;
                                f12 = f14;
                                i70 = iMax;
                            }
                        }
                    }
                    i71++;
                    z21 = z4;
                    z20 = z5;
                }
            }
            z5 = z20;
            iMax8 = i17;
            i70 = i18;
            z4 = z21;
            i71++;
            z21 = z4;
            z20 = z5;
        }
        boolean z27 = z21;
        boolean z28 = z20;
        int i79 = i70;
        int i80 = iMax8;
        int iMax12 = i79;
        if (this.f2753n > 0 && m(childCount2)) {
            this.f2753n += this.f2758t;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1) {
            c2 = 3;
            if (iArr[3] == -1) {
                i5 = i72;
            }
            if (z27 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
                int i81 = 0;
                this.f2753n = 0;
                i16 = 0;
                while (i16 < childCount2) {
                    View childAt7 = getChildAt(i16);
                    if (childAt7 == null) {
                        this.f2753n += i81;
                    } else if (childAt7.getVisibility() == 8) {
                        i16 += 0;
                    } else {
                        a aVar8 = (a) childAt7.getLayoutParams();
                        if (z22) {
                            this.f2753n = ((LinearLayout.LayoutParams) aVar8).leftMargin + iMax9 + ((LinearLayout.LayoutParams) aVar8).rightMargin + 0 + this.f2753n;
                        } else {
                            int i82 = this.f2753n;
                            this.f2753n = Math.max(i82, i82 + iMax9 + ((LinearLayout.LayoutParams) aVar8).leftMargin + ((LinearLayout.LayoutParams) aVar8).rightMargin + 0);
                        }
                    }
                    i16++;
                    i81 = 0;
                }
            }
            int paddingRight = getPaddingRight() + getPaddingLeft() + this.f2753n;
            this.f2753n = paddingRight;
            int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, 0);
            i6 = (16777215 & iResolveSizeAndState2) - this.f2753n;
            if (!z24 || (i6 != 0 && f12 > 0.0f)) {
                f4 = this.f2754o;
                if (f4 > 0.0f) {
                    f12 = f4;
                }
                iArr[3] = -1;
                iArr[2] = -1;
                iArr[1] = -1;
                iArr[0] = -1;
                iArr2[3] = -1;
                iArr2[2] = -1;
                iArr2[1] = -1;
                iArr2[0] = -1;
                this.f2753n = 0;
                int i83 = i6;
                iCombineMeasuredStates = i5;
                int iMax13 = -1;
                i7 = 0;
                while (i7 < childCount2) {
                    View childAt8 = getChildAt(i7);
                    if (childAt8 == null || childAt8.getVisibility() == 8) {
                        i11 = childCount2;
                        i12 = i83;
                    } else {
                        a aVar9 = (a) childAt8.getLayoutParams();
                        float f15 = ((LinearLayout.LayoutParams) aVar9).weight;
                        if (f15 > 0.0f) {
                            i11 = childCount2;
                            int i84 = (int) ((i83 * f15) / f12);
                            float f16 = f12 - f15;
                            int i85 = i83 - i84;
                            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) aVar9).topMargin + ((LinearLayout.LayoutParams) aVar9).bottomMargin, ((LinearLayout.LayoutParams) aVar9).height);
                            if (((LinearLayout.LayoutParams) aVar9).width == 0) {
                                i15 = 1073741824;
                                if (mode3 == 1073741824) {
                                    if (i84 <= 0) {
                                        i84 = 0;
                                    }
                                    childAt8.measure(View.MeasureSpec.makeMeasureSpec(i84, 1073741824), childMeasureSpec2);
                                }
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt8.getMeasuredState() & (-16777216));
                                f12 = f16;
                                i13 = i85;
                            } else {
                                i15 = 1073741824;
                            }
                            int measuredWidth4 = childAt8.getMeasuredWidth() + i84;
                            if (measuredWidth4 < 0) {
                                measuredWidth4 = 0;
                            }
                            childAt8.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i15), childMeasureSpec2);
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt8.getMeasuredState() & (-16777216));
                            f12 = f16;
                            i13 = i85;
                        } else {
                            i13 = i83;
                            i11 = childCount2;
                        }
                        if (z22) {
                            f5 = f12;
                            this.f2753n = childAt8.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar9).leftMargin + ((LinearLayout.LayoutParams) aVar9).rightMargin + 0 + this.f2753n;
                            i12 = i13;
                        } else {
                            f5 = f12;
                            int i86 = this.f2753n;
                            i12 = i13;
                            this.f2753n = Math.max(i86, childAt8.getMeasuredWidth() + i86 + ((LinearLayout.LayoutParams) aVar9).leftMargin + ((LinearLayout.LayoutParams) aVar9).rightMargin + 0);
                        }
                        boolean z29 = mode4 != 1073741824 && ((LinearLayout.LayoutParams) aVar9).height == -1;
                        int i87 = ((LinearLayout.LayoutParams) aVar9).topMargin + ((LinearLayout.LayoutParams) aVar9).bottomMargin;
                        int measuredHeight4 = childAt8.getMeasuredHeight() + i87;
                        iMax13 = Math.max(iMax13, measuredHeight4);
                        if (!z29) {
                            i87 = measuredHeight4;
                        }
                        iMax12 = Math.max(iMax12, i87);
                        if (z23) {
                            i14 = -1;
                            boolean z30 = ((LinearLayout.LayoutParams) aVar9).height == -1;
                            if (!z28 && (baseline = childAt8.getBaseline()) != i14) {
                                int i88 = ((LinearLayout.LayoutParams) aVar9).gravity;
                                if (i88 < 0) {
                                    i88 = this.f2752m;
                                }
                                int i89 = (((i88 & 112) >> 4) & (-2)) >> 1;
                                iArr[i89] = Math.max(iArr[i89], baseline);
                                iArr2[i89] = Math.max(iArr2[i89], measuredHeight4 - baseline);
                            }
                            z23 = z30;
                            f12 = f5;
                        } else {
                            i14 = -1;
                        }
                        if (!z28) {
                            z23 = z30;
                            f12 = f5;
                        }
                    }
                    i7++;
                    childCount2 = i11;
                    i83 = i12;
                }
                i8 = i4;
                i9 = childCount2;
                this.f2753n = getPaddingRight() + getPaddingLeft() + this.f2753n;
                if (iArr[1] != -1 && iArr[0] == -1 && iArr[2] == -1) {
                    c4 = 3;
                    if (iArr[3] == -1) {
                        iMax10 = iMax13;
                    }
                } else {
                    c4 = 3;
                }
                i10 = 0;
                iMax10 = Math.max(iMax13, Math.max(iArr2[c4], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c4], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
                if (z23 || mode4 == 1073741824) {
                    iMax12 = iMax10;
                }
                setMeasuredDimension(((-16777216) & iCombineMeasuredStates) | iResolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax12, getSuggestedMinimumHeight()), i8, iCombineMeasuredStates << 16));
                if (z25) {
                    int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                    int i90 = i9;
                    for (int i91 = i10; i91 < i90; i91++) {
                        View childAt9 = getChildAt(i91);
                        if (childAt9.getVisibility() != 8) {
                            a aVar10 = (a) childAt9.getLayoutParams();
                            if (((LinearLayout.LayoutParams) aVar10).height == -1) {
                                int i92 = ((LinearLayout.LayoutParams) aVar10).width;
                                ((LinearLayout.LayoutParams) aVar10).width = childAt9.getMeasuredWidth();
                                measureChildWithMargins(childAt9, i2, 0, iMakeMeasureSpec3, 0);
                                ((LinearLayout.LayoutParams) aVar10).width = i92;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            iMax12 = Math.max(iMax12, i80);
            if (z27 && mode3 != 1073741824) {
                for (int i93 = 0; i93 < childCount2; i93++) {
                    View childAt10 = getChildAt(i93);
                    if (childAt10 != null && childAt10.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) childAt10.getLayoutParams())).weight > 0.0f) {
                        childAt10.measure(View.MeasureSpec.makeMeasureSpec(iMax9, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt10.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i8 = i4;
            i9 = childCount2;
            iCombineMeasuredStates = i5;
            i10 = 0;
            if (z23) {
                iMax12 = iMax10;
            }
            setMeasuredDimension(((-16777216) & iCombineMeasuredStates) | iResolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax12, getSuggestedMinimumHeight()), i8, iCombineMeasuredStates << 16));
            if (z25) {
            }
        } else {
            c2 = 3;
        }
        i5 = i72;
        iMax10 = Math.max(iMax10, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        if (z27) {
            int i812 = 0;
            this.f2753n = 0;
            i16 = 0;
            while (i16 < childCount2) {
            }
        }
        int paddingRight2 = getPaddingRight() + getPaddingLeft() + this.f2753n;
        this.f2753n = paddingRight2;
        int iResolveSizeAndState22 = View.resolveSizeAndState(Math.max(paddingRight2, getSuggestedMinimumWidth()), i2, 0);
        i6 = (16777215 & iResolveSizeAndState22) - this.f2753n;
        if (z24) {
            f4 = this.f2754o;
            if (f4 > 0.0f) {
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f2753n = 0;
            int i832 = i6;
            iCombineMeasuredStates = i5;
            int iMax132 = -1;
            i7 = 0;
            while (i7 < childCount2) {
            }
            i8 = i4;
            i9 = childCount2;
            this.f2753n = getPaddingRight() + getPaddingLeft() + this.f2753n;
            if (iArr[1] != -1) {
                c4 = 3;
                i10 = 0;
                iMax10 = Math.max(iMax132, Math.max(iArr2[c4], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c4], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            }
        }
        if (z23) {
        }
        setMeasuredDimension(((-16777216) & iCombineMeasuredStates) | iResolveSizeAndState22, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax12, getSuggestedMinimumHeight()), i8, iCombineMeasuredStates << 16));
        if (z25) {
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public G(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public G(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2748i = true;
        this.f2749j = -1;
        this.f2750k = 0;
        this.f2752m = 8388659;
        int[] iArr = Y1.a.f2124r;
        U u = U.u(context, attributeSet, iArr, i2, 0);
        androidx.core.view.o.i(this, context, iArr, attributeSet, u.q(), i2);
        int iJ = u.j(1, -1);
        if (iJ >= 0 && this.f2751l != iJ) {
            this.f2751l = iJ;
            requestLayout();
        }
        int iJ2 = u.j(0, -1);
        if (iJ2 >= 0 && this.f2752m != iJ2) {
            iJ2 = (8388615 & iJ2) == 0 ? iJ2 | 8388611 : iJ2;
            this.f2752m = (iJ2 & 112) == 0 ? iJ2 | 48 : iJ2;
            requestLayout();
        }
        boolean zA = u.a(2, true);
        if (!zA) {
            this.f2748i = zA;
        }
        this.f2754o = u.h();
        this.f2749j = u.j(3, -1);
        this.p = u.a(7, false);
        Drawable drawableF = u.f(5);
        if (drawableF != this.f2757s) {
            this.f2757s = drawableF;
            if (drawableF != null) {
                this.f2758t = drawableF.getIntrinsicWidth();
                this.u = drawableF.getIntrinsicHeight();
            } else {
                this.f2758t = 0;
                this.u = 0;
            }
            setWillNotDraw(drawableF == null);
            requestLayout();
        }
        this.f2759v = u.j(8, 0);
        this.f2760w = u.e(6, 0);
        u.v();
    }
}
