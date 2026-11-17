package U;

import D2.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, Lock> f1642e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final File f1643a;

    /* renamed from: b, reason: collision with root package name */
    private final Lock f1644b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f1645c;
    private FileChannel d;

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.HashMap, java.util.Map<java.lang.String, java.util.concurrent.locks.Lock>] */
    public a(String str, File file, boolean z4) {
        Lock reentrantLock;
        File file2 = new File(file, e.c(str, ".lck"));
        this.f1643a = file2;
        String absolutePath = file2.getAbsolutePath();
        ?? r4 = f1642e;
        synchronized (r4) {
            reentrantLock = (Lock) r4.get(absolutePath);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                r4.put(absolutePath, reentrantLock);
            }
        }
        this.f1644b = reentrantLock;
        this.f1645c = z4;
    }

    public final void a() throws IOException {
        this.f1644b.lock();
        if (this.f1645c) {
            try {
                FileChannel channel = new FileOutputStream(this.f1643a).getChannel();
                this.d = channel;
                channel.lock();
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to grab copy lock.", e2);
            }
        }
    }

    public final void b() throws IOException {
        FileChannel fileChannel = this.d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f1644b.unlock();
    }
}
