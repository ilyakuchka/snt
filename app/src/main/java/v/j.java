package v;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* loaded from: classes.dex */
final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f7957a = new Object();

    static Bundle a(C0398e c0398e) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatB = c0398e.b();
        bundle.putInt("icon", iconCompatB != null ? iconCompatB.b() : 0);
        bundle.putCharSequence("title", c0398e.f7931j);
        bundle.putParcelable("actionIntent", c0398e.f7932k);
        Bundle bundle2 = c0398e.f7924a != null ? new Bundle(c0398e.f7924a) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", c0398e.a());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", b(c0398e.c()));
        bundle.putBoolean("showsUserInterface", c0398e.f7928f);
        bundle.putInt("semanticAction", c0398e.d());
        return bundle;
    }

    private static Bundle[] b(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[lVarArr.length];
        for (int i2 = 0; i2 < lVarArr.length; i2++) {
            l lVar = lVarArr[i2];
            Bundle bundle = new Bundle();
            Objects.requireNonNull(lVar);
            bundle.putString("resultKey", null);
            bundle.putCharSequence("label", null);
            bundle.putCharSequenceArray("choices", null);
            bundle.putBoolean("allowFreeFormInput", false);
            bundle.putBundle("extras", null);
            bundleArr[i2] = bundle;
        }
        return bundleArr;
    }
}
