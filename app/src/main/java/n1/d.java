package n1;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import q.C0365a;
import s1.i;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<i> f7483a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final C0365a<i, List<Class<?>>> f7484b = new C0365a<>();

    public final List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> orDefault;
        i andSet = this.f7483a.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f7484b) {
            orDefault = this.f7484b.getOrDefault(andSet, null);
        }
        this.f7483a.set(andSet);
        return orDefault;
    }

    public final void b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f7484b) {
            this.f7484b.put(new i(cls, cls2, cls3), list);
        }
    }
}
