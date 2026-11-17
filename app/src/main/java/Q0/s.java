package Q0;

import Q0.q;
import android.view.ActionMode;

/* loaded from: classes.dex */
final class s implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ActionMode f1169i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ q.i f1170j;

    s(q.i iVar, ActionMode actionMode) {
        this.f1170j = iVar;
        this.f1169i = actionMode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q.i.e(this.f1170j);
        S2.e.a().post(new RunnableC0172e(this.f1169i, 1));
    }
}
