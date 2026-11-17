package i3;

import g3.C0326c;
import h3.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends o {
    public static boolean A(String str, String str2, boolean z4) {
        f3.c.d(str, "<this>");
        f3.c.d(str2, "prefix");
        return !z4 ? str.startsWith(str2) : j.e(str, 0, str2, 0, str2.length(), z4);
    }

    public static String C(String str, int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(0, i2);
        f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static CharSequence D(CharSequence charSequence) {
        f3.c.d(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z4 = false;
        while (i2 <= length) {
            boolean zB = b.b(charSequence.charAt(!z4 ? i2 : length));
            if (z4) {
                if (!zB) {
                    break;
                }
                length--;
            } else if (zB) {
                i2++;
            } else {
                z4 = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[PHI: r9
      0x00bf: PHI (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v2 java.lang.String) binds: [B:17:0x008b, B:31:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String E(String str) throws IOException {
        f3.c.d(str, "<this>");
        if (!(!j.d("|"))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        n.m(0);
        List listAsList = Arrays.asList("\r\n", "\n", "\r");
        f3.c.c(listAsList, "asList(this)");
        h3.e eVar = new h3.e(new d(str, 0, 0, new l(listAsList, false)), new m(str));
        ArrayList arrayList = new ArrayList();
        Iterator it = eVar.iterator();
        while (true) {
            e.a aVar = (e.a) it;
            if (!aVar.hasNext()) {
                break;
            }
            arrayList.add(aVar.next());
        }
        List listJ = Z2.g.j(arrayList);
        int size = (listJ.size() * 0) + str.length();
        int size2 = listJ.size() - 1;
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        for (Object obj : listJ) {
            int i4 = i2 + 1;
            String strSubstring = null;
            if (i2 < 0) {
                Z2.g.l();
                throw null;
            }
            String str2 = (String) obj;
            if ((i2 == 0 || i2 == size2) && j.d(str2)) {
                str2 = strSubstring;
            } else {
                int length = str2.length();
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        i5 = -1;
                        break;
                    }
                    if (!b.b(str2.charAt(i5))) {
                        break;
                    }
                    i5++;
                }
                if (i5 != -1 && z(str2, "|", i5, false)) {
                    strSubstring = str2.substring("|".length() + i5);
                    f3.c.c(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                if (strSubstring != null) {
                }
            }
            if (str2 != null) {
                arrayList2.add(str2);
            }
            i2 = i4;
        }
        StringBuilder sb = new StringBuilder(size);
        Z2.g.f(arrayList2, sb);
        String string = sb.toString();
        f3.c.c(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static void o(Appendable appendable, Object obj, e3.b bVar) {
        if (bVar != null) {
            appendable.append((CharSequence) bVar.c(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(String.valueOf(obj));
        }
    }

    public static boolean p(String str, String str2) {
        f3.c.d(str, "<this>");
        return str.endsWith(str2);
    }

    public static boolean q(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static int r(CharSequence charSequence, char c2, int i2, boolean z4, int i4) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        f3.c.d(charSequence, "<this>");
        return (z4 || !(charSequence instanceof String)) ? n.k(charSequence, new char[]{c2}, i2, z4) : ((String) charSequence).indexOf(c2, i2);
    }

    public static /* synthetic */ int s(CharSequence charSequence, String str, int i2, boolean z4, int i4) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        return n.i(charSequence, str, i2, z4);
    }

    public static int t(CharSequence charSequence, char c2, int i2, int i4) {
        if ((i4 & 2) != 0) {
            i2 = n.h(charSequence);
        }
        return ((String) charSequence).lastIndexOf(c2, i2);
    }

    public static String u(String str, CharSequence charSequence) {
        if (!A(str, (String) charSequence, false)) {
            return str;
        }
        String strSubstring = str.substring(((String) charSequence).length());
        f3.c.c(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static String v(String str) {
        if (!str.endsWith("Client")) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - "Client".length());
        f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String w(String str) {
        String strReplace = str.replace(' ', '0');
        f3.c.c(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
        return strReplace;
    }

    public static String x(String str, String str2, String str3) {
        f3.c.d(str, "<this>");
        int i2 = n.i(str, str2, 0, false);
        if (i2 < 0) {
            return str;
        }
        int length = str2.length();
        int i4 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i5 = 0;
        do {
            sb.append((CharSequence) str, i5, i2);
            sb.append(str3);
            i5 = i2 + length;
            if (i2 >= str.length()) {
                break;
            }
            i2 = n.i(str, str2, i2 + i4, false);
        } while (i2 > 0);
        sb.append((CharSequence) str, i5, str.length());
        String string = sb.toString();
        f3.c.c(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static List y(CharSequence charSequence, char[] cArr) {
        f3.c.d(charSequence, "<this>");
        if (cArr.length != 1) {
            n.m(0);
            h3.d dVar = new h3.d(new d(charSequence, 0, 0, new k(cArr, false)));
            ArrayList arrayList = new ArrayList(Z2.g.d(dVar));
            Iterator<Object> it = dVar.iterator();
            while (it.hasNext()) {
                arrayList.add(n.n(charSequence, (C0326c) it.next()));
            }
            return arrayList;
        }
        String strValueOf = String.valueOf(cArr[0]);
        n.m(0);
        int i2 = n.i(charSequence, strValueOf, 0, false);
        if (i2 == -1) {
            return Z2.g.g(charSequence.toString());
        }
        ArrayList arrayList2 = new ArrayList(10);
        int length = 0;
        do {
            arrayList2.add(charSequence.subSequence(length, i2).toString());
            length = strValueOf.length() + i2;
            i2 = n.i(charSequence, strValueOf, length, false);
        } while (i2 != -1);
        arrayList2.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList2;
    }

    public static boolean z(String str, String str2, int i2, boolean z4) {
        f3.c.d(str, "<this>");
        return !z4 ? str.startsWith(str2, i2) : j.e(str, i2, str2, 0, str2.length(), z4);
    }
}
