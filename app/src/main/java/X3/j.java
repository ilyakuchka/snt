package X3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j extends z {

    /* renamed from: e, reason: collision with root package name */
    private z f1854e;

    public j(z zVar) {
        f3.c.d(zVar, "delegate");
        this.f1854e = zVar;
    }

    @Override // X3.z
    public final z a() {
        return this.f1854e.a();
    }

    @Override // X3.z
    public final z b() {
        return this.f1854e.b();
    }

    @Override // X3.z
    public final long c() {
        return this.f1854e.c();
    }

    @Override // X3.z
    public final z d(long j2) {
        return this.f1854e.d(j2);
    }

    @Override // X3.z
    public final boolean e() {
        return this.f1854e.e();
    }

    @Override // X3.z
    public final void f() throws IOException {
        this.f1854e.f();
    }

    @Override // X3.z
    public final z g(long j2) {
        f3.c.d(TimeUnit.MILLISECONDS, "unit");
        return this.f1854e.g(j2);
    }

    public final z i() {
        return this.f1854e;
    }

    public final j j() {
        this.f1854e = z.d;
        return this;
    }
}
