package Z2;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class a<E> implements Collection<E> {

    /* renamed from: Z2.a$a, reason: collision with other inner class name */
    static final class C0050a extends f3.d implements e3.b<E, CharSequence> {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ a<E> f2174i;

        /* JADX WARN: Multi-variable type inference failed */
        C0050a(a<? extends E> aVar) {
            this.f2174i = aVar;
        }

        @Override // e3.b
        public final CharSequence c(Object obj) {
            return obj == this.f2174i ? "(this Collection)" : String.valueOf(obj);
        }
    }

    protected a() {
    }

    @Override // java.util.Collection
    public final boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean contains(E e2) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (f3.c.a(it.next(), e2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        f3.c.d(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract int d();

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return d() == 0;
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return f3.b.a(this);
    }

    public final String toString() throws IOException {
        C0050a c0050a = new C0050a(this);
        StringBuilder sb = new StringBuilder();
        k.a(this, sb, ", ", "[", "]", -1, "...", c0050a);
        String string = sb.toString();
        f3.c.c(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        f3.c.d(tArr, "array");
        return (T[]) f3.b.b(this, tArr);
    }
}
