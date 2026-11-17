package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.android.mmt.R;

/* renamed from: androidx.appcompat.widget.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0197s extends C0194o {
    private final SeekBar d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f3042e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f3043f;
    private PorterDuff.Mode g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3044h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3045i;

    C0197s(SeekBar seekBar) {
        super(seekBar);
        this.f3043f = null;
        this.g = null;
        this.f3044h = false;
        this.f3045i = false;
        this.d = seekBar;
    }

    private void d() {
        Drawable drawable = this.f3042e;
        if (drawable != null) {
            if (this.f3044h || this.f3045i) {
                Drawable drawableMutate = drawable.mutate();
                this.f3042e = drawableMutate;
                if (this.f3044h) {
                    drawableMutate.setTintList(this.f3043f);
                }
                if (this.f3045i) {
                    this.f3042e.setTintMode(this.g);
                }
                if (this.f3042e.isStateful()) {
                    this.f3042e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.C0194o
    final void b(AttributeSet attributeSet, int i2) {
        super.b(attributeSet, R.attr.seekBarStyle);
        Context context = this.d.getContext();
        int[] iArr = Y1.a.f2119l;
        U u = U.u(context, attributeSet, iArr, R.attr.seekBarStyle, 0);
        SeekBar seekBar = this.d;
        androidx.core.view.o.i(seekBar, seekBar.getContext(), iArr, attributeSet, u.q(), R.attr.seekBarStyle);
        Drawable drawableG = u.g(0);
        if (drawableG != null) {
            this.d.setThumb(drawableG);
        }
        Drawable drawableF = u.f(1);
        Drawable drawable = this.f3042e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f3042e = drawableF;
        if (drawableF != null) {
            drawableF.setCallback(this.d);
            SeekBar seekBar2 = this.d;
            int i4 = androidx.core.view.o.d;
            drawableF.setLayoutDirection(seekBar2.getLayoutDirection());
            if (drawableF.isStateful()) {
                drawableF.setState(this.d.getDrawableState());
            }
            d();
        }
        this.d.invalidate();
        if (u.r(3)) {
            this.g = C.c(u.j(3, -1), this.g);
            this.f3045i = true;
        }
        if (u.r(2)) {
            this.f3043f = u.c(2);
            this.f3044h = true;
        }
        u.v();
        d();
    }

    final void e(Canvas canvas) {
        if (this.f3042e != null) {
            int max = this.d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f3042e.getIntrinsicWidth();
                int intrinsicHeight = this.f3042e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i4 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f3042e.setBounds(-i2, -i4, i2, i4);
                float width = ((this.d.getWidth() - this.d.getPaddingLeft()) - this.d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.d.getPaddingLeft(), this.d.getHeight() / 2);
                for (int i5 = 0; i5 <= max; i5++) {
                    this.f3042e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    final void f() {
        Drawable drawable = this.f3042e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.d.getDrawableState())) {
            this.d.invalidateDrawable(drawable);
        }
    }

    final void g() {
        Drawable drawable = this.f3042e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }
}
