package U3;

import L3.w;
import Z2.q;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1725a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet<Logger> f1726b = new CopyOnWriteArraySet<>();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f1727c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r12 = w.class.getPackage();
        String name = r12 == null ? null : r12.getName();
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(w.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(S3.e.class.getName(), "okhttp.Http2");
        linkedHashMap.put(O3.d.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f1727c = q.b(linkedHashMap);
    }

    public static final void a(String str, int i2, String str2, Throwable th) {
        int iMin;
        String strC = f1727c.get(str);
        if (strC == null) {
            strC = i3.f.C(str, 23);
        }
        if (Log.isLoggable(strC, i2)) {
            if (th != null) {
                str2 = str2 + '\n' + ((Object) Log.getStackTraceString(th));
            }
            int length = str2.length();
            int i4 = 0;
            while (i4 < length) {
                int iR = i3.f.r(str2, '\n', i4, false, 4);
                if (iR == -1) {
                    iR = length;
                }
                while (true) {
                    iMin = Math.min(iR, i4 + 4000);
                    String strSubstring = str2.substring(i4, iMin);
                    f3.c.c(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i2, strC, strSubstring);
                    if (iMin >= iR) {
                        break;
                    } else {
                        i4 = iMin;
                    }
                }
                i4 = iMin + 1;
            }
        }
    }

    public static final void b() {
        for (Map.Entry<String, String> entry : f1727c.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Logger logger = Logger.getLogger(key);
            if (f1726b.add(logger)) {
                logger.setUseParentHandlers(false);
                logger.setLevel(Log.isLoggable(value, 3) ? Level.FINE : Log.isLoggable(value, 4) ? Level.INFO : Level.WARNING);
                logger.addHandler(d.f1728a);
            }
        }
    }
}
