package g0;

import android.telephony.SmsManager;
import android.util.Log;
import android.util.SparseArray;
import f0.C0302a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import miuix.core.util.SystemProperties;

/* renamed from: g0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0317m {

    /* renamed from: e, reason: collision with root package name */
    private static byte[] f6274e;

    /* renamed from: f, reason: collision with root package name */
    private static byte[] f6275f;

    /* renamed from: a, reason: collision with root package name */
    private ByteArrayInputStream f6276a;

    /* renamed from: b, reason: collision with root package name */
    private C0316l f6277b;

    /* renamed from: c, reason: collision with root package name */
    private C0313i f6278c;
    private final boolean d;

    public C0317m(byte[] bArr) {
        boolean z4 = SmsManager.getDefault().getCarrierConfigValues().getBoolean("supportMmsContentDisposition", true);
        this.f6276a = null;
        this.f6277b = null;
        this.f6278c = null;
        this.f6276a = new ByteArrayInputStream(bArr);
        this.d = z4;
    }

    protected static byte[] b(ByteArrayInputStream byteArrayInputStream, SparseArray<Object> sparseArray) {
        byte[] bArrI;
        int iAvailable;
        int iIntValue;
        int iIntValue2;
        byteArrayInputStream.mark(1);
        int i2 = byteArrayInputStream.read();
        byteArrayInputStream.reset();
        int i4 = i2 & 255;
        if (i4 >= 32) {
            return i4 <= 127 ? i(byteArrayInputStream, 0) : C0315k.f6272a[byteArrayInputStream.read() & 127].getBytes();
        }
        int iH = h(byteArrayInputStream);
        int iAvailable2 = byteArrayInputStream.available();
        byteArrayInputStream.mark(1);
        int i5 = byteArrayInputStream.read();
        byteArrayInputStream.reset();
        int i6 = i5 & 255;
        if (i6 >= 32 && i6 <= 127) {
            bArrI = i(byteArrayInputStream, 0);
        } else {
            if (i6 <= 127) {
                Log.e("PduParser", "Corrupt content-type");
                return C0315k.f6272a[0].getBytes();
            }
            int i7 = byteArrayInputStream.read() & 127;
            String[] strArr = C0315k.f6272a;
            if (i7 < 83) {
                bArrI = strArr[i7].getBytes();
            } else {
                byteArrayInputStream.reset();
                bArrI = i(byteArrayInputStream, 0);
            }
        }
        int iAvailable3 = iH - (iAvailable2 - byteArrayInputStream.available());
        if (iAvailable3 > 0) {
            Integer numValueOf = Integer.valueOf(iAvailable3);
            int iAvailable4 = byteArrayInputStream.available();
            int iIntValue3 = numValueOf.intValue();
            while (iIntValue3 > 0) {
                int i8 = byteArrayInputStream.read();
                iIntValue3--;
                if (i8 != 129) {
                    if (i8 != 131) {
                        if (i8 == 133 || i8 == 151) {
                            byte[] bArrI2 = i(byteArrayInputStream, 0);
                            if (bArrI2 != null && sparseArray != null) {
                                sparseArray.put(151, bArrI2);
                            }
                            iAvailable = byteArrayInputStream.available();
                            iIntValue2 = numValueOf.intValue();
                            iIntValue = iIntValue2;
                        } else {
                            if (i8 != 153) {
                                if (i8 != 137) {
                                    if (i8 != 138) {
                                        if (-1 == j(byteArrayInputStream, iIntValue3)) {
                                            Log.e("PduParser", "Corrupt Content-Type");
                                        } else {
                                            iIntValue3 = 0;
                                        }
                                    }
                                }
                            }
                            byte[] bArrI3 = i(byteArrayInputStream, 0);
                            if (bArrI3 != null && sparseArray != null) {
                                sparseArray.put(153, bArrI3);
                            }
                            iAvailable = byteArrayInputStream.available();
                            iIntValue2 = numValueOf.intValue();
                            iIntValue = iIntValue2;
                        }
                    }
                    byteArrayInputStream.mark(1);
                    int i9 = byteArrayInputStream.read() & 255;
                    byteArrayInputStream.reset();
                    if (i9 > 127) {
                        int i10 = byteArrayInputStream.read() & 127;
                        String[] strArr2 = C0315k.f6272a;
                        if (i10 < 83) {
                            sparseArray.put(131, strArr2[i10].getBytes());
                        }
                    } else {
                        byte[] bArrI4 = i(byteArrayInputStream, 0);
                        if (bArrI4 != null && sparseArray != null) {
                            sparseArray.put(131, bArrI4);
                        }
                    }
                    iAvailable = byteArrayInputStream.available();
                    iIntValue2 = numValueOf.intValue();
                    iIntValue = iIntValue2;
                } else {
                    byteArrayInputStream.mark(1);
                    int i11 = byteArrayInputStream.read() & 255;
                    byteArrayInputStream.reset();
                    if ((i11 <= 32 || i11 >= 127) && i11 != 0) {
                        int iD = (int) d(byteArrayInputStream);
                        if (sparseArray != null) {
                            sparseArray.put(129, Integer.valueOf(iD));
                        }
                    } else {
                        byte[] bArrI5 = i(byteArrayInputStream, 0);
                        try {
                            sparseArray.put(129, Integer.valueOf(C0307c.a(new String(bArrI5))));
                        } catch (UnsupportedEncodingException e2) {
                            Log.e("PduParser", Arrays.toString(bArrI5), e2);
                            sparseArray.put(129, 0);
                        }
                    }
                    iAvailable = byteArrayInputStream.available();
                    iIntValue = numValueOf.intValue();
                }
                iIntValue3 = iIntValue - (iAvailable4 - iAvailable);
            }
            if (iIntValue3 != 0) {
                Log.e("PduParser", "Corrupt Content-Type");
            }
        }
        if (iAvailable3 >= 0) {
            return bArrI;
        }
        Log.e("PduParser", "Corrupt MMS message");
        return C0315k.f6272a[0].getBytes();
    }

    protected static C0309e c(ByteArrayInputStream byteArrayInputStream) {
        int i2;
        byteArrayInputStream.mark(1);
        int i4 = byteArrayInputStream.read() & 255;
        if (i4 == 0) {
            return null;
        }
        byteArrayInputStream.reset();
        if (i4 < 32) {
            h(byteArrayInputStream);
            i2 = byteArrayInputStream.read() & 127;
        } else {
            i2 = 0;
        }
        byte[] bArrI = i(byteArrayInputStream, 0);
        try {
            return i2 != 0 ? new C0309e(i2, bArrI) : new C0309e(bArrI);
        } catch (Exception unused) {
            return null;
        }
    }

    protected static long d(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.mark(1);
        int i2 = byteArrayInputStream.read();
        byteArrayInputStream.reset();
        return i2 > 127 ? byteArrayInputStream.read() & 127 : e(byteArrayInputStream);
    }

    protected static long e(ByteArrayInputStream byteArrayInputStream) {
        int i2 = byteArrayInputStream.read() & 255;
        if (i2 > 8) {
            throw new RuntimeException("Octet count greater than 8 and I can't represent that!");
        }
        long j2 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j2 = (j2 << 8) + (byteArrayInputStream.read() & 255);
        }
        return j2;
    }

    protected static int g(ByteArrayInputStream byteArrayInputStream) {
        int i2 = 0;
        int i4 = byteArrayInputStream.read();
        if (i4 == -1) {
            return i4;
        }
        while ((i4 & 128) != 0) {
            i2 = (i2 << 7) | (i4 & 127);
            i4 = byteArrayInputStream.read();
            if (i4 == -1) {
                return i4;
            }
        }
        return (i2 << 7) | (i4 & 127);
    }

    protected static int h(ByteArrayInputStream byteArrayInputStream) {
        int i2 = byteArrayInputStream.read() & 255;
        if (i2 <= 30) {
            return i2;
        }
        if (i2 == 31) {
            return g(byteArrayInputStream);
        }
        throw new RuntimeException("Value length > LENGTH_QUOTE!");
    }

    protected static byte[] i(ByteArrayInputStream byteArrayInputStream, int i2) {
        byteArrayInputStream.mark(1);
        int i4 = byteArrayInputStream.read();
        if (1 == i2 && 34 == i4) {
            byteArrayInputStream.mark(1);
        } else if (i2 == 0 && 127 == i4) {
            byteArrayInputStream.mark(1);
        } else {
            byteArrayInputStream.reset();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = byteArrayInputStream.read();
        while (-1 != i5 && i5 != 0) {
            if (i2 == 2) {
                if (i5 >= 33 && i5 <= 126 && i5 != 34 && i5 != 44 && i5 != 47 && i5 != 123 && i5 != 125 && i5 != 40 && i5 != 41) {
                    switch (i5) {
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                            break;
                        default:
                            switch (i5) {
                                case SystemProperties.PROP_VALUE_MAX /* 91 */:
                                case 92:
                                case 93:
                                    break;
                                default:
                                    z = true;
                                    break;
                            }
                    }
                }
                if (z) {
                    byteArrayOutputStream.write(i5);
                }
            } else {
                if ((i5 >= 32 && i5 <= 126) || (i5 >= 128 && i5 <= 255) || i5 == 9 || i5 == 10 || i5 == 13) {
                    byteArrayOutputStream.write(i5);
                }
            }
            i5 = byteArrayInputStream.read();
        }
        if (byteArrayOutputStream.size() > 0) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    protected static int j(ByteArrayInputStream byteArrayInputStream, int i2) {
        int i4 = byteArrayInputStream.read(new byte[i2], 0, i2);
        if (i4 < i2) {
            return -1;
        }
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0018, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01bc A[ADDED_TO_REGION, REMOVE, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0310f a() {
        boolean z4;
        C0309e c0309e;
        ByteArrayInputStream byteArrayInputStream = this.f6276a;
        if (byteArrayInputStream == null) {
            return null;
        }
        C0316l c0316l = new C0316l();
        boolean z5 = true;
        while (z5 && byteArrayInputStream.available() > 0) {
            byteArrayInputStream.mark(1);
            int i2 = byteArrayInputStream.read() & 255;
            if (i2 < 32 || i2 > 127) {
                switch (i2) {
                    case 129:
                    case 130:
                    case 151:
                        C0309e c0309eC = c(byteArrayInputStream);
                        if (c0309eC != null) {
                            String str = new String(c0309eC.g());
                            int iIndexOf = str.indexOf("/");
                            if (iIndexOf > 0) {
                                str = str.substring(0, iIndexOf);
                            }
                            c0309eC.h(str.getBytes());
                            c0316l.a(c0309eC, i2);
                        } else {
                            continue;
                        }
                    case 131:
                    case 139:
                    case 152:
                    case 158:
                    case 183:
                    case 184:
                    case 185:
                    case 189:
                    case 190:
                        byte[] bArrI = i(byteArrayInputStream, 0);
                        if (bArrI != null) {
                            c0316l.l(bArrI, i2);
                        } else {
                            continue;
                        }
                    case 132:
                        SparseArray sparseArray = new SparseArray();
                        byte[] bArrB = b(byteArrayInputStream, sparseArray);
                        if (bArrB != null) {
                            try {
                                c0316l.l(bArrB, 132);
                            } catch (NullPointerException unused) {
                            }
                        }
                        f6275f = (byte[]) sparseArray.get(153);
                        f6274e = (byte[]) sparseArray.get(131);
                        z5 = false;
                        continue;
                    case 133:
                    case 142:
                    case 159:
                        c0316l.j(e(byteArrayInputStream), i2);
                        continue;
                    case 134:
                    case 143:
                    case 144:
                    case 145:
                    case 146:
                    case 148:
                    case 149:
                    case 153:
                    case 155:
                    case 156:
                    case 162:
                    case 163:
                    case 165:
                    case 167:
                    case 169:
                    case 171:
                    case 177:
                    case 180:
                    case 186:
                    case 187:
                    case 188:
                    case 191:
                        c0316l.k(byteArrayInputStream.read() & 255, i2);
                        continue;
                    case 135:
                    case 136:
                    case 157:
                        h(byteArrayInputStream);
                        int i4 = byteArrayInputStream.read() & 255;
                        long jE = e(byteArrayInputStream);
                        if (129 == i4) {
                            jE = (System.currentTimeMillis() / 1000) + jE;
                        }
                        c0316l.j(jE, i2);
                        continue;
                    case 137:
                        h(byteArrayInputStream);
                        if (128 == (byteArrayInputStream.read() & 255)) {
                            c0309e = c(byteArrayInputStream);
                            if (c0309e != null) {
                                String str2 = new String(c0309e.g());
                                int iIndexOf2 = str2.indexOf("/");
                                if (iIndexOf2 > 0) {
                                    str2 = str2.substring(0, iIndexOf2);
                                }
                                c0309e.h(str2.getBytes());
                            }
                        } else {
                            c0309e = new C0309e("insert-address-token".getBytes());
                        }
                        c0316l.h(c0309e, 137);
                        continue;
                    case 138:
                        byteArrayInputStream.mark(1);
                        int i5 = byteArrayInputStream.read() & 255;
                        if (i5 < 128) {
                            byteArrayInputStream.reset();
                            byte[] bArrI2 = i(byteArrayInputStream, 0);
                            if (bArrI2 != null) {
                                c0316l.l(bArrI2, 138);
                            } else {
                                continue;
                            }
                        } else if (128 == i5) {
                            c0316l.l("personal".getBytes(), 138);
                        } else if (129 == i5) {
                            c0316l.l("advertisement".getBytes(), 138);
                        } else if (130 == i5) {
                            c0316l.l("informational".getBytes(), 138);
                        } else if (131 == i5) {
                            c0316l.l("auto".getBytes(), 138);
                        }
                    case 140:
                        int i6 = byteArrayInputStream.read() & 255;
                        switch (i6) {
                            case 137:
                            case 138:
                            case 139:
                            case 140:
                            case 141:
                            case 142:
                            case 143:
                            case 144:
                            case 145:
                            case 146:
                            case 147:
                            case 148:
                            case 149:
                            case 150:
                            case 151:
                                break;
                            default:
                                c0316l.k(i6, i2);
                                continue;
                        }
                    case 141:
                        c0316l.k(127 & byteArrayInputStream.read(), 141);
                        continue;
                    case 147:
                    case 150:
                    case 154:
                    case 166:
                    case 181:
                    case 182:
                        C0309e c0309eC2 = c(byteArrayInputStream);
                        if (c0309eC2 != null) {
                            c0316l.h(c0309eC2, i2);
                        } else {
                            continue;
                        }
                    case 160:
                        h(byteArrayInputStream);
                        d(byteArrayInputStream);
                        C0309e c0309eC3 = c(byteArrayInputStream);
                        if (c0309eC3 != null) {
                            try {
                                c0316l.h(c0309eC3, 160);
                            } catch (NullPointerException unused2) {
                            }
                        } else {
                            continue;
                        }
                    case 161:
                        h(byteArrayInputStream);
                        d(byteArrayInputStream);
                        c0316l.j(e(byteArrayInputStream), 161);
                        continue;
                    case 164:
                        h(byteArrayInputStream);
                        byteArrayInputStream.read();
                        c(byteArrayInputStream);
                        continue;
                    case 170:
                    case 172:
                        h(byteArrayInputStream);
                        byteArrayInputStream.read();
                        d(byteArrayInputStream);
                        continue;
                    case 173:
                    case 175:
                    case 179:
                        try {
                            c0316l.j(d(byteArrayInputStream), i2);
                            continue;
                        } catch (C0302a | NullPointerException | RuntimeException unused3) {
                            break;
                        }
                    case 178:
                        b(byteArrayInputStream, null);
                        continue;
                }
                c0316l = null;
                this.f6277b = c0316l;
                if (c0316l != null) {
                    return null;
                }
                int iE = c0316l.e(140);
                C0316l c0316l2 = this.f6277b;
                if (c0316l2 != null) {
                    int iE2 = c0316l2.e(140);
                    if (c0316l2.e(141) != 0) {
                        switch (iE2) {
                            case 128:
                                if (c0316l2.f(132) != null && c0316l2.b(137) != null && c0316l2.f(152) != null) {
                                    z4 = true;
                                    break;
                                }
                                break;
                            case 129:
                                if (c0316l2.e(146) != 0 && c0316l2.f(152) != null) {
                                }
                                break;
                            case 130:
                                if (c0316l2.f(131) != null && -1 != c0316l2.d(136) && c0316l2.f(138) != null && -1 != c0316l2.d(142) && c0316l2.f(152) != null) {
                                }
                                break;
                            case 131:
                                if (c0316l2.e(149) != 0 && c0316l2.f(152) != null) {
                                }
                                break;
                            case 132:
                                if (c0316l2.f(132) != null && -1 != c0316l2.d(133)) {
                                }
                                break;
                            case 133:
                                if (c0316l2.f(152) == null) {
                                }
                                break;
                            case 134:
                                if (-1 != c0316l2.d(133) && c0316l2.f(139) != null && c0316l2.e(149) != 0 && c0316l2.c(151) != null) {
                                }
                                break;
                            case 135:
                                if (c0316l2.b(137) != null && c0316l2.f(139) != null && c0316l2.e(155) != 0 && c0316l2.c(151) != null) {
                                }
                                break;
                            case 136:
                                if (-1 != c0316l2.d(133) && c0316l2.b(137) != null && c0316l2.f(139) != null && c0316l2.e(155) != 0 && c0316l2.c(151) != null) {
                                }
                                break;
                        }
                    }
                } else {
                    z4 = false;
                }
                if (!z4) {
                    return null;
                }
                int iE3 = this.f6277b.g() ? this.f6277b.e(153) : 128;
                if (128 == iE || (132 == iE && iE3 == 128)) {
                    C0313i c0313iF = f(this.f6276a);
                    this.f6278c = c0313iF;
                    if (c0313iF == null) {
                        return null;
                    }
                }
                switch (iE) {
                    case 132:
                        C0322r c0322r = new C0322r(this.f6277b, this.f6278c);
                        if (iE3 == 128) {
                            byte[] bArrF = c0322r.f6252a.f(132);
                            if (bArrF != null) {
                                String str3 = new String(bArrF);
                                if (!str3.equals("application/vnd.wap.multipart.mixed") && !str3.equals("application/vnd.wap.multipart.related") && !str3.equals("application/vnd.wap.multipart.alternative")) {
                                    if (str3.equals("application/vnd.wap.multipart.alternative")) {
                                        C0318n c0318nC = this.f6278c.c(0);
                                        this.f6278c.j();
                                        this.f6278c.a(c0318nC);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
                return null;
            }
            byteArrayInputStream.reset();
            i(byteArrayInputStream, 0);
        }
        this.f6277b = c0316l;
        if (c0316l != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0281  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final C0313i f(ByteArrayInputStream byteArrayInputStream) {
        C0313i c0313i;
        char c2;
        char c4;
        byte[] bArrG;
        char c5;
        int i2;
        boolean z4;
        char c6;
        int iAvailable;
        int i4;
        C0313i c0313i2 = null;
        if (byteArrayInputStream == null) {
            return null;
        }
        int iG = g(byteArrayInputStream);
        C0313i c0313i3 = new C0313i();
        char c7 = 0;
        int i5 = 0;
        while (i5 < iG) {
            int iG2 = g(byteArrayInputStream);
            int iG3 = g(byteArrayInputStream);
            C0318n c0318n = new C0318n();
            int iAvailable2 = byteArrayInputStream.available();
            if (iAvailable2 <= 0) {
                return c0313i2;
            }
            SparseArray sparseArray = new SparseArray();
            byte[] bArrB = b(byteArrayInputStream, sparseArray);
            if (bArrB != null) {
                c0318n.q(bArrB);
            } else {
                c0318n.q(C0315k.f6272a[c7].getBytes());
            }
            byte[] bArr = (byte[]) sparseArray.get(151);
            if (bArr != null) {
                c0318n.u(bArr);
            }
            Integer num = (Integer) sparseArray.get(129);
            if (num != null) {
                c0318n.l(num.intValue());
            }
            int iAvailable3 = iG2 - (iAvailable2 - byteArrayInputStream.available());
            int i6 = -1;
            int i7 = 1;
            if (iAvailable3 > 0) {
                int iAvailable4 = byteArrayInputStream.available();
                int i8 = iAvailable3;
                while (true) {
                    if (i8 > 0) {
                        int i9 = byteArrayInputStream.read();
                        i8--;
                        if (i9 > 127) {
                            if (i9 != 142) {
                                if (i9 != 174) {
                                    if (i9 == 192) {
                                        byte[] bArrI = i(byteArrayInputStream, i7);
                                        if (bArrI != null) {
                                            c0318n.n(bArrI);
                                        }
                                        iAvailable = byteArrayInputStream.available();
                                    } else if (i9 != 197) {
                                        if (i6 == j(byteArrayInputStream, i8)) {
                                            Log.e("PduParser", "Corrupt Part headers");
                                            break;
                                        }
                                        c6 = 129;
                                        i6 = -1;
                                        i7 = 1;
                                        i8 = 0;
                                    }
                                }
                                if (this.d) {
                                    int iH = h(byteArrayInputStream);
                                    byteArrayInputStream.mark(i7);
                                    int iAvailable5 = byteArrayInputStream.available();
                                    int i10 = byteArrayInputStream.read();
                                    if (i10 == 128) {
                                        c0318n.m(C0318n.d);
                                        i4 = 0;
                                    } else {
                                        if (i10 == 129) {
                                            c0318n.m(C0318n.f6279e);
                                        } else if (i10 == 130) {
                                            c0318n.m(C0318n.f6280f);
                                        } else {
                                            byteArrayInputStream.reset();
                                            i4 = 0;
                                            c0318n.m(i(byteArrayInputStream, 0));
                                        }
                                        i4 = 0;
                                    }
                                    if (iAvailable5 - byteArrayInputStream.available() < iH) {
                                        if (byteArrayInputStream.read() == 152) {
                                            c0318n.t(i(byteArrayInputStream, i4));
                                        }
                                        int iAvailable6 = iAvailable5 - byteArrayInputStream.available();
                                        if (iAvailable6 < iH) {
                                            int i11 = iH - iAvailable6;
                                            byteArrayInputStream.read(new byte[i11], i4, i11);
                                        }
                                    }
                                    iAvailable = byteArrayInputStream.available();
                                }
                            } else {
                                byte[] bArrI2 = i(byteArrayInputStream, 0);
                                if (bArrI2 != null) {
                                    c0318n.o(bArrI2);
                                }
                                iAvailable = byteArrayInputStream.available();
                            }
                            c6 = 129;
                            i8 = iAvailable3 - (iAvailable4 - iAvailable);
                            i6 = -1;
                            i7 = 1;
                        } else {
                            c6 = 129;
                            if (i9 < 32 || i9 > 127) {
                                if (-1 == j(byteArrayInputStream, i8)) {
                                    Log.e("PduParser", "Corrupt Part headers");
                                    break;
                                }
                                i6 = -1;
                                i7 = 1;
                                i8 = 0;
                            } else {
                                byte[] bArrI3 = i(byteArrayInputStream, 0);
                                byte[] bArrI4 = i(byteArrayInputStream, 0);
                                if (true == "Content-Transfer-Encoding".equalsIgnoreCase(new String(bArrI3))) {
                                    c0318n.p(bArrI4);
                                }
                                iAvailable = byteArrayInputStream.available();
                                i8 = iAvailable3 - (iAvailable4 - iAvailable);
                                i6 = -1;
                                i7 = 1;
                            }
                        }
                    } else if (i8 != 0) {
                        Log.e("PduParser", "Corrupt Part headers");
                    } else {
                        z4 = true;
                    }
                }
                z4 = false;
                if (!z4) {
                    return null;
                }
            } else if (iAvailable3 < 0) {
                return c0313i2;
            }
            if (c0318n.e() == null && c0318n.k() == null && c0318n.j() == null && c0318n.d() == null) {
                c0318n.o(Long.toOctalString(System.currentTimeMillis()).getBytes());
            }
            if (iG3 > 0) {
                byte[] byteArray = new byte[iG3];
                String str = new String(c0318n.g());
                c2 = 0;
                byteArrayInputStream.read(byteArray, 0, iG3);
                if (str.equalsIgnoreCase("application/vnd.wap.multipart.alternative")) {
                    c0318n = f(new ByteArrayInputStream(byteArray)).c(0);
                    c0313i = null;
                } else {
                    byte[] bArrF = c0318n.f();
                    if (bArrF != null) {
                        String str2 = new String(bArrF);
                        if (str2.equalsIgnoreCase("base64")) {
                            byteArray = C0306b.a(byteArray);
                        } else if (str2.equalsIgnoreCase("quoted-printable")) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            int i12 = 0;
                            while (i12 < iG3) {
                                byte b2 = byteArray[i12];
                                if (b2 == 61) {
                                    int i13 = i12 + 1;
                                    try {
                                        if ('\r' == ((char) byteArray[i13])) {
                                            i12 += 2;
                                            if ('\n' == ((char) byteArray[i12])) {
                                                i2 = 1;
                                                i12 += i2;
                                            }
                                        }
                                        int iDigit = Character.digit((char) byteArray[i13], 16);
                                        int i14 = i13 + 1;
                                        int iDigit2 = Character.digit((char) byteArray[i14], 16);
                                        if (iDigit != -1 && iDigit2 != -1) {
                                            byteArrayOutputStream.write((char) ((iDigit << 4) + iDigit2));
                                            i12 = i14;
                                        }
                                    } catch (ArrayIndexOutOfBoundsException unused) {
                                    }
                                    byteArray = null;
                                    break;
                                }
                                byteArrayOutputStream.write(b2);
                                i2 = 1;
                                i12 += i2;
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                        }
                    }
                    if (byteArray == null) {
                        return null;
                    }
                    c0313i = null;
                    c0318n.r(byteArray);
                }
            } else {
                c0313i = null;
                c2 = 0;
            }
            byte[] bArr2 = f6274e;
            if (bArr2 == null && f6275f == null) {
                c5 = 1;
            } else if (f6275f != null) {
                byte[] bArrD = c0318n.d();
                if (bArrD != null) {
                    c4 = 1;
                    if (true == Arrays.equals(f6275f, bArrD)) {
                        c5 = c2;
                    }
                } else {
                    c4 = 1;
                }
                c5 = c4;
            } else {
                c4 = 1;
                if (bArr2 == null || (bArrG = c0318n.g()) == null || true != Arrays.equals(f6274e, bArrG)) {
                    c5 = c4;
                }
            }
            if (c5 == 0) {
                c0313i3.a(c0318n);
            } else {
                c0313i3.b(c0318n);
            }
            i5++;
            c0313i2 = c0313i;
            c7 = c2;
        }
        return c0313i3;
    }
}
