package k1;

import V0.h;
import Y0.x;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* renamed from: k1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0343c implements d<Drawable, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final Z0.d f6440a;

    /* renamed from: b, reason: collision with root package name */
    private final d<Bitmap, byte[]> f6441b;

    /* renamed from: c, reason: collision with root package name */
    private final d<j1.c, byte[]> f6442c;

    public C0343c(Z0.d dVar, d<Bitmap, byte[]> dVar2, d<j1.c, byte[]> dVar3) {
        this.f6440a = dVar;
        this.f6441b = dVar2;
        this.f6442c = dVar3;
    }

    @Override // k1.d
    public final x<byte[]> d(x<Drawable> xVar, h hVar) {
        Drawable drawable = xVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f6441b.d(f1.d.f(((BitmapDrawable) drawable).getBitmap(), this.f6440a), hVar);
        }
        if (drawable instanceof j1.c) {
            return this.f6442c.d(xVar, hVar);
        }
        return null;
    }
}
