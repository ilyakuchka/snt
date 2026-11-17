package L0;

import M0.h;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.storage.bugle.BugleDatabase;
import g0.C0309e;
import g0.C0319o;
import java.util.ArrayList;
import java.util.List;
import t.C0384b;

/* loaded from: classes.dex */
public final class b {
    public static final List a(long j2, boolean z4) {
        String string;
        long j4;
        int i2;
        boolean z5;
        a aVar = null;
        if (j2 < 0) {
            return null;
        }
        Cursor cursorS = C0384b.s(K0.b.a().b(), K0.b.a().b().getContentResolver(), ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, j2), h.f584a, null, null);
        Log.d("ConversationUpdater", "update: " + j2 + " | " + cursorS);
        ArrayList arrayList = new ArrayList();
        BugleDatabase bugleDatabaseY = BugleDatabase.y();
        bugleDatabaseY.x().D(j2);
        if (cursorS == null || cursorS.getCount() <= 0) {
            bugleDatabaseY.x().j(j2);
        } else {
            Context contextB = K0.b.a().b();
            ContentResolver contentResolver = K0.b.a().b().getContentResolver();
            Uri uriBuild = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter("simple", "true").build();
            String[] strArr = M0.g.f583a;
            StringBuilder sbD = D2.e.d("_id=");
            sbD.append(Long.toString(j2));
            cursorS = C0384b.s(contextB, contentResolver, uriBuild, strArr, sbD.toString(), null);
            if (cursorS != null) {
                try {
                    try {
                    } catch (Exception e2) {
                        Log.e("ConversationUpdater", "getDbConversation", e2);
                    }
                    if (cursorS.moveToFirst()) {
                        a aVar2 = new a();
                        aVar2.z(cursorS.getInt(cursorS.getColumnIndexOrThrow("_id")));
                        aVar2.s(cursorS.getLong(cursorS.getColumnIndexOrThrow("date")));
                        aVar2.A(cursorS.getInt(cursorS.getColumnIndexOrThrow("message_count")));
                        aVar2.C(cursorS.getString(cursorS.getColumnIndexOrThrow("snippet")));
                        aVar2.D(cursorS.getInt(cursorS.getColumnIndexOrThrow("snippet_cs")));
                        aVar2.B(cursorS.getInt(cursorS.getColumnIndexOrThrow("read")));
                        aVar2.F(cursorS.getInt(cursorS.getColumnIndexOrThrow("type")));
                        aVar2.u(cursorS.getInt(cursorS.getColumnIndexOrThrow("error")));
                        aVar2.v(cursorS.getInt(cursorS.getColumnIndexOrThrow("has_attachment")));
                        cursorS.close();
                        cursorS.close();
                        aVar = aVar2;
                    }
                } finally {
                    cursorS.close();
                }
            }
            a aVarT = bugleDatabaseY.x().t(j2);
            if (aVar == null) {
                bugleDatabaseY.x().j(j2);
                return arrayList;
            }
            Log.d("ConversationUpdater", "updateConversation common: " + j2 + " | " + cursorS.getCount());
            if (cursorS.moveToLast()) {
                if ("sms".equals(cursorS.getString(0))) {
                    string = cursorS.getString(4);
                    j4 = cursorS.getLong(5);
                    i2 = cursorS.getInt(8);
                } else {
                    string = cursorS.getString(15);
                    if (!TextUtils.isEmpty(string)) {
                        string = new C0309e(cursorS.getInt(16), C0319o.d(string)).f();
                    }
                    j4 = cursorS.getLong(5) * 1000;
                    i2 = cursorS.getInt(13);
                }
                if (aVarT == null) {
                    aVarT = new a();
                    aVarT.z(j2);
                    z5 = true;
                } else {
                    z5 = false;
                }
                aVarT.A(cursorS.getCount());
                aVarT.C(string);
                aVarT.D(0);
                aVarT.s(j4);
                aVarT.G(aVar.m());
                aVarT.B(aVar.h());
                aVarT.y(i2 == 3);
                aVarT.v(aVar.d());
                aVarT.u(aVar.c());
                arrayList.add(aVarT);
                if (z4) {
                    if (z5) {
                        bugleDatabaseY.x().p(aVarT);
                    } else {
                        bugleDatabaseY.x().E(aVarT);
                    }
                }
            }
        }
        if (cursorS != null && !cursorS.isClosed()) {
        }
        return arrayList;
    }
}
