package o;

import java.util.HashMap;
import java.util.Map;
import o.C0358b;

/* renamed from: o.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0357a<K, V> extends C0358b<K, V> {

    /* renamed from: m, reason: collision with root package name */
    private HashMap<K, C0358b.c<K, V>> f7498m = new HashMap<>();

    public final boolean contains(K k2) {
        return this.f7498m.containsKey(k2);
    }

    @Override // o.C0358b
    protected final C0358b.c<K, V> h(K k2) {
        return this.f7498m.get(k2);
    }

    @Override // o.C0358b
    public final V n(K k2, V v2) {
        C0358b.c<K, V> cVarH = h(k2);
        if (cVarH != null) {
            return cVarH.f7504j;
        }
        this.f7498m.put(k2, l(k2, v2));
        return null;
    }

    @Override // o.C0358b
    public final V o(K k2) {
        V v2 = (V) super.o(k2);
        this.f7498m.remove(k2);
        return v2;
    }

    public final Map.Entry<K, V> p(K k2) {
        if (contains(k2)) {
            return this.f7498m.get(k2).f7506l;
        }
        return null;
    }
}
