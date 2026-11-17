package j1;

import V0.l;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import j1.f;
import java.nio.ByteBuffer;
import java.util.Objects;
import t.C0384b;

/* loaded from: classes.dex */
public final class c extends Drawable implements f.b, Animatable {

    /* renamed from: i, reason: collision with root package name */
    private final a f6370i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6371j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6372k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6373l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6374m;

    /* renamed from: n, reason: collision with root package name */
    private int f6375n;

    /* renamed from: o, reason: collision with root package name */
    private int f6376o;
    private boolean p;

    /* renamed from: q, reason: collision with root package name */
    private Paint f6377q;

    /* renamed from: r, reason: collision with root package name */
    private Rect f6378r;

    static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        final f f6379a;

        a(f fVar) {
            this.f6379a = fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new c(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new c(this);
        }
    }

    public c(Context context, U0.a aVar, l<Bitmap> lVar, int i2, int i4, Bitmap bitmap) {
        a aVar2 = new a(new f(com.bumptech.glide.c.c(context), aVar, i2, i4, lVar, bitmap));
        this.f6374m = true;
        this.f6376o = -1;
        this.f6370i = aVar2;
    }

    private Paint d() {
        if (this.f6377q == null) {
            this.f6377q = new Paint(2);
        }
        return this.f6377q;
    }

    private void h() {
        C0384b.f(!this.f6373l, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f6370i.f6379a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f6371j) {
                return;
            }
            this.f6371j = true;
            this.f6370i.f6379a.m(this);
            invalidateSelf();
        }
    }

    @Override // j1.f.b
    public final void a() {
        Object callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (this.f6370i.f6379a.d() == this.f6370i.f6379a.f() - 1) {
            this.f6375n++;
        }
        int i2 = this.f6376o;
        if (i2 == -1 || this.f6375n < i2) {
            return;
        }
        stop();
    }

    public final ByteBuffer b() {
        return this.f6370i.f6379a.b();
    }

    public final Bitmap c() {
        return this.f6370i.f6379a.e();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f6373l) {
            return;
        }
        if (this.p) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f6378r == null) {
                this.f6378r = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f6378r);
            this.p = false;
        }
        Bitmap bitmapC = this.f6370i.f6379a.c();
        if (this.f6378r == null) {
            this.f6378r = new Rect();
        }
        canvas.drawBitmap(bitmapC, (Rect) null, this.f6378r, d());
    }

    public final int e() {
        return this.f6370i.f6379a.h();
    }

    public final void f() {
        this.f6373l = true;
        this.f6370i.f6379a.a();
    }

    public final void g(l<Bitmap> lVar, Bitmap bitmap) {
        this.f6370i.f6379a.l(lVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f6370i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f6370i.f6379a.g();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f6370i.f6379a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f6371j;
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.p = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        d().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        d().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        C0384b.f(!this.f6373l, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f6374m = z4;
        if (!z4) {
            this.f6371j = false;
            this.f6370i.f6379a.n(this);
        } else if (this.f6372k) {
            h();
        }
        return super.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f6372k = true;
        this.f6375n = 0;
        if (this.f6374m) {
            h();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f6372k = false;
        this.f6371j = false;
        this.f6370i.f6379a.n(this);
    }

    c(a aVar) {
        this.f6374m = true;
        this.f6376o = -1;
        Objects.requireNonNull(aVar, "Argument must not be null");
        this.f6370i = aVar;
    }
}
