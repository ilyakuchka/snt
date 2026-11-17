package com.android.mmt.ui;

import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
final class p0 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ MessageOriginalTextActivity f5686i;

    p0(MessageOriginalTextActivity messageOriginalTextActivity) {
        this.f5686i = messageOriginalTextActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spannable) this.f5686i.f5027y.getText()).getSpans(this.f5686i.f5027y.getSelectionStart(), this.f5686i.f5027y.getSelectionEnd(), ClickableSpan.class);
        if (clickableSpanArr.length > 0) {
            clickableSpanArr[0].onClick(this.f5686i.f5027y);
        }
    }
}
