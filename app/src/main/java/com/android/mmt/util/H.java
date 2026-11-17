package com.android.mmt.util;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.provider.Telephony;
import android.util.Log;
import t.C0384b;

/* loaded from: classes.dex */
public final class H {
    private static H d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f5894e;

    /* renamed from: a, reason: collision with root package name */
    private final Context f5895a;

    /* renamed from: b, reason: collision with root package name */
    private int f5896b;

    /* renamed from: c, reason: collision with root package name */
    private final BroadcastReceiver f5897c = new a();

    final class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("com.android.mmt.RATE_LIMIT_CONFIRMED".equals(intent.getAction())) {
                synchronized (this) {
                    H.this.f5896b = intent.getBooleanExtra("answer", false) ? 1 : 2;
                    notifyAll();
                }
            }
        }
    }

    private H(Context context) {
        this.f5895a = context;
    }

    public static H b() {
        H h2 = d;
        if (h2 != null) {
            return h2;
        }
        throw new IllegalStateException("Uninitialized.");
    }

    public static void c(Context context) {
        if (d != null) {
            Log.w("RateController", "Already initialized.");
        }
        d = new H(context.getApplicationContext());
    }

    public final synchronized boolean d() {
        int i2;
        while (f5894e) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
        f5894e = true;
        C0384b.t(this.f5895a, this.f5897c, new IntentFilter("com.android.mmt.RATE_LIMIT_CONFIRMED"));
        this.f5896b = 0;
        try {
            Intent intent = new Intent("com.android.mmt.RATE_LIMIT_SURPASSED");
            intent.addFlags(268435456);
            this.f5895a.startActivity(intent);
            synchronized (this) {
                int i4 = 0;
                while (true) {
                    i2 = this.f5896b;
                    if (i2 != 0 || i4 >= 20000) {
                        break;
                    }
                    try {
                        wait(1000L);
                    } catch (InterruptedException unused2) {
                    }
                    i4 += 1000;
                }
            }
            return i2 == 1;
        } finally {
            this.f5895a.unregisterReceiver(this.f5897c);
            f5894e = false;
            notifyAll();
        }
        return i2 == 1;
    }

    public final boolean e() {
        long jCurrentTimeMillis = System.currentTimeMillis() - 3600000;
        Context context = this.f5895a;
        Cursor cursorE = O.e(context, context.getContentResolver(), Telephony.Mms.Rate.CONTENT_URI, new String[]{"COUNT(*) AS rate"}, "sent_time>" + jCurrentTimeMillis, null, null);
        if (cursorE != null) {
            try {
                if (cursorE.moveToFirst()) {
                    return cursorE.getInt(0) >= 100;
                }
            } finally {
                cursorE.close();
            }
        }
        return false;
    }

    public final void f() {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("sent_time", Long.valueOf(System.currentTimeMillis()));
        Context context = this.f5895a;
        O.d(context, context.getContentResolver(), Telephony.Mms.Rate.CONTENT_URI, contentValues);
    }
}
