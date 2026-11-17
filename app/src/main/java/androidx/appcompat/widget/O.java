package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import y.C0419a;

/* loaded from: classes.dex */
public final class O {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f2809a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f2810b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f2811c = {R.attr.state_focused};
    static final int[] d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f2812e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f2813f = new int[0];
    private static final int[] g = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Y1.a.f2122o);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i2) {
        ColorStateList colorStateListD = d(context, i2);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(f2810b, colorStateListD.getDefaultColor());
        }
        ThreadLocal<TypedValue> threadLocal = f2809a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f4 = typedValue.getFloat();
        int iC = c(context, i2);
        int iRound = Math.round(Color.alpha(iC) * f4);
        int i4 = C0419a.f8139a;
        if (iRound < 0 || iRound > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (iC & 16777215) | (iRound << 24);
    }

    public static int c(Context context, int i2) {
        int[] iArr = g;
        iArr[0] = i2;
        U uT = U.t(context, null, iArr);
        try {
            return uT.b();
        } finally {
            uT.v();
        }
    }

    public static ColorStateList d(Context context, int i2) {
        int[] iArr = g;
        iArr[0] = i2;
        U uT = U.t(context, null, iArr);
        try {
            return uT.c(0);
        } finally {
            uT.v();
        }
    }
}
