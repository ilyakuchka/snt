package Y0;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    private final Map<V0.f, n<?>> f2057a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<V0.f, n<?>> f2058b = new HashMap();

    u() {
    }

    private Map<V0.f, n<?>> b(boolean z4) {
        return z4 ? this.f2058b : this.f2057a;
    }

    final n<?> a(V0.f fVar, boolean z4) {
        return b(z4).get(fVar);
    }

    final void c(V0.f fVar, n<?> nVar) {
        b(nVar.i()).put(fVar, nVar);
    }

    final void d(V0.f fVar, n<?> nVar) {
        Map<V0.f, n<?>> mapB = b(nVar.i());
        if (nVar.equals(mapB.get(fVar))) {
            mapB.remove(fVar);
        }
    }
}
