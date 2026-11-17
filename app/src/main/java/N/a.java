package N;

import N.i;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import n.C0352a;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    final androidx.recyclerview.widget.b f601a;

    /* renamed from: b, reason: collision with root package name */
    final androidx.recyclerview.widget.c<T> f602b;

    /* renamed from: e, reason: collision with root package name */
    private boolean f604e;

    /* renamed from: f, reason: collision with root package name */
    private i<T> f605f;
    private i<T> g;

    /* renamed from: h, reason: collision with root package name */
    int f606h;

    /* renamed from: c, reason: collision with root package name */
    Executor f603c = C0352a.l();
    private final List<b<T>> d = new CopyOnWriteArrayList();

    /* renamed from: i, reason: collision with root package name */
    private i.e f607i = new C0022a();

    /* renamed from: N.a$a, reason: collision with other inner class name */
    final class C0022a extends i.e {
        C0022a() {
        }

        @Override // N.i.e
        public final void a(int i2, int i4) {
            a.this.f601a.d(i2, i4, null);
        }

        @Override // N.i.e
        public final void b(int i2, int i4) {
            a.this.f601a.b(i2, i4);
        }
    }

    public interface b<T> {
        void a(i iVar);
    }

    public a(RecyclerView.e eVar, k.d<T> dVar) {
        this.f601a = new androidx.recyclerview.widget.b(eVar);
        this.f602b = new c.a(dVar).a();
    }

    private void e(i<T> iVar, i<T> iVar2, Runnable runnable) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(iVar2);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void a(b<T> bVar) {
        this.d.add(bVar);
    }

    public final T b(int i2) {
        i<T> iVar = this.f605f;
        if (iVar != null) {
            iVar.t(i2);
            return this.f605f.get(i2);
        }
        i<T> iVar2 = this.g;
        if (iVar2 != null) {
            return iVar2.get(i2);
        }
        throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
    }

    public final int c() {
        i<T> iVar = this.f605f;
        if (iVar != null) {
            return iVar.size();
        }
        i<T> iVar2 = this.g;
        if (iVar2 == null) {
            return 0;
        }
        return iVar2.size();
    }

    final void d(i<T> iVar, i<T> iVar2, k.c cVar, int i2, Runnable runnable) {
        int iMax;
        i<T> iVar3 = this.g;
        if (iVar3 == null || this.f605f != null) {
            throw new IllegalStateException("must be in snapshot state to apply diff");
        }
        this.f605f = iVar;
        this.g = null;
        androidx.recyclerview.widget.b bVar = this.f601a;
        k<T> kVar = iVar3.f661m;
        k<T> kVar2 = iVar.f661m;
        int iK = kVar.k();
        int iK2 = kVar2.k();
        int i4 = kVar.i();
        int i5 = kVar2.i();
        if (iK == 0 && iK2 == 0 && i4 == 0 && i5 == 0) {
            cVar.b(bVar);
        } else {
            if (iK > iK2) {
                int i6 = iK - iK2;
                bVar.a(kVar.size() - i6, i6);
            } else if (iK < iK2) {
                bVar.b(kVar.size(), iK2 - iK);
            }
            if (i4 > i5) {
                bVar.a(0, i4 - i5);
            } else if (i4 < i5) {
                bVar.b(0, i5 - i4);
            }
            if (i5 != 0) {
                cVar.b(new m(i5, bVar));
            } else {
                cVar.b(bVar);
            }
        }
        iVar.h(iVar2, this.f607i);
        if (!this.f605f.isEmpty()) {
            k<T> kVar3 = iVar3.f661m;
            k<T> kVar4 = iVar2.f661m;
            int i7 = kVar3.i();
            int i8 = i2 - i7;
            int size = (kVar3.size() - i7) - kVar3.k();
            if (i8 < 0 || i8 >= size) {
                iMax = Math.max(0, Math.min(i2, kVar4.size() - 1));
                i<T> iVar4 = this.f605f;
                iVar4.t(Math.max(0, Math.min(iVar4.size() - 1, iMax)));
            } else {
                for (int i9 = 0; i9 < 30; i9++) {
                    int i10 = ((i9 / 2) * (i9 % 2 == 1 ? -1 : 1)) + i8;
                    if (i10 >= 0 && i10 < kVar3.u()) {
                        try {
                            int iA = cVar.a(i10);
                            if (iA != -1) {
                                iMax = iA + kVar4.o();
                                break;
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                }
                iMax = Math.max(0, Math.min(i2, kVar4.size() - 1));
                i<T> iVar42 = this.f605f;
                iVar42.t(Math.max(0, Math.min(iVar42.size() - 1, iMax)));
            }
        }
        e(iVar3, this.f605f, runnable);
    }

    public final void f(i<T> iVar) {
        if (iVar != null) {
            if (this.f605f == null && this.g == null) {
                this.f604e = iVar.q();
            } else if (iVar.q() != this.f604e) {
                throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
            }
        }
        int i2 = this.f606h + 1;
        this.f606h = i2;
        i<T> iVar2 = this.f605f;
        if (iVar == iVar2) {
            return;
        }
        i<T> iVar3 = this.g;
        i<T> iVar4 = iVar3 != null ? iVar3 : iVar2;
        if (iVar == null) {
            int size = iVar2 != null ? iVar2.size() : iVar3 == null ? 0 : iVar3.size();
            i<T> iVar5 = this.f605f;
            if (iVar5 != null) {
                iVar5.y(this.f607i);
                this.f605f = null;
            } else if (this.g != null) {
                this.g = null;
            }
            this.f601a.a(0, size);
            e(iVar4, null, null);
            return;
        }
        if (iVar2 == null && iVar3 == null) {
            this.f605f = iVar;
            iVar.h(null, this.f607i);
            this.f601a.b(0, iVar.size());
            e(null, iVar, null);
            return;
        }
        if (iVar2 != null) {
            iVar2.y(this.f607i);
            i<T> oVar = this.f605f;
            if (!oVar.s()) {
                oVar = new o(oVar);
            }
            this.g = oVar;
            this.f605f = null;
        }
        i<T> iVar6 = this.g;
        if (iVar6 == null || this.f605f != null) {
            throw new IllegalStateException("must be in snapshot state to diff");
        }
        this.f602b.a().execute(new N.b(this, iVar6, iVar.s() ? iVar : new o(iVar), i2, iVar));
    }
}
