package com.android.mmt.util;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.android.mmt.util.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0270b {
    public static void a(Service service) {
        if (service == null) {
            return;
        }
        service.startForeground(114, new v.g(service.getBaseContext(), O0.d.g().f(2, -1)).b());
    }

    public static void b(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        boolean z4 = false;
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.uid == context.getApplicationInfo().uid) {
                    if (next.importance == 100) {
                        z4 = true;
                    }
                }
            }
        }
        if (!z4) {
            c(context, intent);
            return;
        }
        try {
            context.startService(intent);
        } catch (Exception e2) {
            Log.d("AdaptO", "startService: ", e2);
            c(context, intent);
        }
    }

    public static void c(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        StringBuilder sbD = D2.e.d("start from background: ");
        sbD.append(intent.getAction());
        sbD.append("|");
        sbD.append(intent.getComponent() != null ? intent.getComponent().getClassName() : "null");
        Log.d("AdaptO", sbD.toString());
        context.startForegroundService(intent);
    }
}
