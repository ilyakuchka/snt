package com.android.mmt.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import com.android.mmt.R;
import g0.C0309e;
import g0.C0319o;

/* renamed from: com.android.mmt.util.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0271c {
    public static String a(Context context, Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        Uri.Builder builderBuildUpon = Telephony.Mms.CONTENT_URI.buildUpon();
        builderBuildUpon.appendPath(lastPathSegment).appendPath("addr");
        Cursor cursorE = O.e(context, context.getContentResolver(), builderBuildUpon.build(), new String[]{"address", "charset"}, "type=137", null, null);
        if (cursorE != null) {
            try {
                if (cursorE.moveToFirst()) {
                    String string = cursorE.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        return new C0309e(cursorE.getInt(1), C0319o.d(string)).f();
                    }
                }
            } finally {
                cursorE.close();
            }
        }
        return context.getString(R.string.hidden_sender_address);
    }
}
