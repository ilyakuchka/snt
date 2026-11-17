package com.android.mmt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.mmt.ui.N0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class O0 extends RecyclerView {

    /* renamed from: G0, reason: collision with root package name */
    private N0 f5200G0;

    /* renamed from: H0, reason: collision with root package name */
    private RecyclerView.e f5201H0;

    /* renamed from: I0, reason: collision with root package name */
    private d f5202I0;

    /* renamed from: J0, reason: collision with root package name */
    private e f5203J0;

    /* renamed from: K0, reason: collision with root package name */
    private ArrayList<View> f5204K0;

    /* renamed from: L0, reason: collision with root package name */
    private ArrayList<View> f5205L0;

    /* renamed from: M0, reason: collision with root package name */
    private RecyclerView.g f5206M0;

    final class a extends RecyclerView.g {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void g() {
            if (O0.this.f5201H0 == null || O0.this.f5200G0 == O0.this.f5201H0) {
                return;
            }
            O0.this.f5200G0.n();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void h(int i2, int i4) {
            if (O0.this.f5201H0 == null || O0.this.f5200G0 == O0.this.f5201H0) {
                return;
            }
            O0.this.f5200G0.o(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void i(int i2, int i4, Object obj) {
            if (O0.this.f5201H0 == null || O0.this.f5200G0 == O0.this.f5201H0) {
                return;
            }
            O0.this.f5200G0.p(i2, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void j(int i2, int i4) {
            if (O0.this.f5201H0 == null || O0.this.f5200G0 == O0.this.f5201H0) {
                return;
            }
            O0.this.f5200G0.q(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void k(int i2, int i4) {
            if (O0.this.f5201H0 == null || O0.this.f5200G0 == O0.this.f5201H0) {
                return;
            }
            O0.this.f5200G0.r(i2, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void l(int i2, int i4) {
            if (O0.this.f5201H0 == null || O0.this.f5200G0 == O0.this.f5201H0) {
                return;
            }
            O0.this.f5200G0.v(i2);
        }
    }

    final class b implements N0.d {
        b() {
        }
    }

    final class c implements N0.e {
        c() {
        }
    }

    public interface d {
        void a(RecyclerView recyclerView, View view, int i2);
    }

    public interface e {
        boolean a(View view, int i2);
    }

    public O0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5204K0 = new ArrayList<>();
        this.f5205L0 = new ArrayList<>();
        this.f5206M0 = new a();
    }

    public final void J0(View view) {
        if (this.f5205L0.contains(view)) {
            return;
        }
        this.f5205L0.add(view);
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            n02.I(view);
        }
    }

    public final void K0(View view) {
        if (this.f5204K0.contains(view)) {
            return;
        }
        this.f5204K0.add(view);
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            n02.J(view);
        }
    }

    public final int L0() {
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            return n02.j();
        }
        return 0;
    }

    public final int M0() {
        RecyclerView.l lVarP = P();
        if (lVarP instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) lVarP).b1();
        }
        return 0;
    }

    public final int N0() {
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            return n02.L();
        }
        return 0;
    }

    public final d O0() {
        return this.f5202I0;
    }

    public final RecyclerView.e P0() {
        N0 n02 = this.f5200G0;
        return n02 != null ? n02.K() : I();
    }

    public final int Q0() {
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            return n02.N();
        }
        return 0;
    }

    public final boolean R0(int i2) {
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            return n02.O(i2);
        }
        return false;
    }

    public final boolean S0(int i2) {
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            return n02.P(i2);
        }
        return false;
    }

    public final boolean T0(View view) {
        this.f5204K0.remove(view);
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            return n02.Q(view);
        }
        return false;
    }

    public final void U0(d dVar) {
        this.f5202I0 = dVar;
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            if (dVar != null) {
                n02.T(new b());
            } else {
                n02.T(null);
            }
        }
    }

    public final void V0(e eVar) {
        this.f5203J0 = eVar;
        N0 n02 = this.f5200G0;
        if (n02 != null) {
            if (eVar != null) {
                n02.U(new c());
            } else {
                n02.U(null);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void p0(RecyclerView.e eVar) {
        this.f5200G0 = new N0(eVar);
        RecyclerView.e eVar2 = this.f5201H0;
        if (eVar2 != null) {
            eVar2.F(this.f5206M0);
            this.f5201H0 = null;
        }
        this.f5201H0 = eVar;
        if (eVar instanceof N0) {
            this.f5200G0 = (N0) eVar;
        } else {
            this.f5200G0 = new N0(eVar);
        }
        this.f5201H0.D(this.f5206M0);
        U0(this.f5202I0);
        V0(this.f5203J0);
        this.f5200G0.R(this.f5205L0);
        this.f5200G0.S(this.f5204K0);
        super.p0(this.f5200G0);
    }
}
