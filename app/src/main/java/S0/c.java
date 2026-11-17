package S0;

import S0.d;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c<M> extends d<M> {

    /* renamed from: s, reason: collision with root package name */
    private c<M>.a f1349s;

    /* renamed from: t, reason: collision with root package name */
    private int f1350t;

    private class a extends RecyclerView.g {

        /* renamed from: a, reason: collision with root package name */
        private RecyclerView.g f1351a;

        public a(RecyclerView.g gVar) {
            this.f1351a = gVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void g() {
            this.f1351a.g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void h(int i2, int i4) {
            Objects.requireNonNull(c.this);
            this.f1351a.h(c.this.c0() + i2, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void i(int i2, int i4, Object obj) {
            Objects.requireNonNull(c.this);
            this.f1351a.i(c.this.c0() + i2, i4, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void j(int i2, int i4) {
            Objects.requireNonNull(c.this);
            this.f1351a.j(c.this.c0() + i2, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void k(int i2, int i4) {
            Objects.requireNonNull(c.this);
            this.f1351a.k(c.this.c0() + i2, c.this.c0() + i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void l(int i2, int i4) {
            Objects.requireNonNull(c.this);
            this.f1351a.l(c.this.c0() + i2, i4);
        }
    }

    public c(S0.a aVar, int i2) {
        super(aVar);
        this.f1350t = i2;
    }

    @Override // S0.d, androidx.recyclerview.widget.RecyclerView.e
    public final void D(RecyclerView.g gVar) {
        super.D(gVar);
        d<M>.a aVar = this.f1354o;
        if (aVar != null) {
            this.f1353n.F(aVar);
        }
        if (this.f1349s == null) {
            this.f1349s = new a(gVar);
        }
        this.f1353n.D(this.f1349s);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void F(RecyclerView.g gVar) {
        this.f1353n.F(gVar);
    }

    @Override // N.j, androidx.recyclerview.widget.RecyclerView.e
    public final int j() {
        return this.f1353n.j() + a0() + c0() + 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int l(int i2) {
        if (this.f1350t == 256) {
            int iC0 = c0();
            if (i2 < iC0) {
                return d.C0035d.a(i2, 1073741824);
            }
            int i4 = i2 - iC0;
            int iJ = this.f1353n.j() + 0;
            if (i4 < iJ) {
                return this.f1353n.l(i4);
            }
            int i5 = i4 - iJ;
            if (i5 < a0()) {
                return d.C0035d.a(i5, Integer.MIN_VALUE);
            }
            return 0;
        }
        int iC02 = c0();
        if (i2 < iC02) {
            return d.C0035d.a(i2, 1073741824);
        }
        int i6 = i2 - iC02;
        int iJ2 = this.f1353n.j();
        if (i6 < iJ2) {
            return this.f1353n.l(i6);
        }
        int i7 = i6 - iJ2;
        if (i7 < a0()) {
            return d.C0035d.a(i7, Integer.MIN_VALUE);
        }
        return 0;
    }

    @Override // S0.a, androidx.recyclerview.widget.RecyclerView.e
    public final void x(RecyclerView.x xVar, int i2) {
        if (this.f1350t == 256) {
            if (!(xVar instanceof d.c)) {
                this.f1353n.x(xVar, i2 - c0());
                return;
            }
            int iL = l(i2);
            int i4 = iL & (-1073741824);
            int i5 = iL & 1073741823;
            if (i4 == 1073741824) {
                ((d.c) xVar).B(this.p.get(i5).e());
                return;
            } else {
                if (i4 == Integer.MIN_VALUE) {
                    ((d.c) xVar).B(this.f1355q.get(i5).e());
                    return;
                }
                return;
            }
        }
        if (!(xVar instanceof d.c)) {
            this.f1353n.x(xVar, i2 - c0());
            return;
        }
        int iL2 = l(i2);
        int i6 = iL2 & (-1073741824);
        int i7 = iL2 & 1073741823;
        if (i6 == 1073741824) {
            ((d.c) xVar).B(this.p.get(i7).e());
        } else if (i6 == Integer.MIN_VALUE) {
            ((d.c) xVar).B(this.f1355q.get(i7).e());
        }
    }

    @Override // S0.a, androidx.recyclerview.widget.RecyclerView.e
    public final RecyclerView.x y(ViewGroup viewGroup, int i2) {
        if (i2 == -1073741824) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            return new d.c(frameLayout);
        }
        int i4 = (-1073741824) & i2;
        if (i4 != 1073741824 && i4 != Integer.MIN_VALUE) {
            return this.f1353n.y(viewGroup, i2);
        }
        FrameLayout frameLayout2 = new FrameLayout(viewGroup.getContext());
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new d.c(frameLayout2);
    }
}
