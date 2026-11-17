package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import i.C0333a;

/* renamed from: androidx.appcompat.widget.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0186g {

    /* renamed from: a, reason: collision with root package name */
    private final CompoundButton f3013a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f3014b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f3015c = null;
    private boolean d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3016e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3017f;

    C0186g(CompoundButton compoundButton) {
        this.f3013a = compoundButton;
    }

    final void a() {
        Drawable buttonDrawable = this.f3013a.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.d || this.f3016e) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.d) {
                    drawableMutate.setTintList(this.f3014b);
                }
                if (this.f3016e) {
                    drawableMutate.setTintMode(this.f3015c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f3013a.getDrawableState());
                }
                this.f3013a.setButtonDrawable(drawableMutate);
            }
        }
    }

    final void b(AttributeSet attributeSet, int i2) {
        int iM;
        int iM2;
        Context context = this.f3013a.getContext();
        int[] iArr = Y1.a.f2123q;
        U u = U.u(context, attributeSet, iArr, i2, 0);
        CompoundButton compoundButton = this.f3013a;
        androidx.core.view.o.i(compoundButton, compoundButton.getContext(), iArr, attributeSet, u.q(), i2);
        boolean z4 = true;
        try {
            if (!u.r(1) || (iM2 = u.m(1, 0)) == 0) {
                z4 = false;
            } else {
                try {
                    CompoundButton compoundButton2 = this.f3013a;
                    compoundButton2.setButtonDrawable(C0333a.a(compoundButton2.getContext(), iM2));
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (!z4 && u.r(0) && (iM = u.m(0, 0)) != 0) {
                CompoundButton compoundButton3 = this.f3013a;
                compoundButton3.setButtonDrawable(C0333a.a(compoundButton3.getContext(), iM));
            }
            if (u.r(2)) {
                this.f3013a.setButtonTintList(u.c(2));
            }
            if (u.r(3)) {
                this.f3013a.setButtonTintMode(C.c(u.j(3, -1), null));
            }
        } finally {
            u.v();
        }
    }

    final void c() {
        if (this.f3017f) {
            this.f3017f = false;
        } else {
            this.f3017f = true;
            a();
        }
    }
}
