package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import z.InterfaceC0427a;

/* renamed from: androidx.appcompat.widget.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0194o {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f3036c = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    private final ProgressBar f3037a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f3038b;

    C0194o(ProgressBar progressBar) {
        this.f3037a = progressBar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable c(Drawable drawable, boolean z4) {
        if (drawable instanceof InterfaceC0427a) {
            InterfaceC0427a interfaceC0427a = (InterfaceC0427a) drawable;
            Drawable drawableA = interfaceC0427a.a();
            if (drawableA != null) {
                interfaceC0427a.b(c(drawableA, z4));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    int id = layerDrawable.getId(i2);
                    drawableArr[i2] = c(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i4 = 0; i4 < numberOfLayers; i4++) {
                    layerDrawable2.setId(i4, layerDrawable.getId(i4));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f3038b == null) {
                    this.f3038b = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z4 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    final Bitmap a() {
        return this.f3038b;
    }

    void b(AttributeSet attributeSet, int i2) {
        U u = U.u(this.f3037a.getContext(), attributeSet, f3036c, i2, 0);
        Drawable drawableG = u.g(0);
        if (drawableG != null) {
            ProgressBar progressBar = this.f3037a;
            if (drawableG instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) drawableG;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i4 = 0; i4 < numberOfFrames; i4++) {
                    Drawable drawableC = c(animationDrawable.getFrame(i4), true);
                    drawableC.setLevel(10000);
                    animationDrawable2.addFrame(drawableC, animationDrawable.getDuration(i4));
                }
                animationDrawable2.setLevel(10000);
                drawableG = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(drawableG);
        }
        Drawable drawableG2 = u.g(1);
        if (drawableG2 != null) {
            this.f3037a.setProgressDrawable(c(drawableG2, false));
        }
        u.v();
    }
}
