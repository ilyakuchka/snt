package T2;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public List<c> f1561a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f1562b;

    /* renamed from: c, reason: collision with root package name */
    public int f1563c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f1564e;

    /* renamed from: f, reason: collision with root package name */
    public e f1565f;
    private T2.a g;

    final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            b bVar = b.this;
            T2.a aVar = bVar.g;
            C0038b c0038b = aVar.d;
            aVar.d = null;
            if (bVar.f(c0038b)) {
                b.this.c();
            }
        }
    }

    /* renamed from: T2.b$b, reason: collision with other inner class name */
    public static class C0038b {

        /* renamed from: a, reason: collision with root package name */
        public d f1567a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1568b;
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f1569a;

        /* renamed from: b, reason: collision with root package name */
        public int f1570b;

        /* renamed from: c, reason: collision with root package name */
        public int f1571c;

        public c(Bitmap bitmap, int i2, int i4) {
            this.f1569a = bitmap;
            this.f1570b = i2;
            this.f1571c = i4;
        }
    }

    public static C0038b b(e eVar, long j2, int i2) {
        C0038b c0038b = new C0038b();
        c0038b.f1567a = null;
        c0038b.f1568b = false;
        try {
            eVar.reset();
            d dVar = new d();
            c0038b.f1567a = dVar;
            dVar.p(i2);
            dVar.o(j2);
            c0038b.f1568b = dVar.h(eVar) == 0;
            eVar.close();
        } catch (IOException unused) {
        }
        return c0038b;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    private int e() {
        return ((c) this.f1561a.get(r1.size() - 1)).f1571c;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    public final void c() {
        int size = this.f1561a.size();
        int i2 = this.f1562b;
        if (i2 > 3 ? size <= i2 / 2 : size <= 2) {
            int iE = e() + 1;
            int i4 = this.f1563c;
            if (i4 != 0) {
                iE %= i4;
            }
            T2.a aVar = this.g;
            if (aVar.d != null) {
                return;
            }
            aVar.d = new C0038b();
            aVar.sendMessage(aVar.obtainMessage(1, iE, 0));
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    public final void d() {
        a aVar = new a(Looper.getMainLooper());
        this.f1564e = aVar;
        e eVar = this.f1565f;
        int i2 = T2.a.f1556f;
        HandlerThread handlerThread = new HandlerThread("handler thread to decode GIF frames");
        handlerThread.start();
        this.g = new T2.a(handlerThread, eVar, aVar);
        this.f1562b = this.f1561a.size();
        c();
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.ArrayList, java.util.List<T2.b$c>] */
    public final boolean f(C0038b c0038b) {
        d dVar;
        if (!c0038b.f1568b || (dVar = c0038b.f1567a) == null) {
            return false;
        }
        Log.d("dumpFrameIndex", String.format("Thread#%d: decoded %d frames [%s] [%d]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(c0038b.f1567a.d()), Boolean.valueOf(c0038b.f1568b), Integer.valueOf(this.f1563c)));
        if (dVar.f()) {
            this.f1563c = dVar.e();
        }
        int iD = dVar.d();
        if (iD > 0) {
            int iE = e();
            for (int i2 = 0; i2 < iD; i2++) {
                Bitmap bitmapC = dVar.c(i2);
                int iB = dVar.b(i2);
                int i4 = iE + 1 + i2;
                int i5 = this.f1563c;
                if (i5 != 0) {
                    i4 %= i5;
                }
                this.f1561a.add(new c(bitmapC, iB, i4));
            }
        }
        return true;
    }
}
