package R;

import V.c;
import android.database.Cursor;
import android.database.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class j extends c.a {

    /* renamed from: b, reason: collision with root package name */
    private c f1275b;

    /* renamed from: c, reason: collision with root package name */
    private final a f1276c;

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1277a = 2;

        protected abstract void a(V.b bVar);

        protected abstract void b(V.b bVar);

        protected abstract void c(V.b bVar);

        protected abstract void d(V.b bVar);

        protected abstract b e(V.b bVar);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1278a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1279b;

        public b(boolean z4, String str) {
            this.f1278a = z4;
            this.f1279b = str;
        }
    }

    public j(c cVar, a aVar) {
        super(aVar.f1277a);
        this.f1275b = cVar;
        this.f1276c = aVar;
    }

    private void h(V.b bVar) throws SQLException {
        bVar.s("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        bVar.s("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f43fc469e99ef5157d82eba7b211a219')");
    }

    @Override // V.c.a
    public final void b() {
    }

    @Override // V.c.a
    public final void d(V.b bVar) throws SQLException {
        Cursor cursorY = bVar.Y("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z4 = false;
            if (cursorY.moveToFirst()) {
                if (cursorY.getInt(0) == 0) {
                    z4 = true;
                }
            }
            cursorY.close();
            this.f1276c.a(bVar);
            if (!z4) {
                b bVarE = this.f1276c.e(bVar);
                if (!bVarE.f1278a) {
                    StringBuilder sbD = D2.e.d("Pre-packaged database has an invalid schema: ");
                    sbD.append(bVarE.f1279b);
                    throw new IllegalStateException(sbD.toString());
                }
            }
            h(bVar);
            this.f1276c.b(bVar);
        } catch (Throwable th) {
            cursorY.close();
            throw th;
        }
    }

    @Override // V.c.a
    public final void e(V.b bVar, int i2, int i4) throws SQLException {
        g(bVar, i2, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // V.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(V.b bVar) throws SQLException {
        boolean z4;
        Cursor cursorY = bVar.Y("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            if (cursorY.moveToFirst()) {
                z4 = cursorY.getInt(0) != 0;
            }
            cursorY.close();
            if (z4) {
                Cursor cursorR = bVar.R(new V.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                try {
                    String string = cursorR.moveToFirst() ? cursorR.getString(0) : null;
                    cursorR.close();
                    if (!"f43fc469e99ef5157d82eba7b211a219".equals(string) && !"4dd7185f9d7e66784d6cdefbd59a788f".equals(string)) {
                        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                    }
                } catch (Throwable th) {
                    cursorR.close();
                    throw th;
                }
            } else {
                b bVarE = this.f1276c.e(bVar);
                if (!bVarE.f1278a) {
                    StringBuilder sbD = D2.e.d("Pre-packaged database has an invalid schema: ");
                    sbD.append(bVarE.f1279b);
                    throw new IllegalStateException(sbD.toString());
                }
                Objects.requireNonNull(this.f1276c);
                h(bVar);
            }
            this.f1276c.c(bVar);
            this.f1275b = null;
        } catch (Throwable th2) {
            cursorY.close();
            throw th2;
        }
    }

    @Override // V.c.a
    public final void g(V.b bVar, int i2, int i4) throws SQLException {
        boolean z4;
        List<S.a> listB;
        c cVar = this.f1275b;
        if (cVar == null || (listB = cVar.d.b(i2, i4)) == null) {
            z4 = false;
        } else {
            this.f1276c.d(bVar);
            Iterator<S.a> it = listB.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            b bVarE = this.f1276c.e(bVar);
            if (!bVarE.f1278a) {
                StringBuilder sbD = D2.e.d("Migration didn't properly handle: ");
                sbD.append(bVarE.f1279b);
                throw new IllegalStateException(sbD.toString());
            }
            Objects.requireNonNull(this.f1276c);
            h(bVar);
            z4 = true;
        }
        if (z4) {
            return;
        }
        throw new IllegalStateException("A migration from " + i2 + " to " + i4 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}
