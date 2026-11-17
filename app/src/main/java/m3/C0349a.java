package m3;

import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: m3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0349a {
    public static final ThreadLocal<C0349a> g = new ThreadLocal<>();
    private d d;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap<b, Long> f6571a = new ArrayMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<b> f6572b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final C0116a f6573c = new C0116a();

    /* renamed from: e, reason: collision with root package name */
    private long f6574e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6575f = false;

    /* renamed from: m3.a$a, reason: collision with other inner class name */
    class C0116a {
        C0116a() {
        }

        final void a() {
            C0349a.this.f6574e = SystemClock.uptimeMillis();
            C0349a c0349a = C0349a.this;
            C0349a.c(c0349a, c0349a.f6574e);
            if (C0349a.this.f6572b.size() > 0) {
                C0349a.e(C0349a.this).a();
            }
        }
    }

    /* renamed from: m3.a$b */
    public interface b {
        boolean a(long j2);
    }

    /* renamed from: m3.a$c */
    static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final C0116a f6577a;

        c(C0116a c0116a) {
            this.f6577a = c0116a;
        }

        abstract void a();
    }

    /* renamed from: m3.a$d */
    private static class d extends c {

        /* renamed from: b, reason: collision with root package name */
        private final Choreographer f6578b;

        /* renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f6579c;

        /* renamed from: m3.a$d$a, reason: collision with other inner class name */
        final class ChoreographerFrameCallbackC0117a implements Choreographer.FrameCallback {
            ChoreographerFrameCallbackC0117a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                d.this.f6577a.a();
            }
        }

        d(C0116a c0116a) {
            super(c0116a);
            this.f6578b = Choreographer.getInstance();
            this.f6579c = new ChoreographerFrameCallbackC0117a();
        }

        @Override // m3.C0349a.c
        final void a() {
            this.f6578b.postFrameCallback(this.f6579c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void c(C0349a c0349a, long j2) {
        boolean z4;
        Objects.requireNonNull(c0349a);
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i2 = 0; i2 < c0349a.f6572b.size(); i2++) {
            b bVar = c0349a.f6572b.get(i2);
            if (bVar != null) {
                Long l2 = c0349a.f6571a.get(bVar);
                if (l2 == null) {
                    z4 = true;
                    if (z4) {
                    }
                } else if (l2.longValue() < jUptimeMillis) {
                    c0349a.f6571a.remove(bVar);
                    z4 = true;
                    if (z4) {
                        bVar.a(j2);
                    }
                } else {
                    z4 = false;
                    if (z4) {
                    }
                }
            }
        }
        if (!c0349a.f6575f) {
            return;
        }
        int size = c0349a.f6572b.size();
        while (true) {
            size--;
            if (size < 0) {
                c0349a.f6575f = false;
                return;
            } else if (c0349a.f6572b.get(size) == null) {
                c0349a.f6572b.remove(size);
            }
        }
    }

    static c e(C0349a c0349a) {
        if (c0349a.d == null) {
            c0349a.d = new d(c0349a.f6573c);
        }
        return c0349a.d;
    }

    public static C0349a g() {
        ThreadLocal<C0349a> threadLocal = g;
        if (threadLocal.get() == null) {
            threadLocal.set(new C0349a());
        }
        return threadLocal.get();
    }

    public final void f(b bVar, long j2) {
        if (this.f6572b.size() == 0) {
            if (this.d == null) {
                this.d = new d(this.f6573c);
            }
            this.d.a();
        }
        if (!this.f6572b.contains(bVar)) {
            this.f6572b.add(bVar);
        }
        if (j2 > 0) {
            this.f6571a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j2));
        }
    }

    public final void h(b bVar) {
        this.f6571a.remove(bVar);
        int iIndexOf = this.f6572b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f6572b.set(iIndexOf, null);
            this.f6575f = true;
        }
    }
}
