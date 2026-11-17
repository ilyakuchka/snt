package L0;

import R.i;
import R.k;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class f extends T.b<a> {
    f(i iVar, k kVar, String... strArr) {
        super(iVar, kVar, strArr);
    }

    @Override // T.b
    protected final List<a> i(Cursor cursor) {
        int iA = U.b.a(cursor, "_id");
        int iA2 = U.b.a(cursor, "date");
        int iA3 = U.b.a(cursor, "message_count");
        int iA4 = U.b.a(cursor, "snippet");
        int iA5 = U.b.a(cursor, "snippet_cs");
        int iA6 = U.b.a(cursor, "unread_count");
        int iA7 = U.b.a(cursor, "read");
        int iA8 = U.b.a(cursor, "type");
        int iA9 = U.b.a(cursor, "error");
        int iA10 = U.b.a(cursor, "has_attachment");
        int iA11 = U.b.a(cursor, "has_draft");
        int iA12 = U.b.a(cursor, "sp_type");
        int iA13 = U.b.a(cursor, "update_at");
        int iA14 = U.b.a(cursor, "blocked");
        ArrayList arrayList = new ArrayList(cursor.getCount());
        while (cursor.moveToNext()) {
            a aVar = new a();
            int i2 = iA12;
            int i4 = iA13;
            aVar.z(cursor.getLong(iA));
            aVar.s(cursor.getLong(iA2));
            aVar.A(cursor.getLong(iA3));
            aVar.C(cursor.isNull(iA4) ? null : cursor.getString(iA4));
            aVar.D(cursor.getInt(iA5));
            aVar.G(cursor.getInt(iA6));
            aVar.B(cursor.getInt(iA7));
            aVar.F(cursor.getInt(iA8));
            aVar.u(cursor.getInt(iA9));
            aVar.v(cursor.getInt(iA10));
            aVar.x(cursor.getLong(iA11));
            iA12 = i2;
            aVar.E(cursor.getInt(iA12));
            iA13 = i4;
            aVar.H(cursor.getLong(iA13));
            aVar.r(cursor.getInt(iA14));
            arrayList.add(aVar);
            iA = iA;
            iA2 = iA2;
        }
        return arrayList;
    }
}
