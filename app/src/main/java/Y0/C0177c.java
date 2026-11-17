package Y0;

import Y0.r;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: Y0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0177c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1908a;

    /* renamed from: b, reason: collision with root package name */
    final Map<V0.f, a> f1909b;

    /* renamed from: c, reason: collision with root package name */
    private final ReferenceQueue<r<?>> f1910c;
    private r.a d;

    /* renamed from: Y0.c$a */
    static final class a extends WeakReference<r<?>> {

        /* renamed from: a, reason: collision with root package name */
        final V0.f f1911a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f1912b;

        /* renamed from: c, reason: collision with root package name */
        x<?> f1913c;

        a(V0.f fVar, r<?> rVar, ReferenceQueue<? super r<?>> referenceQueue, boolean z4) {
            x<?> xVarE;
            super(rVar, referenceQueue);
            Objects.requireNonNull(fVar, "Argument must not be null");
            this.f1911a = fVar;
            if (rVar.f() && z4) {
                xVarE = rVar.e();
                Objects.requireNonNull(xVarE, "Argument must not be null");
            } else {
                xVarE = null;
            }
            this.f1913c = xVarE;
            this.f1912b = rVar.f();
        }
    }

    C0177c() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryC0175a());
        this.f1909b = new HashMap();
        this.f1910c = new ReferenceQueue<>();
        this.f1908a = false;
        executorServiceNewSingleThreadExecutor.execute(new RunnableC0176b(this));
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.HashMap, java.util.Map<V0.f, Y0.c$a>] */
    final synchronized void a(V0.f fVar, r<?> rVar) {
        a aVar = (a) this.f1909b.put(fVar, new a(fVar, rVar, this.f1910c, this.f1908a));
        if (aVar != null) {
            aVar.f1913c = null;
            aVar.clear();
        }
    }

    final void b() {
        while (true) {
            try {
                c((a) this.f1910c.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<V0.f, Y0.c$a>] */
    final void c(a aVar) {
        x<?> xVar;
        synchronized (this) {
            this.f1909b.remove(aVar.f1911a);
            if (aVar.f1912b && (xVar = aVar.f1913c) != null) {
                this.d.a(aVar.f1911a, new r<>(xVar, true, false, aVar.f1911a, this.d));
            }
        }
    }

    final void d(r.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.d = aVar;
            }
        }
    }
}
