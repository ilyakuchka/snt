package a1;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f2188a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final b f2189b = new b();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final ReentrantLock f2190a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        int f2191b;

        a() {
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<a> f2192a = new ArrayDeque();

        b() {
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayDeque, java.util.Queue<a1.c$a>] */
        final a a() {
            a aVar;
            synchronized (this.f2192a) {
                aVar = (a) this.f2192a.poll();
            }
            return aVar == null ? new a() : aVar;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayDeque, java.util.Queue<a1.c$a>] */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayDeque, java.util.Queue<a1.c$a>] */
        final void b(a aVar) {
            synchronized (this.f2192a) {
                if (this.f2192a.size() < 10) {
                    this.f2192a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, a1.c$a>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap, java.util.Map<java.lang.String, a1.c$a>] */
    final void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = (a) this.f2188a.get(str);
            if (aVarA == null) {
                aVarA = this.f2189b.a();
                this.f2188a.put(str, aVarA);
            }
            aVarA.f2191b++;
        }
        aVarA.f2190a.lock();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, a1.c$a>] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.HashMap, java.util.Map<java.lang.String, a1.c$a>] */
    final void b(String str) {
        a aVar;
        synchronized (this) {
            Object obj = this.f2188a.get(str);
            Objects.requireNonNull(obj, "Argument must not be null");
            aVar = (a) obj;
            int i2 = aVar.f2191b;
            if (i2 < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f2191b);
            }
            int i4 = i2 - 1;
            aVar.f2191b = i4;
            if (i4 == 0) {
                a aVar2 = (a) this.f2188a.remove(str);
                if (!aVar2.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVar2 + ", safeKey: " + str);
                }
                this.f2189b.b(aVar2);
            }
        }
        aVar.f2190a.unlock();
    }
}
