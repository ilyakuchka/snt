package miuix.appcompat.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class TextAlignLayout extends LinearLayout {
    public TextAlignLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        int childCount = getChildCount();
        boolean z4 = true;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (z4 && (childAt instanceof TextView)) {
                TextView textView = (TextView) childAt;
                z4 = textView.getLineCount() <= 1;
                if (z4) {
                    textView.setGravity(1);
                }
            }
        }
    }
}
