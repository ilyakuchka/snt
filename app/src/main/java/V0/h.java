package V0;

import java.security.MessageDigest;
import q.C0365a;

/* loaded from: classes.dex */
public final class h implements f {

    /* renamed from: b, reason: collision with root package name */
    private final C0365a<g<?>, Object> f1763b = new s1.b();

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f1763b.size(); i2++) {
            this.f1763b.h(i2).e(this.f1763b.l(i2), messageDigest);
        }
    }

    public final <T> T c(g<T> gVar) {
        return this.f1763b.containsKey(gVar) ? (T) this.f1763b.getOrDefault(gVar, null) : gVar.b();
    }

    public final void d(h hVar) {
        this.f1763b.i(hVar.f1763b);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [q.a<V0.g<?>, java.lang.Object>, s1.b] */
    public final <T> h e(g<T> gVar, T t2) {
        this.f1763b.put(gVar, t2);
        return this;
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f1763b.equals(((h) obj).f1763b);
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [q.a<V0.g<?>, java.lang.Object>, s1.b] */
    @Override // V0.f
    public final int hashCode() {
        return this.f1763b.hashCode();
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("Options{values=");
        sbD.append(this.f1763b);
        sbD.append('}');
        return sbD.toString();
    }
}
