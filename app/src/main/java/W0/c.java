package W0;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: i, reason: collision with root package name */
    private final OutputStream f1791i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f1792j;

    /* renamed from: k, reason: collision with root package name */
    private Z0.b f1793k;

    /* renamed from: l, reason: collision with root package name */
    private int f1794l;

    public c(OutputStream outputStream, Z0.b bVar) {
        this.f1791i = outputStream;
        this.f1793k = bVar;
        this.f1792j = (byte[]) bVar.d(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            flush();
            this.f1791i.close();
            byte[] bArr = this.f1792j;
            if (bArr != null) {
                this.f1793k.c(bArr);
                this.f1792j = null;
            }
        } catch (Throwable th) {
            this.f1791i.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        int i2 = this.f1794l;
        if (i2 > 0) {
            this.f1791i.write(this.f1792j, 0, i2);
            this.f1794l = 0;
        }
        this.f1791i.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        byte[] bArr = this.f1792j;
        int i4 = this.f1794l;
        int i5 = i4 + 1;
        this.f1794l = i5;
        bArr[i4] = (byte) i2;
        if (i5 != bArr.length || i5 <= 0) {
            return;
        }
        this.f1791i.write(bArr, 0, i5);
        this.f1794l = 0;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i4) throws IOException {
        int i5 = 0;
        do {
            int i6 = i4 - i5;
            int i7 = i2 + i5;
            int i8 = this.f1794l;
            if (i8 == 0 && i6 >= this.f1792j.length) {
                this.f1791i.write(bArr, i7, i6);
                return;
            }
            int iMin = Math.min(i6, this.f1792j.length - i8);
            System.arraycopy(bArr, i7, this.f1792j, this.f1794l, iMin);
            int i9 = this.f1794l + iMin;
            this.f1794l = i9;
            i5 += iMin;
            byte[] bArr2 = this.f1792j;
            if (i9 == bArr2.length && i9 > 0) {
                this.f1791i.write(bArr2, 0, i9);
                this.f1794l = 0;
            }
        } while (i5 < i4);
    }
}
