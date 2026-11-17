package com.bumptech.glide;

import V0.k;
import W0.e;
import Y0.v;
import Y0.x;
import c1.n;
import c1.o;
import c1.p;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final p f6098a;

    /* renamed from: b, reason: collision with root package name */
    private final n1.a f6099b;

    /* renamed from: c, reason: collision with root package name */
    private final n1.e f6100c;
    private final n1.f d;

    /* renamed from: e, reason: collision with root package name */
    private final W0.f f6101e;

    /* renamed from: f, reason: collision with root package name */
    private final k1.e f6102f;
    private final n1.b g;

    /* renamed from: h, reason: collision with root package name */
    private final n1.d f6103h = new n1.d();

    /* renamed from: i, reason: collision with root package name */
    private final n1.c f6104i = new n1.c();

    /* renamed from: j, reason: collision with root package name */
    private final E.b<List<Throwable>> f6105j;

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public g() {
        E.b<List<Throwable>> bVarB = t1.a.b();
        this.f6105j = bVarB;
        this.f6098a = new p(bVarB);
        this.f6099b = new n1.a();
        n1.e eVar = new n1.e();
        this.f6100c = eVar;
        this.d = new n1.f();
        this.f6101e = new W0.f();
        this.f6102f = new k1.e();
        this.g = new n1.b();
        List listAsList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(listAsList.size());
        arrayList.addAll(listAsList);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        eVar.e(arrayList);
    }

    public final <Data> g a(Class<Data> cls, V0.d<Data> dVar) {
        this.f6099b.a(cls, dVar);
        return this;
    }

    public final <TResource> g b(Class<TResource> cls, k<TResource> kVar) {
        this.d.a(cls, kVar);
        return this;
    }

    public final <Data, TResource> g c(Class<Data> cls, Class<TResource> cls2, V0.j<Data, TResource> jVar) {
        e("legacy_append", cls, cls2, jVar);
        return this;
    }

    public final <Model, Data> g d(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f6098a.a(cls, cls2, oVar);
        return this;
    }

    public final <Data, TResource> g e(String str, Class<Data> cls, Class<TResource> cls2, V0.j<Data, TResource> jVar) {
        this.f6100c.a(str, jVar, cls, cls2);
        return this;
    }

    public final List<ImageHeaderParser> f() {
        ArrayList arrayList = (ArrayList) this.g.b();
        if (arrayList.isEmpty()) {
            throw new b();
        }
        return arrayList;
    }

    public final <Data, TResource, Transcode> v<Data, TResource, Transcode> g(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        v<Data, TResource, Transcode> vVarA = this.f6104i.a(cls, cls2, cls3);
        if (this.f6104i.b(vVarA)) {
            return null;
        }
        if (vVarA == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((ArrayList) this.f6100c.d(cls, cls2)).iterator();
            while (it.hasNext()) {
                Class cls4 = (Class) it.next();
                Iterator it2 = ((ArrayList) this.f6102f.b(cls4, cls3)).iterator();
                while (it2.hasNext()) {
                    Class cls5 = (Class) it2.next();
                    arrayList.add(new Y0.k(cls, cls4, cls5, this.f6100c.b(cls, cls4), this.f6102f.a(cls4, cls5), this.f6105j));
                }
            }
            vVarA = arrayList.isEmpty() ? null : new v<>(cls, cls2, cls3, arrayList, this.f6105j);
            this.f6104i.c(cls, cls2, cls3, vVarA);
        }
        return vVarA;
    }

    public final <Model> List<n<Model, ?>> h(Model model) {
        return this.f6098a.c(model);
    }

    public final <Model, TResource, Transcode> List<Class<?>> i(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> listA = this.f6103h.a(cls, cls2, cls3);
        List<Class<?>> list = listA;
        if (listA == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((ArrayList) this.f6098a.b(cls)).iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) this.f6100c.d((Class) it.next(), cls2)).iterator();
                while (it2.hasNext()) {
                    Class cls4 = (Class) it2.next();
                    if (!((ArrayList) this.f6102f.b(cls4, cls3)).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            this.f6103h.b(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            list = arrayList;
        }
        return list;
    }

    public final <X> k<X> j(x<X> xVar) throws d {
        k<X> kVarB = this.d.b(xVar.c());
        if (kVarB != null) {
            return kVarB;
        }
        throw new d(xVar.c());
    }

    public final <X> W0.e<X> k(X x2) {
        return this.f6101e.a(x2);
    }

    public final <X> V0.d<X> l(X x2) throws e {
        V0.d<X> dVarB = this.f6099b.b(x2.getClass());
        if (dVarB != null) {
            return dVarB;
        }
        throw new e(x2.getClass());
    }

    public final boolean m(x<?> xVar) {
        return this.d.b(xVar.c()) != null;
    }

    public final g n(e.a<?> aVar) {
        this.f6101e.b(aVar);
        return this;
    }

    public final g o(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public final <TResource, Transcode> g p(Class<TResource> cls, Class<Transcode> cls2, k1.d<TResource, Transcode> dVar) {
        this.f6102f.c(cls, cls2, dVar);
        return this;
    }

    public static class c extends a {
        /* JADX WARN: Illegal instructions before constructor call */
        public c(Object obj) {
            StringBuilder sbD = D2.e.d("Failed to find any ModelLoaders registered for model class: ");
            sbD.append(obj.getClass());
            super(sbD.toString());
        }

        public <M> c(M m2, List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }
}
