package V2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import x0.C0414a;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public long f1766a;

    /* renamed from: b, reason: collision with root package name */
    public C0414a f1767b;

    /* renamed from: c, reason: collision with root package name */
    public int f1768c = 1;
    public long d;

    public b(long j2, C0414a c0414a, long j4) {
        this.f1766a = j2;
        this.f1767b = c0414a;
        this.d = j4;
    }

    public abstract Intent a(Context context);

    public abstract void b();

    public abstract Uri c();
}
