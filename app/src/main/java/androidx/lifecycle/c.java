package androidx.lifecycle;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import n.C0352a;

/* loaded from: classes.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name */
    final Executor f3677a;

    /* renamed from: c, reason: collision with root package name */
    final AtomicBoolean f3679c = new AtomicBoolean(true);
    final AtomicBoolean d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    final Runnable f3680e = new b();

    /* renamed from: f, reason: collision with root package name */
    final Runnable f3681f = new RunnableC0065c();

    /* renamed from: b, reason: collision with root package name */
    final LiveData<T> f3678b = new a();

    final class a extends LiveData<T> {
        a() {
        }

        @Override // androidx.lifecycle.LiveData
        protected final void i() {
            c cVar = c.this;
            cVar.f3677a.execute(cVar.f3680e);
        }
    }

    final class b implements Runnable {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            do {
                boolean z4 = false;
                if (c.this.d.compareAndSet(false, true)) {
                    Object objA = null;
                    boolean z5 = false;
                    while (c.this.f3679c.compareAndSet(true, false)) {
                        try {
                            objA = c.this.a();
                            z5 = true;
                        } catch (Throwable th) {
                            c.this.d.set(false);
                            throw th;
                        }
                    }
                    if (z5) {
                        c.this.f3678b.k(objA);
                    }
                    c.this.d.set(false);
                    z4 = z5;
                }
                if (!z4) {
                    return;
                }
            } while (c.this.f3679c.get());
        }
    }

    /* renamed from: androidx.lifecycle.c$c, reason: collision with other inner class name */
    final class RunnableC0065c implements Runnable {
        RunnableC0065c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean zF = c.this.f3678b.f();
            if (c.this.f3679c.compareAndSet(false, true) && zF) {
                c cVar = c.this;
                cVar.f3677a.execute(cVar.f3680e);
            }
        }
    }

    public c(Executor executor) {
        this.f3677a = executor;
    }

    protected abstract T a();

    public final LiveData<T> b() {
        return this.f3678b;
    }

    public final void c() {
        C0352a c0352aK = C0352a.k();
        Runnable runnable = this.f3681f;
        if (c0352aK.m()) {
            ((RunnableC0065c) runnable).run();
        } else {
            c0352aK.n(runnable);
        }
    }
}
