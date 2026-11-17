package s1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
public final class d extends InputStream {

    /* renamed from: k, reason: collision with root package name */
    private static final Queue<d> f7850k;

    /* renamed from: i, reason: collision with root package name */
    private InputStream f7851i;

    /* renamed from: j, reason: collision with root package name */
    private IOException f7852j;

    static {
        int i2 = j.f7867c;
        f7850k = new ArrayDeque(0);
    }

    d() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayDeque, java.util.Queue<s1.d>] */
    public static d H(InputStream inputStream) {
        d dVar;
        ?? r02 = f7850k;
        synchronized (r02) {
            dVar = (d) r02.poll();
        }
        if (dVar == null) {
            dVar = new d();
        }
        dVar.f7851i = inputStream;
        return dVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayDeque, java.util.Queue<s1.d>] */
    public final void I() {
        this.f7852j = null;
        this.f7851i = null;
        ?? r02 = f7850k;
        synchronized (r02) {
            r02.offer(this);
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.f7851i.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f7851i.close();
    }

    public final IOException f() {
        return this.f7852j;
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        this.f7851i.mark(i2);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f7851i.markSupported();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        try {
            return this.f7851i.read(bArr);
        } catch (IOException e2) {
            this.f7852j = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.f7851i.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        try {
            return this.f7851i.skip(j2);
        } catch (IOException e2) {
            this.f7852j = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i4) {
        try {
            return this.f7851i.read(bArr, i2, i4);
        } catch (IOException e2) {
            this.f7852j = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.f7851i.read();
        } catch (IOException e2) {
            this.f7852j = e2;
            return -1;
        }
    }
}
