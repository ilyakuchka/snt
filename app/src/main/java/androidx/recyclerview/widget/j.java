package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e;
import java.util.Objects;

/* loaded from: classes.dex */
final class j extends AnimatorListenerAdapter {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ e.d f4180i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f4181j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ View f4182k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ e f4183l;

    j(e eVar, e.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f4183l = eVar;
        this.f4180i = dVar;
        this.f4181j = viewPropertyAnimator;
        this.f4182k = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f4181j.setListener(null);
        this.f4182k.setAlpha(1.0f);
        this.f4182k.setTranslationX(0.0f);
        this.f4182k.setTranslationY(0.0f);
        this.f4183l.c(this.f4180i.f4154b);
        this.f4183l.f4146r.remove(this.f4180i.f4154b);
        this.f4183l.s();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        e eVar = this.f4183l;
        RecyclerView.x xVar = this.f4180i.f4154b;
        Objects.requireNonNull(eVar);
    }
}
