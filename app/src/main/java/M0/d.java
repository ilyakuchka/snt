package M0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    private static d f572c = new d();

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f574b = new a();

    /* renamed from: a, reason: collision with root package name */
    private e f573a = new e();

    final class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Log.d("SyncManager", "provider change.");
        }
    }

    private d() {
    }

    public static d b() {
        return f572c;
    }

    public final void a(c cVar) {
        this.f573a.b(cVar);
    }

    public final void c(Context context) {
        this.f573a.c(context);
        IntentFilter intentFilter = new IntentFilter("android.provider.action.EXTERNAL_PROVIDER_CHANGE");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this.f574b, intentFilter, 4);
        } else {
            context.registerReceiver(this.f574b, intentFilter);
        }
    }

    public final boolean d() {
        return this.f573a.d();
    }

    public final void e(boolean z4) {
        this.f573a.e(z4);
    }

    public final void f(long j2) {
        if (f.b()) {
            j2 = 0;
        }
        this.f573a.f(j2);
    }
}
