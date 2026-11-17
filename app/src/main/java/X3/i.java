package X3;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class i implements y {

    /* renamed from: i, reason: collision with root package name */
    private final y f1853i;

    public i(y yVar) {
        f3.c.d(yVar, "delegate");
        this.f1853i = yVar;
    }

    @Override // X3.y
    public final z c() {
        return this.f1853i.c();
    }

    @Override // X3.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1853i.close();
    }

    public final y f() {
        return this.f1853i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getClass().getSimpleName());
        sb.append('(');
        sb.append(this.f1853i);
        sb.append(')');
        return sb.toString();
    }
}
