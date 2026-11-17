package androidx.appcompat.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
final class f implements SavedStateRegistry.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f2323a;

    f(h hVar) {
        this.f2323a = hVar;
    }

    @Override // androidx.savedstate.SavedStateRegistry.b
    public final Bundle a() {
        Bundle bundle = new Bundle();
        this.f2323a.z().q();
        return bundle;
    }
}
