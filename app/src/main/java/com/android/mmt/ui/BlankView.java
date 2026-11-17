package com.android.mmt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class BlankView extends LinearLayout {
    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.conversation_list_empty_anim_view, (ViewGroup) this, true);
        ((FrameLayout) findViewById(R.id.blankview_container)).setPaddingRelative(0, 0, 0, context.getResources().getDimensionPixelSize(R.dimen.ic_conversation_empty_margin_bottom));
    }
}
