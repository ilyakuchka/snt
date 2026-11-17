package l1;

import android.content.Context;
import android.util.Log;
import l1.c;
import w.C0405a;

/* loaded from: classes.dex */
public final class f implements d {
    public final c a(Context context, c.a aVar) {
        boolean z4 = C0405a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z4 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z4 ? new e(context, aVar) : new i();
    }
}
