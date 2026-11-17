package com.android.mmt.util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.android.mmt.ui.MessagingPreferenceActivity;
import t.C0384b;

/* loaded from: classes.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public static volatile long f5843a = -1;

    public static String a(Context context) {
        return androidx.preference.g.c(context).getString("bookmark_snippet", "");
    }

    public static boolean b(Context context) {
        return androidx.preference.g.c(context).getBoolean("pref_key_allow_network_access", false);
    }

    public static boolean c(Context context) {
        return androidx.preference.g.c(context).getBoolean("bookmark_visible", false);
    }

    public static boolean d(Context context) {
        if (C0384b.j("IN")) {
            return androidx.preference.g.c(context).getBoolean("pref_key_collapse_sp_messages_v9", false);
        }
        return false;
    }

    public static void e(Context context) {
        try {
            Intent intent = new Intent(context, (Class<?>) MessagingPreferenceActivity.class);
            if (!(context instanceof miuix.appcompat.app.h)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e2) {
            Log.e("Mms", "launchMessagePreference caught ", e2);
        }
    }

    public static void f(Context context, String str, long j2) {
        androidx.preference.g.c(context).edit().putLong(str, j2).apply();
    }
}
