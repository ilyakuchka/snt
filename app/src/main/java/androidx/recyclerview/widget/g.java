package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* loaded from: classes.dex */
final class g extends AnimatorListenerAdapter {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ RecyclerView.x f4166i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ View f4167j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f4168k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ e f4169l;

    g(e eVar, RecyclerView.x xVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f4169l = eVar;
        this.f4166i = xVar;
        this.f4167j = view;
        this.f4168k = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f4167j.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f4168k.setListener(null);
        this.f4169l.c(this.f4166i);
        this.f4169l.f4144o.remove(this.f4166i);
        this.f4169l.s();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f4169l);
    }
}
