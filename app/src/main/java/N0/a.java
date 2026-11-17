package N0;

import D2.e;
import android.util.Log;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f724a = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactoryC0023a(), new b());

    /* renamed from: N0.a$a, reason: collision with other inner class name */
    final class ThreadFactoryC0023a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f725a = new AtomicInteger(1);

        ThreadFactoryC0023a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sbD = e.d("StorageWorkThreads #");
            sbD.append(this.f725a.getAndIncrement());
            return new Thread(runnable, sbD.toString());
        }
    }

    private static class b extends ThreadPoolExecutor.DiscardOldestPolicy {
        b() {
        }

        @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            Log.d("StorageWorkThreads", "rejected: " + runnable);
        }
    }

    public static void a(Runnable runnable) {
        f724a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        f724a.remove(runnable);
    }

    public static ScheduledFuture c(Runnable runnable, long j2) {
        return f724a.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    public static Future<?> d(Runnable runnable) {
        return f724a.submit(runnable);
    }
}
