package l1;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class n extends Fragment {

    /* renamed from: c0, reason: collision with root package name */
    private final l1.a f6540c0;

    /* renamed from: d0, reason: collision with root package name */
    private final l f6541d0;

    /* renamed from: e0, reason: collision with root package name */
    private final Set<n> f6542e0;

    /* renamed from: f0, reason: collision with root package name */
    private n f6543f0;

    /* renamed from: g0, reason: collision with root package name */
    private com.bumptech.glide.i f6544g0;

    /* renamed from: h0, reason: collision with root package name */
    private Fragment f6545h0;

    private class a implements l {
        a() {
        }

        public final String toString() {
            return super.toString() + "{fragment=" + n.this + "}";
        }
    }

    public n() {
        l1.a aVar = new l1.a();
        this.f6541d0 = new a();
        this.f6542e0 = new HashSet();
        this.f6540c0 = aVar;
    }

    private Fragment d1() {
        Fragment fragmentH = H();
        return fragmentH != null ? fragmentH : this.f6545h0;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.HashSet, java.util.Set<l1.n>] */
    private void g1(Context context, w wVar) {
        j1();
        n nVarE = com.bumptech.glide.c.c(context).j().e(context, wVar);
        this.f6543f0 = nVarE;
        if (equals(nVarE)) {
            return;
        }
        this.f6543f0.f6542e0.add(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashSet, java.util.Set<l1.n>] */
    private void j1() {
        n nVar = this.f6543f0;
        if (nVar != null) {
            nVar.f6542e0.remove(this);
            this.f6543f0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void c0(Context context) {
        super.c0(context);
        Fragment fragmentH = this;
        while (fragmentH.H() != null) {
            fragmentH = fragmentH.H();
        }
        w wVarE = fragmentH.E();
        if (wVarE == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                g1(B(), wVarE);
            } catch (IllegalStateException e2) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
                }
            }
        }
    }

    final l1.a c1() {
        return this.f6540c0;
    }

    public final com.bumptech.glide.i e1() {
        return this.f6544g0;
    }

    public final l f1() {
        return this.f6541d0;
    }

    @Override // androidx.fragment.app.Fragment
    public final void h0() {
        super.h0();
        this.f6540c0.c();
        j1();
    }

    final void h1() {
        this.f6545h0 = null;
    }

    public final void i1(com.bumptech.glide.i iVar) {
        this.f6544g0 = iVar;
    }

    @Override // androidx.fragment.app.Fragment
    public final void j0() {
        super.j0();
        this.f6545h0 = null;
        j1();
    }

    @Override // androidx.fragment.app.Fragment
    public final void r0() {
        super.r0();
        this.f6540c0.d();
    }

    @Override // androidx.fragment.app.Fragment
    public final void s0() {
        super.s0();
        this.f6540c0.e();
    }

    @Override // androidx.fragment.app.Fragment
    public final String toString() {
        return super.toString() + "{parent=" + d1() + "}";
    }
}
