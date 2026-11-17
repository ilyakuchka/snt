package I0;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.android.mmt.R;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f265a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, String> f266b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, String> f267c = new HashMap<>();

    /* renamed from: I0.a$a, reason: collision with other inner class name */
    public static class C0011a {
    }

    static {
        f265a.put("http://url1", Integer.valueOf(R.string.user_term));
        f265a.put("http://url2", Integer.valueOf(R.string.privacy_term));
        f265a.put("http://url3", Integer.valueOf(R.string.yulore_term));
        f266b.put("http://url1", "file:///android_asset/protocol_file/eula.html");
        f266b.put("http://url2", "file:///android_asset/protocol_file/privacy.html");
        f266b.put("http://url3", "file:///android_asset/protocol_file/policy.html");
        f267c.put("http://url1", "http://www.miui.com/res/doc/eula.html?lang=#LAN");
        f267c.put("http://url2", "https://privacy.mi.com/all/");
        f267c.put("http://url3", "http://www.yulorepages.com/Home/Index/privacy_policy?lang=#LAN");
    }

    public static C0011a a(Context context, String str) throws Resources.NotFoundException {
        String string;
        C0011a c0011a = new C0011a();
        if (f265a.containsKey(str)) {
            if (M2.a.b(context)) {
                try {
                    string = context.getResources().getConfiguration().getLocales().get(0).toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    string = "";
                }
                String str2 = f267c.get(str);
                if (!TextUtils.isEmpty(str2) && !str.equals("http://url2") && (str.equals("http://url1") || str.equals("http://url3"))) {
                    str2.replace("#LAN", string);
                }
            } else {
                f266b.get(str);
            }
            Integer num = f265a.get(str);
            if (num != null && num.intValue() != -1) {
                context.getResources().getString(num.intValue());
            }
        }
        return c0011a;
    }
}
