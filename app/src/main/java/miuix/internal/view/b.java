package miuix.internal.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private int f7121a;

    /* renamed from: b, reason: collision with root package name */
    private int f7122b;

    /* renamed from: c, reason: collision with root package name */
    private int f7123c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f7124e = new Paint();

    /* renamed from: f, reason: collision with root package name */
    private Paint f7125f = new Paint();
    private float g = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7126h;

    public b(int i2, int i4, int i5, int i6, int i7, int i8) {
        this.f7124e.setAntiAlias(true);
        this.f7124e.setColor(i2);
        this.f7121a = i4;
        this.f7122b = i5;
        boolean z4 = i6 != 0;
        this.f7126h = z4;
        if (z4) {
            this.f7125f.setAntiAlias(true);
            this.f7125f.setColor(i6);
            this.f7125f.setStyle(Paint.Style.STROKE);
            this.f7125f.setStrokeWidth(2.0f);
        }
        this.f7123c = i7;
        this.d = i8;
    }

    public final void a(float f4) {
        this.g = f4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i2 = bounds.right;
        int i4 = bounds.left;
        int i5 = bounds.top;
        int i6 = bounds.bottom;
        int i7 = (i5 + i6) / 2;
        int iMin = Math.min(i2 - i4, i6 - i5) / 2;
        float f4 = (i2 + i4) / 2;
        float f5 = i7;
        float f6 = iMin;
        canvas.drawCircle(f4, f5, (this.g * f6) - 1.0f, this.f7124e);
        if (this.f7126h) {
            canvas.drawCircle(f4, f5, ((f6 * this.g) - 1.0f) - 1.0f, this.f7125f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f7124e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f7124e.setAlpha(i2);
        if (this.f7126h) {
            if (i2 == this.f7121a) {
                this.f7125f.setAlpha(this.f7123c);
            } else if (i2 == this.f7122b) {
                this.f7125f.setAlpha(this.d);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f7124e.setColorFilter(colorFilter);
    }
}
