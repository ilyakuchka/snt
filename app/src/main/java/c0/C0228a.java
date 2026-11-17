package c0;

import D2.e;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/* renamed from: c0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0228a {

    /* renamed from: a, reason: collision with root package name */
    private final ContentResolver f4379a;

    /* renamed from: c0.a$a, reason: collision with other inner class name */
    public static final class C0081a {

        /* renamed from: a, reason: collision with root package name */
        static final Uri f4380a = Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, "usagefeedback");
    }

    public C0228a(Context context) {
        this.f4379a = context.getContentResolver();
    }

    public final boolean a(Collection<String> collection) {
        if (Log.isLoggable("a", 3)) {
            StringBuilder sbD = e.d("updateWithPhoneNumber: ");
            sbD.append(Arrays.toString(collection.toArray()));
            Log.d("a", sbD.toString());
        }
        if (!collection.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            String[] strArr = new String[collection.size()];
            arrayList.addAll(collection);
            Arrays.fill(strArr, "?");
            sb.append("data1 IN (");
            sb.append(TextUtils.join(",", strArr));
            sb.append(")");
            Cursor cursorQuery = this.f4379a.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"contact_id", "_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null);
            if (cursorQuery != null) {
                HashSet hashSet = new HashSet(cursorQuery.getCount());
                HashSet hashSet2 = new HashSet(cursorQuery.getCount());
                try {
                    cursorQuery.move(-1);
                    while (cursorQuery.moveToNext()) {
                        hashSet.add(Long.valueOf(cursorQuery.getLong(0)));
                        hashSet2.add(Long.valueOf(cursorQuery.getLong(1)));
                    }
                    cursorQuery.close();
                    System.currentTimeMillis();
                    if (hashSet2.isEmpty()) {
                        if (!Log.isLoggable("a", 3)) {
                            return false;
                        }
                        Log.d("a", "Given list for data IDs is null. Ignoring.");
                        return false;
                    }
                    if (this.f4379a.update(C0081a.f4380a.buildUpon().appendPath(TextUtils.join(",", hashSet2)).appendQueryParameter("type", "short_text").build(), new ContentValues(), null, null) > 0) {
                        return true;
                    }
                    if (!Log.isLoggable("a", 3)) {
                        return false;
                    }
                    Log.d("a", "update toward data rows " + hashSet2 + " failed");
                    return false;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            Log.w("a", "Cursor for Phone.CONTENT_URI became null.");
        }
        return false;
    }
}
