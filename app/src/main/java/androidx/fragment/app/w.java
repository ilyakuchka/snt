package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.E;
import androidx.lifecycle.g;
import com.android.mmt.R;
import f.AbstractC0300a;
import f.C0301b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: A, reason: collision with root package name */
    private boolean f3588A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f3589B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f3590C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f3591D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f3592E;

    /* renamed from: F, reason: collision with root package name */
    private ArrayList<C0205a> f3593F;

    /* renamed from: G, reason: collision with root package name */
    private ArrayList<Boolean> f3594G;

    /* renamed from: H, reason: collision with root package name */
    private ArrayList<Fragment> f3595H;

    /* renamed from: I, reason: collision with root package name */
    private z f3596I;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3599b;
    ArrayList<C0205a> d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Fragment> f3601e;
    private OnBackPressedDispatcher g;

    /* renamed from: q, reason: collision with root package name */
    private t<?> f3611q;

    /* renamed from: r, reason: collision with root package name */
    private O.d f3612r;

    /* renamed from: s, reason: collision with root package name */
    private Fragment f3613s;

    /* renamed from: t, reason: collision with root package name */
    Fragment f3614t;

    /* renamed from: w, reason: collision with root package name */
    private O.d f3616w;

    /* renamed from: x, reason: collision with root package name */
    private O.d f3617x;

    /* renamed from: y, reason: collision with root package name */
    private O.d f3618y;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<l> f3598a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final D f3600c = new D();

    /* renamed from: f, reason: collision with root package name */
    private final u f3602f = new u(this);

    /* renamed from: h, reason: collision with root package name */
    private final androidx.activity.b f3603h = new c();

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f3604i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, Bundle> f3605j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Object> f3606k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    private Map<Fragment, HashSet<B.a>> f3607l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    private final d f3608m = new d();

    /* renamed from: n, reason: collision with root package name */
    private final v f3609n = new v(this);

    /* renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList<A> f3610o = new CopyOnWriteArrayList<>();
    int p = -1;
    private C0222s u = new e();

    /* renamed from: v, reason: collision with root package name */
    private f f3615v = new f();

    /* renamed from: z, reason: collision with root package name */
    ArrayDeque<k> f3619z = new ArrayDeque<>();

    /* renamed from: J, reason: collision with root package name */
    private Runnable f3597J = new g();

    final class a implements androidx.activity.result.b<androidx.activity.result.a> {
        a() {
        }

        @Override // androidx.activity.result.b
        public final void a(androidx.activity.result.a aVar) {
            androidx.activity.result.a aVar2 = aVar;
            k kVarPollFirst = w.this.f3619z.pollFirst();
            if (kVarPollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = kVarPollFirst.f3628i;
            int i2 = kVarPollFirst.f3629j;
            Fragment fragmentI = w.this.f3600c.i(str);
            if (fragmentI != null) {
                fragmentI.b0(i2, aVar2.b(), aVar2.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    final class b implements androidx.activity.result.b<Map<String, Boolean>> {
        b() {
        }

        @Override // androidx.activity.result.b
        @SuppressLint({"SyntheticAccessor"})
        public final void a(Map<String, Boolean> map) {
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
            }
            k kVarPollFirst = w.this.f3619z.pollFirst();
            if (kVarPollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = kVarPollFirst.f3628i;
            int i4 = kVarPollFirst.f3629j;
            Fragment fragmentI = w.this.f3600c.i(str);
            if (fragmentI != null) {
                fragmentI.o0(i4, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    final class c extends androidx.activity.b {
        c() {
        }

        @Override // androidx.activity.b
        public final void b() {
            w.this.g0();
        }
    }

    final class d {
        d() {
        }
    }

    final class e extends C0222s {
        e() {
        }

        @Override // androidx.fragment.app.C0222s
        public final Fragment a(ClassLoader classLoader, String str) {
            t<?> tVarA0 = w.this.a0();
            Context contextJ = w.this.a0().j();
            Objects.requireNonNull(tVarA0);
            return Fragment.V(contextJ, str, null);
        }
    }

    final class f implements Q {
        f() {
        }
    }

    final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            w.this.M(true);
        }
    }

    final class h implements A {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Fragment f3626i;

        h(Fragment fragment) {
            this.f3626i = fragment;
        }

        @Override // androidx.fragment.app.A
        public final void b(Fragment fragment) {
            Objects.requireNonNull(this.f3626i);
        }
    }

    final class i implements androidx.activity.result.b<androidx.activity.result.a> {
        i() {
        }

        @Override // androidx.activity.result.b
        public final void a(androidx.activity.result.a aVar) {
            androidx.activity.result.a aVar2 = aVar;
            k kVarPollFirst = w.this.f3619z.pollFirst();
            if (kVarPollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = kVarPollFirst.f3628i;
            int i2 = kVarPollFirst.f3629j;
            Fragment fragmentI = w.this.f3600c.i(str);
            if (fragmentI != null) {
                fragmentI.b0(i2, aVar2.b(), aVar2.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    static class j extends AbstractC0300a<Object, androidx.activity.result.a> {
        j() {
        }

        @Override // f.AbstractC0300a
        public final androidx.activity.result.a a(int i2, Intent intent) {
            return new androidx.activity.result.a(i2, intent);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: i, reason: collision with root package name */
        String f3628i;

        /* renamed from: j, reason: collision with root package name */
        int f3629j;

        final class a implements Parcelable.Creator<k> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public final k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final k[] newArray(int i2) {
                return new k[i2];
            }
        }

        k(Parcel parcel) {
            this.f3628i = parcel.readString();
            this.f3629j = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f3628i);
            parcel.writeInt(this.f3629j);
        }
    }

    interface l {
        boolean a(ArrayList<C0205a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class m implements l {

        /* renamed from: a, reason: collision with root package name */
        final int f3630a;

        /* renamed from: b, reason: collision with root package name */
        final int f3631b = 1;

        m(int i2) {
            this.f3630a = i2;
        }

        @Override // androidx.fragment.app.w.l
        public final boolean a(ArrayList<C0205a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = w.this.f3614t;
            if (fragment == null || this.f3630a >= 0 || !fragment.A().t0()) {
                return w.this.u0(arrayList, arrayList2, this.f3630a, this.f3631b);
            }
            return false;
        }
    }

    private void D0(Fragment fragment) {
        ViewGroup viewGroupX = X(fragment);
        if (viewGroupX == null || fragment.C() + fragment.D() + fragment.K() + fragment.L() <= 0) {
            return;
        }
        if (viewGroupX.getTag(R.id.visible_removing_fragment_view_tag) == null) {
            viewGroupX.setTag(R.id.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) viewGroupX.getTag(R.id.visible_removing_fragment_view_tag)).W0(fragment.J());
    }

    private void E(int i2) {
        try {
            this.f3599b = true;
            this.f3600c.d(i2);
            p0(i2, false);
            Iterator it = ((HashSet) h()).iterator();
            while (it.hasNext()) {
                ((N) it.next()).i();
            }
            this.f3599b = false;
            M(true);
        } catch (Throwable th) {
            this.f3599b = false;
            throw th;
        }
    }

    private void F0() {
        Iterator it = ((ArrayList) this.f3600c.k()).iterator();
        while (it.hasNext()) {
            s0((C) it.next());
        }
    }

    private void G0() {
        synchronized (this.f3598a) {
            if (!this.f3598a.isEmpty()) {
                this.f3603h.f(true);
                return;
            }
            androidx.activity.b bVar = this.f3603h;
            ArrayList<C0205a> arrayList = this.d;
            bVar.f((arrayList != null ? arrayList.size() : 0) > 0 && n0(this.f3613s));
        }
    }

    private void H() {
        if (this.f3592E) {
            this.f3592E = false;
            F0();
        }
    }

    private void J() {
        Iterator it = ((HashSet) h()).iterator();
        while (it.hasNext()) {
            ((N) it.next()).i();
        }
    }

    private void L(boolean z4) {
        if (this.f3599b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f3611q == null) {
            if (!this.f3591D) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f3611q.k().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z4 && o0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f3593F == null) {
            this.f3593F = new ArrayList<>();
            this.f3594G = new ArrayList<>();
        }
        this.f3599b = true;
        try {
            Q(null, null);
        } finally {
            this.f3599b = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O(ArrayList<C0205a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i4) {
        ViewGroup viewGroup;
        int i5;
        int i6;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z4 = arrayList.get(i2).p;
        ArrayList<Fragment> arrayList4 = this.f3595H;
        if (arrayList4 == null) {
            this.f3595H = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.f3595H.addAll(this.f3600c.n());
        Fragment fragment = this.f3614t;
        int i7 = i2;
        boolean z5 = false;
        while (true) {
            int i8 = 1;
            if (i7 >= i4) {
                this.f3595H.clear();
                if (!z4 && this.p >= 1) {
                    for (int i9 = i2; i9 < i4; i9++) {
                        Iterator<E.a> it = arrayList.get(i9).f3383a.iterator();
                        while (it.hasNext()) {
                            Fragment fragment2 = it.next().f3397b;
                            if (fragment2 != null && fragment2.f3406A != null) {
                                this.f3600c.p(i(fragment2));
                            }
                        }
                    }
                }
                for (int i10 = i2; i10 < i4; i10++) {
                    C0205a c0205a = arrayList.get(i10);
                    if (arrayList2.get(i10).booleanValue()) {
                        c0205a.q(-1);
                        c0205a.u();
                    } else {
                        c0205a.q(1);
                        c0205a.t();
                    }
                }
                boolean zBooleanValue = arrayList2.get(i4 - 1).booleanValue();
                for (int i11 = i2; i11 < i4; i11++) {
                    C0205a c0205a2 = arrayList.get(i11);
                    if (zBooleanValue) {
                        for (int size = c0205a2.f3383a.size() - 1; size >= 0; size--) {
                            Fragment fragment3 = c0205a2.f3383a.get(size).f3397b;
                            if (fragment3 != null) {
                                i(fragment3).l();
                            }
                        }
                    } else {
                        Iterator<E.a> it2 = c0205a2.f3383a.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment4 = it2.next().f3397b;
                            if (fragment4 != null) {
                                i(fragment4).l();
                            }
                        }
                    }
                }
                p0(this.p, true);
                HashSet hashSet = new HashSet();
                for (int i12 = i2; i12 < i4; i12++) {
                    Iterator<E.a> it3 = arrayList.get(i12).f3383a.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment5 = it3.next().f3397b;
                        if (fragment5 != null && (viewGroup = fragment5.f3417N) != null) {
                            hashSet.add(N.m(viewGroup, e0()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    N n2 = (N) it4.next();
                    n2.d = zBooleanValue;
                    n2.n();
                    n2.g();
                }
                for (int i13 = i2; i13 < i4; i13++) {
                    C0205a c0205a3 = arrayList.get(i13);
                    if (arrayList2.get(i13).booleanValue() && c0205a3.f3497s >= 0) {
                        c0205a3.f3497s = -1;
                    }
                    Objects.requireNonNull(c0205a3);
                }
                return;
            }
            C0205a c0205a4 = arrayList.get(i7);
            int i14 = 3;
            if (arrayList3.get(i7).booleanValue()) {
                int i15 = 1;
                ArrayList<Fragment> arrayList5 = this.f3595H;
                int size2 = c0205a4.f3383a.size() - 1;
                while (size2 >= 0) {
                    E.a aVar = c0205a4.f3383a.get(size2);
                    int i16 = aVar.f3396a;
                    if (i16 != i15) {
                        if (i16 != 3) {
                            switch (i16) {
                                case 6:
                                    arrayList5.add(aVar.f3397b);
                                    break;
                                case 8:
                                    fragment = null;
                                    break;
                                case 9:
                                    fragment = aVar.f3397b;
                                    break;
                                case 10:
                                    aVar.f3401h = aVar.g;
                                    break;
                            }
                        }
                        size2--;
                        i15 = 1;
                    }
                    arrayList5.remove(aVar.f3397b);
                    size2--;
                    i15 = 1;
                }
            } else {
                ArrayList<Fragment> arrayList6 = this.f3595H;
                int i17 = 0;
                while (i17 < c0205a4.f3383a.size()) {
                    E.a aVar2 = c0205a4.f3383a.get(i17);
                    int i18 = aVar2.f3396a;
                    if (i18 != i8) {
                        if (i18 != 2) {
                            if (i18 == i14 || i18 == 6) {
                                arrayList6.remove(aVar2.f3397b);
                                Fragment fragment6 = aVar2.f3397b;
                                if (fragment6 == fragment) {
                                    c0205a4.f3383a.add(i17, new E.a(9, fragment6));
                                    i17++;
                                    i5 = 1;
                                    fragment = null;
                                }
                            } else if (i18 == 7) {
                                i5 = 1;
                            } else if (i18 == 8) {
                                c0205a4.f3383a.add(i17, new E.a(9, fragment));
                                i17++;
                                fragment = aVar2.f3397b;
                            }
                            i5 = 1;
                        } else {
                            Fragment fragment7 = aVar2.f3397b;
                            int i19 = fragment7.f3411F;
                            int size3 = arrayList6.size() - 1;
                            boolean z6 = false;
                            while (size3 >= 0) {
                                Fragment fragment8 = arrayList6.get(size3);
                                if (fragment8.f3411F != i19) {
                                    i6 = i19;
                                } else if (fragment8 == fragment7) {
                                    i6 = i19;
                                    z6 = true;
                                } else {
                                    if (fragment8 == fragment) {
                                        i6 = i19;
                                        c0205a4.f3383a.add(i17, new E.a(9, fragment8));
                                        i17++;
                                        fragment = null;
                                    } else {
                                        i6 = i19;
                                    }
                                    E.a aVar3 = new E.a(3, fragment8);
                                    aVar3.f3398c = aVar2.f3398c;
                                    aVar3.f3399e = aVar2.f3399e;
                                    aVar3.d = aVar2.d;
                                    aVar3.f3400f = aVar2.f3400f;
                                    c0205a4.f3383a.add(i17, aVar3);
                                    arrayList6.remove(fragment8);
                                    i17++;
                                }
                                size3--;
                                i19 = i6;
                            }
                            if (z6) {
                                c0205a4.f3383a.remove(i17);
                                i17--;
                                i5 = 1;
                            } else {
                                i5 = 1;
                                aVar2.f3396a = 1;
                                arrayList6.add(fragment7);
                            }
                        }
                        i17 += i5;
                        i8 = i5;
                        i14 = 3;
                    } else {
                        i5 = i8;
                    }
                    arrayList6.add(aVar2.f3397b);
                    i17 += i5;
                    i8 = i5;
                    i14 = 3;
                }
            }
            z5 = z5 || c0205a4.g;
            i7++;
            arrayList3 = arrayList2;
        }
    }

    private void Q(ArrayList<C0205a> arrayList, ArrayList<Boolean> arrayList2) {
    }

    private void V() {
        Iterator it = ((HashSet) h()).iterator();
        while (it.hasNext()) {
            N n2 = (N) it.next();
            if (n2.f3487e) {
                n2.f3487e = false;
                n2.g();
            }
        }
    }

    private ViewGroup X(Fragment fragment) {
        ViewGroup viewGroup = fragment.f3417N;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.f3411F > 0 && this.f3612r.g()) {
            View viewD = this.f3612r.d(fragment.f3411F);
            if (viewD instanceof ViewGroup) {
                return (ViewGroup) viewD;
            }
        }
        return null;
    }

    private void g() {
        this.f3599b = false;
        this.f3594G.clear();
        this.f3593F.clear();
    }

    private Set<N> h() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) this.f3600c.k()).iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((C) it.next()).k().f3417N;
            if (viewGroup != null) {
                hashSet.add(N.m(viewGroup, e0()));
            }
        }
        return hashSet;
    }

    static boolean k0(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    private boolean l0(Fragment fragment) {
        boolean z4;
        if (fragment.f3416K && fragment.L) {
            return true;
        }
        w wVar = fragment.f3408C;
        Iterator it = ((ArrayList) wVar.f3600c.l()).iterator();
        boolean zL0 = false;
        while (true) {
            if (!it.hasNext()) {
                z4 = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                zL0 = wVar.l0(fragment2);
            }
            if (zL0) {
                z4 = true;
                break;
            }
        }
        return z4;
    }

    private void w0(ArrayList<C0205a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        Q(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i4 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).p) {
                if (i4 != i2) {
                    O(arrayList, arrayList2, i4, i2);
                }
                i4 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i4 < size && arrayList2.get(i4).booleanValue() && !arrayList.get(i4).p) {
                        i4++;
                    }
                }
                O(arrayList, arrayList2, i2, i4);
                i2 = i4 - 1;
            }
            i2++;
        }
        if (i4 != size) {
            O(arrayList, arrayList2, i4, size);
        }
    }

    private void x(Fragment fragment) {
        if (fragment == null || !fragment.equals(R(fragment.f3435n))) {
            return;
        }
        fragment.I0();
    }

    final boolean A(Menu menu) {
        boolean z4 = false;
        if (this.p < 1) {
            return false;
        }
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null && m0(fragment) && fragment.H0(menu)) {
                z4 = true;
            }
        }
        return z4;
    }

    final void A0(Fragment fragment, boolean z4) {
        ViewGroup viewGroupX = X(fragment);
        if (viewGroupX == null || !(viewGroupX instanceof C0221q)) {
            return;
        }
        ((C0221q) viewGroupX).b(!z4);
    }

    final void B() {
        G0();
        x(this.f3614t);
    }

    final void B0(Fragment fragment, g.c cVar) {
        if (fragment.equals(R(fragment.f3435n)) && (fragment.f3407B == null || fragment.f3406A == this)) {
            fragment.f3424V = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    final void C() {
        this.f3589B = false;
        this.f3590C = false;
        this.f3596I.l(false);
        E(7);
    }

    final void C0(Fragment fragment) {
        if (fragment == null || (fragment.equals(R(fragment.f3435n)) && (fragment.f3407B == null || fragment.f3406A == this))) {
            Fragment fragment2 = this.f3614t;
            this.f3614t = fragment;
            x(fragment2);
            x(this.f3614t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    final void D() {
        this.f3589B = false;
        this.f3590C = false;
        this.f3596I.l(false);
        E(5);
    }

    final void E0(Fragment fragment) {
        if (k0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f3413H) {
            fragment.f3413H = false;
            fragment.f3421S = !fragment.f3421S;
        }
    }

    final void F() {
        this.f3590C = true;
        this.f3596I.l(true);
        E(4);
    }

    final void G() {
        E(2);
    }

    public final void I(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strC = D2.e.c(str, "    ");
        this.f3600c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f3601e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = this.f3601e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<C0205a> arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                C0205a c0205a = this.d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(c0205a.toString());
                c0205a.s(strC, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3604i.get());
        synchronized (this.f3598a) {
            int size3 = this.f3598a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i5 = 0; i5 < size3; i5++) {
                    l lVar = this.f3598a.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(lVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3611q);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3612r);
        if (this.f3613s != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3613s);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.p);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3589B);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3590C);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3591D);
        if (this.f3588A) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3588A);
        }
    }

    final void K(l lVar, boolean z4) {
        if (!z4) {
            if (this.f3611q == null) {
                if (!this.f3591D) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (o0()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f3598a) {
            if (this.f3611q == null) {
                if (!z4) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f3598a.add(lVar);
                z0();
            }
        }
    }

    final boolean M(boolean z4) {
        boolean zA;
        L(z4);
        boolean z5 = false;
        while (true) {
            ArrayList<C0205a> arrayList = this.f3593F;
            ArrayList<Boolean> arrayList2 = this.f3594G;
            synchronized (this.f3598a) {
                if (this.f3598a.isEmpty()) {
                    zA = false;
                } else {
                    int size = this.f3598a.size();
                    zA = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        zA |= this.f3598a.get(i2).a(arrayList, arrayList2);
                    }
                    this.f3598a.clear();
                    this.f3611q.k().removeCallbacks(this.f3597J);
                }
            }
            if (!zA) {
                G0();
                H();
                this.f3600c.b();
                return z5;
            }
            this.f3599b = true;
            try {
                w0(this.f3593F, this.f3594G);
                g();
                z5 = true;
            } catch (Throwable th) {
                g();
                throw th;
            }
        }
    }

    final void N(l lVar) {
        if (this.f3611q == null || this.f3591D) {
            return;
        }
        L(true);
        ((C0205a) lVar).a(this.f3593F, this.f3594G);
        this.f3599b = true;
        try {
            w0(this.f3593F, this.f3594G);
            g();
            G0();
            H();
            this.f3600c.b();
        } catch (Throwable th) {
            g();
            throw th;
        }
    }

    public final boolean P() {
        boolean zM = M(true);
        V();
        return zM;
    }

    final Fragment R(String str) {
        return this.f3600c.f(str);
    }

    public final Fragment S(int i2) {
        return this.f3600c.g(i2);
    }

    public final Fragment T(String str) {
        return this.f3600c.h(str);
    }

    final Fragment U(String str) {
        return this.f3600c.i(str);
    }

    final O.d W() {
        return this.f3612r;
    }

    public final C0222s Y() {
        Fragment fragment = this.f3613s;
        return fragment != null ? fragment.f3406A.Y() : this.u;
    }

    public final List<Fragment> Z() {
        return this.f3600c.n();
    }

    final t<?> a0() {
        return this.f3611q;
    }

    final C b(Fragment fragment) {
        if (k0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        C cI = i(fragment);
        fragment.f3406A = this;
        this.f3600c.p(cI);
        if (!fragment.f3414I) {
            this.f3600c.a(fragment);
            fragment.u = false;
            if (fragment.f3418O == null) {
                fragment.f3421S = false;
            }
            if (l0(fragment)) {
                this.f3588A = true;
            }
        }
        return cI;
    }

    final LayoutInflater.Factory2 b0() {
        return this.f3602f;
    }

    final int c() {
        return this.f3604i.getAndIncrement();
    }

    final v c0() {
        return this.f3609n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    final void d(t<?> tVar, O.d dVar, Fragment fragment) {
        if (this.f3611q != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f3611q = tVar;
        this.f3612r = dVar;
        this.f3613s = fragment;
        if (fragment != null) {
            this.f3610o.add(new h(fragment));
        } else if (tVar instanceof A) {
            this.f3610o.add((A) tVar);
        }
        if (this.f3613s != null) {
            G0();
        }
        if (tVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) tVar;
            OnBackPressedDispatcher onBackPressedDispatcherC = cVar.c();
            this.g = onBackPressedDispatcherC;
            androidx.lifecycle.k kVar = cVar;
            if (fragment != null) {
                kVar = fragment;
            }
            onBackPressedDispatcherC.a(kVar, this.f3603h);
        }
        if (fragment != null) {
            this.f3596I = fragment.f3406A.f3596I.f(fragment);
        } else if (tVar instanceof androidx.lifecycle.x) {
            this.f3596I = z.g(((androidx.lifecycle.x) tVar).q());
        } else {
            this.f3596I = new z(false);
        }
        this.f3596I.l(o0());
        this.f3600c.x(this.f3596I);
        Object obj = this.f3611q;
        if (obj instanceof androidx.activity.result.d) {
            androidx.activity.result.c cVarF = ((androidx.activity.result.d) obj).f();
            String strC = D2.e.c("FragmentManager:", fragment != null ? C2.c.b(new StringBuilder(), fragment.f3435n, ":") : "");
            this.f3616w = cVarF.e(D2.e.c(strC, "StartActivityForResult"), new C0301b(1), new i());
            this.f3617x = cVarF.e(D2.e.c(strC, "StartIntentSenderForResult"), new j(), new a());
            this.f3618y = cVarF.e(D2.e.c(strC, "RequestPermissions"), new C0301b(0), new b());
        }
    }

    final Fragment d0() {
        return this.f3613s;
    }

    final void e(Fragment fragment) {
        if (k0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f3414I) {
            fragment.f3414I = false;
            if (fragment.f3440t) {
                return;
            }
            this.f3600c.a(fragment);
            if (k0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (l0(fragment)) {
                this.f3588A = true;
            }
        }
    }

    final Q e0() {
        Fragment fragment = this.f3613s;
        return fragment != null ? fragment.f3406A.e0() : this.f3615v;
    }

    public final E f() {
        return new C0205a(this);
    }

    final androidx.lifecycle.w f0(Fragment fragment) {
        return this.f3596I.i(fragment);
    }

    final void g0() {
        M(true);
        if (this.f3603h.c()) {
            t0();
        } else {
            this.g.b();
        }
    }

    final void h0(Fragment fragment) {
        if (k0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.f3413H) {
            return;
        }
        fragment.f3413H = true;
        fragment.f3421S = true ^ fragment.f3421S;
        D0(fragment);
    }

    final C i(Fragment fragment) {
        C cM = this.f3600c.m(fragment.f3435n);
        if (cM != null) {
            return cM;
        }
        C c2 = new C(this.f3609n, this.f3600c, fragment);
        c2.n(this.f3611q.j().getClassLoader());
        c2.r(this.p);
        return c2;
    }

    final void i0(Fragment fragment) {
        if (fragment.f3440t && l0(fragment)) {
            this.f3588A = true;
        }
    }

    final void j(Fragment fragment) {
        if (k0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.f3414I) {
            return;
        }
        fragment.f3414I = true;
        if (fragment.f3440t) {
            if (k0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f3600c.s(fragment);
            if (l0(fragment)) {
                this.f3588A = true;
            }
            D0(fragment);
        }
    }

    public final boolean j0() {
        return this.f3591D;
    }

    final void k() {
        this.f3589B = false;
        this.f3590C = false;
        this.f3596I.l(false);
        E(4);
    }

    final void l() {
        this.f3589B = false;
        this.f3590C = false;
        this.f3596I.l(false);
        E(0);
    }

    final void m(Configuration configuration) {
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null) {
                fragment.onConfigurationChanged(configuration);
                fragment.f3408C.m(configuration);
            }
        }
    }

    final boolean m0(Fragment fragment) {
        w wVar;
        if (fragment == null) {
            return true;
        }
        return fragment.L && ((wVar = fragment.f3406A) == null || wVar.m0(fragment.f3409D));
    }

    final boolean n(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null) {
                if (!fragment.f3413H ? fragment.d0(menuItem) ? true : fragment.f3408C.n(menuItem) : false) {
                    return true;
                }
            }
        }
        return false;
    }

    final boolean n0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        w wVar = fragment.f3406A;
        return fragment.equals(wVar.f3614t) && n0(wVar.f3613s);
    }

    final void o() {
        this.f3589B = false;
        this.f3590C = false;
        this.f3596I.l(false);
        E(1);
    }

    public final boolean o0() {
        return this.f3589B || this.f3590C;
    }

    final boolean p(Menu menu, MenuInflater menuInflater) {
        boolean zP;
        boolean z4;
        if (this.p < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z5 = false;
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null && m0(fragment)) {
                if (fragment.f3413H) {
                    zP = false;
                } else {
                    if (fragment.f3416K && fragment.L) {
                        fragment.f0();
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zP = z4 | fragment.f3408C.p(menu, menuInflater);
                }
                if (zP) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    z5 = true;
                }
            }
        }
        if (this.f3601e != null) {
            for (int i2 = 0; i2 < this.f3601e.size(); i2++) {
                Fragment fragment2 = this.f3601e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    Objects.requireNonNull(fragment2);
                }
            }
        }
        this.f3601e = arrayList;
        return z5;
    }

    final void p0(int i2, boolean z4) {
        t<?> tVar;
        if (this.f3611q == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z4 || i2 != this.p) {
            this.p = i2;
            this.f3600c.r();
            F0();
            if (this.f3588A && (tVar = this.f3611q) != null && this.p == 7) {
                tVar.o();
                this.f3588A = false;
            }
        }
    }

    final void q() {
        this.f3591D = true;
        M(true);
        J();
        E(-1);
        this.f3611q = null;
        this.f3612r = null;
        this.f3613s = null;
        if (this.g != null) {
            this.f3603h.d();
            this.g = null;
        }
        O.d dVar = this.f3616w;
        if (dVar != null) {
            dVar.h();
            this.f3617x.h();
            this.f3618y.h();
        }
    }

    final void q0() {
        if (this.f3611q == null) {
            return;
        }
        this.f3589B = false;
        this.f3590C = false;
        this.f3596I.l(false);
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null) {
                fragment.f3408C.q0();
            }
        }
    }

    final void r() {
        E(1);
    }

    final void r0(C0221q c0221q) {
        View view;
        Iterator it = ((ArrayList) this.f3600c.k()).iterator();
        while (it.hasNext()) {
            C c2 = (C) it.next();
            Fragment fragmentK = c2.k();
            if (fragmentK.f3411F == c0221q.getId() && (view = fragmentK.f3418O) != null && view.getParent() == null) {
                fragmentK.f3417N = c0221q;
                c2.b();
            }
        }
    }

    final void s() {
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null) {
                fragment.D0();
            }
        }
    }

    final void s0(C c2) {
        Fragment fragmentK = c2.k();
        if (fragmentK.P) {
            if (this.f3599b) {
                this.f3592E = true;
            } else {
                fragmentK.P = false;
                c2.l();
            }
        }
    }

    final void t(boolean z4) {
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null) {
                fragment.E0(z4);
            }
        }
    }

    public final boolean t0() {
        M(false);
        L(true);
        Fragment fragment = this.f3614t;
        if (fragment != null && fragment.A().t0()) {
            return true;
        }
        boolean zU0 = u0(this.f3593F, this.f3594G, -1, 0);
        if (zU0) {
            this.f3599b = true;
            try {
                w0(this.f3593F, this.f3594G);
            } finally {
                g();
            }
        }
        G0();
        H();
        this.f3600c.b();
        return zU0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f3613s;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f3613s)));
            sb.append("}");
        } else {
            t<?> tVar = this.f3611q;
            if (tVar != null) {
                sb.append(tVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f3611q)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    final void u(Fragment fragment) {
        Iterator<A> it = this.f3610o.iterator();
        while (it.hasNext()) {
            it.next().b(fragment);
        }
    }

    final boolean u0(ArrayList arrayList, ArrayList arrayList2, int i2, int i4) {
        C0205a c0205a;
        ArrayList<C0205a> arrayList3 = this.d;
        if (arrayList3 == null) {
            return false;
        }
        if (i2 >= 0 || (i4 & 1) != 0) {
            int i5 = -1;
            if (i2 >= 0) {
                int size = arrayList3.size() - 1;
                while (size >= 0) {
                    C0205a c0205a2 = this.d.get(size);
                    if (i2 >= 0 && i2 == c0205a2.f3497s) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i4 & 1) != 0) {
                    do {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        c0205a = this.d.get(size);
                        if (i2 < 0) {
                            break;
                        }
                    } while (i2 == c0205a.f3497s);
                }
                i5 = size;
            }
            if (i5 == this.d.size() - 1) {
                return false;
            }
            for (int size2 = this.d.size() - 1; size2 > i5; size2--) {
                arrayList.add(this.d.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
        } else {
            int size3 = arrayList3.size() - 1;
            if (size3 < 0) {
                return false;
            }
            arrayList.add(this.d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    final boolean v(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null) {
                if (!fragment.f3413H ? fragment.f3408C.v(menuItem) : false) {
                    return true;
                }
            }
        }
        return false;
    }

    final void v0(Fragment fragment) {
        if (k0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f3445z);
        }
        boolean z4 = !fragment.Y();
        if (!fragment.f3414I || z4) {
            this.f3600c.s(fragment);
            if (l0(fragment)) {
                this.f3588A = true;
            }
            fragment.u = true;
            D0(fragment);
        }
    }

    final void w(Menu menu) {
        if (this.p < 1) {
            return;
        }
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null && !fragment.f3413H) {
                fragment.f3408C.w(menu);
            }
        }
    }

    final void x0(Parcelable parcelable) {
        C c2;
        if (parcelable == null) {
            return;
        }
        y yVar = (y) parcelable;
        if (yVar.f3633i == null) {
            return;
        }
        this.f3600c.t();
        Iterator<B> it = yVar.f3633i.iterator();
        while (it.hasNext()) {
            B next = it.next();
            if (next != null) {
                Fragment fragmentE = this.f3596I.e(next.f3365j);
                if (fragmentE != null) {
                    if (k0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentE);
                    }
                    c2 = new C(this.f3609n, this.f3600c, fragmentE, next);
                } else {
                    c2 = new C(this.f3609n, this.f3600c, this.f3611q.j().getClassLoader(), Y(), next);
                }
                Fragment fragmentK = c2.k();
                fragmentK.f3406A = this;
                if (k0(2)) {
                    StringBuilder sbD = D2.e.d("restoreSaveState: active (");
                    sbD.append(fragmentK.f3435n);
                    sbD.append("): ");
                    sbD.append(fragmentK);
                    Log.v("FragmentManager", sbD.toString());
                }
                c2.n(this.f3611q.j().getClassLoader());
                this.f3600c.p(c2);
                c2.r(this.p);
            }
        }
        Iterator it2 = ((ArrayList) this.f3596I.h()).iterator();
        while (it2.hasNext()) {
            Fragment fragment = (Fragment) it2.next();
            if (!this.f3600c.c(fragment.f3435n)) {
                if (k0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + yVar.f3633i);
                }
                this.f3596I.k(fragment);
                fragment.f3406A = this;
                C c4 = new C(this.f3609n, this.f3600c, fragment);
                c4.r(1);
                c4.l();
                fragment.u = true;
                c4.l();
            }
        }
        this.f3600c.u(yVar.f3634j);
        Fragment fragment2 = null;
        if (yVar.f3635k != null) {
            this.d = new ArrayList<>(yVar.f3635k.length);
            int i2 = 0;
            while (true) {
                C0206b[] c0206bArr = yVar.f3635k;
                if (i2 >= c0206bArr.length) {
                    break;
                }
                C0206b c0206b = c0206bArr[i2];
                Objects.requireNonNull(c0206b);
                C0205a c0205a = new C0205a(this);
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int[] iArr = c0206b.f3498i;
                    if (i4 >= iArr.length) {
                        break;
                    }
                    E.a aVar = new E.a();
                    int i6 = i4 + 1;
                    aVar.f3396a = iArr[i4];
                    if (k0(2)) {
                        Log.v("FragmentManager", "Instantiate " + c0205a + " op #" + i5 + " base fragment #" + c0206b.f3498i[i6]);
                    }
                    String str = c0206b.f3499j.get(i5);
                    if (str != null) {
                        aVar.f3397b = R(str);
                    } else {
                        aVar.f3397b = fragment2;
                    }
                    aVar.g = g.c.values()[c0206b.f3500k[i5]];
                    aVar.f3401h = g.c.values()[c0206b.f3501l[i5]];
                    int[] iArr2 = c0206b.f3498i;
                    int i7 = i6 + 1;
                    int i8 = iArr2[i6];
                    aVar.f3398c = i8;
                    int i9 = i7 + 1;
                    int i10 = iArr2[i7];
                    aVar.d = i10;
                    int i11 = i9 + 1;
                    int i12 = iArr2[i9];
                    aVar.f3399e = i12;
                    int i13 = iArr2[i11];
                    aVar.f3400f = i13;
                    c0205a.f3384b = i8;
                    c0205a.f3385c = i10;
                    c0205a.d = i12;
                    c0205a.f3386e = i13;
                    c0205a.d(aVar);
                    i5++;
                    fragment2 = null;
                    i4 = i11 + 1;
                }
                c0205a.f3387f = c0206b.f3502m;
                c0205a.f3389i = c0206b.f3503n;
                c0205a.f3497s = c0206b.f3504o;
                c0205a.g = true;
                c0205a.f3390j = c0206b.p;
                c0205a.f3391k = c0206b.f3505q;
                c0205a.f3392l = c0206b.f3506r;
                c0205a.f3393m = c0206b.f3507s;
                c0205a.f3394n = c0206b.f3508t;
                c0205a.f3395o = c0206b.u;
                c0205a.p = c0206b.f3509v;
                c0205a.q(1);
                if (k0(2)) {
                    StringBuilder sbC = C2.c.c("restoreAllState: back stack #", i2, " (index ");
                    sbC.append(c0205a.f3497s);
                    sbC.append("): ");
                    sbC.append(c0205a);
                    Log.v("FragmentManager", sbC.toString());
                    PrintWriter printWriter = new PrintWriter(new K());
                    c0205a.s("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(c0205a);
                i2++;
                fragment2 = null;
            }
        } else {
            this.d = null;
        }
        this.f3604i.set(yVar.f3636l);
        String str2 = yVar.f3637m;
        if (str2 != null) {
            Fragment fragmentR = R(str2);
            this.f3614t = fragmentR;
            x(fragmentR);
        }
        ArrayList<String> arrayList = yVar.f3638n;
        if (arrayList != null) {
            for (int i14 = 0; i14 < arrayList.size(); i14++) {
                Bundle bundle = yVar.f3639o.get(i14);
                bundle.setClassLoader(this.f3611q.j().getClassLoader());
                this.f3605j.put(arrayList.get(i14), bundle);
            }
        }
        this.f3619z = new ArrayDeque<>(yVar.p);
    }

    final void y() {
        E(5);
    }

    final Parcelable y0() {
        int size;
        V();
        J();
        M(true);
        this.f3589B = true;
        this.f3596I.l(true);
        ArrayList<B> arrayListV = this.f3600c.v();
        C0206b[] c0206bArr = null;
        if (arrayListV.isEmpty()) {
            if (k0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> arrayListW = this.f3600c.w();
        ArrayList<C0205a> arrayList = this.d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            c0206bArr = new C0206b[size];
            for (int i2 = 0; i2 < size; i2++) {
                c0206bArr[i2] = new C0206b(this.d.get(i2));
                if (k0(2)) {
                    StringBuilder sbC = C2.c.c("saveAllState: adding back stack #", i2, ": ");
                    sbC.append(this.d.get(i2));
                    Log.v("FragmentManager", sbC.toString());
                }
            }
        }
        y yVar = new y();
        yVar.f3633i = arrayListV;
        yVar.f3634j = arrayListW;
        yVar.f3635k = c0206bArr;
        yVar.f3636l = this.f3604i.get();
        Fragment fragment = this.f3614t;
        if (fragment != null) {
            yVar.f3637m = fragment.f3435n;
        }
        yVar.f3638n.addAll(this.f3605j.keySet());
        yVar.f3639o.addAll(this.f3605j.values());
        yVar.p = new ArrayList<>(this.f3619z);
        return yVar;
    }

    final void z(boolean z4) {
        for (Fragment fragment : this.f3600c.n()) {
            if (fragment != null) {
                fragment.G0(z4);
            }
        }
    }

    final void z0() {
        synchronized (this.f3598a) {
            if (this.f3598a.size() == 1) {
                this.f3611q.k().removeCallbacks(this.f3597J);
                this.f3611q.k().post(this.f3597J);
                G0();
            }
        }
    }
}
