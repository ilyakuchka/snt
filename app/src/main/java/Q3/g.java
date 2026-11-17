package Q3;

import L3.C;
import L3.v;

/* loaded from: classes.dex */
public final class g extends C {

    /* renamed from: j, reason: collision with root package name */
    private final String f1217j;

    /* renamed from: k, reason: collision with root package name */
    private final long f1218k;

    /* renamed from: l, reason: collision with root package name */
    private final X3.f f1219l;

    public g(String str, long j2, X3.f fVar) {
        this.f1217j = str;
        this.f1218k = j2;
        this.f1219l = fVar;
    }

    @Override // L3.C
    public final long H() {
        return this.f1218k;
    }

    @Override // L3.C
    public final v I() {
        String str = this.f1217j;
        if (str == null) {
            return null;
        }
        return v.f497c.b(str);
    }

    @Override // L3.C
    public final X3.f e0() {
        return this.f1219l;
    }
}
