package androidx.fragment.app;

import android.os.Bundle;
import e.InterfaceC0297b;

/* renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0218n implements InterfaceC0297b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityC0219o f3560a;

    C0218n(ActivityC0219o activityC0219o) {
        this.f3560a = activityC0219o;
    }

    @Override // e.InterfaceC0297b
    public final void a() {
        this.f3560a.p.a();
        Bundle bundleA = this.f3560a.e().a("android:support:fragments");
        if (bundleA != null) {
            this.f3560a.p.w(bundleA.getParcelable("android:support:fragments"));
        }
    }
}
