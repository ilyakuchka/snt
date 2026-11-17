package X3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: X3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0174a extends z {

    /* renamed from: h, reason: collision with root package name */
    public static final C0047a f1835h = new C0047a();

    /* renamed from: i, reason: collision with root package name */
    private static final long f1836i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f1837j;

    /* renamed from: k, reason: collision with root package name */
    private static C0174a f1838k;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1839e;

    /* renamed from: f, reason: collision with root package name */
    private C0174a f1840f;
    private long g;

    /* renamed from: X3.a$a, reason: collision with other inner class name */
    public static final class C0047a {
        public final C0174a a() throws InterruptedException {
            C0174a c0174a = C0174a.f1838k;
            f3.c.b(c0174a);
            C0174a c0174a2 = c0174a.f1840f;
            if (c0174a2 == null) {
                long jNanoTime = System.nanoTime();
                C0174a.class.wait(C0174a.f1836i);
                C0174a c0174a3 = C0174a.f1838k;
                f3.c.b(c0174a3);
                if (c0174a3.f1840f != null || System.nanoTime() - jNanoTime < C0174a.f1837j) {
                    return null;
                }
                return C0174a.f1838k;
            }
            long jN = C0174a.n(c0174a2, System.nanoTime());
            if (jN > 0) {
                long j2 = jN / 1000000;
                C0174a.class.wait(j2, (int) (jN - (1000000 * j2)));
                return null;
            }
            C0174a c0174a4 = C0174a.f1838k;
            f3.c.b(c0174a4);
            c0174a4.f1840f = c0174a2.f1840f;
            c0174a2.f1840f = null;
            return c0174a2;
        }
    }

    /* renamed from: X3.a$b */
    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            C0174a c0174aA;
            while (true) {
                try {
                    synchronized (C0174a.class) {
                        c0174aA = C0174a.f1835h.a();
                        if (c0174aA == C0174a.f1838k) {
                            C0174a.f1838k = null;
                            return;
                        }
                    }
                    if (c0174aA != null) {
                        c0174aA.u();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f1836i = millis;
        f1837j = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static final long n(C0174a c0174a, long j2) {
        return c0174a.g - j2;
    }

    public final void r() {
        long jH = h();
        boolean zE = e();
        if (jH != 0 || zE) {
            synchronized (C0174a.class) {
                if (!(!this.f1839e)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                this.f1839e = true;
                if (f1838k == null) {
                    f1838k = new C0174a();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (jH != 0 && zE) {
                    this.g = Math.min(jH, c() - jNanoTime) + jNanoTime;
                } else if (jH != 0) {
                    this.g = jH + jNanoTime;
                } else {
                    if (!zE) {
                        throw new AssertionError();
                    }
                    this.g = c();
                }
                long j2 = this.g - jNanoTime;
                C0174a c0174a = f1838k;
                f3.c.b(c0174a);
                while (true) {
                    C0174a c0174a2 = c0174a.f1840f;
                    if (c0174a2 == null) {
                        break;
                    }
                    f3.c.b(c0174a2);
                    if (j2 < c0174a2.g - jNanoTime) {
                        break;
                    }
                    c0174a = c0174a.f1840f;
                    f3.c.b(c0174a);
                }
                this.f1840f = c0174a.f1840f;
                c0174a.f1840f = this;
                if (c0174a == f1838k) {
                    C0174a.class.notify();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        r1.f1840f = r4.f1840f;
        r4.f1840f = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean s() {
        boolean z4;
        synchronized (C0174a.class) {
            z4 = false;
            if (this.f1839e) {
                this.f1839e = false;
                C0174a c0174a = f1838k;
                while (true) {
                    if (c0174a == null) {
                        z4 = true;
                        break;
                    }
                    if (c0174a.f1840f == this) {
                        break;
                    }
                    c0174a = c0174a.f1840f;
                }
            }
        }
        return z4;
    }

    protected IOException t(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    protected void u() {
    }
}
