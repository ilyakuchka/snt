package M3;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f594a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f595b;

    public /* synthetic */ b(String str, boolean z4) {
        this.f594a = str;
        this.f595b = z4;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f594a;
        boolean z4 = this.f595b;
        f3.c.d(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z4);
        return thread;
    }
}
