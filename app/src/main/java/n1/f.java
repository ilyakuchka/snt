package n1;

import V0.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?>> f7490a = new ArrayList();

    private static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f7491a;

        /* renamed from: b, reason: collision with root package name */
        final k<T> f7492b;

        a(Class<T> cls, k<T> kVar) {
            this.f7491a = cls;
            this.f7492b = kVar;
        }

        final boolean a(Class<?> cls) {
            return this.f7491a.isAssignableFrom(cls);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<n1.f$a<?>>] */
    public final synchronized <Z> void a(Class<Z> cls, k<Z> kVar) {
        this.f7490a.add(new a(cls, kVar));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<n1.f$a<?>>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList, java.util.List<n1.f$a<?>>] */
    public final synchronized <Z> k<Z> b(Class<Z> cls) {
        int size = this.f7490a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.f7490a.get(i2);
            if (aVar.a(cls)) {
                return (k<Z>) aVar.f7492b;
            }
        }
        return null;
    }
}
