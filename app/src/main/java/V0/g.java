package V0;

import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class g<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final b<Object> f1759e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final T f1760a;

    /* renamed from: b, reason: collision with root package name */
    private final b<T> f1761b;

    /* renamed from: c, reason: collision with root package name */
    private final String f1762c;
    private volatile byte[] d;

    final class a implements b<Object> {
        a() {
        }

        @Override // V0.g.b
        public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    public interface b<T> {
        void a(byte[] bArr, T t2, MessageDigest messageDigest);
    }

    private g(String str, T t2, b<T> bVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f1762c = str;
        this.f1760a = t2;
        this.f1761b = bVar;
    }

    public static <T> g<T> a(String str, T t2, b<T> bVar) {
        return new g<>(str, t2, bVar);
    }

    public static g c() {
        return new g("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, f1759e);
    }

    public static <T> g<T> d(String str, T t2) {
        return new g<>(str, t2, f1759e);
    }

    public final T b() {
        return this.f1760a;
    }

    public final void e(T t2, MessageDigest messageDigest) {
        b<T> bVar = this.f1761b;
        if (this.d == null) {
            this.d = this.f1762c.getBytes(f.f1758a);
        }
        bVar.a(this.d, t2, messageDigest);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f1762c.equals(((g) obj).f1762c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1762c.hashCode();
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("Option{key='");
        sbD.append(this.f1762c);
        sbD.append('\'');
        sbD.append('}');
        return sbD.toString();
    }
}
