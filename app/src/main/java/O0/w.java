package O0;

import android.net.Uri;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: b, reason: collision with root package name */
    private int f844b = 0;

    /* renamed from: a, reason: collision with root package name */
    private Uri f843a = null;

    public final synchronized Uri a() {
        return this.f843a;
    }

    public final synchronized int b() {
        return this.f844b;
    }

    final synchronized void c(Uri uri) {
        this.f843a = uri;
    }

    final synchronized void d(int i2) {
        if (i2 < 0 && i2 > 2) {
            throw new IllegalArgumentException("Bad state: " + i2);
        }
        this.f844b = i2;
    }
}
