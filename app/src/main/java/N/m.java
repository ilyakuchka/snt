package N;

/* loaded from: classes.dex */
final class m implements Q.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f703a;

    /* renamed from: b, reason: collision with root package name */
    private final Q.b f704b;

    m(int i2, Q.b bVar) {
        this.f703a = i2;
        this.f704b = bVar;
    }

    @Override // Q.b
    public final void a(int i2, int i4) {
        this.f704b.a(i2 + this.f703a, i4);
    }

    @Override // Q.b
    public final void b(int i2, int i4) {
        this.f704b.b(i2 + this.f703a, i4);
    }

    @Override // Q.b
    public final void c(int i2, int i4) {
        Q.b bVar = this.f704b;
        int i5 = this.f703a;
        bVar.c(i2 + i5, i4 + i5);
    }

    @Override // Q.b
    public final void d(int i2, int i4, Object obj) {
        this.f704b.d(i2 + this.f703a, i4, obj);
    }
}
