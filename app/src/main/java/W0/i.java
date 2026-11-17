package W0;

import W0.d;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public final class i implements d<InputStream> {

    /* renamed from: o, reason: collision with root package name */
    static final a f1803o = new a();

    /* renamed from: i, reason: collision with root package name */
    private final c1.f f1804i;

    /* renamed from: j, reason: collision with root package name */
    private final int f1805j;

    /* renamed from: k, reason: collision with root package name */
    private final b f1806k;

    /* renamed from: l, reason: collision with root package name */
    private HttpURLConnection f1807l;

    /* renamed from: m, reason: collision with root package name */
    private InputStream f1808m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f1809n;

    private static class a implements b {
        a() {
        }
    }

    interface b {
    }

    public i(c1.f fVar, int i2) {
        a aVar = f1803o;
        this.f1804i = fVar;
        this.f1805j = i2;
        this.f1806k = aVar;
    }

    private InputStream e(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 >= 5) {
            throw new V0.e("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new V0.e("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f1807l = (HttpURLConnection) url.openConnection();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f1807l.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f1807l.setConnectTimeout(this.f1805j);
        this.f1807l.setReadTimeout(this.f1805j);
        this.f1807l.setUseCaches(false);
        this.f1807l.setDoInput(true);
        this.f1807l.setInstanceFollowRedirects(false);
        this.f1807l.connect();
        this.f1808m = this.f1807l.getInputStream();
        if (this.f1809n) {
            return null;
        }
        int responseCode = this.f1807l.getResponseCode();
        int i4 = responseCode / 100;
        if (i4 == 2) {
            HttpURLConnection httpURLConnection = this.f1807l;
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f1808m = s1.c.H(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    StringBuilder sbD = D2.e.d("Got non empty content encoding: ");
                    sbD.append(httpURLConnection.getContentEncoding());
                    Log.d("HttpUrlFetcher", sbD.toString());
                }
                this.f1808m = httpURLConnection.getInputStream();
            }
            return this.f1808m;
        }
        if (!(i4 == 3)) {
            if (responseCode == -1) {
                throw new V0.e(responseCode);
            }
            throw new V0.e(this.f1807l.getResponseMessage(), responseCode);
        }
        String headerField = this.f1807l.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            throw new V0.e("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        b();
        return e(url3, i2 + 1, url, map);
    }

    @Override // W0.d
    public final Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // W0.d
    public final void b() throws IOException {
        InputStream inputStream = this.f1808m;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f1807l;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f1807l = null;
    }

    @Override // W0.d
    public final void c(com.bumptech.glide.f fVar, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        int i2 = s1.f.f7857b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                aVar.f(e(this.f1804i.e(), 0, null, this.f1804i.d()));
            } catch (IOException e2) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
                }
                aVar.e(e2);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(s1.f.a(jElapsedRealtimeNanos));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                StringBuilder sbD = D2.e.d("Finished http url fetcher fetch in ");
                sbD.append(s1.f.a(jElapsedRealtimeNanos));
                Log.v("HttpUrlFetcher", sbD.toString());
            }
            throw th;
        }
    }

    @Override // W0.d
    public final void cancel() {
        this.f1809n = true;
    }

    @Override // W0.d
    public final V0.a d() {
        return V0.a.f1748j;
    }
}
