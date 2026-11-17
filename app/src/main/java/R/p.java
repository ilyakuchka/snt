package R;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class p implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f1309a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque<Runnable> f1310b = new ArrayDeque<>();

    /* renamed from: c, reason: collision with root package name */
    private Runnable f1311c;

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Runnable f1312i;

        a(Runnable runnable) {
            this.f1312i = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f1312i.run();
            } finally {
                p.this.a();
            }
        }
    }

    p(Executor executor) {
        this.f1309a = executor;
    }

    final synchronized void a() {
        Runnable runnablePoll = this.f1310b.poll();
        this.f1311c = runnablePoll;
        if (runnablePoll != null) {
            this.f1309a.execute(runnablePoll);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        this.f1310b.offer(new a(runnable));
        if (this.f1311c == null) {
            a();
        }
    }
}
