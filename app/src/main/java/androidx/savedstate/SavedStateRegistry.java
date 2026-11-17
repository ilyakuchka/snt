package androidx.savedstate;

import D2.e;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import androidx.savedstate.Recreator;
import java.util.Map;
import o.C0358b;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b, reason: collision with root package name */
    private Bundle f4288b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4289c;
    private Recreator.a d;

    /* renamed from: a, reason: collision with root package name */
    private C0358b<String, b> f4287a = new C0358b<>();

    /* renamed from: e, reason: collision with root package name */
    boolean f4290e = true;

    public interface a {
        void a(androidx.savedstate.b bVar);
    }

    public interface b {
        Bundle a();
    }

    SavedStateRegistry() {
    }

    public final Bundle a(String str) {
        if (!this.f4289c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f4288b;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f4288b.remove(str);
        if (this.f4288b.isEmpty()) {
            this.f4288b = null;
        }
        return bundle2;
    }

    final void b(g gVar, Bundle bundle) {
        if (this.f4289c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f4288b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        gVar.a(new i() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.i
            public final void g(k kVar, g.b bVar) {
                if (bVar == g.b.ON_START) {
                    SavedStateRegistry.this.f4290e = true;
                } else if (bVar == g.b.ON_STOP) {
                    SavedStateRegistry.this.f4290e = false;
                }
            }
        });
        this.f4289c = true;
    }

    final void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f4288b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C0358b<String, b>.d dVarI = this.f4287a.i();
        while (dVarI.hasNext()) {
            Map.Entry next = dVarI.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void d(String str, b bVar) {
        if (this.f4287a.n(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    public final void e(Class<? extends a> cls) throws NoSuchMethodException, SecurityException {
        if (!this.f4290e) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.d == null) {
            this.d = new Recreator.a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            Recreator.a aVar = this.d;
            aVar.f4286a.add(cls.getName());
        } catch (NoSuchMethodException e2) {
            StringBuilder sbD = e.d("Class");
            sbD.append(cls.getSimpleName());
            sbD.append(" must have default constructor in order to be automatically recreated");
            throw new IllegalArgumentException(sbD.toString(), e2);
        }
    }
}
