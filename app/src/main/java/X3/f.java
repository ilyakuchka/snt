package X3;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public interface f extends y, ReadableByteChannel {
    int E(p pVar) throws IOException;

    String N() throws IOException;

    byte[] P() throws IOException;

    void Q(long j2) throws IOException;

    boolean V() throws IOException;

    byte[] Z(long j2) throws IOException;

    void a(long j2) throws IOException;

    long a0() throws IOException;

    d b();

    String c0(Charset charset) throws IOException;

    d o();

    g q(long j2) throws IOException;

    byte readByte() throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    String t(long j2) throws IOException;

    boolean z(long j2) throws IOException;
}
