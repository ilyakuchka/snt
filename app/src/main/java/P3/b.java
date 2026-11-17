package P3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<L3.k> f974a;

    /* renamed from: b, reason: collision with root package name */
    private int f975b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f976c;
    private boolean d;

    public b(List<L3.k> list) {
        f3.c.d(list, "connectionSpecs");
        this.f974a = list;
    }

    public final L3.k a(SSLSocket sSLSocket) throws IOException {
        L3.k kVar;
        boolean z4;
        int i2 = this.f975b;
        int size = this.f974a.size();
        while (true) {
            if (i2 >= size) {
                kVar = null;
                break;
            }
            int i4 = i2 + 1;
            kVar = this.f974a.get(i2);
            if (kVar.e(sSLSocket)) {
                this.f975b = i4;
                break;
            }
            i2 = i4;
        }
        if (kVar == null) {
            StringBuilder sbD = D2.e.d("Unable to find acceptable protocols. isFallback=");
            sbD.append(this.d);
            sbD.append(", modes=");
            sbD.append(this.f974a);
            sbD.append(", supported protocols=");
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            f3.c.b(enabledProtocols);
            String string = Arrays.toString(enabledProtocols);
            f3.c.c(string, "toString(this)");
            sbD.append(string);
            throw new UnknownServiceException(sbD.toString());
        }
        int i5 = this.f975b;
        int size2 = this.f974a.size();
        while (true) {
            if (i5 >= size2) {
                z4 = false;
                break;
            }
            int i6 = i5 + 1;
            if (this.f974a.get(i5).e(sSLSocket)) {
                z4 = true;
                break;
            }
            i5 = i6;
        }
        this.f976c = z4;
        kVar.c(sSLSocket, this.d);
        return kVar;
    }

    public final boolean b(IOException iOException) {
        this.d = true;
        return (!this.f976c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !(iOException instanceof SSLException)) ? false : true;
    }
}
