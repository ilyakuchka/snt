package O3;

import O3.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import t.C0384b;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final d f849a;

    /* renamed from: b, reason: collision with root package name */
    private final String f850b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f851c;
    private a d;

    /* renamed from: e, reason: collision with root package name */
    private final List<a> f852e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f853f;

    public c(d dVar, String str) {
        f3.c.d(dVar, "taskRunner");
        f3.c.d(str, "name");
        this.f849a = dVar;
        this.f850b = str;
        this.f852e = new ArrayList();
    }

    public final void a() {
        byte[] bArr = M3.c.f596a;
        synchronized (this.f849a) {
            if (b()) {
                this.f849a.g(this);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList, java.util.List<O3.a>] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.ArrayList, java.util.List<O3.a>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList, java.util.List<O3.a>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.ArrayList, java.util.List<O3.a>] */
    public final boolean b() {
        a aVar = this.d;
        if (aVar != null && aVar.a()) {
            this.f853f = true;
        }
        boolean z4 = false;
        int size = this.f852e.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                if (((a) this.f852e.get(size)).a()) {
                    a aVar2 = (a) this.f852e.get(size);
                    d.b bVar = d.f854h;
                    if (d.f856j.isLoggable(Level.FINE)) {
                        C0384b.d(aVar2, this, "canceled");
                    }
                    this.f852e.remove(size);
                    z4 = true;
                }
                if (i2 < 0) {
                    break;
                }
                size = i2;
            }
        }
        return z4;
    }

    public final a c() {
        return this.d;
    }

    public final boolean d() {
        return this.f853f;
    }

    public final List<a> e() {
        return this.f852e;
    }

    public final String f() {
        return this.f850b;
    }

    public final boolean g() {
        return this.f851c;
    }

    public final d h() {
        return this.f849a;
    }

    public final void i(a aVar, long j2) {
        f3.c.d(aVar, "task");
        synchronized (this.f849a) {
            if (!this.f851c) {
                if (j(aVar, j2, false)) {
                    this.f849a.g(this);
                }
            } else if (aVar.a()) {
                d.b bVar = d.f854h;
                if (d.f856j.isLoggable(Level.FINE)) {
                    C0384b.d(aVar, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                d.b bVar2 = d.f854h;
                if (d.f856j.isLoggable(Level.FINE)) {
                    C0384b.d(aVar, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.ArrayList, java.util.List<O3.a>] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.util.ArrayList, java.util.List<O3.a>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.ArrayList, java.util.List<O3.a>] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.ArrayList, java.util.List<O3.a>] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.ArrayList, java.util.List<O3.a>] */
    public final boolean j(a aVar, long j2, boolean z4) {
        f3.c.d(aVar, "task");
        aVar.e(this);
        long jC = this.f849a.f().c();
        long j4 = jC + j2;
        int iIndexOf = this.f852e.indexOf(aVar);
        if (iIndexOf != -1) {
            if (aVar.c() <= j4) {
                d.b bVar = d.f854h;
                if (d.f856j.isLoggable(Level.FINE)) {
                    C0384b.d(aVar, this, "already scheduled");
                }
                return false;
            }
            this.f852e.remove(iIndexOf);
        }
        aVar.g(j4);
        d.b bVar2 = d.f854h;
        if (d.f856j.isLoggable(Level.FINE)) {
            C0384b.d(aVar, this, z4 ? f3.c.h("run again after ", C0384b.m(j4 - jC)) : f3.c.h("scheduled after ", C0384b.m(j4 - jC)));
        }
        Iterator it = this.f852e.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (((a) it.next()).c() - jC > j2) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.f852e.size();
        }
        this.f852e.add(size, aVar);
        return size == 0;
    }

    public final void k(a aVar) {
        this.d = aVar;
    }

    public final void l() {
        this.f853f = false;
    }

    public final void m() {
        byte[] bArr = M3.c.f596a;
        synchronized (this.f849a) {
            this.f851c = true;
            if (b()) {
                this.f849a.g(this);
            }
        }
    }

    public final String toString() {
        return this.f850b;
    }
}
