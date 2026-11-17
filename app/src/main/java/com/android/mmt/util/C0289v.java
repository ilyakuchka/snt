package com.android.mmt.util;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* renamed from: com.android.mmt.util.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0289v {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6048a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f6049b = true;

    public static boolean a() {
        return f6048a;
    }

    public static void b() {
        if (f6049b) {
            f6049b = false;
            f6048a = false;
        }
    }

    public static void c(Context context, int i2) {
        try {
            Uri uri = Uri.parse("content://antispam");
            Bundle bundle = new Bundle();
            bundle.putInt("simId", i2);
            bundle.putInt("blockType", 1);
            context.getContentResolver().call(uri, "setMmsBlockType", (String) null, bundle);
        } catch (Exception e2) {
            Log.e("MmsBlockUtils", "set smart filtering failed", e2);
        }
    }
}
