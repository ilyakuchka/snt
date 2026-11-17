package miuix.appcompat.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.android.mmt.R;
import w3.C0411d;
import z3.C0431a;

/* loaded from: classes.dex */
public class DialogParentPanel2 extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    private final a f7065i;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f7066a;

        /* renamed from: b, reason: collision with root package name */
        private final Point f7067b;

        /* renamed from: c, reason: collision with root package name */
        private TypedValue f7068c;
        private TypedValue d;

        /* renamed from: e, reason: collision with root package name */
        private TypedValue f7069e;

        /* renamed from: f, reason: collision with root package name */
        private TypedValue f7070f;
        private TypedValue g;

        /* renamed from: h, reason: collision with root package name */
        private TypedValue f7071h;

        /* renamed from: i, reason: collision with root package name */
        private TypedValue f7072i;

        /* renamed from: j, reason: collision with root package name */
        private TypedValue f7073j;

        public a(Context context, AttributeSet attributeSet) {
            Point point = new Point();
            this.f7067b = point;
            this.f7066a = context;
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2109b0);
                if (typedArrayObtainStyledAttributes.hasValue(19)) {
                    TypedValue typedValue = new TypedValue();
                    this.f7068c = typedValue;
                    typedArrayObtainStyledAttributes.getValue(19, typedValue);
                }
                if (typedArrayObtainStyledAttributes.hasValue(16)) {
                    TypedValue typedValue2 = new TypedValue();
                    this.d = typedValue2;
                    typedArrayObtainStyledAttributes.getValue(16, typedValue2);
                }
                if (typedArrayObtainStyledAttributes.hasValue(18)) {
                    TypedValue typedValue3 = new TypedValue();
                    this.f7069e = typedValue3;
                    typedArrayObtainStyledAttributes.getValue(18, typedValue3);
                }
                if (typedArrayObtainStyledAttributes.hasValue(17)) {
                    TypedValue typedValue4 = new TypedValue();
                    this.f7070f = typedValue4;
                    typedArrayObtainStyledAttributes.getValue(17, typedValue4);
                }
                if (typedArrayObtainStyledAttributes.hasValue(25)) {
                    TypedValue typedValue5 = new TypedValue();
                    this.g = typedValue5;
                    typedArrayObtainStyledAttributes.getValue(25, typedValue5);
                }
                if (typedArrayObtainStyledAttributes.hasValue(24)) {
                    TypedValue typedValue6 = new TypedValue();
                    this.f7071h = typedValue6;
                    typedArrayObtainStyledAttributes.getValue(24, typedValue6);
                }
                if (typedArrayObtainStyledAttributes.hasValue(22)) {
                    TypedValue typedValue7 = new TypedValue();
                    this.f7073j = typedValue7;
                    typedArrayObtainStyledAttributes.getValue(22, typedValue7);
                }
                if (typedArrayObtainStyledAttributes.hasValue(23)) {
                    TypedValue typedValue8 = new TypedValue();
                    this.f7072i = typedValue8;
                    typedArrayObtainStyledAttributes.getValue(23, typedValue8);
                }
                typedArrayObtainStyledAttributes.recycle();
            }
            C0411d.a(context, point);
        }

        private int b(int i2, boolean z4, TypedValue typedValue, TypedValue typedValue2, TypedValue typedValue3, TypedValue typedValue4) {
            if (View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
                return i2;
            }
            boolean z5 = this.f7066a.getResources().getConfiguration().orientation == 1;
            if (!z5) {
                typedValue = typedValue2;
            }
            int iE = e(typedValue, z4);
            if (iE > 0) {
                return View.MeasureSpec.makeMeasureSpec(iE, 1073741824);
            }
            if (!z5) {
                typedValue3 = typedValue4;
            }
            int iE2 = e(typedValue3, z4);
            return iE2 > 0 ? View.MeasureSpec.makeMeasureSpec(Math.min(iE2, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE) : i2;
        }

        private int e(TypedValue typedValue, boolean z4) {
            int i2;
            float fraction;
            if (typedValue != null && (i2 = typedValue.type) != 0) {
                if (i2 == 5) {
                    fraction = typedValue.getDimension(this.f7066a.getResources().getDisplayMetrics());
                } else if (i2 == 6) {
                    Point point = this.f7067b;
                    float f4 = z4 ? point.x : point.y;
                    fraction = typedValue.getFraction(f4, f4);
                }
                return (int) fraction;
            }
            return 0;
        }

        public final int a(int i2) {
            return b(i2, false, this.f7070f, this.d, this.f7072i, this.f7073j);
        }

        public final int c(int i2) {
            return b(i2, true, this.f7068c, this.f7069e, this.g, this.f7071h);
        }

        public final void d() {
            this.f7068c = C0431a.h(this.f7066a, R.attr.windowFixedWidthMinor);
            this.d = C0431a.h(this.f7066a, R.attr.windowFixedHeightMajor);
            this.f7069e = C0431a.h(this.f7066a, R.attr.windowFixedWidthMajor);
            this.f7070f = C0431a.h(this.f7066a, R.attr.windowFixedHeightMinor);
            this.g = C0431a.h(this.f7066a, R.attr.windowMaxWidthMinor);
            this.f7071h = C0431a.h(this.f7066a, R.attr.windowMaxWidthMajor);
            this.f7072i = C0431a.h(this.f7066a, R.attr.windowMaxHeightMinor);
            this.f7073j = C0431a.h(this.f7066a, R.attr.windowMaxHeightMajor);
            C0411d.a(this.f7066a, this.f7067b);
        }
    }

    public DialogParentPanel2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f7065i = new a(context, attributeSet);
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f7065i.d();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        super.onMeasure(this.f7065i.c(i2), this.f7065i.a(i4));
    }
}
