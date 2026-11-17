package M0;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.RunnableScheduledFuture;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private Cursor f585a;

    /* renamed from: b, reason: collision with root package name */
    private a f586b = new a();

    private static class a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        private int f587a;

        /* renamed from: b, reason: collision with root package name */
        private RunnableScheduledFuture f588b;

        /* renamed from: c, reason: collision with root package name */
        private RunnableScheduledFuture f589c;
        private Runnable d;

        /* renamed from: e, reason: collision with root package name */
        private Runnable f590e;

        /* renamed from: M0.i$a$a, reason: collision with other inner class name */
        final class RunnableC0020a implements Runnable {

            /* renamed from: M0.i$a$a$a, reason: collision with other inner class name */
            final class RunnableC0021a implements Runnable {
                RunnableC0021a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (a.a(a.this)) {
                        a.this.b();
                        d.b().f(3000L);
                    }
                }
            }

            RunnableC0020a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                N0.a.a(new RunnableC0021a());
            }
        }

        final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.b();
            }
        }

        public a() {
            super(new Handler(Looper.getMainLooper()));
            this.f587a = 0;
            this.d = new RunnableC0020a();
            this.f590e = new b();
        }

        static boolean a(a aVar) {
            return aVar.f587a > 20;
        }

        public final void b() {
            this.f587a = 0;
            N0.a.b(this.f588b);
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z4) {
            if (d.b().d()) {
                return;
            }
            this.f587a++;
            N0.a.b(this.f588b);
            this.f588b = (RunnableScheduledFuture) N0.a.c(this.f590e, 3000L);
            N0.a.b(this.f589c);
            this.f589c = (RunnableScheduledFuture) N0.a.c(this.d, 1000L);
        }
    }

    public final void a(Cursor cursor) {
        a aVar;
        a aVar2;
        Cursor cursor2 = this.f585a;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null && (aVar2 = this.f586b) != null) {
                cursor2.unregisterContentObserver(aVar2);
            }
            this.f585a = cursor;
            if (cursor != null && (aVar = this.f586b) != null) {
                cursor.registerContentObserver(aVar);
            }
            a aVar3 = this.f586b;
            if (aVar3 != null) {
                aVar3.b();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }
}
