package j1;

import V0.j;
import Y0.x;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/* loaded from: classes.dex */
public final class a implements j<ByteBuffer, c> {

    /* renamed from: f, reason: collision with root package name */
    private static final C0114a f6362f = new C0114a();
    private static final b g = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Context f6363a;

    /* renamed from: b, reason: collision with root package name */
    private final List<ImageHeaderParser> f6364b;

    /* renamed from: c, reason: collision with root package name */
    private final b f6365c;
    private final C0114a d;

    /* renamed from: e, reason: collision with root package name */
    private final j1.b f6366e;

    /* renamed from: j1.a$a, reason: collision with other inner class name */
    static class C0114a {
        C0114a() {
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<U0.d> f6367a;

        b() {
            int i2 = s1.j.f7867c;
            this.f6367a = new ArrayDeque(0);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayDeque, java.util.Queue<U0.d>] */
        final synchronized U0.d a(ByteBuffer byteBuffer) {
            U0.d dVar;
            dVar = (U0.d) this.f6367a.poll();
            if (dVar == null) {
                dVar = new U0.d();
            }
            dVar.h(byteBuffer);
            return dVar;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayDeque, java.util.Queue<U0.d>] */
        final synchronized void b(U0.d dVar) {
            dVar.a();
            this.f6367a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, Z0.d dVar, Z0.b bVar) {
        b bVar2 = g;
        C0114a c0114a = f6362f;
        this.f6363a = context.getApplicationContext();
        this.f6364b = list;
        this.d = c0114a;
        this.f6366e = new j1.b(dVar, bVar);
        this.f6365c = bVar2;
    }

    private d c(ByteBuffer byteBuffer, int i2, int i4, U0.d dVar, V0.h hVar) {
        int i5 = s1.f.f7857b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            U0.c cVarC = dVar.c();
            if (cVarC.b() > 0 && cVarC.c() == 0) {
                Bitmap.Config config = hVar.c(h.f6401a) == V0.b.f1753j ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int iD = d(cVarC, i2, i4);
                C0114a c0114a = this.d;
                j1.b bVar = this.f6366e;
                Objects.requireNonNull(c0114a);
                U0.e eVar = new U0.e(bVar, cVarC, byteBuffer, iD);
                eVar.i(config);
                eVar.d();
                Bitmap bitmapC = eVar.c();
                if (bitmapC == null) {
                    return null;
                }
                d dVar2 = new d(new c(this.f6363a, eVar, e1.b.c(), i2, i4, bitmapC));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    StringBuilder sbD = D2.e.d("Decoded GIF from stream in ");
                    sbD.append(s1.f.a(jElapsedRealtimeNanos));
                    Log.v("BufferGifDecoder", sbD.toString());
                }
                return dVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                StringBuilder sbD2 = D2.e.d("Decoded GIF from stream in ");
                sbD2.append(s1.f.a(jElapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sbD2.toString());
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                StringBuilder sbD3 = D2.e.d("Decoded GIF from stream in ");
                sbD3.append(s1.f.a(jElapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sbD3.toString());
            }
        }
    }

    private static int d(U0.c cVar, int i2, int i4) {
        int iMin = Math.min(cVar.a() / i4, cVar.d() / i2);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i2 + "x" + i4 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return iMax;
    }

    @Override // V0.j
    public final boolean a(ByteBuffer byteBuffer, V0.h hVar) throws IOException {
        ImageHeaderParser.ImageType imageType;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (((Boolean) hVar.c(h.f6402b)).booleanValue()) {
            return false;
        }
        List<ImageHeaderParser> list = this.f6364b;
        if (byteBuffer2 == null) {
            imageType = ImageHeaderParser.ImageType.UNKNOWN;
        } else {
            int size = list.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    imageType = ImageHeaderParser.ImageType.UNKNOWN;
                    break;
                }
                ImageHeaderParser.ImageType imageTypeA = list.get(i2).a(byteBuffer2);
                if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                    imageType = imageTypeA;
                    break;
                }
                i2++;
            }
        }
        return imageType == ImageHeaderParser.ImageType.GIF;
    }

    @Override // V0.j
    public final x<c> b(ByteBuffer byteBuffer, int i2, int i4, V0.h hVar) throws IOException {
        ByteBuffer byteBuffer2 = byteBuffer;
        U0.d dVarA = this.f6365c.a(byteBuffer2);
        try {
            return c(byteBuffer2, i2, i4, dVarA, hVar);
        } finally {
            this.f6365c.b(dVarA);
        }
    }
}
