package j1;

import V0.l;
import Y0.x;
import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;
import java.util.Objects;

/* loaded from: classes.dex */
public final class e implements l<c> {

    /* renamed from: b, reason: collision with root package name */
    private final l<Bitmap> f6380b;

    public e(l<Bitmap> lVar) {
        Objects.requireNonNull(lVar, "Argument must not be null");
        this.f6380b = lVar;
    }

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        this.f6380b.a(messageDigest);
    }

    @Override // V0.l
    public final x<c> b(Context context, x<c> xVar, int i2, int i4) {
        c cVar = xVar.get();
        x<Bitmap> dVar = new f1.d(cVar.c(), com.bumptech.glide.c.c(context).e());
        x<Bitmap> xVarB = this.f6380b.b(context, dVar, i2, i4);
        if (!dVar.equals(xVarB)) {
            dVar.d();
        }
        cVar.g(this.f6380b, xVarB.get());
        return xVar;
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f6380b.equals(((e) obj).f6380b);
        }
        return false;
    }

    @Override // V0.f
    public final int hashCode() {
        return this.f6380b.hashCode();
    }
}
