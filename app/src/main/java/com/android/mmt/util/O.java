package com.android.mmt.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.android.mmt.MmsApp;
import com.android.mmt.R;

/* loaded from: classes.dex */
public final class O {

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f5913i;

        a(Context context) {
            this.f5913i = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(MmsApp.c(), this.f5913i.getText(R.string.sqlite_low_memory), 0).show();
        }
    }

    public static void a(Context context, SQLiteException sQLiteException) {
        if (!sQLiteException.getMessage().contains("unable to open database file")) {
            throw sQLiteException;
        }
        S2.e.a().post(new a(context));
    }

    public static boolean b(SQLiteException sQLiteException) {
        if (!(sQLiteException instanceof SQLiteFullException) || !sQLiteException.getMessage().contains("database or disk is full")) {
            return false;
        }
        Log.e("SmsSqliteWrapper", "Sqlite disk is full.");
        return true;
    }

    public static int c(Context context, ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        try {
            return contentResolver.delete(uri, str, strArr);
        } catch (SQLiteException e2) {
            Log.e("SmsSqliteWrapper", "Catch a SQLiteException when delete: ", e2);
            if (!b(e2)) {
                a(context, e2);
            }
            return -1;
        } catch (SecurityException e4) {
            A.g(e4);
            return -1;
        }
    }

    public static Uri d(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        try {
            return contentResolver.insert(uri, contentValues);
        } catch (SQLiteException e2) {
            Log.e("SmsSqliteWrapper", "Catch a SQLiteException when insert: ", e2);
            if (!b(e2)) {
                a(context, e2);
            }
            return null;
        } catch (SecurityException e4) {
            A.g(e4);
            return null;
        }
    }

    public static Cursor e(Context context, ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (SQLiteException e2) {
            Log.e("SmsSqliteWrapper", "Catch a SQLiteException when query: ", e2);
            if (!b(e2)) {
                a(context, e2);
            }
            return null;
        } catch (SecurityException e4) {
            A.g(e4);
            return null;
        }
    }

    public static Cursor f(Context context, ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (SQLiteException e2) {
            Log.e("SmsSqliteWrapper", "Catch a SQLiteException when query: ", e2);
            if (!b(e2)) {
                a(context, e2);
            }
            return null;
        } catch (SecurityException e4) {
            A.e(e4);
            return null;
        }
    }

    public static int g(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return contentResolver.update(uri, contentValues, str, strArr);
        } catch (SQLiteException e2) {
            Log.e("SmsSqliteWrapper", "Catch a SQLiteException when update: ", e2);
            if (!b(e2)) {
                a(context, e2);
            }
            return -1;
        } catch (SecurityException e4) {
            A.g(e4);
            return -1;
        }
    }
}
