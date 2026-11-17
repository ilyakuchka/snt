package o0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.android.mmt.MmsApp;
import java.util.Iterator;

/* renamed from: o0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0363f {

    /* renamed from: a, reason: collision with root package name */
    private static int f7518a = -1;

    static String a(String str, String str2) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean b(Context context) {
        if (f7518a == -1) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            f7518a = (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? 0 : 1;
        }
        return f7518a == 1;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 7 */
    public static boolean c(Context context, String str) {
        return false;
    }

    private static boolean d(Context context, String str) {
        String str2 = null;
        try {
            Iterator<ResolveInfo> it = MmsApp.c().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str3 = it.next().activityInfo.packageName;
                if (TextUtils.equals(str3, "com.xiaomi.discover") && C0362e.d(str3, false) >= 2000760) {
                    str2 = str3;
                    break;
                }
            }
            if (str2 != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(str2);
                intent.setData(Uri.parse(str));
                context.startActivity(intent);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
