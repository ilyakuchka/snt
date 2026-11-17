package com.android.mmt.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import com.android.mmt.util.C0279k;

/* loaded from: classes.dex */
public class MessageListView extends C0279k {

    /* renamed from: j, reason: collision with root package name */
    private boolean f5011j;

    public MessageListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5011j = true;
    }

    @Override // android.view.View
    public final boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        MessageListItem messageListItem;
        C0243g0 c0243g0F;
        if (i2 != 31 || (messageListItem = (MessageListItem) getSelectedView()) == null || (c0243g0F = messageListItem.F()) == null || !c0243g0F.Z()) {
            return super.onKeyShortcut(i2, keyEvent);
        }
        ((ClipboardManager) getContext().getSystemService("clipboard")).setText(c0243g0F.g());
        return true;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected final void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        if (this.f5011j) {
            if (i5 == 0 || i5 == i2) {
                b();
                return;
            }
            Log.v("MessageListView", "oldw is " + i5 + " w is " + i2);
        }
    }
}
