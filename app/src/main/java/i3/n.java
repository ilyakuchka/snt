package i3;

import g3.C0324a;
import g3.C0326c;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends j {
    public static final Y2.d f(CharSequence charSequence, Collection collection, int i2, boolean z4) {
        Object next;
        Object next2;
        Object obj;
        if (!z4 && collection.size() == 1) {
            if (collection instanceof List) {
                List list = (List) collection;
                int size = list.size();
                if (size == 0) {
                    throw new NoSuchElementException("List is empty.");
                }
                if (size != 1) {
                    throw new IllegalArgumentException("List has more than one element.");
                }
                obj = list.get(0);
            } else {
                Iterator it = collection.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException("Collection is empty.");
                }
                Object next3 = it.next();
                if (it.hasNext()) {
                    throw new IllegalArgumentException("Collection has more than one element.");
                }
                obj = next3;
            }
            String str = (String) obj;
            int iS = f.s(charSequence, str, i2, false, 4);
            if (iS < 0) {
                return null;
            }
            return new Y2.d(Integer.valueOf(iS), str);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        C0326c c0326c = new C0326c(i2, charSequence.length());
        if (charSequence instanceof String) {
            int iD = c0326c.d();
            int iG = c0326c.g();
            int iH = c0326c.h();
            if ((iH <= 0 || iD > iG) && (iH >= 0 || iG > iD)) {
                return null;
            }
            while (true) {
                Iterator it2 = collection.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    String str2 = (String) next2;
                    if (j.e(str2, 0, (String) charSequence, iD, str2.length(), z4)) {
                        break;
                    }
                }
                String str3 = (String) next2;
                if (str3 != null) {
                    return new Y2.d(Integer.valueOf(iD), str3);
                }
                if (iD == iG) {
                    return null;
                }
                iD += iH;
            }
        } else {
            int iD2 = c0326c.d();
            int iG2 = c0326c.g();
            int iH2 = c0326c.h();
            if ((iH2 <= 0 || iD2 > iG2) && (iH2 >= 0 || iG2 > iD2)) {
                return null;
            }
            while (true) {
                Iterator it3 = collection.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                    String str4 = (String) next;
                    if (l(str4, 0, charSequence, iD2, str4.length(), z4)) {
                        break;
                    }
                }
                String str5 = (String) next;
                if (str5 != null) {
                    return new Y2.d(Integer.valueOf(iD2), str5);
                }
                if (iD2 == iG2) {
                    return null;
                }
                iD2 += iH2;
            }
        }
    }

    public static boolean g(CharSequence charSequence, CharSequence charSequence2) {
        f3.c.d(charSequence, "<this>");
        if (charSequence2 instanceof String) {
            if (f.s(charSequence, (String) charSequence2, 0, false, 2) >= 0) {
                return true;
            }
        } else if (j(charSequence, charSequence2, 0, charSequence.length(), false, false) >= 0) {
            return true;
        }
        return false;
    }

    public static final int h(CharSequence charSequence) {
        f3.c.d(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int i(CharSequence charSequence, String str, int i2, boolean z4) {
        f3.c.d(charSequence, "<this>");
        f3.c.d(str, "string");
        return (z4 || !(charSequence instanceof String)) ? j(charSequence, str, i2, charSequence.length(), z4, false) : ((String) charSequence).indexOf(str, i2);
    }

    private static final int j(CharSequence charSequence, CharSequence charSequence2, int i2, int i4, boolean z4, boolean z5) {
        C0324a c0324a;
        if (z5) {
            int iH = h(charSequence);
            if (i2 > iH) {
                i2 = iH;
            }
            if (i4 < 0) {
                i4 = 0;
            }
            c0324a = new C0324a(i2, i4, -1);
        } else {
            if (i2 < 0) {
                i2 = 0;
            }
            int length = charSequence.length();
            if (i4 > length) {
                i4 = length;
            }
            c0324a = new C0326c(i2, i4);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iD = c0324a.d();
            int iG = c0324a.g();
            int iH2 = c0324a.h();
            if ((iH2 > 0 && iD <= iG) || (iH2 < 0 && iG <= iD)) {
                while (!j.e((String) charSequence2, 0, (String) charSequence, iD, charSequence2.length(), z4)) {
                    if (iD != iG) {
                        iD += iH2;
                    }
                }
                return iD;
            }
        } else {
            int iD2 = c0324a.d();
            int iG2 = c0324a.g();
            int iH3 = c0324a.h();
            if ((iH3 > 0 && iD2 <= iG2) || (iH3 < 0 && iG2 <= iD2)) {
                while (!l(charSequence2, 0, charSequence, iD2, charSequence2.length(), z4)) {
                    if (iD2 != iG2) {
                        iD2 += iH3;
                    }
                }
                return iD2;
            }
        }
        return -1;
    }

    public static final int k(CharSequence charSequence, char[] cArr, int i2, boolean z4) {
        boolean z5;
        f3.c.d(charSequence, "<this>");
        f3.c.d(cArr, "chars");
        if (!z4 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(Z2.d.d(cArr), i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int iH = h(charSequence);
        if (i2 > iH) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i2);
            int length = cArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z5 = false;
                    break;
                }
                if (b.a(cArr[i4], cCharAt, z4)) {
                    z5 = true;
                    break;
                }
                i4++;
            }
            if (z5) {
                return i2;
            }
            if (i2 == iH) {
                return -1;
            }
            i2++;
        }
    }

    public static final boolean l(CharSequence charSequence, int i2, CharSequence charSequence2, int i4, int i5, boolean z4) {
        f3.c.d(charSequence, "<this>");
        f3.c.d(charSequence2, "other");
        if (i4 < 0 || i2 < 0 || i2 > charSequence.length() - i5 || i4 > charSequence2.length() - i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!b.a(charSequence.charAt(i2 + i6), charSequence2.charAt(i4 + i6), z4)) {
                return false;
            }
        }
        return true;
    }

    public static final void m(int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(D2.e.b("Limit must be non-negative, but was ", i2).toString());
        }
    }

    public static final String n(CharSequence charSequence, C0326c c0326c) {
        f3.c.d(charSequence, "<this>");
        f3.c.d(c0326c, "range");
        return charSequence.subSequence(Integer.valueOf(c0326c.d()).intValue(), Integer.valueOf(c0326c.g()).intValue() + 1).toString();
    }
}
