package L3;

import L3.s;
import L3.t;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final t f551a;

    /* renamed from: b, reason: collision with root package name */
    private final String f552b;

    /* renamed from: c, reason: collision with root package name */
    private final s f553c;
    private final z d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, Object> f554e;

    /* renamed from: f, reason: collision with root package name */
    private C0153d f555f;

    public y(t tVar, String str, s sVar, z zVar, Map<Class<?>, ? extends Object> map) {
        f3.c.d(str, "method");
        this.f551a = tVar;
        this.f552b = str;
        this.f553c = sVar;
        this.d = zVar;
        this.f554e = map;
    }

    public final z a() {
        return this.d;
    }

    public final C0153d b() {
        C0153d c0153d = this.f555f;
        if (c0153d != null) {
            return c0153d;
        }
        C0153d c0153dB = C0153d.f406n.b(this.f553c);
        this.f555f = c0153dB;
        return c0153dB;
    }

    public final Map<Class<?>, Object> c() {
        return this.f554e;
    }

    public final String d(String str) {
        return this.f553c.d(str);
    }

    public final s e() {
        return this.f553c;
    }

    public final boolean f() {
        return this.f551a.h();
    }

    public final String g() {
        return this.f552b;
    }

    public final t h() {
        return this.f551a;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("Request{method=");
        sbD.append(this.f552b);
        sbD.append(", url=");
        sbD.append(this.f551a);
        if (this.f553c.size() != 0) {
            sbD.append(", headers=[");
            int i2 = 0;
            for (Y2.d<? extends String, ? extends String> dVar : this.f553c) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    Z2.g.l();
                    throw null;
                }
                Y2.d<? extends String, ? extends String> dVar2 = dVar;
                String strA = dVar2.a();
                String strB = dVar2.b();
                if (i2 > 0) {
                    sbD.append(", ");
                }
                sbD.append(strA);
                sbD.append(':');
                sbD.append(strB);
                i2 = i4;
            }
            sbD.append(']');
        }
        if (!this.f554e.isEmpty()) {
            sbD.append(", tags=");
            sbD.append(this.f554e);
        }
        sbD.append('}');
        String string = sbD.toString();
        f3.c.c(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private t f556a;

        /* renamed from: b, reason: collision with root package name */
        private String f557b;

        /* renamed from: c, reason: collision with root package name */
        private s.a f558c;
        private z d;

        /* renamed from: e, reason: collision with root package name */
        private Map<Class<?>, Object> f559e;

        public a() {
            this.f559e = new LinkedHashMap();
            this.f557b = "GET";
            this.f558c = new s.a();
        }

        public final a a(String str, String str2) {
            f3.c.d(str2, "value");
            this.f558c.a(str, str2);
            return this;
        }

        public final y b() {
            Map mapUnmodifiableMap;
            t tVar = this.f556a;
            if (tVar == null) {
                throw new IllegalStateException("url == null".toString());
            }
            String str = this.f557b;
            s sVarC = this.f558c.c();
            z zVar = this.d;
            Map<Class<?>, Object> map = this.f559e;
            byte[] bArr = M3.c.f596a;
            f3.c.d(map, "<this>");
            if (map.isEmpty()) {
                mapUnmodifiableMap = Z2.n.f2186i;
            } else {
                mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
                f3.c.c(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
            }
            return new y(tVar, str, sVarC, zVar, mapUnmodifiableMap);
        }

        public final a c(String str, String str2) {
            f3.c.d(str2, "value");
            this.f558c.f(str, str2);
            return this;
        }

        public final a d(s sVar) {
            this.f558c = sVar.i();
            return this;
        }

        public final a e(String str, z zVar) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (zVar == null) {
                if (!(!(f3.c.a(str, "POST") || f3.c.a(str, "PUT") || f3.c.a(str, "PATCH") || f3.c.a(str, "PROPPATCH") || f3.c.a(str, "REPORT")))) {
                    throw new IllegalArgumentException(C2.c.a("method ", str, " must have a request body.").toString());
                }
            } else if (!Y1.a.i(str)) {
                throw new IllegalArgumentException(C2.c.a("method ", str, " must not have a request body.").toString());
            }
            this.f557b = str;
            this.d = zVar;
            return this;
        }

        public final a f(String str) {
            this.f558c.e(str);
            return this;
        }

        public final a g(t tVar) {
            f3.c.d(tVar, "url");
            this.f556a = tVar;
            return this;
        }

        public final a h(String str) throws NumberFormatException {
            f3.c.d(str, "url");
            if (i3.f.A(str, "ws:", true)) {
                String strSubstring = str.substring(3);
                f3.c.c(strSubstring, "this as java.lang.String).substring(startIndex)");
                str = f3.c.h("http:", strSubstring);
            } else if (i3.f.A(str, "wss:", true)) {
                String strSubstring2 = str.substring(4);
                f3.c.c(strSubstring2, "this as java.lang.String).substring(startIndex)");
                str = f3.c.h("https:", strSubstring2);
            }
            f3.c.d(str, "<this>");
            t.a aVar = new t.a();
            aVar.g(null, str);
            this.f556a = aVar.b();
            return this;
        }

        public a(y yVar) {
            LinkedHashMap linkedHashMap;
            f3.c.d(yVar, "request");
            this.f559e = new LinkedHashMap();
            this.f556a = yVar.h();
            this.f557b = yVar.g();
            this.d = yVar.a();
            if (yVar.c().isEmpty()) {
                linkedHashMap = new LinkedHashMap();
            } else {
                Map<Class<?>, Object> mapC = yVar.c();
                f3.c.d(mapC, "<this>");
                linkedHashMap = new LinkedHashMap(mapC);
            }
            this.f559e = linkedHashMap;
            this.f558c = yVar.e().i();
        }
    }
}
