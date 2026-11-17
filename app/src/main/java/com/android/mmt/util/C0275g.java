package com.android.mmt.util;

import t.C0384b;

/* renamed from: com.android.mmt.util.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0275g {

    /* renamed from: a, reason: collision with root package name */
    private static String f5974a = S2.c.a("ro.miui.customized.region", "");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5975b = 0;

    public static boolean a() {
        return C0384b.j("GR") || C0384b.j("PL") || C0384b.j("ES") || d() || "cl_moviestar".equals(f5974a) || "cl_wom".equals(f5974a);
    }

    public static boolean b() {
        return "hk_h3g".equals(f5974a);
    }

    public static boolean c() {
        return "it_tim".equals(f5974a);
    }

    public static boolean d() {
        return "mx_att".equals(f5974a);
    }

    public static boolean e() {
        return "mx_telcel".equals(f5974a);
    }

    public static boolean f() {
        return "fr_sfr".equals(f5974a);
    }
}
