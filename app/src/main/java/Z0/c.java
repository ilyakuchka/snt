package Z0;

import Z0.k;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class c<T extends k> {

    /* renamed from: a, reason: collision with root package name */
    private final Queue<T> f2141a;

    c() {
        int i2 = s1.j.f7867c;
        this.f2141a = new ArrayDeque(20);
    }

    abstract T a();

    final T b() {
        T t2 = (T) this.f2141a.poll();
        return t2 == null ? (T) a() : t2;
    }

    public final void c(T t2) {
        if (this.f2141a.size() < 20) {
            this.f2141a.offer(t2);
        }
    }
}
