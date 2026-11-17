package f1;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class o extends e {

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f6206b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(V0.f.f1758a);

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f6206b);
    }

    @Override // f1.e
    protected final Bitmap c(Z0.d dVar, Bitmap bitmap, int i2, int i4) {
        return t.c(dVar, bitmap, i2, i4);
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        return obj instanceof o;
    }

    @Override // V0.f
    public final int hashCode() {
        return 1572326941;
    }
}
