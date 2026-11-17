package R0;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.Toast;
import com.android.mmt.MmsApp;
import com.android.mmt.R;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f1314b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap<String, Integer> f1315a;

    private a() {
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
        this.f1315a = arrayMap;
        arrayMap.put("*mb*", 1);
    }

    public static a b() {
        return f1314b;
    }

    public final boolean a(String str) {
        int iIntValue;
        if ((!TextUtils.isEmpty(str) && str.startsWith("*") && str.endsWith("*")) && this.f1315a.containsKey(str)) {
            Log.d("CmdManager", "exec " + str);
            iIntValue = this.f1315a.get(str).intValue();
        } else {
            iIntValue = 0;
        }
        if (iIntValue != 1) {
            return false;
        }
        SharedPreferences sharedPreferences = MmsApp.c().getSharedPreferences("cmd", 0);
        sharedPreferences.edit().putBoolean("debug", !sharedPreferences.getBoolean("debug", false)).apply();
        int i2 = R.string.debug_close_success;
        if (sharedPreferences.getBoolean("debug", false)) {
            i2 = R.string.debug_enable_success;
        }
        Toast.makeText(MmsApp.c().getApplicationContext(), i2, 0).show();
        return true;
    }
}
