package L3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: j, reason: collision with root package name */
    public static final a f454j = new a();

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f455k = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f456l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f457m = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f458n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    private final String f459a;

    /* renamed from: b, reason: collision with root package name */
    private final String f460b;

    /* renamed from: c, reason: collision with root package name */
    private final long f461c;
    private final String d;

    /* renamed from: e, reason: collision with root package name */
    private final String f462e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f463f;
    private final boolean g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f464h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f465i;

    public static final class a {
        /* JADX WARN: Removed duplicated region for block: B:32:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final int a(String str, int i2, int i4, boolean z4) {
            while (i2 < i4) {
                int i5 = i2 + 1;
                char cCharAt = str.charAt(i2);
                boolean z5 = false;
                if ((cCharAt >= ' ' || cCharAt == '\t') && cCharAt < 127) {
                    if (cCharAt <= '9' && '0' <= cCharAt) {
                        z5 = true;
                    } else {
                        if (!(cCharAt <= 'z' && 'a' <= cCharAt)) {
                            if ((cCharAt <= 'Z' && 'A' <= cCharAt) || cCharAt == ':') {
                            }
                        }
                    }
                }
                if (z5 == (!z4)) {
                    return i2;
                }
                i2 = i5;
            }
            return i4;
        }

        private final long c(String str, int i2) throws NumberFormatException {
            int iA = a(str, 0, i2, false);
            Matcher matcher = l.f458n.matcher(str);
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int iS = -1;
            int i7 = -1;
            int i8 = -1;
            while (iA < i2) {
                int iA2 = a(str, iA + 1, i2, true);
                matcher.region(iA, iA2);
                if (i5 == -1 && matcher.usePattern(l.f458n).matches()) {
                    String strGroup = matcher.group(1);
                    f3.c.c(strGroup, "matcher.group(1)");
                    i5 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    f3.c.c(strGroup2, "matcher.group(2)");
                    i7 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    f3.c.c(strGroup3, "matcher.group(3)");
                    i8 = Integer.parseInt(strGroup3);
                } else if (i6 == -1 && matcher.usePattern(l.f457m).matches()) {
                    String strGroup4 = matcher.group(1);
                    f3.c.c(strGroup4, "matcher.group(1)");
                    i6 = Integer.parseInt(strGroup4);
                } else if (iS == -1 && matcher.usePattern(l.f456l).matches()) {
                    String strGroup5 = matcher.group(1);
                    f3.c.c(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    f3.c.c(locale, "US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    f3.c.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = l.f456l.pattern();
                    f3.c.c(strPattern, "MONTH_PATTERN.pattern()");
                    iS = i3.f.s(strPattern, lowerCase, 0, false, 6) / 4;
                } else if (i4 == -1 && matcher.usePattern(l.f455k).matches()) {
                    String strGroup6 = matcher.group(1);
                    f3.c.c(strGroup6, "matcher.group(1)");
                    i4 = Integer.parseInt(strGroup6);
                }
                iA = a(str, iA2 + 1, i2, false);
            }
            if (70 <= i4 && i4 < 100) {
                i4 += 1900;
            }
            if (i4 >= 0 && i4 < 70) {
                i4 += 2000;
            }
            if (!(i4 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(iS != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i6 && i6 < 32)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i5 >= 0 && i5 < 24)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i7 >= 0 && i7 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i8 >= 0 && i8 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(M3.c.f599e);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, iS - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        /* JADX WARN: Code restructure failed: missing block: B:108:0x01e1, code lost:
        
            if (okhttp3.internal.publicsuffix.PublicSuffixDatabase.f7571h.b(r1) == null) goto L109;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0043  */
        /* JADX WARN: Type inference failed for: r21v2 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<l> b(t tVar, s sVar) throws NumberFormatException {
            List<String> list;
            int i2;
            long j2;
            String str;
            String str2;
            l lVar;
            List<String> list2;
            f3.c.d(tVar, "url");
            f3.c.d(sVar, "headers");
            List<String> listL = sVar.l("Set-Cookie");
            int size = listL.size();
            int i4 = 0;
            int i5 = 0;
            ArrayList arrayList = null;
            while (i5 < size) {
                int i6 = i5 + 1;
                String str3 = listL.get(i5);
                f3.c.d(str3, "setCookie");
                long jCurrentTimeMillis = System.currentTimeMillis();
                byte[] bArr = M3.c.f596a;
                char c2 = ';';
                int iG = M3.c.g(str3, ';', i4, str3.length());
                char c4 = '=';
                int iG2 = M3.c.g(str3, '=', i4, iG);
                if (iG2 == iG) {
                    list = listL;
                    i2 = i4;
                    lVar = null;
                } else {
                    String strA = M3.c.A(str3, i4, iG2);
                    boolean z4 = true;
                    if ((strA.length() == 0 ? 1 : i4) == 0) {
                        if (M3.c.n(strA) != -1) {
                            list = listL;
                            i2 = 0;
                        } else {
                            String strA2 = M3.c.A(str3, iG2 + 1, iG);
                            if (M3.c.n(strA2) == -1) {
                                int i7 = iG + 1;
                                int length = str3.length();
                                int i8 = i4;
                                boolean z5 = i8 == true ? 1 : 0;
                                boolean z6 = z5;
                                boolean z7 = true;
                                long j4 = -1;
                                long jC = 253402300799999L;
                                String str4 = null;
                                String str5 = null;
                                boolean z8 = i8;
                                while (true) {
                                    if (i7 < length) {
                                        int iG3 = M3.c.g(str3, c2, i7, length);
                                        int iG4 = M3.c.g(str3, c4, i7, iG3);
                                        String strA3 = M3.c.A(str3, i7, iG4);
                                        String strA4 = iG4 < iG3 ? M3.c.A(str3, iG4 + 1, iG3) : "";
                                        if (i3.f.q(strA3, "expires")) {
                                            try {
                                                jC = c(strA4, strA4.length());
                                                list2 = listL;
                                                z6 = true;
                                            } catch (IllegalArgumentException unused) {
                                                list2 = listL;
                                                i7 = iG3 + 1;
                                                listL = list2;
                                                c2 = ';';
                                                c4 = '=';
                                                z8 = z8;
                                            }
                                        } else {
                                            list2 = listL;
                                            if (i3.f.q(strA3, "max-age")) {
                                                try {
                                                    long j5 = Long.parseLong(strA4);
                                                    j4 = j5 > 0 ? j5 : Long.MIN_VALUE;
                                                } catch (NumberFormatException e2) {
                                                    try {
                                                        if (!new i3.e("-?\\d+").a(strA4)) {
                                                            throw e2;
                                                        }
                                                        j4 = i3.f.A(strA4, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                                                    } catch (NumberFormatException | IllegalArgumentException unused2) {
                                                        continue;
                                                    }
                                                }
                                                z6 = true;
                                            } else if (i3.f.q(strA3, "domain")) {
                                                if (!(!strA4.endsWith("."))) {
                                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                                }
                                                String strB = M3.a.b(i3.f.u(strA4, "."));
                                                if (strB == null) {
                                                    throw new IllegalArgumentException();
                                                }
                                                str4 = strB;
                                                z7 = false;
                                            } else if (i3.f.q(strA3, "path")) {
                                                str5 = strA4;
                                            } else if (i3.f.q(strA3, "secure")) {
                                                z8 = 1;
                                            } else if (i3.f.q(strA3, "httponly")) {
                                                z5 = true;
                                            }
                                        }
                                        i7 = iG3 + 1;
                                        listL = list2;
                                        c2 = ';';
                                        c4 = '=';
                                        z8 = z8;
                                    } else {
                                        list = listL;
                                        if (j4 == Long.MIN_VALUE) {
                                            j2 = Long.MIN_VALUE;
                                        } else if (j4 != -1) {
                                            long j6 = jCurrentTimeMillis + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
                                            j2 = (j6 < jCurrentTimeMillis || j6 > 253402300799999L) ? 253402300799999L : j6;
                                        } else {
                                            j2 = jC;
                                        }
                                        String strG = tVar.g();
                                        if (str4 == null) {
                                            str = strG;
                                        } else {
                                            if (!f3.c.a(strG, str4) && (!i3.f.p(strG, str4) || strG.charAt((strG.length() - str4.length()) - 1) != '.' || M3.c.a(strG))) {
                                                z4 = false;
                                            }
                                            if (z4) {
                                                str = str4;
                                            }
                                        }
                                        if (strG.length() != str.length()) {
                                            PublicSuffixDatabase.a aVar = PublicSuffixDatabase.f7569e;
                                        }
                                        String strSubstring = "/";
                                        String str6 = str5;
                                        i2 = 0;
                                        if (str6 == null || !i3.f.A(str6, "/", false)) {
                                            String strC = tVar.c();
                                            int iT = i3.f.t(strC, '/', 0, 6);
                                            if (iT != 0) {
                                                strSubstring = strC.substring(0, iT);
                                                f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                                            }
                                            str2 = strSubstring;
                                        } else {
                                            str2 = str6;
                                        }
                                        lVar = new l(strA, strA2, j2, str, str2, z8, z5, z6, z7);
                                    }
                                }
                            }
                            i2 = 0;
                        }
                    }
                    lVar = null;
                }
                if (lVar != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(lVar);
                }
                i4 = i2;
                i5 = i6;
                listL = list;
            }
            if (arrayList == null) {
                return Z2.m.f2185i;
            }
            List<l> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            f3.c.c(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }
    }

    public l(String str, String str2, long j2, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f459a = str;
        this.f460b = str2;
        this.f461c = j2;
        this.d = str3;
        this.f462e = str4;
        this.f463f = z4;
        this.g = z5;
        this.f464h = z6;
        this.f465i = z7;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (f3.c.a(lVar.f459a, this.f459a) && f3.c.a(lVar.f460b, this.f460b) && lVar.f461c == this.f461c && f3.c.a(lVar.d, this.d) && f3.c.a(lVar.f462e, this.f462e) && lVar.f463f == this.f463f && lVar.g == this.g && lVar.f464h == this.f464h && lVar.f465i == this.f465i) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public final int hashCode() {
        return Boolean.hashCode(this.f465i) + ((Boolean.hashCode(this.f464h) + ((Boolean.hashCode(this.g) + ((Boolean.hashCode(this.f463f) + ((this.f462e.hashCode() + ((this.d.hashCode() + ((Long.hashCode(this.f461c) + ((this.f460b.hashCode() + ((this.f459a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f459a);
        sb.append('=');
        sb.append(this.f460b);
        if (this.f464h) {
            if (this.f461c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(Q3.c.a(new Date(this.f461c)));
            }
        }
        if (!this.f465i) {
            sb.append("; domain=");
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.f462e);
        if (this.f463f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        f3.c.c(string, "toString()");
        return string;
    }
}
