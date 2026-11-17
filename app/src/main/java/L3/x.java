package L3;

import java.io.IOException;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: i, reason: collision with root package name */
    private final String f550i;

    /* renamed from: k, reason: collision with root package name */
    public static final x f545k = new x("HTTP_1_0", 0, "http/1.0");

    /* renamed from: l, reason: collision with root package name */
    public static final x f546l = new x("HTTP_1_1", 1, "http/1.1");

    /* renamed from: m, reason: collision with root package name */
    public static final x f547m = new x("SPDY_3", 2, "spdy/3.1");

    /* renamed from: n, reason: collision with root package name */
    public static final x f548n = new x("HTTP_2", 3, "h2");

    /* renamed from: o, reason: collision with root package name */
    public static final x f549o = new x("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
    public static final x p = new x("QUIC", 5, "quic");

    /* renamed from: j, reason: collision with root package name */
    public static final a f544j = new a();

    public static final class a {
        public final x a(String str) throws IOException {
            x xVar = x.f545k;
            if (!f3.c.a(str, xVar.f550i)) {
                xVar = x.f546l;
                if (!f3.c.a(str, xVar.f550i)) {
                    xVar = x.f549o;
                    if (!f3.c.a(str, xVar.f550i)) {
                        xVar = x.f548n;
                        if (!f3.c.a(str, xVar.f550i)) {
                            xVar = x.f547m;
                            if (!f3.c.a(str, xVar.f550i)) {
                                xVar = x.p;
                                if (!f3.c.a(str, xVar.f550i)) {
                                    throw new IOException(f3.c.h("Unexpected protocol: ", str));
                                }
                            }
                        }
                    }
                }
            }
            return xVar;
        }
    }

    private x(String str, int i2, String str2) {
        this.f550i = str2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f550i;
    }
}
