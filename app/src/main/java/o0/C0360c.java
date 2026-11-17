package o0;

import android.content.ContentResolver;
import android.text.TextUtils;
import android.util.Log;
import com.android.mmt.MmsApp;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* renamed from: o0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0360c {

    /* renamed from: a, reason: collision with root package name */
    public static int f7514a = -1;

    public static String a() throws ClassNotFoundException {
        String strC = C0362e.c();
        if (TextUtils.isEmpty(strC)) {
            strC = C0363f.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(strC)) {
            strC = C0363f.a("persist.sys.country", "");
        }
        return TextUtils.isEmpty(strC) ? Locale.getDefault().getCountry() : strC;
    }

    public static boolean b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f7514a == -1) {
            try {
                Object objInvoke = Class.forName("android.provider.MiuiSettings$Ad").getDeclaredMethod("isPersonalizedAdEnabled", ContentResolver.class).invoke(null, MmsApp.c().getContentResolver());
                if (objInvoke instanceof Boolean) {
                    f7514a = ((Boolean) objInvoke).booleanValue() ? 1 : 0;
                }
            } catch (Exception e2) {
                StringBuilder sbD = D2.e.d("isPersonalizedAdEnabled exception: ");
                sbD.append(e2.getMessage());
                Log.d("AdUtils", sbD.toString());
            }
        }
        return f7514a == 1;
    }
}
