package f1;

import Y0.x;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.IOException;

/* loaded from: classes.dex */
public final class a implements V0.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6169a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final V0.j f6170b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f6171c;

    public a(h1.d dVar, Z0.d dVar2) {
        this.f6170b = dVar;
        this.f6171c = dVar2;
    }

    @Override // V0.j
    public final boolean a(Object obj, V0.h hVar) {
        switch (this.f6169a) {
            case 0:
                return this.f6170b.a(obj, hVar);
            default:
                return "android.resource".equals(((Uri) obj).getScheme());
        }
    }

    @Override // V0.j
    public final x b(Object obj, int i2, int i4, V0.h hVar) throws PackageManager.NameNotFoundException, IOException, NumberFormatException {
        switch (this.f6169a) {
            case 0:
                return d.e((Resources) this.f6171c, this.f6170b.b(obj, i2, i4, hVar));
            default:
                x<Drawable> xVarB = ((h1.d) this.f6170b).b((Uri) obj, i2, i4, hVar);
                if (xVarB == null) {
                    return null;
                }
                return l.a((Z0.d) this.f6171c, (Drawable) ((h1.b) xVarB).get(), i2, i4);
        }
    }

    public a(Resources resources, V0.j jVar) {
        this.f6171c = resources;
        this.f6170b = jVar;
    }
}
