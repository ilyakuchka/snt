package i3;

import g3.C0326c;

/* loaded from: classes.dex */
public class a extends b {
    public static int c(int i2) {
        boolean z4 = false;
        if (2 <= i2 && i2 < 37) {
            z4 = true;
        }
        if (z4) {
            return i2;
        }
        StringBuilder sbC = C2.c.c("radix ", i2, " was not in valid range ");
        sbC.append(new C0326c(2, 36));
        throw new IllegalArgumentException(sbC.toString());
    }
}
