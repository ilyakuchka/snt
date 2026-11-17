package T0;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
final class b implements Closeable {

    /* renamed from: i, reason: collision with root package name */
    private final InputStream f1549i;

    /* renamed from: j, reason: collision with root package name */
    private final Charset f1550j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f1551k;

    /* renamed from: l, reason: collision with root package name */
    private int f1552l;

    /* renamed from: m, reason: collision with root package name */
    private int f1553m;

    final class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0 && ((ByteArrayOutputStream) this).buf[i2 - 1] == 13) {
                i2--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, b.this.f1550j.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        if (charset == null) {
            throw null;
        }
        if (!charset.equals(c.f1555a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f1549i = inputStream;
        this.f1550j = charset;
        this.f1551k = new byte[8192];
    }

    private void H() throws IOException {
        InputStream inputStream = this.f1549i;
        byte[] bArr = this.f1551k;
        int i2 = inputStream.read(bArr, 0, bArr.length);
        if (i2 == -1) {
            throw new EOFException();
        }
        this.f1552l = 0;
        this.f1553m = i2;
    }

    public final boolean I() {
        return this.f1553m == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f1549i) {
            if (this.f1551k != null) {
                this.f1551k = null;
                this.f1549i.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String e0() throws IOException {
        int i2;
        byte[] bArr;
        int i4;
        synchronized (this.f1549i) {
            if (this.f1551k == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f1552l >= this.f1553m) {
                H();
            }
            for (int i5 = this.f1552l; i5 != this.f1553m; i5++) {
                byte[] bArr2 = this.f1551k;
                if (bArr2[i5] == 10) {
                    int i6 = this.f1552l;
                    if (i5 != i6) {
                        i4 = i5 - 1;
                        if (bArr2[i4] != 13) {
                            i4 = i5;
                        }
                    }
                    String str = new String(bArr2, i6, i4 - i6, this.f1550j.name());
                    this.f1552l = i5 + 1;
                    return str;
                }
            }
            a aVar = new a((this.f1553m - this.f1552l) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.f1551k;
                int i7 = this.f1552l;
                aVar.write(bArr3, i7, this.f1553m - i7);
                this.f1553m = -1;
                H();
                i2 = this.f1552l;
                while (i2 != this.f1553m) {
                    bArr = this.f1551k;
                    if (bArr[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            int i8 = this.f1552l;
            if (i2 != i8) {
                aVar.write(bArr, i8, i2 - i8);
            }
            this.f1552l = i2 + 1;
            return aVar.toString();
        }
    }
}
