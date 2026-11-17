package h3;

import java.util.Iterator;

/* renamed from: h3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0332a<T> implements c<T>, b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f6324a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6325b;

    /* renamed from: h3.a$a, reason: collision with other inner class name */
    public static final class C0112a implements Iterator<T> {

        /* renamed from: i, reason: collision with root package name */
        private final Iterator<T> f6326i;

        /* renamed from: j, reason: collision with root package name */
        private int f6327j;

        C0112a(C0332a<T> c0332a) {
            this.f6326i = ((C0332a) c0332a).f6324a.iterator();
            this.f6327j = ((C0332a) c0332a).f6325b;
        }

        private final void a() {
            while (this.f6327j > 0 && this.f6326i.hasNext()) {
                this.f6326i.next();
                this.f6327j--;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            a();
            return this.f6326i.hasNext();
        }

        @Override // java.util.Iterator
        public final T next() {
            a();
            return this.f6326i.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0332a(c<? extends T> cVar, int i2) {
        f3.c.d(cVar, "sequence");
        this.f6324a = cVar;
        this.f6325b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // h3.b
    public final c<T> a(int i2) {
        int i4 = this.f6325b + i2;
        return i4 < 0 ? new C0332a(this, i2) : new C0332a(this.f6324a, i4);
    }

    @Override // h3.c
    public final Iterator<T> iterator() {
        return new C0112a(this);
    }
}
