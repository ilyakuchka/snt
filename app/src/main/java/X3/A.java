package X3;

import X3.g;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f1834a;

    static {
        g.a aVar = g.f1847l;
        f1834a = aVar.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").f();
        aVar.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    }

    public static String a(byte[] bArr) {
        byte[] bArr2 = f1834a;
        f3.c.d(bArr, "<this>");
        f3.c.d(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = i2 + 1;
            byte b2 = bArr[i2];
            int i6 = i5 + 1;
            byte b4 = bArr[i5];
            int i7 = i6 + 1;
            byte b5 = bArr[i6];
            int i8 = i4 + 1;
            bArr3[i4] = bArr2[(b2 & 255) >> 2];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[((b2 & 3) << 4) | ((b4 & 255) >> 4)];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[((b4 & 15) << 2) | ((b5 & 255) >> 6)];
            i4 = i10 + 1;
            bArr3[i10] = bArr2[b5 & 63];
            i2 = i7;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b6 = bArr[i2];
            int i11 = i4 + 1;
            bArr3[i4] = bArr2[(b6 & 255) >> 2];
            int i12 = i11 + 1;
            bArr3[i11] = bArr2[(b6 & 3) << 4];
            byte b7 = (byte) 61;
            bArr3[i12] = b7;
            bArr3[i12 + 1] = b7;
        } else if (length2 == 2) {
            int i13 = i2 + 1;
            byte b8 = bArr[i2];
            byte b9 = bArr[i13];
            int i14 = i4 + 1;
            bArr3[i4] = bArr2[(b8 & 255) >> 2];
            int i15 = i14 + 1;
            bArr3[i14] = bArr2[((b8 & 3) << 4) | ((b9 & 255) >> 4)];
            bArr3[i15] = bArr2[(b9 & 15) << 2];
            bArr3[i15 + 1] = (byte) 61;
        }
        return new String(bArr3, i3.c.f6339b);
    }
}
