package com.android.mmt.util;

import android.content.Context;
import android.os.UserManager;

/* loaded from: classes.dex */
public final class c0 {
    public static boolean a(Context context) {
        return ((UserManager) context.getSystemService("user")).hasUserRestriction("no_sms");
    }
}
