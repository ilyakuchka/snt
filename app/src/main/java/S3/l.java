package S3;

import L3.s;
import X3.C0174a;
import X3.w;
import X3.y;
import X3.z;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Objects;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final int f1480a;

    /* renamed from: b, reason: collision with root package name */
    private final f f1481b;

    /* renamed from: c, reason: collision with root package name */
    private long f1482c;
    private long d;

    /* renamed from: e, reason: collision with root package name */
    private long f1483e;

    /* renamed from: f, reason: collision with root package name */
    private long f1484f;
    private final ArrayDeque<s> g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1485h;

    /* renamed from: i, reason: collision with root package name */
    private final b f1486i;

    /* renamed from: j, reason: collision with root package name */
    private final a f1487j;

    /* renamed from: k, reason: collision with root package name */
    private final c f1488k;

    /* renamed from: l, reason: collision with root package name */
    private final c f1489l;

    /* renamed from: m, reason: collision with root package name */
    private S3.b f1490m;

    /* renamed from: n, reason: collision with root package name */
    private IOException f1491n;

    public final class a implements w {

        /* renamed from: i, reason: collision with root package name */
        private boolean f1492i;

        /* renamed from: j, reason: collision with root package name */
        private final X3.d f1493j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f1494k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ l f1495l;

        public a(l lVar, boolean z4) {
            f3.c.d(lVar, "this$0");
            this.f1495l = lVar;
            this.f1492i = z4;
            this.f1493j = new X3.d();
        }

        private final void f(boolean z4) throws IOException {
            long jMin;
            boolean z5;
            l lVar = this.f1495l;
            synchronized (lVar) {
                lVar.s().r();
                while (lVar.r() >= lVar.q() && !this.f1492i && !this.f1494k && lVar.h() == null) {
                    try {
                        lVar.D();
                    } finally {
                        lVar.s().v();
                    }
                }
                lVar.s().v();
                lVar.c();
                jMin = Math.min(lVar.q() - lVar.r(), this.f1493j.n0());
                lVar.B(lVar.r() + jMin);
                z5 = z4 && jMin == this.f1493j.n0();
            }
            this.f1495l.s().r();
            try {
                this.f1495l.g().T0(this.f1495l.j(), z5, this.f1493j, jMin);
            } finally {
                lVar = this.f1495l;
            }
        }

        public final boolean H() {
            return this.f1494k;
        }

        public final boolean I() {
            return this.f1492i;
        }

        @Override // X3.w
        public final z c() {
            return this.f1495l.s();
        }

        @Override // X3.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            l lVar = this.f1495l;
            byte[] bArr = M3.c.f596a;
            synchronized (lVar) {
                if (this.f1494k) {
                    return;
                }
                boolean z4 = lVar.h() == null;
                if (!this.f1495l.o().f1492i) {
                    if (this.f1493j.n0() > 0) {
                        while (this.f1493j.n0() > 0) {
                            f(true);
                        }
                    } else if (z4) {
                        this.f1495l.g().T0(this.f1495l.j(), true, null, 0L);
                    }
                }
                synchronized (this.f1495l) {
                    this.f1494k = true;
                }
                this.f1495l.g().flush();
                this.f1495l.b();
            }
        }

        @Override // X3.w, java.io.Flushable
        public final void flush() throws IOException {
            l lVar = this.f1495l;
            byte[] bArr = M3.c.f596a;
            synchronized (lVar) {
                lVar.c();
            }
            while (this.f1493j.n0() > 0) {
                f(false);
                this.f1495l.g().flush();
            }
        }

        @Override // X3.w
        public final void w(X3.d dVar, long j2) throws IOException {
            f3.c.d(dVar, "source");
            byte[] bArr = M3.c.f596a;
            this.f1493j.w(dVar, j2);
            while (this.f1493j.n0() >= 16384) {
                f(false);
            }
        }
    }

    public final class b implements y {

        /* renamed from: i, reason: collision with root package name */
        private final long f1496i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1497j;

        /* renamed from: k, reason: collision with root package name */
        private final X3.d f1498k;

        /* renamed from: l, reason: collision with root package name */
        private final X3.d f1499l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f1500m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ l f1501n;

        public b(l lVar, long j2, boolean z4) {
            f3.c.d(lVar, "this$0");
            this.f1501n = lVar;
            this.f1496i = j2;
            this.f1497j = z4;
            this.f1498k = new X3.d();
            this.f1499l = new X3.d();
        }

        private final void f0(long j2) {
            l lVar = this.f1501n;
            byte[] bArr = M3.c.f596a;
            lVar.g().S0(j2);
        }

        public final boolean H() {
            return this.f1497j;
        }

        public final void I(X3.f fVar, long j2) throws IOException {
            boolean z4;
            boolean z5;
            boolean z6;
            long jN0;
            f3.c.d(fVar, "source");
            byte[] bArr = M3.c.f596a;
            while (j2 > 0) {
                synchronized (this.f1501n) {
                    z4 = this.f1497j;
                    z5 = true;
                    z6 = this.f1499l.n0() + j2 > this.f1496i;
                }
                if (z6) {
                    fVar.a(j2);
                    this.f1501n.f(S3.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z4) {
                    fVar.a(j2);
                    return;
                }
                long jU = fVar.U(this.f1498k, j2);
                if (jU == -1) {
                    throw new EOFException();
                }
                j2 -= jU;
                l lVar = this.f1501n;
                synchronized (lVar) {
                    if (this.f1500m) {
                        jN0 = this.f1498k.n0();
                        this.f1498k.f();
                    } else {
                        if (this.f1499l.n0() != 0) {
                            z5 = false;
                        }
                        this.f1499l.t0(this.f1498k);
                        if (z5) {
                            lVar.notifyAll();
                        }
                        jN0 = 0;
                    }
                }
                if (jN0 > 0) {
                    f0(jN0);
                }
            }
        }

        @Override // X3.y
        public final long U(X3.d dVar, long j2) throws IOException {
            IOException iOExceptionI;
            long jU;
            boolean z4;
            long j4;
            f3.c.d(dVar, "sink");
            do {
                iOExceptionI = null;
                l lVar = this.f1501n;
                synchronized (lVar) {
                    lVar.m().r();
                    try {
                        if (lVar.h() != null && (iOExceptionI = lVar.i()) == null) {
                            S3.b bVarH = lVar.h();
                            f3.c.b(bVarH);
                            iOExceptionI = new r(bVarH);
                        }
                        if (this.f1500m) {
                            throw new IOException("stream closed");
                        }
                        if (this.f1499l.n0() > 0) {
                            X3.d dVar2 = this.f1499l;
                            jU = dVar2.U(dVar, Math.min(8192L, dVar2.n0()));
                            lVar.A(lVar.l() + jU);
                            long jL = lVar.l() - lVar.k();
                            if (iOExceptionI == null && jL >= lVar.g().z0().c() / 2) {
                                lVar.g().X0(lVar.j(), jL);
                                lVar.z(lVar.l());
                            }
                        } else if (this.f1497j || iOExceptionI != null) {
                            jU = -1;
                        } else {
                            lVar.D();
                            z4 = true;
                            j4 = -1;
                        }
                        long j5 = jU;
                        z4 = false;
                        j4 = j5;
                    } finally {
                    }
                }
            } while (z4);
            if (j4 != -1) {
                f0(j4);
                return j4;
            }
            if (iOExceptionI == null) {
                return -1L;
            }
            throw iOExceptionI;
        }

        @Override // X3.y
        public final z c() {
            return this.f1501n.m();
        }

        @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            long jN0;
            l lVar = this.f1501n;
            synchronized (lVar) {
                this.f1500m = true;
                jN0 = this.f1499l.n0();
                this.f1499l.f();
                lVar.notifyAll();
            }
            if (jN0 > 0) {
                f0(jN0);
            }
            this.f1501n.b();
        }

        public final void e0() {
            this.f1497j = true;
        }

        public final boolean f() {
            return this.f1500m;
        }
    }

    public final class c extends C0174a {

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ l f1502l;

        public c(l lVar) {
            f3.c.d(lVar, "this$0");
            this.f1502l = lVar;
        }

        @Override // X3.C0174a
        protected final IOException t(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // X3.C0174a
        protected final void u() {
            this.f1502l.f(S3.b.CANCEL);
            this.f1502l.g().N0();
        }

        public final void v() throws IOException {
            if (s()) {
                throw new SocketTimeoutException("timeout");
            }
        }
    }

    public l(int i2, f fVar, boolean z4, boolean z5, s sVar) {
        f3.c.d(fVar, "connection");
        this.f1480a = i2;
        this.f1481b = fVar;
        this.f1484f = fVar.A0().c();
        ArrayDeque<s> arrayDeque = new ArrayDeque<>();
        this.g = arrayDeque;
        this.f1486i = new b(this, fVar.z0().c(), z5);
        this.f1487j = new a(this, z4);
        this.f1488k = new c(this);
        this.f1489l = new c(this);
        if (sVar == null) {
            if (!t()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!t())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(sVar);
        }
    }

    private final boolean e(S3.b bVar, IOException iOException) {
        byte[] bArr = M3.c.f596a;
        synchronized (this) {
            if (h() != null) {
                return false;
            }
            if (this.f1486i.H() && this.f1487j.I()) {
                return false;
            }
            this.f1490m = bVar;
            this.f1491n = iOException;
            notifyAll();
            this.f1481b.M0(this.f1480a);
            return true;
        }
    }

    public final void A(long j2) {
        this.f1482c = j2;
    }

    public final void B(long j2) {
        this.f1483e = j2;
    }

    public final synchronized s C() throws IOException {
        s sVarRemoveFirst;
        this.f1488k.r();
        while (this.g.isEmpty() && this.f1490m == null) {
            try {
                D();
            } catch (Throwable th) {
                this.f1488k.v();
                throw th;
            }
        }
        this.f1488k.v();
        if (!(!this.g.isEmpty())) {
            IOException iOException = this.f1491n;
            if (iOException != null) {
                throw iOException;
            }
            S3.b bVar = this.f1490m;
            f3.c.b(bVar);
            throw new r(bVar);
        }
        sVarRemoveFirst = this.g.removeFirst();
        f3.c.c(sVarRemoveFirst, "headersQueue.removeFirst()");
        return sVarRemoveFirst;
    }

    public final void D() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final z E() {
        return this.f1489l;
    }

    public final void a(long j2) {
        this.f1484f += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public final void b() throws IOException {
        boolean z4;
        boolean zU;
        byte[] bArr = M3.c.f596a;
        synchronized (this) {
            z4 = !this.f1486i.H() && this.f1486i.f() && (this.f1487j.I() || this.f1487j.H());
            zU = u();
        }
        if (z4) {
            d(S3.b.CANCEL, null);
        } else {
            if (zU) {
                return;
            }
            this.f1481b.M0(this.f1480a);
        }
    }

    public final void c() throws IOException {
        if (this.f1487j.H()) {
            throw new IOException("stream closed");
        }
        if (this.f1487j.I()) {
            throw new IOException("stream finished");
        }
        if (this.f1490m != null) {
            IOException iOException = this.f1491n;
            if (iOException != null) {
                throw iOException;
            }
            S3.b bVar = this.f1490m;
            f3.c.b(bVar);
            throw new r(bVar);
        }
    }

    public final void d(S3.b bVar, IOException iOException) throws IOException {
        if (e(bVar, iOException)) {
            this.f1481b.V0(this.f1480a, bVar);
        }
    }

    public final void f(S3.b bVar) {
        if (e(bVar, null)) {
            this.f1481b.W0(this.f1480a, bVar);
        }
    }

    public final f g() {
        return this.f1481b;
    }

    public final synchronized S3.b h() {
        return this.f1490m;
    }

    public final IOException i() {
        return this.f1491n;
    }

    public final int j() {
        return this.f1480a;
    }

    public final long k() {
        return this.d;
    }

    public final long l() {
        return this.f1482c;
    }

    public final c m() {
        return this.f1488k;
    }

    public final w n() {
        synchronized (this) {
            if (!(this.f1485h || t())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
        }
        return this.f1487j;
    }

    public final a o() {
        return this.f1487j;
    }

    public final b p() {
        return this.f1486i;
    }

    public final long q() {
        return this.f1484f;
    }

    public final long r() {
        return this.f1483e;
    }

    public final c s() {
        return this.f1489l;
    }

    public final boolean t() {
        return this.f1481b.u0() == ((this.f1480a & 1) == 1);
    }

    public final synchronized boolean u() {
        if (this.f1490m != null) {
            return false;
        }
        if ((this.f1486i.H() || this.f1486i.f()) && (this.f1487j.I() || this.f1487j.H())) {
            if (this.f1485h) {
                return false;
            }
        }
        return true;
    }

    public final z v() {
        return this.f1488k;
    }

    public final void w(X3.f fVar, int i2) throws IOException {
        f3.c.d(fVar, "source");
        byte[] bArr = M3.c.f596a;
        this.f1486i.I(fVar, i2);
    }

    public final void x(s sVar, boolean z4) {
        boolean zU;
        f3.c.d(sVar, "headers");
        byte[] bArr = M3.c.f596a;
        synchronized (this) {
            if (this.f1485h && z4) {
                Objects.requireNonNull(this.f1486i);
            } else {
                this.f1485h = true;
                this.g.add(sVar);
            }
            if (z4) {
                this.f1486i.e0();
            }
            zU = u();
            notifyAll();
        }
        if (zU) {
            return;
        }
        this.f1481b.M0(this.f1480a);
    }

    public final synchronized void y(S3.b bVar) {
        if (this.f1490m == null) {
            this.f1490m = bVar;
            notifyAll();
        }
    }

    public final void z(long j2) {
        this.d = j2;
    }
}
