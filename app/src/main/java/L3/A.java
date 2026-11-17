package L3;

import L3.s;
import java.io.Closeable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class A implements Closeable {

    /* renamed from: i, reason: collision with root package name */
    private final y f359i;

    /* renamed from: j, reason: collision with root package name */
    private final x f360j;

    /* renamed from: k, reason: collision with root package name */
    private final String f361k;

    /* renamed from: l, reason: collision with root package name */
    private final int f362l;

    /* renamed from: m, reason: collision with root package name */
    private final r f363m;

    /* renamed from: n, reason: collision with root package name */
    private final s f364n;

    /* renamed from: o, reason: collision with root package name */
    private final C f365o;
    private final A p;

    /* renamed from: q, reason: collision with root package name */
    private final A f366q;

    /* renamed from: r, reason: collision with root package name */
    private final A f367r;

    /* renamed from: s, reason: collision with root package name */
    private final long f368s;

    /* renamed from: t, reason: collision with root package name */
    private final long f369t;
    private final P3.c u;

    /* renamed from: v, reason: collision with root package name */
    private C0153d f370v;

    public A(y yVar, x xVar, String str, int i2, r rVar, s sVar, C c2, A a2, A a5, A a6, long j2, long j4, P3.c cVar) {
        this.f359i = yVar;
        this.f360j = xVar;
        this.f361k = str;
        this.f362l = i2;
        this.f363m = rVar;
        this.f364n = sVar;
        this.f365o = c2;
        this.p = a2;
        this.f366q = a5;
        this.f367r = a6;
        this.f368s = j2;
        this.f369t = j4;
        this.u = cVar;
    }

    public static String h0(A a2, String str) {
        Objects.requireNonNull(a2);
        String strD = a2.f364n.d(str);
        if (strD == null) {
            return null;
        }
        return strD;
    }

    public final C0153d H() {
        C0153d c0153d = this.f370v;
        if (c0153d != null) {
            return c0153d;
        }
        C0153d c0153dB = C0153d.f406n.b(this.f364n);
        this.f370v = c0153dB;
        return c0153dB;
    }

    public final A I() {
        return this.f366q;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        C c2 = this.f365o;
        if (c2 == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        c2.close();
    }

    public final int e0() {
        return this.f362l;
    }

    public final C f() {
        return this.f365o;
    }

    public final P3.c f0() {
        return this.u;
    }

    public final r g0() {
        return this.f363m;
    }

    public final s i0() {
        return this.f364n;
    }

    public final String j0() {
        return this.f361k;
    }

    public final A k0() {
        return this.p;
    }

    public final A l0() {
        return this.f367r;
    }

    public final x m0() {
        return this.f360j;
    }

    public final long n0() {
        return this.f369t;
    }

    public final y o0() {
        return this.f359i;
    }

    public final long p0() {
        return this.f368s;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("Response{protocol=");
        sbD.append(this.f360j);
        sbD.append(", code=");
        sbD.append(this.f362l);
        sbD.append(", message=");
        sbD.append(this.f361k);
        sbD.append(", url=");
        sbD.append(this.f359i.h());
        sbD.append('}');
        return sbD.toString();
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private y f371a;

        /* renamed from: b, reason: collision with root package name */
        private x f372b;

        /* renamed from: c, reason: collision with root package name */
        private int f373c;
        private String d;

        /* renamed from: e, reason: collision with root package name */
        private r f374e;

        /* renamed from: f, reason: collision with root package name */
        private s.a f375f;
        private C g;

        /* renamed from: h, reason: collision with root package name */
        private A f376h;

        /* renamed from: i, reason: collision with root package name */
        private A f377i;

        /* renamed from: j, reason: collision with root package name */
        private A f378j;

        /* renamed from: k, reason: collision with root package name */
        private long f379k;

        /* renamed from: l, reason: collision with root package name */
        private long f380l;

        /* renamed from: m, reason: collision with root package name */
        private P3.c f381m;

        public a() {
            this.f373c = -1;
            this.f375f = new s.a();
        }

        private final void e(String str, A a2) {
            if (a2 == null) {
                return;
            }
            if (!(a2.f() == null)) {
                throw new IllegalArgumentException(f3.c.h(str, ".body != null").toString());
            }
            if (!(a2.k0() == null)) {
                throw new IllegalArgumentException(f3.c.h(str, ".networkResponse != null").toString());
            }
            if (!(a2.I() == null)) {
                throw new IllegalArgumentException(f3.c.h(str, ".cacheResponse != null").toString());
            }
            if (!(a2.l0() == null)) {
                throw new IllegalArgumentException(f3.c.h(str, ".priorResponse != null").toString());
            }
        }

        public final a a(String str, String str2) {
            f3.c.d(str2, "value");
            this.f375f.a(str, str2);
            return this;
        }

        public final a b(C c2) {
            this.g = c2;
            return this;
        }

        public final A c() {
            int i2 = this.f373c;
            if (!(i2 >= 0)) {
                throw new IllegalStateException(f3.c.h("code < 0: ", Integer.valueOf(i2)).toString());
            }
            y yVar = this.f371a;
            if (yVar == null) {
                throw new IllegalStateException("request == null".toString());
            }
            x xVar = this.f372b;
            if (xVar == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.d;
            if (str != null) {
                return new A(yVar, xVar, str, i2, this.f374e, this.f375f.c(), this.g, this.f376h, this.f377i, this.f378j, this.f379k, this.f380l, this.f381m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public final a d(A a2) {
            e("cacheResponse", a2);
            this.f377i = a2;
            return this;
        }

        public final a f(int i2) {
            this.f373c = i2;
            return this;
        }

        public final int g() {
            return this.f373c;
        }

        public final a h(r rVar) {
            this.f374e = rVar;
            return this;
        }

        public final a i() {
            this.f375f.f("Proxy-Authenticate", "OkHttp-Preemptive");
            return this;
        }

        public final a j(s sVar) {
            this.f375f = sVar.i();
            return this;
        }

        public final void k(P3.c cVar) {
            f3.c.d(cVar, "deferredTrailers");
            this.f381m = cVar;
        }

        public final a l(String str) {
            f3.c.d(str, "message");
            this.d = str;
            return this;
        }

        public final a m(A a2) {
            e("networkResponse", a2);
            this.f376h = a2;
            return this;
        }

        public final a n(A a2) {
            if (!(a2.f() == null)) {
                throw new IllegalArgumentException("priorResponse.body != null".toString());
            }
            this.f378j = a2;
            return this;
        }

        public final a o(x xVar) {
            f3.c.d(xVar, "protocol");
            this.f372b = xVar;
            return this;
        }

        public final a p(long j2) {
            this.f380l = j2;
            return this;
        }

        public final a q(y yVar) {
            f3.c.d(yVar, "request");
            this.f371a = yVar;
            return this;
        }

        public final a r(long j2) {
            this.f379k = j2;
            return this;
        }

        public a(A a2) {
            f3.c.d(a2, "response");
            this.f373c = -1;
            this.f371a = a2.o0();
            this.f372b = a2.m0();
            this.f373c = a2.e0();
            this.d = a2.j0();
            this.f374e = a2.g0();
            this.f375f = a2.i0().i();
            this.g = a2.f();
            this.f376h = a2.k0();
            this.f377i = a2.I();
            this.f378j = a2.l0();
            this.f379k = a2.p0();
            this.f380l = a2.n0();
            this.f381m = a2.f0();
        }
    }
}
