package s1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f7853a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Executor f7854b = new b();

    final class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f7855a = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f7855a.post(runnable);
        }
    }

    final class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f7854b;
    }

    public static Executor b() {
        return f7853a;
    }
}
