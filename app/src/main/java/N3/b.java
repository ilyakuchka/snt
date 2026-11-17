package N3;

import L3.A;
import L3.C0153d;
import L3.s;
import L3.y;
import f3.c;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f734c = new a();

    /* renamed from: a, reason: collision with root package name */
    private final y f735a;

    /* renamed from: b, reason: collision with root package name */
    private final A f736b;

    public static final class a {
        /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(A a2, y yVar) {
            c.d(a2, "response");
            c.d(yVar, "request");
            int iE0 = a2.e0();
            if (iE0 != 200 && iE0 != 410 && iE0 != 414 && iE0 != 501 && iE0 != 203 && iE0 != 204) {
                if (iE0 == 307) {
                    if (A.h0(a2, "Expires") == null && a2.H().c() == -1 && !a2.H().b() && !a2.H().a()) {
                        return false;
                    }
                } else if (iE0 != 308 && iE0 != 404 && iE0 != 405) {
                    switch (iE0) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            return (a2.H().h() || yVar.b().h()) ? false : true;
        }
    }

    /* renamed from: N3.b$b, reason: collision with other inner class name */
    public static final class C0025b {

        /* renamed from: a, reason: collision with root package name */
        private final long f737a;

        /* renamed from: b, reason: collision with root package name */
        private final y f738b;

        /* renamed from: c, reason: collision with root package name */
        private final A f739c;
        private Date d;

        /* renamed from: e, reason: collision with root package name */
        private String f740e;

        /* renamed from: f, reason: collision with root package name */
        private Date f741f;
        private String g;

        /* renamed from: h, reason: collision with root package name */
        private Date f742h;

        /* renamed from: i, reason: collision with root package name */
        private long f743i;

        /* renamed from: j, reason: collision with root package name */
        private long f744j;

        /* renamed from: k, reason: collision with root package name */
        private String f745k;

        /* renamed from: l, reason: collision with root package name */
        private int f746l;

        public C0025b(long j2, y yVar) {
            c.d(yVar, "request");
            this.f737a = j2;
            this.f738b = yVar;
            this.f739c = null;
            this.f746l = -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x01ec  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0117  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01a4  */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v20, types: [L3.A, L3.y] */
        /* JADX WARN: Type inference failed for: r3v21 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final b a() {
            ?? r32;
            b bVar;
            long time;
            if (this.f739c == null) {
                bVar = new b(this.f738b, null);
            } else {
                if (!(this.f738b.f() && this.f739c.g0() == null) && b.f734c.a(this.f739c, this.f738b)) {
                    C0153d c0153dB = this.f738b.b();
                    if (!c0153dB.g()) {
                        y yVar = this.f738b;
                        String str = "If-Modified-Since";
                        if ((yVar.d("If-Modified-Since") == null && yVar.d("If-None-Match") == null) ? false : true) {
                            r32 = 0;
                            bVar = new b(this.f738b, null);
                        } else {
                            C0153d c0153dH = this.f739c.H();
                            Date date = this.d;
                            long millis = 0;
                            long jMax = date != null ? Math.max(0L, this.f744j - date.getTime()) : 0L;
                            int i2 = this.f746l;
                            if (i2 != -1) {
                                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i2));
                            }
                            long j2 = this.f744j;
                            long j4 = jMax + (j2 - this.f743i) + (this.f737a - j2);
                            A a2 = this.f739c;
                            c.b(a2);
                            if (a2.H().c() != -1) {
                                time = TimeUnit.SECONDS.toMillis(r2.c());
                            } else {
                                Date date2 = this.f742h;
                                if (date2 != null) {
                                    Date date3 = this.d;
                                    Long lValueOf = date3 == null ? null : Long.valueOf(date3.getTime());
                                    time = date2.getTime() - (lValueOf == null ? this.f744j : lValueOf.longValue());
                                    if (time <= 0) {
                                        time = 0;
                                    }
                                } else if (this.f741f != null && this.f739c.o0().h().k() == null) {
                                    Date date4 = this.d;
                                    Long lValueOf2 = date4 == null ? null : Long.valueOf(date4.getTime());
                                    long jLongValue = lValueOf2 == null ? this.f743i : lValueOf2.longValue();
                                    Date date5 = this.f741f;
                                    c.b(date5);
                                    long time2 = jLongValue - date5.getTime();
                                    if (time2 > 0) {
                                        time = time2 / 10;
                                    }
                                }
                            }
                            if (c0153dB.c() != -1) {
                                time = Math.min(time, TimeUnit.SECONDS.toMillis(c0153dB.c()));
                            }
                            long millis2 = c0153dB.e() != -1 ? TimeUnit.SECONDS.toMillis(c0153dB.e()) : 0L;
                            if (!c0153dH.f() && c0153dB.d() != -1) {
                                millis = TimeUnit.SECONDS.toMillis(c0153dB.d());
                            }
                            if (!c0153dH.g()) {
                                long j5 = millis2 + j4;
                                if (j5 < millis + time) {
                                    A.a aVar = new A.a(this.f739c);
                                    if (j5 >= time) {
                                        aVar.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                                    }
                                    if (j4 > 86400000) {
                                        A a5 = this.f739c;
                                        c.b(a5);
                                        if (a5.H().c() == -1 && this.f742h == null) {
                                            aVar.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                        }
                                    }
                                    r32 = 0;
                                    bVar = new b(null, aVar.c());
                                } else {
                                    String str2 = this.f745k;
                                    if (str2 != null) {
                                        str = "If-None-Match";
                                    } else if (this.f741f != null) {
                                        str2 = this.g;
                                    } else if (this.d != null) {
                                        str2 = this.f740e;
                                    } else {
                                        r32 = 0;
                                        bVar = new b(this.f738b, null);
                                    }
                                    s.a aVarI = this.f738b.e().i();
                                    c.b(str2);
                                    aVarI.b(str, str2);
                                    y.a aVar2 = new y.a(this.f738b);
                                    aVar2.d(aVarI.c());
                                    bVar = new b(aVar2.b(), this.f739c);
                                    r32 = 0;
                                }
                            }
                        }
                    }
                    return (bVar.b() == null && this.f738b.b().i()) ? new b(r32, r32) : bVar;
                }
                bVar = new b(this.f738b, null);
            }
            r32 = 0;
            if (bVar.b() == null) {
            }
        }
    }

    public b(y yVar, A a2) {
        this.f735a = yVar;
        this.f736b = a2;
    }

    public final A a() {
        return this.f736b;
    }

    public final y b() {
        return this.f735a;
    }
}
