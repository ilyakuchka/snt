package s1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class h extends FilterInputStream {

    /* renamed from: i, reason: collision with root package name */
    private int f7861i;

    public h(InputStream inputStream) {
        super(inputStream);
        this.f7861i = Integer.MIN_VALUE;
    }

    private void H(long j2) {
        int i2 = this.f7861i;
        if (i2 == Integer.MIN_VALUE || j2 == -1) {
            return;
        }
        this.f7861i = (int) (i2 - j2);
    }

    private long f(long j2) {
        int i2 = this.f7861i;
        if (i2 == 0) {
            return -1L;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        int i2 = this.f7861i;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
        super.mark(i2);
        this.f7861i = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (f(1L) == -1) {
            return -1;
        }
        int i2 = super.read();
        H(1L);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        super.reset();
        this.f7861i = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long jF = f(j2);
        if (jF == -1) {
            return 0L;
        }
        long jSkip = super.skip(jF);
        H(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i4) throws IOException {
        int iF = (int) f(i4);
        if (iF == -1) {
            return -1;
        }
        int i5 = super.read(bArr, i2, iF);
        H(i5);
        return i5;
    }
}
