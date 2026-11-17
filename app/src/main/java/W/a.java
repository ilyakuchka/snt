package W;

import V.f;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Pair;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
final class a implements V.b {

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f1770j = new String[0];

    /* renamed from: i, reason: collision with root package name */
    private final SQLiteDatabase f1771i;

    /* renamed from: W.a$a, reason: collision with other inner class name */
    final class C0044a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ V.e f1772a;

        C0044a(V.e eVar) {
            this.f1772a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f1772a.H(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    a(SQLiteDatabase sQLiteDatabase) {
        this.f1771i = sQLiteDatabase;
    }

    @Override // V.b
    public final f C(String str) {
        return new e(this.f1771i.compileStatement(str));
    }

    @Override // V.b
    public final void G() {
        this.f1771i.beginTransactionNonExclusive();
    }

    @Override // V.b
    public final Cursor R(V.e eVar) {
        return this.f1771i.rawQueryWithFactory(new C0044a(eVar), eVar.f(), f1770j, null);
    }

    @Override // V.b
    public final Cursor Y(String str) {
        return R(new V.a(str));
    }

    @Override // V.b
    public final boolean b0() {
        return this.f1771i.inTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f1771i.close();
    }

    final boolean f(SQLiteDatabase sQLiteDatabase) {
        return this.f1771i == sQLiteDatabase;
    }

    @Override // V.b
    public final String getPath() {
        return this.f1771i.getPath();
    }

    @Override // V.b
    public final void i() {
        this.f1771i.endTransaction();
    }

    @Override // V.b
    public final boolean isOpen() {
        return this.f1771i.isOpen();
    }

    @Override // V.b
    public final void j() {
        this.f1771i.beginTransaction();
    }

    @Override // V.b
    public final List<Pair<String, String>> n() {
        return this.f1771i.getAttachedDbs();
    }

    @Override // V.b
    public final boolean p() {
        return this.f1771i.isWriteAheadLoggingEnabled();
    }

    @Override // V.b
    public final void s(String str) throws SQLException {
        this.f1771i.execSQL(str);
    }

    @Override // V.b
    public final void y() {
        this.f1771i.setTransactionSuccessful();
    }
}
