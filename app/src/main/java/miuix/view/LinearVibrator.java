package miuix.view;

import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import miui.util.HapticFeedbackUtil;
import q.h;

@Keep
/* loaded from: classes.dex */
class LinearVibrator implements d {
    private static final String TAG = "LinearVibrator";
    private final h<Integer> mIds = new h<>();

    static {
        initialize();
    }

    private LinearVibrator() {
        buildIds();
    }

    private void buildIds() {
        this.mIds.a(c.f7455c, 268435456);
        this.mIds.a(c.d, 268435457);
        this.mIds.a(c.f7456e, 268435458);
        this.mIds.a(c.f7457f, 268435459);
        this.mIds.a(c.g, 268435460);
        this.mIds.a(c.f7458h, 268435461);
        this.mIds.a(c.f7459i, 268435462);
        this.mIds.a(c.f7460j, 268435463);
        this.mIds.a(c.f7461k, 268435464);
        this.mIds.a(c.f7462l, 268435465);
        int i2 = PlatformConstants.VERSION;
        if (i2 < 2) {
            return;
        }
        this.mIds.a(c.f7463m, 268435466);
        this.mIds.a(c.f7464n, 268435467);
        this.mIds.a(c.f7465o, 268435468);
        if (i2 < 3) {
            return;
        }
        this.mIds.a(c.p, 268435469);
        if (i2 < 4) {
            return;
        }
        this.mIds.a(c.f7466q, 268435470);
    }

    private static void initialize() {
        boolean zIsSupportLinearMotorVibrate;
        if (PlatformConstants.VERSION < 1) {
            Log.w(TAG, "MiuiHapticFeedbackConstants not found or not compatible for LinearVibrator.");
            return;
        }
        try {
            zIsSupportLinearMotorVibrate = HapticFeedbackUtil.isSupportLinearMotorVibrate();
        } catch (Throwable th) {
            Log.w(TAG, "MIUI Haptic Implementation is not available", th);
            zIsSupportLinearMotorVibrate = false;
        }
        if (!zIsSupportLinearMotorVibrate) {
            Log.w(TAG, "linear motor is not supported in this platform.");
        } else {
            HapticCompat.registerProvider(new LinearVibrator());
            Log.i(TAG, "setup LinearVibrator success.");
        }
    }

    int obtainFeedBack(int i2) {
        int iF = this.mIds.f(i2);
        if (iF >= 0) {
            return this.mIds.k(iF).intValue();
        }
        return -1;
    }

    @Override // miuix.view.d
    public boolean performHapticFeedback(View view, int i2) {
        int iF = this.mIds.f(i2);
        if (iF < 0) {
            Log.w(TAG, String.format("feedback(0x%08x-%s) is not found in current platform(v%d)", Integer.valueOf(i2), c.a(i2), Integer.valueOf(PlatformConstants.VERSION)));
            return false;
        }
        int iIntValue = this.mIds.k(iF).intValue();
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(iIntValue)) {
            return view.performHapticFeedback(iIntValue);
        }
        Log.w(TAG, String.format("unsupported feedback: 0x%08x. platform version: %d", Integer.valueOf(iIntValue), Integer.valueOf(PlatformConstants.VERSION)));
        return false;
    }

    public boolean supportLinearMotor(int i2) {
        int iF = this.mIds.f(i2);
        if (iF < 0) {
            Log.w(TAG, String.format("feedback(0x%08x-%s) is not found in current platform(v%d)", Integer.valueOf(i2), c.a(i2), Integer.valueOf(PlatformConstants.VERSION)));
            return false;
        }
        int iIntValue = this.mIds.k(iF).intValue();
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(iIntValue)) {
            return HapticFeedbackUtil.isSupportLinearMotorVibrate(iIntValue);
        }
        Log.w(TAG, String.format("unsupported feedback: 0x%08x. platform version: %d", Integer.valueOf(iIntValue), Integer.valueOf(PlatformConstants.VERSION)));
        return false;
    }
}
