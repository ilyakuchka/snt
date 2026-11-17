package C;

import android.os.Handler;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class l<T> implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    private Callable<T> f50i;

    /* renamed from: j, reason: collision with root package name */
    private E.a<T> f51j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f52k;

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ E.a f53i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Object f54j;

        a(E.a aVar, Object obj) {
            this.f53i = aVar;
            this.f54j = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f53i.a(this.f54j);
        }
    }

    l(Handler handler, Callable<T> callable, E.a<T> aVar) {
        this.f50i = callable;
        this.f51j = aVar;
        this.f52k = handler;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        T tCall;
        try {
            tCall = this.f50i.call();
        } catch (Exception unused) {
            tCall = null;
        }
        this.f52k.post(new a(this.f51j, tCall));
    }
}
