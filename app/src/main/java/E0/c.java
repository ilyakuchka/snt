package E0;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    private static Hashtable f98c = new Hashtable();

    /* renamed from: a, reason: collision with root package name */
    private Hashtable f99a = new Hashtable();

    /* renamed from: b, reason: collision with root package name */
    private Hashtable f100b = new Hashtable();

    private c() {
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [E0.c, java.lang.Object] */
    public static c b(Context context) throws RuntimeException {
        ?? cVar;
        InputStream inputStreamOpen;
        StringTokenizer stringTokenizer;
        Object obj = f98c.get("jwap_port/charsets");
        Object obj2 = obj;
        if (obj == null) {
            synchronized (f98c) {
                cVar = f98c.get("jwap_port/charsets");
                if (cVar == 0) {
                    cVar = new c();
                    try {
                        inputStreamOpen = context.getAssets().open("jwap_port/charsets");
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        inputStreamOpen = null;
                    }
                    if (inputStreamOpen == null) {
                        f98c.put("jwap_port/charsets", new byte[0]);
                        throw new RuntimeException("jwap_port/charsets: Unable to load translation table");
                    }
                    try {
                        Properties properties = new Properties();
                        try {
                            properties.load(inputStreamOpen);
                            f98c.put("jwap_port/charsets", cVar);
                            boolean zBooleanValue = Boolean.valueOf(properties.getProperty("transtable.aliases")).booleanValue();
                            String property = properties.getProperty("transtable.delimiter", ",");
                            Enumeration enumerationKeys = properties.keys();
                            while (enumerationKeys.hasMoreElements()) {
                                String str = (String) enumerationKeys.nextElement();
                                if (!"transtable.aliases".equals(str) && !"transtable.delimiter".equals(str)) {
                                    String strTrim = properties.getProperty(str).trim();
                                    if (zBooleanValue) {
                                        stringTokenizer = new StringTokenizer(strTrim, property);
                                        strTrim = stringTokenizer.nextToken().trim();
                                    } else {
                                        stringTokenizer = null;
                                    }
                                    try {
                                        Integer numDecode = Integer.decode(str);
                                        ((c) cVar).f99a.put(numDecode, strTrim);
                                        ((c) cVar).f100b.put(strTrim.toLowerCase(), numDecode);
                                        if (zBooleanValue) {
                                            while (stringTokenizer.hasMoreTokens()) {
                                                ((c) cVar).f100b.put(stringTokenizer.nextToken().trim().toLowerCase(), numDecode);
                                            }
                                        }
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                            }
                        } finally {
                            inputStreamOpen.close();
                        }
                    } catch (IOException unused2) {
                        f98c.put("jwap_port/charsets", new byte[0]);
                        throw new RuntimeException("jwap_port/charsets: Unable to load translation table");
                    }
                }
            }
            obj2 = cVar;
        }
        if (obj2 instanceof c) {
            return (c) obj2;
        }
        throw new RuntimeException("jwap_port/charsets: Unable to load translation table.");
    }

    public final String a(int i2) {
        return (String) this.f99a.get(Integer.valueOf(i2));
    }
}
