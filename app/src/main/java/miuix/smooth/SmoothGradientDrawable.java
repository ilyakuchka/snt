package miuix.smooth;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Deprecated
/* loaded from: classes.dex */
public class SmoothGradientDrawable extends GradientDrawable {

    /* renamed from: f, reason: collision with root package name */
    private static final PorterDuffXfermode f7427f = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

    /* renamed from: a, reason: collision with root package name */
    protected b f7428a;

    /* renamed from: b, reason: collision with root package name */
    private GradientDrawable f7429b;

    /* renamed from: c, reason: collision with root package name */
    private J3.a f7430c;
    private RectF d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f7431e;

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        this.f7428a.f7432a = super.getConstantState();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        b bVar = this.f7428a;
        if (bVar != null) {
            Objects.requireNonNull(bVar);
        } else if (!super.canApplyTheme()) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int iSaveLayer = this.f7428a.f7436f != 2 ? canvas.saveLayer(this.d, null, 31) : -1;
        GradientDrawable gradientDrawable = this.f7429b;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        } else {
            super.draw(canvas);
        }
        this.f7430c.a(canvas, f7427f);
        if (this.f7428a.f7436f != 2) {
            canvas.restoreToCount(iSaveLayer);
        }
        this.f7430c.b(canvas);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final int getAlpha() {
        GradientDrawable gradientDrawable = this.f7429b;
        return gradientDrawable != null ? gradientDrawable.getAlpha() : super.getAlpha();
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final ColorStateList getColor() {
        GradientDrawable gradientDrawable = this.f7429b;
        return gradientDrawable != null ? gradientDrawable.getColor() : super.getColor();
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final int[] getColors() {
        GradientDrawable gradientDrawable = this.f7429b;
        return gradientDrawable != null ? gradientDrawable.getColors() : super.getColors();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f7428a;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setPath(this.f7430c.c(this.f7431e));
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int[] iArr = Y1.a.f2097R;
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        int dimensionPixelSize = typedArrayObtainAttributes.getDimensionPixelSize(2, 0);
        b bVar = this.f7428a;
        if (bVar.d != dimensionPixelSize) {
            bVar.d = dimensionPixelSize;
            this.f7430c.j(dimensionPixelSize);
            invalidateSelf();
        }
        int color = typedArrayObtainAttributes.getColor(1, 0);
        b bVar2 = this.f7428a;
        if (bVar2.f7435e != color) {
            bVar2.f7435e = color;
            this.f7430c.i(color);
            invalidateSelf();
        }
        int i2 = typedArrayObtainAttributes.getInt(0, 0);
        if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("Layer type can only be one of: LAYER_TYPE_NONE, LAYER_TYPE_SOFTWARE or LAYER_TYPE_HARDWARE");
        }
        b bVar3 = this.f7428a;
        if (bVar3.f7436f != i2) {
            bVar3.f7436f = i2;
            invalidateSelf();
        }
        typedArrayObtainAttributes.recycle();
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        GradientDrawable gradientDrawable = this.f7429b;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(rect);
        }
        this.f7430c.e(rect);
        this.f7431e = rect;
        this.d.set(0.0f, 0.0f, rect.width(), rect.height());
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        GradientDrawable gradientDrawable = this.f7429b;
        if (gradientDrawable != null) {
            gradientDrawable.setAlpha(i2);
        } else {
            super.setAlpha(i2);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final void setColor(int i2) {
        GradientDrawable gradientDrawable = this.f7429b;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(i2);
        } else {
            super.setColor(i2);
        }
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final void setColors(int[] iArr, float[] fArr) {
        GradientDrawable gradientDrawable = this.f7429b;
        if (gradientDrawable != null) {
            gradientDrawable.setColors(iArr, fArr);
        } else {
            super.setColors(iArr, fArr);
        }
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final void setCornerRadii(float[] fArr) {
        super.setCornerRadii(fArr);
        this.f7428a.f7434c = fArr;
        this.f7430c.g(fArr);
        if (fArr == null) {
            this.f7428a.f7433b = 0.0f;
            this.f7430c.h(0.0f);
        }
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final void setCornerRadius(float f4) {
        if (Float.isNaN(f4)) {
            return;
        }
        super.setCornerRadius(f4);
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        b bVar = this.f7428a;
        bVar.f7433b = f4;
        bVar.f7434c = null;
        this.f7430c.h(f4);
        this.f7430c.g(null);
    }

    protected static class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        Drawable.ConstantState f7432a;

        /* renamed from: b, reason: collision with root package name */
        float f7433b;

        /* renamed from: c, reason: collision with root package name */
        float[] f7434c;
        int d;

        /* renamed from: e, reason: collision with root package name */
        int f7435e;

        /* renamed from: f, reason: collision with root package name */
        int f7436f;

        public b() {
            this.d = 0;
            this.f7435e = 0;
            this.f7436f = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.f7432a.getChangingConfigurations();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            Resources resources = null;
            Object[] objArr = 0;
            if (this.f7432a == null) {
                return null;
            }
            return new SmoothGradientDrawable(this, resources);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            if (this.f7432a == null) {
                return null;
            }
            return new SmoothGradientDrawable(new b(this), resources);
        }

        public b(b bVar) {
            this.d = 0;
            this.f7435e = 0;
            this.f7436f = 0;
            this.f7433b = bVar.f7433b;
            this.f7434c = bVar.f7434c;
            this.d = bVar.d;
            this.f7435e = bVar.f7435e;
            this.f7432a = bVar.f7432a;
            this.f7436f = bVar.f7436f;
        }
    }

    public SmoothGradientDrawable() {
        this.f7430c = new J3.a();
        this.d = new RectF();
        this.f7431e = new Rect();
        b bVar = new b();
        this.f7428a = bVar;
        bVar.f7432a = super.getConstantState();
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final void setColor(ColorStateList colorStateList) {
        GradientDrawable gradientDrawable = this.f7429b;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(colorStateList);
        } else {
            super.setColor(colorStateList);
        }
    }

    public SmoothGradientDrawable(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.f7430c = new J3.a();
        this.d = new RectF();
        this.f7431e = new Rect();
        b bVar = new b();
        this.f7428a = bVar;
        bVar.f7432a = super.getConstantState();
    }

    private SmoothGradientDrawable(b bVar, Resources resources) {
        Drawable drawableNewDrawable;
        this.f7430c = new J3.a();
        this.d = new RectF();
        this.f7431e = new Rect();
        this.f7428a = bVar;
        if (resources == null) {
            drawableNewDrawable = bVar.f7432a.newDrawable();
        } else {
            drawableNewDrawable = bVar.f7432a.newDrawable(resources);
        }
        this.f7428a.f7432a = drawableNewDrawable.getConstantState();
        this.f7429b = (GradientDrawable) drawableNewDrawable;
        this.f7430c.g(bVar.f7434c);
        this.f7430c.h(bVar.f7433b);
        this.f7430c.j(bVar.d);
        this.f7430c.i(bVar.f7435e);
    }
}
