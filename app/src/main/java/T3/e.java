package T3;

import L3.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class e extends h {
    private final Method d;

    /* renamed from: e, reason: collision with root package name */
    private final Method f1630e;

    /* renamed from: f, reason: collision with root package name */
    private final Method f1631f;
    private final Class<?> g;

    /* renamed from: h, reason: collision with root package name */
    private final Class<?> f1632h;

    private static final class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f1633a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f1634b;

        /* renamed from: c, reason: collision with root package name */
        private String f1635c;

        public a(List<String> list) {
            this.f1633a = list;
        }

        public final String a() {
            return this.f1635c;
        }

        public final boolean b() {
            return this.f1634b;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            f3.c.d(obj, "proxy");
            f3.c.d(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (f3.c.a(name, "supports") && f3.c.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (f3.c.a(name, "unsupported") && f3.c.a(Void.TYPE, returnType)) {
                this.f1634b = true;
                return null;
            }
            if (f3.c.a(name, "protocols")) {
                if (objArr.length == 0) {
                    return this.f1633a;
                }
            }
            if ((!f3.c.a(name, "selectProtocol") && !f3.c.a(name, "select")) || !f3.c.a(String.class, returnType) || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!f3.c.a(name, "protocolSelected") && !f3.c.a(name, "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                }
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.String");
                this.f1635c = (String) obj2;
                return null;
            }
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) obj3;
            int size = list.size();
            if (size >= 0) {
                int i2 = 0;
                while (true) {
                    int i4 = i2 + 1;
                    Object obj4 = list.get(i2);
                    Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) obj4;
                    if (this.f1633a.contains(str)) {
                        this.f1635c = str;
                        return str;
                    }
                    if (i2 == size) {
                        break;
                    }
                    i2 = i4;
                }
            }
            String str2 = this.f1633a.get(0);
            this.f1635c = str2;
            return str2;
        }
    }

    public e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.d = method;
        this.f1630e = method2;
        this.f1631f = method3;
        this.g = cls;
        this.f1632h = cls2;
    }

    @Override // T3.h
    public final void b(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f1631f.invoke(null, sSLSocket);
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        } catch (InvocationTargetException e4) {
            throw new AssertionError("failed to remove ALPN", e4);
        }
    }

    @Override // T3.h
    public final void e(SSLSocket sSLSocket, String str, List<? extends x> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        f3.c.d(list, "protocols");
        try {
            this.d.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.g, this.f1632h}, new a(h.f1639a.a(list))));
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        } catch (InvocationTargetException e4) {
            throw new AssertionError("failed to set ALPN", e4);
        }
    }

    @Override // T3.h
    public final String f(SSLSocket sSLSocket) throws IllegalArgumentException {
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f1630e.invoke(null, sSLSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            a aVar = (a) invocationHandler;
            if (!aVar.b() && aVar.a() == null) {
                i("ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 4, null);
                return null;
            }
            if (aVar.b()) {
                return null;
            }
            return aVar.a();
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        } catch (InvocationTargetException e4) {
            throw new AssertionError("failed to get ALPN selected protocol", e4);
        }
    }
}
