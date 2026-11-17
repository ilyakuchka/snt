package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout;

/* loaded from: classes.dex */
final class l implements ContentFrameLayout.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f2403a;

    l(j jVar) {
        this.f2403a = jVar;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public final void onDetachedFromWindow() {
        this.f2403a.I();
    }
}
