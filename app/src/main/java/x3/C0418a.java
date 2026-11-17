package x3;

import android.view.View;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: x3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0418a {

    /* renamed from: a, reason: collision with root package name */
    protected static Method f8138a;

    static {
        try {
            Class cls = Integer.TYPE;
            try {
                Method method = Window.class.getMethod("setExtraFlags", cls, cls);
                method.setAccessible(true);
                f8138a = method;
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
        } catch (Exception unused) {
            f8138a = null;
        }
    }

    public static boolean a(Window window, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z4 = false;
        if (f8138a == null) {
            return false;
        }
        if (i2 == 0) {
            window.clearFlags(Integer.MIN_VALUE);
        } else {
            window.addFlags(Integer.MIN_VALUE);
            View decorView = window.getDecorView();
            if (i2 == 1) {
                decorView.setSystemUiVisibility(8208);
            } else {
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193) & (-17));
            }
        }
        if (i2 == 0) {
            window.clearFlags(67108864);
        } else {
            window.setFlags(67108864, 67108864);
        }
        try {
            if (i2 == 0) {
                f8138a.invoke(window, 0, 17);
            } else {
                f8138a.invoke(window, Integer.valueOf(i2 == 1 ? 17 : 1), 17);
            }
            z4 = true;
            return true;
        } catch (Exception unused) {
            return z4;
        }
    }
}
