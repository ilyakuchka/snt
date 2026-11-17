package g3;

import g3.C0326c;

/* renamed from: g3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0327d extends C0328e {
    public static C0324a a(C0324a c0324a, int i2) {
        f3.c.d(c0324a, "<this>");
        boolean z4 = i2 > 0;
        Integer numValueOf = Integer.valueOf(i2);
        f3.c.d(numValueOf, "step");
        if (z4) {
            int iD = c0324a.d();
            int iG = c0324a.g();
            if (c0324a.h() <= 0) {
                i2 = -i2;
            }
            return new C0324a(iD, iG, i2);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
    }

    public static C0326c b(int i2, int i4) {
        if (i4 > Integer.MIN_VALUE) {
            return new C0326c(i2, i4 - 1);
        }
        C0326c.a aVar = C0326c.f6308l;
        return C0326c.f6309m;
    }
}
