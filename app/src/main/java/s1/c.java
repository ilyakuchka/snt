package s1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* renamed from: i, reason: collision with root package name */
    private final long f7848i;

    /* renamed from: j, reason: collision with root package name */
    private int f7849j;

    private c(InputStream inputStream, long j2) {
        super(inputStream);
        this.f7848i = j2;
    }

    public static InputStream H(InputStream inputStream, long j2) {
        return new c(inputStream, j2);
    }

    private int f(int i2) throws IOException {
        if (i2 >= 0) {
            this.f7849j += i2;
        } else if (this.f7848i - this.f7849j > 0) {
            StringBuilder sbD = D2.e.d("Failed to read all expected data, expected: ");
            sbD.append(this.f7848i);
            sbD.append(", but read: ");
            sbD.append(this.f7849j);
            throw new IOException(sbD.toString());
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() throws IOException {
        return (int) Math.max(this.f7848i - this.f7849j, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() throws IOException {
        int i2;
        i2 = super.read();
        f(i2 >= 0 ? 1 : -1);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i4) throws IOException {
        int i5;
        i5 = super.read(bArr, i2, i4);
        f(i5);
        return i5;
    }
}
