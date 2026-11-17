package X3;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: classes.dex */
public interface w extends Closeable, Flushable {
    z c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    void w(d dVar, long j2) throws IOException;
}
