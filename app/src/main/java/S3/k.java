package S3;

import S3.d;
import X3.y;
import X3.z;
import g3.C0324a;
import g3.C0327d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class k implements Closeable {

    /* renamed from: m, reason: collision with root package name */
    public static final a f1468m = new a();

    /* renamed from: n, reason: collision with root package name */
    private static final Logger f1469n;

    /* renamed from: i, reason: collision with root package name */
    private final X3.f f1470i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f1471j;

    /* renamed from: k, reason: collision with root package name */
    private final b f1472k;

    /* renamed from: l, reason: collision with root package name */
    private final d.a f1473l;

    public static final class a {
        public final int a(int i2, int i4, int i5) throws IOException {
            if ((i4 & 8) != 0) {
                i2--;
            }
            if (i5 <= i2) {
                return i2 - i5;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i5 + " > remaining length " + i2);
        }
    }

    public static final class b implements y {

        /* renamed from: i, reason: collision with root package name */
        private final X3.f f1474i;

        /* renamed from: j, reason: collision with root package name */
        private int f1475j;

        /* renamed from: k, reason: collision with root package name */
        private int f1476k;

        /* renamed from: l, reason: collision with root package name */
        private int f1477l;

        /* renamed from: m, reason: collision with root package name */
        private int f1478m;

        /* renamed from: n, reason: collision with root package name */
        private int f1479n;

        public b(X3.f fVar) {
            this.f1474i = fVar;
        }

        public final void H(int i2) {
            this.f1476k = i2;
        }

        public final void I(int i2) {
            this.f1478m = i2;
        }

        @Override // X3.y
        public final long U(X3.d dVar, long j2) throws IOException {
            int i2;
            int i4;
            f3.c.d(dVar, "sink");
            do {
                int i5 = this.f1478m;
                if (i5 != 0) {
                    long jU = this.f1474i.U(dVar, Math.min(8192L, i5));
                    if (jU == -1) {
                        return -1L;
                    }
                    this.f1478m -= (int) jU;
                    return jU;
                }
                this.f1474i.a(this.f1479n);
                this.f1479n = 0;
                if ((this.f1476k & 4) != 0) {
                    return -1L;
                }
                i2 = this.f1477l;
                int iU = M3.c.u(this.f1474i);
                this.f1478m = iU;
                this.f1475j = iU;
                int i6 = this.f1474i.readByte() & 255;
                this.f1476k = this.f1474i.readByte() & 255;
                a aVar = k.f1468m;
                if (k.f1469n.isLoggable(Level.FINE)) {
                    k.f1469n.fine(e.f1397a.b(true, this.f1477l, this.f1475j, i6, this.f1476k));
                }
                i4 = this.f1474i.readInt() & Integer.MAX_VALUE;
                this.f1477l = i4;
                if (i6 != 9) {
                    throw new IOException(i6 + " != TYPE_CONTINUATION");
                }
            } while (i4 == i2);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        @Override // X3.y
        public final z c() {
            return this.f1474i.c();
        }

        @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
        }

        public final void e0(int i2) {
            this.f1475j = i2;
        }

        public final int f() {
            return this.f1478m;
        }

        public final void f0(int i2) {
            this.f1479n = i2;
        }

        public final void g0(int i2) {
            this.f1477l = i2;
        }
    }

    public interface c {
        void b(int i2, S3.b bVar, X3.g gVar);

        void c(boolean z4, int i2, X3.f fVar, int i4) throws IOException;

        void d(int i2, List list) throws IOException;

        void e();

        void f(int i2, S3.b bVar);

        void g(int i2, long j2);

        void h(boolean z4, int i2, List list);

        void i();

        void j(boolean z4, int i2, int i4);

        void k(q qVar);
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        f3.c.c(logger, "getLogger(Http2::class.java.name)");
        f1469n = logger;
    }

    public k(X3.f fVar, boolean z4) {
        this.f1470i = fVar;
        this.f1471j = z4;
        b bVar = new b(fVar);
        this.f1472k = bVar;
        this.f1473l = new d.a(bVar);
    }

    private final List<S3.c> e0(int i2, int i4, int i5, int i6) throws IOException {
        this.f1472k.I(i2);
        b bVar = this.f1472k;
        bVar.e0(bVar.f());
        this.f1472k.f0(i4);
        this.f1472k.H(i5);
        this.f1472k.g0(i6);
        this.f1473l.g();
        return this.f1473l.c();
    }

    private final void f0(c cVar, int i2) throws IOException {
        this.f1470i.readInt();
        this.f1470i.readByte();
        byte[] bArr = M3.c.f596a;
        cVar.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e0, code lost:
    
        throw new java.io.IOException(f3.c.h("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", java.lang.Integer.valueOf(r12)));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean H(boolean z4, c cVar) throws IOException {
        f3.c.d(cVar, "handler");
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        try {
            this.f1470i.Q(9L);
            int iU = M3.c.u(this.f1470i);
            if (iU > 16384) {
                throw new IOException(f3.c.h("FRAME_SIZE_ERROR: ", Integer.valueOf(iU)));
            }
            int i6 = this.f1470i.readByte() & 255;
            int i7 = this.f1470i.readByte() & 255;
            int i8 = this.f1470i.readInt() & Integer.MAX_VALUE;
            Logger logger = f1469n;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.f1397a.b(true, i8, iU, i6, i7));
            }
            if (z4 && i6 != 4) {
                throw new IOException(f3.c.h("Expected a SETTINGS frame but was ", e.f1397a.a(i6)));
            }
            S3.b bVar = null;
            switch (i6) {
                case 0:
                    if (i8 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
                    }
                    boolean z5 = (i7 & 1) != 0;
                    if (((i7 & 32) != 0) == true) {
                        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
                    }
                    if ((i7 & 8) != 0) {
                        byte b2 = this.f1470i.readByte();
                        byte[] bArr = M3.c.f596a;
                        i2 = b2 & 255;
                    }
                    cVar.c(z5, i8, this.f1470i, f1468m.a(iU, i7, i2));
                    this.f1470i.a(i2);
                    return true;
                case 1:
                    if (i8 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
                    }
                    boolean z6 = (i7 & 1) != 0;
                    if ((i7 & 8) != 0) {
                        byte b4 = this.f1470i.readByte();
                        byte[] bArr2 = M3.c.f596a;
                        i5 = b4 & 255;
                    }
                    if ((i7 & 32) != 0) {
                        f0(cVar, i8);
                        iU -= 5;
                    }
                    cVar.h(z6, i8, e0(f1468m.a(iU, i7, i5), i5, i7, i8));
                    return true;
                case 2:
                    if (iU == 5) {
                        if (i8 == 0) {
                            throw new IOException("TYPE_PRIORITY streamId == 0");
                        }
                        f0(cVar, i8);
                        return true;
                    }
                    throw new IOException("TYPE_PRIORITY length: " + iU + " != 5");
                case 3:
                    if (iU != 4) {
                        throw new IOException("TYPE_RST_STREAM length: " + iU + " != 4");
                    }
                    if (i8 == 0) {
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    }
                    int i9 = this.f1470i.readInt();
                    S3.b[] bVarArrValues = S3.b.values();
                    int length = bVarArrValues.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            S3.b bVar2 = bVarArrValues[i10];
                            if ((bVar2.d() == i9) == true) {
                                bVar = bVar2;
                            } else {
                                i10++;
                            }
                        }
                    }
                    if (bVar == null) {
                        throw new IOException(f3.c.h("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(i9)));
                    }
                    cVar.f(i8, bVar);
                    return true;
                case 4:
                    if (i8 != 0) {
                        throw new IOException("TYPE_SETTINGS streamId != 0");
                    }
                    if ((i7 & 1) != 0) {
                        if (iU != 0) {
                            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        }
                        cVar.e();
                    } else {
                        if (iU % 6 != 0) {
                            throw new IOException(f3.c.h("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(iU)));
                        }
                        q qVar = new q();
                        C0324a c0324aA = C0327d.a(C0327d.b(0, iU), 6);
                        int iD = c0324aA.d();
                        int iG = c0324aA.g();
                        int iH = c0324aA.h();
                        if ((iH > 0 && iD <= iG) || (iH < 0 && iG <= iD)) {
                            while (true) {
                                int i11 = iD + iH;
                                short s2 = this.f1470i.readShort();
                                byte[] bArr3 = M3.c.f596a;
                                int i12 = s2 & 65535;
                                int i13 = this.f1470i.readInt();
                                if (i12 != 2) {
                                    if (i12 == 3) {
                                        i12 = 4;
                                    } else if (i12 == 4) {
                                        i12 = 7;
                                        if (i13 < 0) {
                                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        }
                                    } else if (i12 == 5 && (i13 < 16384 || i13 > 16777215)) {
                                        break;
                                    }
                                } else if (i13 != 0 && i13 != 1) {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                }
                                qVar.h(i12, i13);
                                if (iD != iG) {
                                    iD = i11;
                                }
                            }
                        }
                        cVar.k(qVar);
                    }
                    return true;
                case 5:
                    if (i8 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
                    }
                    if ((i7 & 8) != 0) {
                        byte b5 = this.f1470i.readByte();
                        byte[] bArr4 = M3.c.f596a;
                        i4 = b5 & 255;
                    }
                    cVar.d(this.f1470i.readInt() & Integer.MAX_VALUE, e0(f1468m.a(iU - 4, i7, i4), i4, i7, i8));
                    return true;
                case 6:
                    if (iU != 8) {
                        throw new IOException(f3.c.h("TYPE_PING length != 8: ", Integer.valueOf(iU)));
                    }
                    if (i8 != 0) {
                        throw new IOException("TYPE_PING streamId != 0");
                    }
                    cVar.j((i7 & 1) != 0, this.f1470i.readInt(), this.f1470i.readInt());
                    return true;
                case 7:
                    if (iU < 8) {
                        throw new IOException(f3.c.h("TYPE_GOAWAY length < 8: ", Integer.valueOf(iU)));
                    }
                    if (i8 != 0) {
                        throw new IOException("TYPE_GOAWAY streamId != 0");
                    }
                    int i14 = this.f1470i.readInt();
                    int i15 = this.f1470i.readInt();
                    int i16 = iU - 8;
                    S3.b[] bVarArrValues2 = S3.b.values();
                    int length2 = bVarArrValues2.length;
                    int i17 = 0;
                    while (true) {
                        if (i17 < length2) {
                            S3.b bVar3 = bVarArrValues2[i17];
                            if ((bVar3.d() == i15) == true) {
                                bVar = bVar3;
                            } else {
                                i17++;
                            }
                        }
                    }
                    if (bVar == null) {
                        throw new IOException(f3.c.h("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(i15)));
                    }
                    X3.g gVarQ = X3.g.f1848m;
                    if (i16 > 0) {
                        gVarQ = this.f1470i.q(i16);
                    }
                    cVar.b(i14, bVar, gVarQ);
                    return true;
                case 8:
                    if (iU != 4) {
                        throw new IOException(f3.c.h("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(iU)));
                    }
                    int i18 = this.f1470i.readInt();
                    byte[] bArr5 = M3.c.f596a;
                    long j2 = 2147483647L & i18;
                    if (j2 == 0) {
                        throw new IOException("windowSizeIncrement was 0");
                    }
                    cVar.g(i8, j2);
                    return true;
                default:
                    this.f1470i.a(iU);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void I(c cVar) throws IOException {
        f3.c.d(cVar, "handler");
        if (this.f1471j) {
            if (!H(true, cVar)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        X3.f fVar = this.f1470i;
        X3.g gVar = e.f1398b;
        X3.g gVarQ = fVar.q(gVar.h());
        Logger logger = f1469n;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(M3.c.j(f3.c.h("<< CONNECTION ", gVarQ.i()), new Object[0]));
        }
        if (!f3.c.a(gVar, gVarQ)) {
            throw new IOException(f3.c.h("Expected a connection header but was ", gVarQ.q()));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f1470i.close();
    }
}
