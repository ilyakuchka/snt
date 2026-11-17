package P3;

import L3.A;
import L3.C0150a;
import L3.InterfaceC0152c;
import L3.InterfaceC0154e;
import L3.o;
import L3.p;
import L3.t;
import L3.w;
import L3.y;
import T3.h;
import X3.C0174a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class e implements InterfaceC0154e {

    /* renamed from: i, reason: collision with root package name */
    private final w f1001i;

    /* renamed from: j, reason: collision with root package name */
    private final y f1002j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f1003k;

    /* renamed from: l, reason: collision with root package name */
    private final j f1004l;

    /* renamed from: m, reason: collision with root package name */
    private final p f1005m;

    /* renamed from: n, reason: collision with root package name */
    private final c f1006n;

    /* renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f1007o;
    private Throwable p;

    /* renamed from: q, reason: collision with root package name */
    private d f1008q;

    /* renamed from: r, reason: collision with root package name */
    private f f1009r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f1010s;

    /* renamed from: t, reason: collision with root package name */
    private P3.c f1011t;
    private boolean u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1012v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f1013w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f1014x;

    /* renamed from: y, reason: collision with root package name */
    private volatile P3.c f1015y;

    /* renamed from: z, reason: collision with root package name */
    private volatile f f1016z;

    public final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        private final L3.f f1017i;

        /* renamed from: j, reason: collision with root package name */
        private volatile AtomicInteger f1018j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ e f1019k;

        public a(e eVar, L3.f fVar) {
            f3.c.d(eVar, "this$0");
            this.f1019k = eVar;
            this.f1017i = fVar;
            this.f1018j = new AtomicInteger(0);
        }

        public final void a(ExecutorService executorService) {
            Objects.requireNonNull(this.f1019k.j());
            byte[] bArr = M3.c.f596a;
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    this.f1019k.s(interruptedIOException);
                    this.f1017i.a(interruptedIOException);
                    this.f1019k.j().i().d(this);
                }
            } catch (Throwable th) {
                this.f1019k.j().i().d(this);
                throw th;
            }
        }

        public final e b() {
            return this.f1019k;
        }

        public final AtomicInteger c() {
            return this.f1018j;
        }

        public final String d() {
            return this.f1019k.n().h().g();
        }

        public final void e(a aVar) {
            this.f1018j = aVar.f1018j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            w wVarJ;
            String strH = f3.c.h("OkHttp ", this.f1019k.t());
            e eVar = this.f1019k;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(strH);
            try {
                eVar.f1006n.r();
                boolean z4 = false;
                try {
                    try {
                        try {
                            this.f1017i.b(eVar.o());
                            wVarJ = eVar.j();
                        } catch (IOException e2) {
                            e = e2;
                            z4 = true;
                            if (z4) {
                                h.a aVar = T3.h.f1639a;
                                T3.h.f1640b.i(f3.c.h("Callback failure for ", e.b(eVar)), 4, e);
                            } else {
                                this.f1017i.a(e);
                            }
                            wVarJ = eVar.j();
                            wVarJ.i().d(this);
                        } catch (Throwable th) {
                            th = th;
                            z4 = true;
                            eVar.e();
                            if (!z4) {
                                IOException iOException = new IOException(f3.c.h("canceled due to ", th));
                                Y1.a.a(iOException, th);
                                this.f1017i.a(iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        eVar.j().i().d(this);
                        throw th2;
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th3) {
                    th = th3;
                }
                wVarJ.i().d(this);
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    public static final class b extends WeakReference<e> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f1020a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, Object obj) {
            super(eVar);
            f3.c.d(eVar, "referent");
            this.f1020a = obj;
        }

        public final Object a() {
            return this.f1020a;
        }
    }

    public static final class c extends C0174a {
        c() {
        }

        @Override // X3.C0174a
        protected final void u() {
            e.this.e();
        }
    }

    public e(w wVar, y yVar, boolean z4) {
        f3.c.d(wVar, "client");
        f3.c.d(yVar, "originalRequest");
        this.f1001i = wVar;
        this.f1002j = yVar;
        this.f1003k = z4;
        this.f1004l = wVar.f().a();
        p pVar = (p) ((D1.k) wVar.k()).f85b;
        byte[] bArr = M3.c.f596a;
        f3.c.d(pVar, "$this_asFactory");
        this.f1005m = pVar;
        c cVar = new c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        cVar.g(0);
        this.f1006n = cVar;
        this.f1007o = new AtomicBoolean();
        this.f1013w = true;
    }

    public static final String b(e eVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(eVar.f1014x ? "canceled " : "");
        sb.append(eVar.f1003k ? "web socket" : "call");
        sb.append(" to ");
        sb.append(eVar.f1002j.h().o());
        return sb.toString();
    }

    private final <E extends IOException> E d(E e2) throws IOException {
        E interruptedIOException;
        Socket socketU;
        byte[] bArr = M3.c.f596a;
        f fVar = this.f1009r;
        if (fVar != null) {
            synchronized (fVar) {
                socketU = u();
            }
            if (this.f1009r == null) {
                if (socketU != null) {
                    M3.c.f(socketU);
                }
                Objects.requireNonNull(this.f1005m);
            } else {
                if (!(socketU == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        if (!this.f1010s && this.f1006n.s()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (e2 != null) {
                interruptedIOException.initCause(e2);
            }
        } else {
            interruptedIOException = e2;
        }
        if (e2 != null) {
            p pVar = this.f1005m;
            f3.c.b(interruptedIOException);
            Objects.requireNonNull(pVar);
        } else {
            Objects.requireNonNull(this.f1005m);
        }
        return interruptedIOException;
    }

    public final void c(f fVar) {
        byte[] bArr = M3.c.f596a;
        if (!(this.f1009r == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f1009r = fVar;
        ((ArrayList) fVar.j()).add(new b(this, this.p));
    }

    public final Object clone() {
        return new e(this.f1001i, this.f1002j, this.f1003k);
    }

    public final void e() {
        if (this.f1014x) {
            return;
        }
        this.f1014x = true;
        P3.c cVar = this.f1015y;
        if (cVar != null) {
            cVar.b();
        }
        f fVar = this.f1016z;
        if (fVar != null) {
            fVar.d();
        }
        Objects.requireNonNull(this.f1005m);
    }

    public final void f(L3.f fVar) {
        if (!this.f1007o.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        h.a aVar = T3.h.f1639a;
        this.p = (Throwable) T3.h.f1640b.g("response.body().close()");
        Objects.requireNonNull(this.f1005m);
        this.f1001i.i().a(new a(this, fVar));
    }

    public final void g(y yVar, boolean z4) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierO;
        L3.g gVarD;
        f3.c.d(yVar, "request");
        if (!(this.f1011t == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.f1012v)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.u)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        if (z4) {
            j jVar = this.f1004l;
            t tVarH = yVar.h();
            if (tVarH.h()) {
                SSLSocketFactory sSLSocketFactoryY = this.f1001i.y();
                hostnameVerifierO = this.f1001i.o();
                sSLSocketFactory = sSLSocketFactoryY;
                gVarD = this.f1001i.d();
            } else {
                sSLSocketFactory = null;
                hostnameVerifierO = null;
                gVarD = null;
            }
            String strG = tVarH.g();
            int iJ = tVarH.j();
            o oVarJ = this.f1001i.j();
            SocketFactory socketFactoryX = this.f1001i.x();
            InterfaceC0152c interfaceC0152cT = this.f1001i.t();
            Objects.requireNonNull(this.f1001i);
            this.f1008q = new d(jVar, new C0150a(strG, iJ, oVarJ, socketFactoryX, sSLSocketFactory, hostnameVerifierO, gVarD, interfaceC0152cT, this.f1001i.s(), this.f1001i.g(), this.f1001i.u()), this, this.f1005m);
        }
    }

    public final A h() {
        if (!this.f1007o.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.f1006n.r();
        h.a aVar = T3.h.f1639a;
        this.p = (Throwable) T3.h.f1640b.g("response.body().close()");
        Objects.requireNonNull(this.f1005m);
        try {
            this.f1001i.i().b(this);
            return o();
        } finally {
            this.f1001i.i().e(this);
        }
    }

    public final void i(boolean z4) {
        P3.c cVar;
        synchronized (this) {
            if (!this.f1013w) {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z4 && (cVar = this.f1015y) != null) {
            cVar.d();
        }
        this.f1011t = null;
    }

    public final w j() {
        return this.f1001i;
    }

    public final f k() {
        return this.f1009r;
    }

    public final boolean l() {
        return this.f1003k;
    }

    public final P3.c m() {
        return this.f1011t;
    }

    public final y n() {
        return this.f1002j;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final A o() throws Throwable {
        ArrayList arrayList = new ArrayList();
        Z2.g.c(arrayList, this.f1001i.p());
        arrayList.add(new Q3.h(this.f1001i));
        arrayList.add(new Q3.a(this.f1001i.h()));
        Objects.requireNonNull(this.f1001i);
        arrayList.add(new N3.a());
        arrayList.add(P3.a.f973a);
        if (!this.f1003k) {
            Z2.g.c(arrayList, this.f1001i.q());
        }
        arrayList.add(new Q3.b(this.f1003k));
        boolean z4 = false;
        try {
            A aJ = new Q3.f(this, arrayList, 0, null, this.f1002j, this.f1001i.e(), this.f1001i.v(), this.f1001i.z()).j(this.f1002j);
            if (this.f1014x) {
                M3.c.e(aJ);
                throw new IOException("Canceled");
            }
            s(null);
            return aJ;
        } catch (IOException e2) {
            try {
                IOException iOExceptionS = s(e2);
                if (iOExceptionS == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                throw iOExceptionS;
            } catch (Throwable th) {
                th = th;
                z4 = true;
                if (!z4) {
                    s(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z4) {
            }
            throw th;
        }
    }

    public final P3.c p(Q3.f fVar) throws IOException {
        synchronized (this) {
            if (!this.f1013w) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.f1012v)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.u)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        d dVar = this.f1008q;
        f3.c.b(dVar);
        P3.c cVar = new P3.c(this, this.f1005m, dVar, dVar.a(this.f1001i, fVar));
        this.f1011t = cVar;
        this.f1015y = cVar;
        synchronized (this) {
            this.u = true;
            this.f1012v = true;
        }
        if (this.f1014x) {
            throw new IOException("Canceled");
        }
        return cVar;
    }

    public final boolean q() {
        return this.f1014x;
    }

    public final <E extends IOException> E r(P3.c cVar, boolean z4, boolean z5, E e2) {
        boolean z6;
        boolean z7;
        f3.c.d(cVar, "exchange");
        if (!f3.c.a(cVar, this.f1015y)) {
            return e2;
        }
        synchronized (this) {
            z6 = false;
            if (z4) {
                try {
                    if (!this.u) {
                        if (z5 || !this.f1012v) {
                            z7 = false;
                        }
                    }
                    if (z4) {
                        this.u = false;
                    }
                    if (z5) {
                        this.f1012v = false;
                    }
                    boolean z8 = this.u;
                    boolean z9 = (z8 || this.f1012v) ? false : true;
                    if (!z8 && !this.f1012v) {
                        if (!this.f1013w) {
                            z6 = true;
                        }
                    }
                    z7 = z6;
                    z6 = z9;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z5) {
                }
                z7 = false;
            }
        }
        if (z6) {
            this.f1015y = null;
            f fVar = this.f1009r;
            if (fVar != null) {
                fVar.o();
            }
        }
        return z7 ? (E) d(e2) : e2;
    }

    public final IOException s(IOException iOException) {
        boolean z4;
        synchronized (this) {
            z4 = false;
            if (this.f1013w) {
                this.f1013w = false;
                if (!this.u) {
                    if (!this.f1012v) {
                        z4 = true;
                    }
                }
            }
        }
        return z4 ? d(iOException) : iOException;
    }

    public final String t() {
        return this.f1002j.h().o();
    }

    public final Socket u() {
        f fVar = this.f1009r;
        f3.c.b(fVar);
        byte[] bArr = M3.c.f596a;
        ArrayList arrayList = (ArrayList) fVar.j();
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (f3.c.a(((Reference) it.next()).get(), this)) {
                break;
            }
            i2++;
        }
        if (!(i2 != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        arrayList.remove(i2);
        this.f1009r = null;
        if (arrayList.isEmpty()) {
            fVar.w(System.nanoTime());
            if (this.f1004l.c(fVar)) {
                return fVar.y();
            }
        }
        return null;
    }

    public final boolean v() {
        d dVar = this.f1008q;
        f3.c.b(dVar);
        return dVar.d();
    }

    public final void w(f fVar) {
        this.f1016z = fVar;
    }

    public final void x() {
        if (!(!this.f1010s)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f1010s = true;
        this.f1006n.s();
    }
}
