package androidx.fragment.app;

import androidx.fragment.app.N;
import q.C0365a;

/* renamed from: androidx.fragment.app.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0212h implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ N.b f3532i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ N.b f3533j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ boolean f3534k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ C0365a f3535l;

    RunnableC0212h(N.b bVar, N.b bVar2, boolean z4, C0365a c0365a) {
        this.f3532i = bVar;
        this.f3533j = bVar2;
        this.f3534k = z4;
        this.f3535l = c0365a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        F.a(this.f3532i.f(), this.f3533j.f(), this.f3534k);
    }
}
