package y;

import android.graphics.Color;

/* renamed from: y.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0419a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f8139a = 0;

    static {
        new ThreadLocal();
    }

    public static int a(int i2, int i4) {
        int iAlpha = Color.alpha(i4);
        int iAlpha2 = Color.alpha(i2);
        int i5 = 255 - (((255 - iAlpha2) * (255 - iAlpha)) / 255);
        return Color.argb(i5, b(Color.red(i2), iAlpha2, Color.red(i4), iAlpha, i5), b(Color.green(i2), iAlpha2, Color.green(i4), iAlpha, i5), b(Color.blue(i2), iAlpha2, Color.blue(i4), iAlpha, i5));
    }

    private static int b(int i2, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        return (((255 - i4) * (i5 * i6)) + ((i2 * 255) * i4)) / (i7 * 255);
    }
}
