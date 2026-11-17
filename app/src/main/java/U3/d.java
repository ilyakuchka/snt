package U3;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: classes.dex */
public final class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1728a = new d();

    private d() {
    }

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }

    @Override // java.util.logging.Handler
    public final void publish(LogRecord logRecord) {
        f3.c.d(logRecord, "record");
        c cVar = c.f1725a;
        String loggerName = logRecord.getLoggerName();
        f3.c.c(loggerName, "record.loggerName");
        int i2 = logRecord.getLevel().intValue() > Level.INFO.intValue() ? 5 : logRecord.getLevel().intValue() == Level.INFO.intValue() ? 4 : 3;
        String message = logRecord.getMessage();
        f3.c.c(message, "record.message");
        c.a(loggerName, i2, message, logRecord.getThrown());
    }
}
