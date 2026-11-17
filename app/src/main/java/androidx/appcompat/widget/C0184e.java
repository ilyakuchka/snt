package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0184e {

    /* renamed from: a, reason: collision with root package name */
    private final View f3006a;
    private S d;

    /* renamed from: e, reason: collision with root package name */
    private S f3009e;

    /* renamed from: f, reason: collision with root package name */
    private S f3010f;

    /* renamed from: c, reason: collision with root package name */
    private int f3008c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final C0187h f3007b = C0187h.b();

    C0184e(View view) {
        this.f3006a = view;
    }

    final void a() {
        Drawable background = this.f3006a.getBackground();
        if (background != null) {
            boolean z4 = true;
            if (this.d != null) {
                if (this.f3010f == null) {
                    this.f3010f = new S();
                }
                S s2 = this.f3010f;
                s2.f2815a = null;
                s2.d = false;
                s2.f2816b = null;
                s2.f2817c = false;
                View view = this.f3006a;
                int i2 = androidx.core.view.o.d;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    s2.d = true;
                    s2.f2815a = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = this.f3006a.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    s2.f2817c = true;
                    s2.f2816b = backgroundTintMode;
                }
                if (s2.d || s2.f2817c) {
                    int[] drawableState = this.f3006a.getDrawableState();
                    int i4 = C0187h.d;
                    L.m(background, s2, drawableState);
                } else {
                    z4 = false;
                }
                if (z4) {
                    return;
                }
            }
            S s4 = this.f3009e;
            if (s4 != null) {
                int[] drawableState2 = this.f3006a.getDrawableState();
                int i5 = C0187h.d;
                L.m(background, s4, drawableState2);
            } else {
                S s5 = this.d;
                if (s5 != null) {
                    int[] drawableState3 = this.f3006a.getDrawableState();
                    int i6 = C0187h.d;
                    L.m(background, s5, drawableState3);
                }
            }
        }
    }

    final ColorStateList b() {
        S s2 = this.f3009e;
        if (s2 != null) {
            return s2.f2815a;
        }
        return null;
    }

    final PorterDuff.Mode c() {
        S s2 = this.f3009e;
        if (s2 != null) {
            return s2.f2816b;
        }
        return null;
    }

    final void d(AttributeSet attributeSet, int i2) {
        Context context = this.f3006a.getContext();
        int[] iArr = Y1.a.f2087E;
        U u = U.u(context, attributeSet, iArr, i2, 0);
        View view = this.f3006a;
        androidx.core.view.o.i(view, view.getContext(), iArr, attributeSet, u.q(), i2);
        try {
            if (u.r(0)) {
                this.f3008c = u.m(0, -1);
                ColorStateList colorStateListE = this.f3007b.e(this.f3006a.getContext(), this.f3008c);
                if (colorStateListE != null) {
                    g(colorStateListE);
                }
            }
            if (u.r(1)) {
                this.f3006a.setBackgroundTintList(u.c(1));
            }
            if (u.r(2)) {
                this.f3006a.setBackgroundTintMode(C.c(u.j(2, -1), null));
            }
        } finally {
            u.v();
        }
    }

    final void e() {
        this.f3008c = -1;
        g(null);
        a();
    }

    final void f(int i2) {
        this.f3008c = i2;
        C0187h c0187h = this.f3007b;
        g(c0187h != null ? c0187h.e(this.f3006a.getContext(), i2) : null);
        a();
    }

    final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new S();
            }
            S s2 = this.d;
            s2.f2815a = colorStateList;
            s2.d = true;
        } else {
            this.d = null;
        }
        a();
    }

    final void h(ColorStateList colorStateList) {
        if (this.f3009e == null) {
            this.f3009e = new S();
        }
        S s2 = this.f3009e;
        s2.f2815a = colorStateList;
        s2.d = true;
        a();
    }

    final void i(PorterDuff.Mode mode) {
        if (this.f3009e == null) {
            this.f3009e = new S();
        }
        S s2 = this.f3009e;
        s2.f2816b = mode;
        s2.f2817c = true;
        a();
    }
}
