package com.android.mmt.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import com.android.mmt.util.C0270b;

/* loaded from: classes.dex */
public class SmsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    static final Object f4515a = new Object();

    /* renamed from: b, reason: collision with root package name */
    static PowerManager.WakeLock f4516b;

    /* renamed from: c, reason: collision with root package name */
    private static SmsReceiver f4517c;

    public static SmsReceiver a() {
        if (f4517c == null) {
            f4517c = new SmsReceiver();
        }
        return f4517c;
    }

    protected final void b(Context context, Intent intent, boolean z4) {
        if (z4 || !"android.provider.Telephony.SMS_DELIVER".equals(intent.getAction())) {
            Uri data = intent.getData();
            if (data != null) {
                W2.a.a("SmsReceiver", "sms ack received, uri: " + data + ", result: " + getResultCode());
            }
            intent.setClass(context, SmsReceiverService.class);
            intent.putExtra("result", getResultCode());
            synchronized (f4515a) {
                if (f4516b == null) {
                    PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "Mms:StartingAlertService");
                    f4516b = wakeLockNewWakeLock;
                    wakeLockNewWakeLock.setReferenceCounted(false);
                }
                f4516b.acquire();
                C0270b.b(context, intent);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b(context, intent, false);
    }
}
