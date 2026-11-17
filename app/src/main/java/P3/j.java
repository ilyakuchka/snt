package P3;

import L3.C0150a;
import L3.D;
import P3.e;
import T3.h;
import java.io.IOException;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final int f1041a;

    /* renamed from: b, reason: collision with root package name */
    private final long f1042b;

    /* renamed from: c, reason: collision with root package name */
    private final O3.c f1043c;
    private final i d;

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentLinkedQueue<f> f1044e;

    public j(O3.d dVar) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f3.c.d(dVar, "taskRunner");
        f3.c.d(timeUnit, "timeUnit");
        this.f1041a = 5;
        this.f1042b = timeUnit.toNanos(5L);
        this.f1043c = dVar.h();
        this.d = new i(this, f3.c.h(M3.c.g, " ConnectionPool"));
        this.f1044e = new ConcurrentLinkedQueue<>();
    }

    private final int d(f fVar, long j2) {
        byte[] bArr = M3.c.f596a;
        List<Reference<e>> listJ = fVar.j();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) listJ;
            if (i2 >= arrayList.size()) {
                return arrayList.size();
            }
            Reference reference = (Reference) arrayList.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                StringBuilder sbD = D2.e.d("A connection to ");
                sbD.append(fVar.v().a().l());
                sbD.append(" was leaked. Did you forget to close a response body?");
                String string = sbD.toString();
                h.a aVar = T3.h.f1639a;
                T3.h hVar = T3.h.f1640b;
                Object objA = ((e.b) reference).a();
                Objects.requireNonNull(hVar);
                f3.c.d(string, "message");
                if (objA == null) {
                    string = f3.c.h(string, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
                }
                hVar.i(string, 5, (Throwable) objA);
                arrayList.remove(i2);
                fVar.x();
                if (arrayList.isEmpty()) {
                    fVar.w(j2 - this.f1042b);
                    return 0;
                }
            }
        }
    }

    public final boolean a(C0150a c0150a, e eVar, List<D> list, boolean z4) {
        f3.c.d(c0150a, "address");
        f3.c.d(eVar, "call");
        Iterator<f> it = this.f1044e.iterator();
        while (it.hasNext()) {
            f next = it.next();
            f3.c.c(next, "connection");
            synchronized (next) {
                if (z4) {
                    if (!next.r()) {
                    }
                }
                if (next.p(c0150a, list)) {
                    eVar.c(next);
                    return true;
                }
            }
        }
        return false;
    }

    public final long b(long j2) throws IOException {
        Iterator<f> it = this.f1044e.iterator();
        int i2 = 0;
        long j4 = Long.MIN_VALUE;
        f fVar = null;
        int i4 = 0;
        while (it.hasNext()) {
            f next = it.next();
            f3.c.c(next, "connection");
            synchronized (next) {
                if (d(next, j2) > 0) {
                    i4++;
                } else {
                    i2++;
                    long jK = j2 - next.k();
                    if (jK > j4) {
                        fVar = next;
                        j4 = jK;
                    }
                }
            }
        }
        long j5 = this.f1042b;
        if (j4 < j5 && i2 <= this.f1041a) {
            if (i2 > 0) {
                return j5 - j4;
            }
            if (i4 > 0) {
                return j5;
            }
            return -1L;
        }
        f3.c.b(fVar);
        synchronized (fVar) {
            if (!((ArrayList) fVar.j()).isEmpty()) {
                return 0L;
            }
            if (fVar.k() + j4 != j2) {
                return 0L;
            }
            fVar.x();
            this.f1044e.remove(fVar);
            M3.c.f(fVar.y());
            if (this.f1044e.isEmpty()) {
                this.f1043c.a();
            }
            return 0L;
        }
    }

    public final boolean c(f fVar) {
        byte[] bArr = M3.c.f596a;
        if (!fVar.l() && this.f1041a != 0) {
            this.f1043c.i(this.d, 0L);
            return false;
        }
        fVar.x();
        this.f1044e.remove(fVar);
        if (!this.f1044e.isEmpty()) {
            return true;
        }
        this.f1043c.a();
        return true;
    }

    public final void e(f fVar) {
        byte[] bArr = M3.c.f596a;
        this.f1044e.add(fVar);
        this.f1043c.i(this.d, 0L);
    }
}
