package A0;

/* loaded from: classes.dex */
public final class n implements a4.m {

    /* renamed from: a, reason: collision with root package name */
    short f6a;

    /* renamed from: b, reason: collision with root package name */
    boolean f7b;

    /* renamed from: c, reason: collision with root package name */
    double f8c;

    n(String str) {
        int i2;
        if (str.equals("indefinite")) {
            this.f6a = (short) 0;
            return;
        }
        if (!str.startsWith("+")) {
            if (str.startsWith("-")) {
                str = str.substring(1);
                i2 = -1;
            }
            this.f8c = (e(str) * i2) / 1000.0d;
            this.f7b = true;
            this.f6a = (short) 1;
        }
        str = str.substring(1);
        i2 = 1;
        this.f8c = (e(str) * i2) / 1000.0d;
        this.f7b = true;
        this.f6a = (short) 1;
    }

    public static float e(String str) {
        float f4;
        int i2;
        try {
            String strTrim = str.trim();
            if (strTrim.endsWith("ms")) {
                return f(strTrim, 2, true);
            }
            if (strTrim.endsWith("s")) {
                return f(strTrim, 1, true) * 1000.0f;
            }
            if (strTrim.endsWith("min")) {
                return f(strTrim, 3, true) * 60000.0f;
            }
            if (strTrim.endsWith("h")) {
                return f(strTrim, 1, true) * 3600000.0f;
            }
            try {
                return f(strTrim, 0, true) * 1000.0f;
            } catch (NumberFormatException unused) {
                String[] strArrSplit = strTrim.split(":");
                if (strArrSplit.length == 2) {
                    i2 = 0;
                    f4 = 0.0f;
                } else {
                    if (strArrSplit.length != 3) {
                        throw new IllegalArgumentException();
                    }
                    f4 = ((int) f(strArrSplit[0], 0, false)) * 3600000;
                    i2 = 1;
                }
                int iF = (int) f(strArrSplit[i2], 0, false);
                if (iF < 0 || iF > 59) {
                    throw new IllegalArgumentException();
                }
                float f5 = f4 + (iF * 60000);
                float f6 = f(strArrSplit[i2 + 1], 0, true);
                if (f6 < 0.0f || f6 >= 60.0f) {
                    throw new IllegalArgumentException();
                }
                return (f6 * 60000.0f) + f5;
            }
        } catch (NumberFormatException unused2) {
            throw new IllegalArgumentException();
        }
    }

    private static float f(String str, int i2, boolean z4) throws NumberFormatException {
        String strSubstring = str.substring(0, str.length() - i2);
        int iIndexOf = strSubstring.indexOf(46);
        if (iIndexOf == -1) {
            return Integer.parseInt(strSubstring);
        }
        if (!z4) {
            throw new IllegalArgumentException("int value contains decimal");
        }
        String strC = D2.e.c(strSubstring, "000");
        return (Float.parseFloat(strC.substring(iIndexOf + 1, iIndexOf + 4)) / 1000.0f) + Float.parseFloat(strC.substring(0, iIndexOf));
    }

    @Override // a4.m
    public final boolean a() {
        return this.f7b;
    }

    @Override // a4.m
    public final void b() {
    }

    @Override // a4.m
    public final double c() {
        return this.f8c;
    }

    @Override // a4.m
    public final short d() {
        return this.f6a;
    }
}
