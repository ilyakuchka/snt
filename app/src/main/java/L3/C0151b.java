package L3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* renamed from: L3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0151b implements InterfaceC0152c, m, o {
    @Override // L3.m
    public void a(t tVar, List list) {
        f3.c.d(tVar, "url");
    }

    @Override // L3.o
    public List b(String str) throws UnknownHostException {
        f3.c.d(str, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            f3.c.c(allByName, "getAllByName(hostname)");
            return Z2.d.e(allByName);
        } catch (NullPointerException e2) {
            UnknownHostException unknownHostException = new UnknownHostException(f3.c.h("Broken system behaviour for dns lookup of ", str));
            unknownHostException.initCause(e2);
            throw unknownHostException;
        }
    }

    @Override // L3.m
    public void c(t tVar) {
        f3.c.d(tVar, "url");
    }

    @Override // L3.InterfaceC0152c
    public y d(D d, A a2) {
        f3.c.d(a2, "response");
        return null;
    }
}
