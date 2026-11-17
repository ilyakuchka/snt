package Z2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
final class c<T> implements Collection<T> {

    /* renamed from: i, reason: collision with root package name */
    private final T[] f2181i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f2182j;

    public c(T[] tArr, boolean z4) {
        f3.c.d(tArr, "values");
        this.f2181i = tArr;
        this.f2182j = z4;
    }

    @Override // java.util.Collection
    public final boolean add(T t2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        int i2;
        T[] tArr = this.f2181i;
        f3.c.d(tArr, "<this>");
        if (obj == null) {
            int length = tArr.length;
            i2 = 0;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    break;
                }
                i2++;
            }
            i2 = -1;
        } else {
            int length2 = tArr.length;
            for (int i4 = 0; i4 < length2; i4++) {
                if (f3.c.a(obj, tArr[i4])) {
                    i2 = i4;
                    break;
                }
            }
            i2 = -1;
        }
        return i2 >= 0;
    }

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

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f2181i.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return f3.c.f(this.f2181i);
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
    public final int size() {
        return this.f2181i.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        T[] tArr = this.f2181i;
        boolean z4 = this.f2182j;
        f3.c.d(tArr, "<this>");
        if (z4 && f3.c.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        f3.c.c(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        f3.c.d(tArr, "array");
        return (T[]) f3.b.b(this, tArr);
    }
}
