package g0;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: g0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0314j {
    private static q.g<String, Integer> g = new q.g<>();

    /* renamed from: a, reason: collision with root package name */
    protected ByteArrayOutputStream f6258a;

    /* renamed from: b, reason: collision with root package name */
    private C0310f f6259b;

    /* renamed from: c, reason: collision with root package name */
    protected int f6260c;
    private a d;

    /* renamed from: e, reason: collision with root package name */
    private final ContentResolver f6261e;

    /* renamed from: f, reason: collision with root package name */
    private C0316l f6262f;

    /* renamed from: g0.j$a */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        private b f6263a = null;

        /* renamed from: b, reason: collision with root package name */
        private b f6264b = null;

        /* renamed from: c, reason: collision with root package name */
        int f6265c = 0;

        a() {
        }

        final void a() {
            C0314j.this.k(this.f6264b.f6266a.toByteArray(), this.f6264b.f6267b);
            this.f6264b = null;
        }

        final c b() {
            C0314j c0314j = C0314j.this;
            c cVar = c0314j.new c();
            cVar.f6269a = c0314j.f6260c;
            cVar.f6270b = this.f6265c;
            return cVar;
        }

        final void c() {
            if (this.f6264b != null) {
                throw new RuntimeException("BUG: Invalid newbuf() before copy()");
            }
            b bVar = new b();
            C0314j c0314j = C0314j.this;
            bVar.f6266a = c0314j.f6258a;
            bVar.f6267b = c0314j.f6260c;
            bVar.f6268c = this.f6263a;
            this.f6263a = bVar;
            this.f6265c++;
            c0314j.f6258a = new ByteArrayOutputStream();
            C0314j.this.f6260c = 0;
        }

        final void d() {
            C0314j c0314j = C0314j.this;
            ByteArrayOutputStream byteArrayOutputStream = c0314j.f6258a;
            int i2 = c0314j.f6260c;
            b bVar = this.f6263a;
            c0314j.f6258a = bVar.f6266a;
            c0314j.f6260c = bVar.f6267b;
            this.f6264b = bVar;
            this.f6263a = bVar.f6268c;
            this.f6265c--;
            bVar.f6266a = byteArrayOutputStream;
            bVar.f6267b = i2;
        }
    }

    /* renamed from: g0.j$b */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        ByteArrayOutputStream f6266a = null;

        /* renamed from: b, reason: collision with root package name */
        public int f6267b = 0;

        /* renamed from: c, reason: collision with root package name */
        public b f6268c = null;

        b() {
        }
    }

    /* renamed from: g0.j$c */
    private class c {

        /* renamed from: a, reason: collision with root package name */
        private int f6269a;

        /* renamed from: b, reason: collision with root package name */
        private int f6270b;

        c() {
        }

        final int c() {
            if (this.f6270b == C0314j.this.d.f6265c) {
                return C0314j.this.f6260c - this.f6269a;
            }
            throw new RuntimeException("BUG: Invalid call to getLength()");
        }
    }

    static {
        int i2 = 0;
        while (true) {
            String[] strArr = C0315k.f6272a;
            if (i2 >= 83) {
                return;
            }
            g.put(strArr[i2], Integer.valueOf(i2));
            i2++;
        }
    }

    public C0314j(Context context, C0310f c0310f) {
        this.f6258a = null;
        this.f6260c = 0;
        this.d = null;
        this.f6262f = null;
        this.f6259b = c0310f;
        this.f6261e = context.getContentResolver();
        this.f6262f = c0310f.f6252a;
        this.d = new a();
        this.f6258a = new ByteArrayOutputStream();
        this.f6260c = 0;
    }

    private C0309e c(C0309e c0309e) throws IOException {
        try {
            String strF = c0309e.f();
            char c2 = 5;
            if (strF.matches("[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}")) {
                c2 = 3;
            } else if (strF.matches("\\+?[0-9|\\.|\\-]+")) {
                c2 = 1;
            } else if (strF.matches("[a-zA-Z| ]*\\<{0,1}[a-zA-Z| ]+@{1}[a-zA-Z| ]+\\.{1}[a-zA-Z| ]+\\>{0,1}")) {
                c2 = 2;
            } else if (strF.matches("[a-fA-F]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}")) {
                c2 = 4;
            }
            C0309e c0309eC = C0309e.c(c0309e);
            if (1 == c2) {
                c0309eC.a("/TYPE=PLMN".getBytes());
            } else if (3 == c2) {
                c0309eC.a("/TYPE=IPV4".getBytes());
            } else if (4 == c2) {
                c0309eC.a("/TYPE=IPV6".getBytes());
            }
            return c0309eC;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    private int e(int i2) throws IOException {
        switch (i2) {
            case 129:
            case 130:
            case 151:
                C0309e[] c0309eArrC = this.f6262f.c(i2);
                if (c0309eArrC == null) {
                    return 2;
                }
                for (C0309e c0309e : c0309eArrC) {
                    C0309e c0309eC = c(c0309e);
                    if (c0309eC == null) {
                        return 1;
                    }
                    b(i2);
                    d(c0309eC);
                }
                return 0;
            case 131:
            case 139:
            case 152:
                byte[] bArrF = this.f6262f.f(i2);
                if (bArrF == null) {
                    return 2;
                }
                b(i2);
                h(bArrF);
                return 0;
            case 132:
            case 135:
            case 140:
            case 146:
            case 147:
            case 148:
            case 153:
            case 154:
            default:
                return 3;
            case 133:
                long jD = this.f6262f.d(i2);
                if (-1 == jD) {
                    return 2;
                }
                b(i2);
                f(jD);
                return 0;
            case 134:
            case 143:
            case 144:
            case 145:
            case 149:
            case 155:
                int iE = this.f6262f.e(i2);
                if (iE == 0) {
                    return 2;
                }
                b(i2);
                b(iE);
                return 0;
            case 136:
            case 142:
                long jD2 = this.f6262f.d(i2);
                if (-1 == jD2) {
                    return 2;
                }
                b(i2);
                this.d.c();
                c cVarB = this.d.b();
                b(129);
                f(jD2);
                int iC = cVarB.c();
                this.d.d();
                j(iC);
                this.d.a();
                return 0;
            case 137:
                b(i2);
                C0309e c0309eB = this.f6262f.b(i2);
                if (c0309eB == null || TextUtils.isEmpty(c0309eB.f()) || new String(c0309eB.g()).equals("insert-address-token")) {
                    b(1);
                    b(129);
                } else {
                    this.d.c();
                    c cVarB2 = this.d.b();
                    b(128);
                    C0309e c0309eC2 = c(c0309eB);
                    if (c0309eC2 == null) {
                        return 1;
                    }
                    d(c0309eC2);
                    int iC2 = cVarB2.c();
                    this.d.d();
                    j(iC2);
                    this.d.a();
                }
                return 0;
            case 138:
                byte[] bArrF2 = this.f6262f.f(i2);
                if (bArrF2 == null) {
                    return 2;
                }
                b(i2);
                if (Arrays.equals(bArrF2, "advertisement".getBytes())) {
                    b(129);
                } else if (Arrays.equals(bArrF2, "auto".getBytes())) {
                    b(131);
                } else if (Arrays.equals(bArrF2, "personal".getBytes())) {
                    b(128);
                } else if (Arrays.equals(bArrF2, "informational".getBytes())) {
                    b(130);
                } else {
                    h(bArrF2);
                }
                return 0;
            case 141:
                b(i2);
                int iE2 = this.f6262f.e(i2);
                if (iE2 == 0) {
                    g(18);
                } else {
                    g(iE2);
                }
                return 0;
            case 150:
                C0309e c0309eB2 = this.f6262f.b(i2);
                if (c0309eB2 == null) {
                    return 2;
                }
                b(i2);
                d(c0309eB2);
                return 0;
        }
    }

    protected final void b(int i2) {
        this.f6258a.write(i2);
        this.f6260c++;
    }

    protected final void d(C0309e c0309e) {
        int iE = c0309e.e();
        byte[] bArrG = c0309e.g();
        this.d.c();
        c cVarB = this.d.b();
        g(iE);
        h(bArrG);
        int iC = cVarB.c();
        this.d.d();
        j(iC);
        this.d.a();
    }

    protected final void f(long j2) {
        long j4 = j2;
        int i2 = 0;
        while (j4 != 0 && i2 < 8) {
            j4 >>>= 8;
            i2++;
        }
        b(i2);
        int i4 = (i2 - 1) * 8;
        for (int i5 = 0; i5 < i2; i5++) {
            b((int) ((j2 >>> i4) & 255));
            i4 -= 8;
        }
    }

    protected final void g(int i2) {
        b((i2 | 128) & 255);
    }

    protected final void h(byte[] bArr) {
        if ((bArr[0] & 255) > 127) {
            b(127);
        }
        k(bArr, bArr.length);
        b(0);
    }

    protected final void i(long j2) {
        int i2 = 0;
        long j4 = 127;
        while (i2 < 5 && j2 >= j4) {
            j4 = (j4 << 7) | 127;
            i2++;
        }
        while (i2 > 0) {
            b((int) ((((j2 >>> (i2 * 7)) & 127) | 128) & 255));
            i2--;
        }
        b((int) (j2 & 127));
    }

    protected final void j(long j2) {
        if (j2 < 31) {
            b((int) j2);
        } else {
            b(31);
            i(j2);
        }
    }

    protected final void k(byte[] bArr, int i2) {
        this.f6258a.write(bArr, 0, i2);
        this.f6260c += i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0394 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x037a A[EXC_TOP_SPLITTER, PHI: r8
      0x037a: PHI (r8v9 java.io.InputStream) = (r8v7 java.io.InputStream), (r8v8 java.io.InputStream), (r8v10 java.io.InputStream) binds: [B:189:0x0370, B:192:0x0374, B:195:0x0378] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] l() throws Throwable {
        boolean z4;
        boolean z5;
        boolean z6;
        int iH;
        int i2;
        InputStream inputStreamOpenInputStream;
        boolean z7;
        int length;
        int iA = this.f6259b.a();
        int i4 = 133;
        InputStream inputStream = null;
        if (iA == 128) {
            if (this.f6258a == null) {
                this.f6258a = new ByteArrayOutputStream();
                this.f6260c = 0;
            }
            b(140);
            b(128);
            b(152);
            byte[] bArrF = this.f6262f.f(152);
            if (bArrF == null) {
                throw new IllegalArgumentException("Transaction-ID is null.");
            }
            h(bArrF);
            if (e(141) != 0) {
                z4 = true;
                if (z4) {
                    return null;
                }
            } else {
                e(133);
                if (e(137) == 0) {
                    boolean z8 = e(151) != 1;
                    if (e(130) != 1) {
                        z8 = true;
                    }
                    int i5 = 129;
                    if (e(129) != 1) {
                        z8 = true;
                    }
                    if (z8) {
                        e(150);
                        e(138);
                        e(136);
                        e(143);
                        e(134);
                        e(144);
                        b(132);
                        this.d.c();
                        c cVarB = this.d.b();
                        Integer orDefault = g.getOrDefault(new String(this.f6262f.f(132)), null);
                        if (orDefault != null) {
                            g(orDefault.intValue());
                            C0313i c0313iE = ((t) this.f6259b).e();
                            if (c0313iE == null || c0313iE.h() == 0) {
                                z5 = false;
                                i(0L);
                                this.d.d();
                                this.d.a();
                            } else {
                                try {
                                    C0318n c0318nC = c0313iE.c(0);
                                    byte[] bArrD = c0318nC.d();
                                    if (bArrD != null) {
                                        b(138);
                                        if (60 == bArrD[0]) {
                                            z6 = true;
                                            try {
                                                if (62 == bArrD[bArrD.length - 1]) {
                                                    h(bArrD);
                                                }
                                            } catch (ArrayIndexOutOfBoundsException e2) {
                                                e = e2;
                                                e.printStackTrace();
                                                int iC = cVarB.c();
                                                this.d.d();
                                                j(iC);
                                                this.d.a();
                                                iH = c0313iE.h();
                                                i(iH);
                                                i2 = 0;
                                                while (i2 < iH) {
                                                }
                                                z5 = z;
                                                z4 = z5;
                                                if (z4) {
                                                }
                                                return this.f6258a.toByteArray();
                                            }
                                        } else {
                                            z6 = true;
                                        }
                                        h(("<" + new String(bArrD) + ">").getBytes());
                                    } else {
                                        z6 = true;
                                    }
                                    b(137);
                                    h(c0318nC.g());
                                } catch (ArrayIndexOutOfBoundsException e4) {
                                    e = e4;
                                    z6 = true;
                                }
                                int iC2 = cVarB.c();
                                this.d.d();
                                j(iC2);
                                this.d.a();
                                iH = c0313iE.h();
                                i(iH);
                                i2 = 0;
                                while (i2 < iH) {
                                    C0318n c0318nC2 = c0313iE.c(i2);
                                    this.d.c();
                                    c cVarB2 = this.d.b();
                                    this.d.c();
                                    c cVarB3 = this.d.b();
                                    byte[] bArrG = c0318nC2.g();
                                    if (bArrG != null) {
                                        Integer orDefault2 = g.getOrDefault(new String(bArrG), null);
                                        if (orDefault2 == null) {
                                            h(bArrG);
                                        } else {
                                            g(orDefault2.intValue());
                                        }
                                        byte[] bArrK = c0318nC2.k();
                                        if (bArrK == null && (bArrK = c0318nC2.j()) == null && (bArrK = c0318nC2.e()) == null) {
                                            bArrK = "smil.xml".getBytes();
                                        }
                                        b(i4);
                                        h(bArrK);
                                        int iB = c0318nC2.b();
                                        if (iB != 0) {
                                            b(i5);
                                            g(iB);
                                        }
                                        int iC3 = cVarB3.c();
                                        this.d.d();
                                        j(iC3);
                                        this.d.a();
                                        byte[] bArrD2 = c0318nC2.d();
                                        int i6 = -1;
                                        if (bArrD2 != null) {
                                            b(192);
                                            if (60 == bArrD2[0] && 62 == bArrD2[bArrD2.length - 1]) {
                                                b(34);
                                                k(bArrD2, bArrD2.length);
                                                b(0);
                                            } else {
                                                StringBuilder sbD = D2.e.d("<");
                                                sbD.append(new String(bArrD2));
                                                sbD.append(">");
                                                byte[] bytes = sbD.toString().getBytes();
                                                b(34);
                                                k(bytes, bytes.length);
                                                b(0);
                                            }
                                        }
                                        byte[] bArrE = c0318nC2.e();
                                        if (bArrE != null) {
                                            b(142);
                                            h(bArrE);
                                        }
                                        int iC4 = cVarB2.c();
                                        byte[] bArrH = c0318nC2.h();
                                        if (bArrH != null) {
                                            k(bArrH, bArrH.length);
                                            length = bArrH.length;
                                            z7 = false;
                                        } else {
                                            try {
                                                byte[] bArr = new byte[1024];
                                                inputStreamOpenInputStream = this.f6261e.openInputStream(c0318nC2.i());
                                                int i7 = 0;
                                                while (true) {
                                                    try {
                                                        int i8 = inputStreamOpenInputStream.read(bArr);
                                                        if (i8 == i6) {
                                                            break;
                                                        }
                                                        this.f6258a.write(bArr, 0, i8);
                                                        this.f6260c += i8;
                                                        i7 += i8;
                                                        i6 = -1;
                                                    } catch (FileNotFoundException unused) {
                                                        if (inputStreamOpenInputStream != null) {
                                                            try {
                                                                inputStreamOpenInputStream.close();
                                                            } catch (IOException unused2) {
                                                            }
                                                        }
                                                        z4 = z6;
                                                        if (z4) {
                                                        }
                                                        return this.f6258a.toByteArray();
                                                    } catch (IOException unused3) {
                                                        if (inputStreamOpenInputStream != null) {
                                                        }
                                                        z4 = z6;
                                                        if (z4) {
                                                        }
                                                        return this.f6258a.toByteArray();
                                                    } catch (RuntimeException unused4) {
                                                        if (inputStreamOpenInputStream != null) {
                                                        }
                                                        z4 = z6;
                                                        if (z4) {
                                                        }
                                                        return this.f6258a.toByteArray();
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        inputStream = inputStreamOpenInputStream;
                                                        if (inputStream != null) {
                                                            try {
                                                                inputStream.close();
                                                            } catch (IOException unused5) {
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                z7 = false;
                                                try {
                                                    inputStreamOpenInputStream.close();
                                                } catch (IOException unused6) {
                                                }
                                                length = i7;
                                            } catch (FileNotFoundException unused7) {
                                                inputStreamOpenInputStream = null;
                                            } catch (IOException unused8) {
                                                inputStreamOpenInputStream = null;
                                            } catch (RuntimeException unused9) {
                                                inputStreamOpenInputStream = null;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                        if (length != cVarB2.c() - iC4) {
                                            throw new RuntimeException("BUG: Length check failed");
                                        }
                                        this.d.d();
                                        i(iC4);
                                        i(length);
                                        this.d.a();
                                        i2++;
                                        i5 = 129;
                                        z = z7;
                                        i4 = 133;
                                    }
                                    z4 = z6;
                                    break;
                                }
                                z5 = z;
                            }
                            z4 = z5;
                        }
                        if (z4) {
                        }
                    }
                }
            }
        } else if (iA == 133) {
            if (this.f6258a == null) {
                this.f6258a = new ByteArrayOutputStream();
                this.f6260c = 0;
            }
            b(140);
            b(133);
            if (e(152) == 0 && e(141) == 0) {
                e(145);
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
        } else if (iA == 135) {
            if (this.f6258a == null) {
                this.f6258a = new ByteArrayOutputStream();
                this.f6260c = 0;
            }
            b(140);
            b(135);
            if (e(141) == 0 && e(139) == 0 && e(151) == 0 && e(137) == 0) {
                e(133);
                z = e(155) != 0;
                if (z) {
                    return null;
                }
            }
        } else if (iA == 130) {
            if (this.f6258a == null) {
                this.f6258a = new ByteArrayOutputStream();
                this.f6260c = 0;
            }
            b(140);
            b(130);
            if (e(152) == 0 && e(141) == 0 && e(137) == 0) {
                e(150);
                z = (e(138) == 0 && e(142) == 0 && e(136) == 0 && e(131) == 0) ? false : true;
                if (z) {
                    return null;
                }
            }
        } else {
            if (iA != 131) {
                return null;
            }
            if (this.f6258a == null) {
                this.f6258a = new ByteArrayOutputStream();
                this.f6260c = 0;
            }
            b(140);
            b(131);
            if ((e(152) == 0 && e(141) == 0 && e(149) == 0) ? false : true) {
                return null;
            }
        }
        return this.f6258a.toByteArray();
    }
}
