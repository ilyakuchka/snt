package com.android.mmt.ui;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
final class V implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ P f5493i;

    V(P p) {
        this.f5493i = p;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        P p = this.f5493i;
        p.q0 = p.f5245Y.f();
        P p4 = this.f5493i;
        Context unused = p4.f5267v0;
        p4.o1(this.f5493i.q0);
        this.f5493i.W0();
    }
}
