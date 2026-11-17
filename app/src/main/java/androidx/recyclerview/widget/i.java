package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e;
import java.util.Objects;

/* loaded from: classes.dex */
final class i extends AnimatorListenerAdapter {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ e.d f4176i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f4177j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ View f4178k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ e f4179l;

    i(e eVar, e.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f4179l = eVar;
        this.f4176i = dVar;
        this.f4177j = viewPropertyAnimator;
        this.f4178k = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f4177j.setListener(null);
        this.f4178k.setAlpha(1.0f);
        this.f4178k.setTranslationX(0.0f);
        this.f4178k.setTranslationY(0.0f);
        this.f4179l.c(this.f4176i.f4153a);
        this.f4179l.f4146r.remove(this.f4176i.f4153a);
        this.f4179l.s();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        e eVar = this.f4179l;
        RecyclerView.x xVar = this.f4176i.f4153a;
        Objects.requireNonNull(eVar);
    }
}
