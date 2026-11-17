package Z0;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class e implements d {
    @Override // Z0.d
    public final void a(int i2) {
    }

    @Override // Z0.d
    public final void b() {
    }

    @Override // Z0.d
    public final Bitmap c(int i2, int i4, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i4, config);
    }

    @Override // Z0.d
    public final Bitmap d(int i2, int i4, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i4, config);
    }

    @Override // Z0.d
    public void e(Bitmap bitmap) {
        bitmap.recycle();
    }
}
