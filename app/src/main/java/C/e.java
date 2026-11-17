package C;

import android.util.Base64;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f24a;

    /* renamed from: b, reason: collision with root package name */
    private final String f25b;

    /* renamed from: c, reason: collision with root package name */
    private final String f26c;
    private final List<List<byte[]>> d;

    /* renamed from: e, reason: collision with root package name */
    private final String f27e;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f24a = str;
        this.f25b = str2;
        this.f26c = str3;
        Objects.requireNonNull(list);
        this.d = list;
        this.f27e = str + "-" + str2 + "-" + str3;
    }

    public final List<List<byte[]>> a() {
        return this.d;
    }

    final String b() {
        return this.f27e;
    }

    public final String c() {
        return this.f24a;
    }

    public final String d() {
        return this.f25b;
    }

    public final String e() {
        return this.f26c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbD = D2.e.d("FontRequest {mProviderAuthority: ");
        sbD.append(this.f24a);
        sbD.append(", mProviderPackage: ");
        sbD.append(this.f25b);
        sbD.append(", mQuery: ");
        sbD.append(this.f26c);
        sbD.append(", mCertificates:");
        sb.append(sbD.toString());
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i2);
            for (int i4 = 0; i4 < list.size(); i4++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i4), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        return C2.c.b(sb, "}", "mCertificatesArray: 0");
    }
}
