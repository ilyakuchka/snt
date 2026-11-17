package f1;

import android.graphics.Bitmap;
import android.util.Log;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class h extends e {

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f6183b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(V0.f.f1758a);

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f6183b);
    }

    @Override // f1.e
    protected final Bitmap c(Z0.d dVar, Bitmap bitmap, int i2, int i4) {
        int i5 = t.d;
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i4) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return t.c(dVar, bitmap, i2, i4);
        }
        if (!Log.isLoggable("TransformationUtils", 2)) {
            return bitmap;
        }
        Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        return bitmap;
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // V0.f
    public final int hashCode() {
        return -670243078;
    }
}
