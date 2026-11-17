package s1;

import q.C0365a;

/* loaded from: classes.dex */
public final class b<K, V> extends C0365a<K, V> {

    /* renamed from: s, reason: collision with root package name */
    private int f7847s;

    @Override // q.g, java.util.Map
    public final void clear() {
        this.f7847s = 0;
        super.clear();
    }

    @Override // q.g, java.util.Map
    public final int hashCode() {
        if (this.f7847s == 0) {
            this.f7847s = super.hashCode();
        }
        return this.f7847s;
    }

    @Override // q.g
    public final void i(q.g<? extends K, ? extends V> gVar) {
        this.f7847s = 0;
        super.i(gVar);
    }

    @Override // q.g
    public final V j(int i2) {
        this.f7847s = 0;
        return (V) super.j(i2);
    }

    @Override // q.g
    public final V k(int i2, V v2) {
        this.f7847s = 0;
        return (V) super.k(i2, v2);
    }

    @Override // q.g, java.util.Map
    public final V put(K k2, V v2) {
        this.f7847s = 0;
        return (V) super.put(k2, v2);
    }
}
