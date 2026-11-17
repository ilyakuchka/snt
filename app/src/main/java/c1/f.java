package c1;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class f implements V0.f {

    /* renamed from: b, reason: collision with root package name */
    private final g f4399b;

    /* renamed from: c, reason: collision with root package name */
    private final URL f4400c;
    private final String d;

    /* renamed from: e, reason: collision with root package name */
    private String f4401e;

    /* renamed from: f, reason: collision with root package name */
    private URL f4402f;
    private volatile byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private int f4403h;

    public f(URL url) {
        i iVar = g.f4404a;
        Objects.requireNonNull(url, "Argument must not be null");
        this.f4400c = url;
        this.d = null;
        Objects.requireNonNull(iVar, "Argument must not be null");
        this.f4399b = iVar;
    }

    @Override // V0.f
    public final void a(MessageDigest messageDigest) {
        if (this.g == null) {
            this.g = c().getBytes(V0.f.f1758a);
        }
        messageDigest.update(this.g);
    }

    public final String c() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        URL url = this.f4400c;
        Objects.requireNonNull(url, "Argument must not be null");
        return url.toString();
    }

    public final Map<String, String> d() {
        return this.f4399b.a();
    }

    public final URL e() throws MalformedURLException {
        if (this.f4402f == null) {
            if (TextUtils.isEmpty(this.f4401e)) {
                String string = this.d;
                if (TextUtils.isEmpty(string)) {
                    URL url = this.f4400c;
                    Objects.requireNonNull(url, "Argument must not be null");
                    string = url.toString();
                }
                this.f4401e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f4402f = new URL(this.f4401e);
        }
        return this.f4402f;
    }

    @Override // V0.f
    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return c().equals(fVar.c()) && this.f4399b.equals(fVar.f4399b);
    }

    @Override // V0.f
    public final int hashCode() {
        if (this.f4403h == 0) {
            int iHashCode = c().hashCode();
            this.f4403h = iHashCode;
            this.f4403h = this.f4399b.hashCode() + (iHashCode * 31);
        }
        return this.f4403h;
    }

    public final String toString() {
        return c();
    }

    public f(String str) {
        i iVar = g.f4404a;
        this.f4400c = null;
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            Objects.requireNonNull(iVar, "Argument must not be null");
            this.f4399b = iVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
