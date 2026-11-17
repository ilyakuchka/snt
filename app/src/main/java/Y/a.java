package Y;

import android.annotation.SuppressLint;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f1893a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f1894b;

    @SuppressLint({"NewApi"})
    public static boolean a() {
        try {
            if (f1894b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f1894b == null) {
                f1893a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f1894b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f1894b.invoke(null, Long.valueOf(f1893a))).booleanValue();
        } catch (Exception e2) {
            if (!(e2 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e2);
                return false;
            }
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }
}
