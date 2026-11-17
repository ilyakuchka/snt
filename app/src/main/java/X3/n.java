package X3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes.dex */
public final class n {
    public static final boolean a(byte[] bArr, int i2, byte[] bArr2, int i4, int i5) {
        f3.c.d(bArr, "a");
        f3.c.d(bArr2, "b");
        if (i5 <= 0) {
            return true;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6 + 1;
            if (bArr[i6 + i2] != bArr2[i6 + i4]) {
                return false;
            }
            if (i7 >= i5) {
                return true;
            }
            i6 = i7;
        }
    }

    public static final e b(w wVar) {
        f3.c.d(wVar, "<this>");
        return new r(wVar);
    }

    public static final f c(y yVar) {
        return new s(yVar);
    }

    public static final void d(long j2, long j4, long j5) {
        if ((j4 | j5) < 0 || j4 > j2 || j2 - j4 < j5) {
            throw new ArrayIndexOutOfBoundsException("size=" + j2 + " offset=" + j4 + " byteCount=" + j5);
        }
    }

    public static final boolean e(AssertionError assertionError) {
        int i2 = o.f1867b;
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message == null ? false : i3.f.g(message, "getsockname failed");
    }

    public static final w f(Socket socket) throws IOException {
        int i2 = o.f1867b;
        x xVar = new x(socket);
        OutputStream outputStream = socket.getOutputStream();
        f3.c.c(outputStream, "getOutputStream()");
        return new b(xVar, new q(outputStream, xVar));
    }

    public static final y g(InputStream inputStream) {
        int i2 = o.f1867b;
        return new m(inputStream, new z());
    }

    public static final y h(Socket socket) throws IOException {
        int i2 = o.f1867b;
        x xVar = new x(socket);
        InputStream inputStream = socket.getInputStream();
        f3.c.c(inputStream, "getInputStream()");
        return new c(xVar, new m(inputStream, xVar));
    }
}
