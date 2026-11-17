package O2;

import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;

/* loaded from: classes.dex */
public final class a {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean b() {
        int ringerMode = ((AudioManager) C0.a.c().getSystemService("audio")).getRingerMode();
        if (ringerMode != 1) {
            if (ringerMode != 2) {
                return false;
            }
            Settings.System.getInt(C0.a.c().getContentResolver(), "vibrate_when_ringing", 0);
        }
        return true;
    }
}
