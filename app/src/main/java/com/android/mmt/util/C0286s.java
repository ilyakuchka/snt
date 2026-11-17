package com.android.mmt.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* renamed from: com.android.mmt.util.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0286s {
    public static void a(Context context, int... iArr) {
        SharedPreferences.Editor editorEdit = androidx.preference.g.c(context).edit();
        for (int i2 : iArr) {
            StringBuilder sbC = C2.c.c(" mark recommend dialog showed , type:", i2, " time:");
            sbC.append(System.currentTimeMillis());
            Log.i("GlobalSmsStorage", sbC.toString());
            editorEdit.putInt(b("key_dialog_negative_action", 1, i2), androidx.preference.g.c(context).getInt(b("key_dialog_negative_action", 1, i2), 0) + 1);
            editorEdit.putLong(b("key_enable_mark_time", 1, i2), System.currentTimeMillis());
            if (i2 == 514) {
                editorEdit.putBoolean("key_recommend_mx_banner_show", false);
            } else {
                editorEdit.putBoolean("key_recommend_smart_sms_banner_show", false);
                editorEdit.putLong(b("key_enable_mark_time", 2, i2), Long.MAX_VALUE);
            }
            editorEdit.apply();
        }
    }

    private static String b(String str, int i2, int i4) {
        return str + "_" + String.valueOf(i4) + "_" + String.valueOf(i2);
    }
}
