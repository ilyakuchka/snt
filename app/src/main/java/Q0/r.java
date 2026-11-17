package Q0;

import Q0.q;
import java.util.ArrayList;
import x0.C0416c;

/* loaded from: classes.dex */
final class r implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ q.i f1168i;

    r(q.i iVar) {
        this.f1168i = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0416c.h0(q.this.f1139n0, this.f1168i.d.S() ? q.this.n1().h().z(new ArrayList(this.f1168i.d.Q())) : new ArrayList<>(this.f1168i.d.Q()));
    }
}
