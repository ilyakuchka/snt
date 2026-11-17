package f1;

import Y0.x;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final Z0.d f6203a = new a();

    final class a extends Z0.e {
        a() {
        }

        @Override // Z0.e, Z0.d
        public final void e(Bitmap bitmap) {
        }
    }

    static x<Bitmap> a(Z0.d dVar, Drawable drawable, int i2, int i4) {
        Drawable current = drawable.getCurrent();
        boolean z4 = false;
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            if (i2 != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i4 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i2 = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i4 = current.getIntrinsicHeight();
                    }
                    Lock lockD = t.d();
                    lockD.lock();
                    Bitmap bitmapD = dVar.d(i2, i4, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(bitmapD);
                        current.setBounds(0, 0, i2, i4);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lockD.unlock();
                        bitmap = bitmapD;
                    } catch (Throwable th) {
                        lockD.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
            } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            z4 = true;
        }
        if (!z4) {
            dVar = f6203a;
        }
        return d.f(bitmap, dVar);
    }
}
