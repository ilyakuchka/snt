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
import com.android.mmt.ui.ManageSimMessages;
import com.android.mmt.util.C0287t;

/* loaded from: classes.dex */
public class SimFullReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (Settings.Secure.getInt(context.getContentResolver(), "device_provisioned", 0) == 1 && "android.provider.Telephony.SIM_FULL".equals(intent.getAction())) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            int iT = C0287t.t(intent);
            Intent intent2 = new Intent(context, (Class<?>) ManageSimMessages.class);
            intent2.setAction("android.intent.action.VIEW");
            intent2.setFlags(268435456);
            intent2.putExtra("slot_id", iT);
            UserHandle userHandle = C0223a.f4309b;
            PendingIntent pendingIntentC = C0178a.c(context, intent2, userHandle);
            v.g gVar = new v.g(context, O0.d.g().f(2, -1));
            gVar.l(R.drawable.stat_sys_no_sim);
            gVar.o(context.getString(R.string.sim_full_title));
            gVar.g(context.getString(R.string.sim_full_title));
            gVar.f(context.getString(R.string.sim_full_body));
            gVar.e(pendingIntentC);
            gVar.h();
            C0178a.o(notificationManager, 234, gVar.b(), userHandle);
        }
    }
}
