package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.g;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import t.C0384b;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.k, androidx.lifecycle.x, androidx.savedstate.b {

    /* renamed from: b0, reason: collision with root package name */
    static final Object f3405b0 = new Object();

    /* renamed from: A, reason: collision with root package name */
    w f3406A;

    /* renamed from: B, reason: collision with root package name */
    t<?> f3407B;

    /* renamed from: D, reason: collision with root package name */
    Fragment f3409D;

    /* renamed from: E, reason: collision with root package name */
    int f3410E;

    /* renamed from: F, reason: collision with root package name */
    int f3411F;

    /* renamed from: G, reason: collision with root package name */
    String f3412G;

    /* renamed from: H, reason: collision with root package name */
    boolean f3413H;

    /* renamed from: I, reason: collision with root package name */
    boolean f3414I;

    /* renamed from: J, reason: collision with root package name */
    boolean f3415J;

    /* renamed from: K, reason: collision with root package name */
    boolean f3416K;
    private boolean M;

    /* renamed from: N, reason: collision with root package name */
    ViewGroup f3417N;

    /* renamed from: O, reason: collision with root package name */
    View f3418O;
    boolean P;

    /* renamed from: R, reason: collision with root package name */
    b f3420R;

    /* renamed from: S, reason: collision with root package name */
    boolean f3421S;

    /* renamed from: T, reason: collision with root package name */
    LayoutInflater f3422T;

    /* renamed from: U, reason: collision with root package name */
    boolean f3423U;

    /* renamed from: W, reason: collision with root package name */
    androidx.lifecycle.l f3425W;

    /* renamed from: X, reason: collision with root package name */
    J f3426X;

    /* renamed from: Z, reason: collision with root package name */
    androidx.savedstate.a f3428Z;

    /* renamed from: a0, reason: collision with root package name */
    private final ArrayList<d> f3429a0;

    /* renamed from: j, reason: collision with root package name */
    Bundle f3431j;

    /* renamed from: k, reason: collision with root package name */
    SparseArray<Parcelable> f3432k;

    /* renamed from: l, reason: collision with root package name */
    Bundle f3433l;

    /* renamed from: m, reason: collision with root package name */
    Boolean f3434m;

    /* renamed from: o, reason: collision with root package name */
    Bundle f3436o;
    Fragment p;

    /* renamed from: r, reason: collision with root package name */
    int f3438r;

    /* renamed from: t, reason: collision with root package name */
    boolean f3440t;
    boolean u;

    /* renamed from: v, reason: collision with root package name */
    boolean f3441v;

    /* renamed from: w, reason: collision with root package name */
    boolean f3442w;

    /* renamed from: x, reason: collision with root package name */
    boolean f3443x;

    /* renamed from: y, reason: collision with root package name */
    boolean f3444y;

    /* renamed from: z, reason: collision with root package name */
    int f3445z;

    /* renamed from: i, reason: collision with root package name */
    int f3430i = -1;

    /* renamed from: n, reason: collision with root package name */
    String f3435n = UUID.randomUUID().toString();

    /* renamed from: q, reason: collision with root package name */
    String f3437q = null;

    /* renamed from: s, reason: collision with root package name */
    private Boolean f3439s = null;

    /* renamed from: C, reason: collision with root package name */
    w f3408C = new x();
    boolean L = true;

    /* renamed from: Q, reason: collision with root package name */
    boolean f3419Q = true;

    /* renamed from: V, reason: collision with root package name */
    g.c f3424V = g.c.RESUMED;

    /* renamed from: Y, reason: collision with root package name */
    androidx.lifecycle.o<androidx.lifecycle.k> f3427Y = new androidx.lifecycle.o<>();

    final class a extends O.d {
        a() {
        }

        @Override // O.d
        public final View d(int i2) {
            View view = Fragment.this.f3418O;
            if (view != null) {
                return view.findViewById(i2);
            }
            StringBuilder sbD = D2.e.d("Fragment ");
            sbD.append(Fragment.this);
            sbD.append(" does not have a view");
            throw new IllegalStateException(sbD.toString());
        }

        @Override // O.d
        public final boolean g() {
            return Fragment.this.f3418O != null;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        View f3448a;

        /* renamed from: b, reason: collision with root package name */
        boolean f3449b;

        /* renamed from: c, reason: collision with root package name */
        int f3450c;
        int d;

        /* renamed from: e, reason: collision with root package name */
        int f3451e;

        /* renamed from: f, reason: collision with root package name */
        int f3452f;
        int g;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<String> f3453h;

        /* renamed from: i, reason: collision with root package name */
        ArrayList<String> f3454i;

        /* renamed from: j, reason: collision with root package name */
        Object f3455j;

        /* renamed from: k, reason: collision with root package name */
        Object f3456k;

        /* renamed from: l, reason: collision with root package name */
        Object f3457l;

        /* renamed from: m, reason: collision with root package name */
        float f3458m;

        /* renamed from: n, reason: collision with root package name */
        View f3459n;

        b() {
            Object obj = Fragment.f3405b0;
            this.f3455j = obj;
            this.f3456k = obj;
            this.f3457l = obj;
            this.f3458m = 1.0f;
            this.f3459n = null;
        }
    }

    public static class c extends RuntimeException {
        public c(String str, Exception exc) {
            super(str, exc);
        }
    }

    private static abstract class d {
        private d() {
        }

        abstract void a();
    }

    public Fragment() {
        new AtomicInteger();
        this.f3429a0 = new ArrayList<>();
        this.f3425W = new androidx.lifecycle.l(this);
        this.f3428Z = androidx.savedstate.a.a(this);
    }

    private int G() {
        g.c cVar = this.f3424V;
        return (cVar == g.c.INITIALIZED || this.f3409D == null) ? cVar.ordinal() : Math.min(cVar.ordinal(), this.f3409D.G());
    }

    @Deprecated
    public static Fragment V(Context context, String str, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Fragment fragmentNewInstance = C0222s.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.R0(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e2) {
            throw new c(C2.c.a("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (InstantiationException e4) {
            throw new c(C2.c.a("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e4);
        } catch (NoSuchMethodException e5) {
            throw new c(C2.c.a("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e5);
        } catch (InvocationTargetException e6) {
            throw new c(C2.c.a("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e6);
        }
    }

    private b w() {
        if (this.f3420R == null) {
            this.f3420R = new b();
        }
        return this.f3420R;
    }

    public final w A() {
        if (this.f3407B != null) {
            return this.f3408C;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    final void A0() {
        this.f3408C.r();
        if (this.f3418O != null && this.f3426X.a().b().d(g.c.CREATED)) {
            this.f3426X.b(g.b.ON_DESTROY);
        }
        this.f3430i = 1;
        this.M = false;
        i0();
        if (this.M) {
            androidx.loader.app.a.b(this).c();
            this.f3444y = false;
        } else {
            throw new S("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public final Context B() {
        t<?> tVar = this.f3407B;
        if (tVar == null) {
            return null;
        }
        return tVar.j();
    }

    final void B0() {
        this.f3430i = -1;
        this.M = false;
        j0();
        this.f3422T = null;
        if (this.M) {
            if (this.f3408C.j0()) {
                return;
            }
            this.f3408C.q();
            this.f3408C = new x();
            return;
        }
        throw new S("Fragment " + this + " did not call through to super.onDetach()");
    }

    final int C() {
        b bVar = this.f3420R;
        if (bVar == null) {
            return 0;
        }
        return bVar.f3450c;
    }

    final LayoutInflater C0(Bundle bundle) {
        LayoutInflater layoutInflaterK0 = k0(bundle);
        this.f3422T = layoutInflaterK0;
        return layoutInflaterK0;
    }

    final int D() {
        b bVar = this.f3420R;
        if (bVar == null) {
            return 0;
        }
        return bVar.d;
    }

    final void D0() {
        onLowMemory();
        this.f3408C.s();
    }

    @Deprecated
    public final w E() {
        return this.f3406A;
    }

    final void E0(boolean z4) {
        this.f3408C.t(z4);
    }

    public final LayoutInflater F() {
        LayoutInflater layoutInflater = this.f3422T;
        return layoutInflater == null ? C0(null) : layoutInflater;
    }

    final void F0() {
        this.f3408C.y();
        if (this.f3418O != null) {
            this.f3426X.b(g.b.ON_PAUSE);
        }
        this.f3425W.f(g.b.ON_PAUSE);
        this.f3430i = 6;
        this.M = false;
        n0();
        if (this.M) {
            return;
        }
        throw new S("Fragment " + this + " did not call through to super.onPause()");
    }

    final void G0(boolean z4) {
        this.f3408C.z(z4);
    }

    public final Fragment H() {
        return this.f3409D;
    }

    final boolean H0(Menu menu) {
        boolean z4 = false;
        if (this.f3413H) {
            return false;
        }
        if (this.f3416K && this.L) {
            z4 = true;
        }
        return z4 | this.f3408C.A(menu);
    }

    public final w I() {
        w wVar = this.f3406A;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    final void I0() {
        boolean zN0 = this.f3406A.n0(this);
        Boolean bool = this.f3439s;
        if (bool == null || bool.booleanValue() != zN0) {
            this.f3439s = Boolean.valueOf(zN0);
            this.f3408C.B();
        }
    }

    final boolean J() {
        b bVar = this.f3420R;
        if (bVar == null) {
            return false;
        }
        return bVar.f3449b;
    }

    final void J0() {
        this.f3408C.q0();
        this.f3408C.M(true);
        this.f3430i = 7;
        this.M = false;
        p0();
        if (!this.M) {
            throw new S("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.l lVar = this.f3425W;
        g.b bVar = g.b.ON_RESUME;
        lVar.f(bVar);
        if (this.f3418O != null) {
            this.f3426X.b(bVar);
        }
        this.f3408C.C();
    }

    final int K() {
        b bVar = this.f3420R;
        if (bVar == null) {
            return 0;
        }
        return bVar.f3451e;
    }

    final void K0() {
        this.f3408C.q0();
        this.f3408C.M(true);
        this.f3430i = 5;
        this.M = false;
        r0();
        if (!this.M) {
            throw new S("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.l lVar = this.f3425W;
        g.b bVar = g.b.ON_START;
        lVar.f(bVar);
        if (this.f3418O != null) {
            this.f3426X.b(bVar);
        }
        this.f3408C.D();
    }

    final int L() {
        b bVar = this.f3420R;
        if (bVar == null) {
            return 0;
        }
        return bVar.f3452f;
    }

    final void L0() {
        this.f3408C.F();
        if (this.f3418O != null) {
            this.f3426X.b(g.b.ON_STOP);
        }
        this.f3425W.f(g.b.ON_STOP);
        this.f3430i = 4;
        this.M = false;
        s0();
        if (this.M) {
            return;
        }
        throw new S("Fragment " + this + " did not call through to super.onStop()");
    }

    public final Object M() {
        Object obj;
        b bVar = this.f3420R;
        if (bVar == null || (obj = bVar.f3456k) == f3405b0) {
            return null;
        }
        return obj;
    }

    public final ActivityC0219o M0() {
        ActivityC0219o activityC0219oX = x();
        if (activityC0219oX != null) {
            return activityC0219oX;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Resources N() {
        return N0().getResources();
    }

    public final Context N0() {
        Context contextB = B();
        if (contextB != null) {
            return contextB;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final Object O() {
        Object obj;
        b bVar = this.f3420R;
        if (bVar == null || (obj = bVar.f3455j) == f3405b0) {
            return null;
        }
        return obj;
    }

    public final View O0() {
        View viewT = T();
        if (viewT != null) {
            return viewT;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final Object P() {
        Object obj;
        b bVar = this.f3420R;
        if (bVar == null || (obj = bVar.f3457l) == f3405b0) {
            return null;
        }
        return obj;
    }

    final void P0(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f3408C.x0(parcelable);
        this.f3408C.o();
    }

    public final String Q(int i2) {
        return N().getString(i2);
    }

    final void Q0(int i2, int i4, int i5, int i6) {
        if (this.f3420R == null && i2 == 0 && i4 == 0 && i5 == 0 && i6 == 0) {
            return;
        }
        w().f3450c = i2;
        w().d = i4;
        w().f3451e = i5;
        w().f3452f = i6;
    }

    public final String R(int i2, Object... objArr) {
        return N().getString(i2, objArr);
    }

    public final void R0(Bundle bundle) {
        w wVar = this.f3406A;
        if (wVar != null) {
            if (wVar == null ? false : wVar.o0()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.f3436o = bundle;
    }

    @Deprecated
    public final Fragment S() {
        String str;
        Fragment fragment = this.p;
        if (fragment != null) {
            return fragment;
        }
        w wVar = this.f3406A;
        if (wVar == null || (str = this.f3437q) == null) {
            return null;
        }
        return wVar.R(str);
    }

    final void S0(View view) {
        w().f3459n = view;
    }

    public View T() {
        return this.f3418O;
    }

    public void T0() {
        if (!this.f3416K) {
            this.f3416K = true;
            if (!W() || this.f3413H) {
                return;
            }
            this.f3407B.o();
        }
    }

    public final androidx.lifecycle.k U() {
        J j2 = this.f3426X;
        if (j2 != null) {
            return j2;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public void U0(boolean z4) {
        if (this.L != z4) {
            this.L = z4;
            if (this.f3416K && W() && !this.f3413H) {
                this.f3407B.o();
            }
        }
    }

    final void V0(int i2) {
        if (this.f3420R == null && i2 == 0) {
            return;
        }
        w();
        this.f3420R.g = i2;
    }

    public final boolean W() {
        return this.f3407B != null && this.f3440t;
    }

    final void W0(boolean z4) {
        if (this.f3420R == null) {
            return;
        }
        w().f3449b = z4;
    }

    public final boolean X() {
        return this.f3413H;
    }

    final void X0(float f4) {
        w().f3458m = f4;
    }

    final boolean Y() {
        return this.f3445z > 0;
    }

    final void Y0(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        w();
        b bVar = this.f3420R;
        bVar.f3453h = arrayList;
        bVar.f3454i = arrayList2;
    }

    public final boolean Z() {
        return this.f3430i >= 7;
    }

    @Deprecated
    public final void Z0(Fragment fragment) {
        w wVar = this.f3406A;
        w wVar2 = fragment != null ? fragment.f3406A : null;
        if (wVar != null && wVar2 != null && wVar != wVar2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragmentS = fragment; fragmentS != null; fragmentS = fragmentS.S()) {
            if (fragmentS.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.f3437q = null;
            this.p = null;
        } else if (this.f3406A == null || fragment.f3406A == null) {
            this.f3437q = null;
            this.p = fragment;
        } else {
            this.f3437q = fragment.f3435n;
            this.p = null;
        }
        this.f3438r = 0;
    }

    @Override // androidx.lifecycle.k
    public final androidx.lifecycle.g a() {
        return this.f3425W;
    }

    @Deprecated
    public void a0(Bundle bundle) {
        this.M = true;
    }

    @Deprecated
    public final void a1(boolean z4) {
        if (!this.f3419Q && z4 && this.f3430i < 5 && this.f3406A != null && W() && this.f3423U) {
            w wVar = this.f3406A;
            wVar.s0(wVar.i(this));
        }
        this.f3419Q = z4;
        this.P = this.f3430i < 5 && !z4;
        if (this.f3431j != null) {
            this.f3434m = Boolean.valueOf(z4);
        }
    }

    @Deprecated
    public final void b0(int i2, int i4, Intent intent) {
        if (w.k0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i4 + " data: " + intent);
        }
    }

    public final void b1(@SuppressLint({"UnknownNullness"}) Intent intent) {
        t<?> tVar = this.f3407B;
        if (tVar != null) {
            tVar.n(intent);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void c0(Context context) {
        this.M = true;
        t<?> tVar = this.f3407B;
        if ((tVar == null ? null : tVar.i()) != null) {
            this.M = true;
        }
    }

    public boolean d0(MenuItem menuItem) {
        return false;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry e() {
        return this.f3428Z.b();
    }

    public void e0(Bundle bundle) {
        this.M = true;
        P0(bundle);
        w wVar = this.f3408C;
        if (wVar.p >= 1) {
            return;
        }
        wVar.o();
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f0() {
    }

    public View g0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void h0() {
        this.M = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i0() {
        this.M = true;
    }

    public void j0() {
        this.M = true;
    }

    public LayoutInflater k0(Bundle bundle) {
        t<?> tVar = this.f3407B;
        if (tVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterM = tVar.m();
        layoutInflaterM.setFactory2(this.f3408C.b0());
        return layoutInflaterM;
    }

    public void l0(boolean z4) {
    }

    public final void m0() {
        this.M = true;
        t<?> tVar = this.f3407B;
        if ((tVar == null ? null : tVar.i()) != null) {
            this.M = true;
        }
    }

    public void n0() {
        this.M = true;
    }

    @Deprecated
    public void o0(int i2, String[] strArr, int[] iArr) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.M = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        M0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.M = true;
    }

    public void p0() {
        this.M = true;
    }

    @Override // androidx.lifecycle.x
    public final androidx.lifecycle.w q() {
        if (this.f3406A == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (G() != 1) {
            return this.f3406A.f0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public void q0(Bundle bundle) {
    }

    public void r0() {
        this.M = true;
    }

    public void s0() {
        this.M = true;
    }

    public void t0(Bundle bundle) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f3435n);
        if (this.f3410E != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3410E));
        }
        if (this.f3412G != null) {
            sb.append(" tag=");
            sb.append(this.f3412G);
        }
        sb.append(")");
        return sb.toString();
    }

    O.d u() {
        return new a();
    }

    public void u0(Bundle bundle) {
        this.M = true;
    }

    public final void v(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f3410E));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f3411F));
        printWriter.print(" mTag=");
        printWriter.println(this.f3412G);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f3430i);
        printWriter.print(" mWho=");
        printWriter.print(this.f3435n);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f3445z);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f3440t);
        printWriter.print(" mRemoving=");
        printWriter.print(this.u);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f3441v);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f3442w);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f3413H);
        printWriter.print(" mDetached=");
        printWriter.print(this.f3414I);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.L);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f3416K);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f3415J);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f3419Q);
        if (this.f3406A != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f3406A);
        }
        if (this.f3407B != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f3407B);
        }
        if (this.f3409D != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f3409D);
        }
        if (this.f3436o != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f3436o);
        }
        if (this.f3431j != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f3431j);
        }
        if (this.f3432k != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f3432k);
        }
        if (this.f3433l != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f3433l);
        }
        Fragment fragmentS = S();
        if (fragmentS != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentS);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f3438r);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(J());
        if (C() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(C());
        }
        if (D() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(D());
        }
        if (K() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(K());
        }
        if (L() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(L());
        }
        if (this.f3417N != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f3417N);
        }
        if (this.f3418O != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f3418O);
        }
        if (y() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(y());
        }
        if (B() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f3408C + ":");
        this.f3408C.I(D2.e.c(str, "  "), fileDescriptor, printWriter, strArr);
    }

    final void v0(Bundle bundle) {
        this.f3408C.q0();
        this.f3430i = 3;
        this.M = false;
        a0(bundle);
        if (!this.M) {
            throw new S("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        if (w.k0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        View view = this.f3418O;
        if (view != null) {
            Bundle bundle2 = this.f3431j;
            SparseArray<Parcelable> sparseArray = this.f3432k;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                this.f3432k = null;
            }
            if (this.f3418O != null) {
                this.f3426X.g(this.f3433l);
                this.f3433l = null;
            }
            this.M = false;
            u0(bundle2);
            if (!this.M) {
                throw new S("Fragment " + this + " did not call through to super.onViewStateRestored()");
            }
            if (this.f3418O != null) {
                this.f3426X.b(g.b.ON_CREATE);
            }
        }
        this.f3431j = null;
        this.f3408C.k();
    }

    final void w0() {
        Iterator<d> it = this.f3429a0.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f3429a0.clear();
        this.f3408C.d(this.f3407B, u(), this);
        this.f3430i = 0;
        this.M = false;
        c0(this.f3407B.j());
        if (this.M) {
            this.f3406A.u(this);
            this.f3408C.l();
        } else {
            throw new S("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public final ActivityC0219o x() {
        t<?> tVar = this.f3407B;
        if (tVar == null) {
            return null;
        }
        return (ActivityC0219o) tVar.i();
    }

    final void x0(Bundle bundle) {
        this.f3408C.q0();
        this.f3430i = 1;
        this.M = false;
        this.f3425W.a(new androidx.lifecycle.i() { // from class: androidx.fragment.app.Fragment.5
            @Override // androidx.lifecycle.i
            public final void g(androidx.lifecycle.k kVar, g.b bVar) {
                View view;
                if (bVar != g.b.ON_STOP || (view = Fragment.this.f3418O) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.f3428Z.c(bundle);
        e0(bundle);
        this.f3423U = true;
        if (this.M) {
            this.f3425W.f(g.b.ON_CREATE);
            return;
        }
        throw new S("Fragment " + this + " did not call through to super.onCreate()");
    }

    final View y() {
        b bVar = this.f3420R;
        if (bVar == null) {
            return null;
        }
        return bVar.f3448a;
    }

    void y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3408C.q0();
        this.f3444y = true;
        this.f3426X = new J(q());
        View viewG0 = g0(layoutInflater, viewGroup, bundle);
        this.f3418O = viewG0;
        if (viewG0 == null) {
            if (this.f3426X.f()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f3426X = null;
        } else {
            this.f3426X.d();
            C0384b.u(this.f3418O, this.f3426X);
            C0384b.v(this.f3418O, this.f3426X);
            C0384b.w(this.f3418O, this.f3426X);
            this.f3427Y.n(this.f3426X);
        }
    }

    public final Bundle z() {
        return this.f3436o;
    }

    final void z0() {
        this.f3408C.q();
        this.f3425W.f(g.b.ON_DESTROY);
        this.f3430i = 0;
        this.M = false;
        this.f3423U = false;
        h0();
        if (this.M) {
            return;
        }
        throw new S("Fragment " + this + " did not call through to super.onDestroy()");
    }
}
