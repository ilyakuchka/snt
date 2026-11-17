package f;

import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: f.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0301b extends AbstractC0300a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6168a;

    @Override // f.AbstractC0300a
    public final Object a(int i2, Intent intent) {
        switch (this.f6168a) {
            case 0:
                if (i2 != -1) {
                    return Collections.emptyMap();
                }
                if (intent == null) {
                    return Collections.emptyMap();
                }
                String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                if (intArrayExtra == null || stringArrayExtra == null) {
                    return Collections.emptyMap();
                }
                HashMap map = new HashMap();
                int length = stringArrayExtra.length;
                for (int i4 = 0; i4 < length; i4++) {
                    map.put(stringArrayExtra[i4], Boolean.valueOf(intArrayExtra[i4] == 0));
                }
                return map;
            default:
                return new androidx.activity.result.a(i2, intent);
        }
    }
}
