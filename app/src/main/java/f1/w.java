package f1;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class w extends MediaDataSource {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ ByteBuffer f6239i;

    w(ByteBuffer byteBuffer) {
        this.f6239i = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f6239i.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j2, byte[] bArr, int i2, int i4) {
        if (j2 >= this.f6239i.limit()) {
            return -1;
        }
        this.f6239i.position((int) j2);
        int iMin = Math.min(i4, this.f6239i.remaining());
        this.f6239i.get(bArr, i2, iMin);
        return iMin;
    }
}
