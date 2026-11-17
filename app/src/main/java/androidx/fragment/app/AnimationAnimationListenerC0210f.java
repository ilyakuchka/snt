package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.C0207c;

/* renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class AnimationAnimationListenerC0210f implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup f3525a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f3526b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0207c.b f3527c;

    /* renamed from: androidx.fragment.app.f$a */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnimationAnimationListenerC0210f animationAnimationListenerC0210f = AnimationAnimationListenerC0210f.this;
            animationAnimationListenerC0210f.f3525a.endViewTransition(animationAnimationListenerC0210f.f3526b);
            AnimationAnimationListenerC0210f.this.f3527c.a();
        }
    }

    AnimationAnimationListenerC0210f(ViewGroup viewGroup, View view, C0207c.b bVar) {
        this.f3525a = viewGroup;
        this.f3526b = view;
        this.f3527c = bVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f3525a.post(new a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
