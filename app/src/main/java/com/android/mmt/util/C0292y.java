package com.android.mmt.util;

import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.regex.Pattern;
import t.C0384b;

/* renamed from: com.android.mmt.util.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0292y {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f6053a = {'-', '.', ',', '(', ')', ' ', '/', '\\', '*', '#', '+'};

    /* renamed from: b, reason: collision with root package name */
    private static Pattern f6054b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Pattern f6055c = null;
    private static final ArrayMap d = new ArrayMap(11);

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f6056e = 0;

    static {
        int i2 = 0;
        while (true) {
            char[] cArr = f6053a;
            if (i2 >= 11) {
                return;
            }
            d.put(Character.valueOf(cArr[i2]), Character.valueOf(cArr[i2]));
            i2++;
        }
    }

    public static boolean a(String str) {
        if (!k0.d.w()) {
            return false;
        }
        int length = str == null ? 0 : str.length();
        if (length < k0.d.c() || length > k0.d.b() || !Character.isLetter(str.charAt(0))) {
            return false;
        }
        for (int i2 = 1; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '.') {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= 3 && str.indexOf(64) >= 1;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str) || !C0384b.j("IN")) {
            return false;
        }
        if (f6055c == null) {
            f6055c = Pattern.compile("^[a-zA-Z]{2}-[a-zA-Z0-9]+$");
        }
        if (f6055c.matcher(str).matches()) {
            return true;
        }
        int length = str.length();
        boolean z4 = false;
        int i2 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (!z4 && Character.isLetter(cCharAt)) {
                z4 = true;
            }
            if (!Character.isDigit(cCharAt) && !Character.isLetter(cCharAt)) {
                break;
            }
            i2++;
        }
        return i2 == length && z4;
    }

    public static boolean d(String str) {
        if (f6054b == null) {
            f6054b = Pattern.compile("^[A-Za-z][A-Za-z][-]\\S{6}$");
        }
        return f6054b.matcher(str).matches();
    }

    public static String e(String str) {
        String string;
        if (S2.d.h(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                string = sb.toString();
                break;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt == '+' && sb.length() == 0) {
                sb.append(cCharAt);
            } else if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            } else if (d.get(Character.valueOf(cCharAt)) == null) {
                string = null;
                break;
            }
            i2++;
        }
        if (string != null) {
            return string;
        }
        if (a(str)) {
            return str;
        }
        return null;
    }
}
