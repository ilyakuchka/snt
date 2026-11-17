package Q0;

import Q0.q;

/* loaded from: classes.dex */
final class t implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ q.i f1171i;

    t(q.i iVar) {
        this.f1171i = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q.i iVar = this.f1171i;
        q.this.n1().h().A();
        iVar.f1153e = 0;
    }
}
