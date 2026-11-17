package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public final class c extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    b f3266i;

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z4, int i2, int i4, int i5, int i6) {
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    public static class a extends ConstraintLayout.a {

        /* renamed from: l0, reason: collision with root package name */
        public float f3267l0;

        /* renamed from: m0, reason: collision with root package name */
        public boolean f3268m0;

        /* renamed from: n0, reason: collision with root package name */
        public float f3269n0;

        /* renamed from: o0, reason: collision with root package name */
        public float f3270o0;
        public float p0;
        public float q0;

        /* renamed from: r0, reason: collision with root package name */
        public float f3271r0;

        /* renamed from: s0, reason: collision with root package name */
        public float f3272s0;

        /* renamed from: t0, reason: collision with root package name */
        public float f3273t0;

        /* renamed from: u0, reason: collision with root package name */
        public float f3274u0;

        /* renamed from: v0, reason: collision with root package name */
        public float f3275v0;

        /* renamed from: w0, reason: collision with root package name */
        public float f3276w0;

        public a() {
            this.f3267l0 = 1.0f;
            this.f3268m0 = false;
            this.f3269n0 = 0.0f;
            this.f3270o0 = 0.0f;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.f3271r0 = 1.0f;
            this.f3272s0 = 1.0f;
            this.f3273t0 = 0.0f;
            this.f3274u0 = 0.0f;
            this.f3275v0 = 0.0f;
            this.f3276w0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3267l0 = 1.0f;
            this.f3268m0 = false;
            this.f3269n0 = 0.0f;
            this.f3270o0 = 0.0f;
            this.p0 = 0.0f;
            this.q0 = 0.0f;
            this.f3271r0 = 1.0f;
            this.f3272s0 = 1.0f;
            this.f3273t0 = 0.0f;
            this.f3274u0 = 0.0f;
            this.f3275v0 = 0.0f;
            this.f3276w0 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2112d0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == 13) {
                    this.f3267l0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3267l0);
                } else if (index == 26) {
                    this.f3269n0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3269n0);
                    this.f3268m0 = true;
                } else if (index == 21) {
                    this.p0 = typedArrayObtainStyledAttributes.getFloat(index, this.p0);
                } else if (index == 22) {
                    this.q0 = typedArrayObtainStyledAttributes.getFloat(index, this.q0);
                } else if (index == 20) {
                    this.f3270o0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3270o0);
                } else if (index == 18) {
                    this.f3271r0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3271r0);
                } else if (index == 19) {
                    this.f3272s0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3272s0);
                } else if (index == 14) {
                    this.f3273t0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3273t0);
                } else if (index == 15) {
                    this.f3274u0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3274u0);
                } else if (index == 16) {
                    this.f3275v0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3275v0);
                } else if (index == 17) {
                    this.f3276w0 = typedArrayObtainStyledAttributes.getFloat(index, this.f3276w0);
                } else if (index == 25) {
                    this.f3275v0 = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                }
            }
        }
    }
}
