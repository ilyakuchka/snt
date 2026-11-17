package miuix.appcompat.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class DialogButtonPanel extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    private final int f7061i;

    /* renamed from: j, reason: collision with root package name */
    private final int f7062j;

    /* renamed from: k, reason: collision with root package name */
    private final int f7063k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7064l;

    public DialogButtonPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f7061i = getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_dialog_button_panel_horizontal_margin);
        this.f7062j = getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_dialog_btn_margin_horizontal);
        this.f7063k = getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_dialog_btn_margin_vertical);
    }

    public final void a(boolean z4) {
        this.f7064l = z4;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        boolean z4;
        int size = View.MeasureSpec.getSize(i2);
        if (this.f7064l) {
            z4 = true;
            break;
        }
        int childCount = getChildCount();
        int i5 = childCount;
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            if (getChildAt(i6).getVisibility() == 8) {
                i5--;
            }
        }
        if (i5 >= 2) {
            if (i5 < 3) {
                int i7 = (size - this.f7062j) / 2;
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = getChildAt(i8);
                    if ((childAt instanceof TextView) && childAt.getVisibility() == 0) {
                        TextView textView = (TextView) childAt;
                        if (((int) textView.getPaint().measureText(textView.getText().toString())) > (i7 - textView.getPaddingStart()) - textView.getPaddingEnd()) {
                        }
                    }
                }
            }
            z4 = true;
            break;
        }
        z4 = false;
        int childCount2 = getChildCount();
        if (z4) {
            setOrientation(1);
            setPadding(this.f7061i, getPaddingTop(), this.f7061i, getPaddingBottom());
            int i9 = 0;
            for (int i10 = 0; i10 < childCount2; i10++) {
                View childAt2 = getChildAt(i10);
                boolean z5 = childAt2.getVisibility() == 0;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -2;
                layoutParams.weight = 0.0f;
                layoutParams.topMargin = z5 ? i9 : 0;
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                if (z5) {
                    i9 = this.f7063k;
                }
            }
        } else {
            setOrientation(0);
            setPadding(this.f7061i, getPaddingTop(), this.f7061i, getPaddingBottom());
            boolean z6 = getLayoutDirection() == 1;
            int i11 = 0;
            for (int i12 = 0; i12 < childCount2; i12++) {
                View childAt3 = getChildAt(i12);
                boolean z7 = childAt3.getVisibility() == 0;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) childAt3.getLayoutParams();
                layoutParams2.width = 0;
                layoutParams2.height = -1;
                layoutParams2.weight = 1.0f;
                layoutParams2.topMargin = 0;
                if (!z7) {
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                } else if (z6) {
                    layoutParams2.rightMargin = i11;
                } else {
                    layoutParams2.leftMargin = i11;
                }
                if (z7) {
                    i11 = this.f7062j;
                }
            }
        }
        super.onMeasure(i2, i4);
    }
}
