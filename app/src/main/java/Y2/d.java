package Y2;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class d<A, B> implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    private final A f2132i;

    /* renamed from: j, reason: collision with root package name */
    private final B f2133j;

    public d(A a2, B b2) {
        this.f2132i = a2;
        this.f2133j = b2;
    }

    public final A a() {
        return this.f2132i;
    }

    public final B b() {
        return this.f2133j;
    }

    public final A c() {
        return this.f2132i;
    }

    public final B d() {
        return this.f2133j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return f3.c.a(this.f2132i, dVar.f2132i) && f3.c.a(this.f2133j, dVar.f2133j);
    }

    public final int hashCode() {
        A a2 = this.f2132i;
        int iHashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
        B b2 = this.f2133j;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public final String toString() {
        return '(' + this.f2132i + ", " + this.f2133j + ')';
    }
}
