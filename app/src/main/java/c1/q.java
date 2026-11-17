package c1;

import W0.d;
import c1.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import t.C0384b;

/* loaded from: classes.dex */
final class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n<Model, Data>> f4426a;

    /* renamed from: b, reason: collision with root package name */
    private final E.b<List<Throwable>> f4427b;

    static class a<Data> implements W0.d<Data>, d.a<Data> {

        /* renamed from: i, reason: collision with root package name */
        private final List<W0.d<Data>> f4428i;

        /* renamed from: j, reason: collision with root package name */
        private final E.b<List<Throwable>> f4429j;

        /* renamed from: k, reason: collision with root package name */
        private int f4430k;

        /* renamed from: l, reason: collision with root package name */
        private com.bumptech.glide.f f4431l;

        /* renamed from: m, reason: collision with root package name */
        private d.a<? super Data> f4432m;

        /* renamed from: n, reason: collision with root package name */
        private List<Throwable> f4433n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f4434o;

        a(List<W0.d<Data>> list, E.b<List<Throwable>> bVar) {
            this.f4429j = bVar;
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Must not be empty.");
            }
            this.f4428i = list;
            this.f4430k = 0;
        }

        private void g() {
            if (this.f4434o) {
                return;
            }
            if (this.f4430k < this.f4428i.size() - 1) {
                this.f4430k++;
                c(this.f4431l, this.f4432m);
            } else {
                C0384b.h(this.f4433n);
                this.f4432m.e(new Y0.s("Fetch failed", new ArrayList(this.f4433n)));
            }
        }

        @Override // W0.d
        public final Class<Data> a() {
            return this.f4428i.get(0).a();
        }

        @Override // W0.d
        public final void b() {
            List<Throwable> list = this.f4433n;
            if (list != null) {
                this.f4429j.a(list);
            }
            this.f4433n = null;
            Iterator<W0.d<Data>> it = this.f4428i.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // W0.d
        public final void c(com.bumptech.glide.f fVar, d.a<? super Data> aVar) {
            this.f4431l = fVar;
            this.f4432m = aVar;
            this.f4433n = this.f4429j.b();
            this.f4428i.get(this.f4430k).c(fVar, this);
            if (this.f4434o) {
                cancel();
            }
        }

        @Override // W0.d
        public final void cancel() {
            this.f4434o = true;
            Iterator<W0.d<Data>> it = this.f4428i.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // W0.d
        public final V0.a d() {
            return this.f4428i.get(0).d();
        }

        @Override // W0.d.a
        public final void e(Exception exc) {
            List<Throwable> list = this.f4433n;
            Objects.requireNonNull(list, "Argument must not be null");
            list.add(exc);
            g();
        }

        @Override // W0.d.a
        public final void f(Data data) {
            if (data != null) {
                this.f4432m.f(data);
            } else {
                g();
            }
        }
    }

    q(List<n<Model, Data>> list, E.b<List<Throwable>> bVar) {
        this.f4426a = list;
        this.f4427b = bVar;
    }

    @Override // c1.n
    public final n.a<Data> a(Model model, int i2, int i4, V0.h hVar) {
        n.a<Data> aVarA;
        int size = this.f4426a.size();
        ArrayList arrayList = new ArrayList(size);
        V0.f fVar = null;
        for (int i5 = 0; i5 < size; i5++) {
            n<Model, Data> nVar = this.f4426a.get(i5);
            if (nVar.b(model) && (aVarA = nVar.a(model, i2, i4, hVar)) != null) {
                fVar = aVarA.f4419a;
                arrayList.add(aVarA.f4421c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new n.a<>(fVar, new a(arrayList, this.f4427b));
    }

    @Override // c1.n
    public final boolean b(Model model) {
        Iterator<n<Model, Data>> it = this.f4426a.iterator();
        while (it.hasNext()) {
            if (it.next().b(model)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("MultiModelLoader{modelLoaders=");
        sbD.append(Arrays.toString(this.f4426a.toArray()));
        sbD.append('}');
        return sbD.toString();
    }
}
