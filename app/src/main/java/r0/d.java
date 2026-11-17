package r0;

import P0.t;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;
import com.android.mmt.MmsApp;
import com.android.mmt.transaction.CleanFileService;
import com.android.mmt.util.AbstractHandlerC0272d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d extends AbstractHandlerC0272d {
    private C0376a d;

    /* renamed from: e, reason: collision with root package name */
    private c f7687e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f7688f;
    private String g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f7689h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f7690i;

    public d(ContentResolver contentResolver) {
        super(contentResolver);
        this.d = null;
    }

    public static void h(Object obj, Uri uri, String str, c cVar, C0376a c0376a) {
        d dVar = new d(MmsApp.c().getContentResolver());
        dVar.d = c0376a;
        dVar.f7688f = uri;
        dVar.g = str;
        dVar.f7689h = null;
        dVar.f7687e = cVar;
        dVar.f(9700, obj, Telephony.Mms.CONTENT_URI, new String[]{"mx_extension", "_id"}, str, null);
    }

    @Override // com.android.mmt.util.AbstractHandlerC0272d
    protected final void b(int i2, Object obj, int i4) {
        if (this.f7690i != null) {
            Intent intent = new Intent(MmsApp.c(), (Class<?>) CleanFileService.class);
            int i5 = CleanFileService.f4506i;
            intent.putExtra("msg_type", 1);
            Bundle bundle = new Bundle();
            bundle.putStringArray("paths", this.f7690i);
            intent.putExtras(bundle);
            MmsApp.c().startService(intent);
        }
        t.d().c(ContentUris.parseId(this.f7688f));
        c cVar = this.f7687e;
        if (cVar != null) {
            cVar.a(obj);
        }
    }

    @Override // com.android.mmt.util.AbstractHandlerC0272d
    protected final void c(int i2, Object obj, Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        try {
                            try {
                                JSONArray jSONArray = new JSONArray(cursor.getString(0));
                                long j2 = cursor.getLong(1);
                                C0376a c0376a = this.d;
                                if (c0376a != null) {
                                    c0376a.b(j2);
                                    this.d.c(j2);
                                }
                                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                    try {
                                        arrayList.add(((JSONObject) jSONArray.get(i4)).getString("filename"));
                                    } catch (JSONException e2) {
                                        Log.e("Mx2DeleteHelper", "JSON failed.", e2);
                                    }
                                }
                            } catch (NullPointerException e4) {
                                Log.e("Mx2DeleteHelper", "JSONArray NullPointer.", e4);
                            }
                        } catch (JSONException e5) {
                            Log.e("Mx2DeleteHelper", "JSON failed.", e5);
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
                String[] strArr = new String[arrayList.size()];
                this.f7690i = strArr;
                arrayList.toArray(strArr);
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
        }
        e(i2, obj, this.f7688f, this.g, this.f7689h);
    }
}
