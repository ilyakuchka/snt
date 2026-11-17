package C;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class k implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private String f47a = "fonts-androidx";

    /* renamed from: b, reason: collision with root package name */
    private int f48b = 10;

    private static class a extends Thread {

        /* renamed from: i, reason: collision with root package name */
        private final int f49i;

        a(Runnable runnable, String str, int i2) {
            super(runnable, str);
            this.f49i = i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(this.f49i);
            super.run();
        }
    }

    k() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new a(runnable, this.f47a, this.f48b);
    }
}
