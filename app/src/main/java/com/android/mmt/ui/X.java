package com.android.mmt.ui;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
final class X implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ P f5496i;

    X(P p) {
        this.f5496i = p;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        P p = this.f5496i;
        p.q0 = p.f5245Y.f();
        P p4 = this.f5496i;
        p4.f5263s0 = p4.f5245Y.g();
        P p5 = this.f5496i;
        Context context = p5.f5267v0;
        P p6 = this.f5496i;
        p5.p1(context, p6.q0, p6.f5263s0);
        this.f5496i.W0();
    }
}
