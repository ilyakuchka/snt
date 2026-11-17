package com.android.mmt.ui;

import P0.InterfaceC0165k;
import android.os.Handler;
import com.android.mmt.ui.AnimationAnimationListenerC0231a0;

/* loaded from: classes.dex */
final class M implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ long f4900i = 0;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ float f4901j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ float f4902k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ long f4903l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ InterfaceC0165k f4904m;

    /* renamed from: n, reason: collision with root package name */
    final /* synthetic */ Handler f4905n;

    M(float f4, float f5, long j2, InterfaceC0165k interfaceC0165k, Handler handler) {
        this.f4901j = f4;
        this.f4902k = f5;
        this.f4903l = j2;
        this.f4904m = interfaceC0165k;
        this.f4905n = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float f4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.f4900i;
        if (j2 == 0) {
            f4 = this.f4901j;
        } else {
            float f5 = this.f4902k;
            f4 = (((this.f4901j - f5) * (jCurrentTimeMillis - this.f4903l)) / j2) + f5;
        }
        float f6 = this.f4902k;
        float f7 = this.f4901j;
        if ((f6 > f7 || f4 < f7) && (f6 <= f7 || f4 > f7)) {
            ((AnimationAnimationListenerC0231a0.a) this.f4904m).a(f4);
            this.f4905n.post(this);
            return;
        }
        ((AnimationAnimationListenerC0231a0.a) this.f4904m).a(f7);
        AnimationAnimationListenerC0231a0.a aVar = (AnimationAnimationListenerC0231a0.a) this.f4904m;
        AnimationAnimationListenerC0231a0.this.f5543a.f5237Q.getLayoutParams().height = -2;
        AnimationAnimationListenerC0231a0.this.f5543a.f5237Q.requestLayout();
        AnimationAnimationListenerC0231a0.this.f5543a.f5237Q.getViewTreeObserver().addOnPreDrawListener(new Z(aVar));
    }
}
