package h1;

import Y0.x;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    static x<Drawable> e(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    @Override // Y0.x
    public final int b() {
        return Math.max(1, this.f6322i.getIntrinsicHeight() * this.f6322i.getIntrinsicWidth() * 4);
    }

    @Override // Y0.x
    public final Class<Drawable> c() {
        return this.f6322i.getClass();
    }

    @Override // Y0.x
    public final void d() {
    }
}
