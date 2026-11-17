package Y0;

import Y0.h;
import Y0.k;
import Y0.m;
import android.os.SystemClock;
import android.util.Log;
import c1.n;
import com.bumptech.glide.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import r.C0374g;
import t1.a;

/* loaded from: classes.dex */
final class j<R> implements h.a, Runnable, Comparable<j<?>>, a.d {

    /* renamed from: A, reason: collision with root package name */
    private int f1942A;

    /* renamed from: B, reason: collision with root package name */
    private long f1943B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f1944C;

    /* renamed from: D, reason: collision with root package name */
    private Object f1945D;

    /* renamed from: E, reason: collision with root package name */
    private Thread f1946E;

    /* renamed from: F, reason: collision with root package name */
    private V0.f f1947F;

    /* renamed from: G, reason: collision with root package name */
    private V0.f f1948G;

    /* renamed from: H, reason: collision with root package name */
    private Object f1949H;

    /* renamed from: I, reason: collision with root package name */
    private V0.a f1950I;

    /* renamed from: J, reason: collision with root package name */
    private W0.d<?> f1951J;

    /* renamed from: K, reason: collision with root package name */
    private volatile h f1952K;
    private volatile boolean L;
    private volatile boolean M;

    /* renamed from: l, reason: collision with root package name */
    private final d f1956l;

    /* renamed from: m, reason: collision with root package name */
    private final E.b<j<?>> f1957m;
    private com.bumptech.glide.e p;

    /* renamed from: q, reason: collision with root package name */
    private V0.f f1960q;

    /* renamed from: r, reason: collision with root package name */
    private com.bumptech.glide.f f1961r;

    /* renamed from: s, reason: collision with root package name */
    private p f1962s;

    /* renamed from: t, reason: collision with root package name */
    private int f1963t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    private l f1964v;

    /* renamed from: w, reason: collision with root package name */
    private V0.h f1965w;

    /* renamed from: x, reason: collision with root package name */
    private a<R> f1966x;

    /* renamed from: y, reason: collision with root package name */
    private int f1967y;

    /* renamed from: z, reason: collision with root package name */
    private int f1968z;

    /* renamed from: i, reason: collision with root package name */
    private final i<R> f1953i = new i<>();

    /* renamed from: j, reason: collision with root package name */
    private final List<Throwable> f1954j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private final t1.d f1955k = t1.d.a();

    /* renamed from: n, reason: collision with root package name */
    private final c<?> f1958n = new c<>();

    /* renamed from: o, reason: collision with root package name */
    private final e f1959o = new e();

    interface a<R> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class b<Z> implements k.a<Z> {

        /* renamed from: a, reason: collision with root package name */
        private final V0.a f1969a;

        b(V0.a aVar) {
            this.f1969a = aVar;
        }

        public final x<Z> a(x<Z> xVar) {
            return j.this.q(this.f1969a, xVar);
        }
    }

    private static class c<Z> {

        /* renamed from: a, reason: collision with root package name */
        private V0.f f1971a;

        /* renamed from: b, reason: collision with root package name */
        private V0.k<Z> f1972b;

        /* renamed from: c, reason: collision with root package name */
        private w<Z> f1973c;

        c() {
        }

        final void a() {
            this.f1971a = null;
            this.f1972b = null;
            this.f1973c = null;
        }

        final void b(d dVar, V0.h hVar) {
            try {
                ((m.c) dVar).a().a(this.f1971a, new g(this.f1972b, this.f1973c, hVar));
            } finally {
                this.f1973c.e();
            }
        }

        final boolean c() {
            return this.f1973c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        final <X> void d(V0.f fVar, V0.k<X> kVar, w<X> wVar) {
            this.f1971a = fVar;
            this.f1972b = kVar;
            this.f1973c = wVar;
        }
    }

    interface d {
    }

    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1974a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f1975b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1976c;

        e() {
        }

        private boolean a() {
            return (this.f1976c || this.f1975b) && this.f1974a;
        }

        final synchronized boolean b() {
            this.f1975b = true;
            return a();
        }

