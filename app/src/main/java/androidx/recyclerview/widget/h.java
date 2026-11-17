package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* loaded from: classes.dex */
final class h extends AnimatorListenerAdapter {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ RecyclerView.x f4170i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ int f4171j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ View f4172k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ int f4173l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f4174m;

    /* renamed from: n, reason: collision with root package name */
    final /* synthetic */ e f4175n;

    h(e eVar, RecyclerView.x xVar, int i2, View view, int i4, ViewPropertyAnimator viewPropertyAnimator) {
        this.f4175n = eVar;
        this.f4170i = xVar;
        this.f4171j = i2;
        this.f4172k = view;
        this.f4173l = i4;
        this.f4174m = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        if (this.f4171j != 0) {
            this.f4172k.setTranslationX(0.0f);
        }
        if (this.f4173l != 0) {
            this.f4172k.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f4174m.setListener(null);
        this.f4175n.c(this.f4170i);
        this.f4175n.p.remove(this.f4170i);
        this.f4175n.s();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f4175n);
    }
}
