package com.android.mmt.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.android.mmt.MmsApp;
import com.android.mmt.R;

/* loaded from: classes.dex */
public class ThumbnailView extends ImageView {

    /* renamed from: A, reason: collision with root package name */
    private static int f5458A;

    /* renamed from: B, reason: collision with root package name */
    private static int f5459B;
    private static final PorterDuffXfermode u = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    /* renamed from: v, reason: collision with root package name */
    private static int f5460v;

    /* renamed from: w, reason: collision with root package name */
    private static int f5461w;

    /* renamed from: x, reason: collision with root package name */
    private static int f5462x;

    /* renamed from: y, reason: collision with root package name */
    private static int f5463y;

    /* renamed from: z, reason: collision with root package name */
    private static int f5464z;

    /* renamed from: i, reason: collision with root package name */
    private Rect f5465i;

    /* renamed from: j, reason: collision with root package name */
    private int f5466j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f5467k;

    /* renamed from: l, reason: collision with root package name */
    private Rect f5468l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f5469m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5470n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f5471o;
    private Drawable p;

    /* renamed from: q, reason: collision with root package name */
    private int f5472q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5473r;

    /* renamed from: s, reason: collision with root package name */
    private int f5474s;

    /* renamed from: t, reason: collision with root package name */
    private int f5475t;

    static {
        new Paint();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Resources resources = MmsApp.c().getResources();
        resources.getDimensionPixelSize(R.dimen.bubble_thumbnail_large_long_edge);
        resources.getDimensionPixelSize(R.dimen.bubble_thumbnail_small_long_edge);
        f5460v = resources.getDimensionPixelSize(R.dimen.bubble_thumbnail_zoom_size);
        f5461w = resources.getDimensionPixelSize(R.dimen.bubble_thumbnail_large_long_edge);
        f5462x = resources.getDimensionPixelSize(R.dimen.bubble_thumbnail_large_short_edge);
        f5463y = resources.getDimensionPixelSize(R.dimen.bubble_thumbnail_small_long_edge);
        f5464z = resources.getDimensionPixelSize(R.dimen.bubble_thumbnail_small_short_edge);
        f5458A = resources.getDimensionPixelSize(R.dimen.bubble_attachment_image_min_size);
        f5459B = resources.getDimensionPixelSize(R.dimen.bubble_thumbnail_normal_size);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sbD = D2.e.d("Initialize cached drawables of ThumbnailView: ");
        sbD.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
        sbD.append("ms");
        Log.d("ThumbnailView", sbD.toString());
    }

