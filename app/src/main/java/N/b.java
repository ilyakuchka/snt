package N;

import androidx.recyclerview.widget.k;

/* loaded from: classes.dex */
final class b implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ i f609i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ i f610j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ int f611k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ i f612l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ Runnable f613m = null;

    /* renamed from: n, reason: collision with root package name */
    final /* synthetic */ N.a f614n;

    final class a implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ k.c f615i;

        a(k.c cVar) {
            this.f615i = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar = b.this;
            N.a aVar = bVar.f614n;
            if (aVar.f606h == bVar.f611k) {
                aVar.d(bVar.f612l, bVar.f610j, this.f615i, bVar.f609i.f662n, bVar.f613m);
            }
        }
    }

    b(N.a aVar, i iVar, i iVar2, int i2, i iVar3) {
        this.f614n = aVar;
        this.f609i = iVar;
        this.f610j = iVar2;
        this.f611k = i2;
        this.f612l = iVar3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k<T> kVar = this.f609i.f661m;
        k<T> kVar2 = this.f610j.f661m;
        k.d dVarB = this.f614n.f602b.b();
        int i2 = kVar.i();
        this.f614n.f603c.execute(new a(androidx.recyclerview.widget.k.a(new l(kVar, i2, kVar2, dVarB, (kVar.size() - i2) - kVar.k(), (kVar2.size() - kVar2.i()) - kVar2.k()))));
    }
}
