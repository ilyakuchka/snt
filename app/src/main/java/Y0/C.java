package Y0;

import Y0.h;
import android.os.SystemClock;
import android.util.Log;
import c1.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class C implements h, h.a {

    /* renamed from: i, reason: collision with root package name */
    private final i<?> f1899i;

    /* renamed from: j, reason: collision with root package name */
    private final h.a f1900j;

    /* renamed from: k, reason: collision with root package name */
    private int f1901k;

    /* renamed from: l, reason: collision with root package name */
    private e f1902l;

    /* renamed from: m, reason: collision with root package name */
    private Object f1903m;

    /* renamed from: n, reason: collision with root package name */
    private volatile n.a<?> f1904n;

    /* renamed from: o, reason: collision with root package name */
    private f f1905o;

    C(i<?> iVar, h.a aVar) {
        this.f1899i = iVar;
        this.f1900j = aVar;
    }

    @Override // Y0.h
    public final boolean a() {
        Object obj = this.f1903m;
        if (obj != null) {
            this.f1903m = null;
            int i2 = s1.f.f7857b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            try {
                V0.d<X> dVarP = this.f1899i.p(obj);
                g gVar = new g(dVarP, obj, this.f1899i.k());
                this.f1905o = new f(this.f1904n.f4419a, this.f1899i.o());
                this.f1899i.d().a(this.f1905o, gVar);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f1905o + ", data: " + obj + ", encoder: " + dVarP + ", duration: " + s1.f.a(jElapsedRealtimeNanos));
                }
                this.f1904n.f4421c.b();
                this.f1902l = new e(Collections.singletonList(this.f1904n.f4419a), this.f1899i, this);
            } catch (Throwable th) {
                this.f1904n.f4421c.b();
                throw th;
            }
        }
        e eVar = this.f1902l;
        if (eVar != null && eVar.a()) {
            return true;
        }
        this.f1902l = null;
        this.f1904n = null;
        boolean z4 = false;
        while (!z4) {
            if (!(this.f1901k < ((ArrayList) this.f1899i.g()).size())) {
                break;
            }
            List<n.a<?>> listG = this.f1899i.g();
            int i4 = this.f1901k;
            this.f1901k = i4 + 1;
            this.f1904n = (n.a) ((ArrayList) listG).get(i4);
            if (this.f1904n != null && (this.f1899i.e().c(this.f1904n.f4421c.d()) || this.f1899i.t(this.f1904n.f4421c.a()))) {
                this.f1904n.f4421c.c(this.f1899i.l(), new B(this, this.f1904n));
                z4 = true;
            }
        }
        return z4;
    }

    final boolean b(n.a<?> aVar) {
        n.a<?> aVar2 = this.f1904n;
        return aVar2 != null && aVar2 == aVar;
    }

    final void c(n.a<?> aVar, Object obj) {
        l lVarE = this.f1899i.e();
        if (obj != null && lVarE.c(aVar.f4421c.d())) {
            this.f1903m = obj;
            this.f1900j.d();
        } else {
            h.a aVar2 = this.f1900j;
            V0.f fVar = aVar.f4419a;
            W0.d<?> dVar = aVar.f4421c;
            aVar2.g(fVar, obj, dVar, dVar.d(), this.f1905o);
        }
    }

    @Override // Y0.h
    public final void cancel() {
        n.a<?> aVar = this.f1904n;
        if (aVar != null) {
            aVar.f4421c.cancel();
        }
    }

    @Override // Y0.h.a
    public final void d() {
        throw new UnsupportedOperationException();
    }

    @Override // Y0.h.a
    public final void e(V0.f fVar, Exception exc, W0.d<?> dVar, V0.a aVar) {
        this.f1900j.e(fVar, exc, dVar, this.f1904n.f4421c.d());
    }

    final void f(n.a<?> aVar, Exception exc) {
        h.a aVar2 = this.f1900j;
        f fVar = this.f1905o;
        W0.d<?> dVar = aVar.f4421c;
        aVar2.e(fVar, exc, dVar, dVar.d());
    }

    @Override // Y0.h.a
    public final void g(V0.f fVar, Object obj, W0.d<?> dVar, V0.a aVar, V0.f fVar2) {
        this.f1900j.g(fVar, obj, dVar, this.f1904n.f4421c.d(), fVar);
    }
}
