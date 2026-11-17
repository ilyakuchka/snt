package W0;

import W0.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    private static final e.a<?> f1795b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f1796a = new HashMap();

    final class a implements e.a<Object> {
        a() {
        }

        @Override // W0.e.a
        public final Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // W0.e.a
        public final e<Object> b(Object obj) {
            return new b(obj);
        }
    }

    private static final class b implements e<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f1797a;

        b(Object obj) {
            this.f1797a = obj;
        }

        @Override // W0.e
        public final Object a() {
            return this.f1797a;
        }

        @Override // W0.e
        public final void b() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, W0.e$a<?>>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, W0.e$a<?>>] */
    public final synchronized <T> e<T> a(T t2) {
        e.a<?> aVar;
        Objects.requireNonNull(t2, "Argument must not be null");
        aVar = (e.a) this.f1796a.get(t2.getClass());
        if (aVar == null) {
            Iterator it = this.f1796a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> aVar2 = (e.a) it.next();
                if (aVar2.a().isAssignableFrom(t2.getClass())) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f1795b;
        }
        return aVar.b(t2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, W0.e$a<?>>] */
    public final synchronized void b(e.a<?> aVar) {
        this.f1796a.put(aVar.a(), aVar);
    }
}
