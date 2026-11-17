package com.android.mmt.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class MessageStatusReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("com.android.mmt.transaction.MessageStatusReceiver.MESSAGE_STATUS_RECEIVED".equals(intent.getAction())) {
            intent.setClass(context, MessageStatusService.class);
            context.startService(intent);
        }
    }
}
