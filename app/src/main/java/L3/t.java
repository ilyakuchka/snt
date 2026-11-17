package L3;

import g3.C0324a;
import g3.C0327d;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: k, reason: collision with root package name */
    public static final b f481k = new b();

    /* renamed from: l, reason: collision with root package name */
    private static final char[] f482l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    private final String f483a;

    /* renamed from: b, reason: collision with root package name */
    private final String f484b;

    /* renamed from: c, reason: collision with root package name */
    private final String f485c;
    private final String d;

    /* renamed from: e, reason: collision with root package name */
    private final int f486e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f487f;
    private final List<String> g;

    /* renamed from: h, reason: collision with root package name */
    private final String f488h;

    /* renamed from: i, reason: collision with root package name */
    private final String f489i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f490j;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f491a;
        private String d;

        /* renamed from: f, reason: collision with root package name */
        private final List<String> f495f;
        private List<String> g;

        /* renamed from: h, reason: collision with root package name */
        private String f496h;

        /* renamed from: b, reason: collision with root package name */
        private String f492b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f493c = "";

        /* renamed from: e, reason: collision with root package name */
        private int f494e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f495f = arrayList;
            arrayList.add("");
        }

        private final int c() {
            int i2;
            int i4 = this.f494e;
            if (i4 != -1) {
                return i4;
            }
            String str = this.f491a;
            f3.c.b(str);
            if (f3.c.a(str, "http")) {
                i2 = 80;
            } else {
                if (!f3.c.a(str, "https")) {
                    return -1;
                }
                i2 = 443;
            }
            return i2;
        }

        public final a a(String str, String str2) {
            if (this.g == null) {
                this.g = new ArrayList();
            }
            List<String> list = this.g;
            f3.c.b(list);
            list.add(b.a(str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219));
            List<String> list2 = this.g;
            f3.c.b(list2);
            list2.add(str2 == null ? null : b.a(str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219));
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Iterable, java.util.ArrayList, java.util.List<java.lang.String>] */
        public final t b() {
            ArrayList arrayList;
            String str = this.f491a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String strD = b.d(this.f492b, 0, 0, false, 7);
            String strD2 = b.d(this.f493c, 0, 0, false, 7);
            String str2 = this.d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iC = c();
            ?? r02 = this.f495f;
            ArrayList arrayList2 = new ArrayList(Z2.g.d(r02));
            Iterator it = r02.iterator();
            while (it.hasNext()) {
                arrayList2.add(b.d((String) it.next(), 0, 0, false, 7));
            }
            List<String> list = this.g;
            if (list == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(Z2.g.d(list));
                for (String str3 : list) {
                    arrayList.add(str3 == null ? null : b.d(str3, 0, 0, true, 3));
                }
            }
            String str4 = this.f496h;
            return new t(str, strD, strD2, str2, iC, arrayList2, arrayList, str4 != null ? b.d(str4, 0, 0, false, 7) : null, toString());
        }

        public final a d(String str) {
            this.g = str == null ? null : t.f481k.e(b.a(str, 0, 0, " \"'<>#", true, false, true, false, null, 211));
            return this;
        }

        public final List<String> e() {
            return this.f495f;
        }

        public final a f(String str) {
            f3.c.d(str, "host");
            String strB = M3.a.b(b.d(str, 0, 0, false, 7));
            if (strB == null) {
                throw new IllegalArgumentException(f3.c.h("unexpected host: ", str));
            }
            this.d = strB;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x0098  */
        /* JADX WARN: Type inference failed for: r1v60, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r1v61, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r1v67, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r1v68, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r1v71, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r2v37, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r2v38, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r2v53, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r2v68, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r2v73, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r2v74, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r3v28, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r3v34, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final a g(t tVar, String str) throws NumberFormatException {
            int i2;
            char c2;
            char c4;
            int iH;
            int i4;
            int i5;
            boolean z4;
            boolean z5;
            int i6;
            int i7;
            int i8;
            String str2;
            byte[] bArr = M3.c.f596a;
            int i9 = 0;
            int iO = M3.c.o(str, 0, str.length());
            int iP = M3.c.p(str, iO, str.length());
            char c5 = ':';
            char c6 = 65535;
            if (iP - iO < 2) {
                i2 = -1;
            } else {
                char cCharAt = str.charAt(iO);
                if ((f3.c.e(cCharAt, 97) >= 0 && f3.c.e(cCharAt, 122) <= 0) || (f3.c.e(cCharAt, 65) >= 0 && f3.c.e(cCharAt, 90) <= 0)) {
                    i2 = iO + 1;
                    while (true) {
                        if (i2 >= iP) {
                            break;
                        }
                        int i10 = i2 + 1;
                        char cCharAt2 = str.charAt(i2);
                        if (!(((((('a' <= cCharAt2 && cCharAt2 < '{') || ('A' <= cCharAt2 && cCharAt2 < '[')) || ('0' <= cCharAt2 && cCharAt2 < ':')) || cCharAt2 == '+') || cCharAt2 == '-') || cCharAt2 == '.')) {
                            if (cCharAt2 != ':') {
                                break;
                            }
                        } else {
                            i2 = i10;
                        }
                    }
                    i2 = -1;
                }
            }
            String str3 = "https";
            if (i2 != -1) {
                if (i3.f.z(str, "https:", iO, true)) {
                    this.f491a = "https";
                    iO += 6;
                } else {
                    if (!i3.f.z(str, "http:", iO, true)) {
                        StringBuilder sbD = D2.e.d("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str.substring(0, i2);
                        f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sbD.append(strSubstring);
                        sbD.append('\'');
                        throw new IllegalArgumentException(sbD.toString());
                    }
                    this.f491a = "http";
                    iO += 5;
                }
            } else {
                if (tVar == null) {
                    throw new IllegalArgumentException(f3.c.h("Expected URL scheme 'http' or 'https' but no scheme was found for ", str.length() > 6 ? f3.c.h(i3.f.C(str, 6), "...") : str));
                }
                this.f491a = tVar.p();
            }
            int i11 = iO;
            while (true) {
                c2 = '\\';
                c4 = '/';
                if (i11 >= iP) {
                    break;
                }
                int i12 = i11 + 1;
                char cCharAt3 = str.charAt(i11);
                if (cCharAt3 != '\\' && cCharAt3 != '/') {
                    break;
                }
                i9++;
                i11 = i12;
            }
            char c7 = '?';
            char c8 = '#';
            if (i9 >= 2 || tVar == null || !f3.c.a(tVar.p(), this.f491a)) {
                int i13 = iO + i9;
                boolean z6 = false;
                boolean z7 = false;
                while (true) {
                    iH = M3.c.h(str, "@/\\?#", i13, iP);
                    char cCharAt4 = iH != iP ? str.charAt(iH) : c6;
                    if (cCharAt4 == c6 || cCharAt4 == c8 || cCharAt4 == c4 || cCharAt4 == c2 || cCharAt4 == c7) {
                        break;
                    }
                    if (cCharAt4 == '@') {
                        if (z6) {
                            i7 = iH;
                            i8 = iP;
                            String str4 = str3;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.f493c);
                            sb.append("%40");
                            str2 = str4;
                            sb.append(b.a(str, i13, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240));
                            this.f493c = sb.toString();
                        } else {
                            int iG = M3.c.g(str, c5, i13, iH);
                            i7 = iH;
                            i8 = iP;
                            String str5 = str3;
                            String strA = b.a(str, i13, iG, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                            if (z7) {
                                strA = this.f492b + "%40" + strA;
                            }
                            this.f492b = strA;
                            if (iG != i7) {
                                this.f493c = b.a(str, iG + 1, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                                z6 = true;
                            }
                            z7 = true;
                            str2 = str5;
                        }
                        i13 = i7 + 1;
                        c7 = '?';
                        c2 = '\\';
                        c4 = '/';
                        c8 = '#';
                        c5 = ':';
                        iP = i8;
                        str3 = str2;
                        c6 = 65535;
                    }
                }
                String str6 = str3;
                i4 = iP;
                int i14 = i13;
                while (true) {
                    if (i14 >= iH) {
                        i5 = iH;
                        break;
                    }
                    char cCharAt5 = str.charAt(i14);
                    if (cCharAt5 == '[') {
                        do {
                            i14++;
                            if (i14 >= iH) {
                                break;
                            }
                        } while (str.charAt(i14) != ']');
                    } else if (cCharAt5 == ':') {
                        i5 = i14;
                        break;
                    }
                    i14++;
                }
                int i15 = i5 + 1;
                char c9 = '\"';
                if (i15 < iH) {
                    this.d = M3.a.b(b.d(str, i13, i5, false, 4));
                    int i16 = i13;
                    try {
                        i6 = Integer.parseInt(b.a(str, i15, iH, "", false, false, false, false, null, 248));
                    } catch (NumberFormatException unused) {
                    }
                    if (!(1 <= i6 && i6 < 65536)) {
                        i6 = -1;
                    }
                    this.f494e = i6;
                    if (!(i6 != -1)) {
                        StringBuilder sbD2 = D2.e.d("Invalid URL port: \"");
                        String strSubstring2 = str.substring(i15, iH);
                        f3.c.c(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sbD2.append(strSubstring2);
                        sbD2.append('\"');
                        throw new IllegalArgumentException(sbD2.toString().toString());
                    }
                    c9 = '\"';
                    z4 = false;
                    i13 = i16;
                } else {
                    this.d = M3.a.b(b.d(str, i13, i5, false, 4));
                    String str7 = this.f491a;
                    f3.c.b(str7);
                    this.f494e = f3.c.a(str7, "http") ? 80 : f3.c.a(str7, str6) ? 443 : -1;
                    z4 = false;
                }
                if (!(this.d != null ? true : z4)) {
                    StringBuilder sbD3 = D2.e.d("Invalid URL host: \"");
                    String strSubstring3 = str.substring(i13, i5);
                    f3.c.c(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    sbD3.append(strSubstring3);
                    sbD3.append(c9);
                    throw new IllegalArgumentException(sbD3.toString().toString());
                }
                z5 = z4;
                iO = iH;
            } else {
                this.f492b = tVar.f();
                this.f493c = tVar.b();
                this.d = tVar.g();
                this.f494e = tVar.j();
                this.f495f.clear();
                this.f495f.addAll(tVar.d());
                if (iO == iP || str.charAt(iO) == '#') {
                    d(tVar.e());
                }
                i4 = iP;
                z5 = false;
            }
            int i17 = i4;
            int iH2 = M3.c.h(str, "?#", iO, i17);
            if (iO != iH2) {
                char cCharAt6 = str.charAt(iO);
                if (cCharAt6 == '/' || cCharAt6 == '\\') {
                    this.f495f.clear();
                    this.f495f.add("");
                    iO++;
                } else {
                    this.f495f.set(r2.size() - 1, "");
                }
                int i18 = iO;
                while (i18 < iH2) {
                    int iH3 = M3.c.h(str, "/\\", i18, iH2);
                    boolean z8 = iH3 < iH2 ? true : z5;
                    String strA2 = b.a(str, i18, iH3, " \"<>^`{}|/\\?#", true, false, false, false, null, 240);
                    if (!((f3.c.a(strA2, ".") || i3.f.q(strA2, "%2e")) ? true : z5)) {
                        if ((f3.c.a(strA2, "..") || i3.f.q(strA2, "%2e.") || i3.f.q(strA2, ".%2e") || i3.f.q(strA2, "%2e%2e")) ? true : z5) {
                            ?? r12 = this.f495f;
                            if ((((String) r12.remove(r12.size() - 1)).length() == 0 ? true : z5) && (!this.f495f.isEmpty())) {
                                ?? r13 = this.f495f;
                                r13.set(r13.size() - 1, "");
                            } else {
                                this.f495f.add("");
                            }
                        } else {
                            ?? r32 = this.f495f;
                            if (((CharSequence) r32.get(r32.size() - 1)).length() == 0 ? true : z5) {
                                ?? r33 = this.f495f;
                                r33.set(r33.size() - 1, strA2);
                            } else {
                                this.f495f.add(strA2);
                            }
                            if (z8) {
                                this.f495f.add("");
                            }
                        }
                    }
                    i18 = z8 ? iH3 + 1 : iH3;
                }
            }
            if (iH2 < i17 && str.charAt(iH2) == '?') {
                int iG2 = M3.c.g(str, '#', iH2, i17);
                this.g = t.f481k.e(b.a(str, iH2 + 1, iG2, " \"'<>#", true, false, true, false, null, 208));
                iH2 = iG2;
            }
            if (iH2 < i17 && str.charAt(iH2) == '#') {
                this.f496h = b.a(str, iH2 + 1, i17, "", true, false, false, true, null, 176);
            }
            return this;
        }

        public final a h() {
            this.f493c = b.a("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
            return this;
        }

        public final a i(int i2) {
            boolean z4 = false;
            if (1 <= i2 && i2 < 65536) {
                z4 = true;
            }
            if (!z4) {
                throw new IllegalArgumentException(f3.c.h("unexpected port: ", Integer.valueOf(i2)).toString());
            }
            this.f494e = i2;
            return this;
        }

        public final a j() {
            this.g = null;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
        public final a k() {
            String str = this.d;
            this.d = str == null ? null : new i3.e("[\"<>^`{|}]").b(str);
            int size = this.f495f.size();
            int i2 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                ?? r6 = this.f495f;
                r6.set(i4, b.a((String) r6.get(i4), 0, 0, "[]", true, true, false, false, null, 227));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                while (i2 < size2) {
                    int i5 = i2 + 1;
                    String str2 = list.get(i2);
                    list.set(i2, str2 == null ? null : b.a(str2, 0, 0, "\\^`{|}", true, true, true, false, null, 195));
                    i2 = i5;
                }
            }
            String str3 = this.f496h;
            this.f496h = str3 != null ? b.a(str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163) : null;
            return this;
        }

        public final a l(String str) {
            if (i3.f.q(str, "http")) {
                this.f491a = "http";
            } else {
                if (!i3.f.q(str, "https")) {
                    throw new IllegalArgumentException(f3.c.h("unexpected scheme: ", str));
                }
                this.f491a = "https";
            }
            return this;
        }

        public final void m(String str) {
            this.f496h = str;
        }

        public final void n(String str) {
            this.f493c = str;
        }

        public final void o(String str) {
            this.f492b = str;
        }

        public final void p(String str) {
            this.d = str;
        }

        public final void q(int i2) {
            this.f494e = i2;
        }

        public final void r(String str) {
            this.f491a = str;
        }

        public final a s() {
            this.f492b = b.a("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
        /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Object, java.util.ArrayList, java.util.List<java.lang.String>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f491a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.f492b.length() > 0) {
                sb.append(this.f492b);
                if (this.f493c.length() > 0) {
                    sb.append(':');
                    sb.append(this.f493c);
                }
                sb.append('@');
            } else if (this.f493c.length() > 0) {
            }
            String str2 = this.d;
            if (str2 != null) {
                if (i3.f.r(str2, ':', 0, false, 2) >= 0) {
                    sb.append('[');
                    sb.append(this.d);
                    sb.append(']');
                } else {
                    sb.append(this.d);
                }
            }
            int i2 = -1;
            if (this.f494e != -1 || this.f491a != null) {
                int iC = c();
                String str3 = this.f491a;
                if (str3 == null) {
                    sb.append(':');
                    sb.append(iC);
                } else {
                    if (f3.c.a(str3, "http")) {
                        i2 = 80;
                    } else if (f3.c.a(str3, "https")) {
                        i2 = 443;
                    }
                    if (iC != i2) {
                    }
                }
            }
            ?? r12 = this.f495f;
            f3.c.d(r12, "<this>");
            int size = r12.size();
            for (int i4 = 0; i4 < size; i4++) {
                sb.append('/');
                sb.append((String) r12.get(i4));
            }
            if (this.g != null) {
                sb.append('?');
                b bVar = t.f481k;
                List<String> list = this.g;
                f3.c.b(list);
                bVar.f(list, sb);
            }
            if (this.f496h != null) {
                sb.append('#');
                sb.append(this.f496h);
            }
            String string = sb.toString();
            f3.c.c(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    public static final class b {
        /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static String a(String str, int i2, int i4, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset, int i5) {
            String str3;
            int iCharCount;
            int i6;
            boolean z8;
            String str4 = str;
            b bVar = t.f481k;
            int i7 = (i5 & 1) != 0 ? 0 : i2;
            int length = (i5 & 2) != 0 ? str.length() : i4;
            boolean z9 = (i5 & 8) != 0 ? false : z4;
            boolean z10 = (i5 & 16) != 0 ? false : z5;
            boolean z11 = (i5 & 32) != 0 ? false : z6;
            boolean z12 = (i5 & 64) != 0 ? false : z7;
            int i8 = 128;
            Charset charset2 = (i5 & 128) != 0 ? null : charset;
            f3.c.d(str4, "<this>");
            int iCharCount2 = i7;
            while (iCharCount2 < length) {
                int iCodePointAt = str4.codePointAt(iCharCount2);
                int i9 = 2;
                boolean z13 = true;
                if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= i8 && !z12)) {
                    str3 = str2;
                    X3.d dVar = new X3.d();
                    dVar.z0(str4, i7, iCharCount2);
                    iCharCount = iCharCount2;
                    int i10 = 32;
                    boolean z14 = z12;
                    boolean z15 = z11;
                    boolean z16 = z10;
                    boolean z17 = z9;
                    i6 = length;
                    X3.d dVar2 = null;
                    Charset charset3 = charset2;
                    String str5 = str4;
                    while (iCharCount < i6) {
                        boolean z18 = z13;
                        int iCodePointAt2 = str4.codePointAt(iCharCount);
                        String str6 = str5;
                        if (z17 && (iCodePointAt2 == 9 || iCodePointAt2 == 10 || iCodePointAt2 == 12 || iCodePointAt2 == 13)) {
                            z8 = z18;
                            str5 = str6;
                        } else {
                            if (iCodePointAt2 == 43 && z15) {
                                dVar.y0(z17 ? "+" : "%2B");
                            } else {
                                if (iCodePointAt2 >= i10 && iCodePointAt2 != 127 && (iCodePointAt2 < 128 || z14)) {
                                    if (!(i3.f.r(str3, (char) iCodePointAt2, 0, false, i9) >= 0 ? z18 : false) && (iCodePointAt2 != 37 || (z17 && (!z16 || bVar.c(str4, iCharCount, i6))))) {
                                        dVar.A0(iCodePointAt2);
                                    }
                                }
                                if (dVar2 == null) {
                                    dVar2 = new X3.d();
                                }
                                if (charset3 == null || f3.c.a(charset3, StandardCharsets.UTF_8)) {
                                    dVar2.A0(iCodePointAt2);
                                } else {
                                    int iCharCount3 = Character.charCount(iCodePointAt2) + iCharCount;
                                    if (!(iCharCount >= 0 ? z18 : false)) {
                                        throw new IllegalArgumentException(f3.c.h("beginIndex < 0: ", Integer.valueOf(iCharCount)).toString());
                                    }
                                    if (!(iCharCount3 >= iCharCount ? z18 : false)) {
                                        throw new IllegalArgumentException(("endIndex < beginIndex: " + iCharCount3 + " < " + iCharCount).toString());
                                    }
                                    if (!(iCharCount3 <= str6.length() ? z18 : false)) {
                                        StringBuilder sbC = C2.c.c("endIndex > string.length: ", iCharCount3, " > ");
                                        sbC.append(str6.length());
                                        throw new IllegalArgumentException(sbC.toString().toString());
                                    }
                                    if (f3.c.a(charset3, i3.c.f6339b)) {
                                        dVar2.z0(str4, iCharCount, iCharCount3);
                                    } else {
                                        String strSubstring = str4.substring(iCharCount, iCharCount3);
                                        f3.c.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        byte[] bytes = strSubstring.getBytes(charset3);
                                        f3.c.c(bytes, "(this as java.lang.String).getBytes(charset)");
                                        dVar2.s0(bytes, 0, bytes.length);
                                    }
                                }
                                str5 = str6;
                                while (!dVar2.V()) {
                                    int i11 = dVar2.readByte() & 255;
                                    dVar.u0(37);
                                    dVar.u0(t.f482l[(i11 >> 4) & 15]);
                                    dVar.u0(t.f482l[i11 & 15]);
                                    str4 = str4;
                                }
                                iCodePointAt2 = iCodePointAt2;
                                z8 = z18;
                            }
                            z8 = z18;
                            str5 = str6;
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i9 = 2;
                        z13 = z8;
                        i10 = 32;
                    }
                    return dVar.k0();
                }
                str3 = str2;
                if ((i3.f.r(str3, (char) iCodePointAt, 0, false, 2) >= 0) || ((iCodePointAt == 37 && (!z9 || (z10 && !bVar.c(str4, iCharCount2, length)))) || (iCodePointAt == 43 && z11))) {
                    X3.d dVar3 = new X3.d();
                    dVar3.z0(str4, i7, iCharCount2);
                    iCharCount = iCharCount2;
                    int i102 = 32;
                    boolean z142 = z12;
                    boolean z152 = z11;
                    boolean z162 = z10;
                    boolean z172 = z9;
                    i6 = length;
                    X3.d dVar22 = null;
                    Charset charset32 = charset2;
                    String str52 = str4;
                    while (iCharCount < i6) {
                    }
                    return dVar3.k0();
                }
                iCharCount2 += Character.charCount(iCodePointAt);
                i8 = 128;
            }
            String strSubstring2 = str4.substring(i7, length);
            f3.c.c(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring2;
        }

        private final boolean c(String str, int i2, int i4) {
            int i5 = i2 + 2;
            return i5 < i4 && str.charAt(i2) == '%' && M3.c.s(str.charAt(i2 + 1)) != -1 && M3.c.s(str.charAt(i5)) != -1;
        }

        public static String d(String str, int i2, int i4, boolean z4, int i5) {
            int i6;
            if ((i5 & 1) != 0) {
                i2 = 0;
            }
            if ((i5 & 2) != 0) {
                i4 = str.length();
            }
            if ((i5 & 4) != 0) {
                z4 = false;
            }
            f3.c.d(str, "<this>");
            int iCharCount = i2;
            while (iCharCount < i4) {
                int i7 = iCharCount + 1;
                char cCharAt = str.charAt(iCharCount);
                if (cCharAt == '%' || (cCharAt == '+' && z4)) {
                    X3.d dVar = new X3.d();
                    dVar.z0(str, i2, iCharCount);
                    while (iCharCount < i4) {
                        int iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 37 && (i6 = iCharCount + 2) < i4) {
                            int iS = M3.c.s(str.charAt(iCharCount + 1));
                            int iS2 = M3.c.s(str.charAt(i6));
                            if (iS == -1 || iS2 == -1) {
                                dVar.A0(iCodePointAt);
                                iCharCount += Character.charCount(iCodePointAt);
                            } else {
                                dVar.u0((iS << 4) + iS2);
                                iCharCount = Character.charCount(iCodePointAt) + i6;
                            }
                        } else if (iCodePointAt == 43 && z4) {
                            dVar.u0(32);
                            iCharCount++;
                        } else {
                            dVar.A0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                    return dVar.k0();
                }
                iCharCount = i7;
            }
            String strSubstring = str.substring(i2, i4);
            f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final int b(String str) {
            f3.c.d(str, "scheme");
            if (f3.c.a(str, "http")) {
                return 80;
            }
            return f3.c.a(str, "https") ? 443 : -1;
        }

        public final List<String> e(String str) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 <= str.length()) {
                int iR = i3.f.r(str, '&', i2, false, 4);
                if (iR == -1) {
                    iR = str.length();
                }
                int iR2 = i3.f.r(str, '=', i2, false, 4);
                if (iR2 == -1 || iR2 > iR) {
                    String strSubstring = str.substring(i2, iR);
                    f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i2, iR2);
                    f3.c.c(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iR2 + 1, iR);
                    f3.c.c(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i2 = iR + 1;
            }
            return arrayList;
        }

        public final void f(List<String> list, StringBuilder sb) {
            f3.c.d(list, "<this>");
            C0324a c0324aA = C0327d.a(C0327d.b(0, list.size()), 2);
            int iD = c0324aA.d();
            int iG = c0324aA.g();
            int iH = c0324aA.h();
            if ((iH <= 0 || iD > iG) && (iH >= 0 || iG > iD)) {
                return;
            }
            while (true) {
                int i2 = iD + iH;
                String str = list.get(iD);
                String str2 = list.get(iD + 1);
                if (iD > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (iD == iG) {
                    return;
                } else {
                    iD = i2;
                }
            }
        }
    }

    public t(String str, String str2, String str3, String str4, int i2, List<String> list, List<String> list2, String str5, String str6) {
        this.f483a = str;
        this.f484b = str2;
        this.f485c = str3;
        this.d = str4;
        this.f486e = i2;
        this.f487f = list;
        this.g = list2;
        this.f488h = str5;
        this.f489i = str6;
        this.f490j = f3.c.a(str, "https");
    }

    public final String b() {
        if (this.f485c.length() == 0) {
            return "";
        }
        String strSubstring = this.f489i.substring(i3.f.r(this.f489i, ':', this.f483a.length() + 3, false, 4) + 1, i3.f.r(this.f489i, '@', 0, false, 6));
        f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String c() {
        int iR = i3.f.r(this.f489i, '/', this.f483a.length() + 3, false, 4);
        String str = this.f489i;
        String strSubstring = this.f489i.substring(iR, M3.c.h(str, "?#", iR, str.length()));
        f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> d() {
        int iR = i3.f.r(this.f489i, '/', this.f483a.length() + 3, false, 4);
        String str = this.f489i;
        int iH = M3.c.h(str, "?#", iR, str.length());
        ArrayList arrayList = new ArrayList();
        while (iR < iH) {
            int i2 = iR + 1;
            int iG = M3.c.g(this.f489i, '/', i2, iH);
            String strSubstring = this.f489i.substring(i2, iG);
            f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iR = iG;
        }
        return arrayList;
    }

    public final String e() {
        if (this.g == null) {
            return null;
        }
        int iR = i3.f.r(this.f489i, '?', 0, false, 6) + 1;
        String str = this.f489i;
        String strSubstring = this.f489i.substring(iR, M3.c.g(str, '#', iR, str.length()));
        f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof t) && f3.c.a(((t) obj).f489i, this.f489i);
    }

    public final String f() {
        if (this.f484b.length() == 0) {
            return "";
        }
        int length = this.f483a.length() + 3;
        String str = this.f489i;
        String strSubstring = this.f489i.substring(length, M3.c.h(str, ":@", length, str.length()));
        f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String g() {
        return this.d;
    }

    public final boolean h() {
        return this.f490j;
    }

    public final int hashCode() {
        return this.f489i.hashCode();
    }

    public final a i() {
        String strSubstring;
        a aVar = new a();
        aVar.r(this.f483a);
        aVar.o(f());
        aVar.n(b());
        aVar.p(this.d);
        aVar.q(this.f486e != f481k.b(this.f483a) ? this.f486e : -1);
        ((ArrayList) aVar.e()).clear();
        ((ArrayList) aVar.e()).addAll(d());
        aVar.d(e());
        if (this.f488h == null) {
            strSubstring = null;
        } else {
            strSubstring = this.f489i.substring(i3.f.r(this.f489i, '#', 0, false, 6) + 1);
            f3.c.c(strSubstring, "this as java.lang.String).substring(startIndex)");
        }
        aVar.m(strSubstring);
        return aVar;
    }

    public final int j() {
        return this.f486e;
    }

    public final String k() {
        if (this.g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        f481k.f(this.g, sb);
        return sb.toString();
    }

    public final String l(int i2) {
        List<String> list = this.g;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i2 * 2);
        f3.c.b(str);
        return str;
    }

    public final String m(int i2) {
        List<String> list = this.g;
        if (list != null) {
            return list.get((i2 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int n() {
        List<String> list = this.g;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String o() {
        a aVar;
        try {
            aVar = new a();
            aVar.g(this, "/...");
        } catch (IllegalArgumentException unused) {
            aVar = null;
        }
        f3.c.b(aVar);
        aVar.s();
        aVar.h();
        return aVar.b().f489i;
    }

    public final String p() {
        return this.f483a;
    }

    public final URI q() {
        a aVarI = i();
        aVarI.k();
        String string = aVarI.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e2) {
            try {
                URI uriCreate = URI.create(new i3.e("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").b(string));
                f3.c.c(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final String toString() {
        return this.f489i;
    }
}
