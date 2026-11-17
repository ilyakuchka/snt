package com.android.mmt.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.android.mmt.util.C0287t;

/* renamed from: com.android.mmt.ui.m0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC0255m0 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0243g0 f5673i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ MessageListItem f5674j;

    ViewOnClickListenerC0255m0(MessageListItem messageListItem, C0243g0 c0243g0) {
        this.f5674j = messageListItem;
        this.f5673i = c0243g0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Handler handler = this.f5674j.f4927E;
        if (handler != null) {
            Message messageObtain = Message.obtain(handler, 5);
            messageObtain.obj = Long.valueOf(this.f5673i.z());
            messageObtain.arg1 = Integer.valueOf(C0287t.q(this.f5673i.E())).intValue();
            messageObtain.sendToTarget();
        }
    }
}
