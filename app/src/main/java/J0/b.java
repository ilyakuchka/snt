package J0;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class b extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i2) {
        super("adv_close");
        if (i2 == 1) {
            super("app_ads");
        } else if (i2 != 2) {
        } else {
            super("no_show_reason");
        }
    }

    public static void e(int i2) {
        b bVar = new b(2);
        bVar.d("reason", i2);
        bVar.b();
    }

    public final b f() {
        if (!TextUtils.isEmpty("1.419.4.1")) {
            this.f279b.putString("show_id", "1.419.4.1");
        }
        return this;
    }
}
