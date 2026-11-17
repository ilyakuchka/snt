package y;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f8140e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f8141a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8142b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8143c;
    public final int d;

    private b(int i2, int i4, int i5, int i6) {
        this.f8141a = i2;
        this.f8142b = i4;
        this.f8143c = i5;
        this.d = i6;
    }

    public static b a(int i2, int i4, int i5, int i6) {
        return (i2 == 0 && i4 == 0 && i5 == 0 && i6 == 0) ? f8140e : new b(i2, i4, i5, i6);
    }

    public final Insets b() {
        return Insets.of(this.f8141a, this.f8142b, this.f8143c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.d == bVar.d && this.f8141a == bVar.f8141a && this.f8143c == bVar.f8143c && this.f8142b == bVar.f8142b;
    }

    public final int hashCode() {
        return (((((this.f8141a * 31) + this.f8142b) * 31) + this.f8143c) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder sbD = D2.e.d("Insets{left=");
        sbD.append(this.f8141a);
        sbD.append(", top=");
        sbD.append(this.f8142b);
        sbD.append(", right=");
        sbD.append(this.f8143c);
        sbD.append(", bottom=");
        sbD.append(this.d);
        sbD.append('}');
        return sbD.toString();
    }
}
