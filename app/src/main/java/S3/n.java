package S3;

import X3.s;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f1512c;

    /* renamed from: a, reason: collision with root package name */
    public static final n f1510a = new n();

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f1511b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    private static final a d = new a();

    static {
        byte[] bArr = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f1512c = bArr;
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            f1510a.a(i2, f1511b[i2], f1512c[i2]);
        }
    }

    private n() {
    }

    private final void a(int i2, int i4, int i5) {
        a aVar = new a(i2, i5);
        a aVar2 = d;
        while (i5 > 8) {
            i5 -= 8;
            int i6 = (i4 >>> i5) & 255;
            a[] aVarArrA = aVar2.a();
            f3.c.b(aVarArrA);
            a aVar3 = aVarArrA[i6];
            if (aVar3 == null) {
                aVar3 = new a();
                aVarArrA[i6] = aVar3;
            }
            aVar2 = aVar3;
        }
        int i7 = 8 - i5;
        int i8 = (i4 << i7) & 255;
        a[] aVarArrA2 = aVar2.a();
        f3.c.b(aVarArrA2);
        Arrays.fill(aVarArrA2, i8, (1 << i7) + i8, aVar);
    }

    public final void b(X3.f fVar, long j2, X3.e eVar) {
        f3.c.d(fVar, "source");
        a aVar = d;
        int i2 = 0;
        long j4 = 0;
        int iC = 0;
        while (j4 < j2) {
            j4++;
            byte b2 = ((s) fVar).readByte();
            byte[] bArr = M3.c.f596a;
            i2 = (i2 << 8) | (b2 & 255);
            iC += 8;
            while (iC >= 8) {
                int i4 = iC - 8;
                a[] aVarArrA = aVar.a();
                f3.c.b(aVarArrA);
                aVar = aVarArrA[(i2 >>> i4) & 255];
                f3.c.b(aVar);
                if (aVar.a() == null) {
                    ((X3.d) eVar).u0(aVar.b());
                    iC -= aVar.c();
                    aVar = d;
                } else {
                    iC = i4;
                }
            }
        }
        while (iC > 0) {
            a[] aVarArrA2 = aVar.a();
            f3.c.b(aVarArrA2);
            a aVar2 = aVarArrA2[(i2 << (8 - iC)) & 255];
            f3.c.b(aVar2);
            if (aVar2.a() != null || aVar2.c() > iC) {
                return;
            }
            ((X3.d) eVar).u0(aVar2.b());
            iC -= aVar2.c();
            aVar = d;
        }
    }

    public final void c(X3.g gVar, X3.e eVar) throws IOException {
        f3.c.d(gVar, "source");
        int iH = gVar.h();
        int i2 = 0;
        long j2 = 0;
        int i4 = 0;
        while (i2 < iH) {
            int i5 = i2 + 1;
            byte bK = gVar.k(i2);
            byte[] bArr = M3.c.f596a;
            int i6 = bK & 255;
            int i7 = f1511b[i6];
            byte b2 = f1512c[i6];
            j2 = (j2 << b2) | i7;
            i4 += b2;
            while (i4 >= 8) {
                i4 -= 8;
                ((X3.d) eVar).u0((int) (j2 >> i4));
            }
            i2 = i5;
        }
        if (i4 > 0) {
            ((X3.d) eVar).u0((int) ((j2 << (8 - i4)) | (255 >>> i4)));
        }
    }

    public final int d(X3.g gVar) {
        f3.c.d(gVar, "bytes");
        int iH = gVar.h();
        long j2 = 0;
        int i2 = 0;
        while (i2 < iH) {
            int i4 = i2 + 1;
            byte bK = gVar.k(i2);
            byte[] bArr = M3.c.f596a;
            j2 += f1512c[bK & 255];
            i2 = i4;
        }
        return (int) ((j2 + 7) >> 3);
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final a[] f1513a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1514b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1515c;

        public a() {
            this.f1513a = new a[256];
            this.f1514b = 0;
            this.f1515c = 0;
        }

        public final a[] a() {
            return this.f1513a;
        }

        public final int b() {
            return this.f1514b;
        }

        public final int c() {
            return this.f1515c;
        }

        public a(int i2, int i4) {
            this.f1513a = null;
            this.f1514b = i2;
            int i5 = i4 & 7;
            this.f1515c = i5 == 0 ? 8 : i5;
        }
    }
}
