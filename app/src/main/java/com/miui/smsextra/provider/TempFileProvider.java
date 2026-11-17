package com.miui.smsextra.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import w.C0406b;

/* loaded from: classes.dex */
public class TempFileProvider extends C0406b {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f6137m = 0;

    public static String d(Context context) {
        if (context == null) {
            return null;
        }
        return context.getCacheDir().getAbsolutePath() + "/.temp.jpg";
    }

    @Override // w.C0406b, android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // w.C0406b, android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // w.C0406b, android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        if (Log.isLoggable("TempFileProvider", 2)) {
            Log.d("TempFileProvider", "openFile: uri=" + uri + ", mode=" + str);
        }
        if (!TextUtils.isEmpty(str) && str.contains("w")) {
            String strD = d(getContext());
            if (!TextUtils.isEmpty(strD)) {
                try {
                    File file = new File(strD);
                    File parentFile = file.getParentFile();
                    if (parentFile.exists() || parentFile.mkdirs()) {
                        ParcelFileDescriptor.open(file, 939524096);
                    } else {
                        Log.e("TempFileProvider", "[TempFileProvider] tempStoreFd: " + parentFile.getPath() + "does not exist!");
                    }
                } catch (Exception e2) {
                    Log.e("TempFileProvider", "getTempStoreFd: error creating pfd for " + strD, e2);
                }
            }
        }
        return super.openFile(uri, str);
    }

    @Override // w.C0406b, android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // w.C0406b, android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
