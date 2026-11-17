package L3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    private final C0150a f386a;

    /* renamed from: b, reason: collision with root package name */
    private final Proxy f387b;

    /* renamed from: c, reason: collision with root package name */
    private final InetSocketAddress f388c;

    public D(C0150a c0150a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        f3.c.d(c0150a, "address");
        f3.c.d(inetSocketAddress, "socketAddress");
        this.f386a = c0150a;
        this.f387b = proxy;
        this.f388c = inetSocketAddress;
    }

    public final C0150a a() {
        return this.f386a;
    }

    public final Proxy b() {
        return this.f387b;
    }

    public final boolean c() {
        return this.f386a.k() != null && this.f387b.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress d() {
        return this.f388c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof D) {
            D d = (D) obj;
            if (f3.c.a(d.f386a, this.f386a) && f3.c.a(d.f387b, this.f387b) && f3.c.a(d.f388c, this.f388c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f388c.hashCode() + ((this.f387b.hashCode() + ((this.f386a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("Route{");
        sbD.append(this.f388c);
        sbD.append('}');
        return sbD.toString();
    }
}
