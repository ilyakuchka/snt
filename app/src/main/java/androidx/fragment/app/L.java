package androidx.fragment.app;

import androidx.fragment.app.N;

/* loaded from: classes.dex */
final class L implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ N.a f3480i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ N f3481j;

    L(N n2, N.a aVar) {
        this.f3481j = n2;
        this.f3480i = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3481j.f3485b.contains(this.f3480i)) {
            P.a(this.f3480i.e(), this.f3480i.f().f3418O);
        }
    }
}
