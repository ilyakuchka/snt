package Y0;

import Y0.j;
import Y0.m;
import c1.n;
import com.bumptech.glide.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class i<Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n.a<?>> f1927a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<V0.f> f1928b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.e f1929c;
    private Object d;

    /* renamed from: e, reason: collision with root package name */
    private int f1930e;

    /* renamed from: f, reason: collision with root package name */
    private int f1931f;
    private Class<?> g;

    /* renamed from: h, reason: collision with root package name */
    private j.d f1932h;

    /* renamed from: i, reason: collision with root package name */
    private V0.h f1933i;

    /* renamed from: j, reason: collision with root package name */
    private Map<Class<?>, V0.l<?>> f1934j;

    /* renamed from: k, reason: collision with root package name */
    private Class<Transcode> f1935k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1936l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1937m;

    /* renamed from: n, reason: collision with root package name */
    private V0.f f1938n;

    /* renamed from: o, reason: collision with root package name */
    private com.bumptech.glide.f f1939o;
    private l p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1940q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1941r;

    i() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<c1.n$a<?>>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<V0.f>] */
    final void a() {
        this.f1929c = null;
        this.d = null;
        this.f1938n = null;
        this.g = null;
        this.f1935k = null;
        this.f1933i = null;
        this.f1939o = null;
        this.f1934j = null;
        this.p = null;
        this.f1927a.clear();
        this.f1936l = false;
        this.f1928b.clear();
        this.f1937m = false;
    }

    final Z0.b b() {
        return this.f1929c.b();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<V0.f>] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.ArrayList, java.util.List<V0.f>] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList, java.util.List<V0.f>] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList, java.util.List<V0.f>] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.ArrayList, java.util.List<V0.f>] */
    final List<V0.f> c() {
        if (!this.f1937m) {
            this.f1937m = true;
            this.f1928b.clear();
            ArrayList arrayList = (ArrayList) g();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a aVar = (n.a) arrayList.get(i2);
                if (!this.f1928b.contains(aVar.f4419a)) {
                    this.f1928b.add(aVar.f4419a);
                }
                for (int i4 = 0; i4 < aVar.f4420b.size(); i4++) {
                    if (!this.f1928b.contains(aVar.f4420b.get(i4))) {
                        this.f1928b.add(aVar.f4420b.get(i4));
                    }
                }
            }
        }
        return this.f1928b;
    }

    final a1.a d() {
        return ((m.c) this.f1932h).a();
    }

    final l e() {
        return this.p;
    }

    final int f() {
        return this.f1931f;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<c1.n$a<?>>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.ArrayList, java.util.List<c1.n$a<?>>] */
    final List<n.a<?>> g() {
        if (!this.f1936l) {
            this.f1936l = true;
            this.f1927a.clear();
            List listH = this.f1929c.h().h(this.d);
            int size = listH.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a aVarA = ((c1.n) listH.get(i2)).a(this.d, this.f1930e, this.f1931f, this.f1933i);
                if (aVarA != null) {
                    this.f1927a.add(aVarA);
                }
            }
        }
        return this.f1927a;
    }

    final <Data> v<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f1929c.h().g(cls, this.g, this.f1935k);
    }

    final Class<?> i() {
        return this.d.getClass();
    }

    final List<c1.n<File, ?>> j(File file) throws g.c {
        return this.f1929c.h().h(file);
    }

    final V0.h k() {
        return this.f1933i;
    }

    final com.bumptech.glide.f l() {
        return this.f1939o;
    }

    final List<Class<?>> m() {
        return this.f1929c.h().i(this.d.getClass(), this.g, this.f1935k);
    }

    final <Z> V0.k<Z> n(x<Z> xVar) {
        return this.f1929c.h().j(xVar);
    }

    final V0.f o() {
        return this.f1938n;
    }

    final <X> V0.d<X> p(X x2) throws g.e {
        return this.f1929c.h().l(x2);
    }

    final Class<?> q() {
        return this.f1935k;
    }

    final <Z> V0.l<Z> r(Class<Z> cls) {
        V0.l<Z> lVar = (V0.l) this.f1934j.get(cls);
        if (lVar == null) {
            Iterator<Map.Entry<Class<?>, V0.l<?>>> it = this.f1934j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, V0.l<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    lVar = (V0.l) next.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f1934j.isEmpty() || !this.f1940q) {
            return e1.b.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    final int s() {
        return this.f1930e;
    }

    final boolean t(Class<?> cls) {
        return this.f1929c.h().g(cls, this.g, this.f1935k) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final <R> void u(com.bumptech.glide.e eVar, Object obj, V0.f fVar, int i2, int i4, l lVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, V0.h hVar, Map<Class<?>, V0.l<?>> map, boolean z4, boolean z5, j.d dVar) {
        this.f1929c = eVar;
        this.d = obj;
        this.f1938n = fVar;
        this.f1930e = i2;
        this.f1931f = i4;
        this.p = lVar;
        this.g = cls;
        this.f1932h = dVar;
        this.f1935k = cls2;
        this.f1939o = fVar2;
        this.f1933i = hVar;
        this.f1934j = map;
        this.f1940q = z4;
        this.f1941r = z5;
    }

    final boolean v(x<?> xVar) {
        return this.f1929c.h().m(xVar);
    }

    final boolean w() {
        return this.f1941r;
    }
}
