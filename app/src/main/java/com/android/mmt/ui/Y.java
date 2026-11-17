package com.android.mmt.ui;

/* loaded from: classes.dex */
final class Y implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f5497i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ P f5498j;

    Y(P p, boolean z4) {
        this.f5498j = p;
        this.f5497i = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5497i) {
            this.f5498j.h1();
        } else {
            this.f5498j.C0();
        }
    }
}
