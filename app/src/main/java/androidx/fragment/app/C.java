package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.g;
import com.android.mmt.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes.dex */
final class C {

    /* renamed from: a, reason: collision with root package name */
    private final v f3375a;

    /* renamed from: b, reason: collision with root package name */
    private final D f3376b;

    /* renamed from: c, reason: collision with root package name */
    private final Fragment f3377c;
    private boolean d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f3378e = -1;

    final class a implements View.OnAttachStateChangeListener {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f3379i;

        a(View view) {
            this.f3379i = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            this.f3379i.removeOnAttachStateChangeListener(this);
            View view2 = this.f3379i;
            int i2 = androidx.core.view.o.d;
            view2.requestApplyInsets();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    C(v vVar, D d, Fragment fragment) {
        this.f3375a = vVar;
        this.f3376b = d;
        this.f3377c = fragment;
    }

    final void a() {
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("moveto ACTIVITY_CREATED: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        Fragment fragment = this.f3377c;
        fragment.v0(fragment.f3431j);
        v vVar = this.f3375a;
        Fragment fragment2 = this.f3377c;
        vVar.a(fragment2, fragment2.f3431j, false);
    }

    final void b() {
        int iJ = this.f3376b.j(this.f3377c);
        Fragment fragment = this.f3377c;
        fragment.f3417N.addView(fragment.f3418O, iJ);
    }

    final void c() {
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("moveto ATTACHED: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        Fragment fragment = this.f3377c;
        Fragment fragment2 = fragment.p;
        C cM = null;
        if (fragment2 != null) {
            C cM2 = this.f3376b.m(fragment2.f3435n);
            if (cM2 == null) {
                StringBuilder sbD2 = D2.e.d("Fragment ");
                sbD2.append(this.f3377c);
                sbD2.append(" declared target fragment ");
                sbD2.append(this.f3377c.p);
                sbD2.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sbD2.toString());
            }
            Fragment fragment3 = this.f3377c;
            fragment3.f3437q = fragment3.p.f3435n;
            fragment3.p = null;
            cM = cM2;
        } else {
            String str = fragment.f3437q;
            if (str != null && (cM = this.f3376b.m(str)) == null) {
                StringBuilder sbD3 = D2.e.d("Fragment ");
                sbD3.append(this.f3377c);
                sbD3.append(" declared target fragment ");
                throw new IllegalStateException(C2.c.b(sbD3, this.f3377c.f3437q, " that does not belong to this FragmentManager!"));
            }
        }
        if (cM != null) {
            cM.l();
        }
        Fragment fragment4 = this.f3377c;
        fragment4.f3407B = fragment4.f3406A.a0();
        Fragment fragment5 = this.f3377c;
        fragment5.f3409D = fragment5.f3406A.d0();
        this.f3375a.g(this.f3377c, false);
        this.f3377c.w0();
        this.f3375a.b(this.f3377c, false);
    }

    final int d() {
        Fragment fragment = this.f3377c;
        if (fragment.f3406A == null) {
            return fragment.f3430i;
        }
        int iMin = this.f3378e;
        int iOrdinal = fragment.f3424V.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        Fragment fragment2 = this.f3377c;
        if (fragment2.f3441v) {
            if (fragment2.f3442w) {
                iMin = Math.max(this.f3378e, 2);
                View view = this.f3377c.f3418O;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f3378e < 4 ? Math.min(iMin, fragment2.f3430i) : Math.min(iMin, 1);
            }
        }
        if (!this.f3377c.f3440t) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment3 = this.f3377c;
        ViewGroup viewGroup = fragment3.f3417N;
        int iJ = viewGroup != null ? N.m(viewGroup, fragment3.I().e0()).j(this) : 0;
        if (iJ == 2) {
            iMin = Math.min(iMin, 6);
        } else if (iJ == 3) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f3377c;
            if (fragment4.u) {
                iMin = fragment4.Y() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f3377c;
        if (fragment5.P && fragment5.f3430i < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (w.k0(2)) {
            StringBuilder sbC = C2.c.c("computeExpectedState() of ", iMin, " for ");
            sbC.append(this.f3377c);
            Log.v("FragmentManager", sbC.toString());
        }
        return iMin;
    }

    final void e() {
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("moveto CREATED: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        Fragment fragment = this.f3377c;
        if (fragment.f3423U) {
            fragment.P0(fragment.f3431j);
            this.f3377c.f3430i = 1;
            return;
        }
        this.f3375a.h(fragment, fragment.f3431j, false);
        Fragment fragment2 = this.f3377c;
        fragment2.x0(fragment2.f3431j);
        v vVar = this.f3375a;
        Fragment fragment3 = this.f3377c;
        vVar.c(fragment3, fragment3.f3431j, false);
    }

    final void f() throws Resources.NotFoundException {
        String resourceName;
        if (this.f3377c.f3441v) {
            return;
        }
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("moveto CREATE_VIEW: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        Fragment fragment = this.f3377c;
        LayoutInflater layoutInflaterC0 = fragment.C0(fragment.f3431j);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.f3377c;
        ViewGroup viewGroup2 = fragment2.f3417N;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i2 = fragment2.f3411F;
            if (i2 != 0) {
                if (i2 == -1) {
                    StringBuilder sbD2 = D2.e.d("Cannot create fragment ");
                    sbD2.append(this.f3377c);
                    sbD2.append(" for a container view with no id");
                    throw new IllegalArgumentException(sbD2.toString());
                }
                viewGroup = (ViewGroup) fragment2.f3406A.W().d(this.f3377c.f3411F);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f3377c;
                    if (!fragment3.f3443x) {
                        try {
                            resourceName = fragment3.N().getResourceName(this.f3377c.f3411F);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        StringBuilder sbD3 = D2.e.d("No view found for id 0x");
                        sbD3.append(Integer.toHexString(this.f3377c.f3411F));
                        sbD3.append(" (");
                        sbD3.append(resourceName);
                        sbD3.append(") for fragment ");
                        sbD3.append(this.f3377c);
                        throw new IllegalArgumentException(sbD3.toString());
                    }
                }
            }
        }
        Fragment fragment4 = this.f3377c;
        fragment4.f3417N = viewGroup;
        fragment4.y0(layoutInflaterC0, viewGroup, fragment4.f3431j);
        View view = this.f3377c.f3418O;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f3377c;
            fragment5.f3418O.setTag(R.id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f3377c;
            if (fragment6.f3413H) {
                fragment6.f3418O.setVisibility(8);
            }
            View view2 = this.f3377c.f3418O;
            int i4 = androidx.core.view.o.d;
            if (view2.isAttachedToWindow()) {
                this.f3377c.f3418O.requestApplyInsets();
            } else {
                View view3 = this.f3377c.f3418O;
                view3.addOnAttachStateChangeListener(new a(view3));
            }
            Fragment fragment7 = this.f3377c;
            View view4 = fragment7.f3418O;
            fragment7.t0(fragment7.f3431j);
            fragment7.f3408C.G();
            v vVar = this.f3375a;
            Fragment fragment8 = this.f3377c;
            vVar.m(fragment8, fragment8.f3418O, fragment8.f3431j, false);
            int visibility = this.f3377c.f3418O.getVisibility();
            this.f3377c.X0(this.f3377c.f3418O.getAlpha());
            Fragment fragment9 = this.f3377c;
            if (fragment9.f3417N != null && visibility == 0) {
                View viewFindFocus = fragment9.f3418O.findFocus();
                if (viewFindFocus != null) {
                    this.f3377c.S0(viewFindFocus);
                    if (w.k0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f3377c);
                    }
                }
                this.f3377c.f3418O.setAlpha(0.0f);
            }
        }
        this.f3377c.f3430i = 2;
    }

    final void g() {
        Fragment fragmentF;
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("movefrom CREATED: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        Fragment fragment = this.f3377c;
        boolean zIsChangingConfigurations = true;
        boolean z4 = fragment.u && !fragment.Y();
        if (!(z4 || this.f3376b.o().m(this.f3377c))) {
            String str = this.f3377c.f3437q;
            if (str != null && (fragmentF = this.f3376b.f(str)) != null && fragmentF.f3415J) {
                this.f3377c.p = fragmentF;
            }
            this.f3377c.f3430i = 0;
            return;
        }
        t<?> tVar = this.f3377c.f3407B;
        if (tVar instanceof androidx.lifecycle.x) {
            zIsChangingConfigurations = this.f3376b.o().j();
        } else if (tVar.j() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) tVar.j()).isChangingConfigurations();
        }
        if (z4 || zIsChangingConfigurations) {
            this.f3376b.o().d(this.f3377c);
        }
        this.f3377c.z0();
        this.f3375a.d(this.f3377c, false);
        Iterator it = ((ArrayList) this.f3376b.k()).iterator();
        while (it.hasNext()) {
            C c2 = (C) it.next();
            if (c2 != null) {
                Fragment fragment2 = c2.f3377c;
                if (this.f3377c.f3435n.equals(fragment2.f3437q)) {
                    fragment2.p = this.f3377c;
                    fragment2.f3437q = null;
                }
            }
        }
        Fragment fragment3 = this.f3377c;
        String str2 = fragment3.f3437q;
        if (str2 != null) {
            fragment3.p = this.f3376b.f(str2);
        }
        this.f3376b.q(this);
    }

    final void h() {
        View view;
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("movefrom CREATE_VIEW: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        Fragment fragment = this.f3377c;
        ViewGroup viewGroup = fragment.f3417N;
        if (viewGroup != null && (view = fragment.f3418O) != null) {
            viewGroup.removeView(view);
        }
        this.f3377c.A0();
        this.f3375a.n(this.f3377c, false);
        Fragment fragment2 = this.f3377c;
        fragment2.f3417N = null;
        fragment2.f3418O = null;
        fragment2.f3426X = null;
        fragment2.f3427Y.n(null);
        this.f3377c.f3442w = false;
    }

    final void i() {
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("movefrom ATTACHED: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        this.f3377c.B0();
        this.f3375a.e(this.f3377c, false);
        Fragment fragment = this.f3377c;
        fragment.f3430i = -1;
        fragment.f3407B = null;
        fragment.f3409D = null;
        fragment.f3406A = null;
        if ((fragment.u && !fragment.Y()) || this.f3376b.o().m(this.f3377c)) {
            if (w.k0(3)) {
                StringBuilder sbD2 = D2.e.d("initState called for fragment: ");
                sbD2.append(this.f3377c);
                Log.d("FragmentManager", sbD2.toString());
            }
            Fragment fragment2 = this.f3377c;
            Objects.requireNonNull(fragment2);
            fragment2.f3425W = new androidx.lifecycle.l(fragment2);
            fragment2.f3428Z = androidx.savedstate.a.a(fragment2);
            fragment2.f3435n = UUID.randomUUID().toString();
            fragment2.f3440t = false;
            fragment2.u = false;
            fragment2.f3441v = false;
            fragment2.f3442w = false;
            fragment2.f3443x = false;
            fragment2.f3445z = 0;
            fragment2.f3406A = null;
            fragment2.f3408C = new x();
            fragment2.f3407B = null;
            fragment2.f3410E = 0;
            fragment2.f3411F = 0;
            fragment2.f3412G = null;
            fragment2.f3413H = false;
            fragment2.f3414I = false;
        }
    }

    final void j() {
        Fragment fragment = this.f3377c;
        if (fragment.f3441v && fragment.f3442w && !fragment.f3444y) {
            if (w.k0(3)) {
                StringBuilder sbD = D2.e.d("moveto CREATE_VIEW: ");
                sbD.append(this.f3377c);
                Log.d("FragmentManager", sbD.toString());
            }
            Fragment fragment2 = this.f3377c;
            fragment2.y0(fragment2.C0(fragment2.f3431j), null, this.f3377c.f3431j);
            View view = this.f3377c.f3418O;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f3377c;
                fragment3.f3418O.setTag(R.id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f3377c;
                if (fragment4.f3413H) {
                    fragment4.f3418O.setVisibility(8);
                }
                Fragment fragment5 = this.f3377c;
                View view2 = fragment5.f3418O;
                fragment5.t0(fragment5.f3431j);
                fragment5.f3408C.G();
                v vVar = this.f3375a;
                Fragment fragment6 = this.f3377c;
                vVar.m(fragment6, fragment6.f3418O, fragment6.f3431j, false);
                this.f3377c.f3430i = 2;
            }
        }
    }

    final Fragment k() {
        return this.f3377c;
    }

    final void l() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.d) {
            if (w.k0(2)) {
                StringBuilder sbD = D2.e.d("Ignoring re-entrant call to moveToExpectedState() for ");
                sbD.append(this.f3377c);
                Log.v("FragmentManager", sbD.toString());
                return;
            }
            return;
        }
        try {
            this.d = true;
            while (true) {
                int iD = d();
                Fragment fragment = this.f3377c;
                int i2 = fragment.f3430i;
                if (iD == i2) {
                    if (fragment.f3421S) {
                        if (fragment.f3418O != null && (viewGroup = fragment.f3417N) != null) {
                            N nM = N.m(viewGroup, fragment.I().e0());
                            if (this.f3377c.f3413H) {
                                nM.c(this);
                            } else {
                                nM.e(this);
                            }
                        }
                        Fragment fragment2 = this.f3377c;
                        w wVar = fragment2.f3406A;
                        if (wVar != null) {
                            wVar.i0(fragment2);
                        }
                        Fragment fragment3 = this.f3377c;
                        fragment3.f3421S = false;
                        fragment3.l0(fragment3.f3413H);
                    }
                    return;
                }
                if (iD <= i2) {
                    switch (i2 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.f3377c.f3430i = 1;
                            break;
                        case 2:
                            fragment.f3442w = false;
                            fragment.f3430i = 2;
                            break;
                        case 3:
                            if (w.k0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f3377c);
                            }
                            Fragment fragment4 = this.f3377c;
                            if (fragment4.f3418O != null && fragment4.f3432k == null) {
                                q();
                            }
                            Fragment fragment5 = this.f3377c;
                            if (fragment5.f3418O != null && (viewGroup3 = fragment5.f3417N) != null) {
                                N.m(viewGroup3, fragment5.I().e0()).d(this);
                            }
                            this.f3377c.f3430i = 3;
                            break;
                        case 4:
                            t();
                            break;
                        case 5:
                            fragment.f3430i = 5;
                            break;
                        case 6:
                            m();
                            break;
                    }
                } else {
                    switch (i2 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.f3418O != null && (viewGroup2 = fragment.f3417N) != null) {
                                N.m(viewGroup2, fragment.I().e0()).b(P.b(this.f3377c.f3418O.getVisibility()), this);
                            }
                            this.f3377c.f3430i = 4;
                            break;
                        case 5:
                            s();
                            break;
                        case 6:
                            fragment.f3430i = 6;
                            break;
                        case 7:
                            o();
                            break;
                    }
                }
            }
        } finally {
            this.d = false;
        }
    }

    final void m() {
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("movefrom RESUMED: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        this.f3377c.F0();
        this.f3375a.f(this.f3377c, false);
    }

    final void n(ClassLoader classLoader) {
        Bundle bundle = this.f3377c.f3431j;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f3377c;
        fragment.f3432k = fragment.f3431j.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f3377c;
        fragment2.f3433l = fragment2.f3431j.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f3377c;
        fragment3.f3437q = fragment3.f3431j.getString("android:target_state");
        Fragment fragment4 = this.f3377c;
        if (fragment4.f3437q != null) {
            fragment4.f3438r = fragment4.f3431j.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f3377c;
        Boolean bool = fragment5.f3434m;
        if (bool != null) {
            fragment5.f3419Q = bool.booleanValue();
            this.f3377c.f3434m = null;
        } else {
            fragment5.f3419Q = fragment5.f3431j.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f3377c;
        if (fragment6.f3419Q) {
            return;
        }
        fragment6.P = true;
    }

    final void o() {
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("moveto RESUMED: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        Fragment fragment = this.f3377c;
        Fragment.b bVar = fragment.f3420R;
        View view = bVar == null ? null : bVar.f3459n;
        if (view != null) {
            boolean z4 = true;
            if (view != fragment.f3418O) {
                ViewParent parent = view.getParent();
                while (true) {
                    if (parent == null) {
                        z4 = false;
                        break;
                    } else if (parent == this.f3377c.f3418O) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            if (z4) {
                boolean zRequestFocus = view.requestFocus();
                if (w.k0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("requestFocus: Restoring focused view ");
                    sb.append(view);
                    sb.append(" ");
                    sb.append(zRequestFocus ? "succeeded" : "failed");
                    sb.append(" on Fragment ");
                    sb.append(this.f3377c);
                    sb.append(" resulting in focused view ");
                    sb.append(this.f3377c.f3418O.findFocus());
                    Log.v("FragmentManager", sb.toString());
                }
            }
        }
        this.f3377c.S0(null);
        this.f3377c.J0();
        this.f3375a.i(this.f3377c, false);
        Fragment fragment2 = this.f3377c;
        fragment2.f3431j = null;
        fragment2.f3432k = null;
        fragment2.f3433l = null;
    }

    final B p() {
        B b2 = new B(this.f3377c);
        Fragment fragment = this.f3377c;
        if (fragment.f3430i <= -1 || b2.u != null) {
            b2.u = fragment.f3431j;
        } else {
            Bundle bundle = new Bundle();
            Fragment fragment2 = this.f3377c;
            fragment2.q0(bundle);
            fragment2.f3428Z.d(bundle);
            Parcelable parcelableY0 = fragment2.f3408C.y0();
            if (parcelableY0 != null) {
                bundle.putParcelable("android:support:fragments", parcelableY0);
            }
            this.f3375a.j(this.f3377c, bundle, false);
            if (bundle.isEmpty()) {
                bundle = null;
            }
            if (this.f3377c.f3418O != null) {
                q();
            }
            if (this.f3377c.f3432k != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray("android:view_state", this.f3377c.f3432k);
            }
            if (this.f3377c.f3433l != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("android:view_registry_state", this.f3377c.f3433l);
            }
            if (!this.f3377c.f3419Q) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android:user_visible_hint", this.f3377c.f3419Q);
            }
            b2.u = bundle;
            if (this.f3377c.f3437q != null) {
                if (bundle == null) {
                    b2.u = new Bundle();
                }
                b2.u.putString("android:target_state", this.f3377c.f3437q);
                int i2 = this.f3377c.f3438r;
                if (i2 != 0) {
                    b2.u.putInt("android:target_req_state", i2);
                }
            }
        }
        return b2;
    }

    final void q() {
        if (this.f3377c.f3418O == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f3377c.f3418O.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f3377c.f3432k = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f3377c.f3426X.h(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f3377c.f3433l = bundle;
    }

    final void r(int i2) {
        this.f3378e = i2;
    }

    final void s() {
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("moveto STARTED: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        this.f3377c.K0();
        this.f3375a.k(this.f3377c, false);
    }

    final void t() {
        if (w.k0(3)) {
            StringBuilder sbD = D2.e.d("movefrom STARTED: ");
            sbD.append(this.f3377c);
            Log.d("FragmentManager", sbD.toString());
        }
        this.f3377c.L0();
        this.f3375a.l(this.f3377c, false);
    }

    C(v vVar, D d, ClassLoader classLoader, C0222s c0222s, B b2) {
        this.f3375a = vVar;
        this.f3376b = d;
        Fragment fragmentA = c0222s.a(classLoader, b2.f3364i);
        this.f3377c = fragmentA;
        Bundle bundle = b2.f3372r;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.R0(b2.f3372r);
        fragmentA.f3435n = b2.f3365j;
        fragmentA.f3441v = b2.f3366k;
        fragmentA.f3443x = true;
        fragmentA.f3410E = b2.f3367l;
        fragmentA.f3411F = b2.f3368m;
        fragmentA.f3412G = b2.f3369n;
        fragmentA.f3415J = b2.f3370o;
        fragmentA.u = b2.p;
        fragmentA.f3414I = b2.f3371q;
        fragmentA.f3413H = b2.f3373s;
        fragmentA.f3424V = g.c.values()[b2.f3374t];
        Bundle bundle2 = b2.u;
        if (bundle2 != null) {
            fragmentA.f3431j = bundle2;
        } else {
            fragmentA.f3431j = new Bundle();
        }
        if (w.k0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    C(v vVar, D d, Fragment fragment, B b2) {
        this.f3375a = vVar;
        this.f3376b = d;
        this.f3377c = fragment;
        fragment.f3432k = null;
        fragment.f3433l = null;
        fragment.f3445z = 0;
        fragment.f3442w = false;
        fragment.f3440t = false;
        Fragment fragment2 = fragment.p;
        fragment.f3437q = fragment2 != null ? fragment2.f3435n : null;
        fragment.p = null;
        Bundle bundle = b2.u;
        if (bundle != null) {
            fragment.f3431j = bundle;
        } else {
            fragment.f3431j = new Bundle();
        }
    }
}
