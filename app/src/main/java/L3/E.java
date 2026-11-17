package L3;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class E {

    /* renamed from: i, reason: collision with root package name */
    private final String f395i;

    /* renamed from: k, reason: collision with root package name */
    public static final E f390k = new E("TLS_1_3", 0, "TLSv1.3");

    /* renamed from: l, reason: collision with root package name */
    public static final E f391l = new E("TLS_1_2", 1, "TLSv1.2");

    /* renamed from: m, reason: collision with root package name */
    public static final E f392m = new E("TLS_1_1", 2, "TLSv1.1");

    /* renamed from: n, reason: collision with root package name */
    public static final E f393n = new E("TLS_1_0", 3, "TLSv1");

    /* renamed from: o, reason: collision with root package name */
    public static final E f394o = new E("SSL_3_0", 4, "SSLv3");

    /* renamed from: j, reason: collision with root package name */
    public static final a f389j = new a();

    public static final class a {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final E a(String str) {
            f3.c.d(str, "javaName");
            int iHashCode = str.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return E.f392m;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return E.f391l;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return E.f390k;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return E.f393n;
                }
            } else if (str.equals("SSLv3")) {
                return E.f394o;
            }
            throw new IllegalArgumentException(f3.c.h("Unexpected TLS version: ", str));
        }
    }

    private E(String str, int i2, String str2) {
        this.f395i = str2;
    }

    public final String d() {
        return this.f395i;
    }
}
