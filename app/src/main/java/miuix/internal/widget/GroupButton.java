package miuix.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Y;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class GroupButton extends AppCompatButton {

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f7154l = {R.attr.state_first_v};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f7155m = {R.attr.state_middle_v};

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f7156n = {R.attr.state_last_v};

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f7157o = {R.attr.state_first_h};
    private static final int[] p = {R.attr.state_middle_h};

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f7158q = {R.attr.state_last_h};

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f7159r = {R.attr.state_single_h};

    /* renamed from: k, reason: collision with root package name */
    private boolean f7160k;

    public GroupButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final boolean a() {
        return this.f7160k;
    }

    @Override // android.widget.TextView, android.view.View
    protected final int[] onCreateDrawableState(int i2) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return super.onCreateDrawableState(i2);
        }
        if (!(viewGroup instanceof LinearLayout)) {
            return super.onCreateDrawableState(i2);
        }
        int orientation = ((LinearLayout) viewGroup).getOrientation();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i4 = 0;
        boolean z4 = true;
        boolean z5 = true;
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            if (viewGroup.getChildAt(i5).getVisibility() == 0) {
                i4++;
                if (i5 < iIndexOfChild) {
                    z4 = false;
                }
                if (i5 > iIndexOfChild) {
                    z5 = false;
                }
            }
        }
        boolean z6 = i4 == 1;
        if (orientation == 1) {
            int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7159r);
            if (!z6) {
                if (z4) {
                    View.mergeDrawableStates(iArrOnCreateDrawableState, f7154l);
                } else if (z5) {
                    View.mergeDrawableStates(iArrOnCreateDrawableState, f7156n);
                } else {
                    View.mergeDrawableStates(iArrOnCreateDrawableState, f7155m);
                }
            }
            return iArrOnCreateDrawableState;
        }
        boolean zB = Y.b(this);
        int[] iArrOnCreateDrawableState2 = super.onCreateDrawableState(i2 + 1);
        if (z6) {
            View.mergeDrawableStates(iArrOnCreateDrawableState2, f7159r);
        } else if (z4) {
            View.mergeDrawableStates(iArrOnCreateDrawableState2, zB ? f7158q : f7157o);
        } else if (z5) {
            View.mergeDrawableStates(iArrOnCreateDrawableState2, zB ? f7157o : f7158q);
        } else {
            View.mergeDrawableStates(iArrOnCreateDrawableState2, p);
        }
        return iArrOnCreateDrawableState2;
    }

    public GroupButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y1.a.f2103X, i2, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
                typedArrayObtainStyledAttributes.getDrawable(0);
            }
            if (typedArrayObtainStyledAttributes.hasValue(1)) {
                this.f7160k = typedArrayObtainStyledAttributes.getBoolean(1, false);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
