package C3;

import D2.e;
import android.content.Context;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import miuix.appcompat.internal.app.widget.SearchActionModeView;
import miuix.appcompat.internal.view.menu.MenuBuilder;
import w3.C0409b;

/* loaded from: classes.dex */
public final class a implements Serializable, Cloneable, Comparable<a> {
    private static final byte[] p = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f58q = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    /* renamed from: r, reason: collision with root package name */
    private static final String[] f59r = {"ERA", "YEAR", "CHINESE_YEAR", "CHINESE_YEAR_SYMBOL_ANIMAL", "CHINESE_ERA_YEAR", "MONTH", "CHINESE_MONTH", "CHINESE_ERA_MONTH", "CHINESE_MONTH_IS_LEAP", "DAY_OF_MONTH", "DAY_OF_CHINESE_MONTH", "CHINESE_ERA_DAY", "DAY_OF_YEAR", "DAY_OF_CHINESE_YEAR", "DAY_OF_WEEK", "SOLAR_TERM", "DETAIL_AM_PM", "AM_PM", "HOUR", "CHINESE_ERA_HOUR", "MINUTE", "SECOND", "MILLISECOND", "ZONE_OFFSET", "DST_OFFSET"};

    /* renamed from: s, reason: collision with root package name */
    private static final int[] f60s = {3, -1, -1, 12, 14, 26, 0, 18, 19, -1, 18, 5, 5, 7, -1, -1, -1, -1, 22, -1, -1, -1, 26, -1, 4, 25, -1, -1, -1, -1, -1, -1, 16, -1, 14, 9, 7, -1, -1, 18, -1, -1, 18, -1, 20, -1, -1, -1, -1, -1, 21, 15, -1, -1, 26, -1, 1, 25};

    /* renamed from: t, reason: collision with root package name */
    private static final int[] f61t = {0, 384, 738, 1093, 1476, 1830, 2185, 2569, 2923, 3278, 3662, 4016, 4400, 4754, 5108, 5492, 5846, 6201, 6585, 6940, 7324, 7678, 8032, 8416, 8770, 9124, 9509, 9863, 10218, 10602, 10956, 11339, 11693, 12048, 12432, 12787, 13141, 13525, 13879, 14263, 14617, 14971, 15355, 15710, 16064, 16449, 16803, 17157, 17541, 17895, 18279, 18633, 18988, 19372, 19726, 20081, 20465, 20819, 21202, 21557, 21911, 22295, 22650, 23004, 23388, 23743, 24096, 24480, 24835, 25219, 25573, 25928, 26312, 26666, 27020, 27404, 27758, 28142, 28496, 28851, 29235, 29590, 29944, 30328, 30682, 31066, 31420, 31774, 32158, 32513, 32868, 33252, 33606, 33960, 34343, 34698, 35082, 35436, 35791, 36175, 36529, 36883, 37267, 37621, 37976, 38360, 38714, 39099, 39453, 39807, 40191, 40545, 40899, 41283, 41638, 42022, 42376, 42731, 43115, 43469, 43823, 44207, 44561, 44916, 45300, 45654, 46038, 46392, 46746, 47130, 47485, 47839, 48223, 48578, 48962, 49316, 49670, 50054, 50408, 50762, 51146, 51501, 51856, 52240, 52594, 52978, 53332, 53686, 54070, 54424, 54779, 55163, 55518, 55902, 56256, 56610, 56993, 57348, 57702, 58086, 58441, 58795, 59179, 59533, 59917, 60271, 60626, 61010, 61364, 61719, 62103, 62457, 62841, 63195, 63549, 63933, 64288, 64642, 65026, 65381, 65735, 66119, 66473, 66857, 67211, 67566, 67950, 68304, 68659, 69042, 69396, 69780, 70134, 70489, 70873, 71228, 71582, 71966, 72320, 72674, 73058, 73412};
    private static final int[] u = {19416, 19168, 42352, 21717, 53856, 55632, 21844, 22191, 39632, 21970, 19168, 42422, 42192, 53840, 53909, 46415, 54944, 44450, 38320, 18807, 18815, 42160, 46261, 27216, 27968, 43860, 11119, 38256, 21234, 18800, 25958, 54432, 59984, 27285, 23263, 11104, 34531, 37615, 51415, 51551, 54432, 55462, 46431, 22176, 42420, 9695, 37584, 53938, 43344, 46423, 27808, 46416, 21333, 19887, 42416, 17779, 21183, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 38310, 38335, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 20854, 21183, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 53430, 53855, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 45653, 27951, 44448, 19299, 37759, 18936, 18800, 25776, 26790, 59999, 27424, 42692, 43759, 37600, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 19285, 19311, 42352, 21732, 53856, 59752, 54560, 55968, 27302, 22239, 19168, 43476, 42192, 53584, 62034, 54560};

