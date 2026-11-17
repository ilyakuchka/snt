package q;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* renamed from: q.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0365a<K, V> extends g<K, V> implements Map<K, V> {
    C0365a<K, V>.C0134a p;

    /* renamed from: q, reason: collision with root package name */
    C0365a<K, V>.c f7593q;

    /* renamed from: r, reason: collision with root package name */
    C0365a<K, V>.e f7594r;

    /* renamed from: q.a$a, reason: collision with other inner class name */
    final class C0134a extends AbstractSet<Map.Entry<K, V>> {
        C0134a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return C0365a.this.f7633k;
        }
    }

    /* renamed from: q.a$b */
    final class b extends q.d<K> {
        b() {
            super(C0365a.this.f7633k);
        }

        @Override // q.d
        protected final K a(int i2) {
            return C0365a.this.h(i2);
        }

        @Override // q.d
        protected final void b(int i2) {
            C0365a.this.j(i2);
        }
    }

    /* renamed from: q.a$d */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: i, reason: collision with root package name */
        int f7598i;

        /* renamed from: j, reason: collision with root package name */
        int f7599j = -1;

        /* renamed from: k, reason: collision with root package name */
        boolean f7600k;

        d() {
            this.f7598i = C0365a.this.f7633k - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.f7600k) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            K kH = C0365a.this.h(this.f7599j);
            if (!(key == kH || (key != null && key.equals(kH)))) {
                return false;
            }
            Object value = entry.getValue();
            V vL = C0365a.this.l(this.f7599j);
            return value == vL || (value != null && value.equals(vL));
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            if (this.f7600k) {
                return C0365a.this.h(this.f7599j);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            if (this.f7600k) {
                return C0365a.this.l(this.f7599j);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f7599j < this.f7598i;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.f7600k) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            K kH = C0365a.this.h(this.f7599j);
            V vL = C0365a.this.l(this.f7599j);
            return (kH == null ? 0 : kH.hashCode()) ^ (vL != null ? vL.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f7599j++;
            this.f7600k = true;
            return this;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f7600k) {
                throw new IllegalStateException();
            }
            C0365a.this.j(this.f7599j);
            this.f7599j--;
            this.f7598i--;
            this.f7600k = false;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v2) {
            if (this.f7600k) {
                return C0365a.this.k(this.f7599j, v2);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: q.a$f */
    final class f extends q.d<V> {
        f() {
            super(C0365a.this.f7633k);
        }

        @Override // q.d
        protected final V a(int i2) {
            return C0365a.this.l(i2);
        }

        @Override // q.d
        protected final void b(int i2) {
            C0365a.this.j(i2);
        }
    }

    public C0365a() {
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        C0365a<K, V>.C0134a c0134a = this.p;
        if (c0134a != null) {
            return c0134a;
        }
        C0365a<K, V>.C0134a c0134a2 = new C0134a();
        this.p = c0134a2;
        return c0134a2;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        C0365a<K, V>.c cVar = this.f7593q;
        if (cVar != null) {
            return cVar;
        }
        C0365a<K, V>.c cVar2 = new c();
        this.f7593q = cVar2;
        return cVar2;
    }

    public final boolean m(Collection<?> collection) {
        int i2 = this.f7633k;
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            if (!collection.contains(h(i4))) {
                j(i4);
            }
        }
        return i2 != this.f7633k;
    }

    final <T> T[] n(T[] tArr, int i2) {
        int i4 = this.f7633k;
        if (tArr.length < i4) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i4));
        }
        for (int i5 = 0; i5 < i4; i5++) {
            tArr[i5] = this.f7632j[(i5 << 1) + i2];
        }
        if (tArr.length > i4) {
            tArr[i4] = null;
        }
        return tArr;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.f7633k);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        C0365a<K, V>.e eVar = this.f7594r;
        if (eVar != null) {
            return eVar;
        }
        C0365a<K, V>.e eVar2 = new e();
        this.f7594r = eVar2;
        return eVar2;
    }

    public C0365a(int i2) {
        super(i2);
    }

    /* renamed from: q.a$c */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            C0365a.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return C0365a.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            C0365a c0365a = C0365a.this;
            Objects.requireNonNull(c0365a);
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!c0365a.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (size() == set.size()) {
                        if (containsAll(set)) {
                            return true;
                        }
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int iHashCode = 0;
            for (int i2 = C0365a.this.f7633k - 1; i2 >= 0; i2--) {
                K kH = C0365a.this.h(i2);
                iHashCode += kH == null ? 0 : kH.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return C0365a.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<K> iterator() {
            return new b();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            int iE = C0365a.this.e(obj);
            if (iE < 0) {
                return false;
            }
            C0365a.this.j(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            C0365a c0365a = C0365a.this;
            int i2 = c0365a.f7633k;
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                c0365a.remove(it.next());
            }
            return i2 != c0365a.f7633k;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            return C0365a.this.m(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return C0365a.this.f7633k;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            int i2 = C0365a.this.f7633k;
            Object[] objArr = new Object[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                objArr[i4] = C0365a.this.h(i4);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) C0365a.this.n(tArr, 0);
        }
    }

    /* renamed from: q.a$e */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public final boolean add(V v2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            C0365a.this.clear();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return C0365a.this.g(obj) >= 0;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return C0365a.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new f();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            int iG = C0365a.this.g(obj);
            if (iG < 0) {
                return false;
            }
            C0365a.this.j(iG);
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            int i2 = C0365a.this.f7633k;
            int i4 = 0;
            boolean z4 = false;
            while (i4 < i2) {
                if (collection.contains(C0365a.this.l(i4))) {
                    C0365a.this.j(i4);
                    i4--;
                    i2--;
                    z4 = true;
                }
                i4++;
            }
            return z4;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            int i2 = C0365a.this.f7633k;
            int i4 = 0;
            boolean z4 = false;
            while (i4 < i2) {
                if (!collection.contains(C0365a.this.l(i4))) {
                    C0365a.this.j(i4);
                    i4--;
                    i2--;
                    z4 = true;
                }
                i4++;
            }
            return z4;
        }

        @Override // java.util.Collection
        public final int size() {
            return C0365a.this.f7633k;
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            int i2 = C0365a.this.f7633k;
            Object[] objArr = new Object[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                objArr[i4] = C0365a.this.l(i4);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) C0365a.this.n(tArr, 1);
        }
    }
}
