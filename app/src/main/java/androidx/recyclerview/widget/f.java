package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* loaded from: classes.dex */
final class f extends AnimatorListenerAdapter {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ RecyclerView.x f4162i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f4163j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ View f4164k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ e f4165l;

    f(e eVar, RecyclerView.x xVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f4165l = eVar;
        this.f4162i = xVar;
        this.f4163j = viewPropertyAnimator;
        this.f4164k = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f4163j.setListener(null);
        this.f4164k.setAlpha(1.0f);
        this.f4165l.c(this.f4162i);
        this.f4165l.f4145q.remove(this.f4162i);
        this.f4165l.s();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f4165l);
    }
}