    /* renamed from: v, reason: collision with root package name */
    private static final int[] f62v = {4, 19, 3, 18, 4, 19, 4, 19, 4, 20, 4, 20, 6, 22, 6, 22, 6, 22, 7, 22, 6, 21, 6, 21};

    /* renamed from: w, reason: collision with root package name */
    private static final byte[] f63w = "0123415341536789:;<9:=<>:=1>?012@015@015@015AB78CDE8CD=1FD01GH01GH01IH01IJ0KLMN;LMBEOPDQRST0RUH0RVH0RWH0RWM0XYMNZ[MB\\]PT^_ST`_WH`_WH`_WM`_WM`aYMbc[Mde]Sfe]gfh_gih_Wih_WjhaWjka[jkl[jmn]ope]qph_qrh_sth_W".getBytes();

    /* renamed from: x, reason: collision with root package name */
    private static final byte[] f64x = "211122112122112121222211221122122222212222222221222122222232222222222222222233223232223232222222322222112122112121222211222122222222222222222222322222112122112121222111211122122222212221222221221122122222222222222222222223222232222232222222222222112122112121122111211122122122212221222221221122122222222222222221211122112122212221222211222122222232222232222222222222112122112121111111222222112121112121111111222222111121112121111111211122112122112121122111222212111121111121111111111122112122112121122111211122112122212221222221222211111121111121111111222111111121111111111111111122112121112121111111222111111111111111111111111122111121112121111111221122122222212221222221222111011111111111111111111122111121111121111111211122112122112121122211221111011111101111111111111112111121111121111111211122112122112221222211221111011111101111111110111111111121111111111111111122112121112121122111111011111121111111111111111011111111112111111111111011111111111111111111221111011111101110111110111011011111111111111111221111011011101110111110111011011111101111111111211111001011101110111110110011011111101111111111211111001011001010111110110011011111101111111110211111001011001010111100110011011011101110111110211111001011001010011100110011001011101110111110211111001010001010011000100011001011001010111110111111001010001010011000111111111111111111111111100011001011001010111100111111001010001010000000111111000010000010000000100011001011001010011100110011001011001110111110100011001010001010011000110011001011001010111110111100000010000000000000000011001010001010011000111100000000000000000000000011001010001010000000111000000000000000000000000011001010000010000000".getBytes();

    /* renamed from: j, reason: collision with root package name */
    private TimeZone f66j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f67k = new int[25];

    /* renamed from: l, reason: collision with root package name */
    private transient long f68l = -12219292800000L;

    /* renamed from: m, reason: collision with root package name */
    private transient int f69m = 1582;

    /* renamed from: n, reason: collision with root package name */
    private transient int f70n = 13;

    /* renamed from: o, reason: collision with root package name */
    private transient int f71o = 10;

    /* renamed from: i, reason: collision with root package name */
    private long f65i = System.currentTimeMillis();

    public a() {
        B();
    }

    static int C(int i2, int i4) {
        if (i2 > 2100) {
            return 0;
        }
        int i5 = i4 * 2;
        int i6 = ((f63w[i2 - 1900] - 48) * 24) + i5;
        int i7 = i6 + 1;
        int i8 = f64x[i6] - 48;
        int[] iArr = f62v;
        return ((i8 + iArr[i5]) << 8) + (r1[i7] - 48) + iArr[i5 + 1];
    }

    private void e(StringBuilder sb, boolean z4, boolean z5) {
        char c2;
        int iO = o(24) + o(23);
        if (iO < 0) {
            c2 = '-';
            iO = -iO;
        } else {
            c2 = '+';
        }
        if (z4) {
            sb.append("GMT");
        }
        sb.append(c2);
        f(sb, 2, iO / 3600000);
        if (z5) {
            sb.append(':');
        }
        f(sb, 2, (iO % 3600000) / 60000);
    }

    private static void f(StringBuilder sb, int i2, int i4) {
        sb.append(D3.a.a(i2, i4));
    }

