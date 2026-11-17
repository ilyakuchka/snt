package miuix.slidingwidget.widget;

import m3.AbstractC0350b;

/* loaded from: classes.dex */
final class b implements AbstractC0350b.InterfaceC0118b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f7417a;

    b(Runnable runnable) {
        this.f7417a = runnable;
    }

    @Override // m3.AbstractC0350b.InterfaceC0118b
    public final void a() {
        this.f7417a.run();
    }
}
