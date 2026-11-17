package com.android.mmt;

import O0.r;
import P0.G;
import P0.t;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.drm.DrmManagerClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.MessageQueue;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;
import androidx.preference.g;
import com.android.mmt.transaction.SmsReceiverService;
import com.android.mmt.transaction.TransactionService;
import com.android.mmt.ui.MmsTabActivity;
import com.android.mmt.util.A;
import com.android.mmt.util.BackgroundCleaner;
import com.android.mmt.util.C;
import com.android.mmt.util.C0275g;
import com.android.mmt.util.C0278j;
import com.android.mmt.util.C0287t;
import com.android.mmt.util.H;
import com.android.mmt.util.O;
import java.util.Objects;
import k0.C0340a;
import t0.C0385a;
import x0.C0414a;
import x0.C0416c;

/* loaded from: classes.dex */
public class MmsApp extends Application {

    /* renamed from: q, reason: collision with root package name */
    private static MmsApp f4461q;

    /* renamed from: r, reason: collision with root package name */
    private static long f4462r;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f4463s;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f4464t;

    /* renamed from: i, reason: collision with root package name */
    private DrmManagerClient f4465i;

    /* renamed from: j, reason: collision with root package name */
    private Configuration f4466j;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4468l;

    /* renamed from: k, reason: collision with root package name */
    private Object f4467k = new Object();

    /* renamed from: m, reason: collision with root package name */
    private Runnable f4469m = new a();

    /* renamed from: n, reason: collision with root package name */
    private Runnable f4470n = new b();

