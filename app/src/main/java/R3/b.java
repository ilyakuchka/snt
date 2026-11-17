package R3;

import L3.A;
import L3.m;
import L3.s;
import L3.t;
import L3.w;
import Q3.i;
import X3.j;
import X3.y;
import X3.z;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class b implements Q3.d {

    /* renamed from: a, reason: collision with root package name */
    private final w f1318a;

    /* renamed from: b, reason: collision with root package name */
    private final P3.f f1319b;

    /* renamed from: c, reason: collision with root package name */
    private final X3.f f1320c;
    private final X3.e d;

    /* renamed from: e, reason: collision with root package name */
    private int f1321e;

    /* renamed from: f, reason: collision with root package name */
    private final R3.a f1322f;
    private s g;

    private abstract class a implements y {

        /* renamed from: i, reason: collision with root package name */
        private final j f1323i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1324j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ b f1325k;

        public a(b bVar) {
            f3.c.d(bVar, "this$0");
            this.f1325k = bVar;
            this.f1323i = new j(bVar.f1320c.c());
        }

        public final void H() {
            if (this.f1325k.f1321e == 6) {
                return;
            }
            if (this.f1325k.f1321e != 5) {
                throw new IllegalStateException(f3.c.h("state: ", Integer.valueOf(this.f1325k.f1321e)));
            }
            b.i(this.f1325k, this.f1323i);
            this.f1325k.f1321e = 6;
        }

        protected final void I(boolean z4) {
            this.f1324j = true;
        }

        @Override // X3.y
        public long U(X3.d dVar, long j2) throws IOException {
            f3.c.d(dVar, "sink");
            try {
                return this.f1325k.f1320c.U(dVar, j2);
            } catch (IOException e2) {
                this.f1325k.h().u();
                this.H();
                throw e2;
            }
        }

        @Override // X3.y
        public final z c() {
            return this.f1323i;
        }

        protected final boolean f() {
            return this.f1324j;
        }
    }

    /* renamed from: R3.b$b, reason: collision with other inner class name */
    private final class C0034b implements X3.w {

        /* renamed from: i, reason: collision with root package name */
        private final j f1326i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1327j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ b f1328k;

        public C0034b(b bVar) {
            f3.c.d(bVar, "this$0");
            this.f1328k = bVar;
            this.f1326i = new j(bVar.d.c());
        }

        @Override // X3.w
        public final z c() {
            return this.f1326i;
        }

        @Override // X3.w, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (this.f1327j) {
                return;
            }
            this.f1327j = true;
            this.f1328k.d.S("0\r\n\r\n");
            b.i(this.f1328k, this.f1326i);
            this.f1328k.f1321e = 3;
        }

        @Override // X3.w, java.io.Flushable
        public final synchronized void flush() {
            if (this.f1327j) {
                return;
            }
            this.f1328k.d.flush();
        }

        @Override // X3.w
        public final void w(X3.d dVar, long j2) throws IOException {
            f3.c.d(dVar, "source");
            if (!(!this.f1327j)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j2 == 0) {
                return;
            }
            this.f1328k.d.m(j2);
            this.f1328k.d.S("\r\n");
            this.f1328k.d.w(dVar, j2);
            this.f1328k.d.S("\r\n");
        }
    }

    private final class c extends a {

        /* renamed from: l, reason: collision with root package name */
        private final t f1329l;

        /* renamed from: m, reason: collision with root package name */
        private long f1330m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f1331n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ b f1332o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, t tVar) {
            super(bVar);
            f3.c.d(bVar, "this$0");
            f3.c.d(tVar, "url");
            this.f1332o = bVar;
            this.f1329l = tVar;
            this.f1330m = -1L;
            this.f1331n = true;
        }

        @Override // R3.b.a, X3.y
        public final long U(X3.d dVar, long j2) throws IOException {
            f3.c.d(dVar, "sink");
            boolean z4 = true;
            if (!(!f())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f1331n) {
                return -1L;
            }
            long j4 = this.f1330m;
            if (j4 == 0 || j4 == -1) {
                if (j4 != -1) {
                    this.f1332o.f1320c.N();
                }
                try {
                    this.f1330m = this.f1332o.f1320c.a0();
                    String string = i3.f.D(this.f1332o.f1320c.N()).toString();
                    if (this.f1330m >= 0) {
                        if (string.length() <= 0) {
                            z4 = false;
                        }
                        if (!z4 || i3.f.A(string, ";", false)) {
                            if (this.f1330m == 0) {
                                this.f1331n = false;
                                b bVar = this.f1332o;
                                bVar.g = bVar.f1322f.a();
                                w wVar = this.f1332o.f1318a;
                                f3.c.b(wVar);
                                m mVarH = wVar.h();
                                t tVar = this.f1329l;
                                s sVar = this.f1332o.g;
                                f3.c.b(sVar);
                                Q3.e.b(mVarH, tVar, sVar);
                                H();
                            }
                            if (!this.f1331n) {
                                return -1L;
                            }
                        }
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f1330m + string + '\"');
                } catch (NumberFormatException e2) {
                    throw new ProtocolException(e2.getMessage());
                }
            }
            long jU = super.U(dVar, Math.min(8192L, this.f1330m));
            if (jU != -1) {
                this.f1330m -= jU;
                return jU;
            }
            this.f1332o.h().u();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            H();
            throw protocolException;
        }

        @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (f()) {
                return;
            }
            if (this.f1331n) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (!M3.c.i(this)) {
                    this.f1332o.h().u();
                    H();
                }
            }
            I(true);
        }
    }

    private final class d extends a {

        /* renamed from: l, reason: collision with root package name */
        private long f1333l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ b f1334m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, long j2) {
            super(bVar);
            f3.c.d(bVar, "this$0");
            this.f1334m = bVar;
            this.f1333l = j2;
            if (j2 == 0) {
                H();
            }
        }

        @Override // R3.b.a, X3.y
        public final long U(X3.d dVar, long j2) throws IOException {
            f3.c.d(dVar, "sink");
            if (!(!f())) {
                throw new IllegalStateException("closed".toString());
            }
            long j4 = this.f1333l;
            if (j4 == 0) {
                return -1L;
            }
            long jU = super.U(dVar, Math.min(j4, 8192L));
            if (jU == -1) {
                this.f1334m.h().u();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                H();
                throw protocolException;
            }
            long j5 = this.f1333l - jU;
            this.f1333l = j5;
            if (j5 == 0) {
                H();
            }
            return jU;
        }

        @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (f()) {
                return;
            }
            if (this.f1333l != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (!M3.c.i(this)) {
                    this.f1334m.h().u();
                    H();
                }
            }
            I(true);
        }
    }

    private final class e implements X3.w {

        /* renamed from: i, reason: collision with root package name */
        private final j f1335i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1336j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ b f1337k;

        public e(b bVar) {
            f3.c.d(bVar, "this$0");
            this.f1337k = bVar;
            this.f1335i = new j(bVar.d.c());
        }

        @Override // X3.w
        public final z c() {
            return this.f1335i;
        }

        @Override // X3.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f1336j) {
                return;
            }
            this.f1336j = true;
            b.i(this.f1337k, this.f1335i);
            this.f1337k.f1321e = 3;
        }

        @Override // X3.w, java.io.Flushable
        public final void flush() throws IOException {
            if (this.f1336j) {
                return;
            }
            this.f1337k.d.flush();
        }

        @Override // X3.w
        public final void w(X3.d dVar, long j2) throws IOException {
            f3.c.d(dVar, "source");
            if (!(!this.f1336j)) {
                throw new IllegalStateException("closed".toString());
            }
            M3.c.d(dVar.n0(), 0L, j2);
            this.f1337k.d.w(dVar, j2);
        }
    }

    private final class f extends a {

        /* renamed from: l, reason: collision with root package name */
        private boolean f1338l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar) {
            super(bVar);
            f3.c.d(bVar, "this$0");
        }

        @Override // R3.b.a, X3.y
        public final long U(X3.d dVar, long j2) throws IOException {
            f3.c.d(dVar, "sink");
            if (!(!f())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f1338l) {
                return -1L;
            }
            long jU = super.U(dVar, 8192L);
            if (jU != -1) {
                return jU;
            }
            this.f1338l = true;
            H();
            return -1L;
        }

        @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (f()) {
                return;
            }
            if (!this.f1338l) {
                H();
            }
            I(true);
        }
    }

    public b(w wVar, P3.f fVar, X3.f fVar2, X3.e eVar) {
        f3.c.d(fVar, "connection");
        this.f1318a = wVar;
        this.f1319b = fVar;
        this.f1320c = fVar2;
        this.d = eVar;
        this.f1322f = new R3.a(fVar2);
    }

    public static final void i(b bVar, j jVar) {
        Objects.requireNonNull(bVar);
        z zVarI = jVar.i();
        jVar.j();
        zVarI.a();
        zVarI.b();
    }

    private final y r(long j2) {
        int i2 = this.f1321e;
        if (!(i2 == 4)) {
            throw new IllegalStateException(f3.c.h("state: ", Integer.valueOf(i2)).toString());
        }
        this.f1321e = 5;
        return new d(this, j2);
    }

    @Override // Q3.d
    public final y a(A a2) {
        if (!Q3.e.a(a2)) {
            return r(0L);
        }
        if (i3.f.q("chunked", A.h0(a2, "Transfer-Encoding"))) {
            t tVarH = a2.o0().h();
            int i2 = this.f1321e;
            if (!(i2 == 4)) {
                throw new IllegalStateException(f3.c.h("state: ", Integer.valueOf(i2)).toString());
            }
            this.f1321e = 5;
            return new c(this, tVarH);
        }
        long jL = M3.c.l(a2);
        if (jL != -1) {
            return r(jL);
        }
        int i4 = this.f1321e;
        if (!(i4 == 4)) {
            throw new IllegalStateException(f3.c.h("state: ", Integer.valueOf(i4)).toString());
        }
        this.f1321e = 5;
        this.f1319b.u();
        return new f(this);
    }

    @Override // Q3.d
    public final X3.w b(L3.y yVar, long j2) {
        if (yVar.a() != null) {
            Objects.requireNonNull(yVar.a());
        }
        if (i3.f.q("chunked", yVar.d("Transfer-Encoding"))) {
            int i2 = this.f1321e;
            if (!(i2 == 1)) {
                throw new IllegalStateException(f3.c.h("state: ", Integer.valueOf(i2)).toString());
            }
            this.f1321e = 2;
            return new C0034b(this);
        }
        if (j2 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        int i4 = this.f1321e;
        if (!(i4 == 1)) {
            throw new IllegalStateException(f3.c.h("state: ", Integer.valueOf(i4)).toString());
        }
        this.f1321e = 2;
        return new e(this);
    }

    @Override // Q3.d
    public final void c() {
        this.d.flush();
    }

    @Override // Q3.d
    public final void cancel() {
        this.f1319b.d();
    }

    @Override // Q3.d
    public final void d() throws IOException {
        this.d.flush();
    }

    @Override // Q3.d
    public final void e(L3.y yVar) {
        Proxy.Type type = this.f1319b.v().b().type();
        f3.c.c(type, "connection.route().proxy.type()");
        StringBuilder sb = new StringBuilder();
        sb.append(yVar.g());
        sb.append(' ');
        if (!yVar.f() && type == Proxy.Type.HTTP) {
            sb.append(yVar.h());
        } else {
            t tVarH = yVar.h();
            f3.c.d(tVarH, "url");
            String strC = tVarH.c();
            String strE = tVarH.e();
            if (strE != null) {
                strC = strC + '?' + ((Object) strE);
            }
            sb.append(strC);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        f3.c.c(string, "StringBuilder().apply(builderAction).toString()");
        t(yVar.e(), string);
    }

    @Override // Q3.d
    public final long f(A a2) {
        if (!Q3.e.a(a2)) {
            return 0L;
        }
        if (i3.f.q("chunked", A.h0(a2, "Transfer-Encoding"))) {
            return -1L;
        }
        return M3.c.l(a2);
    }

    @Override // Q3.d
    public final A.a g(boolean z4) {
        int i2 = this.f1321e;
        boolean z5 = true;
        if (i2 != 1 && i2 != 3) {
            z5 = false;
        }
        if (!z5) {
            throw new IllegalStateException(f3.c.h("state: ", Integer.valueOf(i2)).toString());
        }
        try {
            i iVarA = i.d.a(this.f1322f.b());
            A.a aVar = new A.a();
            aVar.o(iVarA.f1221a);
            aVar.f(iVarA.f1222b);
            aVar.l(iVarA.f1223c);
            aVar.j(this.f1322f.a());
            if (z4 && iVarA.f1222b == 100) {
                return null;
            }
            if (iVarA.f1222b == 100) {
                this.f1321e = 3;
                return aVar;
            }
            this.f1321e = 4;
            return aVar;
        } catch (EOFException e2) {
            throw new IOException(f3.c.h("unexpected end of stream on ", this.f1319b.v().a().l().o()), e2);
        }
    }

    @Override // Q3.d
    public final P3.f h() {
        return this.f1319b;
    }

    public final void s(A a2) {
        long jL = M3.c.l(a2);
        if (jL == -1) {
            return;
        }
        y yVarR = r(jL);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        M3.c.v(yVarR, Integer.MAX_VALUE);
        ((d) yVarR).close();
    }

    public final void t(s sVar, String str) {
        f3.c.d(sVar, "headers");
        f3.c.d(str, "requestLine");
        int i2 = this.f1321e;
        if (!(i2 == 0)) {
            throw new IllegalStateException(f3.c.h("state: ", Integer.valueOf(i2)).toString());
        }
        this.d.S(str).S("\r\n");
        int size = sVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.d.S(sVar.g(i4)).S(": ").S(sVar.k(i4)).S("\r\n");
        }
        this.d.S("\r\n");
        this.f1321e = 1;
    }
}
