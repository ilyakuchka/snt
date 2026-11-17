package k0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import com.android.mmt.R;
import com.android.mmt.util.C0275g;
import com.android.mmt.util.C0288u;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t.C0384b;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6418a = false;

    /* renamed from: b, reason: collision with root package name */
    private static int f6419b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static int f6420c = 307200;
    private static String d = "x-wap-profile";

    /* renamed from: e, reason: collision with root package name */
    private static String f6421e = null;

    /* renamed from: f, reason: collision with root package name */
    private static String f6422f = null;
    private static String g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f6423h = null;

    /* renamed from: i, reason: collision with root package name */
    private static int f6424i = 1920;

    /* renamed from: j, reason: collision with root package name */
    private static int f6425j = 1920;

    /* renamed from: k, reason: collision with root package name */
    private static int f6426k = Integer.MAX_VALUE;

    /* renamed from: l, reason: collision with root package name */
    private static int f6427l = 500;

    /* renamed from: m, reason: collision with root package name */
    private static int f6428m = 50;

    /* renamed from: n, reason: collision with root package name */
    private static int f6429n = 60000;

    /* renamed from: o, reason: collision with root package name */
    private static int f6430o = 7;
    private static boolean p = false;

    /* renamed from: q, reason: collision with root package name */
    private static int f6431q = 9;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f6432r = false;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f6433s = true;

    /* renamed from: t, reason: collision with root package name */
    private static int f6434t = 4;
    private static boolean u = false;

    /* renamed from: v, reason: collision with root package name */
    private static int f6435v = 2;

    /* renamed from: w, reason: collision with root package name */
    private static int f6436w = 48;

    public static final void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (xmlPullParser.getName().equals("mms_config")) {
            return;
        }
        StringBuilder sbD = D2.e.d("Unexpected start tag: found ");
        sbD.append(xmlPullParser.getName());
        sbD.append(", expected ");
        sbD.append("mms_config");
        throw new XmlPullParserException(sbD.toString());
    }

    public static int b() {
        return f6436w;
    }

    public static int c() {
        return f6435v;
    }

    public static int d() {
        return f6428m;
    }

    public static int e() {
        return f6427l;
    }

    public static String f() {
        return f6423h;
    }

    public static int g() {
        return f6429n;
    }

    public static int h() {
        return f6424i;
    }

    public static int i() {
        return f6425j;
    }

    public static int j() {
        if (C0288u.e()) {
            return C0288u.b();
        }
        StringBuilder sbD = D2.e.d("MmsConfig.getMaxMessageSize(): ");
        sbD.append(f6420c);
        Log.v("MmsConfig", sbD.toString());
        return f6420c;
    }

    public static int k() {
        return f6434t;
    }

    public static int l() {
        return f6430o;
    }

    public static boolean m() {
        return f6419b == 1;
    }

    public static boolean n() {
        return C0288u.e() ? C0288u.c() : f6432r;
    }

    public static boolean o() {
        return p;
    }

    public static int p() {
        return f6426k;
    }

    public static boolean q() {
        return f6433s;
    }

    public static int r() {
        return C0288u.e() ? C0288u.d() : f6431q;
    }

    public static boolean s() {
        return f6418a;
    }

    public static String t() {
        return d;
    }

    public static String u() {
        String str = f6421e;
        if (str == null || str.contains("ua-profile-kila")) {
            f6421e = "http://apkupdate.miui.com/other/UAprofile.xml";
        }
        Log.v("MmsConfig", f6421e);
        return f6421e;
    }

    public static void v(Context context) throws Resources.NotFoundException {
        Log.v("MmsConfig", "MmsConfig.init()");
        x(context);
    }

    public static boolean w() {
        return u;
    }

    private static void x(Context context) throws Resources.NotFoundException {
        XmlResourceParser xml = context.getResources().getXml(R.xml.mms_config);
        try {
            try {
                try {
                    try {
                        a(xml);
                        while (true) {
                            y(xml);
                            String name = xml.getName();
                            if (name == null) {
                                break;
                            }
                            String attributeName = xml.getAttributeName(0);
                            String attributeValue = xml.getAttributeValue(0);
                            String text = xml.next() == 4 ? xml.getText() : null;
                            if ("name".equalsIgnoreCase(attributeName)) {
                                if ("bool".equals(name)) {
                                    if ("enabledMMS".equalsIgnoreCase(attributeValue)) {
                                        f6419b = "true".equalsIgnoreCase(text) ? 1 : 0;
                                    } else if ("enabledTransID".equalsIgnoreCase(attributeValue)) {
                                        f6418a = "true".equalsIgnoreCase(text);
                                    } else if ("enabledNotifyWapMMSC".equalsIgnoreCase(attributeValue)) {
                                        p = "true".equalsIgnoreCase(text);
                                    } else if ("aliasEnabled".equalsIgnoreCase(attributeValue)) {
                                        u = "true".equalsIgnoreCase(text);
                                    } else if ("allowAttachAudio".equalsIgnoreCase(attributeValue)) {
                                        "true".equalsIgnoreCase(text);
                                    } else if ("enableMultipartSMS".equalsIgnoreCase(attributeValue)) {
                                        f6432r = "true".equalsIgnoreCase(text);
                                    } else if ("enableSlideDuration".equalsIgnoreCase(attributeValue)) {
                                        f6433s = "true".equalsIgnoreCase(text);
                                    } else if ("enableMMSReadReports".equalsIgnoreCase(attributeValue)) {
                                        "true".equalsIgnoreCase(text);
                                    } else if ("enableSMSDeliveryReports".equalsIgnoreCase(attributeValue)) {
                                        "true".equalsIgnoreCase(text);
                                    } else if ("enableMMSDeliveryReports".equalsIgnoreCase(attributeValue)) {
                                        "true".equalsIgnoreCase(text);
                                    }
                                } else if ("int".equals(name)) {
                                    if ("maxMessageSize".equalsIgnoreCase(attributeValue)) {
                                        if (C0275g.d() || C0275g.e()) {
                                            f6420c = 1048576;
                                        } else if (C0384b.j("FR")) {
                                            f6420c = 614400;
                                        } else if (C0384b.j("BE")) {
                                            f6420c = 606208;
                                        } else if (C0384b.j("PT")) {
                                            f6420c = 305152;
                                        } else if (C0384b.j("TW")) {
                                            f6420c = 614400;
                                        } else if (C0384b.j("RU")) {
                                            f6420c = 512000;
                                        } else {
                                            f6420c = Integer.parseInt(text);
                                        }
                                    } else if ("maxImageHeight".equalsIgnoreCase(attributeValue)) {
                                        f6424i = Integer.parseInt(text);
                                    } else if ("maxImageWidth".equalsIgnoreCase(attributeValue)) {
                                        f6425j = Integer.parseInt(text);
                                    } else if ("defaultSMSMessagesPerThread".equalsIgnoreCase(attributeValue)) {
                                        f6427l = Integer.parseInt(text);
                                    } else if ("defaultMMSMessagesPerThread".equalsIgnoreCase(attributeValue)) {
                                        f6428m = Integer.parseInt(text);
                                    } else if ("minMessageCountPerThread".equalsIgnoreCase(attributeValue)) {
                                        Integer.parseInt(text);
                                    } else if ("maxMessageCountPerThread".equalsIgnoreCase(attributeValue)) {
                                        Integer.parseInt(text);
                                    } else if ("recipientLimit".equalsIgnoreCase(attributeValue)) {
                                        int i2 = Integer.parseInt(text);
                                        f6426k = i2;
                                        if (i2 < 0) {
                                            f6426k = Integer.MAX_VALUE;
                                        }
                                    } else if ("httpSocketTimeout".equalsIgnoreCase(attributeValue)) {
                                        f6429n = Integer.parseInt(text);
                                    } else if ("minimumSlideElementDuration".equalsIgnoreCase(attributeValue)) {
                                        f6430o = Integer.parseInt(text);
                                    } else if ("maxSizeScaleForPendingMmsAllowed".equalsIgnoreCase(attributeValue)) {
                                        f6434t = Integer.parseInt(text);
                                    } else if ("aliasMinChars".equalsIgnoreCase(attributeValue)) {
                                        f6435v = Integer.parseInt(text);
                                    } else if ("aliasMaxChars".equalsIgnoreCase(attributeValue)) {
                                        f6436w = Integer.parseInt(text);
                                    } else if ("smsToMmsTextThreshold".equalsIgnoreCase(attributeValue)) {
                                        f6431q = Integer.parseInt(text);
                                        if (C0384b.j("PL")) {
                                            f6431q = 7;
                                        }
                                    } else if ("maxMessageTextSize".equalsIgnoreCase(attributeValue)) {
                                        Integer.parseInt(text);
                                    } else if ("maxSubjectLength".equalsIgnoreCase(attributeValue)) {
                                        Integer.parseInt(text);
                                    }
                                } else if ("string".equals(name) && !"userAgent".equalsIgnoreCase(attributeValue)) {
                                    if ("uaProfTagName".equalsIgnoreCase(attributeValue)) {
                                        d = text;
                                    } else if ("uaProfUrl".equalsIgnoreCase(attributeValue)) {
                                        f6421e = text;
                                    } else if ("httpParams".equalsIgnoreCase(attributeValue)) {
                                        f6422f = text;
                                    } else if ("httpParamsLine1Key".equalsIgnoreCase(attributeValue)) {
                                        g = text;
                                    } else if ("emailGatewayNumber".equalsIgnoreCase(attributeValue)) {
                                        f6423h = text;
                                    }
                                }
                            }
                        }
                    } catch (XmlPullParserException e2) {
                        Log.e("MmsConfig", "loadMmsSettings caught ", e2);
                    }
                } catch (IOException e4) {
                    Log.e("MmsConfig", "loadMmsSettings caught ", e4);
                }
            } catch (NumberFormatException e5) {
                Log.e("MmsConfig", "loadMmsSettings caught ", e5);
            }
            xml.close();
            String str = (m() && f6421e == null) ? "uaProfUrl" : null;
            if (str != null) {
                Log.e("MmsConfig", String.format("MmsConfig.loadMmsSettings mms_config.xml missing %s setting", str));
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public static final void y(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                return;
            }
        } while (next != 1);
    }
}
