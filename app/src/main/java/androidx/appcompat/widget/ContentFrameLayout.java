package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import java.util.Objects;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    private TypedValue f2716i;

    /* renamed from: j, reason: collision with root package name */
    private TypedValue f2717j;

    /* renamed from: k, reason: collision with root package name */
    private TypedValue f2718k;

    /* renamed from: l, reason: collision with root package name */
    private TypedValue f2719l;

    /* renamed from: m, reason: collision with root package name */
    private TypedValue f2720m;

    /* renamed from: n, reason: collision with root package name */
    private TypedValue f2721n;

    /* renamed from: o, reason: collision with root package name */
    private final Rect f2722o;
    private a p;

    public interface a {
        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2722o = new Rect();
    }

    public final TypedValue a() {
        if (this.f2720m == null) {
            this.f2720m = new TypedValue();
        }
        return this.f2720m;
    }

    public final TypedValue b() {
        if (this.f2721n == null) {
            this.f2721n = new TypedValue();
        }
        return this.f2721n;
    }

    public final TypedValue c() {
        if (this.f2718k == null) {
            this.f2718k = new TypedValue();
        }
        return this.f2718k;
    }

    public final TypedValue d() {
        if (this.f2719l == null) {
            this.f2719l = new TypedValue();
        }
        return this.f2719l;
    }

    public final TypedValue e() {
        if (this.f2716i == null) {
            this.f2716i = new TypedValue();
        }
        return this.f2716i;
    }

    public final TypedValue f() {
        if (this.f2717j == null) {
            this.f2717j = new TypedValue();
        }
        return this.f2717j;
    }

    public final void g(a aVar) {
        this.p = aVar;
    }

    public final void h(int i2, int i4, int i5, int i6) {
        this.f2722o.set(i2, i4, i5, i6);
        int i7 = androidx.core.view.o.d;
        if (isLaidOut()) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.p;
        if (aVar != null) {
            Objects.requireNonNull(aVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.p;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void onMeasure(int i2, int i4) {
        boolean z4;
        int i5;
        int i6;
        float fraction;
        int i7;
        int i8;
        float fraction2;
        int i9;
        int i10;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z5 = true;
        boolean z6 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode != Integer.MIN_VALUE) {
            z4 = false;
        } else {
            TypedValue typedValue = z6 ? this.f2719l : this.f2718k;
            if (typedValue != null && (i9 = typedValue.type) != 0) {
                if (i9 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else if (i9 == 6) {
                    int i11 = displayMetrics.widthPixels;
                    fraction3 = typedValue.getFraction(i11, i11);
                } else {
                    i10 = 0;
                    if (i10 <= 0) {
                        Rect rect = this.f2722o;
                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i10 - (rect.left + rect.right), View.MeasureSpec.getSize(i2)), 1073741824);
                        z4 = true;
                    }
                }
                i10 = (int) fraction3;
                if (i10 <= 0) {
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z6 ? this.f2720m : this.f2721n;
            if (typedValue2 != null && (i7 = typedValue2.type) != 0) {
                if (i7 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else if (i7 == 6) {
                    int i12 = displayMetrics.heightPixels;
                    fraction2 = typedValue2.getFraction(i12, i12);
                } else {
                    i8 = 0;
                    if (i8 > 0) {
                        Rect rect2 = this.f2722o;
                        i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i8 - (rect2.top + rect2.bottom), View.MeasureSpec.getSize(i4)), 1073741824);
                    }
                }
                i8 = (int) fraction2;
                if (i8 > 0) {
                }
            }
        }
        super.onMeasure(i2, i4);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z4 || mode != Integer.MIN_VALUE) {
            z5 = false;
        } else {
            TypedValue typedValue3 = z6 ? this.f2717j : this.f2716i;
            if (typedValue3 != null && (i5 = typedValue3.type) != 0) {
                if (i5 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else if (i5 == 6) {
                    int i13 = displayMetrics.widthPixels;
                    fraction = typedValue3.getFraction(i13, i13);
                } else {
                    i6 = 0;
                    if (i6 > 0) {
                        Rect rect3 = this.f2722o;
                        i6 -= rect3.left + rect3.right;
                    }
                    if (measuredWidth >= i6) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                    }
                }
                i6 = (int) fraction;
                if (i6 > 0) {
                }
                if (measuredWidth >= i6) {
                }
            }
        }
        if (z5) {
            super.onMeasure(iMakeMeasureSpec, i4);
        }
    }
}
