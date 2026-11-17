package P2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private List<b> f968a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b, reason: collision with root package name */
    private b f969b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Activity> f970c;

    /* renamed from: P2.a$a, reason: collision with other inner class name */
    final class C0029a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Application f971i;

        C0029a(Application application) {
            this.f971i = application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (a.this.f970c == null || a.this.f970c.get() != activity) {
                return;
            }
            this.f971i.unregisterActivityLifecycleCallbacks(this);
            if (a.this.f969b != null) {
                a.this.f969b.a().a();
                a.this.f969b = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            if (a.this.f970c == null || a.this.f970c.get() != activity) {
                return;
            }
            a.this.e();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            if (a.this.f970c == null || a.this.f970c.get() != activity) {
                return;
            }
            a.this.f();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    public interface b {
        c a();
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    public a(Activity activity) {
        this.f970c = new WeakReference<>(activity);
        Application application = activity.getApplication();
        application.registerActivityLifecycleCallbacks(new C0029a(application));
    }

    public final void d() {
        this.f968a.clear();
    }

    public final void e() {
        b bVar = this.f969b;
        if (bVar != null) {
            bVar.a().c();
        }
    }

    public final void f() {
        b bVar = this.f969b;
        if (bVar != null) {
            bVar.a().b();
        }
    }
}
