package Y0;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
final class z implements V0.f {

    /* renamed from: j, reason: collision with root package name */
    private static final s1.g<Class<?>, byte[]> f2076j = new s1.g<>(50);

    /* renamed from: b, reason: collision with root package name */
    private final Z0.b f2077b;

    /* renamed from: c, reason: collision with root package name */
    private final V0.f f2078c;
    private final V0.f d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2079e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2080f;
    private final Class<?> g;

    /* renamed from: h, reason: collision with root package name */
    private final V0.h f2081h;

    /* renamed from: i, reason: collision with root package name */
    private final V0.l<?> f2082i;

    z(Z0.b bVar, V0.f fVar, V0.f fVar2, int i2, int i4, V0.l<?> lVar, Class<?> cls, V0.h hVar) {
        this.f2077b = bVar;
        this.f2078c = fVar;
        this.d = fVar2;
        this.f2079e = i2;
        this.f2080f = i4;
        this.f2082i = lVar;
        this.g = cls;
        this.f2081h = hVar;
    }

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f2077b.e();
        ByteBuffer.wrap(bArr).putInt(this.f2079e).putInt(this.f2080f).array();
        this.d.a(messageDigest);
        this.f2078c.a(messageDigest);
        messageDigest.update(bArr);
        V0.l<?> lVar = this.f2082i;
        if (lVar != null) {
            lVar.a(messageDigest);
        }
        this.f2081h.a(messageDigest);
        s1.g<Class<?>, byte[]> gVar = f2076j;
        byte[] bArrB = gVar.b(this.g);
        if (bArrB == null) {
            bArrB = this.g.getName().getBytes(V0.f.f1758a);
            gVar.f(this.g, bArrB);
        }
        messageDigest.update(bArrB);
        this.f2077b.c(bArr);
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f2080f == zVar.f2080f && this.f2079e == zVar.f2079e && s1.j.b(this.f2082i, zVar.f2082i) && this.g.equals(zVar.g) && this.f2078c.equals(zVar.f2078c) && this.d.equals(zVar.d) && this.f2081h.equals(zVar.f2081h);
    }

    @Override // V0.f
    public final int hashCode() {
        int iHashCode = ((((this.d.hashCode() + (this.f2078c.hashCode() * 31)) * 31) + this.f2079e) * 31) + this.f2080f;
        V0.l<?> lVar = this.f2082i;
        if (lVar != null) {
            iHashCode = (iHashCode * 31) + lVar.hashCode();
        }
        int iHashCode2 = this.g.hashCode();
        return this.f2081h.hashCode() + ((iHashCode2 + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("ResourceCacheKey{sourceKey=");
        sbD.append(this.f2078c);
        sbD.append(", signature=");
        sbD.append(this.d);
        sbD.append(", width=");
        sbD.append(this.f2079e);
        sbD.append(", height=");
        sbD.append(this.f2080f);
        sbD.append(", decodedResourceClass=");
        sbD.append(this.g);
        sbD.append(", transformation='");
        sbD.append(this.f2082i);
        sbD.append('\'');
        sbD.append(", options=");
        sbD.append(this.f2081h);
        sbD.append('}');
        return sbD.toString();
    }
}
