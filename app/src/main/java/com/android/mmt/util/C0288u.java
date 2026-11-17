package com.android.mmt.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.android.mmt.MmsApp;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import t.C0384b;

/* renamed from: com.android.mmt.util.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0288u {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6042a;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f6043b;

    /* renamed from: c, reason: collision with root package name */
    private static final Set<String> f6044c;
    private static int d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f6045e;

    /* renamed from: f, reason: collision with root package name */
    private static int f6046f;
    private static boolean g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f6047h;

    static {
        HashSet hashSet = new HashSet(10);
        f6043b = hashSet;
        HashSet hashSet2 = new HashSet(10);
        f6044c = hashSet2;
        d = k0.d.j();
        f6045e = k0.d.n();
        f6046f = k0.d.r();
        g = true;
        f6047h = false;
        hashSet.add("23205");
        hashSet.add("23210");
        hashSet.add("23420");
        hashSet.add("22288");
        hashSet.add("22299");
        hashSet.add("27202");
        hashSet.add("27205");
        hashSet.add("24002");
        hashSet2.add("20201");
        hashSet2.add("21630");
        hashSet2.add("21901");
        hashSet2.add("23001");
        hashSet2.add("23102");
        hashSet2.add("23203");
        hashSet2.add("23207");
        hashSet2.add("26002");
        hashSet2.add("26201");
        hashSet2.add("22603");
        hashSet2.add("22606");
        hashSet2.add("20820");
        hashSet2.add("25001");
    }

    public static boolean a() {
        return f6047h;
    }

    public static int b() {
        return d;
    }

    public static boolean c() {
        return f6045e;
    }

    public static int d() {
        return f6046f;
    }

    public static boolean e() {
        return f6042a;
    }

    private static void f(Context context, String str) throws Throwable {
        Exception e2;
        Throwable th;
        InputStream inputStreamOpen;
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        InputStream inputStream = null;
        try {
            try {
                inputStreamOpen = context.getAssets().open("carrier_config/carrier_config_" + str + ".xml");
            } catch (Throwable th2) {
                th = th2;
                inputStreamOpen = inputStream;
            }
        } catch (Exception e4) {
            e2 = e4;
        }
        try {
            xmlPullParserNewPullParser.setInput(inputStreamOpen, "utf-8");
            k0.d.a(xmlPullParserNewPullParser);
            while (true) {
                int next = xmlPullParserNewPullParser.next();
                if (next == 2 || next == 1) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (name == null) {
                        break;
                    }
                    String attributeName = xmlPullParserNewPullParser.getAttributeName(0);
                    String attributeValue = xmlPullParserNewPullParser.getAttributeValue(0);
                    String text = xmlPullParserNewPullParser.next() == 4 ? xmlPullParserNewPullParser.getText() : null;
                    if ("name".equalsIgnoreCase(attributeName)) {
                        if ("bool".equals(name)) {
                            if ("enableMultipartSMS".equalsIgnoreCase(attributeValue)) {
                                f6045e = "true".equalsIgnoreCase(text);
                            } else if ("acceptPush".equalsIgnoreCase(attributeValue)) {
                                g = "true".equalsIgnoreCase(text);
                            } else if ("deleteOld".equalsIgnoreCase(attributeValue)) {
                                f6047h = "true".equalsIgnoreCase(text);
                            }
                        } else if ("int".equals(name)) {
                            if ("maxMessageSize".equalsIgnoreCase(attributeValue)) {
                                d = Integer.parseInt(text);
                            } else if ("smsToMmsTextThreshold".equalsIgnoreCase(attributeValue)) {
                                f6046f = Integer.parseInt(text);
                            }
                        }
                    }
                }
            }
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
        } catch (Exception e5) {
            e2 = e5;
            inputStream = inputStreamOpen;
            Log.e("MiuiMmsConfig", "loadMmsSettings caught ", e2);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            throw th;
        }
    }

    private static void g() {
        d = k0.d.j();
        f6045e = k0.d.n();
        f6046f = k0.d.r();
        g = true;
        f6047h = false;
    }

    public static void h() throws Throwable {
        int i2 = C0275g.f5975b;
        if (C0384b.j("ES")) {
            f6042a = true;
            g();
            if (C0384b.j("ES")) {
                f6045e = true;
                return;
            }
            return;
        }
        int iF = C0287t.f();
        if (iF == -1) {
            f6042a = false;
            return;
        }
        String strO = C0287t.o(iF);
        Log.v("MiuiMmsConfig", " getSimOperator is " + strO);
        Set<String> set = C0275g.b() ? f6043b : f6044c;
        if (TextUtils.isEmpty(strO) || !set.contains(strO)) {
            f6042a = false;
            return;
        }
        try {
            if (!set.contains(strO)) {
                Log.v("MiuiMmsConfig", "not customized operator: " + strO);
                return;
            }
            Log.v("MiuiMmsConfig", "customized operator: " + strO);
            f6042a = true;
            g();
            f(MmsApp.c(), strO);
            if (!TextUtils.equals(androidx.preference.g.c(MmsApp.c()).getString("last_operator", ""), strO)) {
                SharedPreferences sharedPreferencesC = androidx.preference.g.c(MmsApp.c());
                sharedPreferencesC.edit().putBoolean("pref_key_allow_si_sl_push", g).apply();
                sharedPreferencesC.edit().putBoolean("pref_key_auto_delete", f6047h).apply();
            }
            androidx.preference.g.c(MmsApp.c()).edit().putString("last_operator", strO).apply();
        } catch (Exception e2) {
            Log.e("MiuiMmsConfig", " exception when load config", e2);
        }
    }
}
