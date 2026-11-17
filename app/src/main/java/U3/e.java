package U3;

import U3.i;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class e implements i.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1729a = "com.google.android.gms.org.conscrypt";

    e() {
    }

    @Override // U3.i.a
    public final boolean a(SSLSocket sSLSocket) {
        return i3.f.A(sSLSocket.getClass().getName(), f3.c.h(this.f1729a, "."), false);
    }

    @Override // U3.i.a
    public final j b(SSLSocket sSLSocket) {
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (!f3.c.a(superclass.getSimpleName(), "OpenSSLSocketImpl")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError(f3.c.h("No OpenSSLSocketImpl superclass of socket of type ", cls));
            }
        }
        return new f(superclass);
    }
}
