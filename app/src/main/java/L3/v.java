package L3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import t.C0384b;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: c, reason: collision with root package name */
    public static final a f497c = new a();
    private static final Pattern d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f498e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name */
    private final String f499a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f500b;

    public static final class a {
        public final v a(String str) {
            f3.c.d(str, "<this>");
            Matcher matcher = v.d.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            f3.c.c(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            f3.c.c(locale, "US");
            f3.c.c(strGroup.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            f3.c.c(strGroup2, "typeSubtype.group(2)");
            f3.c.c(strGroup2.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = v.f498e.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sbD = D2.e.d("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    f3.c.c(strSubstring, "this as java.lang.String).substring(startIndex)");
                    sbD.append(strSubstring);
                    sbD.append("\" for: \"");
                    sbD.append(str);
                    sbD.append('\"');
                    throw new IllegalArgumentException(sbD.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (i3.f.A(strGroup4, "'", false) && strGroup4.endsWith("'") && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        f3.c.c(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new v(str, (String[]) array);
        }

        public final v b(String str) {
            f3.c.d(str, "<this>");
            try {
                return a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public v(String str, String[] strArr) {
        this.f499a = str;
        this.f500b = strArr;
    }

    public final Charset c(Charset charset) {
        String str;
        int i2 = 0;
        int iO = C0384b.o(0, this.f500b.length - 1, 2);
        if (iO >= 0) {
            while (true) {
                int i4 = i2 + 2;
                if (i3.f.q(this.f500b[i2], "charset")) {
                    str = this.f500b[i2 + 1];
                    break;
                }
                if (i2 == iO) {
                    break;
                }
                i2 = i4;
            }
            str = null;
        } else {
            str = null;
        }
        if (str == null) {
            return charset;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof v) && f3.c.a(((v) obj).f499a, this.f499a);
    }

    public final int hashCode() {
        return this.f499a.hashCode();
    }

    public final String toString() {
        return this.f499a;
    }
}
