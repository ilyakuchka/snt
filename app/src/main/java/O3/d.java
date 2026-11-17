package O3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import t.C0384b;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: h, reason: collision with root package name */
    public static final b f854h = new b();

    /* renamed from: i, reason: collision with root package name */
    public static final d f855i;

    /* renamed from: j, reason: collision with root package name */
    private static final Logger f856j;

    /* renamed from: a, reason: collision with root package name */
    private final a f857a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f859c;
    private long d;

    /* renamed from: b, reason: collision with root package name */
    private int f858b = 10000;

    /* renamed from: e, reason: collision with root package name */
    private final List<O3.c> f860e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List<O3.c> f861f = new ArrayList();
    private final RunnableC0028d g = new RunnableC0028d();

    public interface a {
        void a(d dVar);

        void b(d dVar, long j2);

        long c();

        void execute(Runnable runnable);
    }

    public static final class b {
    }

    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f862a;

        public c(ThreadFactory threadFactory) {
            this.f862a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // O3.d.a
        public final void a(d dVar) {
            f3.c.d(dVar, "taskRunner");
            dVar.notify();
        }

        @Override // O3.d.a
        public final void b(d dVar, long j2) throws InterruptedException {
            f3.c.d(dVar, "taskRunner");
            long j4 = j2 / 1000000;
            long j5 = j2 - (1000000 * j4);
            if (j4 > 0 || j2 > 0) {
                dVar.wait(j4, (int) j5);
            }
        }

        @Override // O3.d.a
        public final long c() {
            return System.nanoTime();
        }

        @Override // O3.d.a
        public final void execute(Runnable runnable) {
            f3.c.d(runnable, "runnable");
            this.f862a.execute(runnable);
        }
    }

    /* renamed from: O3.d$d, reason: collision with other inner class name */
    public static final class RunnableC0028d implements Runnable {
        RunnableC0028d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            O3.a aVarD;
            while (true) {
                d dVar = d.this;
                synchronized (dVar) {
                    aVarD = dVar.d();
                }
                if (aVarD == null) {
                    return;
                }
                O3.c cVarD = aVarD.d();
                f3.c.b(cVarD);
                d dVar2 = d.this;
                long jC = -1;
                b bVar = d.f854h;
                boolean zIsLoggable = d.f856j.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jC = cVarD.h().f().c();
                    C0384b.d(aVarD, cVarD, "starting");
                }
                try {
                    d.b(dVar2, aVarD);
                    if (zIsLoggable) {
                        C0384b.d(aVarD, cVarD, f3.c.h("finished run in ", C0384b.m(cVarD.h().f().c() - jC)));
                    }
                } finally {
                }
            }
        }
    }

    static {
        String strH = f3.c.h(M3.c.g, " TaskRunner");
        f3.c.d(strH, "name");
        f855i = new d(new c(new M3.b(strH, true)));
        Logger logger = Logger.getLogger(d.class.getName());
        f3.c.c(logger, "getLogger(TaskRunner::class.java.name)");
        f856j = logger;
    }

    public d(a aVar) {
        this.f857a = aVar;
    }

    public static final void b(d dVar, O3.a aVar) {
        Objects.requireNonNull(dVar);
        byte[] bArr = M3.c.f596a;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.b());
        try {
            long jF = aVar.f();
            synchronized (dVar) {
                dVar.c(aVar, jF);
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th) {
            synchronized (dVar) {
                dVar.c(aVar, -1L);
                threadCurrentThread.setName(name);
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList, java.util.List<O3.c>] */
    private final void c(O3.a aVar, long j2) {
        byte[] bArr = M3.c.f596a;
        O3.c cVarD = aVar.d();
        f3.c.b(cVarD);
        if (!(cVarD.c() == aVar)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean zD = cVarD.d();
        cVarD.l();
        cVarD.k(null);
        this.f860e.remove(cVarD);
        if (j2 != -1 && !zD && !cVarD.g()) {
            cVarD.j(aVar, j2, true);
        }
        if (!((ArrayList) cVarD.e()).isEmpty()) {
            this.f861f.add(cVarD);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList, java.util.List<O3.c>] */
    public final O3.a d() {
        boolean z4;
        byte[] bArr = M3.c.f596a;
        while (!this.f861f.isEmpty()) {
            long jC = this.f857a.c();
            long jMin = Long.MAX_VALUE;
            Iterator it = this.f861f.iterator();
            O3.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z4 = false;
                    break;
                }
                O3.a aVar2 = (O3.a) ((ArrayList) ((O3.c) it.next()).e()).get(0);
                long jMax = Math.max(0L, aVar2.c() - jC);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z4 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                byte[] bArr2 = M3.c.f596a;
                aVar.g(-1L);
                O3.c cVarD = aVar.d();
                f3.c.b(cVarD);
                ((ArrayList) cVarD.e()).remove(aVar);
                this.f861f.remove(cVarD);
                cVarD.k(aVar);
                this.f860e.add(cVarD);
                if (z4 || (!this.f859c && (!this.f861f.isEmpty()))) {
                    this.f857a.execute(this.g);
                }
                return aVar;
            }
            if (this.f859c) {
                if (jMin < this.d - jC) {
                    this.f857a.a(this);
                }
                return null;
            }
            this.f859c = true;
            this.d = jC + jMin;
            try {
                try {
                    this.f857a.b(this, jMin);
                } catch (InterruptedException unused) {
                    e();
                }
            } finally {
                this.f859c = false;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.ArrayList, java.util.List<O3.c>] */
    public final void e() {
        int size = this.f860e.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                ((O3.c) this.f860e.get(size)).b();
                if (i2 < 0) {
                    break;
                } else {
                    size = i2;
                }
            }
        }
        int size2 = this.f861f.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i4 = size2 - 1;
            O3.c cVar = (O3.c) this.f861f.get(size2);
            cVar.b();
            if (((ArrayList) cVar.e()).isEmpty()) {
                this.f861f.remove(size2);
            }
            if (i4 < 0) {
                return;
            } else {
                size2 = i4;
            }
        }
    }

    public final a f() {
        return this.f857a;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList, java.util.List<O3.c>] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, java.util.ArrayList, java.util.List<O3.c>] */
    public final void g(O3.c cVar) {
        f3.c.d(cVar, "taskQueue");
        byte[] bArr = M3.c.f596a;
        if (cVar.c() == null) {
            if (!((ArrayList) cVar.e()).isEmpty()) {
                ?? r02 = this.f861f;
                f3.c.d(r02, "<this>");
                if (!r02.contains(cVar)) {
                    r02.add(cVar);
                }
            } else {
                this.f861f.remove(cVar);
            }
        }
        if (this.f859c) {
            this.f857a.a(this);
        } else {
            this.f857a.execute(this.g);
        }
    }

    public final O3.c h() {
        int i2;
        synchronized (this) {
            i2 = this.f858b;
            this.f858b = i2 + 1;
        }
        return new O3.c(this, f3.c.h("Q", Integer.valueOf(i2)));
    }
}
