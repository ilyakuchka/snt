package c1;

import W0.d;
import c1.n;

/* loaded from: classes.dex */
public final class v<Model> implements n<Model, Model> {

    /* renamed from: a, reason: collision with root package name */
    private static final v<?> f4451a = new v<>();

    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a, reason: collision with root package name */
        private static final a<?> f4452a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> b() {
            return (a<T>) f4452a;
        }

        @Override // c1.o
        public final n<Model, Model> a(r rVar) {
            return v.c();
        }
    }

    private static class b<Model> implements W0.d<Model> {

        /* renamed from: i, reason: collision with root package name */
        private final Model f4453i;

        b(Model model) {
            this.f4453i = model;
        }

        @Override // W0.d
        public final Class<Model> a() {
            return (Class<Model>) this.f4453i.getClass();
        }

        @Override // W0.d
        public final void b() {
        }

        @Override // W0.d
        public final void c(com.bumptech.glide.f fVar, d.a<? super Model> aVar) {
            aVar.f(this.f4453i);
        }

        @Override // W0.d
        public final void cancel() {
        }

        @Override // W0.d
        public final V0.a d() {
            return V0.a.f1747i;
        }
    }

    @Deprecated
    public v() {
    }

    public static <T> v<T> c() {
        return (v<T>) f4451a;
    }

    @Override // c1.n
    public final n.a<Model> a(Model model, int i2, int i4, V0.h hVar) {
        return new n.a<>(new r1.b(model), new b(model));
    }

    @Override // c1.n
    public final boolean b(Model model) {
        return true;
    }
}
