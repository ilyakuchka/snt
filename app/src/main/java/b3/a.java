package b3;

import f3.c;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b3.a$a, reason: collision with other inner class name */
    private static final class C0080a {

        /* renamed from: a, reason: collision with root package name */
        public static final Method f4377a;

        /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            c.c(methods, "throwableMethods");
            int length = methods.length;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                if (c.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    c.c(parameterTypes, "it.parameterTypes");
                    boolean z4 = c.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class);
                    if (z4) {
                        method = method2;
                        break;
                    }
                    i2++;
                }
            }
            f4377a = method;
            int length2 = methods.length;
            for (int i4 = 0; i4 < length2 && !c.a(methods[i4].getName(), "getSuppressed"); i4++) {
            }
        }
    }

    public void a(Throwable th, Throwable th2) {
        c.d(th, "cause");
        c.d(th2, "exception");
        Method method = C0080a.f4377a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
