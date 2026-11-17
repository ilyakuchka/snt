package M3;

import X3.d;
import i3.f;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a1, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00de, code lost:
    
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b0  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final InetAddress a(String str, int i2, int i4) {
        int i5;
        boolean z4;
        int i6;
        int i7;
        int i8 = 16;
        byte[] bArr = new byte[16];
        int i9 = -1;
        boolean z5 = false;
        int i10 = i2;
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        while (true) {
            if (i10 >= i4) {
                i5 = i8;
                break;
            }
            if (i13 != i8) {
                int i14 = i10 + 2;
                if (i14 <= i4 && f.z(str, "::", i10, z5)) {
                    if (i11 == i9) {
                        i13 += 2;
                        if (i14 != i4) {
                            i11 = i13;
                            i12 = i14;
                            i10 = i12;
                            int i15 = 0;
                            while (i10 < i4) {
                            }
                            i7 = i10 - i12;
                            if (i7 == 0) {
                                break;
                            }
                            break;
                            break;
                        }
                        i5 = i8;
                        i11 = i13;
                        break;
                    }
                    return null;
                }
                if (i13 != 0) {
                    if (f.z(str, ":", i10, z5)) {
                        i10++;
                    } else {
                        if (!f.z(str, ".", i10, z5)) {
                            return null;
                        }
                        int i16 = i13 - 2;
                        int i17 = i16;
                        loop2: while (true) {
                            if (i12 < i4) {
                                if (i17 == i8) {
                                    break;
                                }
                                if (i17 != i16) {
                                    if (str.charAt(i12) != '.') {
                                        break;
                                    }
                                    i12++;
                                }
                                ?? r15 = z5;
                                int i18 = i12;
                                while (i18 < i4) {
                                    char cCharAt = str.charAt(i18);
                                    if (f3.c.e(cCharAt, 48) >= 0 && f3.c.e(cCharAt, 57) <= 0) {
                                        if ((r15 == 0 && i12 != i18) || (i6 = ((r15 * 10) + cCharAt) - 48) > 255) {
                                            break loop2;
                                        }
                                        i18++;
                                        r15 = i6;
                                    } else {
                                        break;
                                    }
                                }
                                if (i18 - i12 == 0) {
                                    break;
                                }
                                bArr[i17] = (byte) r15;
                                i17++;
                                i12 = i18;
                                i8 = 16;
                                z5 = false;
                            } else if (i17 == i16 + 4) {
                                z4 = true;
                            }
                        }
                        z4 = z5;
                        if (!z4) {
                            return null;
                        }
                        i13 += 2;
                        i5 = 16;
                    }
                }
                i12 = i10;
                i10 = i12;
                int i152 = 0;
                while (i10 < i4) {
                    int iS = c.s(str.charAt(i10));
                    if (iS == -1) {
                        break;
                    }
                    i152 = (i152 << 4) + iS;
                    i10++;
                }
                i7 = i10 - i12;
                if (i7 == 0 || i7 > 4) {
                    break;
                }
                int i19 = i13 + 1;
                bArr[i13] = (byte) ((i152 >>> 8) & 255);
                i13 = i19 + 1;
                bArr[i19] = (byte) (i152 & 255);
                i8 = 16;
                i9 = -1;
                z5 = false;
            } else {
                return null;
            }
        }
        if (i13 != i5) {
            if (i11 == -1) {
                return null;
            }
            int i20 = i13 - i11;
            System.arraycopy(bArr, i11, bArr, 16 - i20, i20);
            Arrays.fill(bArr, i11, (16 - i13) + i11, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static final String b(String str) {
        f3.c.d(str, "<this>");
        int i2 = 0;
        int i4 = -1;
        if (!f.g(str, ":")) {
            try {
                String ascii = IDN.toASCII(str);
                f3.c.c(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                f3.c.c(locale, "US");
                String lowerCase = ascii.toLowerCase(locale);
                f3.c.c(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                int i5 = 0;
                while (i5 < length) {
                    int i6 = i5 + 1;
                    char cCharAt = lowerCase.charAt(i5);
                    if (f3.c.e(cCharAt, 31) > 0 && f3.c.e(cCharAt, 127) < 0 && f.r(" #%/:?@[\\]", cCharAt, 0, false, 6) == -1) {
                        i5 = i6;
                    }
                    i2 = 1;
                    break;
                }
                if (i2 != 0) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressA = (f.A(str, "[", false) && str.endsWith("]")) ? a(str, 1, str.length() - 1) : a(str, 0, str.length());
        if (inetAddressA == null) {
            return null;
        }
        byte[] address = inetAddressA.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressA.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < address.length) {
            int i9 = i7;
            while (i9 < 16 && address[i9] == 0 && address[i9 + 1] == 0) {
                i9 += 2;
            }
            int i10 = i9 - i7;
            if (i10 > i8 && i10 >= 4) {
                i4 = i7;
                i8 = i10;
            }
            i7 = i9 + 2;
        }
        d dVar = new d();
        while (i2 < address.length) {
            if (i2 == i4) {
                dVar.u0(58);
                i2 += i8;
                if (i2 == 16) {
                    dVar.u0(58);
                }
            } else {
                if (i2 > 0) {
                    dVar.u0(58);
                }
                byte b2 = address[i2];
                byte[] bArr = c.f596a;
                dVar.m(((b2 & 255) << 8) | (address[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return dVar.k0();
    }
}
