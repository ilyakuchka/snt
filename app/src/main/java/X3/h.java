package X3;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class h implements w {

    /* renamed from: i, reason: collision with root package name */
    private final w f1852i;

    public h(w wVar) {
        f3.c.d(wVar, "delegate");
        this.f1852i = wVar;
    }

    @Override // X3.w
    public final z c() {
        return this.f1852i.c();
    }

    @Override // X3.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1852i.close();
    }

    @Override // X3.w, java.io.Flushable
    public void flush() throws IOException {
        this.f1852i.flush();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getClass().getSimpleName());
        sb.append('(');
        sb.append(this.f1852i);
        sb.append(')');
        return sb.toString();
    }

    @Override // X3.w
    public void w(d dVar, long j2) throws IOException {
        f3.c.d(dVar, "source");
        this.f1852i.w(dVar, j2);
    }
}
