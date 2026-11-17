package L3;

import e3.InterfaceC0299a;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: e, reason: collision with root package name */
    public static final a f472e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final E f473a;

    /* renamed from: b, reason: collision with root package name */
    private final h f474b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Certificate> f475c;
    private final Y2.b d;

    public static final class a {

        /* renamed from: L3.r$a$a, reason: collision with other inner class name */
        static final class C0016a extends f3.d implements InterfaceC0299a<List<? extends Certificate>> {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ List<Certificate> f476i;

            /* JADX WARN: Multi-variable type inference failed */
            C0016a(List<? extends Certificate> list) {
                this.f476i = list;
            }

            @Override // e3.InterfaceC0299a
            public final List<? extends Certificate> a() {
                return this.f476i;
            }
        }

        public final r a(SSLSession sSLSession) throws IOException {
            List listM;
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            if (f3.c.a(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : f3.c.a(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException(f3.c.h("cipherSuite == ", cipherSuite));
            }
            h hVarB = h.f428b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (f3.c.a("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            E eA = E.f389j.a(protocol);
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                listM = peerCertificates != null ? M3.c.m(Arrays.copyOf(peerCertificates, peerCertificates.length)) : Z2.m.f2185i;
            } catch (SSLPeerUnverifiedException unused) {
                listM = Z2.m.f2185i;
            }
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            return new r(eA, hVarB, localCertificates != null ? M3.c.m(Arrays.copyOf(localCertificates, localCertificates.length)) : Z2.m.f2185i, new C0016a(listM));
        }
    }

    static final class b extends f3.d implements InterfaceC0299a<List<? extends Certificate>> {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ InterfaceC0299a<List<Certificate>> f477i;

        /* JADX WARN: Multi-variable type inference failed */
        b(InterfaceC0299a<? extends List<? extends Certificate>> interfaceC0299a) {
            this.f477i = interfaceC0299a;
        }

        @Override // e3.InterfaceC0299a
        public final List<? extends Certificate> a() {
            try {
                return this.f477i.a();
            } catch (SSLPeerUnverifiedException unused) {
                return Z2.m.f2185i;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(E e2, h hVar, List<? extends Certificate> list, InterfaceC0299a<? extends List<? extends Certificate>> interfaceC0299a) {
        f3.c.d(e2, "tlsVersion");
        f3.c.d(hVar, "cipherSuite");
        f3.c.d(list, "localCertificates");
        this.f473a = e2;
        this.f474b = hVar;
        this.f475c = list;
        this.d = Y2.c.n(new b(interfaceC0299a));
    }

    private final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        f3.c.c(type, "type");
        return type;
    }

    public final h a() {
        return this.f474b;
    }

    public final List<Certificate> c() {
        return this.f475c;
    }

    public final List<Certificate> d() {
        return (List) this.d.getValue();
    }

    public final E e() {
        return this.f473a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.f473a == this.f473a && f3.c.a(rVar.f474b, this.f474b) && f3.c.a(rVar.d(), d()) && f3.c.a(rVar.f475c, this.f475c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f475c.hashCode() + ((d().hashCode() + ((this.f474b.hashCode() + ((this.f473a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        List<Certificate> listD = d();
        ArrayList arrayList = new ArrayList(Z2.g.d(listD));
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sbD = D2.e.d("Handshake{tlsVersion=");
        sbD.append(this.f473a);
        sbD.append(" cipherSuite=");
        sbD.append(this.f474b);
        sbD.append(" peerCertificates=");
        sbD.append(string);
        sbD.append(" localCertificates=");
        List<Certificate> list = this.f475c;
        ArrayList arrayList2 = new ArrayList(Z2.g.d(list));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b((Certificate) it2.next()));
        }
        sbD.append(arrayList2);
        sbD.append('}');
        return sbD.toString();
    }
}
