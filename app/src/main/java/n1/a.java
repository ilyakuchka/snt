package n1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final List<C0129a<?>> f7476a = new ArrayList();

    /* renamed from: n1.a$a, reason: collision with other inner class name */
    private static final class C0129a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f7477a;

        /* renamed from: b, reason: collision with root package name */
        final V0.d<T> f7478b;

        C0129a(Class<T> cls, V0.d<T> dVar) {
            this.f7477a = cls;
            this.f7478b = dVar;
        }

        final boolean a(Class<?> cls) {
            return this.f7477a.isAssignableFrom(cls);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<n1.a$a<?>>] */
    public final synchronized <T> void a(Class<T> cls, V0.d<T> dVar) {
        this.f7476a.add(new C0129a(cls, dVar));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<n1.a$a<?>>] */
    public final synchronized <T> V0.d<T> b(Class<T> cls) {
        Iterator it = this.f7476a.iterator();
        while (it.hasNext()) {
            C0129a c0129a = (C0129a) it.next();
            if (c0129a.a(cls)) {
                return c0129a.f7478b;
            }
        }
        return null;
    }
}
