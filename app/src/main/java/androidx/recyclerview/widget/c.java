package androidx.recyclerview.widget;

import androidx.recyclerview.widget.k;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f4126a;

    /* renamed from: b, reason: collision with root package name */
    private final k.d<T> f4127b;

    public static final class a<T> {

        /* renamed from: c, reason: collision with root package name */
        private static final Object f4128c = new Object();
        private static ExecutorService d;

        /* renamed from: a, reason: collision with root package name */
        private Executor f4129a;

        /* renamed from: b, reason: collision with root package name */
        private final k.d<T> f4130b;

        public a(k.d<T> dVar) {
            this.f4130b = dVar;
        }

        public final c<T> a() {
            if (this.f4129a == null) {
                synchronized (f4128c) {
                    try {
                        if (d == null) {
                            d = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.f4129a = d;
            }
            return new c<>(this.f4129a, this.f4130b);
        }
    }

    c(Executor executor, k.d dVar) {
        this.f4126a = executor;
        this.f4127b = dVar;
    }

    public final Executor a() {
        return this.f4126a;
    }

    public final k.d<T> b() {
        return this.f4127b;
    }
}
