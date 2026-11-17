package k1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f6443a = new ArrayList();

    private static final class a<Z, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Z> f6444a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<R> f6445b;

        /* renamed from: c, reason: collision with root package name */
        final d<Z, R> f6446c;

        a(Class<Z> cls, Class<R> cls2, d<Z, R> dVar) {
            this.f6444a = cls;
            this.f6445b = cls2;
            this.f6446c = dVar;
        }

        public final boolean a(Class<?> cls, Class<?> cls2) {
            return this.f6444a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f6445b);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<k1.e$a<?, ?>>] */
    public final synchronized <Z, R> d<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return f.a();
        }
        Iterator it = this.f6443a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.a(cls, cls2)) {
                return aVar.f6446c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<k1.e$a<?, ?>>] */
    public final synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator it = this.f6443a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<k1.e$a<?, ?>>] */
    public final synchronized <Z, R> void c(Class<Z> cls, Class<R> cls2, d<Z, R> dVar) {
        this.f6443a.add(new a(cls, cls2, dVar));
    }
}
