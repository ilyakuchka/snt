package o0;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.android.mmt.MmsApp;
import java.util.List;
import java.util.Locale;

/* renamed from: o0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0362e {

    /* renamed from: a, reason: collision with root package name */
    private static String f7516a;

    /* renamed from: b, reason: collision with root package name */
    private static String f7517b;

    public static String a() {
        if (TextUtils.isEmpty(f7517b)) {
            try {
                f7517b = MmsApp.c().getPackageManager().getPackageInfo(MmsApp.c().getPackageName(), 0).versionName;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return f7517b;
    }

    public static String b() {
        String language = Locale.getDefault().getLanguage();
        return TextUtils.isEmpty(language) ? "" : language;
    }

    public static String c() {
        if (TextUtils.isEmpty(f7516a)) {
            f7516a = C0363f.a("ro.miui.region", null);
        }
        if (TextUtils.isEmpty(f7516a)) {
            f7516a = "n/a";
        }
        return f7516a;
    }

    public static long d(String str, boolean z4) throws PackageManager.NameNotFoundException {
        Intent intent = new Intent("android.intent.action.MAIN");
        if (z4) {
            intent.addCategory("android.intent.category.LAUNCHER");
        }
        intent.setPackage(str);
        PackageManager packageManager = MmsApp.c().getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
            return -1L;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            if (applicationInfo != null && !applicationInfo.enabled) {
                return -2L;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.getLongVersionCode();
            }
            return -1L;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }
}