    private void g() {
        int i2;
        int offset;
        long j2;
        this.f67k[23] = this.f66j.getRawOffset();
        long j4 = this.f65i;
        long j5 = j4 / 86400000;
        int i4 = (int) (j4 % 86400000);
        if (i4 < 0) {
            i4 += 86400000;
            j5--;
        }
        int i5 = i4 + this.f67k[23];
        while (i5 < 0) {
            i5 += 86400000;
            j5--;
        }
        while (i5 >= 86400000) {
            i5 -= 86400000;
            j5++;
        }
        int i6 = this.f67k[23];
        long j6 = this.f65i;
        long j7 = i6 + j6;
        if (j6 > 0 && j7 < 0 && i6 > 0) {
            j7 = Long.MAX_VALUE;
        } else if (j6 < 0 && j7 > 0 && i6 < 0) {
            j7 = Long.MIN_VALUE;
        }
        h(j5, j7);
        int[] iArr = this.f67k;
        if (iArr[1] <= 0) {
            i2 = 1;
            offset = 0;
        } else {
            i2 = 1;
            offset = this.f66j.getOffset(1, iArr[1], iArr[5], iArr[9], iArr[14], i5);
        }
        int[] iArr2 = this.f67k;
        int i7 = iArr2[i2] > 0 ? offset - iArr2[23] : 0;
        iArr2[24] = i7;
        if (i7 != 0) {
            i5 += i7;
            if (i5 < 0) {
                i5 += 86400000;
                j2 = j5 - 1;
            } else if (i5 >= 86400000) {
                i5 -= 86400000;
                j2 = 1 + j5;
            } else {
                j2 = j5;
            }
            if (j5 != j2) {
                int i8 = iArr2[24] - iArr2[23];
                long j8 = this.f65i;
                long j9 = i8 + j8;
                if (j8 > 0 && j9 < 0 && i8 > 0) {
                    j9 = Long.MAX_VALUE;
                } else if (j8 < 0 && j9 > 0 && i8 < 0) {
                    j9 = Long.MIN_VALUE;
                }
                h(j2, j9);
            }
            j5 = j2;
        }
        int[] iArr3 = this.f67k;
        if (iArr3[i2] <= 0) {
            iArr3[0] = 0;
            iArr3[i2] = 1 - iArr3[i2];
        } else {
            iArr3[0] = i2;
        }
        iArr3[22] = i5 % 1000;
        int i9 = i5 / 1000;
        iArr3[21] = i9 % 60;
        int i10 = i9 / 60;
        iArr3[20] = i10 % 60;
        iArr3[18] = (i10 / 60) % 24;
        iArr3[17] = iArr3[18] > 11 ? i2 : 0;
        switch (iArr3[18]) {
            case 0:
                iArr3[16] = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                iArr3[16] = i2;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                iArr3[16] = 2;
                break;
            case 12:
                iArr3[16] = 3;
                break;
            case 13:
            case 14:
            case 15:
            case MenuBuilder.CATEGORY_SHIFT /* 16 */:
            case 17:
                iArr3[16] = 4;
                break;
            case 18:
                iArr3[16] = 5;
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                iArr3[16] = 6;
                break;
        }
        if (y()) {
            return;
        }
        int i11 = (int) (j5 - (-25537));
        int[] iArr4 = this.f67k;
        int i12 = iArr4[i2] < 2100 ? iArr4[i2] + 1 : 2100;
        int iK = i11 - f61t[i12 - 1900];
        if (iK < 0) {
            i12--;
            iK += k(i12);
        }
        if (iK < 0) {
            i12--;
            iK += k(i12);
        }
        int[] iArr5 = this.f67k;
        iArr5[2] = i12;
        iArr5[13] = iK + 1;
        int iT = t(i12);
        int i13 = 0;
        int i14 = 0;
        int iJ = 0;
        while (i13 < 12 && iK > 0) {
            if (iT >= 0 && i13 == iT + 1 && i14 == 0) {
                i13--;
                iJ = u(i12);
                i14 = i2;
            } else {
                iJ = j(i12, i13);
            }
            if (i14 != 0 && i13 == iT + 1) {
                i14 = 0;
            }
            iK -= iJ;
            i13++;
        }
        if (iK == 0 && iT > 0 && i13 == iT + i2) {
            if (i14 != 0) {
                i14 = 0;
            } else {
                i13--;
                i14 = i2;
            }
        }
        if (iK < 0) {
            iK += iJ;
            i13--;
        }
        int[] iArr6 = this.f67k;
        iArr6[8] = i14;
        iArr6[6] = i13;
        iArr6[10] = iK + i2;
        int iC = C(iArr6[i2], iArr6[5]);
        int[] iArr7 = this.f67k;
        if (iArr7[9] == (iC >> 8)) {
            iArr7[15] = (iArr7[5] * 2) + i2;
        } else if (iArr7[9] == (iC & 255)) {
            iArr7[15] = (iArr7[5] * 2) + 2;
        } else {
            iArr7[15] = 0;
        }
        int i15 = iArr7[i2];
        if (iArr7[5] < 2) {
            i15--;
        }
        if (iArr7[6] == 0 && iArr7[10] >= i2) {
            i15 = iArr7[i2];
        }
        int i16 = i15 - 1900;
        iArr7[3] = v(i16 + 12, 12);
        this.f67k[4] = v(i16 + 36, 60);
        int[] iArr8 = this.f67k;
        int iC2 = C(iArr8[i2], iArr8[5]) >> 8;
        int[] iArr9 = this.f67k;
        int i17 = ((iArr9[i2] - 1900) * 12) + iArr9[5];
        if (iArr9[9] >= iC2) {
            i17++;
        }
        iArr9[7] = v(i17 + 12, 60);
        this.f67k[11] = v(i11 + 40, 60);
        this.f67k[19] = v((((r0[18] + i2) % 24) / 2) + (i11 * 12), 60);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0018 -> B:9:0x001e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(long j2, long j4) {
        a aVar;
        long jM;
        long j5;
        int i2;
        int i4 = 1970;
        if (j4 < this.f68l) {
            long jI = this.f70n;
            aVar = this;
            j5 = j2;
            jM = j5 - jI;
            i2 = (int) (jM / 365);
            if (i2 != 0) {
                i4 += i2;
                jI = aVar.i(i4);
                jM = j5 - jI;
                i2 = (int) (jM / 365);
                if (i2 != 0) {
                    if (jM < 0) {
                        i4--;
                        jM += aVar.m(i4);
                    }
                    aVar.f67k[1] = i4;
                    int i5 = ((int) jM) + 1;
                    int[] iArr = this.f67k;
                    iArr[12] = i5;
                    if (iArr[1] == this.f69m && this.f68l <= j4) {
                        i5 += this.f71o;
                    }
                    int i6 = i5 / 32;
                    boolean zS = s(iArr[1]);
                    int iL = i5 - ((!zS || i6 <= 1) ? f58q[i6] : f58q[i6] + 1);
                    if (iL > l(zS, i6)) {
                        iL -= l(zS, i6);
                        i6++;
                    }
                    int[] iArr2 = this.f67k;
                    iArr2[5] = i6;
                    iArr2[9] = iL;
                    iArr2[14] = v(j2 - 3, 7) + 1;
                }
            }
        } else {
            aVar = this;
            jM = j2;
            j5 = jM;
            i2 = (int) (jM / 365);
            if (i2 != 0) {
            }
        }
    }

    private long i(long j2) {
        if (j2 < 1970) {
            if (j2 <= this.f69m) {
                return ((j2 - 1972) / 4) + ((j2 - 1970) * 365) + this.f70n;
            }
            long j4 = ((j2 - 1972) / 4) + ((j2 - 1970) * 365);
            long j5 = j2 - 2000;
            return (j5 / 400) + (j4 - (j5 / 100));
        }
        long j6 = ((j2 - 1969) / 4) + ((j2 - 1970) * 365);
        int i2 = this.f69m;
        long j7 = i2;
        if (j2 > j7) {
            return j6 - (((j2 - 1901) / 100) - ((j2 - 1601) / 400));
        }
        return j6 + (j2 == j7 ? this.f71o : j2 == ((long) (i2 + (-1))) ? 0 : this.f70n);
    }

    static int j(int i2, int i4) {
        return (u[i2 + (-1900)] & (65536 >> (i4 + 1))) != 0 ? 30 : 29;
    }

    static int k(int i2) {
        int[] iArr = f61t;
        int i4 = i2 - 1900;
        return iArr[i4 + 1] - iArr[i4];
    }

    private static int l(boolean z4, int i2) {
        return (z4 && i2 == 1) ? p[i2] + 1 : p[i2];
    }

    private int m(int i2) {
        int i4 = s(i2) ? 366 : 365;
        int i5 = this.f69m;
        if (i2 == i5) {
            i4 -= this.f71o;
        }
        return i2 == i5 + (-1) ? i4 + 0 : i4;
    }

    private static int t(int i2) {
        int i4 = u[i2 - 1900] & 15;
        if (i4 == 15) {
            return -1;
        }
        return i4 - 1;
    }

    static int u(int i2) {
        if (t(i2) >= 0) {
            return (u[(i2 + (-1900)) + 1] & 15) == 15 ? 30 : 29;
        }
        return 0;
    }

    private static int v(long j2, int i2) {
        int i4 = (int) (j2 % i2);
        return (j2 >= 0 || i4 >= 0) ? i4 : i4 + i2;
    }

    private void w() {
        int[] iArr;
        int iU;
        long j2 = f61t[this.f67k[2] - 1900] - 25537;
        int i2 = 0;
        while (true) {
            iArr = this.f67k;
            if (i2 >= iArr[6]) {
                break;
            }
            j2 += j(iArr[2], i2);
            i2++;
        }
        if (iArr[8] != 1) {
            int iT = t(iArr[2]);
            if (iT >= 0) {
                int[] iArr2 = this.f67k;
                if (iT < iArr2[6]) {
                    iU = u(iArr2[2]);
                }
            }
            h(j2 + (this.f67k[10] - 1), 0L);
            x();
        }
        iU = j(iArr[2], iArr[6]);
        j2 += iU;
        h(j2 + (this.f67k[10] - 1), 0L);
        x();
    }

    private void x() {
        int[] iArr = this.f67k;
        int i2 = iArr[1];
        long jI = i(i2) + ((((!s(i2) || iArr[5] <= 1) ? f58q[r3] : f58q[r3] + 1) + iArr[9]) - 1);
        this.f67k[14] = v(jI - 3, 7) + 1;
        int[] iArr2 = this.f67k;
        long j2 = (jI * 86400000) + (iArr2[21] * 1000) + (iArr2[20] * 60000) + (iArr2[18] * 3600000) + iArr2[22];
        this.f65i = j2;
        long offset = this.f66j.getOffset(j2);
        long j4 = this.f65i;
        if (i2 <= 0) {
            offset = 0;
        }
        this.f65i = j4 - offset;
        g();
    }

    public final a A(long j2) {
        this.f65i = j2;
        g();
        return this;
    }

    public final a B() {
        TimeZone timeZone = TimeZone.getDefault();
        TimeZone timeZone2 = this.f66j;
        if (timeZone2 == null || !timeZone2.getID().equals(timeZone.getID())) {
            this.f66j = timeZone;
            g();
        }
        return this;
    }

    public final Object clone() {
        try {
            a aVar = (a) super.clone();
            aVar.f67k = (int[]) this.f67k.clone();
            aVar.f66j = (TimeZone) this.f66j.clone();
            return aVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(a aVar) {
        long j2 = this.f65i;
        long j4 = aVar.f65i;
        if (j2 < j4) {
            return -1;
        }
        return j2 == j4 ? 0 : 1;
    }

    public final a d(int i2, int i4) {
        if (i2 < 0 || i2 >= 25) {
            throw new IllegalArgumentException(e.b("Field out of range [0-25]: ", i2));
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 5) {
                        if (i2 != 6) {
                            if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13) {
                                if (i4 != 0) {
                                    long j2 = this.f65i;
                                    long j4 = (i4 * 86400000) + j2;
                                    if ((i4 > 0) != (j4 > j2)) {
                                        throw new IllegalArgumentException("out of range");
                                    }
                                    this.f65i = j4;
                                    g();
                                }
                            } else if (i2 != 18) {
                                switch (i2) {
                                    case 20:
                                        if (i4 != 0) {
                                            long j5 = this.f65i;
                                            long j6 = (i4 * 60000) + j5;
                                            if ((i4 > 0) != (j6 > j5)) {
                                                throw new IllegalArgumentException("out of range");
                                            }
                                            this.f65i = j6;
                                            g();
                                            break;
                                        }
                                        break;
                                    case 21:
                                        if (i4 != 0) {
                                            long j7 = this.f65i;
                                            long j8 = (i4 * 1000) + j7;
                                            if ((i4 > 0) != (j8 > j7)) {
                                                throw new IllegalArgumentException("out of range");
                                            }
                                            this.f65i = j8;
                                            g();
                                            break;
                                        }
                                        break;
                                    case 22:
                                        if (i4 != 0) {
                                            long j9 = this.f65i;
                                            long j10 = i4 + j9;
                                            if ((i4 > 0) != (j10 > j9)) {
                                                throw new IllegalArgumentException("out of range");
                                            }
                                            this.f65i = j10;
                                            g();
                                            break;
                                        }
                                        break;
                                    default:
                                        StringBuilder sbD = e.d("unsupported set field:");
                                        sbD.append(f59r[i2]);
                                        throw new IllegalArgumentException(sbD.toString());
                                }
                            } else if (i4 != 0) {
                                long j11 = this.f65i;
                                long j12 = (i4 * 3600000) + j11;
                                if ((i4 > 0) != (j12 > j11)) {
                                    throw new IllegalArgumentException("out of range");
                                }
                                this.f65i = j12;
                                g();
                            }
                        } else if (i4 != 0) {
                            if (y()) {
                                throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                            }
                            int iT = t(this.f67k[2]);
                            while (i4 > 0) {
                                int[] iArr = this.f67k;
                                if (iArr[6] == iT && iArr[8] == 0) {
                                    iArr[8] = 1;
                                } else {
                                    iArr[6] = iArr[6] + 1;
                                    iArr[8] = 0;
                                    if (iArr[6] > 11) {
                                        iArr[6] = 0;
                                        iArr[2] = iArr[2] + 1;
                                        if (iArr[2] > 2100) {
                                            throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                                        }
                                        iT = t(iArr[2]);
                                    } else {
                                        continue;
                                    }
                                }
                                i4--;
                            }
                            while (i4 < 0) {
                                int[] iArr2 = this.f67k;
                                if (iArr2[6] == iT && iArr2[8] == 1) {
                                    iArr2[8] = 0;
                                } else {
                                    iArr2[6] = iArr2[6] - 1;
                                    if (iArr2[6] < 0) {
                                        iArr2[6] = 11;
                                        iArr2[6] = iArr2[6] - 1;
                                        if (iArr2[2] < 1900) {
                                            throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                                        }
                                        iT = t(iArr2[1]);
                                    }
                                    int[] iArr3 = this.f67k;
                                    if (iArr3[6] == iT) {
                                        iArr3[8] = 1;
                                    }
                                }
                                i4++;
                            }
                            int[] iArr4 = this.f67k;
                            int iU = iArr4[8] == 1 ? u(iArr4[2]) : j(iArr4[2], iArr4[6]);
                            int[] iArr5 = this.f67k;
                            if (iArr5[10] > iU) {
                                iArr5[10] = iU;
                            }
                            w();
                        }
                    } else if (i4 != 0) {
                        int[] iArr6 = this.f67k;
                        int i5 = i4 + iArr6[5];
                        int i6 = i5 / 12;
                        int i7 = i5 % 12;
                        if (i7 < 0) {
                            i7 += 12;
                            i6--;
                        }
                        iArr6[5] = i7;
                        if (i6 == 0) {
                            if (iArr6[0] == 0) {
                                iArr6[1] = (-1) - iArr6[1];
                            }
                            int iL = l(s(iArr6[1]), this.f67k[5]);
                            int[] iArr7 = this.f67k;
                            if (iArr7[9] > iL) {
                                iArr7[9] = iL;
                            }
                            x();
                        } else {
                            d(1, i6);
                        }
                    }
                } else if (i4 != 0) {
                    int i8 = i4 + this.f67k[2];
                    if (y() || i8 < 1900 || i8 > 2100) {
                        throw new IllegalArgumentException("out of range of Chinese Lunar Year");
                    }
                    int[] iArr8 = this.f67k;
                    iArr8[2] = i8;
                    if (iArr8[8] == 1 && iArr8[6] == t(iArr8[2])) {
                        this.f67k[8] = 0;
                    }
                    int[] iArr9 = this.f67k;
                    int iU2 = iArr9[8] == 1 ? u(iArr9[2]) : j(iArr9[2], iArr9[6]);
                    int[] iArr10 = this.f67k;
                    if (iArr10[10] > iU2) {
                        iArr10[10] = iU2;
                    }
                    w();
                }
            } else if (i4 != 0) {
                int[] iArr11 = this.f67k;
                if (iArr11[0] == 0) {
                    iArr11[1] = (-1) - iArr11[1];
                }
                iArr11[1] = iArr11[1] + i4;
                int iL2 = l(s(iArr11[1]), this.f67k[5]);
                int[] iArr12 = this.f67k;
                if (iArr12[9] > iL2) {
                    iArr12[9] = iL2;
                }
                x();
            }
        } else if (i4 != 0) {
            int[] iArr13 = this.f67k;
            if (iArr13[0] != (iArr13[0] + i4) % 2 && iArr13[0] == 0) {
                iArr13[1] = (-1) - iArr13[1];
                x();
            }
        }
        return this;
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof a) && this.f65i == ((a) obj).f65i);
    }

    public final int hashCode() {
        long j2 = this.f65i;
        return (int) (j2 ^ (j2 >>> 32));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:111:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final StringBuilder n(Context context, StringBuilder sb, CharSequence charSequence) {
        int i2;
        b bVarM = b.m(context);
        int length = charSequence.length();
        int i4 = 0;
        boolean z4 = false;
        while (i4 < length) {
            char cCharAt = charSequence.charAt(i4);
            if (z4) {
                if (cCharAt == '\'') {
                    i2 = i4 + 1;
                    if (i2 >= length || charSequence.charAt(i2) != cCharAt) {
                        z4 = false;
                    } else {
                        sb.append(cCharAt);
                        i4 = i2;
                    }
                } else {
                    sb.append(cCharAt);
                }
            } else if (cCharAt == '\'') {
                i2 = i4 + 1;
                if (i2 >= length || charSequence.charAt(i2) != cCharAt) {
                    z4 = true;
                } else {
                    sb.append(cCharAt);
                    i4 = i2;
                }
            } else if (cCharAt < 'A' || cCharAt > 'z') {
                sb.append(cCharAt);
            } else {
                int i5 = cCharAt - 'A';
                if (f60s[i5] >= 0) {
                    int i6 = 1;
                    while (true) {
                        int i7 = i4 + 1;
                        if (i7 < length && charSequence.charAt(i7) == cCharAt) {
                            i6++;
                            i4 = i7;
                        }
                    }
                    int i8 = f60s[i5];
                    if (cCharAt == 'A') {
                        sb.append(bVarM.g()[this.f67k[3]]);
                    } else if (cCharAt == 'S') {
                        f(sb, i6, this.f67k[i8]);
                    } else if (cCharAt != 'a') {
                        if (cCharAt == 'h') {
                            int i9 = this.f67k[18] % 12;
                            if (i9 == 0) {
                                i9 = 12;
                            }
                            f(sb, i6, i9);
                        } else if (cCharAt == 'k') {
                            f(sb, i6, this.f67k[18]);
                        } else if (cCharAt != 'm' && cCharAt != 'D') {
                            if (cCharAt == 'E') {
                                if (i6 == 4) {
                                    sb.append(bVarM.s()[this.f67k[14] - 1]);
                                } else if (i6 == 5) {
                                    sb.append(bVarM.q()[this.f67k[14] - 1]);
                                } else {
                                    sb.append(bVarM.o()[this.f67k[14] - 1]);
                                }
                            } else if (cCharAt != 'Y') {
                                if (cCharAt != 'Z') {
                                    if (cCharAt != 's') {
                                        if (cCharAt == 't') {
                                            sb.append(bVarM.r()[this.f67k[15]]);
                                        } else if (cCharAt != 'y') {
                                            if (cCharAt != 'z') {
                                                switch (cCharAt) {
                                                    case 'G':
                                                        sb.append(bVarM.j()[this.f67k[0]]);
                                                        break;
                                                    case 'H':
                                                        break;
                                                    case 'I':
                                                        if (i6 == 2) {
                                                            sb.append(bVarM.k()[this.f67k[19] % 10]);
                                                        }
                                                        sb.append(bVarM.i()[this.f67k[19] % 12]);
                                                        break;
                                                    default:
                                                        switch (cCharAt) {
                                                            case 'K':
                                                                f(sb, i6, this.f67k[18] % 12);
                                                                break;
                                                            case 'L':
                                                            case 'M':
                                                                if (i6 >= 3) {
                                                                    if (i6 != 4) {
                                                                        if (i6 != 5) {
                                                                            sb.append(bVarM.n()[this.f67k[5]]);
                                                                            break;
                                                                        } else {
                                                                            sb.append(bVarM.p()[this.f67k[5]]);
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        sb.append(bVarM.l()[this.f67k[5]]);
                                                                        break;
                                                                    }
                                                                } else {
                                                                    f(sb, i6, this.f67k[5] + 1);
                                                                    break;
                                                                }
                                                            case 'N':
                                                                if (i6 == 2) {
                                                                    sb.append(bVarM.k()[this.f67k[7] % 10]);
                                                                    sb.append(bVarM.i()[this.f67k[7] % 12]);
                                                                    break;
                                                                } else {
                                                                    sb.append(bVarM.e()[this.f67k[8]]);
                                                                    sb.append(bVarM.f()[this.f67k[6]]);
                                                                    break;
                                                                }
                                                            default:
                                                                switch (cCharAt) {
                                                                    case 'e':
                                                                        if (i6 == 2) {
                                                                            sb.append(bVarM.k()[this.f67k[11] % 10]);
                                                                            sb.append(bVarM.i()[this.f67k[11] % 12]);
                                                                            break;
                                                                        } else {
                                                                            sb.append(bVarM.c()[this.f67k[10] - 1]);
                                                                            break;
                                                                        }
                                                                }
                                                        }
                                                }
                                            } else {
                                                TimeZone timeZone = this.f66j;
                                                boolean z5 = this.f67k[24] != 0;
                                                int i10 = i6 != 4 ? 0 : 1;
                                                Objects.requireNonNull(bVarM);
                                                String displayName = timeZone.getDisplayName(z5, i10, Locale.getDefault());
                                                if (displayName != null) {
                                                    sb.append(displayName);
                                                } else {
                                                    e(sb, false, false);
                                                }
                                            }
                                        } else if (i6 == 2) {
                                            f(sb, i6, this.f67k[1] % 100);
                                        } else {
                                            f(sb, i6, this.f67k[1]);
                                        }
                                    }
                                } else if (i6 == 4) {
                                    e(sb, true, true);
                                } else if (i6 == 5) {
                                    e(sb, false, true);
                                } else {
                                    e(sb, false, false);
                                }
                            } else if (i6 != 2) {
                                String[] strArrD = bVarM.d();
                                int i11 = this.f67k[2];
                                int length2 = sb.length();
                                while (i11 > 0) {
                                    int i12 = i11 % 10;
                                    i11 /= 10;
                                    sb.insert(length2, strArrD[i12]);
                                }
                            } else {
                                sb.append(bVarM.k()[this.f67k[4] % 10]);
                                sb.append(bVarM.i()[this.f67k[4] % 12]);
                            }
                        }
                    } else if (i6 != 2) {
                        sb.append(bVarM.b()[this.f67k[17]]);
                    } else {
                        sb.append(bVarM.h()[this.f67k[16]]);
                    }
                }
            }
            i4++;
        }
        return sb;
    }

    public final int o(int i2) {
        if (i2 < 0 || i2 >= 25) {
            throw new IllegalArgumentException(e.b("Field out of range [0-25]: ", i2));
        }
        return this.f67k[i2];
    }

    public final int p(int i2) {
        if (i2 < 0 || i2 >= 25) {
            throw new IllegalArgumentException(e.b("Field out of range [0-25]: ", i2));
        }
        switch (i2) {
            case 0:
                return 1;
            case 1:
                return this.f67k[0] == 1 ? 292278994 : 292269055;
            case 2:
                return 2100;
            case 3:
                return 11;
            case 4:
            case 7:
            case 11:
            case 19:
                return 59;
            case 5:
            case 6:
                return 11;
            case 8:
                return 1;
            case 9:
                return l(s(this.f67k[1]), this.f67k[5]);
            case 10:
                if (y()) {
                    return 0;
                }
                int[] iArr = this.f67k;
                return iArr[8] == 1 ? u(iArr[2]) : j(iArr[2], iArr[6]);
            case 12:
                return m(this.f67k[1]);
            case 13:
                if (y()) {
                    return 0;
                }
                return k(this.f67k[2]);
            case 14:
                return 7;
            case 15:
                return 24;
            case MenuBuilder.CATEGORY_SHIFT /* 16 */:
                return 6;
            case 17:
                return 1;
            case 18:
                return 23;
            case 20:
            case 21:
                return 59;
            case 22:
                return 999;
            default:
                StringBuilder sbD = e.d("unsupported field: ");
                sbD.append(f59r[i2]);
                throw new IllegalArgumentException(sbD.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int q(int i2) {
        boolean zY;
        if (i2 < 0 || i2 >= 25) {
            throw new IllegalArgumentException(e.b("Field out of range [0-25]: ", i2));
        }
        switch (i2) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 1900;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 19:
                return 0;
            case 9:
                return 1;
            case 10:
                zY = y();
                break;
            case 12:
                return 1;
            case 13:
                zY = y();
                break;
            case 14:
                return 1;
            case 15:
            case MenuBuilder.CATEGORY_SHIFT /* 16 */:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
                return 0;
            default:
                StringBuilder sbD = e.d("unsupported field: ");
                sbD.append(f59r[i2]);
                throw new IllegalArgumentException(sbD.toString());
        }
        return !zY;
    }

    public final long r() {
        return this.f65i;
    }

    public final boolean s(int i2) {
        return i2 > this.f69m ? i2 % 4 == 0 && (i2 % 100 != 0 || i2 % SearchActionModeView.ANIMATION_DURATION == 0) : i2 % 4 == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        StringBuilder sb = (StringBuilder) ((C0409b.f) C0409b.c()).a();
        sb.append(a.class.getName());
        sb.append("[time");
        sb.append(this.f65i);
        sb.append(",zone=");
        sb.append(this.f66j.getID());
        for (int i2 = 0; i2 < 25; i2++) {
            sb.append(',');
            sb.append(f59r[i2]);
            sb.append('=');
            sb.append(this.f67k[i2]);
        }
        sb.append(']');
        String string = sb.toString();
        ((C0409b.f) C0409b.c()).d(sb);
        return string;
    }

    public final boolean y() {
        long j2 = this.f65i;
        int[] iArr = this.f67k;
        return j2 < ((-2206396800000L) - ((long) iArr[23])) - ((long) iArr[24]) || j2 >= (4136400000000L - ((long) iArr[23])) - ((long) iArr[24]);
    }

    public final a z(int i2, int i4) {
        if (i2 != 6) {
            if (i4 >= q(i2) || i4 <= p(i2)) {
                try {
                    d(i2, i4 - this.f67k[i2]);
                    return this;
                } catch (IllegalArgumentException unused) {
                    StringBuilder sbD = e.d("unsupported set field:");
                    sbD.append(f59r[i2]);
                    throw new IllegalArgumentException(sbD.toString());
                }
            }
            StringBuilder sbD2 = e.d("value is out of date range [");
            sbD2.append(q(i2));
            sbD2.append("-");
            sbD2.append(p(i2));
            sbD2.append("]: ");
            sbD2.append(i4);
            throw new IllegalArgumentException(sbD2.toString());
        }
        if (i4 < 0) {
            i4 = -i4;
            if (i4 != t(this.f67k[2])) {
                StringBuilder sbD3 = e.d("year ");
                sbD3.append(this.f67k[2]);
                sbD3.append(" has no such leap month:");
                sbD3.append(i4);
                throw new IllegalArgumentException(sbD3.toString());
            }
            this.f67k[8] = 1;
        } else {
            if (i4 < q(i2) && i4 > p(i2)) {
                StringBuilder sbD4 = e.d("value is out of date range [");
                sbD4.append(q(i2));
                sbD4.append("-");
                sbD4.append(p(i2));
                sbD4.append("]: ");
                sbD4.append(i4);
                throw new IllegalArgumentException(sbD4.toString());
            }
            this.f67k[8] = 0;
        }
        int[] iArr = this.f67k;
        iArr[6] = i4;
        int iU = iArr[8] == 1 ? u(iArr[2]) : j(iArr[2], iArr[6]);
        int[] iArr2 = this.f67k;
        if (iArr2[10] > iU) {
            iArr2[10] = iU;
        }
        w();
        return this;
    }
}
