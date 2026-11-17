package miuix.smooth;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class SmoothContainerDrawable extends Drawable implements Drawable.Callback {

    /* renamed from: k, reason: collision with root package name */
    private static final PorterDuffXfermode f7418k = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

    /* renamed from: i, reason: collision with root package name */
    private c f7419i;

    /* renamed from: j, reason: collision with root package name */
    private J3.a f7420j;

    static class b {

        /* renamed from: a, reason: collision with root package name */
        Drawable f7421a;

        b() {
        }

        b(b bVar, SmoothContainerDrawable smoothContainerDrawable, Resources resources, Resources.Theme theme) {
            Drawable drawableNewDrawable;
            Drawable drawable = bVar.f7421a;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                drawableNewDrawable = constantState == null ? drawable : resources == null ? constantState.newDrawable() : theme == null ? constantState.newDrawable(resources) : constantState.newDrawable(resources, theme);
                drawableNewDrawable.setLayoutDirection(drawable.getLayoutDirection());
                drawableNewDrawable.setBounds(drawable.getBounds());
                drawableNewDrawable.setLevel(drawable.getLevel());
                drawableNewDrawable.setCallback(smoothContainerDrawable);
            } else {
                drawableNewDrawable = null;
            }
            this.f7421a = drawableNewDrawable;
        }
    }

    static final class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        b f7422a;

        /* renamed from: b, reason: collision with root package name */
        float f7423b;

        /* renamed from: c, reason: collision with root package name */
        float[] f7424c;
        int d;

        /* renamed from: e, reason: collision with root package name */
        int f7425e;

        /* renamed from: f, reason: collision with root package name */
        int f7426f;

        public c() {
            this.f7426f = 0;
            this.f7422a = new b();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.f7422a.f7421a.getChangingConfigurations();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new SmoothContainerDrawable(null, 0 == true ? 1 : 0, this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new SmoothContainerDrawable(resources, null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            return new SmoothContainerDrawable(resources, theme, this);
        }

        public c(c cVar, SmoothContainerDrawable smoothContainerDrawable, Resources resources, Resources.Theme theme) {
            this.f7426f = 0;
            this.f7422a = new b(cVar.f7422a, smoothContainerDrawable, resources, theme);
            this.f7423b = cVar.f7423b;
            this.f7424c = cVar.f7424c;
            this.d = cVar.d;
            this.f7425e = cVar.f7425e;
            this.f7426f = cVar.f7426f;
        }
    }

    public final Rect a() {
        return this.f7419i.f7422a.f7421a.getBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        this.f7419i.f7422a.f7421a.applyTheme(theme);
    }

    public final void b(Drawable drawable) {
        if (this.f7419i != null) {
            b bVar = new b();
            bVar.f7421a = drawable;
            drawable.setCallback(this);
            this.f7419i.f7422a = bVar;
        }
    }

    public final void c(float f4) {
        if (Float.isNaN(f4)) {
            return;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        c cVar = this.f7419i;
        cVar.f7423b = f4;
        cVar.f7424c = null;
        this.f7420j.h(f4);
        this.f7420j.g(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        c cVar = this.f7419i;
        if (cVar != null) {
            Objects.requireNonNull(cVar);
        } else if (!super.canApplyTheme()) {
            return false;
        }
        return true;
    }

    public final void d(int i2) {
        if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("Layer type can only be one of: LAYER_TYPE_NONE, LAYER_TYPE_SOFTWARE or LAYER_TYPE_HARDWARE");
        }
        c cVar = this.f7419i;
        if (cVar.f7426f != i2) {
            cVar.f7426f = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int iSaveLayer = this.f7419i.f7426f != 2 ? canvas.saveLayer(a().left, a().top, a().right, a().bottom, null, 31) : -1;
        this.f7419i.f7422a.f7421a.draw(canvas);
        this.f7420j.a(canvas, f7418k);
        if (this.f7419i.f7426f != 2) {
            canvas.restoreToCount(iSaveLayer);
        }
        this.f7420j.b(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f7419i.f7422a.f7421a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f7419i;
    }

    @Override // android.graphics.drawable.Drawable
    public final Rect getDirtyBounds() {
        return this.f7419i.f7422a.f7421a.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f7419i.f7422a.f7421a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f7419i.f7422a.f7421a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f7419i.f7422a.f7421a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setPath(this.f7420j.c(a()));
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        return this.f7419i.f7422a.f7421a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        int[] iArr = Y1.a.P;
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        c(typedArrayObtainAttributes.getDimensionPixelSize(0, 0));
        if (typedArrayObtainAttributes.hasValue(1) || typedArrayObtainAttributes.hasValue(2) || typedArrayObtainAttributes.hasValue(4) || typedArrayObtainAttributes.hasValue(3)) {
            float dimensionPixelSize = typedArrayObtainAttributes.getDimensionPixelSize(1, 0);
            float dimensionPixelSize2 = typedArrayObtainAttributes.getDimensionPixelSize(2, 0);
            float dimensionPixelSize3 = typedArrayObtainAttributes.getDimensionPixelSize(4, 0);
            float dimensionPixelSize4 = typedArrayObtainAttributes.getDimensionPixelSize(3, 0);
            float[] fArr = {dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize4};
            this.f7419i.f7424c = fArr;
            this.f7420j.g(fArr);
            invalidateSelf();
        }
        int dimensionPixelSize5 = typedArrayObtainAttributes.getDimensionPixelSize(7, 0);
        c cVar = this.f7419i;
        if (cVar.d != dimensionPixelSize5) {
            cVar.d = dimensionPixelSize5;
            this.f7420j.j(dimensionPixelSize5);
            invalidateSelf();
        }
        int color = typedArrayObtainAttributes.getColor(6, 0);
        c cVar2 = this.f7419i;
        if (cVar2.f7425e != color) {
            cVar2.f7425e = color;
            this.f7420j.i(color);
            invalidateSelf();
        }
        d(typedArrayObtainAttributes.getInt(5, 0));
        typedArrayObtainAttributes.recycle();
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("child")) {
                do {
                    next = xmlPullParser.next();
                } while (next == 4);
                if (next != 2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <child> tag requires a 'drawable' attribute or child tag defining a drawable");
                }
                b bVar = new b();
                Drawable drawableCreateFromXmlInner = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                bVar.f7421a = drawableCreateFromXmlInner;
                drawableCreateFromXmlInner.setCallback(this);
                this.f7419i.f7422a = bVar;
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f7419i.f7422a.f7421a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.f7419i.f7422a.f7421a.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        this.f7419i.f7422a.f7421a.setBounds(rect);
        this.f7420j.e(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected final boolean onStateChange(int[] iArr) {
        c cVar = this.f7419i;
        return cVar.f7422a.f7421a.isStateful() && cVar.f7422a.f7421a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        c cVar = this.f7419i;
        cVar.f7422a.f7421a.setAlpha(i2);
        cVar.f7422a.f7421a.invalidateSelf();
        this.f7420j.f(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i2) {
        this.f7419i.f7422a.f7421a.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f7419i.f7422a.f7421a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z4) {
        this.f7419i.f7422a.f7421a.setDither(z4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z4) {
        this.f7419i.f7422a.f7421a.setFilterBitmap(z4);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public SmoothContainerDrawable() {
        this.f7420j = new J3.a();
        this.f7419i = new c();
    }

    private SmoothContainerDrawable(Resources resources, Resources.Theme theme, c cVar) {
        this.f7420j = new J3.a();
        this.f7419i = new c(cVar, this, resources, theme);
        this.f7420j.j(cVar.d);
        this.f7420j.i(cVar.f7425e);
        this.f7420j.g(cVar.f7424c);
        this.f7420j.h(cVar.f7423b);
    }
}
