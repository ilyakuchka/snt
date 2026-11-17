package G0;

import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private String f139a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<a> f140b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private int f141c = 0;
    private Map<String, String> d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Object> f142e;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<Pair<String, String>> f143a;

        /* renamed from: b, reason: collision with root package name */
        int f144b;

        /* renamed from: c, reason: collision with root package name */
        int f145c;

        public a(String str, String str2, int i2, int i4) {
            ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
            this.f143a = arrayList;
            arrayList.add(new Pair<>(str, str2));
            this.f144b = i2;
            this.f145c = i4;
        }

        public final boolean a(String str, String str2, int i2, int i4, String str3) {
            if ("vnd.android.cursor.item/name".equalsIgnoreCase(str)) {
                return false;
            }
            if (this.f145c != i2 && TextUtils.getTrimmedLength(str3) != 0) {
                return false;
            }
            this.f143a.add(new Pair<>(str, str2));
            this.f145c = i4;
            return true;
        }

        public final ArrayList<Pair<String, String>> b() {
            return this.f143a;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<Pair<String, String>> it = this.f143a.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                sb.append("[");
                sb.append((String) c.this.d.get(next.first));
                sb.append("] ");
                sb.append((String) next.second);
                sb.append(";\n");
            }
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    }

    public c(String str, Map<String, String> map) {
        this.f139a = str;
        this.d = map;
    }

    public final void b(String str, String str2, int i2, int i4) {
        if (i2 >= this.f141c && i2 < i4) {
            a aVar = null;
            if (!this.f140b.isEmpty()) {
                aVar = this.f140b.get(r0.size() - 1);
            }
            a aVar2 = aVar;
            String strSubstring = this.f139a.substring(this.f141c, i2);
            if (aVar2 == null || !aVar2.a(str, str2, i2, i4, strSubstring)) {
                this.f140b.add(new a(str, str2, i2, i4));
            }
        }
        this.f141c = i4;
    }

    public final ArrayList<Object> c() {
        if (this.f142e == null) {
            this.f142e = new ArrayList<>();
            int i2 = 0;
            Iterator<a> it = this.f140b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                int i4 = next.f144b;
                int i5 = next.f145c;
                if (i4 > i2) {
                    String strTrim = this.f139a.substring(i2, i4).trim();
                    if (!TextUtils.isEmpty(strTrim)) {
                        this.f142e.add(strTrim);
                    }
                }
                this.f142e.add(next);
                i2 = i5;
            }
            if (i2 < this.f139a.length()) {
                String str = this.f139a;
                String strTrim2 = str.substring(i2, str.length()).trim();
                if (!TextUtils.isEmpty(strTrim2)) {
                    this.f142e.add(strTrim2);
                }
            }
        }
        return this.f142e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.f139a);
        for (int size = this.f140b.size() - 1; size >= 0; size--) {
            a aVar = this.f140b.get(size);
            sb.replace(aVar.f144b, aVar.f145c, aVar.toString());
        }
        return sb.toString();
    }
}
