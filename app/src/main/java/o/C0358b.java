package o;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: o.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0358b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: i, reason: collision with root package name */
    c<K, V> f7499i;

    /* renamed from: j, reason: collision with root package name */
    private c<K, V> f7500j;

    /* renamed from: k, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f7501k = new WeakHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private int f7502l = 0;

    /* renamed from: o.b$a */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // o.C0358b.e
        final c<K, V> b(c<K, V> cVar) {
            return cVar.f7506l;
        }

        @Override // o.C0358b.e
        final c<K, V> c(c<K, V> cVar) {
            return cVar.f7505k;
        }
    }

    /* renamed from: o.b$b, reason: collision with other inner class name */
    private static class C0131b<K, V> extends e<K, V> {
        C0131b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // o.C0358b.e
        final c<K, V> b(c<K, V> cVar) {
            return cVar.f7505k;
        }

        @Override // o.C0358b.e
        final c<K, V> c(c<K, V> cVar) {
            return cVar.f7506l;
        }
    }

    /* renamed from: o.b$c */
    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: i, reason: collision with root package name */
        final K f7503i;

        /* renamed from: j, reason: collision with root package name */
        final V f7504j;

        /* renamed from: k, reason: collision with root package name */
        c<K, V> f7505k;

        /* renamed from: l, reason: collision with root package name */
        c<K, V> f7506l;

        c(K k2, V v2) {
            this.f7503i = k2;
            this.f7504j = v2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f7503i.equals(cVar.f7503i) && this.f7504j.equals(cVar.f7504j);
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f7503i;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f7504j;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.f7504j.hashCode() ^ this.f7503i.hashCode();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v2) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.f7503i + "=" + this.f7504j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o.b$d */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: i, reason: collision with root package name */
        private c<K, V> f7507i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f7508j = true;

        d() {
        }

        @Override // o.C0358b.f
        public final void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f7507i;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f7506l;
                this.f7507i = cVar3;
                this.f7508j = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f7508j) {
                return C0358b.this.f7499i != null;
            }
            c<K, V> cVar = this.f7507i;
            return (cVar == null || cVar.f7505k == null) ? false : true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f7508j) {
                this.f7508j = false;
                this.f7507i = C0358b.this.f7499i;
            } else {
                c<K, V> cVar = this.f7507i;
                this.f7507i = cVar != null ? cVar.f7505k : null;
            }
            return this.f7507i;
        }
    }

    /* renamed from: o.b$e */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: i, reason: collision with root package name */
        c<K, V> f7510i;

        /* renamed from: j, reason: collision with root package name */
        c<K, V> f7511j;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f7510i = cVar2;
            this.f7511j = cVar;
        }

        @Override // o.C0358b.f
        public final void a(c<K, V> cVar) {
            c<K, V> cVarC = null;
            if (this.f7510i == cVar && cVar == this.f7511j) {
                this.f7511j = null;
                this.f7510i = null;
            }
            c<K, V> cVar2 = this.f7510i;
            if (cVar2 == cVar) {
                this.f7510i = b(cVar2);
            }
            c<K, V> cVar3 = this.f7511j;
            if (cVar3 == cVar) {
                c<K, V> cVar4 = this.f7510i;
                if (cVar3 != cVar4 && cVar4 != null) {
                    cVarC = c(cVar3);
                }
                this.f7511j = cVarC;
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f7511j != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            c<K, V> cVar = this.f7511j;
            c<K, V> cVar2 = this.f7510i;
            this.f7511j = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    /* renamed from: o.b$f */
    interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public final Iterator<Map.Entry<K, V>> d() {
        C0131b c0131b = new C0131b(this.f7500j, this.f7499i);
        this.f7501k.put(c0131b, Boolean.FALSE);
        return c0131b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r1.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((o.C0358b.e) r6).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0358b)) {
            return false;
        }
        C0358b c0358b = (C0358b) obj;
        if (this.f7502l != c0358b.f7502l) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = c0358b.iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                break;
            }
            e eVar2 = (e) it2;
            if (!eVar2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) eVar.next();
            Object next = eVar2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                break;
            }
        }
        return false;
    }

    public final Map.Entry<K, V> g() {
        return this.f7499i;
    }

    protected c<K, V> h(K k2) {
        c<K, V> cVar = this.f7499i;
        while (cVar != null && !cVar.f7503i.equals(k2)) {
            cVar = cVar.f7505k;
        }
        return cVar;
    }

    public final int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    public final C0358b<K, V>.d i() {
        C0358b<K, V>.d dVar = new d();
        this.f7501k.put(dVar, Boolean.FALSE);
        return dVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f7499i, this.f7500j);
        this.f7501k.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public final Map.Entry<K, V> k() {
        return this.f7500j;
    }

    protected final c<K, V> l(K k2, V v2) {
        c<K, V> cVar = new c<>(k2, v2);
        this.f7502l++;
        c<K, V> cVar2 = this.f7500j;
        if (cVar2 == null) {
            this.f7499i = cVar;
            this.f7500j = cVar;
            return cVar;
        }
        cVar2.f7505k = cVar;
        cVar.f7506l = cVar2;
        this.f7500j = cVar;
        return cVar;
    }

    public V n(K k2, V v2) {
        c<K, V> cVarH = h(k2);
        if (cVarH != null) {
            return cVarH.f7504j;
        }
        l(k2, v2);
        return null;
    }

    public V o(K k2) {
        c<K, V> cVarH = h(k2);
        if (cVarH == null) {
            return null;
        }
        this.f7502l--;
        if (!this.f7501k.isEmpty()) {
            Iterator<f<K, V>> it = this.f7501k.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarH);
            }
        }
        c<K, V> cVar = cVarH.f7506l;
        if (cVar != null) {
            cVar.f7505k = cVarH.f7505k;
        } else {
            this.f7499i = cVarH.f7505k;
        }
        c<K, V> cVar2 = cVarH.f7505k;
        if (cVar2 != null) {
            cVar2.f7506l = cVar;
        } else {
            this.f7500j = cVar;
        }
        cVarH.f7505k = null;
        cVarH.f7506l = null;
        return cVarH.f7504j;
    }

    public final int size() {
        return this.f7502l;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                sbD.append("]");
                return sbD.toString();
            }
            sbD.append(((Map.Entry) eVar.next()).toString());
            if (eVar.hasNext()) {
                sbD.append(", ");
            }
        }
    }
}
