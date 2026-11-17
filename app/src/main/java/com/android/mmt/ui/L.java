package com.android.mmt.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.mmt.R;
import com.android.mmt.ui.MessageListItem;
import java.util.Objects;
import x0.C0414a;

/* loaded from: classes.dex */
public class L extends MessageListItem {

    /* renamed from: w0, reason: collision with root package name */
    private TextView f4887w0;

    /* renamed from: x0, reason: collision with root package name */
    protected ViewGroup f4888x0;

    public L(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.android.mmt.ui.MessageListItem
    public void L(C0243g0 c0243g0, boolean z4, boolean z5, boolean z6, String str, String str2) {
        super.L(c0243g0, z4, z5, z6, str, str2);
        this.f4887w0.setText(c0243g0.l());
        Objects.requireNonNull(F());
        this.f4888x0.setVisibility(8);
    }

    @Override // com.android.mmt.ui.MessageListItem
    public void R() {
        super.R();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f4887w0 = (TextView) findViewById(R.id.message_sender);
        this.f4888x0 = (ViewGroup) findViewById(R.id.bubble);
    }

    @Override // com.android.mmt.ui.MessageListItem, x0.C0414a.c
    public final void t(C0414a c0414a) {
        Handler handler = this.f4927E;
        if (handler == null) {
            return;
        }
        handler.post(new MessageListItem.c(c0414a));
    }
}