    public ThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5465i = new Rect();
        this.f5467k = new Rect();
        this.f5468l = new Rect();
        this.f5472q = 2;
        this.f5473r = false;
        this.f5475t = 0;
        this.f5474s = context.getResources().getDimensionPixelSize(R.dimen.bubble_margin);
    }

    private boolean a() {
        return (this.f5475t / 90) % 2 != 0;
    }

    public final void b(Drawable drawable, int i2) {
        super.setBackground(drawable);
        this.f5469m = drawable;
        this.f5466j = i2;
    }

    public final void c(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f5470n = true;
        this.f5472q = 2;
        this.f5473r = false;
    }

    public final void d(int i2, boolean z4) {
        super.setImageResource(i2);
        this.f5470n = z4;
        this.f5472q = 2;
        this.f5473r = i2 == R.drawable.message_attachment_default;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Drawable drawable;
        int i2;
        Drawable drawable2 = getDrawable();
        if (this.f5469m == null || drawable2 == null) {
            if (drawable2 != null) {
                drawable2.draw(canvas);
                return;
            } else {
                super.draw(canvas);
                return;
            }
        }
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            super.draw(canvas);
            return;
        }
        this.f5469m.setBounds(this.f5465i);
        this.f5469m.draw(canvas);
        if (drawable2 instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable2;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f5475t != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(this.f5475t);
                try {
                    bitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap(), 0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight(), matrix, true);
                } catch (IllegalArgumentException e2) {
                    Log.e("ThumbnailView", "draw thumbnailView exception", e2);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    Log.e("ThumbnailView", "draw: " + bitmapDrawable.getBitmap().getWidth() + "|" + bitmapDrawable.getBitmap().getHeight() + "|" + bitmapDrawable.getIntrinsicWidth() + "|" + bitmapDrawable.getIntrinsicHeight());
                }
            }
            Paint paint = bitmapDrawable.getPaint();
            setLayerType(2, paint);
            Xfermode xfermode = paint.getXfermode();
            paint.setXfermode(u);
            canvas.drawBitmap(bitmap, this.f5467k, this.f5468l, paint);
            paint.setXfermode(xfermode);
        } else {
            drawable2.draw(canvas);
        }
        if (isPressed() && (drawable = this.f5471o) != null && ((i2 = this.f5466j) == 1 || i2 == 2)) {
            drawable.setBounds(this.f5465i);
            this.f5471o.draw(canvas);
            return;
        }
        Drawable drawable3 = this.p;
        if (drawable3 != null) {
            drawable3.setBounds(this.f5465i);
            this.p.draw(canvas);
        }
    }

    public final void e(int i2) {
        this.f5475t = i2;
    }

    public final void f(Drawable drawable, Drawable drawable2) {
        this.f5471o = drawable;
        this.p = drawable2;
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onMeasure(int i2, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Drawable drawable = getDrawable();
        if (this.f5469m == null || drawable == null) {
            if (drawable != null) {
                setMeasuredDimension(a() ? drawable.getIntrinsicHeight() : drawable.getIntrinsicWidth(), a() ? drawable.getIntrinsicWidth() : drawable.getIntrinsicHeight());
                return;
            } else {
                super.onMeasure(i2, i4);
                return;
            }
        }
        int intrinsicHeight = a() ? drawable.getIntrinsicHeight() : drawable.getIntrinsicWidth();
        int intrinsicWidth = a() ? drawable.getIntrinsicWidth() : drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0 || intrinsicWidth <= 0) {
            super.onMeasure(i2, i4);
            return;
        }
        if (this.f5472q == 0) {
            i6 = 0;
            i5 = 0;
        } else {
            this.f5472q = 2;
            boolean z4 = this.f5470n;
            i5 = z4 ? f5462x : f5461w;
            int i11 = f5462x;
            if (this.f5466j == 0) {
                int i12 = f5458A;
                if (intrinsicHeight < i12 || intrinsicWidth < i12) {
                    i5 = f5464z;
                    this.f5472q = 1;
                } else {
                    i5 = f5459B;
                }
                i6 = i5;
            } else if (intrinsicHeight < intrinsicWidth) {
                int i13 = z4 ? i11 : f5461w;
                if (intrinsicHeight < f5458A) {
                    i5 = f5464z;
                    i6 = z4 ? i5 : f5463y;
                    this.f5472q = 1;
                } else {
                    i6 = i13;
                    i5 = i11;
                }
            } else if (intrinsicWidth < f5458A) {
                i5 = z4 ? f5464z : f5463y;
                i6 = f5464z;
                this.f5472q = 1;
            } else {
                if (this.f5473r) {
                    i11 = f5461w;
                }
                i6 = i11;
            }
        }
        int i14 = this.f5466j;
        if (i14 == 1 || i14 == 2) {
            i5 += f5460v;
        }
        double d = i5;
        double d2 = intrinsicHeight;
        double d4 = i6;
        double d5 = intrinsicWidth;
        int i15 = i5;
        double dMax = Math.max(d / d2, d4 / d5);
        if (((int) (d2 * dMax)) > i15) {
            double d6 = d2 / 2.0d;
            double d7 = d / (dMax * 2.0d);
            int i16 = (int) (d6 - d7);
            int i17 = (int) (d6 + d7);
            i7 = 0;
            this.f5467k.set(i16, 0, i17, intrinsicWidth);
        } else {
            i7 = 0;
            double d8 = d5 / 2.0d;
            double d9 = d4 / (dMax * 2.0d);
            this.f5467k.set(0, (int) (d8 - d9), intrinsicHeight, (int) (d8 + d9));
        }
        int i18 = this.f5466j;
        if (i18 == 1) {
            this.f5465i.set(i7, i7, i15 - f5460v, i6);
            i8 = 1;
        } else {
            if (i18 == 2) {
                i9 = i15 + this.f5474s;
                i8 = 1;
                this.f5465i.set(i7, i7, (i9 - f5460v) - 1, i6);
                i10 = this.f5466j;
                if (i10 == i8 && i10 == 2) {
                    Rect rect = this.f5468l;
                    int i19 = f5460v;
                    rect.set(-i19, i7, (i9 - this.f5474s) - i19, i6);
                } else {
                    this.f5468l.set(i7, i7, i9, i6);
                }
                setMeasuredDimension(this.f5465i.width(), this.f5465i.height());
            }
            i8 = 1;
            this.f5465i.set(i7, i7, i15, i6);
        }
        i9 = i15;
        i10 = this.f5466j;
        if (i10 == i8) {
            this.f5468l.set(i7, i7, i9, i6);
        } else {
            Rect rect2 = this.f5468l;
            int i192 = f5460v;
            rect2.set(-i192, i7, (i9 - this.f5474s) - i192, i6);
        }
        setMeasuredDimension(this.f5465i.width(), this.f5465i.height());
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f5470n = false;
        this.f5473r = false;
        this.f5472q = 2;
    }

    @Override // android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f5470n = false;
        this.f5473r = false;
        this.f5472q = 2;
    }

    @Override // android.widget.ImageView
    public final void setImageResource(int i2) {
        d(i2, false);
        this.f5472q = 2;
    }
}
