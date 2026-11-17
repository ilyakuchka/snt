package Y0;

import java.security.MessageDigest;

/* loaded from: classes.dex */
final class f implements V0.f {

    /* renamed from: b, reason: collision with root package name */
    private final V0.f f1922b;

    /* renamed from: c, reason: collision with root package name */
    private final V0.f f1923c;

    f(V0.f fVar, V0.f fVar2) {
        this.f1922b = fVar;
        this.f1923c = fVar2;
    }

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        this.f1922b.a(messageDigest);
        this.f1923c.a(messageDigest);
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f1922b.equals(fVar.f1922b) && this.f1923c.equals(fVar.f1923c);
    }

    @Override // V0.f
    public final int hashCode() {
        return this.f1923c.hashCode() + (this.f1922b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("DataCacheKey{sourceKey=");
        sbD.append(this.f1922b);
        sbD.append(", signature=");
        sbD.append(this.f1923c);
        sbD.append('}');
        return sbD.toString();
    }
}
