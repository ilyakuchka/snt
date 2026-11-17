package c1;

import c1.n;
import com.bumptech.glide.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: e, reason: collision with root package name */
    private static final c f4435e = new c();

    /* renamed from: f, reason: collision with root package name */
    private static final n<Object, Object> f4436f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<b<?, ?>> f4437a;

    /* renamed from: b, reason: collision with root package name */
    private final c f4438b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<b<?, ?>> f4439c;
    private final E.b<List<Throwable>> d;

    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // c1.n
        public final n.a<Object> a(Object obj, int i2, int i4, V0.h hVar) {
            return null;
        }

        @Override // c1.n
        public final boolean b(Object obj) {
            return false;
        }
    }

    private static class b<Model, Data> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Model> f4440a;

        /* renamed from: b, reason: collision with root package name */
        final Class<Data> f4441b;

        /* renamed from: c, reason: collision with root package name */
        final o<? extends Model, ? extends Data> f4442c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f4440a = cls;
            this.f4441b = cls2;
            this.f4442c = oVar;
        }

        public final boolean a(Class<?> cls) {
            return this.f4440a.isAssignableFrom(cls);
        }
    }

    static class c {
        c() {
        }
    }

    public r(E.b<List<Throwable>> bVar) {
        c cVar = f4435e;
        this.f4437a = new ArrayList();
        this.f4439c = new HashSet();
        this.d = bVar;
        this.f4438b = cVar;
    }

    private <Model, Data> n<Model, Data> b(b<?, ?> bVar) {
        n<Model, Data> nVar = (n<Model, Data>) bVar.f4442c.a(this);
        Objects.requireNonNull(nVar, "Argument must not be null");
        return nVar;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<c1.r$b<?, ?>>] */
    final synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        b bVar = new b(cls, cls2, oVar);
        ?? r2 = this.f4437a;
        r2.add(r2.size(), bVar);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<c1.r$b<?, ?>>] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.HashSet, java.util.Set<c1.r$b<?, ?>>] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.HashSet, java.util.Set<c1.r$b<?, ?>>] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.HashSet, java.util.Set<c1.r$b<?, ?>>] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.HashSet, java.util.Set<c1.r$b<?, ?>>] */
    public final synchronized <Model, Data> n<Model, Data> c(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f4437a.iterator();
            boolean z4 = false;
            while (it.hasNext()) {
                b<?, ?> bVar = (b) it.next();
                if (this.f4439c.contains(bVar)) {
                    z4 = true;
                } else {
                    if (bVar.a(cls) && bVar.f4441b.isAssignableFrom(cls2)) {
                        this.f4439c.add(bVar);
                        arrayList.add(b(bVar));
                        this.f4439c.remove(bVar);
                    }
                }
            }
            if (arrayList.size() > 1) {
                c cVar = this.f4438b;
                E.b<List<Throwable>> bVar2 = this.d;
                Objects.requireNonNull(cVar);
                return new q(arrayList, bVar2);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (z4) {
                return (n<Model, Data>) f4436f;
            }
            throw new g.c((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th) {
            this.f4439c.clear();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<c1.r$b<?, ?>>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<c1.r$b<?, ?>>] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.HashSet, java.util.Set<c1.r$b<?, ?>>] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.HashSet, java.util.Set<c1.r$b<?, ?>>] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.HashSet, java.util.Set<c1.r$b<?, ?>>] */
    final synchronized <Model> List<n<Model, ?>> d(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.f4437a.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!this.f4439c.contains(bVar) && bVar.a(cls)) {
                    this.f4439c.add(bVar);
                    n nVarA = bVar.f4442c.a(this);
                    Objects.requireNonNull(nVarA, "Argument must not be null");
                    arrayList.add(nVarA);
                    this.f4439c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f4439c.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<c1.r$b<?, ?>>] */
    final synchronized List<Class<?>> e(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f4437a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (!arrayList.contains(bVar.f4441b) && bVar.a(cls)) {
                arrayList.add(bVar.f4441b);
            }
        }
        return arrayList;
    }
}
