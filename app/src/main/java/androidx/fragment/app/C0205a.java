package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.E;
import androidx.fragment.app.w;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0205a extends E implements w.l {

    /* renamed from: q, reason: collision with root package name */
    final w f3495q;

    /* renamed from: r, reason: collision with root package name */
    boolean f3496r;

    /* renamed from: s, reason: collision with root package name */
    int f3497s;

    C0205a(w wVar) {
        wVar.Y();
        if (wVar.a0() != null) {
            wVar.a0().j().getClassLoader();
        }
        this.f3497s = -1;
        this.f3495q = wVar;
    }

    @Override // androidx.fragment.app.w.l
    public final boolean a(ArrayList<C0205a> arrayList, ArrayList<Boolean> arrayList2) {
        if (w.k0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        w wVar = this.f3495q;
        if (wVar.d == null) {
            wVar.d = new ArrayList<>();
        }
        wVar.d.add(this);
        return true;
    }

    @Override // androidx.fragment.app.E
    public final int g() {
        return r(false);
    }

    @Override // androidx.fragment.app.E
    public final int h() {
        return r(true);
    }

    @Override // androidx.fragment.app.E
    public final E i(Fragment fragment) {
        w wVar = fragment.f3406A;
        if (wVar == null || wVar == this.f3495q) {
            d(new E.a(6, fragment));
            return this;
        }
        StringBuilder sbD = D2.e.d("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
        sbD.append(fragment.toString());
        sbD.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbD.toString());
    }

    @Override // androidx.fragment.app.E
    final void k(int i2, Fragment fragment, String str, int i4) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder sbD = D2.e.d("Fragment ");
            sbD.append(cls.getCanonicalName());
            sbD.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(sbD.toString());
        }
        if (str != null) {
            String str2 = fragment.f3412G;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f3412G + " now " + str);
            }
            fragment.f3412G = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i5 = fragment.f3410E;
            if (i5 != 0 && i5 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f3410E + " now " + i2);
            }
            fragment.f3410E = i2;
            fragment.f3411F = i2;
        }
        d(new E.a(i4, fragment));
        fragment.f3406A = this.f3495q;
    }

    @Override // androidx.fragment.app.E
    public final E l(Fragment fragment) {
        w wVar = fragment.f3406A;
        if (wVar == null || wVar == this.f3495q) {
            d(new E.a(4, fragment));
            return this;
        }
        StringBuilder sbD = D2.e.d("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
        sbD.append(fragment.toString());
        sbD.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbD.toString());
    }

    @Override // androidx.fragment.app.E
    public final boolean m() {
        return this.f3383a.isEmpty();
    }

    @Override // androidx.fragment.app.E
    public final E n(Fragment fragment) {
        w wVar = fragment.f3406A;
        if (wVar == null || wVar == this.f3495q) {
            d(new E.a(3, fragment));
            return this;
        }
        StringBuilder sbD = D2.e.d("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        sbD.append(fragment.toString());
        sbD.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbD.toString());
    }

    @Override // androidx.fragment.app.E
    public final E p(Fragment fragment) {
        w wVar = fragment.f3406A;
        if (wVar == null || wVar == this.f3495q) {
            d(new E.a(5, fragment));
            return this;
        }
        StringBuilder sbD = D2.e.d("Cannot show Fragment attached to a different FragmentManager. Fragment ");
        sbD.append(fragment.toString());
        sbD.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(sbD.toString());
    }

    final void q(int i2) {
        if (this.g) {
            if (w.k0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f3383a.size();
            for (int i4 = 0; i4 < size; i4++) {
                E.a aVar = this.f3383a.get(i4);
                Fragment fragment = aVar.f3397b;
                if (fragment != null) {
                    fragment.f3445z += i2;
                    if (w.k0(2)) {
                        StringBuilder sbD = D2.e.d("Bump nesting of ");
                        sbD.append(aVar.f3397b);
                        sbD.append(" to ");
                        sbD.append(aVar.f3397b.f3445z);
                        Log.v("FragmentManager", sbD.toString());
                    }
                }
            }
        }
    }

    final int r(boolean z4) {
        if (this.f3496r) {
            throw new IllegalStateException("commit already called");
        }
        if (w.k0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new K());
            s("  ", printWriter, true);
            printWriter.close();
        }
        this.f3496r = true;
        if (this.g) {
            this.f3497s = this.f3495q.c();
        } else {
            this.f3497s = -1;
        }
        this.f3495q.K(this, z4);
        return this.f3497s;
    }

    public final void s(String str, PrintWriter printWriter, boolean z4) {
        String string;
        if (z4) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3389i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3497s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3496r);
            if (this.f3387f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3387f));
            }
            if (this.f3384b != 0 || this.f3385c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3384b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3385c));
            }
            if (this.d != 0 || this.f3386e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3386e));
            }
            if (this.f3390j != 0 || this.f3391k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3390j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3391k);
            }
            if (this.f3392l != 0 || this.f3393m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3392l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3393m);
            }
        }
        if (this.f3383a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f3383a.size();
        for (int i2 = 0; i2 < size; i2++) {
            E.a aVar = this.f3383a.get(i2);
            switch (aVar.f3396a) {
                case 0:
                    string = "NULL";
                    break;
                case 1:
                    string = "ADD";
                    break;
                case 2:
                    string = "REPLACE";
                    break;
                case 3:
                    string = "REMOVE";
                    break;
                case 4:
                    string = "HIDE";
                    break;
                case 5:
                    string = "SHOW";
                    break;
                case 6:
                    string = "DETACH";
                    break;
                case 7:
                    string = "ATTACH";
                    break;
                case 8:
                    string = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    string = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    string = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    StringBuilder sbD = D2.e.d("cmd=");
                    sbD.append(aVar.f3396a);
                    string = sbD.toString();
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(string);
            printWriter.print(" ");
            printWriter.println(aVar.f3397b);
            if (z4) {
                if (aVar.f3398c != 0 || aVar.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3398c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.d));
                }
                if (aVar.f3399e != 0 || aVar.f3400f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3399e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f3400f));
                }
            }
        }
    }

    final void t() {
        int size = this.f3383a.size();
        for (int i2 = 0; i2 < size; i2++) {
            E.a aVar = this.f3383a.get(i2);
            Fragment fragment = aVar.f3397b;
            if (fragment != null) {
                fragment.W0(false);
                fragment.V0(this.f3387f);
                fragment.Y0(this.f3394n, this.f3395o);
            }
            switch (aVar.f3396a) {
                case 1:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.A0(fragment, false);
                    this.f3495q.b(fragment);
                    break;
                case 2:
                default:
                    StringBuilder sbD = D2.e.d("Unknown cmd: ");
                    sbD.append(aVar.f3396a);
                    throw new IllegalArgumentException(sbD.toString());
                case 3:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.v0(fragment);
                    break;
                case 4:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.h0(fragment);
                    break;
                case 5:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.A0(fragment, false);
                    this.f3495q.E0(fragment);
                    break;
                case 6:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.j(fragment);
                    break;
                case 7:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.A0(fragment, false);
                    this.f3495q.e(fragment);
                    break;
                case 8:
                    this.f3495q.C0(fragment);
                    break;
                case 9:
                    this.f3495q.C0(null);
                    break;
                case 10:
                    this.f3495q.B0(fragment, aVar.f3401h);
                    break;
            }
            if (!this.p) {
                int i4 = aVar.f3396a;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3497s >= 0) {
            sb.append(" #");
            sb.append(this.f3497s);
        }
        if (this.f3389i != null) {
            sb.append(" ");
            sb.append(this.f3389i);
        }
        sb.append("}");
        return sb.toString();
    }

    final void u() {
        for (int size = this.f3383a.size() - 1; size >= 0; size--) {
            E.a aVar = this.f3383a.get(size);
            Fragment fragment = aVar.f3397b;
            if (fragment != null) {
                fragment.W0(true);
                int i2 = this.f3387f;
                fragment.V0(i2 != 4097 ? i2 != 4099 ? i2 != 8194 ? 0 : 4097 : 4099 : 8194);
                fragment.Y0(this.f3395o, this.f3394n);
            }
            switch (aVar.f3396a) {
                case 1:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.A0(fragment, true);
                    this.f3495q.v0(fragment);
                    break;
                case 2:
                default:
                    StringBuilder sbD = D2.e.d("Unknown cmd: ");
                    sbD.append(aVar.f3396a);
                    throw new IllegalArgumentException(sbD.toString());
                case 3:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.b(fragment);
                    break;
                case 4:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.E0(fragment);
                    break;
                case 5:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.A0(fragment, true);
                    this.f3495q.h0(fragment);
                    break;
                case 6:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.e(fragment);
                    break;
                case 7:
                    fragment.Q0(aVar.f3398c, aVar.d, aVar.f3399e, aVar.f3400f);
                    this.f3495q.A0(fragment, true);
                    this.f3495q.j(fragment);
                    break;
                case 8:
                    this.f3495q.C0(null);
                    break;
                case 9:
                    this.f3495q.C0(fragment);
                    break;
                case 10:
                    this.f3495q.B0(fragment, aVar.g);
                    break;
            }
        }
    }
}
