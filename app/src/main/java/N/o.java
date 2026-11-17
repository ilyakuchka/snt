package N;

import N.i;

/* loaded from: classes.dex */
final class o<T> extends i<T> {

    /* renamed from: x, reason: collision with root package name */
    private final boolean f716x;

    /* renamed from: y, reason: collision with root package name */
    private final Object f717y;

    /* renamed from: z, reason: collision with root package name */
    private final e<?, T> f718z;

    o(i<T> iVar) {
        super(iVar.f661m.C(), iVar.f657i, iVar.f658j, null, iVar.f660l);
        this.f718z = iVar.o();
        this.f716x = iVar.q();
        this.f662n = iVar.f662n;
        this.f717y = iVar.p();
    }

    @Override // N.i
    final void n(i<T> iVar, i.e eVar) {
    }

    @Override // N.i
    public final e<?, T> o() {
        return this.f718z;
    }

    @Override // N.i
    public final Object p() {
        return this.f717y;
    }

    @Override // N.i
    final boolean q() {
        return this.f716x;
    }

    @Override // N.i
    public final boolean r() {
        return true;
    }

    @Override // N.i
    public final boolean s() {
        return true;
    }

    @Override // N.i
    final void u(int i2) {
    }
}
