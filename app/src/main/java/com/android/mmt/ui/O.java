package com.android.mmt.ui;

import android.view.View;

/* loaded from: classes.dex */
final class O implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ P f5199i;

    O(P p) {
        this.f5199i = p;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        P p = this.f5199i;
        if (p.I0(p.f5235N)) {
            this.f5199i.f5235N.requestFocus();
            this.f5199i.f5235N.setSelection(0);
            this.f5199i.h1();
        }
    }
}
