package Z2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class b<E> extends Z2.a<E> implements List<E> {

    private class a implements Iterator<E> {

        /* renamed from: i, reason: collision with root package name */
        private int f2175i;

        public a() {
        }

        protected final int a() {
            return this.f2175i;
        }

        protected final void b(int i2) {
            this.f2175i = i2;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f2175i < b.this.d();
        }

        @Override // java.util.Iterator
        public final E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b<E> bVar = b.this;
            int i2 = this.f2175i;
            this.f2175i = i2 + 1;
            return bVar.get(i2);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: Z2.b$b, reason: collision with other inner class name */
    private class C0051b extends b<E>.a implements ListIterator<E> {
        public C0051b(int i2) {
            super();
            int iD = b.this.d();
            if (i2 >= 0 && i2 <= iD) {
                b(i2);
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + iD);
        }

        @Override // java.util.ListIterator
        public final void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public final E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            b<E> bVar = b.this;
            b(a() - 1);
            return bVar.get(a());
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public final void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private static final class c<E> extends b<E> implements RandomAccess {

        /* renamed from: i, reason: collision with root package name */
        private final b<E> f2178i;

        /* renamed from: j, reason: collision with root package name */
        private final int f2179j;

        /* renamed from: k, reason: collision with root package name */
        private int f2180k;

        /* JADX WARN: Multi-variable type inference failed */
        public c(b<? extends E> bVar, int i2, int i4) {
            f3.c.d(bVar, "list");
            this.f2178i = bVar;
            this.f2179j = i2;
            int iD = bVar.d();
            if (i2 < 0 || i4 > iD) {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i4 + ", size: " + iD);
            }
            if (i2 <= i4) {
                this.f2180k = i4 - i2;
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i4);
        }

        @Override // Z2.a
        public final int d() {
            return this.f2180k;
        }

        @Override // Z2.b, java.util.List
        public final E get(int i2) {
            int i4 = this.f2180k;
            if (i2 >= 0 && i2 < i4) {
                return this.f2178i.get(this.f2179j + i2);
            }
            throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i4);
        }
    }

    protected b() {
    }

    @Override // java.util.List
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        f3.c.d(collection, "other");
        if (size() == collection.size()) {
            Iterator<E> it = collection.iterator();
            Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!f3.c.a(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    public abstract E get(int i2);

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            E next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    public int indexOf(E e2) {
        Iterator<E> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (f3.c.a(it.next(), e2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return new a();
    }

    public int lastIndexOf(E e2) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (f3.c.a(listIterator.previous(), e2)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator() {
        return new C0051b(0);
    }

    @Override // java.util.List
    public final E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<E> subList(int i2, int i4) {
        return new c(this, i2, i4);
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator(int i2) {
        return new C0051b(i2);
    }
}
