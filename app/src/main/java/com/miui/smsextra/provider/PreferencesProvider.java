package com.miui.smsextra.provider;

import C0.a;
import D2.e;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;
import androidx.preference.g;

/* loaded from: classes.dex */
public class PreferencesProvider extends ContentProvider {

    /* renamed from: i, reason: collision with root package name */
    private UriMatcher f6135i;

    /* renamed from: j, reason: collision with root package name */
    private SharedPreferences f6136j;

    static {
        Uri.parse("content://com.android.mmt.prefprovider");
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f6135i = uriMatcher;
        uriMatcher.addURI("com.android.mmt.prefprovider", "networkstate", 0);
        this.f6136j = g.c(a.c());
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (this.f6135i.match(uri) != 0) {
            return null;
        }
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("default", false);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"value"});
        if (this.f6136j.contains("pref_key_allow_network_access")) {
            matrixCursor.newRow().add(Integer.valueOf(this.f6136j.getBoolean("pref_key_allow_network_access", booleanQueryParameter) ? 1 : 0));
        }
        StringBuilder sbD = e.d("query uri: ");
        sbD.append(uri.toString());
        Log.v("PreferencesProvider", sbD.toString());
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
