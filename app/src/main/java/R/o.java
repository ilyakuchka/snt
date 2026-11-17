package R;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f1306a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final i f1307b;

    /* renamed from: c, reason: collision with root package name */
    private volatile V.f f1308c;

    public o(i iVar) {
        this.f1307b = iVar;
    }

    public final V.f a() {
        this.f1307b.a();
        if (!this.f1306a.compareAndSet(false, true)) {
            return this.f1307b.e(b());
        }
        if (this.f1308c == null) {
            this.f1308c = this.f1307b.e(b());
        }
        return this.f1308c;
    }

    protected abstract String b();

    public final void c(V.f fVar) {
        if (fVar == this.f1308c) {
            this.f1306a.set(false);
        }
    }
}
