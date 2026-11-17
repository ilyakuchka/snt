package W;

import android.database.sqlite.SQLiteProgram;

/* loaded from: classes.dex */
class d implements V.d {

    /* renamed from: i, reason: collision with root package name */
    private final SQLiteProgram f1785i;

    d(SQLiteProgram sQLiteProgram) {
        this.f1785i = sQLiteProgram;
    }

    @Override // V.d
    public final void J(int i2, byte[] bArr) {
        this.f1785i.bindBlob(i2, bArr);
    }

    @Override // V.d
    public final void L(int i2) {
        this.f1785i.bindNull(i2);
    }

    @Override // V.d
    public final void O(int i2, double d) {
        this.f1785i.bindDouble(i2, d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1785i.close();
    }

    @Override // V.d
    public final void u(int i2, String str) {
        this.f1785i.bindString(i2, str);
    }

    @Override // V.d
    public final void v(int i2, long j2) {
        this.f1785i.bindLong(i2, j2);
    }
}
