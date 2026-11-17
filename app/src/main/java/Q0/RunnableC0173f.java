package Q0;

import Q0.C0170c;
import android.view.ActionMode;
import java.util.ArrayList;

/* renamed from: Q0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0173f implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ActionMode f1104i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ C0170c.d f1105j;

    RunnableC0173f(C0170c.d dVar, ActionMode actionMode) {
        this.f1105j = dVar;
        this.f1104i = actionMode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1105j.d.S()) {
            C0170c.this.n1().h().r(new ArrayList(this.f1105j.d.Q()));
        } else {
            C0170c.this.n1().h().q(new ArrayList(this.f1105j.d.Q()), 0);
        }
        S2.e.a().post(new RunnableC0172e(this.f1104i, 0));
    }
}
