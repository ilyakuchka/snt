package f1;

import Y0.x;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.File;

/* renamed from: f1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0304b implements V0.k<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final Z0.d f6172a;

    /* renamed from: b, reason: collision with root package name */
    private final V0.k<Bitmap> f6173b;

    public C0304b(Z0.d dVar, V0.k<Bitmap> kVar) {
        this.f6172a = dVar;
        this.f6173b = kVar;
    }

    @Override // V0.k
    public final V0.c a(V0.h hVar) {
        return this.f6173b.a(hVar);
    }

    @Override // V0.d
    public final boolean b(Object obj, File file, V0.h hVar) {
        return this.f6173b.b(new d(((BitmapDrawable) ((x) obj).get()).getBitmap(), this.f6172a), file, hVar);
    }
}
