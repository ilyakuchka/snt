package com.android.mmt.ui;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

/* renamed from: com.android.mmt.ui.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0249j0 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ P0.v f5656i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ MessageListItem f5657j;

    DialogInterfaceOnClickListenerC0249j0(MessageListItem messageListItem, P0.v vVar) {
        this.f5657j = messageListItem;
        this.f5656i = vVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        H0.a item = this.f5656i.getItem(i2);
        if (item != null) {
            MessageListItem.e(this.f5657j, item.d, item.f256a, item.f259e);
            Handler handler = this.f5657j.f4927E;
            boolean z4 = item.f259e;
            Message messageObtain = Message.obtain(handler, !item.f260f ? z4 ? 4 : 3 : z4 ? 6 : 7);
            messageObtain.obj = Long.valueOf(item.d);
            messageObtain.arg1 = Integer.valueOf(item.f256a).intValue();
            messageObtain.sendToTarget();
            if (this.f5657j.f4967r0 != null) {
                this.f5657j.f4967r0.dismiss();
                this.f5657j.f4967r0 = null;
            }
        }
    }
}
