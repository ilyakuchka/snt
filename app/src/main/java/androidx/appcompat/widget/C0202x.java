package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Objects;
import t.C0384b;

/* renamed from: androidx.appcompat.widget.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0202x {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f3073a;

    /* renamed from: b, reason: collision with root package name */
    private S f3074b;

    /* renamed from: c, reason: collision with root package name */
    private S f3075c;
    private S d;

    /* renamed from: e, reason: collision with root package name */
    private S f3076e;

    /* renamed from: f, reason: collision with root package name */
    private S f3077f;
    private S g;

    /* renamed from: h, reason: collision with root package name */
    private S f3078h;

    /* renamed from: i, reason: collision with root package name */
    private final C0203y f3079i;

    /* renamed from: j, reason: collision with root package name */
    private int f3080j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f3081k = -1;

    /* renamed from: l, reason: collision with root package name */
    private Typeface f3082l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3083m;

    /* renamed from: androidx.appcompat.widget.x$a */
    final class a extends x.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3084a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3085b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f3086c;

        a(int i2, int i4, WeakReference weakReference) {
            this.f3084a = i2;
            this.f3085b = i4;
            this.f3086c = weakReference;
        }

        @Override // x.d
        public final void d(Typeface typeface) {
            int i2 = this.f3084a;
            if (i2 != -1) {
                typeface = Typeface.create(typeface, i2, (this.f3085b & 2) != 0);
            }
            C0202x.this.g(this.f3086c, typeface);
        }
    }

    /* renamed from: androidx.appcompat.widget.x$b */
    final class b implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ TextView f3087i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Typeface f3088j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f3089k;

        b(TextView textView, Typeface typeface, int i2) {
            this.f3087i = textView;
            this.f3088j = typeface;
            this.f3089k = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3087i.setTypeface(this.f3088j, this.f3089k);
        }
    }

    C0202x(TextView textView) {
        this.f3073a = textView;
        this.f3079i = new C0203y(textView);
    }

    private void a(Drawable drawable, S s2) {
        if (drawable == null || s2 == null) {
            return;
        }
        int[] drawableState = this.f3073a.getDrawableState();
        int i2 = C0187h.d;
        L.m(drawable, s2, drawableState);
    }

    private static S c(Context context, C0187h c0187h, int i2) {
        ColorStateList colorStateListE = c0187h.e(context, i2);
        if (colorStateListE == null) {
            return null;
        }
        S s2 = new S();
        s2.d = true;
        s2.f2815a = colorStateListE;
        return s2;
    }

    private void k(Context context, U u) {
        String strN;
        this.f3080j = u.j(2, this.f3080j);
        int iJ = u.j(11, -1);
        this.f3081k = iJ;
        if (iJ != -1) {
            this.f3080j = (this.f3080j & 2) | 0;
        }
        if (!u.r(10) && !u.r(12)) {
            if (u.r(1)) {
                this.f3083m = false;
                int iJ2 = u.j(1, 1);
                if (iJ2 == 1) {
                    this.f3082l = Typeface.SANS_SERIF;
                    return;
                } else if (iJ2 == 2) {
                    this.f3082l = Typeface.SERIF;
                    return;
                } else {
                    if (iJ2 != 3) {
                        return;
                    }
                    this.f3082l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f3082l = null;
        int i2 = u.r(12) ? 12 : 10;
        int i4 = this.f3081k;
        int i5 = this.f3080j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceI = u.i(i2, this.f3080j, new a(i4, i5, new WeakReference(this.f3073a)));
                if (typefaceI != null) {
                    if (this.f3081k != -1) {
                        this.f3082l = Typeface.create(Typeface.create(typefaceI, 0), this.f3081k, (this.f3080j & 2) != 0);
                    } else {
                        this.f3082l = typefaceI;
                    }
                }
                this.f3083m = this.f3082l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f3082l != null || (strN = u.n(i2)) == null) {
            return;
        }
        if (this.f3081k != -1) {
            this.f3082l = Typeface.create(Typeface.create(strN, 0), this.f3081k, (this.f3080j & 2) != 0);
        } else {
            this.f3082l = Typeface.create(strN, this.f3080j);
        }
    }

    final void b() {
        if (this.f3074b != null || this.f3075c != null || this.d != null || this.f3076e != null) {
            Drawable[] compoundDrawables = this.f3073a.getCompoundDrawables();
            a(compoundDrawables[0], this.f3074b);
            a(compoundDrawables[1], this.f3075c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.f3076e);
        }
        if (this.f3077f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f3073a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f3077f);
        a(compoundDrawablesRelative[2], this.g);
    }

    final ColorStateList d() {
        S s2 = this.f3078h;
        if (s2 != null) {
            return s2.f2815a;
        }
        return null;
    }

    final PorterDuff.Mode e() {
        S s2 = this.f3078h;
        if (s2 != null) {
            return s2.f2816b;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    final void f(AttributeSet attributeSet, int i2) {
        boolean zA;
        boolean z4;
        String strN;
        String strN2;
        Context context = this.f3073a.getContext();
        C0187h c0187hB = C0187h.b();
        int[] iArr = Y1.a.f2120m;
        U u = U.u(context, attributeSet, iArr, i2, 0);
        TextView textView = this.f3073a;
        androidx.core.view.o.i(textView, textView.getContext(), iArr, attributeSet, u.q(), i2);
        int iM = u.m(0, -1);
        if (u.r(3)) {
            this.f3074b = c(context, c0187hB, u.m(3, 0));
        }
        if (u.r(1)) {
            this.f3075c = c(context, c0187hB, u.m(1, 0));
        }
        if (u.r(4)) {
            this.d = c(context, c0187hB, u.m(4, 0));
        }
        if (u.r(2)) {
            this.f3076e = c(context, c0187hB, u.m(2, 0));
        }
        if (u.r(5)) {
            this.f3077f = c(context, c0187hB, u.m(5, 0));
        }
        if (u.r(6)) {
            this.g = c(context, c0187hB, u.m(6, 0));
        }
        u.v();
        boolean z5 = this.f3073a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iM != -1) {
            U uS = U.s(context, iM, Y1.a.f2084B);
            if (z5 || !uS.r(14)) {
                zA = false;
                z4 = false;
            } else {
                zA = uS.a(14, false);
                z4 = true;
            }
            k(context, uS);
            strN = uS.r(15) ? uS.n(15) : null;
            strN2 = uS.r(13) ? uS.n(13) : null;
            uS.v();
        } else {
            zA = false;
            z4 = false;
            strN = null;
            strN2 = null;
        }
        U u2 = U.u(context, attributeSet, Y1.a.f2084B, i2, 0);
        if (!z5 && u2.r(14)) {
            zA = u2.a(14, false);
            z4 = true;
        }
        if (u2.r(15)) {
            strN = u2.n(15);
        }
        if (u2.r(13)) {
            strN2 = u2.n(13);
        }
        String str = strN2;
        if (u2.r(0) && u2.e(0, -1) == 0) {
            this.f3073a.setTextSize(0, 0.0f);
        }
        k(context, u2);
        u2.v();
        if (!z5 && z4) {
            this.f3073a.setAllCaps(zA);
        }
        Typeface typeface = this.f3082l;
        if (typeface != null) {
            if (this.f3081k == -1) {
                this.f3073a.setTypeface(typeface, this.f3080j);
            } else {
                this.f3073a.setTypeface(typeface);
            }
        }
        if (str != null) {
            this.f3073a.setFontVariationSettings(str);
        }
        if (strN != null) {
            this.f3073a.setTextLocales(LocaleList.forLanguageTags(strN));
        }
        this.f3079i.g(attributeSet, i2);
        if (this.f3079i.f() != 0) {
            int[] iArrE = this.f3079i.e();
            if (iArrE.length > 0) {
                if (this.f3073a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f3073a.setAutoSizeTextTypeUniformWithConfiguration(this.f3079i.c(), this.f3079i.b(), this.f3079i.d(), 0);
                } else {
                    this.f3073a.setAutoSizeTextTypeUniformWithPresetSizes(iArrE, 0);
                }
            }
        }
        U uT = U.t(context, attributeSet, Y1.a.f2121n);
        int iM2 = uT.m(8, -1);
        Drawable drawableC = iM2 != -1 ? c0187hB.c(context, iM2) : null;
        int iM3 = uT.m(13, -1);
        Drawable drawableC2 = iM3 != -1 ? c0187hB.c(context, iM3) : null;
        int iM4 = uT.m(9, -1);
        Drawable drawableC3 = iM4 != -1 ? c0187hB.c(context, iM4) : null;
        int iM5 = uT.m(6, -1);
        Drawable drawableC4 = iM5 != -1 ? c0187hB.c(context, iM5) : null;
        int iM6 = uT.m(10, -1);
        Drawable drawableC5 = iM6 != -1 ? c0187hB.c(context, iM6) : null;
        int iM7 = uT.m(7, -1);
        Drawable drawableC6 = iM7 != -1 ? c0187hB.c(context, iM7) : null;
        if (drawableC5 != null || drawableC6 != null) {
            Drawable[] compoundDrawablesRelative = this.f3073a.getCompoundDrawablesRelative();
            TextView textView2 = this.f3073a;
            if (drawableC5 == null) {
                drawableC5 = compoundDrawablesRelative[0];
            }
            if (drawableC2 == null) {
                drawableC2 = compoundDrawablesRelative[1];
            }
            if (drawableC6 == null) {
                drawableC6 = compoundDrawablesRelative[2];
            }
            if (drawableC4 == null) {
                drawableC4 = compoundDrawablesRelative[3];
            }
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableC5, drawableC2, drawableC6, drawableC4);
        } else if (drawableC != null || drawableC2 != null || drawableC3 != null || drawableC4 != null) {
            Drawable[] compoundDrawablesRelative2 = this.f3073a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.f3073a.getCompoundDrawables();
                TextView textView3 = this.f3073a;
                if (drawableC == null) {
                    drawableC = compoundDrawables[0];
                }
                if (drawableC2 == null) {
                    drawableC2 = compoundDrawables[1];
                }
                if (drawableC3 == null) {
                    drawableC3 = compoundDrawables[2];
                }
                if (drawableC4 == null) {
                    drawableC4 = compoundDrawables[3];
                }
                textView3.setCompoundDrawablesWithIntrinsicBounds(drawableC, drawableC2, drawableC3, drawableC4);
            } else {
                TextView textView4 = this.f3073a;
                Drawable drawable = compoundDrawablesRelative2[0];
                if (drawableC2 == null) {
                    drawableC2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable2 = compoundDrawablesRelative2[2];
                if (drawableC4 == null) {
                    drawableC4 = compoundDrawablesRelative2[3];
                }
                textView4.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawableC2, drawable2, drawableC4);
            }
        }
        if (uT.r(11)) {
            ColorStateList colorStateListC = uT.c(11);
            TextView textView5 = this.f3073a;
            Objects.requireNonNull(textView5);
            textView5.setCompoundDrawableTintList(colorStateListC);
        }
        if (uT.r(12)) {
            PorterDuff.Mode modeC = C.c(uT.j(12, -1), null);
            TextView textView6 = this.f3073a;
            Objects.requireNonNull(textView6);
            textView6.setCompoundDrawableTintMode(modeC);
        }
        int iE = uT.e(14, -1);
        int iE2 = uT.e(17, -1);
        int iE3 = uT.e(18, -1);
        uT.v();
        if (iE != -1) {
            TextView textView7 = this.f3073a;
            C0384b.g(iE);
            textView7.setFirstBaselineToTopHeight(iE);
        }
        if (iE2 != -1) {
            H.c.a(this.f3073a, iE2);
        }
        if (iE3 != -1) {
            H.c.b(this.f3073a, iE3);
        }
    }

    final void g(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f3083m) {
            this.f3082l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                int i2 = androidx.core.view.o.d;
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.f3080j));
                } else {
                    textView.setTypeface(typeface, this.f3080j);
                }
            }
        }
    }

    final void h(Context context, int i2) {
        String strN;
        U uS = U.s(context, i2, Y1.a.f2084B);
        if (uS.r(14)) {
            this.f3073a.setAllCaps(uS.a(14, false));
        }
        if (uS.r(0) && uS.e(0, -1) == 0) {
            this.f3073a.setTextSize(0, 0.0f);
        }
        k(context, uS);
        if (uS.r(13) && (strN = uS.n(13)) != null) {
            this.f3073a.setFontVariationSettings(strN);
        }
        uS.v();
        Typeface typeface = this.f3082l;
        if (typeface != null) {
            this.f3073a.setTypeface(typeface, this.f3080j);
        }
    }

    final void i(ColorStateList colorStateList) {
        if (this.f3078h == null) {
            this.f3078h = new S();
        }
        S s2 = this.f3078h;
        s2.f2815a = colorStateList;
        s2.d = colorStateList != null;
        this.f3074b = s2;
        this.f3075c = s2;
        this.d = s2;
        this.f3076e = s2;
        this.f3077f = s2;
        this.g = s2;
    }

    final void j(PorterDuff.Mode mode) {
        if (this.f3078h == null) {
            this.f3078h = new S();
        }
        S s2 = this.f3078h;
        s2.f2816b = mode;
        s2.f2817c = mode != null;
        this.f3074b = s2;
        this.f3075c = s2;
        this.d = s2;
        this.f3076e = s2;
        this.f3077f = s2;
        this.g = s2;
    }
}
