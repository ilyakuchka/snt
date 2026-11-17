package P3;

import L3.D;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final Set<D> f1045a = new LinkedHashSet();

    public final synchronized void a(D d) {
        f3.c.d(d, "route");
        this.f1045a.remove(d);
    }

    public final synchronized void b(D d) {
        f3.c.d(d, "failedRoute");
        this.f1045a.add(d);
    }

    public final synchronized boolean c(D d) {
        return this.f1045a.contains(d);
    }
}
