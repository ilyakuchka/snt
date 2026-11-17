package b1;

import D2.e;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class a implements ExecutorService {

    /* renamed from: b, reason: collision with root package name */
    private static final long f4367b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c, reason: collision with root package name */
    private static volatile int f4368c;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f4369a;

    /* renamed from: b1.a$a, reason: collision with other inner class name */
    public static final class C0078a {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f4370a;

        /* renamed from: b, reason: collision with root package name */
        private int f4371b;

        /* renamed from: c, reason: collision with root package name */
        private int f4372c;
        private String d;

        C0078a(boolean z4) {
            this.f4370a = z4;
        }

        public final a a() {
            if (!TextUtils.isEmpty(this.d)) {
                return new a(new ThreadPoolExecutor(this.f4371b, this.f4372c, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.d, this.f4370a)));
            }
            StringBuilder sbD = e.d("Name must be non-null and non-empty, but given: ");
            sbD.append(this.d);
            throw new IllegalArgumentException(sbD.toString());
        }

        public final C0078a b(String str) {
            this.d = str;
            return this;
        }

        public final C0078a c(int i2) {
            this.f4371b = i2;
            this.f4372c = i2;
            return this;
        }
    }

    private static final class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final String f4373a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f4374b;

        /* renamed from: c, reason: collision with root package name */
        private int f4375c;

        /* renamed from: b1.a$b$a, reason: collision with other inner class name */
        final class C0079a extends Thread {
            C0079a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(9);
                if (b.this.f4374b) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    Objects.requireNonNull(b.this);
                    if (Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                    }
                }
            }
        }

        b(String str, boolean z4) {
            this.f4373a = str;
            this.f4374b = z4;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final synchronized Thread newThread(Runnable runnable) {
            C0079a c0079a;
            c0079a = new C0079a(runnable, "glide-" + this.f4373a + "-thread-" + this.f4375c);
            this.f4375c = this.f4375c + 1;
            return c0079a;
        }
    }

    a(ExecutorService executorService) {
        this.f4369a = executorService;
    }

    public static int a() {
        if (f4368c == 0) {
            f4368c = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        return f4368c;
    }

    public static a b() {
        int i2 = a() >= 4 ? 2 : 1;
        C0078a c0078a = new C0078a(true);
        c0078a.c(i2);
        c0078a.b("animation");
        return c0078a.a();
    }

    public static a c() {
        C0078a c0078a = new C0078a(true);
        c0078a.c(1);
        c0078a.b("disk-cache");
        return c0078a.a();
    }

    public static a d() {
        C0078a c0078a = new C0078a(false);
        c0078a.c(a());
        c0078a.b("source");
        return c0078a.a();
    }

    public static a e() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f4367b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f4369a.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f4369a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f4369a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f4369a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f4369a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f4369a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f4369a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.f4369a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        return this.f4369a.submit(runnable);
    }

    public final String toString() {
        return this.f4369a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f4369a.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f4369a.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, T t2) {
        return this.f4369a.submit(runnable, t2);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        return this.f4369a.submit(callable);
    }
}
