package n;

import O.d;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: n.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0353b extends d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f7472a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f7473b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c, reason: collision with root package name */
    private volatile Handler f7474c;

    /* renamed from: n.b$a */
    final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f7475a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f7475a.getAndIncrement())));
            return thread;
        }
    }

    public final void i(Runnable runnable) {
        this.f7473b.execute(runnable);
    }

    public final boolean j() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final void k(Runnable runnable) {
        if (this.f7474c == null) {
            synchronized (this.f7472a) {
                if (this.f7474c == null) {
                    this.f7474c = Handler.createAsync(Looper.getMainLooper());
                }
            }
        }
        this.f7474c.post(runnable);
    }
}
