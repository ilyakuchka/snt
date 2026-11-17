package com.android.mmt.util;

import O2.a;
import android.content.Context;
import android.os.Vibrator;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private static final long[] f5957a = {0, 250, 250, 250};

    /* renamed from: b, reason: collision with root package name */
    private static Vibrator f5958b;

    public static void a() {
        Vibrator vibrator = f5958b;
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    public static void b(Context context) {
        if (f5958b == null) {
            f5958b = (Vibrator) context.getSystemService("vibrator");
        }
        if (a.b()) {
            f5958b.vibrate(f5957a, -1);
        }
    }
}
