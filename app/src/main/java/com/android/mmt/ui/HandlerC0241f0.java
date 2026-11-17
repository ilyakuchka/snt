package com.android.mmt.ui;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.android.mmt.ui.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class HandlerC0241f0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f5560a;

    HandlerC0241f0(P p) {
        this.f5560a = p;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f5560a.f5252f0.w(message);
    }
}
