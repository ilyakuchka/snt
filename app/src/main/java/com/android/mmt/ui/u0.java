package com.android.mmt.ui;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
final class u0 implements View.OnTouchListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ NewMessageActivity f5762i;

    u0(NewMessageActivity newMessageActivity) {
        this.f5762i = newMessageActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        NewMessageActivity.A1(this.f5762i);
        return false;
    }
}
