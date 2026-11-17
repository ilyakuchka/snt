package W0;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* renamed from: k, reason: collision with root package name */
    private static final byte[] f1798k = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: l, reason: collision with root package name */
    private static final int f1799l = 31;

    /* renamed from: i, reason: collision with root package name */
    private final byte f1800i;

    /* renamed from: j, reason: collision with root package name */
    private int f1801j;

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException(D2.e.b("Cannot add invalid orientation: ", i2));
        }
        this.f1800i = (byte) i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i2;
        int i4 = this.f1801j;
        int i5 = (i4 < 2 || i4 > (i2 = f1799l)) ? super.read() : i4 == i2 ? this.f1800i : f1798k[i4 - 2] & 255;
        if (i5 != -1) {
            this.f1801j++;
        }
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long jSkip = super.skip(j2);
        if (jSkip > 0) {
            this.f1801j = (int) (this.f1801j + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i4) throws IOException {
        int i5;
        int i6 = this.f1801j;
        int i7 = f1799l;
        if (i6 > i7) {
            i5 = super.read(bArr, i2, i4);
        } else if (i6 == i7) {
            bArr[i2] = this.f1800i;
            i5 = 1;
        } else if (i6 < 2) {
            i5 = super.read(bArr, i2, 2 - i6);
        } else {
            int iMin = Math.min(i7 - i6, i4);
            System.arraycopy(f1798k, this.f1801j - 2, bArr, i2, iMin);
            i5 = iMin;
        }
        if (i5 > 0) {
            this.f1801j += i5;
        }
        return i5;
    }
}
