package S0;

import N.i;
import Q0.ViewOnClickListenerC0169b;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class d<M> extends S0.a<M> {

    /* renamed from: n, reason: collision with root package name */
    protected S0.a f1353n;

    /* renamed from: o, reason: collision with root package name */
    protected d<M>.a f1354o;
    ArrayList<b> p;

    /* renamed from: q, reason: collision with root package name */
    ArrayList<b> f1355q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f1356r;

    /* JADX INFO: Access modifiers changed from: private */
    class a extends RecyclerView.g {

        /* renamed from: a, reason: collision with root package name */
        private RecyclerView.g f1357a;

        public a(RecyclerView.g gVar) {
            this.f1357a = gVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void g() {
            this.f1357a.g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void h(int i2, int i4) {
            this.f1357a.h(d.this.c0() + i2, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void i(int i2, int i4, Object obj) {
            this.f1357a.i(d.this.c0() + i2, i4, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void j(int i2, int i4) {
            this.f1357a.j(d.this.c0() + i2, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void k(int i2, int i4) {
            this.f1357a.k(d.this.c0() + i2, d.this.c0() + i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void l(int i2, int i4) {
            this.f1357a.l(d.this.c0() + i2, i4);
        }
    }

    public static class b implements Comparable<b> {

        /* renamed from: i, reason: collision with root package name */
        private int f1359i;

        /* renamed from: j, reason: collision with root package name */
        private View f1360j;

        public b(int i2, View view) {
            this.f1359i = i2;
            this.f1360j = view;
        }

        @Override // java.lang.Comparable
        public final int compareTo(b bVar) {
            int i2 = this.f1359i;
            int i4 = bVar.f1359i;
            if (i2 > i4) {
                return 1;
            }
            return i2 < i4 ? -1 : 0;
        }

        public final int d() {
            return this.f1359i;
        }

        public final View e() {
            return this.f1360j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f1359i == this.f1359i && bVar.f1360j == this.f1360j;
        }
    }

    public static class c extends RecyclerView.x {
        public c(View view) {
            super(view);
        }

        public final void B(View view) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeAllViews();
            }
            View view2 = this.f4055i;
            if (view2 instanceof ViewGroup) {
                ((ViewGroup) view2).removeAllViews();
                ((ViewGroup) this.f4055i).addView(view);
            }
        }
    }

    /* renamed from: S0.d$d, reason: collision with other inner class name */
    public static class C0035d {
        public static int a(int i2, int i4) {
            return (i2 & 1073741823) | (i4 & (-1073741824));
        }
    }

    public d(S0.a aVar) {
        super(aVar.f1341e, null);
        this.p = new ArrayList<>();
        this.f1355q = new ArrayList<>();
        this.f1356r = false;
        this.f1353n = aVar;
    }

    private void f0() {
        if (this.p.size() > 0) {
            Iterator<b> it = this.p.iterator();
            while (it.hasNext()) {
                ViewGroup.LayoutParams layoutParams = it.next().e().getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (this.f1356r || !this.f1353n.f1342f) ? -2 : 0;
                }
            }
        }
        if (this.f1355q.size() > 0) {
            Iterator<b> it2 = this.f1355q.iterator();
            while (it2.hasNext()) {
                ViewGroup.LayoutParams layoutParams2 = it2.next().e().getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = (this.f1356r || !this.f1353n.f1342f) ? -2 : 0;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final boolean A(RecyclerView.x xVar) {
        return this.f1353n.A(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void B(RecyclerView.x xVar) {
        this.f1353n.B(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void C(RecyclerView.x xVar) {
        this.f1353n.C(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void D(RecyclerView.g gVar) {
        if (this.f1354o == null) {
            this.f1354o = new a(gVar);
        }
        this.f1353n.D(this.f1354o);
        super.D(gVar);
    }

    @Override // S0.a, N.j
    public final M G(int i2) {
        return (M) this.f1353n.G(i2);
    }

    @Override // N.j
    public final void H(i<M> iVar) {
        this.f1353n.H(iVar);
    }

    @Override // N.j
    public final void I(i<M> iVar) {
        this.f1353n.I(iVar);
    }

    @Override // S0.a
    public final void J(int i2) {
        this.f1353n.J(i2);
    }

    @Override // S0.a
    public final void K() {
        this.f1353n.K();
    }

    @Override // S0.a
    public final void L(boolean z4) {
        this.f1353n.L(z4);
    }

    @Override // S0.a
    public final void M() {
        this.f1353n.M();
        f0();
    }

    @Override // S0.a
    public final void N() {
        this.f1353n.N();
        f0();
    }

    @Override // S0.a
    public final int O() {
        return this.f1353n.O();
    }

    @Override // S0.a
    public final long P(int i2) {
        return this.f1353n.P(i2);
    }

    @Override // S0.a
    public final Set<Long> Q() {
        return this.f1353n.Q();
    }

    @Override // S0.a
    public final boolean R() {
        return this.f1353n.R();
    }

    @Override // S0.a
    public final boolean S() {
        return this.f1353n.S();
    }

    @Override // S0.a
    public final boolean T() {
        return this.f1353n.T();
    }

    @Override // S0.a
    public final void V(int i2) {
        this.f1353n.V(i2);
    }

    @Override // S0.a
    public final void W(boolean z4) {
        this.f1353n.W(z4);
    }

    @Override // S0.a
    public final void X(ViewOnClickListenerC0169b.a aVar) {
        this.f1353n.X(aVar);
    }

    @Override // S0.a
    public final void Y(ViewOnClickListenerC0169b.InterfaceC0031b<M> interfaceC0031b) {
        this.f1353n.Y(interfaceC0031b);
    }

    public final void Z(int i2, View view) {
        if (view == null || i2 < 0) {
            return;
        }
        b bVar = new b(i2, view);
        if (this.p.contains(bVar)) {
            return;
        }
        this.p.add(bVar);
        Collections.sort(this.p);
        q(this.p.indexOf(bVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void a(RecyclerView.x xVar) {
        this.f1353n.a(xVar);
    }

    public final int a0() {
        return this.f1355q.size();
    }

    public final View b0(int i2) {
        if (i2 >= 0 && this.p.size() != 0) {
            Iterator<b> it = this.p.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.d() == i2) {
                    return next.e();
                }
            }
        }
        return null;
    }

    public final int c0() {
        return this.p.size();
    }

    public final boolean d0(int i2) {
        if (i2 < 0 || this.p.size() == 0) {
            return false;
        }
        Iterator<b> it = this.p.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.d() == i2) {
                v(this.p.indexOf(next));
                return this.p.remove(next);
            }
        }
        return false;
    }

    public final void e0() {
        this.f1356r = true;
    }

    @Override // S0.a, Q0.ViewOnClickListenerC0169b.a
    public final void g(int i2, boolean z4) {
        this.f1353n.g(i2, z4);
    }

    @Override // S0.a, androidx.recyclerview.widget.RecyclerView.e
    public final long k(int i2) {
        return this.f1353n.k(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void w(RecyclerView recyclerView) {
        this.f1353n.w(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void z(RecyclerView recyclerView) {
        this.f1353n.z(recyclerView);
    }
}
