package x0;

import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import com.android.mmt.util.O;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    private static Uri f8087e = Uri.parse("content://mms-sms/canonical-addresses");

    /* renamed from: f, reason: collision with root package name */
    private static Uri f8088f = Uri.parse("content://mms-sms/canonical-address");
    private static f g;
    private final Context d;

    /* renamed from: c, reason: collision with root package name */
    private HashSet<C0414a> f8091c = new HashSet<>();

    /* renamed from: a, reason: collision with root package name */
    private final LongSparseArray<String> f8089a = new LongSparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final LongSparseArray<String> f8090b = new LongSparseArray<>();

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ LongSparseArray f8092i;

        a(LongSparseArray longSparseArray) {
            this.f8092i = longSparseArray;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (int i2 = 0; i2 < this.f8092i.size(); i2++) {
                f.b(f.g, this.f8092i.keyAt(i2), (String) this.f8092i.valueAt(i2));
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f8093a;

        /* renamed from: b, reason: collision with root package name */
        public String f8094b;

        /* renamed from: c, reason: collision with root package name */
        public String f8095c;

        public b(long j2, String str, String str2) {
            this.f8093a = j2;
            this.f8094b = str;
            this.f8095c = str2;
        }
    }

    f(Context context) {
        this.d = context;
    }

    static void b(f fVar, long j2, String str) {
        Objects.requireNonNull(fVar);
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", str);
        Uri uriWithAppendedId = ContentUris.withAppendedId(f8088f, j2);
        Context context = fVar.d;
        O.g(context, context.getContentResolver(), uriWithAppendedId, contentValues, "_id=" + j2, null);
    }

    public static void d() {
        Y1.a.c("[RecipientIdCache] fill: begin", new Object[0]);
        Context context = g.d;
        Cursor cursorE = O.e(context, context.getContentResolver(), f8087e, null, null, null, null);
        if (cursorE == null) {
            Log.w("Mms/cache", "null Cursor in fill()");
            return;
        }
        try {
            synchronized (g) {
                while (cursorE.moveToNext()) {
                    g.f8089a.put(cursorE.getLong(0), cursorE.getString(1));
                }
            }
        } finally {
            cursorE.close();
        }
    }

    public static List<b> e(String str) {
        synchronized (g) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            for (String str2 : str.split(" ")) {
                try {
                    long j2 = Long.parseLong(str2);
                    String str3 = g.f8089a.get(j2);
                    if (str3 == null) {
                        d();
                        str3 = g.f8089a.get(j2);
                    }
                    String str4 = g.f8090b.get(j2);
                    if (TextUtils.isEmpty(str3)) {
                        Log.w("Mms/cache", "RecipientId " + j2 + " has empty number!");
                    } else {
                        arrayList.add(new b(j2, str3, str4));
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return arrayList;
        }
    }

    static f f() {
        return g;
    }

    public static String g(Context context, String str) throws NumberFormatException {
        try {
            Cursor cursorE = O.e(context, context.getContentResolver(), ContentUris.withAppendedId(f8088f, Long.parseLong(str)), null, null, null, null);
            if (cursorE == null) {
                return null;
            }
            try {
                if (cursorE.moveToFirst()) {
                    return cursorE.getString(0);
                }
                return null;
            } finally {
                cursorE.close();
            }
        } catch (NumberFormatException e2) {
            Log.e("Mms/cache", "getSingleAddressFromCanonicalAddressInDb parseLong ", e2);
            return null;
        }
    }

    static void h(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (g == null) {
            g = new f(applicationContext);
        }
    }

    public static void i(C0415b c0415b) {
        LongSparseArray longSparseArray = new LongSparseArray();
        Iterator<C0414a> it = c0415b.iterator();
        while (it.hasNext()) {
            C0414a next = it.next();
            if (next.k0()) {
                next.r0();
                long jC0 = next.c0();
                if (jC0 == 0) {
                    continue;
                } else {
                    String strW = next.W();
                    synchronized (g) {
                        if (!strW.equalsIgnoreCase(g.f8089a.get(jC0))) {
                            g.f8089a.put(jC0, strW);
                            longSparseArray.put(jC0, strW);
                        }
                    }
                }
            }
        }
        if (longSparseArray.size() > 0) {
            Q2.c.a(new a(longSparseArray));
        }
    }

    public final void c(C0414a c0414a) {
        synchronized (g) {
            if (this.f8090b.size() == 0) {
                return;
            }
            if (!TextUtils.equals(this.f8090b.get(c0414a.c0()), c0414a.b0())) {
                this.f8090b.put(c0414a.c0(), c0414a.b0());
                this.f8091c.add(c0414a);
            }
        }
    }

    public final void j() throws RemoteException, OperationApplicationException {
        HashSet hashSet;
        synchronized (g) {
            hashSet = (HashSet) this.f8091c.clone();
        }
        if (hashSet.size() == 0) {
            return;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        Iterator it = hashSet.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C0414a c0414a = (C0414a) it.next();
            if (i2 < 50) {
                arrayList.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(f8088f, c0414a.c0())).withValue("name", c0414a.b0()).build());
            } else {
                try {
                    this.d.getContentResolver().applyBatch("mms-sms", arrayList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                arrayList.clear();
                arrayList.add(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(f8088f, c0414a.c0())).withValue("name", c0414a.b0()).build());
                i2 = 0;
            }
            i2++;
        }
        if (arrayList.size() > 0) {
            try {
                this.d.getContentResolver().applyBatch("mms-sms", arrayList);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        synchronized (g) {
            this.f8091c.clear();
        }
        hashSet.clear();
    }
}
