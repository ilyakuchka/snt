package p1;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public abstract class d<Z> extends g<ImageView, Z> {

    /* renamed from: k, reason: collision with root package name */
    private Animatable f7579k;

    public d(ImageView imageView) {
        super(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m(Z z4) {
        b bVar = (b) this;
        switch (bVar.f7575l) {
            case 0:
                ((ImageView) bVar.f7580i).setImageBitmap((Bitmap) z4);
                break;
            default:
                ((ImageView) bVar.f7580i).setImageDrawable((Drawable) z4);
                break;
        }
        if (!(z4 instanceof Animatable)) {
            this.f7579k = null;
            return;
        }
        Animatable animatable = (Animatable) z4;
        this.f7579k = animatable;
        animatable.start();
    }

    @Override // l1.h
    public final void a() {
        Animatable animatable = this.f7579k;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // p1.f
    public final void c(Drawable drawable) {
        m(null);
        l(drawable);
    }

    @Override // l1.h
    public final void d() {
        Animatable animatable = this.f7579k;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // p1.f
    public final void h(Drawable drawable) {
        m(null);
        l(drawable);
    }

    @Override // p1.g, p1.f
    public final void j(Drawable drawable) {
        super.j(drawable);
        Animatable animatable = this.f7579k;
        if (animatable != null) {
            animatable.stop();
        }
        m(null);
        l(drawable);
    }

    @Override // p1.f
    public final void k(Z z4, q1.b<? super Z> bVar) {
        m(z4);
    }

    public final void l(Drawable drawable) {
        ((ImageView) this.f7580i).setImageDrawable(drawable);
    }
}
