package s;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private int f7830a;

    /* renamed from: b, reason: collision with root package name */
    private int f7831b;

    /* renamed from: c, reason: collision with root package name */
    private int f7832c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<a> f7833e = new ArrayList<>();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private d f7834a;

        /* renamed from: b, reason: collision with root package name */
        private d f7835b;

        /* renamed from: c, reason: collision with root package name */
        private int f7836c;
        private int d;

        /* renamed from: e, reason: collision with root package name */
        private int f7837e;

        public a(d dVar) {
            this.f7834a = dVar;
            this.f7835b = dVar.d;
            this.f7836c = dVar.c();
            this.d = dVar.f();
            this.f7837e = dVar.b();
        }

        public final void a(e eVar) {
            eVar.g(this.f7834a.f7723c).a(this.f7835b, this.f7836c, -1, this.d, this.f7837e, false);
        }

        public final void b(e eVar) {
            d dVarG = eVar.g(this.f7834a.f7723c);
            this.f7834a = dVarG;
            if (dVarG != null) {
                this.f7835b = dVarG.d;
                this.f7836c = dVarG.c();
                this.d = this.f7834a.f();
                this.f7837e = this.f7834a.b();
                return;
            }
            this.f7835b = null;
            this.f7836c = 0;
            this.d = 2;
            this.f7837e = 0;
        }
    }

    public n(e eVar) {
        this.f7830a = eVar.f7744I;
        this.f7831b = eVar.f7745J;
        this.f7832c = eVar.v();
        this.d = eVar.n();
        ArrayList<d> arrayList = eVar.f7737B;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f7833e.add(new a(arrayList.get(i2)));
        }
    }

    public final void a(e eVar) {
        eVar.f7744I = this.f7830a;
        eVar.f7745J = this.f7831b;
        eVar.g0(this.f7832c);
        eVar.M(this.d);
        int size = this.f7833e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f7833e.get(i2).a(eVar);
        }
    }

    public final void b(e eVar) {
        this.f7830a = eVar.f7744I;
        this.f7831b = eVar.f7745J;
        this.f7832c = eVar.v();
        this.d = eVar.n();
        int size = this.f7833e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f7833e.get(i2).b(eVar);
        }
    }
}
