package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* loaded from: classes.dex */
public final class n implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: i, reason: collision with root package name */
    private final View f3310i;

    /* renamed from: j, reason: collision with root package name */
    private ViewTreeObserver f3311j;

    /* renamed from: k, reason: collision with root package name */
    private final Runnable f3312k;

    private n(View view, Runnable runnable) {
        this.f3310i = view;
        this.f3311j = view.getViewTreeObserver();
        this.f3312k = runnable;
    }

    public static n a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        n nVar = new n(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(nVar);
        view.addOnAttachStateChangeListener(nVar);
        return nVar;
    }

    public final void b() {
        if (this.f3311j.isAlive()) {
            this.f3311j.removeOnPreDrawListener(this);
        } else {
            this.f3310i.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f3310i.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        b();
        this.f3312k.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f3311j = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        b();
    }
}
