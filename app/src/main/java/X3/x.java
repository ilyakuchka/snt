package X3;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* loaded from: classes.dex */
final class x extends C0174a {

    /* renamed from: l, reason: collision with root package name */
    private final Socket f1889l;

    public x(Socket socket) {
        this.f1889l = socket;
    }

    @Override // X3.C0174a
    protected final IOException t(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // X3.C0174a
    protected final void u() throws IOException {
        try {
            this.f1889l.close();
        } catch (AssertionError e2) {
            if (!n.e(e2)) {
                throw e2;
            }
            o.f1866a.log(Level.WARNING, f3.c.h("Failed to close timed out socket ", this.f1889l), (Throwable) e2);
        } catch (Exception e4) {
            o.f1866a.log(Level.WARNING, f3.c.h("Failed to close timed out socket ", this.f1889l), (Throwable) e4);
        }
    }
}
