package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import i.C0333a;

/* renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0191l {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f3031a;

    /* renamed from: b, reason: collision with root package name */
    private S f3032b;

    public C0191l(ImageView imageView) {
        this.f3031a = imageView;
    }

    final void a() {
        S s2;
        Drawable drawable = this.f3031a.getDrawable();
        if (drawable != null) {
            Rect rect = C.f2715a;
        }
        if (drawable == null || (s2 = this.f3032b) == null) {
            return;
        }
        int[] drawableState = this.f3031a.getDrawableState();
        int i2 = C0187h.d;
        L.m(drawable, s2, drawableState);
    }

    final boolean b() {
        return !(this.f3031a.getBackground() instanceof RippleDrawable);
    }

    public final void c(AttributeSet attributeSet, int i2) {
        int iM;
        Context context = this.f3031a.getContext();
        int[] iArr = Y1.a.f2118k;
        U u = U.u(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.f3031a;
        androidx.core.view.o.i(imageView, imageView.getContext(), iArr, attributeSet, u.q(), i2);
        try {
            Drawable drawable = this.f3031a.getDrawable();
            if (drawable == null && (iM = u.m(1, -1)) != -1 && (drawable = C0333a.a(this.f3031a.getContext(), iM)) != null) {
                this.f3031a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                Rect rect = C.f2715a;
            }
            if (u.r(2)) {
                this.f3031a.setImageTintList(u.c(2));
            }
            if (u.r(3)) {
                this.f3031a.setImageTintMode(C.c(u.j(3, -1), null));
            }
        } finally {
            u.v();
        }
    }

    public final void d(int i2) {
        if (i2 != 0) {
            Drawable drawableA = C0333a.a(this.f3031a.getContext(), i2);
            if (drawableA != null) {
                Rect rect = C.f2715a;
            }
            this.f3031a.setImageDrawable(drawableA);
        } else {
            this.f3031a.setImageDrawable(null);
        }
        a();
    }
}
