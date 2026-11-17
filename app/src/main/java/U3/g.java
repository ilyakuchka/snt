package U3;

import L3.x;
import T3.c;
import U3.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* loaded from: classes.dex */
public final class g implements j {

    /* renamed from: a, reason: collision with root package name */
    private static final a f1735a = new a();

    public static final class a implements i.a {
        a() {
        }

        @Override // U3.i.a
        public final boolean a(SSLSocket sSLSocket) {
            c.a aVar = T3.c.f1625e;
            return T3.c.f1626f && (sSLSocket instanceof BCSSLSocket);
        }

        @Override // U3.i.a
        public final j b(SSLSocket sSLSocket) {
            return new g();
        }
    }

    @Override // U3.j
    public final boolean a(SSLSocket sSLSocket) {
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // U3.j
    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : f3.c.a(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // U3.j
    public final boolean c() {
        c.a aVar = T3.c.f1625e;
        return T3.c.f1626f;
    }

    @Override // U3.j
    public final void d(SSLSocket sSLSocket, String str, List<? extends x> list) {
        f3.c.d(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            Object[] array = ((ArrayList) T3.h.f1639a.a(list)).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }
}
