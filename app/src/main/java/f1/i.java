package f1;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes.dex */
public final class i implements ImageHeaderParser {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f6184a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f6185b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f6186a;

        a(ByteBuffer byteBuffer) {
            this.f6186a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // f1.i.c
        public final long a(long j2) {
            int iMin = (int) Math.min(this.f6186a.remaining(), j2);
            ByteBuffer byteBuffer = this.f6186a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }

        @Override // f1.i.c
        public final int b() throws c.a {
            return c() | (c() << 8);
        }

        @Override // f1.i.c
        public final short c() throws c.a {
            if (this.f6186a.remaining() >= 1) {
                return (short) (this.f6186a.get() & 255);
            }
            throw new c.a();
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f6187a;

        b(byte[] bArr, int i2) {
            this.f6187a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        final short a(int i2) {
            if (this.f6187a.remaining() - i2 >= 2) {
                return this.f6187a.getShort(i2);
            }
            return (short) -1;
        }

        final int b(int i2) {
            if (this.f6187a.remaining() - i2 >= 4) {
                return this.f6187a.getInt(i2);
            }
            return -1;
        }

        final int c() {
            return this.f6187a.remaining();
        }

        final void d(ByteOrder byteOrder) {
            this.f6187a.order(byteOrder);
        }
    }

    private interface c {

        public static final class a extends IOException {
            a() {
                super("Unexpectedly reached end of a file");
            }
        }

        long a(long j2) throws IOException;

        int b() throws IOException;

        short c() throws IOException;
    }

    private static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f6188a;

        d(InputStream inputStream) {
            this.f6188a = inputStream;
        }

        @Override // f1.i.c
        public final long a(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j4 = j2;
            while (j4 > 0) {
                long jSkip = this.f6188a.skip(j4);
                if (jSkip <= 0) {
                    if (this.f6188a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j4 -= jSkip;
            }
            return j2 - j4;
        }

        @Override // f1.i.c
        public final int b() throws IOException {
            return c() | (c() << 8);
        }

        @Override // f1.i.c
        public final short c() throws IOException {
            int i2 = this.f6188a.read();
            if (i2 != -1) {
                return (short) i2;
            }
            throw new c.a();
        }

        public final int d(byte[] bArr, int i2) throws IOException {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2 && (i5 = this.f6188a.read(bArr, i4, i2 - i4)) != -1) {
                i4 += i5;
            }
            if (i4 == 0 && i5 == -1) {
                throw new c.a();
            }
            return i4;
        }
    }

    private ImageHeaderParser.ImageType d(c cVar) throws IOException {
        try {
            int iB = cVar.b();
            if (iB == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iC = (iB << 8) | cVar.c();
            if (iC == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iC2 = (iC << 8) | cVar.c();
            if (iC2 == -1991225785) {
                cVar.a(21L);
                try {
                    return cVar.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iC2 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.a(4L);
            if (((cVar.b() << 16) | cVar.b()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iB2 = (cVar.b() << 16) | cVar.b();
            if ((iB2 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = iB2 & 255;
            if (i2 == 88) {
                cVar.a(4L);
                return (cVar.c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i2 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            }
            cVar.a(4L);
            return (cVar.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private int e(c cVar) throws IOException {
        short sC;
        int iB;
        long j2;
        long jA;
        do {
            d dVar = (d) cVar;
            short sC2 = dVar.c();
            if (sC2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sC2));
                }
                return -1;
            }
            sC = dVar.c();
            if (sC == 218) {
                return -1;
            }
            if (sC == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iB = dVar.b() - 2;
            if (sC == 225) {
                return iB;
            }
            j2 = iB;
            jA = dVar.a(j2);
        } while (jA == j2);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sC) + ", wanted to skip: " + iB + ", but actually skipped: " + jA);
        }
        return -1;
    }

    private int f(c cVar, byte[] bArr, int i2) throws IOException {
        ByteOrder byteOrder;
        int iD = ((d) cVar).d(bArr, i2);
        if (iD != i2) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i2 + ", actually read: " + iD);
            }
            return -1;
        }
        boolean z4 = bArr != null && i2 > f6184a.length;
        if (z4) {
            int i4 = 0;
            while (true) {
                byte[] bArr2 = f6184a;
                if (i4 >= bArr2.length) {
                    break;
                }
                if (bArr[i4] != bArr2[i4]) {
                    z4 = false;
                    break;
                }
                i4++;
            }
        }
        if (!z4) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        b bVar = new b(bArr, i2);
        short sA = bVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.d(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i5 = 0; i5 < sA2; i5++) {
            int i6 = (i5 * 12) + iB + 2;
            short sA3 = bVar.a(i6);
            if (sA3 == 274) {
                short sA4 = bVar.a(i6 + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(i6 + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i5 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i7 = iB2 + f6185b[sA4];
                        if (i7 <= 4) {
                            int i8 = i6 + 8;
                            if (i8 >= 0 && i8 <= bVar.c()) {
                                if (i7 >= 0 && i7 + i8 <= bVar.c()) {
                                    return bVar.a(i8);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i8 + " tagType=" + ((int) sA3));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sA4));
                }
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) throws IOException {
        Objects.requireNonNull(byteBuffer, "Argument must not be null");
        return d(new a(byteBuffer));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final int b(InputStream inputStream, Z0.b bVar) throws IOException {
        Objects.requireNonNull(inputStream, "Argument must not be null");
        d dVar = new d(inputStream);
        Objects.requireNonNull(bVar, "Argument must not be null");
        try {
            int iB = dVar.b();
            if (!((iB & 65496) == 65496 || iB == 19789 || iB == 18761)) {
                if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
                    return -1;
                }
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iB);
                return -1;
            }
            int iE = e(dVar);
            if (iE == -1) {
                if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
                    return -1;
                }
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                return -1;
            }
            byte[] bArr = (byte[]) bVar.d(iE, byte[].class);
            try {
                int iF = f(dVar, bArr, iE);
                bVar.c(bArr);
                return iF;
            } catch (Throwable th) {
                bVar.c(bArr);
                throw th;
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType c(InputStream inputStream) throws IOException {
        Objects.requireNonNull(inputStream, "Argument must not be null");
        return d(new d(inputStream));
    }
}
