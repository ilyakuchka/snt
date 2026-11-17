package T3;

import L3.w;
import L3.x;
import T3.a;
import T3.b;
import T3.c;
import T3.d;
import T3.f;
import T3.g;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1639a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile h f1640b;

    /* renamed from: c, reason: collision with root package name */
    private static final Logger f1641c;

    public static final class a {
        public final List<String> a(List<? extends x> list) {
            f3.c.d(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((x) obj) != x.f545k) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Z2.g.d(arrayList));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((x) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] b(List<? extends x> list) {
            f3.c.d(list, "protocols");
            X3.d dVar = new X3.d();
            Iterator it = ((ArrayList) a(list)).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                dVar.u0(str.length());
                dVar.y0(str);
            }
            return dVar.P();
        }

        public final boolean c() {
            return f3.c.a("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    static {
        h fVar;
        a aVar = new a();
        f1639a = aVar;
        e eVar = null;
        if (aVar.c()) {
            U3.c cVar = U3.c.f1725a;
            U3.c.b();
            a.C0039a c0039a = T3.a.f1623e;
            fVar = T3.a.f1624f ? new T3.a() : null;
            if (fVar == null) {
                b.a aVar2 = b.d;
                b.a aVar3 = b.d;
                f3.c.b(null);
                throw null;
            }
        } else if (f3.c.a("Conscrypt", Security.getProviders()[0].getName())) {
            d.a aVar4 = d.f1627e;
            fVar = d.f1628f ? new d(null) : null;
            if (fVar == null) {
                if (f3.c.a("BC", Security.getProviders()[0].getName())) {
                    c.a aVar5 = c.f1625e;
                    fVar = c.f1626f ? new c(null) : null;
                    if (fVar == null) {
                        if (f3.c.a("OpenJSSE", Security.getProviders()[0].getName())) {
                            g.a aVar6 = g.f1637e;
                            fVar = g.f1638f ? new g(null) : null;
                            if (fVar == null) {
                                f.a aVar7 = f.d;
                                fVar = f.f1636e ? new f() : null;
                                if (fVar == null) {
                                    String property = System.getProperty("java.specification.version", "unknown");
                                    try {
                                        f3.c.c(property, "jvmVersion");
                                    } catch (NumberFormatException unused) {
                                    }
                                    if (Integer.parseInt(property) < 9) {
                                        try {
                                            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                            Class<?> cls2 = Class.forName(f3.c.h("org.eclipse.jetty.alpn.ALPN", "$Provider"), true, null);
                                            Class<?> cls3 = Class.forName(f3.c.h("org.eclipse.jetty.alpn.ALPN", "$ClientProvider"), true, null);
                                            Class<?> cls4 = Class.forName(f3.c.h("org.eclipse.jetty.alpn.ALPN", "$ServerProvider"), true, null);
                                            Method method = cls.getMethod("put", SSLSocket.class, cls2);
                                            Method method2 = cls.getMethod("get", SSLSocket.class);
                                            Method method3 = cls.getMethod("remove", SSLSocket.class);
                                            f3.c.c(method, "putMethod");
                                            f3.c.c(method2, "getMethod");
                                            f3.c.c(method3, "removeMethod");
                                            f3.c.c(cls3, "clientProviderClass");
                                            f3.c.c(cls4, "serverProviderClass");
                                            eVar = new e(method, method2, method3, cls3, cls4);
                                        } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                                        }
                                    }
                                    fVar = eVar != null ? eVar : new h();
                                }
                            }
                        }
                    }
                }
            }
        }
        f1640b = fVar;
        f1641c = Logger.getLogger(w.class.getName());
    }

    public void b(SSLSocket sSLSocket) {
    }

    public W3.c c(X509TrustManager x509TrustManager) {
        return new W3.a(d(x509TrustManager));
    }

    public W3.e d(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        f3.c.c(acceptedIssuers, "trustManager.acceptedIssuers");
        return new W3.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(SSLSocket sSLSocket, String str, List<x> list) {
        f3.c.d(list, "protocols");
    }

    public String f(SSLSocket sSLSocket) {
        return null;
    }

    public Object g(String str) {
        if (f1641c.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean h(String str) {
        f3.c.d(str, "hostname");
        return true;
    }

    public final void i(String str, int i2, Throwable th) {
        f3.c.d(str, "message");
        f1641c.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public SSLContext j() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        f3.c.c(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory k(X509TrustManager x509TrustManager) throws KeyManagementException {
        try {
            SSLContext sSLContextJ = j();
            sSLContextJ.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextJ.getSocketFactory();
            f3.c.c(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e2) {
            throw new AssertionError(f3.c.h("No System TLS: ", e2), e2);
        }
    }

    public X509TrustManager l() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        f3.c.b(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            Objects.requireNonNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return (X509TrustManager) trustManager;
        }
        String string = Arrays.toString(trustManagers);
        f3.c.c(string, "toString(this)");
        throw new IllegalStateException(f3.c.h("Unexpected default trust managers: ", string).toString());
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
