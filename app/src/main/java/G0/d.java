package G0;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    private static d f146e;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f148a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f149b = new ArrayMap();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<String> f150c;
    private static final String[] d = {"Name", "Nickname", "Phone", "Email", "Organization", "IM", "SIP Phone", "Birthday", "Website", "Address", "Note", "Relation"};

    /* renamed from: f, reason: collision with root package name */
    private static Pattern f147f = Pattern.compile("\\[(.+?)\\]((.|\n)*?);");

    /* JADX WARN: Type inference failed for: r4v0, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    private d(Context context) throws Resources.NotFoundException {
        String[] stringArray = context.getResources().getStringArray(R.array.contact_entries);
        String[] stringArray2 = context.getResources().getStringArray(R.array.contact_values);
        this.f150c = new ArrayList<>(Arrays.asList(stringArray2));
        int iMin = Math.min(stringArray.length, stringArray2.length);
        boolean z4 = !"en".equals(context.getResources().getConfiguration().locale.getLanguage());
        for (int i2 = 0; i2 < iMin; i2++) {
            this.f148a.put(d[i2], stringArray2[i2]);
            if (z4) {
                this.f148a.put(stringArray[i2], stringArray2[i2]);
            }
            this.f149b.put(stringArray2[i2], stringArray[i2]);
        }
    }

    public static d b(Context context) {
        if (f146e == null) {
            f146e = new d(context);
        }
        return f146e;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    public final String a(Intent intent) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f150c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(next);
            if (stringArrayListExtra != null) {
                Iterator<String> it2 = stringArrayListExtra.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    if (!TextUtils.isEmpty(next2)) {
                        sb.append('[' + ((String) this.f149b.get(next)) + ']' + next2.replace(';', ',') + ";\n");
                    }
                }
            }
        }
        return sb.toString();
    }

    public final String c(Context context, String str) throws Resources.NotFoundException {
        String[] stringArray = context.getResources().getStringArray(R.array.contact_entries);
        int iIndexOf = this.f150c.indexOf(str);
        return (iIndexOf <= 0 || iIndexOf >= stringArray.length) ? "" : stringArray[iIndexOf];
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.util.ArrayMap, java.util.Map<java.lang.String, java.lang.String>] */
    public final c d(String str) {
        c cVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = f147f.matcher(str);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            String strTrim = matcher.group(1).trim();
            String strTrim2 = matcher.group(2).trim();
            if (this.f148a.containsKey(strTrim)) {
                strTrim = (String) this.f148a.get(strTrim);
            } else if (!this.f149b.containsKey(strTrim)) {
            }
            if (cVar == null) {
                cVar = new c(str, this.f149b);
            }
            cVar.b(strTrim, strTrim2, iStart, iEnd);
        }
        return cVar;
    }
}
