package U3;

import L3.x;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class i implements j {

    /* renamed from: a, reason: collision with root package name */
    private final a f1737a;

    /* renamed from: b, reason: collision with root package name */
    private j f1738b;

    public interface a {
        boolean a(SSLSocket sSLSocket);

        j b(SSLSocket sSLSocket);
    }

    public i(a aVar) {
        f3.c.d(aVar, "socketAdapterFactory");
        this.f1737a = aVar;
    }

    private final synchronized j e(SSLSocket sSLSocket) {
        if (this.f1738b == null && this.f1737a.a(sSLSocket)) {
            this.f1738b = this.f1737a.b(sSLSocket);
        }
        return this.f1738b;
    }

    @Override // U3.j
    public final boolean a(SSLSocket sSLSocket) {
        return this.f1737a.a(sSLSocket);
    }

    @Override // U3.j
    public final String b(SSLSocket sSLSocket) {
        j jVarE = e(sSLSocket);
        if (jVarE == null) {
            return null;
        }
        return jVarE.b(sSLSocket);
    }

    @Override // U3.j
    public final boolean c() {
        return true;
    }

    @Override // U3.j
    public final void d(SSLSocket sSLSocket, String str, List<? extends x> list) {
        f3.c.d(list, "protocols");
        j jVarE = e(sSLSocket);
        if (jVarE == null) {
            return;
        }
        jVarE.d(sSLSocket, str, list);
    }
}
