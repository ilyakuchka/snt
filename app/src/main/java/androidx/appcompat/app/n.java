package androidx.appcompat.app;

import android.view.View;
import t.C0384b;

/* loaded from: classes.dex */
final class n extends C0384b {

    /* renamed from: z, reason: collision with root package name */
    final /* synthetic */ j f2406z;

    n(j jVar) {
        this.f2406z = jVar;
    }

    @Override // androidx.core.view.u
    public final void a() {
        this.f2406z.f2373x.setAlpha(1.0f);
        this.f2406z.f2332A.f(null);
        this.f2406z.f2332A = null;
    }

    @Override // t.C0384b, androidx.core.view.u
    public final void c() {
        this.f2406z.f2373x.setVisibility(0);
        this.f2406z.f2373x.sendAccessibilityEvent(32);
        if (this.f2406z.f2373x.getParent() instanceof View) {
            View view = (View) this.f2406z.f2373x.getParent();
            int i2 = androidx.core.view.o.d;
            view.requestApplyInsets();
        }
    }
}
