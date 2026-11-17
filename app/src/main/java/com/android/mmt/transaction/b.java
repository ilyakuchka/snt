package com.android.mmt.transaction;

import android.util.Log;

/* loaded from: classes.dex */
final class b implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ long f4596i;

    b(long j2) {
        this.f4596i = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (c.class) {
            Log.d("Mms:transaction", "[HttpUtils] abortHttpRequest. tag = " + this.f4596i + " sAlarmTag = " + a.f4592b);
            if (this.f4596i != a.f4592b || a.f4594e == null) {
                Log.d("Mms:transaction", "[HttpUtils] Alarm tags not matching or no req. Ignore!");
            } else {
                try {
                    a.f4594e.disconnect();
                } catch (Exception e2) {
                    Log.w("Mms:transaction", "[HttpUtils] abortHttpRequest: Ex:" + e2);
                }
            }
        }
    }
}
