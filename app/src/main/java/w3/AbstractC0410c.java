package w3;

import java.lang.ref.SoftReference;

/* renamed from: w3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0410c<T> {

    /* renamed from: a, reason: collision with root package name */
    private SoftReference<T> f7995a = null;

    protected abstract T a(Object obj);

    public final T b(Object obj) {
        T tA;
        synchronized (this) {
            SoftReference<T> softReference = this.f7995a;
            if (softReference == null || (tA = softReference.get()) == null) {
                tA = a(obj);
                this.f7995a = new SoftReference<>(tA);
            } else {
                c(tA, obj);
            }
        }
        return tA;
    }

    protected void c(T t2, Object obj) {
    }
}
