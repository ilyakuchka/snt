package L3;

import L3.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: e, reason: collision with root package name */
    public static final k f446e;

    /* renamed from: f, reason: collision with root package name */
    public static final k f447f;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f448a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f449b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f450c;
    private final String[] d;

    static {
        h hVar = h.f441r;
        h hVar2 = h.f442s;
        h hVar3 = h.f443t;
        h hVar4 = h.f436l;
        h hVar5 = h.f438n;
        h hVar6 = h.f437m;
        h hVar7 = h.f439o;
        h hVar8 = h.f440q;
        h hVar9 = h.p;
        h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9};
        h[] hVarArr2 = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, h.f434j, h.f435k, h.f432h, h.f433i, h.f431f, h.g, h.f430e};
        a aVar = new a(true);
        aVar.b((h[]) Arrays.copyOf(hVarArr, 9));
        E e2 = E.f390k;
        E e4 = E.f391l;
        aVar.e(e2, e4);
        aVar.d();
        aVar.a();
        a aVar2 = new a(true);
        aVar2.b((h[]) Arrays.copyOf(hVarArr2, 16));
        aVar2.e(e2, e4);
        aVar2.d();
        f446e = aVar2.a();
        a aVar3 = new a(true);
        aVar3.b((h[]) Arrays.copyOf(hVarArr2, 16));
        aVar3.e(e2, e4, E.f392m, E.f393n);
        aVar3.d();
        aVar3.a();
        f447f = new a(false).a();
    }

    public k(boolean z4, boolean z5, String[] strArr, String[] strArr2) {
        this.f448a = z4;
        this.f449b = z5;
        this.f450c = strArr;
        this.d = strArr2;
    }

    public final void c(SSLSocket sSLSocket, boolean z4) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f450c != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            f3.c.c(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            String[] strArr = this.f450c;
            h.b bVar = h.f428b;
            enabledCipherSuites = M3.c.q(enabledCipherSuites2, strArr, h.f429c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.d != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            f3.c.c(enabledProtocols2, "sslSocket.enabledProtocols");
            enabledProtocols = M3.c.q(enabledProtocols2, this.d, a3.c.f2214a);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        f3.c.c(supportedCipherSuites, "supportedCipherSuites");
        h.b bVar2 = h.f428b;
        Comparator comparator = h.f429c;
        byte[] bArr = M3.c.f596a;
        int length = supportedCipherSuites.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else {
                if (((h.a) comparator).compare(supportedCipherSuites[i2], "TLS_FALLBACK_SCSV") == 0) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (z4 && i2 != -1) {
            f3.c.c(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i2];
            f3.c.c(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            f3.c.c(objArrCopyOf, "copyOf(this, newSize)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        a aVar = new a(this);
        f3.c.c(enabledCipherSuites, "cipherSuitesIntersection");
        aVar.c((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        f3.c.c(enabledProtocols, "tlsVersionsIntersection");
        aVar.f((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        k kVarA = aVar.a();
        if (kVarA.h() != null) {
            sSLSocket.setEnabledProtocols(kVarA.d);
        }
        if (kVarA.d() != null) {
            sSLSocket.setEnabledCipherSuites(kVarA.f450c);
        }
    }

    public final List<h> d() {
        String[] strArr = this.f450c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(h.f428b.b(str));
        }
        return Z2.g.m(arrayList);
    }

    public final boolean e(SSLSocket sSLSocket) {
        if (!this.f448a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !M3.c.k(strArr, sSLSocket.getEnabledProtocols(), a3.c.f2214a)) {
            return false;
        }
        String[] strArr2 = this.f450c;
        if (strArr2 == null) {
            return true;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        h.b bVar = h.f428b;
        return M3.c.k(strArr2, enabledCipherSuites, h.f429c);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z4 = this.f448a;
        k kVar = (k) obj;
        if (z4 != kVar.f448a) {
            return false;
        }
        return !z4 || (Arrays.equals(this.f450c, kVar.f450c) && Arrays.equals(this.d, kVar.d) && this.f449b == kVar.f449b);
    }

    public final boolean f() {
        return this.f448a;
    }

    public final boolean g() {
        return this.f449b;
    }

    public final List<E> h() {
        String[] strArr = this.d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(E.f389j.a(str));
        }
        return Z2.g.m(arrayList);
    }

    public final int hashCode() {
        if (!this.f448a) {
            return 17;
        }
        String[] strArr = this.f450c;
        int iHashCode = (527 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String[] strArr2 = this.d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f449b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f448a) {
            return "ConnectionSpec()";
        }
        StringBuilder sbD = D2.e.d("ConnectionSpec(cipherSuites=");
        sbD.append((Object) Objects.toString(d(), "[all enabled]"));
        sbD.append(", tlsVersions=");
        sbD.append((Object) Objects.toString(h(), "[all enabled]"));
        sbD.append(", supportsTlsExtensions=");
        sbD.append(this.f449b);
        sbD.append(')');
        return sbD.toString();
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f451a;

        /* renamed from: b, reason: collision with root package name */
        private String[] f452b;

        /* renamed from: c, reason: collision with root package name */
        private String[] f453c;
        private boolean d;

        public a(boolean z4) {
            this.f451a = z4;
        }

        public final k a() {
            return new k(this.f451a, this.d, this.f452b, this.f453c);
        }

        public final a b(h... hVarArr) {
            f3.c.d(hVarArr, "cipherSuites");
            if (!this.f451a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(hVarArr.length);
            for (h hVar : hVarArr) {
                arrayList.add(hVar.c());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            c((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        public final a c(String... strArr) {
            f3.c.d(strArr, "cipherSuites");
            if (!this.f451a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            this.f452b = (String[]) strArr.clone();
            return this;
        }

        public final a d() {
            if (!this.f451a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.d = true;
            return this;
        }

        public final a e(E... eArr) {
            if (!this.f451a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(eArr.length);
            for (E e2 : eArr) {
                arrayList.add(e2.d());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            f((String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        public final a f(String... strArr) {
            f3.c.d(strArr, "tlsVersions");
            if (!this.f451a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            this.f453c = (String[]) strArr.clone();
            return this;
        }

        public a(k kVar) {
            f3.c.d(kVar, "connectionSpec");
            this.f451a = kVar.f();
            this.f452b = kVar.f450c;
            this.f453c = kVar.d;
            this.d = kVar.g();
        }
    }
}
