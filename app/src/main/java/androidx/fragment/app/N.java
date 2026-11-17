package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
abstract class N {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f3484a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<b> f3485b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<b> f3486c = new ArrayList<>();
    boolean d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f3487e = false;

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends b {

        /* renamed from: h, reason: collision with root package name */
        private final C f3488h;

        a(int i2, int i4, C c2, B.a aVar) {
            super(i2, i4, c2.k(), aVar);
            this.f3488h = c2;
        }

        @Override // androidx.fragment.app.N.b
        public final void c() {
            super.c();
            this.f3488h.l();
        }

        @Override // androidx.fragment.app.N.b
        final void l() {
            if (g() == 2) {
                Fragment fragmentK = this.f3488h.k();
                View viewFindFocus = fragmentK.f3418O.findFocus();
                if (viewFindFocus != null) {
                    fragmentK.S0(viewFindFocus);
                    if (w.k0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK);
                    }
                }
                View viewO0 = f().O0();
                if (viewO0.getParent() == null) {
                    this.f3488h.b();
                    viewO0.setAlpha(0.0f);
                }
                if (viewO0.getAlpha() == 0.0f && viewO0.getVisibility() == 0) {
                    viewO0.setVisibility(4);
                }
                Fragment.b bVar = fragmentK.f3420R;
                viewO0.setAlpha(bVar == null ? 1.0f : bVar.f3458m);
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f3489a;

        /* renamed from: b, reason: collision with root package name */
        private int f3490b;

        /* renamed from: c, reason: collision with root package name */
        private final Fragment f3491c;
        private final List<Runnable> d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final HashSet<B.a> f3492e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        private boolean f3493f = false;
        private boolean g = false;

        b(int i2, int i4, Fragment fragment, B.a aVar) {
            this.f3489a = i2;
            this.f3490b = i4;
            this.f3491c = fragment;
            aVar.b(new O(this));
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<java.lang.Runnable>] */
        final void a(Runnable runnable) {
            this.d.add(runnable);
        }

        final void b() {
            if (this.f3493f) {
                return;
            }
            this.f3493f = true;
            if (this.f3492e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f3492e).iterator();
            while (it.hasNext()) {
                ((B.a) it.next()).a();
            }
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.Runnable>] */
        public void c() {
            if (this.g) {
                return;
            }
            if (w.k0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void d(B.a aVar) {
            if (this.f3492e.remove(aVar) && this.f3492e.isEmpty()) {
                c();
            }
        }

        public final int e() {
            return this.f3489a;
        }

        public final Fragment f() {
            return this.f3491c;
        }

        final int g() {
            return this.f3490b;
        }

        final boolean h() {
            return this.f3493f;
        }

        final boolean i() {
            return this.g;
        }

        public final void j(B.a aVar) {
            l();
            this.f3492e.add(aVar);
        }

        final void k(int i2, int i4) {
            if (i4 == 0) {
                throw null;
            }
            int i5 = i4 - 1;
            if (i5 == 0) {
                if (this.f3489a != 1) {
                    if (w.k0(2)) {
                        StringBuilder sbD = D2.e.d("SpecialEffectsController: For fragment ");
                        sbD.append(this.f3491c);
                        sbD.append(" mFinalState = ");
                        sbD.append(P.d(this.f3489a));
                        sbD.append(" -> ");
                        sbD.append(P.d(i2));
                        sbD.append(". ");
                        Log.v("FragmentManager", sbD.toString());
                    }
                    this.f3489a = i2;
                    return;
                }
                return;
            }
            if (i5 == 1) {
                if (this.f3489a == 1) {
                    if (w.k0(2)) {
                        StringBuilder sbD2 = D2.e.d("SpecialEffectsController: For fragment ");
                        sbD2.append(this.f3491c);
                        sbD2.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        sbD2.append(C2.c.i(this.f3490b));
                        sbD2.append(" to ADDING.");
                        Log.v("FragmentManager", sbD2.toString());
                    }
                    this.f3489a = 2;
                    this.f3490b = 2;
                    return;
                }
                return;
            }
            if (i5 != 2) {
                return;
            }
            if (w.k0(2)) {
                StringBuilder sbD3 = D2.e.d("SpecialEffectsController: For fragment ");
                sbD3.append(this.f3491c);
                sbD3.append(" mFinalState = ");
                sbD3.append(P.d(this.f3489a));
                sbD3.append(" -> REMOVED. mLifecycleImpact  = ");
                sbD3.append(C2.c.i(this.f3490b));
                sbD3.append(" to REMOVING.");
                Log.v("FragmentManager", sbD3.toString());
            }
            this.f3489a = 1;
            this.f3490b = 3;
        }

        void l() {
        }

        public final String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + P.d(this.f3489a) + "} {mLifecycleImpact = " + C2.c.i(this.f3490b) + "} {mFragment = " + this.f3491c + "}";
        }
    }

    N(ViewGroup viewGroup) {
        this.f3484a = viewGroup;
    }

    private void a(int i2, int i4, C c2) {
        synchronized (this.f3485b) {
            B.a aVar = new B.a();
            b bVarH = h(c2.k());
            if (bVarH != null) {
                bVarH.k(i2, i4);
                return;
            }
            a aVar2 = new a(i2, i4, c2, aVar);
            this.f3485b.add(aVar2);
            aVar2.a(new L(this, aVar2));
            aVar2.a(new M(this, aVar2));
        }
    }

    private b h(Fragment fragment) {
        Iterator<b> it = this.f3485b.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    static N l(ViewGroup viewGroup, w wVar) {
        return m(viewGroup, wVar.e0());
    }

    static N m(ViewGroup viewGroup, Q q2) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof N) {
            return (N) tag;
        }
        Objects.requireNonNull((w.f) q2);
        C0207c c0207c = new C0207c(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, c0207c);
        return c0207c;
    }

    private void o() {
        Iterator<b> it = this.f3485b.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.g() == 2) {
                next.k(P.b(next.f().O0().getVisibility()), 1);
            }
        }
    }

    final void b(int i2, C c2) {
        if (w.k0(2)) {
            StringBuilder sbD = D2.e.d("SpecialEffectsController: Enqueuing add operation for fragment ");
            sbD.append(c2.k());
            Log.v("FragmentManager", sbD.toString());
        }
        a(i2, 2, c2);
    }

    final void c(C c2) {
        if (w.k0(2)) {
            StringBuilder sbD = D2.e.d("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sbD.append(c2.k());
            Log.v("FragmentManager", sbD.toString());
        }
        a(3, 1, c2);
    }

    final void d(C c2) {
        if (w.k0(2)) {
            StringBuilder sbD = D2.e.d("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sbD.append(c2.k());
            Log.v("FragmentManager", sbD.toString());
        }
        a(1, 3, c2);
    }

    final void e(C c2) {
        if (w.k0(2)) {
            StringBuilder sbD = D2.e.d("SpecialEffectsController: Enqueuing show operation for fragment ");
            sbD.append(c2.k());
            Log.v("FragmentManager", sbD.toString());
        }
        a(2, 1, c2);
    }

    abstract void f(List<b> list, boolean z4);

    final void g() {
        if (this.f3487e) {
            return;
        }
        ViewGroup viewGroup = this.f3484a;
        int i2 = androidx.core.view.o.d;
        if (!viewGroup.isAttachedToWindow()) {
            i();
            this.d = false;
            return;
        }
        synchronized (this.f3485b) {
            if (!this.f3485b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f3486c);
                this.f3486c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (w.k0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + bVar);
                    }
                    bVar.b();
                    if (!bVar.i()) {
                        this.f3486c.add(bVar);
                    }
                }
                o();
                ArrayList arrayList2 = new ArrayList(this.f3485b);
                this.f3485b.clear();
                this.f3486c.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).l();
                }
                f(arrayList2, this.d);
                this.d = false;
            }
        }
    }

    final void i() {
        String str;
        String str2;
        ViewGroup viewGroup = this.f3484a;
        int i2 = androidx.core.view.o.d;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f3485b) {
            o();
            Iterator<b> it = this.f3485b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.f3486c).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (w.k0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (zIsAttachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f3484a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(bVar);
                    Log.v("FragmentManager", sb.toString());
                }
                bVar.b();
            }
            Iterator it3 = new ArrayList(this.f3485b).iterator();
            while (it3.hasNext()) {
                b bVar2 = (b) it3.next();
                if (w.k0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (zIsAttachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.f3484a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(bVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                bVar2.b();
            }
        }
    }

    final int j(C c2) {
        b next;
        b bVarH = h(c2.k());
        int iG = bVarH != null ? bVarH.g() : 0;
        Fragment fragmentK = c2.k();
        Iterator<b> it = this.f3486c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.f().equals(fragmentK) && !next.h()) {
                break;
            }
        }
        return (next == null || !(iG == 0 || iG == 1)) ? iG : next.g();
    }

    public final ViewGroup k() {
        return this.f3484a;
    }

    final void n() {
        synchronized (this.f3485b) {
            o();
            this.f3487e = false;
            int size = this.f3485b.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                b bVar = this.f3485b.get(size);
                int iC = P.c(bVar.f().f3418O);
                if (bVar.e() == 2 && iC != 2) {
                    Objects.requireNonNull(bVar.f());
                    this.f3487e = false;
                    break;
                }
            }
        }
    }
}
