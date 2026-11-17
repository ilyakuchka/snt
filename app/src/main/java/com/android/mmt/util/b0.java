package com.android.mmt.util;

import P0.C0157c;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.android.mmt.R;
import com.android.mmt.ui.C0243g0;
import java.lang.ref.WeakReference;
import x0.C0414a;
import x0.C0416c;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<C0243g0> f5940a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Uri f5941a;

        /* renamed from: b, reason: collision with root package name */
        public int f5942b;

        /* renamed from: c, reason: collision with root package name */
        public String f5943c;
        public String d;

        /* renamed from: e, reason: collision with root package name */
        public String f5944e;

        /* renamed from: f, reason: collision with root package name */
        public C0414a f5945f;
    }

    public static a a(String str) {
        a aVar = new a();
        aVar.f5941a = Uri.parse(str);
        int iIndexOf = str.indexOf(58);
        String strSubstring = iIndexOf != -1 ? str.substring(0, iIndexOf) : "";
        if (strSubstring.equalsIgnoreCase("tel")) {
            aVar.f5942b = 0;
            String strSubstring2 = str.substring(iIndexOf + 1);
            String number = PhoneNumberUtils.formatNumber(strSubstring2);
            aVar.f5943c = number;
            if (number == null) {
                aVar.f5943c = strSubstring2;
            }
            C0414a c0414aO = C0414a.O(strSubstring2);
            c0414aO.m0(false, true);
            aVar.f5945f = c0414aO;
            if (c0414aO.L()) {
                aVar.f5944e = strSubstring2 + " (" + aVar.f5945f.U() + ")";
            } else {
                aVar.f5944e = strSubstring2;
            }
        } else if (strSubstring.equalsIgnoreCase("mailto")) {
            aVar.f5942b = 1;
            String strSubstring3 = str.substring(iIndexOf + 1);
            aVar.f5943c = strSubstring3;
            aVar.f5944e = strSubstring3;
        } else if (strSubstring.equalsIgnoreCase("http") || strSubstring.equalsIgnoreCase("https") || strSubstring.equalsIgnoreCase("rtsp")) {
            aVar.f5942b = 2;
            aVar.f5943c = str;
            aVar.f5944e = str;
        } else if (strSubstring.equalsIgnoreCase("time")) {
            aVar.f5942b = 4;
            String strSubstring4 = str.substring(iIndexOf + 1);
            aVar.f5943c = strSubstring4;
            aVar.d = strSubstring4;
            aVar.f5944e = strSubstring4;
        } else {
            aVar.f5942b = 3;
            aVar.f5943c = str;
            aVar.f5944e = str;
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context, a aVar, C0243g0 c0243g0) {
        String str;
        boolean z4;
        C0414a c0414a;
        Activity activity;
        if (context instanceof Activity) {
            C0157c c0157c = new C0157c(context);
            WeakReference<C0243g0> weakReference = new WeakReference<>(c0243g0);
            f5940a = weakReference;
            if (aVar.f5942b == 2) {
                c(context, new Intent("android.intent.action.VIEW", aVar.f5941a));
                return;
            }
            C0243g0 c0243g02 = weakReference.get();
            if (c0243g02 == null || c0243g02.H() >= 0) {
                int i2 = aVar.f5942b;
                if (i2 == 0) {
                    c0157c.b(R.string.context_menu_call, new S(context, aVar));
                    c0157c.b(R.string.context_menu_send_sms, new T(context, aVar));
                    str = "phone";
                } else if (i2 == 1) {
                    c0157c.b(R.string.context_menu_send_mail, new U(context, aVar));
                    str = "email";
                } else {
                    if (i2 != 2) {
                        if (i2 != 4) {
                            str = "notes";
                        } else {
                            c0157c.b(R.string.context_menu_add_calendar, new W(aVar, c0243g0, context));
                            str = "";
                        }
                        z4 = false;
                        c0157c.b(R.string.context_menu_copy, new X(context, aVar));
                        c0414a = aVar.f5945f;
                        if (c0414a == null && c0414a.L()) {
                            c0157c.b(R.string.context_menu_view_contact, new Y(context, aVar));
                        } else if (z4) {
                            c0157c.b(R.string.context_menu_new_contact, new Z(str, aVar, context));
                            c0157c.b(R.string.context_menu_add_contact, new a0(str, aVar, context));
                            if (c0243g0 != null && ((c0243g0.Z() && c0243g0.i() == 1) || (c0243g0.U() && c0243g0.i() == 1))) {
                                C0414a c0414aO = C0414a.O(c0243g0.e());
                                if (c0414aO.L() && !C0414a.l0(c0414aO)) {
                                    c0157c.c(context.getString(R.string.add_number_to_sender, c0243g0.l()), new Q(c0414aO, str, aVar, context));
                                }
                            }
                        }
                        c0157c.e(aVar.f5944e);
                        activity = (Activity) context;
                        if (!activity.isFinishing() || activity.isDestroyed()) {
                        }
                        c0157c.f();
                        return;
                    }
                    c0157c.b(R.string.context_menu_browse_web, new V(context, aVar));
                    str = "website";
                }
                z4 = true;
                c0157c.b(R.string.context_menu_copy, new X(context, aVar));
                c0414a = aVar.f5945f;
                if (c0414a == null) {
                    if (z4) {
                    }
                }
                c0157c.e(aVar.f5944e);
                activity = (Activity) context;
                if (activity.isFinishing()) {
                }
            }
        }
    }

    public static void c(Context context, Intent intent) {
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        intent.setFlags(524288);
        C0243g0 c0243g0 = f5940a.get();
        if (c0243g0 != null) {
            long jH = c0243g0.H();
            if (jH < 0) {
                return;
            } else {
                C0416c.v(jH);
            }
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, context.getString(R.string.activity_not_found_uri), 0).show();
        }
    }
}
