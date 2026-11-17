package U0;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f1684b;

    /* renamed from: c, reason: collision with root package name */
    private c f1685c;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f1683a = new byte[256];
    private int d = 0;

    private boolean b() {
        return this.f1685c.f1675b != 0;
    }

    private int d() {
        try {
            return this.f1684b.get() & 255;
        } catch (Exception unused) {
            this.f1685c.f1675b = 1;
            return 0;
        }
    }

    private void e() {
        int iD = d();
        this.d = iD;
        if (iD <= 0) {
            return;
        }
        int i2 = 0;
        int i4 = 0;
        while (true) {
            try {
                i4 = this.d;
                if (i2 >= i4) {
                    return;
                }
                i4 -= i2;
                this.f1684b.get(this.f1683a, i2, i4);
                i2 += i4;
            } catch (Exception e2) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i4 + " blockSize: " + this.d, e2);
                }
                this.f1685c.f1675b = 1;
                return;
            }
        }
    }

    private int[] f(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.f1684b.get(bArr);
            iArr = new int[256];
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int i9 = i4 + 1;
                iArr[i4] = ((bArr[i5] & 255) << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
                i5 = i8;
                i4 = i9;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f1685c.f1675b = 1;
        }
        return iArr;
    }

    private int g() {
        return this.f1684b.getShort();
    }

    private void i() {
        int iD;
        do {
            iD = d();
            this.f1684b.position(Math.min(this.f1684b.position() + iD, this.f1684b.limit()));
        } while (iD > 0);
    }

    public final void a() {
        this.f1684b = null;
        this.f1685c = null;
    }

    /* JADX WARN: Type inference failed for: r6v23, types: [java.util.ArrayList, java.util.List<U0.b>] */
    public final c c() {
        if (this.f1684b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f1685c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) d());
        }
        if (sb.toString().startsWith("GIF")) {
            this.f1685c.f1678f = g();
            this.f1685c.g = g();
            int iD = d();
            c cVar = this.f1685c;
            cVar.f1679h = (iD & 128) != 0;
            cVar.f1680i = (int) Math.pow(2.0d, (iD & 7) + 1);
            this.f1685c.f1681j = d();
            c cVar2 = this.f1685c;
            d();
            Objects.requireNonNull(cVar2);
            if (this.f1685c.f1679h && !b()) {
                c cVar3 = this.f1685c;
                cVar3.f1674a = f(cVar3.f1680i);
                c cVar4 = this.f1685c;
                cVar4.f1682k = cVar4.f1674a[cVar4.f1681j];
            }
        } else {
            this.f1685c.f1675b = 1;
        }
        if (!b()) {
            boolean z4 = false;
            while (!z4 && !b() && this.f1685c.f1676c <= Integer.MAX_VALUE) {
                int iD2 = d();
                if (iD2 == 33) {
                    int iD3 = d();
                    if (iD3 == 1) {
                        i();
                    } else if (iD3 == 249) {
                        this.f1685c.d = new b();
                        d();
                        int iD4 = d();
                        b bVar = this.f1685c.d;
                        int i4 = (iD4 & 28) >> 2;
                        bVar.g = i4;
                        if (i4 == 0) {
                            bVar.g = 1;
                        }
                        bVar.f1669f = (iD4 & 1) != 0;
                        int iG = g();
                        if (iG < 2) {
                            iG = 10;
                        }
                        b bVar2 = this.f1685c.d;
                        bVar2.f1671i = iG * 10;
                        bVar2.f1670h = d();
                        d();
                    } else if (iD3 == 254) {
                        i();
                    } else if (iD3 != 255) {
                        i();
                    } else {
                        e();
                        StringBuilder sb2 = new StringBuilder();
                        for (int i5 = 0; i5 < 11; i5++) {
                            sb2.append((char) this.f1683a[i5]);
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                e();
                                byte[] bArr = this.f1683a;
                                if (bArr[0] == 1) {
                                    byte b2 = bArr[1];
                                    byte b4 = bArr[2];
                                    Objects.requireNonNull(this.f1685c);
                                }
                                if (this.d > 0) {
                                }
                            } while (!b());
                        } else {
                            i();
                        }
                    }
                } else if (iD2 == 44) {
                    c cVar5 = this.f1685c;
                    if (cVar5.d == null) {
                        cVar5.d = new b();
                    }
                    cVar5.d.f1665a = g();
                    this.f1685c.d.f1666b = g();
                    this.f1685c.d.f1667c = g();
                    this.f1685c.d.d = g();
                    int iD5 = d();
                    boolean z5 = (iD5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iD5 & 7) + 1);
                    b bVar3 = this.f1685c.d;
                    bVar3.f1668e = (iD5 & 64) != 0;
                    if (z5) {
                        bVar3.f1673k = f(iPow);
                    } else {
                        bVar3.f1673k = null;
                    }
                    this.f1685c.d.f1672j = this.f1684b.position();
                    d();
                    i();
                    if (!b()) {
                        c cVar6 = this.f1685c;
                        cVar6.f1676c++;
                        cVar6.f1677e.add(cVar6.d);
                    }
                } else if (iD2 != 59) {
                    this.f1685c.f1675b = 1;
                } else {
                    z4 = true;
                }
            }
            c cVar7 = this.f1685c;
            if (cVar7.f1676c < 0) {
                cVar7.f1675b = 1;
            }
        }
        return this.f1685c;
    }

    public final d h(ByteBuffer byteBuffer) {
        this.f1684b = null;
        Arrays.fill(this.f1683a, (byte) 0);
        this.f1685c = new c();
        this.d = 0;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f1684b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f1684b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
