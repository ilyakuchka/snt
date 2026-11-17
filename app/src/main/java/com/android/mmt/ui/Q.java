package com.android.mmt.ui;

/* loaded from: classes.dex */
final class Q implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ miuix.appcompat.app.g f5326i;

    Q(miuix.appcompat.app.g gVar) {
        this.f5326i = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        miuix.appcompat.app.g gVar = this.f5326i;
        if (gVar != null) {
            gVar.show();
        }
    }
}
