package X3;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class g implements Serializable, Comparable<g> {

    /* renamed from: l, reason: collision with root package name */
    public static final a f1847l = new a();

    /* renamed from: m, reason: collision with root package name */
    public static final g f1848m = new g(new byte[0]);

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f1849i;

    /* renamed from: j, reason: collision with root package name */
    private transient int f1850j;

    /* renamed from: k, reason: collision with root package name */
    private transient String f1851k;

    public static final class a {
        public static g c(byte[] bArr) {
            a aVar = g.f1847l;
            int length = bArr.length;
            n.d(bArr.length, 0, length);
            return new g(Z2.d.c(bArr, 0, length + 0));
        }

        public final g a(String str) {
            int i2 = 0;
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(f3.c.h("Unexpected hex string: ", str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            int i4 = length - 1;
            if (i4 >= 0) {
                while (true) {
                    int i5 = i2 + 1;
                    int i6 = i2 * 2;
                    bArr[i2] = (byte) (Y3.b.a(str.charAt(i6 + 1)) + (Y3.b.a(str.charAt(i6)) << 4));
                    if (i5 > i4) {
                        break;
                    }
                    i2 = i5;
                }
            }
            return new g(bArr);
        }

        public final g b(String str) {
            f3.c.d(str, "<this>");
            byte[] bytes = str.getBytes(i3.c.f6339b);
            f3.c.c(bytes, "(this as java.lang.String).getBytes(charset)");
            g gVar = new g(bytes);
            gVar.o(str);
            return gVar;
        }
    }

    public g(byte[] bArr) {
        f3.c.d(bArr, "data");
        this.f1849i = bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (r0 < r1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        if (r6 < r7) goto L13;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compareTo(g gVar) {
        g gVar2 = gVar;
        f3.c.d(gVar2, "other");
        int iH = h();
        int iH2 = gVar2.h();
        int iMin = Math.min(iH, iH2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int iK = k(i2) & 255;
            int iK2 = gVar2.k(i2) & 255;
            if (iK == iK2) {
            }
        }
        if (iH == iH2) {
            return 0;
        }
    }

    public String d() {
        return A.a(this.f1849i);
    }

    public g e(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f1849i, 0, h());
        byte[] bArrDigest = messageDigest.digest();
        f3.c.c(bArrDigest, "digestBytes");
        return new g(bArrDigest);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            int iH = gVar.h();
            byte[] bArr = this.f1849i;
            if (iH == bArr.length && gVar.l(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public final byte[] f() {
        return this.f1849i;
    }

    public final int g() {
        return this.f1850j;
    }

    public int h() {
        return this.f1849i.length;
    }

    public int hashCode() {
        int i2 = this.f1850j;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f1849i);
        this.f1850j = iHashCode;
        return iHashCode;
    }

    public String i() {
        byte[] bArr = this.f1849i;
        char[] cArr = new char[bArr.length * 2];
        int length = bArr.length;
        int i2 = 0;
        int i4 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            i2++;
            int i5 = i4 + 1;
            cArr[i4] = Y3.b.b()[(b2 >> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = Y3.b.b()[b2 & 15];
        }
        return new String(cArr);
    }

    public byte[] j() {
        return this.f1849i;
    }

    public byte k(int i2) {
        return this.f1849i[i2];
    }

    public boolean l(int i2, byte[] bArr, int i4, int i5) {
        f3.c.d(bArr, "other");
        if (i2 >= 0) {
            byte[] bArr2 = this.f1849i;
            if (i2 <= bArr2.length - i5 && i4 >= 0 && i4 <= bArr.length - i5 && n.a(bArr2, i2, bArr, i4, i5)) {
                return true;
            }
        }
        return false;
    }

    public boolean m(g gVar, int i2) {
        return gVar.l(0, this.f1849i, 0, i2);
    }

    public final void n(int i2) {
        this.f1850j = i2;
    }

    public final void o(String str) {
        this.f1851k = str;
    }

    public g p() {
        byte b2;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f1849i;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b4 = bArr[i2];
            byte b5 = (byte) 65;
            if (b4 >= b5 && b4 <= (b2 = (byte) 90)) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                f3.c.c(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i2] = (byte) (b4 + 32);
                for (int i4 = i2 + 1; i4 < bArrCopyOf.length; i4++) {
                    byte b6 = bArrCopyOf[i4];
                    if (b6 >= b5 && b6 <= b2) {
                        bArrCopyOf[i4] = (byte) (b6 + 32);
                    }
                }
                return new g(bArrCopyOf);
            }
            i2++;
        }
    }

    public final String q() {
        String str = this.f1851k;
        if (str != null) {
            return str;
        }
        byte[] bArrJ = j();
        f3.c.d(bArrJ, "<this>");
        String str2 = new String(bArrJ, i3.c.f6339b);
        this.f1851k = str2;
        return str2;
    }

    public void r(d dVar, int i2) {
        f3.c.d(dVar, "buffer");
        dVar.s0(this.f1849i, 0, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x022e A[EDGE_INSN: B:273:0x022e->B:247:0x022e BREAK  A[LOOP:0: B:9:0x0014->B:308:0x0014], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x022e A[EDGE_INSN: B:276:0x022e->B:247:0x022e BREAK  A[LOOP:0: B:9:0x0014->B:308:0x0014, LOOP_LABEL: LOOP:0: B:9:0x0014->B:308:0x0014], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x022e A[EDGE_INSN: B:284:0x022e->B:247:0x022e BREAK  A[LOOP:0: B:9:0x0014->B:308:0x0014], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x022e A[EDGE_INSN: B:290:0x022e->B:247:0x022e BREAK  A[LOOP:0: B:9:0x0014->B:308:0x0014], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x022e A[EDGE_INSN: B:305:0x022e->B:247:0x022e BREAK  A[LOOP:0: B:9:0x0014->B:308:0x0014], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        g gVar = this;
        byte[] bArr = gVar.f1849i;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        loop0: while (true) {
            if (i2 >= length) {
                break;
            }
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                int i6 = i4 + 1;
                if (i4 == 64) {
                    break;
                }
                if (b2 != 10 && b2 != 13) {
                    if (b2 >= 0 && b2 <= 31) {
                        z5 = true;
                        if (!z5) {
                            break;
                        }
                    } else {
                        if (!(127 <= b2 && b2 <= 159)) {
                            z5 = false;
                        }
                        if (!z5) {
                        }
                    }
                } else {
                    if (b2 == 65533) {
                        break;
                    }
                    i5 += b2 < 65536 ? 1 : 2;
                    i2++;
                    while (true) {
                        i4 = i6;
                        if (i2 < length && bArr[i2] >= 0) {
                            int i7 = i2 + 1;
                            byte b4 = bArr[i2];
                            i6 = i4 + 1;
                            if (i4 == 64) {
                                break loop0;
                            }
                            if (b4 != 10 && b4 != 13) {
                                if (b4 >= 0 && b4 <= 31) {
                                    z4 = true;
                                    if (!z4) {
                                        break loop0;
                                    }
                                } else {
                                    if (!(127 <= b4 && b4 <= 159)) {
                                        z4 = false;
                                    }
                                    if (!z4) {
                                    }
                                }
                            } else {
                                if (b4 == 65533) {
                                    break loop0;
                                }
                                i5 += b4 < 65536 ? 1 : 2;
                                i2 = i7;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } else if ((b2 >> 5) == -2) {
                int i8 = i2 + 1;
                if (length > i8) {
                    byte b5 = bArr[i2];
                    byte b6 = bArr[i8];
                    if ((b6 & 192) == 128) {
                        int i9 = (b6 ^ 3968) ^ (b5 << 6);
                        if (i9 >= 128) {
                            int i10 = i4 + 1;
                            if (i4 == 64) {
                                break;
                            }
                            if (i9 != 10 && i9 != 13) {
                                if (i9 >= 0 && i9 <= 31) {
                                    z6 = true;
                                    if (!z6) {
                                        break;
                                    }
                                } else {
                                    if (!(127 <= i9 && i9 <= 159)) {
                                        z6 = false;
                                    }
                                    if (!z6) {
                                    }
                                }
                            } else {
                                if (i9 == 65533) {
                                    break;
                                }
                                i5 += i9 < 65536 ? 1 : 2;
                                i2 += 2;
                                i4 = i10;
                            }
                        } else if (i4 != 64) {
                            break;
                        }
                    } else if (i4 != 64) {
                        break;
                    }
                } else if (i4 != 64) {
                    break;
                }
            } else if ((b2 >> 4) == -2) {
                int i11 = i2 + 2;
                if (length > i11) {
                    byte b7 = bArr[i2];
                    byte b8 = bArr[i2 + 1];
                    if ((b8 & 192) == 128) {
                        byte b9 = bArr[i11];
                        if ((b9 & 192) == 128) {
                            int i12 = ((b9 ^ (-123008)) ^ (b8 << 6)) ^ (b7 << 12);
                            if (i12 >= 2048) {
                                if (!(55296 <= i12 && i12 <= 57343)) {
                                    int i13 = i4 + 1;
                                    if (i4 == 64) {
                                        break;
                                    }
                                    if (i12 != 10 && i12 != 13) {
                                        if (i12 >= 0 && i12 <= 31) {
                                            z7 = true;
                                            if (!z7) {
                                                break;
                                            }
                                        } else {
                                            if (!(127 <= i12 && i12 <= 159)) {
                                                z7 = false;
                                            }
                                            if (!z7) {
                                            }
                                        }
                                    } else {
                                        if (i12 == 65533) {
                                            break;
                                        }
                                        i5 += i12 < 65536 ? 1 : 2;
                                        i2 += 3;
                                        i4 = i13;
                                    }
                                } else if (i4 != 64) {
                                    break;
                                }
                            } else if (i4 != 64) {
                                break;
                            }
                        } else if (i4 != 64) {
                            break;
                        }
                    } else if (i4 != 64) {
                        break;
                    }
                } else if (i4 != 64) {
                    break;
                }
            } else if ((b2 >> 3) == -2) {
                int i14 = i2 + 3;
                if (length > i14) {
                    byte b10 = bArr[i2];
                    byte b11 = bArr[i2 + 1];
                    if ((b11 & 192) == 128) {
                        byte b12 = bArr[i2 + 2];
                        if ((b12 & 192) == 128) {
                            byte b13 = bArr[i14];
                            if ((b13 & 192) == 128) {
                                int i15 = (((b13 ^ 3678080) ^ (b12 << 6)) ^ (b11 << 12)) ^ (b10 << 18);
                                if (i15 <= 1114111) {
                                    if (!(55296 <= i15 && i15 <= 57343)) {
                                        if (i15 >= 65536) {
                                            int i16 = i4 + 1;
                                            if (i4 == 64) {
                                                break;
                                            }
                                            if (i15 != 10 && i15 != 13) {
                                                if (i15 >= 0 && i15 <= 31) {
                                                    z8 = true;
                                                    if (!z8) {
                                                        break;
                                                    }
                                                } else {
                                                    if (!(127 <= i15 && i15 <= 159)) {
                                                        z8 = false;
                                                    }
                                                    if (!z8) {
                                                    }
                                                }
                                            } else {
                                                if (i15 == 65533) {
                                                    break;
                                                }
                                                i5 += i15 < 65536 ? 1 : 2;
                                                i2 += 4;
                                                i4 = i16;
                                            }
                                        } else if (i4 != 64) {
                                            break;
                                        }
                                    } else if (i4 != 64) {
                                        break;
                                    }
                                } else if (i4 != 64) {
                                    break;
                                }
                            } else if (i4 != 64) {
                                break;
                            }
                        } else if (i4 != 64) {
                            break;
                        }
                    } else if (i4 != 64) {
                        break;
                    }
                } else if (i4 != 64) {
                    break;
                }
            } else if (i4 != 64) {
                break;
            }
        }
        i5 = -1;
        if (i5 != -1) {
            String strQ = q();
            String strSubstring = strQ.substring(0, i5);
            f3.c.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String strX = i3.f.x(i3.f.x(i3.f.x(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i5 >= strQ.length()) {
                return "[text=" + strX + ']';
            }
            StringBuilder sbD = D2.e.d("[size=");
            sbD.append(gVar.f1849i.length);
            sbD.append(" text=");
            sbD.append(strX);
            sbD.append("…]");
            return sbD.toString();
        }
        if (gVar.f1849i.length <= 64) {
            StringBuilder sbD2 = D2.e.d("[hex=");
            sbD2.append(i());
            sbD2.append(']');
            return sbD2.toString();
        }
        StringBuilder sbD3 = D2.e.d("[size=");
        sbD3.append(gVar.f1849i.length);
        sbD3.append(" hex=");
        byte[] bArr2 = gVar.f1849i;
        if (!(64 <= bArr2.length)) {
            StringBuilder sbD4 = D2.e.d("endIndex > length(");
            sbD4.append(gVar.f1849i.length);
            sbD4.append(')');
            throw new IllegalArgumentException(sbD4.toString().toString());
        }
        if (64 != bArr2.length) {
            gVar = new g(Z2.d.c(bArr2, 0, 64));
        }
        sbD3.append(gVar.i());
        sbD3.append("…]");
        return sbD3.toString();
    }
}
