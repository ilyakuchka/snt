package f1;

import V0.g;
import Y0.x;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Objects;

/* loaded from: classes.dex */
public final class v<T> implements V0.j<T, Bitmap> {
    public static final V0.g<Long> d = V0.g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e, reason: collision with root package name */
    public static final V0.g<Integer> f6232e = V0.g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f, reason: collision with root package name */
    private static final e f6233f = new e();

    /* renamed from: a, reason: collision with root package name */
    private final f<T> f6234a;

    /* renamed from: b, reason: collision with root package name */
    private final Z0.d f6235b;

    /* renamed from: c, reason: collision with root package name */
    private final e f6236c;

    final class a implements g.b<Long> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f6237a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // V0.g.b
        public final void a(byte[] bArr, Long l2, MessageDigest messageDigest) {
            Long l3 = l2;
            messageDigest.update(bArr);
            synchronized (this.f6237a) {
                this.f6237a.position(0);
                messageDigest.update(this.f6237a.putLong(l3.longValue()).array());
            }
        }
    }

    final class b implements g.b<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f6238a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // V0.g.b
        public final void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            Integer num2 = num;
            if (num2 == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f6238a) {
                this.f6238a.position(0);
                messageDigest.update(this.f6238a.putInt(num2.intValue()).array());
            }
        }
    }

    private static final class c implements f<AssetFileDescriptor> {
        c() {
        }

        @Override // f1.v.f
        public final void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    static final class d implements f<ByteBuffer> {
        d() {
        }

        @Override // f1.v.f
        public final void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(new w(byteBuffer));
        }
    }

    static class e {
        e() {
        }
    }

    interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t2);
    }

    static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        @Override // f1.v.f
        public final void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    v(Z0.d dVar, f<T> fVar) {
        e eVar = f6233f;
        this.f6235b = dVar;
        this.f6234a = fVar;
        this.f6236c = eVar;
    }

    public static V0.j<AssetFileDescriptor, Bitmap> c(Z0.d dVar) {
        return new v(dVar, new c());
    }

    public static V0.j<ByteBuffer, Bitmap> d(Z0.d dVar) {
        return new v(dVar, new d());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i4, int i5, j jVar) {
        Bitmap scaledFrameAtTime;
        if (i4 == Integer.MIN_VALUE || i5 == Integer.MIN_VALUE || jVar == j.d) {
            scaledFrameAtTime = null;
        } else {
            try {
                int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int i8 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (i8 == 90 || i8 == 270) {
                    i7 = i6;
                    i6 = i7;
                }
                float fB = jVar.b(i6, i7, i4, i5);
                scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(i6 * fB), Math.round(fB * i7));
            } catch (Throwable th) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
                }
            }
        }
        return scaledFrameAtTime == null ? mediaMetadataRetriever.getFrameAtTime(j2, i2) : scaledFrameAtTime;
    }

    public static V0.j<ParcelFileDescriptor, Bitmap> f(Z0.d dVar) {
        return new v(dVar, new g());
    }

    @Override // V0.j
    public final boolean a(T t2, V0.h hVar) {
        return true;
    }

    @Override // V0.j
    public final x<Bitmap> b(T t2, int i2, int i4, V0.h hVar) throws IOException {
        long jLongValue = ((Long) hVar.c(d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) hVar.c(f6232e);
        if (num == null) {
            num = 2;
        }
        j jVar = (j) hVar.c(j.f6193f);
        if (jVar == null) {
            jVar = j.f6192e;
        }
        j jVar2 = jVar;
        Objects.requireNonNull(this.f6236c);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                this.f6234a.a(mediaMetadataRetriever, t2);
                Bitmap bitmapE = e(mediaMetadataRetriever, jLongValue, num.intValue(), i2, i4, jVar2);
                mediaMetadataRetriever.release();
                return f1.d.f(bitmapE, this.f6235b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }
}
