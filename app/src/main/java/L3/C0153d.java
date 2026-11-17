package L3;

import java.util.concurrent.TimeUnit;

/* renamed from: L3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0153d {

    /* renamed from: n, reason: collision with root package name */
    public static final b f406n = new b();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f407a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f408b;

    /* renamed from: c, reason: collision with root package name */
    private final int f409c;
    private final int d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f410e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f411f;
    private final boolean g;

    /* renamed from: h, reason: collision with root package name */
    private final int f412h;

    /* renamed from: i, reason: collision with root package name */
    private final int f413i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f414j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f415k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f416l;

    /* renamed from: m, reason: collision with root package name */
    private String f417m;

    /* renamed from: L3.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f418a;

        /* renamed from: b, reason: collision with root package name */
        private int f419b = -1;

        /* renamed from: c, reason: collision with root package name */
        private boolean f420c;

        public final C0153d a() {
            return new C0153d(this.f418a, false, -1, -1, false, false, false, this.f419b, -1, this.f420c, false, false, null);
        }

        public final a b() {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            f3.c.d(timeUnit, "timeUnit");
            long seconds = timeUnit.toSeconds(Integer.MAX_VALUE);
            this.f419b = seconds <= 2147483647L ? (int) seconds : Integer.MAX_VALUE;
            return this;
        }

        public final a c() {
            this.f418a = true;
            return this;
        }

        public final a d() {
            this.f420c = true;
            return this;
        }
    }

    /* renamed from: L3.d$b */
    public static final class b {
        private final int a(String str, String str2, int i2) {
            int length = str.length();
            while (i2 < length) {
                int i4 = i2 + 1;
                if (i3.f.r(str2, str.charAt(i2), 0, false, 2) >= 0) {
                    return i2;
                }
                i2 = i4;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final C0153d b(s sVar) {
            int i2;
            int i4;
            boolean z4;
            int iA;
            String string;
            s sVar2 = sVar;
            f3.c.d(sVar2, "headers");
            int size = sVar.size();
            int i5 = 0;
            boolean z5 = true;
            String str = null;
            boolean z6 = false;
            boolean z7 = false;
            int iZ = -1;
            int iZ2 = -1;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            int iZ3 = -1;
            int iZ4 = -1;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            while (i5 < size) {
                int i6 = i5 + 1;
                String strG = sVar2.g(i5);
                String strK = sVar2.k(i5);
                if (i3.f.q(strG, "Cache-Control")) {
                    if (str == null) {
                        str = strK;
                    }
                    i2 = 0;
                    while (i2 < strK.length()) {
                        int iA2 = a(strK, "=,;", i2);
                        String strSubstring = strK.substring(i2, iA2);
                        f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        String string2 = i3.f.D(strSubstring).toString();
                        if (iA2 == strK.length() || strK.charAt(iA2) == ',' || strK.charAt(iA2) == ';') {
                            i4 = size;
                            z4 = true;
                            iA = iA2 + 1;
                            string = null;
                        } else {
                            int length = iA2 + 1;
                            byte[] bArr = M3.c.f596a;
                            int length2 = strK.length();
                            while (true) {
                                if (length >= length2) {
                                    i4 = size;
                                    length = strK.length();
                                    break;
                                }
                                int i7 = length + 1;
                                int i8 = length2;
                                char cCharAt = strK.charAt(length);
                                i4 = size;
                                if (cCharAt != ' ' && cCharAt != '\t') {
                                    break;
                                }
                                length = i7;
                                length2 = i8;
                                size = i4;
                            }
                            if (length >= strK.length() || strK.charAt(length) != '\"') {
                                z4 = true;
                                iA = a(strK, ",;", length);
                                String strSubstring2 = strK.substring(length, iA);
                                f3.c.c(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                string = i3.f.D(strSubstring2).toString();
                            } else {
                                int i9 = length + 1;
                                int iR = i3.f.r(strK, '\"', i9, false, 4);
                                string = strK.substring(i9, iR);
                                f3.c.c(string, "this as java.lang.String…ing(startIndex, endIndex)");
                                z4 = true;
                                iA = iR + 1;
                            }
                        }
                        if (i3.f.q("no-cache", string2)) {
                            z6 = z4;
                        } else if (i3.f.q("no-store", string2)) {
                            z7 = z4;
                        } else {
                            if (i3.f.q("max-age", string2)) {
                                iZ = M3.c.z(string, -1);
                            } else if (i3.f.q("s-maxage", string2)) {
                                iZ2 = M3.c.z(string, -1);
                            } else if (i3.f.q("private", string2)) {
                                z8 = z4;
                            } else if (i3.f.q("public", string2)) {
                                z9 = z4;
                            } else if (i3.f.q("must-revalidate", string2)) {
                                z10 = z4;
                            } else if (i3.f.q("max-stale", string2)) {
                                iZ3 = M3.c.z(string, Integer.MAX_VALUE);
                            } else if (i3.f.q("min-fresh", string2)) {
                                iZ4 = M3.c.z(string, -1);
                            } else if (i3.f.q("only-if-cached", string2)) {
                                z11 = z4;
                            } else if (i3.f.q("no-transform", string2)) {
                                z12 = z4;
                            } else if (i3.f.q("immutable", string2)) {
                                z13 = z4;
                            }
                            i2 = iA;
                            size = i4;
                        }
                        i2 = iA;
                        size = i4;
                    }
                    sVar2 = sVar;
                    i5 = i6;
                    size = size;
                } else if (!i3.f.q(strG, "Pragma")) {
                    sVar2 = sVar;
                    i5 = i6;
                    size = size;
                }
                z5 = false;
                i2 = 0;
                while (i2 < strK.length()) {
                }
                sVar2 = sVar;
                i5 = i6;
                size = size;
            }
            return new C0153d(z6, z7, iZ, iZ2, z8, z9, z10, iZ3, iZ4, z11, z12, z13, !z5 ? null : str);
        }
    }

    static {
        a aVar = new a();
        aVar.c();
        aVar.a();
        a aVar2 = new a();
        aVar2.d();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar2.b();
        aVar2.a();
    }

    public C0153d(boolean z4, boolean z5, int i2, int i4, boolean z6, boolean z7, boolean z8, int i5, int i6, boolean z9, boolean z10, boolean z11, String str) {
        this.f407a = z4;
        this.f408b = z5;
        this.f409c = i2;
        this.d = i4;
        this.f410e = z6;
        this.f411f = z7;
        this.g = z8;
        this.f412h = i5;
        this.f413i = i6;
        this.f414j = z9;
        this.f415k = z10;
        this.f416l = z11;
        this.f417m = str;
    }

    public final boolean a() {
        return this.f410e;
    }

    public final boolean b() {
        return this.f411f;
    }

    public final int c() {
        return this.f409c;
    }

    public final int d() {
        return this.f412h;
    }

    public final int e() {
        return this.f413i;
    }

    public final boolean f() {
        return this.g;
    }

    public final boolean g() {
        return this.f407a;
    }

    public final boolean h() {
        return this.f408b;
    }

    public final boolean i() {
        return this.f414j;
    }

    public final String toString() {
        String str = this.f417m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f407a) {
            sb.append("no-cache, ");
        }
        if (this.f408b) {
            sb.append("no-store, ");
        }
        if (this.f409c != -1) {
            sb.append("max-age=");
            sb.append(this.f409c);
            sb.append(", ");
        }
        if (this.d != -1) {
            sb.append("s-maxage=");
            sb.append(this.d);
            sb.append(", ");
        }
        if (this.f410e) {
            sb.append("private, ");
        }
        if (this.f411f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.f412h != -1) {
            sb.append("max-stale=");
            sb.append(this.f412h);
            sb.append(", ");
        }
        if (this.f413i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f413i);
            sb.append(", ");
        }
        if (this.f414j) {
            sb.append("only-if-cached, ");
        }
        if (this.f415k) {
            sb.append("no-transform, ");
        }
        if (this.f416l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        f3.c.c(string, "StringBuilder().apply(builderAction).toString()");
        this.f417m = string;
        return string;
    }
}
