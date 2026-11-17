package c1;

import com.bumptech.glide.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final r f4422a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4423b;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C0086a<?>> f4424a = new HashMap();

        /* renamed from: c1.p$a$a, reason: collision with other inner class name */
        private static class C0086a<Model> {

            /* renamed from: a, reason: collision with root package name */
            final List<n<Model, ?>> f4425a;

            public C0086a(List<n<Model, ?>> list) {
                this.f4425a = list;
            }
        }

        a() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, c1.p$a$a<?>>] */
        public final void a() {
            this.f4424a.clear();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, c1.p$a$a<?>>] */
        public final <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0086a c0086a = (C0086a) this.f4424a.get(cls);
            if (c0086a == null) {
                return null;
            }
            return c0086a.f4425a;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.HashMap, java.util.Map<java.lang.Class<?>, c1.p$a$a<?>>] */
        public final <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (((C0086a) this.f4424a.put(cls, new C0086a(list))) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(E.b<List<Throwable>> bVar) {
        r rVar = new r(bVar);
        this.f4423b = new a();
        this.f4422a = rVar;
    }

    public final synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f4422a.a(cls, cls2, oVar);
        this.f4423b.a();
    }

    public final synchronized List<Class<?>> b(Class<?> cls) {
        return this.f4422a.e(cls);
    }

    public final <A> List<n<A, ?>> c(A a2) {
        List listB;
        Class<?> cls = a2.getClass();
        synchronized (this) {
            listB = this.f4423b.b(cls);
            if (listB == null) {
                listB = Collections.unmodifiableList(this.f4422a.d(cls));
                this.f4423b.c(cls, listB);
            }
        }
        if (listB.isEmpty()) {
            throw new g.c(a2);
        }
        int size = listB.size();
        List<n<A, ?>> listEmptyList = Collections.emptyList();
        boolean z4 = true;
        for (int i2 = 0; i2 < size; i2++) {
            n<A, ?> nVar = (n) listB.get(i2);
            if (nVar.b(a2)) {
                if (z4) {
                    listEmptyList = new ArrayList<>(size - i2);
                    z4 = false;
                }
                listEmptyList.add(nVar);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new g.c(a2, (List<n<A, ?>>) listB);
        }
        return listEmptyList;
    }
}
