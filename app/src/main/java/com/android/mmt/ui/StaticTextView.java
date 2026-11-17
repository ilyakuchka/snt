package com.android.mmt.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes.dex */
public class StaticTextView extends AppCompatTextView {
    private boolean manualAutoLink;

    public StaticTextView(Context context) {
        super(context);
        this.manualAutoLink = true;
    }

    private void manualSetAutoLinkMask() {
        int autoLinkMask;
        if (!this.manualAutoLink || (autoLinkMask = getAutoLinkMask()) == 0) {
            return;
        }
        Linkify.addLinks(this, autoLinkMask);
    }

    @Override // android.widget.TextView
    public void append(CharSequence charSequence, int i2, int i4) {
        super.append(charSequence, i2, i4);
        manualSetAutoLinkMask();
    }

    public void disableManualAutoLink() {
        this.manualAutoLink = false;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public CharSequence getText() {
        return SpannableString.valueOf(super.getText());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(!TextUtils.isEmpty(charSequence) ? SpannableString.valueOf(charSequence) : null, bufferType);
        manualSetAutoLinkMask();
    }

    public boolean useDynamicLayout() {
        return false;
    }

    public StaticTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.manualAutoLink = true;
    }

    public StaticTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.manualAutoLink = true;
    }
}
