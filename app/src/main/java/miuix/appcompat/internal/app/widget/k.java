package miuix.appcompat.internal.app.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.a;
import androidx.fragment.app.E;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import b0.AbstractC0224a;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class k extends AbstractC0224a {

    /* renamed from: c, reason: collision with root package name */
    private Context f6992c;
    private w d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<a> f6993e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private E f6994f = null;
    private Fragment g = null;

    class a {

        /* renamed from: a, reason: collision with root package name */
        String f6995a;

        /* renamed from: b, reason: collision with root package name */
        Class<? extends Fragment> f6996b;
        Bundle d;

        /* renamed from: e, reason: collision with root package name */
        a.c f6998e;

        /* renamed from: c, reason: collision with root package name */
        Fragment f6997c = null;

        /* renamed from: f, reason: collision with root package name */
        boolean f6999f = false;

        a(String str, Class cls, Bundle bundle, a.c cVar) {
            this.f6995a = str;
            this.f6996b = cls;
            this.d = bundle;
            this.f6998e = cVar;
        }
    }

    public k(Context context, w wVar) {
        this.f6992c = context;
        this.d = wVar;
    }

    @Override // b0.AbstractC0224a
    public final void a(Object obj) {
        if (this.f6994f == null) {
            this.f6994f = this.d.f();
        }
        this.f6994f.i((Fragment) obj);
    }

    @Override // b0.AbstractC0224a
    public final void b() {
        E e2 = this.f6994f;
        if (e2 != null) {
            e2.h();
            this.f6994f = null;
            this.d.P();
        }
    }

    @Override // b0.AbstractC0224a
    public final int c() {
        return this.f6993e.size();
    }

    @Override // b0.AbstractC0224a
    public final int d(Object obj) {
        int size = this.f6993e.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj == this.f6993e.get(i2).f6997c) {
                return i2;
            }
        }
        return -2;
    }

    @Override // b0.AbstractC0224a
    public final Object e(ViewGroup viewGroup, int i2) {
        if (this.f6994f == null) {
            this.f6994f = this.d.f();
        }
        Fragment fragmentK = k(i2, true, false);
        if (fragmentK.E() != null) {
            this.f6994f.f(fragmentK);
        } else {
            this.f6994f.b(viewGroup.getId(), fragmentK, this.f6993e.get(i2).f6995a);
        }
        if (fragmentK != this.g) {
            fragmentK.U0(false);
            fragmentK.a1(false);
        }
        return fragmentK;
    }

    @Override // b0.AbstractC0224a
    public final boolean f(View view, Object obj) {
        return ((Fragment) obj).T() == view;
    }

    @Override // b0.AbstractC0224a
    public final void h(Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.g;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.U0(false);
                this.g.a1(false);
            }
            if (fragment != null) {
                fragment.U0(true);
                fragment.a1(true);
            }
            this.g = fragment;
        }
    }

    final int j(String str, Class cls, Bundle bundle, a.c cVar) {
        if (n()) {
            this.f6993e.add(0, new a(str, cls, bundle, cVar));
        } else {
            this.f6993e.add(new a(str, cls, bundle, cVar));
        }
        g();
        return this.f6993e.size() - 1;
    }

    final Fragment k(int i2, boolean z4, boolean z5) {
        Class<? extends Fragment> cls;
        if (this.f6993e.isEmpty()) {
            return null;
        }
        ArrayList<a> arrayList = this.f6993e;
        if (z5) {
            i2 = p(i2);
        }
        a aVar = arrayList.get(i2);
        if (aVar.f6997c == null) {
            Fragment fragmentT = this.d.T(aVar.f6995a);
            aVar.f6997c = fragmentT;
            if (fragmentT == null && z4 && (cls = aVar.f6996b) != null) {
                aVar.f6997c = Fragment.V(this.f6992c, cls.getName(), aVar.d);
                aVar.f6996b = null;
                aVar.d = null;
            }
        }
        return aVar.f6997c;
    }

    final a.c l(int i2) {
        return this.f6993e.get(i2).f6998e;
    }

    public final boolean m(int i2) {
        if (i2 < 0 || i2 >= this.f6993e.size()) {
            return false;
        }
        return this.f6993e.get(i2).f6999f;
    }

    final boolean n() {
        return this.f6992c.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    final void o() {
        E eF = this.d.f();
        int size = this.f6993e.size();
        for (int i2 = 0; i2 < size; i2++) {
            eF.n(k(i2, false, true));
        }
        eF.h();
        this.d.P();
        this.f6993e.clear();
        this.g = null;
        g();
    }

    final int p(int i2) {
        if (!n()) {
            return i2;
        }
        int size = this.f6993e.size() - 1;
        if (size > i2) {
            return size - i2;
        }
        return 0;
    }
}
