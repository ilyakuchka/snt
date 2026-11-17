package R;

import java.io.IOException;

/* loaded from: classes.dex */
final class b implements V.c, d {

    /* renamed from: i, reason: collision with root package name */
    private final V.c f1224i;

    /* renamed from: j, reason: collision with root package name */
    private final a f1225j;

    static final class a implements V.b {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            throw null;
        }

        final void f() {
            throw null;
        }
    }

    @Override // V.c
    public final V.b T() {
        this.f1225j.f();
        return this.f1225j;
    }

    @Override // V.c, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            this.f1225j.close();
        } catch (IOException e2) {
            throw e2;
        }
    }

    @Override // R.d
    public final V.c f() {
        return this.f1224i;
    }

    @Override // V.c
    public final String getDatabaseName() {
        return this.f1224i.getDatabaseName();
    }

    @Override // V.c
    public final void setWriteAheadLoggingEnabled(boolean z4) {
        this.f1224i.setWriteAheadLoggingEnabled(z4);
    }
}
