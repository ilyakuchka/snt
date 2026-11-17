package androidx.lifecycle;

import androidx.lifecycle.g;
import java.util.Iterator;
import java.util.Map;
import n.C0352a;
import o.C0358b;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k, reason: collision with root package name */
    static final Object f3649k = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f3650a;

    /* renamed from: b, reason: collision with root package name */
    private C0358b<p<? super T>, LiveData<T>.c> f3651b;

    /* renamed from: c, reason: collision with root package name */
    int f3652c;
    private boolean d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f3653e;

    /* renamed from: f, reason: collision with root package name */
    volatile Object f3654f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3655h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3656i;

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f3657j;

    class LifecycleBoundObserver extends LiveData<T>.c implements i {

        /* renamed from: e, reason: collision with root package name */
        final k f3658e;

        LifecycleBoundObserver(k kVar, p<? super T> pVar) {
            super(pVar);
            this.f3658e = kVar;
        }

        @Override // androidx.lifecycle.i
        public final void g(k kVar, g.b bVar) {
            g.c cVarB = this.f3658e.a().b();
            if (cVarB == g.c.DESTROYED) {
                LiveData.this.l(this.f3661a);
                return;
            }
            g.c cVar = null;
            while (cVar != cVarB) {
                h(this.f3658e.a().b().d(g.c.STARTED));
                cVar = cVarB;
                cVarB = this.f3658e.a().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        final void i() {
            this.f3658e.a().c(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        final boolean j(k kVar) {
            return this.f3658e == kVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        final boolean k() {
            return this.f3658e.a().b().d(g.c.STARTED);
        }
    }

    final class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            Object obj;
            synchronized (LiveData.this.f3650a) {
                obj = LiveData.this.f3654f;
                LiveData.this.f3654f = LiveData.f3649k;
            }
            LiveData.this.n(obj);
        }
    }

    private class b extends LiveData<T>.c {
        b(LiveData liveData, p<? super T> pVar) {
            super(pVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        final boolean k() {
            return true;
        }
    }

    private abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final p<? super T> f3661a;

        /* renamed from: b, reason: collision with root package name */
        boolean f3662b;

        /* renamed from: c, reason: collision with root package name */
        int f3663c = -1;

        c(p<? super T> pVar) {
            this.f3661a = pVar;
        }

        final void h(boolean z4) {
            if (z4 == this.f3662b) {
                return;
            }
            this.f3662b = z4;
            LiveData.this.b(z4 ? 1 : -1);
            if (this.f3662b) {
                LiveData.this.d(this);
            }
        }

        void i() {
        }

        boolean j(k kVar) {
            return false;
        }

        abstract boolean k();
    }

    public LiveData(T t2) {
        this.f3650a = new Object();
        this.f3651b = new C0358b<>();
        this.f3652c = 0;
        this.f3654f = f3649k;
        this.f3657j = new a();
        this.f3653e = t2;
        this.g = 0;
    }

    static void a(String str) {
        if (!C0352a.k().m()) {
            throw new IllegalStateException(C2.c.a("Cannot invoke ", str, " on a background thread"));
        }
    }

    private void c(LiveData<T>.c cVar) {
        if (cVar.f3662b) {
            if (!cVar.k()) {
                cVar.h(false);
                return;
            }
            int i2 = cVar.f3663c;
            int i4 = this.g;
            if (i2 >= i4) {
                return;
            }
            cVar.f3663c = i4;
            cVar.f3661a.a((Object) this.f3653e);
        }
    }

    final void b(int i2) {
        int i4 = this.f3652c;
        this.f3652c = i2 + i4;
        if (this.d) {
            return;
        }
        this.d = true;
        while (true) {
            try {
                int i5 = this.f3652c;
                if (i4 == i5) {
                    return;
                }
                boolean z4 = i4 == 0 && i5 > 0;
                boolean z5 = i4 > 0 && i5 == 0;
                if (z4) {
                    i();
                } else if (z5) {
                    j();
                }
                i4 = i5;
            } finally {
                this.d = false;
            }
        }
    }

    final void d(LiveData<T>.c cVar) {
        if (this.f3655h) {
            this.f3656i = true;
            return;
        }
        this.f3655h = true;
        do {
            this.f3656i = false;
            if (cVar != null) {
                c(cVar);
                cVar = null;
            } else {
                C0358b<p<? super T>, LiveData<T>.c>.d dVarI = this.f3651b.i();
                while (dVarI.hasNext()) {
                    c((c) dVarI.next().getValue());
                    if (this.f3656i) {
                        break;
                    }
                }
            }
        } while (this.f3656i);
        this.f3655h = false;
    }

    public final T e() {
        T t2 = (T) this.f3653e;
        if (t2 != f3649k) {
            return t2;
        }
        return null;
    }

    public final boolean f() {
        return this.f3652c > 0;
    }

    public final void g(k kVar, p<? super T> pVar) {
        a("observe");
        if (kVar.a().b() == g.c.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(kVar, pVar);
        LiveData<T>.c cVarN = this.f3651b.n(pVar, lifecycleBoundObserver);
        if (cVarN != null && !cVarN.j(kVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarN != null) {
            return;
        }
        kVar.a().a(lifecycleBoundObserver);
    }

    public final void h(p<? super T> pVar) {
        a("observeForever");
        b bVar = new b(this, pVar);
        LiveData<T>.c cVarN = this.f3651b.n(pVar, bVar);
        if (cVarN instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarN != null) {
            return;
        }
        bVar.h(true);
    }

    protected void i() {
    }

    protected void j() {
    }

    protected void k(T t2) {
        boolean z4;
        synchronized (this.f3650a) {
            z4 = this.f3654f == f3649k;
            this.f3654f = t2;
        }
        if (z4) {
            C0352a.k().n(this.f3657j);
        }
    }

    public void l(p<? super T> pVar) {
        a("removeObserver");
        LiveData<T>.c cVarO = this.f3651b.o(pVar);
        if (cVarO == null) {
            return;
        }
        cVarO.i();
        cVarO.h(false);
    }

    public final void m(k kVar) {
        a("removeObservers");
        Iterator<Map.Entry<p<? super T>, LiveData<T>.c>> it = this.f3651b.iterator();
        while (it.hasNext()) {
            Map.Entry<p<? super T>, LiveData<T>.c> next = it.next();
            if (next.getValue().j(kVar)) {
                l(next.getKey());
            }
        }
    }

    protected void n(T t2) {
        a("setValue");
        this.g++;
        this.f3653e = t2;
        d(null);
    }

    public LiveData() {
        this.f3650a = new Object();
        this.f3651b = new C0358b<>();
        this.f3652c = 0;
        Object obj = f3649k;
        this.f3654f = obj;
        this.f3657j = new a();
        this.f3653e = obj;
        this.g = -1;
    }
}
