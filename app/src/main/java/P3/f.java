package P3;

import L3.A;
import L3.C0150a;
import L3.D;
import L3.InterfaceC0154e;
import L3.p;
import L3.r;
import L3.t;
import L3.w;
import L3.x;
import L3.y;
import S3.f;
import S3.q;
import T3.h;
import X3.n;
import X3.s;
import X3.z;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class f extends f.c implements L3.i {

    /* renamed from: b, reason: collision with root package name */
    private final D f1022b;

    /* renamed from: c, reason: collision with root package name */
    private Socket f1023c;
    private Socket d;

    /* renamed from: e, reason: collision with root package name */
    private r f1024e;

    /* renamed from: f, reason: collision with root package name */
    private x f1025f;
    private S3.f g;

    /* renamed from: h, reason: collision with root package name */
    private s f1026h;

    /* renamed from: i, reason: collision with root package name */
    private X3.r f1027i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1028j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1029k;

    /* renamed from: l, reason: collision with root package name */
    private int f1030l;

    /* renamed from: m, reason: collision with root package name */
    private int f1031m;

    /* renamed from: n, reason: collision with root package name */
    private int f1032n;

    /* renamed from: o, reason: collision with root package name */
    private int f1033o;
    private final List<Reference<e>> p;

    /* renamed from: q, reason: collision with root package name */
    private long f1034q;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1035a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            f1035a = iArr;
        }
    }

    public f(j jVar, D d) {
        f3.c.d(jVar, "connectionPool");
        f3.c.d(d, "route");
        this.f1022b = d;
        this.f1033o = 1;
        this.p = new ArrayList();
        this.f1034q = Long.MAX_VALUE;
    }

    private final void g(int i2, int i4, InterfaceC0154e interfaceC0154e, p pVar) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyB = this.f1022b.b();
        C0150a c0150aA = this.f1022b.a();
        Proxy.Type type = proxyB.type();
        int i5 = type == null ? -1 : a.f1035a[type.ordinal()];
        if (i5 == 1 || i5 == 2) {
            socketCreateSocket = c0150aA.j().createSocket();
            f3.c.b(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxyB);
        }
        this.f1023c = socketCreateSocket;
        InetSocketAddress inetSocketAddressD = this.f1022b.d();
        Objects.requireNonNull(pVar);
        f3.c.d(interfaceC0154e, "call");
        f3.c.d(inetSocketAddressD, "inetSocketAddress");
        socketCreateSocket.setSoTimeout(i4);
        try {
            h.a aVar = T3.h.f1639a;
            T3.h hVar = T3.h.f1640b;
            InetSocketAddress inetSocketAddressD2 = this.f1022b.d();
            Objects.requireNonNull(hVar);
            f3.c.d(inetSocketAddressD2, "address");
            socketCreateSocket.connect(inetSocketAddressD2, i2);
            try {
                this.f1026h = new s(n.h(socketCreateSocket));
                this.f1027i = (X3.r) n.b(n.f(socketCreateSocket));
            } catch (NullPointerException e2) {
                if (f3.c.a(e2.getMessage(), "throw with null exception")) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e4) {
            ConnectException connectException = new ConnectException(f3.c.h("Failed to connect to ", this.f1022b.d()));
            connectException.initCause(e4);
            throw connectException;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x014c, code lost:
    
        if (r3 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x014f, code lost:
    
        r5 = r17.f1023c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0151, code lost:
    
        if (r5 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0154, code lost:
    
        M3.c.f(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0157, code lost:
    
        r5 = null;
        r17.f1023c = null;
        r17.f1027i = null;
        r17.f1026h = null;
        r6 = r17.f1022b.d();
        r10 = r17.f1022b.b();
        f3.c.d(r21, "call");
        f3.c.d(r6, "inetSocketAddress");
        f3.c.d(r10, "proxy");
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(int i2, int i4, int i5, InterfaceC0154e interfaceC0154e, p pVar) throws IOException {
        y.a aVar = new y.a();
        aVar.g(this.f1022b.a().l());
        w wVar = null;
        aVar.e("CONNECT", null);
        boolean z4 = true;
        aVar.c("Host", M3.c.x(this.f1022b.a().l(), true));
        aVar.c("Proxy-Connection", "Keep-Alive");
        aVar.c("User-Agent", "okhttp/4.10.0");
        y yVarB = aVar.b();
        A.a aVar2 = new A.a();
        aVar2.q(yVarB);
        aVar2.o(x.f546l);
        aVar2.f(407);
        aVar2.l("Preemptive Authenticate");
        aVar2.b(M3.c.f598c);
        aVar2.r(-1L);
        aVar2.p(-1L);
        aVar2.i();
        y yVarD = this.f1022b.a().h().d(this.f1022b, aVar2.c());
        if (yVarD != null) {
            yVarB = yVarD;
        }
        t tVarH = yVarB.h();
        int i6 = 0;
        while (i6 < 21) {
            i6++;
            g(i2, i4, interfaceC0154e, pVar);
            StringBuilder sbD = D2.e.d("CONNECT ");
            sbD.append(M3.c.x(tVarH, z4));
            sbD.append(" HTTP/1.1");
            String string = sbD.toString();
            while (true) {
                s sVar = this.f1026h;
                f3.c.b(sVar);
                X3.r rVar = this.f1027i;
                f3.c.b(rVar);
                R3.b bVar = new R3.b(wVar, this, sVar, rVar);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                sVar.c().g(i4);
                rVar.c().g(i5);
                string = string;
                bVar.t(yVarB.e(), string);
                bVar.c();
                A.a aVarG = bVar.g(false);
                f3.c.b(aVarG);
                aVarG.q(yVarB);
                A aC = aVarG.c();
                bVar.s(aC);
                int iE0 = aC.e0();
                if (iE0 != 200) {
                    if (iE0 != 407) {
                        throw new IOException(f3.c.h("Unexpected response code for CONNECT: ", Integer.valueOf(aC.e0())));
                    }
                    y yVarD2 = this.f1022b.a().h().d(this.f1022b, aC);
                    if (yVarD2 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                    if (i3.f.q("close", A.h0(aC, "Connection"))) {
                        yVarB = yVarD2;
                        break;
                    } else {
                        yVarB = yVarD2;
                        wVar = null;
                    }
                } else {
                    if (!sVar.f1877j.V() || !rVar.f1874j.V()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    yVarB = null;
                }
            }
        }
    }

    private final void i(b bVar, InterfaceC0154e interfaceC0154e, p pVar) throws Throwable {
        x xVarA = x.f546l;
        if (this.f1022b.a().k() == null) {
            List<x> listF = this.f1022b.a().f();
            x xVar = x.f549o;
            if (!listF.contains(xVar)) {
                this.d = this.f1023c;
                this.f1025f = xVarA;
                return;
            } else {
                this.d = this.f1023c;
                this.f1025f = xVar;
                z();
                return;
            }
        }
        Objects.requireNonNull(pVar);
        f3.c.d(interfaceC0154e, "call");
        C0150a c0150aA = this.f1022b.a();
        SSLSocketFactory sSLSocketFactoryK = c0150aA.k();
        SSLSocket sSLSocket = null;
        String strF = null;
        try {
            f3.c.b(sSLSocketFactoryK);
            Socket socketCreateSocket = sSLSocketFactoryK.createSocket(this.f1023c, c0150aA.l().g(), c0150aA.l().j(), true);
            if (socketCreateSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                L3.k kVarA = bVar.a(sSLSocket2);
                if (kVarA.g()) {
                    h.a aVar = T3.h.f1639a;
                    T3.h.f1640b.e(sSLSocket2, c0150aA.l().g(), c0150aA.f());
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                r.a aVar2 = r.f472e;
                f3.c.c(session, "sslSocketSession");
                r rVarA = aVar2.a(session);
                HostnameVerifier hostnameVerifierE = c0150aA.e();
                f3.c.b(hostnameVerifierE);
                if (hostnameVerifierE.verify(c0150aA.l().g(), session)) {
                    L3.g gVarA = c0150aA.a();
                    f3.c.b(gVarA);
                    this.f1024e = new r(rVarA.e(), rVarA.a(), rVarA.c(), new g(gVarA, rVarA, c0150aA));
                    gVarA.b(c0150aA.l().g(), new h(this));
                    if (kVarA.g()) {
                        h.a aVar3 = T3.h.f1639a;
                        strF = T3.h.f1640b.f(sSLSocket2);
                    }
                    this.d = sSLSocket2;
                    this.f1026h = new s(n.h(sSLSocket2));
                    this.f1027i = (X3.r) n.b(n.f(sSLSocket2));
                    if (strF != null) {
                        xVarA = x.f544j.a(strF);
                    }
                    this.f1025f = xVarA;
                    h.a aVar4 = T3.h.f1639a;
                    T3.h.f1640b.b(sSLSocket2);
                    if (this.f1025f == x.f548n) {
                        z();
                        return;
                    }
                    return;
                }
                List<Certificate> listD = rVarA.d();
                if (!(!listD.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + c0150aA.l().g() + " not verified (no certificates)");
                }
                X509Certificate x509Certificate = (X509Certificate) listD.get(0);
                throw new SSLPeerUnverifiedException(i3.f.E("\n              |Hostname " + c0150aA.l().g() + " not verified:\n              |    certificate: " + L3.g.f421c.a(x509Certificate) + "\n              |    DN: " + ((Object) x509Certificate.getSubjectDN().getName()) + "\n              |    subjectAltNames: " + W3.d.f1821a.a(x509Certificate) + "\n              "));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    h.a aVar5 = T3.h.f1639a;
                    T3.h.f1640b.b(sSLSocket);
                }
                if (sSLSocket != null) {
                    M3.c.f(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void z() throws IOException {
        Socket socket = this.d;
        f3.c.b(socket);
        s sVar = this.f1026h;
        f3.c.b(sVar);
        X3.r rVar = this.f1027i;
        f3.c.b(rVar);
        socket.setSoTimeout(0);
        f.a aVar = new f.a(O3.d.f855i);
        aVar.h(socket, this.f1022b.a().l().g(), sVar, rVar);
        aVar.f(this);
        aVar.g();
        S3.f fVar = new S3.f(aVar);
        this.g = fVar;
        f.b bVar = S3.f.f1401K;
        this.f1033o = S3.f.L.d();
        S3.f.R0(fVar);
    }

    public final synchronized void A(e eVar, IOException iOException) {
        f3.c.d(eVar, "call");
        if (iOException instanceof S3.r) {
            if (((S3.r) iOException).f1519i == S3.b.REFUSED_STREAM) {
                int i2 = this.f1032n + 1;
                this.f1032n = i2;
                if (i2 > 1) {
                    this.f1028j = true;
                    this.f1030l++;
                }
            } else if (((S3.r) iOException).f1519i != S3.b.CANCEL || !eVar.q()) {
                this.f1028j = true;
                this.f1030l++;
            }
        } else if (!r() || (iOException instanceof S3.a)) {
            this.f1028j = true;
            if (this.f1031m == 0) {
                if (iOException != null) {
                    f(eVar.j(), this.f1022b, iOException);
                }
                this.f1030l++;
            }
        }
    }

    @Override // S3.f.c
    public final synchronized void a(S3.f fVar, q qVar) {
        f3.c.d(fVar, "connection");
        f3.c.d(qVar, "settings");
        this.f1033o = qVar.d();
    }

    @Override // S3.f.c
    public final void b(S3.l lVar) throws IOException {
        f3.c.d(lVar, "stream");
        lVar.d(S3.b.REFUSED_STREAM, null);
    }

    public final void d() {
        Socket socket = this.f1023c;
        if (socket == null) {
            return;
        }
        M3.c.f(socket);
    }

    public final void e(int i2, int i4, int i5, boolean z4, InterfaceC0154e interfaceC0154e, p pVar) throws Throwable {
        f3.c.d(interfaceC0154e, "call");
        f3.c.d(pVar, "eventListener");
        if (!(this.f1025f == null)) {
            throw new IllegalStateException("already connected".toString());
        }
        List<L3.k> listB = this.f1022b.a().b();
        b bVar = new b(listB);
        if (this.f1022b.a().k() == null) {
            if (!listB.contains(L3.k.f447f)) {
                throw new l(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strG = this.f1022b.a().l().g();
            h.a aVar = T3.h.f1639a;
            if (!T3.h.f1640b.h(strG)) {
                throw new l(new UnknownServiceException(C2.c.a("CLEARTEXT communication to ", strG, " not permitted by network security policy")));
            }
        } else if (this.f1022b.a().f().contains(x.f549o)) {
            throw new l(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        l lVar = null;
        do {
            try {
                if (this.f1022b.c()) {
                    h(i2, i4, i5, interfaceC0154e, pVar);
                    if (this.f1023c == null) {
                        if (!this.f1022b.c() && this.f1023c == null) {
                            throw new l(new ProtocolException("Too many tunnel connections attempted: 21"));
                        }
                        this.f1034q = System.nanoTime();
                        return;
                    }
                } else {
                    try {
                        g(i2, i4, interfaceC0154e, pVar);
                    } catch (IOException e2) {
                        e = e2;
                        Socket socket = this.d;
                        if (socket != null) {
                            M3.c.f(socket);
                        }
                        Socket socket2 = this.f1023c;
                        if (socket2 != null) {
                            M3.c.f(socket2);
                        }
                        this.d = null;
                        this.f1023c = null;
                        this.f1026h = null;
                        this.f1027i = null;
                        this.f1024e = null;
                        this.f1025f = null;
                        this.g = null;
                        this.f1033o = 1;
                        InetSocketAddress inetSocketAddressD = this.f1022b.d();
                        Proxy proxyB = this.f1022b.b();
                        f3.c.d(inetSocketAddressD, "inetSocketAddress");
                        f3.c.d(proxyB, "proxy");
                        if (lVar == null) {
                            lVar = new l(e);
                        } else {
                            lVar.a(e);
                        }
                        if (!z4) {
                            throw lVar;
                        }
                    }
                }
                i(bVar, interfaceC0154e, pVar);
                InetSocketAddress inetSocketAddressD2 = this.f1022b.d();
                Proxy proxyB2 = this.f1022b.b();
                f3.c.d(inetSocketAddressD2, "inetSocketAddress");
                f3.c.d(proxyB2, "proxy");
                if (!this.f1022b.c()) {
                }
                this.f1034q = System.nanoTime();
                return;
            } catch (IOException e4) {
                e = e4;
            }
        } while (bVar.b(e));
        throw lVar;
    }

    public final void f(w wVar, D d, IOException iOException) {
        f3.c.d(wVar, "client");
        f3.c.d(d, "failedRoute");
        f3.c.d(iOException, "failure");
        if (d.b().type() != Proxy.Type.DIRECT) {
            C0150a c0150aA = d.a();
            c0150aA.i().connectFailed(c0150aA.l().q(), d.b().address(), iOException);
        }
        wVar.n().b(d);
    }

    public final List<Reference<e>> j() {
        return this.p;
    }

    public final long k() {
        return this.f1034q;
    }

    public final boolean l() {
        return this.f1028j;
    }

    public final int m() {
        return this.f1030l;
    }

    public final r n() {
        return this.f1024e;
    }

    public final synchronized void o() {
        this.f1031m++;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<java.lang.ref.Reference<P3.e>>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean p(C0150a c0150a, List<D> list) {
        boolean z4;
        boolean z5;
        r rVar;
        f3.c.d(c0150a, "address");
        byte[] bArr = M3.c.f596a;
        if (this.p.size() >= this.f1033o || this.f1028j || !this.f1022b.a().d(c0150a)) {
            return false;
        }
        if (f3.c.a(c0150a.l().g(), this.f1022b.a().l().g())) {
            return true;
        }
        if (this.g != null && list != null) {
            if (list.isEmpty()) {
                z4 = false;
                if (z4) {
                    HostnameVerifier hostnameVerifierE = c0150a.e();
                    W3.d dVar = W3.d.f1821a;
                    if (hostnameVerifierE != dVar) {
                        return false;
                    }
                    t tVarL = c0150a.l();
                    byte[] bArr2 = M3.c.f596a;
                    t tVarL2 = this.f1022b.a().l();
                    if (tVarL.j() == tVarL2.j()) {
                        if (!f3.c.a(tVarL.g(), tVarL2.g())) {
                            if (!this.f1029k && (rVar = this.f1024e) != null) {
                                List<Certificate> listD = rVar.d();
                                if ((listD.isEmpty() ^ true) && dVar.e(tVarL.g(), (X509Certificate) listD.get(0))) {
                                }
                                if (z5) {
                                    return false;
                                }
                                try {
                                    L3.g gVarA = c0150a.a();
                                    f3.c.b(gVarA);
                                    String strG = c0150a.l().g();
                                    r rVar2 = this.f1024e;
                                    f3.c.b(rVar2);
                                    gVarA.a(strG, rVar2.d());
                                    return true;
                                } catch (SSLPeerUnverifiedException unused) {
                                }
                            }
                            z5 = false;
                            if (z5) {
                            }
                        }
                        z5 = true;
                        if (z5) {
                        }
                    } else {
                        z5 = false;
                        if (z5) {
                        }
                    }
                }
            } else {
                for (D d : list) {
                    if (d.b().type() == Proxy.Type.DIRECT && this.f1022b.b().type() == Proxy.Type.DIRECT && f3.c.a(this.f1022b.d(), d.d())) {
                        z4 = true;
                        break;
                    }
                }
                z4 = false;
                if (z4) {
                }
            }
        }
        return false;
    }

    public final boolean q(boolean z4) throws SocketException {
        long j2;
        byte[] bArr = M3.c.f596a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f1023c;
        f3.c.b(socket);
        Socket socket2 = this.d;
        f3.c.b(socket2);
        s sVar = this.f1026h;
        f3.c.b(sVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        S3.f fVar = this.g;
        if (fVar != null) {
            return fVar.F0(jNanoTime);
        }
        synchronized (this) {
            j2 = jNanoTime - this.f1034q;
        }
        if (j2 < 10000000000L || !z4) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                boolean z5 = !sVar.V();
                socket2.setSoTimeout(soTimeout);
                return z5;
            } catch (Throwable th) {
                socket2.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final boolean r() {
        return this.g != null;
    }

    public final Q3.d s(w wVar, Q3.f fVar) throws SocketException {
        f3.c.d(wVar, "client");
        Socket socket = this.d;
        f3.c.b(socket);
        s sVar = this.f1026h;
        f3.c.b(sVar);
        X3.r rVar = this.f1027i;
        f3.c.b(rVar);
        S3.f fVar2 = this.g;
        if (fVar2 != null) {
            return new S3.j(wVar, this, fVar, fVar2);
        }
        socket.setSoTimeout(fVar.k());
        z zVarC = sVar.c();
        long jG = fVar.g();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zVarC.g(jG);
        rVar.c().g(fVar.i());
        return new R3.b(wVar, this, sVar, rVar);
    }

    public final synchronized void t() {
        this.f1029k = true;
    }

    public final String toString() {
        L3.h hVarA;
        StringBuilder sbD = D2.e.d("Connection{");
        sbD.append(this.f1022b.a().l().g());
        sbD.append(':');
        sbD.append(this.f1022b.a().l().j());
        sbD.append(", proxy=");
        sbD.append(this.f1022b.b());
        sbD.append(" hostAddress=");
        sbD.append(this.f1022b.d());
        sbD.append(" cipherSuite=");
        r rVar = this.f1024e;
        Object obj = "none";
        if (rVar != null && (hVarA = rVar.a()) != null) {
            obj = hVarA;
        }
        sbD.append(obj);
        sbD.append(" protocol=");
        sbD.append(this.f1025f);
        sbD.append('}');
        return sbD.toString();
    }

    public final synchronized void u() {
        this.f1028j = true;
    }

    public final D v() {
        return this.f1022b;
    }

    public final void w(long j2) {
        this.f1034q = j2;
    }

    public final void x() {
        this.f1028j = true;
    }

    public final Socket y() {
        Socket socket = this.d;
        f3.c.b(socket);
        return socket;
    }
}
