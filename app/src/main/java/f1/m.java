package f1;

import Y0.x;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class m implements V0.l<Drawable> {

    /* renamed from: b, reason: collision with root package name */
    private final V0.l<Bitmap> f6204b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6205c;

    public m(V0.l<Bitmap> lVar, boolean z4) {
        this.f6204b = lVar;
        this.f6205c = z4;
    }

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        this.f6204b.a(messageDigest);
    }

    @Override // V0.l
    public final x<Drawable> b(Context context, x<Drawable> xVar, int i2, int i4) {
        Z0.d dVarE = com.bumptech.glide.c.c(context).e();
        Drawable drawable = xVar.get();
        x<Bitmap> xVarA = l.a(dVarE, drawable, i2, i4);
        if (xVarA != null) {
            x<Bitmap> xVarB = this.f6204b.b(context, xVarA, i2, i4);
            if (!xVarB.equals(xVarA)) {
                return d.e(context.getResources(), xVarB);
            }
            xVarB.d();
            return xVar;
        }
        if (!this.f6205c) {
            return xVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f6204b.equals(((m) obj).f6204b);
        }
        return false;
    }

    @Override // V0.f
    public final int hashCode() {
        return this.f6204b.hashCode();
    }
}
