package T2;

import android.graphics.Bitmap;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: A, reason: collision with root package name */
    protected Bitmap f1578A;

    /* renamed from: H, reason: collision with root package name */
    protected int f1585H;

    /* renamed from: I, reason: collision with root package name */
    protected short[] f1586I;

    /* renamed from: J, reason: collision with root package name */
    protected byte[] f1587J;

    /* renamed from: K, reason: collision with root package name */
    protected byte[] f1588K;
    protected byte[] L;
    protected Vector<a> M;

    /* renamed from: N, reason: collision with root package name */
    private int[] f1589N;

    /* renamed from: a, reason: collision with root package name */
    private long f1591a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1593c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private int f1594e;

    /* renamed from: f, reason: collision with root package name */
    protected BufferedInputStream f1595f;
    protected int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1596h;

    /* renamed from: i, reason: collision with root package name */
    private int f1597i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f1598j;

    /* renamed from: k, reason: collision with root package name */
    protected int f1599k;

    /* renamed from: l, reason: collision with root package name */
    protected int[] f1600l;

    /* renamed from: m, reason: collision with root package name */
    protected int[] f1601m;

    /* renamed from: n, reason: collision with root package name */
    protected int f1602n;

    /* renamed from: o, reason: collision with root package name */
    protected int f1603o;
    protected int p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f1604q;

    /* renamed from: r, reason: collision with root package name */
    protected int f1605r;

    /* renamed from: s, reason: collision with root package name */
    protected int f1606s;

    /* renamed from: t, reason: collision with root package name */
    protected int f1607t;
    protected int u;

    /* renamed from: v, reason: collision with root package name */
    protected int f1608v;

    /* renamed from: w, reason: collision with root package name */
    protected int f1609w;

    /* renamed from: x, reason: collision with root package name */
    protected int f1610x;

    /* renamed from: y, reason: collision with root package name */
    protected int f1611y;

    /* renamed from: z, reason: collision with root package name */
    protected Bitmap f1612z;

    /* renamed from: b, reason: collision with root package name */
    private long f1592b = 1048576;

    /* renamed from: B, reason: collision with root package name */
    protected byte[] f1579B = new byte[256];

    /* renamed from: C, reason: collision with root package name */
    protected int f1580C = 0;

    /* renamed from: D, reason: collision with root package name */
    protected int f1581D = 0;

    /* renamed from: E, reason: collision with root package name */
    protected int f1582E = 0;

    /* renamed from: F, reason: collision with root package name */
    protected boolean f1583F = false;

    /* renamed from: G, reason: collision with root package name */
    protected int f1584G = 0;

    /* renamed from: O, reason: collision with root package name */
    private boolean f1590O = false;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f1613a;

        /* renamed from: b, reason: collision with root package name */
        public int f1614b;

        public a(Bitmap bitmap, int i2) {
            this.f1613a = bitmap;
            this.f1614b = i2;
        }
    }

    protected final boolean a() {
        return this.g != 0;
    }

    public final int b(int i2) {
        this.f1584G = -1;
        int iD = d();
        if (i2 >= 0 && i2 < iD) {
            this.f1584G = this.M.elementAt(i2).f1614b;
        }
        return this.f1584G;
    }

    public final Bitmap c(int i2) {
        int iD = d();
        if (iD <= 0) {
            return null;
        }
        return this.M.elementAt(i2 % iD).f1613a;
    }

    public final int d() {
        Vector<a> vector = this.M;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public final int e() {
        if (this.f1593c) {
            return this.d;
        }
        return 0;
    }

    public final boolean f() {
        return this.f1593c;
    }

    protected final int g() {
        try {
            return this.f1595f.read();
        } catch (Exception unused) {
            this.g = 1;
            return 0;
        }
    }

    public final int h(InputStream inputStream) throws IOException {
        this.f1593c = false;
        if (this.f1590O) {
            throw new IllegalStateException("decoder cannot be called more than once");
        }
        this.f1590O = true;
        this.g = 0;
        this.M = new Vector<>();
        this.f1600l = null;
        if (inputStream != null) {
            this.f1595f = new BufferedInputStream(inputStream);
            try {
                l();
                if (!a()) {
                    k();
                    if (d() < 0) {
                        this.g = 1;
                    }
                }
            } catch (OutOfMemoryError unused) {
                this.g = 2;
                n();
            }
        } else {
            this.g = 2;
        }
        return this.g;
    }

    protected final int i() throws IOException {
        int iG = g();
        this.f1580C = iG;
        int i2 = 0;
        if (iG > 0) {
            while (true) {
                try {
                    int i4 = this.f1580C;
                    if (i2 >= i4) {
                        break;
                    }
                    int i5 = this.f1595f.read(this.f1579B, i2, i4 - i2);
                    if (i5 == -1) {
                        break;
                    }
                    i2 += i5;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (i2 < this.f1580C) {
                this.g = 1;
            }
        }
        return i2;
    }

    protected final int[] j(int i2) throws IOException {
        int i4;
        int i5 = i2 * 3;
        byte[] bArr = new byte[i5];
        try {
            i4 = this.f1595f.read(bArr, 0, i5);
        } catch (Exception e2) {
            e2.printStackTrace();
            i4 = 0;
        }
        if (i4 < i5) {
            this.g = 1;
            return null;
        }
        int[] iArr = new int[256];
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i6 + 1;
            int i9 = i8 + 1;
            iArr[i7] = ((bArr[i6] & 255) << 16) | (-16777216) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
            i6 = i9 + 1;
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v18, types: [short] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r7v1 */
    protected final void k() throws IOException {
        boolean z4;
        boolean z5;
        int i2;
        Bitmap bitmap;
        int i4;
        int i5;
        int i6;
        int i7;
        short s2;
        boolean z6 = false;
        this.d = 0;
        int i8 = 0;
        while (!z6 && !a()) {
            int iG = g();
            byte b2 = 255;
            if (iG == 33) {
                z4 = z6;
                int iG2 = g();
                if (iG2 == 1) {
                    i8 = 0;
                    q();
                } else if (iG2 == 249) {
                    i8 = 0;
                    g();
                    int iG3 = g();
                    int i9 = (iG3 & 28) >> 2;
                    this.f1581D = i9;
                    if (i9 == 0) {
                        z5 = true;
                        this.f1581D = 1;
                    } else {
                        z5 = true;
                    }
                    if ((iG3 & 1) == 0) {
                        z5 = false;
                    }
                    this.f1583F = z5;
                    int iM = m() * 10;
                    this.f1584G = iM;
                    if (iM <= 0) {
                        this.f1584G = 100;
                    }
                    this.f1585H = g();
                    g();
                } else if (iG2 == 254) {
                    i8 = 0;
                    q();
                } else if (iG2 != 255) {
                    q();
                    i8 = 0;
                } else {
                    i();
                    String string = "";
                    for (int i10 = 0; i10 < 11; i10++) {
                        StringBuilder sbD = D2.e.d(string);
                        sbD.append((char) this.f1579B[i10]);
                        string = sbD.toString();
                    }
                    if (string.equals("NETSCAPE2.0")) {
                        do {
                            i();
                            byte[] bArr = this.f1579B;
                            i8 = 0;
                            if (bArr[0] == 1) {
                                byte b4 = bArr[1];
                                byte b5 = bArr[2];
                            }
                            if (this.f1580C <= 0) {
                                break;
                            }
                        } while (!a());
                    } else {
                        i8 = 0;
                        q();
                    }
                }
            } else if (iG == 44) {
                int size = this.M.size();
                this.f1605r = m();
                this.f1606s = m();
                this.f1607t = m();
                this.u = m();
                int iG4 = g();
                int i11 = (iG4 & 128) != 0 ? 1 : i8;
                int i12 = 2 << (iG4 & 7);
                this.f1604q = (iG4 & 64) != 0 ? 1 : i8;
                if (i11 != 0) {
                    this.f1601m = j(i12);
                } else {
                    this.f1601m = this.f1600l;
                    if (this.f1602n == this.f1585H) {
                        this.f1603o = i8;
                    }
                }
                if (this.f1583F) {
                    int[] iArr = this.f1601m;
                    int i13 = this.f1585H;
                    i2 = iArr[i13];
                    iArr[i13] = i8;
                } else {
                    i2 = i8;
                }
                if (this.f1601m == null) {
                    this.g = 1;
                }
                if (a()) {
                    z4 = z6;
                } else {
                    int i14 = this.f1607t * this.u;
                    byte[] bArr2 = this.L;
                    if (bArr2 == null || bArr2.length < i14) {
                        this.L = new byte[i14];
                    }
                    if (this.f1586I == null) {
                        this.f1586I = new short[4096];
                    }
                    if (this.f1587J == null) {
                        this.f1587J = new byte[4096];
                    }
                    if (this.f1588K == null) {
                        this.f1588K = new byte[4097];
                    }
                    int iG5 = g();
                    int i15 = 1 << iG5;
                    int i16 = i15 + 1;
                    int i17 = i15 + 2;
                    int i18 = iG5 + 1;
                    int i19 = (1 << i18) - 1;
                    short s4 = i8;
                    while (i8 < i15) {
                        this.f1586I[i8] = s4;
                        this.f1587J[i8] = (byte) i8;
                        i8++;
                        s4 = 0;
                    }
                    int i20 = 0;
                    int i21 = 0;
                    int i22 = 0;
                    int i23 = 0;
                    int i24 = 0;
                    int i25 = 0;
                    int i26 = 0;
                    int i27 = 0;
                    int i28 = i19;
                    int i29 = i17;
                    int i30 = i18;
                    z4 = z6;
                    int i31 = -1;
                    while (i21 < i14) {
                        if (i23 != 0) {
                            i5 = i19;
                            i6 = i31;
                            i7 = -1;
                        } else if (i20 < i30) {
                            if (i25 == 0) {
                                i25 = i();
                                if (i25 <= 0) {
                                    break;
                                } else {
                                    i26 = 0;
                                }
                            }
                            i5 = i19;
                            i24 += (b2 & this.f1579B[i26]) << i20;
                            i20 += 8;
                            i26++;
                            i25--;
                            b2 = 255;
                            i19 = i5;
                        } else {
                            i5 = i19;
                            int i32 = i24 & i28;
                            i24 >>= i30;
                            i20 -= i30;
                            if (i32 > i29 || i32 == i16) {
                                break;
                            }
                            if (i32 == i15) {
                                i31 = -1;
                                i30 = i18;
                                i29 = i17;
                                i28 = i5;
                            } else if (i31 == -1) {
                                this.f1588K[i23] = this.f1587J[i32];
                                i31 = i32;
                                i22 = i31;
                                i23++;
                            } else {
                                if (i32 == i29) {
                                    this.f1588K[i23] = (byte) i22;
                                    s2 = i31;
                                    i23++;
                                } else {
                                    s2 = i32;
                                }
                                while (s2 > i15) {
                                    this.f1588K[i23] = this.f1587J[s2];
                                    s2 = this.f1586I[s2];
                                    i23++;
                                    i20 = i20;
                                }
                                int i33 = i20;
                                byte[] bArr3 = this.f1587J;
                                i22 = bArr3[s2] & 255;
                                if (i29 >= 4096) {
                                    break;
                                }
                                int i34 = i23 + 1;
                                i6 = i32;
                                byte b6 = (byte) i22;
                                this.f1588K[i23] = b6;
                                this.f1586I[i29] = (short) i31;
                                bArr3[i29] = b6;
                                i29++;
                                if ((i29 & i28) == 0 && i29 < 4096) {
                                    i30++;
                                    i28 += i29;
                                }
                                i7 = -1;
                                i23 = i34;
                                i20 = i33;
                            }
                            b2 = 255;
                            i19 = i5;
                        }
                        i23 += i7;
                        this.L[i27] = this.f1588K[i23];
                        i21++;
                        i27++;
                        i31 = i6;
                        b2 = 255;
                        i19 = i5;
                    }
                    for (int i35 = i27; i35 < i14; i35++) {
                        this.L[i35] = 0;
                    }
                    q();
                    if (!a()) {
                        if (this.f1589N == null) {
                            this.f1589N = new int[this.f1596h * this.f1597i];
                        }
                        int i36 = this.f1582E;
                        if (i36 > 0) {
                            if (i36 == 3) {
                                int iD = d() - 2;
                                if (iD > 0) {
                                    Bitmap bitmapC = c(iD - 1);
                                    if (!bitmapC.equals(this.f1578A)) {
                                        this.f1578A = bitmapC;
                                        int[] iArr2 = this.f1589N;
                                        int i37 = this.f1596h;
                                        bitmapC.getPixels(iArr2, 0, i37, 0, 0, i37, this.f1597i);
                                    }
                                } else {
                                    this.f1578A = null;
                                    this.f1589N = new int[this.f1596h * this.f1597i];
                                }
                            }
                            if (this.f1578A != null && this.f1582E == 2) {
                                int i38 = !this.f1583F ? this.p : 0;
                                int i39 = (this.f1609w * this.f1596h) + this.f1608v;
                                for (int i40 = 0; i40 < this.f1611y; i40++) {
                                    int i41 = this.f1610x + i39;
                                    for (int i42 = i39; i42 < i41; i42++) {
                                        this.f1589N[i42] = i38;
                                    }
                                    i39 += this.f1596h;
                                }
                            }
                        }
                        int i43 = 8;
                        int i44 = 0;
                        int i45 = 0;
                        int i46 = 1;
                        while (true) {
                            int i47 = this.u;
                            if (i45 >= i47) {
                                break;
                            }
                            if (this.f1604q) {
                                if (i44 >= i47) {
                                    i46++;
                                    if (i46 == 2) {
                                        i44 = 4;
                                    } else if (i46 == 3) {
                                        i44 = 2;
                                        i43 = 4;
                                    } else if (i46 == 4) {
                                        i44 = 1;
                                        i43 = 2;
                                    }
                                }
                                i4 = i44 + i43;
                            } else {
                                i4 = i44;
                                i44 = i45;
                            }
                            int i48 = i44 + this.f1606s;
                            if (i48 < this.f1597i) {
                                int i49 = this.f1596h;
                                int i50 = i48 * i49;
                                int i51 = this.f1605r + i50;
                                int i52 = this.f1607t;
                                int i53 = i51 + i52;
                                int i54 = i50 + i49;
                                if (i54 < i53) {
                                    i53 = i54;
                                }
                                int i55 = i52 * i45;
                                while (i51 < i53) {
                                    int i56 = i55 + 1;
                                    int i57 = this.f1601m[this.L[i55] & 255];
                                    if (i57 != 0) {
                                        this.f1589N[i51] = i57;
                                    }
                                    i51++;
                                    i55 = i56;
                                }
                            }
                            i45++;
                            i44 = i4;
                        }
                        if (this.d <= this.f1594e && (bitmap = this.f1612z) != null && !bitmap.isRecycled()) {
                            this.f1612z.recycle();
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f1589N, this.f1596h, this.f1597i, Bitmap.Config.ARGB_8888);
                        this.f1612z = bitmapCreateBitmap;
                        if (this.d >= this.f1594e) {
                            this.M.addElement(new a(bitmapCreateBitmap, this.f1584G));
                        }
                        this.d++;
                        if (this.f1583F) {
                            this.f1601m[this.f1585H] = i2;
                        }
                        this.f1582E = this.f1581D;
                        this.f1608v = this.f1605r;
                        this.f1609w = this.f1606s;
                        this.f1610x = this.f1607t;
                        this.f1611y = this.u;
                        this.f1578A = this.f1612z;
                        this.p = this.f1603o;
                        this.f1581D = 0;
                        this.f1583F = false;
                        this.f1584G = 0;
                    }
                }
                if (this.M.size() > size) {
                    this.f1591a += this.f1612z.getHeight() * this.f1612z.getRowBytes();
                }
                i8 = 0;
                if (this.f1591a > this.f1592b) {
                    z6 = true;
                }
            } else if (iG != 59) {
                this.g = 1;
                z4 = z6;
            } else {
                this.f1593c = true;
                z6 = true;
            }
            z6 = z4;
        }
    }

    protected final void l() throws IOException {
        String string = "";
        for (int i2 = 0; i2 < 6; i2++) {
            StringBuilder sbD = D2.e.d(string);
            sbD.append((char) g());
            string = sbD.toString();
        }
        if (!string.startsWith("GIF")) {
            this.g = 1;
            return;
        }
        this.f1596h = m();
        this.f1597i = m();
        int iG = g();
        this.f1598j = (iG & 128) != 0;
        this.f1599k = 2 << (iG & 7);
        this.f1602n = g();
        g();
        if (!this.f1598j || a()) {
            return;
        }
        int[] iArrJ = j(this.f1599k);
        this.f1600l = iArrJ;
        this.f1603o = iArrJ[this.f1602n];
    }

    protected final int m() {
        return (g() << 8) | g();
    }

    public final void n() {
        Vector<a> vector = this.M;
        if (vector != null) {
            int size = vector.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVarElementAt = this.M.elementAt(i2);
                Bitmap bitmap = aVarElementAt.f1613a;
                if (bitmap != null && !bitmap.isRecycled()) {
                    aVarElementAt.f1613a.recycle();
                }
            }
        }
    }

    public final void o(long j2) {
        this.f1592b = j2;
    }

    public final void p(int i2) {
        this.f1594e = i2;
    }

    protected final void q() throws IOException {
        do {
            i();
            if (this.f1580C <= 0) {
                return;
            }
        } while (!a());
    }
}
