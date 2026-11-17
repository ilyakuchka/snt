package n1;

import Y0.k;
import Y0.v;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import q.C0365a;
import s1.i;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    private static final v<?, ?, ?> f7480c = new v<>(Object.class, Object.class, Object.class, Collections.singletonList(new k(Object.class, Object.class, Object.class, Collections.emptyList(), new k1.f(), null)), null);

    /* renamed from: a, reason: collision with root package name */
    private final C0365a<i, v<?, ?, ?>> f7481a = new C0365a<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<i> f7482b = new AtomicReference<>();

    public final <Data, TResource, Transcode> v<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        v<Data, TResource, Transcode> vVar;
        i andSet = this.f7482b.getAndSet(null);
        if (andSet == null) {
            andSet = new i();
        }
        andSet.a(cls, cls2, cls3);
        synchronized (this.f7481a) {
            vVar = (v) this.f7481a.getOrDefault(andSet, null);
        }
        this.f7482b.set(andSet);
        return vVar;
    }

    public final boolean b(v<?, ?, ?> vVar) {
        return f7480c.equals(vVar);
    }

    public final void c(Class<?> cls, Class<?> cls2, Class<?> cls3, v<?, ?, ?> vVar) {
        synchronized (this.f7481a) {
            C0365a<i, v<?, ?, ?>> c0365a = this.f7481a;
            i iVar = new i(cls, cls2, cls3);
            if (vVar == null) {
                vVar = f7480c;
            }
            c0365a.put(iVar, vVar);
        }
    }
}
