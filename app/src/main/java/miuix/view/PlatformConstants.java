package miuix.view;

import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.InvocationTargetException;
import miui.util.HapticFeedbackUtil;

@Keep
/* loaded from: classes.dex */
public class PlatformConstants {
    public static final int VERSION;
    public static double romHapticVersion = 1.0d;

    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    static {
        int iCheckVersion;
        try {
            Class<?> cls = Class.forName("miui.util.HapticFeedbackUtil");
            Class<?> cls2 = Class.forName("miui.view.MiuiHapticFeedbackConstants");
            if (cls.getMethod("isSupportLinearMotorVibrate", Integer.TYPE) != null) {
                iCheckVersion = cls2.getDeclaredField("FLAG_MIUI_HAPTIC_VERSION") != null ? 4 : 0;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError | NoSuchMethodException e2) {
            Log.w("HapticCompat", "MIUI Haptic Implementation not found.", e2);
            iCheckVersion = -1;
        } catch (NoSuchFieldException e4) {
            Log.w("HapticCompat", "error when getting FLAG_MIUI_HAPTIC_VERSION.", e4);
            iCheckVersion = checkVersion();
        }
        VERSION = iCheckVersion;
        Log.i("HapticCompat", String.format("Platform version: %d.", Integer.valueOf(iCheckVersion)));
        try {
            Class<?> cls3 = Class.forName("miui.util.HapticFeedbackUtil");
            romHapticVersion = ((Double) cls3.getDeclaredMethod("getCurVersion", new Class[0]).invoke(cls3, new Object[0])).doubleValue();
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.w("HapticCompat", "MIUI Haptic Implementation not found.", e5);
        } catch (IllegalAccessException unused) {
            Log.w("HapticCompat", "have no access to the definition of getCurVersion()");
        } catch (InvocationTargetException unused2) {
            Log.w("HapticCompat", "method getCurVersion() called using Reflection failed");
        }
        StringBuilder sbD = D2.e.d("Rom haptic version: ");
        sbD.append(romHapticVersion);
        Log.i("HapticCompat", sbD.toString());
    }

    static int checkVersion() {
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(268435470)) {
            return 4;
        }
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(268435469)) {
            return 3;
        }
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(268435468)) {
            return 2;
        }
        return HapticFeedbackUtil.isSupportLinearMotorVibrate(268435465) ? 1 : 0;
    }
}
