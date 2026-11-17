package c1;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class i implements g {

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<h>> f4405b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Map<String, String> f4406c;

    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        private static final Map<String, List<h>> f4407b;

        /* renamed from: a, reason: collision with root package name */
        private Map<String, List<h>> f4408a = f4407b;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i2 = 0; i2 < length; i2++) {
                    char cCharAt = property.charAt(i2);
                    if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                        sb.append(cCharAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                map.put("User-Agent", Collections.singletonList(new b(property)));
            }
            f4407b = Collections.unmodifiableMap(map);
        }

        public final i a() {
            return new i(this.f4408a);
        }
    }

    static final class b implements h {

        /* renamed from: a, reason: collision with root package name */
        private final String f4409a;

        b(String str) {
            this.f4409a = str;
        }

        @Override // c1.h
        public final String a() {
            return this.f4409a;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f4409a.equals(((b) obj).f4409a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f4409a.hashCode();
        }

        public final String toString() {
            StringBuilder sbD = D2.e.d("StringHeaderFactory{value='");
            sbD.append(this.f4409a);
            sbD.append('\'');
            sbD.append('}');
            return sbD.toString();
        }
    }

    i(Map<String, List<h>> map) {
        this.f4405b = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<h>> entry : this.f4405b.entrySet()) {
            List<h> value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = value.size();
            for (int i2 = 0; i2 < size; i2++) {
                String strA = value.get(i2).a();
                if (!TextUtils.isEmpty(strA)) {
                    sb.append(strA);
                    if (i2 != value.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                map.put(entry.getKey(), string);
            }
        }
        return map;
    }

    @Override // c1.g
    public final Map<String, String> a() {
        if (this.f4406c == null) {
            synchronized (this) {
                if (this.f4406c == null) {
                    this.f4406c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f4406c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f4405b.equals(((i) obj).f4405b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4405b.hashCode();
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("LazyHeaders{headers=");
        sbD.append(this.f4405b);
        sbD.append('}');
        return sbD.toString();
    }
}
