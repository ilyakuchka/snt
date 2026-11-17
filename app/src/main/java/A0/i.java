package A0;

import java.util.ArrayList;
import org.w3c.dom.DOMException;

/* loaded from: classes.dex */
public final class i extends f implements a4.i {
    a4.b g;

    final class a extends A0.a {
        a(a4.f fVar) {
            super(fVar);
        }

        @Override // A0.d
        final a4.d c() {
            return ((e) this.f0a.getOwnerDocument()).f1e;
        }

        @Override // A0.d, a4.d
        public final o f() {
            o oVarF = super.f();
            if (oVarF.a() <= 1) {
                return oVarF;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(oVarF.b(0));
            return new o(arrayList);
        }
    }

    i(e eVar, String str) {
        super(eVar, str.toUpperCase());
        this.g = new a(this);
    }

    @Override // a4.d
    public final o a() {
        return ((d) this.g).a();
    }

    @Override // a4.d
    public final o f() {
        return ((a) this.g).f();
    }

    @Override // a4.d
    public final float l() {
        return ((A0.a) this.g).l();
    }

    @Override // a4.d
    public final void p(float f4) throws DOMException {
        ((d) this.g).p(f4);
    }

    @Override // a4.d
    public final short x() {
        return ((d) this.g).x();
    }
}
