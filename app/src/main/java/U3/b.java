package U3;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class b extends W3.c {

    /* renamed from: a, reason: collision with root package name */
    private final X509TrustManager f1723a;

    /* renamed from: b, reason: collision with root package name */
    private final X509TrustManagerExtensions f1724b;

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        this.f1723a = x509TrustManager;
        this.f1724b = x509TrustManagerExtensions;
    }

    @Override // W3.c
    public final List<Certificate> a(List<? extends Certificate> list, String str) throws CertificateException, SSLPeerUnverifiedException {
        f3.c.d(list, "chain");
        f3.c.d(str, "hostname");
        Object[] array = list.toArray(new X509Certificate[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        try {
            List<X509Certificate> listCheckServerTrusted = this.f1724b.checkServerTrusted((X509Certificate[]) array, "RSA", str);
            f3.c.c(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException.initCause(e2);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f1723a == this.f1723a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f1723a);
    }
}
