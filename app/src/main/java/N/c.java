package N;

import N.h;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
abstract class c<Key, Value> extends e<Key, Value> {
    c() {
    }

    @Override // N.e
    final boolean c() {
        return true;
    }

    abstract void f(int i2, int i4, Executor executor, h.a aVar);

    abstract void g(int i2, int i4, Executor executor, h.a aVar);

    abstract void h(Object obj, int i2, int i4, Executor executor, h.a aVar);

    abstract Object i(int i2);
}
