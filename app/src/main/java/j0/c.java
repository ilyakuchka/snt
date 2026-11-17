package j0;

import android.os.Build;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6360a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f6361b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        f6360a = i2 >= 17;
        f6361b = i2 >= 22;
    }

    public static boolean a() {
        return f6360a;
    }

    public static boolean b() {
        return f6361b;
    }
}
