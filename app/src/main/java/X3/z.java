package X3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class z {
    public static final a d = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f1890a;

    /* renamed from: b, reason: collision with root package name */
    private long f1891b;

    /* renamed from: c, reason: collision with root package name */
    private long f1892c;

    public static final class a extends z {
        a() {
        }

        @Override // X3.z
        public final z d(long j2) {
            return this;
        }

        @Override // X3.z
        public final void f() {
        }

        @Override // X3.z
        public final z g(long j2) {
            f3.c.d(TimeUnit.MILLISECONDS, "unit");
            return this;
        }
    }

    public z a() {
        this.f1890a = false;
        return this;
    }

    public z b() {
        this.f1892c = 0L;
        return this;
    }

    public long c() {
        if (this.f1890a) {
            return this.f1891b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public z d(long j2) {
        this.f1890a = true;
        this.f1891b = j2;
        return this;
    }

    public boolean e() {
        return this.f1890a;
    }

    public void f() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f1890a && this.f1891b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public z g(long j2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        f3.c.d(timeUnit, "unit");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(f3.c.h("timeout < 0: ", Long.valueOf(j2)).toString());
        }
        this.f1892c = timeUnit.toNanos(j2);
        return this;
    }

    public final long h() {
        return this.f1892c;
    }
}
