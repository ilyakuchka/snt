package com.android.mmt.ui;

import android.os.Message;
import android.view.View;
import com.android.mmt.util.C0287t;
import java.util.Objects;

/* renamed from: com.android.mmt.ui.o0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC0259o0 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0243g0 f5683i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ MessageListItem f5684j;

    ViewOnClickListenerC0259o0(MessageListItem messageListItem, C0243g0 c0243g0) {
        this.f5684j = messageListItem;
        this.f5683i = c0243g0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5684j.f4927E == null || C0287t.e() <= 0) {
            return;
        }
        boolean Z4 = this.f5683i.Z();
        long jZ = this.f5683i.z();
        MessageListItem messageListItem = this.f5684j;
        Objects.requireNonNull(this.f5683i);
        Objects.requireNonNull(messageListItem);
        if (C0287t.y()) {
            MessageListItem.d(this.f5684j, view, jZ, Z4);
            return;
        }
        int iF = C0287t.f();
        if (C0287t.q(this.f5683i.E()) < 0) {
            MessageListItem.e(this.f5684j, jZ, iF, Z4);
        }
        Message messageObtain = Message.obtain(this.f5684j.f4927E, Z4 ? 4 : 3);
        messageObtain.obj = Long.valueOf(jZ);
        messageObtain.arg1 = Integer.valueOf(iF).intValue();
        messageObtain.sendToTarget();
    }
}
