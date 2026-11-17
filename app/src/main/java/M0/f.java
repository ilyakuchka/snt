package M0;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f582a;

    public static synchronized void a(Context context) {
        if (f582a == null) {
            f582a = context.getApplicationContext().getSharedPreferences("sync_telephony", 0);
        }
    }

    public static boolean b() {
        if (f582a == null) {
            a(K0.b.a().b());
        }
        return f582a.getLong("last_sync_time_millis", -1L) == -1;
    }

    public static void c(long j2) {
        if (f582a == null) {
            a(K0.b.a().b());
        }
        f582a.edit().putLong("last_sync_time_millis", j2).apply();
    }
}
