package x;

import android.graphics.Typeface;

/* renamed from: x.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0413b implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Typeface f8005i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ d f8006j;

    RunnableC0413b(d dVar, Typeface typeface) {
        this.f8006j = dVar;
        this.f8005i = typeface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8006j.d(this.f8005i);
    }
}
