package L3;

import X3.g;
import e3.InterfaceC0299a;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final b f421c = new b();
    public static final g d = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final Set<c> f422a;

    /* renamed from: b, reason: collision with root package name */
    private final W3.c f423b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<c> f424a = new ArrayList();

        public final g a() {
            return new g(Z2.g.o(this.f424a));
        }
    }

    public static final class b {
        public final String a(Certificate certificate) {
            f3.c.d(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return f3.c.h("sha256/", b((X509Certificate) certificate).d());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final X3.g b(X509Certificate x509Certificate) {
            f3.c.d(x509Certificate, "<this>");
            g.a aVar = X3.g.f1847l;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            f3.c.c(encoded, "publicKey.encoded");
            return g.a.c(encoded).e("SHA-256");
        }
    }

    public static final class c {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            Objects.requireNonNull(cVar);
            if (!f3.c.a(null, null)) {
                return false;
            }
            Objects.requireNonNull(cVar);
            if (!f3.c.a(null, null)) {
                return false;
            }
            Objects.requireNonNull(cVar);
            return f3.c.a(null, null);
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append((String) null);
            sb.append('/');
            throw null;
        }
    }

    static final class d extends f3.d implements InterfaceC0299a<List<? extends X509Certificate>> {

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ List<Certificate> f426j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f427k;

        /* JADX WARN: Multi-variable type inference failed */
        d(List<? extends Certificate> list, String str) {
            this.f426j = list;
            this.f427k = str;
        }

        @Override // e3.InterfaceC0299a
        public final List<? extends X509Certificate> a() {
            W3.c cVarC = g.this.c();
            List<Certificate> listA = cVarC == null ? null : cVarC.a(this.f426j, this.f427k);
            if (listA == null) {
                listA = this.f426j;
            }
            ArrayList arrayList = new ArrayList(Z2.g.d(listA));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add((X509Certificate) ((Certificate) it.next()));
            }
            return arrayList;
        }
    }

    public g(Set set) {
        this.f422a = set;
        this.f423b = null;
    }

    public final void a(String str, List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        f3.c.d(str, "hostname");
        f3.c.d(list, "peerCertificates");
        b(str, new d(list, str));
    }

    public final void b(String str, InterfaceC0299a<? extends List<? extends X509Certificate>> interfaceC0299a) {
        f3.c.d(str, "hostname");
        Iterator<T> it = this.f422a.iterator();
        if (it.hasNext()) {
            Objects.requireNonNull((c) it.next());
            i3.f.A(null, "**.", false);
            throw null;
        }
    }

    public final W3.c c() {
        return this.f423b;
    }

    public final g d(W3.c cVar) {
        return f3.c.a(this.f423b, cVar) ? this : new g(this.f422a, cVar);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (f3.c.a(gVar.f422a, this.f422a) && f3.c.a(gVar.f423b, this.f423b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f422a.hashCode() + 1517) * 41;
        W3.c cVar = this.f423b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public g(Set<c> set, W3.c cVar) {
        f3.c.d(set, "pins");
        this.f422a = set;
        this.f423b = cVar;
    }
}
