package U3;

import L3.x;
import T3.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public class f implements j {

    /* renamed from: f, reason: collision with root package name */
    public static final a f1730f = new a();
    private static final e g = new e();

    /* renamed from: a, reason: collision with root package name */
    private final Class<? super SSLSocket> f1731a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f1732b;

    /* renamed from: c, reason: collision with root package name */
    private final Method f1733c;
    private final Method d;

    /* renamed from: e, reason: collision with root package name */
    private final Method f1734e;

    public static final class a {
    }

    public f(Class<? super SSLSocket> cls) throws NoSuchMethodException, SecurityException {
        this.f1731a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        f3.c.c(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f1732b = declaredMethod;
        this.f1733c = cls.getMethod("setHostname", String.class);
        this.d = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f1734e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // U3.j
    public final boolean a(SSLSocket sSLSocket) {
        return this.f1731a.isInstance(sSLSocket);
    }

    @Override // U3.j
    public final String b(SSLSocket sSLSocket) {
        if (!this.f1731a.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.d.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            return new String(bArr, i3.c.f6339b);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if ((cause instanceof NullPointerException) && f3.c.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e4);
        }
    }

    @Override // U3.j
    public final boolean c() {
        b.a aVar = T3.b.d;
        b.a aVar2 = T3.b.d;
        return false;
    }

    @Override // U3.j
    public final void d(SSLSocket sSLSocket, String str, List<? extends x> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        f3.c.d(list, "protocols");
        if (this.f1731a.isInstance(sSLSocket)) {
            try {
                this.f1732b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f1733c.invoke(sSLSocket, str);
                }
                this.f1734e.invoke(sSLSocket, T3.h.f1639a.b(list));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e4) {
                throw new AssertionError(e4);
            }
        }
    }
}
