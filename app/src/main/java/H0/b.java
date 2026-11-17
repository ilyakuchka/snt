package H0;

import android.net.Uri;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f261a = Uri.parse("content://com.android.providers.telephony.heduohaoprovider/heduohao");

    /* renamed from: b, reason: collision with root package name */
    private static b f262b;

    private b() {
    }

    public static synchronized b a() {
        if (f262b == null) {
            f262b = new b();
        }
        return f262b;
    }
}
