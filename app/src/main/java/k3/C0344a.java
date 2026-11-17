package k3;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.mmt.MmsApp;
import java.util.Arrays;
import java.util.List;

/* renamed from: k3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0344a {

    /* renamed from: a, reason: collision with root package name */
    private static String f6448a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f6449b = "";

    /* renamed from: c, reason: collision with root package name */
    private static List<String> f6450c = Arrays.asList("00");
    public static final /* synthetic */ int d = 0;

    public static String a() {
        c();
        return f6450c.get(0);
    }

    public static List<String> b() {
        c();
        return f6450c;
    }

    private static void c() {
        String networkOperator = ((TelephonyManager) MmsApp.c().getSystemService("phone")).getNetworkOperator();
        if (TextUtils.isEmpty(networkOperator) || networkOperator.length() < 3 || networkOperator.equals(f6448a)) {
            return;
        }
        f6448a = networkOperator;
        String strSubstring = networkOperator.substring(0, 3);
        f6449b = b.a(strSubstring);
        List<String> listB = b.b(strSubstring);
        f6450c = listB;
        if (listB == null || f6449b.isEmpty()) {
            f6450c = Arrays.asList("00");
        }
    }
}
