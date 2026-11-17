package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<View> f3321a;

    final class a extends AnimatorListenerAdapter {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ u f3322i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ View f3323j;

        a(u uVar, View view) {
            this.f3322i = uVar;
            this.f3323j = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f3322i.b(this.f3323j);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            this.f3322i.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            this.f3322i.c();
        }
    }

    final class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ v f3324i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ View f3325j;

        b(v vVar, View view) {
            this.f3324i = vVar;
            this.f3325j = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3324i.a();
        }
    }

    t(View view) {
        this.f3321a = new WeakReference<>(view);
    }

    private void g(View view, u uVar) {
        if (uVar != null) {
            view.animate().setListener(new a(uVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public final t a(float f4) {
        View view = this.f3321a.get();
        if (view != null) {
            view.animate().alpha(f4);
        }
        return this;
    }

    public final void b() {
        View view = this.f3321a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final long c() {
        View view = this.f3321a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public final t d(long j2) {
        View view = this.f3321a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public final t e(Interpolator interpolator) {
        View view = this.f3321a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public final t f(u uVar) {
        View view = this.f3321a.get();
        if (view != null) {
            g(view, uVar);
        }
        return this;
    }

    public final t h(long j2) {
        View view = this.f3321a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public final t i(v vVar) {
        View view = this.f3321a.get();
        if (view != null) {
            view.animate().setUpdateListener(vVar != null ? new b(vVar, view) : null);
        }
        return this;
    }

    public final void j() {
        View view = this.f3321a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final t k(float f4) {
        View view = this.f3321a.get();
        if (view != null) {
            view.animate().translationY(f4);
        }
        return this;
    }
}
