package P3;

import L3.A;
import L3.C;
import L3.p;
import L3.z;
import X3.s;
import X3.w;
import X3.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final e f977a;

    /* renamed from: b, reason: collision with root package name */
    private final p f978b;

    /* renamed from: c, reason: collision with root package name */
    private final d f979c;
    private final Q3.d d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f980e;

    /* renamed from: f, reason: collision with root package name */
    private final f f981f;

    private final class a extends X3.h {

        /* renamed from: j, reason: collision with root package name */
        private final long f982j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f983k;

        /* renamed from: l, reason: collision with root package name */
        private long f984l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f985m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ c f986n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, w wVar, long j2) {
            super(wVar);
            f3.c.d(cVar, "this$0");
            f3.c.d(wVar, "delegate");
            this.f986n = cVar;
            this.f982j = j2;
        }

        private final <E extends IOException> E f(E e2) {
            if (this.f983k) {
                return e2;
            }
            this.f983k = true;
            return (E) this.f986n.a(false, true, e2);
        }

        @Override // X3.h, X3.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.f985m) {
                return;
            }
            this.f985m = true;
            long j2 = this.f982j;
            if (j2 != -1 && this.f984l != j2) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                f(null);
            } catch (IOException e2) {
                throw f(e2);
            }
        }

        @Override // X3.h, X3.w, java.io.Flushable
        public final void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e2) {
                throw f(e2);
            }
        }

        @Override // X3.h, X3.w
        public final void w(X3.d dVar, long j2) throws IOException {
            f3.c.d(dVar, "source");
            if (!(!this.f985m)) {
                throw new IllegalStateException("closed".toString());
            }
            long j4 = this.f982j;
            if (j4 == -1 || this.f984l + j2 <= j4) {
                try {
                    super.w(dVar, j2);
                    this.f984l += j2;
                    return;
                } catch (IOException e2) {
                    throw f(e2);
                }
            }
            StringBuilder sbD = D2.e.d("expected ");
            sbD.append(this.f982j);
            sbD.append(" bytes but received ");
            sbD.append(this.f984l + j2);
            throw new ProtocolException(sbD.toString());
        }
    }

    public final class b extends X3.i {

        /* renamed from: j, reason: collision with root package name */
        private final long f987j;

        /* renamed from: k, reason: collision with root package name */
        private long f988k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f989l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f990m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f991n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ c f992o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, y yVar, long j2) {
            super(yVar);
            f3.c.d(cVar, "this$0");
            f3.c.d(yVar, "delegate");
            this.f992o = cVar;
            this.f987j = j2;
            this.f989l = true;
            if (j2 == 0) {
                H(null);
            }
        }

        public final <E extends IOException> E H(E e2) {
            if (this.f990m) {
                return e2;
            }
            this.f990m = true;
            if (e2 == null && this.f989l) {
                this.f989l = false;
                p pVarI = this.f992o.i();
                e eVarG = this.f992o.g();
                Objects.requireNonNull(pVarI);
                f3.c.d(eVarG, "call");
            }
            return (E) this.f992o.a(true, false, e2);
        }

        @Override // X3.y
        public final long U(X3.d dVar, long j2) throws IOException {
            f3.c.d(dVar, "sink");
            if (!(!this.f991n)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long jU = f().U(dVar, 8192L);
                if (this.f989l) {
                    this.f989l = false;
                    p pVarI = this.f992o.i();
                    e eVarG = this.f992o.g();
                    Objects.requireNonNull(pVarI);
                    f3.c.d(eVarG, "call");
                }
                if (jU == -1) {
                    H(null);
                    return -1L;
                }
                long j4 = this.f988k + jU;
                long j5 = this.f987j;
                if (j5 != -1 && j4 > j5) {
                    throw new ProtocolException("expected " + this.f987j + " bytes but received " + j4);
                }
                this.f988k = j4;
                if (j4 == j5) {
                    H(null);
                }
                return jU;
            } catch (IOException e2) {
                throw H(e2);
            }
        }

        @Override // X3.i, X3.y, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.f991n) {
                return;
            }
            this.f991n = true;
            try {
                super.close();
                H(null);
            } catch (IOException e2) {
                throw H(e2);
            }
        }
    }

    public c(e eVar, p pVar, d dVar, Q3.d dVar2) {
        f3.c.d(eVar, "call");
        f3.c.d(pVar, "eventListener");
        this.f977a = eVar;
        this.f978b = pVar;
        this.f979c = dVar;
        this.d = dVar2;
        this.f981f = dVar2.h();
    }

    private final void s(IOException iOException) {
        this.f979c.f(iOException);
        this.d.h().A(this.f977a, iOException);
    }

    public final IOException a(boolean z4, boolean z5, IOException iOException) {
        if (iOException != null) {
            s(iOException);
        }
        if (z5) {
            if (iOException != null) {
                this.f978b.b(this.f977a, iOException);
            } else {
                p pVar = this.f978b;
                e eVar = this.f977a;
                Objects.requireNonNull(pVar);
                f3.c.d(eVar, "call");
            }
        }
        if (z4) {
            if (iOException != null) {
                this.f978b.c(this.f977a, iOException);
            } else {
                p pVar2 = this.f978b;
                e eVar2 = this.f977a;
                Objects.requireNonNull(pVar2);
                f3.c.d(eVar2, "call");
            }
        }
        return this.f977a.r(this, z5, z4, iOException);
    }

    public final void b() {
        this.d.cancel();
    }

    public final w c(L3.y yVar) throws IOException {
        this.f980e = false;
        z zVarA = yVar.a();
        f3.c.b(zVarA);
        long jA = zVarA.a();
        p pVar = this.f978b;
        e eVar = this.f977a;
        Objects.requireNonNull(pVar);
        f3.c.d(eVar, "call");
        return new a(this, this.d.b(yVar, jA), jA);
    }

    public final void d() {
        this.d.cancel();
        this.f977a.r(this, true, true, null);
    }

    public final void e() throws IOException {
        try {
            this.d.c();
        } catch (IOException e2) {
            this.f978b.b(this.f977a, e2);
            s(e2);
            throw e2;
        }
    }

    public final void f() throws IOException {
        try {
            this.d.d();
        } catch (IOException e2) {
            this.f978b.b(this.f977a, e2);
            s(e2);
            throw e2;
        }
    }

    public final e g() {
        return this.f977a;
    }

    public final f h() {
        return this.f981f;
    }

    public final p i() {
        return this.f978b;
    }

    public final d j() {
        return this.f979c;
    }

    public final boolean k() {
        return !f3.c.a(this.f979c.c().l().g(), this.f981f.v().a().l().g());
    }

    public final boolean l() {
        return this.f980e;
    }

    public final void m() {
        this.d.h().u();
    }

    public final void n() {
        this.f977a.r(this, true, false, null);
    }

    public final C o(A a2) throws IOException {
        try {
            String strH0 = A.h0(a2, "Content-Type");
            long jF = this.d.f(a2);
            return new Q3.g(strH0, jF, new s(new b(this, this.d.a(a2), jF)));
        } catch (IOException e2) {
            this.f978b.c(this.f977a, e2);
            s(e2);
            throw e2;
        }
    }

    public final A.a p(boolean z4) throws IOException {
        try {
            A.a aVarG = this.d.g(z4);
            if (aVarG != null) {
                aVarG.k(this);
            }
            return aVarG;
        } catch (IOException e2) {
            this.f978b.c(this.f977a, e2);
            s(e2);
            throw e2;
        }
    }

    public final void q(A a2) {
        p pVar = this.f978b;
        e eVar = this.f977a;
        Objects.requireNonNull(pVar);
        f3.c.d(eVar, "call");
    }

    public final void r() {
        p pVar = this.f978b;
        e eVar = this.f977a;
        Objects.requireNonNull(pVar);
        f3.c.d(eVar, "call");
    }

    public final void t(L3.y yVar) throws IOException {
        try {
            p pVar = this.f978b;
            e eVar = this.f977a;
            Objects.requireNonNull(pVar);
            f3.c.d(eVar, "call");
            this.d.e(yVar);
            p pVar2 = this.f978b;
            e eVar2 = this.f977a;
            Objects.requireNonNull(pVar2);
            f3.c.d(eVar2, "call");
        } catch (IOException e2) {
            this.f978b.b(this.f977a, e2);
            s(e2);
            throw e2;
        }
    }
}
