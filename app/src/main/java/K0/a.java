package K0;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f327a;

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("collapse_sp", this.f327a);
        bundle.putBoolean("show_block", false);
        return bundle;
    }

    public final a b(boolean z4) {
        this.f327a = z4;
        return this;
    }
}
