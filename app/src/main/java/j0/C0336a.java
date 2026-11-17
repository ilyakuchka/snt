package j0;

import android.util.Log;

/* renamed from: j0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0336a {
    public static void a(int i2) {
        if (-1 == i2) {
            return;
        }
        b("Expected -1 but got " + i2);
        throw null;
    }

    private static void b(String str) {
        Log.e("Assert", str);
        throw new AssertionError(str);
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            return;
        }
        b(str);
        throw null;
    }
}
