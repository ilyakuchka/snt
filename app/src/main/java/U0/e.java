package U0;

import U0.a;
import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e implements a {

    /* renamed from: a, reason: collision with root package name */
    private int[] f1686a;

    /* renamed from: c, reason: collision with root package name */
    private final a.InterfaceC0041a f1688c;
    private ByteBuffer d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f1689e;

    /* renamed from: f, reason: collision with root package name */
    private short[] f1690f;
    private byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f1691h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f1692i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f1693j;

    /* renamed from: k, reason: collision with root package name */
    private int f1694k;

    /* renamed from: l, reason: collision with root package name */
    private c f1695l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f1696m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1697n;

    /* renamed from: o, reason: collision with root package name */
    private int f1698o;
    private int p;

    /* renamed from: q, reason: collision with root package name */
    private int f1699q;

    /* renamed from: r, reason: collision with root package name */
    private int f1700r;

    /* renamed from: s, reason: collision with root package name */
    private Boolean f1701s;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f1687b = new int[256];

    /* renamed from: t, reason: collision with root package name */
    private Bitmap.Config f1702t = Bitmap.Config.ARGB_8888;

    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList, java.util.List<U0.b>] */
    public e(a.InterfaceC0041a interfaceC0041a, c cVar, ByteBuffer byteBuffer, int i2) {
        this.f1688c = interfaceC0041a;
        this.f1695l = new c();
        synchronized (this) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
            }
            int iHighestOneBit = Integer.highestOneBit(i2);
            this.f1698o = 0;
            this.f1695l = cVar;
            this.f1694k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.d.order(ByteOrder.LITTLE_ENDIAN);
            this.f1697n = false;
            Iterator it = cVar.f1677e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((b) it.next()).g == 3) {
                    this.f1697n = true;
                    break;
                }
            }
            this.p = iHighestOneBit;
            int i4 = cVar.f1678f;
            this.f1700r = i4 / iHighestOneBit;
            int i5 = cVar.g;
            this.f1699q = i5 / iHighestOneBit;
            this.f1692i = ((j1.b) this.f1688c).b(i4 * i5);
            this.f1693j = ((j1.b) this.f1688c).c(this.f1700r * this.f1699q);
        }
    }

    private Bitmap h() {
        Boolean bool = this.f1701s;
        Bitmap bitmapA = ((j1.b) this.f1688c).a(this.f1700r, this.f1699q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f1702t);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap j(b bVar, b bVar2) {
        int[] iArr;
        byte b2;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        short s2;
        int i16;
        short s4;
        short s5;
        int i17;
        Bitmap bitmap;
        int[] iArr2 = this.f1693j;
        byte b4 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f1696m;
            if (bitmap2 != null) {
                ((j1.b) this.f1688c).d(bitmap2);
            }
            this.f1696m = null;
            Arrays.fill(iArr2, 0);
        }
        if (bVar2 != null && bVar2.g == 3 && this.f1696m == null) {
            Arrays.fill(iArr2, 0);
        }
        if (bVar2 != null && (i17 = bVar2.g) > 0) {
            if (i17 == 2) {
                if (!bVar.f1669f) {
                    c cVar = this.f1695l;
                    int i18 = cVar.f1682k;
                    if (bVar.f1673k != null && cVar.f1681j == bVar.f1670h) {
                        i18 = 0;
                    }
                    int i19 = bVar2.d;
                    int i20 = this.p;
                    int i21 = i19 / i20;
                    int i22 = bVar2.f1666b / i20;
                    int i23 = bVar2.f1667c / i20;
                    int i24 = bVar2.f1665a / i20;
                    int i25 = this.f1700r;
                    int i26 = (i22 * i25) + i24;
                    int i27 = (i21 * i25) + i26;
                    while (i26 < i27) {
                        int i28 = i26 + i23;
                        for (int i29 = i26; i29 < i28; i29++) {
                            iArr2[i29] = i18;
                        }
                        i26 += this.f1700r;
                    }
                }
            } else if (i17 == 3 && (bitmap = this.f1696m) != null) {
                int i30 = this.f1700r;
                bitmap.getPixels(iArr2, 0, i30, 0, 0, i30, this.f1699q);
            }
        }
        this.d.position(bVar.f1672j);
        int i31 = bVar.f1667c * bVar.d;
        byte[] bArr = this.f1692i;
        if (bArr == null || bArr.length < i31) {
            this.f1692i = ((j1.b) this.f1688c).b(i31);
        }
        byte[] bArr2 = this.f1692i;
        if (this.f1690f == null) {
            this.f1690f = new short[4096];
        }
        short[] sArr = this.f1690f;
        if (this.g == null) {
            this.g = new byte[4096];
        }
        byte[] bArr3 = this.g;
        if (this.f1691h == null) {
            this.f1691h = new byte[4097];
        }
        byte[] bArr4 = this.f1691h;
        int i32 = this.d.get() & 255;
        int i33 = 1 << i32;
        int i34 = i33 + 1;
        int i35 = i33 + 2;
        int i36 = i32 + 1;
        int i37 = (1 << i36) - 1;
        for (int i38 = 0; i38 < i33; i38++) {
            sArr[i38] = 0;
            bArr3[i38] = (byte) i38;
        }
        byte[] bArr5 = this.f1689e;
        e eVar = this;
        int i39 = i36;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        int i45 = 0;
        short s6 = 0;
        int i46 = 0;
        int i47 = i35;
        int i48 = i37;
        short s7 = -1;
        while (true) {
            if (i40 >= i31) {
                iArr = iArr2;
                b2 = b4;
                i2 = i41;
                break;
            }
            if (i42 == 0) {
                int i49 = eVar.d.get() & 255;
                if (i49 <= 0) {
                    i14 = i36;
                    i15 = i40;
                    iArr = iArr2;
                    s2 = s7;
                } else {
                    i14 = i36;
                    ByteBuffer byteBuffer = eVar.d;
                    i15 = i40;
                    s2 = s7;
                    iArr = iArr2;
                    byteBuffer.get(eVar.f1689e, 0, Math.min(i49, byteBuffer.remaining()));
                }
                if (i49 <= 0) {
                    eVar.f1698o = 3;
                    i2 = i41;
                    b2 = 0;
                    break;
                }
                i42 = i49;
                i43 = 0;
            } else {
                i14 = i36;
                i15 = i40;
                iArr = iArr2;
                s2 = s7;
            }
            i45 += (bArr5[i43] & 255) << i44;
            i43++;
            i42--;
            int i50 = i44 + 8;
            int i51 = i47;
            int i52 = i39;
            i40 = i15;
            s7 = s2;
            byte[] bArr6 = bArr5;
            short s8 = s6;
            while (true) {
                if (i50 < i52) {
                    s6 = s8;
                    eVar = this;
                    break;
                }
                e eVar2 = eVar;
                int i53 = i45 & i48;
                i45 >>= i52;
                i50 -= i52;
                if (i53 == i33) {
                    i16 = i50;
                    i51 = i35;
                    i48 = i37;
                    eVar = eVar2;
                    i52 = i14;
                    s7 = -1;
                    s4 = s8;
                } else {
                    if (i53 == i34) {
                        s6 = s8;
                        eVar = eVar2;
                        break;
                    }
                    i16 = i50;
                    if (s7 == -1) {
                        bArr2[i41] = bArr3[i53 == true ? 1 : 0];
                        i41++;
                        i40++;
                        s8 = i53 == true ? 1 : 0;
                        s7 = s8;
                        i50 = i16;
                        eVar = this;
                    } else {
                        if (i53 >= i51) {
                            bArr4[i46] = (byte) s8;
                            i46++;
                            s5 = s7;
                        } else {
                            s5 = i53 == true ? 1 : 0;
                        }
                        while (s5 >= i33) {
                            bArr4[i46] = bArr3[s5];
                            i46++;
                            s5 = sArr[s5];
                        }
                        boolean z4 = bArr3[s5] & 255;
                        byte b5 = z4 ? (byte) 1 : (byte) 0;
                        bArr2[i41] = b5;
                        while (true) {
                            i41++;
                            i40++;
                            if (i46 <= 0) {
                                break;
                            }
                            i46--;
                            bArr2[i41] = bArr4[i46];
                        }
                        s4 = z4 ? 1 : 0;
                        if (i51 < 4096) {
                            sArr[i51] = s7;
                            bArr3[i51] = b5;
                            i51++;
                            if ((i51 & i48) == 0 && i51 < 4096) {
                                i52++;
                                i48 += i51;
                            }
                        }
                        s7 = i53 == true ? 1 : 0;
                        eVar = this;
                    }
                }
                s8 = s4;
                i50 = i16;
            }
            i39 = i52;
            i47 = i51;
            bArr5 = bArr6;
            i36 = i14;
            b4 = 0;
            i44 = i50;
            iArr2 = iArr;
        }
        Arrays.fill(bArr2, i2, i31, b2);
        if (bVar.f1668e || this.p != 1) {
            int[] iArr3 = this.f1693j;
            int i54 = bVar.d;
            int i55 = this.p;
            int i56 = i54 / i55;
            int i57 = bVar.f1666b / i55;
            int i58 = bVar.f1667c / i55;
            int i59 = bVar.f1665a / i55;
            boolean z5 = this.f1694k == 0;
            int i60 = this.f1700r;
            int i61 = this.f1699q;
            byte[] bArr7 = this.f1692i;
            int[] iArr4 = this.f1686a;
            Boolean bool = this.f1701s;
            int i62 = 8;
            int i63 = 0;
            int i64 = 0;
            int i65 = 1;
            while (i63 < i56) {
                Boolean bool2 = bool;
                if (bVar.f1668e) {
                    if (i64 >= i56) {
                        int i66 = i65 + 1;
                        i4 = i56;
                        if (i66 == 2) {
                            i64 = 4;
                            i65 = i66;
                        } else if (i66 != 3) {
                            i65 = i66;
                            if (i66 == 4) {
                                i64 = 1;
                                i62 = 2;
                            }
                        } else {
                            i62 = 4;
                            i65 = i66;
                            i64 = 2;
                        }
                    } else {
                        i4 = i56;
                    }
                    i5 = i64 + i62;
                } else {
                    i4 = i56;
                    i5 = i64;
                    i64 = i63;
                }
                int i67 = i64 + i57;
                boolean z6 = i55 == 1;
                if (i67 < i61) {
                    int i68 = i67 * i60;
                    int i69 = i68 + i59;
                    i6 = i5;
                    int i70 = i69 + i58;
                    int i71 = i68 + i60;
                    if (i71 < i70) {
                        i70 = i71;
                    }
                    i7 = i57;
                    int i72 = i63 * i55 * bVar.f1667c;
                    if (z6) {
                        bool = bool2;
                        int i73 = i69;
                        while (true) {
                            i8 = i58;
                            if (i73 >= i70) {
                                break;
                            }
                            int i74 = iArr4[bArr7[i72] & 255];
                            if (i74 != 0) {
                                iArr3[i73] = i74;
                            } else if (z5 && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i72 += i55;
                            i73++;
                            i58 = i8;
                        }
                    } else {
                        i8 = i58;
                        int i75 = ((i70 - i69) * i55) + i72;
                        bool = bool2;
                        int i76 = i69;
                        while (i76 < i70) {
                            int i77 = i70;
                            int i78 = bVar.f1667c;
                            int i79 = i59;
                            int i80 = i60;
                            int i81 = i72;
                            int i82 = 0;
                            int i83 = 0;
                            int i84 = 0;
                            int i85 = 0;
                            int i86 = 0;
                            while (true) {
                                if (i81 >= this.p + i72) {
                                    i12 = i61;
                                    break;
                                }
                                byte[] bArr8 = this.f1692i;
                                i12 = i61;
                                if (i81 >= bArr8.length || i81 >= i75) {
                                    break;
                                }
                                int i87 = this.f1686a[bArr8[i81] & 255];
                                if (i87 != 0) {
                                    i82 += (i87 >> 24) & 255;
                                    i83 += (i87 >> 16) & 255;
                                    i84 += (i87 >> 8) & 255;
                                    i85 += i87 & 255;
                                    i86++;
                                }
                                i81++;
                                i61 = i12;
                            }
                            int i88 = i78 + i72;
                            for (int i89 = i88; i89 < this.p + i88; i89++) {
                                byte[] bArr9 = this.f1692i;
                                if (i89 >= bArr9.length || i89 >= i75) {
                                    break;
                                }
                                int i90 = this.f1686a[bArr9[i89] & 255];
                                if (i90 != 0) {
                                    i82 += (i90 >> 24) & 255;
                                    i83 += (i90 >> 16) & 255;
                                    i84 += (i90 >> 8) & 255;
                                    i85 += i90 & 255;
                                    i86++;
                                }
                            }
                            int i91 = i86 == 0 ? 0 : ((i82 / i86) << 24) | ((i83 / i86) << 16) | ((i84 / i86) << 8) | (i85 / i86);
                            if (i91 != 0) {
                                iArr3[i76] = i91;
                            } else if (z5 && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i72 += i55;
                            i76++;
                            i70 = i77;
                            i59 = i79;
                            i60 = i80;
                            i61 = i12;
                        }
                    }
                    i9 = i59;
                    i10 = i60;
                    i11 = i61;
                } else {
                    i6 = i5;
                    i7 = i57;
                    i8 = i58;
                    i9 = i59;
                    i10 = i60;
                    i11 = i61;
                    bool = bool2;
                }
                i63++;
                i56 = i4;
                i64 = i6;
                i57 = i7;
                i58 = i8;
                i59 = i9;
                i60 = i10;
                i61 = i11;
            }
            Boolean bool3 = bool;
            if (this.f1701s == null) {
                this.f1701s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
            }
        } else {
            int[] iArr5 = this.f1693j;
            int i92 = bVar.d;
            int i93 = bVar.f1666b;
            int i94 = bVar.f1667c;
            int i95 = bVar.f1665a;
            byte b6 = this.f1694k == 0 ? (byte) 1 : b2;
            int i96 = this.f1700r;
            byte[] bArr10 = this.f1692i;
            int[] iArr6 = this.f1686a;
            int i97 = -1;
            for (int i98 = b2; i98 < i92; i98++) {
                int i99 = (i98 + i93) * i96;
                int i100 = i99 + i95;
                int i101 = i100 + i94;
                int i102 = i99 + i96;
                if (i102 < i101) {
                    i101 = i102;
                }
                int i103 = bVar.f1667c * i98;
                while (i100 < i101) {
                    int i104 = i92;
                    int i105 = bArr10[i103];
                    int i106 = i93;
                    int i107 = i105 & 255;
                    if (i107 != i97) {
                        int i108 = iArr6[i107];
                        if (i108 != 0) {
                            iArr5[i100] = i108;
                        } else {
                            i97 = i105;
                        }
                    }
                    i103++;
                    i100++;
                    i92 = i104;
                    i93 = i106;
                }
            }
            Boolean bool4 = this.f1701s;
            this.f1701s = Boolean.valueOf((bool4 != null && bool4.booleanValue()) || !(this.f1701s != null || b6 == 0 || i97 == -1));
        }
        if (this.f1697n && ((i13 = bVar.g) == 0 || i13 == 1)) {
            if (this.f1696m == null) {
                this.f1696m = h();
            }
            Bitmap bitmap3 = this.f1696m;
            int i109 = this.f1700r;
            bitmap3.setPixels(iArr, 0, i109, 0, 0, i109, this.f1699q);
        }
        Bitmap bitmapH = h();
        int i110 = this.f1700r;
        bitmapH.setPixels(iArr, 0, i110, 0, 0, i110, this.f1699q);
        return bitmapH;
    }

    @Override // U0.a
    public final int a() {
        return this.f1694k;
    }

    @Override // U0.a
    public final int b() {
        return (this.f1693j.length * 4) + this.d.limit() + this.f1692i.length;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList, java.util.List<U0.b>] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.ArrayList, java.util.List<U0.b>] */
    @Override // U0.a
    public final synchronized Bitmap c() {
        if (this.f1695l.f1676c <= 0 || this.f1694k < 0) {
            if (Log.isLoggable("e", 3)) {
                Log.d("e", "Unable to decode frame, frameCount=" + this.f1695l.f1676c + ", framePointer=" + this.f1694k);
            }
            this.f1698o = 1;
        }
        int i2 = this.f1698o;
        if (i2 != 1 && i2 != 2) {
            this.f1698o = 0;
            if (this.f1689e == null) {
                this.f1689e = ((j1.b) this.f1688c).b(255);
            }
            b bVar = (b) this.f1695l.f1677e.get(this.f1694k);
            int i4 = this.f1694k - 1;
            b bVar2 = i4 >= 0 ? (b) this.f1695l.f1677e.get(i4) : null;
            int[] iArr = bVar.f1673k;
            if (iArr == null) {
                iArr = this.f1695l.f1674a;
            }
            this.f1686a = iArr;
            if (iArr == null) {
                if (Log.isLoggable("e", 3)) {
                    Log.d("e", "No valid color table found for frame #" + this.f1694k);
                }
                this.f1698o = 1;
                return null;
            }
            if (bVar.f1669f) {
                System.arraycopy(iArr, 0, this.f1687b, 0, iArr.length);
                int[] iArr2 = this.f1687b;
                this.f1686a = iArr2;
                iArr2[bVar.f1670h] = 0;
                if (bVar.g == 2 && this.f1694k == 0) {
                    this.f1701s = Boolean.TRUE;
                }
            }
            return j(bVar, bVar2);
        }
        if (Log.isLoggable("e", 3)) {
            Log.d("e", "Unable to decode frame, status=" + this.f1698o);
        }
        return null;
    }

    @Override // U0.a
    public final void clear() {
        this.f1695l = null;
        byte[] bArr = this.f1692i;
        if (bArr != null) {
            ((j1.b) this.f1688c).e(bArr);
        }
        int[] iArr = this.f1693j;
        if (iArr != null) {
            ((j1.b) this.f1688c).f(iArr);
        }
        Bitmap bitmap = this.f1696m;
        if (bitmap != null) {
            ((j1.b) this.f1688c).d(bitmap);
        }
        this.f1696m = null;
        this.d = null;
        this.f1701s = null;
        byte[] bArr2 = this.f1689e;
        if (bArr2 != null) {
            ((j1.b) this.f1688c).e(bArr2);
        }
    }

    @Override // U0.a
    public final void d() {
        this.f1694k = (this.f1694k + 1) % this.f1695l.f1676c;
    }

    @Override // U0.a
    public final int e() {
        return this.f1695l.f1676c;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<U0.b>] */
    @Override // U0.a
    public final int f() {
        int i2;
        c cVar = this.f1695l;
        int i4 = cVar.f1676c;
        if (i4 <= 0 || (i2 = this.f1694k) < 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= i4) {
            return -1;
        }
        return ((b) cVar.f1677e.get(i2)).f1671i;
    }

    @Override // U0.a
    public final ByteBuffer g() {
        return this.d;
    }

    public final void i(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f1702t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }
}
