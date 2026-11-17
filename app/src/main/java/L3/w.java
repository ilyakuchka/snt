package L3;

import L3.p;
import T3.h;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class w implements Cloneable {

    /* renamed from: H, reason: collision with root package name */
    public static final b f501H = new b();

    /* renamed from: I, reason: collision with root package name */
    private static final List<x> f502I = M3.c.m(x.f548n, x.f546l);

    /* renamed from: J, reason: collision with root package name */
    private static final List<k> f503J = M3.c.m(k.f446e, k.f447f);

    /* renamed from: A, reason: collision with root package name */
    private final W3.d f504A;

    /* renamed from: B, reason: collision with root package name */
    private final g f505B;

    /* renamed from: C, reason: collision with root package name */
    private final W3.c f506C;

    /* renamed from: D, reason: collision with root package name */
    private final int f507D;

    /* renamed from: E, reason: collision with root package name */
    private final int f508E;

    /* renamed from: F, reason: collision with root package name */
    private final int f509F;

    /* renamed from: G, reason: collision with root package name */
    private final P3.k f510G;

    /* renamed from: i, reason: collision with root package name */
    private final n f511i;

    /* renamed from: j, reason: collision with root package name */
    private final j f512j;

    /* renamed from: k, reason: collision with root package name */
    private final List<u> f513k;

    /* renamed from: l, reason: collision with root package name */
    private final List<u> f514l;

    /* renamed from: m, reason: collision with root package name */
    private final D1.k f515m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f516n;

    /* renamed from: o, reason: collision with root package name */
    private final InterfaceC0152c f517o;
    private final boolean p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f518q;

    /* renamed from: r, reason: collision with root package name */
    private final m f519r;

    /* renamed from: s, reason: collision with root package name */
    private final o f520s;

    /* renamed from: t, reason: collision with root package name */
    private final ProxySelector f521t;
    private final InterfaceC0152c u;

    /* renamed from: v, reason: collision with root package name */
    private final SocketFactory f522v;

    /* renamed from: w, reason: collision with root package name */
    private final SSLSocketFactory f523w;

    /* renamed from: x, reason: collision with root package name */
    private final X509TrustManager f524x;

    /* renamed from: y, reason: collision with root package name */
    private final List<k> f525y;

    /* renamed from: z, reason: collision with root package name */
    private final List<x> f526z;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private n f527a = new n();

        /* renamed from: b, reason: collision with root package name */
        private j f528b = new j();

        /* renamed from: c, reason: collision with root package name */
        private final List<u> f529c = new ArrayList();
        private final List<u> d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private D1.k f530e = new D1.k(p.f471a, 7);

        /* renamed from: f, reason: collision with root package name */
        private boolean f531f = true;
        private InterfaceC0152c g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f532h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f533i;

        /* renamed from: j, reason: collision with root package name */
        private m f534j;

        /* renamed from: k, reason: collision with root package name */
        private o f535k;

        /* renamed from: l, reason: collision with root package name */
        private InterfaceC0152c f536l;

        /* renamed from: m, reason: collision with root package name */
        private SocketFactory f537m;

        /* renamed from: n, reason: collision with root package name */
        private List<k> f538n;

        /* renamed from: o, reason: collision with root package name */
        private List<? extends x> f539o;
        private W3.d p;

        /* renamed from: q, reason: collision with root package name */
        private g f540q;

        /* renamed from: r, reason: collision with root package name */
        private int f541r;

        /* renamed from: s, reason: collision with root package name */
        private int f542s;

        /* renamed from: t, reason: collision with root package name */
        private int f543t;
        private long u;

        public a() {
            InterfaceC0152c interfaceC0152c = InterfaceC0152c.f405a;
            this.g = interfaceC0152c;
            this.f532h = true;
            this.f533i = true;
            this.f534j = m.f466b;
            this.f535k = o.f470c;
            this.f536l = interfaceC0152c;
            SocketFactory socketFactory = SocketFactory.getDefault();
            f3.c.c(socketFactory, "getDefault()");
            this.f537m = socketFactory;
            b bVar = w.f501H;
            this.f538n = w.f503J;
            this.f539o = w.f502I;
            this.p = W3.d.f1821a;
            this.f540q = g.d;
            this.f541r = 10000;
            this.f542s = 10000;
            this.f543t = 10000;
            this.u = 1024L;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<L3.u>] */
        public final a a(u uVar) {
            this.d.add(uVar);
            return this;
        }

        public final a b() {
            f3.c.d(TimeUnit.MILLISECONDS, "unit");
            this.f541r = M3.c.c();
            return this;
        }

        public final InterfaceC0152c c() {
            return this.g;
        }

        public final g d() {
            return this.f540q;
        }

        public final int e() {
            return this.f541r;
        }

        public final j f() {
            return this.f528b;
        }

        public final List<k> g() {
            return this.f538n;
        }

        public final m h() {
            return this.f534j;
        }

        public final n i() {
            return this.f527a;
        }

        public final o j() {
            return this.f535k;
        }

        public final p.b k() {
            return this.f530e;
        }

        public final boolean l() {
            return this.f532h;
        }

        public final boolean m() {
            return this.f533i;
        }

        public final HostnameVerifier n() {
            return this.p;
        }

        public final List<u> o() {
            return this.f529c;
        }

        public final List<u> p() {
            return this.d;
        }

        public final List<x> q() {
            return this.f539o;
        }

        public final InterfaceC0152c r() {
            return this.f536l;
        }

        public final int s() {
            return this.f542s;
        }

        public final boolean t() {
            return this.f531f;
        }

        public final SocketFactory u() {
            return this.f537m;
        }

        public final int v() {
            return this.f543t;
        }

        public final a w() {
            f3.c.d(TimeUnit.MILLISECONDS, "unit");
            this.f542s = M3.c.c();
            return this;
        }

        public final a x() {
            f3.c.d(TimeUnit.MILLISECONDS, "unit");
            this.f543t = M3.c.c();
            return this;
        }
    }

    public static final class b {
    }

    public w(a aVar) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z4;
        boolean z5;
        this.f511i = aVar.i();
        this.f512j = aVar.f();
        this.f513k = M3.c.y(aVar.o());
        this.f514l = M3.c.y(aVar.p());
        this.f515m = (D1.k) aVar.k();
        this.f516n = aVar.t();
        this.f517o = aVar.c();
        this.p = aVar.l();
        this.f518q = aVar.m();
        this.f519r = aVar.h();
        this.f520s = aVar.j();
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.f521t = proxySelector == null ? V3.a.f1769a : proxySelector;
        this.u = aVar.r();
        this.f522v = aVar.u();
        List<k> listG = aVar.g();
        this.f525y = listG;
        this.f526z = aVar.q();
        this.f504A = (W3.d) aVar.n();
        this.f507D = aVar.e();
        this.f508E = aVar.s();
        this.f509F = aVar.v();
        this.f510G = new P3.k();
        if ((listG instanceof Collection) && listG.isEmpty()) {
            z4 = true;
        } else {
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                if (((k) it.next()).f()) {
                    z4 = false;
                    break;
                }
            }
            z4 = true;
        }
        if (z4) {
            this.f523w = null;
            this.f506C = null;
            this.f524x = null;
            this.f505B = g.d;
        } else {
            h.a aVar2 = T3.h.f1639a;
            X509TrustManager x509TrustManagerL = T3.h.f1640b.l();
            this.f524x = x509TrustManagerL;
            T3.h hVar = T3.h.f1640b;
            f3.c.b(x509TrustManagerL);
            this.f523w = hVar.k(x509TrustManagerL);
            W3.c cVarC = T3.h.f1640b.c(x509TrustManagerL);
            this.f506C = cVarC;
            g gVarD = aVar.d();
            f3.c.b(cVarC);
            this.f505B = gVarD.d(cVarC);
        }
        if (!(!this.f513k.contains(null))) {
            throw new IllegalStateException(f3.c.h("Null interceptor: ", this.f513k).toString());
        }
        if (!(!this.f514l.contains(null))) {
            throw new IllegalStateException(f3.c.h("Null network interceptor: ", this.f514l).toString());
        }
        List<k> list = this.f525y;
        if ((list instanceof Collection) && list.isEmpty()) {
            z5 = true;
        } else {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((k) it2.next()).f()) {
                    z5 = false;
                    break;
                }
            }
            z5 = true;
        }
        if (!z5) {
            if (this.f523w == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.f506C == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.f524x == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.f523w == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f506C == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f524x == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!f3.c.a(this.f505B, g.d)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final InterfaceC0152c c() {
        return this.f517o;
    }

    public final Object clone() {
        return super.clone();
    }

    public final g d() {
        return this.f505B;
    }

    public final int e() {
        return this.f507D;
    }

    public final j f() {
        return this.f512j;
    }

    public final List<k> g() {
        return this.f525y;
    }

    public final m h() {
        return this.f519r;
    }

    public final n i() {
        return this.f511i;
    }

    public final o j() {
        return this.f520s;
    }

    public final p.b k() {
        return this.f515m;
    }

    public final boolean l() {
        return this.p;
    }

    public final boolean m() {
        return this.f518q;
    }

    public final P3.k n() {
        return this.f510G;
    }

    public final HostnameVerifier o() {
        return this.f504A;
    }

    public final List<u> p() {
        return this.f513k;
    }

    public final List<u> q() {
        return this.f514l;
    }

    public final InterfaceC0154e r(y yVar) {
        f3.c.d(yVar, "request");
        return new P3.e(this, yVar, false);
    }

    public final List<x> s() {
        return this.f526z;
    }

    public final InterfaceC0152c t() {
        return this.u;
    }

    public final ProxySelector u() {
        return this.f521t;
    }

    public final int v() {
        return this.f508E;
    }

    public final boolean w() {
        return this.f516n;
    }

    public final SocketFactory x() {
        return this.f522v;
    }

    public final SSLSocketFactory y() {
        SSLSocketFactory sSLSocketFactory = this.f523w;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int z() {
        return this.f509F;
    }

    public w() {
        this(new a());
    }
}
