package com.android.mmt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class AttachmentScreenView extends ScreenView {
    public AttachmentScreenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.android.mmt.ui.ScreenView
    protected final void e(View view, FrameLayout.LayoutParams layoutParams) {
        super.e(view, layoutParams);
        view.setLayoutDirection(0);
    }
}
