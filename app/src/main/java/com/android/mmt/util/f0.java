package com.android.mmt.util;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class f0<T> extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<T> f5973a;

    public f0(T t2) {
        this.f5973a = new WeakReference<>(t2);
    }

    public abstract void a(T t2, Message message);

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        T t2 = this.f5973a.get();
        if (t2 != null) {
            a(t2, message);
        }
    }
}
