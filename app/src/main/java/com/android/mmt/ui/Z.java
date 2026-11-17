package com.android.mmt.ui;

import android.view.ViewTreeObserver;
import com.android.mmt.ui.AnimationAnimationListenerC0231a0;

/* loaded from: classes.dex */
final class Z implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ AnimationAnimationListenerC0231a0.a f5499i;

    Z(AnimationAnimationListenerC0231a0.a aVar) {
        this.f5499i = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        AnimationAnimationListenerC0231a0.this.f5543a.R0();
        AnimationAnimationListenerC0231a0.this.f5543a.f5237Q.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
