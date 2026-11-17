package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
final class z extends androidx.lifecycle.u {

    /* renamed from: h, reason: collision with root package name */
    private static final v.a f3640h = new a();

    /* renamed from: e, reason: collision with root package name */
    private final boolean f3643e;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, Fragment> f3641b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, z> f3642c = new HashMap<>();
    private final HashMap<String, androidx.lifecycle.w> d = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f3644f = false;
    private boolean g = false;

    final class a implements v.a {
        a() {
        }

        @Override // androidx.lifecycle.v.a
        public final androidx.lifecycle.u a() {
            return new z(true);
        }
    }

    z(boolean z4) {
        this.f3643e = z4;
    }

    static z g(androidx.lifecycle.w wVar) {
        return (z) new androidx.lifecycle.v(wVar, f3640h).a(z.class);
    }

    @Override // androidx.lifecycle.u
    protected final void c() {
        if (w.k0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f3644f = true;
    }

    final void d(Fragment fragment) {
        if (w.k0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        z zVar = this.f3642c.get(fragment.f3435n);
        if (zVar != null) {
            zVar.c();
            this.f3642c.remove(fragment.f3435n);
        }
        androidx.lifecycle.w wVar = this.d.get(fragment.f3435n);
        if (wVar != null) {
            wVar.a();
            this.d.remove(fragment.f3435n);
        }
    }

    final Fragment e(String str) {
        return this.f3641b.get(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f3641b.equals(zVar.f3641b) && this.f3642c.equals(zVar.f3642c) && this.d.equals(zVar.d);
    }

    final z f(Fragment fragment) {
        z zVar = this.f3642c.get(fragment.f3435n);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this.f3643e);
        this.f3642c.put(fragment.f3435n, zVar2);
        return zVar2;
    }

    final Collection<Fragment> h() {
        return new ArrayList(this.f3641b.values());
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.f3642c.hashCode() + (this.f3641b.hashCode() * 31)) * 31);
    }

    final androidx.lifecycle.w i(Fragment fragment) {
        androidx.lifecycle.w wVar = this.d.get(fragment.f3435n);
        if (wVar != null) {
            return wVar;
        }
        androidx.lifecycle.w wVar2 = new androidx.lifecycle.w();
        this.d.put(fragment.f3435n, wVar2);
        return wVar2;
    }

    final boolean j() {
        return this.f3644f;
    }

    final void k(Fragment fragment) {
        if (this.g) {
            if (w.k0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f3641b.remove(fragment.f3435n) != null) && w.k0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    final void l(boolean z4) {
        this.g = z4;
    }

    final boolean m(Fragment fragment) {
        if (this.f3641b.containsKey(fragment.f3435n) && this.f3643e) {
            return this.f3644f;
        }
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f3641b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f3642c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
