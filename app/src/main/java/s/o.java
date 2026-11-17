package s;

import java.util.ArrayList;
import r.C0370c;

/* loaded from: classes.dex */
public class o extends e {

    /* renamed from: i0, reason: collision with root package name */
    protected ArrayList<e> f7838i0 = new ArrayList<>();

    @Override // s.e
    public void D() {
        this.f7838i0.clear();
        super.D();
    }

    @Override // s.e
    public final void F(C0370c c0370c) {
        super.F(c0370c);
        int size = this.f7838i0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f7838i0.get(i2).F(c0370c);
        }
    }

    @Override // s.e
    public final void X(int i2, int i4) {
        this.f7748O = i2;
        this.P = i4;
        int size = this.f7838i0.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f7838i0.get(i5).X(this.f7744I + this.f7748O, this.f7745J + this.P);
        }
    }

    @Override // s.e
    public final void l0() {
        super.l0();
        ArrayList<e> arrayList = this.f7838i0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.f7838i0.get(i2);
            eVar.X(l(), m());
            if (!(eVar instanceof f)) {
                eVar.l0();
            }
        }
    }

    public final void n0(e eVar) {
        this.f7838i0.add(eVar);
        e eVar2 = eVar.f7739D;
        if (eVar2 != null) {
            ((o) eVar2).f7838i0.remove(eVar);
            eVar.f7739D = null;
        }
        eVar.f7739D = this;
    }

    public void o0() {
        l0();
        ArrayList<e> arrayList = this.f7838i0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.f7838i0.get(i2);
            if (eVar instanceof o) {
                ((o) eVar).o0();
            }
        }
    }

    public final void p0(e eVar) {
        this.f7838i0.remove(eVar);
        eVar.f7739D = null;
    }

    public final void q0() {
        this.f7838i0.clear();
    }
}
