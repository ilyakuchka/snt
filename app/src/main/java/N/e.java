package N;

import N.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class e<Key, Value> {

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f631a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<b> f632b = new CopyOnWriteArrayList<>();

    public static abstract class a<Key, Value> {
        public abstract e<Key, Value> a();
    }

    public interface b {
        void a();
    }

    static class c<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f633a;

        /* renamed from: b, reason: collision with root package name */
        private final e f634b;

        /* renamed from: c, reason: collision with root package name */
        final h.a<T> f635c;

        /* renamed from: e, reason: collision with root package name */
        private Executor f636e;
        private final Object d = new Object();

        /* renamed from: f, reason: collision with root package name */
        private boolean f637f = false;

        final class a implements Runnable {

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ h f638i;

            a(h hVar) {
                this.f638i = hVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c cVar = c.this;
                cVar.f635c.a(cVar.f633a, this.f638i);
            }
        }

        c(e eVar, int i2, Executor executor, h.a<T> aVar) {
            this.f634b = eVar;
            this.f633a = i2;
            this.f636e = executor;
            this.f635c = aVar;
        }

        final boolean a() {
            if (!this.f634b.d()) {
                return false;
            }
            b(h.a());
            return true;
        }

        final void b(h<T> hVar) {
            Executor executor;
            synchronized (this.d) {
                if (this.f637f) {
                    throw new IllegalStateException("callback.onResult already called, cannot call again.");
                }
                this.f637f = true;
                executor = this.f636e;
            }
            if (executor != null) {
                executor.execute(new a(hVar));
            } else {
                this.f635c.a(this.f633a, hVar);
            }
        }

        final void c(Executor executor) {
            synchronized (this.d) {
                this.f636e = executor;
            }
        }
    }

    e() {
    }

    public void a(b bVar) {
        this.f632b.add(bVar);
    }

    public final void b() {
        if (this.f631a.compareAndSet(false, true)) {
            Iterator<b> it = this.f632b.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    abstract boolean c();

    public boolean d() {
        return this.f631a.get();
    }

    public void e(b bVar) {
        this.f632b.remove(bVar);
    }
}
