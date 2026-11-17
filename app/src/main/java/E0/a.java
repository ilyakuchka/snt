package E0;

import java.util.Hashtable;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f91c;

    /* renamed from: a, reason: collision with root package name */
    private Hashtable f92a;

    /* renamed from: b, reason: collision with root package name */
    private Hashtable f93b;

    private a() {
        Hashtable hashtable = new Hashtable();
        this.f92a = hashtable;
        hashtable.put("0", "STRING_TABLE");
        this.f92a.put("1", "UNKNOWN");
        this.f92a.put("2", "-//WAPFORUM//DTD WML 1.0//EN");
        this.f92a.put("3", "-//WAPFORUM//DTD WTA 1.0//EN");
        this.f92a.put("4", "-//WAPFORUM//DTD WML 1.1//EN");
        this.f92a.put("5", "-//WAPFORUM//DTD SI 1.0//EN");
        this.f92a.put("6", "-//WAPFORUM//DTD SL 1.0//EN");
        this.f92a.put("7", "-//WAPFORUM//DTD CO 1.0//EN");
        this.f92a.put("8", "-//WAPFORUM//DTD CHANNEL 1.1//EN");
        this.f92a.put("9", "-//WAPFORUM//DTD WML 1.2//EN");
        this.f92a.put("A", "-//WAPFORUM//DTD WML 1.3//EN");
        this.f92a.put("B", "-//WAPFORUM//DTD PROV 1.0//EN");
        this.f92a.put("C", "-//WAPFORUM//DTD WTA-WML 1.2//EN");
        this.f92a.put("D", "-//WAPFORUM//DTD CHANNEL 1.2//EN");
        this.f92a.put("E", "-//OMA//DTD DRMREL 1.0//EN");
        this.f92a.put("1100", "-//PHONE.COM//DTD ALERT 1.0//EN");
        this.f92a.put("FD1", "-//SYNCML//DTD SyncML 1.0//EN");
        this.f92a.put("FD2", "-//SYNCML//DTD DevInf 1.0//EN");
        this.f92a.put("FD3", "-//SYNCML//DTD SyncML 1.1//EN");
        this.f92a.put("FD4", "-//SYNCML//DTD DevInf 1.1//EN");
        Hashtable hashtable2 = new Hashtable();
        this.f93b = hashtable2;
        hashtable2.put("STRING_TABLE", "");
        this.f93b.put("UNKNOWN", "");
        this.f93b.put("-//WAPFORUM//DTD WML 1.0//EN", "");
        this.f93b.put("-//WAPFORUM//DTD WTA 1.0//EN", "");
        this.f93b.put("-//WAPFORUM//DTD WML 1.1//EN", "http://www.wapforum.org/DTD/wml_1_1.dtd");
        this.f93b.put("-//WAPFORUM//DTD SI 1.0//EN", "http://www.wapforum.org/DTD/si.dtd");
        this.f93b.put("-//WAPFORUM//DTD SL 1.0//EN", "http://www.wapforum.org/DTD/sl.dtd");
        this.f93b.put("-//WAPFORUM//DTD CO 1.0//EN", "");
        this.f93b.put("-//WAPFORUM//DTD CHANNEL 1.1//EN", "");
        this.f93b.put("-//WAPFORUM//DTD WML 1.2//EN", "http://www.wapforum.org/DTD/wml12.dtd");
        this.f93b.put("-//WAPFORUM//DTD WML 1.3//EN", "http://www.wapforum.org/DTD/wml13.dtd");
        this.f93b.put("-//WAPFORUM//DTD PROV 1.0//EN", "http://www.wapforum.org/DTD/prov.dtd");
        this.f93b.put("-//WAPFORUM//DTD WTA-WML 1.2//EN", "http://www.wapforum.org/DTD/wta-wml12.dtd");
        this.f93b.put("-//WAPFORUM//DTD CHANNEL 1.2//EN", "http://www.wapforum.org/DTD/channel12.dtd");
        this.f93b.put("-//OMA//DTD DRMREL 1.0//EN", "");
        this.f93b.put("-//PHONE.COM//DTD ALERT 1.0//EN", "");
    }

    public static a a() {
        if (f91c == null) {
            f91c = new a();
        }
        return f91c;
    }

    public final String b(int i2) {
        String str = (String) this.f92a.get(Integer.toHexString(i2).toUpperCase());
        return str == null ? (String) this.f92a.get("1") : str;
    }

    public final String c(String str) {
        for (Map.Entry entry : this.f92a.entrySet()) {
            if (entry.getValue().toString().equalsIgnoreCase(str)) {
                return entry.getKey().toString();
            }
        }
        return "1";
    }

    public final String d(String str) {
        return (String) this.f93b.get(str);
    }
}
