package P0;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.android.mmt.util.e0;

/* renamed from: P0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ActivityC0156b extends miuix.appcompat.app.h {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // miuix.appcompat.app.h, androidx.fragment.app.ActivityC0219o, androidx.activity.ComponentActivity, v.ActivityC0395b, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        miuix.appcompat.app.b bVarK = K();
        if (bVarK != null) {
            bVarK.u(0);
            bVarK.w(false);
            Window window = getWindow();
            boolean zH = e0.h();
            if (!zH) {
                window.addFlags(Integer.MIN_VALUE);
            }
            boolean z4 = !zH;
            Window window2 = getWindow();
            if (window2 == null) {
                return;
            }
            View decorView = window2.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z4 ? 8192 | systemUiVisibility : (-8193) & systemUiVisibility);
        }
    }
}
