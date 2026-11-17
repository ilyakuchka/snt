package Z0;

import Z0.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class g<K extends k, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V> f2143a = new a<>(null);

    /* renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f2144b = new HashMap();

    private static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f2145a;

        /* renamed from: b, reason: collision with root package name */
        private List<V> f2146b;

        /* renamed from: c, reason: collision with root package name */
        a<K, V> f2147c;
        a<K, V> d;

        a() {
            this(null);
        }

        public final void a(V v2) {
            if (this.f2146b == null) {
                this.f2146b = new ArrayList();
            }
            this.f2146b.add(v2);
        }

        public final V b() {
            List<V> list = this.f2146b;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                return (V) this.f2146b.remove(size - 1);
            }
            return null;
        }

        public final int c() {
            List<V> list = this.f2146b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k2) {
            this.d = this;
            this.f2147c = this;
            this.f2145a = k2;
        }
    }

    g() {
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.d;
        aVar2.f2147c = aVar.f2147c;
        aVar.f2147c.d = aVar2;
    }

    public final V a(K k2) {
        a aVar;
        a aVar2 = (a) this.f2144b.get(k2);
        if (aVar2 == null) {
            a aVar3 = new a(k2);
            this.f2144b.put(k2, aVar3);
            aVar = aVar3;
        } else {
            k2.a();
            aVar = aVar2;
        }
        c(aVar);
        a<K, V> aVar4 = this.f2143a;
        aVar.d = aVar4;
        a<K, V> aVar5 = aVar4.f2147c;
        aVar.f2147c = aVar5;
        aVar5.d = aVar;
        aVar.d.f2147c = aVar;
        return (V) aVar.b();
    }

    public final void b(K k2, V v2) {
        a aVar = (a) this.f2144b.get(k2);
        if (aVar == null) {
            aVar = new a(k2);
            c(aVar);
            a<K, V> aVar2 = this.f2143a;
            aVar.d = aVar2.d;
            aVar.f2147c = aVar2;
            aVar2.d = aVar;
            aVar.d.f2147c = aVar;
            this.f2144b.put(k2, aVar);
        } else {
            k2.a();
        }
        aVar.a(v2);
    }

    public final V d() {
        for (a aVar = this.f2143a.d; !aVar.equals(this.f2143a); aVar = aVar.d) {
            V v2 = (V) aVar.b();
            if (v2 != null) {
                return v2;
            }
            c(aVar);
            this.f2144b.remove(aVar.f2145a);
            ((k) aVar.f2145a).a();
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z4 = false;
        for (a aVar = this.f2143a.f2147c; !aVar.equals(this.f2143a); aVar = aVar.f2147c) {
            z4 = true;
            sb.append('{');
            sb.append(aVar.f2145a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
        }
        if (z4) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