        final synchronized boolean c() {
            this.f1976c = true;
            return a();
        }

        final synchronized boolean d() {
            this.f1974a = true;
            return a();
        }

        final synchronized void e() {
            this.f1975b = false;
            this.f1974a = false;
            this.f1976c = false;
        }
    }

    j(d dVar, E.b<j<?>> bVar) {
        this.f1956l = dVar;
        this.f1957m = bVar;
    }

    private <Data> x<R> i(W0.d<?> dVar, Data data, V0.a aVar) throws s {
        if (data == null) {
            return null;
        }
        try {
            int i2 = s1.f.f7857b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            x<R> xVarJ = j(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + xVarJ, jElapsedRealtimeNanos, null);
            }
            return xVarJ;
        } finally {
            dVar.b();
        }
    }

    private <Data> x<R> j(Data data, V0.a aVar) throws s {
        v<Data, ?, R> vVarH = this.f1953i.h(data.getClass());
        V0.h hVar = this.f1965w;
        boolean z4 = aVar == V0.a.f1750l || this.f1953i.w();
        V0.g<Boolean> gVar = f1.k.f6196i;
        Boolean bool = (Boolean) hVar.c(gVar);
        if (bool == null || (bool.booleanValue() && !z4)) {
            hVar = new V0.h();
            hVar.d(this.f1965w);
            hVar.e(gVar, Boolean.valueOf(z4));
        }
        V0.h hVar2 = hVar;
        W0.e<Data> eVarK = this.p.h().k(data);
        try {
            return vVarH.a(eVarK, hVar2, this.f1963t, this.u, new b(aVar));
        } finally {
            eVarK.b();
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.Throwable>] */
    private void k() {
        x<R> xVarI;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.f1943B;
            StringBuilder sbD = D2.e.d("data: ");
            sbD.append(this.f1949H);
            sbD.append(", cache key: ");
            sbD.append(this.f1947F);
            sbD.append(", fetcher: ");
            sbD.append(this.f1951J);
            o("Retrieved data", j2, sbD.toString());
        }
        w wVarA = null;
        try {
            xVarI = i(this.f1951J, this.f1949H, this.f1950I);
        } catch (s e2) {
            e2.g(this.f1948G, this.f1950I);
            this.f1954j.add(e2);
            xVarI = null;
        }
        if (xVarI == null) {
            t();
            return;
        }
        V0.a aVar = this.f1950I;
        if (xVarI instanceof t) {
            ((t) xVarI).a();
        }
        if (this.f1958n.c()) {
            wVarA = w.a(xVarI);
            xVarI = wVarA;
        }
        v();
        ((n) this.f1966x).h(xVarI, aVar);
        this.f1968z = 5;
        try {
            if (this.f1958n.c()) {
                this.f1958n.b(this.f1956l, this.f1965w);
            }
            if (this.f1959o.b()) {
                s();
            }
        } finally {
            if (wVarA != null) {
                wVarA.e();
            }
        }
    }

    private h l() {
        int iB = C0374g.b(this.f1968z);
        if (iB == 1) {
            return new y(this.f1953i, this);
        }
        if (iB == 2) {
            return new Y0.e(this.f1953i, this);
        }
        if (iB == 3) {
            return new C(this.f1953i, this);
        }
        if (iB == 5) {
            return null;
        }
        StringBuilder sbD = D2.e.d("Unrecognized stage: ");
        sbD.append(C2.c.h(this.f1968z));
        throw new IllegalStateException(sbD.toString());
    }

    private int m(int i2) {
        if (i2 == 0) {
            throw null;
        }
        int i4 = i2 - 1;
        if (i4 == 0) {
            if (this.f1964v.b()) {
                return 2;
            }
            return m(2);
        }
        if (i4 == 1) {
            if (this.f1964v.a()) {
                return 3;
            }
            return m(3);
        }
        if (i4 == 2) {
            return this.f1944C ? 6 : 4;
        }
        if (i4 == 3 || i4 == 5) {
            return 6;
        }
        StringBuilder sbD = D2.e.d("Unrecognized stage: ");
        sbD.append(C2.c.h(i2));
        throw new IllegalArgumentException(sbD.toString());
    }

    private void o(String str, long j2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(s1.f.a(j2));
        sb.append(", load key: ");
        sb.append(this.f1962s);
        sb.append(str2 != null ? D2.e.c(", ", str2) : "");
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void p() {
        v();
        ((n) this.f1966x).g(new s("Failed to load resource", new ArrayList(this.f1954j)));
        if (this.f1959o.c()) {
            s();
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList, java.util.List<java.lang.Throwable>] */
    private void s() {
        this.f1959o.e();
        this.f1958n.a();
        this.f1953i.a();
        this.L = false;
        this.p = null;
        this.f1960q = null;
        this.f1965w = null;
        this.f1961r = null;
        this.f1962s = null;
        this.f1966x = null;
        this.f1968z = 0;
        this.f1952K = null;
        this.f1946E = null;
        this.f1947F = null;
        this.f1949H = null;
        this.f1950I = null;
        this.f1951J = null;
        this.f1943B = 0L;
        this.M = false;
        this.f1945D = null;
        this.f1954j.clear();
        this.f1957m.a(this);
    }

    private void t() {
        this.f1946E = Thread.currentThread();
        int i2 = s1.f.f7857b;
        this.f1943B = SystemClock.elapsedRealtimeNanos();
        boolean zA = false;
        while (!this.M && this.f1952K != null && !(zA = this.f1952K.a())) {
            this.f1968z = m(this.f1968z);
            this.f1952K = l();
            if (this.f1968z == 4) {
                this.f1942A = 2;
                ((n) this.f1966x).l(this);
                return;
            }
        }
        if ((this.f1968z == 6 || this.M) && !zA) {
            p();
        }
    }

    private void u() {
        int iB = C0374g.b(this.f1942A);
        if (iB == 0) {
            this.f1968z = m(1);
            this.f1952K = l();
            t();
        } else if (iB == 1) {
            t();
        } else if (iB == 2) {
            k();
        } else {
            StringBuilder sbD = D2.e.d("Unrecognized run reason: ");
            sbD.append(D2.e.i(this.f1942A));
            throw new IllegalStateException(sbD.toString());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<java.lang.Throwable>] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.Throwable>] */
    private void v() {
        Throwable th;
        this.f1955k.c();
        if (!this.L) {
            this.L = true;
            return;
        }
        if (this.f1954j.isEmpty()) {
            th = null;
        } else {
            ?? r2 = this.f1954j;
            th = (Throwable) r2.get(r2.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    @Override // java.lang.Comparable
    public final int compareTo(j<?> jVar) {
        j<?> jVar2 = jVar;
        int iOrdinal = this.f1961r.ordinal() - jVar2.f1961r.ordinal();
        return iOrdinal == 0 ? this.f1967y - jVar2.f1967y : iOrdinal;
    }

    @Override // Y0.h.a
    public final void d() {
        this.f1942A = 2;
        ((n) this.f1966x).l(this);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList, java.util.List<java.lang.Throwable>] */
    @Override // Y0.h.a
    public final void e(V0.f fVar, Exception exc, W0.d<?> dVar, V0.a aVar) {
        dVar.b();
        s sVar = new s("Fetching data failed", Collections.singletonList(exc));
        sVar.h(fVar, aVar, dVar.a());
        this.f1954j.add(sVar);
        if (Thread.currentThread() == this.f1946E) {
            t();
        } else {
            this.f1942A = 2;
            ((n) this.f1966x).l(this);
        }
    }

    @Override // t1.a.d
    public final t1.d f() {
        return this.f1955k;
    }

    @Override // Y0.h.a
    public final void g(V0.f fVar, Object obj, W0.d<?> dVar, V0.a aVar, V0.f fVar2) {
        this.f1947F = fVar;
        this.f1949H = obj;
        this.f1951J = dVar;
        this.f1950I = aVar;
        this.f1948G = fVar2;
        if (Thread.currentThread() == this.f1946E) {
            k();
        } else {
            this.f1942A = 3;
            ((n) this.f1966x).l(this);
        }
    }

    public final void h() {
        this.M = true;
        h hVar = this.f1952K;
        if (hVar != null) {
            hVar.cancel();
        }
    }

    final j<R> n(com.bumptech.glide.e eVar, Object obj, p pVar, V0.f fVar, int i2, int i4, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, l lVar, Map<Class<?>, V0.l<?>> map, boolean z4, boolean z5, boolean z6, V0.h hVar, a<R> aVar, int i5) {
        this.f1953i.u(eVar, obj, fVar, i2, i4, lVar, cls, cls2, fVar2, hVar, map, z4, z5, this.f1956l);
        this.p = eVar;
        this.f1960q = fVar;
        this.f1961r = fVar2;
        this.f1962s = pVar;
        this.f1963t = i2;
        this.u = i4;
        this.f1964v = lVar;
        this.f1944C = z6;
        this.f1965w = hVar;
        this.f1966x = aVar;
        this.f1967y = i5;
        this.f1942A = 1;
        this.f1945D = obj;
        return this;
    }

    final <Z> x<Z> q(V0.a aVar, x<Z> xVar) {
        x<Z> xVarB;
        V0.l<Z> lVar;
        V0.c cVarA;
        V0.f fVar;
        Class<?> cls = xVar.get().getClass();
        V0.k<Z> kVarN = null;
        if (aVar != V0.a.f1750l) {
            V0.l<Z> lVarR = this.f1953i.r(cls);
            lVar = lVarR;
            xVarB = lVarR.b(this.p, xVar, this.f1963t, this.u);
        } else {
            xVarB = xVar;
            lVar = null;
        }
        if (!xVar.equals(xVarB)) {
            xVar.d();
        }
        if (this.f1953i.v(xVarB)) {
            kVarN = this.f1953i.n(xVarB);
            cVarA = kVarN.a(this.f1965w);
        } else {
            cVarA = V0.c.NONE;
        }
        V0.k kVar = kVarN;
        i<R> iVar = this.f1953i;
        V0.f fVar2 = this.f1947F;
        ArrayList arrayList = (ArrayList) iVar.g();
        int size = arrayList.size();
        boolean z4 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (((n.a) arrayList.get(i2)).f4419a.equals(fVar2)) {
                z4 = true;
                break;
            }
            i2++;
        }
        if (!this.f1964v.d(!z4, aVar, cVarA)) {
            return xVarB;
        }
        if (kVar == null) {
            throw new g.d(xVarB.get().getClass());
        }
        int iOrdinal = cVarA.ordinal();
        if (iOrdinal == 0) {
            fVar = new f(this.f1947F, this.f1960q);
        } else {
            if (iOrdinal != 1) {
                throw new IllegalArgumentException("Unknown strategy: " + cVarA);
            }
            fVar = new z(this.f1953i.b(), this.f1947F, this.f1960q, this.f1963t, this.u, lVar, cls, this.f1965w);
        }
        w wVarA = w.a(xVarB);
        this.f1958n.d(fVar, kVar, wVarA);
        return wVarA;
    }

    final void r() {
        if (this.f1959o.d()) {
            s();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<java.lang.Throwable>] */
    @Override // java.lang.Runnable
    public final void run() {
        W0.d<?> dVar = this.f1951J;
        try {
            try {
                if (this.M) {
                    p();
                    if (dVar != null) {
                        dVar.b();
                        return;
                    }
                    return;
                }
                u();
                if (dVar != null) {
                    dVar.b();
                }
            } catch (Throwable th) {
                if (dVar != null) {
                    dVar.b();
                }
                throw th;
            }
        } catch (Y0.d e2) {
            throw e2;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.M + ", stage: " + C2.c.h(this.f1968z), th2);
            }
            if (this.f1968z != 5) {
                this.f1954j.add(th2);
                p();
            }
            if (!this.M) {
                throw th2;
            }
            throw th2;
        }
    }

    final boolean w() {
        int iM = m(1);
        return iM == 2 || iM == 3;
    }
}
