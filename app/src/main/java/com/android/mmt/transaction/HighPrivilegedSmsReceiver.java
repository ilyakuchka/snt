package com.android.mmt.transaction;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class HighPrivilegedSmsReceiver extends SmsReceiver {
    @Override // com.android.mmt.transaction.SmsReceiver, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        b(context, intent, true);
    }
}
