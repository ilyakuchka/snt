package h3;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class e<T, R> implements c<R> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f6329a;

    /* renamed from: b, reason: collision with root package name */
    private final e3.b<T, R> f6330b;

    public static final class a implements Iterator<R> {

        /* renamed from: i, reason: collision with root package name */
        private final Iterator<T> f6331i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ e<T, R> f6332j;

        a(e<T, R> eVar) {
            this.f6332j = eVar;
            this.f6331i = ((e) eVar).f6329a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f6331i.hasNext();
        }

        @Override // java.util.Iterator
        public final R next() {
            return (R) ((e) this.f6332j).f6330b.c(this.f6331i.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(c<? extends T> cVar, e3.b<? super T, ? extends R> bVar) {
        this.f6329a = cVar;
        this.f6330b = bVar;
    }

    @Override // h3.c
    public final Iterator<R> iterator() {
        return new a(this);
    }
}
