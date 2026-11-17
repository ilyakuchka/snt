package S3;

import S3.k;
import e3.InterfaceC0299a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import miuix.appcompat.internal.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public final class f implements Closeable {

    /* renamed from: K, reason: collision with root package name */
    public static final b f1401K = new b();
    private static final q L;

    /* renamed from: A, reason: collision with root package name */
    private final q f1402A;

    /* renamed from: B, reason: collision with root package name */
    private q f1403B;

    /* renamed from: C, reason: collision with root package name */
    private long f1404C;

    /* renamed from: D, reason: collision with root package name */
    private long f1405D;

    /* renamed from: E, reason: collision with root package name */
    private long f1406E;

    /* renamed from: F, reason: collision with root package name */
    private long f1407F;

    /* renamed from: G, reason: collision with root package name */
    private final Socket f1408G;

    /* renamed from: H, reason: collision with root package name */
    private final m f1409H;

    /* renamed from: I, reason: collision with root package name */
    private final d f1410I;

    /* renamed from: J, reason: collision with root package name */
    private final Set<Integer> f1411J;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f1412i;

    /* renamed from: j, reason: collision with root package name */
    private final c f1413j;

    /* renamed from: k, reason: collision with root package name */
    private final Map<Integer, S3.l> f1414k;

    /* renamed from: l, reason: collision with root package name */
    private final String f1415l;

    /* renamed from: m, reason: collision with root package name */
    private int f1416m;

    /* renamed from: n, reason: collision with root package name */
    private int f1417n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1418o;
    private final O3.d p;

    /* renamed from: q, reason: collision with root package name */
    private final O3.c f1419q;

    /* renamed from: r, reason: collision with root package name */
    private final O3.c f1420r;

    /* renamed from: s, reason: collision with root package name */
    private final O3.c f1421s;

    /* renamed from: t, reason: collision with root package name */
    private final p f1422t;
    private long u;

    /* renamed from: v, reason: collision with root package name */
    private long f1423v;

    /* renamed from: w, reason: collision with root package name */
    private long f1424w;

    /* renamed from: x, reason: collision with root package name */
    private long f1425x;

    /* renamed from: y, reason: collision with root package name */
    private long f1426y;

    /* renamed from: z, reason: collision with root package name */
    private long f1427z;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1428a;

        /* renamed from: b, reason: collision with root package name */
        private final O3.d f1429b;

        /* renamed from: c, reason: collision with root package name */
        public Socket f1430c;
        public String d;

        /* renamed from: e, reason: collision with root package name */
        public X3.f f1431e;

        /* renamed from: f, reason: collision with root package name */
        public X3.e f1432f;
        private c g;

        /* renamed from: h, reason: collision with root package name */
        private p f1433h;

        /* renamed from: i, reason: collision with root package name */
        private int f1434i;

        public a(O3.d dVar) {
            f3.c.d(dVar, "taskRunner");
            this.f1428a = true;
            this.f1429b = dVar;
            this.g = c.f1435a;
            this.f1433h = p.f1516a;
        }

        public final boolean a() {
            return this.f1428a;
        }

        public final c b() {
            return this.g;
        }

        public final int c() {
            return this.f1434i;
        }

        public final p d() {
            return this.f1433h;
        }

        public final O3.d e() {
            return this.f1429b;
        }

        public final a f(c cVar) {
            f3.c.d(cVar, "listener");
            this.g = cVar;
            return this;
        }

        public final a g() {
            this.f1434i = 0;
            return this;
        }

        public final a h(Socket socket, String str, X3.f fVar, X3.e eVar) throws IOException {
            String strH;
            f3.c.d(str, "peerName");
            this.f1430c = socket;
            if (this.f1428a) {
                strH = M3.c.g + ' ' + str;
            } else {
                strH = f3.c.h("MockWebServer ", str);
            }
            f3.c.d(strH, "<set-?>");
            this.d = strH;
            this.f1431e = fVar;
            this.f1432f = eVar;
            return this;
        }
    }

    public static final class b {
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f1435a = new a();

        public static final class a extends c {
            a() {
            }

            @Override // S3.f.c
            public final void b(S3.l lVar) throws IOException {
                f3.c.d(lVar, "stream");
                lVar.d(S3.b.REFUSED_STREAM, null);
            }
        }

        public void a(f fVar, q qVar) {
            f3.c.d(fVar, "connection");
            f3.c.d(qVar, "settings");
        }

        public abstract void b(S3.l lVar) throws IOException;
    }

    public final class d implements k.c, InterfaceC0299a<Y2.h> {

        /* renamed from: i, reason: collision with root package name */
        private final S3.k f1436i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f1437j;

        public static final class a extends O3.a {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ f f1438e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f1439f;
            final /* synthetic */ int g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, f fVar, int i2, int i4) {
                super(str, true);
                this.f1438e = fVar;
                this.f1439f = i2;
                this.g = i4;
            }

            @Override // O3.a
            public final long f() throws IOException {
                this.f1438e.U0(true, this.f1439f, this.g);
                return -1L;
            }
        }

        public d(f fVar, S3.k kVar) {
            f3.c.d(fVar, "this$0");
            this.f1437j = fVar;
            this.f1436i = kVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v5, types: [Y2.h] */
        @Override // e3.InterfaceC0299a
        public final Y2.h a() throws Throwable {
            Throwable th;
            S3.b bVar;
            S3.b bVar2 = S3.b.INTERNAL_ERROR;
            IOException e2 = null;
            try {
                try {
                    this.f1436i.I(this);
                    while (this.f1436i.H(false, this)) {
                    }
                    S3.b bVar3 = S3.b.NO_ERROR;
                    try {
                        bVar2 = S3.b.CANCEL;
                        this.f1437j.t0(bVar3, bVar2, null);
                        bVar = bVar3;
                    } catch (IOException e4) {
                        e2 = e4;
                        bVar2 = S3.b.PROTOCOL_ERROR;
                        f fVar = this.f1437j;
                        fVar.t0(bVar2, bVar2, e2);
                        bVar = fVar;
                        M3.c.e(this.f1436i);
                        this = Y2.h.f2138a;
                        return this;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.f1437j.t0(bVar, bVar2, e2);
                    M3.c.e(this.f1436i);
                    throw th;
                }
            } catch (IOException e5) {
                e2 = e5;
            } catch (Throwable th3) {
                th = th3;
                bVar = bVar2;
                this.f1437j.t0(bVar, bVar2, e2);
                M3.c.e(this.f1436i);
                throw th;
            }
            M3.c.e(this.f1436i);
            this = Y2.h.f2138a;
            return this;
        }

        @Override // S3.k.c
        public final void b(int i2, S3.b bVar, X3.g gVar) {
            int i4;
            Object[] array;
            f3.c.d(gVar, "debugData");
            gVar.h();
            f fVar = this.f1437j;
            synchronized (fVar) {
                i4 = 0;
                array = ((LinkedHashMap) fVar.C0()).values().toArray(new S3.l[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                fVar.f1418o = true;
            }
            S3.l[] lVarArr = (S3.l[]) array;
            int length = lVarArr.length;
            while (i4 < length) {
                S3.l lVar = lVarArr[i4];
                i4++;
                if (lVar.j() > i2 && lVar.t()) {
                    lVar.y(S3.b.REFUSED_STREAM);
                    this.f1437j.M0(lVar.j());
                }
            }
        }

        @Override // S3.k.c
        public final void c(boolean z4, int i2, X3.f fVar, int i4) throws IOException {
            f3.c.d(fVar, "source");
            if (this.f1437j.L0(i2)) {
                this.f1437j.H0(i2, fVar, i4, z4);
                return;
            }
            S3.l lVarB0 = this.f1437j.B0(i2);
            if (lVarB0 == null) {
                this.f1437j.W0(i2, S3.b.PROTOCOL_ERROR);
                long j2 = i4;
                this.f1437j.S0(j2);
                fVar.a(j2);
                return;
            }
            lVarB0.w(fVar, i4);
            if (z4) {
                lVarB0.x(M3.c.f597b, true);
            }
        }

        @Override // S3.k.c
        public final void d(int i2, List list) {
            this.f1437j.J0(i2, list);
        }

        @Override // S3.k.c
        public final void e() {
        }

        @Override // S3.k.c
        public final void f(int i2, S3.b bVar) {
            if (this.f1437j.L0(i2)) {
                this.f1437j.K0(i2, bVar);
                return;
            }
            S3.l lVarM0 = this.f1437j.M0(i2);
            if (lVarM0 == null) {
                return;
            }
            lVarM0.y(bVar);
        }

        @Override // S3.k.c
        public final void g(int i2, long j2) {
            if (i2 == 0) {
                f fVar = this.f1437j;
                synchronized (fVar) {
                    fVar.f1407F = fVar.D0() + j2;
                    fVar.notifyAll();
                }
                return;
            }
            S3.l lVarB0 = this.f1437j.B0(i2);
            if (lVarB0 != null) {
                synchronized (lVarB0) {
                    lVarB0.a(j2);
                }
            }
        }

        @Override // S3.k.c
        public final void h(boolean z4, int i2, List list) {
            if (this.f1437j.L0(i2)) {
                this.f1437j.I0(i2, list, z4);
                return;
            }
            f fVar = this.f1437j;
            synchronized (fVar) {
                S3.l lVarB0 = fVar.B0(i2);
                if (lVarB0 != null) {
                    lVarB0.x(M3.c.w(list), z4);
                    return;
                }
                if (fVar.f1418o) {
                    return;
                }
                if (i2 <= fVar.w0()) {
                    return;
                }
                if (i2 % 2 == fVar.y0() % 2) {
                    return;
                }
                S3.l lVar = new S3.l(i2, fVar, false, z4, M3.c.w(list));
                fVar.O0(i2);
                fVar.C0().put(Integer.valueOf(i2), lVar);
                fVar.p.h().i(new S3.h(fVar.v0() + '[' + i2 + "] onStream", fVar, lVar), 0L);
            }
        }

        @Override // S3.k.c
        public final void i() {
        }

        @Override // S3.k.c
        public final void j(boolean z4, int i2, int i4) {
            if (!z4) {
                this.f1437j.f1419q.i(new a(f3.c.h(this.f1437j.v0(), " ping"), this.f1437j, i2, i4), 0L);
                return;
            }
            f fVar = this.f1437j;
            synchronized (fVar) {
                if (i2 == 1) {
                    fVar.f1423v++;
                } else if (i2 == 2) {
                    fVar.f1425x++;
                } else if (i2 == 3) {
                    fVar.f1426y++;
                    fVar.notifyAll();
                }
            }
        }

        @Override // S3.k.c
        public final void k(q qVar) {
            this.f1437j.f1419q.i(new S3.i(f3.c.h(this.f1437j.v0(), " applyAndAckSettings"), this, qVar), 0L);
        }
    }

    public static final class e extends O3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f1440e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1441f;
        final /* synthetic */ X3.d g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f1442h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, f fVar, int i2, X3.d dVar, int i4, boolean z4) {
            super(str, true);
            this.f1440e = fVar;
            this.f1441f = i2;
            this.g = dVar;
            this.f1442h = i4;
        }

        @Override // O3.a
        public final long f() {
            try {
                p pVar = this.f1440e.f1422t;
                X3.d dVar = this.g;
                int i2 = this.f1442h;
                Objects.requireNonNull((o) pVar);
                f3.c.d(dVar, "source");
                dVar.a(i2);
                this.f1440e.E0().j0(this.f1441f, S3.b.CANCEL);
                synchronized (this.f1440e) {
                    this.f1440e.f1411J.remove(Integer.valueOf(this.f1441f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* renamed from: S3.f$f, reason: collision with other inner class name */
    public static final class C0036f extends O3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f1443e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1444f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0036f(String str, f fVar, int i2, List list, boolean z4) {
            super(str, true);
            this.f1443e = fVar;
            this.f1444f = i2;
            this.g = list;
        }

        @Override // O3.a
        public final long f() {
            p pVar = this.f1443e.f1422t;
            List list = this.g;
            Objects.requireNonNull((o) pVar);
            f3.c.d(list, "responseHeaders");
            try {
                this.f1443e.E0().j0(this.f1444f, S3.b.CANCEL);
                synchronized (this.f1443e) {
                    this.f1443e.f1411J.remove(Integer.valueOf(this.f1444f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class g extends O3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f1445e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1446f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, f fVar, int i2, List list) {
            super(str, true);
            this.f1445e = fVar;
            this.f1446f = i2;
            this.g = list;
        }

        @Override // O3.a
        public final long f() {
            p pVar = this.f1445e.f1422t;
            List list = this.g;
            Objects.requireNonNull((o) pVar);
            f3.c.d(list, "requestHeaders");
            try {
                this.f1445e.E0().j0(this.f1446f, S3.b.CANCEL);
                synchronized (this.f1445e) {
                    this.f1445e.f1411J.remove(Integer.valueOf(this.f1446f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class h extends O3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f1447e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1448f;
        final /* synthetic */ S3.b g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, f fVar, int i2, S3.b bVar) {
            super(str, true);
            this.f1447e = fVar;
            this.f1448f = i2;
            this.g = bVar;
        }

        @Override // O3.a
        public final long f() {
            p pVar = this.f1447e.f1422t;
            S3.b bVar = this.g;
            Objects.requireNonNull((o) pVar);
            f3.c.d(bVar, "errorCode");
            synchronized (this.f1447e) {
                this.f1447e.f1411J.remove(Integer.valueOf(this.f1448f));
            }
            return -1L;
        }
    }

    public static final class i extends O3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f1449e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, f fVar) {
            super(str, true);
            this.f1449e = fVar;
        }

        @Override // O3.a
        public final long f() throws IOException {
            this.f1449e.U0(false, 2, 0);
            return -1L;
        }
    }

    public static final class j extends O3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f1450e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f1451f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, f fVar, long j2) {
            super(str, true);
            this.f1450e = fVar;
            this.f1451f = j2;
        }

        @Override // O3.a
        public final long f() throws IOException {
            boolean z4;
            synchronized (this.f1450e) {
                if (this.f1450e.f1423v < this.f1450e.u) {
                    z4 = true;
                } else {
                    this.f1450e.u++;
                    z4 = false;
                }
            }
            if (z4) {
                f.f(this.f1450e, null);
                return -1L;
            }
            this.f1450e.U0(false, 1, 0);
            return this.f1451f;
        }
    }

    public static final class k extends O3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f1452e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1453f;
        final /* synthetic */ S3.b g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, f fVar, int i2, S3.b bVar) {
            super(str, true);
            this.f1452e = fVar;
            this.f1453f = i2;
            this.g = bVar;
        }

        @Override // O3.a
        public final long f() throws IOException {
            try {
                this.f1452e.V0(this.f1453f, this.g);
                return -1L;
            } catch (IOException e2) {
                f.f(this.f1452e, e2);
                return -1L;
            }
        }
    }

    public static final class l extends O3.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f1454e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1455f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, f fVar, int i2, long j2) {
            super(str, true);
            this.f1454e = fVar;
            this.f1455f = i2;
            this.g = j2;
        }

        @Override // O3.a
        public final long f() throws IOException {
            try {
                this.f1454e.E0().l0(this.f1455f, this.g);
                return -1L;
            } catch (IOException e2) {
                f.f(this.f1454e, e2);
                return -1L;
            }
        }
    }

    static {
        q qVar = new q();
        qVar.h(7, MenuBuilder.USER_MASK);
        qVar.h(5, 16384);
        L = qVar;
    }

    public f(a aVar) {
        boolean zA = aVar.a();
        this.f1412i = zA;
        this.f1413j = aVar.b();
        this.f1414k = new LinkedHashMap();
        String str = aVar.d;
        if (str == null) {
            f3.c.i("connectionName");
            throw null;
        }
        this.f1415l = str;
        this.f1417n = aVar.a() ? 3 : 2;
        O3.d dVarE = aVar.e();
        this.p = dVarE;
        O3.c cVarH = dVarE.h();
        this.f1419q = cVarH;
        this.f1420r = dVarE.h();
        this.f1421s = dVarE.h();
        this.f1422t = aVar.d();
        q qVar = new q();
        if (aVar.a()) {
            qVar.h(7, 16777216);
        }
        this.f1402A = qVar;
        this.f1403B = L;
        this.f1407F = r3.c();
        Socket socket = aVar.f1430c;
        if (socket == null) {
            f3.c.i("socket");
            throw null;
        }
        this.f1408G = socket;
        X3.e eVar = aVar.f1432f;
        if (eVar == null) {
            f3.c.i("sink");
            throw null;
        }
        this.f1409H = new m(eVar, zA);
        X3.f fVar = aVar.f1431e;
        if (fVar == null) {
            f3.c.i("source");
            throw null;
        }
        this.f1410I = new d(this, new S3.k(fVar, zA));
        this.f1411J = new LinkedHashSet();
        if (aVar.c() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(aVar.c());
            cVarH.i(new j(f3.c.h(str, " ping"), this, nanos), nanos);
        }
    }

    public static void R0(f fVar) throws IOException {
        O3.d dVar = O3.d.f855i;
        f3.c.d(dVar, "taskRunner");
        fVar.f1409H.H();
        fVar.f1409H.k0(fVar.f1402A);
        if (fVar.f1402A.c() != 65535) {
            fVar.f1409H.l0(0, r1 - MenuBuilder.USER_MASK);
        }
        dVar.h().i(new O3.b(fVar.f1415l, fVar.f1410I), 0L);
    }

    public static final void f(f fVar, IOException iOException) throws IOException {
        S3.b bVar = S3.b.PROTOCOL_ERROR;
        fVar.t0(bVar, bVar, iOException);
    }

    public final q A0() {
        return this.f1403B;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, S3.l>] */
    public final synchronized S3.l B0(int i2) {
        return (S3.l) this.f1414k.get(Integer.valueOf(i2));
    }

    public final Map<Integer, S3.l> C0() {
        return this.f1414k;
    }

    public final long D0() {
        return this.f1407F;
    }

    public final m E0() {
        return this.f1409H;
    }

    public final synchronized boolean F0(long j2) {
        if (this.f1418o) {
            return false;
        }
        if (this.f1425x < this.f1424w) {
            if (j2 >= this.f1427z) {
                return false;
            }
        }
        return true;
    }

    public final S3.l G0(List<S3.c> list, boolean z4) throws IOException {
        int i2;
        S3.l lVar;
        boolean z5;
        boolean z6 = !z4;
        synchronized (this.f1409H) {
            synchronized (this) {
                if (this.f1417n > 1073741823) {
                    Q0(S3.b.REFUSED_STREAM);
                }
                if (this.f1418o) {
                    throw new S3.a();
                }
                i2 = this.f1417n;
                this.f1417n = i2 + 2;
                lVar = new S3.l(i2, this, z6, false, null);
                z5 = !z4 || this.f1406E >= this.f1407F || lVar.r() >= lVar.q();
                if (lVar.u()) {
                    this.f1414k.put(Integer.valueOf(i2), lVar);
                }
            }
            this.f1409H.g0(z6, i2, list);
        }
        if (z5) {
            this.f1409H.flush();
        }
        return lVar;
    }

    public final void H0(int i2, X3.f fVar, int i4, boolean z4) throws IOException {
        f3.c.d(fVar, "source");
        X3.d dVar = new X3.d();
        long j2 = i4;
        fVar.Q(j2);
        fVar.U(dVar, j2);
        this.f1420r.i(new e(this.f1415l + '[' + i2 + "] onData", this, i2, dVar, i4, z4), 0L);
    }

    public final void I0(int i2, List<S3.c> list, boolean z4) {
        this.f1420r.i(new C0036f(this.f1415l + '[' + i2 + "] onHeaders", this, i2, list, z4), 0L);
    }

    public final void J0(int i2, List<S3.c> list) {
        synchronized (this) {
            if (this.f1411J.contains(Integer.valueOf(i2))) {
                W0(i2, S3.b.PROTOCOL_ERROR);
                return;
            }
            this.f1411J.add(Integer.valueOf(i2));
            this.f1420r.i(new g(this.f1415l + '[' + i2 + "] onRequest", this, i2, list), 0L);
        }
    }

    public final void K0(int i2, S3.b bVar) {
        this.f1420r.i(new h(this.f1415l + '[' + i2 + "] onReset", this, i2, bVar), 0L);
    }

    public final boolean L0(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public final synchronized S3.l M0(int i2) {
        S3.l lVarRemove;
        lVarRemove = this.f1414k.remove(Integer.valueOf(i2));
        notifyAll();
        return lVarRemove;
    }

    public final void N0() {
        synchronized (this) {
            long j2 = this.f1425x;
            long j4 = this.f1424w;
            if (j2 < j4) {
                return;
            }
            this.f1424w = j4 + 1;
            this.f1427z = System.nanoTime() + 1000000000;
            this.f1419q.i(new i(f3.c.h(this.f1415l, " ping"), this), 0L);
        }
    }

    public final void O0(int i2) {
        this.f1416m = i2;
    }

    public final void P0(q qVar) {
        f3.c.d(qVar, "<set-?>");
        this.f1403B = qVar;
    }

    public final void Q0(S3.b bVar) throws IOException {
        synchronized (this.f1409H) {
            synchronized (this) {
                if (this.f1418o) {
                    return;
                }
                this.f1418o = true;
                this.f1409H.f0(this.f1416m, bVar, M3.c.f596a);
            }
        }
    }

    public final synchronized void S0(long j2) {
        long j4 = this.f1404C + j2;
        this.f1404C = j4;
        long j5 = j4 - this.f1405D;
        if (j5 >= this.f1402A.c() / 2) {
            X0(0, j5);
            this.f1405D += j5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.f1409H.h0());
        r6 = r2;
        r8.f1406E += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T0(int i2, boolean z4, X3.d dVar, long j2) throws IOException {
        int iMin;
        long j4;
        if (j2 == 0) {
            this.f1409H.I(z4, i2, dVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        long j5 = this.f1406E;
                        long j6 = this.f1407F;
                        if (j5 < j6) {
                            break;
                        } else {
                            if (!this.f1414k.containsKey(Integer.valueOf(i2))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
            }
            j2 -= j4;
            this.f1409H.I(z4 && j2 == 0, i2, dVar, iMin);
        }
    }

    public final void U0(boolean z4, int i2, int i4) throws IOException {
        try {
            this.f1409H.i0(z4, i2, i4);
        } catch (IOException e2) {
            S3.b bVar = S3.b.PROTOCOL_ERROR;
            t0(bVar, bVar, e2);
        }
    }

    public final void V0(int i2, S3.b bVar) throws IOException {
        f3.c.d(bVar, "statusCode");
        this.f1409H.j0(i2, bVar);
    }

    public final void W0(int i2, S3.b bVar) {
        this.f1419q.i(new k(this.f1415l + '[' + i2 + "] writeSynReset", this, i2, bVar), 0L);
    }

    public final void X0(int i2, long j2) {
        this.f1419q.i(new l(this.f1415l + '[' + i2 + "] windowUpdate", this, i2, j2), 0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        t0(S3.b.NO_ERROR, S3.b.CANCEL, null);
    }

    public final void flush() throws IOException {
        this.f1409H.flush();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, S3.l>] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, S3.l>] */
    public final void t0(S3.b bVar, S3.b bVar2, IOException iOException) throws IOException {
        int i2;
        byte[] bArr = M3.c.f596a;
        try {
            Q0(bVar);
        } catch (IOException unused) {
        }
        Object[] array = null;
        synchronized (this) {
            if (!this.f1414k.isEmpty()) {
                array = this.f1414k.values().toArray(new S3.l[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                this.f1414k.clear();
            }
        }
        S3.l[] lVarArr = (S3.l[]) array;
        if (lVarArr != null) {
            for (S3.l lVar : lVarArr) {
                try {
                    lVar.d(bVar2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f1409H.close();
        } catch (IOException unused3) {
        }
        try {
            this.f1408G.close();
        } catch (IOException unused4) {
        }
        this.f1419q.m();
        this.f1420r.m();
        this.f1421s.m();
    }

    public final boolean u0() {
        return this.f1412i;
    }

    public final String v0() {
        return this.f1415l;
    }

    public final int w0() {
        return this.f1416m;
    }

    public final c x0() {
        return this.f1413j;
    }

    public final int y0() {
        return this.f1417n;
    }

    public final q z0() {
        return this.f1402A;
    }
}
