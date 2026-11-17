package f1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class r extends FilterInputStream {

    /* renamed from: i, reason: collision with root package name */
    private volatile byte[] f6218i;

    /* renamed from: j, reason: collision with root package name */
    private int f6219j;

    /* renamed from: k, reason: collision with root package name */
    private int f6220k;

    /* renamed from: l, reason: collision with root package name */
    private int f6221l;

    /* renamed from: m, reason: collision with root package name */
    private int f6222m;

    /* renamed from: n, reason: collision with root package name */
    private final Z0.b f6223n;

    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    public r(InputStream inputStream, Z0.b bVar) {
        super(inputStream);
        this.f6221l = -1;
        this.f6223n = bVar;
        this.f6218i = (byte[]) bVar.d(65536, byte[].class);
    }

    private static IOException e0() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    private int f(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f6221l;
        if (i2 != -1) {
            int i4 = this.f6222m - i2;
            int i5 = this.f6220k;
            if (i4 < i5) {
                if (i2 == 0 && i5 > bArr.length && this.f6219j == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i5) {
                        i5 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f6223n.d(i5, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f6218i = bArr2;
                    this.f6223n.c(bArr);
                    bArr = bArr2;
                } else if (i2 > 0) {
                    System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
                }
                int i6 = this.f6222m - this.f6221l;
                this.f6222m = i6;
                this.f6221l = 0;
                this.f6219j = 0;
                int i7 = inputStream.read(bArr, i6, bArr.length - i6);
                int i8 = this.f6222m;
                if (i7 > 0) {
                    i8 += i7;
                }
                this.f6219j = i8;
                return i7;
            }
        }
        int i9 = inputStream.read(bArr);
        if (i9 > 0) {
            this.f6221l = -1;
            this.f6222m = 0;
            this.f6219j = i9;
        }
        return i9;
    }

    public final synchronized void H() {
        this.f6220k = this.f6218i.length;
    }

    public final synchronized void I() {
        if (this.f6218i != null) {
            this.f6223n.c(this.f6218i);
            this.f6218i = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f6218i == null || inputStream == null) {
            e0();
            throw null;
        }
        return (this.f6219j - this.f6222m) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f6218i != null) {
            this.f6223n.c(this.f6218i);
            this.f6218i = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
        this.f6220k = Math.max(this.f6220k, i2);
        this.f6221l = this.f6222m;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() throws IOException {
        byte[] bArr = this.f6218i;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            e0();
            throw null;
        }
        if (this.f6222m >= this.f6219j && f(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f6218i && (bArr = this.f6218i) == null) {
            e0();
            throw null;
        }
        int i2 = this.f6219j;
        int i4 = this.f6222m;
        if (i2 - i4 <= 0) {
            return -1;
        }
        this.f6222m = i4 + 1;
        return bArr[i4] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (this.f6218i == null) {
            throw new IOException("Stream is closed");
        }
        int i2 = this.f6221l;
        if (-1 == i2) {
            throw new a("Mark has been invalidated, pos: " + this.f6222m + " markLimit: " + this.f6220k);
        }
        this.f6222m = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.f6218i;
        if (bArr == null) {
            e0();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            e0();
            throw null;
        }
        int i2 = this.f6219j;
        int i4 = this.f6222m;
        if (i2 - i4 >= j2) {
            this.f6222m = (int) (i4 + j2);
            return j2;
        }
        long j4 = i2 - i4;
        this.f6222m = i2;
        if (this.f6221l == -1 || j2 > this.f6220k) {
            return j4 + inputStream.skip(j2 - j4);
        }
        if (f(inputStream, bArr) == -1) {
            return j4;
        }
        int i5 = this.f6219j;
        int i6 = this.f6222m;
        if (i5 - i6 >= j2 - j4) {
            this.f6222m = (int) ((i6 + j2) - j4);
            return j2;
        }
        long j5 = (j4 + i5) - i6;
        this.f6222m = i5;
        return j5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i4) throws IOException {
        int i5;
        int i6;
        byte[] bArr2 = this.f6218i;
        if (bArr2 == null) {
            e0();
            throw null;
        }
        if (i4 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i7 = this.f6222m;
            int i8 = this.f6219j;
            if (i7 < i8) {
                int i9 = i8 - i7 >= i4 ? i4 : i8 - i7;
                System.arraycopy(bArr2, i7, bArr, i2, i9);
                this.f6222m += i9;
                if (i9 == i4 || inputStream.available() == 0) {
                    return i9;
                }
                i2 += i9;
                i5 = i4 - i9;
            } else {
                i5 = i4;
            }
            while (true) {
                if (this.f6221l == -1 && i5 >= bArr2.length) {
                    i6 = inputStream.read(bArr, i2, i5);
                    if (i6 == -1) {
                        return i5 != i4 ? i4 - i5 : -1;
                    }
                } else {
                    if (f(inputStream, bArr2) == -1) {
                        return i5 != i4 ? i4 - i5 : -1;
                    }
                    if (bArr2 != this.f6218i && (bArr2 = this.f6218i) == null) {
                        e0();
                        throw null;
                    }
                    int i10 = this.f6219j;
                    int i11 = this.f6222m;
                    i6 = i10 - i11 >= i5 ? i5 : i10 - i11;
                    System.arraycopy(bArr2, i11, bArr, i2, i6);
                    this.f6222m += i6;
                }
                i5 -= i6;
                if (i5 == 0) {
                    return i4;
                }
                if (inputStream.available() == 0) {
                    return i4 - i5;
                }
                i2 += i6;
            }
        } else {
            e0();
            throw null;
        }
    }
}
