package q;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    static final int[] f7613a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    static final Object[] f7614b = new Object[0];

    static int a(int[] iArr, int i2, int i4) {
        int i5 = i2 - 1;
        int i6 = 0;
        while (i6 <= i5) {
            int i7 = (i6 + i5) >>> 1;
            int i8 = iArr[i7];
            if (i8 < i4) {
                i6 = i7 + 1;
            } else {
                if (i8 <= i4) {
                    return i7;
                }
                i5 = i7 - 1;
            }
        }
        return ~i6;
    }

    static int b(long[] jArr, int i2, long j2) {
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            long j4 = jArr[i6];
            if (j4 < j2) {
                i5 = i6 + 1;
            } else {
                if (j4 <= j2) {
                    return i6;
                }
                i4 = i6 - 1;
            }
        }
        return ~i5;
    }

    public static int c(int i2) {
        int i4 = i2 * 4;
        int i5 = 4;
        while (true) {
            if (i5 >= 32) {
                break;
            }
            int i6 = (1 << i5) - 12;
            if (i4 <= i6) {
                i4 = i6;
                break;
            }
            i5++;
        }
        return i4 / 4;
    }

    public static int d(int i2) {
        int i4 = i2 * 8;
        int i5 = 4;
        while (true) {
            if (i5 >= 32) {
                break;
            }
            int i6 = (1 << i5) - 12;
            if (i4 <= i6) {
                i4 = i6;
                break;
            }
            i5++;
        }
        return i4 / 8;
    }
}
