package T3;

import L3.x;
import U3.i;
import U3.j;
import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: e, reason: collision with root package name */
    public static final C0039a f1623e = new C0039a();

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f1624f = f3.c.a("Dalvik", System.getProperty("java.vm.name"));
    private final List<j> d;

    /* renamed from: T3.a$a, reason: collision with other inner class name */
    public static final class C0039a {
    }

    public a() {
        j[] jVarArr = new j[4];
        jVarArr[0] = f3.c.a("Dalvik", System.getProperty("java.vm.name")) ? new U3.a() : null;
        jVarArr[1] = new i(U3.f.g);
        jVarArr[2] = new i(U3.h.f1736a);
        jVarArr[3] = new i(U3.g.f1735a);
        List listH = Z2.g.h(jVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) listH).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((j) next).c()) {
                arrayList.add(next);
            }
        }
        this.d = arrayList;
    }

    @Override // T3.h
    public final W3.c c(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        U3.b bVar = x509TrustManagerExtensions != null ? new U3.b(x509TrustManager, x509TrustManagerExtensions) : null;
        return bVar == null ? new W3.a(d(x509TrustManager)) : bVar;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<U3.j>] */
    @Override // T3.h
    public final void e(SSLSocket sSLSocket, String str, List<? extends x> list) {
        Object next;
        f3.c.d(list, "protocols");
        Iterator it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((j) next).a(sSLSocket)) {
                    break;
                }
            }
        }
        j jVar = (j) next;
        if (jVar == null) {
            return;
        }
        jVar.d(sSLSocket, str, list);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.ArrayList, java.util.List<U3.j>] */
    @Override // T3.h
    public final String f(SSLSocket sSLSocket) {
        Object next;
        Iterator it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((j) next).a(sSLSocket)) {
                break;
            }
        }
        j jVar = (j) next;
        if (jVar == null) {
            return null;
        }
        return jVar.b(sSLSocket);
    }

    @Override // T3.h
    @SuppressLint({"NewApi"})
    public final boolean h(String str) {
        f3.c.d(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
