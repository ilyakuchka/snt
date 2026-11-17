package q;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* renamed from: q.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0366b<E> implements Collection<E>, Set<E> {

    /* renamed from: l, reason: collision with root package name */
    private static Object[] f7604l;

    /* renamed from: m, reason: collision with root package name */
    private static int f7605m;

    /* renamed from: n, reason: collision with root package name */
    private static Object[] f7606n;

    /* renamed from: o, reason: collision with root package name */
    private static int f7607o;
    private static final Object p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static final Object f7608q = new Object();

    /* renamed from: i, reason: collision with root package name */
    private int[] f7609i;

    /* renamed from: j, reason: collision with root package name */
    Object[] f7610j;

    /* renamed from: k, reason: collision with root package name */
    int f7611k;

    /* renamed from: q.b$a */
    private class a extends d<E> {
        a() {
            super(C0366b.this.f7611k);
        }

        @Override // q.d
        protected final E a(int i2) {
            return (E) C0366b.this.f7610j[i2];
        }

        @Override // q.d
        protected final void b(int i2) {
            C0366b.this.k(i2);
        }
    }

    public C0366b(int i2) {
        if (i2 == 0) {
            this.f7609i = c.f7613a;
            this.f7610j = c.f7614b;
        } else {
            d(i2);
        }
        this.f7611k = 0;
    }

    private void d(int i2) {
        if (i2 == 8) {
            synchronized (f7608q) {
                Object[] objArr = f7606n;
                if (objArr != null) {
                    try {
                        this.f7610j = objArr;
                        f7606n = (Object[]) objArr[0];
                        int[] iArr = (int[]) objArr[1];
                        this.f7609i = iArr;
                        if (iArr != null) {
                            objArr[1] = null;
                            objArr[0] = null;
                            f7607o--;
                            return;
                        }
                    } catch (ClassCastException unused) {
                    }
                    System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr[0] + " [1]=" + objArr[1]);
                    f7606n = null;
                    f7607o = 0;
                }
            }
        } else if (i2 == 4) {
            synchronized (p) {
                Object[] objArr2 = f7604l;
                if (objArr2 != null) {
                    try {
                        this.f7610j = objArr2;
                        f7604l = (Object[]) objArr2[0];
                        int[] iArr2 = (int[]) objArr2[1];
                        this.f7609i = iArr2;
                        if (iArr2 != null) {
                            objArr2[1] = null;
                            objArr2[0] = null;
                            f7605m--;
                            return;
                        }
                    } catch (ClassCastException unused2) {
                    }
                    System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr2[0] + " [1]=" + objArr2[1]);
                    f7604l = null;
                    f7605m = 0;
                }
            }
        }
        this.f7609i = new int[i2];
        this.f7610j = new Object[i2];
    }

    private static void g(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (f7608q) {
                if (f7607o < 10) {
                    objArr[0] = f7606n;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f7606n = objArr;
                    f7607o++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (p) {
                if (f7605m < 10) {
                    objArr[0] = f7604l;
                    objArr[1] = iArr;
                    for (int i5 = i2 - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    f7604l = objArr;
                    f7605m++;
                }
            }
        }
    }

    private int h(Object obj, int i2) {
        int i4 = this.f7611k;
        if (i4 == 0) {
            return -1;
        }
        try {
            int iA = c.a(this.f7609i, i4, i2);
            if (iA < 0 || obj.equals(this.f7610j[iA])) {
                return iA;
            }
            int i5 = iA + 1;
            while (i5 < i4 && this.f7609i[i5] == i2) {
                if (obj.equals(this.f7610j[i5])) {
                    return i5;
                }
                i5++;
            }
            for (int i6 = iA - 1; i6 >= 0 && this.f7609i[i6] == i2; i6--) {
                if (obj.equals(this.f7610j[i6])) {
                    return i6;
                }
            }
            return ~i5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private int i() {
        int i2 = this.f7611k;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iA = c.a(this.f7609i, i2, 0);
            if (iA < 0 || this.f7610j[iA] == null) {
                return iA;
            }
            int i4 = iA + 1;
            while (i4 < i2 && this.f7609i[i4] == 0) {
                if (this.f7610j[i4] == null) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iA - 1; i5 >= 0 && this.f7609i[i5] == 0; i5--) {
                if (this.f7610j[i5] == null) {
                    return i5;
                }
            }
            return ~i4;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(E e2) {
        int i2;
        int iH;
        int i4 = this.f7611k;
        if (e2 == null) {
            iH = i();
            i2 = 0;
        } else {
            int iHashCode = e2.hashCode();
            i2 = iHashCode;
            iH = h(e2, iHashCode);
        }
        if (iH >= 0) {
            return false;
        }
        int i5 = ~iH;
        int[] iArr = this.f7609i;
        if (i4 >= iArr.length) {
            int i6 = 4;
            if (i4 >= 8) {
                i6 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.f7610j;
            d(i6);
            if (i4 != this.f7611k) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f7609i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f7610j, 0, objArr.length);
            }
            g(iArr, objArr, i4);
        }
        if (i5 < i4) {
            int[] iArr3 = this.f7609i;
            int i7 = i5 + 1;
            int i8 = i4 - i5;
            System.arraycopy(iArr3, i5, iArr3, i7, i8);
            Object[] objArr2 = this.f7610j;
            System.arraycopy(objArr2, i5, objArr2, i7, i8);
        }
        int i9 = this.f7611k;
        if (i4 == i9) {
            int[] iArr4 = this.f7609i;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                this.f7610j[i5] = e2;
                this.f7611k = i9 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.f7611k;
        int i2 = this.f7611k;
        int[] iArr = this.f7609i;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f7610j;
            d(size);
            int i4 = this.f7611k;
            if (i4 > 0) {
                System.arraycopy(iArr, 0, this.f7609i, 0, i4);
                System.arraycopy(objArr, 0, this.f7610j, 0, this.f7611k);
            }
            g(iArr, objArr, this.f7611k);
        }
        if (this.f7611k != i2) {
            throw new ConcurrentModificationException();
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i2 = this.f7611k;
        if (i2 != 0) {
            int[] iArr = this.f7609i;
            Object[] objArr = this.f7610j;
            this.f7609i = c.f7613a;
            this.f7610j = c.f7614b;
            this.f7611k = 0;
            g(iArr, objArr, i2);
        }
        if (this.f7611k != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? i() : h(obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f7611k != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f7611k; i2++) {
                try {
                    if (!set.contains(this.f7610j[i2])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f7609i;
        int i2 = this.f7611k;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 += iArr[i5];
        }
        return i4;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f7611k <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        return new a();
    }

    public final E k(int i2) {
        int i4 = this.f7611k;
        Object[] objArr = this.f7610j;
        E e2 = (E) objArr[i2];
        if (i4 <= 1) {
            clear();
        } else {
            int i5 = i4 - 1;
            int[] iArr = this.f7609i;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    int i7 = i5 - i2;
                    System.arraycopy(iArr, i6, iArr, i2, i7);
                    Object[] objArr2 = this.f7610j;
                    System.arraycopy(objArr2, i6, objArr2, i2, i7);
                }
                this.f7610j[i5] = null;
            } else {
                d(i4 > 8 ? i4 + (i4 >> 1) : 8);
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f7609i, 0, i2);
                    System.arraycopy(objArr, 0, this.f7610j, 0, i2);
                }
                if (i2 < i5) {
                    int i8 = i2 + 1;
                    int i9 = i5 - i2;
                    System.arraycopy(iArr, i8, this.f7609i, i2, i9);
                    System.arraycopy(objArr, i8, this.f7610j, i2, i9);
                }
            }
            if (i4 != this.f7611k) {
                throw new ConcurrentModificationException();
            }
            this.f7611k = i5;
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i2 = obj == null ? i() : h(obj, obj.hashCode());
        if (i2 < 0) {
            return false;
        }
        k(i2);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        boolean z4 = false;
        for (int i2 = this.f7611k - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f7610j[i2])) {
                k(i2);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f7611k;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i2 = this.f7611k;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f7610j, 0, objArr, 0, i2);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f7611k * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f7611k; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.f7610j[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f7611k) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f7611k));
        }
        System.arraycopy(this.f7610j, 0, tArr, 0, this.f7611k);
        int length = tArr.length;
        int i2 = this.f7611k;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}
