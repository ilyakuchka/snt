package L3;

import L3.t;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: L3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0150a {

    /* renamed from: a, reason: collision with root package name */
    private final o f396a;

    /* renamed from: b, reason: collision with root package name */
    private final SocketFactory f397b;

    /* renamed from: c, reason: collision with root package name */
    private final SSLSocketFactory f398c;
    private final HostnameVerifier d;

    /* renamed from: e, reason: collision with root package name */
    private final g f399e;

    /* renamed from: f, reason: collision with root package name */
    private final InterfaceC0152c f400f;
    private final Proxy g;

    /* renamed from: h, reason: collision with root package name */
    private final ProxySelector f401h;

    /* renamed from: i, reason: collision with root package name */
    private final t f402i;

    /* renamed from: j, reason: collision with root package name */
    private final List<x> f403j;

    /* renamed from: k, reason: collision with root package name */
    private final List<k> f404k;

    public C0150a(String str, int i2, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, InterfaceC0152c interfaceC0152c, List list, List list2, ProxySelector proxySelector) {
        f3.c.d(str, "uriHost");
        f3.c.d(oVar, "dns");
        f3.c.d(socketFactory, "socketFactory");
        f3.c.d(interfaceC0152c, "proxyAuthenticator");
        f3.c.d(list, "protocols");
        f3.c.d(list2, "connectionSpecs");
        f3.c.d(proxySelector, "proxySelector");
        this.f396a = oVar;
        this.f397b = socketFactory;
        this.f398c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.f399e = gVar;
        this.f400f = interfaceC0152c;
        this.g = null;
        this.f401h = proxySelector;
        t.a aVar = new t.a();
        aVar.l(sSLSocketFactory != null ? "https" : "http");
        aVar.f(str);
        aVar.i(i2);
        this.f402i = aVar.b();
        this.f403j = M3.c.y(list);
        this.f404k = M3.c.y(list2);
    }

    public final g a() {
        return this.f399e;
    }

    public final List<k> b() {
        return this.f404k;
    }

    public final o c() {
        return this.f396a;
    }

    public final boolean d(C0150a c0150a) {
        f3.c.d(c0150a, "that");
        return f3.c.a(this.f396a, c0150a.f396a) && f3.c.a(this.f400f, c0150a.f400f) && f3.c.a(this.f403j, c0150a.f403j) && f3.c.a(this.f404k, c0150a.f404k) && f3.c.a(this.f401h, c0150a.f401h) && f3.c.a(this.g, c0150a.g) && f3.c.a(this.f398c, c0150a.f398c) && f3.c.a(this.d, c0150a.d) && f3.c.a(this.f399e, c0150a.f399e) && this.f402i.j() == c0150a.f402i.j();
    }

    public final HostnameVerifier e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0150a) {
            C0150a c0150a = (C0150a) obj;
            if (f3.c.a(this.f402i, c0150a.f402i) && d(c0150a)) {
                return true;
            }
        }
        return false;
    }

    public final List<x> f() {
        return this.f403j;
    }

    public final Proxy g() {
        return this.g;
    }

    public final InterfaceC0152c h() {
        return this.f400f;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f399e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.f398c) + ((Objects.hashCode(this.g) + ((this.f401h.hashCode() + ((this.f404k.hashCode() + ((this.f403j.hashCode() + ((this.f400f.hashCode() + ((this.f396a.hashCode() + ((this.f402i.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final ProxySelector i() {
        return this.f401h;
    }

    public final SocketFactory j() {
        return this.f397b;
    }

    public final SSLSocketFactory k() {
        return this.f398c;
    }

    public final t l() {
        return this.f402i;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("Address{");
        sbD.append(this.f402i.g());
        sbD.append(':');
        sbD.append(this.f402i.j());
        sbD.append(", ");
        Proxy proxy = this.g;
        sbD.append(proxy != null ? f3.c.h("proxy=", proxy) : f3.c.h("proxySelector=", this.f401h));
        sbD.append('}');
        return sbD.toString();
    }
}
