package J0;

import android.annotation.SuppressLint;
import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Looper;
import com.android.mmt.MmsApp;
import o0.C0363f;
import u0.C0391c;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    String f278a;

    /* renamed from: b, reason: collision with root package name */
    protected Bundle f279b = new Bundle();

    public a(String str) {
        this.f278a = null;
        this.f278a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(boolean z4) {
        boolean z5;
        if (!z4) {
            Application applicationC = MmsApp.c();
            synchronized (C0363f.class) {
                ConnectivityManager connectivityManager = (ConnectivityManager) applicationC.getSystemService("connectivity");
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null) {
                    z5 = networkCapabilities.hasTransport(1);
                }
            }
            if (!z5) {
                return;
            }
        }
        C0391c.d(this.f278a, this.f279b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b() {
        if (this.f279b.keySet() != null && !this.f279b.keySet().isEmpty() && Thread.currentThread() != Looper.getMainLooper().getThread()) {
        }
    }

    public final void d(String str, int i2) {
        this.f279b.putInt(str, i2);
    }

    public final String toString() {
        return String.valueOf(this.f279b);
    }
}
