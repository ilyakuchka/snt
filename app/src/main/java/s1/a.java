package s1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<byte[]> f7841a = new AtomicReference<>();

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f7844a;

        /* renamed from: b, reason: collision with root package name */
        final int f7845b;

        /* renamed from: c, reason: collision with root package name */
        final byte[] f7846c;

        b(byte[] bArr, int i2, int i4) {
            this.f7846c = bArr;
            this.f7844a = i2;
            this.f7845b = i4;
        }
    }

    public static ByteBuffer a(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
                MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return mappedByteBufferLoad;
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static byte[] b(ByteBuffer byteBuffer) {
        b bVar = (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) ? null : new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        if (bVar != null && bVar.f7844a == 0 && bVar.f7845b == bVar.f7846c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void c(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static InputStream d(ByteBuffer byteBuffer) {
        return new C0137a(byteBuffer);
    }

    /* renamed from: s1.a$a, reason: collision with other inner class name */
    private static class C0137a extends InputStream {

        /* renamed from: i, reason: collision with root package name */
        private final ByteBuffer f7842i;

        /* renamed from: j, reason: collision with root package name */
        private int f7843j = -1;

        C0137a(ByteBuffer byteBuffer) {
            this.f7842i = byteBuffer;
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.f7842i.remaining();
        }

        @Override // java.io.InputStream
        public final synchronized void mark(int i2) {
            this.f7843j = this.f7842i.position();
        }

        @Override // java.io.InputStream
        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public final int read() {
            if (this.f7842i.hasRemaining()) {
                return this.f7842i.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() throws IOException {
            int i2 = this.f7843j;
            if (i2 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f7842i.position(i2);
        }

        @Override // java.io.InputStream
        public final long skip(long j2) throws IOException {
            if (!this.f7842i.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j2, available());
            this.f7842i.position((int) (r2.position() + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i4) throws IOException {
            if (!this.f7842i.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i4, available());
            this.f7842i.get(bArr, i2, iMin);
            return iMin;
        }
    }
}
