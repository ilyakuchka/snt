package F0;

import D2.e;
import android.content.Context;
import android.content.res.Configuration;
import com.android.mmt.MmsApp;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static Object f129b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static b f130c;

    /* renamed from: a, reason: collision with root package name */
    private a f131a;

    private b(Context context) {
        c(context.getResources().getConfiguration());
    }

    public static b a() {
        synchronized (f129b) {
            if (f130c == null) {
                f130c = new b(MmsApp.c().getApplicationContext());
            }
        }
        return f130c;
    }

    private void c(Configuration configuration) {
        a aVar;
        int i2 = configuration.orientation == 1 ? 11 : 10;
        if (i2 == 10) {
            aVar = new a(10);
        } else {
            if (i2 != 11) {
                throw new IllegalArgumentException(e.b("Unsupported display type: ", i2));
            }
            aVar = new a(11);
        }
        this.f131a = aVar;
    }

    public static void d(Configuration configuration) {
        if (f130c != null) {
            a().c(configuration);
        }
    }

    public final a b() {
        return this.f131a;
    }
}
