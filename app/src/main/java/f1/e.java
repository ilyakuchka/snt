package f1;

import Y0.x;
import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: classes.dex */
public abstract class e implements V0.l<Bitmap> {
    @Override // V0.l
    public final x<Bitmap> b(Context context, x<Bitmap> xVar, int i2, int i4) {
        if (!s1.j.i(i2, i4)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i4 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        Z0.d dVarE = com.bumptech.glide.c.c(context).e();
        Bitmap bitmap = xVar.get();
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getWidth();
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(dVarE, bitmap, i2, i4);
        return bitmap.equals(bitmapC) ? xVar : d.f(bitmapC, dVarE);
    }

    protected abstract Bitmap c(Z0.d dVar, Bitmap bitmap, int i2, int i4);
}
