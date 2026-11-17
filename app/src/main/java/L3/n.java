package L3;

import P3.e;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f467a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque<e.a> f468b = new ArrayDeque<>();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque<e.a> f469c = new ArrayDeque<>();
    private final ArrayDeque<P3.e> d = new ArrayDeque<>();

    private final <T> void c(Deque<T> deque, T t2) {
        synchronized (this) {
            if (!deque.remove(t2)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            synchronized (this) {
            }
            f();
        }
        f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (r3 < 5) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        r1.remove();
        r2.c().incrementAndGet();
        r0.add(r2);
        r15.f469c.add(r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean f() {
        int size;
        int size2;
        int i2;
        int i4;
        e.a aVar;
        byte[] bArr = M3.c.f596a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<e.a> it = this.f468b.iterator();
            f3.c.c(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                e.a next = it.next();
                int size3 = this.f469c.size();
                synchronized (this) {
                    if (size3 >= 64) {
                        break;
                    }
                    int i5 = next.c().get();
                    synchronized (this) {
                    }
                    aVar.a(threadPoolExecutor);
                    i2 = i4;
                }
                size2 = arrayList.size();
                i2 = 0;
                while (i2 < size2) {
                    i4 = i2 + 1;
                    aVar = (e.a) arrayList.get(i2);
                    synchronized (this) {
                        if (this.f467a == null) {
                            TimeUnit timeUnit = TimeUnit.SECONDS;
                            SynchronousQueue synchronousQueue = new SynchronousQueue();
                            String strH = f3.c.h(M3.c.g, " Dispatcher");
                            f3.c.d(strH, "name");
                            this.f467a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new M3.b(strH, false));
                        }
                        ThreadPoolExecutor threadPoolExecutor = this.f467a;
                        f3.c.b(threadPoolExecutor);
                        aVar.a(threadPoolExecutor);
                        i2 = i4;
                    }
                }
                return z;
            }
            synchronized (this) {
                size = this.f469c.size() + this.d.size();
            }
        }
        boolean z4 = size > 0;
        size2 = arrayList.size();
        i2 = 0;
        while (i2 < size2) {
        }
        return z4;
    }

    public final void a(e.a aVar) {
        e.a next;
        synchronized (this) {
            this.f468b.add(aVar);
            if (!aVar.b().l()) {
                String strD = aVar.d();
                Iterator<e.a> it = this.f469c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator<e.a> it2 = this.f468b.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            } else {
                                next = it2.next();
                                if (f3.c.a(next.d(), strD)) {
                                    break;
                                }
                            }
                        }
                    } else {
                        next = it.next();
                        if (f3.c.a(next.d(), strD)) {
                            break;
                        }
                    }
                }
                if (next != null) {
                    aVar.e(next);
                }
            }
        }
        f();
    }

    public final synchronized void b(P3.e eVar) {
        f3.c.d(eVar, "call");
        this.d.add(eVar);
    }

    public final void d(e.a aVar) {
        f3.c.d(aVar, "call");
        aVar.c().decrementAndGet();
        c(this.f469c, aVar);
    }

    public final void e(P3.e eVar) {
        f3.c.d(eVar, "call");
        c(this.d, eVar);
    }
}
