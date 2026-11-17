package com.android.mmt.ui;

import android.view.View;

/* loaded from: classes.dex */
final class s0 implements View.OnFocusChangeListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ NewMessageActivity f5758i;

    s0(NewMessageActivity newMessageActivity) {
        this.f5758i = newMessageActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z4) {
        NewMessageActivity.b2(this.f5758i, z4);
        this.f5758i.n2(z4);
    }
}
