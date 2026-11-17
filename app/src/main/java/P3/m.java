package P3;

import L3.C0150a;
import L3.D;
import L3.InterfaceC0154e;
import L3.p;
import L3.t;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final C0150a f1048a;

    /* renamed from: b, reason: collision with root package name */
    private final k f1049b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0154e f1050c;
    private final p d;

    /* renamed from: e, reason: collision with root package name */
    private List<? extends Proxy> f1051e;

    /* renamed from: f, reason: collision with root package name */
    private int f1052f;
    private List<? extends InetSocketAddress> g;

    /* renamed from: h, reason: collision with root package name */
    private final List<D> f1053h;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<D> f1054a;

        /* renamed from: b, reason: collision with root package name */
        private int f1055b;

        public a(List<D> list) {
            this.f1054a = list;
        }

        public final List<D> a() {
            return this.f1054a;
        }

        public final boolean b() {
            return this.f1055b < this.f1054a.size();
        }

        public final D c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<D> list = this.f1054a;
            int i2 = this.f1055b;
            this.f1055b = i2 + 1;
            return list.get(i2);
        }
    }

    public m(C0150a c0150a, k kVar, InterfaceC0154e interfaceC0154e, p pVar) {
        List<? extends Proxy> listY;
        f3.c.d(c0150a, "address");
        f3.c.d(kVar, "routeDatabase");
        f3.c.d(interfaceC0154e, "call");
        f3.c.d(pVar, "eventListener");
        this.f1048a = c0150a;
        this.f1049b = kVar;
        this.f1050c = interfaceC0154e;
        this.d = pVar;
        Z2.m mVar = Z2.m.f2185i;
        this.f1051e = mVar;
        this.g = mVar;
        this.f1053h = new ArrayList();
        t tVarL = c0150a.l();
        Proxy proxyG = c0150a.g();
        f3.c.d(tVarL, "url");
        if (proxyG != null) {
            listY = Z2.g.g(proxyG);
        } else {
            URI uriQ = tVarL.q();
            if (uriQ.getHost() == null) {
                listY = M3.c.m(Proxy.NO_PROXY);
            } else {
                List<Proxy> listSelect = c0150a.i().select(uriQ);
                if (listSelect == null || listSelect.isEmpty()) {
                    listY = M3.c.m(Proxy.NO_PROXY);
                } else {
                    f3.c.c(listSelect, "proxiesOrNull");
                    listY = M3.c.y(listSelect);
                }
            }
        }
        this.f1051e = listY;
        this.f1052f = 0;
    }

    private final boolean b() {
        return this.f1052f < this.f1051e.size();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<L3.D>] */
    public final boolean a() {
        return b() || (this.f1053h.isEmpty() ^ true);
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList, java.util.List<L3.D>] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.ArrayList, java.util.List<L3.D>] */
    public final a c() throws IOException {
        String strG;
        int iJ;
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            if (!b()) {
                StringBuilder sbD = D2.e.d("No route to ");
                sbD.append(this.f1048a.l().g());
                sbD.append("; exhausted proxy configurations: ");
                sbD.append(this.f1051e);
                throw new SocketException(sbD.toString());
            }
            List<? extends Proxy> list = this.f1051e;
            int i2 = this.f1052f;
            this.f1052f = i2 + 1;
            Proxy proxy = list.get(i2);
            ArrayList arrayList2 = new ArrayList();
            this.g = arrayList2;
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                strG = this.f1048a.l().g();
                iJ = this.f1048a.l().j();
            } else {
                SocketAddress socketAddressAddress = proxy.address();
                if (!(socketAddressAddress instanceof InetSocketAddress)) {
                    throw new IllegalArgumentException(f3.c.h("Proxy.address() is not an InetSocketAddress: ", socketAddressAddress.getClass()).toString());
                }
                f3.c.c(socketAddressAddress, "proxyAddress");
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                InetAddress address = inetSocketAddress.getAddress();
                if (address == null) {
                    strG = inetSocketAddress.getHostName();
                    f3.c.c(strG, "hostName");
                } else {
                    strG = address.getHostAddress();
                    f3.c.c(strG, "address.hostAddress");
                }
                iJ = inetSocketAddress.getPort();
            }
            boolean z4 = false;
            if (1 <= iJ && iJ < 65536) {
                z4 = true;
            }
            if (!z4) {
                throw new SocketException("No route to " + strG + ':' + iJ + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList2.add(InetSocketAddress.createUnresolved(strG, iJ));
            } else {
                p pVar = this.d;
                InterfaceC0154e interfaceC0154e = this.f1050c;
                Objects.requireNonNull(pVar);
                f3.c.d(interfaceC0154e, "call");
                f3.c.d(strG, "domainName");
                List<InetAddress> listB = this.f1048a.c().b(strG);
                if (listB.isEmpty()) {
                    throw new UnknownHostException(this.f1048a.c() + " returned no addresses for " + strG);
                }
                p pVar2 = this.d;
                InterfaceC0154e interfaceC0154e2 = this.f1050c;
                Objects.requireNonNull(pVar2);
                f3.c.d(interfaceC0154e2, "call");
                Iterator<InetAddress> it = listB.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new InetSocketAddress(it.next(), iJ));
                }
            }
            Iterator<? extends InetSocketAddress> it2 = this.g.iterator();
            while (it2.hasNext()) {
                D d = new D(this.f1048a, proxy, it2.next());
                if (this.f1049b.c(d)) {
                    this.f1053h.add(d);
                } else {
                    arrayList.add(d);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            Z2.g.c(arrayList, this.f1053h);
            this.f1053h.clear();
        }
        return new a(arrayList);
    }
}
