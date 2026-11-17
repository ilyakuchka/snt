package Q0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import com.android.mmt.R;

/* loaded from: classes.dex */
public final class o extends S0.a<L0.a> {

    /* renamed from: n, reason: collision with root package name */
    public static k.d<L0.a> f1126n = new a();

    final class a extends k.d<L0.a> {
        a() {
        }

        @Override // androidx.recyclerview.widget.k.d
        public final boolean a(L0.a aVar, L0.a aVar2) {
            return aVar.equals(aVar2);
        }

        @Override // androidx.recyclerview.widget.k.d
        public final boolean b(L0.a aVar, L0.a aVar2) {
            return aVar.f() == aVar2.f();
        }
    }

    public o() {
        super(f1126n, null);
    }

    @Override // S0.a
    public final long P(int i2) {
        return G(i2).f();
    }

    @Override // S0.a, Q0.ViewOnClickListenerC0169b.a
    public final void g(int i2, boolean z4) {
        super.g(i2, z4);
    }

    @Override // N.j, androidx.recyclerview.widget.RecyclerView.e
    public final int j() {
        return super.j();
    }

    @Override // S0.a, androidx.recyclerview.widget.RecyclerView.e
    public final long k(int i2) {
        return G(i2).f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final int l(int i2) {
        L0.a aVarG = G(i2);
        return (aVarG.f() == -100 || aVarG.f() == -103 || aVarG.f() == -104) ? 1 : 0;
    }

    @Override // S0.a, androidx.recyclerview.widget.RecyclerView.e
    public final void x(RecyclerView.x xVar, int i2) {
        if (xVar instanceof w) {
            ((w) xVar).H(i2, G(i2), this.f1342f, U(i2), this.g);
        } else if (xVar instanceof v) {
            ((v) xVar).G(i2, G(i2), this.f1342f, U(i2), this.g);
        }
    }

    @Override // S0.a, androidx.recyclerview.widget.RecyclerView.e
    public final RecyclerView.x y(ViewGroup viewGroup, int i2) {
        return i2 != 1 ? new w(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.conversation_item, viewGroup, false), this.f1348m, this) : new v(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.conversation_entry, viewGroup, false), this.f1348m, this);
    }
}
