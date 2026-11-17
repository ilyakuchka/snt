package O0;

import android.app.Application;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.android.mmt.MmsApp;
import com.android.mmt.R;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, C0026a> f761a;

    /* renamed from: b, reason: collision with root package name */
    private static final MmsApp f762b;

    /* renamed from: O0.a$a, reason: collision with other inner class name */
    public static class C0026a {

        /* renamed from: a, reason: collision with root package name */
        public String f763a;

        /* renamed from: b, reason: collision with root package name */
        public String f764b;

        public C0026a(String str, String str2) {
            this.f763a = str;
            this.f764b = str2;
        }
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f761a = arrayMap;
        Application applicationC = MmsApp.c();
        f762b = (MmsApp) applicationC;
        arrayMap.put("Mms_Default", new C0026a(applicationC.getString(R.string.notification_channel_other_name), applicationC.getString(R.string.notification_channel_other_description)));
        arrayMap.put("Channel_Msg_Default", new C0026a(applicationC.getString(R.string.notification_channel_msg_name), applicationC.getString(R.string.notification_channel_msg_description)));
        arrayMap.put("Channel_Msg_Slot1", new C0026a(applicationC.getString(R.string.notification_channel_sim1_name), applicationC.getString(R.string.notification_channel_sim1_description)));
        arrayMap.put("Channel_Msg_Slot2", new C0026a(applicationC.getString(R.string.notification_channel_sim2_name), applicationC.getString(R.string.notification_channel_sim2_description)));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.util.ArrayMap, java.util.Map<java.lang.String, O0.a$a>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.util.ArrayMap, java.util.Map<java.lang.String, O0.a$a>] */
    public static C0026a a(String str) {
        ?? r02 = f761a;
        C0026a c0026a = (C0026a) r02.get("Mms_Default");
        for (String str2 : r02.keySet()) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return (C0026a) f761a.get(str2);
            }
        }
        return c0026a;
    }
}
