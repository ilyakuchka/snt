package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class D {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Fragment> f3380a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, C> f3381b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private z f3382c;

    D() {
    }

    final void a(Fragment fragment) {
        if (this.f3380a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f3380a) {
            this.f3380a.add(fragment);
        }
        fragment.f3440t = true;
    }

    final void b() {
        this.f3381b.values().removeAll(Collections.singleton(null));
    }

    final boolean c(String str) {
        return this.f3381b.get(str) != null;
    }

    final void d(int i2) {
        for (C c2 : this.f3381b.values()) {
            if (c2 != null) {
                c2.r(i2);
            }
        }
    }

    final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String strC = D2.e.c(str, "    ");
        if (!this.f3381b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (C c2 : this.f3381b.values()) {
                printWriter.print(str);
                if (c2 != null) {
                    Fragment fragmentK = c2.k();
                    printWriter.println(fragmentK);
                    fragmentK.v(strC, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f3380a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.f3380a.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    final Fragment f(String str) {
        C c2 = this.f3381b.get(str);
        if (c2 != null) {
            return c2.k();
        }
        return null;
    }

    final Fragment g(int i2) {
        for (int size = this.f3380a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3380a.get(size);
            if (fragment != null && fragment.f3410E == i2) {
                return fragment;
            }
        }
        for (C c2 : this.f3381b.values()) {
            if (c2 != null) {
                Fragment fragmentK = c2.k();
                if (fragmentK.f3410E == i2) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    final Fragment h(String str) {
        if (str != null) {
            for (int size = this.f3380a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f3380a.get(size);
                if (fragment != null && str.equals(fragment.f3412G)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (C c2 : this.f3381b.values()) {
            if (c2 != null) {
                Fragment fragmentK = c2.k();
                if (str.equals(fragmentK.f3412G)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    final Fragment i(String str) {
        for (C c2 : this.f3381b.values()) {
            if (c2 != null) {
                Fragment fragmentK = c2.k();
                if (!str.equals(fragmentK.f3435n)) {
                    fragmentK = fragmentK.f3408C.U(str);
                }
                if (fragmentK != null) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    final int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.f3417N;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f3380a.indexOf(fragment);
        for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = this.f3380a.get(i2);
            if (fragment2.f3417N == viewGroup && (view2 = fragment2.f3418O) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f3380a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f3380a.get(iIndexOf);
            if (fragment3.f3417N == viewGroup && (view = fragment3.f3418O) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    final List<C> k() {
        ArrayList arrayList = new ArrayList();
        for (C c2 : this.f3381b.values()) {
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        return arrayList;
    }

    final List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (C c2 : this.f3381b.values()) {
            if (c2 != null) {
                arrayList.add(c2.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    final C m(String str) {
        return this.f3381b.get(str);
    }

    final List<Fragment> n() {
        ArrayList arrayList;
        if (this.f3380a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3380a) {
            arrayList = new ArrayList(this.f3380a);
        }
        return arrayList;
    }

    final z o() {
        return this.f3382c;
    }

    final void p(C c2) {
        Fragment fragmentK = c2.k();
        if (c(fragmentK.f3435n)) {
            return;
        }
        this.f3381b.put(fragmentK.f3435n, c2);
        if (w.k0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    final void q(C c2) {
        Fragment fragmentK = c2.k();
        if (fragmentK.f3415J) {
            this.f3382c.k(fragmentK);
        }
        if (this.f3381b.put(fragmentK.f3435n, null) != null && w.k0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    final void r() {
        Iterator<Fragment> it = this.f3380a.iterator();
        while (it.hasNext()) {
            C c2 = this.f3381b.get(it.next().f3435n);
            if (c2 != null) {
                c2.l();
            }
        }
        for (C c4 : this.f3381b.values()) {
            if (c4 != null) {
                c4.l();
                Fragment fragmentK = c4.k();
                if (fragmentK.u && !fragmentK.Y()) {
                    q(c4);
                }
            }
        }
    }

    final void s(Fragment fragment) {
        synchronized (this.f3380a) {
            this.f3380a.remove(fragment);
        }
        fragment.f3440t = false;
    }

    final void t() {
        this.f3381b.clear();
    }

    final void u(List<String> list) {
        this.f3380a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException(C2.c.a("No instantiated fragment for (", str, ")"));
                }
                if (w.k0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    final ArrayList<B> v() {
        ArrayList<B> arrayList = new ArrayList<>(this.f3381b.size());
        for (C c2 : this.f3381b.values()) {
            if (c2 != null) {
                Fragment fragmentK = c2.k();
                B bP = c2.p();
                arrayList.add(bP);
                if (w.k0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + bP.u);
                }
            }
        }
        return arrayList;
    }

    final ArrayList<String> w() {
        synchronized (this.f3380a) {
            if (this.f3380a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f3380a.size());
            Iterator<Fragment> it = this.f3380a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.f3435n);
                if (w.k0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f3435n + "): " + next);
                }
            }
            return arrayList;
        }
    }

    final void x(z zVar) {
        this.f3382c = zVar;
    }
}
