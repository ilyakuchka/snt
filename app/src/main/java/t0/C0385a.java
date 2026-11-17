package t0;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: t0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0385a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7893a = 0;

    /* renamed from: t0.a$a, reason: collision with other inner class name */
    public static class C0138a {

        /* renamed from: a, reason: collision with root package name */
        public static final Map<Integer, Integer> f7894a;

        static {
            HashMap map = new HashMap();
            f7894a = map;
            map.put(0, 1);
            map.put(1, 2);
            map.put(2, 4);
            map.put(3, 3);
            map.put(4, 5);
            map.put(5, 0);
        }
    }

    /* renamed from: t0.a$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f7895a = Uri.parse("content://mms-sms/message/preview");

        /* renamed from: b, reason: collision with root package name */
        public static final Uri f7896b = Uri.parse("content://mms-sms/locked/all");

        /* renamed from: c, reason: collision with root package name */
        public static final Uri f7897c = Uri.parse("content://mms-sms/complete-conversations");
        public static final Uri d = Uri.parse("content://mms-sms/expired");

        /* renamed from: e, reason: collision with root package name */
        public static final Uri f7898e;

        static {
            Uri.parse("content://mms-sms/recent-recipients");
            Uri.parse("content://mms-sms/understand-info");
            Uri.parse("content://mms-sms/understand-info/all");
            f7898e = Uri.parse("content://mms-sms/blocked");
            Uri.parse("content://mms-sms/blocked-thread");
        }
    }

    /* renamed from: t0.a$c */
    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f7899a = Uri.parse("content://mms-sms/private-addresses");
    }

    static {
        Pattern.compile("银行|信用卡|Bank|BANK|支付宝|中国银联");
        Pattern.compile("((\\[[\\s\\S]*(银行|信用卡|Bank|BANK|支付宝|中国银联)\\])|(\\【[\\s\\S]*(银行|信用卡|Bank|BANK|支付宝|中国银联)\\】))$");
    }
}
