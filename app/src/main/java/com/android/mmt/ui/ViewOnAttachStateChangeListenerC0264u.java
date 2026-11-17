package com.android.mmt.ui;

import android.view.View;

/* renamed from: com.android.mmt.ui.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnAttachStateChangeListenerC0264u implements View.OnAttachStateChangeListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ r f5761i;

    ViewOnAttachStateChangeListenerC0264u(r rVar) {
        this.f5761i = rVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f5761i.f5694P0.getViewTreeObserver().removeOnGlobalLayoutListener(this.f5761i.v1);
    }
}
