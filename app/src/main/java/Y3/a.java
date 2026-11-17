package Y3;

import X3.d;
import X3.p;
import X3.t;
import i3.c;
import java.io.EOFException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2139a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(c.f6339b);
        f3.c.c(bytes, "(this as java.lang.String).getBytes(charset)");
        f2139a = bytes;
    }

    public static final byte[] a() {
        return f2139a;
    }

    public static final String b(d dVar, long j2) throws EOFException {
        f3.c.d(dVar, "<this>");
        if (j2 > 0) {
            long j4 = j2 - 1;
            if (dVar.f0(j4) == ((byte) 13)) {
                String strL0 = dVar.l0(j4);
                dVar.a(2L);
                return strL0;
            }
        }
        String strL02 = dVar.l0(j2);
        dVar.a(1L);
        return strL02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
    
        if (r19 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int c(d dVar, p pVar, boolean z4) {
        int i2;
        int i4;
        int i5;
        int i6;
        t tVar;
        f3.c.d(dVar, "<this>");
        f3.c.d(pVar, "options");
        t tVar2 = dVar.f1845i;
        if (tVar2 != null) {
            byte[] bArr = tVar2.f1879a;
            int i7 = tVar2.f1880b;
            int i8 = tVar2.f1881c;
            int[] iArrH = pVar.h();
            t tVar3 = tVar2;
            int i9 = -1;
            int i10 = 0;
            loop0: while (true) {
                int i11 = i10 + 1;
                int i12 = iArrH[i10];
                int i13 = i11 + 1;
                int i14 = iArrH[i11];
                if (i14 != -1) {
                    i9 = i14;
                }
                if (tVar3 == null) {
                    break;
                }
                if (i12 >= 0) {
                    i2 = i7 + 1;
                    int i15 = bArr[i7] & 255;
                    int i16 = i13 + i12;
                    while (i13 != i16) {
                        if (i15 == iArrH[i13]) {
                            i4 = iArrH[i13 + i12];
                            if (i2 == i8) {
                                tVar3 = tVar3.f1883f;
                                f3.c.b(tVar3);
                                i2 = tVar3.f1880b;
                                bArr = tVar3.f1879a;
                                i8 = tVar3.f1881c;
                                if (tVar3 == tVar2) {
                                    tVar3 = null;
                                }
                            }
                        } else {
                            i13++;
                        }
                    }
                    return i9;
                }
                int i17 = (i12 * (-1)) + i13;
                while (true) {
                    int i18 = i7 + 1;
                    int i19 = i13 + 1;
                    if ((bArr[i7] & 255) != iArrH[i13]) {
                        return i9;
                    }
                    boolean z5 = i19 == i17;
                    if (i18 == i8) {
                        f3.c.b(tVar3);
                        t tVar4 = tVar3.f1883f;
                        f3.c.b(tVar4);
                        i6 = tVar4.f1880b;
                        byte[] bArr2 = tVar4.f1879a;
                        i5 = tVar4.f1881c;
                        if (tVar4 != tVar2) {
                            tVar = tVar4;
                            bArr = bArr2;
                        } else {
                            if (!z5) {
                                break loop0;
                            }
                            bArr = bArr2;
                            tVar = null;
                        }
                    } else {
                        t tVar5 = tVar3;
                        i5 = i8;
                        i6 = i18;
                        tVar = tVar5;
                    }
                    if (z5) {
                        i4 = iArrH[i19];
                        i2 = i6;
                        i8 = i5;
                        tVar3 = tVar;
                        break;
                    }
                    i7 = i6;
                    i8 = i5;
                    i13 = i19;
                    tVar3 = tVar;
                }
                if (i4 >= 0) {
                    return i4;
                }
                i10 = -i4;
                i7 = i2;
            }
        } else {
            return z4 ? -2 : -1;
        }
    }
}
