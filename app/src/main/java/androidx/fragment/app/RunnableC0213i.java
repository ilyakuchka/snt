package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* renamed from: androidx.fragment.app.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0213i implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ I f3536i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ View f3537j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ Rect f3538k;

    RunnableC0213i(I i2, View view, Rect rect) {
        this.f3536i = i2;
        this.f3537j = view;
        this.f3538k = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3536i.f(this.f3537j, this.f3538k);
    }
}
