package o1;

import Y0.m;
import Y0.s;
import Y0.x;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import c1.k;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import q1.a;
import s1.j;

/* loaded from: classes.dex */
public final class g<R> implements b, p1.e, f {

    /* renamed from: D, reason: collision with root package name */
    private static final boolean f7543D = Log.isLoggable("Request", 2);

    /* renamed from: A, reason: collision with root package name */
    private int f7544A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f7545B;

    /* renamed from: C, reason: collision with root package name */
    private RuntimeException f7546C;

    /* renamed from: a, reason: collision with root package name */
    private final String f7547a;

    /* renamed from: b, reason: collision with root package name */
    private final t1.d f7548b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f7549c;
    private final d<R> d;

    /* renamed from: e, reason: collision with root package name */
    private final c f7550e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f7551f;
    private final com.bumptech.glide.e g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f7552h;

    /* renamed from: i, reason: collision with root package name */
    private final Class<R> f7553i;

    /* renamed from: j, reason: collision with root package name */
    private final a<?> f7554j;

    /* renamed from: k, reason: collision with root package name */
    private final int f7555k;

    /* renamed from: l, reason: collision with root package name */
    private final int f7556l;

    /* renamed from: m, reason: collision with root package name */
    private final com.bumptech.glide.f f7557m;

    /* renamed from: n, reason: collision with root package name */
    private final p1.f<R> f7558n;

    /* renamed from: o, reason: collision with root package name */
    private final List<d<R>> f7559o;
    private final q1.c<? super R> p;

    /* renamed from: q, reason: collision with root package name */
    private final Executor f7560q;

    /* renamed from: r, reason: collision with root package name */
    private x<R> f7561r;

    /* renamed from: s, reason: collision with root package name */
    private m.d f7562s;

    /* renamed from: t, reason: collision with root package name */
    private long f7563t;
    private volatile m u;

    /* renamed from: v, reason: collision with root package name */
    private int f7564v;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f7565w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f7566x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f7567y;

    /* renamed from: z, reason: collision with root package name */
    private int f7568z;

    private g(Context context, com.bumptech.glide.e eVar, Object obj, Object obj2, Class cls, a aVar, int i2, int i4, com.bumptech.glide.f fVar, p1.f fVar2, List list, m mVar, q1.c cVar, Executor executor) {
        this.f7547a = f7543D ? String.valueOf(hashCode()) : null;
        this.f7548b = t1.d.a();
        this.f7549c = obj;
        this.f7551f = context;
        this.g = eVar;
        this.f7552h = obj2;
        this.f7553i = cls;
        this.f7554j = aVar;
        this.f7555k = i2;
        this.f7556l = i4;
        this.f7557m = fVar;
        this.f7558n = fVar2;
        this.d = null;
        this.f7559o = list;
        this.f7550e = null;
        this.u = mVar;
        this.p = cVar;
        this.f7560q = executor;
        this.f7564v = 1;
        if (this.f7546C == null && eVar.i()) {
            this.f7546C = new RuntimeException("Glide request origin trace");
        }
    }

