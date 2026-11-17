package R;

import R.g;
import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class l<T> extends LiveData<T> {

    /* renamed from: l, reason: collision with root package name */
    final i f1288l;

    /* renamed from: n, reason: collision with root package name */
    final Callable<T> f1290n;

    /* renamed from: o, reason: collision with root package name */
    private final f f1291o;
    final g.c p;

    /* renamed from: q, reason: collision with root package name */
    final AtomicBoolean f1292q = new AtomicBoolean(true);

    /* renamed from: r, reason: collision with root package name */
    final AtomicBoolean f1293r = new AtomicBoolean(false);

    /* renamed from: s, reason: collision with root package name */
    final AtomicBoolean f1294s = new AtomicBoolean(false);

    /* renamed from: t, reason: collision with root package name */
    final Runnable f1295t = new a();
    final Runnable u = new b();

    /* renamed from: m, reason: collision with root package name */
    final boolean f1289m = false;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z4;
            if (l.this.f1294s.compareAndSet(false, true)) {
                g gVarJ = l.this.f1288l.j();
                g.c cVar = l.this.p;
                Objects.requireNonNull(gVarJ);
                gVarJ.a(new g.e(gVarJ, cVar));
            }
            do {
                if (l.this.f1293r.compareAndSet(false, true)) {
                    T tCall = null;
                    z4 = false;
                    while (l.this.f1292q.compareAndSet(true, false)) {
                        try {
                            try {
                                tCall = l.this.f1290n.call();
                                z4 = true;
                            } catch (Exception e2) {
                                throw new RuntimeException("Exception while computing database live data.", e2);
                            }
                        } finally {
                            l.this.f1293r.set(false);
                        }
                    }
                    if (z4) {
                        l.this.k(tCall);
                    }
                } else {
                    z4 = false;
                }
                if (!z4) {
                    return;
                }
            } while (l.this.f1292q.get());
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean zF = l.this.f();
            if (l.this.f1292q.compareAndSet(false, true) && zF) {
                l lVar = l.this;
                (lVar.f1289m ? lVar.f1288l.n() : lVar.f1288l.l()).execute(l.this.f1295t);
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    l(i iVar, f fVar, Callable callable, String[] strArr) {
        this.f1288l = iVar;
        this.f1290n = callable;
        this.f1291o = fVar;
        this.p = new m(this, strArr);
    }

    @Override // androidx.lifecycle.LiveData
    protected final void i() {
        this.f1291o.f1234a.add(this);
        (this.f1289m ? this.f1288l.n() : this.f1288l.l()).execute(this.f1295t);
    }

    @Override // androidx.lifecycle.LiveData
    protected final void j() {
        this.f1291o.f1234a.remove(this);
    }
}
