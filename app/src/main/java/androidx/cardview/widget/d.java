package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final double f3122a = Math.cos(Math.toRadians(45.0d));

    static float a(float f4, float f5, boolean z4) {
        if (!z4) {
            return f4;
        }
        return (float) (((1.0d - f3122a) * f5) + f4);
    }

    static float b(float f4, float f5, boolean z4) {
        if (!z4) {
            return f4 * 1.5f;
        }
        return (float) (((1.0d - f3122a) * f5) + (f4 * 1.5f));
    }
}