    private void f() {
        if (this.f7545B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private Drawable g() {
        if (this.f7567y == null) {
            Drawable drawableN = this.f7554j.n();
            this.f7567y = drawableN;
            if (drawableN == null && this.f7554j.o() > 0) {
                this.f7567y = l(this.f7554j.o());
            }
        }
        return this.f7567y;
    }

    private Drawable i() {
        if (this.f7566x == null) {
            Drawable drawableT = this.f7554j.t();
            this.f7566x = drawableT;
            if (drawableT == null && this.f7554j.u() > 0) {
                this.f7566x = l(this.f7554j.u());
            }
        }
        return this.f7566x;
    }

    private boolean k() {
        c cVar = this.f7550e;
        return cVar == null || !cVar.a().e();
    }

    private Drawable l(int i2) {
        return h1.a.a(this.g, i2, this.f7554j.z() != null ? this.f7554j.z() : this.f7551f.getTheme());
    }

    private void m(String str) {
        Log.v("Request", str + " this: " + this.f7547a);
    }

    public static g n(Context context, com.bumptech.glide.e eVar, Object obj, Object obj2, Class cls, a aVar, int i2, int i4, com.bumptech.glide.f fVar, p1.f fVar2, List list, m mVar, q1.c cVar, Executor executor) {
        return new g(context, eVar, obj, obj2, cls, aVar, i2, i4, fVar, fVar2, list, mVar, cVar, executor);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p(s sVar, int i2) {
        boolean zA;
        this.f7548b.c();
        synchronized (this.f7549c) {
            Objects.requireNonNull(sVar);
            int iG = this.g.g();
            if (iG <= i2) {
                Log.w("Glide", "Load failed for " + this.f7552h + " with size [" + this.f7568z + "x" + this.f7544A + "]", sVar);
                if (iG <= 4) {
                    sVar.e();
                }
            }
            this.f7562s = null;
            this.f7564v = 5;
            boolean z4 = true;
            this.f7545B = true;
            try {
                List<d<R>> list = this.f7559o;
                if (list != null) {
                    zA = false;
                    for (d<R> dVar : list) {
                        k();
                        zA |= dVar.a();
                    }
                } else {
                    zA = false;
                }
                d<R> dVar2 = this.d;
                if (dVar2 != null) {
                    k();
                    if (!dVar2.a()) {
                        z4 = false;
                    }
                    if (!(z4 | zA)) {
                        s();
                    }
                    this.f7545B = false;
                    c cVar = this.f7550e;
                    if (cVar != null) {
                        cVar.d(this);
                    }
                }
            } catch (Throwable th) {
                this.f7545B = false;
                throw th;
            }
        }
    }

    private void r(x<R> xVar, R r2, V0.a aVar) {
        boolean zB;
        k();
        this.f7564v = 4;
        this.f7561r = xVar;
        if (this.g.g() <= 3) {
            StringBuilder sbD = D2.e.d("Finished loading ");
            sbD.append(r2.getClass().getSimpleName());
            sbD.append(" from ");
            sbD.append(aVar);
            sbD.append(" for ");
            sbD.append(this.f7552h);
            sbD.append(" with size [");
            sbD.append(this.f7568z);
            sbD.append("x");
            sbD.append(this.f7544A);
            sbD.append("] in ");
            sbD.append(s1.f.a(this.f7563t));
            sbD.append(" ms");
            Log.d("Glide", sbD.toString());
        }
        boolean z4 = true;
        this.f7545B = true;
        try {
            List<d<R>> list = this.f7559o;
            if (list != null) {
                Iterator<d<R>> it = list.iterator();
                zB = false;
                while (it.hasNext()) {
                    zB |= it.next().b();
                }
            } else {
                zB = false;
            }
            d<R> dVar = this.d;
            if (dVar == null || !dVar.b()) {
                z4 = false;
            }
            if (!(z4 | zB)) {
                this.f7558n.k(r2, ((a.C0135a) this.p).a());
            }
            this.f7545B = false;
            c cVar = this.f7550e;
            if (cVar != null) {
                cVar.g(this);
            }
        } catch (Throwable th) {
            this.f7545B = false;
            throw th;
        }
    }

    private void s() {
        c cVar = this.f7550e;
        if (cVar == null || cVar.f(this)) {
            Drawable drawableG = this.f7552h == null ? g() : null;
            if (drawableG == null) {
                if (this.f7565w == null) {
                    Drawable drawableM = this.f7554j.m();
                    this.f7565w = drawableM;
                    if (drawableM == null && this.f7554j.l() > 0) {
                        this.f7565w = l(this.f7554j.l());
                    }
                }
                drawableG = this.f7565w;
            }
            if (drawableG == null) {
                drawableG = i();
            }
            this.f7558n.h(drawableG);
        }
    }

    @Override // o1.b
    public final void a() {
        synchronized (this.f7549c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // o1.b
    public final void b() {
        synchronized (this.f7549c) {
            f();
            this.f7548b.c();
            int i2 = s1.f.f7857b;
            this.f7563t = SystemClock.elapsedRealtimeNanos();
            if (this.f7552h == null) {
                if (j.i(this.f7555k, this.f7556l)) {
                    this.f7568z = this.f7555k;
                    this.f7544A = this.f7556l;
                }
                p(new s("Received null model"), g() == null ? 5 : 3);
                return;
            }
            int i4 = this.f7564v;
            if (i4 == 2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (i4 == 4) {
                q(this.f7561r, V0.a.f1751m);
                return;
            }
            this.f7564v = 3;
            if (j.i(this.f7555k, this.f7556l)) {
                e(this.f7555k, this.f7556l);
            } else {
                this.f7558n.f(this);
            }
            int i5 = this.f7564v;
            if (i5 == 2 || i5 == 3) {
                c cVar = this.f7550e;
                if (cVar == null || cVar.f(this)) {
                    this.f7558n.c(i());
                }
            }
            if (f7543D) {
                m("finished run method in " + s1.f.a(this.f7563t));
            }
        }
    }

    @Override // o1.b
    public final boolean c() {
        boolean z4;
        synchronized (this.f7549c) {
            z4 = this.f7564v == 4;
        }
        return z4;
    }

    @Override // o1.b
    public final void clear() {
        synchronized (this.f7549c) {
            f();
            this.f7548b.c();
            if (this.f7564v == 6) {
                return;
            }
            f();
            this.f7548b.c();
            this.f7558n.g(this);
            m.d dVar = this.f7562s;
            x<R> xVar = null;
            if (dVar != null) {
                dVar.a();
                this.f7562s = null;
            }
            x<R> xVar2 = this.f7561r;
            if (xVar2 != null) {
                this.f7561r = null;
                xVar = xVar2;
            }
            c cVar = this.f7550e;
            if (cVar == null || cVar.c(this)) {
                this.f7558n.j(i());
            }
            this.f7564v = 6;
            if (xVar != null) {
                this.u.h(xVar);
            }
        }
    }

    @Override // o1.b
    public final boolean d() {
        boolean z4;
        synchronized (this.f7549c) {
            z4 = this.f7564v == 6;
        }
        return z4;
    }

    @Override // p1.e
    public final void e(int i2, int i4) throws Throwable {
        Object obj;
        int iRound = i2;
        this.f7548b.c();
        Object obj2 = this.f7549c;
        synchronized (obj2) {
            try {
                boolean z4 = f7543D;
                if (z4) {
                    m("Got onSizeReady in " + s1.f.a(this.f7563t));
                }
                if (this.f7564v == 3) {
                    this.f7564v = 2;
                    float fY = this.f7554j.y();
                    if (iRound != Integer.MIN_VALUE) {
                        iRound = Math.round(iRound * fY);
                    }
                    this.f7568z = iRound;
                    this.f7544A = i4 == Integer.MIN_VALUE ? i4 : Math.round(fY * i4);
                    if (z4) {
                        m("finished setup for calling load in " + s1.f.a(this.f7563t));
                    }
                    obj = obj2;
                    try {
                        this.f7562s = this.u.b(this.g, this.f7552h, this.f7554j.x(), this.f7568z, this.f7544A, this.f7554j.w(), this.f7553i, this.f7557m, this.f7554j.k(), this.f7554j.A(), this.f7554j.H(), this.f7554j.E(), this.f7554j.q(), this.f7554j.D(), this.f7554j.C(), this.f7554j.B(), this.f7554j.p(), this, this.f7560q);
                        if (this.f7564v != 2) {
                            this.f7562s = null;
                        }
                        if (z4) {
                            m("finished onSizeReady in " + s1.f.a(this.f7563t));
                        }
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    public final Object h() {
        this.f7548b.c();
        return this.f7549c;
    }

    @Override // o1.b
    public final boolean isRunning() {
        boolean z4;
        synchronized (this.f7549c) {
            int i2 = this.f7564v;
            z4 = i2 == 2 || i2 == 3;
        }
        return z4;
    }

    public final boolean j(b bVar) {
        int i2;
        int i4;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        com.bumptech.glide.f fVar;
        int size;
        int i5;
        int i6;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        com.bumptech.glide.f fVar2;
        int size2;
        if (!(bVar instanceof g)) {
            return false;
        }
        synchronized (this.f7549c) {
            i2 = this.f7555k;
            i4 = this.f7556l;
            obj = this.f7552h;
            cls = this.f7553i;
            aVar = this.f7554j;
            fVar = this.f7557m;
            List<d<R>> list = this.f7559o;
            size = list != null ? list.size() : 0;
        }
        g gVar = (g) bVar;
        synchronized (gVar.f7549c) {
            i5 = gVar.f7555k;
            i6 = gVar.f7556l;
            obj2 = gVar.f7552h;
            cls2 = gVar.f7553i;
            aVar2 = gVar.f7554j;
            fVar2 = gVar.f7557m;
            List<d<R>> list2 = gVar.f7559o;
            size2 = list2 != null ? list2.size() : 0;
        }
        if (i2 != i5 || i4 != i6) {
            return false;
        }
        int i7 = j.f7867c;
        return (obj == null ? obj2 == null : obj instanceof k ? ((k) obj).a() : obj.equals(obj2)) && cls.equals(cls2) && aVar.equals(aVar2) && fVar == fVar2 && size == size2;
    }

    public final void o(s sVar) {
        p(sVar, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(x<?> xVar, V0.a aVar) {
        Throwable th;
        this.f7548b.c();
        x<?> xVar2 = null;
        try {
            synchronized (this.f7549c) {
                try {
                    this.f7562s = null;
                    if (xVar == null) {
                        p(new s("Expected to receive a Resource<R> with an object of " + this.f7553i + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = xVar.get();
                    try {
                        if (obj == null || !this.f7553i.isAssignableFrom(obj.getClass())) {
                            this.f7561r = null;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Expected to receive an object of ");
                            sb.append(this.f7553i);
                            sb.append(" but instead got ");
                            sb.append(obj != null ? obj.getClass() : "");
                            sb.append("{");
                            sb.append(obj);
                            sb.append("} inside Resource{");
                            sb.append(xVar);
                            sb.append("}.");
                            sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            p(new s(sb.toString()), 5);
                        } else {
                            c cVar = this.f7550e;
                            if (cVar == null || cVar.b(this)) {
                                r(xVar, obj, aVar);
                                return;
                            } else {
                                this.f7561r = null;
                                this.f7564v = 4;
                            }
                        }
                        this.u.h(xVar);
                    } catch (Throwable th2) {
                        th = th2;
                        xVar2 = xVar;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            if (xVar2 != null) {
                this.u.h(xVar2);
            }
            throw th4;
        }
    }
}
