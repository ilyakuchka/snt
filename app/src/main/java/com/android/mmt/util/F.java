package com.android.mmt.util;

import I0.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
final class F extends ClickableSpan {

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ Context f5889j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ String f5890k;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f5888i = true;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ boolean f5891l = true;

    F(Context context, String str) {
        this.f5889j = context;
        this.f5890k = str;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) throws Resources.NotFoundException {
        if (this.f5888i) {
            a.a(this.f5889j, this.f5890k);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(this.f5891l);
        textPaint.setColor(Color.parseColor("#0099FF"));
    }
}
