package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f4292a;

    /* renamed from: b, reason: collision with root package name */
    private final SavedStateRegistry f4293b = new SavedStateRegistry();

    private a(b bVar) {
        this.f4292a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public final SavedStateRegistry b() {
        return this.f4293b;
    }

    public final void c(Bundle bundle) {
        g gVarA = this.f4292a.a();
        if (gVarA.b() != g.c.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        gVarA.a(new Recreator(this.f4292a));
        this.f4293b.b(gVarA, bundle);
    }

    public final void d(Bundle bundle) {
        this.f4293b.c(bundle);
    }
}
