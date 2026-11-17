package l;

import android.content.Context;
import android.content.res.Configuration;
import com.android.mmt.R;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f6454a;

    private a(Context context) {
        this.f6454a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public final boolean a() {
        return this.f6454a.getApplicationInfo().targetSdkVersion < 14;
    }

    public final int c() {
        return this.f6454a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public final int d() {
        Configuration configuration = this.f6454a.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600) {
            return 5;
        }
        if (i2 > 960 && i4 > 720) {
            return 5;
        }
        if (i2 > 720 && i4 > 960) {
            return 5;
        }
        if (i2 >= 500) {
            return 4;
        }
        if (i2 > 640 && i4 > 480) {
            return 4;
        }
        if (i2 <= 480 || i4 <= 640) {
            return i2 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public final boolean e() {
        return this.f6454a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }
}
