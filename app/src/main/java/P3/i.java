package P3;

/* loaded from: classes.dex */
public final class i extends O3.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ j f1040e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    i(j jVar, String str) {
        super(str, true);
        this.f1040e = jVar;
    }

    @Override // O3.a
    public final long f() {
        return this.f1040e.b(System.nanoTime());
    }
}
