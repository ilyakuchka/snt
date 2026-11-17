package androidx.fragment.app;

import androidx.fragment.app.N;

/* loaded from: classes.dex */
final class M implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ N.a f3482i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ N f3483j;

    M(N n2, N.a aVar) {
        this.f3483j = n2;
        this.f3482i = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3483j.f3485b.remove(this.f3482i);
        this.f3483j.f3486c.remove(this.f3482i);
    }
}
