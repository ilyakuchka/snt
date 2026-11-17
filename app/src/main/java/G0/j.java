package G0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class j extends l {

    /* renamed from: j, reason: collision with root package name */
    private n f161j;

    /* renamed from: k, reason: collision with root package name */
    private n f162k;

    /* renamed from: l, reason: collision with root package name */
    private n f163l;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<n> f164m;

    /* renamed from: n, reason: collision with root package name */
    private F0.a f165n;

    public j() {
        this.f165n = F0.b.a().b();
        q();
        p();
        r();
    }

    private void p() {
        n nVar = this.f161j;
        if (nVar == null) {
            throw new IllegalStateException("Root-Layout uninitialized.");
        }
        this.f162k = new n("Image", 0, nVar.v(), this.f165n.b());
    }

    private void q() {
        this.f161j = new n(null, 0, this.f165n.d(), this.f165n.a());
    }

    private void r() {
        if (this.f161j == null) {
            throw new IllegalStateException("Root-Layout uninitialized.");
        }
        this.f163l = new n("Text", this.f165n.b(), this.f161j.v(), this.f165n.c());
    }

    @Override // G0.l
    protected final void i(h hVar) {
        n nVar = this.f161j;
        if (nVar != null) {
            nVar.h(hVar);
        }
        n nVar2 = this.f162k;
        if (nVar2 != null) {
            nVar2.h(hVar);
        }
        n nVar3 = this.f163l;
        if (nVar3 != null) {
            nVar3.h(hVar);
        }
    }

    @Override // G0.l
    protected final void l() {
        n nVar = this.f161j;
        if (nVar != null) {
            nVar.k();
        }
        n nVar2 = this.f162k;
        if (nVar2 != null) {
            nVar2.k();
        }
        n nVar3 = this.f163l;
        if (nVar3 != null) {
            nVar3.k();
        }
    }

    @Override // G0.l
    protected final void o(h hVar) {
        n nVar = this.f161j;
        if (nVar != null) {
            nVar.n(hVar);
        }
        n nVar2 = this.f162k;
        if (nVar2 != null) {
            nVar2.n(hVar);
        }
        n nVar3 = this.f163l;
        if (nVar3 != null) {
            nVar3.n(hVar);
        }
    }

    public final n s(String str) {
        if ("Image".equals(str)) {
            return this.f162k;
        }
        if ("Text".equals(str)) {
            return this.f163l;
        }
        Iterator<n> it = this.f164m.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.t().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final String t() {
        return this.f161j.p();
    }

    public final n u() {
        return this.f162k;
    }

    public final int v() {
        return this.f161j.r();
    }

    public final int w() {
        return this.f161j.v();
    }

    public final ArrayList<n> x() {
        ArrayList<n> arrayList = new ArrayList<>();
        n nVar = this.f162k;
        if (nVar != null) {
            arrayList.add(nVar);
        }
        n nVar2 = this.f163l;
        if (nVar2 != null) {
            arrayList.add(nVar2);
        }
        return arrayList;
    }

    public final n y() {
        return this.f163l;
    }

    public j(n nVar, ArrayList<n> arrayList) {
        this.f165n = F0.b.a().b();
        this.f161j = nVar;
        this.f164m = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            String strT = next.t();
            if (strT.equals("Image")) {
                this.f162k = next;
            } else if (strT.equals("Text")) {
                this.f163l = next;
            } else {
                this.f164m.add(next);
            }
        }
        if (this.f161j == null) {
            q();
        }
        if (this.f162k == null) {
            p();
        }
        if (this.f163l == null) {
            r();
        }
        Objects.requireNonNull(this.f162k);
        Objects.requireNonNull(this.f163l);
    }
}
