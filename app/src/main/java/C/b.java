package C;

import C.j;

/* loaded from: classes.dex */
final class b implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ j.c f19i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ int f20j;

    b(j.c cVar, int i2) {
        this.f19i = cVar;
        this.f20j = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f19i.a(this.f20j);
    }
}
