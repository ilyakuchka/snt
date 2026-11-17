package androidx.fragment.app;

import java.util.ArrayList;

/* renamed from: androidx.fragment.app.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0214j implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ArrayList f3539i;

    RunnableC0214j(ArrayList arrayList) {
        this.f3539i = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        F.c(this.f3539i, 4);
    }
}
