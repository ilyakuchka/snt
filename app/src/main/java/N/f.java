package N;

import N.e;
import N.i;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class f extends androidx.lifecycle.c<i<Object>> {
    private i<Object> g;

    /* renamed from: h, reason: collision with root package name */
    private e<Object, Object> f640h;

    /* renamed from: i, reason: collision with root package name */
    private final e.b f641i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ Object f642j = null;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ e.a f643k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ i.f f644l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ Executor f645m;

    /* renamed from: n, reason: collision with root package name */
    final /* synthetic */ Executor f646n;

    /* renamed from: o, reason: collision with root package name */
    final /* synthetic */ i.c f647o;

    final class a implements e.b {
        a() {
        }

        @Override // N.e.b
        public final void a() {
            f.this.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f(Executor executor, e.a aVar, i.f fVar, Executor executor2, Executor executor3, i.c cVar) {
        super(executor);
        this.f643k = aVar;
        this.f644l = fVar;
        this.f645m = executor2;
        this.f646n = executor3;
        this.f647o = cVar;
        this.f641i = new a();
    }

    @Override // androidx.lifecycle.c
    protected final i<Object> a() {
        i<Object> iVarA;
        Object objP = this.f642j;
        i<Object> iVar = this.g;
        if (iVar != null) {
            objP = iVar.p();
        }
        do {
            e<Object, Object> eVar = this.f640h;
            if (eVar != null) {
                eVar.e(this.f641i);
            }
            e<Object, Object> eVarA = this.f643k.a();
            this.f640h = eVarA;
            eVarA.a(this.f641i);
            i.d dVar = new i.d(this.f640h, this.f644l);
            dVar.e(this.f645m);
            dVar.c(this.f646n);
            dVar.b(this.f647o);
            dVar.d(objP);
            iVarA = dVar.a();
            this.g = iVarA;
        } while (iVarA.r());
        return this.g;
    }
}
