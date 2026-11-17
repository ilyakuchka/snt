package q;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class f<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f7623a;

    /* renamed from: b, reason: collision with root package name */
    private int f7624b;

    /* renamed from: c, reason: collision with root package name */
    private int f7625c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private int f7626e;

    public f(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f7625c = i2;
        this.f7623a = new LinkedHashMap<>(0, 0.75f, true);
    }

    protected V a(K k2) {
        return null;
    }

    public final V b(K k2) {
        V vPut;
        Objects.requireNonNull(k2, "key == null");
        synchronized (this) {
            V v2 = this.f7623a.get(k2);
            if (v2 != null) {
                this.d++;
                return v2;
            }
            this.f7626e++;
            V vA = a(k2);
            if (vA == null) {
                return null;
            }
            synchronized (this) {
                vPut = this.f7623a.put(k2, vA);
                if (vPut != null) {
                    this.f7623a.put(k2, vPut);
                } else {
                    this.f7624b++;
                }
            }
            if (vPut != null) {
                return vPut;
            }
            f(this.f7625c);
            return vA;
        }
    }

    public final V c(K k2, V v2) {
        V vPut;
        if (k2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f7624b++;
            vPut = this.f7623a.put(k2, v2);
            if (vPut != null) {
                this.f7624b--;
            }
        }
        f(this.f7625c);
        return vPut;
    }

    public final V d(K k2) {
        V vRemove;
        Objects.requireNonNull(k2, "key == null");
        synchronized (this) {
            vRemove = this.f7623a.remove(k2);
            if (vRemove != null) {
                this.f7624b--;
            }
        }
        return vRemove;
    }

    public final synchronized Map<K, V> e() {
        return new LinkedHashMap(this.f7623a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(int i2) {
        while (true) {
            synchronized (this) {
                if (this.f7624b >= 0 && (!this.f7623a.isEmpty() || this.f7624b == 0)) {
                    if (this.f7624b <= i2 || this.f7623a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f7623a.entrySet().iterator().next();
                    K key = next.getKey();
                    next.getValue();
                    this.f7623a.remove(key);
                    this.f7624b--;
                } else {
                    break;
                }
            }
        }
    }

    public final synchronized String toString() {
        int i2;
        int i4;
        i2 = this.d;
        i4 = this.f7626e + i2;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f7625c), Integer.valueOf(this.d), Integer.valueOf(this.f7626e), Integer.valueOf(i4 != 0 ? (i2 * 100) / i4 : 0));
    }
}
