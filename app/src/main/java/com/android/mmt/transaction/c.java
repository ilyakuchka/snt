package com.android.mmt.transaction;

import android.util.LongSparseArray;
import java.util.Locale;
import org.apache.http.client.methods.HttpRequestBase;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4597a;

    /* renamed from: b, reason: collision with root package name */
    private static final LongSparseArray<HttpRequestBase> f4598b;

    static {
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        String language = locale.getLanguage();
        if (language == null) {
            language = null;
        } else if ("iw".equals(language)) {
            language = "he";
        } else if ("in".equals(language)) {
            language = "id";
        } else if ("ji".equals(language)) {
            language = "yi";
        }
        if (language != null) {
            sb.append(language);
            String country = locale.getCountry();
            if (country != null) {
                sb.append("-");
                sb.append(country);
            }
        }
        if (!Locale.US.equals(locale)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("en-US");
        }
        f4597a = sb.toString();
        f4598b = new LongSparseArray<>();
    }

    private c() {
    }

    protected static boolean a(long j2) {
        HttpRequestBase httpRequestBase;
        LongSparseArray<HttpRequestBase> longSparseArray = f4598b;
        synchronized (longSparseArray) {
            httpRequestBase = longSparseArray.get(j2);
        }
        if (httpRequestBase == null) {
            return false;
        }
        httpRequestBase.abort();
        return true;
    }
}