    /* renamed from: o, reason: collision with root package name */
    MessageQueue.IdleHandler f4471o = new c();
    private ContentObserver p = new d();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmsApp.f4463s = false;
            if (C0275g.a()) {
                MmsApp.f4463s = g.c(MmsApp.c()).getBoolean("pref_key_use_gsm_alphabet", true);
            }
            O0.f.j().p();
            MmsApp.this.getContentResolver().registerContentObserver(C0385a.c.f7899a, true, MmsApp.this.p);
        }
    }

    final class b implements Runnable {

        final class a implements Runnable {

            /* renamed from: com.android.mmt.MmsApp$b$a$a, reason: collision with other inner class name */
            final class RunnableC0087a implements Runnable {
                RunnableC0087a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MmsApp.this.startService(new Intent(MmsApp.c(), (Class<?>) TransactionService.class));
                }
            }

            /* renamed from: com.android.mmt.MmsApp$b$a$b, reason: collision with other inner class name */
            final class RunnableC0088b implements Runnable {
                RunnableC0088b() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    C0287t.K(MmsApp.c(), Integer.MAX_VALUE);
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public final void run() throws SecurityException, IllegalArgumentException {
                boolean zMoveToFirst;
                Process.setThreadPriority(10);
                SharedPreferences sharedPreferencesC = g.c(MmsApp.c());
                if (sharedPreferencesC.getLong("url_check_time", 0L) == 0) {
                    sharedPreferencesC.edit().putLong("url_check_time", System.currentTimeMillis()).apply();
                }
                boolean z4 = MmsApp.f4463s;
                if (C0287t.d() > 0) {
                    if (TransactionService.T()) {
                        Log.v("Mms", "retry startService when app start");
                        S2.e.a().post(new RunnableC0087a());
                    }
                    int i2 = SmsReceiverService.f4519q;
                    Cursor cursorE = O.e(MmsApp.c(), MmsApp.c().getContentResolver(), Uri.parse("content://sms/queued"), new String[]{"_id"}, "address is not null AND address!=''", null, null);
                    if (cursorE != null) {
                        try {
                            zMoveToFirst = cursorE.moveToFirst();
                        } finally {
                            cursorE.close();
                        }
                    } else {
                        zMoveToFirst = false;
                    }
                    if (zMoveToFirst) {
                        Log.v("Mms", "retry sms service when app start");
                        S2.e.a().post(new RunnableC0088b());
                    }
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Q2.c.a(new a());
            S2.a.a().addIdleHandler(MmsApp.this.f4471o);
            r.b().c();
        }
    }

    final class c implements MessageQueue.IdleHandler {
        c() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            MmsApp mmsApp = MmsApp.f4461q;
            if (C.f5843a < 0) {
                String packageName = mmsApp.getPackageName();
                try {
                    C.f5843a = mmsApp.getPackageManager().getPackageInfo(packageName, 0).getLongVersionCode();
                    String str = mmsApp.getPackageManager().getPackageInfo(packageName, 0).versionName;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            C.f(mmsApp, "key_app_version_code", C.f5843a);
            return false;
        }
    }

    final class d extends ContentObserver {
        d() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z4, Uri uri) {
            super.onChange(z4, uri);
            if (uri == null || !uri.toString().startsWith(C0385a.c.f7899a.toString())) {
                return;
            }
            C0416c.N();
        }
    }

    final class e extends ContentObserver {
        e() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z4, Uri uri) {
            super.onChange(z4, uri);
            if (uri == null || !uri.toString().startsWith(H0.b.f261a.toString())) {
                return;
            }
            synchronized (H0.b.a()) {
            }
        }
    }

    private class f implements Application.ActivityLifecycleCallbacks {
        f() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            A.j(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (activity instanceof MmsTabActivity) {
                return;
            }
            MmsApp.f4464t = false;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            if (activity instanceof MmsTabActivity) {
                MmsApp.f4464t = false;
            }
        }
    }

    public MmsApp() {
        new e();
        f4462r = System.currentTimeMillis();
        C0.c cVar = new C0.c();
        C0.a.e(cVar);
        C0.a.f(cVar);
    }

    public static synchronized Application c() {
        return f4461q;
    }

    public static DrmManagerClient d() {
        MmsApp mmsApp = f4461q;
        if (mmsApp.f4465i == null) {
            mmsApp.f4465i = new DrmManagerClient(c().getApplicationContext());
        }
        return f4461q.f4465i;
    }

    public static long e() {
        return f4462r;
    }

    public static boolean f() {
        boolean z4;
        synchronized (f4461q.f4467k) {
            z4 = f4461q.f4468l;
        }
        return z4;
    }

    public static void g(boolean z4) {
        synchronized (f4461q.f4467k) {
            f4461q.f4468l = z4;
        }
    }

    @Override // android.content.ContextWrapper
    protected final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        f4461q = this;
        new C0340a(c());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        F0.b.d(configuration);
        if (G.d()) {
            G.b().f();
        }
        if (this.f4466j == null) {
            this.f4466j = new Configuration(configuration);
        }
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        f4464t = true;
        if (true ^ ((UserManager) getSystemService("user")).isUserUnlocked()) {
            return;
        }
        K0.b bVarA = K0.b.a();
        Application applicationC = c();
        K0.a aVar = new K0.a();
        aVar.b(C.d(c()));
        bVarA.d(applicationC, aVar.a());
        C0414a.g0(this);
        C0278j.e(this);
        H.c(this);
        registerActivityLifecycleCallbacks(new f());
        ((androidx.lifecycle.r) androidx.lifecycle.r.j()).a().a(BackgroundCleaner.j());
        S2.e.a().postDelayed(this.f4469m, 500L);
        S2.e.a().postDelayed(this.f4470n, 2500L);
        Q2.c.a(new com.android.mmt.a(this));
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        Objects.requireNonNull(t.d());
    }

    @Override // android.app.Application
    public final void onTerminate() {
        com.android.mmt.transaction.d.C();
        r.b().d();
        getContentResolver().unregisterContentObserver(this.p);
        ((androidx.lifecycle.r) androidx.lifecycle.r.j()).a().c(BackgroundCleaner.j());
        super.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (i2 == 20) {
            com.bumptech.glide.c.c(this).b();
        }
    }

    @Override // android.app.Application
    public final void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks.getClass().getName().startsWith("com.google.android.gms.measurement")) {
            return;
        }
        super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
