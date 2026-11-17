package Q0;

import Q0.C0170c;
import java.util.ArrayList;
import x0.C0416c;

/* renamed from: Q0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0171d implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ C0170c.d f1101i;

    RunnableC0171d(C0170c.d dVar) {
        this.f1101i = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0416c.h0(C0170c.this.f1139n0, this.f1101i.d.S() ? C0170c.this.n1().h().z(new ArrayList(this.f1101i.d.Q())) : new ArrayList<>(this.f1101i.d.Q()));
    }
}
