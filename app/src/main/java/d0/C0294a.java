package d0;

import android.content.Context;
import android.content.Intent;

/* renamed from: d0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0294a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6138a;

    public static void a(Context context) {
        if (f6138a) {
            Intent intent = new Intent("com.android.common.speech.LOG_EVENT");
            intent.putExtra("app_name", "voiceime");
            intent.putExtra("extra_event", 21);
            intent.putExtra("", context.getPackageName());
            intent.putExtra("timestamp", System.currentTimeMillis());
            context.sendBroadcast(intent);
            f6138a = false;
        }
    }
}
