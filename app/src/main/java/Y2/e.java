package Y2;

import e3.InterfaceC0299a;
import java.io.Serializable;

/* loaded from: classes.dex */
final class e<T> implements b<T>, Serializable {

    /* renamed from: i, reason: collision with root package name */
    private InterfaceC0299a<? extends T> f2134i;

    /* renamed from: j, reason: collision with root package name */
    private volatile Object f2135j = f.f2137a;

    /* renamed from: k, reason: collision with root package name */
    private final Object f2136k = this;

    public e(InterfaceC0299a interfaceC0299a) {
        this.f2134i = interfaceC0299a;
    }

    @Override // Y2.b
    public final T getValue() {
        T tA;
        T t2 = (T) this.f2135j;
        f fVar = f.f2137a;
        if (t2 != fVar) {
            return t2;
        }
        synchronized (this.f2136k) {
            tA = (T) this.f2135j;
            if (tA == fVar) {
                InterfaceC0299a<? extends T> interfaceC0299a = this.f2134i;
                f3.c.b(interfaceC0299a);
                tA = interfaceC0299a.a();
                this.f2135j = tA;
                this.f2134i = null;
            }
        }
        return tA;
    }

    public final String toString() {
        return this.f2135j != f.f2137a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
