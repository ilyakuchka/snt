package g0;

import android.net.Uri;
import android.util.SparseArray;
import java.util.Objects;

/* renamed from: g0.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0318n {
    static final byte[] d = "from-data".getBytes();

    /* renamed from: e, reason: collision with root package name */
    static final byte[] f6279e = "attachment".getBytes();

    /* renamed from: f, reason: collision with root package name */
    static final byte[] f6280f = "inline".getBytes();

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<Object> f6281a;

    /* renamed from: b, reason: collision with root package name */
    private Uri f6282b = null;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f6283c = null;

    public C0318n() {
        this.f6281a = null;
        this.f6281a = new SparseArray<>();
    }

    public final String a() {
        byte[] bArr = (byte[]) this.f6281a.get(151);
        if (bArr == null && (bArr = (byte[]) this.f6281a.get(152)) == null) {
            bArr = (byte[]) this.f6281a.get(142);
        }
        if (bArr != null) {
            return new String(bArr);
        }
        byte[] bArr2 = (byte[]) this.f6281a.get(192);
        StringBuilder sbD = D2.e.d("cid:");
        sbD.append(new String(bArr2));
        return sbD.toString();
    }

    public final int b() {
        Integer num = (Integer) this.f6281a.get(129);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final byte[] c() {
        return (byte[]) this.f6281a.get(197);
    }

    public final byte[] d() {
        return (byte[]) this.f6281a.get(192);
    }

    public final byte[] e() {
        return (byte[]) this.f6281a.get(142);
    }

    public final byte[] f() {
        return (byte[]) this.f6281a.get(200);
    }

    public final byte[] g() {
        return (byte[]) this.f6281a.get(145);
    }

    public final byte[] h() {
        return this.f6283c;
    }

    public final Uri i() {
        return this.f6282b;
    }

    public final byte[] j() {
        return (byte[]) this.f6281a.get(152);
    }

    public final byte[] k() {
        return (byte[]) this.f6281a.get(151);
    }

    public final void l(int i2) {
        this.f6281a.put(129, Integer.valueOf(i2));
    }

    public final void m(byte[] bArr) {
        Objects.requireNonNull(bArr, "null content-disposition");
        this.f6281a.put(197, bArr);
    }

    public final void n(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Content-Id may not be null or empty.");
        }
        if (bArr.length > 1 && ((char) bArr[0]) == '<' && ((char) bArr[bArr.length - 1]) == '>') {
            this.f6281a.put(192, bArr);
            return;
        }
        int length = bArr.length + 2;
        byte[] bArr2 = new byte[length];
        bArr2[0] = 60;
        bArr2[length - 1] = 62;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        this.f6281a.put(192, bArr2);
    }

    public final void o(byte[] bArr) {
        Objects.requireNonNull(bArr, "null content-location");
        this.f6281a.put(142, bArr);
    }

    public final void p(byte[] bArr) {
        Objects.requireNonNull(bArr, "null content-transfer-encoding");
        this.f6281a.put(200, bArr);
    }

    public final void q(byte[] bArr) {
        Objects.requireNonNull(bArr, "null content-type");
        this.f6281a.put(145, bArr);
    }

    public final void r(byte[] bArr) {
        this.f6283c = bArr;
    }

    public final void s(Uri uri) {
        this.f6282b = uri;
    }

    public final void t(byte[] bArr) {
        Objects.requireNonNull(bArr, "null content-id");
        this.f6281a.put(152, bArr);
    }

    public final void u(byte[] bArr) {
        Objects.requireNonNull(bArr, "null content-id");
        this.f6281a.put(151, bArr);
    }
}
