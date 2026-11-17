package f1;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class g extends e {

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f6182b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(V0.f.f1758a);

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f6182b);
    }

    @Override // f1.e
    protected final Bitmap c(Z0.d dVar, Bitmap bitmap, int i2, int i4) {
        return t.b(dVar, bitmap, i2, i4);
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        return obj instanceof g;
    }

    @Override // V0.f
    public final int hashCode() {
        return -599754482;
    }
}
