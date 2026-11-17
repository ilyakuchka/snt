package miuix.view;

import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
class ExtendedVibrator implements d {
    private static final String TAG = "ExtendedVibrator";

    static {
        initialize();
    }

    private ExtendedVibrator() {
    }

    private static void initialize() {
        if (PlatformConstants.VERSION < 0) {
            Log.w(TAG, "MiuiHapticFeedbackConstants not found.");
        } else {
            HapticCompat.registerProvider(new ExtendedVibrator());
            Log.i(TAG, "setup ExtendedVibrator success.");
        }
    }

    @Override // miuix.view.d
    public boolean performHapticFeedback(View view, int i2) {
        if (i2 == c.f7454b) {
            return view.performHapticFeedback(2);
        }
        return false;
    }
}
