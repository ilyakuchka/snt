package J3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import java.util.Objects;
import miuix.smooth.a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private float[] f282c;
    private float d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f283e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f284f;

    /* renamed from: h, reason: collision with root package name */
    private Path f285h;

    /* renamed from: i, reason: collision with root package name */
    private Path f286i;

    /* renamed from: j, reason: collision with root package name */
    private miuix.smooth.a f287j;

    /* renamed from: a, reason: collision with root package name */
    private int f280a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f281b = 0;
    private Paint g = new Paint(1);

    public a() {
        Paint paint = new Paint(1);
        this.f284f = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f285h = new Path();
        this.f286i = new Path();
        this.f287j = new miuix.smooth.a();
        this.f283e = new RectF();
    }

    private Path d(Path path, RectF rectF, float[] fArr, float f4, float f5, float f6) {
        a.b bVarD;
        if (fArr == null) {
            miuix.smooth.a aVar = this.f287j;
            Objects.requireNonNull(aVar);
            bVarD = aVar.d(rectF, new float[]{f4, f4, f4, f4, f4, f4, f4, f4}, f5, f6);
        } else {
            bVarD = this.f287j.d(rectF, fArr, f5, f6);
        }
        return this.f287j.e(path, bVarD);
    }

    public final void a(Canvas canvas, Xfermode xfermode) {
        this.g.setXfermode(xfermode);
        canvas.drawPath(this.f286i, this.g);
        this.g.setXfermode(null);
    }

    public final void b(Canvas canvas) {
        if ((this.f280a == 0 || this.f284f.getAlpha() == 0 || Color.alpha(this.f281b) == 0) ? false : true) {
            canvas.save();
            this.f284f.setStrokeWidth(this.f280a);
            this.f284f.setColor(this.f281b);
            canvas.drawPath(this.f285h, this.f284f);
            canvas.restore();
        }
    }

    public final Path c(Rect rect) {
        float f4 = this.f280a != 0 && this.f284f.getAlpha() != 0 && Color.alpha(this.f281b) != 0 ? 0.5f + (this.f280a / 2.0f) : 0.5f;
        return d(new Path(), new RectF(rect), this.f282c, this.d, f4, f4);
    }

    public final void e(Rect rect) {
        this.f283e.set(rect.left - 0.5f, rect.top - 0.5f, rect.right + 0.5f, rect.bottom + 0.5f);
        float f4 = this.f280a != 0 && this.f284f.getAlpha() != 0 && Color.alpha(this.f281b) != 0 ? 0.5f + (this.f280a / 2.0f) : 0.5f;
        this.f285h = d(this.f285h, this.f283e, this.f282c, this.d, f4, f4);
        Path path = this.f286i;
        if (path != null) {
            path.reset();
        } else {
            this.f286i = new Path();
        }
        this.f286i.addRect(this.f283e, Path.Direction.CW);
        this.f286i.op(this.f285h, Path.Op.DIFFERENCE);
    }

    public final void f(int i2) {
        this.f284f.setAlpha(i2);
    }

    public final void g(float[] fArr) {
        this.f282c = fArr;
    }

    public final void h(float f4) {
        this.d = f4;
    }

    public final void i(int i2) {
        this.f281b = i2;
    }

    public final void j(int i2) {
        this.f280a = i2;
    }
}
