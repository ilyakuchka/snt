package i3;

import Z2.p;
import g3.C0326c;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
class j extends i {
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean d(CharSequence charSequence) {
        boolean z4;
        f3.c.d(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable c0326c = new C0326c(0, charSequence.length() - 1);
            if ((c0326c instanceof Collection) && ((Collection) c0326c).isEmpty()) {
                z4 = true;
                if (!z4) {
                }
            } else {
                Iterator it = c0326c.iterator();
                while (it.hasNext()) {
                    if (!b.b(charSequence.charAt(((p) it).a()))) {
                        z4 = false;
                        break;
                    }
                }
                z4 = true;
                if (!z4) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final boolean e(String str, int i2, String str2, int i4, int i5, boolean z4) {
        f3.c.d(str, "<this>");
        f3.c.d(str2, "other");
        return !z4 ? str.regionMatches(i2, str2, i4, i5) : str.regionMatches(z4, i2, str2, i4, i5);
    }
}
