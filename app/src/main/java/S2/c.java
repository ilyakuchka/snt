package S2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static Method f1362a;

    public static String a(String str, String str2) {
        if (f1362a == null) {
            try {
                f1362a = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
            }
        }
        Method method = f1362a;
        if (method != null) {
            try {
                return (String) method.invoke(null, str);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            }
        }
        return str2;
    }
}
