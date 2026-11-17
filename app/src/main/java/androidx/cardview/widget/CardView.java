package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import t.C0384b;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] p = {R.attr.colorBackground};

    /* renamed from: q, reason: collision with root package name */
    private static final androidx.cardview.widget.a f3103q = new androidx.cardview.widget.a();

    /* renamed from: i, reason: collision with root package name */
    private boolean f3104i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3105j;

    /* renamed from: k, reason: collision with root package name */
    int f3106k;

    /* renamed from: l, reason: collision with root package name */
    int f3107l;

    /* renamed from: m, reason: collision with root package name */
    final Rect f3108m;

    /* renamed from: n, reason: collision with root package name */
    final Rect f3109n;

    /* renamed from: o, reason: collision with root package name */
    private final a f3110o;

    final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f3111a;

        a() {
        }

        public final Drawable a() {
            return this.f3111a;
        }

        public final boolean b() {
            return CardView.this.b();
        }

        public final void c(Drawable drawable) {
            this.f3111a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        public final void d(int i2, int i4, int i5, int i6) {
            CardView.this.f3109n.set(i2, i4, i5, i6);
            CardView cardView = CardView.this;
            Rect rect = cardView.f3108m;
            CardView.super.setPadding(i2 + rect.left, i4 + rect.top, i5 + rect.right, i6 + rect.bottom);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, com.android.mmt.R.attr.cardViewStyle);
        Rect rect = new Rect();
        this.f3108m = rect;
        this.f3109n = new Rect();
        a aVar = new a();
        this.f3110o = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0384b.f7888t, com.android.mmt.R.attr.cardViewStyle, com.android.mmt.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(p);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(com.android.mmt.R.color.cardview_light_background) : getResources().getColor(com.android.mmt.R.color.cardview_dark_background));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.f3104i = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f3105j = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        float f4 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f3106k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f3107l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        f3103q.c(aVar, context, colorStateList, dimension, dimension2, f4);
    }

    public final boolean b() {
        return this.f3105j;
    }

    public final boolean c() {
        return this.f3104i;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
    }

    @Override // android.view.View
    public final void setMinimumHeight(int i2) {
        this.f3107l = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public final void setMinimumWidth(int i2) {
        this.f3106k = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public final void setPadding(int i2, int i4, int i5, int i6) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i2, int i4, int i5, int i6) {
    }
}
