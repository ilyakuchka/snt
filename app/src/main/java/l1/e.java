package l1;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.util.Objects;
import l1.c;

/* loaded from: classes.dex */
final class e implements c {

    /* renamed from: i, reason: collision with root package name */
    private final Context f6519i;

    /* renamed from: j, reason: collision with root package name */
    final c.a f6520j;

    /* renamed from: k, reason: collision with root package name */
    boolean f6521k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6522l;

    /* renamed from: m, reason: collision with root package name */
    private final BroadcastReceiver f6523m = new a();

    final class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            e eVar = e.this;
            boolean z4 = eVar.f6521k;
            eVar.f6521k = eVar.l(context);
            if (z4 != e.this.f6521k) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    StringBuilder sbD = D2.e.d("connectivity changed, isConnected: ");
                    sbD.append(e.this.f6521k);
                    Log.d("ConnectivityMonitor", sbD.toString());
                }
                e eVar2 = e.this;
                eVar2.f6520j.a(eVar2.f6521k);
            }
        }
    }

    e(Context context, c.a aVar) {
        this.f6519i = context.getApplicationContext();
        this.f6520j = aVar;
    }

    @Override // l1.h
    public final void a() {
        if (this.f6522l) {
            this.f6519i.unregisterReceiver(this.f6523m);
            this.f6522l = false;
        }
    }

    @Override // l1.h
    public final void d() {
        if (this.f6522l) {
            return;
        }
        this.f6521k = l(this.f6519i);
        try {
            this.f6519i.registerReceiver(this.f6523m, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f6522l = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    @Override // l1.h
    public final void e() {
    }

    @SuppressLint({"MissingPermission"})
    final boolean l(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Objects.requireNonNull(connectivityManager, "Argument must not be null");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }
}
