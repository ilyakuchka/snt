package com.android.mmt.ui;

import android.view.View;
import x0.C0414a;

/* loaded from: classes.dex */
final class v0 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ NewMessageActivity f5764i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ C0414a f5765j;

    v0(NewMessageActivity newMessageActivity, C0414a c0414a) {
        this.f5764i = newMessageActivity;
        this.f5765j = c0414a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NewMessageActivity.X1(this.f5764i, this.f5765j);
        this.f5764i.u2();
    }
}
