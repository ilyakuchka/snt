package S3;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f1397a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final X3.g f1398b = X3.g.f1847l.b("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f1399c = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] d = new String[64];

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f1400e;

    static {
        String[] strArr = new String[256];
        int i2 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            String binaryString = Integer.toBinaryString(i4);
            f3.c.c(binaryString, "toBinaryString(it)");
            strArr[i4] = i3.f.w(M3.c.j("%8s", binaryString));
        }
        f1400e = strArr;
        String[] strArr2 = d;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i5 = 0;
        while (i5 < 1) {
            int i6 = iArr[i5];
            i5++;
            String[] strArr3 = d;
            strArr3[i6 | 8] = f3.c.h(strArr3[i6], "|PADDED");
        }
        String[] strArr4 = d;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i7 = 0;
        while (i7 < 3) {
            int i8 = iArr2[i7];
            i7++;
            int i9 = 0;
            while (i9 < 1) {
                int i10 = iArr[i9];
                i9++;
                String[] strArr5 = d;
                int i11 = i10 | i8;
                StringBuilder sb = new StringBuilder();
                sb.append((Object) strArr5[i10]);
                sb.append('|');
                sb.append((Object) strArr5[i8]);
                strArr5[i11] = sb.toString();
                strArr5[i11 | 8] = ((Object) strArr5[i10]) + '|' + ((Object) strArr5[i8]) + "|PADDED";
            }
        }
        int length = d.length;
        while (i2 < length) {
            int i12 = i2 + 1;
            String[] strArr6 = d;
            if (strArr6[i2] == null) {
                strArr6[i2] = f1400e[i2];
            }
            i2 = i12;
        }
    }

    private e() {
    }

    public final String a(int i2) {
        String[] strArr = f1399c;
        return i2 < strArr.length ? strArr[i2] : M3.c.j("0x%02x", Integer.valueOf(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(boolean z4, int i2, int i4, int i5, int i6) {
        String strX;
        String str;
        String strA = a(i5);
        if (i6 == 0) {
            strX = "";
        } else if (i5 == 2 || i5 == 3) {
            strX = f1400e[i6];
        } else if (i5 == 4 || i5 == 6) {
            strX = i6 == 1 ? "ACK" : f1400e[i6];
        } else if (i5 != 7 && i5 != 8) {
            String[] strArr = d;
            if (i6 < strArr.length) {
                str = strArr[i6];
                f3.c.b(str);
            } else {
                str = f1400e[i6];
            }
            strX = (i5 != 5 || (i6 & 4) == 0) ? (i5 != 0 || (i6 & 32) == 0) ? str : i3.f.x(str, "PRIORITY", "COMPRESSED") : i3.f.x(str, "HEADERS", "PUSH_PROMISE");
        }
        return M3.c.j("%s 0x%08x %5d %-13s %s", z4 ? "<<" : ">>", Integer.valueOf(i2), Integer.valueOf(i4), strA, strX);
    }
}
