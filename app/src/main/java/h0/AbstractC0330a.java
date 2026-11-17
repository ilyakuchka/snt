package h0;

import q.g;

/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0330a<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final g<K, b<V>> f6310a = new g<>();

    /* renamed from: h0.a$b */
    private static class b<V> {

        /* renamed from: a, reason: collision with root package name */
        V f6311a;

        private b() {
        }

        b(C0111a c0111a) {
        }
    }

    protected AbstractC0330a() {
    }

    public final V a(K k2) {
        b<V> orDefault;
        if (k2 == null || (orDefault = this.f6310a.getOrDefault(k2, null)) == null) {
            return null;
        }
        return orDefault.f6311a;
    }

    public final V b(K k2) {
        b<V> bVarRemove = this.f6310a.remove(k2);
        if (bVarRemove != null) {
            return bVarRemove.f6311a;
        }
        return null;
    }

    public void c() {
        this.f6310a.clear();
    }

    public final boolean d(K k2, V v2) {
        if (this.f6310a.size() >= 500 || k2 == null) {
            return false;
        }
        b<V> bVar = new b<>(null);
        bVar.f6311a = v2;
        this.f6310a.put(k2, bVar);
        return true;
    }
}
