package X3;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface e extends w, WritableByteChannel {
    e D(g gVar) throws IOException;

    e F(int i2) throws IOException;

    e S(String str) throws IOException;

    e X(int i2) throws IOException;

    d b();

    e d(byte[] bArr) throws IOException;

    @Override // X3.w, java.io.Flushable
    void flush() throws IOException;

    e g(byte[] bArr, int i2, int i4) throws IOException;

    e m(long j2) throws IOException;

    e x(int i2) throws IOException;
}
