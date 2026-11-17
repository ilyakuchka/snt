package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.g;
import androidx.savedstate.SavedStateRegistry;

/* renamed from: androidx.fragment.app.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0217m implements SavedStateRegistry.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityC0219o f3559a;

    C0217m(ActivityC0219o activityC0219o) {
        this.f3559a = activityC0219o;
    }

    @Override // androidx.savedstate.SavedStateRegistry.b
    public final Bundle a() {
        Bundle bundle = new Bundle();
        this.f3559a.v();
        this.f3559a.f3561q.f(g.b.ON_STOP);
        Parcelable parcelableX = this.f3559a.p.x();
        if (parcelableX != null) {
            bundle.putParcelable("android:support:fragments", parcelableX);
        }
        return bundle;
    }
}
