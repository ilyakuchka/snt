package com.android.mmt.ui;

import P0.InterfaceC0165k;
import android.os.Handler;
import android.view.animation.Animation;

/* renamed from: com.android.mmt.ui.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class AnimationAnimationListenerC0231a0 implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f5543a;

    /* renamed from: com.android.mmt.ui.a0$a */
    final class a implements InterfaceC0165k {
        a() {
        }

        public final void a(float f4) {
            AnimationAnimationListenerC0231a0.this.f5543a.f5237Q.getLayoutParams().height = (int) f4;
            AnimationAnimationListenerC0231a0.this.f5543a.f5237Q.requestLayout();
        }
    }

    AnimationAnimationListenerC0231a0(P p) {
        this.f5543a = p;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int height = this.f5543a.f5237Q.getHeight();
        this.f5543a.Y0();
        this.f5543a.f5237Q.getLayoutParams().height = height;
        float f4 = this.f5543a.f5268w;
        a aVar = new a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Handler handler = new Handler();
        handler.post(new M(f4, height, jCurrentTimeMillis, aVar, handler));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
