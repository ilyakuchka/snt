package W;

import V.f;
import android.database.sqlite.SQLiteStatement;

/* loaded from: classes.dex */
final class e extends d implements f {

    /* renamed from: j, reason: collision with root package name */
    private final SQLiteStatement f1786j;

    e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f1786j = sQLiteStatement;
    }

    @Override // V.f
    public final int B() {
        return this.f1786j.executeUpdateDelete();
    }

    @Override // V.f
    public final long W() {
        return this.f1786j.executeInsert();
    }
}
