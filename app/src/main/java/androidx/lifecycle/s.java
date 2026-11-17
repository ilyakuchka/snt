package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: classes.dex */
final class s extends d {
    final /* synthetic */ r this$0;

    final class a extends d {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            s.this.this$0.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            s.this.this$0.f();
        }
    }

    s(r rVar) {
        this.this$0 = rVar;
    }

    @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.this$0.b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks(new a());
    }

    @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.this$0.g();
    }
}
