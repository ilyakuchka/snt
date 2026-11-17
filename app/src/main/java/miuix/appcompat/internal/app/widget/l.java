package miuix.appcompat.internal.app.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.android.mmt.R;
import miuix.appcompat.internal.app.widget.ScrollingTabContainerView;

/* loaded from: classes.dex */
public final class l extends ScrollingTabContainerView {

    /* renamed from: w, reason: collision with root package name */
    private int[] f7000w;

    public l(Context context) {
        super(context);
        l(-2);
        this.f7000w = new int[]{context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_action_bar_tab_expand_text_size), 0, 0};
        this.f7000w[1] = context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_action_bar_tab_expand_text_size_1);
        this.f7000w[2] = context.getResources().getDimensionPixelSize(R.dimen.miuix_appcompat_action_bar_tab_expand_text_size_2);
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int f() {
        return R.attr.actionBarTabTextExpandStyle;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int g() {
        return R.layout.miuix_appcompat_action_bar_tabbar_expand;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int h() {
        return -2;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int i() {
        return R.layout.miuix_appcompat_action_bar_tab_expand;
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView
    final int j() {
        return getContext().getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_tab_expand_margin);
    }

    @Override // miuix.appcompat.internal.app.widget.ScrollingTabContainerView, android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i4) throws Resources.NotFoundException {
        int[] iArr = this.f7000w;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 0);
        int i5 = iArr[0];
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.miuix_appcompat_action_bar_tab_expand_margin);
        for (int i6 = 0; i6 < iArr.length; i6++) {
            i5 = iArr[i6];
            TextPaint textPaint = null;
            int iMeasureText = 0;
            for (int i7 = 0; i7 < this.f6906n.getChildCount(); i7++) {
                TextView textViewC = ((ScrollingTabContainerView.TabView) this.f6906n.getChildAt(i7)).c();
                if (textViewC != null) {
                    if (textPaint == null) {
                        textPaint = new TextPaint(textViewC.getPaint());
                        iMeasureText += dimensionPixelOffset;
                    }
                    textPaint.setTextSize(i5);
                    iMeasureText = (int) (textPaint.measureText(textViewC.getText().toString()) + iMeasureText);
                }
            }
            if (iMeasureText <= Math.max(getMeasuredWidth(), View.MeasureSpec.getSize(iMakeMeasureSpec))) {
                break;
            }
        }
        for (int i8 = 0; i8 < this.f6906n.getChildCount(); i8++) {
            TextView textViewC2 = ((ScrollingTabContainerView.TabView) this.f6906n.getChildAt(i8)).c();
            if (textViewC2 != null) {
                textViewC2.setTextSize(0, i5);
            }
        }
        super.onMeasure(i2, i4);
    }
}
