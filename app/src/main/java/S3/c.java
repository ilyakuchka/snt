package S3;

import X3.g;

/* loaded from: classes.dex */
public final class c {
    public static final X3.g d;

    /* renamed from: e, reason: collision with root package name */
    public static final X3.g f1374e;

    /* renamed from: f, reason: collision with root package name */
    public static final X3.g f1375f;
    public static final X3.g g;

    /* renamed from: h, reason: collision with root package name */
    public static final X3.g f1376h;

    /* renamed from: i, reason: collision with root package name */
    public static final X3.g f1377i;

    /* renamed from: a, reason: collision with root package name */
    public final X3.g f1378a;

    /* renamed from: b, reason: collision with root package name */
    public final X3.g f1379b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1380c;

    static {
        g.a aVar = X3.g.f1847l;
        d = aVar.b(":");
        f1374e = aVar.b(":status");
        f1375f = aVar.b(":method");
        g = aVar.b(":path");
        f1376h = aVar.b(":scheme");
        f1377i = aVar.b(":authority");
    }

    public c(X3.g gVar, X3.g gVar2) {
        f3.c.d(gVar, "name");
        f3.c.d(gVar2, "value");
        this.f1378a = gVar;
        this.f1379b = gVar2;
        this.f1380c = gVar2.h() + gVar.h() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return f3.c.a(this.f1378a, cVar.f1378a) && f3.c.a(this.f1379b, cVar.f1379b);
    }

    public final int hashCode() {
        return this.f1379b.hashCode() + (this.f1378a.hashCode() * 31);
    }

    public final String toString() {
        return this.f1378a.q() + ": " + this.f1379b.q();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(String str, String str2) {
        f3.c.d(str, "name");
        f3.c.d(str2, "value");
        g.a aVar = X3.g.f1847l;
        this(aVar.b(str), aVar.b(str2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(X3.g gVar, String str) {
        this(gVar, X3.g.f1847l.b(str));
        f3.c.d(gVar, "name");
        f3.c.d(str, "value");
    }
}
