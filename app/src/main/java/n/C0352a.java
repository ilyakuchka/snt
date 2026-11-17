package n;

import O.d;
import java.util.concurrent.Executor;

/* renamed from: n.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0352a extends d {

    /* renamed from: c, reason: collision with root package name */
    private static volatile C0352a f7468c;
    private static final Executor d = new ExecutorC0128a();

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f7469e = new b();

    /* renamed from: a, reason: collision with root package name */
    private C0353b f7470a;

    /* renamed from: b, reason: collision with root package name */
    private C0353b f7471b;

    /* renamed from: n.a$a, reason: collision with other inner class name */
    static class ExecutorC0128a implements Executor {
        ExecutorC0128a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C0352a.k().n(runnable);
        }
    }

    /* renamed from: n.a$b */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C0352a.k().i(runnable);
        }
    }

    private C0352a() {
        C0353b c0353b = new C0353b();
        this.f7471b = c0353b;
        this.f7470a = c0353b;
    }

    public static Executor j() {
        return f7469e;
    }

    public static C0352a k() {
        if (f7468c != null) {
            return f7468c;
        }
        synchronized (C0352a.class) {
            if (f7468c == null) {
                f7468c = new C0352a();
            }
        }
        return f7468c;
    }

    public static Executor l() {
        return d;
    }

    public final void i(Runnable runnable) {
        this.f7470a.i(runnable);
    }

    public final boolean m() {
        return this.f7470a.j();
    }

    public final void n(Runnable runnable) {
        this.f7470a.k(runnable);
    }
}
