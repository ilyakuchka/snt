package q;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
abstract class d<T> implements Iterator<T> {

    /* renamed from: i, reason: collision with root package name */
    private int f7615i;

    /* renamed from: j, reason: collision with root package name */
    private int f7616j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7617k;

    d(int i2) {
        this.f7615i = i2;
    }

    protected abstract T a(int i2);

    protected abstract void b(int i2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7616j < this.f7615i;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T tA = a(this.f7616j);
        this.f7616j++;
        this.f7617k = true;
        return tA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f7617k) {
            throw new IllegalStateException();
        }
        int i2 = this.f7616j - 1;
        this.f7616j = i2;
        b(i2);
        this.f7615i--;
        this.f7617k = false;
    }
}
