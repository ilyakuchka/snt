package com.android.mmt.util;

import android.annotation.TargetApi;
import android.os.PowerManager;
import android.util.Log;
import com.android.mmt.MmsApp;

/* loaded from: classes.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    private static PowerManager f5892a;

    /* renamed from: b, reason: collision with root package name */
    private static PowerManager.WakeLock f5893b;

    @TargetApi(21)
    private static void a() {
        if (f5892a == null) {
            f5892a = (PowerManager) MmsApp.c().getSystemService("power");
        }
        if (f5892a.isWakeLockLevelSupported(32) && f5893b == null) {
            f5893b = f5892a.newWakeLock(32, "G");
        }
    }

    public static void b() {
        a();
        PowerManager.WakeLock wakeLock = f5893b;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                Log.i("G", "Proximity wake lock already acquired");
            } else {
                Log.i("G", "Acquiring proximity wake lock");
                f5893b.acquire();
            }
        }
    }

    @TargetApi(21)
    public static void c() {
        a();
        PowerManager.WakeLock wakeLock = f5893b;
        if (wakeLock != null) {
            if (!wakeLock.isHeld()) {
                Log.i("G", "Proximity wake lock already released");
            } else {
                Log.i("G", "Releasing proximity wake lock");
                f5893b.release(1);
            }
        }
    }
}
