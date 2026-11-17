package X3;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public interface y extends Closeable {
    long U(d dVar, long j2) throws IOException;

    z c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
