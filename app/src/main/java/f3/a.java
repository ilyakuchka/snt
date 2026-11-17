package f3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class a<T> implements Iterator<T> {

    /* renamed from: i, reason: collision with root package name */
    private final T[] f6240i;

    /* renamed from: j, reason: collision with root package name */
    private int f6241j;

    public a(T[] tArr) {
        c.d(tArr, "array");
        this.f6240i = tArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6241j < this.f6240i.length;
    }

    @Override // java.util.Iterator
    public final T next() {
        try {
            T[] tArr = this.f6240i;
            int i2 = this.f6241j;
            this.f6241j = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f6241j--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
