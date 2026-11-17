package com.android.mmt.ui;

import android.view.View;

/* renamed from: com.android.mmt.ui.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC0234c implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f5551i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ C0230a f5552j;

    ViewOnClickListenerC0234c(C0230a c0230a, int i2) {
        this.f5552j = c0230a;
        this.f5551i = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f5552j.C(this.f5551i);
    }
}
