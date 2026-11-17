package com.android.mmt.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public class NotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Log.v("NReceiver", "onReceive: intent " + intent);
        intent.getAction().equals("com.android.mmt.transaction.NotificationReceiver.NOTIFICATION_UPDATE");
    }
}
