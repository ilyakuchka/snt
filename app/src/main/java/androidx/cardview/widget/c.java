package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class c extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f3113a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f3114b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f3115c;
    private final Rect d;

    /* renamed from: e, reason: collision with root package name */
    private float f3116e;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f3118h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f3119i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f3120j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3117f = false;
    private boolean g = true;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f3121k = PorterDuff.Mode.SRC_IN;

    c(ColorStateList colorStateList, float f4) {
        this.f3113a = f4;
        Paint paint = new Paint(5);
        this.f3114b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f3118h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f3118h.getDefaultColor()));
        this.f3115c = new RectF();
        this.d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f3115c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.d.set(rect);
        if (this.f3117f) {
            this.d.inset((int) Math.ceil(d.a(this.f3116e, this.f3113a, this.g)), (int) Math.ceil(d.b(this.f3116e, this.f3113a, this.g)));
            this.f3115c.set(this.d);
        }
    }

    final float b() {
        return this.f3116e;
    }

    public final float c() {
        return this.f3113a;
    }

    final void d(float f4, boolean z4, boolean z5) {
        if (f4 == this.f3116e && this.f3117f == z4 && this.g == z5) {
            return;
        }
        this.f3116e = f4;
        this.f3117f = z4;
        this.g = z5;
        e(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z4;
        Paint paint = this.f3114b;
        if (this.f3119i == null || paint.getColorFilter() != null) {
            z4 = false;
        } else {
            paint.setColorFilter(this.f3119i);
            z4 = true;
        }
        RectF rectF = this.f3115c;
        float f4 = this.f3113a;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        if (z4) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.d, this.f3113a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f3120j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f3118h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        e(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f3118h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z4 = colorForState != this.f3114b.getColor();
        if (z4) {
            this.f3114b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f3120j;
        if (colorStateList2 == null || (mode = this.f3121k) == null) {
            return z4;
        }
        this.f3119i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f3114b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3114b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f3120j = colorStateList;
        this.f3119i = a(colorStateList, this.f3121k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f3121k = mode;
        this.f3119i = a(this.f3120j, mode);
        invalidateSelf();
    }
}
