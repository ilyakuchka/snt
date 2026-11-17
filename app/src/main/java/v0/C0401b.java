package v0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.preference.g;
import java.util.UUID;

/* renamed from: v0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0401b extends C0400a {
    public static long b() {
        return ((C0403d) C0400a.a()).b("key_global_mms_config_remote_ad_expired_time_0x10008", 3600000L);
    }

    public static long c() {
        return ((C0403d) C0400a.a()).b("key_global_mms_config_remote_ad_show_type_0x10009", 0L);
    }

    public static boolean d(Context context) {
        return g.c(context).getBoolean("key_global_mms_config_ad_switch_0x10002", true);
    }

    public static synchronized String e() {
        String strC = ((C0403d) C0400a.a()).c("key_global_mms_config_user_anonymous_id_0x10004", "");
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String string = UUID.randomUUID().toString();
        ((C0403d) C0400a.a()).f("key_global_mms_config_user_anonymous_id_0x10004", string);
        return string;
    }

    public static String f() {
        return ((C0403d) C0400a.a()).c("key_global_mms_config_device_gaid_0x10001", "00000000-0000-0000-0000-000000000000");
    }

    public static String g() {
        String strC = ((C0403d) C0400a.a()).c("key_global_mms_config_device_user_agent_0x10000", "");
        if (TextUtils.isEmpty(strC)) {
            strC = System.getProperty("http.agent");
            if (TextUtils.isEmpty(strC)) {
                StringBuilder sb = new StringBuilder();
                String str = Build.VERSION.RELEASE;
                if (str.length() <= 0) {
                    sb.append("1.0");
                } else if (Character.isDigit(str.charAt(0))) {
                    sb.append(str);
                } else {
                    sb.append("4.0.4");
                }
                sb.append(";");
                if ("REL".equals(Build.VERSION.CODENAME)) {
                    String str2 = Build.MODEL;
                    if (str2.length() > 0) {
                        sb.append(" ");
                        sb.append(str2);
                    }
                }
                String str3 = Build.ID;
                if (str3.length() > 0) {
                    sb.append(" Build/");
                    sb.append(str3);
                }
                strC = String.format("Dalvik/%s (Linux; U; Android %s)", System.getProperty("java.vm.version", ""), sb);
            }
            ((C0403d) C0400a.a()).f("key_global_mms_config_device_user_agent_0x10000", strC);
        }
        return strC;
    }

    public static synchronized long h() {
        long jB = ((C0403d) C0400a.a()).b("key_global_mms_config_privacy_agree_time_0x10005", -1L);
        if (jB != -1) {
            return jB;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ((C0403d) C0400a.a()).e("key_global_mms_config_privacy_agree_time_0x10005", jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    public static boolean i(Context context) {
        return g.c(context).getBoolean("key_global_mms_config_recommend_ad_switch_0x10003", true);
    }

    public static boolean j() {
        return ((C0403d) C0400a.a()).a("key_global_mms_config_remote_ad_switch_0x10007");
    }

    public static boolean k() {
        return ((C0403d) C0400a.a()).a("key_global_mms_config_privacy_report_state_0x10006");
    }

    public static void l(long j2) {
        ((C0403d) C0400a.a()).e("key_global_mms_config_remote_ad_expired_time_0x10008", j2);
    }

    public static void m(long j2) {
        ((C0403d) C0400a.a()).e("key_global_mms_config_remote_ad_show_type_0x10009", j2);
    }

    public static void n(String str) {
        ((C0403d) C0400a.a()).f("key_global_mms_config_device_gaid_0x10001", str);
    }

    public static void o() {
        ((C0403d) C0400a.a()).d("key_global_mms_config_privacy_report_state_0x10006", true);
    }

    public static void p(boolean z4) {
        ((C0403d) C0400a.a()).d("key_global_mms_config_remote_ad_switch_0x10007", z4);
    }
}
