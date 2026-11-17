package com.android.mmt.util;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.android.mmt.util.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0283o {
    private static int a(int i2) {
        if (i2 == 3) {
            return 180;
        }
        if (i2 != 6) {
            return i2 != 8 ? 0 : 270;
        }
        return 90;
    }

    public static int b(String str) {
        try {
            return a(new ExifInterface(str).getAttributeInt("Orientation", 1));
        } catch (Exception e2) {
            Log.e("ExifHelper", "getRotationByPath ExifInterface ", e2);
            return 0;
        }
    }

    public static int c(Context context, Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            return a(new ExifInterface(inputStreamOpenInputStream).getAttributeInt("Orientation", 1));
        } catch (Exception e2) {
            Log.e("ExifHelper", "getRotationByUri ExifInterface ", e2);
            return 0;
        } finally {
            S2.d.c(inputStreamOpenInputStream);
        }
    }
}
