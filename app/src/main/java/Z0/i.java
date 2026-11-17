package Z0;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class i implements d {

    /* renamed from: j, reason: collision with root package name */
    private static final Bitmap.Config f2156j = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    private final j f2157a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f2158b;

    /* renamed from: c, reason: collision with root package name */
    private final a f2159c;
    private long d;

    /* renamed from: e, reason: collision with root package name */
    private long f2160e;

    /* renamed from: f, reason: collision with root package name */
    private int f2161f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2162h;

    /* renamed from: i, reason: collision with root package name */
    private int f2163i;

    private static final class a {
        a() {
        }
    }

    public i(long j2) {
        l lVar = new l();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        Set<Bitmap.Config> setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.d = j2;
        this.f2157a = lVar;
        this.f2158b = setUnmodifiableSet;
        this.f2159c = new a();
    }

    private void f() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            g();
        }
    }

    private void g() {
        StringBuilder sbD = D2.e.d("Hits=");
        sbD.append(this.f2161f);
        sbD.append(", misses=");
        sbD.append(this.g);
        sbD.append(", puts=");
        sbD.append(this.f2162h);
        sbD.append(", evictions=");
        sbD.append(this.f2163i);
        sbD.append(", currentSize=");
        sbD.append(this.f2160e);
        sbD.append(", maxSize=");
        sbD.append(this.d);
        sbD.append("\nStrategy=");
        sbD.append(this.f2157a);
        Log.v("LruBitmapPool", sbD.toString());
    }

    private synchronized Bitmap h(int i2, int i4, Bitmap.Config config) {
        Bitmap bitmapB;
        if (config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
        bitmapB = ((l) this.f2157a).b(i2, i4, config != null ? config : f2156j);
        if (bitmapB == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing bitmap=");
                Objects.requireNonNull((l) this.f2157a);
                sb.append(l.c(s1.j.c(i2, i4, config), config));
                Log.d("LruBitmapPool", sb.toString());
            }
            this.g++;
        } else {
            this.f2161f++;
            long j2 = this.f2160e;
            Objects.requireNonNull((l) this.f2157a);
            this.f2160e = j2 - s1.j.d(bitmapB);
            Objects.requireNonNull(this.f2159c);
            bitmapB.setHasAlpha(true);
            bitmapB.setPremultiplied(true);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get bitmap=");
            Objects.requireNonNull((l) this.f2157a);
            sb2.append(l.c(s1.j.c(i2, i4, config), config));
            Log.v("LruBitmapPool", sb2.toString());
        }
        f();
        return bitmapB;
    }

    private synchronized void i(long j2) {
        while (this.f2160e > j2) {
            Bitmap bitmapG = ((l) this.f2157a).g();
            if (bitmapG == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    g();
                }
                this.f2160e = 0L;
                return;
            }
            Objects.requireNonNull(this.f2159c);
            long j4 = this.f2160e;
            Objects.requireNonNull((l) this.f2157a);
            this.f2160e = j4 - s1.j.d(bitmapG);
            this.f2163i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + ((l) this.f2157a).e(bitmapG));
            }
            f();
            bitmapG.recycle();
        }
    }

    @Override // Z0.d
    @SuppressLint({"InlinedApi"})
    public final void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40 || i2 >= 20) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "clearMemory");
            }
            i(0L);
        } else if (i2 >= 20 || i2 == 15) {
            i(this.d / 2);
        }
    }

    @Override // Z0.d
    public final void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        i(0L);
    }

    @Override // Z0.d
    public final Bitmap c(int i2, int i4, Bitmap.Config config) {
        Bitmap bitmapH = h(i2, i4, config);
        if (bitmapH != null) {
            return bitmapH;
        }
        if (config == null) {
            config = f2156j;
        }
        return Bitmap.createBitmap(i2, i4, config);
    }

    @Override // Z0.d
    public final Bitmap d(int i2, int i4, Bitmap.Config config) {
        Bitmap bitmapH = h(i2, i4, config);
        if (bitmapH != null) {
            bitmapH.eraseColor(0);
            return bitmapH;
        }
        if (config == null) {
            config = f2156j;
        }
        return Bitmap.createBitmap(i2, i4, config);
    }

    @Override // Z0.d
    public final synchronized void e(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        }
        if (bitmap.isMutable()) {
            Objects.requireNonNull((l) this.f2157a);
            if (s1.j.d(bitmap) <= this.d && this.f2158b.contains(bitmap.getConfig())) {
                Objects.requireNonNull((l) this.f2157a);
                int iD = s1.j.d(bitmap);
                ((l) this.f2157a).f(bitmap);
                Objects.requireNonNull(this.f2159c);
                this.f2162h++;
                this.f2160e += iD;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + ((l) this.f2157a).e(bitmap));
                }
                f();
                i(this.d);
                return;
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + ((l) this.f2157a).e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f2158b.contains(bitmap.getConfig()));
        }
        bitmap.recycle();
    }
}
