package O0;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f838a;

    public u(int i2, String str) {
        Bundle bundle = new Bundle();
        this.f838a = bundle;
        bundle.putInt("type", i2);
        bundle.putString("uri", str);
    }

    public final String a() {
        return this.f838a.getString("mmsc-url");
    }

    public final String b() {
        return this.f838a.getString("proxy-address");
    }

    public final int c() {
        return this.f838a.getInt("proxy-port");
    }

    public final byte[] d() {
        return this.f838a.getByteArray("mms-push-data");
    }

    public final int e() {
        return this.f838a.getInt("type");
    }

    public final String f() {
        return this.f838a.getString("uri");
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("transactionType: ");
        sbD.append(e());
        sbD.append(" uri: ");
        sbD.append(f());
        sbD.append(" pushData: ");
        sbD.append(this.f838a.getByteArray("mms-push-data"));
        sbD.append(" mmscUrl: ");
        sbD.append(this.f838a.getString("mmsc-url"));
        sbD.append(" proxyAddress: ");
        sbD.append(this.f838a.getString("proxy-address"));
        sbD.append(" proxyPort: ");
        sbD.append(this.f838a.getInt("proxy-port"));
        return sbD.toString();
    }

    public u(Bundle bundle) {
        this.f838a = bundle;
    }
}
