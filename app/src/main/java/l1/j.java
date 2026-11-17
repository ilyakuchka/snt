package l1;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public final class j extends Fragment {

    /* renamed from: i, reason: collision with root package name */
    private final l1.a f6525i;

    /* renamed from: j, reason: collision with root package name */
    private final l f6526j;

    /* renamed from: k, reason: collision with root package name */
    private final Set<j> f6527k;

    /* renamed from: l, reason: collision with root package name */
    private com.bumptech.glide.i f6528l;

    /* renamed from: m, reason: collision with root package name */
    private j f6529m;

    /* renamed from: n, reason: collision with root package name */
    private Fragment f6530n;

    private class a implements l {
        a() {
        }

        public final String toString() {
            return super.toString() + "{fragment=" + j.this + "}";
        }
    }

    public j() {
        l1.a aVar = new l1.a();
        this.f6526j = new a();
        this.f6527k = new HashSet();
        this.f6525i = aVar;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.HashSet, java.util.Set<l1.j>] */
    private void d(Activity activity) {
        g();
        j jVarC = com.bumptech.glide.c.c(activity).j().c(activity);
        this.f6529m = jVarC;
        if (equals(jVarC)) {
            return;
        }
        this.f6529m.f6527k.add(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashSet, java.util.Set<l1.j>] */
    private void g() {
        j jVar = this.f6529m;
        if (jVar != null) {
            jVar.f6527k.remove(this);
            this.f6529m = null;
        }
    }

    final l1.a a() {
        return this.f6525i;
    }

    public final com.bumptech.glide.i b() {
        return this.f6528l;
    }

    public final l c() {
        return this.f6526j;
    }

    final void e() {
        this.f6530n = null;
    }

    public final void f(com.bumptech.glide.i iVar) {
        this.f6528l = iVar;
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            d(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f6525i.c();
        g();
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        g();
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f6525i.d();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f6525i.e();
    }

    @Override // android.app.Fragment
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f6530n;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
