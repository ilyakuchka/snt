package f1;

import Y0.x;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d implements x, Y0.t {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6177i = 1;

    /* renamed from: j, reason: collision with root package name */
    private final Object f6178j;

    /* renamed from: k, reason: collision with root package name */
    private final Object f6179k;

    public d(Bitmap bitmap, Z0.d dVar) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        this.f6178j = bitmap;
        Objects.requireNonNull(dVar, "BitmapPool must not be null");
        this.f6179k = dVar;
    }

    public static x e(Resources resources, x xVar) {
        if (xVar == null) {
            return null;
        }
        return new d(resources, xVar);
    }

    public static d f(Bitmap bitmap, Z0.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, dVar);
    }

    @Override // Y0.t
    public final void a() {
        switch (this.f6177i) {
            case 0:
                ((Bitmap) this.f6178j).prepareToDraw();
                break;
            default:
                x xVar = (x) this.f6179k;
                if (xVar instanceof Y0.t) {
                    ((Y0.t) xVar).a();
                    break;
                }
                break;
        }
    }

    @Override // Y0.x
    public final int b() {
        switch (this.f6177i) {
            case 0:
                return s1.j.d((Bitmap) this.f6178j);
            default:
                return ((x) this.f6179k).b();
        }
    }

    @Override // Y0.x
    public final Class c() {
        switch (this.f6177i) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // Y0.x
    public final void d() {
        switch (this.f6177i) {
            case 0:
                ((Z0.d) this.f6179k).e((Bitmap) this.f6178j);
                break;
            default:
                ((x) this.f6179k).d();
                break;
        }
    }

    @Override // Y0.x
    public final Object get() {
        switch (this.f6177i) {
            case 0:
                return (Bitmap) this.f6178j;
            default:
                return new BitmapDrawable((Resources) this.f6178j, (Bitmap) ((x) this.f6179k).get());
        }
    }

    public d(Resources resources, x xVar) {
        Objects.requireNonNull(resources, "Argument must not be null");
        this.f6178j = resources;
        Objects.requireNonNull(xVar, "Argument must not be null");
        this.f6179k = xVar;
    }
}
