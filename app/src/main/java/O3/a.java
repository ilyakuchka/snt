package O3;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f845a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f846b;

    /* renamed from: c, reason: collision with root package name */
    private c f847c;
    private long d;

    public a(String str, boolean z4) {
        f3.c.d(str, "name");
        this.f845a = str;
        this.f846b = z4;
        this.d = -1L;
    }

    public final boolean a() {
        return this.f846b;
    }

    public final String b() {
        return this.f845a;
    }

    public final long c() {
        return this.d;
    }

    public final c d() {
        return this.f847c;
    }

    public final void e(c cVar) {
        f3.c.d(cVar, "queue");
        c cVar2 = this.f847c;
        if (cVar2 == cVar) {
            return;
        }
        if (!(cVar2 == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.f847c = cVar;
    }

    public abstract long f();

    public final void g(long j2) {
        this.d = j2;
    }

    public final String toString() {
        return this.f845a;
    }
}
