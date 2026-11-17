package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0207c;
import androidx.fragment.app.N;

/* renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0208d extends AnimatorListenerAdapter {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ViewGroup f3519i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ View f3520j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ boolean f3521k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ N.b f3522l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ C0207c.b f3523m;

    C0208d(ViewGroup viewGroup, View view, boolean z4, N.b bVar, C0207c.b bVar2) {
        this.f3519i = viewGroup;
        this.f3520j = view;
        this.f3521k = z4;
        this.f3522l = bVar;
        this.f3523m = bVar2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f3519i.endViewTransition(this.f3520j);
        if (this.f3521k) {
            P.a(this.f3522l.e(), this.f3520j);
        }
        this.f3523m.a();
    }
}
