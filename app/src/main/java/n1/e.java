package n1;

import V0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f7485a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f7486b = new HashMap();

    private static class a<T, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f7487a;

        /* renamed from: b, reason: collision with root package name */
        final Class<R> f7488b;

        /* renamed from: c, reason: collision with root package name */
        final j<T, R> f7489c;

        public a(Class<T> cls, Class<R> cls2, j<T, R> jVar) {
            this.f7487a = cls;
            this.f7488b = cls2;
            this.f7489c = jVar;
        }

        public final boolean a(Class<?> cls, Class<?> cls2) {
            return this.f7487a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f7488b);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.HashMap, java.util.Map<java.lang.String, java.util.List<n1.e$a<?, ?>>>] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.util.List<n1.e$a<?, ?>>>] */
    private synchronized List<a<?, ?>> c(String str) {
        List<a<?, ?>> arrayList;
        if (!this.f7485a.contains(str)) {
            this.f7485a.add(str);
        }
        arrayList = (List) this.f7486b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f7486b.put(str, arrayList);
        }
        return arrayList;
    }

    public final synchronized <T, R> void a(String str, j<T, R> jVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, jVar));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.util.List<n1.e$a<?, ?>>>] */
    public final synchronized <T, R> List<j<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f7485a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.f7486b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f7489c);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.util.List<n1.e$a<?, ?>>>] */
    public final synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f7485a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.f7486b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f7488b)) {
                        arrayList.add(aVar.f7488b);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    public final synchronized void e(List<String> list) {
        ArrayList arrayList = new ArrayList(this.f7485a);
        this.f7485a.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f7485a.add(it.next());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (!list.contains(str)) {
                this.f7485a.add(str);
            }
        }
    }
}
