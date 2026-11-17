package S3;

import X3.s;
import X3.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1381a;

    /* renamed from: b, reason: collision with root package name */
    private static final c[] f1382b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<X3.g, Integer> f1383c;

    public static final class a {
        private final s d;
        public int g;

        /* renamed from: h, reason: collision with root package name */
        public int f1389h;

        /* renamed from: a, reason: collision with root package name */
        private final int f1384a = 4096;

        /* renamed from: b, reason: collision with root package name */
        private int f1385b = 4096;

        /* renamed from: c, reason: collision with root package name */
        private final List<c> f1386c = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public c[] f1387e = new c[8];

        /* renamed from: f, reason: collision with root package name */
        private int f1388f = 7;

        public a(y yVar) {
            this.d = new s(yVar);
        }

        private final void a() {
            c[] cVarArr = this.f1387e;
            int length = cVarArr.length;
            f3.c.d(cVarArr, "<this>");
            Arrays.fill(cVarArr, 0, length, (Object) null);
            this.f1388f = this.f1387e.length - 1;
            this.g = 0;
            this.f1389h = 0;
        }

        private final int b(int i2) {
            int i4;
            int i5 = 0;
            if (i2 > 0) {
                int length = this.f1387e.length;
                while (true) {
                    length--;
                    i4 = this.f1388f;
                    if (length < i4 || i2 <= 0) {
                        break;
                    }
                    c cVar = this.f1387e[length];
                    f3.c.b(cVar);
                    int i6 = cVar.f1380c;
                    i2 -= i6;
                    this.f1389h -= i6;
                    this.g--;
                    i5++;
                }
                c[] cVarArr = this.f1387e;
                System.arraycopy(cVarArr, i4 + 1, cVarArr, i4 + 1 + i5, this.g);
                this.f1388f += i5;
            }
            return i5;
        }

        private final X3.g d(int i2) throws IOException {
            if (i2 >= 0 && i2 <= d.f1381a.c().length - 1) {
                return d.f1381a.c()[i2].f1378a;
            }
            int length = this.f1388f + 1 + (i2 - d.f1381a.c().length);
            if (length >= 0) {
                c[] cVarArr = this.f1387e;
                if (length < cVarArr.length) {
                    c cVar = cVarArr[length];
                    f3.c.b(cVar);
                    return cVar.f1378a;
                }
            }
            throw new IOException(f3.c.h("Header index too large ", Integer.valueOf(i2 + 1)));
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<S3.c>] */
        private final void e(c cVar) {
            this.f1386c.add(cVar);
            int i2 = cVar.f1380c;
            int i4 = this.f1385b;
            if (i2 > i4) {
                a();
                return;
            }
            b((this.f1389h + i2) - i4);
            int i5 = this.g + 1;
            c[] cVarArr = this.f1387e;
            if (i5 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f1388f = this.f1387e.length - 1;
                this.f1387e = cVarArr2;
            }
            int i6 = this.f1388f;
            this.f1388f = i6 - 1;
            this.f1387e[i6] = cVar;
            this.g++;
            this.f1389h += i2;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<S3.c>] */
        public final List<c> c() {
            List<c> listM = Z2.g.m(this.f1386c);
            this.f1386c.clear();
            return listM;
        }

        public final X3.g f() throws IOException {
            byte b2 = this.d.readByte();
            byte[] bArr = M3.c.f596a;
            int i2 = b2 & 255;
            boolean z4 = (i2 & 128) == 128;
            long jH = h(i2, 127);
            if (!z4) {
                return this.d.q(jH);
            }
            X3.d dVar = new X3.d();
            n.f1510a.b(this.d, jH, dVar);
            return dVar.h0();
        }

        /* JADX WARN: Type inference failed for: r0v12, types: [java.util.ArrayList, java.util.List<S3.c>] */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.util.ArrayList, java.util.List<S3.c>] */
        /* JADX WARN: Type inference failed for: r2v8, types: [java.util.ArrayList, java.util.List<S3.c>] */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.util.ArrayList, java.util.List<S3.c>] */
        public final void g() throws IOException {
            while (!this.d.V()) {
                byte b2 = this.d.readByte();
                byte[] bArr = M3.c.f596a;
                int i2 = b2 & 255;
                if (i2 == 128) {
                    throw new IOException("index == 0");
                }
                if ((i2 & 128) == 128) {
                    int iH = h(i2, 127) - 1;
                    if (!(iH >= 0 && iH <= d.f1381a.c().length - 1)) {
                        int length = this.f1388f + 1 + (iH - d.f1381a.c().length);
                        if (length >= 0) {
                            c[] cVarArr = this.f1387e;
                            if (length < cVarArr.length) {
                                ?? r02 = this.f1386c;
                                c cVar = cVarArr[length];
                                f3.c.b(cVar);
                                r02.add(cVar);
                            }
                        }
                        throw new IOException(f3.c.h("Header index too large ", Integer.valueOf(iH + 1)));
                    }
                    this.f1386c.add(d.f1381a.c()[iH]);
                } else if (i2 == 64) {
                    d dVar = d.f1381a;
                    X3.g gVarF = f();
                    dVar.a(gVarF);
                    e(new c(gVarF, f()));
                } else if ((i2 & 64) == 64) {
                    e(new c(d(h(i2, 63) - 1), f()));
                } else if ((i2 & 32) == 32) {
                    int iH2 = h(i2, 31);
                    this.f1385b = iH2;
                    if (iH2 < 0 || iH2 > this.f1384a) {
                        throw new IOException(f3.c.h("Invalid dynamic table size update ", Integer.valueOf(this.f1385b)));
                    }
                    int i4 = this.f1389h;
                    if (iH2 < i4) {
                        if (iH2 == 0) {
                            a();
                        } else {
                            b(i4 - iH2);
                        }
                    }
                } else if (i2 == 16 || i2 == 0) {
                    d dVar2 = d.f1381a;
                    X3.g gVarF2 = f();
                    dVar2.a(gVarF2);
                    this.f1386c.add(new c(gVarF2, f()));
                } else {
                    this.f1386c.add(new c(d(h(i2, 15) - 1), f()));
                }
            }
        }

        public final int h(int i2, int i4) throws IOException {
            int i5 = i2 & i4;
            if (i5 < i4) {
                return i5;
            }
            int i6 = 0;
            while (true) {
                byte b2 = this.d.readByte();
                byte[] bArr = M3.c.f596a;
                int i7 = b2 & 255;
                if ((i7 & 128) == 0) {
                    return i4 + (i7 << i6);
                }
                i4 += (i7 & 127) << i6;
                i6 += 7;
            }
        }
    }

    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        private final X3.d f1391b;
        private boolean d;

        /* renamed from: h, reason: collision with root package name */
        public int f1395h;

        /* renamed from: i, reason: collision with root package name */
        public int f1396i;

        /* renamed from: a, reason: collision with root package name */
        private final boolean f1390a = true;

        /* renamed from: c, reason: collision with root package name */
        private int f1392c = Integer.MAX_VALUE;

        /* renamed from: e, reason: collision with root package name */
        public int f1393e = 4096;

        /* renamed from: f, reason: collision with root package name */
        public c[] f1394f = new c[8];
        private int g = 7;

        public b(X3.d dVar) {
            this.f1391b = dVar;
        }

        private final void a() {
            c[] cVarArr = this.f1394f;
            int length = cVarArr.length;
            f3.c.d(cVarArr, "<this>");
            Arrays.fill(cVarArr, 0, length, (Object) null);
            this.g = this.f1394f.length - 1;
            this.f1395h = 0;
            this.f1396i = 0;
        }

        private final int b(int i2) {
            int i4;
            int i5 = 0;
            if (i2 > 0) {
                int length = this.f1394f.length;
                while (true) {
                    length--;
                    i4 = this.g;
                    if (length < i4 || i2 <= 0) {
                        break;
                    }
                    c cVar = this.f1394f[length];
                    f3.c.b(cVar);
                    i2 -= cVar.f1380c;
                    int i6 = this.f1396i;
                    c cVar2 = this.f1394f[length];
                    f3.c.b(cVar2);
                    this.f1396i = i6 - cVar2.f1380c;
                    this.f1395h--;
                    i5++;
                }
                c[] cVarArr = this.f1394f;
                System.arraycopy(cVarArr, i4 + 1, cVarArr, i4 + 1 + i5, this.f1395h);
                c[] cVarArr2 = this.f1394f;
                int i7 = this.g;
                Arrays.fill(cVarArr2, i7 + 1, i7 + 1 + i5, (Object) null);
                this.g += i5;
            }
            return i5;
        }

        private final void c(c cVar) {
            int i2 = cVar.f1380c;
            int i4 = this.f1393e;
            if (i2 > i4) {
                a();
                return;
            }
            b((this.f1396i + i2) - i4);
            int i5 = this.f1395h + 1;
            c[] cVarArr = this.f1394f;
            if (i5 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.g = this.f1394f.length - 1;
                this.f1394f = cVarArr2;
            }
            int i6 = this.g;
            this.g = i6 - 1;
            this.f1394f[i6] = cVar;
            this.f1395h++;
            this.f1396i += i2;
        }

        public final void d(int i2) {
            int iMin = Math.min(i2, 16384);
            int i4 = this.f1393e;
            if (i4 == iMin) {
                return;
            }
            if (iMin < i4) {
                this.f1392c = Math.min(this.f1392c, iMin);
            }
            this.d = true;
            this.f1393e = iMin;
            int i5 = this.f1396i;
            if (iMin < i5) {
                if (iMin == 0) {
                    a();
                } else {
                    b(i5 - iMin);
                }
            }
        }

        public final void e(X3.g gVar) throws IOException {
            f3.c.d(gVar, "data");
            if (this.f1390a) {
                n nVar = n.f1510a;
                if (nVar.d(gVar) < gVar.h()) {
                    X3.d dVar = new X3.d();
                    nVar.c(gVar, dVar);
                    X3.g gVarH0 = dVar.h0();
                    g(gVarH0.h(), 127, 128);
                    this.f1391b.q0(gVarH0);
                    return;
                }
            }
            g(gVar.h(), 127, 0);
            this.f1391b.q0(gVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void f(List<c> list) throws IOException {
            int length;
            int length2;
            if (this.d) {
                int i2 = this.f1392c;
                if (i2 < this.f1393e) {
                    g(i2, 31, 32);
                }
                this.d = false;
                this.f1392c = Integer.MAX_VALUE;
                g(this.f1393e, 31, 32);
            }
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                int i5 = i4 + 1;
                c cVar = list.get(i4);
                X3.g gVarP = cVar.f1378a.p();
                X3.g gVar = cVar.f1379b;
                d dVar = d.f1381a;
                Integer num = dVar.b().get(gVarP);
                if (num != null) {
                    length2 = num.intValue() + 1;
                    if (!(2 <= length2 && length2 < 8)) {
                        length = length2;
                        length2 = -1;
                    } else if (f3.c.a(dVar.c()[length2 - 1].f1379b, gVar)) {
                        length = length2;
                    } else if (f3.c.a(dVar.c()[length2].f1379b, gVar)) {
                        length2++;
                        length = length2;
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int i6 = this.g + 1;
                    int length3 = this.f1394f.length;
                    while (true) {
                        if (i6 >= length3) {
                            break;
                        }
                        int i7 = i6 + 1;
                        c cVar2 = this.f1394f[i6];
                        f3.c.b(cVar2);
                        if (f3.c.a(cVar2.f1378a, gVarP)) {
                            c cVar3 = this.f1394f[i6];
                            f3.c.b(cVar3);
                            if (f3.c.a(cVar3.f1379b, gVar)) {
                                length2 = d.f1381a.c().length + (i6 - this.g);
                                break;
                            } else if (length == -1) {
                                length = d.f1381a.c().length + (i6 - this.g);
                            }
                        }
                        i6 = i7;
                    }
                }
                if (length2 != -1) {
                    g(length2, 127, 128);
                } else if (length == -1) {
                    this.f1391b.u0(64);
                    e(gVarP);
                    e(gVar);
                    c(cVar);
                } else {
                    X3.g gVar2 = c.d;
                    Objects.requireNonNull(gVarP);
                    f3.c.d(gVar2, "prefix");
                    if (!gVarP.m(gVar2, gVar2.h()) || f3.c.a(c.f1377i, gVarP)) {
                        g(length, 63, 64);
                        e(gVar);
                        c(cVar);
                    } else {
                        g(length, 15, 0);
                        e(gVar);
                    }
                }
                i4 = i5;
            }
        }

        public final void g(int i2, int i4, int i5) {
            if (i2 < i4) {
                this.f1391b.u0(i2 | i5);
                return;
            }
            this.f1391b.u0(i5 | i4);
            int i6 = i2 - i4;
            while (i6 >= 128) {
                this.f1391b.u0(128 | (i6 & 127));
                i6 >>>= 7;
            }
            this.f1391b.u0(i6);
        }
    }

    static {
        d dVar = new d();
        f1381a = dVar;
        c cVar = new c(c.f1377i, "");
        int i2 = 0;
        X3.g gVar = c.f1375f;
        X3.g gVar2 = c.g;
        X3.g gVar3 = c.f1376h;
        X3.g gVar4 = c.f1374e;
        c[] cVarArr = {cVar, new c(gVar, "GET"), new c(gVar, "POST"), new c(gVar2, "/"), new c(gVar2, "/index.html"), new c(gVar3, "http"), new c(gVar3, "https"), new c(gVar4, "200"), new c(gVar4, "204"), new c(gVar4, "206"), new c(gVar4, "304"), new c(gVar4, "400"), new c(gVar4, "404"), new c(gVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f1382b = cVarArr;
        Objects.requireNonNull(dVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap(cVarArr.length);
        int length = cVarArr.length;
        while (i2 < length) {
            int i4 = i2 + 1;
            c[] cVarArr2 = f1382b;
            if (!linkedHashMap.containsKey(cVarArr2[i2].f1378a)) {
                linkedHashMap.put(cVarArr2[i2].f1378a, Integer.valueOf(i2));
            }
            i2 = i4;
        }
        Map<X3.g, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        f3.c.c(mapUnmodifiableMap, "unmodifiableMap(result)");
        f1383c = mapUnmodifiableMap;
    }

    private d() {
    }

    public final X3.g a(X3.g gVar) throws IOException {
        f3.c.d(gVar, "name");
        int iH = gVar.h();
        int i2 = 0;
        while (i2 < iH) {
            int i4 = i2 + 1;
            byte bK = gVar.k(i2);
            if (65 <= bK && bK <= 90) {
                throw new IOException(f3.c.h("PROTOCOL_ERROR response malformed: mixed case name: ", gVar.q()));
            }
            i2 = i4;
        }
        return gVar;
    }

    public final Map<X3.g, Integer> b() {
        return f1383c;
    }

    public final c[] c() {
        return f1382b;
    }
}
