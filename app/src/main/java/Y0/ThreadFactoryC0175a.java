package Y0;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* renamed from: Y0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ThreadFactoryC0175a implements ThreadFactory {

    /* renamed from: Y0.a$a, reason: collision with other inner class name */
    final class RunnableC0048a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Runnable f1906i;

        RunnableC0048a(Runnable runnable) {
            this.f1906i = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            this.f1906i.run();
        }
    }

    ThreadFactoryC0175a() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(new RunnableC0048a(runnable), "glide-active-resources");
    }
}
