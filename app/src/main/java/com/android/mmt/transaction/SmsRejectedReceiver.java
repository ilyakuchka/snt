package com.android.mmt.transaction;

import a.C0178a;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.provider.Settings;
import b.C0223a;
import com.android.mmt.R;
import com.android.mmt.ui.MmsTabActivity;

/* loaded from: classes.dex */
public class SmsRejectedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i2;
        int i4;
        if (Settings.Secure.getInt(context.getContentResolver(), "device_provisioned", 0) == 1 && "android.provider.Telephony.SMS_REJECTED".equals(intent.getAction())) {
            boolean z4 = intent.getIntExtra("result", -1) == 3;
            if (z4) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                Intent intent2 = new Intent(context, (Class<?>) MmsTabActivity.class);
                intent2.setFlags(603979776);
                intent2.setAction("android.intent.action.VIEW");
                intent2.setFlags(872415232);
                UserHandle userHandle = C0223a.f4309b;
                PendingIntent pendingIntentC = C0178a.c(context, intent2, userHandle);
                v.g gVar = new v.g(context, O0.d.g().f(3, -1));
                gVar.l(R.drawable.stat_sys_no_sim);
                if (z4) {
                    i2 = R.string.sms_full_title;
                    i4 = R.string.sms_full_body;
                } else {
                    i2 = R.string.sms_rejected_title;
                    i4 = R.string.sms_rejected_body;
                }
                gVar.o(context.getString(i2));
                gVar.g(context.getString(i2));
                gVar.f(context.getString(i4));
                gVar.e(pendingIntentC);
                gVar.h();
                C0178a.o(notificationManager, 239, gVar.b(), userHandle);
            }
        }
    }
}
