package f3;

import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        g(nullPointerException, c.class.getName());
        throw nullPointerException;
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(D2.e.c(str, " must not be null"));
        g(nullPointerException, c.class.getName());
        throw nullPointerException;
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
        g(nullPointerException, c.class.getName());
        throw nullPointerException;
    }

    public static int e(int i2, int i4) {
        if (i2 < i4) {
            return -1;
        }
        return i2 == i4 ? 0 : 1;
    }

    public static final Iterator f(Object[] objArr) {
        d(objArr, "array");
        return new a(objArr);
    }

    static Throwable g(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.equals(stackTrace[i4].getClassName())) {
                i2 = i4;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return th;
    }

    public static String h(String str, Object obj) {
        return str + obj;
    }

    public static void i(String str) {
        Y2.g gVar = new Y2.g(C2.c.a("lateinit property ", str, " has not been initialized"));
        g(gVar, c.class.getName());
        throw gVar;
    }
}
