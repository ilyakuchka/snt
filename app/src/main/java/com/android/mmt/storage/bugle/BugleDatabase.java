package com.android.mmt.storage.bugle;

import L0.d;
import R.h;
import R.i;
import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class BugleDatabase extends i {

    /* renamed from: n, reason: collision with root package name */
    private static Context f4500n;

    /* renamed from: o, reason: collision with root package name */
    private static volatile boolean f4501o;
    private static BugleDatabase p;

    /* renamed from: m, reason: collision with root package name */
    private static Object f4499m = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static final S.a f4502q = new a();

    /* renamed from: r, reason: collision with root package name */
    private static i.b f4503r = new b();

    final class a extends S.a {
        a() {
        }

        @Override // S.a
        public final void a() {
        }
    }

    final class b extends i.b {
        b() {
        }

        @Override // R.i.b
        public final void a() {
            Log.d("BugleDatabase", "onCreate");
        }
    }

    public static BugleDatabase y() {
        synchronized (f4499m) {
            if (!f4501o) {
                i.a aVarA = h.a(f4500n);
                aVarA.a(f4503r);
                aVarA.b(f4502q);
                aVarA.c();
                p = (BugleDatabase) aVarA.d();
                f4501o = true;
            }
        }
        return p;
    }

    public static void z(Context context) {
        f4500n = context.getApplicationContext();
    }

    public abstract d x();
}
