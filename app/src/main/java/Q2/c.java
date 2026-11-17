package Q2;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f1200a = (ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR;

    public static void a(Runnable runnable) {
        f1200a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        f1200a.remove(runnable);
    }
}
