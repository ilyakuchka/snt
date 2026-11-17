package Y0;

import java.security.MessageDigest;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
final class p implements V0.f {

    /* renamed from: b, reason: collision with root package name */
    private final Object f2035b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2036c;
    private final int d;

    /* renamed from: e, reason: collision with root package name */
    private final Class<?> f2037e;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f2038f;
    private final V0.f g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Class<?>, V0.l<?>> f2039h;

    /* renamed from: i, reason: collision with root package name */
    private final V0.h f2040i;

    /* renamed from: j, reason: collision with root package name */
    private int f2041j;

    p(Object obj, V0.f fVar, int i2, int i4, Map<Class<?>, V0.l<?>> map, Class<?> cls, Class<?> cls2, V0.h hVar) {
        Objects.requireNonNull(obj, "Argument must not be null");
        this.f2035b = obj;
        Objects.requireNonNull(fVar, "Signature must not be null");
        this.g = fVar;
        this.f2036c = i2;
        this.d = i4;
        Objects.requireNonNull(map, "Argument must not be null");
        this.f2039h = map;
        Objects.requireNonNull(cls, "Resource class must not be null");
        this.f2037e = cls;
        Objects.requireNonNull(cls2, "Transcode class must not be null");
        this.f2038f = cls2;
        Objects.requireNonNull(hVar, "Argument must not be null");
        this.f2040i = hVar;
    }

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f2035b.equals(pVar.f2035b) && this.g.equals(pVar.g) && this.d == pVar.d && this.f2036c == pVar.f2036c && this.f2039h.equals(pVar.f2039h) && this.f2037e.equals(pVar.f2037e) && this.f2038f.equals(pVar.f2038f) && this.f2040i.equals(pVar.f2040i);
    }

    @Override // V0.f
    public final int hashCode() {
        if (this.f2041j == 0) {
            int iHashCode = this.f2035b.hashCode();
            this.f2041j = iHashCode;
            int iHashCode2 = ((((this.g.hashCode() + (iHashCode * 31)) * 31) + this.f2036c) * 31) + this.d;
            this.f2041j = iHashCode2;
            int iHashCode3 = this.f2039h.hashCode() + (iHashCode2 * 31);
            this.f2041j = iHashCode3;
            int iHashCode4 = this.f2037e.hashCode() + (iHashCode3 * 31);
            this.f2041j = iHashCode4;
            int iHashCode5 = this.f2038f.hashCode() + (iHashCode4 * 31);
            this.f2041j = iHashCode5;
            this.f2041j = this.f2040i.hashCode() + (iHashCode5 * 31);
        }
        return this.f2041j;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("EngineKey{model=");
        sbD.append(this.f2035b);
        sbD.append(", width=");
        sbD.append(this.f2036c);
        sbD.append(", height=");
        sbD.append(this.d);
        sbD.append(", resourceClass=");
        sbD.append(this.f2037e);
        sbD.append(", transcodeClass=");
        sbD.append(this.f2038f);
        sbD.append(", signature=");
        sbD.append(this.g);
        sbD.append(", hashCode=");
        sbD.append(this.f2041j);
        sbD.append(", transformations=");
        sbD.append(this.f2039h);
        sbD.append(", options=");
        sbD.append(this.f2040i);
        sbD.append('}');
        return sbD.toString();
    }
}
