package s1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class g<T, Y> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<T, Y> f7858a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    private long f7859b;

    /* renamed from: c, reason: collision with root package name */
    private long f7860c;

    public g(long j2) {
        this.f7859b = j2;
    }

    public final void a() {
        h(0L);
    }

    public final synchronized Y b(T t2) {
        return (Y) this.f7858a.get(t2);
    }

    public final synchronized long c() {
        return this.f7859b;
    }

    protected int d(Y y2) {
        return 1;
    }

    protected void e(T t2, Y y2) {
    }

    public final synchronized Y f(T t2, Y y2) {
        long jD = d(y2);
        if (jD >= this.f7859b) {
            e(t2, y2);
            return null;
        }
        if (y2 != null) {
            this.f7860c += jD;
        }
        Y yPut = this.f7858a.put(t2, y2);
        if (yPut != null) {
            this.f7860c -= d(yPut);
            if (!yPut.equals(y2)) {
                e(t2, yPut);
            }
        }
        h(this.f7859b);
        return yPut;
    }

    public final synchronized Y g(T t2) {
        Y yRemove;
        yRemove = this.f7858a.remove(t2);
        if (yRemove != null) {
            this.f7860c -= d(yRemove);
        }
        return yRemove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final synchronized void h(long j2) {
        while (this.f7860c > j2) {
            Iterator it = this.f7858a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            this.f7860c -= d(value);
            Object key = entry.getKey();
            it.remove();
            e(key, value);
        }
    }
}
