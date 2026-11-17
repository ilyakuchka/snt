package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f2241b = new CopyOnWriteArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    private boolean f2240a = false;

    final void a(a aVar) {
        this.f2241b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f2240a;
    }

    public final void d() {
        Iterator<a> it = this.f2241b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    final void e(a aVar) {
        this.f2241b.remove(aVar);
    }

    public final void f(boolean z4) {
        this.f2240a = z4;
    }
}
