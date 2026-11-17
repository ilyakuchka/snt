package s3;

import android.content.Context;
import android.provider.Settings;
import android.widget.TextView;

/* renamed from: s3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0381a {
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(TextView textView) {
        boolean z4;
        if (textView != null) {
            Context context = textView.getContext();
            if (context != null) {
                z4 = Settings.System.getInt(context.getContentResolver(), "elderly_mode", 0) == 1;
            }
            if (z4) {
                textView.setTextSize(0, 88.0f);
            }
        }
    }
}
