package g0;

/* renamed from: g0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0306b {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f6246a = new byte[255];

    static {
        for (int i2 = 0; i2 < 255; i2++) {
            f6246a[i2] = -1;
        }
        for (int i4 = 90; i4 >= 65; i4--) {
            f6246a[i4] = (byte) (i4 - 65);
        }
        for (int i5 = 122; i5 >= 97; i5--) {
            f6246a[i5] = (byte) ((i5 - 97) + 26);
        }
        for (int i6 = 57; i6 >= 48; i6--) {
            f6246a[i6] = (byte) ((i6 - 48) + 52);
        }
        byte[] bArr = f6246a;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        int i4 = 0;
        while (true) {
            boolean z4 = true;
            if (i2 >= bArr.length) {
                break;
            }
            byte b2 = bArr[i2];
            if (b2 != 61 && f6246a[b2] == -1) {
                z4 = false;
            }
            if (z4) {
                bArr2[i4] = bArr[i2];
                i4++;
            }
            i2++;
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        if (i4 == 0) {
            return new byte[0];
        }
        int i5 = i4 / 4;
        while (true) {
            int i6 = i4 - 1;
            if (bArr3[i6] != 61) {
                byte[] bArr4 = new byte[i4 - i5];
                int i7 = 0;
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = i8 * 4;
                    byte b4 = bArr3[i9 + 2];
                    byte b5 = bArr3[i9 + 3];
                    byte[] bArr5 = f6246a;
                    byte b6 = bArr5[bArr3[i9]];
                    byte b7 = bArr5[bArr3[i9 + 1]];
                    if (b4 != 61 && b5 != 61) {
                        byte b8 = bArr5[b4];
                        byte b9 = bArr5[b5];
                        bArr4[i7] = (byte) ((b6 << 2) | (b7 >> 4));
                        bArr4[i7 + 1] = (byte) (((b7 & 15) << 4) | ((b8 >> 2) & 15));
                        bArr4[i7 + 2] = (byte) ((b8 << 6) | b9);
                    } else if (b4 == 61) {
                        bArr4[i7] = (byte) ((b7 >> 4) | (b6 << 2));
                    } else if (b5 == 61) {
                        byte b10 = bArr5[b4];
                        bArr4[i7] = (byte) ((b6 << 2) | (b7 >> 4));
                        bArr4[i7 + 1] = (byte) (((b7 & 15) << 4) | ((b10 >> 2) & 15));
                    }
                    i7 += 3;
                }
                return bArr4;
            }
            if (i6 == 0) {
                return new byte[0];
            }
            i4 = i6;
        }
    }
}
