package U3;

import L3.x;
import T3.d;
import U3.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* loaded from: classes.dex */
public final class h implements j {

    /* renamed from: a, reason: collision with root package name */
    private static final a f1736a = new a();

    public static final class a implements i.a {
        a() {
        }

        @Override // U3.i.a
        public final boolean a(SSLSocket sSLSocket) {
            d.a aVar = T3.d.f1627e;
            return T3.d.f1628f && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // U3.i.a
        public final j b(SSLSocket sSLSocket) {
            return new h();
        }
    }

    @Override // U3.j
    public final boolean a(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // U3.j
    public final String b(SSLSocket sSLSocket) {
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // U3.j
    public final boolean c() {
        d.a aVar = T3.d.f1627e;
        return T3.d.f1628f;
    }

    @Override // U3.j
    public final void d(SSLSocket sSLSocket, String str, List<? extends x> list) {
        f3.c.d(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array = ((ArrayList) T3.h.f1639a.a(list)).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
        }
    }
}
